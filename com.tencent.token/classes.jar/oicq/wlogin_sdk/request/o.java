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
    int j = t.w;
    Object localObject = t.b(this.x.h);
    tlv_t104 localtlv_t104 = ((async_context)localObject)._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    for (;;)
    {
      localObject = ((async_context)localObject)._t105;
      if (localObject == null) {
        localObject = new tlv_t105();
      }
      for (;;)
      {
        int i = 0;
        for (;;)
        {
          byte[] arrayOfByte = a(localtlv_t104.get_data(), paramArrayOfByte, ((tlv_t105)localObject).get_sign(), paramInt1, paramInt2, paramArrayOfLong);
          a(this.i, this.t, this.j, this.x.f, this.m, this.n, j, this.p, arrayOfByte);
          int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
          if (k != 0) {
            return k;
          }
          k = b();
          util.LOGI("retry num:" + i + " ret:" + k, "" + this.x.f);
          if (k != 180) {
            return k;
          }
          if (i >= 1) {
            return k;
          }
          i += 1;
        }
      }
    }
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
    if (I) {}
    for (paramArrayOfByte1 = localtlv_t193.get_tlv_193(paramArrayOfByte2);; paramArrayOfByte1 = localtlv_t2.get_tlv_2(paramArrayOfByte2, paramArrayOfByte3))
    {
      paramArrayOfByte2 = new byte[paramArrayOfByte1.length + localObject1.length + localObject2.length + paramArrayOfLong.length];
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
      paramInt1 = paramArrayOfByte1.length + 0;
      System.arraycopy(localObject1, 0, paramArrayOfByte2, paramInt1, localObject1.length);
      paramInt1 += localObject1.length;
      System.arraycopy(localObject2, 0, paramArrayOfByte2, paramInt1, localObject2.length);
      paramInt1 += localObject2.length;
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte2, paramInt1, paramArrayOfLong.length);
      paramInt1 = paramArrayOfLong.length;
      return b(paramArrayOfByte2, this.u, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.o
 * JD-Core Version:    0.7.0.1
 */