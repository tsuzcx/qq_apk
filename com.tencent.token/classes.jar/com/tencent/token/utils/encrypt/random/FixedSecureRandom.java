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
    int i = 0x0 | a() << 24 | a() << 16;
    if (this._intPad == 2) {
      this._intPad -= 1;
    }
    while (this._intPad == 1)
    {
      this._intPad -= 1;
      return i;
      i |= a() << 8;
    }
    return i | a();
  }
  
  public long nextLong()
  {
    return 0L | a() << 56 | a() << 48 | a() << 40 | a() << 32 | a() << 24 | a() << 16 | a() << 8 | a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.random.FixedSecureRandom
 * JD-Core Version:    0.7.0.1
 */