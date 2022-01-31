package com.tencent.qphone.base.util;

public class Cryptor
{
  a impl = new a();
  
  public byte[] decrypt(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    return this.impl.a(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2);
  }
  
  public byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return this.impl.a(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return this.impl.b(paramArrayOfByte1, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.Cryptor
 * JD-Core Version:    0.7.0.1
 */