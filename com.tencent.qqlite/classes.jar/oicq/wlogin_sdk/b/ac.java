package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class ac
  extends a
{
  int h = 0;
  int i = 0;
  
  public ac()
  {
    this.g = 293;
  }
  
  public Boolean e()
  {
    if (this.e < 2) {
      return Boolean.valueOf(false);
    }
    this.h = util.buf_to_int16(this.f, this.d);
    if (this.e < this.h + 2 + 2) {
      return Boolean.valueOf(false);
    }
    this.i = util.buf_to_int16(this.f, this.d + 2 + this.h);
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
    System.arraycopy(this.f, this.d + 2 + this.h + 2, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.ac
 * JD-Core Version:    0.7.0.1
 */