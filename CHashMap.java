import java.util.LinkedList;
import java.util.Iterator;
/**
 * 
 * @author bharas01
 * 
 */ 
public class CHashMap<K, V>{
    //Each bucket in the table is a linkedlist of Entry<K,V> since its chaining 
    private LinkedList<Entry<K, V>>[] table;
    
    //number of entries stored in the map
    private int size;
    
    //load factor of the hashmap
    private double loadFactor;
    
    /**
     * constructs an empty chaining hash map with the given initial capacity and load factor
     * 
     * @param iniitialCapacity number of bucekts in the hashmap
     * @param loadFactor load factor
     */
    public CHashMap(int initialCapacity, double loadFactor){ 
        this.loadFactor = loadFactor;
        //initialize 0 size
        size = 0;
    
        //we will create the array of linked lists
        table = (LinkedList<Entry<K, V>>[]) new LinkedList[initialCapacity];
    
        //we will add each bucket with an empty linked list
        for(int i = 0; i < initialCapacity; i++){
            table[i] = new LinkedList<>();
        }
    }
    
    /**
     * this method will figure out the index of the given key using hashcode
     * 
     * @param key key given by user
     * @return index index of the given key
     */ 
    private int index(K key){
        //returns the index number associated with the keys which is remainder of number of letters in the word divided by length of table
        return Math.abs(key.hashCode() % table.length);
    }
    
    /**
     * puts a key and value to the map
     * 
     * @param key the key value to insert
     * @param value the value to associate with the key
     * @return old value of the key or null
     */
    public V put(K key, V value){
        //we will find the index where the value should be added
        int i = index(key);
        
        //we will search bucket's list at that index for the given key
        for(Entry<K,V> entry : table[i]){
            if(entry.key.equals(key)){
                //if we find the key we save the old data
                V oldValue = entry.value;
                //we replace it with the given key
                entry.value = value;
                return oldValue;
            }
        }
        //if key not found we add new entry to the bucket
        table[i].add(new Entry<>(key, value));
        //update the size
        size++;
        return null;
    }
    
    /**
     * this method returns the value of the given key
     * 
     * @param key key to find given by the user
     * @return value of the given key else null if key not found
     */
    public V get(K key){
        //find the index associated with the key
        int i = index(key);
        
        //search the bucket's list for the matching key
        for(Entry<K,V> entry : table[i]){
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        //if key was not found we return null
        return null;
    }
    
    /**
     * this method removes the entry with the given key
     * 
     * @param key key given by the user to remove from the map
     * @return value that was removed or null if key not found
     */
    public V remove(K key){
        //we find the index of the key 
        int i = index(key);
        
        //we will use an iterator to call iterator.remove()
        //call the iterator
        Iterator<Entry<K, V>> iter = table[i].iterator();
        while(iter.hasNext()){
            Entry<K, V> entry = iter.next();
            //if we find the key
            if(entry.key.equals(key)){
                iter.remove();
                //update size
                size--;
                return entry.value;
            }
        }
        //if key not found return null
        return null;
    }
    
    /**
     * this method determines if the map contains the given value
     * 
     * @param Value value that we check if it exists in the map
     * @return true if it does else false
     */
    public boolean containsValue(V value){
        //we will iterate through each bucket and then iterate through each entry in each bucket
        for(LinkedList<Entry<K, V>> list : table){
            for(Entry<K,V> entry : list){
                if(entry.value.equals(value)){
                    return true;
                }
            }
        }
        //if value not found
        return false; 
    }
    
    /**
     * 
     * this method will return a string representation of the hash map
     * 
     * @return string representation of the hash map
     */
    public String toString(){
        String str = size + ":[";
        
        //add each buckets' string into the string
        for(LinkedList<Entry<K, V>> list : table){
            //we will add the string rep of bucket, the linked list and space in between
            str = str + list + " ";
        }
        //close the bracket
        str = str.trim() + "]";
        //replace the commas of the linked list
        str = str.replaceAll(",", "");
        //return the final string
        return str;
    }    
}