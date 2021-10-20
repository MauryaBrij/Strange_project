package TicTaeToe;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        char[] pos = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

        Scanner sc = new Scanner(System.in);
        int i=0;
        char turn='X';
        int position;

        while (true) {
            do {
                System.out.println("Please enter a positions:");
                position = sc.nextInt();
            }while(pos[position]=='X' || pos[position]=='O');
            pos[position] = turn;

            System.out.println(" " + pos[0] + " | " + pos[1] + " | " + pos[2] + " ");
            System.out.println("---+---+---");
            System.out.println(" " + pos[3] + " | " + pos[4] + " | " + pos[5] + " ");
            System.out.println("---+---+---");
            System.out.println(" " + pos[6] + " | " + pos[7] + " | " + pos[8] + " ");

            if((pos[0]==turn && pos[1]==turn && pos[2]==turn) ||
                    (pos[3]==turn && pos[4]==turn && pos[5]==turn) ||
                    (pos[6]==turn && pos[7]==turn && pos[8]==turn) ||
                    (pos[0]==turn && pos[3]==turn && pos[6]==turn) ||
                    (pos[1]==turn && pos[4]==turn && pos[7]==turn) ||
                    (pos[2]==turn && pos[5]==turn && pos[8]==turn) ||
                    (pos[0]==turn && pos[4]==turn && pos[8]==turn) ||
                    (pos[2]==turn && pos[4]==turn && pos[6]==turn)){
                System.out.println(turn +" won the game");
                break;
            }




            if(turn=='X') {
                turn = 'O';
            }
            else if(turn=='O') {
                turn = 'X';
            }
            i++;
        }
    }
}
