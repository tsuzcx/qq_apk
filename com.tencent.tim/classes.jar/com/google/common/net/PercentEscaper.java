package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;

@Beta
@GwtCompatible
public final class PercentEscaper
  extends UnicodeEscaper
{
  private static final char[] PLUS_SIGN = { '+' };
  private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
  private final boolean plusForSpace;
  private final boolean[] safeOctets;
  
  public PercentEscaper(String paramString, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramString);
    if (paramString.matches(".*[0-9A-Za-z].*")) {
      throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }
    paramString = paramString + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    if ((paramBoolean) && (paramString.contains(" "))) {
      throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
    }
    this.plusForSpace = paramBoolean;
    this.safeOctets = createSafeOctets(paramString);
  }
  
  private static boolean[] createSafeOctets(String paramString)
  {
    int k = 0;
    paramString = paramString.toCharArray();
    int m = paramString.length;
    int j = -1;
    int i = 0;
    while (i < m)
    {
      j = Math.max(paramString[i], j);
      i += 1;
    }
    boolean[] arrayOfBoolean = new boolean[j + 1];
    j = paramString.length;
    i = k;
    while (i < j)
    {
      arrayOfBoolean[paramString[i]] = true;
      i += 1;
    }
    return arrayOfBoolean;
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
        int k = paramString.charAt(i);
        if ((k >= this.safeOctets.length) || (this.safeOctets[k] == 0)) {
          str = escapeSlow(paramString, i);
        }
      }
      else
      {
        return str;
      }
      i += 1;
    }
  }
  
  public char[] escape(int paramInt)
  {
    if ((paramInt < this.safeOctets.length) && (this.safeOctets[paramInt] != 0)) {
      return null;
    }
    if ((paramInt == 32) && (this.plusForSpace)) {
      return PLUS_SIGN;
    }
    int i;
    if (paramInt <= 127)
    {
      i = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      return new char[] { '%', UPPER_HEX_DIGITS[(paramInt >>> 4)], i };
    }
    int j;
    int k;
    if (paramInt <= 2047)
    {
      i = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = UPPER_HEX_DIGITS[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      return new char[] { '%', UPPER_HEX_DIGITS[(paramInt >>> 4 | 0xC)], k, '%', j, i };
    }
    int m;
    if (paramInt <= 65535)
    {
      i = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = UPPER_HEX_DIGITS[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      paramInt >>>= 4;
      m = UPPER_HEX_DIGITS[(paramInt & 0x3 | 0x8)];
      return new char[] { '%', 'E', UPPER_HEX_DIGITS[(paramInt >>> 2)], '%', m, k, '%', j, i };
    }
    if (paramInt <= 1114111)
    {
      i = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = UPPER_HEX_DIGITS[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      paramInt >>>= 4;
      m = UPPER_HEX_DIGITS[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      int n = UPPER_HEX_DIGITS[(paramInt & 0xF)];
      paramInt >>>= 4;
      int i1 = UPPER_HEX_DIGITS[(paramInt & 0x3 | 0x8)];
      return new char[] { '%', 'F', UPPER_HEX_DIGITS[(paramInt >>> 2 & 0x7)], '%', i1, n, '%', m, k, '%', j, i };
    }
    throw new IllegalArgumentException("Invalid unicode character value " + paramInt);
  }
  
  public int nextEscapeIndex(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    Preconditions.checkNotNull(paramCharSequence);
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        int i = paramCharSequence.charAt(paramInt1);
        if ((i < this.safeOctets.length) && (this.safeOctets[i] != 0)) {}
      }
      else
      {
        return paramInt1;
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.net.PercentEscaper
 * JD-Core Version:    0.7.0.1
 */