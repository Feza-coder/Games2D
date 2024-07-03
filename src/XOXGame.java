package Game2D;

import java.awt.*;
import java.util.*;
public class XOXGame {
    public static void main(String[] args) {
        XOGameClass Game = new XOGameClass();
        Game.StartGame();
        Game.StartGame();
    }
}

class XOGameClass{
    static int GameCount=0;
    private int x;
    private int y;
    private int WinCount=3;
    private boolean GameOver;
    public  XOGameClass(){

    }
    public void StartGame() {
        GameCount++;
        System.out.println("Game no :" + GameCount);
        String player1, player2;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter player 1 name ");
        player1 = input.nextLine();
        System.out.print("Enter player 2 name ");
        player2 = input.nextLine();
        char[][] board = new char[3][3];
        printBoard(board);
        int round = 0;
        while (true) {
            String currentPlayer = (round % 2 == 0) ? player1 : player2;
            System.out.println(currentPlayer+ " Turn");
            PlayerInput(board,currentPlayer,input);
            updateBoard(board, x, y, currentPlayer.equals(player1) ? 'X': 'O');
            round += 1;
            CheckWinning(board);
            if(GameOver) {
                System.out.println("Game Over, player " + currentPlayer + " Won" );
                break;
            }
            if(GameIsDraw(board)){
                System.out.println("Game is Draw, no winners");
                break;
            }
        }
        //reset
        GameOver=false;
        board = new char[3][3];
    }

    void printBoard(char[][] board){
        System.out.println("\n-------------------------");
        for(int i=0; i<board.length; i++){
            System.out.print('|');
            for(int j=0; j<board[i].length; j++){
                System.out.print("\t" + board[i][j] + "\t|");
            }
            System.out.println("\n-------------------------");
        }
    }

    void updateBoard(char[][] board, int x, int y, char symbol){
        board[x][y] = symbol;
        printBoard(board);
    }

    void PlayerInput(char[][] board,String currentPlayer, Scanner input){
        try {
            System.out.print(currentPlayer+ ", enter x location : ");
            x = input.nextInt()-1;
            System.out.print(currentPlayer+ ", enter y location : ");
            y = input.nextInt()-1;
            if(board[x][y] == 'X' || board[x][y] == 'O'){
                throw new Exception("cant, try again");
            }
        }
        catch(Exception e) {
            System.err.println(e.toString());
            System.out.println();
            PlayerInput(board,currentPlayer,input);
        }
    }
    void CheckWinning(char[][] board){
        //1
        for (int k = 0; k < board.length; k++) {
            for (int m = 0; m < board[k].length; m++) {

                for (int j = 0; j < 4; j++) {
                    switch (j) {
                        case 0:
                            boolean SequenceBroke = false;
                            for (int i = 1; i < WinCount; i++) {
//                                    System.out.println("looooop ---- " + i);
                                char Symbol = board[k][m] == 'X' || board[k][m] == 'O'? board[k][m]:'.';
                                if(ValidIndex(board,m+i,k)){
                                    if(Symbol != board[k][m+i]){
                                        SequenceBroke=true;
                                    }
                                }
                                else{
                                    SequenceBroke=true;
                                }
                            }
                            if(SequenceBroke == false){
                                System.out.println("Match");
                                GameOver = true;
                                break;
                            }
                            break;
                        case 1:
                            SequenceBroke = false;
                            for (int i = 1; i < WinCount; i++) {
                                char Symbol = board[k][m] == 'X' || board[k][m] == 'O'? board[k][m]:'.';
                                if(ValidIndex(board,m+i,k+i)){
                                    if(Symbol != board[k+i][m+i]){
                                        SequenceBroke=true;
                                    }
                                }
                                else{
                                    SequenceBroke=true;
                                }
                            }
                            if(SequenceBroke == false){
                                System.out.println("Match");
                                GameOver = true;
                                break;
                            }
                            break;
                        case 2:
                            SequenceBroke = false;
                            for (int i = 1; i < WinCount; i++) {
                                char Symbol = board[k][m] == 'X' || board[k][m] == 'O'? board[k][m]:'.';
                                if(ValidIndex(board,m-i,k+i)){
                                    if(Symbol != board[k+i][m-i]){
                                        SequenceBroke=true;
                                    }
                                }
                                else{
                                    SequenceBroke=true;
                                }
                            }
                            if(SequenceBroke == false){
                                System.out.println("Match");
                                GameOver = true;
                                break;
                            }
                            break;
                        case 3:
                            SequenceBroke = false;
                            for (int i = 1; i < WinCount; i++) {
                                char Symbol = board[k][m] == 'X' || board[k][m] == 'O'? board[k][m]:'.';
                                if(ValidIndex(board,m,k+i)){
                                    if(Symbol != board[k+i][m]){
                                        SequenceBroke=true;
                                    }
                                }
                                else{
                                    SequenceBroke=true;
                                }
                            }
                            if(SequenceBroke == false){
                                System.out.println("Match");
                                GameOver = true;
                                break;
                            }
                            break;
                        default:
                            break;
                    }

                }
            }
        }
    }

    boolean FullBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return  true;
    }

    boolean GameIsDraw(char[][] board){
        if(FullBoard(board) && !GameOver){
            return  true;
        }
        return false;
    }
    boolean ValidIndex(char[][] array, int row, int col) {
        if (array == null) {
            return false;
        }
        if (row < 0 || row >= array.length) {
            return false;
        }
        if (col < 0 || col >= array[row].length) {
            return false;
        }
        return true;
    }
}