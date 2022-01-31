package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bt
  extends a
{
  int h = 22;
  int i = 1;
  int j = 1536;
  
  public bt()
  {
    this.g = 24;
  }
  
  public byte[] a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    byte[] arrayOfByte = new byte[this.h];
    util.int16_to_buf(arrayOfByte, 0, this.i);
    util.int32_to_buf(arrayOfByte, 2, this.j);
    util.int32_to_buf(arrayOfByte, 6, (int)paramLong1);
    util.int32_to_buf(arrayOfByte, 10, paramInt1);
    util.int32_to_buf(arrayOfByte, 14, (int)paramLong2);
    util.int16_to_buf(arrayOfByte, 18, paramInt2);
    util.int16_to_buf(arrayOfByte, 20, 0);
    a(this.g);
    b(arrayOfByte, this.h);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.bt
 * JD-Core Version:    0.7.0.1
 */