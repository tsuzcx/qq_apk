package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class aq
  extends a
{
  public aq()
  {
    this.g = 327;
  }
  
  public byte[] a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    int j = c(arrayOfByte, 32);
    int i = c(paramArrayOfByte1, 32);
    paramArrayOfByte2 = new byte[j + 6 + 2 + i];
    util.int64_to_buf32(paramArrayOfByte2, 0, paramLong);
    util.int16_to_buf(paramArrayOfByte2, 4, j);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, 6, j);
    j += 6;
    util.int16_to_buf(paramArrayOfByte2, j, i);
    j += 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, j, i);
    a(this.g);
    b(paramArrayOfByte2, paramArrayOfByte2.length);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.aq
 * JD-Core Version:    0.7.0.1
 */