package com.company;

import java.util.Random;

public class Computer {
    int ComputerPunch;

    public int PunchOutC(){
        Random random = new Random();
        ComputerPunch = (random.nextInt(3)+1);
        return ComputerPunch;

    }
}

