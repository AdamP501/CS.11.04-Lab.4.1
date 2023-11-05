public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str)
    {
        int open = 0;
        int closed = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '(')
            {
                open++;
            }
            else if(str.charAt(i) == ')')
            {
                closed++;
            }

            if (closed > open) //a closed parantheses appearing before an opened one means the order is wrong
            {
                return false;
            }
        }

        if (closed == open)
        {
            return true;
        }
        return false;
    }

    // 2. reverseInteger
    public static String reverseInteger(int num)
    {
        String result = "";
        String numStr = num + "";
        int numStr2 =  num;
        for (int i = 0; i < numStr.length(); i++)
        {
            int digit = numStr2%10;
            result = result + digit;
            numStr2 = numStr2/10;
        }

        return result;
    }

    // 3. encryptThis
    public static String encryptThis(String str)
    {
        String result = "";
        String[] words = str.split(" "); //split the string by spaces
        for (String word : words)
        {
            result = result + (int) word.charAt(0);

            if (word.length() > 2)
            {
                result = result + word.charAt(word.length()-1);
                for (int i = 2; i < word.length()-1; i++)
                {
                    result = result + word.charAt(i);
                }
                result = result + word.charAt(1);

            }

            else if (word.length() == 2)
            {
                result = result + word.charAt(1);
            }

            result = result + " ";
        }

        result = result.substring(0,result.length()-1); //get rid of the last space
        return result;
    }

    // 4. decipherThis
    public static String decipherThis(String str)
    {
        String result = "";
        String[] words = str.split(" ");

        for (String word : words)
        {
            //check how long the unicode is
            int unicodeLen = 0;
            for (int i = 0; i < word.length(); i++)
            {
                if (Character.isDigit(word.charAt(i)))
                {
                    unicodeLen++;
                }
            }

            int unicode = Integer.parseInt(word.substring(0,unicodeLen));
            result = result + (char) unicode;

            if (word.length() > unicodeLen + 1)
            {
                result = result + word.charAt(word.length()-1);
                for (int i = unicodeLen+1; i < word.length()-1; i++)
                {
                    result = result + word.charAt(i);
                }
                result = result + word.charAt(unicodeLen);
            }

            else if (word.length() == unicodeLen + 1)
            {
                result = result + word.charAt(unicodeLen);
            }

            result = result + " ";
        }
        result = result.substring(0,result.length()-1);
        return result;
    }


}