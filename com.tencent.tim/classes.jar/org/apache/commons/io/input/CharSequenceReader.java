package org.apache.commons.io.input;

import java.io.Reader;
import java.io.Serializable;

public class CharSequenceReader
  extends Reader
  implements Serializable
{
  private static final long serialVersionUID = 3724187752191401220L;
  private final CharSequence charSequence;
  private int idx;
  private int mark;
  
  public CharSequenceReader(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {}
    for (;;)
    {
      this.charSequence = paramCharSequence;
      return;
      paramCharSequence = "";
    }
  }
  
  public void close()
  {
    this.idx = 0;
    this.mark = 0;
  }
  
  public void mark(int paramInt)
  {
    this.mark = this.idx;
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    if (this.idx >= this.charSequence.length()) {
      return -1;
    }
    CharSequence localCharSequence = this.charSequence;
    int i = this.idx;
    this.idx = (i + 1);
    return localCharSequence.charAt(i);
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (this.idx >= this.charSequence.length()) {
      return -1;
    }
    if (paramArrayOfChar == null) {
      throw new NullPointerException("Character array is missing");
    }
    if ((paramInt2 < 0) || (paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length)) {
      throw new IndexOutOfBoundsException("Array Size=" + paramArrayOfChar.length + ", offset=" + paramInt1 + ", length=" + paramInt2);
    }
    int j = 0;
    while (j < paramInt2)
    {
      int k = read();
      if (k == -1) {
        return i;
      }
      paramArrayOfChar[(paramInt1 + j)] = ((char)k);
      j += 1;
      i += 1;
    }
    return i;
  }
  
  public void reset()
  {
    this.idx = this.mark;
  }
  
  public long skip(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Number of characters to skip is less than zero: " + paramLong);
    }
    if (this.idx >= this.charSequence.length()) {
      return -1L;
    }
    int i = (int)Math.min(this.charSequence.length(), this.idx + paramLong);
    int j = this.idx;
    this.idx = i;
    return i - j;
  }
  
  public String toString()
  {
    return this.charSequence.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.CharSequenceReader
 * JD-Core Version:    0.7.0.1
 */