package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.b.ad;
import oicq.wlogin_sdk.b.ae;
import oicq.wlogin_sdk.b.bw;
import oicq.wlogin_sdk.b.cl;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.b.t;
import oicq.wlogin_sdk.tools.util;

public class ac
  extends o
{
  public ac(y paramy)
  {
    this.s = 2064;
    this.t = 18;
    this.u = "wtlogin.login";
    this.w = paramy;
    this.w.m = 0;
  }
  
  public int a(String paramString, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = y.u;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = a(paramString.getBytes(), paramInt1, paramInt2, paramArrayOfLong);
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
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    int i = 0;
    int[] arrayOfInt = new int[5];
    int[] tmp10_8 = arrayOfInt;
    tmp10_8[0] = 260;
    int[] tmp16_10 = tmp10_8;
    tmp16_10[1] = 8;
    int[] tmp21_16 = tmp16_10;
    tmp21_16[2] = 295;
    int[] tmp27_21 = tmp21_16;
    tmp27_21[3] = 388;
    int[] tmp33_27 = tmp27_21;
    tmp33_27[4] = 278;
    tmp33_27;
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfInt.length;
    int j = 0;
    k localk = y.b(this.w.h);
    int n = 0;
    if (n < i1)
    {
      byte[] arrayOfByte = new byte[0];
      switch (arrayOfInt[n])
      {
      }
      for (;;)
      {
        int k = j;
        int m = i;
        if (arrayOfByte.length > 4)
        {
          m = i + 1;
          k = j + arrayOfByte.length;
          localArrayList.add(arrayOfByte);
        }
        n += 1;
        i = m;
        j = k;
        break;
        arrayOfByte = localk.m.a();
        continue;
        arrayOfByte = new cl().a(0, y.s, 0);
        continue;
        arrayOfByte = new ae().a(paramArrayOfByte, localk.p.f());
        continue;
        arrayOfByte = new bw().a(localk.B, localk.C);
        continue;
        arrayOfByte = new t().a(paramInt1, paramInt2, paramArrayOfLong);
      }
    }
    paramArrayOfByte = new byte[j];
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      paramArrayOfLong = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte, paramInt2, paramArrayOfLong.length);
      paramInt2 += paramArrayOfLong.length;
      paramInt1 += 1;
    }
    return a(paramArrayOfByte, this.t, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.ac
 * JD-Core Version:    0.7.0.1
 */