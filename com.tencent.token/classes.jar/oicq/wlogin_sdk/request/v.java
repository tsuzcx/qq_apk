package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t112;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class v
  extends oicq_request
{
  public v(t paramt)
  {
    this.t = 2064;
    this.u = 17;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, String paramString, int paramInt2, int paramInt3, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.w;
    int i = 0;
    for (;;)
    {
      Object localObject = a(paramLong1, paramLong2, paramInt1, j, paramArrayOfByte, paramString.getBytes(), paramInt2, paramInt3, paramArrayOfLong);
      a(this.i, this.t, this.j, this.x.f, this.m, this.n, j, this.p, (byte[])localObject);
      int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (k != 0) {
        return k;
      }
      k = b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("retry num:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" ret:");
      ((StringBuilder)localObject).append(k);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.x.f);
      util.LOGI((String)localObject, localStringBuilder.toString());
      if (k != 180) {
        return k;
      }
      if (i >= 1) {
        return k;
      }
      i += 1;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, long[] paramArrayOfLong)
  {
    int[] arrayOfInt = new int[9];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 256;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 264;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 265;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 8;
    int[] tmp31_26 = tmp26_20;
    tmp31_26[4] = 322;
    int[] tmp37_31 = tmp31_26;
    tmp37_31[5] = 325;
    int[] tmp43_37 = tmp37_31;
    tmp43_37[6] = 340;
    int[] tmp50_43 = tmp43_37;
    tmp50_43[7] = 274;
    int[] tmp57_50 = tmp50_43;
    tmp57_50[8] = 278;
    tmp57_50;
    ArrayList localArrayList = new ArrayList();
    int i1 = tmp14_8.length;
    int j = 0;
    int k = 0;
    int m;
    for (int i = 0; j < i1; i = m)
    {
      byte[] arrayOfByte = new byte[0];
      m = tmp14_8[j];
      if (m != 8)
      {
        if (m != 256)
        {
          if (m != 274)
          {
            if (m != 278)
            {
              if (m != 322)
              {
                if (m != 325)
                {
                  if (m != 340) {
                    switch (m)
                    {
                    default: 
                      break;
                    case 265: 
                      if ((t.M != null) && (t.M.length > 0)) {
                        arrayOfByte = new tlv_t109().get_tlv_109(t.M);
                      }
                      break;
                    case 264: 
                      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0)) {
                        arrayOfByte = new tlv_t108().get_tlv_108(paramArrayOfByte1);
                      }
                      break;
                    }
                  } else {
                    arrayOfByte = new tlv_t154().get_tlv_154(this.x.i);
                  }
                }
                else {
                  arrayOfByte = new tlv_t145().get_tlv_145(t.A);
                }
              }
              else {
                arrayOfByte = new tlv_t142().get_tlv_142(t.E);
              }
            }
            else {
              arrayOfByte = new tlv_t116().get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
            }
          }
          else {
            arrayOfByte = new tlv_t112().get_tlv_112(paramArrayOfByte2);
          }
        }
        else {
          arrayOfByte = new tlv_t100().get_tlv_100(paramLong1, paramLong2, paramInt2, paramInt1);
        }
      }
      else {
        arrayOfByte = new tlv_t8().get_tlv_8(0, t.u, 0);
      }
      int n = k;
      m = i;
      if (arrayOfByte.length > 4)
      {
        m = i + 1;
        n = k + arrayOfByte.length;
        localArrayList.add(arrayOfByte);
      }
      j += 1;
      k = n;
    }
    paramArrayOfByte1 = new byte[k];
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < i)
    {
      paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, paramArrayOfByte2.length);
      paramInt2 += paramArrayOfByte2.length;
      paramInt1 += 1;
    }
    return b(paramArrayOfByte1, this.u, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.v
 * JD-Core Version:    0.7.0.1
 */