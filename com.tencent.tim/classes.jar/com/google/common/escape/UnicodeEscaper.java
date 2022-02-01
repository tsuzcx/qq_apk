package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@Beta
@GwtCompatible
public abstract class UnicodeEscaper
  extends Escaper
{
  private static final int DEST_PAD = 32;
  
  protected static int codePointAt(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    Preconditions.checkNotNull(paramCharSequence);
    if (paramInt1 < paramInt2)
    {
      int j = paramInt1 + 1;
      int i = paramCharSequence.charAt(paramInt1);
      if ((i < 55296) || (i > 57343)) {
        return i;
      }
      if (i <= 56319)
      {
        if (j == paramInt2) {
          return -i;
        }
        char c = paramCharSequence.charAt(j);
        if (Character.isLowSurrogate(c)) {
          return Character.toCodePoint(i, c);
        }
        throw new IllegalArgumentException("Expected low surrogate but got char '" + c + "' with value " + c + " at index " + j + " in '" + paramCharSequence + "'");
      }
      throw new IllegalArgumentException("Unexpected low surrogate character '" + i + "' with value " + i + " at index " + (j - 1) + " in '" + paramCharSequence + "'");
    }
    throw new IndexOutOfBoundsException("Index exceeds specified range");
  }
  
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
    int i = paramString.length();
    int j = nextEscapeIndex(paramString, 0, i);
    if (j == i) {
      return paramString;
    }
    return escapeSlow(paramString, j);
  }
  
  protected abstract char[] escape(int paramInt);
  
  protected final String escapeSlow(String paramString, int paramInt)
  {
    int n = paramString.length();
    Object localObject1 = Platform.charBufferFromThreadLocal();
    int i = 0;
    int j = 0;
    int k = paramInt;
    paramInt = j;
    label73:
    int m;
    Object localObject2;
    if (k < n)
    {
      j = codePointAt(paramString, k, n);
      if (j < 0) {
        throw new IllegalArgumentException("Trailing high surrogate at end of input");
      }
      char[] arrayOfChar = escape(j);
      if (Character.isSupplementaryCodePoint(j))
      {
        j = 2;
        m = j + k;
        if (arrayOfChar == null) {
          break label291;
        }
        int i1 = k - i;
        j = paramInt + i1 + arrayOfChar.length;
        localObject2 = localObject1;
        if (localObject1.length < j) {
          localObject2 = growBuffer((char[])localObject1, paramInt, j + (n - k) + 32);
        }
        j = paramInt;
        if (i1 > 0)
        {
          paramString.getChars(i, k, (char[])localObject2, paramInt);
          j = paramInt + i1;
        }
        paramInt = j;
        if (arrayOfChar.length > 0)
        {
          System.arraycopy(arrayOfChar, 0, localObject2, j, arrayOfChar.length);
          paramInt = j + arrayOfChar.length;
        }
        i = paramInt;
        paramInt = m;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      k = nextEscapeIndex(paramString, m, n);
      j = paramInt;
      paramInt = i;
      i = j;
      break;
      j = 1;
      break label73;
      k = n - i;
      j = paramInt;
      localObject2 = localObject1;
      if (k > 0)
      {
        j = k + paramInt;
        localObject2 = localObject1;
        if (localObject1.length < j) {
          localObject2 = growBuffer((char[])localObject1, paramInt, j);
        }
        paramString.getChars(i, n, (char[])localObject2, paramInt);
      }
      return new String((char[])localObject2, 0, j);
      label291:
      j = paramInt;
      paramInt = i;
      i = j;
    }
  }
  
  protected int nextEscapeIndex(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      i = codePointAt(paramCharSequence, paramInt1, paramInt2);
      if ((i >= 0) && (escape(i) == null)) {}
    }
    else
    {
      return paramInt1;
    }
    if (Character.isSupplementaryCodePoint(i)) {}
    for (int i = 2;; i = 1)
    {
      paramInt1 += i;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.escape.UnicodeEscaper
 * JD-Core Version:    0.7.0.1
 */