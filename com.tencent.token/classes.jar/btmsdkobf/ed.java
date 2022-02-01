package btmsdkobf;

import android.content.Context;

public class ed
{
  public static int K(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    if ((!paramString.startsWith("46000")) && (!paramString.startsWith("46002")) && (!paramString.startsWith("46007")))
    {
      if (paramString.startsWith("46001")) {
        return 1;
      }
      if (paramString.startsWith("46003")) {
        return 2;
      }
      return -1;
    }
    return 0;
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return K(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ed
 * JD-Core Version:    0.7.0.1
 */