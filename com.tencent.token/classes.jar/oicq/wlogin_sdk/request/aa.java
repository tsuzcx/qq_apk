package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.HashMap;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t126;
import oicq.wlogin_sdk.tlv_type.tlv_t127;
import oicq.wlogin_sdk.tlv_type.tlv_t184;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class aa
  extends oicq_request
{
  public aa(u paramu)
  {
    this.t = 2064;
    this.u = 18;
    this.v = "wtlogin.login";
    this.x = paramu;
    this.x.m = 0;
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    ArrayList localArrayList = new ArrayList();
    async_context localasync_context = u.b(this.x.h);
    int k = 0;
    int j = 0;
    int m;
    for (int i = 0; k < 6; i = m)
    {
      Object localObject = new byte[0];
      m = new int[] { 260, 8, 295, 388, 278, 1313 }[k];
      if (m != 8)
      {
        if (m != 260)
        {
          if (m != 278)
          {
            if (m != 295)
            {
              if (m != 388)
              {
                if (m == 1313)
                {
                  localObject = new tlv_t(1313);
                  byte[] arrayOfByte = new byte[6];
                  util.int32_to_buf(arrayOfByte, 0, u.aA);
                  util.int16_to_buf(arrayOfByte, 4, 0);
                  ((tlv_t)localObject).set_data(arrayOfByte, 6);
                  localObject = ((tlv_t)localObject).get_buf();
                }
              }
              else {
                localObject = new tlv_t184().get_tlv_184(localasync_context._msalt, localasync_context._mpasswd);
              }
            }
            else {
              localObject = new tlv_t127().get_tlv_127(paramArrayOfByte, localasync_context._t126.get_random());
            }
          }
          else {
            localObject = new tlv_t116().get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
          }
        }
        else {
          localObject = localasync_context._t104.get_buf();
        }
      }
      else {
        localObject = new tlv_t8().get_tlv_8(0, u.v, 0);
      }
      int n = j;
      m = i;
      if (localObject.length > 4)
      {
        n = j + 1;
        m = i + localObject.length;
        localArrayList.add(localObject);
      }
      k += 1;
      j = n;
    }
    paramArrayOfByte = (tlv_t)paramWUserSigInfo._loginExtraProductTLVMap.get(Integer.valueOf(1322));
    paramInt1 = j;
    paramInt2 = i;
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = paramArrayOfByte.get_buf();
      paramInt1 = j + 1;
      paramInt2 = i + paramArrayOfByte.length;
      localArrayList.add(paramArrayOfByte);
    }
    paramArrayOfByte = new byte[paramInt2];
    paramInt2 = 0;
    i = 0;
    while (paramInt2 < paramInt1)
    {
      paramArrayOfLong = (byte[])localArrayList.get(paramInt2);
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte, i, paramArrayOfLong.length);
      i += paramArrayOfLong.length;
      paramInt2 += 1;
    }
    return b(paramArrayOfByte, this.u, paramInt1);
  }
  
  public int a(String paramString, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int m = u.x;
    int i = 0;
    int j;
    for (;;)
    {
      Object localObject = a(paramString.getBytes(), paramInt1, paramInt2, paramArrayOfLong, paramWUserSigInfo);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.aa
 * JD-Core Version:    0.7.0.1
 */