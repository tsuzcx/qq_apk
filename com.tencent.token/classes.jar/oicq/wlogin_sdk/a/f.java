package oicq.wlogin_sdk.a;

import android.os.Build.VERSION;
import oicq.wlogin_sdk.tools.util;

public class f
  extends a
{
  public f()
  {
    this.b = 10;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, long paramLong3, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10)
  {
    String str = Build.VERSION.RELEASE;
    byte[] arrayOfByte = paramArrayOfByte7;
    if (paramArrayOfByte7 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte7 = paramArrayOfByte10;
    if (paramArrayOfByte10 == null) {
      paramArrayOfByte7 = new byte[0];
    }
    this.d = (paramArrayOfByte1.length + 1 + 1 + 1 + str.length() + 1 + paramArrayOfByte2.length + 1 + paramArrayOfByte3.length + 1 + 1 + 1 + 4 + 4 + 1 + paramArrayOfByte5.length + 1 + paramArrayOfByte6.length + 1 + (arrayOfByte.length + 2) + 6 + 10 + (paramArrayOfByte8.length + 2) + (paramArrayOfByte9.length + 2) + (paramArrayOfByte7.length + 5));
    paramArrayOfByte10 = new byte[this.d];
    util.int8_to_buf(paramArrayOfByte10, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte10, 1, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 1;
    util.int8_to_buf(paramArrayOfByte10, i, this.c);
    i += 1;
    util.int8_to_buf(paramArrayOfByte10, i, str.length());
    i += 1;
    System.arraycopy(str.getBytes(), 0, paramArrayOfByte10, i, str.length());
    i += str.length();
    util.int8_to_buf(paramArrayOfByte10, i, paramArrayOfByte2.length);
    i += 1;
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte10, i, paramArrayOfByte2.length);
    i += paramArrayOfByte2.length;
    util.int8_to_buf(paramArrayOfByte10, i, paramArrayOfByte3.length);
    i += 1;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte10, i, paramArrayOfByte3.length);
    i += paramArrayOfByte3.length;
    util.int8_to_buf(paramArrayOfByte10, i, paramInt1);
    paramInt1 = i + 1;
    util.int8_to_buf(paramArrayOfByte10, paramInt1, paramInt2);
    paramInt1 += 1;
    util.int8_to_buf(paramArrayOfByte10, paramInt1, paramInt3);
    paramInt1 += 1;
    util.int64_to_buf32(paramArrayOfByte10, paramInt1, paramLong1);
    paramInt1 += 4;
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length == 4))
    {
      System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte10, paramInt1, 4);
      paramInt1 += 4;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, paramArrayOfByte5.length);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte10, paramInt1, paramArrayOfByte5.length);
      paramInt1 += paramArrayOfByte5.length;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, paramArrayOfByte6.length);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte6, 0, paramArrayOfByte10, paramInt1, paramArrayOfByte6.length);
      paramInt1 += paramArrayOfByte6.length;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, 6);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, 1);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, arrayOfByte.length);
      paramInt1 += 1;
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte10, paramInt1, arrayOfByte.length);
      paramInt1 += arrayOfByte.length;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, 2);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, 8);
      paramInt1 += 1;
      util.int64_to_buf(paramArrayOfByte10, paramInt1, paramLong3);
      paramInt1 += 8;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, 3);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, paramArrayOfByte8.length);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte8, 0, paramArrayOfByte10, paramInt1, paramArrayOfByte8.length);
      paramInt1 += paramArrayOfByte8.length;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, 4);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, paramArrayOfByte9.length);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte9, 0, paramArrayOfByte10, paramInt1, paramArrayOfByte9.length);
      paramInt1 += paramArrayOfByte9.length;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, 13);
      paramInt1 += 1;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, 4);
      paramInt1 += 1;
      util.int64_to_buf32(paramArrayOfByte10, paramInt1, paramLong2);
      paramInt2 = paramInt1 + 4;
      paramInt1 = paramInt2 + 1;
      util.int8_to_buf(paramArrayOfByte10, paramInt2, 6);
      paramInt2 = paramInt1 + 1;
      util.int8_to_buf(paramArrayOfByte10, paramInt1, paramArrayOfByte7.length + 3);
      paramInt3 = paramInt2 + 1;
      if (paramArrayOfByte7.length != 0) {
        break label805;
      }
    }
    label805:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      util.int8_to_buf(paramArrayOfByte10, paramInt2, paramInt1);
      util.int16_to_buf(paramArrayOfByte10, paramInt3, paramArrayOfByte7.length);
      paramInt1 = paramInt3 + 2;
      System.arraycopy(paramArrayOfByte7, 0, paramArrayOfByte10, paramInt1, paramArrayOfByte7.length);
      paramInt1 = paramArrayOfByte7.length;
      return a(paramArrayOfByte10);
      util.int32_to_buf(paramArrayOfByte10, paramInt1, 0);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.f
 * JD-Core Version:    0.7.0.1
 */