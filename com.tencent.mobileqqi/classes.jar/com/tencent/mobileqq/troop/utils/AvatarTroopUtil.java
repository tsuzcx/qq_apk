package com.tencent.mobileqq.troop.utils;

public class AvatarTroopUtil
{
  public static final int a = 100;
  public static final String a = "http://p.qlogo.cn/gh/dir/file/";
  public static final int b = 640;
  protected static String b = "http://p.qlogo.cn/gh/";
  public static final int c = 0;
  public static final int d = 0;
  public static final int e = 1;
  
  public static String a(String paramString)
  {
    if (a(paramString)) {
      return paramString + 100;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    String str = "http://p.qlogo.cn/gh/dir/file/";
    if (1 == paramInt) {
      paramString1 = "http://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2 + "_" + paramString1);
    }
    do
    {
      return paramString1;
      paramString1 = str;
    } while (paramInt != 0);
    return "http://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith(b);
  }
  
  public static String b(String paramString)
  {
    if (a(paramString)) {
      return paramString + 0;
    }
    return null;
  }
  
  public static boolean b(String paramString)
  {
    int i = paramString.length();
    char c1;
    do
    {
      int j;
      do
      {
        do
        {
          j = i - 1;
          if (j < 0) {
            break;
          }
          c1 = paramString.charAt(j);
          i = j;
        } while (c1 == '-');
        i = j;
      } while (c1 == '+');
      i = j;
    } while (Character.isDigit(c1));
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AvatarTroopUtil
 * JD-Core Version:    0.7.0.1
 */