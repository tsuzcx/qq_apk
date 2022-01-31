package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.b.al;
import oicq.wlogin_sdk.b.ao;
import oicq.wlogin_sdk.b.av;
import oicq.wlogin_sdk.b.c;
import oicq.wlogin_sdk.b.cq;
import oicq.wlogin_sdk.b.k;
import oicq.wlogin_sdk.b.q;
import oicq.wlogin_sdk.tools.util;

public class v
  extends j
{
  public v(t paramt)
  {
    this.s = 2064;
    this.t = 17;
    this.u = "wtlogin.login";
    this.w = paramt;
    this.w.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, String paramString, int paramInt2, int paramInt3, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.u;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = a(paramLong1, paramLong2, paramInt1, j, paramArrayOfByte, paramString.getBytes(), paramInt2, paramInt3, paramArrayOfLong);
      a(this.h, this.s, this.i, this.w.f, this.l, this.m, j, this.o, arrayOfByte);
      int k = a(String.valueOf(this.w.f), false, paramWUserSigInfo);
      if (k != 0) {
        return k;
      }
      k = b();
      util.LOGI("retry num:" + i + " ret:" + k, "" + this.w.f);
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
    int i = 0;
    int[] arrayOfInt = new int[9];
    int[] tmp11_9 = arrayOfInt;
    tmp11_9[0] = 256;
    int[] tmp17_11 = tmp11_9;
    tmp17_11[1] = 264;
    int[] tmp23_17 = tmp17_11;
    tmp23_17[2] = 265;
    int[] tmp29_23 = tmp23_17;
    tmp29_23[3] = 8;
    int[] tmp34_29 = tmp29_23;
    tmp34_29[4] = 322;
    int[] tmp40_34 = tmp34_29;
    tmp40_34[5] = 325;
    int[] tmp46_40 = tmp40_34;
    tmp46_40[6] = 340;
    int[] tmp53_46 = tmp46_40;
    tmp53_46[7] = 274;
    int[] tmp60_53 = tmp53_46;
    tmp60_53[8] = 278;
    tmp60_53;
    ArrayList localArrayList = new ArrayList();
    int m = tmp17_11.length;
    int j = 0;
    int k = 0;
    byte[] arrayOfByte2;
    byte[] arrayOfByte1;
    if (k < m)
    {
      arrayOfByte2 = new byte[0];
      switch (tmp17_11[k])
      {
      default: 
        arrayOfByte1 = arrayOfByte2;
        label192:
        if (arrayOfByte1.length > 4)
        {
          int n = arrayOfByte1.length;
          localArrayList.add(arrayOfByte1);
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
      arrayOfByte1 = new c().a(paramLong1, paramLong2, paramInt2, paramInt1);
      break label192;
      arrayOfByte1 = arrayOfByte2;
      if (paramArrayOfByte1 == null) {
        break label192;
      }
      arrayOfByte1 = arrayOfByte2;
      if (paramArrayOfByte1.length <= 0) {
        break label192;
      }
      arrayOfByte1 = new oicq.wlogin_sdk.b.j().a(paramArrayOfByte1);
      break label192;
      arrayOfByte1 = arrayOfByte2;
      if (t.K == null) {
        break label192;
      }
      arrayOfByte1 = arrayOfByte2;
      if (t.K.length <= 0) {
        break label192;
      }
      arrayOfByte1 = new k().a(t.K);
      break label192;
      arrayOfByte1 = new cq().a(0, t.s, 0);
      break label192;
      arrayOfByte1 = new al().a(t.C);
      break label192;
      arrayOfByte1 = new ao().a(t.y);
      break label192;
      arrayOfByte1 = new av().b(this.w.i);
      break label192;
      arrayOfByte1 = new q().a(paramArrayOfByte2);
      break label192;
      arrayOfByte1 = new oicq.wlogin_sdk.b.t().a(paramInt3, paramInt4, paramArrayOfLong);
      break label192;
      paramArrayOfByte1 = new byte[j];
      paramInt2 = 0;
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, paramArrayOfByte2.length);
        paramInt2 += paramArrayOfByte2.length;
        paramInt1 += 1;
      }
      return a(paramArrayOfByte1, this.t, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.v
 * JD-Core Version:    0.7.0.1
 */