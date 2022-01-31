package oicq.wlogin_sdk.code2d;

import java.util.ArrayList;
import oicq.wlogin_sdk.b.a;
import oicq.wlogin_sdk.request.y;
import oicq.wlogin_sdk.tools.util;

public class fetch_code
  extends b
{
  public fetch_code()
  {
    this._cmd = 49;
  }
  
  public byte[] get_request(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte, QRCodeCustom paramQRCodeCustom, long paramLong4, long paramLong5)
  {
    int i = paramArrayOfByte.length + 17 + 2;
    int[] arrayOfInt = new int[4];
    int[] tmp17_15 = arrayOfInt;
    tmp17_15[0] = 22;
    int[] tmp22_17 = tmp17_15;
    tmp22_17[1] = 27;
    int[] tmp27_22 = tmp22_17;
    tmp27_22[2] = 29;
    int[] tmp32_27 = tmp27_22;
    tmp32_27[3] = 31;
    tmp32_27;
    int n = tmp32_27.length;
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    if (m < n)
    {
      a locala = new a();
      locala.a(tmp32_27[m]);
      byte[] arrayOfByte;
      switch (tmp32_27[m])
      {
      default: 
        arrayOfByte = null;
        j = 0;
      }
      for (;;)
      {
        k = i;
        if (arrayOfByte != null)
        {
          locala.b(arrayOfByte, j);
          locala.d();
          arrayOfByte = locala.a();
          k = i + arrayOfByte.length;
          localArrayList.add(arrayOfByte);
        }
        m += 1;
        i = k;
        break;
        arrayOfByte = getAppInfo(paramLong2, paramLong3);
        j = arrayOfByte.length;
        continue;
        arrayOfByte = new byte[30];
        util.int32_to_buf(arrayOfByte, 0, paramQRCodeCustom.Micro);
        util.int32_to_buf(arrayOfByte, 4, paramQRCodeCustom.Version);
        util.int32_to_buf(arrayOfByte, 8, paramQRCodeCustom.Size);
        util.int32_to_buf(arrayOfByte, 12, paramQRCodeCustom.Margin);
        util.int32_to_buf(arrayOfByte, 16, paramQRCodeCustom.Dpi);
        util.int32_to_buf(arrayOfByte, 20, paramQRCodeCustom.EcLevel);
        util.int32_to_buf(arrayOfByte, 24, paramQRCodeCustom.Hint);
        util.int16_to_buf(arrayOfByte, 28, 0);
        i += 30;
        j = 30;
        continue;
        arrayOfByte = new byte[14];
        util.int8_to_buf(arrayOfByte, 0, 1);
        util.int64_to_buf32(arrayOfByte, 1, paramLong4);
        util.int64_to_buf32(arrayOfByte, 5, paramLong5);
        util.int8_to_buf(arrayOfByte, 9, 0);
        util.int64_to_buf32(arrayOfByte, 10, 0L);
        j = 14;
        continue;
        j = y.I.length + 3 + 2 + y.H.length + 2 + 2 + y.A.length + 2 + 0 + 2 + y.D.length;
        arrayOfByte = new byte[j];
        util.int8_to_buf(arrayOfByte, 0, y.V);
        k = fill_staff(arrayOfByte, y.I, 1);
        k = fill_staff(arrayOfByte, y.H, k);
        util.int16_to_buf(arrayOfByte, k, y.B);
        k = fill_staff(arrayOfByte, y.A, k + 2);
        k = fill_staff(arrayOfByte, new byte[0], k);
        fill_staff(arrayOfByte, y.D, k);
      }
    }
    paramQRCodeCustom = new byte[i];
    util.int64_to_buf32(paramQRCodeCustom, 2, paramLong2);
    util.int64_to_buf(paramQRCodeCustom, 6, paramLong1);
    util.int8_to_buf(paramQRCodeCustom, 14, 8);
    i = fill_staff(paramQRCodeCustom, paramArrayOfByte, 15);
    int k = localArrayList.size();
    util.int16_to_buf(paramQRCodeCustom, i, k);
    int j = i + 2;
    i = 0;
    while (i < k)
    {
      paramArrayOfByte = (byte[])localArrayList.get(i);
      System.arraycopy(paramArrayOfByte, 0, paramQRCodeCustom, j, paramArrayOfByte.length);
      j += paramArrayOfByte.length;
      i += 1;
    }
    return get_request(paramLong1, true, paramQRCodeCustom);
  }
  
  public int get_response(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = get_response(paramArrayOfByte, 0);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 11)) {
      return -1009;
    }
    _status.h = util.buf_to_int32(paramArrayOfByte, 2);
    _status.b = util.buf_to_int8(paramArrayOfByte, 6);
    if (_status.b != 0)
    {
      i = util.buf_to_int16(paramArrayOfByte, 7);
      _status.f = new byte[i];
      System.arraycopy(paramArrayOfByte, 9, _status.f, 0, i);
      return _status.b;
    }
    int i = util.buf_to_int16(paramArrayOfByte, 7);
    c.i = new byte[i];
    System.arraycopy(paramArrayOfByte, 9, c.i, 0, i);
    i += 9;
    int k = util.buf_to_int16(paramArrayOfByte, i);
    i += 2;
    int j = 0;
    if (j < k)
    {
      int m = util.buf_to_int16(paramArrayOfByte, i);
      i += 2;
      int n = util.buf_to_int16(paramArrayOfByte, i);
      i += 2;
      switch (m)
      {
      }
      for (;;)
      {
        j += 1;
        break;
        _status.j = new byte[n];
        System.arraycopy(paramArrayOfByte, i, _status.j, 0, n);
        i += n;
        continue;
        _status.k = util.buf_to_int32(paramArrayOfByte, i);
        i += 4;
        _status.l = util.buf_to_int16(paramArrayOfByte, i);
        i += 2;
      }
    }
    return _status.b;
  }
  
  public static class QRCodeCustom
  {
    public int Dpi = 72;
    public int EcLevel = 2;
    public int Hint = 2;
    public int Margin = 4;
    public int Micro = 0;
    public int Size = 3;
    public int Version = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.fetch_code
 * JD-Core Version:    0.7.0.1
 */