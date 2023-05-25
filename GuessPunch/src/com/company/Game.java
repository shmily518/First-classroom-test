package com.company;

import java.util.Scanner;

public class Game {
    String persona;
    String myname;
    String state;
    String middle1 = "";//电脑出拳
    String middle="";//我的出拳
    int myChioce, comChioce;
    int mycount = 0, comcount = 0, count = 0;


    public void initial() {//初始程序
        System.out.println("*******************");
        System.out.println("*****猜 拳 开 始*****");
        System.out.println("*******************");
        System.out.println("出拳规则:1.剪刀 2.手头 3.布");
        System.out.println("请选择对方角色:1:刘备 2:孙权 3:曹操");
        Scanner scanner = new Scanner(System.in);
        persona = scanner.next();
        if(persona.equals("1")){
            persona = "刘备";
        }else if(persona.equals("2")){
            persona = "孙权";
        }else {
            persona = "曹操";
        }
        System.out.print("\n请输入你的姓名:");
        myname = scanner.next();
        System.out.println(myname + "    VS    " + persona);
        System.out.println("要开始吗？(y/n)");
        state = scanner.next();
        JudgeInput();

    }

    public void JudgeInput(){
        while ((!(state.equals("y"))) && (!(state.equals("n")))){
            System.out.println("输入有误，请重新输入！\n"+"请输入‘y’或’n‘");
            Scanner scanner = new Scanner(System.in);
            state = scanner.next();
        }
    }
    public void showPunch(){
        if(comChioce==1){
            middle1 = "剪刀";
        }else if(comChioce==2){
            middle1 = "石头";
        }else {
            middle1 = "布";
        }
        if(myChioce==1){
            middle = "剪刀";
        }else if(myChioce==2){
            middle = "石头";
        }else {
            middle = "布";
        }
        System.out.println("你出拳:"+middle);
        System.out.println(persona+"出拳:"+middle1);
    }


    public void StartGame() {
        while (state.equals("y")) {
            Scanner scanner = new Scanner(System.in);
            User user1 = new User();
            Computer computer1 = new Computer();
            myChioce = user1.PunchOutU();
            comChioce = computer1.PunchOutC();
            showPunch();
                switch (myChioce) {
                    case 1:
                        if (comChioce == 1) {
                            System.out.println("和局，真囊，等着瞧吧！");
                            break;
                        } else if (comChioce == 2) {
                            System.out.println("你输了，真笨！");
                            comcount++;
                            break;
                        } else if (comChioce == 3) {
                            System.out.println("恭喜你，你赢了！");
                            mycount++;
                            break;
                        }
                    case 2:
                        if (comChioce == 2) {
                            System.out.println("和局，真囊，等着瞧吧！");
                            break;
                        } else if (comChioce == 3) {
                            System.out.println("你输了，真笨！");
                            comcount++;
                            break;
                        } else if (comChioce == 1) {
                            System.out.println("恭喜你，你赢了！");
                            mycount++;
                            break;
                        }
                    case 3:
                        if (comChioce == 3) {
                            System.out.println("和局，真囊，等着瞧吧！");
                            break;
                        } else if (comChioce == 1) {
                            System.out.println("你输了，真笨！");
                            comcount++;
                            break;
                        } else{
                            System.out.println("恭喜你，你赢了！");
                            mycount++;
                            break;
                        }
                }
            count++;
            System.out.println("\n是否开始下一轮？（y/n）");
            state = scanner.next();
            JudgeInput();
            if(state.equals("n")){
                System.out.println(myname + "   Vs   "+ persona);
                System.out.println("对战次数："+count);
                System.out.println("姓名      得分\n"+myname+"      "+mycount);
                System.out.println(persona+"      "+comcount);
                if(mycount>comcount){
                    System.out.println("结果：真棒，你战胜了"+persona);
                }else if(mycount<comcount){
                    System.out.println("结果：呵呵，笨笨，下次加油啊！");
                }else{
                    System.out.println("结果：打成平手，下次再和你一分高下！");
                }

            }

        }
    }
}