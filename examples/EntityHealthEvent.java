public class EntityHealth implements EntityHealthListener {
  
  // Creating the damage system
  private int entityHealth = 20;
  
  @Override
  public void onDamage(Entity entity, Event event) {
    entityHealth -= 2;
    entity.setHealth(entityHealth);
  }
  
  @Override
  public void onHeal(Entity entity, Event event) {
    entityHealth += 2; 
  }
}
