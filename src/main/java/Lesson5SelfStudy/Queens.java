package Lesson5SelfStudy;

import java.util.ArrayList;
import java.util.List;

public class Queens {
    public static void main(String[] args) {
//        int[][] chessBoard = generateEmptyChessGame();
//        print(chessBoard);
//
//        List<int[][]> baseCaseSols = generateBaseCaseSolutions();
//
//        printAll(baseCaseSols);

        List<int[][]> sols = generateSolutions(7);
        printAll(sols);

    }




    private static void printAll(List<int[][]> sols) {

        for (int i = 0; i < sols.size(); i++) {
            System.out.println("Solution " + (i+1));
            print(sols.get(i));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();

        }
    }

    private static List<int[][]> generateSolutions(int untilRow) {
        if (untilRow ==0){
            return generateBaseCaseSolutions();
        }

        List<int[][]> subSolutions = generateSolutions(untilRow-1);

        List<int[][]> sols = new ArrayList<>();

        for (int[][] subSol: subSolutions) {
            for (int col = 0; col < 8; col++) {
                if (canPut(untilRow, col, subSol)){
                    int[][] sol = duplicate(subSol);

                    sol[untilRow][col] = 1;

                    sols.add(sol);

                }

            }
        }
        return sols;
    }

    private static int[][] duplicate(int[][] chessGame) {
        int[][] newChessGame = new int[chessGame.length][chessGame[0].length];
        for (int row = 0; row < chessGame.length; row++) {
            for (int col = 0; col < chessGame[row].length; col++) {
                newChessGame[row][col] = chessGame[row][col];
            }
        }
        return newChessGame;
    }

    private static boolean canPut(int row, int col, int[][] subSol) {
        for (int i = row - 1 ; i >= 0 ; i--) {
            if (subSol[i][col] == 1) {
                return false;

            }
        }
        for (int i = row - 1 , j = col -1 ; i >= 0 && j >= 0 ; i-- , j--) {
            if (subSol[i][j] == 1) {
                return false;

            }
        }
        for (int i = row - 1 , j = col + 1 ; i >= 0 && j < 8 ; i-- , j++) {
            if (subSol[i][j] == 1) {
                return false;
            }

        }
        return true;
    }




    private static List<int[][]> generateBaseCaseSolutions() {
    List<int[][]> sols = new ArrayList<>();

    for (int col = 0 ; col < 8 ; col++){
        int[][] chessGame = generateEmptyChessGame();
        chessGame[0][col] = 1;

        sols.add(chessGame);
    }

    return sols;
    }

    private static void print(int[][] chessGame) {
        for (int i = 0; i < chessGame.length; i++) {
            for (int j = 0; j < chessGame.length; j++) {
                System.out.print(chessGame[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] generateEmptyChessGame() {
        int[][] chessGame = new int[8][8];
        for (int i = 0; i < chessGame.length; i++) {
            for (int j = 0; j < chessGame.length; j++) {
                chessGame[i][j] = 0;
            }
        }
        return chessGame;
    }


}