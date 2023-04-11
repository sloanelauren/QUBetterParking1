public class QuBetterParking1 
{
    public static void main(String[] args) 
    {
        //Made variables that hold the size of the array, the values can be changed to whatever programmer wants
        int rowSize = 5; 
        int colSize = 5;
        
        //Creating the array
        char [][] parking;
        parking = new char[rowSize][colSize];

        //Counting variable for parking spaces
        int availableSpots = 0;
        //Printing Array and setting available spots
        for(int row = 0; row < rowSize; row++)
        {
            for(int col = 0; col < colSize; col++)
            {
                if(parking[row][col] == parking[0][0])
                {
                    //Setting [0][0] to the entrance/exit
                    parking[0][0] = 'E';
                    System.out.print(parking[row][col] + " ");
                    continue;
                }
                parking[row][col] = '0';
                System.out.print(parking[row][col] + " ");
                availableSpots++;
            }
            System.out.println();
        }
        System.out.println("Available spots: " + availableSpots);
    }
}