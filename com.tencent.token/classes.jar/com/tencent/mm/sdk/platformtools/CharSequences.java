package com.tencent.mm.sdk.platformtools;

public class CharSequences
{
  static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 > paramInt3) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt1 > paramInt2) {
      throw new IndexOutOfBoundsException();
    }
  }
  
  public static int compareToIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int k = 0;
    int m = paramCharSequence1.length();
    int n = paramCharSequence2.length();
    int i;
    int j;
    if (m < n)
    {
      i = m;
      j = 0;
    }
    for (;;)
    {
      if (j < i)
      {
        int i1 = Character.toLowerCase(paramCharSequence1.charAt(j)) - Character.toLowerCase(paramCharSequence2.charAt(k));
        if (i1 == 0) {
          break label80;
        }
        return i1;
        i = n;
        break;
      }
      return m - n;
      label80:
      k += 1;
      j += 1;
    }
  }
  
  public static boolean equals(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1.length() != paramCharSequence2.length()) {
      return false;
    }
    int j = paramCharSequence1.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label55;
      }
      if (paramCharSequence1.charAt(i) != paramCharSequence2.charAt(i)) {
        break;
      }
      i += 1;
    }
    label55:
    return true;
  }
  
  public static CharSequence forAsciiBytes(byte[] paramArrayOfByte)
  {
    return new CharSequences.1(paramArrayOfByte);
  }
  
  public static CharSequence forAsciiBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, paramArrayOfByte.length);
    return new CharSequences.2(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.CharSequences
 * JD-Core Version:    0.7.0.1
 */