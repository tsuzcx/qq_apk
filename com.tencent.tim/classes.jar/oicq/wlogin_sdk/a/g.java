package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public class g
  extends c
{
  public g()
  {
    this.b = 4;
  }
  
  public byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.d = (paramArrayOfByte1.length + 1);
    paramArrayOfByte2 = new byte[this.d];
    util.int8_to_buf(paramArrayOfByte2, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 1, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length;
    return a(paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.g
 * JD-Core Version:    0.7.0.1
 */