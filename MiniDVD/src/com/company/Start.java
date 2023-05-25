package com.company;

import java.util.Scanner;

public class Start {
    int SMC = 1;


    public void startMenu(){//主菜单
        int count = 1;
        DVDMgr dvdMgr = new DVDMgr();
        /*if (count==1){
            dvdMgr.initial();
        }
        count++;*/
        System.out.println("欢迎使用miniDVD管理器");
        System.out.println("_________________________");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.新增DVD\n"+"2.查看DVD\n"+"3.删除DVD\n"+"4.借出DVD\n"+"5.归还DVD\n"+"6.退出");
        System.out.println("_________________________");
        System.out.print("请选择:");
        SMC = scanner.nextInt();
        switch(SMC){
            case 1:{
                System.out.println("--->新增DVD");
                dvdMgr.add();
                break;
            }
            case 2:{
                System.out.println("--->查看DVD");
                dvdMgr.search();
                break;

            }
            case 3:{
                System.out.println("--->删除DVD");
                dvdMgr.delete();
                break;

            }
            case 4:{
                System.out.println("--->借出DVD");
                dvdMgr.lendDvd();
                break;

            }
            case 5:{
                System.out.println("--->归还DVD");
                dvdMgr.returnDvd();
                break;

            }
            case 6:{
                System.out.println("--->退出");
                break;

            }
        }
    }


    public void returnMain(){//返回主菜单


    }
}
