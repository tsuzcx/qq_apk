package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t113;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import oicq.wlogin_sdk.tlv_type.tlv_t184;
import oicq.wlogin_sdk.tlv_type.tlv_t508;
import oicq.wlogin_sdk.tlv_type.tlv_t533;
import oicq.wlogin_sdk.tlv_type.tlv_t541;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class w
  extends oicq_request
{
  public w(u paramu)
  {
    this.t = 2064;
    this.u = 23;
    this.v = "wtlogin.login";
    this.x = paramu;
    this.x.m = 0;
  }
  
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, WUserSigInfo paramWUserSigInfo)
  {
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = a(paramArrayOfByte1, paramArrayOfByte2, paramWUserSigInfo.extraLoginTLVMap);
      a(this.x.f, arrayOfByte, this.y);
      int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (j != 0) {
        return j;
      }
      j = b();
      util.LOGI("retry num:" + i + " ret:" + j, "" + this.x.f);
      if (j != 180) {
        return j;
      }
      if (i >= 1) {
        return j;
      }
      i += 1;
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, Map<Integer, tlv_t> paramMap)
  {
    int i = 0;
    int[] arrayOfInt = new int[7];
    int[] tmp11_9 = arrayOfInt;
    tmp11_9[0] = 256;
    int[] tmp17_11 = tmp11_9;
    tmp17_11[1] = 322;
    int[] tmp23_17 = tmp17_11;
    tmp23_17[2] = 325;
    int[] tmp29_23 = tmp23_17;
    tmp29_23[3] = 387;
    int[] tmp35_29 = tmp29_23;
    tmp35_29[4] = 388;
    int[] tmp41_35 = tmp35_29;
    tmp41_35[5] = 1331;
    int[] tmp47_41 = tmp41_35;
    tmp47_41[6] = 1313;
    tmp47_41;
    ArrayList localArrayList = new ArrayList();
    int m = arrayOfInt.length;
    int j = 0;
    async_context localasync_context = u.b(this.x.h);
    int k = 0;
    Object localObject;
    if (k < m)
    {
      localObject = new byte[0];
      switch (arrayOfInt[k])
      {
      default: 
        label172:
        if (localObject.length > 4)
        {
          int n = localObject.length;
          localArrayList.add(localObject);
          j = n + j;
          i += 1;
        }
        break;
      }
    }
    for (;;)
    {
      k += 1;
      break;
      localObject = new tlv_t100().get_tlv_100(localasync_context._appid, localasync_context._sub_appid, 0, localasync_context._main_sigmap);
      break label172;
      localObject = new tlv_t142().get_tlv_142(u.F);
      break label172;
      localObject = new tlv_t145().get_tlv_145(u.B);
      break label172;
      localObject = new tlv_t183().get_tlv_183(localasync_context._msalt);
      break label172;
      localObject = new tlv_t184().get_tlv_184(localasync_context._msalt, localasync_context._mpasswd);
      break label172;
      localObject = new tlv_t533().get_tlv_533(paramArrayOfByte1, paramArrayOfByte2);
      break label172;
      localObject = new tlv_t(1313);
      byte[] arrayOfByte = new byte[6];
      util.int32_to_buf(arrayOfByte, 0, u.aA);
      util.int16_to_buf(arrayOfByte, 4, 0);
      ((tlv_t)localObject).set_data(arrayOfByte, 6);
      localObject = ((tlv_t)localObject).get_buf();
      break label172;
      m = j;
      k = i;
      if (paramMap != null)
      {
        paramArrayOfByte1 = paramMap.keySet().iterator();
        for (;;)
        {
          m = j;
          k = i;
          if (!paramArrayOfByte1.hasNext()) {
            break;
          }
          paramArrayOfByte2 = (tlv_t)paramMap.get((Integer)paramArrayOfByte1.next());
          if (paramArrayOfByte2 != null)
          {
            paramArrayOfByte2 = paramArrayOfByte2.get_buf();
            i += 1;
            localArrayList.add(paramArrayOfByte2);
            j += paramArrayOfByte2.length;
          }
        }
      }
      paramArrayOfByte1 = new byte[m];
      j = 0;
      i = 0;
      while (i < k)
      {
        paramArrayOfByte2 = (byte[])localArrayList.get(i);
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, j, paramArrayOfByte2.length);
        j += paramArrayOfByte2.length;
        i += 1;
      }
      return b(paramArrayOfByte1, this.u, k);
    }
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 5)
    {
      paramInt1 = -1009;
      return paramInt1;
    }
    Object localObject3 = new tlv_t104();
    tlv_t113 localtlv_t113 = new tlv_t113();
    Object localObject1 = new tlv_t(1344);
    tlv_t541 localtlv_t541 = new tlv_t541();
    Object localObject2 = u.b(this.x.h);
    paramInt2 = c(paramArrayOfByte, paramInt1 + 2);
    int j = paramInt1 + 5;
    this.x.d = null;
    switch (paramInt2)
    {
    default: 
      c(paramArrayOfByte, j, this.c - j - 1);
      paramInt1 = paramInt2;
      label130:
      localObject2 = new StringBuilder().append("request_login_by_wechat type:").append(paramInt2).append(" ret:");
      if (paramInt1 > 0)
      {
        localObject1 = "0x" + Integer.toHexString(paramInt1);
        label183:
        util.LOGI(localObject1, "" + this.x.f);
        if (paramInt1 != 0) {
          break label630;
        }
        a(null);
        paramInt2 = paramInt1;
      }
      break;
    }
    for (;;)
    {
      if ((paramInt2 != 10) && (paramInt2 != 161) && (paramInt2 != 162) && (paramInt2 != 164) && (paramInt2 != 165) && (paramInt2 != 166) && (paramInt2 != 154))
      {
        paramInt1 = paramInt2;
        if (paramInt2 < 128) {
          break;
        }
        paramInt1 = paramInt2;
        if (paramInt2 > 143) {
          break;
        }
      }
      return -1000;
      int i = ((tlv_t104)localObject3).get_tlv(paramArrayOfByte, j, this.c - j);
      paramInt1 = i;
      if (i < 0) {
        break label130;
      }
      ((async_context)localObject2)._t104 = ((tlv_t104)localObject3);
      if (((tlv_t)localObject1).get_tlv(paramArrayOfByte, j, this.c - j) > 0)
      {
        ((async_context)localObject2).tlv540 = ((tlv_t)localObject1);
        if (localtlv_t541.get_tlv(paramArrayOfByte, j, this.c - j - 1) >= 0) {
          ((async_context)localObject2)._weixinUserFlags = localtlv_t541.get_flags();
        }
        if (localtlv_t113.get_tlv(paramArrayOfByte, j, this.c - j - 1) < 0) {
          break label476;
        }
        this.x.f = localtlv_t113.get_uin();
        ((async_context)localObject2)._uin = this.x.f;
        util.LOGI("request_login_by_wechat get_response_body subCmd= 0x17 success", "" + this.x.f);
        paramInt1 = 0;
        break label130;
      }
      paramInt1 = -2002;
      break label130;
      label476:
      paramInt1 = -2003;
      break label130;
      localObject3 = new tlv_t543();
      paramInt1 = ((tlv_t543)localObject3).get_tlv(paramArrayOfByte, j, this.c - j);
      if (paramInt1 > 0)
      {
        ((async_context)localObject2)._t543 = ((tlv_t543)localObject3);
        paramInt1 = ((tlv_t)localObject1).get_tlv(paramArrayOfByte, j, this.c - j);
        if (paramInt1 <= 0) {
          break label587;
        }
        ((async_context)localObject2).tlv540 = ((tlv_t)localObject1);
        paramInt1 = 230;
        break label130;
      }
      util.LOGI("request_login_by_wechat ret oxe6 t543 is null subCmd= 0x17", "" + this.x.f);
      break label130;
      label587:
      util.LOGI("request_login_by_wechat ret oxe6 t540 is null subCmd= 0x17", "" + this.x.f);
      break label130;
      localObject1 = Integer.valueOf(paramInt1);
      break label183;
      label630:
      new tlv_t508().get_tlv(paramArrayOfByte, j, this.c - j - 1);
      paramInt2 = paramInt1;
      if (tlv_t508.doFetch)
      {
        paramArrayOfByte = new ErrMsg();
        i = new i(this.x, this.t, this.u, paramArrayOfByte).b(paramInt1);
        paramInt2 = paramInt1;
        if (i != -1000)
        {
          a(paramArrayOfByte);
          paramInt2 = i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.w
 * JD-Core Version:    0.7.0.1
 */