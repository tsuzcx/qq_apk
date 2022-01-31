package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bu
  extends a
{
  int h = 0;
  int i = 0;
  
  public bu()
  {
    this.g = 386;
  }
  
  public Boolean e()
  {
    if (this.e < 5) {
      return Boolean.valueOf(false);
    }
    this.h = util.buf_to_int16(this.f, this.d + 1);
    this.i = util.buf_to_int16(this.f, this.d + 1 + 2);
    return Boolean.valueOf(true);
  }
  
  public int f()
  {
    return this.h;
  }
  
  public int g()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.bu
 * JD-Core Version:    0.7.0.1
 */