package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class cf
  extends a
{
  int h = 0;
  byte[] i = new byte[0];
  byte[] j = new byte[0];
  
  public cf()
  {
    this.g = 406;
  }
  
  public Boolean e()
  {
    if (this.e < 5) {
      return Boolean.valueOf(false);
    }
    int k = this.d;
    this.h = util.buf_to_int8(this.f, k);
    int m = k + 1;
    k = util.buf_to_int16(this.f, m);
    m += 2;
    if (m - this.d + k > this.e) {
      return Boolean.valueOf(false);
    }
    this.i = new byte[k];
    System.arraycopy(this.f, m, this.i, 0, k);
    m += k;
    k = util.buf_to_int16(this.f, m);
    m += 2;
    if (m - this.d + k > this.e) {
      return Boolean.valueOf(false);
    }
    this.j = new byte[k];
    System.arraycopy(this.f, m, this.j, 0, k);
    return Boolean.valueOf(true);
  }
  
  public int f()
  {
    return this.h;
  }
  
  public String g()
  {
    return new String(this.i);
  }
  
  public String h()
  {
    return new String(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.cf
 * JD-Core Version:    0.7.0.1
 */