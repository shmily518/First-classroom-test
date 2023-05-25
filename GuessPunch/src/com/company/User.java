package com.company;

import java.util.Scanner;

public class User {
    int UserPunch;

    public int PunchOutU(){
        System.out.println("请出拳:1.剪刀 2.石头 3.布 (输入对应数字)");
        Scanner scanner = new Scanner(System.in);
        UserPunch = scanner.nextInt();

        return UserPunch;

    }
}
