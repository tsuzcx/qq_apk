package com.tencent.token.utils.encrypt.random;

public class FixedSecureRandom
  extends SecureRandom
{
  private byte[] _data;
  private int _index;
  private int _intPad;
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    System.arraycopy(this._data, this._index, paramArrayOfByte, 0, paramArrayOfByte.length);
    this._index += paramArrayOfByte.length;
  }
  
  public int nextInt()
  {
    byte[] arrayOfByte = this._data;
    int i = this._index;
    this._index = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = this._data;
    int j = this._index;
    this._index = (j + 1);
    i = (i & 0xFF) << 24 | 0x0 | (arrayOfByte[j] & 0xFF) << 16;
    if (this._intPad == 2) {
      this._intPad -= 1;
    }
    while (this._intPad == 1)
    {
      this._intPad -= 1;
      return i;
      arrayOfByte = this._data;
      j = this._index;
      this._index = (j + 1);
      i |= (arrayOfByte[j] & 0xFF) << 8;
    }
    arrayOfByte = this._data;
    j = this._index;
    this._index = (j + 1);
    return i | arrayOfByte[j] & 0xFF;
  }
  
  public long nextLong()
  {
    byte[] arrayOfByte = this._data;
    int i = this._index;
    this._index = (i + 1);
    long l1 = arrayOfByte[i] & 0xFF;
    arrayOfByte = this._data;
    i = this._index;
    this._index = (i + 1);
    long l2 = arrayOfByte[i] & 0xFF;
    arrayOfByte = this._data;
    i = this._index;
    this._index = (i + 1);
    long l3 = arrayOfByte[i] & 0xFF;
    arrayOfByte = this._data;
    i = this._index;
    this._index = (i + 1);
    long l4 = arrayOfByte[i] & 0xFF;
    arrayOfByte = this._data;
    i = this._index;
    this._index = (i + 1);
    long l5 = arrayOfByte[i] & 0xFF;
    arrayOfByte = this._data;
    i = this._index;
    this._index = (i + 1);
    long l6 = arrayOfByte[i] & 0xFF;
    arrayOfByte = this._data;
    i = this._index;
    this._index = (i + 1);
    long l7 = arrayOfByte[i] & 0xFF;
    arrayOfByte = this._data;
    i = this._index;
    this._index = (i + 1);
    return 0L | l1 << 56 | l2 << 48 | l3 << 40 | l4 << 32 | l5 << 24 | l6 << 16 | l7 << 8 | arrayOfByte[i] & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.random.FixedSecureRandom
 * JD-Core Version:    0.7.0.1
 */