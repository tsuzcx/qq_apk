package com.tencent.token.utils.encrypt.random;

public class FixedSecureRandom
  extends SecureRandom
{
  private byte[] _data;
  private int _index;
  private int _intPad;
  
  private int a()
  {
    byte[] arrayOfByte = this._data;
    int i = this._index;
    this._index = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    System.arraycopy(this._data, this._index, paramArrayOfByte, 0, paramArrayOfByte.length);
    this._index += paramArrayOfByte.length;
  }
  
  public int nextInt()
  {
    int i = a() << 24 | 0x0 | a() << 16;
    int j = this._intPad;
    if (j == 2) {
      this._intPad = (j - 1);
    } else {
      i |= a() << 8;
    }
    j = this._intPad;
    if (j == 1)
    {
      this._intPad = (j - 1);
      return i;
    }
    return i | a();
  }
  
  public long nextLong()
  {
    return a() << 56 | 0L | a() << 48 | a() << 40 | a() << 32 | a() << 24 | a() << 16 | a() << 8 | a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.random.FixedSecureRandom
 * JD-Core Version:    0.7.0.1
 */