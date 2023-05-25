package com.company;

import java.util.Random;
import java.util.Scanner;

public class Console {
    String UserName;
    String password;
    int CardNumber;
    String Y = "y";


    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    void menu() {
        while (Y.equals("y")) {
            System.out.println("******欢迎进入奖客富翁系统*****");
            System.out.println("\t\t1.注册\n" + "\t\t2.登录\n" + "\t\t3.抽奖");
            System.out.println("***************************\n"+"请选择菜单:");
            String option = scanner.next();
            if (option.equals("1")) {
                System.out.println("[奖客富翁系统 > 注册]");
            } else if (option.equals("2")) {
                System.out.println("[奖客富翁系统 > 登录]");

            } else if (option.equals("3")) {
                System.out.println("[奖客富翁系统 > 抽奖]");
            } else {
                System.out.println("您输入有误！！！");
                continue;
            }
            System.out.println("要继续吗？（y/n）");
            Y = scanner.next();
            if (Y.equals("n")) {
                System.out.println("谢谢使用，退出系统");
                break;
            }
            if (option.equals("1")) {
                enroll();
            } else if (option.equals("2")) {
                login();
            } else if (option.equals("3")){
                Sweepstakes();
                break;
            }
        }
    }
    void enroll(){     //注册
        System.out.println("请填写个人注册信息:\n"+"用户名:");
        UserName = scanner.next();
        System.out.println("密码:");
        password = scanner.next();

        CardNumber = random.nextInt(9999-1000+1);
        System.out.println("注册成功，请记好你的会员卡号！");
        System.out.println("用户名\t\t"+"密码\t\t"+"会员卡号\t\t");
        System.out.println(UserName+"\t\t"+password+"\t\t"+CardNumber+"\t\t");
    }
    void login(){      //登录
        String UserName1 , password1;
        System.out.println("请输入用户名:");
        UserName1 = scanner.next();
        System.out.println("请输入密码:");
        password1 = scanner.next();
        if((UserName1.equals(UserName))&&(password1.equals(password))){
            System.out.println("欢迎您:"+UserName);
            int LuckyNumber = random.nextInt(9-0+1);
        }
    }
    void Sweepstakes(){
        System.out.println("请输入您的卡号:");
        CardNumber = scanner.nextInt();
        int LuckyNumber = random.nextInt(9-0+1);
        int middle;
        middle = (CardNumber-((CardNumber/1000)*1000))/100;
        System.out.println("今日幸运数为:"+LuckyNumber);
        if(LuckyNumber == middle){
            System.out.println("恭喜您，您是今日的幸运会员！");
        }
        else{
            System.out.println("抱歉，您不是今日的幸运会员！");
        }
    }
}