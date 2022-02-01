package com.huawei.hianalytics.ab.bc.kl;

public class ab
{
  private byte[] ab = null;
  private int bc = 1024;
  private int cd = 0;
  
  public ab()
  {
    this.ab = new byte[this.bc];
  }
  
  public ab(int paramInt)
  {
    this.bc = paramInt;
    this.ab = new byte[paramInt];
  }
  
  public int ab()
  {
    return this.cd;
  }
  
  public void ab(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (this.ab.length - this.cd >= paramInt) {
      System.arraycopy(paramArrayOfByte, 0, this.ab, this.cd, paramInt);
    }
    for (;;)
    {
      this.cd += paramInt;
      return;
      byte[] arrayOfByte = new byte[this.ab.length + paramInt << 1];
      System.arraycopy(this.ab, 0, arrayOfByte, 0, this.cd);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.cd, paramInt);
      this.ab = arrayOfByte;
    }
  }
  
  public byte[] bc()
  {
    if (this.cd <= 0) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[this.cd];
    System.arraycopy(this.ab, 0, arrayOfByte, 0, this.cd);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.kl.ab
 * JD-Core Version:    0.7.0.1
 */