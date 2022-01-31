package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class ap
  extends a
{
  public int h = 0;
  public int i = 0;
  public int j = 0;
  
  public ap()
  {
    this.g = 326;
  }
  
  public Boolean e()
  {
    if (this.e < 12) {
      return Boolean.valueOf(false);
    }
    int k = util.buf_to_int16(this.f, this.d + 4);
    if (this.e < k + 12) {
      return Boolean.valueOf(false);
    }
    this.h = k;
    k = util.buf_to_int16(this.f, this.d + 6 + this.h);
    if (this.e < this.h + 12 + k) {
      return Boolean.valueOf(false);
    }
    this.i = k;
    k = util.buf_to_int16(this.f, this.d + 10 + this.h + this.i);
    if (this.e < this.h + 12 + this.i + k) {
      return Boolean.valueOf(false);
    }
    this.j = k;
    return Boolean.valueOf(true);
  }
  
  public byte[] f()
  {
    byte[] arrayOfByte = new byte[this.h];
    System.arraycopy(this.f, this.d + 6, arrayOfByte, 0, this.h);
    return arrayOfByte;
  }
  
  public byte[] g()
  {
    byte[] arrayOfByte = new byte[this.i];
    System.arraycopy(this.f, this.d + 8 + this.h, arrayOfByte, 0, this.i);
    return arrayOfByte;
  }
  
  public int h()
  {
    return util.buf_to_int16(this.f, this.d + 8 + this.h + this.i);
  }
  
  public byte[] i()
  {
    byte[] arrayOfByte = new byte[this.j];
    System.arraycopy(this.f, this.d + 12 + this.h + this.i, arrayOfByte, 0, this.j);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.ap
 * JD-Core Version:    0.7.0.1
 */