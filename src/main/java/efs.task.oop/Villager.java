package efs.task.oop;

public class Villager implements Fighter {
    private String name;
    protected int health;
    private int age;

    public Villager(String name, int age) {
        this.name = name;
        this.health = 100;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        double damage = (100 - age * 0.5) / 10;
        return (int) damage;
    }

    @Override
    public void attack(Fighter victim) {
        int damage = getDamage();
        victim.takeHit(damage);
    }

    @Override
    public void takeHit(int damage) {
        health -= damage;
    }

    public boolean isAlive(){
        if(health > 0)
            return true;
        else
            return false;
    }
    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + name + " and I'm " + age + " years old");
    }
}
