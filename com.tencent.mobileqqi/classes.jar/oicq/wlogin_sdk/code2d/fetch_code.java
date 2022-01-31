package oicq.wlogin_sdk.code2d;

import java.util.ArrayList;
import oicq.wlogin_sdk.b.a;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tools.util;

public class fetch_code
  extends b
{
  public fetch_code()
  {
    this._cmd = 49;
  }
  
  public byte[] get_request(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, QRCodeCustom paramQRCodeCustom, long paramLong4, long paramLong5, byte[] paramArrayOfByte2)
  {
    int i = paramArrayOfByte1.length;
    int[] arrayOfInt = new int[5];
    int[] tmp12_10 = arrayOfInt;
    tmp12_10[0] = 17;
    int[] tmp17_12 = tmp12_10;
    tmp17_12[1] = 22;
    int[] tmp22_17 = tmp17_12;
    tmp22_17[2] = 27;
    int[] tmp27_22 = tmp22_17;
    tmp27_22[3] = 29;
    int[] tmp32_27 = tmp27_22;
    tmp32_27[4] = 31;
    tmp32_27;
    int n = tmp27_22.length;
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k = i + 17 + 2;
    if (j < n)
    {
      a locala = new a();
      locala.a(tmp27_22[j]);
      Object localObject2 = null;
      int m = 0;
      Object localObject1;
      switch (tmp27_22[j])
      {
      default: 
        localObject1 = localObject2;
        i = m;
      }
      for (;;)
      {
        m = k;
        if (localObject1 != null)
        {
          locala.b((byte[])localObject1, i);
          locala.d();
          localObject1 = locala.a();
          m = k + localObject1.length;
          localArrayList.add(localObject1);
        }
        j += 1;
        k = m;
        break;
        i = m;
        localObject1 = localObject2;
        if (paramArrayOfByte2 != null)
        {
          i = m;
          localObject1 = localObject2;
          if (paramArrayOfByte2.length > 0)
          {
            i = paramArrayOfByte2.length;
            util.LOGI("qrpushsig of " + paramLong2, paramLong1 + "");
            localObject1 = paramArrayOfByte2;
            continue;
            localObject1 = getAppInfo(paramLong2, paramLong3);
            i = localObject1.length;
            continue;
            i = 30;
            localObject1 = new byte[30];
            util.int32_to_buf((byte[])localObject1, 0, paramQRCodeCustom.Micro);
            util.int32_to_buf((byte[])localObject1, 4, paramQRCodeCustom.Version);
            util.int32_to_buf((byte[])localObject1, 8, paramQRCodeCustom.Size);
            util.int32_to_buf((byte[])localObject1, 12, paramQRCodeCustom.Margin);
            util.int32_to_buf((byte[])localObject1, 16, paramQRCodeCustom.Dpi);
            util.int32_to_buf((byte[])localObject1, 20, paramQRCodeCustom.EcLevel);
            util.int32_to_buf((byte[])localObject1, 24, paramQRCodeCustom.Hint);
            util.int16_to_buf((byte[])localObject1, 28, 0);
            continue;
            i = 14;
            localObject1 = new byte[14];
            util.int8_to_buf((byte[])localObject1, 0, 1);
            util.int64_to_buf32((byte[])localObject1, 1, paramLong4);
            util.int64_to_buf32((byte[])localObject1, 5, paramLong5);
            util.int8_to_buf((byte[])localObject1, 9, 0);
            util.int64_to_buf32((byte[])localObject1, 10, 0L);
            continue;
            i = t.I.length + 3 + 2 + t.H.length + 2 + 2 + t.A.length + 2 + 0 + 2 + t.D.length;
            localObject1 = new byte[i];
            util.int8_to_buf((byte[])localObject1, 0, t.X);
            m = fill_staff((byte[])localObject1, t.I, 1);
            m = fill_staff((byte[])localObject1, t.H, m);
            util.int16_to_buf((byte[])localObject1, m, t.B);
            m = fill_staff((byte[])localObject1, t.A, m + 2);
            m = fill_staff((byte[])localObject1, new byte[0], m);
            fill_staff((byte[])localObject1, t.D, m);
          }
        }
      }
    }
    paramQRCodeCustom = new byte[k];
    util.int64_to_buf32(paramQRCodeCustom, 2, paramLong2);
    util.int64_to_buf(paramQRCodeCustom, 6, paramLong1);
    util.int8_to_buf(paramQRCodeCustom, 14, 8);
    i = fill_staff(paramQRCodeCustom, paramArrayOfByte1, 15);
    k = localArrayList.size();
    util.int16_to_buf(paramQRCodeCustom, i, k);
    j = i + 2;
    i = 0;
    while (i < k)
    {
      paramArrayOfByte1 = (byte[])localArrayList.get(i);
      System.arraycopy(paramArrayOfByte1, 0, paramQRCodeCustom, j, paramArrayOfByte1.length);
      j += paramArrayOfByte1.length;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.fetch_code
 * JD-Core Version:    0.7.0.1
 */