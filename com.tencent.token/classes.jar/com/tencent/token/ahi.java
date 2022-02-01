package com.tencent.token;

public final class ahi
{
  public static final int a;
  
  static
  {
    String str = System.getProperty("java.version");
    int j = 0;
    try
    {
      localObject = str.split("[._]");
      i = Integer.parseInt(localObject[0]);
      if ((i == 1) && (localObject.length > 1))
      {
        i = Integer.parseInt(localObject[1]);
        break label52;
      }
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      Object localObject;
      int i;
      label50:
      label52:
      break label50;
    }
    i = -1;
    if (i == -1) {}
    try
    {
      localObject = new StringBuilder();
      i = j;
      while (i < str.length())
      {
        char c = str.charAt(i);
        if (!Character.isDigit(c)) {
          break;
        }
        ((StringBuilder)localObject).append(c);
        i += 1;
      }
      i = Integer.parseInt(((StringBuilder)localObject).toString());
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label115:
      break label115;
    }
    i = -1;
    j = i;
    if (i == -1) {
      j = 6;
    }
    a = j;
  }
  
  public static boolean a()
  {
    return a >= 9;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahi
 * JD-Core Version:    0.7.0.1
 */