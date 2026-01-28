class isPalindrome{
    public boolean Palindrome(String s) {
        
        //conver the string to lowercase
        s = s.toLowerCase();
        //remove all the spaces
        s = s.replaceAll("\\s", "");
        //remove all the commans, other signs etc
        s = s.replaceAll("[^a-z0-9]", "");

        //create a new string builder which will store the reversed string
        StringBuilder str = new StringBuilder();

        //reverse the s using a for loop
        //add the letters in the string builder
        for(int i = s.length() - 1; i >= 0; i--){
            str.append(s.charAt(i));
        }

        if(str.toString().equals(s)){
            return true;
        }else{
            return false;
        }




    }
}