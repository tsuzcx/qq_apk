package com.tencent.mm.platformtools;

import java.io.UnsupportedEncodingException;

public class SpellMap
{
  private static int a(char paramChar)
  {
    if (paramChar <= '') {
      return paramChar;
    }
    int j = 0;
    try
    {
      byte[] arrayOfByte = String.valueOf(paramChar).getBytes("GBK");
      int i = j;
      if (arrayOfByte != null)
      {
        i = j;
        if (arrayOfByte.length <= 2)
        {
          if (arrayOfByte.length <= 0) {
            return 0;
          }
          if (arrayOfByte.length == 1) {
            return arrayOfByte[0];
          }
          i = j;
          if (arrayOfByte.length == 2) {
            i = (arrayOfByte[0] + 256 << 16) + (arrayOfByte[1] + 256);
          }
        }
      }
      return i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return 0;
  }
  
  public static String getSpell(char paramChar)
  {
    int j = a(paramChar);
    if (j < 65536) {
      return String.valueOf(paramChar);
    }
    int i = j >> 16;
    j &= 0xFF;
    String str1;
    if ((i >= 129) && (i <= 253) && (j >= 63) && (j <= 254)) {
      str1 = spellGetJni(i - 129, j - 63);
    } else {
      str1 = null;
    }
    if (str1 == null) {
      return null;
    }
    String[] arrayOfString = str1.split(",");
    String str2 = str1;
    if (arrayOfString != null)
    {
      if (arrayOfString.length < 2) {
        return str1;
      }
      str2 = arrayOfString[0];
    }
    return str2;
  }
  
  public static native String spellGetJni(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.SpellMap
 * JD-Core Version:    0.7.0.1
 */