package laboration5;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.Map.Entry;

public class Dictionary {
	
	Map<Word,Set<Word>> map = new HashMap<Word,Set<Word>>();
	
	public void add(Word t, Word m) {
		if(map.containsKey(t)) {
			Set<Word> nyttM = map.get(t);
			nyttM.add(m);
		}
		else {
			Set<Word> newSet = new HashSet<>();
			newSet.add(m);
			map.put(t, newSet);
		}
		
		System.out.println(map);
		
	}
	
	public void add(String t, String m) {
		add(new Word(t), new Word(m));
	}
	
	
	 // Returnerar en icke-null mängd med ordlistans alla termer.
	 
	public Set<Word> term() {
		return map.keySet();
	}
	
	
	 // Slår upp och returnerar en mängd av betydelser till t,
	 // eller null om t inte finns i ordlistan
	 
	
	public Set<Word> lookup(Word t) {
		return map.get(t);
	}
	 
	 // Skapar och returnerar en ny ordlista på det motsatta språket,
	 // dvs, alla betydelser blir termer och alla termer blir betydelser.
	 // T.ex en svensk-engelsk ordlist blir efter invertering engels-svensk.
	
	public Dictionary inverse() {
		Dictionary inverseDictionary = new Dictionary();
		
		for(Word term : map.keySet()) {
			
			if(map.get(term).size() > 1) {
				Object[] english = map.get(term).toArray();
				
				for(int i = 0; i<map.get(term).size(); i++) {
					inverseDictionary.add((Word) english[i], term);
				}
				
			}else {
				Object[] english = map.get(term).toArray();
				inverseDictionary.add((Word) english[0], term);
			}
		}
		return inverseDictionary;
		
	}
	
	/* 
	 * Läser in orden från den givna strömmen och lägger dessa i ordlistan.
	 */
	
	public void load(InputStream is) {
	}
	
	/* 
	 * Lagrar ordlistan på den givna strömmen.
	 */
	
	public void save(OutputStream os) {
	}
	
	
}