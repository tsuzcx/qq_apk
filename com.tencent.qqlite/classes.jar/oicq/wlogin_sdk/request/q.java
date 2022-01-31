package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.b.ab;
import oicq.wlogin_sdk.b.af;
import oicq.wlogin_sdk.b.ak;
import oicq.wlogin_sdk.b.al;
import oicq.wlogin_sdk.b.an;
import oicq.wlogin_sdk.b.ao;
import oicq.wlogin_sdk.b.aq;
import oicq.wlogin_sdk.b.ar;
import oicq.wlogin_sdk.b.au;
import oicq.wlogin_sdk.b.bc;
import oicq.wlogin_sdk.b.bg;
import oicq.wlogin_sdk.b.bi;
import oicq.wlogin_sdk.b.bl;
import oicq.wlogin_sdk.b.bt;
import oicq.wlogin_sdk.b.bz;
import oicq.wlogin_sdk.b.c;
import oicq.wlogin_sdk.b.ca;
import oicq.wlogin_sdk.b.ce;
import oicq.wlogin_sdk.b.cl;
import oicq.wlogin_sdk.b.h;
import oicq.wlogin_sdk.b.j;
import oicq.wlogin_sdk.b.t;
import oicq.wlogin_sdk.tools.util;

public class q
  extends o
{
  public q(y paramy)
  {
    this.s = 2064;
    this.t = 13;
    this.u = "wtlogin.login";
    this.w = paramy;
    this.w.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte3, long paramLong4, long paramLong5, long paramLong6, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, WUserSigInfo paramWUserSigInfo)
  {
    int k = y.u;
    paramArrayOfByte1 = c(paramArrayOfByte1);
    int i;
    if (paramArrayOfByte1 == null)
    {
      i = -1014;
      return i;
    }
    paramInt1 = 0;
    for (;;)
    {
      byte[] arrayOfByte = a(paramLong1, paramLong2, paramLong3, k, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt3, paramInt4, paramArrayOfLong, y.W, paramArrayOfByte3, paramLong4, paramLong5, paramLong6, paramArrayOfByte4, paramArrayOfByte5);
      a(this.h, this.s, this.i, paramLong1, this.l, this.m, k, this.o, arrayOfByte);
      int j = a(String.valueOf(this.w.f), false, paramWUserSigInfo);
      i = j;
      if (j != 0) {
        break;
      }
      i = b();
      util.LOGI("retry num:" + paramInt1 + " ret:" + i, "" + paramLong1);
      if (i != 180) {
        return i;
      }
      if (paramInt1 >= 1) {
        return i;
      }
      paramInt1 += 1;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, long paramLong4, long paramLong5, long paramLong6, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
  {
    Object localObject4 = new h();
    an localan = new an();
    Object localObject5 = new c();
    Object localObject21 = new j();
    Object localObject7 = new t();
    Object localObject20 = new oicq.wlogin_sdk.b.q();
    Object localObject8 = new al();
    Object localObject10 = new ao();
    Object localObject19 = new bc();
    Object localObject12 = new bt();
    Object localObject13 = new ak();
    Object localObject14 = new cl();
    Object localObject17 = new oicq.wlogin_sdk.b.k();
    Object localObject11 = new ab();
    Object localObject9 = new af();
    Object localObject15 = new aq();
    ar localar = new ar();
    au localau = new au();
    Object localObject6 = new bg();
    Object localObject18 = new bi();
    Object localObject16 = new bl();
    Object localObject1 = new bz();
    Object localObject2 = new ca();
    Object localObject3 = new ce();
    ((h)localObject4).a(paramArrayOfByte1, paramArrayOfByte1.length);
    localObject4 = ((h)localObject4).a();
    localObject5 = ((c)localObject5).a(paramLong5, paramLong6, paramInt1, paramInt2);
    localObject7 = ((t)localObject7).a(paramInt3, paramInt4, paramArrayOfLong);
    localObject8 = ((al)localObject8).a(y.C);
    localObject10 = ((ao)localObject10).a(y.y);
    localObject12 = ((bt)localObject12).a(paramLong2, paramInt1, paramLong1, 0);
    localObject13 = ((ak)localObject13).b(y.A, y.B, y.D);
    localObject14 = ((cl)localObject14).a(0, y.s, 0);
    localObject15 = ((aq)localObject15).a(paramLong2, y.E, y.F);
    localObject16 = ((bl)localObject16).a(1414386621L, "5.2.3.1");
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0)) {
      paramArrayOfByte1 = ((j)localObject21).a(paramArrayOfByte3);
    }
    for (paramInt1 = 11;; paramInt1 = 10)
    {
      if ((this.w.g != null) && (!util.check_uin_account(this.w.g).booleanValue()))
      {
        paramArrayOfLong = ((oicq.wlogin_sdk.b.q)localObject20).a(this.w.g.getBytes());
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0))
        {
          paramArrayOfByte2 = ((bc)localObject19).a(paramArrayOfByte2);
          paramInt1 += 1;
        }
        for (;;)
        {
          if ((this.w.p != null) && (this.w.p.length > 0))
          {
            paramArrayOfByte3 = ((bi)localObject18).a(this.w.p);
            paramInt1 += 1;
          }
          for (;;)
          {
            if ((y.L != null) && (y.L.length > 0))
            {
              localObject1 = ((bz)localObject1).a(y.L);
              paramInt1 += 1;
            }
            for (;;)
            {
              if ((y.M != null) && (y.M.length > 0))
              {
                localObject2 = ((ca)localObject2).a(y.M);
                paramInt1 += 1;
              }
              for (;;)
              {
                if ((y.J != null) && (y.J.length > 0))
                {
                  localObject3 = ((ce)localObject3).a(y.J);
                  paramInt1 += 1;
                }
                for (;;)
                {
                  localObject17 = ((oicq.wlogin_sdk.b.k)localObject17).a(y.K);
                  localObject18 = util.get_os_type();
                  localObject19 = util.get_os_version();
                  paramInt2 = y.B;
                  localObject20 = y.A;
                  localObject21 = y.D;
                  localObject11 = ((ab)localObject11).a((byte[])localObject18, (byte[])localObject19, paramInt2, (byte[])localObject20, new byte[0], (byte[])localObject21);
                  localObject9 = ((af)localObject9).a(y.P, y.Q, y.R, 0, y.G, y.y, y.N);
                  paramArrayOfByte4 = localar.a(paramArrayOfByte4, paramLong4, paramLong5, paramLong6, paramArrayOfByte5, paramArrayOfByte6);
                  paramArrayOfByte5 = localau.b(y.V);
                  paramArrayOfByte6 = ((bg)localObject6).a(y.G);
                  localObject6 = y.b(this.w.h).l;
                  paramArrayOfByte4 = localan.a((byte[])localObject17, (byte[])localObject11, (byte[])localObject9, paramArrayOfByte4, new byte[0], paramArrayOfByte5, paramArrayOfByte6, (byte[])localObject6);
                  paramArrayOfByte5 = new byte[localObject4.length + localObject5.length + paramArrayOfByte1.length + localObject7.length + paramArrayOfLong.length + localObject8.length + localObject10.length + paramArrayOfByte4.length + paramArrayOfByte2.length + localObject12.length + localObject13.length + localObject14.length + localObject15.length + paramArrayOfByte3.length + localObject16.length + localObject1.length + localObject2.length + localObject3.length];
                  System.arraycopy(localObject4, 0, paramArrayOfByte5, 0, localObject4.length);
                  paramInt2 = 0 + localObject4.length;
                  System.arraycopy(localObject5, 0, paramArrayOfByte5, paramInt2, localObject5.length);
                  paramInt2 += localObject5.length;
                  System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, paramInt2, paramArrayOfByte1.length);
                  paramInt2 += paramArrayOfByte1.length;
                  System.arraycopy(localObject7, 0, paramArrayOfByte5, paramInt2, localObject7.length);
                  paramInt2 += localObject7.length;
                  System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte5, paramInt2, paramArrayOfLong.length);
                  paramInt2 += paramArrayOfLong.length;
                  System.arraycopy(localObject8, 0, paramArrayOfByte5, paramInt2, localObject8.length);
                  paramInt2 += localObject8.length;
                  System.arraycopy(localObject10, 0, paramArrayOfByte5, paramInt2, localObject10.length);
                  paramInt2 += localObject10.length;
                  System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt2, paramArrayOfByte4.length);
                  paramInt2 = paramArrayOfByte4.length + paramInt2;
                  System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt2, paramArrayOfByte2.length);
                  paramInt2 += paramArrayOfByte2.length;
                  System.arraycopy(localObject12, 0, paramArrayOfByte5, paramInt2, localObject12.length);
                  paramInt2 += localObject12.length;
                  System.arraycopy(localObject13, 0, paramArrayOfByte5, paramInt2, localObject13.length);
                  paramInt2 += localObject13.length;
                  System.arraycopy(localObject14, 0, paramArrayOfByte5, paramInt2, localObject14.length);
                  paramInt2 += localObject14.length;
                  System.arraycopy(localObject15, 0, paramArrayOfByte5, paramInt2, localObject15.length);
                  paramInt2 += localObject15.length;
                  System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt2, paramArrayOfByte3.length);
                  paramInt2 += paramArrayOfByte3.length;
                  System.arraycopy(localObject16, 0, paramArrayOfByte5, paramInt2, localObject16.length);
                  paramInt2 += localObject16.length;
                  System.arraycopy(localObject1, 0, paramArrayOfByte5, paramInt2, localObject1.length);
                  paramInt2 += localObject1.length;
                  System.arraycopy(localObject2, 0, paramArrayOfByte5, paramInt2, localObject2.length);
                  paramInt2 += localObject2.length;
                  System.arraycopy(localObject3, 0, paramArrayOfByte5, paramInt2, localObject3.length);
                  paramInt2 = localObject3.length;
                  return a(paramArrayOfByte5, this.t, paramInt1 + 1);
                  localObject3 = new byte[0];
                }
                localObject2 = new byte[0];
              }
              localObject1 = new byte[0];
            }
            paramArrayOfByte3 = new byte[0];
          }
          paramArrayOfByte2 = new byte[0];
        }
        paramArrayOfLong = new byte[0];
      }
      paramArrayOfByte1 = new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.q
 * JD-Core Version:    0.7.0.1
 */