import static org.junit.Assert.*;
import org.junit.Test;
/**
 * 
 * @author bharas01
 */
public class CHashMapTest{
    //shortcut for making MyString objects
    public static MyString ms(String str){
        return new MyString(str);
    }
    
    @Test
    public void testCHashMap(){
        CHashMap<MyString, Integer> map = new CHashMap<MyString, Integer>(6, 0.5);
        assertEquals(map.toString(), "0:[[] [] [] [] [] []]");
        
        //put jan
        assertTrue(map.put(ms("january"), 31) == null);
        assertEquals(map.toString(), "1:[[] [january:31] [] [] [] []]");
        
        //put march
        assertTrue(map.put(ms("march"), 31) == null);
        assertEquals(map.toString(), "2:[[] [january:31] [] [] [] [march:31]]");
        
        //put april(collision)
        assertTrue(map.put(ms("april"), 30) == null);
        assertEquals(map.toString(), "3:[[] [january:31] [] [] [] [march:31 april:30]]");
        
        //put another collision
        assertTrue(map.put(ms("asmit"), 67) == null);
        assertEquals(map.toString(), "4:[[] [january:31] [] [] [] [march:31 april:30 asmit:67]]");
        
        //put without collision
        assertTrue(map.put(ms("september"), 50) == null);
        assertEquals(map.toString(), "5:[[] [january:31] [] [september:50] [] [march:31 april:30 asmit:67]]");
        
        //update existing key
        assertTrue(map.put(ms("march"), 100) == 31);
        assertEquals(map.toString(), "5:[[] [january:31] [] [september:50] [] [march:100 april:30 asmit:67]]");
        
        //replace it with the original value again
        assertTrue(map.put(ms("march"), 31) == 100);
        assertEquals(map.toString(), "5:[[] [january:31] [] [september:50] [] [march:31 april:30 asmit:67]]");
        
        //get existing keys
        assertTrue(map.get(ms("september")) == 50);
        assertEquals(map.toString(), "5:[[] [january:31] [] [september:50] [] [march:31 april:30 asmit:67]]");
        
        //get missing key
        assertTrue(map.get(ms("johnmichael")) == null);
        assertEquals(map.toString(), "5:[[] [january:31] [] [september:50] [] [march:31 april:30 asmit:67]]");
        
        //check containsvalue that is there
        assertTrue(map.containsValue(31));
        assertEquals(map.toString(), "5:[[] [january:31] [] [september:50] [] [march:31 april:30 asmit:67]]");
                   
        //check containsvalue that is not there
        assertFalse(map.containsValue(100));
        assertEquals(map.toString(), "5:[[] [january:31] [] [september:50] [] [march:31 april:30 asmit:67]]");
                   
        //remove from bucket
        assertTrue(map.remove(ms("january")) == 31);
        assertEquals(map.toString(), "4:[[] [] [] [september:50] [] [march:31 april:30 asmit:67]]");
        
        //should return true since march 31 is still there
        assertTrue(map.containsValue(31));
        assertEquals(map.toString(), "4:[[] [] [] [september:50] [] [march:31 april:30 asmit:67]]");
        
        //remove from collision
        assertTrue(map.remove(ms("april")) == 30);
        assertEquals(map.toString(), "3:[[] [] [] [september:50] [] [march:31 asmit:67]]");
        
        //check if april is still there
        assertFalse(map.containsValue(30));
        assertEquals(map.toString(), "3:[[] [] [] [september:50] [] [march:31 asmit:67]]");
        
        //remove false
        assertTrue(map.remove(ms("aefefe")) == null);
        assertEquals(map.toString(), "3:[[] [] [] [september:50] [] [march:31 asmit:67]]");    
    }
}
