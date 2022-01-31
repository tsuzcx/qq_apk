package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class ad
  extends a
{
  int h = 0;
  
  public ad()
  {
    this.g = 294;
  }
  
  public Boolean e()
  {
    if (this.e < 2) {
      return Boolean.valueOf(false);
    }
    if (this.e < 4) {
      return Boolean.valueOf(false);
    }
    this.h = util.buf_to_int16(this.f, this.d + 2);
    if (this.h + 2 + 2 > this.e) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public byte[] f()
  {
    byte[] arrayOfByte = new byte[this.h];
    System.arraycopy(this.f, this.d + 2 + 2, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.ad
 * JD-Core Version:    0.7.0.1
 */