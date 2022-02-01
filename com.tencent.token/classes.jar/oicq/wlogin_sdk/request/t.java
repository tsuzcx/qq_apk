package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t161;
import oicq.wlogin_sdk.tlv_type.tlv_t174;
import oicq.wlogin_sdk.tlv_type.tlv_t17a;
import oicq.wlogin_sdk.tlv_type.tlv_t17b;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import oicq.wlogin_sdk.tlv_type.tlv_t542;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class t
  extends oicq_request
{
  static int K;
  
  public t(u paramu)
  {
    this.t = 2064;
    this.u = 8;
    this.v = "wtlogin.login";
    this.x = paramu;
    this.x.m = 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    int m = u.x;
    Object localObject1 = u.b(this.x.h);
    tlv_t104 localtlv_t104 = ((async_context)localObject1)._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    localObject1 = ((async_context)localObject1)._t174;
    if (localObject1 == null) {
      localObject1 = new tlv_t174();
    }
    int i = 0;
    int j;
    int k;
    do
    {
      j = i;
      Object localObject2 = a(localtlv_t104.get_data(), paramLong, ((tlv_t174)localObject1).get_data(), paramInt1, paramInt2, paramArrayOfLong, paramArrayOfByte);
      a(this.i, this.t, this.j, this.x.f, this.m, this.n, m, this.p, (byte[])localObject2);
      k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      i = k;
      if (k != 0) {
        break;
      }
      k = b();
      localObject2 = new StringBuilder("retry num:");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(" ret:");
      ((StringBuilder)localObject2).append(k);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.x.f);
      util.LOGI((String)localObject2, localStringBuilder.toString());
      i = k;
      if (k != 180) {
        break;
      }
      i = j + 1;
    } while (j <= 0);
    i = k;
    return i;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, long paramLong, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, long[] paramArrayOfLong, byte[] paramArrayOfByte3)
  {
    Object localObject1 = new tlv_t8();
    tlv_t104 localtlv_t104 = new tlv_t104();
    tlv_t116 localtlv_t116 = new tlv_t116();
    tlv_t174 localtlv_t174 = new tlv_t174();
    Object localObject4 = new tlv_t17a();
    Object localObject2 = new tlv_t(407);
    Object localObject3 = new tlv_t542();
    localObject1 = ((tlv_t8)localObject1).get_tlv_8(0, u.v, 0);
    paramArrayOfByte1 = localtlv_t104.get_tlv_104(paramArrayOfByte1);
    paramArrayOfLong = localtlv_t116.get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
    paramArrayOfByte2 = localtlv_t174.get_tlv_174(paramArrayOfByte2);
    localObject4 = ((tlv_t17a)localObject4).get_tlv_17a(paramLong);
    paramArrayOfByte3 = ((tlv_t542)localObject3).get_tlv_542(paramArrayOfByte3);
    ((tlv_t)localObject2).set_data(new byte[] { (byte)K }, 1);
    localObject2 = ((tlv_t)localObject2).get_buf();
    localObject3 = new byte[localObject1.length + paramArrayOfByte1.length + paramArrayOfLong.length + paramArrayOfByte2.length + localObject4.length + localObject2.length + paramArrayOfByte3.length];
    System.arraycopy(localObject1, 0, localObject3, 0, localObject1.length);
    paramInt1 = localObject1.length + 0;
    System.arraycopy(paramArrayOfByte1, 0, localObject3, paramInt1, paramArrayOfByte1.length);
    paramInt1 += paramArrayOfByte1.length;
    System.arraycopy(paramArrayOfLong, 0, localObject3, paramInt1, paramArrayOfLong.length);
    paramInt1 += paramArrayOfLong.length;
    System.arraycopy(paramArrayOfByte2, 0, localObject3, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    System.arraycopy(localObject4, 0, localObject3, paramInt1, localObject4.length);
    paramInt1 += localObject4.length;
    System.arraycopy(localObject2, 0, localObject3, paramInt1, localObject2.length);
    System.arraycopy(paramArrayOfByte3, 0, localObject3, paramInt1 + localObject2.length, paramArrayOfByte3.length);
    return b((byte[])localObject3, this.u, 7);
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    tlv_t104 localtlv_t104 = new tlv_t104();
    tlv_t17b localtlv_t17b = new tlv_t17b();
    tlv_t161 localtlv_t161 = new tlv_t161();
    Object localObject = new tlv_t543();
    async_context localasync_context = u.b(this.x.h);
    StringBuffer localStringBuffer = new StringBuffer("request_flushsms");
    localStringBuffer.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
    paramInt2 = c(paramArrayOfByte, paramInt1 + 2);
    localStringBuffer.append(",type=");
    localStringBuffer.append(paramInt2);
    int i = paramInt1 + 5;
    paramInt1 = ((tlv_t543)localObject).get_tlv(paramArrayOfByte, i, this.c - i);
    localasync_context._t543 = ((tlv_t543)localObject);
    localStringBuffer.append(",tlv 543 ret=");
    localStringBuffer.append(paramInt1);
    localObject = new tlv_t183();
    paramInt1 = ((tlv_t183)localObject).get_tlv(paramArrayOfByte, i, this.c - i);
    if (paramInt1 >= 0)
    {
      localasync_context._msalt = ((tlv_t183)localObject).getMsalt();
      localStringBuffer.append(",tlv 183 ret=");
      localStringBuffer.append(paramInt1);
      localStringBuffer.append(",_msalt=");
      localStringBuffer.append(Long.toHexString(localasync_context._msalt));
    }
    if (paramInt2 != 160)
    {
      if (paramInt2 != 180)
      {
        if (paramInt2 == 239) {
          break label286;
        }
      }
      else
      {
        paramInt1 = localtlv_t161.get_tlv(paramArrayOfByte, i, this.c - i - 1);
        if (paramInt1 < 0) {
          break label283;
        }
        a(localtlv_t161);
      }
      c(paramArrayOfByte, i, this.c - i - 1);
      break label350;
      label283:
      break label355;
    }
    label286:
    paramInt1 = localtlv_t104.get_tlv(paramArrayOfByte, i, this.c - i);
    if (paramInt1 >= 0)
    {
      localasync_context._t104 = localtlv_t104;
      i = localtlv_t17b.get_tlv(paramArrayOfByte, i, this.c - i);
      paramInt1 = i;
      if (i >= 0)
      {
        localasync_context._t17b = localtlv_t17b;
        a(null);
        label350:
        paramInt1 = paramInt2;
      }
    }
    label355:
    if (localasync_context._last_err_msg != null)
    {
      localStringBuffer.append(",err type=");
      localStringBuffer.append(localasync_context._last_err_msg.getType());
      localStringBuffer.append(",err title=");
      localStringBuffer.append(localasync_context._last_err_msg.getTitle());
      localStringBuffer.append(",err msg=");
      localStringBuffer.append(localasync_context._last_err_msg.getMessage());
    }
    else
    {
      localStringBuffer.append(",err = null");
    }
    util.LOGI(localStringBuffer.toString(), "");
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.t
 * JD-Core Version:    0.7.0.1
 */