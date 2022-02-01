package com.tencent.token;

public abstract class du
{
  protected abstract void a();
  
  protected abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  protected int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = b();
    if (paramInt2 < arrayOfByte.length) {
      throw new Exception("partial digests not returned");
    }
    if (paramArrayOfByte.length - paramInt1 < arrayOfByte.length) {
      throw new Exception("insufficient space in the output buffer to store the digest");
    }
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt1, arrayOfByte.length);
    return arrayOfByte.length;
  }
  
  protected abstract byte[] b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.du
 * JD-Core Version:    0.7.0.1
 */