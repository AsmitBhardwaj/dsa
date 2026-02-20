/**
 * @author bharas01
 * 
 */ 
public class Entry<K,V>{
    //initalizing key
    public K key;
    //initializing value
    public V value;
    
    /**
     * constructs a new entry with the given key and value
     * 
     * @param key key 
     * @param value value
     */ 
    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }
    
    /**
     * returns a string representation of this entry like key:Value
     * 
     * 
     * @return str string representation of the entry
     */
    public String toString(){
        return key + ":" + value;
    }
}