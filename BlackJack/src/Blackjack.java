//Pranav Saran
//Period 4

import java.util.*;

public class Blackjack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the blackjack table!");
        System.out.println("You start with a 1000$ payroll.");

        boolean game = true;
        boolean switch1 = true;
        String card = " ";
        double payroll = 1000;
        int blackjack;

        boolean bustSwitch1 = true;
        boolean bustSwitch2 = true;
        int ace = 11;

        while (game) {
            if (payroll == 0){
                game = false;
            }
            int[] deck = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9,
                    10, 10, 10, 10, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13};
            int[] pHand = new int[2];
            int[] dHand = new int[2];
            boolean bust = false;

            System.out.println("How much do you want to bet?");
            double bet = sc.nextDouble();
            sc.nextLine();
            if (bet > payroll) {
                System.out.println("You do not have enough money.");
                //game = false;
            }

            for (int i = 1; i < 5; i++) {

                int drawCard = (int) ((Math.random() * 13) + 1);

                //removing cards
                if (Helpers.existsInArray(deck, drawCard)) {
                    int con = Helpers.findIndex(deck, drawCard);
                    deck = Helpers.remove(deck, con);
                }

                //Royal values
                if (drawCard == 11 || drawCard == 12 || drawCard == 13) {

                    if (drawCard == 11)
                        card = "K";
                    if (drawCard == 12)
                        card = "J";
                    if (drawCard == 13)
                        card = "Q";
                    drawCard = 10;
                }


                boolean switch2 = Helpers.existsInArray(deck, drawCard);
                if (!switch2) {
                    i--;
                }
                //UI and setting numbers for math
                if (i == 1) {
                    System.out.println("Your hand:");
                    if (card.equals("J") || card.equals("Q") || card.equals("K")) {
                        System.out.print(card);
                        pHand[0] = 10;
                    } else if (drawCard == 1) {
                        pHand[0] = 11;
                        System.out.print("A");
                    } else {
                        System.out.print(drawCard);
                        pHand[0] = drawCard;
                    }
                    System.out.print(" ");

                } else if (i == 2) {
                    if (card.equals("J") || card.equals("Q") || card.equals("K")) {
                        System.out.print(card);
                        pHand[1] = 10;
                    } else if (drawCard == 1) {
                        pHand[1] = 11;
                        System.out.print("A");
                    } else {
                        System.out.print(drawCard);
                        pHand[1] = drawCard;
                    }
                    System.out.println();
                } else if (i == 3) {
                    System.out.println("Dealers hand:");
                    if (card.equals("J") || card.equals("Q") || card.equals("K")) {
                        System.out.print(card);
                        dHand[0] = 10;
                    } else if (drawCard == 1) {
                        dHand[0] = 11;
                        System.out.print("A");
                    } else {
                        System.out.print(drawCard);
                        dHand[0] = drawCard;
                    }
                } else {
                    System.out.print(" ▉ ");
                    if (card.equals("J") || card.equals("Q") || card.equals("K")) {
                        dHand[1] = 10;
                    } else if (drawCard == 1) {
                        dHand[1] = 11;
                    } else {
                        dHand[1] = drawCard;
                    }
                }
            }
            System.out.println();
            int blck = 0;
            double pay = 0;

            for (int i = 0; i < pHand.length; i++) {
                blck += pHand[i];
            }
            if (blck == 21) {
                System.out.println("Nice Blackjack! Here you go!");
                pay = bet * 1.5;
                payroll += pay;
            }


            boolean dealer = false;
            int pNew = 0;
            boolean[] proceed = {false, false};
            boolean HoS = true;
            int sum = 0;

            //player can either hit or stand
            while (HoS) {
                System.out.println("Would you like to hit(1) or stand(2)");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    System.out.println("Okay! Hitting you now!");
                    pNew = (int) ((Math.random() * 13) + 1);
                    if (pNew == 11 || pNew == 12 || pNew == 13) {

                        if (pNew == 11)
                            card = "K";
                        if (pNew == 12)
                            card = "J";
                        if (pNew == 13)
                            card = "Q";
                        pNew = 10;
                    }
                    if (Helpers.existsInArray(deck, pNew)) {
                        int con1 = Helpers.findIndex(deck, pNew);
                        deck = Helpers.remove(deck, con1);
                        proceed[0] = true;
                    }
                    if (proceed[0] = true) {
                        pHand = Helpers.add(pHand, pNew);
                        System.out.println("Your card values: ");
                        Helpers.display(pHand);
                    }
                    for (int i = 0; i < pHand.length; i++) {
                        sum += pHand[i];
                    }
                    //check if player busts
                    if (sum > 21) {
                        if ((Helpers.existsInArray(pHand, ace)) == true) {
                            int locA = Helpers.findIndex(pHand, ace);
                            pHand = Helpers.replace(pHand, 1, locA);
                            sum = 0;
                            for (int i = 0; i < pHand.length; i++) {
                                sum += pHand[i];
                            }
                        }
                        if (sum > 21) {
                            System.out.println("Uh Oh! You bust! Looks like i'm taking your money :)");
                            payroll = payroll - bet;
                            HoS = false;
                            bust = true;
                            System.out.println();
                            System.out.println("Bank: ");
                            System.out.println(payroll);


                            System.out.println("Do you want to try your luck again? yes(1) no(2)");
                            int retry = sc.nextInt();
                            sc.nextLine();
                            if (retry == 2)
                                game = false;
                            else {
                                game = true;
                                bustSwitch1 = false;
                            }
                        }
                        else{
                            System.out.print("");
                        }
                    }
                }
                //stand option
                if (choice != 1) {
                    System.out.println("Okay! Lets reveal cards!");
                    System.out.println("Your card values:");
                    Helpers.display(pHand);
                    HoS = false;
                }
            }

            boolean computer = true;
            boolean over17 = true;
            int dSum = 0;
            int dNew = 0;

            while (computer && bust == false) {
                for (int i = 0; i < dHand.length; i++) {
                    dSum += dHand[i];
                }
                //if over 17 or = 17 dealer will not hit
                if (dSum >= 17) {
                    computer = false;
                    over17 = false;
                }
            }
            //if not over 17 dealer will hit
            while (over17 == true) {
                if (dSum >= 17)
                    over17 = false;
                dNew = (int) ((Math.random() * 13) + 1);
                if (dNew == 11 || dNew == 12 || dNew == 13) {

                    if (dNew == 11)
                        card = "K";
                    if (dNew == 12)
                        card = "J";
                    if (dNew == 13)
                        card = "Q";
                    dNew = 10;
                }
                if (Helpers.existsInArray(deck, dNew)) {
                    int con2 = Helpers.findIndex(deck, dNew);
                    deck = Helpers.remove(deck, con2);
                    proceed[1] = true;

                }
                if (proceed[1] = true) {
                    dHand = Helpers.add(dHand, dNew);

                }
                for (int i = 0; i < dHand.length; i++) {
                    dSum += dHand[i];
                }
                System.out.println("My card values: ");
                Helpers.display(dHand);

                if (dSum > 21) {
                    if ((Helpers.existsInArray(dHand, ace)) == true) {
                        int locB = Helpers.findIndex(dHand, ace);
                        pHand = Helpers.replace(pHand, 1, locB);
                        sum = 0;
                        for (int i = 0; i < pHand.length; i++) {
                            sum += pHand[i];
                        }
                    }
                    if (sum > 21) {
                        System.out.println("Oh. I bust... Here is your money.");
                        bet = bet * 2;
                        payroll = bet + payroll;
                        bust = true;
                        System.out.println();
                        System.out.println("Bank: ");
                        System.out.println(payroll);
                        System.out.println("Do you want to try your luck again? yes(1) no(2)");
                        int retry = sc.nextInt();
                        sc.nextLine();
                        if (retry == 2)
                            game = false;
                        else {
                            game = true;
                            bustSwitch2 = false;
                        }
                        if (dSum >= 17)
                            over17 = false;
                    }
                    else{
                        System.out.print("");
                    }
                }
            }

            //Who is closer to 21?
            int dCheck = 21 - dSum;
            int pCheck = 21 - sum;
            if (bustSwitch1 && bustSwitch2) {
                if (pCheck > dCheck) {
                    System.out.println("Oh you won! Here is your payout");
                    bet = bet * 2;
                    payroll = bet + payroll;
                } else if (pCheck == dCheck) {
                    System.out.println("Push! Nothing happens.");
                } else {
                    System.out.println("Unfortunate! You did not make bank this time. I'll be taking what you put up for grabs.");
                    payroll = payroll - bet;
                }
            }

            System.out.println();
            System.out.println("Bank: ");
            System.out.println(payroll);
            System.out.println("Do you want to try your luck again? yes(1) no(2)");
            int retry = sc.nextInt();
            sc.nextLine();

            if (retry == 2)
                game = false;

        }
    }
}



