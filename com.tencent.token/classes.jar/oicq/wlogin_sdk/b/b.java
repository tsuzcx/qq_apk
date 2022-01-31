package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class b
  extends a
{
  int h = 4;
  int i = 14;
  int j = 1;
  int k = 20;
  byte[] l = new byte[2];
  
  public b()
  {
    this.g = 1;
  }
  
  public byte[] a(long paramLong, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[this.k];
    util.int16_to_buf(arrayOfByte, 0, this.j);
    util.int32_to_buf(arrayOfByte, 2, util.get_rand_32());
    util.int32_to_buf(arrayOfByte, 6, (int)paramLong);
    util.int64_to_buf32(arrayOfByte, 10, util.get_server_cur_time());
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 14, paramArrayOfByte.length);
    int m = paramArrayOfByte.length + 14;
    util.int16_to_buf(arrayOfByte, m, 0);
    a(this.g);
    b(arrayOfByte, this.k);
    d();
    return a();
  }
  
  public Boolean e()
  {
    if (this.e < 20) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.b
 * JD-Core Version:    0.7.0.1
 */