import java.util.Random;
import java.util.Scanner;


public class MasterMind {
	public static void main(String[] args) {
		Game game = new Game();
		game.setRandomCode();
		
		game.welcomeMessage();
		
		while (game.getMaxGuesses() > game.getGuessCount() && !game.getGuessedCorrect() && game.getGameRunning()) {
			game.getInput();
			if (game.getGameRunning()) {
				game.checkInput();
			}
		}
		
		if (game.getGuessCount() >= game.getMaxGuesses()) {
			System.out.println("\n\nJe hebt je maximaal aantal beurten gehad!");
			game.printRandomCode();
		} else if (game.getGuessedCorrect()) {
			System.out.println("\nGeweldig!");
		} else {
		game.printRandomCode();
		}
		
	}
}

class Game {
	private char[] theCode = new char[4];
	private char[] guessedCode = new char[4];
	private int MAX_GUESSES = 25;
	private int guessCount = 0;
	private int correctCount = 0;
	private boolean guessedCorrect = false;
	private boolean gameRunning = true;
	
	
	public int getMaxGuesses() {
		return MAX_GUESSES;
	}
	
	public int getGuessCount() {
		return guessCount;
	}
	
	public boolean getGuessedCorrect() {
		return guessedCorrect;
	}
	
	public boolean getGameRunning() {
		return gameRunning;
	}
	
	public void setRandomCode() {
		for (int i = 0; i < theCode.length; i++) {
			Random r = new Random();
			char c = (char)(r.nextInt(26) + 'a');
			theCode[i] = c;
		}
	}
	
	public void printRandomCode() {
		System.out.println("\n\nThe code was: ");
		for (char character : theCode) {
			System.out.print(character);
		}
	}
	
	public void getInput() {
		Scanner sc =  new Scanner(System.in);
		
		System.out.println("\nGok de reeks");
		String input = sc.next();
		if (input.contentEquals("STOP")) {
			gameRunning = false;
			System.out.print("YOUR A QUITTER");
		} else {
			for (int i = 0; i < theCode.length; i++) {
				try {
					guessedCode[i] = input.charAt(i); 
				}
				catch (Exception e) {
					
				}
	        } 
			if (theCode.length > guessedCode.length) {
				System.out.println("Probeer de volgende keer een reeks van 4 karakters in te voeren");
			}
			
		}
		guessCount++;			
	}
	
	public void checkInput() {
		correctCount = 0;
		for (int i = 0; i < theCode.length; i++) {
			if(theCode[i] == guessedCode[i]) {
				correctCount++;
			}
		}
		if (correctCount == (theCode.length - 1)) {
			System.out.println("Aantal goed gegokt: " + correctCount + "Je bent er bijna!");
			System.out.println("Slechts " + (theCode.length - correctCount) + " nodig om te winnen");
		} else if (correctCount == theCode.length){
			System.out.println("Aantal goed gegokt: " + correctCount);
			System.out.println("JE HEBT GEWONNEN!");
			guessedCorrect = true;
		} else {
			System.out.println("Aantal goed gegokt: " + correctCount);
			System.out.println("Je hebt nog " + (theCode.length - correctCount) + " nodig om te winnen");
		}
		
	}
	
	public void welcomeMessage() {
		System.out.println("#############################");
		System.out.println("welkom bij MAsterMind");
		System.out.println("raad de code van 4 karakters!");
		System.out.println("typ STOP om te stoppen");
		System.out.println("#############################");
		System.out.println("");
	}
	
}
