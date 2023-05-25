package com.company;

public abstract class Pet {//父类
    private String name;
    private int health;//0-100
    public int love;//0-100

    public Pet(){
        this.health = 80;
        this.love = 0;
    }

    public Pet(String name, int health, int love){
        super();
        this.name = name;
        this.health = health;
        this.love = love;
    }

    public void print(){
        System.out.println("宠物的自白:");
        System.out.println("我的名字叫"+name+"，我的健康值是"+health+"，我和主人的亲密程度是"+love+"。");
    }

    public abstract void feed();
    public abstract void game();
    public abstract void cure();


    public String getName(){

        return name;
    }

    public int getHealth(){

        return health;
    }

    public int getLove(){

        return love;
    }

    public void setName(String name){

        this.name = name;
    }

    public void setHealth(int health){

            this.health = health;
    }

    public void setLove(int love){

            this.love = love;

    }

    public void check(){
        if (this.getHealth()>100){
            this.setHealth(100);
        } if (this.getHealth()<0){
            this.setHealth(0);
        }if (this.getLove()>100){
            this.setLove(100);
        }
    }
}
