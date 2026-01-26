import java.util.*;

class MinAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        //first we will sort the list so that we can find the minimum abs difference
        //scan numbers next to each other to find the minimum difference 
        //scan again to collect all pairs with that difference
        Arrays.sort(arr);

        //make a new list for the result
        List<List<Integer>> res = new ArrayList<>();

        //initialize minimum difference
        int minDiff = Integer.MAX_VALUE;

        //find minimum difference
        for(int i = 1; i < arr.length; i++){
            int currDiff = arr[i] - arr[i-1];
            minDiff = Math.min(currDiff, minDiff);
        }

        //now we will collect pairs with the minimum difference
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i-1] == minDiff){
                res.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }

        return res;



    }
}