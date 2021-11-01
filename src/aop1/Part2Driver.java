package aop1;
import java.util.Scanner;

public class Part2Driver {
    static TicTacToe game = new TicTacToe();
    static boolean isgameover=false;

	 public static void main(String[] args)
	    {
	      Part2Driver p2driver=new Part2Driver();
	      p2driver.Main();
	    }
	public void iterationdone() {
		
	}
	
	public void Main() {
		  Scanner scan = new Scanner(System.in);
	        game.SetupBoard();
	        System.out.println("Tic-Tac-Toe!");
	        do
	        {
	            System.out.println("Board position:");
	            game.DisplayBoardCondition();
	            int row;
	            int col;
	            do
	            {
	                System.out.println("Player " + game.getmark() + ", enter an empty row then enter a column to place your mark!");
	                row = scan.nextInt()-1;
	                col = scan.nextInt()-1;
	            }
	            while (!game.markposition(row, col));
	            game.changeturn();
	            iterationdone();
	        }
	        while(isgameover==false);
	      
	}
   
}
