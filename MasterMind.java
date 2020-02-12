import java.util.Random;
import java.util.Scanner;


public class MasterMind {
	public static void main(String[] args) {
		Game game = new Game();
		game.setRandomCode();
		game.getInput();
		game.checkInput();
	}
}

class Game {
	private char[] theCode = new char[4];
	private char[] guessedCode = new char[4];
	private int guessCount;
	
	public void setRandomCode() {
		for (int i = 0; i < 4; i++) {
			Random r = new Random();
			char c = (char)(r.nextInt(26) + 'a');
			theCode[i] = c;
			System.out.print(theCode[i]);
			System.out.println("");
		}
	}
	
	public char[] getRandomCode() {
		return theCode;
	}
	
	public void getInput() {
		Scanner sc =  new Scanner(System.in);
		System.out.println("Gok de reeks");
		String input = sc.next();
		System.out.println(input);
		for (int i = 0; i < 4; i++) { 
			guessedCode[i] = input.charAt(i); 
			System.out.print(guessedCode[i]);
			System.out.println("");
        } 
	}
	
	public void checkInput() {
		int correctCount = 0;
		for (int i = 0; i < 4; i++) {
			if(theCode[i] == guessedCode[i]) {
				System.out.println("correct");
			}
		}
		
	}
	
}
