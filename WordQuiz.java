package laboration5;
import java.util.*;
import java.io.*;
public class WordQuiz {
	
	Dictionary dictionary;
	public WordQuiz(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	
	public void runQuiz() {
		Set<Word> keys = dictionary.terms();
		Scanner scan = new Scanner(System.in);
		List<Word> list = new ArrayList<>(keys);
		List<Word> rattList = new ArrayList<>();
		int ratt = 0;
		int fel = 0;
		int wordCount = 1;
		while(!(list.isEmpty())) {
			
			for(Word key : list) {
				System.out.println("Word " + wordCount + " is: " + key);
				Word value = new Word(scan.nextLine());
				
				if(dictionary.lookup(key).contains(value)) {
					System.out.println("Rätt!");
					ratt++;
					rattList.add(key);
				} else {
					System.out.println("Fel!");
					fel++;
				}	
				wordCount++;
			}
			for(Word key : rattList) {
				list.remove(key);
			}
			if (list.size() != 0) {
			System.out.println("Du hade " + fel + " fel, kör igen!");
			wordCount = 1;
			}
		}
		
		System.out.println("Du hade " + ratt + " rätt och " + fel + " Fel");
		
	}
	
	private static int showMenu() {
		System.out.println("1. Add Word");
		System.out.println("2. Play Swedish to English");
		System.out.println("3. Play English to Swedish");
		System.out.println("4. Quit");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		return choice;

	}
	
	public void menu() throws IOException, FileNotFoundException {
		System.out.println("Welcome To My Wordquiz");
		System.out.println("======================");
		System.out.println("Select one of the following:");
		
		Scanner scan = new Scanner(System.in);
		
		InputStream ordFil = new FileInputStream ("/Users/adam/eclipse-workspace/laboration5/src/laboration5/ord.txt");
		dictionary.load(ordFil);
		
		int a = 0;
		int i = 0;
		
		while (a != 4) {
			a = showMenu();
			switch(a){
				case 1:
					System.out.println("Write Svenska,Engelska");
					OutputStream spara = new FileOutputStream ("/Users/adam/eclipse-workspace/laboration5/src/laboration5/ord.txt");
					String line = scan.nextLine();
					String[] word = line.split(",");
					this.dictionary.add(word[0], word[1]);
					dictionary.save(spara);
					break;
					
				case 2:
					runQuiz();				
					break;
					
				case 3:
					dictionary = dictionary.inverse();
					runQuiz();
					dictionary = dictionary.inverse();	
					break;
					
				case 4:
					System.out.println("Goodbye!");
					System.exit(0);
					break;
					
				default:
					System.out.println("Skriv in ett nummer mellan 1-4 din sopa");
					break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
// Skapa en tom ordlista på ngt sätt och fyll den med ord. Dictionary
		
		Dictionary sweng = new Dictionary();
		WordQuiz wq = new WordQuiz(sweng);
		wq.menu();  
	}
}
