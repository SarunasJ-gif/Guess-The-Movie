package com.company;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    private final String gameFile;

    public Game(String gameFile) {
        this.gameFile = gameFile;
    }
    public String[] readFile() throws Exception {
        File file = new File(gameFile);
        Scanner fileScanner = new Scanner(file);
        int n = 0;
        while (fileScanner.hasNextLine()) {
            n++;
            fileScanner.nextLine();
        }
        String[] movies = new String[n];
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < movies.length; i++) {
            movies[i] = scanner.nextLine();
        }
         return movies;
    }

    public void runGame() throws Exception {
        Scanner scanner = new Scanner(System.in);

        String[] movies = readFile();
        int i = (int) (Math.random() * movies.length);
        String movie = movies[i];
        char[] movieTitle = movie.toCharArray();

        System.out.println("Please, enter your name");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + ", guess the title of the movie");
        System.out.println("Enter first letter: ");
        char[] table = new char[movieTitle.length];
        for (int j = 0; j < movieTitle.length; j++) {
            table[j] = '_';
            System.out.print(table[j]);
        }

        int x = 0;
        int y = 0;


        String oneWord = "";
        String[] movieWordsArray = movie.split(" ");    //kaip isimti tarpus is char masyvo?
        for (int j = 0; j < movieWordsArray.length; j++) {
            oneWord += movieWordsArray[j];
        }
        int movieLettersLength = oneWord.length();


        boolean flag = false;

        System.out.println();
        System.out.println();

        for (int j = table.length + 3; j > 1; j--) {
            String input = scanner.nextLine();
            char guess = input.charAt(0);
            int m = x;
            int z = y;


            for (int g = 0; g < movieTitle.length; g++) {
                if (guess == table[g]) {
                    System.out.println("The letter " + "\"" + guess + "\"" + " you have already opened!");
                    j++;
                    y++;
                    break;
                }
                if (guess == movieTitle[g]) {
                    table[g] = guess;
                    x++;
                }
            }

            if (x == movieLettersLength) {
                flag = true;
                break;
            }

            if (x == m && z == y) {
                System.out.println("Not correct. It's no letter " + "\"" + guess + "\"" + " in movie title. You have "
                        + (j - 1) + " attempts.");
            } else if (x != m && z == y) {
                System.out.println("Your guess is good. You opened the letter " + "\"" + guess + "\".");
            }

            for (int l = 0; l < table.length; l++) {
                System.out.print(table[l]);
            }
            System.out.println();

           }

            if (flag) {
                System.out.println("Congratulations! You won the game!");
                System.out.println("The movie was " + "\"" + movie + "\".");
            } else {
                System.out.println("You lost the game...");
                System.out.println("The movie was " + "\"" + movie + "\".");
        }
    }
}


