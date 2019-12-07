package laboration5;
import java.io.*;
import java.util.*;

public class Dictionary {
	
	Map<Word,Set<Word>> map = new HashMap<Word,Set<Word>>();
	
	public void add(Word key, Word value) {
		if(map.containsKey(key)) {
			Set<Word> nyttM = map.get(key);
			nyttM.add(key);
		}
		else {
			Set<Word> newSet = new HashSet<>();
			newSet.add(value);
			map.put(key, newSet);
		}
		
	}
	
	public void add(String key, String value) {
		add(new Word(key), new Word(value));
	}
	
	
	 // Returnerar en icke-null mängd med ordlistans alla termer.
	 
	public Set<Word> terms() {
		return map.keySet();
	}
	
	
	 // Slår upp och returnerar en mängd av betydelser till t
	 
	
	public Set<Word> lookup(Word key) {
		return map.get(key);
	}
	
	public Dictionary inverse() {
		Dictionary inverseDictionary = new Dictionary();
		
		for(Word key : map.keySet()) {
			for (Word value : lookup(key)) {
			inverseDictionary.add(value, key);
			}
		}
		return inverseDictionary;
		
	}
	 
	public void load(InputStream is) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    while (reader.ready()) {
	    	String line = reader.readLine();
	        String[] words = line.split(",");
	        add(words[0],words[1]);  
	    }

	} 
	
	public void save(OutputStream os) throws IOException {
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os);
		for(Word key : map.keySet()) {
				for(Word value : map.get(key)) {
					outputStreamWriter.append(key + "," + value + "\n");
					
				}
		}

		outputStreamWriter.close();
	}
	
	
}