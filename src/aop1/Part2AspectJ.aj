package aop1;

import java.io.IOException;

public aspect Part2AspectJ {
	pointcut function() :
		call(void aop1.Part2Driver.iterationdone());
	before(): function() 
	{		
		if(aop1.Part2Driver.game.isPlayerWon() || aop1.Part2Driver.game.allSpaceFull()) {
		//check if game is ended
	        if (aop1.Part2Driver.game.allSpaceFull() && !aop1.Part2Driver.game.isPlayerWon())
	        {
	            System.out.println("It's a Tie!");
	        }
	        else
	        {
	            System.out.println("Current board layout:");
	            aop1.Part2Driver.game.DisplayBoardCondition();
	            aop1.Part2Driver.game.changeturn();
	            System.out.println(Character.toUpperCase(aop1.Part2Driver.game.getmark()) + " is the Winner!!!");
	        	aop1.Part2Driver.isgameover=true;

	        	
	        }
		}
		
	}
	
}
