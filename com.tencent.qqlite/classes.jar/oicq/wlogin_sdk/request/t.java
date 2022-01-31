package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.b.bk;
import oicq.wlogin_sdk.b.bq;
import oicq.wlogin_sdk.b.ci;
import oicq.wlogin_sdk.b.cj;
import oicq.wlogin_sdk.b.ck;
import oicq.wlogin_sdk.b.cl;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.tools.util;

public class t
  extends o
{
  public t(y paramy)
  {
    this.s = 2064;
    this.t = 7;
    this.u = "wtlogin.login";
    this.w = paramy;
    this.w.m = 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = y.u;
    k localk = y.b(this.w.h);
    f localf = localk.m;
    if (localf == null) {
      localf = new f();
    }
    for (;;)
    {
      bk localbk = localk.v;
      if (localbk == null) {
        localbk = new bk();
      }
      for (;;)
      {
        Object localObject2 = localk.r;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new cj();
        }
        ck localck = localk.s;
        localObject2 = localck;
        if (localck == null) {
          localObject2 = new ck();
        }
        localk.t = util.get_mpasswd().getBytes();
        localk.u = a(y.y, localk.t, ((cj)localObject1).b());
        if ((((cj)localObject1).c() > 0) && (((ck)localObject2).c() > 0)) {
          localk.q = true;
        }
        int i = 0;
        for (;;)
        {
          localObject1 = a(localf.b(), paramArrayOfByte, localbk.b(), paramInt1, paramInt2, paramArrayOfLong, localk.u);
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
    Object localObject1 = new cl();
    f localf = new f();
    oicq.wlogin_sdk.b.t localt = new oicq.wlogin_sdk.b.t();
    bk localbk = new bk();
    bq localbq = new bq();
    Object localObject2 = new ci();
    localObject1 = ((cl)localObject1).a(0, y.s, 0);
    paramArrayOfByte1 = localf.a(paramArrayOfByte1);
    paramArrayOfLong = localt.a(paramInt1, paramInt2, paramArrayOfLong);
    paramArrayOfByte3 = localbk.a(paramArrayOfByte3);
    paramArrayOfByte2 = localbq.a(paramArrayOfByte2);
    paramArrayOfByte4 = ((ci)localObject2).a(paramArrayOfByte4);
    localObject2 = new byte[localObject1.length + paramArrayOfByte1.length + paramArrayOfLong.length + paramArrayOfByte3.length + paramArrayOfByte2.length + paramArrayOfByte4.length];
    System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
    paramInt1 = localObject1.length + 0;
    System.arraycopy(paramArrayOfByte1, 0, localObject2, paramInt1, paramArrayOfByte1.length);
    paramInt1 += paramArrayOfByte1.length;
    System.arraycopy(paramArrayOfLong, 0, localObject2, paramInt1, paramArrayOfLong.length);
    paramInt1 += paramArrayOfLong.length;
    System.arraycopy(paramArrayOfByte3, 0, localObject2, paramInt1, paramArrayOfByte3.length);
    paramInt1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte2, 0, localObject2, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    System.arraycopy(paramArrayOfByte4, 0, localObject2, paramInt1, paramArrayOfByte4.length);
    paramInt1 = paramArrayOfByte4.length;
    return a((byte[])localObject2, this.t, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.t
 * JD-Core Version:    0.7.0.1
 */