package com.bridgelabz;

public class GamblingSimulation {

    static final int BET = 1;
    static int stake = 100;
    static int daycount = 1;

    static int total_num_of_wins_in_day = 0;
    static int total_num_of_losses_in_day = 0;

    public static void checkWinOrLoose() {
        int random_Check = (int) (Math.random() * 2);
        switch (random_Check) {
            case 1:
                stake += BET;
                total_num_of_wins_in_day++;
                break;
            default:
                stake -= BET;
                total_num_of_losses_in_day++;
        }
    }

    public static void gambling() {
        double winningTarget = stake * 1.5;
        double loosingTarget = stake * 0.5;

        System.out.println("Starting with : " + stake + "    Winning target = " + winningTarget + "    Loosing target = " + loosingTarget);

        while (stake <= winningTarget && stake >= loosingTarget) {
            checkWinOrLoose();
            if (stake == 150) {
                System.out.println("*** Winning day ***");
                break;
            }
            if (stake == 50) {
                System.out.println("*** Loosing day ***");
                break;
            }
        }
        System.out.println("Gambler account balance : " + stake);
        System.out.println("Total number of wins in the day is : " + total_num_of_wins_in_day);
        System.out.println("Total number of loose in the day is : " + total_num_of_losses_in_day);

        stake = 100;
        total_num_of_wins_in_day = 0;
        total_num_of_losses_in_day = 0;
    }

    public static void checkAfter20Days() {
        while (daycount != 21) {
            System.out.println("******* DAY" + daycount + " *******");
            gambling();
            System.out.println("");
            daycount++;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Simulation problems");
        checkAfter20Days();
    }
}