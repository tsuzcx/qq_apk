package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class ci
  extends a
{
  public ci()
  {
    this.g = 514;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[16];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    int j = c(arrayOfByte, 16);
    int i = c(paramArrayOfByte1, 32);
    paramArrayOfByte2 = new byte[j + 2 + 2 + i];
    util.int16_to_buf(paramArrayOfByte2, 0, j);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, 2, j);
    j += 2;
    util.int16_to_buf(paramArrayOfByte2, j, i);
    j += 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, j, i);
    a(this.g);
    b(paramArrayOfByte2, paramArrayOfByte2.length);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.ci
 * JD-Core Version:    0.7.0.1
 */