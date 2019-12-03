package laboration5;

import java.util.Scanner;
public class WordQuiz {
private Scanner input = new Scanner(System.in);
	
	public WordQuiz(Dictionary dictionary) {
		
	}
	
	public void runQuiz() {
		System.out.println("Första ordet är:");
	}
	
	private static int showMenu() {
		System.out.println("1. Add Word");
		System.out.println("2. Play Swedish to English");
		System.out.println("3. Play English to Swedish");
		System.out.println("4. Quit");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		input.close();
		return choice;

	}

	public static void main(String[] args) {
// Skapa en tom ordlista på ngt sätt och fyll den med ord. Dictionary
		
		Dictionary sweng = new Dictionary();
		sweng.add("hej", "hello");
		sweng.add("hej", "hi");
		sweng.add("hej", "hey");
		sweng.add("godnatt", "good night");
		sweng.add("nattinatti", "good night");
		sweng.add("fågel", "bird");
		sweng.add("hund", "dog");
		sweng.add("katt", "cat");
		WordQuiz quiz = new WordQuiz(sweng);
		quiz.runQuiz();
		
		System.out.println("Welcome To My Wordquiz");
		System.out.println("======================");
		System.out.println("Select one of the following:");
		
		Scanner input = new Scanner(System.in);
		
		int result = 0;

		while (result != 4) {
			result = showMenu();
			switch(result){
				case 1:
					String t = "";
					String m = "";
					
					System.out.println("Type your word in swedish");
					t = input.nextLine();
					
					System.out.println("Type your word in english");
					m = input.nextLine();
					
					sweng.add(t,m);
					break;
					
				case 2:
					
					break;
				case 3:
					
					break;
					
				case 4:
					System.out.println("Goodbye!");
					break;
					
				default:
					
					break;
			}
		}
}
}