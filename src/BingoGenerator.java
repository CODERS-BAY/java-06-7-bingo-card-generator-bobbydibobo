import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BingoGenerator {

    public static void main(String[] args) {

        //24 slots --> unique Numb
        //col B: 5 rnd Num between 1-15
        //col I: 5 rnd Num between 16-30
        //col N: 4 rnd Num between 31-45
        //col G: 5 rnd Num between 46-60
        //col O: 5 rnd Num between 61-75

        //Grid: 5x5 --> empty 2D Array (grid)
        //Grid Empty: Array[2][2] --> Empty

        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        int gridWidth = 5;
        int[][] grid = new int[gridWidth][gridWidth];
        int[][] newGrid = new int[gridWidth][gridWidth];

        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            for (int j = 0; j < grid[i].length; j++) {

                int startValue = 0;

                if (j == 1) {
                    startValue = 15;
                } else if (j == 2) {
                    startValue = 30;
                } else if (j == 3) {
                    startValue = 45;
                } else if (j == 4) {
                    startValue = 60;
                }

                int changeCounter = 0;
                switch (j) {
                    case 0:
                        grid[i][j] = rnd.nextInt((16));
                        while (grid[i][j] == 0) {
                            grid[i][j] = rnd.nextInt((15 + 1));
                        }
                        System.out.print(grid[i][j] + "\t");
                        break;

                    case 1:
                        grid[i][j] = rnd.nextInt(15 + 1) + startValue;
                        System.out.print(grid[i][j] + "\t");
                        break;

                    case 2:
                        if (i == 2) {
                            System.out.print("\t");
                        } else {
                            grid[i][j] = rnd.nextInt(15 + 1) + startValue;
                            System.out.print(grid[i][j] + "\t");
                        }
                        break;

                    case 3:
                        grid[i][j] = rnd.nextInt(15 + 1) + startValue;
                        System.out.print(grid[i][j] + "\t");
                        break;

                    case 4:
                        grid[i][j] = rnd.nextInt(15 + 1) + startValue;
                        System.out.print(grid[i][j] + "\t");
                        break;

                }

                    newGrid[i][j] = grid[i][j];

            }
        }

        System.out.println();

        for (int i = 0; i < newGrid.length; i++){
            System.out.println();
            for(int j = 0; j < newGrid[i].length;j++){

                for (int k = 0; k < gridWidth;k++){

                   int counter = 0;
                    while (newGrid[i][j] == grid[k][j] && k != i && counter < 3){
                        if (j == 1) {
                            newGrid[i][j] = rnd.nextInt(15+1) + 15;
                            counter++;
                        } else if (j == 2) {
                            newGrid[i][j] = rnd.nextInt(15+1) + 30;
                            counter++;
                        } else if (j == 3) {
                            newGrid[i][j] = rnd.nextInt(15+1) + 45;
                            counter++;
                        } else if (j == 4) {
                            newGrid[i][j] = rnd.nextInt(15+1) + 60;
                            counter++;
                        } else{
                            newGrid[i][j]=grid[i][i];
                            counter++;
                        }

                }

                }
                if (grid[i][j]==0){
                    System.out.print("\t");
                } else{
                    System.out.print(newGrid[i][j] +"\t");
                }

            }
        }
    }


}



