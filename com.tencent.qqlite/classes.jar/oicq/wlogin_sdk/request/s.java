package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.b.cd;
import oicq.wlogin_sdk.b.cf;
import oicq.wlogin_sdk.b.cl;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.b.g;
import oicq.wlogin_sdk.b.t;
import oicq.wlogin_sdk.tools.util;

public class s
  extends o
{
  public static boolean D = false;
  
  public s(y paramy)
  {
    this.s = 2064;
    this.t = 2;
    this.u = "wtlogin.login";
    this.w = paramy;
    this.w.m = 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = y.u;
    Object localObject = y.b(this.w.h);
    f localf = ((k)localObject).m;
    if (localf == null) {
      localf = new f();
    }
    for (;;)
    {
      localObject = ((k)localObject).n;
      if (localObject == null) {
        localObject = new g();
      }
      for (;;)
      {
        int i = 0;
        for (;;)
        {
          byte[] arrayOfByte = a(localf.b(), paramArrayOfByte, ((g)localObject).g(), paramInt1, paramInt2, paramArrayOfLong);
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
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    cf localcf = new cf();
    Object localObject1 = new cl();
    Object localObject2 = new f();
    t localt = new t();
    cd localcd = new cd();
    localObject1 = ((cl)localObject1).a(0, y.s, 0);
    localObject2 = ((f)localObject2).a(paramArrayOfByte1);
    paramArrayOfLong = localt.a(paramInt1, paramInt2, paramArrayOfLong);
    if (D) {}
    for (paramArrayOfByte1 = localcd.a(paramArrayOfByte2);; paramArrayOfByte1 = localcf.a(paramArrayOfByte2, paramArrayOfByte3))
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
      return a(paramArrayOfByte2, this.t, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.s
 * JD-Core Version:    0.7.0.1
 */