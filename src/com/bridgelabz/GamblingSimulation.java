package com.bridgelabz;

public class GamblingSimulation {

    static final int BET = 1;
    static int stake = 100;
    static int daycount = 1;

    static int total_num_of_wins_in_day = 0;
    static int total_num_of_losses_in_day = 0;

    static int winningDaycount = 0;
    static int loosingDaycount = 0;

    /* Gambler make 1 bet so either win or loose 1 */
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

    /* (Single day gambling process) Gambler will resign for the day if won or lost 50% of the stake */
    public static void gambling() {
        double winningTarget = stake * 1.5;
        double loosingTarget = stake * 0.5;

        System.out.println("Starting with : " + stake + "    Winning target = " + winningTarget + "    Loosing target = " + loosingTarget);

        while (stake <= winningTarget && stake >= loosingTarget) {
            checkWinOrLoose();
            if (stake == 150) {
                winningDaycount++;
                System.out.println("*** Winning day ***");
                break;
            }
            if (stake == 50) {
                loosingDaycount++;
                System.out.println("*** Loosing day ***");
                break;
            }
        }
        System.out.println("Gambler account balance : " + stake);
        System.out.println("Total number of wins in the day is : " + total_num_of_wins_in_day);
        System.out.println("Total number of loose in the day is : " + total_num_of_losses_in_day);

    //After each days of playing this values will be assigned with the default values. Because on the next day there will be a fresh start
        stake = 100;
        total_num_of_wins_in_day = 0;
        total_num_of_losses_in_day = 0;
    }

    /* After 30 days of playing every day would like to know the total amount won or lost. */
    public static void checkAfterMonth() {
        while (daycount != 31) {
            System.out.println("********** DAY" + daycount + " **********");
            gambling();
            System.out.println("");
            daycount++;
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Gambler total number of wins in a month :- " + winningDaycount);
        System.out.println("Gambler total number of looses in a month :- " + loosingDaycount);
        System.out.println("-----------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Simulation problems");
        checkAfterMonth();
    }
}