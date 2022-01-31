package oicq.wlogin_sdk.request;

import java.util.List;
import oicq.wlogin_sdk.b.a;
import oicq.wlogin_sdk.b.ab;
import oicq.wlogin_sdk.b.af;
import oicq.wlogin_sdk.b.ak;
import oicq.wlogin_sdk.b.al;
import oicq.wlogin_sdk.b.an;
import oicq.wlogin_sdk.b.ao;
import oicq.wlogin_sdk.b.aq;
import oicq.wlogin_sdk.b.av;
import oicq.wlogin_sdk.b.az;
import oicq.wlogin_sdk.b.b;
import oicq.wlogin_sdk.b.bc;
import oicq.wlogin_sdk.b.be;
import oicq.wlogin_sdk.b.bg;
import oicq.wlogin_sdk.b.bj;
import oicq.wlogin_sdk.b.br;
import oicq.wlogin_sdk.b.bx;
import oicq.wlogin_sdk.b.by;
import oicq.wlogin_sdk.b.c;
import oicq.wlogin_sdk.b.cc;
import oicq.wlogin_sdk.b.ch;
import oicq.wlogin_sdk.b.ci;
import oicq.wlogin_sdk.b.ck;
import oicq.wlogin_sdk.b.cp;
import oicq.wlogin_sdk.b.cq;
import oicq.wlogin_sdk.b.h;
import oicq.wlogin_sdk.b.i;
import oicq.wlogin_sdk.b.q;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public class y
  extends j
{
  public y(t paramt)
  {
    this.s = 2064;
    this.t = 15;
    this.u = "wtlogin.exchange_emp";
    this.w = paramt;
    this.w.m = 0;
  }
  
  public int a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, long paramLong4, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.u;
    paramArrayOfByte2 = c(paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      paramInt6 = -1014;
      return paramInt6;
    }
    paramInt1 = 0;
    for (;;)
    {
      a(this.h, this.s, this.i, paramLong2, this.l, this.m, j, this.o, a(paramLong1, j, paramLong2, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong3, j, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfByte4, paramLong4, t.C, paramWUserSigInfo._domains));
      int i = a(String.valueOf(this.w.f), false, paramWUserSigInfo);
      paramInt6 = i;
      if (i != 0) {
        break;
      }
      paramInt6 = b();
      util.LOGI("retry num:" + paramInt1 + " ret:" + paramInt6, "" + paramLong2);
      if (paramInt6 != 180) {
        return paramInt6;
      }
      if (paramInt1 >= 1) {
        return paramInt6;
      }
      paramInt1 += 1;
    }
  }
  
  public byte[] a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, long paramLong4, byte[] paramArrayOfByte5, List<String> paramList)
  {
    Object localObject6 = new br();
    Object localObject8 = new b();
    Object localObject9 = new h();
    Object localObject13 = new oicq.wlogin_sdk.b.t();
    Object localObject11 = new c();
    Object localObject12 = new i();
    Object localObject26 = new oicq.wlogin_sdk.b.j();
    Object localObject22 = new oicq.wlogin_sdk.b.k();
    Object localObject21 = new ab();
    af localaf = new af();
    Object localObject20 = new al();
    q localq = new q();
    an localan = new an();
    Object localObject14 = new ao();
    Object localObject18 = new aq();
    Object localObject25 = new az();
    bc localbc = new bc();
    Object localObject16 = new ak();
    Object localObject17 = new cq();
    Object localObject15 = new av();
    cp localcp = new cp();
    be localbe = new be();
    Object localObject24 = new bg();
    Object localObject19 = new bj();
    Object localObject5 = new ck();
    Object localObject23 = new bx();
    Object localObject1 = new by();
    Object localObject2 = new cc();
    Object localObject3 = new ch();
    Object localObject4 = new ci();
    Object localObject7 = new a(1313);
    Object localObject10 = this.w.a(paramLong2, paramLong4);
    localObject6 = ((br)localObject6).a(paramLong1, paramInt1, paramLong2, paramInt2);
    localObject8 = ((b)localObject8).a(paramLong2, paramArrayOfByte1);
    ((h)localObject9).a(paramArrayOfByte2, paramArrayOfByte2.length);
    localObject9 = ((h)localObject9).a();
    util.LOGD("req2 a1:", util.buf_to_string((byte[])localObject9));
    localObject11 = ((c)localObject11).a(paramLong1, paramLong3, paramInt1, paramInt5);
    localObject12 = ((i)localObject12).a(paramInt7, paramInt8, paramInt9, paramInt10);
    localObject13 = ((oicq.wlogin_sdk.b.t)localObject13).a(paramInt3, paramInt4, paramArrayOfLong);
    localObject14 = ((ao)localObject14).a(t.y);
    localObject15 = ((av)localObject15).b(this.w.i);
    localObject16 = ((ak)localObject16).b(t.A, t.B, t.D);
    localObject17 = ((cq)localObject17).a(0, t.s, 0);
    localObject18 = ((aq)localObject18).a(paramLong4, t.E, t.F);
    localObject19 = ((bj)localObject19).a(1524812170L, "6.3.1.2293");
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0)) {
      paramArrayOfByte1 = ((oicq.wlogin_sdk.b.j)localObject26).a(paramArrayOfByte4);
    }
    for (paramInt1 = 13;; paramInt1 = 12)
    {
      if ((paramInt3 & 0x80) != 0)
      {
        paramArrayOfByte2 = ((az)localObject25).b(t.v);
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((this.w.p != null) && (this.w.p.length > 0))
        {
          paramArrayOfLong = ((bg)localObject24).a(this.w.p);
          paramInt1 += 1;
        }
        for (;;)
        {
          if ((t.L != null) && (t.L.length > 0))
          {
            paramArrayOfByte4 = ((bx)localObject23).a(t.L);
            paramInt1 += 1;
          }
          for (;;)
          {
            if ((t.M != null) && (t.M.length > 0))
            {
              localObject1 = ((by)localObject1).a(t.M);
              paramInt1 += 1;
            }
            for (;;)
            {
              if ((t.J != null) && (t.J.length > 0))
              {
                localObject2 = ((cc)localObject2).a(t.J);
                paramInt1 += 1;
              }
              for (;;)
              {
                if ((k.E != null) && (k.E.length > 0))
                {
                  localObject3 = ((ch)localObject3).a(k.E, k.F, "qq".getBytes(), k.G);
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
                    localObject22 = ((oicq.wlogin_sdk.b.k)localObject22).a(t.K);
                    localObject23 = util.get_os_type();
                    localObject24 = util.get_os_version();
                    paramInt2 = t.B;
                    localObject25 = t.A;
                    localObject26 = t.D;
                    localObject21 = localan.a((byte[])localObject22, ((ab)localObject21).a((byte[])localObject23, (byte[])localObject24, paramInt2, (byte[])localObject25, new byte[0], (byte[])localObject26), localaf.a(t.R, t.S, t.T, t.W, t.G, t.y, t.N), localbe.a(t.G), t.b(this.w.h)._tgtgt_key);
                    localObject20 = ((al)localObject20).a(paramArrayOfByte5);
                    paramInt1 = paramInt1 + 1 + 1;
                    if ((this.w.g != null) && (!util.check_uin_account(this.w.g).booleanValue()))
                    {
                      paramArrayOfByte5 = localq.a(this.w.g.getBytes());
                      paramInt1 += 1;
                    }
                    for (;;)
                    {
                      if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
                      {
                        paramArrayOfByte3 = localbc.a(paramArrayOfByte3);
                        paramInt1 += 1;
                      }
                      for (;;)
                      {
                        if ((paramList != null) && (paramList.size() > 0))
                        {
                          paramList = localcp.a(paramList);
                          paramInt1 += 1;
                        }
                        for (;;)
                        {
                          if ((localObject10 != null) && (((WloginSigInfo)localObject10)._G != null) && (((WloginSigInfo)localObject10)._G.length > 0) && (((WloginSigInfo)localObject10)._dpwd != null) && (((WloginSigInfo)localObject10)._dpwd.length > 0) && (((WloginSigInfo)localObject10)._randseed != null) && (((WloginSigInfo)localObject10)._randseed.length > 0))
                          {
                            localObject5 = ((ck)localObject5).a(((WloginSigInfo)localObject10)._G, paramLong2, t.y, ((WloginSigInfo)localObject10)._dpwd, paramLong4, 1L, ((WloginSigInfo)localObject10)._randseed);
                            paramInt1 += 1;
                          }
                          for (;;)
                          {
                            localObject10 = new byte[6];
                            util.int32_to_buf((byte[])localObject10, 0, t.ak);
                            util.int16_to_buf((byte[])localObject10, 4, 0);
                            ((a)localObject7).a((byte[])localObject10, 6);
                            localObject7 = ((a)localObject7).a();
                            localObject10 = new byte[localObject6.length + localObject8.length + localObject9.length + localObject13.length + localObject11.length + localObject12.length + paramArrayOfByte1.length + localObject21.length + localObject20.length + paramArrayOfByte5.length + localObject14.length + paramArrayOfByte2.length + paramArrayOfByte3.length + localObject15.length + localObject16.length + localObject17.length + paramList.length + localObject18.length + paramArrayOfLong.length + localObject19.length + localObject5.length + paramArrayOfByte4.length + localObject1.length + localObject2.length + localObject3.length + localObject4.length + localObject7.length];
                            System.arraycopy(localObject6, 0, localObject10, 0, localObject6.length);
                            paramInt2 = 0 + localObject6.length;
                            System.arraycopy(localObject8, 0, localObject10, paramInt2, localObject8.length);
                            paramInt2 += localObject8.length;
                            System.arraycopy(localObject9, 0, localObject10, paramInt2, localObject9.length);
                            paramInt2 += localObject9.length;
                            System.arraycopy(localObject13, 0, localObject10, paramInt2, localObject13.length);
                            paramInt2 += localObject13.length;
                            System.arraycopy(localObject11, 0, localObject10, paramInt2, localObject11.length);
                            paramInt2 += localObject11.length;
                            System.arraycopy(localObject12, 0, localObject10, paramInt2, localObject12.length);
                            paramInt2 += localObject12.length;
                            System.arraycopy(paramArrayOfByte1, 0, localObject10, paramInt2, paramArrayOfByte1.length);
                            paramInt2 += paramArrayOfByte1.length;
                            System.arraycopy(localObject21, 0, localObject10, paramInt2, localObject21.length);
                            paramInt2 += localObject21.length;
                            System.arraycopy(localObject20, 0, localObject10, paramInt2, localObject20.length);
                            paramInt2 += localObject20.length;
                            System.arraycopy(paramArrayOfByte5, 0, localObject10, paramInt2, paramArrayOfByte5.length);
                            paramInt2 += paramArrayOfByte5.length;
                            System.arraycopy(localObject14, 0, localObject10, paramInt2, localObject14.length);
                            paramInt2 += localObject14.length;
                            System.arraycopy(paramArrayOfByte2, 0, localObject10, paramInt2, paramArrayOfByte2.length);
                            paramInt2 += paramArrayOfByte2.length;
                            System.arraycopy(paramArrayOfByte3, 0, localObject10, paramInt2, paramArrayOfByte3.length);
                            paramInt2 += paramArrayOfByte3.length;
                            System.arraycopy(localObject15, 0, localObject10, paramInt2, localObject15.length);
                            paramInt2 += localObject15.length;
                            System.arraycopy(localObject16, 0, localObject10, paramInt2, localObject16.length);
                            paramInt2 += localObject16.length;
                            System.arraycopy(localObject17, 0, localObject10, paramInt2, localObject17.length);
                            paramInt2 += localObject17.length;
                            System.arraycopy(paramList, 0, localObject10, paramInt2, paramList.length);
                            paramInt2 += paramList.length;
                            System.arraycopy(localObject18, 0, localObject10, paramInt2, localObject18.length);
                            paramInt2 += localObject18.length;
                            System.arraycopy(paramArrayOfLong, 0, localObject10, paramInt2, paramArrayOfLong.length);
                            paramInt2 += paramArrayOfLong.length;
                            System.arraycopy(localObject19, 0, localObject10, paramInt2, localObject19.length);
                            paramInt2 += localObject19.length;
                            System.arraycopy(localObject5, 0, localObject10, paramInt2, localObject5.length);
                            paramInt2 = localObject5.length + paramInt2;
                            System.arraycopy(paramArrayOfByte4, 0, localObject10, paramInt2, paramArrayOfByte4.length);
                            paramInt2 += paramArrayOfByte4.length;
                            System.arraycopy(localObject1, 0, localObject10, paramInt2, localObject1.length);
                            paramInt2 += localObject1.length;
                            System.arraycopy(localObject2, 0, localObject10, paramInt2, localObject2.length);
                            paramInt2 += localObject2.length;
                            System.arraycopy(localObject3, 0, localObject10, paramInt2, localObject3.length);
                            paramInt2 += localObject3.length;
                            System.arraycopy(localObject4, 0, localObject10, paramInt2, localObject4.length);
                            paramInt2 += localObject4.length;
                            System.arraycopy(localObject7, 0, localObject10, paramInt2, localObject7.length);
                            paramInt2 = localObject7.length;
                            return a((byte[])localObject10, this.t, paramInt1 + 1);
                            localObject5 = new byte[0];
                          }
                          paramList = new byte[0];
                        }
                        paramArrayOfByte3 = new byte[0];
                      }
                      paramArrayOfByte5 = new byte[0];
                    }
                    localObject4 = new byte[0];
                  }
                  localObject3 = new byte[0];
                }
                localObject2 = new byte[0];
              }
              localObject1 = new byte[0];
            }
            paramArrayOfByte4 = new byte[0];
          }
          paramArrayOfLong = new byte[0];
        }
        paramArrayOfByte2 = new byte[0];
      }
      paramArrayOfByte1 = new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.y
 * JD-Core Version:    0.7.0.1
 */