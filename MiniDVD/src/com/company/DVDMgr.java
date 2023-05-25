package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DVDMgr {
    static int lend = 0;//已借出
    static int NotLoaned = 1;//未借出
    int n = 0;
    int m = 3;

    DVDSet dvd = new DVDSet();
    Start start = new Start();
    Scanner scanner = new Scanner(System.in);
    public DVDMgr(){
        dvd.name[0] = "罗马假日";
        dvd.state[0] = lend;//状态 0 已借出 1 未借出
        dvd.date[0] = "2010-7-1";

        dvd.name[1] = "风声鹤唳";
        dvd.state[1] = NotLoaned;//状态 0 已借出 1 未借出
        dvd.date[1] = "";

        dvd.name[2] = "浪漫满屋";
        dvd.state[2] = NotLoaned;//状态 0 已借出 1 未借出
        dvd.date[2] = "";

        }

    public void search(){//查看
        String middle = "";
        int middle1 = 1;
        while (dvd.name[n]!=null){
            System.out.println("序号   "+"状态   "+"    名称        "+"借出日期");
            if (dvd.state[n]==lend){
                middle = "已借出";
            }else {
                middle = "可借";
            }
            System.out.println((n+1)+"     "+middle+"   《"+dvd.name[n]+"》        "+dvd.date[n]);
            n++;
        }
        System.out.print("输入0返回:");
        middle1 = scanner.nextInt();
        if (middle1==0) {
            start.startMenu();
        }
    }


    public void add(){//新增
        int middle = 1;
        while (middle==1) {
            System.out.println("请输入DVD名称:");
            dvd.name[m] = scanner.next();
            System.out.println("新增《" + dvd.name[m] + "》成功！");
            dvd.state[m] = NotLoaned;
            m++;
            System.out.println("_________________________");
            System.out.print("输入0返回,输入1继续输入:");
            middle = scanner.nextInt();
            if (middle==0) {
                start.startMenu();
            }else if (middle==1){
                continue;
            }
        }
    }
/*
    public void delete(){
        String middle = "0";
        int middle2 = 1;
        System.out.print("请输入DVD名称:");
        middle = scanner.nextLine();
        for (int i=0;i<50;i++){
            if (dvd.name[i].equals(middle)){
                if(dvd.state[i]==lend){
                    System.out.println(dvd.name[i]+"为借出状态，不能删除！");
                    break;
                }else if (dvd.state[i]==NotLoaned){
                    for (int j=i;j<50;j++){
                        if (dvd.name[j]==null){
                            break;
                        }
                        dvd.name[j]=dvd.name[j+1];
                        dvd.state[j]=dvd.state[j+1];
                        dvd.date[j]=dvd.date[j+1];

                    }
                    System.out.println(dvd.name[i]+"已经成功删除！");
                }
                break;
            }
        }
        System.out.print("输入0返回:");
        middle2 = scanner.nextInt();
        if (middle2==0){
            start.startMenu();
        }

    }*/

    public void delete() {
        int count = 0;
        int i = 0;
        String dvdName;
        System.out.print("请输入要删除的DVD名称：");
        dvdName = scanner.nextLine();
        for (; i < dvd.name.length; i++) {
            if (dvd.name[i] == null) {
                break;
            }
            if (dvdName.equals(dvd.name[i])) {
                if (dvd.state[i] == 1) {
                    System.out.println("删除" + "《" + dvd.name[i] + "》" + "成功！");
                    for (int j = i; j < dvd.name.length; j++) {
                        if (dvd.name[j] == null) {
                            break;
                        }
                        dvd.name[j] = dvd.name[j + 1];
                        dvd.state[j] = dvd.state[j + 1];
                        dvd.date[j] = dvd.date[j + 1];
                    }

                    count++;
                } else if (dvd.state[i] == 0) {
                    System.out.println("《" + dvd.name[i] + "》" + "为借出状态，不能删除！");
                    count++;
                    break;
                } else {
                    continue;
                }
            }
        }
        if (count == 0) {
            System.out.println("你要删除的DVD不存在！");
        }
        start.startMenu();
    }

    public void lendDvd() {
        //dvd.countNum[0] = 1;
        int count = 0;
        String dvdName;
        System.out.print("请输入要借出的DVD名称：");
        dvdName = scanner.nextLine();
        for (int i = 0; i < dvd.name.length; i++) {
            if (dvd.name[i] == null) {
                break;
            }
            if (dvdName.equals(dvd.name[i])) {
                if (dvd.state[i] == 1) {
                    System.out.println("《" + dvd.name[i] + "》" + "可借！");
                    dvd.state[i] = 0;
                    System.out.print("请输入借出日期（年-月-日）：");
                    dvd.date[i] = scanner.nextLine();
                    //dvd.countNum[i] = (dvd.countNum[i])+1;
                    System.out.println("借出" + "《" + dvd.name[i] + "》" + "成功！");

                    count++;
                } else if (dvd.state[i] == 0) {
                    System.out.println("《" + dvd.name[i] + "》" + "已经借出了！");
                    count++;
                } else {
                    continue;
                }
            }
        }
        if (count == 0) {
            System.out.println("你要借的DVD不存在！");
        }
        start.startMenu();
    }

    public void returnDvd(){
        long charge;

        String dvdName, returnTime;
        int count = 0;
        System.out.print("请输入DVD名称：");
        dvdName = scanner.nextLine();
        for (int i = 0; i < dvd.name.length; i++) {
            if (dvd.name[i] == null) {
                break;
            }
            if (dvdName.equals(dvd.name[i])) {
                if (dvd.state[i] == 0) {
                    dvd.state[i] = 1;
                    System.out.print("请输入归还日期（年-月-日）：");                 //"《" + dvd.name[i] + "》" + "可借！"
                    returnTime = scanner.nextLine();
                    System.out.println("归还" + "《" + dvd.name[i] + "》" + "成功！" + "\n");
                    System.out.println("借出日期为：" + dvd.date[i]);
                    System.out.println("归还日期为：" + returnTime);


                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date date1 = null;
                    try {
                        date1 = format.parse(dvd.date[i]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Date date2 = null;
                    try {
                        date2 = format.parse(returnTime);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    long startTime = date1.getTime();
                    long endTime  = date2.getTime();;
                    int days = (int) ((endTime - startTime) / (1000 * 60 * 60 * 24));
                    charge = days*1;
                    System.out.println("你应付租金为:"+charge+"元");

                    count++;
                } else if (dvd.state[i] == 1) {
                    System.out.println("此书《" + dvd.name[i] + "》" + "暂未借出！");
                    count++;
                } else {
                    continue;
                }
            }
        }
        if (count == 0) {
            System.out.println("归还的DVD信息不存在！");
        }
    start.startMenu();
    }






}


