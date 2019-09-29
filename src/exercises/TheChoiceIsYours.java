package exercises;

public class TheChoiceIsYours {
	private boolean blackSheep;

	public static void main(String[] args) {
		TheChoiceIsYours choice = new TheChoiceIsYours();

		// 1. Condense the if statement for the first method
		choice.blackSheep = false;
		System.out.println("1: should be false: " + choice.condenseIfStatement());
		choice.blackSheep = true;
		System.out.println("1: should be true: " + choice.condenseIfStatement());

		// 2. Change method 2 to use a ternary operator
		choice.blackSheep = false;
		System.out.println("2: should be that: " + choice.useTernaryOperator());
		choice.blackSheep = true;
		System.out.println("2: should be this: " + choice.useTernaryOperator());
	}

	boolean condenseIfStatement() {
		return blackSheep;
	}

	String useTernaryOperator() {
		return blackSheep ? "this" : "that";
	}

}
