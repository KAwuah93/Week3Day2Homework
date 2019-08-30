package com.example.week3day2homework;

import java.util.Random;

public class Animal {
     String name;
     String type;
     int age;
     int fans;
     String talent;
     int image;


    //Lists of Randomized Traits used to generate each animal.
    private String[] names = {"Zack", "Joe", "Tim", "Sasha", "Samantha", "Ricky","Jon","Christy","Gon","Steven","Joe",
                                "Fred", "Sam", "Jeb", "Kyle", "Paul", "Mack", "Richard"};
    private String[] types = {"Bat","lion","tiger","lemur","raccoon","otter","owl","snake","gecko","Dolphin","duck"};
    private String[] talents = {"Juggling", "Dancing", "Singing","Water Performance", "Cuddly nature","Ball Balancing", "Synchronized Dance","Cuteness", "Sarcasm"};

    Animal(){
        // Name 1 - 11 roll
        int Roll = new Random().nextInt(names.length-1);
        this.name = names[Roll];
        // Type 1 - 11 roll
        Roll = new Random().nextInt(types.length-1);
        this.type = types[Roll];
        // Talents 1 - 7
        Roll = new Random().nextInt(talents.length-1);
        this.talent = talents[Roll];
        //Randomize the Age and the Fan count
        this.age = new Random().nextInt(10-1+1)+1;
        this.fans = new Random().nextInt(3000-250)+200;
        //assign picture based on animal type (hard coded right now)
        switch(this.type){
            case "duck":
                this.image = R.drawable.duck;
                break;
            case "Dolphin":
                this.image = R.drawable.dolphin;
                break;
            case "gecko":
                this.image = R.drawable.gecko;
                break;
            case "snake":
                this.image = R.drawable.snake;
                break;
            case "owl":
                this.image = R.drawable.owl;
                break;
            case "otter":
                this.image = R.drawable.otter;
                break;
            case "raccoon":
                this.image = R.drawable.raccoon;
                break;
            case "Bat":
                this.image = R.drawable.bat;
                break;
            case "lion":
                this.image = R.drawable.lion;
                break;
            case "tiger":
                this.image = R.drawable.tiger;
                break;
            case "lemur":
                this.image = R.drawable.lemur;
                break;
                // TODO default image incase if anyhing
        }
    }
    @Override
    public String toString(){
        return (this.name + " the " + this.type + " currently has " + this.fans + " fans who love them for their " + this.talent + "!");
    }

    public String info(){
        return (this.name + " the " + this.type + " is " + this.age + " years old!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public String getTalent() {
        return talent;
    }

    public void setTalent(String talent) {
        this.talent = talent;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String[] getTalents() {
        return talents;
    }

    public void setTalents(String[] talents) {
        this.talents = talents;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
