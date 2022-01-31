package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class as
  extends a
{
  public int h = 0;
  public int i = 0;
  public int j = 0;
  
  public as()
  {
    this.g = 329;
  }
  
  public Boolean e()
  {
    if (this.e < 8) {
      return Boolean.valueOf(false);
    }
    int k = util.buf_to_int16(this.f, this.d + 2);
    if (this.e < k + 8) {
      return Boolean.valueOf(false);
    }
    this.h = k;
    k = util.buf_to_int16(this.f, this.d + 2 + 2 + this.h);
    if (this.e < this.h + 8 + k) {
      return Boolean.valueOf(false);
    }
    this.i = k;
    k = util.buf_to_int16(this.f, this.d + 2 + 2 + this.h + 2 + this.i);
    if (this.e < this.h + 8 + this.i + k) {
      return Boolean.valueOf(false);
    }
    this.j = k;
    return Boolean.valueOf(true);
  }
  
  public int f()
  {
    return util.buf_to_int16(this.f, this.d);
  }
  
  public byte[] g()
  {
    byte[] arrayOfByte = new byte[this.h];
    System.arraycopy(this.f, this.d + 2 + 2, arrayOfByte, 0, this.h);
    return arrayOfByte;
  }
  
  public byte[] h()
  {
    byte[] arrayOfByte = new byte[this.i];
    System.arraycopy(this.f, this.d + 2 + 2 + this.h + 2, arrayOfByte, 0, this.i);
    return arrayOfByte;
  }
  
  public byte[] i()
  {
    byte[] arrayOfByte = new byte[this.j];
    System.arraycopy(this.f, this.d + 2 + 2 + this.h + 2 + this.i + 2, arrayOfByte, 0, this.j);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.as
 * JD-Core Version:    0.7.0.1
 */