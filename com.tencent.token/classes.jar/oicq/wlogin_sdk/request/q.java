package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t113;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t174;
import oicq.wlogin_sdk.tlv_type.tlv_t17c;
import oicq.wlogin_sdk.tlv_type.tlv_t184;
import oicq.wlogin_sdk.tlv_type.tlv_t401;
import oicq.wlogin_sdk.tlv_type.tlv_t402;
import oicq.wlogin_sdk.tlv_type.tlv_t403;
import oicq.wlogin_sdk.tlv_type.tlv_t542;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class q
  extends oicq_request
{
  private int K = 0;
  
  public q(u paramu)
  {
    this.t = 2064;
    this.u = 7;
    this.v = "wtlogin.login";
    this.x = paramu;
    this.x.m = 0;
  }
  
  public int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2)
  {
    int m = u.x;
    async_context localasync_context = u.b(this.x.h);
    tlv_t104 localtlv_t104 = localasync_context._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    tlv_t174 localtlv_t174 = localasync_context._t174;
    if (localtlv_t174 == null) {
      localtlv_t174 = new tlv_t174();
    }
    Object localObject2 = localasync_context._t402;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new tlv_t402();
    }
    tlv_t403 localtlv_t403 = localasync_context._t403;
    localObject2 = localtlv_t403;
    if (localtlv_t403 == null) {
      localObject2 = new tlv_t403();
    }
    localasync_context._dpwd = util.get_mpasswd().getBytes();
    localasync_context._G = c(u.B, localasync_context._dpwd, ((tlv_t402)localObject1).get_data());
    if ((((tlv_t402)localObject1).get_data_len() > 0) && (((tlv_t403)localObject2).get_data_len() > 0)) {
      localasync_context._sec_guid_flag = true;
    }
    int i = 0;
    for (;;)
    {
      int j = i;
      localObject1 = a(localtlv_t104.get_data(), paramArrayOfByte1, localtlv_t174.get_data(), paramInt1, paramInt2, paramArrayOfLong, localasync_context._G, paramArrayOfByte2, paramWUserSigInfo, localasync_context);
      a(this.i, this.t, this.j, this.x.f, this.m, this.n, m, this.p, (byte[])localObject1);
      int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      i = k;
      if (k != 0) {
        break;
      }
      k = b();
      localObject1 = new StringBuilder("retry num:");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(" ret:");
      ((StringBuilder)localObject1).append(k);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.x.f);
      util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
      i = k;
      if (k != 180) {
        break;
      }
      i = j + 1;
      if (j > 0) {
        return k;
      }
    }
    return i;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, long[] paramArrayOfLong, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, WUserSigInfo paramWUserSigInfo, async_context paramasync_context)
  {
    int[] arrayOfInt = new int[8];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 8;
    int[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 260;
    int[] tmp19_13 = tmp13_8;
    tmp19_13[2] = 278;
    int[] tmp25_19 = tmp19_13;
    tmp25_19[3] = 372;
    int[] tmp31_25 = tmp25_19;
    tmp31_25[4] = 380;
    int[] tmp37_31 = tmp31_25;
    tmp37_31[5] = 1025;
    int[] tmp43_37 = tmp37_31;
    tmp43_37[6] = 408;
    int[] tmp50_43 = tmp43_37;
    tmp50_43[7] = 1346;
    tmp50_43;
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer("request_checksms");
    localStringBuffer.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
    int j = 0;
    int k;
    for (int i = 0; j < 8; i = k)
    {
      Object localObject = null;
      k = arrayOfInt[j];
      if (k != 8)
      {
        if (k != 260)
        {
          if (k != 278)
          {
            if (k != 372)
            {
              if (k != 380)
              {
                if (k != 408)
                {
                  if (k != 1025)
                  {
                    if (k == 1346)
                    {
                      localObject = new tlv_t542().get_tlv_542(paramArrayOfByte5);
                      StringBuilder localStringBuilder = new StringBuilder("checksms tlv542:");
                      if (localObject != null) {
                        k = localObject.length;
                      } else {
                        k = 0;
                      }
                      localStringBuilder.append(k);
                      util.LOGI(localStringBuilder.toString(), "");
                    }
                  }
                  else {
                    localObject = new tlv_t401().get_tlv_401(paramArrayOfByte4);
                  }
                }
                else
                {
                  localObject = new tlv_t(408);
                  ((tlv_t)localObject).set_data(new byte[] { (byte)t.K }, 1);
                  localObject = ((tlv_t)localObject).get_buf();
                }
              }
              else {
                localObject = new tlv_t17c().get_tlv_17c(paramArrayOfByte2);
              }
            }
            else {
              localObject = new tlv_t174().get_tlv_174(paramArrayOfByte3);
            }
          }
          else {
            localObject = new tlv_t116().get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
          }
        }
        else {
          localObject = new tlv_t104().get_tlv_104(paramArrayOfByte1);
        }
      }
      else {
        localObject = new tlv_t8().get_tlv_8(0, u.v, 0);
      }
      k = i;
      if (localObject != null)
      {
        localArrayList.add(localObject);
        k = i + localObject.length;
      }
      j += 1;
    }
    localStringBuffer.append(",_msalt=");
    localStringBuffer.append(Long.toHexString(paramasync_context._msalt));
    paramInt1 = i;
    if (paramasync_context._msalt > 0L)
    {
      localStringBuffer.append(",_mpasswd=");
      localStringBuffer.append(paramasync_context._mpasswd);
      paramArrayOfByte1 = new tlv_t184().get_tlv_184(paramasync_context._msalt, paramasync_context._mpasswd);
      localArrayList.add(paramArrayOfByte1);
      paramInt1 = i + paramArrayOfByte1.length;
    }
    paramArrayOfByte1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
    while (paramArrayOfByte1.hasNext())
    {
      paramArrayOfByte2 = (Integer)paramArrayOfByte1.next();
      paramArrayOfByte3 = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte2)).get_buf();
      localArrayList.add(paramArrayOfByte3);
      paramInt1 += paramArrayOfByte3.length;
      util.LOGI("Extra Tlv from user：0x".concat(String.valueOf(paramArrayOfByte2)));
    }
    i = localArrayList.size();
    paramArrayOfByte1 = new byte[paramInt1];
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < i)
    {
      paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, paramArrayOfByte2.length);
      paramInt2 += paramArrayOfByte2.length;
      paramInt1 += 1;
    }
    util.LOGI(localStringBuffer.toString(), "");
    return b(paramArrayOfByte1, this.u, i);
  }
  
  public q b(int paramInt)
  {
    this.K = paramInt;
    return this;
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.K == 2) {
      return e(paramArrayOfByte, paramInt1, paramInt2);
    }
    StringBuilder localStringBuilder = new StringBuilder("request_checksms");
    localStringBuilder.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
    localStringBuilder.append(" super get_response_body");
    util.LOGI(localStringBuilder.toString(), "");
    return super.d(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer("request_checksms");
    localStringBuffer.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
    localStringBuffer.append("get_response_body");
    if (paramInt2 < 5)
    {
      localStringBuffer.append(",len < 5");
      util.LOGI(localStringBuffer.toString(), "");
      return -1009;
    }
    async_context localasync_context = u.b(this.x.h);
    paramInt2 = c(paramArrayOfByte, paramInt1 + 2);
    localStringBuffer.append(",ret=");
    localStringBuffer.append(paramInt2);
    paramInt1 += 5;
    Object localObject = new tlv_t113();
    int i = ((tlv_t113)localObject).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
    localStringBuffer.append(",ret113=");
    localStringBuffer.append(i);
    if (i >= 0)
    {
      this.x.f = ((tlv_t113)localObject).get_uin();
      localasync_context._uin = this.x.f;
      localStringBuffer.append(",ret113 uin=");
      localStringBuffer.append(this.x.f);
    }
    localObject = new tlv_t104();
    i = ((tlv_t104)localObject).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
    localStringBuffer.append(",ret104=");
    localStringBuffer.append(i);
    if (i >= 0) {
      localasync_context._t104 = ((tlv_t104)localObject);
    }
    if (paramInt2 != 0)
    {
      c(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
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
    }
    util.LOGI(localStringBuffer.toString(), "");
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.q
 * JD-Core Version:    0.7.0.1
 */