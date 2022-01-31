package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.b.cl;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.b.t;
import oicq.wlogin_sdk.tools.util;

public class ab
  extends o
{
  public ab(y paramy)
  {
    this.s = 2064;
    this.t = 19;
    this.u = "wtlogin.login";
    this.w = paramy;
    this.w.m = 0;
  }
  
  public int a(int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = y.u;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = a(paramInt1, paramInt2, paramArrayOfLong);
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
  
  public byte[] a(int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    int[] arrayOfInt = new int[3];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 260;
    int[] tmp13_7 = tmp7_5;
    tmp13_7[1] = 8;
    int[] tmp18_13 = tmp13_7;
    tmp18_13[2] = 278;
    tmp18_13;
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfInt.length;
    k localk = y.b(this.w.h);
    int n = 0;
    int j = 0;
    int i = 0;
    byte[] arrayOfByte;
    if (n < i1)
    {
      arrayOfByte = new byte[0];
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
        arrayOfByte = new t().a(paramInt1, paramInt2, paramArrayOfLong);
      }
    }
    paramArrayOfLong = new byte[j];
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < i)
    {
      arrayOfByte = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(arrayOfByte, 0, paramArrayOfLong, paramInt2, arrayOfByte.length);
      paramInt2 += arrayOfByte.length;
      paramInt1 += 1;
    }
    return a(paramArrayOfLong, this.t, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.ab
 * JD-Core Version:    0.7.0.1
 */