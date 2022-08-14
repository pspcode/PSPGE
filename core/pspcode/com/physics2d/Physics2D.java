package pspcode.com.physics2d;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;
import org.joml.Vector2f;
import org.pspcode.com.components.GameObject;
import org.pspcode.com.components.Transform;

import pspcode.com.physics2d.primitives.Box2DCollider;
import pspcode.com.physics2d.primitives.CircleCollider;
import pspcode.com.physics2d.primitives.PillboxCollider;
import pspcode.com.physics2d.primitives.Rigidbody2D;

import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;

public class Physics2D {
	
	private static Physics2D instance = null;
	
	private Vec2 gravity = new Vec2(0, -10.0f);
	private World world = new World(gravity);
	
	public static Physics2D get() {
		if (instance == null) instance = new Physics2D();
		return instance;
	}

	public void add(GameObject go) {
        Rigidbody2D rb = go.getComponent(Rigidbody2D.class);
        if (rb != null && rb.getRawBody() == null) {
            Transform transform = go.transform;

            BodyDef bodyDef = new BodyDef();
            bodyDef.angle = (float)Math.toRadians(transform.rotation);
            bodyDef.position.set(transform.position.x, transform.position.y);
            bodyDef.angularDamping = rb.getAngularDamping();
            bodyDef.linearDamping = rb.getLinearDamping();
            bodyDef.fixedRotation = rb.isFixedRotation();
            bodyDef.bullet = rb.isContinuousCollision();
            bodyDef.gravityScale = rb.gravityScale;
            bodyDef.angularVelocity = rb.angularVelocity;
            bodyDef.userData = rb.gameObject;

            switch (rb.getBodyType()) {
                case Kinematic: bodyDef.type = BodyType.KINEMATIC; break;
                case Static: bodyDef.type = BodyType.STATIC; break;
                case Dynamic: bodyDef.type = BodyType.DYNAMIC; break;
            }

            Body body = this.world.createBody(bodyDef);
            body.m_mass = rb.getMass();
            rb.setRawBody(body);

            CircleCollider circleCollider;
            Box2DCollider boxCollider;
            PillboxCollider pillboxCollider;

            if ((circleCollider = go.getComponent(CircleCollider.class)) != null) {
                addCircleCollider(rb, circleCollider);
            }

            if ((boxCollider = go.getComponent(Box2DCollider.class)) != null) {
                addBox2DCollider(rb, boxCollider);
            }

            if ((pillboxCollider = go.getComponent(PillboxCollider.class)) != null) {
                addPillboxCollider(rb, pillboxCollider);
            }
        }
    }
	
	public void addCircleCollider(Rigidbody2D rb, CircleCollider circleCollider) {
        Body body = rb.getRawBody();
        assert body != null : "Raw body must not be null";

        CircleShape shape = new CircleShape();
        shape.setRadius(circleCollider.getRadius());
        shape.m_p.set(circleCollider.getOffset().x, circleCollider.getOffset().y);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = rb.getFriction();
        fixtureDef.userData = circleCollider.gameObject;
        fixtureDef.isSensor = rb.isSensor();
        body.createFixture(fixtureDef);
    }
	
	public void addPillboxCollider(Rigidbody2D rb, PillboxCollider pb) {
        Body body = rb.getRawBody();
        assert body != null : "Raw body must not be null";

        addBox2DCollider(rb, pb.getBox());
        addCircleCollider(rb, pb.getBottomCircle());
    }

    public void addBox2DCollider(Rigidbody2D rb, Box2DCollider boxCollider) {
        Body body = rb.getRawBody();
        assert body != null : "Raw body must not be null";

        PolygonShape shape = new PolygonShape();
        Vector2f halfSize = new Vector2f(boxCollider.getHalfSize()).mul(0.5f);
        Vector2f offset = boxCollider.getOffset();
        Vector2f origin = new Vector2f(boxCollider.getOrigin());
        shape.setAsBox(halfSize.x, halfSize.y, new Vec2(offset.x, offset.y), 0);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = rb.getFriction();
        fixtureDef.userData = boxCollider.gameObject;
        fixtureDef.isSensor = rb.isSensor();
        body.createFixture(fixtureDef);
    }

    public void addCircleCollider2(Rigidbody2D rb, CircleCollider circleCollider) {
        Body body = rb.getRawBody();
        assert body != null : "Raw body must not be null";

        CircleShape shape = new CircleShape();
        shape.setRadius(circleCollider.getRadius());
        shape.m_p.set(circleCollider.getOffset().x, circleCollider.getOffset().y);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = rb.getFriction();
        fixtureDef.userData = circleCollider.gameObject;
        fixtureDef.isSensor = rb.isSensor();
        body.createFixture(fixtureDef);
    }
    
    public boolean isLocked() {
        return world.isLocked();
    }


    public void resetCircleCollider(Rigidbody2D rb, CircleCollider circleCollider) {
        Body body = rb.getRawBody();
        if (body == null) return;

        int size = fixtureListSize(body);
        for (int i = 0; i < size; i++) {
            body.destroyFixture(body.getFixtureList());
        }

        addCircleCollider(rb, circleCollider);
        body.resetMassData();
    }

    public void resetBox2DCollider(Rigidbody2D rb, Box2DCollider boxCollider) {
        Body body = rb.getRawBody();
        if (body == null) return;

        int size = fixtureListSize(body);
        for (int i = 0; i < size; i++) {
            body.destroyFixture(body.getFixtureList());
        }

        addBox2DCollider(rb, boxCollider);
        body.resetMassData();
    }

    private int fixtureListSize(Body body) {
        int size = 0;
        Fixture fixture = body.getFixtureList();
        while (fixture != null) {
            size++;
            fixture = fixture.m_next;
        }
        return size;
    }

	public void resetPillboxCollider(Rigidbody2D rb, PillboxCollider pb) {
        Body body = rb.getRawBody();
        if (body == null) return;

        int size = fixtureListSize(body);
        for (int i = 0; i < size; i++) {
            body.destroyFixture(body.getFixtureList());
        }

        addPillboxCollider(rb, pb);
        body.resetMassData();
    }

    public void addPillboxCollider2(Rigidbody2D rb, PillboxCollider pb) {
        Body body = rb.getRawBody();
        assert body != null : "Raw body must not be null";

        addBox2DCollider(rb, pb.getBox());
        addCircleCollider(rb, pb.getBottomCircle());
    }

    public void destroyGameObject(GameObject go) {
        Rigidbody2D rb = go.getComponent(Rigidbody2D.class);
        if (rb != null) {
            if (rb.getRawBody() != null) {
                world.destroyBody(rb.getRawBody());
                rb.setRawBody(null);
            }
        }
    }

	public void update(float dt) {
	
		
	}

}
