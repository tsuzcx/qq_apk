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
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class d
  extends oicq_request
{
  private String K;
  
  public d(u paramu, String paramString)
  {
    this.t = 2064;
    this.u = 22;
    this.v = "wtlogin.login";
    this.x = paramu;
    this.x.m = 0;
    this.K = paramString;
  }
  
  public int a(int paramInt1, int paramInt2, WUserSigInfo paramWUserSigInfo)
  {
    int i = 0;
    int j;
    for (;;)
    {
      Object localObject = a(paramInt1, paramInt2);
      a(this.x.f, (byte[])localObject, this.y);
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
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    async_context localasync_context = u.b(this.x.h);
    int j = 0;
    int k = 0;
    byte[] arrayOfByte;
    int m;
    for (int i = 0; j < 12; i = m)
    {
      arrayOfByte = new byte[0];
      switch (new int[] { 8, 256, 264, 265, 1325, 278, 322, 325, 340, 387, 388, 1312 }[j])
      {
      default: 
        localObject = arrayOfByte;
        break;
      case 1325: 
        localObject = new tlv_t52d().get_tlv_52d(u.u);
        break;
      case 1312: 
        localObject = new tlv_t(1312);
        arrayOfByte = util.string_to_buf(this.K);
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
        localObject = new tlv_t145().get_tlv_145(u.B);
        break;
      case 322: 
        localObject = new tlv_t142().get_tlv_142(u.F);
        break;
      case 278: 
        localObject = new tlv_t116().get_tlv_116(paramInt1, paramInt2, localasync_context._sub_appid_list);
        break;
      case 265: 
        localObject = new tlv_t109().get_tlv_109(u.P);
        break;
      case 264: 
        localObject = arrayOfByte;
        if (u.ad != null)
        {
          localObject = arrayOfByte;
          if (u.ad.length != 0)
          {
            localObject = new tlv_t108();
            arrayOfByte = u.ad;
            ((tlv_t108)localObject).set_data(arrayOfByte, arrayOfByte.length);
            localObject = ((tlv_t108)localObject).get_buf();
          }
        }
        break;
      case 256: 
        localObject = new tlv_t100().get_tlv_100(localasync_context._appid, localasync_context._sub_appid, 0, localasync_context._main_sigmap);
        break;
      case 8: 
        localObject = new tlv_t8().get_tlv_8(0, u.v, 0);
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
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */