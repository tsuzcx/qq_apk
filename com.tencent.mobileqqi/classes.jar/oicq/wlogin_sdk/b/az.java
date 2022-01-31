package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class az
  extends a
{
  public az()
  {
    this.g = 358;
  }
  
  public byte[] b(int paramInt)
  {
    byte[] arrayOfByte = new byte[1];
    util.int8_to_buf(arrayOfByte, 0, paramInt);
    a(this.g);
    b(arrayOfByte, arrayOfByte.length);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.az
 * JD-Core Version:    0.7.0.1
 */