package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bq
  extends a
{
  int h = 0;
  
  public bq()
  {
    this.g = 380;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    this.h = (arrayOfByte.length + 2);
    paramArrayOfByte = new byte[this.h];
    util.int16_to_buf(paramArrayOfByte, 0, arrayOfByte.length);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 2, arrayOfByte.length);
    int i = arrayOfByte.length;
    a(this.g);
    b(paramArrayOfByte, this.h);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.bq
 * JD-Core Version:    0.7.0.1
 */