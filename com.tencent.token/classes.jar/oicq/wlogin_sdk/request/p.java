package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t174;
import oicq.wlogin_sdk.tlv_type.tlv_t17c;
import oicq.wlogin_sdk.tlv_type.tlv_t401;
import oicq.wlogin_sdk.tlv_type.tlv_t402;
import oicq.wlogin_sdk.tlv_type.tlv_t403;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class p
  extends oicq_request
{
  public p(t paramt)
  {
    this.t = 2064;
    this.u = 7;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.w;
    Object localObject3 = t.b(this.x.h);
    tlv_t104 localtlv_t104 = ((async_context)localObject3)._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    tlv_t174 localtlv_t174 = ((async_context)localObject3)._t174;
    if (localtlv_t174 == null) {
      localtlv_t174 = new tlv_t174();
    }
    Object localObject2 = ((async_context)localObject3)._t402;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new tlv_t402();
    }
    tlv_t403 localtlv_t403 = ((async_context)localObject3)._t403;
    localObject2 = localtlv_t403;
    if (localtlv_t403 == null) {
      localObject2 = new tlv_t403();
    }
    ((async_context)localObject3)._dpwd = util.get_mpasswd().getBytes();
    ((async_context)localObject3)._G = c(t.A, ((async_context)localObject3)._dpwd, ((tlv_t402)localObject1).get_data());
    if ((((tlv_t402)localObject1).get_data_len() > 0) && (((tlv_t403)localObject2).get_data_len() > 0)) {
      ((async_context)localObject3)._sec_guid_flag = true;
    }
    int i = 0;
    localObject1 = localObject3;
    for (;;)
    {
      int k = i;
      localObject2 = a(localtlv_t104.get_data(), paramArrayOfByte, localtlv_t174.get_data(), paramInt1, paramInt2, paramArrayOfLong, ((async_context)localObject1)._G);
      a(this.i, this.t, this.j, this.x.f, this.m, this.n, j, this.p, (byte[])localObject2);
      int m = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      i = m;
      if (m != 0) {
        break;
      }
      m = b();
      localObject2 = new StringBuilder("retry num:");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(" ret:");
      ((StringBuilder)localObject2).append(m);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.x.f);
      util.LOGI((String)localObject2, ((StringBuilder)localObject3).toString());
      i = m;
      if (m != 180) {
        break;
      }
      i = k + 1;
      if (k > 0) {
        return m;
      }
    }
    return i;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, long[] paramArrayOfLong, byte[] paramArrayOfByte4)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k;
    for (int i = 0; j < 7; i = k)
    {
      Object localObject = null;
      k = new int[] { 8, 260, 278, 372, 380, 1025, 408 }[j];
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
                  if (k == 1025) {
                    localObject = new tlv_t401().get_tlv_401(paramArrayOfByte4);
                  }
                }
                else
                {
                  localObject = new tlv_t(408);
                  ((tlv_t)localObject).set_data(new byte[] { (byte)s.I }, 1);
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
        localObject = new tlv_t8().get_tlv_8(0, t.u, 0);
      }
      k = i;
      if (localObject != null)
      {
        localArrayList.add(localObject);
        k = i + localObject.length;
      }
      j += 1;
    }
    j = localArrayList.size();
    paramArrayOfByte1 = new byte[i];
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < j)
    {
      paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, paramArrayOfByte2.length);
      paramInt2 += paramArrayOfByte2.length;
      paramInt1 += 1;
    }
    return b(paramArrayOfByte1, this.u, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.p
 * JD-Core Version:    0.7.0.1
 */