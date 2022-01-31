package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.b.a;
import oicq.wlogin_sdk.b.bk;
import oicq.wlogin_sdk.b.bq;
import oicq.wlogin_sdk.b.cn;
import oicq.wlogin_sdk.b.co;
import oicq.wlogin_sdk.b.cp;
import oicq.wlogin_sdk.b.cr;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.tools.util;

public class o
  extends j
{
  public o(t paramt)
  {
    this.s = 2064;
    this.t = 7;
    this.u = "wtlogin.login";
    this.w = paramt;
    this.w.m = 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.u;
    async_context localasync_context = t.b(this.w.h);
    f localf = localasync_context._t104;
    if (localf == null) {
      localf = new f();
    }
    for (;;)
    {
      bk localbk = localasync_context._t174;
      if (localbk == null) {
        localbk = new bk();
      }
      for (;;)
      {
        Object localObject2 = localasync_context._t402;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new co();
        }
        cp localcp = localasync_context._t403;
        localObject2 = localcp;
        if (localcp == null) {
          localObject2 = new cp();
        }
        localasync_context._dpwd = util.get_mpasswd().getBytes();
        localasync_context._G = a(t.y, localasync_context._dpwd, ((co)localObject1).b());
        if ((((co)localObject1).c() > 0) && (((cp)localObject2).c() > 0)) {
          localasync_context._sec_guid_flag = true;
        }
        int i = 0;
        for (;;)
        {
          localObject1 = a(localf.b(), paramArrayOfByte, localbk.b(), paramInt1, paramInt2, paramArrayOfLong, localasync_context._G);
          a(this.h, this.s, this.i, this.w.f, this.l, this.m, j, this.o, (byte[])localObject1);
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
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, long[] paramArrayOfLong, byte[] paramArrayOfByte4)
  {
    int[] arrayOfInt = new int[7];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 8;
    int[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 260;
    int[] tmp19_13 = tmp13_8;
    tmp19_13[2] = 278;
    int[] tmp25_19 = tmp19_13;
    tmp25_19[3] = 372;
    int[] tmp31_25 = tmp25_19;
    tmp31_25[4] = 380;
    int[] tmp37_31 = tmp31_25;
    tmp37_31[5] = 1025;
    int[] tmp43_37 = tmp37_31;
    tmp43_37[6] = 408;
    tmp43_37;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if (j < arrayOfInt.length)
    {
      Object localObject = null;
      switch (arrayOfInt[j])
      {
      }
      for (;;)
      {
        int k = i;
        if (localObject != null)
        {
          localArrayList.add(localObject);
          k = i + localObject.length;
        }
        j += 1;
        i = k;
        break;
        localObject = new cr().a(0, t.s, 0);
        continue;
        localObject = new f().a(paramArrayOfByte1);
        continue;
        localObject = new oicq.wlogin_sdk.b.t().a(paramInt1, paramInt2, paramArrayOfLong);
        continue;
        localObject = new bk().a(paramArrayOfByte3);
        continue;
        localObject = new bq().a(paramArrayOfByte2);
        continue;
        localObject = new cn().a(paramArrayOfByte4);
        continue;
        localObject = new a(408);
        ((a)localObject).a(new byte[] { (byte)r.D }, 1);
        localObject = ((a)localObject).a();
      }
    }
    j = localArrayList.size();
    paramArrayOfByte1 = new byte[i];
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, paramArrayOfByte2.length);
      paramInt2 += paramArrayOfByte2.length;
      paramInt1 += 1;
    }
    return a(paramArrayOfByte1, this.t, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.o
 * JD-Core Version:    0.7.0.1
 */