import java.util.Arrays;

public class axvo
{
  public static String cWo = "[a-zA-Z0-9\\u4e00-\\u9fa5]";
  private static final int[] oX = { 0, 64, 91, 96, 123, 8543, 8576, 12295, 19967, 40870, 65295, 65306, 65312, 65339, 65344, 65371, 2147483647 };
  
  public static int f(char paramChar)
  {
    if (k(paramChar)) {
      return 3;
    }
    switch (Arrays.binarySearch(oX, paramChar))
    {
    default: 
      if (Character.isHighSurrogate(paramChar)) {
        return 2;
      }
      break;
    case -16: 
    case -14: 
    case -12: 
    case -10: 
    case -7: 
    case -5: 
    case -3: 
    case 5: 
      return 0;
    }
    return 1;
  }
  
  public static int gn(String paramString)
  {
    return Character.codePointCount(paramString, 0, paramString.length());
  }
  
  private static boolean k(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvo
 * JD-Core Version:    0.7.0.1
 */