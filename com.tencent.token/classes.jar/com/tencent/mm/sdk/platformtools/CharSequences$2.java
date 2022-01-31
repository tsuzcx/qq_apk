package com.tencent.mm.sdk.platformtools;

final class CharSequences$2
  implements CharSequence
{
  CharSequences$2(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public final char charAt(int paramInt)
  {
    return (char)this.u[(this.v + paramInt)];
  }
  
  public final int length()
  {
    return this.w - this.v;
  }
  
  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    paramInt1 -= this.v;
    paramInt2 -= this.v;
    CharSequences.a(paramInt1, paramInt2, length());
    return CharSequences.forAsciiBytes(this.u, paramInt1, paramInt2);
  }
  
  public final String toString()
  {
    return new String(this.u, this.v, length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.CharSequences.2
 * JD-Core Version:    0.7.0.1
 */