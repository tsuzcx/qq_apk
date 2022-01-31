package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import oicq.wlogin_sdk.tlv_type.tlv_t184;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class c
  extends oicq_request
{
  private String I;
  
  public c(t paramt, String paramString)
  {
    this.t = 2064;
    this.u = 22;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
    this.I = paramString;
  }
  
  public int a(int paramInt1, int paramInt2, WUserSigInfo paramWUserSigInfo)
  {
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = a(paramInt1, paramInt2);
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
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    int i = 0;
    int[] arrayOfInt = new int[11];
    int[] tmp10_8 = arrayOfInt;
    tmp10_8[0] = 8;
    int[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 256;
    int[] tmp21_15 = tmp15_10;
    tmp21_15[2] = 264;
    int[] tmp27_21 = tmp21_15;
    tmp27_21[3] = 265;
    int[] tmp33_27 = tmp27_21;
    tmp33_27[4] = 278;
    int[] tmp39_33 = tmp33_27;
    tmp39_33[5] = 322;
    int[] tmp45_39 = tmp39_33;
    tmp45_39[6] = 325;
    int[] tmp52_45 = tmp45_39;
    tmp52_45[7] = 340;
    int[] tmp59_52 = tmp52_45;
    tmp59_52[8] = 387;
    int[] tmp66_59 = tmp59_52;
    tmp66_59[9] = 388;
    int[] tmp73_66 = tmp66_59;
    tmp73_66[10] = 1312;
    tmp73_66;
    ArrayList localArrayList = new ArrayList();
    int m = arrayOfInt.length;
    int j = 0;
    async_context localasync_context = t.b(this.x.h);
    int k = 0;
    byte[] arrayOfByte;
    Object localObject;
    if (k < m)
    {
      arrayOfByte = new byte[0];
      switch (arrayOfInt[k])
      {
      default: 
        localObject = arrayOfByte;
        label232:
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
      localObject = new tlv_t8().get_tlv_8(0, t.u, 0);
      break label232;
      localObject = new tlv_t100().get_tlv_100(localasync_context._appid, localasync_context._sub_appid, 0, localasync_context._main_sigmap);
      break label232;
      localObject = arrayOfByte;
      if (t.aa == null) {
        break label232;
      }
      localObject = arrayOfByte;
      if (t.aa.length == 0) {
        break label232;
      }
      localObject = new tlv_t108();
      ((tlv_t108)localObject).set_data(t.aa, t.aa.length);
      localObject = ((tlv_t108)localObject).get_buf();
      break label232;
      localObject = new tlv_t109().get_tlv_109(t.M);
      break label232;
      localObject = new tlv_t116().get_tlv_116(paramInt1, paramInt2, localasync_context._sub_appid_list);
      break label232;
      localObject = new tlv_t142().get_tlv_142(t.E);
      break label232;
      localObject = new tlv_t145().get_tlv_145(t.A);
      break label232;
      localObject = new tlv_t154().get_tlv_154(this.x.i);
      break label232;
      localObject = new tlv_t183().get_tlv_183(localasync_context._msalt);
      break label232;
      localObject = new tlv_t184().get_tlv_184(localasync_context._msalt, localasync_context._mpasswd);
      break label232;
      localObject = new tlv_t(1312);
      arrayOfByte = util.string_to_buf(this.I);
      ((tlv_t)localObject).set_data(arrayOfByte, arrayOfByte.length);
      localObject = ((tlv_t)localObject).get_buf();
      break label232;
      localObject = new byte[j];
      paramInt2 = 0;
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        arrayOfByte = (byte[])localArrayList.get(paramInt1);
        System.arraycopy(arrayOfByte, 0, localObject, paramInt2, arrayOfByte.length);
        paramInt2 += arrayOfByte.length;
        paramInt1 += 1;
      }
      return b((byte[])localObject, this.u, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.c
 * JD-Core Version:    0.7.0.1
 */