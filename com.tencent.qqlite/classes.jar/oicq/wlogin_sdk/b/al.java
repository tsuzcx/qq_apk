package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class al
  extends a
{
  int h = 0;
  int i = 0;
  
  public al()
  {
    this.g = 322;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    int j = c(arrayOfByte, 32);
    this.i = (j + 4);
    paramArrayOfByte = new byte[this.i];
    util.int16_to_buf(paramArrayOfByte, 0, this.h);
    util.int16_to_buf(paramArrayOfByte, 2, j);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 4, j);
    a(this.g);
    b(paramArrayOfByte, paramArrayOfByte.length);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.al
 * JD-Core Version:    0.7.0.1
 */