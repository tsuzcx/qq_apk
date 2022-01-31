package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class ah
  extends a
{
  int h = 0;
  int i = 0;
  
  public ah()
  {
    this.g = 306;
  }
  
  public Boolean e()
  {
    if (this.e < 2) {
      return Boolean.valueOf(false);
    }
    this.h = util.buf_to_int16(this.f, this.d);
    if (this.h + 2 + 4 + 2 > this.e) {
      return Boolean.valueOf(false);
    }
    this.i = util.buf_to_int16(this.f, this.d + 2 + this.h + 4);
    return Boolean.valueOf(true);
  }
  
  public byte[] f()
  {
    byte[] arrayOfByte = new byte[this.h];
    System.arraycopy(this.f, this.d + 2, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public byte[] g()
  {
    byte[] arrayOfByte = new byte[this.i];
    System.arraycopy(this.f, this.d + 2 + this.h + 4 + 2, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.ah
 * JD-Core Version:    0.7.0.1
 */