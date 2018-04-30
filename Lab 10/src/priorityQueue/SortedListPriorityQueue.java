package priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

import priorityQueueInterfaces.Entry;

/**
 * Implementation of a PriorityQueue based in an ArrayList<Entry<K, V>>.
 * @author pedroirivera-vega
 *
 * @param <K>
 * @param <V>
 */
public class SortedListPriorityQueue<K, V> extends AbstractListPriorityQueue<K, V> {
	public SortedListPriorityQueue(Comparator<K> cmp) { 
		super(cmp);
	}
	
	public SortedListPriorityQueue() { 
		super(); 
	}
	

	@Override
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
		//if(this.size()<1)return null;
		super.validate(key);
		if(list.size()==0){
			Entry<K,V> newest = new PQEntry<K,V>(key, value);
			list.add(newest);
			return newest;
		}
		else{
		Entry<K,V> newest = new PQEntry<K,V>(key, value);
		int curr = list.size()-1; 
		while (curr >= 0  && compare(list.get(curr), newest) > 0)
			curr--; 
		list.add(curr, newest); 
		return newest; 
		}
	}

	@Override
	protected int minEntryIndex() {
		return 0;
	}

}
