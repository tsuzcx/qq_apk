package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.b.aw;
import oicq.wlogin_sdk.b.bk;
import oicq.wlogin_sdk.b.bo;
import oicq.wlogin_sdk.b.bp;
import oicq.wlogin_sdk.b.cl;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.b.t;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class w
  extends o
{
  public w(y paramy)
  {
    this.s = 2064;
    this.t = 8;
    this.u = "wtlogin.login";
    this.w = paramy;
    this.w.m = 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = y.u;
    Object localObject = y.b(this.w.h);
    f localf = ((k)localObject).m;
    if (localf == null) {
      localf = new f();
    }
    for (;;)
    {
      localObject = ((k)localObject).v;
      if (localObject == null) {
        localObject = new bk();
      }
      for (;;)
      {
        int i = 0;
        for (;;)
        {
          byte[] arrayOfByte = a(localf.b(), paramLong, ((bk)localObject).b(), paramInt1, paramInt2, paramArrayOfLong);
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
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, long paramLong, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    Object localObject1 = new cl();
    f localf = new f();
    t localt = new t();
    Object localObject3 = new bk();
    Object localObject2 = new bo();
    localObject1 = ((cl)localObject1).a(0, y.s, 0);
    paramArrayOfByte1 = localf.a(paramArrayOfByte1);
    paramArrayOfLong = localt.a(paramInt1, paramInt2, paramArrayOfLong);
    paramArrayOfByte2 = ((bk)localObject3).a(paramArrayOfByte2);
    localObject2 = ((bo)localObject2).a(paramLong);
    localObject3 = new byte[localObject1.length + paramArrayOfByte1.length + paramArrayOfLong.length + paramArrayOfByte2.length + localObject2.length];
    System.arraycopy(localObject1, 0, localObject3, 0, localObject1.length);
    paramInt1 = localObject1.length + 0;
    System.arraycopy(paramArrayOfByte1, 0, localObject3, paramInt1, paramArrayOfByte1.length);
    paramInt1 += paramArrayOfByte1.length;
    System.arraycopy(paramArrayOfLong, 0, localObject3, paramInt1, paramArrayOfLong.length);
    paramInt1 += paramArrayOfLong.length;
    System.arraycopy(paramArrayOfByte2, 0, localObject3, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    System.arraycopy(localObject2, 0, localObject3, paramInt1, localObject2.length);
    paramInt1 = localObject2.length;
    return a((byte[])localObject3, this.t, 5);
  }
  
  public int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    f localf = new f();
    bp localbp = new bp();
    aw localaw = new aw();
    k localk = y.b(this.w.h);
    paramInt2 = c(paramArrayOfByte, paramInt1 + 2);
    util.LOGD(getClass().getName(), "type=" + paramInt2);
    int j = paramInt1 + 5;
    switch (paramInt2)
    {
    default: 
      b(paramArrayOfByte, j, this.b - j - 1);
      paramInt1 = paramInt2;
    }
    int i;
    do
    {
      do
      {
        do
        {
          return paramInt1;
          i = localf.b(paramArrayOfByte, j, this.b - j);
          paramInt1 = i;
        } while (i < 0);
        localk.m = localf;
        i = localbp.b(paramArrayOfByte, j, this.b - j);
        paramInt1 = i;
      } while (i < 0);
      localk.w = localbp;
      a((ErrMsg)null);
      return paramInt2;
      i = localaw.b(paramArrayOfByte, j, this.b - j - 1);
      paramInt1 = i;
    } while (i < 0);
    a(localaw);
    util.LOGD("0xb4 parse t161 called");
    b(paramArrayOfByte, j, this.b - j - 1);
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.w
 * JD-Core Version:    0.7.0.1
 */