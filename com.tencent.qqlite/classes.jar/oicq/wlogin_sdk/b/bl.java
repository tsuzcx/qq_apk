package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bl
  extends a
{
  int h = 0;
  
  public bl()
  {
    this.g = 375;
  }
  
  public byte[] a(long paramLong, String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    if (paramString != null) {
      arrayOfByte = paramString.getBytes();
    }
    this.h = (arrayOfByte.length + 7);
    paramString = new byte[this.h];
    util.int8_to_buf(paramString, 0, 1);
    util.int64_to_buf32(paramString, 1, paramLong);
    util.int16_to_buf(paramString, 5, arrayOfByte.length);
    System.arraycopy(arrayOfByte, 0, paramString, 7, arrayOfByte.length);
    int i = arrayOfByte.length;
    a(this.g);
    b(paramString, this.h);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.bl
 * JD-Core Version:    0.7.0.1
 */