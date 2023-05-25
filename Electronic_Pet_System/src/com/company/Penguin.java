package com.company;

public class Penguin extends Pet{//企鹅类
    private String sex;
    public Penguin() {

    }

    public Penguin(String name, int health, int love,String sex) {
        super(name, health, love);
        this.sex = sex;
    }

    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex = sex;
    }

    @Override
    public void feed() {
        this.setHealth(this.getHealth() + 4);
        this.setLove(this.getLove()+5);
        super.check();
        System.out.println("给宠物企鹅" + this.getName() + "喂食，健康值+4"+",亲密度+5.");
    }

    @Override
    public void game() {
        this.setHealth(this.getHealth() - 10);
        this.setLove(this.getLove()+5);
        super.check();
        System.out.println("和宠物企鹅" + this.getName() + "玩游戏，健康值-10"+",亲密度+5.");
    }

    @Override
    public void cure() {
        this.setHealth(this.getHealth() + 20);
        super.check();
        System.out.println("给宠物企鹅" + this.getName() + "治疗后，健康值+20");
    }

    public void print() {
        super.print();
        System.out.println("我的性别"+sex);
    }
}
