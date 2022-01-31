package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class g
  extends a
{
  int h = 0;
  int i = 0;
  int j = 0;
  int k = 0;
  
  public g()
  {
    this.g = 261;
  }
  
  public Boolean e()
  {
    if (this.e < 2) {
      return Boolean.valueOf(false);
    }
    this.i = util.buf_to_int16(this.f, this.d);
    if (this.e < this.i + 2 + 2) {
      return Boolean.valueOf(false);
    }
    this.h = util.buf_to_int16(this.f, this.d + 2 + this.i);
    if (this.e < this.i + 2 + 2 + this.h) {
      return Boolean.valueOf(false);
    }
    this.k = (this.d + 2);
    this.j = (this.i + 2 + 2 + this.d);
    return Boolean.valueOf(true);
  }
  
  public byte[] f()
  {
    byte[] arrayOfByte = new byte[this.h];
    if (this.h <= 0) {
      return arrayOfByte;
    }
    System.arraycopy(this.f, this.j, arrayOfByte, 0, this.h);
    return arrayOfByte;
  }
  
  public byte[] g()
  {
    byte[] arrayOfByte = new byte[this.i];
    if (this.i <= 0) {
      return arrayOfByte;
    }
    System.arraycopy(this.f, this.k, arrayOfByte, 0, this.i);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.g
 * JD-Core Version:    0.7.0.1
 */