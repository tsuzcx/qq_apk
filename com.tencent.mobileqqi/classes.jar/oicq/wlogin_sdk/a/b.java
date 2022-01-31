package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class b
  extends a
{
  public b()
  {
    this.b = 6;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, boolean paramBoolean, byte[] paramArrayOfByte7, long paramLong, byte[] paramArrayOfByte8, int paramInt2)
  {
    paramArrayOfByte2 = b(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramInt1, paramArrayOfByte5, paramArrayOfByte6, paramBoolean, paramArrayOfByte7, paramLong, paramArrayOfByte8, paramInt2);
    this.d = (paramArrayOfByte1.length + 1 + 1 + paramArrayOfByte2.length + 4);
    paramArrayOfByte3 = new byte[this.d];
    util.int8_to_buf(paramArrayOfByte3, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, 1, paramArrayOfByte1.length);
    paramInt1 = paramArrayOfByte1.length + 1;
    util.int8_to_buf(paramArrayOfByte3, paramInt1, paramArrayOfByte2.length);
    paramInt1 += 1;
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    util.int8_to_buf(paramArrayOfByte3, paramInt1, 37);
    paramInt1 += 1;
    util.int8_to_buf(paramArrayOfByte3, paramInt1, 2);
    paramInt1 += 1;
    util.int16_to_buf(paramArrayOfByte3, paramInt1, t.ak);
    return a(paramArrayOfByte3);
  }
  
  public byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, boolean paramBoolean, byte[] paramArrayOfByte7, long paramLong, byte[] paramArrayOfByte8, int paramInt2)
  {
    byte[] arrayOfByte = paramArrayOfByte6;
    if (paramArrayOfByte6 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte6 = paramArrayOfByte4;
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte6 = new byte[0];
    }
    paramArrayOfByte4 = paramArrayOfByte7;
    if (paramArrayOfByte7 == null) {
      paramArrayOfByte4 = new byte[0];
    }
    int i = 6;
    if (paramBoolean)
    {
      i = 11;
      paramArrayOfByte7 = new byte[paramArrayOfByte1.length + 1 + 1 + paramArrayOfByte3.length + 1 + 1 + 2 + paramArrayOfByte5.length + 2 + arrayOfByte.length + 2 + paramArrayOfByte6.length + 2 + 1 + 2 + 1 + 2 + paramArrayOfByte4.length + 2 + paramArrayOfByte3.length + 2 + 4 + 2 + paramArrayOfByte8.length + 2 + 4 + 4];
      util.int8_to_buf(paramArrayOfByte7, 0, paramArrayOfByte1.length);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte7, 1, paramArrayOfByte1.length);
      int j = paramArrayOfByte1.length + 1;
      util.int8_to_buf(paramArrayOfByte7, j, paramArrayOfByte3.length);
      j += 1;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte7, j, paramArrayOfByte3.length);
      j += paramArrayOfByte3.length;
      util.int8_to_buf(paramArrayOfByte7, j, paramInt1);
      paramInt1 = j + 1;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, i);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, 1);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, paramArrayOfByte5.length);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte7, paramInt1, paramArrayOfByte5.length);
      paramInt1 += paramArrayOfByte5.length;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, 5);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, arrayOfByte.length);
      paramInt1 += 1;
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte7, paramInt1, arrayOfByte.length);
      paramInt1 += arrayOfByte.length;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, 6);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, paramArrayOfByte6.length);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte6, 0, paramArrayOfByte7, paramInt1, paramArrayOfByte6.length);
      paramInt1 += paramArrayOfByte6.length;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, 8);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, 1);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, 1);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, 15);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, 4);
      paramInt1 += 1;
      util.int32_to_buf(paramArrayOfByte7, paramInt1, paramInt2);
      paramInt1 += 4;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, 37);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte7, paramInt1, 2);
      paramInt1 += 1;
      util.int16_to_buf(paramArrayOfByte7, paramInt1, t.ak);
      paramInt1 += 2;
      if (paramBoolean)
      {
        util.int8_to_buf(paramArrayOfByte7, paramInt1, 9);
        paramInt1 += 1;
        util.int8_to_buf(paramArrayOfByte7, paramInt1, 1);
        paramInt1 += 1;
        util.int8_to_buf(paramArrayOfByte7, paramInt1, 1);
        paramInt1 += 1;
        util.int8_to_buf(paramArrayOfByte7, paramInt1, 10);
        paramInt1 += 1;
        util.int8_to_buf(paramArrayOfByte7, paramInt1, paramArrayOfByte4.length);
        paramInt1 += 1;
        System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte7, paramInt1, paramArrayOfByte4.length);
        paramInt1 += paramArrayOfByte4.length;
        util.int8_to_buf(paramArrayOfByte7, paramInt1, 11);
        paramInt1 += 1;
        util.int8_to_buf(paramArrayOfByte7, paramInt1, paramArrayOfByte3.length);
        paramInt1 += 1;
        System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte7, paramInt1, paramArrayOfByte3.length);
        paramInt1 += paramArrayOfByte3.length;
        util.int8_to_buf(paramArrayOfByte7, paramInt1, 13);
        paramInt1 += 1;
        util.int8_to_buf(paramArrayOfByte7, paramInt1, 4);
        paramInt1 += 1;
        util.int64_to_buf32(paramArrayOfByte7, paramInt1, paramLong);
        paramInt1 += 4;
        util.int8_to_buf(paramArrayOfByte7, paramInt1, 14);
        paramInt1 += 1;
        util.int8_to_buf(paramArrayOfByte7, paramInt1, paramArrayOfByte8.length);
        paramInt1 += 1;
        System.arraycopy(paramArrayOfByte8, 0, paramArrayOfByte7, paramInt1, paramArrayOfByte8.length);
        paramInt1 = paramArrayOfByte8.length;
      }
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
        break label814;
      }
    }
    label814:
    for (paramArrayOfByte1 = h.a.getBytes();; paramArrayOfByte1 = MD5.toMD5Byte(paramArrayOfByte2))
    {
      return cryptor.encrypt(paramArrayOfByte7, 0, paramArrayOfByte7.length, paramArrayOfByte1);
      paramArrayOfByte7 = new byte[paramArrayOfByte1.length + 1 + 1 + paramArrayOfByte3.length + 1 + 1 + 2 + paramArrayOfByte5.length + 2 + arrayOfByte.length + 2 + paramArrayOfByte6.length + 2 + 1 + 2 + 4 + 4];
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */