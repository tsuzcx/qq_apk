package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class br
  extends a
{
  public int h = 0;
  public int i = 0;
  
  public br()
  {
    this.g = 381;
  }
  
  public Boolean e()
  {
    if (this.e < 8) {
      return Boolean.valueOf(false);
    }
    int j = util.buf_to_int16(this.f, this.d + 2);
    if (this.e < j + 8) {
      return Boolean.valueOf(false);
    }
    this.h = j;
    j = util.buf_to_int16(this.f, this.d + 2 + 2 + this.h + 2);
    if (this.e < this.h + 8 + j) {
      return Boolean.valueOf(false);
    }
    this.i = j;
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
  
  public int h()
  {
    return util.buf_to_int16(this.f, this.d + 2 + 2 + this.h);
  }
  
  public byte[] i()
  {
    byte[] arrayOfByte = new byte[this.i];
    System.arraycopy(this.f, this.d + 2 + 2 + this.h + 2 + 2, arrayOfByte, 0, this.i);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.br
 * JD-Core Version:    0.7.0.1
 */