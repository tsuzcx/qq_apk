package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bn
  extends a
{
  public int h = 0;
  
  public bn()
  {
    this.g = 377;
  }
  
  public Boolean e()
  {
    if (this.e < 2) {
      return Boolean.valueOf(false);
    }
    int i = util.buf_to_int16(this.f, this.d);
    if (this.e < i + 2) {
      return Boolean.valueOf(false);
    }
    this.h = i;
    return Boolean.valueOf(true);
  }
  
  public byte[] f()
  {
    byte[] arrayOfByte = new byte[this.h];
    System.arraycopy(this.f, this.d + 2, arrayOfByte, 0, this.h);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.bn
 * JD-Core Version:    0.7.0.1
 */