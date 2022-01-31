package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bp
  extends a
{
  public bp()
  {
    this.g = 379;
  }
  
  public Boolean e()
  {
    if (this.e < 4) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public int f()
  {
    if (this.e < 4) {
      return 0;
    }
    return util.buf_to_int16(this.f, this.d);
  }
  
  public int g()
  {
    if (this.e < 4) {
      return 0;
    }
    return util.buf_to_int16(this.f, this.d + 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.bp
 * JD-Core Version:    0.7.0.1
 */