package com.company;

import Models.LopezMiquel_Card;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<LopezMiquel_Card> newCards = new ArrayList<>();

    public static void main(String[] args) {
        String team = "Cleveland Cavaliers";
        readBbdds(team);
	    printBbdd(newCards);
    }

    public static void readBbdds(String x){
        try {
            String initials;
            int min = 55, max = 75;
            String[] team = x.split(" ");
            String finalyTeam;

            File document = new File("oldCards.txt");
            try (Scanner sc = new Scanner(document)) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] values = line.split(" ");
                    if (team.length == 2){
                        initials = ""+team[0].charAt(0) + team[1].charAt(0) + values[0].charAt(0) + values[1].charAt(0);
                        finalyTeam = team[0] + " " + team[1];
                    }else{
                        initials = ""+team[0].charAt(0) + team[1].charAt(0) + team[2].charAt(0) + values[0].charAt(0) + values[1].charAt(0);
                        finalyTeam = team[0] + " " + team[1] + " " + team[2];
                    }

                    LopezMiquel_Card y = new LopezMiquel_Card(
                                            values[0],
                                            values[1],
                                    1,
                                            (int)Math.floor(Math.random()*(max-min+1)+min),
                                            (int)Math.floor(Math.random()*(max-min+1)+min),
                                            finalyTeam,
                                            initials);
                    newCards.add(y);
                }
            } catch (Exception ignored) {
            }
        }catch (Exception ignored){}
    }

    public static void printBbdd(ArrayList<LopezMiquel_Card> x) {
        try {
            File document = new File("newCards.txt");
            PrintStream output= new PrintStream(document);
            for (LopezMiquel_Card lopezMiquel_card : x) {
                output.print(
                        lopezMiquel_card.getName() + ";" +
                        lopezMiquel_card.getSurname() + ";" +
                        lopezMiquel_card.getPosition() + ";" +
                        lopezMiquel_card.getAtk() + ";" +
                        lopezMiquel_card.getDef() + ";" +
                        lopezMiquel_card.getTeam() + ";" +
                        lopezMiquel_card.getIdCard() + ";" +
                        "\n");
            }
            output.close();
        }catch (Exception ignored){}

    }
}