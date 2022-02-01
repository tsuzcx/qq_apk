package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public class c
  extends a
{
  public c()
  {
    this.b = 7;
  }
  
  public byte[] a(int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    this.d = (paramArrayOfByte.length + 2 + 4);
    byte[] arrayOfByte = new byte[this.d];
    util.int8_to_buf(arrayOfByte, 0, paramInt);
    util.int8_to_buf(arrayOfByte, 1, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 2, paramArrayOfByte.length);
    util.int64_to_buf32(arrayOfByte, 2 + paramArrayOfByte.length, paramLong);
    return a(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.c
 * JD-Core Version:    0.7.0.1
 */