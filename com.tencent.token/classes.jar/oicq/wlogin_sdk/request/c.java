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
      Object localObject = a(paramInt1, paramInt2);
      a(this.x.f, (byte[])localObject, this.y);
      int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (j != 0) {
        return j;
      }
      j = b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("retry num:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" ret:");
      ((StringBuilder)localObject).append(j);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.x.f);
      util.LOGI((String)localObject, localStringBuilder.toString());
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
    int[] arrayOfInt = new int[11];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 8;
    int[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 256;
    int[] tmp19_13 = tmp13_8;
    tmp19_13[2] = 264;
    int[] tmp25_19 = tmp19_13;
    tmp25_19[3] = 265;
    int[] tmp31_25 = tmp25_19;
    tmp31_25[4] = 278;
    int[] tmp37_31 = tmp31_25;
    tmp37_31[5] = 322;
    int[] tmp43_37 = tmp37_31;
    tmp43_37[6] = 325;
    int[] tmp50_43 = tmp43_37;
    tmp50_43[7] = 340;
    int[] tmp57_50 = tmp50_43;
    tmp57_50[8] = 387;
    int[] tmp64_57 = tmp57_50;
    tmp64_57[9] = 388;
    int[] tmp71_64 = tmp64_57;
    tmp71_64[10] = 1312;
    tmp71_64;
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfInt.length;
    async_context localasync_context = t.b(this.x.h);
    int j = 0;
    int k = 0;
    byte[] arrayOfByte;
    int m;
    for (int i = 0; j < i1; i = m)
    {
      arrayOfByte = new byte[0];
      switch (arrayOfInt[j])
      {
      default: 
        localObject = arrayOfByte;
        break;
      case 1312: 
        localObject = new tlv_t(1312);
        arrayOfByte = util.string_to_buf(this.I);
        ((tlv_t)localObject).set_data(arrayOfByte, arrayOfByte.length);
        localObject = ((tlv_t)localObject).get_buf();
        break;
      case 388: 
        localObject = new tlv_t184().get_tlv_184(localasync_context._msalt, localasync_context._mpasswd);
        break;
      case 387: 
        localObject = new tlv_t183().get_tlv_183(localasync_context._msalt);
        break;
      case 340: 
        localObject = new tlv_t154().get_tlv_154(this.x.i);
        break;
      case 325: 
        localObject = new tlv_t145().get_tlv_145(t.A);
        break;
      case 322: 
        localObject = new tlv_t142().get_tlv_142(t.E);
        break;
      case 278: 
        localObject = new tlv_t116().get_tlv_116(paramInt1, paramInt2, localasync_context._sub_appid_list);
        break;
      case 265: 
        localObject = new tlv_t109().get_tlv_109(t.M);
        break;
      case 264: 
        localObject = arrayOfByte;
        if (t.aa != null)
        {
          localObject = arrayOfByte;
          if (t.aa.length != 0)
          {
            localObject = new tlv_t108();
            ((tlv_t108)localObject).set_data(t.aa, t.aa.length);
            localObject = ((tlv_t108)localObject).get_buf();
          }
        }
        break;
      case 256: 
        localObject = new tlv_t100().get_tlv_100(localasync_context._appid, localasync_context._sub_appid, 0, localasync_context._main_sigmap);
        break;
      case 8: 
        localObject = new tlv_t8().get_tlv_8(0, t.u, 0);
      }
      int n = k;
      m = i;
      if (localObject.length > 4)
      {
        m = i + 1;
        n = k + localObject.length;
        localArrayList.add(localObject);
      }
      j += 1;
      k = n;
    }
    Object localObject = new byte[k];
    paramInt1 = 0;
    paramInt2 = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.c
 * JD-Core Version:    0.7.0.1
 */