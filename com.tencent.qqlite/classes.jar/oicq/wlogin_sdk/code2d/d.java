package oicq.wlogin_sdk.code2d;

import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.request.o;
import oicq.wlogin_sdk.tools.util;

public class d
  extends b
{
  public d()
  {
    this._cmd = 18;
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte3 = get_response(paramArrayOfByte, 0);
    if ((arrayOfByte3 == null) || (arrayOfByte3.length < 8)) {
      return -1009;
    }
    _status.h = util.buf_to_int32(arrayOfByte3, 2);
    _status.b = util.buf_to_int8(arrayOfByte3, 6);
    if (_status.b != 0) {
      return _status.b;
    }
    _status.a = util.buf_to_int64(arrayOfByte3, 7);
    _status.c = util.buf_to_int32(arrayOfByte3, 15);
    _status.e = new ArrayList();
    int k = util.buf_to_int16(arrayOfByte3, 19);
    int i = 21;
    int j = 0;
    byte[] arrayOfByte1 = null;
    paramArrayOfByte = null;
    if (j < k)
    {
      int m = util.buf_to_int16(arrayOfByte3, i);
      int n = i + 2;
      i = util.buf_to_int16(arrayOfByte3, n);
      n += 2;
      switch (m)
      {
      default: 
        byte[] arrayOfByte4 = new byte[i + 4];
        System.arraycopy(arrayOfByte3, n - 4, arrayOfByte4, 0, arrayOfByte4.length);
        _status.e.add(arrayOfByte4);
        i = n + i;
      }
      for (;;)
      {
        j += 1;
        break;
        _status.m = util.buf_to_int16(arrayOfByte3, n);
        m = n + 2;
        i = util.buf_to_int16(arrayOfByte3, m);
        m += 2;
        _status.n = new byte[i];
        System.arraycopy(arrayOfByte3, m, _status.n, 0, i);
        i = m + i;
        continue;
        _status.o = util.buf_to_int16(arrayOfByte3, n);
        m = n + 2;
        i = util.buf_to_int16(arrayOfByte3, m);
        m += 2;
        _status.p = new byte[i];
        System.arraycopy(arrayOfByte3, m, _status.p, 0, i);
        i = m + i;
        continue;
        paramArrayOfByte = new byte[i];
        System.arraycopy(arrayOfByte3, n, paramArrayOfByte, 0, i);
        i = n + i;
        continue;
        arrayOfByte2 = new byte[i];
        System.arraycopy(arrayOfByte3, n, arrayOfByte2, 0, i);
        i = n + i;
        continue;
        arrayOfByte1 = new byte[i];
        System.arraycopy(arrayOfByte3, n, arrayOfByte1, 0, i);
        i = n + i;
      }
    }
    if ((paramArrayOfByte == null) || (arrayOfByte1 == null) || (arrayOfByte2 == null)) {
      return -1009;
    }
    c.q = o.b(paramArrayOfByte, arrayOfByte1);
    c.r = arrayOfByte2;
    return _status.b;
  }
  
  public byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length + 8 + 8 + 1 + 2 + paramArrayOfByte2.length + 2];
    util.int64_to_buf32(paramArrayOfByte2, 2, paramLong2);
    int i = fill_staff(paramArrayOfByte2, paramArrayOfByte1, 6);
    util.int64_to_buf(paramArrayOfByte2, i, paramLong1);
    i += 8;
    util.int8_to_buf(paramArrayOfByte2, i, 8);
    return get_request(paramLong1, true, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.d
 * JD-Core Version:    0.7.0.1
 */