package com.company;

public class Monkey extends Pet{//猴类
    public Monkey() {
    }

    public Monkey(String name, int health, int love) {
        super(name, health, love);//super可以直接访问父类的构造方法

    }
    @Override
    public void feed() {
        this.setHealth(this.getHealth() + 4);
        this.setLove(this.getLove()+5);
        super.check();
        System.out.println("给宠物小猴" + this.getName() + "喂食，健康值+4"+",亲密度+5.");
    }

    @Override
    public void game() {
        this.setHealth(this.getHealth() - 10);
        this.setLove(this.getLove()+5);
        super.check();
        System.out.println("和宠物小猴" + this.getName() + "玩游戏，健康值-10"+",亲密度+5.");
    }

    @Override
    public void cure() {
        this.setHealth(this.getHealth() + 20);
        super.check();
        System.out.println("给宠物小猴" + this.getName() + "治疗后，健康值+20");
    }

    public void print() {
        super.print();
        System.out.println("我是一只机灵的小猴子!");
    }
}
