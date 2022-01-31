package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class x
  extends a
{
  int h = 0;
  
  public x()
  {
    this.g = 285;
  }
  
  public Boolean e()
  {
    if (this.e < 22) {
      return Boolean.valueOf(false);
    }
    this.h = util.buf_to_int16(this.f, this.d + 4 + 16);
    this.h &= 0xFFFF;
    if (this.e < this.h + 22) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public long f()
  {
    return util.buf_to_int32(this.f, this.d) & 0xFFFFFFFF;
  }
  
  public byte[] g()
  {
    byte[] arrayOfByte = new byte[16];
    System.arraycopy(this.f, this.d + 4, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public byte[] h()
  {
    byte[] arrayOfByte = new byte[this.h];
    System.arraycopy(this.f, this.d + 4 + 16 + 2, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.x
 * JD-Core Version:    0.7.0.1
 */