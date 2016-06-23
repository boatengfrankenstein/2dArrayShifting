import java.util.Arrays;
import java.util.Scanner;

public class Monk {
           int flag;
    public Monk(){
        this.flag  = 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int after[][] = {
                { 2, 2, 0, 0,},
                { 0, 0, 2, 4,},
                { 9, 0, 2,0,},
                { 2, 8, 4, 2,},
        };

        int temp[][];
       // temp = Left(after);
        Monk monkey = new Monk();
       // Left(after);
      //System.out.println("Array of "+after.length);
        printTable(monkey.moveDown(after));
    }
    public static void shiftLeft(int[][] table) {

        //int left = table[0][0];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length-1; j++) {

                  if( table[i][j] ==table[i+1][j ]) {
                      table[i][j] = table[i+1][j];
                      table[i+1][j] = 0;
                  }

            }
        }
    }


    public static void printTable(int[][] table) {

        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table.length; j++) {
                System.out.print(String.format("%4s",table[i][j]));
            }
            System.out.println();
        }
    }
    public static int[][] Left(int[][] grid){
        for(int y=0;y<grid.length;y++){
            for(int x=0;x>grid.length;x++){

                while(true){

                    //When two number match
                    if(grid[x][y]==grid[x][y-1]){
                        grid[x][y-1]=grid[x][y]+grid[x][y-1];
                        grid[x][y]=0;
                        break;
                    }
                    //isLineFull full=new isLineFull();
                    if(grid[x][y-1]==0){
                        grid[x][y-1]=grid[x][y];
                        grid[x][y]=0;
                    }

                    break;
                }


            }
        }

        return grid;
    }



    public int[][] shiftRight(int t[][]){
        flag=0;
       int temp[][] = new int[t.length][t.length];
        for(int i = 0; i< t.length; i++){
            for(int j = 1; j <t.length; j++){
                if(t[i][j]!=0){
                    while((t[i-1][j]!=0)){
                        temp[i-1][j]=t[i][j];
                        flag=1;
                    }
                }
            }
        }
        t= temp;
        return t;
    }



    private int[][] moveDown(int grid[][]){
        for(int i =0; i<grid.length; i++){
            for(int j= grid[0].length - 1 ; j>0; j--){
                if(grid[i][j] == grid[i][j-1] && grid[i][j] !=0){
                    grid[i][j] = 2 * grid[i][j];
                    //change the number
                    grid[i][j-1] =0;
                    //clear the one that is being moved
                    for(int k = j-1; k>0; k--){
                        grid[i][k] = grid[i][k-1];
                        //this is the case when you move number around except the most up
                        grid[i][k-1] = 0;
                    }
                }
            }
        }
        return grid;
    }



    private int[][] moveUp(int grid[][]){
        for(int i =0; i<grid.length; i++){
            for(int j=0 ; j>grid[0].length-1; j++){
                if(grid[i][j] == grid[i][j-1] && grid[i][j] !=0){
                    grid[i][j] = 2 * grid[i][j];
                    //change the number
                    grid[i][j-1] =0;
                    //clear the one that is being moved
                    for(int k = j-1; k>0; k--){
                        grid[i][k] = grid[i][k-1];
                        //this is the case when you move number around except the most up
                        grid[i][k-1] = 0;
                    }
                }
            }
        }
      return grid;
    }
}


