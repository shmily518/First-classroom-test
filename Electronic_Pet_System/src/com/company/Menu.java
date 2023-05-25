package com.company;

import javax.xml.namespace.QName;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Menu {
    String administrator = "Admin";//登录名
    String passWard = "123456";
    int count = 1;
    boolean sta = true;
    int type1 = 0;


    Dog dog = new Dog();
    Penguin penguin = new Penguin();
    Cat cat = new Cat();
    Tiger tiger = new Tiger();
    Monkey monkey =new Monkey();
    Master m = new Master();
    public Menu() {
    }

    public void startMenu() throws IOException {//主菜单
        while (sta=true) {
            int choice = 0;
            boolean state = true;
            Scanner scanner = new Scanner(System.in);
         for (;count <= 1;count++) {
                initial();
                login();
            }
            showMenu();
            while (state == true) {
                choice = scanner.nextInt();
                while (choice >= 6 || choice <= 0) {
                    System.out.print("输入有误，请重新输入:");
                    choice = scanner.nextInt();
                }
                switch (choice) {
                    case 1: {
                        System.out.println("--->领养宠物");
                        adopted();
                        break;
                    }
                    case 2: {
                        System.out.println("--->给宠物喂食");
                        feeding();
                        break;
                    }
                    case 3: {
                        System.out.println("--->与宠物游戏");
                        GameIng();
                        break;
                    }
                    case 4: {
                        System.out.println("--->给宠物看病");
                        seeDoctor();
                        break;
                    }
                    case 5:{
                        System.out.println("感谢使用电子宠物管理系统！！！！");
                        System.exit(0);
                    }
                }
            }
        }
    }


    public void login() {//登录
        boolean state = false;
        while(state==false){
            String userName = "";
            String userPassWard = "";
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入用户名:");
            userName = scanner.nextLine();
            System.out.print("请输入登录密码:");
            userPassWard = scanner.nextLine();
            if (userName.equals(administrator) && userPassWard.equals(passWard)) {
                System.out.println("登录成功！欢迎" + administrator);
                state = true;
            } else {
                System.out.println("用户名或密码不正确请重新输入:");
            }
        }
    }

    public void initial(){
        System.out.println("****欢迎使用电子宠物管理系统*****");
        System.out.println("**********请登录*************");
    }

    public void showMenu(){
        System.out.println("1.领养宠物\n"+"2.给宠物喂食\n"+
                "3.与宠物游戏\n"+"4.给宠物看病\n"+"5.退出");
        System.out.print("请选择:");
    }

    public void adopted() throws IOException {//领养
        System.out.print("请输入要领养宠物的名字:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请选择要领养的宠物类型(1、狗狗" +
                "2、企鹅3、小猫4、小老虎5、小猴)");
        int type=scanner.nextInt();
        while (type >= 6 || type <= 0) {
            System.out.print("输入有误，请重新输入:");
            type = scanner.nextInt();
        }
        type1 = type;
        switch (type){
            case 1:{
                String strain = "";
                dog.setName(name);
                dog.getHealth();
                dog.getLove();
                System.out.println("请选择狗狗的品种(1、拉布拉多 2、雪纳瑞 )");
                int type1 = scanner.nextInt();
                if (type1==1){
                    strain = "拉布拉多";
                }else {
                    strain = "雪纳瑞";
                }
                dog.setStrain(strain);
                dog.print();
                break;
            }

            case 2:{
                String sex = null;
                //Penguin penguin = new Penguin();
                penguin.setName(name);
                System.out.println("请选择企鹅的性别(1、Q仔 2、Q妹)");
                int type1 = scanner.nextInt();
                if (type1==1){
                     sex = "Q仔";
                }else {
                    sex = "Q妹";
                }
                penguin.setSex(sex);
                penguin.print();
                break;
            }
            case 3:{
                //Cat cat = new Cat();
                cat.setName(name);
                cat.print();
                break;
            }
            case 4:{
                //Tiger tiger = new Tiger();
                tiger.setName(name);
                tiger.print();
                break;

            }
            case 5:{
                //Monkey monkey =new Monkey();
                monkey.setName(name);
                monkey.print();
                break;
            }
        }
        //停顿
        System.out.println("按回车继续");
        new BufferedReader(new InputStreamReader(System.in)).readLine();
        startMenu();
    }

    public void feeding() throws IOException {//喂食
        //Master m = new Master();
        if (type1==0){
            System.out.println("请先领养宠物！！！");
            System.out.println("按回车继续");
            new BufferedReader(new InputStreamReader(System.in)).readLine();
            startMenu();

        }
        switch (type1){
            case 1:{
                dog.print();
                m.feed(dog);
                dog.print();
                break;
            }

            case 2:{
                penguin.print();
                m.feed(penguin);
                penguin.print();
                break;
            }
            case 3:{
                cat.print();
                m.feed(cat);
                cat.print();
                break;
            }
            case 4:{
                tiger.print();
                m.feed(tiger);
                tiger.print();
                break;

            }
            case 5:{
                monkey.print();
                m.feed(monkey);
                monkey.print();
                break;
            }
        }

        //停顿
        System.out.println("按回车继续");
        new BufferedReader(new InputStreamReader(System.in)).readLine();
        startMenu();
    }
    public void GameIng() throws IOException {
        if (type1==0) {
            System.out.println("请先领养宠物！！！");
            System.out.println("按回车继续");
            new BufferedReader(new InputStreamReader(System.in)).readLine();
            startMenu();
        }

        switch (type1) {
            case 1: {
                dog.print();
                m.game(dog);
                dog.print();
                break;
            }

            case 2: {
                penguin.print();
                m.game(penguin);
                penguin.print();
                break;
            }
            case 3: {
                cat.print();
                m.game(cat);
                cat.print();
                break;
            }
            case 4: {
                tiger.print();
                m.game(tiger);
                tiger.print();
                break;

            }
            case 5: {
                monkey.print();
                m.game(monkey);
                monkey.print();
                break;
            }
        }

        //停顿
        System.out.println("按回车继续");
        new BufferedReader(new InputStreamReader(System.in)).readLine();
        startMenu();
    }
    public void seeDoctor() throws IOException {
        if (type1==0){
            System.out.println("请先领养宠物！！！");
            System.out.println("按回车继续");
            new BufferedReader(new InputStreamReader(System.in)).readLine();
            startMenu();

        }
        switch (type1){
            case 1:{
                dog.print();
                m.cure(dog);
                dog.print();
                break;
            }

            case 2:{
                penguin.print();
                m.cure(penguin);
                penguin.print();
                break;
            }
            case 3:{
                cat.print();
                m.cure(cat);
                cat.print();
                break;
            }
            case 4:{
                tiger.print();
                m.cure(tiger);
                tiger.print();
                break;

            }
            case 5:{
                monkey.print();
                m.cure(monkey);
                monkey.print();
                break;
            }
        }

        //停顿
        System.out.println("按回车继续");
        new BufferedReader(new InputStreamReader(System.in)).readLine();
        startMenu();
    }

}