package oicq.wlogin_sdk.request;

import java.util.List;
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
import oicq.wlogin_sdk.b.bd;
import oicq.wlogin_sdk.b.bg;
import oicq.wlogin_sdk.b.bi;
import oicq.wlogin_sdk.b.bl;
import oicq.wlogin_sdk.b.bt;
import oicq.wlogin_sdk.b.bz;
import oicq.wlogin_sdk.b.c;
import oicq.wlogin_sdk.b.ca;
import oicq.wlogin_sdk.b.ce;
import oicq.wlogin_sdk.b.ch;
import oicq.wlogin_sdk.b.cl;
import oicq.wlogin_sdk.b.h;
import oicq.wlogin_sdk.b.i;
import oicq.wlogin_sdk.b.j;
import oicq.wlogin_sdk.b.q;
import oicq.wlogin_sdk.b.t;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public class ad
  extends o
{
  public ad(y paramy)
  {
    this.s = 2064;
    this.t = 15;
    this.u = "wtlogin.exchange_emp";
    this.w = paramy;
    this.w.m = 0;
  }
  
  public int a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, long paramLong4, WUserSigInfo paramWUserSigInfo)
  {
    int j = y.u;
    paramArrayOfByte2 = c(paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      paramInt6 = -1014;
      return paramInt6;
    }
    paramInt1 = 0;
    for (;;)
    {
      a(this.h, this.s, this.i, paramLong2, this.l, this.m, j, this.o, a(paramLong1, j, paramLong2, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong3, j, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfByte4, paramLong4, y.C, paramWUserSigInfo._domains));
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
    Object localObject4 = new bt();
    Object localObject5 = new b();
    Object localObject7 = new h();
    Object localObject10 = new t();
    Object localObject8 = new c();
    Object localObject9 = new i();
    Object localObject23 = new j();
    Object localObject19 = new oicq.wlogin_sdk.b.k();
    Object localObject18 = new ab();
    af localaf = new af();
    Object localObject17 = new al();
    q localq = new q();
    an localan = new an();
    Object localObject11 = new ao();
    Object localObject15 = new aq();
    Object localObject22 = new az();
    bc localbc = new bc();
    Object localObject13 = new ak();
    Object localObject14 = new cl();
    Object localObject12 = new av();
    bd localbd = new bd();
    bg localbg = new bg();
    Object localObject21 = new bi();
    Object localObject16 = new bl();
    Object localObject3 = new ch();
    Object localObject20 = new bz();
    Object localObject1 = new ca();
    Object localObject2 = new ce();
    Object localObject6 = this.w.a(paramLong2, paramLong4);
    localObject4 = ((bt)localObject4).a(paramLong1, paramInt1, paramLong2, paramInt2);
    localObject5 = ((b)localObject5).a(paramLong2, paramArrayOfByte1);
    ((h)localObject7).a(paramArrayOfByte2, paramArrayOfByte2.length);
    localObject7 = ((h)localObject7).a();
    util.LOGD("req2 a1:", util.buf_to_string((byte[])localObject7));
    localObject8 = ((c)localObject8).a(paramLong1, paramLong3, paramInt1, paramInt5);
    localObject9 = ((i)localObject9).a(paramInt7, paramInt8, paramInt9, paramInt10);
    localObject10 = ((t)localObject10).a(paramInt3, paramInt4, paramArrayOfLong);
    localObject11 = ((ao)localObject11).a(y.y);
    localObject12 = ((av)localObject12).b(this.w.i);
    localObject13 = ((ak)localObject13).b(y.A, y.B, y.D);
    localObject14 = ((cl)localObject14).a(0, y.s, 0);
    localObject15 = ((aq)localObject15).a(paramLong4, y.E, y.F);
    localObject16 = ((bl)localObject16).a(1414386621L, "5.2.3.1");
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0)) {
      paramArrayOfByte1 = ((j)localObject23).a(paramArrayOfByte4);
    }
    for (paramInt1 = 13;; paramInt1 = 12)
    {
      if ((paramInt3 & 0x80) != 0)
      {
        paramArrayOfByte2 = ((az)localObject22).b(y.v);
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((this.w.p != null) && (this.w.p.length > 0))
        {
          paramArrayOfLong = ((bi)localObject21).a(this.w.p);
          paramInt1 += 1;
        }
        for (;;)
        {
          if ((y.L != null) && (y.L.length > 0))
          {
            paramArrayOfByte4 = ((bz)localObject20).a(y.L);
            paramInt1 += 1;
          }
          for (;;)
          {
            if ((y.M != null) && (y.M.length > 0))
            {
              localObject1 = ((ca)localObject1).a(y.M);
              paramInt1 += 1;
            }
            for (;;)
            {
              if ((y.J != null) && (y.J.length > 0))
              {
                localObject2 = ((ce)localObject2).a(y.J);
                paramInt1 += 1;
              }
              for (;;)
              {
                localObject19 = ((oicq.wlogin_sdk.b.k)localObject19).a(y.K);
                localObject20 = util.get_os_type();
                localObject21 = util.get_os_version();
                paramInt2 = y.B;
                localObject22 = y.A;
                localObject23 = y.D;
                localObject18 = localan.a((byte[])localObject19, ((ab)localObject18).a((byte[])localObject20, (byte[])localObject21, paramInt2, (byte[])localObject22, new byte[0], (byte[])localObject23), localaf.a(y.P, y.Q, y.R, y.U, y.G, y.y, y.N), localbg.a(y.G), y.b(this.w.h).l);
                localObject17 = ((al)localObject17).a(paramArrayOfByte5);
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
                      paramList = localbd.a(paramList);
                      paramInt1 += 1;
                    }
                    for (;;)
                    {
                      if ((localObject6 != null) && (((WloginSigInfo)localObject6)._G != null) && (((WloginSigInfo)localObject6)._G.length > 0) && (((WloginSigInfo)localObject6)._dpwd != null) && (((WloginSigInfo)localObject6)._dpwd.length > 0) && (((WloginSigInfo)localObject6)._randseed != null) && (((WloginSigInfo)localObject6)._randseed.length > 0))
                      {
                        localObject3 = ((ch)localObject3).a(((WloginSigInfo)localObject6)._G, paramLong2, y.y, ((WloginSigInfo)localObject6)._dpwd, paramLong4, 1L, ((WloginSigInfo)localObject6)._randseed);
                        paramInt1 += 1;
                      }
                      for (;;)
                      {
                        localObject6 = new byte[localObject4.length + localObject5.length + localObject7.length + localObject10.length + localObject8.length + localObject9.length + paramArrayOfByte1.length + localObject18.length + localObject17.length + paramArrayOfByte5.length + localObject11.length + paramArrayOfByte2.length + paramArrayOfByte3.length + localObject12.length + localObject13.length + localObject14.length + paramList.length + localObject15.length + paramArrayOfLong.length + localObject16.length + localObject3.length + paramArrayOfByte4.length + localObject1.length + localObject2.length];
                        System.arraycopy(localObject4, 0, localObject6, 0, localObject4.length);
                        paramInt2 = 0 + localObject4.length;
                        System.arraycopy(localObject5, 0, localObject6, paramInt2, localObject5.length);
                        paramInt2 += localObject5.length;
                        System.arraycopy(localObject7, 0, localObject6, paramInt2, localObject7.length);
                        paramInt2 += localObject7.length;
                        System.arraycopy(localObject10, 0, localObject6, paramInt2, localObject10.length);
                        paramInt2 += localObject10.length;
                        System.arraycopy(localObject8, 0, localObject6, paramInt2, localObject8.length);
                        paramInt2 += localObject8.length;
                        System.arraycopy(localObject9, 0, localObject6, paramInt2, localObject9.length);
                        paramInt2 += localObject9.length;
                        System.arraycopy(paramArrayOfByte1, 0, localObject6, paramInt2, paramArrayOfByte1.length);
                        paramInt2 += paramArrayOfByte1.length;
                        System.arraycopy(localObject18, 0, localObject6, paramInt2, localObject18.length);
                        paramInt2 += localObject18.length;
                        System.arraycopy(localObject17, 0, localObject6, paramInt2, localObject17.length);
                        paramInt2 += localObject17.length;
                        System.arraycopy(paramArrayOfByte5, 0, localObject6, paramInt2, paramArrayOfByte5.length);
                        paramInt2 += paramArrayOfByte5.length;
                        System.arraycopy(localObject11, 0, localObject6, paramInt2, localObject11.length);
                        paramInt2 += localObject11.length;
                        System.arraycopy(paramArrayOfByte2, 0, localObject6, paramInt2, paramArrayOfByte2.length);
                        paramInt2 += paramArrayOfByte2.length;
                        System.arraycopy(paramArrayOfByte3, 0, localObject6, paramInt2, paramArrayOfByte3.length);
                        paramInt2 += paramArrayOfByte3.length;
                        System.arraycopy(localObject12, 0, localObject6, paramInt2, localObject12.length);
                        paramInt2 += localObject12.length;
                        System.arraycopy(localObject13, 0, localObject6, paramInt2, localObject13.length);
                        paramInt2 += localObject13.length;
                        System.arraycopy(localObject14, 0, localObject6, paramInt2, localObject14.length);
                        paramInt2 += localObject14.length;
                        System.arraycopy(paramList, 0, localObject6, paramInt2, paramList.length);
                        paramInt2 += paramList.length;
                        System.arraycopy(localObject15, 0, localObject6, paramInt2, localObject15.length);
                        paramInt2 += localObject15.length;
                        System.arraycopy(paramArrayOfLong, 0, localObject6, paramInt2, paramArrayOfLong.length);
                        paramInt2 += paramArrayOfLong.length;
                        System.arraycopy(localObject16, 0, localObject6, paramInt2, localObject16.length);
                        paramInt2 += localObject16.length;
                        System.arraycopy(localObject3, 0, localObject6, paramInt2, localObject3.length);
                        paramInt2 = localObject3.length + paramInt2;
                        System.arraycopy(paramArrayOfByte4, 0, localObject6, paramInt2, paramArrayOfByte4.length);
                        paramInt2 += paramArrayOfByte4.length;
                        System.arraycopy(localObject1, 0, localObject6, paramInt2, localObject1.length);
                        paramInt2 += localObject1.length;
                        System.arraycopy(localObject2, 0, localObject6, paramInt2, localObject2.length);
                        paramInt2 = localObject2.length;
                        return a((byte[])localObject6, this.t, paramInt1);
                        localObject3 = new byte[0];
                      }
                      paramList = new byte[0];
                    }
                    paramArrayOfByte3 = new byte[0];
                  }
                  paramArrayOfByte5 = new byte[0];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.ad
 * JD-Core Version:    0.7.0.1
 */