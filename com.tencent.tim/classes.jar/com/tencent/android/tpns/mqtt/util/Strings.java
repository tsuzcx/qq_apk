package com.tencent.android.tpns.mqtt.util;

public final class Strings
{
  private static final int INDEX_NOT_FOUND = -1;
  
  public static boolean containsAny(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence2 == null) {
      return false;
    }
    return containsAny(paramCharSequence1, toCharArray(paramCharSequence2));
  }
  
  public static boolean containsAny(CharSequence paramCharSequence, char[] paramArrayOfChar)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((isEmpty(paramCharSequence)) || (isEmpty(paramArrayOfChar)))
    {
      bool1 = false;
      return bool1;
    }
    int k = paramCharSequence.length();
    int m = paramArrayOfChar.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label139;
      }
      char c = paramCharSequence.charAt(i);
      int j = 0;
      for (;;)
      {
        if (j >= m) {
          break label132;
        }
        if (paramArrayOfChar[j] == c)
        {
          bool1 = bool2;
          if (!Character.isHighSurrogate(c)) {
            break;
          }
          bool1 = bool2;
          if (j == m - 1) {
            break;
          }
          if (i < k - 1)
          {
            bool1 = bool2;
            if (paramArrayOfChar[(j + 1)] == paramCharSequence.charAt(i + 1)) {
              break;
            }
          }
        }
        j += 1;
      }
      label132:
      i += 1;
    }
    label139:
    return false;
  }
  
  public static int countMatches(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int j = 0;
    if ((isEmpty(paramCharSequence1)) || (isEmpty(paramCharSequence2)))
    {
      j = 0;
      return j;
    }
    int i = 0;
    for (;;)
    {
      int k = indexOf(paramCharSequence1, paramCharSequence2, j);
      j = i;
      if (k == -1) {
        break;
      }
      i += 1;
      j = k + paramCharSequence2.length();
    }
  }
  
  public static boolean equalsAny(CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence)
  {
    boolean bool1;
    if (paramCharSequence == null) {
      if (paramArrayOfCharSequence == null) {
        bool1 = true;
      }
    }
    for (;;)
    {
      label16:
      boolean bool2;
      if (paramArrayOfCharSequence != null)
      {
        int i = 0;
        bool2 = bool1;
        if (i < paramArrayOfCharSequence.length)
        {
          if ((bool1) || (paramArrayOfCharSequence[i].equals(paramCharSequence))) {}
          for (bool1 = true;; bool1 = false)
          {
            i += 1;
            break label16;
            bool1 = false;
            break;
          }
        }
      }
      else
      {
        bool2 = bool1;
      }
      return bool2;
      bool1 = false;
    }
  }
  
  private static int indexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    return paramCharSequence1.toString().indexOf(paramCharSequence2.toString(), paramInt);
  }
  
  public static boolean isEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  private static boolean isEmpty(char[] paramArrayOfChar)
  {
    return (paramArrayOfChar == null) || (paramArrayOfChar.length == 0);
  }
  
  private static char[] toCharArray(CharSequence paramCharSequence)
  {
    Object localObject;
    if ((paramCharSequence instanceof String))
    {
      localObject = ((String)paramCharSequence).toCharArray();
      return localObject;
    }
    int j = paramCharSequence.length();
    char[] arrayOfChar = new char[paramCharSequence.length()];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfChar;
      if (i >= j) {
        break;
      }
      arrayOfChar[i] = paramCharSequence.charAt(i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.util.Strings
 * JD-Core Version:    0.7.0.1
 */