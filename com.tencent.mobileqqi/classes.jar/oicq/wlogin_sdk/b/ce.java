package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class ce
  extends a
{
  byte[] h = new byte[0];
  byte[] i = new byte[0];
  
  public ce()
  {
    this.g = 409;
  }
  
  public Boolean e()
  {
    if (this.e < 2) {
      return Boolean.valueOf(false);
    }
    int j = util.buf_to_int16(this.f, this.d + 0);
    if (this.e < j + 2) {
      return Boolean.valueOf(false);
    }
    this.h = new byte[j];
    System.arraycopy(this.f, this.d + 2, this.h, 0, j);
    int k = j + 2;
    if (this.e < k + 2) {
      return Boolean.valueOf(false);
    }
    j = util.buf_to_int16(this.f, this.d + k);
    k += 2;
    if (this.e < k + j) {
      return Boolean.valueOf(false);
    }
    this.i = new byte[j];
    System.arraycopy(this.f, this.d + k, this.i, 0, j);
    return Boolean.valueOf(true);
  }
  
  public byte[] f()
  {
    return this.h;
  }
  
  public byte[] g()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.ce
 * JD-Core Version:    0.7.0.1
 */