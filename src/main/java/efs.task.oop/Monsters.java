package efs.task.oop;

public class Monsters {
    public static final Monster andariel = new Monster(10, 70) {
        @Override
        public void takeHit(int damage) {
            super.takeHit(damage);
            Monsters.monstersHealth -= damage;
        }

    };

    public static final Monster blacksmith = new Monster(100, 25) {
        @Override
        public void takeHit(int damage) {
            super.takeHit(5 + damage);
            Monsters.monstersHealth -= (5 + damage);
        }
    };

    public static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();

}
