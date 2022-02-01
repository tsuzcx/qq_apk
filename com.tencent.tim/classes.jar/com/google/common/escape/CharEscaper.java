package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@Beta
@GwtCompatible
public abstract class CharEscaper
  extends Escaper
{
  private static final int DEST_PAD_MULTIPLIER = 2;
  
  private static char[] growBuffer(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    if (paramInt1 > 0) {
      System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramInt1);
    }
    return arrayOfChar;
  }
  
  public String escape(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < j)
      {
        if (escape(paramString.charAt(i)) != null) {
          str = escapeSlow(paramString, i);
        }
      }
      else {
        return str;
      }
      i += 1;
    }
  }
  
  protected abstract char[] escape(char paramChar);
  
  protected final String escapeSlow(String paramString, int paramInt)
  {
    int n = paramString.length();
    Object localObject1 = Platform.charBufferFromThreadLocal();
    int j = localObject1.length;
    int m = 0;
    int i = 0;
    int k = paramInt;
    paramInt = i;
    char[] arrayOfChar;
    int i1;
    Object localObject2;
    while (k < n)
    {
      arrayOfChar = escape(paramString.charAt(k));
      if (arrayOfChar == null)
      {
        i = j;
        k += 1;
        j = i;
      }
      else
      {
        i1 = arrayOfChar.length;
        int i2 = k - m;
        int i3 = paramInt + i2 + i1;
        i = j;
        localObject2 = localObject1;
        if (j < i3)
        {
          i = (n - k) * 2 + i3;
          localObject2 = growBuffer((char[])localObject1, paramInt, i);
        }
        if (i2 <= 0) {
          break label247;
        }
        paramString.getChars(m, k, (char[])localObject2, paramInt);
        paramInt += i2;
      }
    }
    label247:
    for (;;)
    {
      j = paramInt;
      if (i1 > 0)
      {
        System.arraycopy(arrayOfChar, 0, localObject2, paramInt, i1);
        j = paramInt + i1;
      }
      paramInt = j;
      m = k + 1;
      localObject1 = localObject2;
      break;
      k = n - m;
      i = paramInt;
      localObject2 = localObject1;
      if (k > 0)
      {
        i = k + paramInt;
        localObject2 = localObject1;
        if (j < i) {
          localObject2 = growBuffer((char[])localObject1, paramInt, i);
        }
        paramString.getChars(m, n, (char[])localObject2, paramInt);
      }
      return new String((char[])localObject2, 0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.escape.CharEscaper
 * JD-Core Version:    0.7.0.1
 */