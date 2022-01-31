package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class ba
  extends a
{
  public int h = 0;
  
  public ba()
  {
    this.g = 359;
  }
  
  public Boolean e()
  {
    if (this.e < 4) {
      return Boolean.valueOf(false);
    }
    int i = util.buf_to_int16(this.f, this.d + 1 + 1);
    if (this.e < i + 4) {
      return Boolean.valueOf(false);
    }
    this.h = i;
    return Boolean.valueOf(true);
  }
  
  public byte[] f()
  {
    byte[] arrayOfByte = new byte[1];
    System.arraycopy(this.f, this.d, arrayOfByte, 0, 1);
    return arrayOfByte;
  }
  
  public byte[] g()
  {
    byte[] arrayOfByte = new byte[1];
    System.arraycopy(this.f, this.d + 1, arrayOfByte, 0, 1);
    return arrayOfByte;
  }
  
  public byte[] h()
  {
    byte[] arrayOfByte = new byte[this.h];
    System.arraycopy(this.f, this.d + 1 + 1 + 2, arrayOfByte, 0, this.h);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.ba
 * JD-Core Version:    0.7.0.1
 */