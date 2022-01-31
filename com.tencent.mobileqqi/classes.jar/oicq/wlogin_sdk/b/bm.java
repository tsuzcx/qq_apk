package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bm
  extends a
{
  public bm()
  {
    this.g = 378;
  }
  
  public byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[4];
    util.int64_to_buf32(arrayOfByte, 0, paramLong);
    a(this.g);
    b(arrayOfByte, 4);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.bm
 * JD-Core Version:    0.7.0.1
 */