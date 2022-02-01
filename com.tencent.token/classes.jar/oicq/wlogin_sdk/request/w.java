package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class w
  extends oicq_request
{
  public w(t paramt)
  {
    this.t = 2064;
    this.u = 19;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int m = t.w;
    int i = 0;
    int j;
    for (;;)
    {
      Object localObject = a(paramInt1, paramInt2, paramArrayOfLong);
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
  
  public byte[] a(int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    ArrayList localArrayList = new ArrayList();
    async_context localasync_context = t.b(this.x.h);
    int j = 0;
    int k = 0;
    byte[] arrayOfByte;
    int m;
    for (int i = 0; j < 3; i = m)
    {
      arrayOfByte = new byte[0];
      m = new int[] { 260, 8, 278 }[j];
      if (m != 8)
      {
        if (m != 260)
        {
          if (m == 278) {
            arrayOfByte = new tlv_t116().get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
          }
        }
        else {
          arrayOfByte = localasync_context._t104.get_buf();
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
    paramArrayOfLong = new byte[k];
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < i)
    {
      arrayOfByte = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(arrayOfByte, 0, paramArrayOfLong, paramInt2, arrayOfByte.length);
      paramInt2 += arrayOfByte.length;
      paramInt1 += 1;
    }
    return b(paramArrayOfLong, this.u, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.w
 * JD-Core Version:    0.7.0.1
 */