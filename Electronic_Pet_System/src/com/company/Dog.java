package com.company;

public class Dog extends Pet{//狗类
    private String strain;


    public Dog() {
    }

    public Dog(String name, int health, int love,String strain) {
        super(name, health, love);//super可以直接访问父类的构造方法
        this.strain = strain;
    }

    public String getStrain(){
        return strain;
    }
    public void setStrain(String strain) {

        this.strain = strain;
    }
    @Override
    public void feed() {//Dog类中实现
        this.setHealth(this.getHealth()+4);
        this.setLove(this.getLove()+5);
        super.check();
        System.out.println("给宠物狗"+this.getName()+
                "喂食，健康值+4"+",亲密度+5.");
    }

    @Override
    public void game() {
        this.setHealth(this.getHealth() - 10);
        this.setLove(this.getLove()+5);
        super.check();
        System.out.println("和宠物狗" + this.getName() + "玩游戏，健康值-10"+",亲密度+5.");
    }

    @Override
    public void cure() {
        this.setHealth(this.getHealth() + 20);
        super.check();
        System.out.println("给宠物狗" + this.getName() + "治疗后，健康值+20");

    }

    public  void print() {
        super.print();
        System.out.println("我是一只"+strain);
    }

}
