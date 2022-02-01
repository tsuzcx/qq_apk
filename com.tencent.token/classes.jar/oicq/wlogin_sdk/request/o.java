package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t193;
import oicq.wlogin_sdk.tlv_type.tlv_t2;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class o
  extends oicq_request
{
  public static boolean I = false;
  
  public o(t paramt)
  {
    this.t = 2064;
    this.u = 2;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int m = t.w;
    Object localObject1 = t.b(this.x.h);
    tlv_t104 localtlv_t104 = ((async_context)localObject1)._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    localObject1 = ((async_context)localObject1)._t105;
    if (localObject1 == null) {
      localObject1 = new tlv_t105();
    }
    int i = 0;
    int j;
    int k;
    do
    {
      j = i;
      Object localObject2 = a(localtlv_t104.get_data(), paramArrayOfByte, ((tlv_t105)localObject1).get_sign(), paramInt1, paramInt2, paramArrayOfLong);
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
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    tlv_t2 localtlv_t2 = new tlv_t2();
    Object localObject1 = new tlv_t8();
    Object localObject2 = new tlv_t104();
    tlv_t116 localtlv_t116 = new tlv_t116();
    tlv_t193 localtlv_t193 = new tlv_t193();
    localObject1 = ((tlv_t8)localObject1).get_tlv_8(0, t.u, 0);
    localObject2 = ((tlv_t104)localObject2).get_tlv_104(paramArrayOfByte1);
    paramArrayOfLong = localtlv_t116.get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
    if (I) {
      paramArrayOfByte1 = localtlv_t193.get_tlv_193(paramArrayOfByte2);
    } else {
      paramArrayOfByte1 = localtlv_t2.get_tlv_2(paramArrayOfByte2, paramArrayOfByte3);
    }
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length + localObject1.length + localObject2.length + paramArrayOfLong.length];
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
    paramInt1 = paramArrayOfByte1.length + 0;
    System.arraycopy(localObject1, 0, paramArrayOfByte2, paramInt1, localObject1.length);
    paramInt1 += localObject1.length;
    System.arraycopy(localObject2, 0, paramArrayOfByte2, paramInt1, localObject2.length);
    System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte2, paramInt1 + localObject2.length, paramArrayOfLong.length);
    return b(paramArrayOfByte2, this.u, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.o
 * JD-Core Version:    0.7.0.1
 */