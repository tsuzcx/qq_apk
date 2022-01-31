package com.tencent.mm.sdk.platformtools;

final class CharSequences$1
  implements CharSequence
{
  CharSequences$1(byte[] paramArrayOfByte) {}
  
  public final char charAt(int paramInt)
  {
    return (char)this.u[paramInt];
  }
  
  public final int length()
  {
    return this.u.length;
  }
  
  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return CharSequences.forAsciiBytes(this.u, paramInt1, paramInt2);
  }
  
  public final String toString()
  {
    return new String(this.u);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.CharSequences.1
 * JD-Core Version:    0.7.0.1
 */