package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;

public class a
  extends DevlockBase
{
  public a()
  {
    this._msgType = DevlockBase.a.a;
  }
  
  public byte[] a(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
  {
    paramArrayOfByte1 = new g().a(paramLong2, paramLong3, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      return new byte[0];
    }
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length + 2];
    util.int16_to_buf(paramArrayOfByte2, 0, 1);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 2, paramArrayOfByte1.length);
    return _get_request(paramLong1, paramLong2, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.a
 * JD-Core Version:    0.7.0.1
 */