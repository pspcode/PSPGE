public class GameScene extends SceneInitializer {
  
  // creating gameobject to scene
  private GameObject player;
  
  public GameScene() {
    player = new GameObject("player");
    System.out.println("Game Scene [#1] is running."); 
  }
  
 
  
  @Override
  public void loadResources(Scene scene) {
    // loading the "player" obj to scene
    // creating the sprite renderer
    SpriteRenderer renderer = new SpriteRenderer();
    // creating the sprite to the "player" obj
    Sprite sprite = new Spite();
    // adding texture to sprite
    sprite.setTexture(AssetPool.getTexture("path/sprite.png"));
    // adding an size
    sprite.setWidth(16);
    sprite.setHeight(16);
    // setting the sprite to the sprite renderer
    renderer.setSprite(sprite);
    // adding sprite renderer component to the gameobject
    player.addComponent(renderer);
    
    // now you need to add the "player" object to the scene
    scene.addGameObjectToScene(player);
    
    /*
    * finish. the "player" obj was loaded in the game scene
    */
   
  }
  
  @Override
  public void init(Scene scene) {
    // nothing here.
  }
}
