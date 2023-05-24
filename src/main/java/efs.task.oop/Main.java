package efs.task.oop;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Villager kaysha = new Villager("Kaysha", 30);
        ExtraordinaryVillager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        Villager gheed = new Villager("Gheed", 50);
        ExtraordinaryVillager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);

        kaysha.sayHello();
        akara.sayHello();
        gheed.sayHello();
        deckardCain.sayHello();
        warriv.sayHello();
        flawia.sayHello();

        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;

        //nie da się wykonać metody klasy ExtraordinaryVillager ponieważ są traktowane jako obiekt
        //objectDeckardCain.sayHello();
        //objectAkara.sayHello();

        //można wywołać metody klasy ExtraordinaryVillager gdy dokonamy takiego rzutowania
        //((ExtraordinaryVillager)objectDeckardCain).sayHello();
        //((ExtraordinaryVillager)objectAkara).sayHello();

        ArrayList<Villager> villagers = new ArrayList<>();
        villagers.add(kaysha);
        villagers.add(gheed);
        villagers.add(warriv);
        villagers.add(flawia);

        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(Monsters.andariel);
        monsters.add(Monsters.blacksmith);

        while(Monsters.monstersHealth > 0) {
            if(villagers.isEmpty()) {
                System.out.println("Porażka!");
                break;
            }
            if(villagers.get(0).isAlive()==false) {
                villagers.remove(0);
                continue;
            }

            System.out.println("Potwory posiadaja jeszcze " + Monsters.monstersHealth + " punkty zycia");
            System.out.println("Aktualnie walczacy osadnik to " + villagers.get(0).getName());

            villagers.get(0).attack(monsters.get(0));

            if(monsters.get(0).getHealth() <= 0){
                monsters.remove(0);
            }

            if(monsters.isEmpty()){
                break;
            }else{
                monsters.get(0).attack(villagers.get(0));
            }

        }
        if(Monsters.monstersHealth <= 0)
            System.out.println("Obozowisko ocalone!");

        deckardCain = (ExtraordinaryVillager) objectDeckardCain;
        akara = (ExtraordinaryVillager) objectAkara;

        //można wywołać metody klasy ExtraordinaryVillager
        //deckardCain.sayHello();
        //akara.sayHello();
    }

}