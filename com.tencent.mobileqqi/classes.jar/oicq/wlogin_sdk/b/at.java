package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class at
  extends a
{
  public int h = 0;
  
  public at()
  {
    this.g = 336;
  }
  
  public Boolean e()
  {
    if (this.e < 7) {
      return Boolean.valueOf(false);
    }
    int i = util.buf_to_int16(this.f, this.d + 5);
    if (this.e < i + 7) {
      return Boolean.valueOf(false);
    }
    this.h = i;
    return Boolean.valueOf(true);
  }
  
  public int f()
  {
    return util.buf_to_int32(this.f, this.d);
  }
  
  public byte g()
  {
    return (byte)(util.buf_to_int8(this.f, this.d + 4) & 0xFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.at
 * JD-Core Version:    0.7.0.1
 */