/**
 * Implementation of a String wrapper to be used for testing
 * the Hash Table. Changes the default hash code implementation. 
 */

public class MyString
{
    /**
     * the string representative
     */
    private String str;

    /**
     * Creates a new string wrapper based on the given string.
     *
     * @param s   the string representative
     */
    public MyString(String s)
    {
        str = s;
    }

    /**
     * Returns a hash code for this string:
     * - if the string starts with a digit, the digit's multiple of 10
     *   is added to the length of the string (ignoring the digit)
     * - otherwise the length of the string is returned
     *
     * For example: "cat"=3, "1cat"=13, "2cat"=23, ..., "9cat"=93
     *
     * @return a hash code for this string
     */
    @Override
    public int hashCode()
    {
        char firstChar = str.charAt(0);
        if (Character.isDigit(firstChar)) {
            int value = Character.getNumericValue(firstChar);
            return  10*value + (str.length() - 1);
        }
        else {
            return str.length();
        }
    }

    /**
     * Returns a string representation of this string.
     *
     * @return a string representation of this string
     */
    @Override
    public String toString()
    {
        return str;
    }

    /**
     * Checks if the given object is equal to this string wrapper.
     *
     * @param other   the object to compare with
     * @return true if the given object is equal to this string wrapper
     */
    @Override
    public boolean equals(Object other)
    {
        if (other == this) {
            return true;
        }
        else if ( !(other instanceof MyString) ) {
            return false;
        }
        else {
            MyString otherStr = (MyString) other;
            return this.str.equals(otherStr.str);
        }
    }
}
