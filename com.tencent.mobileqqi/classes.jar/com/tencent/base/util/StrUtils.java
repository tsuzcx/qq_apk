package com.tencent.base.util;

public class StrUtils
{
  public static final String EMPTY = "";
  public static final String NOT_AVALIBLE = "N/A";
  
  public static boolean isTextEmpty(String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() >= 1) {
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.base.util.StrUtils
 * JD-Core Version:    0.7.0.1
 */