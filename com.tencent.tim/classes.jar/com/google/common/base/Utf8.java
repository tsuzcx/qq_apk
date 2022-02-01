package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
public final class Utf8
{
  public static int encodedLength(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.length();
    int i = 0;
    while ((i < m) && (paramCharSequence.charAt(i) < '')) {
      i += 1;
    }
    for (;;)
    {
      int k = i;
      int j;
      if (j < m)
      {
        k = paramCharSequence.charAt(j);
        if (k < 2048)
        {
          j += 1;
          i = (127 - k >>> 31) + i;
        }
        else
        {
          k = i + encodedLengthGeneral(paramCharSequence, j);
        }
      }
      else
      {
        if (k < m) {
          throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (k + 4294967296L));
        }
        return k;
        j = i;
        i = m;
      }
    }
  }
  
  private static int encodedLengthGeneral(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    if (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      for (;;)
      {
        paramInt = j + 1;
        break;
        int k = i + 2;
        j = paramInt;
        i = k;
        if (55296 <= n)
        {
          j = paramInt;
          i = k;
          if (n <= 57343)
          {
            if (Character.codePointAt(paramCharSequence, paramInt) == n) {
              throw new IllegalArgumentException(unpairedSurrogateMsg(paramInt));
            }
            j = paramInt + 1;
            i = k;
          }
        }
      }
    }
    return i;
  }
  
  public static boolean isWellFormed(byte[] paramArrayOfByte)
  {
    return isWellFormed(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static boolean isWellFormed(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt1 + paramInt2;
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, paramArrayOfByte.length);
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfByte[paramInt1] < 0) {
        return isWellFormedSlowPath(paramArrayOfByte, paramInt1, paramInt2);
      }
      paramInt1 += 1;
    }
    return true;
  }
  
  private static boolean isWellFormedSlowPath(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        return true;
      }
      int i = paramInt1 + 1;
      paramInt1 = paramArrayOfByte[paramInt1];
      if (paramInt1 < 0)
      {
        if (paramInt1 < -32)
        {
          if (i == paramInt2) {
            return false;
          }
          if (paramInt1 >= -62)
          {
            paramInt1 = i + 1;
            if (paramArrayOfByte[i] <= -65) {}
          }
          else
          {
            return false;
          }
        }
        else
        {
          int j;
          if (paramInt1 < -16)
          {
            if (i + 1 >= paramInt2) {
              return false;
            }
            j = i + 1;
            i = paramArrayOfByte[i];
            if ((i <= -65) && ((paramInt1 != -32) || (i >= -96)) && ((paramInt1 != -19) || (-96 > i)))
            {
              paramInt1 = j + 1;
              if (paramArrayOfByte[j] <= -65) {}
            }
            else
            {
              return false;
            }
          }
          else
          {
            if (i + 2 >= paramInt2) {
              return false;
            }
            j = i + 1;
            i = paramArrayOfByte[i];
            if ((i <= -65) && ((paramInt1 << 28) + (i + 112) >> 30 == 0))
            {
              i = j + 1;
              if (paramArrayOfByte[j] <= -65)
              {
                paramInt1 = i + 1;
                if (paramArrayOfByte[i] <= -65) {
                  break label189;
                }
              }
            }
            return false;
          }
        }
      }
      else {
        label189:
        paramInt1 = i;
      }
    }
  }
  
  private static String unpairedSurrogateMsg(int paramInt)
  {
    return "Unpaired surrogate at index " + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Utf8
 * JD-Core Version:    0.7.0.1
 */