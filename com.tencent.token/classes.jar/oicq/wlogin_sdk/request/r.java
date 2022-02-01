package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t161;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class r
  extends oicq_request
{
  public r(t paramt)
  {
    this.t = 2064;
    this.u = 3;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int m = t.w;
    tlv_t104 localtlv_t104 = t.b(this.x.h)._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    int i = 0;
    int j;
    for (;;)
    {
      Object localObject = a(localtlv_t104.get_data(), paramInt1, paramInt2, paramArrayOfLong);
      a(this.i, this.t, this.j, this.x.f, this.m, this.n, m, this.p, (byte[])localObject);
      int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      j = k;
      if (k != 0) {
        break;
      }
      k = b();
      localObject = new StringBuilder("retry num:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" ret:");
      ((StringBuilder)localObject).append(k);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.x.f);
      util.LOGI((String)localObject, localStringBuilder.toString());
      j = k;
      if (k != 180) {
        break;
      }
      if (i > 0) {
        return k;
      }
      i += 1;
    }
    return j;
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    Object localObject1 = new tlv_t8();
    tlv_t104 localtlv_t104 = new tlv_t104();
    Object localObject2 = new tlv_t116();
    localObject1 = ((tlv_t8)localObject1).get_tlv_8(0, t.u, 0);
    paramArrayOfByte = localtlv_t104.get_tlv_104(paramArrayOfByte);
    paramArrayOfLong = ((tlv_t116)localObject2).get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
    localObject2 = new byte[localObject1.length + paramArrayOfByte.length + paramArrayOfLong.length];
    System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
    paramInt1 = localObject1.length + 0;
    System.arraycopy(paramArrayOfByte, 0, localObject2, paramInt1, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfLong, 0, localObject2, paramInt1 + paramArrayOfByte.length, paramArrayOfLong.length);
    return b((byte[])localObject2, this.u, 3);
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    tlv_t104 localtlv_t104 = new tlv_t104();
    tlv_t105 localtlv_t105 = new tlv_t105();
    tlv_t165 localtlv_t165 = new tlv_t165();
    tlv_t161 localtlv_t161 = new tlv_t161();
    async_context localasync_context = t.b(this.x.h);
    int i = c(paramArrayOfByte, paramInt1 + 2);
    util.LOGD(getClass().getName(), "type=".concat(String.valueOf(i)));
    int j = paramInt1 + 5;
    if (i != 2)
    {
      if (i == 180)
      {
        paramInt2 = localtlv_t161.get_tlv(paramArrayOfByte, j, this.c - j - 1);
        paramInt1 = paramInt2;
        if (paramInt2 < 0) {
          return paramInt1;
        }
        a(localtlv_t161);
      }
      c(paramArrayOfByte, j, this.c - j - 1);
    }
    else
    {
      paramInt1 = localtlv_t104.get_tlv(paramArrayOfByte, j, this.c - j);
      if (paramInt1 < 0) {
        return paramInt1;
      }
      localasync_context._t104 = localtlv_t104;
      paramInt2 = localtlv_t105.get_tlv(paramArrayOfByte, j, this.c - j);
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        return paramInt1;
      }
      localasync_context._t105 = localtlv_t105;
      if (localtlv_t165.get_tlv(paramArrayOfByte, j, this.c - j) >= 0) {
        localasync_context._t165 = localtlv_t165;
      } else {
        localasync_context._t165 = new tlv_t165();
      }
      a(null);
    }
    return i;
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.r
 * JD-Core Version:    0.7.0.1
 */