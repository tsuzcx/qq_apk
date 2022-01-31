package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class h
  extends a
{
  int h = 3;
  int i = 5;
  int j = 98;
  
  public h()
  {
    this.g = 262;
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3, long paramLong4, byte[] paramArrayOfByte4, int paramInt3, byte[] paramArrayOfByte5, int paramInt4)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    paramArrayOfByte2 = paramArrayOfByte3;
    if (paramArrayOfByte3 == null) {
      paramArrayOfByte2 = new byte[0];
    }
    paramArrayOfByte3 = paramArrayOfByte4;
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte3 = new byte[0];
    }
    paramArrayOfByte4 = paramArrayOfByte5;
    if (paramArrayOfByte5 == null) {
      paramArrayOfByte4 = new byte[0];
    }
    paramArrayOfByte5 = new byte[this.j];
    util.int16_to_buf(paramArrayOfByte5, 0, this.h);
    util.int32_to_buf(paramArrayOfByte5, 2, util.get_rand_32());
    util.int32_to_buf(paramArrayOfByte5, 6, this.i);
    util.int32_to_buf(paramArrayOfByte5, 10, (int)paramLong1);
    util.int32_to_buf(paramArrayOfByte5, 14, paramInt1);
    util.int64_to_buf(paramArrayOfByte5, 18, paramLong3);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte5, 26, arrayOfByte.length);
    paramInt1 = arrayOfByte.length + 26;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte1.length);
    paramInt1 += paramArrayOfByte1.length;
    util.int8_to_buf(paramArrayOfByte5, paramInt1, paramInt2);
    paramInt1 += 1;
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte3.length);
    paramInt1 += paramArrayOfByte3.length;
    util.int32_to_buf(paramArrayOfByte5, paramInt1, 0);
    paramInt1 += 4;
    util.int8_to_buf(paramArrayOfByte5, paramInt1, paramInt3);
    paramInt1 += 1;
    if ((paramArrayOfByte4 == null) || (paramArrayOfByte4.length <= 0))
    {
      paramArrayOfByte1 = new byte[16];
      util.int32_to_buf(paramArrayOfByte1, 0, util.get_rand_32());
      util.int32_to_buf(paramArrayOfByte1, 4, util.get_rand_32());
      util.int32_to_buf(paramArrayOfByte1, 8, util.get_rand_32());
      util.int32_to_buf(paramArrayOfByte1, 12, util.get_rand_32());
      paramInt1 += paramArrayOfByte1.length;
      util.int64_to_buf32(paramArrayOfByte5, paramInt1, paramLong2);
      paramInt1 += 4;
      util.int32_to_buf(paramArrayOfByte5, paramInt1, paramInt4);
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte2.length);
      if (paramLong4 != 0L) {
        break label461;
      }
      util.int64_to_buf(paramArrayOfByte1, 16, paramLong3);
    }
    for (;;)
    {
      paramArrayOfByte1 = MD5.toMD5Byte(paramArrayOfByte1);
      paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte5, 0, paramArrayOfByte5.length, paramArrayOfByte1);
      this.j = paramArrayOfByte1.length;
      a(this.g);
      b(paramArrayOfByte1, this.j);
      d();
      return a();
      System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte4.length);
      paramInt1 += paramArrayOfByte4.length;
      break;
      label461:
      util.int64_to_buf(paramArrayOfByte1, 16, paramLong4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.h
 * JD-Core Version:    0.7.0.1
 */