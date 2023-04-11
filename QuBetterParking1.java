import java.util.Scanner;

public class QuBetterParking1 {
    public static void main(String[] args) {
        // Made variables that hold the size of the array, the values can be changed to
        // whatever programmer wants
        int rowSize = 5;
        int colSize = 5;

        // input related variables
        Scanner scanoTron9000 = new Scanner(System.in);
        String userInput = "";
        int rowNum = 0;
        int colNum = 0;
        boolean goodRow = false;
        boolean goodCol = false;

        // Creating the array
        char[][] parking;
        parking = new char[rowSize][colSize];

        // Counting variable for parking spaces
        int availableSpots = 0;

        int row, col = 0;

        // Setting available spots
        for (row = 0; row < rowSize; row++) {
            for (col = 0; col < colSize; col++) {
                if (parking[row][col] == parking[0][0]) {
                    // Setting [0][0] to the entrance/exit
                    parking[0][0] = 'E';
                    continue;
                }
                parking[row][col] = '0';
                availableSpots++;
            }
        }

        // Program loop
        while(!userInput.equals("q")){ // q quits the program
            
            // Printing the array and available spots- prints everytime before user chooses what to do
            System.out.println(":PARKING LOT:");
            for (row = 0; row < rowSize; row++) {
                for (col = 0; col < colSize; col++) {
                    System.out.print(parking[row][col] + " ");
                }
                System.out.println();
            }
            System.out.println("Available spots: " + availableSpots);

            // User chooses what they want to do
            System.out.println("Press t for ticket\nPress e to enter your ticket\nPress q to go find a parking spot somewhere else");
            userInput = scanoTron9000.nextLine();

            if(userInput.equals("t")){ // t gives the user a ticket

                // First checks if there are spots - if not then tells user no spots available
                if (availableSpots == 0) {
                    System.out.println("There are no more available spots. Please try again later!");
                }

                // Giving ticket logic - if there are available spots
                else {
                    // searches array for first available spot - first spot that is "0"
                    for (int i = 0; i < rowSize; i++) {
                        for (int j = 0; j < colSize; j++) {
                            if (parking[i][j] == '0') {
                                // i and j are the coordinates of the first available spot
                                // Ticket statement (assigns parking spots)
                                System.out.println("Please park in the ticketed spot.");
                                System.out.println(" ------------------------");
                                System.out.println("|      Spot : " + i + " , " + j + "      |");
                                System.out.println(" ------------------------");

                                // Setting X to the nearest taken spot
                                parking[i][j] = 'X';

                                // decrement availableSpots
                                availableSpots--;

                                // setting i and j to rowSize and colSize breaks the loop - a break could also
                                // be used here
                                i = rowSize;
                                j = colSize;
                            }
                        }
                    }
                }
            }
            else if(userInput.equals("e")){ // e if user wants to enter a ticket spot
                // nextLine appears after each nextInt becuse nextInt is funky when you hit enter

                // Row loop - makes sure entered row is valid
                while(!goodRow){
                    try{
                        // getting user row
                        System.out.println("Enter your row number");
                        rowNum = scanoTron9000.nextInt();
                        scanoTron9000.nextLine();

                        // checks if entered row exists
                        if(rowNum < rowSize && rowNum >= 0){goodRow = true;}
                        else{System.out.println("That is not a valid row number");}
                    }
                    catch(Exception e){ // exeception reached if user did not enter an integer
                        System.out.println("That is not a valid row number");
                        scanoTron9000.nextLine();
                    }
                }

                // Column loop - makes sure entered column is valid
                while(!goodCol){
                    try{
                        // getting user column
                        System.out.println("Enter your column number");
                        colNum = scanoTron9000.nextInt();
                        scanoTron9000.nextLine();

                        // checks if entered column exists
                        if(colNum < colSize && colNum >= 0){goodCol = true;} 
                        else{System.out.println("That is not a valid column number");}
                    }
                    catch(Exception e){ // exeception reached if user did not enter an integer
                        System.out.println("That is not a valid column number");
                        scanoTron9000.nextLine();
                    }
                }

                // Logic for each possible array value
                if(parking[rowNum][colNum] == 'X'){ // if spot is taken change spot to empty and increment availableSpots
                    parking[rowNum][colNum] = '0';
                    System.out.println("Thank you for using this parking lot");
                    availableSpots++;
                }
                else if(parking[rowNum][colNum] == 'E'){ // if spot is the entrance/exit do nothing
                    System.out.println("That is not a valid parking spot");
                }
                else{ // if spot is empty do nothing
                    System.out.println("No car is parked there");
                }

                // reset row and column input validation variables
                goodRow = false;
                goodCol = false;
            }
            else if(userInput.equals("q")){ // departing message if user quits
                System.out.println("Good luck finding a parking spot somewhere else");
            }
        }
    }
}