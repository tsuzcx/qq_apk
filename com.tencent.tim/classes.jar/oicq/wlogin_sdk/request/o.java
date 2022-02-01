package oicq.wlogin_sdk.request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t193;
import oicq.wlogin_sdk.tlv_type.tlv_t2;
import oicq.wlogin_sdk.tlv_type.tlv_t547;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class o
  extends oicq_request
{
  public static boolean K = false;
  
  public o(u paramu)
  {
    this.t = 2064;
    this.u = 2;
    this.v = "wtlogin.login";
    this.x = paramu;
    this.x.m = 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = u.x;
    Object localObject = u.b(this.x.h);
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
        byte[] arrayOfByte1 = u.an;
        int i = 0;
        for (;;)
        {
          byte[] arrayOfByte2 = a(localtlv_t104.get_data(), paramArrayOfByte, ((tlv_t105)localObject).get_sign(), paramInt1, paramInt2, paramArrayOfLong, arrayOfByte1, paramWUserSigInfo);
          a(this.i, this.t, this.j, this.x.f, this.m, this.n, j, this.p, arrayOfByte2);
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
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, long[] paramArrayOfLong, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject3 = new tlv_t2();
    Object localObject1 = new tlv_t8();
    Object localObject2 = new tlv_t104();
    tlv_t116 localtlv_t116 = new tlv_t116();
    tlv_t193 localtlv_t193 = new tlv_t193();
    tlv_t547 localtlv_t547 = new tlv_t547();
    localObject1 = ((tlv_t8)localObject1).get_tlv_8(0, u.v, 0);
    localObject2 = ((tlv_t104)localObject2).get_tlv_104(paramArrayOfByte1);
    paramArrayOfLong = localtlv_t116.get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
    paramArrayOfByte4 = localtlv_t547.get_tlv_547(paramArrayOfByte4);
    if (K) {}
    int i;
    for (paramArrayOfByte1 = localtlv_t193.get_tlv_193(paramArrayOfByte2);; paramArrayOfByte1 = ((tlv_t2)localObject3).get_tlv_2(paramArrayOfByte2, paramArrayOfByte3))
    {
      paramInt1 = paramArrayOfByte1.length;
      paramInt2 = localObject1.length;
      i = localObject2.length;
      int j = paramArrayOfLong.length;
      int k = paramArrayOfByte4.length;
      paramArrayOfByte2 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
      for (paramInt1 = paramInt1 + paramInt2 + i + j + k; paramArrayOfByte2.hasNext(); paramInt1 = paramInt2 + paramInt1)
      {
        paramArrayOfByte3 = (Integer)paramArrayOfByte2.next();
        localObject3 = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte3)).get_buf();
        paramInt2 = localObject3.length;
        util.LOGI("Extra Tlv key：0x" + paramArrayOfByte3 + " len:" + localObject3.length, "");
      }
    }
    paramArrayOfByte2 = new byte[paramInt1];
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
    paramInt1 = 0 + paramArrayOfByte1.length;
    System.arraycopy(localObject1, 0, paramArrayOfByte2, paramInt1, localObject1.length);
    paramInt1 += localObject1.length;
    System.arraycopy(localObject2, 0, paramArrayOfByte2, paramInt1, localObject2.length);
    paramInt1 += localObject2.length;
    System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte2, paramInt1, paramArrayOfLong.length);
    paramInt1 += paramArrayOfLong.length;
    System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte2, paramInt1, paramArrayOfByte4.length);
    paramInt2 = paramArrayOfByte4.length;
    paramArrayOfByte1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
    paramInt1 += paramInt2;
    paramInt2 = 5;
    while (paramArrayOfByte1.hasNext())
    {
      paramArrayOfByte3 = (Integer)paramArrayOfByte1.next();
      paramArrayOfLong = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte3)).get_buf();
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte2, paramInt1, paramArrayOfLong.length);
      i = paramArrayOfLong.length;
      util.LOGI("Extra Tlv from user：0x" + paramArrayOfByte3);
      paramInt2 += 1;
      paramInt1 = i + paramInt1;
    }
    return b(paramArrayOfByte2, this.u, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.o
 * JD-Core Version:    0.7.0.1
 */