package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bo
  extends a
{
  public bo()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.bo
 * JD-Core Version:    0.7.0.1
 */