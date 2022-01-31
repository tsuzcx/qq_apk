package oicq.wlogin_sdk.code2d;

import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.tools.util;

public class e
  extends b
{
  public e()
  {
    this._cmd = 19;
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = get_response(paramArrayOfByte, 0);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 11)) {
      return -1009;
    }
    _status.a = util.buf_to_int64(paramArrayOfByte, 2);
    _status.b = (util.buf_to_int8(paramArrayOfByte, 10) & 0xFF);
    if (_status.b != 0)
    {
      i = util.buf_to_int16(paramArrayOfByte, 11);
      _status.f = new byte[i];
      System.arraycopy(paramArrayOfByte, 13, _status.f, 0, i);
      return _status.b;
    }
    _status.c = (util.buf_to_int32(paramArrayOfByte, 11) & 0xFFFFFFFF);
    int i = util.buf_to_int16(paramArrayOfByte, 15);
    _status.d = new byte[i];
    System.arraycopy(paramArrayOfByte, 17, _status.d, 0, i);
    int j = i + 17;
    int k = util.buf_to_int16(paramArrayOfByte, j);
    _status.g = new byte[0];
    _status.e = new ArrayList(k);
    i = 0;
    j += 2;
    if (i < k)
    {
      int m = util.buf_to_int16(paramArrayOfByte, j);
      int n = util.buf_to_int16(paramArrayOfByte, j + 2);
      if (m == 13)
      {
        _status.g = new byte[n];
        System.arraycopy(paramArrayOfByte, j + 4, _status.g, 0, n);
      }
      for (;;)
      {
        j += n + 4;
        i += 1;
        break;
        if (m == 26)
        {
          if (util.buf_to_int8(paramArrayOfByte, j + 4) == 1) {}
          for (boolean bool = true;; bool = false)
          {
            c.s = bool;
            break;
          }
        }
        byte[] arrayOfByte = new byte[n + 4];
        System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, n + 4);
        _status.e.add(arrayOfByte);
      }
    }
    return _status.b;
  }
  
  public byte[] a(long paramLong1, long paramLong2, boolean paramBoolean, byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt, byte[] paramArrayOfByte5)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte1 = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      paramArrayOfByte1 = new int[0];
    }
    paramArrayOfInt = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfInt = new byte[0];
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
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0))
    {
      paramArrayOfByte5 = new byte[arrayOfByte.length + 16 + 2 + paramArrayOfInt.length + 16 + 1 + 2 + 1 + 2 + paramArrayOfByte1.length * 2 + 2 + 4 + paramArrayOfByte3.length + 4 + paramArrayOfByte4.length];
      util.int64_to_buf32(paramArrayOfByte5, 2, paramLong2);
      util.int64_to_buf(paramArrayOfByte5, 6, paramLong1);
      util.int16_to_buf(paramArrayOfByte5, 14, arrayOfByte.length);
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte5, 16, arrayOfByte.length);
      i = arrayOfByte.length + 16;
      util.int16_to_buf(paramArrayOfByte5, i, paramArrayOfInt.length);
      i += 2;
      System.arraycopy(paramArrayOfInt, 0, paramArrayOfByte5, i, paramArrayOfInt.length);
      i += paramArrayOfInt.length;
      if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length != 16)) {
        break label399;
      }
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, i, 16);
      i += 16;
    }
    for (;;)
    {
      util.int8_to_buf(paramArrayOfByte5, i, 1);
      i += 1;
      util.int16_to_buf(paramArrayOfByte5, i, paramInt);
      paramInt = i + 2;
      util.int8_to_buf(paramArrayOfByte5, paramInt, 8);
      paramInt += 1;
      util.int16_to_buf(paramArrayOfByte5, paramInt, paramArrayOfByte1.length);
      paramInt += 2;
      i = 0;
      while (i < paramArrayOfByte1.length)
      {
        util.int16_to_buf(paramArrayOfByte5, paramInt, paramArrayOfByte1[i]);
        paramInt += 2;
        i += 1;
      }
      paramArrayOfByte5 = new byte[arrayOfByte.length + 16 + 2 + paramArrayOfInt.length + 16 + 1 + 2 + 1 + 2 + paramArrayOfByte1.length * 2 + 2 + 4 + paramArrayOfByte3.length];
      break;
      label399:
      i += 16;
    }
    int j = 1;
    int i = j;
    if (paramArrayOfByte4 != null)
    {
      i = j;
      if (paramArrayOfByte4.length > 0) {
        i = 2;
      }
    }
    util.int16_to_buf(paramArrayOfByte5, paramInt, i);
    paramInt += 2;
    util.int16_to_buf(paramArrayOfByte5, paramInt, 9);
    paramInt += 2;
    util.int16_to_buf(paramArrayOfByte5, paramInt, paramArrayOfByte3.length);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt, paramArrayOfByte3.length);
    paramInt += paramArrayOfByte3.length;
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0))
    {
      util.int16_to_buf(paramArrayOfByte5, paramInt, 12);
      paramInt += 2;
      util.int16_to_buf(paramArrayOfByte5, paramInt, paramArrayOfByte4.length);
      paramInt += 2;
      System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt, paramArrayOfByte4.length);
      paramInt = paramArrayOfByte4.length;
    }
    return get_request(paramLong1, paramBoolean, paramArrayOfByte5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.e
 * JD-Core Version:    0.7.0.1
 */