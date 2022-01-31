package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class ak
  extends a
{
  int h = 1;
  
  public ak()
  {
    this.g = 321;
  }
  
  public byte[] b(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    int i = arrayOfByte.length + 4 + 2 + 2 + paramArrayOfByte1.length;
    paramArrayOfByte2 = new byte[i];
    util.int16_to_buf(paramArrayOfByte2, 0, this.h);
    util.int16_to_buf(paramArrayOfByte2, 2, arrayOfByte.length);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, 4, arrayOfByte.length);
    int j = arrayOfByte.length + 4;
    util.int16_to_buf(paramArrayOfByte2, j, paramInt);
    paramInt = j + 2;
    util.int16_to_buf(paramArrayOfByte2, paramInt, paramArrayOfByte1.length);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt, paramArrayOfByte1.length);
    paramInt = paramArrayOfByte1.length;
    a(this.g);
    b(paramArrayOfByte2, i);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.ak
 * JD-Core Version:    0.7.0.1
 */