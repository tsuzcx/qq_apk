package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.b.ab;
import oicq.wlogin_sdk.b.af;
import oicq.wlogin_sdk.b.av;
import oicq.wlogin_sdk.b.c;
import oicq.wlogin_sdk.b.cb;
import oicq.wlogin_sdk.b.cl;
import oicq.wlogin_sdk.b.i;
import oicq.wlogin_sdk.b.j;
import oicq.wlogin_sdk.b.q;
import oicq.wlogin_sdk.b.t;
import oicq.wlogin_sdk.tools.util;

public class x
  extends o
{
  public x(y paramy)
  {
    this.s = 2064;
    this.t = 4;
    this.u = "wtlogin.name2uin";
    this.w = paramy;
    this.w.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int i = y.u;
    this.w.g = new String(paramArrayOfByte);
    paramInt1 = 0;
    for (;;)
    {
      Object localObject = a(paramLong1, paramLong2, i, paramInt2, paramArrayOfByte, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfLong, y.W, y.y);
      a(this.h, this.s, this.i, 0L, this.l, this.m, i, this.o, (byte[])localObject);
      localObject = String.valueOf(this.w.f);
      int j = a((String)localObject, false, paramWUserSigInfo);
      if (j != 0) {
        return j;
      }
      j = b();
      util.LOGI("retry num:" + paramInt1 + " ret:" + j + " uin: " + (String)localObject, this.w.g);
      if (j != 180) {
        return j;
      }
      if (paramInt1 >= 1) {
        return j;
      }
      paramInt1 += 1;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long[] paramArrayOfLong, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramArrayOfByte3 = new c();
    Object localObject9 = new q();
    Object localObject3 = new i();
    Object localObject4 = new j();
    Object localObject2 = new ab();
    Object localObject1 = new af();
    Object localObject8 = new t();
    Object localObject6 = new av();
    Object localObject7 = new cl();
    Object localObject5 = new cb();
    paramArrayOfByte3 = paramArrayOfByte3.a(paramLong1, paramLong2, paramInt1, paramInt2);
    paramArrayOfByte1 = ((q)localObject9).a(paramArrayOfByte1);
    localObject3 = ((i)localObject3).a(paramInt3, paramInt4, paramInt5, paramInt6);
    localObject4 = ((j)localObject4).a(paramArrayOfByte2);
    paramArrayOfLong = ((t)localObject8).a(paramInt7, paramInt8, paramArrayOfLong);
    localObject6 = ((av)localObject6).b(this.w.i);
    localObject7 = ((cl)localObject7).a(0, y.s, 0);
    localObject5 = ((cb)localObject5).a(p.D);
    localObject8 = util.get_os_type();
    localObject9 = util.get_os_version();
    paramInt1 = y.B;
    byte[] arrayOfByte1 = y.A;
    byte[] arrayOfByte2 = y.D;
    localObject2 = ((ab)localObject2).a((byte[])localObject8, (byte[])localObject9, paramInt1, arrayOfByte1, new byte[0], arrayOfByte2);
    localObject1 = ((af)localObject1).a(y.P, y.Q, y.R, y.U, y.G, y.y, y.N);
    localObject8 = new byte[paramArrayOfByte3.length + paramArrayOfByte1.length + localObject3.length + localObject4.length + localObject2.length + localObject1.length + paramArrayOfLong.length + localObject6.length + localObject7.length + localObject5.length];
    System.arraycopy(paramArrayOfByte3, 0, localObject8, 0, paramArrayOfByte3.length);
    paramInt1 = 0 + paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte1, 0, localObject8, paramInt1, paramArrayOfByte1.length);
    paramInt1 += paramArrayOfByte1.length;
    System.arraycopy(localObject3, 0, localObject8, paramInt1, localObject3.length);
    paramInt1 += localObject3.length;
    System.arraycopy(localObject6, 0, localObject8, paramInt1, localObject6.length);
    paramInt1 += localObject6.length;
    System.arraycopy(localObject7, 0, localObject8, paramInt1, localObject7.length);
    paramInt3 = paramInt1 + localObject7.length;
    paramInt4 = 5;
    paramInt2 = paramInt3;
    paramInt1 = paramInt4;
    if (paramArrayOfByte2 != null)
    {
      paramInt2 = paramInt3;
      paramInt1 = paramInt4;
      if (paramArrayOfByte2.length > 0)
      {
        System.arraycopy(localObject4, 0, localObject8, paramInt3, localObject4.length);
        paramInt2 = paramInt3 + localObject4.length;
        paramInt1 = 6;
      }
    }
    System.arraycopy(localObject2, 0, localObject8, paramInt2, localObject2.length);
    paramInt2 += localObject2.length;
    System.arraycopy(localObject1, 0, localObject8, paramInt2, localObject1.length);
    paramInt2 += localObject1.length;
    System.arraycopy(paramArrayOfLong, 0, localObject8, paramInt2, paramArrayOfLong.length);
    paramInt2 += paramArrayOfLong.length;
    System.arraycopy(localObject5, 0, localObject8, paramInt2, localObject5.length);
    paramInt2 = localObject5.length;
    return a((byte[])localObject8, this.t, paramInt1 + 3 + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.x
 * JD-Core Version:    0.7.0.1
 */