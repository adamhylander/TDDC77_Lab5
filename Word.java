package laboration5;

public class Word{
	
	/* 
	 * Skapar ett nytt ord med den givna texten.
	 */
	String text;
	public Word(String text) {
		this.text = text;
	}
	
	/* 
	 * Jämför detta ord med det specifierade objektet. Resultatet 
	 * är true om och endast om obj också är ett ord (Word) 
	 * och har samma text.
 	 */
	 
	public boolean equals(Object obj) {
		if(!(obj instanceof Word)) {
			return false;
		}
		Word objWord = (Word) obj;
		if(this.text.equals(objWord.text)) {
			return true;
		}
			return false;
		//return false;
		//return this.text.equals(objWord.text);
	}
	
	/* 
	 * Returnerar hashkoden för detta ord beräknat på ordets text.
	 */
	
	public int hashCode() {
		return text.hashCode();
	}
	
	/* 
	 * Returnerar texten för detta ord
	 */
	public String toString() {
		return text;
	}
	
	
	
}