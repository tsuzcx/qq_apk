package com.tencent.qqmail.utilities;

public class QMMath
{
  public static int bitwiseCombine(boolean... paramVarArgs)
  {
    int j = 0;
    int i = 0;
    if (j < paramVarArgs.length)
    {
      int k = paramVarArgs.length - (j + 1);
      if (paramVarArgs[(paramVarArgs.length - j)] != 0) {
        i |= 1 << k;
      }
      for (;;)
      {
        j += 1;
        break;
        i &= (1 << k ^ 0xFFFFFFFF);
      }
    }
    return i;
  }
  
  public static int hashInt(String paramString)
  {
    int i = 0;
    int j = 0;
    while (i < paramString.length())
    {
      j = j * 131 + paramString.charAt(i);
      i += 1;
    }
    return j;
  }
  
  public static long hashLong(String paramString)
  {
    long l = 0L;
    int i = 0;
    while (i < paramString.length())
    {
      l = l * 131L + paramString.charAt(i);
      i += 1;
    }
    return l;
  }
  
  public static long hashLong(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      l = l * 131L + paramArrayOfByte[i];
      i += 1;
    }
    return l;
  }
  
  public static int hashPositivetInt(String paramString)
  {
    return hashInt(paramString) & 0x7FFFFFFF;
  }
  
  public static int randomWeightIndex(int[] paramArrayOfInt)
  {
    int m = 0;
    int j = 0;
    int i = 0;
    while (j < paramArrayOfInt.length)
    {
      i += paramArrayOfInt[j];
      j += 1;
    }
    int k = m;
    int n;
    if (i > 0)
    {
      double d = Math.random();
      n = (int)Math.ceil(i * d);
      i = 0;
      j = 0;
    }
    for (;;)
    {
      k = m;
      if (i < paramArrayOfInt.length)
      {
        j += paramArrayOfInt[i];
        if (j >= n) {
          k = i;
        }
      }
      else
      {
        return k;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMMath
 * JD-Core Version:    0.7.0.1
 */