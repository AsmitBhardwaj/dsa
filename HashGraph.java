import java.util.HashMap;

public class HashGraph {
    
    public static void main(String[] args) {
   
         //we will create a hashmap for employee with their ids
         HashMap<String, Integer> empIds = new HashMap<>();

         empIds.put("Asmit", 1234);
         empIds.put("Evylen", 2323);
         empIds.put("Karan", 23413);

         System.out.println(empIds);

         System.out.println(empIds.get("Evylen"));

         System.out.println(empIds.containsKey("Asmit"));
         System.out.println(empIds.containsKey("Dodo"));

         System.out.println(empIds.containsValue(1234));
         System.out.println(empIds.containsValue(23232));

         empIds.replace("Asmit", 60906);
         System.out.println(empIds);
    }
}
