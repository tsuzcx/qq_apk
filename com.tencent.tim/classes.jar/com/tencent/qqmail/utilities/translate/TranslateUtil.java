package com.tencent.qqmail.utilities.translate;

import com.tencent.qqmail.utilities.log.QMLog;

public class TranslateUtil
{
  private static final String TAG = "TranslateUtil";
  
  public static String filterPlainText(String paramString)
  {
    return paramString.replaceAll("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,5}", "").replaceAll("[a-zA-z]+://[^\\s]*", "").replaceAll("[-<>.,:：+=]", "").replaceAll("[0-9]", "").replaceAll("[\n\t\r]", "").replaceAll(" +", "");
  }
  
  private static boolean inRange(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt2 <= paramInt1) && (paramInt1 <= paramInt3);
  }
  
  private static boolean isDeOrFr(int paramInt)
  {
    return inRange(paramInt, 192, 255);
  }
  
  private static boolean isEn(int paramInt)
  {
    return (inRange(paramInt, 65, 90)) || (inRange(paramInt, 97, 122));
  }
  
  public static boolean isFroeignLanguageSupport(String paramString)
    throws Throwable
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    int i = 0;
    int j = 0;
    int m = 0;
    if (i < paramString.length())
    {
      int i1 = paramString.charAt(i);
      int k;
      if (i1 == 32) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        int n = m + 1;
        if ((!isDeOrFr(i1)) && (!isKo(i1)) && (!isEn(i1)))
        {
          k = j;
          m = n;
          if (!isJa(i1)) {}
        }
        else
        {
          k = j + 1;
          m = n;
        }
      }
    }
    float f = j / m;
    QMLog.log(4, "TranslateUtil", "foreignLanRate:" + f + ", cost: " + (System.currentTimeMillis() - l));
    if (f > 0.5D) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isJa(int paramInt)
  {
    return (inRange(paramInt, 12352, 12543)) || (inRange(paramInt, 12784, 12799));
  }
  
  private static boolean isKo(int paramInt)
  {
    return (inRange(paramInt, 4352, 4607)) || (inRange(paramInt, 12592, 12687)) || (inRange(paramInt, 44032, 55215));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.translate.TranslateUtil
 * JD-Core Version:    0.7.0.1
 */