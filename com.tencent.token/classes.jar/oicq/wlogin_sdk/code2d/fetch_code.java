package oicq.wlogin_sdk.code2d;

import java.util.ArrayList;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tlv_type.tlv_t;
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
    int[] arrayOfInt = new int[7];
    int[] tmp13_11 = arrayOfInt;
    tmp13_11[0] = 17;
    int[] tmp18_13 = tmp13_11;
    tmp18_13[1] = 22;
    int[] tmp23_18 = tmp18_13;
    tmp23_18[2] = 27;
    int[] tmp28_23 = tmp23_18;
    tmp28_23[3] = 29;
    int[] tmp33_28 = tmp28_23;
    tmp33_28[4] = 31;
    int[] tmp38_33 = tmp33_28;
    tmp38_33[5] = 51;
    int[] tmp43_38 = tmp38_33;
    tmp43_38[6] = 53;
    tmp43_38;
    int j = tmp23_18.length;
    ArrayList localArrayList = new ArrayList();
    int m = i + 17 + 2;
    int k = 0;
    for (;;)
    {
      Object localObject2 = paramArrayOfByte2;
      Object localObject1 = paramQRCodeCustom;
      if (k >= j) {
        break;
      }
      tlv_t localtlv_t = new tlv_t();
      localtlv_t.fill_head(tmp23_18[k]);
      i = tmp23_18[k];
      if (i != 17)
      {
        if (i != 22)
        {
          if (i != 27)
          {
            if (i != 29)
            {
              if (i != 31)
              {
                if (i != 51)
                {
                  if (i == 53)
                  {
                    localObject1 = new byte[4];
                    util.int32_to_buf((byte[])localObject1, 0, t.au);
                    i = 4;
                    break label697;
                  }
                }
                else
                {
                  localObject1 = (byte[])t.A.clone();
                  i = localObject1.length;
                  break label697;
                }
              }
              else
              {
                i = t.K.length + 3 + 2 + t.J.length + 2 + 2 + t.C.length + 2 + 0 + 2 + t.F.length;
                localObject1 = new byte[i];
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("os ");
                ((StringBuilder)localObject2).append(new String(t.K));
                ((StringBuilder)localObject2).append(" sim info ");
                ((StringBuilder)localObject2).append(new String(t.C));
                ((StringBuilder)localObject2).append(" apn ");
                ((StringBuilder)localObject2).append(new String(t.F));
                util.LOGI(((StringBuilder)localObject2).toString(), "");
                util.int8_to_buf((byte[])localObject1, 0, t.Z);
                int n = fill_staff((byte[])localObject1, t.K, 1);
                n = fill_staff((byte[])localObject1, t.J, n);
                util.int16_to_buf((byte[])localObject1, n, t.D);
                n = fill_staff((byte[])localObject1, t.C, n + 2);
                n = fill_staff((byte[])localObject1, new byte[0], n);
                fill_staff((byte[])localObject1, t.F, n);
                break label697;
              }
            }
            else
            {
              localObject1 = new byte[14];
              util.int8_to_buf((byte[])localObject1, 0, 1);
              util.int64_to_buf32((byte[])localObject1, 1, paramLong4);
              util.int64_to_buf32((byte[])localObject1, 5, paramLong5);
              util.int8_to_buf((byte[])localObject1, 9, 0);
              util.int64_to_buf32((byte[])localObject1, 10, 0L);
              i = 14;
              break label697;
            }
          }
          else
          {
            localObject2 = new byte[30];
            util.int32_to_buf((byte[])localObject2, 0, ((QRCodeCustom)localObject1).Micro);
            util.int32_to_buf((byte[])localObject2, 4, ((QRCodeCustom)localObject1).Version);
            util.int32_to_buf((byte[])localObject2, 8, ((QRCodeCustom)localObject1).Size);
            util.int32_to_buf((byte[])localObject2, 12, ((QRCodeCustom)localObject1).Margin);
            util.int32_to_buf((byte[])localObject2, 16, ((QRCodeCustom)localObject1).Dpi);
            util.int32_to_buf((byte[])localObject2, 20, ((QRCodeCustom)localObject1).EcLevel);
            util.int32_to_buf((byte[])localObject2, 24, ((QRCodeCustom)localObject1).Hint);
            util.int16_to_buf((byte[])localObject2, 28, 0);
            localObject1 = localObject2;
            i = 30;
            break label697;
          }
        }
        else
        {
          localObject1 = getAppInfo(paramLong2, paramLong3);
          i = localObject1.length;
          break label697;
        }
      }
      else if ((localObject2 != null) && (localObject2.length > 0))
      {
        i = localObject2.length;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("qrpushsig of ");
        ((StringBuilder)localObject1).append(paramLong2);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramLong1);
        ((StringBuilder)localObject2).append("");
        util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
        localObject1 = paramArrayOfByte2;
        break label697;
      }
      localObject1 = null;
      i = 0;
      label697:
      if (localObject1 != null)
      {
        localtlv_t.fill_body((byte[])localObject1, i);
        localtlv_t.set_length();
        localObject1 = localtlv_t.get_buf();
        m += localObject1.length;
        localArrayList.add(localObject1);
      }
      k += 1;
    }
    paramQRCodeCustom = new byte[m];
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
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 11))
    {
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
      i = 9 + i;
      int k = util.buf_to_int16(paramArrayOfByte, i);
      i += 2;
      int j = 0;
      while (j < k)
      {
        int m = util.buf_to_int16(paramArrayOfByte, i);
        i += 2;
        int n = util.buf_to_int16(paramArrayOfByte, i);
        i += 2;
        if (m != 23)
        {
          if (m == 28)
          {
            _status.k = util.buf_to_int32(paramArrayOfByte, i);
            i += 4;
            _status.l = util.buf_to_int16(paramArrayOfByte, i);
            i += 2;
          }
        }
        else
        {
          _status.j = new byte[n];
          System.arraycopy(paramArrayOfByte, i, _status.j, 0, n);
          i += n;
        }
        j += 1;
      }
      return _status.b;
    }
    return -1009;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.fetch_code
 * JD-Core Version:    0.7.0.1
 */