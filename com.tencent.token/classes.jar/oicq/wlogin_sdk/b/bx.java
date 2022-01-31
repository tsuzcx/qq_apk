package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bx
  extends a
{
  public bx()
  {
    this.g = 389;
  }
  
  public byte[] b(int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    util.int8_to_buf(arrayOfByte, 0, 1);
    util.int8_to_buf(arrayOfByte, 1, paramInt);
    a(this.g);
    b(arrayOfByte, arrayOfByte.length);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.bx
 * JD-Core Version:    0.7.0.1
 */