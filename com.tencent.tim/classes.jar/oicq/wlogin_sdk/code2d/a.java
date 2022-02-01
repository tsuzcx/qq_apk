package oicq.wlogin_sdk.code2d;

import oicq.wlogin_sdk.tools.util;

public class a
  extends c
{
  public a()
  {
    this._cmd = 22;
  }
  
  public byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length + 8 + 8 + 1 + 2 + arrayOfByte.length + 2];
    util.int64_to_buf32(paramArrayOfByte2, 2, paramLong2);
    util.int16_to_buf(paramArrayOfByte2, 6, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 8, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 8;
    util.int64_to_buf(paramArrayOfByte2, i, paramLong1);
    i += 8;
    util.int8_to_buf(paramArrayOfByte2, i, 8);
    i += 1;
    util.int16_to_buf(paramArrayOfByte2, i, arrayOfByte.length);
    i += 2;
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, i, arrayOfByte.length);
    util.int16_to_buf(paramArrayOfByte2, i + arrayOfByte.length, 0);
    return get_request(paramLong1, true, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.a
 * JD-Core Version:    0.7.0.1
 */