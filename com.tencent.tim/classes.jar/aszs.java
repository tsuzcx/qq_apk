public class aszs
{
  public static String rm(String paramString)
  {
    String str = paramString;
    int i;
    if (sQ(paramString)) {
      i = paramString.length() - 1;
    }
    for (;;)
    {
      if ((i < 0) || (paramString.charAt(i) == '\\') || (paramString.charAt(i) == '/'))
      {
        str = paramString.substring(i + 1);
        return str;
      }
      i -= 1;
    }
  }
  
  public static boolean sQ(String paramString)
  {
    boolean bool2 = false;
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if ((paramString.charAt(i) == '\\') || (paramString.charAt(i) == '/')) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszs
 * JD-Core Version:    0.7.0.1
 */