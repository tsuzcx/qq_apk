package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.b.cn;
import oicq.wlogin_sdk.b.co;
import oicq.wlogin_sdk.b.cp;
import oicq.wlogin_sdk.b.cr;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.tools.util;

public class p
  extends j
{
  public p(t paramt)
  {
    this.s = 2064;
    this.t = 20;
    this.u = "wtlogin.login";
    this.w = paramt;
    this.w.m = 0;
  }
  
  public int a(int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.u;
    async_context localasync_context = t.b(this.w.h);
    f localf = localasync_context._t104;
    if (localf == null) {
      localf = new f();
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
        localObject1 = a(localf.b(), paramInt1, paramInt2, paramArrayOfLong, localasync_context._G);
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
  
  public byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, long[] paramArrayOfLong, byte[] paramArrayOfByte2)
  {
    Object localObject1 = new cr();
    f localf = new f();
    oicq.wlogin_sdk.b.t localt = new oicq.wlogin_sdk.b.t();
    Object localObject2 = new cn();
    localObject1 = ((cr)localObject1).a(0, t.s, 0);
    paramArrayOfByte1 = localf.a(paramArrayOfByte1);
    paramArrayOfLong = localt.a(paramInt1, paramInt2, paramArrayOfLong);
    paramArrayOfByte2 = ((cn)localObject2).a(paramArrayOfByte2);
    localObject2 = new byte[localObject1.length + paramArrayOfByte1.length + paramArrayOfLong.length + paramArrayOfByte2.length];
    System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
    paramInt1 = localObject1.length + 0;
    System.arraycopy(paramArrayOfByte1, 0, localObject2, paramInt1, paramArrayOfByte1.length);
    paramInt1 += paramArrayOfByte1.length;
    System.arraycopy(paramArrayOfLong, 0, localObject2, paramInt1, paramArrayOfLong.length);
    paramInt1 += paramArrayOfLong.length;
    System.arraycopy(paramArrayOfByte2, 0, localObject2, paramInt1, paramArrayOfByte2.length);
    paramInt1 = paramArrayOfByte2.length;
    return a((byte[])localObject2, this.t, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.p
 * JD-Core Version:    0.7.0.1
 */