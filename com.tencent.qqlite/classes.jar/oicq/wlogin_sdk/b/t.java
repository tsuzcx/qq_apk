package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class t
  extends a
{
  int h = 0;
  int i = 0;
  
  public t()
  {
    this.g = 278;
  }
  
  public byte[] a(int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    int j = 0;
    long[] arrayOfLong = paramArrayOfLong;
    if (paramArrayOfLong == null) {
      arrayOfLong = new long[0];
    }
    this.h = (arrayOfLong.length * 4 + 10);
    paramArrayOfLong = new byte[this.h];
    util.int8_to_buf(paramArrayOfLong, 0, this.i);
    util.int32_to_buf(paramArrayOfLong, 1, paramInt1);
    util.int32_to_buf(paramArrayOfLong, 5, paramInt2);
    util.int8_to_buf(paramArrayOfLong, 9, arrayOfLong.length);
    paramInt2 = 10;
    paramInt1 = j;
    while (paramInt1 < arrayOfLong.length)
    {
      util.int32_to_buf(paramArrayOfLong, paramInt2, (int)arrayOfLong[paramInt1]);
      paramInt2 += 4;
      paramInt1 += 1;
    }
    a(this.g);
    b(paramArrayOfLong, this.h);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.t
 * JD-Core Version:    0.7.0.1
 */