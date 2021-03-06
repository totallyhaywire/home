package main;

import java.util.ArrayList;
import java.util.List;

import Objects.Attempt;
import Objects.Colour;
import Objects.Game;
import Objects.Attempt;
import io.Input;
import services.AI;

public class RunProgram {
	
	public static void main(String[] args){
		runProgram();
	}
	
	public static void runProgram(){
		Game game = new Game();
		AI ai = new AI(game);
		
		ai.firstGuess();
		while(!game.isComplete()){
			Attempt attempt = new Attempt(ai.nextGuess());
			outputGuess(attempt.getCombination());
			Input.inputScore(attempt);
		}
		outputGameWon(game.getAttemptRecord().size());	
	}
	
	public static void printCombination(List<Colour> combination){
		for(Colour colour: combination){
			System.out.println(colour + ", ");
		}
	}
	
	public static void outputGuess(List<Colour> combination){
		printCombination(combination);
	}
	
	public static void outputGameWon(int goes){
		System.out.println("Game won! Combination guessed in "+goes+" goes");
	}
}
