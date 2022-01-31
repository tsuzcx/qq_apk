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
import oicq.wlogin_sdk.b.be;
import oicq.wlogin_sdk.b.bg;
import oicq.wlogin_sdk.b.bj;
import oicq.wlogin_sdk.b.br;
import oicq.wlogin_sdk.b.bx;
import oicq.wlogin_sdk.b.by;
import oicq.wlogin_sdk.b.c;
import oicq.wlogin_sdk.b.cc;
import oicq.wlogin_sdk.b.ci;
import oicq.wlogin_sdk.b.cq;
import oicq.wlogin_sdk.b.h;
import oicq.wlogin_sdk.b.k;
import oicq.wlogin_sdk.b.q;
import oicq.wlogin_sdk.tools.util;

public class l
  extends j
{
  public l(t paramt)
  {
    this.s = 2064;
    this.t = 13;
    this.u = "wtlogin.login";
    this.w = paramt;
    this.w.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte3, long paramLong4, long paramLong5, long paramLong6, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, WUserSigInfo paramWUserSigInfo)
  {
    int k = t.u;
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
      byte[] arrayOfByte = a(paramLong1, paramLong2, paramLong3, k, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt3, paramInt4, paramArrayOfLong, t.Y, paramArrayOfByte3, paramLong4, paramLong5, paramLong6, paramArrayOfByte4, paramArrayOfByte5);
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
    Object localObject5 = new h();
    an localan = new an();
    Object localObject6 = new c();
    Object localObject22 = new oicq.wlogin_sdk.b.j();
    Object localObject8 = new oicq.wlogin_sdk.b.t();
    Object localObject21 = new q();
    Object localObject9 = new al();
    Object localObject11 = new ao();
    Object localObject20 = new bc();
    Object localObject13 = new br();
    Object localObject14 = new ak();
    Object localObject15 = new cq();
    Object localObject18 = new k();
    Object localObject12 = new ab();
    Object localObject10 = new af();
    Object localObject16 = new aq();
    ar localar = new ar();
    au localau = new au();
    Object localObject7 = new be();
    Object localObject19 = new bg();
    Object localObject17 = new bj();
    Object localObject1 = new bx();
    Object localObject2 = new by();
    Object localObject3 = new cc();
    Object localObject4 = new ci();
    ((h)localObject5).a(paramArrayOfByte1, paramArrayOfByte1.length);
    localObject5 = ((h)localObject5).a();
    localObject6 = ((c)localObject6).a(paramLong5, paramLong6, paramInt1, paramInt2);
    localObject8 = ((oicq.wlogin_sdk.b.t)localObject8).a(paramInt3, paramInt4, paramArrayOfLong);
    localObject9 = ((al)localObject9).a(t.C);
    localObject11 = ((ao)localObject11).a(t.y);
    localObject13 = ((br)localObject13).a(paramLong2, paramInt1, paramLong1, 0);
    localObject14 = ((ak)localObject14).b(t.A, t.B, t.D);
    localObject15 = ((cq)localObject15).a(0, t.s, 0);
    localObject16 = ((aq)localObject16).a(paramLong2, t.E, t.F);
    localObject17 = ((bj)localObject17).a(1524812170L, "6.3.1.2293");
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0)) {
      paramArrayOfByte1 = ((oicq.wlogin_sdk.b.j)localObject22).a(paramArrayOfByte3);
    }
    for (paramInt1 = 11;; paramInt1 = 10)
    {
      if ((this.w.g != null) && (!util.check_uin_account(this.w.g).booleanValue()))
      {
        paramArrayOfLong = ((q)localObject21).a(this.w.g.getBytes());
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0))
        {
          paramArrayOfByte2 = ((bc)localObject20).a(paramArrayOfByte2);
          paramInt1 += 1;
        }
        for (;;)
        {
          if ((this.w.p != null) && (this.w.p.length > 0))
          {
            paramArrayOfByte3 = ((bg)localObject19).a(this.w.p);
            paramInt1 += 1;
          }
          for (;;)
          {
            if ((t.L != null) && (t.L.length > 0))
            {
              localObject1 = ((bx)localObject1).a(t.L);
              paramInt1 += 1;
            }
            for (;;)
            {
              if ((t.M != null) && (t.M.length > 0))
              {
                localObject2 = ((by)localObject2).a(t.M);
                paramInt1 += 1;
              }
              for (;;)
              {
                if ((t.J != null) && (t.J.length > 0))
                {
                  localObject3 = ((cc)localObject3).a(t.J);
                  paramInt1 += 1;
                }
                for (;;)
                {
                  if ((t.P != null) && (t.P.length > 0))
                  {
                    localObject4 = ((ci)localObject4).a(t.P, t.Q);
                    paramInt1 += 1;
                  }
                  for (;;)
                  {
                    localObject18 = ((k)localObject18).a(t.K);
                    localObject19 = util.get_os_type();
                    localObject20 = util.get_os_version();
                    paramInt2 = t.B;
                    localObject21 = t.A;
                    localObject22 = t.D;
                    localObject12 = ((ab)localObject12).a((byte[])localObject19, (byte[])localObject20, paramInt2, (byte[])localObject21, new byte[0], (byte[])localObject22);
                    localObject10 = ((af)localObject10).a(t.R, t.S, t.T, 0, t.G, t.y, t.N);
                    paramArrayOfByte4 = localar.a(paramArrayOfByte4, paramLong4, paramLong5, paramLong6, paramArrayOfByte5, paramArrayOfByte6);
                    paramArrayOfByte5 = localau.b(t.X);
                    paramArrayOfByte6 = ((be)localObject7).a(t.G);
                    localObject7 = t.b(this.w.h)._tgtgt_key;
                    paramArrayOfByte4 = localan.a((byte[])localObject18, (byte[])localObject12, (byte[])localObject10, paramArrayOfByte4, new byte[0], paramArrayOfByte5, paramArrayOfByte6, (byte[])localObject7);
                    paramArrayOfByte5 = new byte[localObject5.length + localObject6.length + paramArrayOfByte1.length + localObject8.length + paramArrayOfLong.length + localObject9.length + localObject11.length + paramArrayOfByte4.length + paramArrayOfByte2.length + localObject13.length + localObject14.length + localObject15.length + localObject16.length + paramArrayOfByte3.length + localObject17.length + localObject1.length + localObject2.length + localObject3.length + localObject4.length];
                    System.arraycopy(localObject5, 0, paramArrayOfByte5, 0, localObject5.length);
                    paramInt2 = 0 + localObject5.length;
                    System.arraycopy(localObject6, 0, paramArrayOfByte5, paramInt2, localObject6.length);
                    paramInt2 += localObject6.length;
                    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, paramInt2, paramArrayOfByte1.length);
                    paramInt2 += paramArrayOfByte1.length;
                    System.arraycopy(localObject8, 0, paramArrayOfByte5, paramInt2, localObject8.length);
                    paramInt2 += localObject8.length;
                    System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte5, paramInt2, paramArrayOfLong.length);
                    paramInt2 += paramArrayOfLong.length;
                    System.arraycopy(localObject9, 0, paramArrayOfByte5, paramInt2, localObject9.length);
                    paramInt2 += localObject9.length;
                    System.arraycopy(localObject11, 0, paramArrayOfByte5, paramInt2, localObject11.length);
                    paramInt2 += localObject11.length;
                    System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt2, paramArrayOfByte4.length);
                    paramInt2 = paramArrayOfByte4.length + paramInt2;
                    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt2, paramArrayOfByte2.length);
                    paramInt2 += paramArrayOfByte2.length;
                    System.arraycopy(localObject13, 0, paramArrayOfByte5, paramInt2, localObject13.length);
                    paramInt2 += localObject13.length;
                    System.arraycopy(localObject14, 0, paramArrayOfByte5, paramInt2, localObject14.length);
                    paramInt2 += localObject14.length;
                    System.arraycopy(localObject15, 0, paramArrayOfByte5, paramInt2, localObject15.length);
                    paramInt2 += localObject15.length;
                    System.arraycopy(localObject16, 0, paramArrayOfByte5, paramInt2, localObject16.length);
                    paramInt2 += localObject16.length;
                    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt2, paramArrayOfByte3.length);
                    paramInt2 += paramArrayOfByte3.length;
                    System.arraycopy(localObject17, 0, paramArrayOfByte5, paramInt2, localObject17.length);
                    paramInt2 += localObject17.length;
                    System.arraycopy(localObject1, 0, paramArrayOfByte5, paramInt2, localObject1.length);
                    paramInt2 += localObject1.length;
                    System.arraycopy(localObject2, 0, paramArrayOfByte5, paramInt2, localObject2.length);
                    paramInt2 += localObject2.length;
                    System.arraycopy(localObject3, 0, paramArrayOfByte5, paramInt2, localObject3.length);
                    paramInt2 += localObject3.length;
                    System.arraycopy(localObject4, 0, paramArrayOfByte5, paramInt2, localObject4.length);
                    paramInt2 = localObject4.length;
                    return a(paramArrayOfByte5, this.t, paramInt1 + 1);
                    localObject4 = new byte[0];
                  }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.l
 * JD-Core Version:    0.7.0.1
 */