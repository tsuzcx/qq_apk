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
import oicq.wlogin_sdk.b.bx;
import oicq.wlogin_sdk.b.bz;
import oicq.wlogin_sdk.b.c;
import oicq.wlogin_sdk.b.ca;
import oicq.wlogin_sdk.b.cb;
import oicq.wlogin_sdk.b.ce;
import oicq.wlogin_sdk.b.ch;
import oicq.wlogin_sdk.b.cl;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.b.h;
import oicq.wlogin_sdk.b.i;
import oicq.wlogin_sdk.b.j;
import oicq.wlogin_sdk.b.q;
import oicq.wlogin_sdk.b.t;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public class p
  extends o
{
  public static boolean D = false;
  
  public p(y paramy)
  {
    this.s = 2064;
    this.t = 9;
    this.u = "wtlogin.login";
    this.w = paramy;
    this.w.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, byte[] paramArrayOfByte3, int paramInt4, int paramInt5, int paramInt6, long[] paramArrayOfLong, int paramInt7, long paramLong4, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    paramInt8 = y.u;
    Object localObject = y.b(this.w.h);
    ((k)localObject).l = util.get_rand_16byte(y.z);
    byte[] arrayOfByte1 = ((k)localObject).l;
    localObject = ((k)localObject).m;
    if (localObject == null) {
      localObject = new f();
    }
    for (;;)
    {
      paramInt1 = 0;
      for (;;)
      {
        byte[] arrayOfByte2 = a(paramLong1, paramLong2, paramInt8, paramLong3, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt3, paramArrayOfByte3, arrayOfByte1, paramInt4, paramInt5, paramInt6, paramArrayOfLong, paramInt7, paramLong4, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramArrayOfByte4, ((f)localObject).b(), y.C, paramWUserSigInfo._domains);
        a(this.h, this.s, this.i, paramLong3, this.l, this.m, paramInt8, this.o, arrayOfByte2);
        int i = a(String.valueOf(this.w.f), false, paramWUserSigInfo);
        if (i != 0) {
          return i;
        }
        i = b();
        util.LOGI("retry num:" + paramInt1 + " ret:" + i, "" + paramLong3);
        if (i != 180) {
          return i;
        }
        if (paramInt1 >= 1) {
          return i;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong4, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    int j = y.u;
    f localf = y.b(this.w.h).m;
    if (localf == null) {
      localf = new f();
    }
    for (;;)
    {
      paramArrayOfByte2 = c(paramArrayOfByte2);
      if (paramArrayOfByte2 == null)
      {
        paramInt6 = -1014;
        return paramInt6;
      }
      paramInt1 = 0;
      for (;;)
      {
        byte[] arrayOfByte = a(paramLong1, paramLong2, j, paramLong3, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong4, j, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfByte4, y.y, localf.b(), y.C, paramWUserSigInfo._domains);
        a(this.h, this.s, this.i, paramLong3, this.l, this.m, j, this.o, arrayOfByte);
        int i = a(String.valueOf(this.w.f), false, paramWUserSigInfo);
        paramInt6 = i;
        if (i != 0) {
          break;
        }
        paramInt6 = b();
        util.LOGI("retry num:" + paramInt1 + " ret:" + paramInt6, "" + paramLong3);
        if (paramInt6 != 180) {
          return paramInt6;
        }
        if (paramInt1 >= 1) {
          return paramInt6;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt4, int paramInt5, int paramInt6, long[] paramArrayOfLong, int paramInt7, long paramLong4, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, List<String> paramList)
  {
    Object localObject3 = new bt();
    Object localObject4 = new b();
    Object localObject7 = new h();
    Object localObject10 = new t();
    Object localObject8 = new c();
    Object localObject9 = new i();
    j localj = new j();
    Object localObject19 = new oicq.wlogin_sdk.b.k();
    f localf = new f();
    Object localObject18 = new ab();
    af localaf = new af();
    Object localObject17 = new al();
    q localq = new q();
    an localan = new an();
    Object localObject11 = new ao();
    Object localObject15 = new aq();
    az localaz = new az();
    Object localObject12 = new av();
    Object localObject13 = new ak();
    Object localObject14 = new cl();
    bd localbd = new bd();
    bg localbg = new bg();
    Object localObject23 = new bi();
    Object localObject16 = new bl();
    Object localObject1 = new bx();
    Object localObject2 = new ch();
    Object localObject22 = new bz();
    Object localObject21 = new ca();
    Object localObject20 = new ce();
    Object localObject6 = new cb();
    Object localObject5 = this.w.a(paramLong3, paramLong1);
    localObject3 = ((bt)localObject3).a(paramLong1, paramInt1, paramLong3, paramInt2);
    localObject4 = ((b)localObject4).a(paramLong3, paramArrayOfByte1);
    k localk = y.b(this.w.h);
    localObject7 = ((h)localObject7).a(paramLong1, paramLong2, paramInt1, paramLong3, paramArrayOfByte2, paramArrayOfByte1, 1, paramArrayOfByte3, localk.B, paramArrayOfByte4, y.Q, y.y, paramInt4);
    util.LOGD("req1 a1:", util.buf_to_string((byte[])localObject7));
    localObject8 = ((c)localObject8).a(paramLong1, paramLong4, paramInt1, paramInt7);
    localObject9 = ((i)localObject9).a(paramInt9, paramInt10, paramInt11, paramInt12);
    localObject10 = ((t)localObject10).a(paramInt5, paramInt6, paramArrayOfLong);
    localObject11 = ((ao)localObject11).a(y.y);
    localObject12 = ((av)localObject12).b(this.w.i);
    localObject13 = ((ak)localObject13).b(y.A, y.B, y.D);
    localObject14 = ((cl)localObject14).a(0, y.s, 0);
    localObject15 = ((aq)localObject15).a(paramLong1, y.E, y.F);
    localObject16 = ((bl)localObject16).a(1414386621L, "5.2.3.1");
    if ((paramArrayOfByte5 != null) && (paramArrayOfByte5.length > 0)) {
      paramArrayOfByte1 = localj.a(paramArrayOfByte5);
    }
    for (paramInt1 = 13;; paramInt1 = 12)
    {
      if ((paramInt5 & 0x80) != 0)
      {
        paramArrayOfByte2 = localaz.b(y.v);
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((this.w.p != null) && (this.w.p.length > 0))
        {
          paramArrayOfByte3 = ((bi)localObject23).a(this.w.p);
          paramInt1 += 1;
        }
        for (;;)
        {
          if ((y.L != null) && (y.L.length > 0))
          {
            paramArrayOfByte4 = ((bz)localObject22).a(y.L);
            paramInt1 += 1;
          }
          for (;;)
          {
            if ((y.M != null) && (y.M.length > 0))
            {
              paramArrayOfLong = ((ca)localObject21).a(y.M);
              paramInt1 += 1;
            }
            for (;;)
            {
              if ((y.J != null) && (y.J.length > 0))
              {
                paramArrayOfByte5 = ((ce)localObject20).a(y.J);
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
                localObject18 = localan.a((byte[])localObject19, ((ab)localObject18).a((byte[])localObject20, (byte[])localObject21, paramInt2, (byte[])localObject22, new byte[0], (byte[])localObject23), localaf.a(y.P, y.Q, y.R, y.U, y.G, y.y, y.N), localbg.a(y.G), localk.l);
                localObject17 = ((al)localObject17).a(paramArrayOfByte7);
                paramInt1 = paramInt1 + 1 + 1;
                if ((this.w.g != null) && (!util.check_uin_account(this.w.g).booleanValue()))
                {
                  paramArrayOfByte7 = localq.a(this.w.g.getBytes());
                  paramInt1 += 1;
                }
                for (;;)
                {
                  if ((paramArrayOfByte6 != null) && (paramArrayOfByte6.length > 0))
                  {
                    paramArrayOfByte6 = localf.a(paramArrayOfByte6);
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
                      if (paramInt4 == 3)
                      {
                        localObject1 = ((bx)localObject1).b(1);
                        paramInt1 += 1;
                      }
                      for (;;)
                      {
                        localObject6 = ((cb)localObject6).a(D);
                        paramInt1 += 1;
                        if ((localObject5 != null) && (((WloginSigInfo)localObject5)._G != null) && (((WloginSigInfo)localObject5)._G.length > 0) && (((WloginSigInfo)localObject5)._dpwd != null) && (((WloginSigInfo)localObject5)._dpwd.length > 0) && (((WloginSigInfo)localObject5)._randseed != null) && (((WloginSigInfo)localObject5)._randseed.length > 0))
                        {
                          localObject2 = ((ch)localObject2).a(((WloginSigInfo)localObject5)._G, paramLong3, y.y, ((WloginSigInfo)localObject5)._dpwd, paramLong1, paramLong2, ((WloginSigInfo)localObject5)._randseed);
                          paramInt1 += 1;
                        }
                        for (;;)
                        {
                          localObject5 = new byte[localObject3.length + localObject4.length + localObject7.length + localObject10.length + localObject8.length + localObject9.length + paramArrayOfByte1.length + localObject18.length + paramArrayOfByte6.length + localObject17.length + paramArrayOfByte7.length + localObject11.length + paramArrayOfByte2.length + localObject12.length + localObject13.length + localObject14.length + paramList.length + localObject15.length + paramArrayOfByte3.length + localObject16.length + localObject1.length + localObject2.length + paramArrayOfByte4.length + paramArrayOfLong.length + localObject6.length + paramArrayOfByte5.length];
                          System.arraycopy(localObject3, 0, localObject5, 0, localObject3.length);
                          paramInt2 = 0 + localObject3.length;
                          System.arraycopy(localObject4, 0, localObject5, paramInt2, localObject4.length);
                          paramInt2 += localObject4.length;
                          System.arraycopy(localObject7, 0, localObject5, paramInt2, localObject7.length);
                          paramInt2 += localObject7.length;
                          System.arraycopy(localObject10, 0, localObject5, paramInt2, localObject10.length);
                          paramInt2 += localObject10.length;
                          System.arraycopy(localObject8, 0, localObject5, paramInt2, localObject8.length);
                          paramInt2 += localObject8.length;
                          System.arraycopy(localObject9, 0, localObject5, paramInt2, localObject9.length);
                          paramInt2 += localObject9.length;
                          System.arraycopy(paramArrayOfByte1, 0, localObject5, paramInt2, paramArrayOfByte1.length);
                          paramInt2 += paramArrayOfByte1.length;
                          System.arraycopy(localObject18, 0, localObject5, paramInt2, localObject18.length);
                          paramInt2 += localObject18.length;
                          System.arraycopy(localObject17, 0, localObject5, paramInt2, localObject17.length);
                          paramInt2 += localObject17.length;
                          System.arraycopy(paramArrayOfByte7, 0, localObject5, paramInt2, paramArrayOfByte7.length);
                          paramInt2 += paramArrayOfByte7.length;
                          System.arraycopy(paramArrayOfByte6, 0, localObject5, paramInt2, paramArrayOfByte6.length);
                          paramInt2 += paramArrayOfByte6.length;
                          System.arraycopy(localObject11, 0, localObject5, paramInt2, localObject11.length);
                          paramInt2 += localObject11.length;
                          System.arraycopy(paramArrayOfByte2, 0, localObject5, paramInt2, paramArrayOfByte2.length);
                          paramInt2 += paramArrayOfByte2.length;
                          System.arraycopy(localObject12, 0, localObject5, paramInt2, localObject12.length);
                          paramInt2 += localObject12.length;
                          System.arraycopy(localObject13, 0, localObject5, paramInt2, localObject13.length);
                          paramInt2 += localObject13.length;
                          System.arraycopy(localObject14, 0, localObject5, paramInt2, localObject14.length);
                          paramInt2 += localObject14.length;
                          System.arraycopy(paramList, 0, localObject5, paramInt2, paramList.length);
                          paramInt2 += paramList.length;
                          System.arraycopy(localObject15, 0, localObject5, paramInt2, localObject15.length);
                          paramInt2 += localObject15.length;
                          System.arraycopy(paramArrayOfByte3, 0, localObject5, paramInt2, paramArrayOfByte3.length);
                          paramInt2 += paramArrayOfByte3.length;
                          System.arraycopy(localObject16, 0, localObject5, paramInt2, localObject16.length);
                          paramInt2 += localObject16.length;
                          System.arraycopy(localObject1, 0, localObject5, paramInt2, localObject1.length);
                          paramInt2 += localObject1.length;
                          System.arraycopy(localObject2, 0, localObject5, paramInt2, localObject2.length);
                          paramInt2 = localObject2.length + paramInt2;
                          System.arraycopy(paramArrayOfByte4, 0, localObject5, paramInt2, paramArrayOfByte4.length);
                          paramInt2 += paramArrayOfByte4.length;
                          System.arraycopy(paramArrayOfLong, 0, localObject5, paramInt2, paramArrayOfLong.length);
                          paramInt2 += paramArrayOfLong.length;
                          System.arraycopy(localObject6, 0, localObject5, paramInt2, localObject6.length);
                          paramInt2 += localObject6.length;
                          System.arraycopy(paramArrayOfByte5, 0, localObject5, paramInt2, paramArrayOfByte5.length);
                          paramInt2 = paramArrayOfByte5.length;
                          return a((byte[])localObject5, this.t, paramInt1);
                          localObject2 = new byte[0];
                        }
                        localObject1 = new byte[0];
                      }
                      paramList = new byte[0];
                    }
                    paramArrayOfByte6 = new byte[0];
                  }
                  paramArrayOfByte7 = new byte[0];
                }
                paramArrayOfByte5 = new byte[0];
              }
              paramArrayOfLong = new byte[0];
            }
            paramArrayOfByte4 = new byte[0];
          }
          paramArrayOfByte3 = new byte[0];
        }
        paramArrayOfByte2 = new byte[0];
      }
      paramArrayOfByte1 = new byte[0];
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong4, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, List<String> paramList)
  {
    Object localObject3 = new bt();
    Object localObject4 = new b();
    Object localObject6 = new h();
    Object localObject9 = new t();
    Object localObject7 = new c();
    Object localObject8 = new i();
    Object localObject22 = new j();
    Object localObject18 = new oicq.wlogin_sdk.b.k();
    f localf = new f();
    Object localObject17 = new ab();
    af localaf = new af();
    Object localObject16 = new al();
    q localq = new q();
    an localan = new an();
    Object localObject10 = new ao();
    Object localObject14 = new aq();
    Object localObject21 = new az();
    bc localbc = new bc();
    Object localObject11 = new av();
    Object localObject12 = new ak();
    Object localObject13 = new cl();
    bd localbd = new bd();
    bg localbg = new bg();
    Object localObject20 = new bi();
    Object localObject15 = new bl();
    Object localObject2 = new ch();
    Object localObject19 = new bz();
    paramArrayOfByte5 = new ca();
    Object localObject1 = new ce();
    Object localObject5 = this.w.a(paramLong3, paramLong1);
    localObject3 = ((bt)localObject3).a(paramLong1, paramInt1, paramLong3, paramInt2);
    localObject4 = ((b)localObject4).a(paramLong3, paramArrayOfByte1);
    ((h)localObject6).a(paramArrayOfByte2, paramArrayOfByte2.length);
    localObject6 = ((h)localObject6).a();
    util.LOGD("req2 a1:", util.buf_to_string((byte[])localObject6));
    localObject7 = ((c)localObject7).a(paramLong1, paramLong4, paramInt1, paramInt5);
    localObject8 = ((i)localObject8).a(paramInt7, paramInt8, paramInt9, paramInt10);
    localObject9 = ((t)localObject9).a(paramInt3, paramInt4, paramArrayOfLong);
    localObject10 = ((ao)localObject10).a(y.y);
    localObject11 = ((av)localObject11).b(this.w.i);
    localObject12 = ((ak)localObject12).b(y.A, y.B, y.D);
    localObject13 = ((cl)localObject13).a(0, y.s, 0);
    localObject14 = ((aq)localObject14).a(paramLong1, y.E, y.F);
    localObject15 = ((bl)localObject15).a(1414386621L, "5.2.3.1");
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0)) {
      paramArrayOfByte1 = ((j)localObject22).a(paramArrayOfByte4);
    }
    for (paramInt1 = 13;; paramInt1 = 12)
    {
      if ((paramInt3 & 0x80) != 0)
      {
        paramArrayOfByte2 = ((az)localObject21).b(y.v);
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((this.w.p != null) && (this.w.p.length > 0))
        {
          paramArrayOfLong = ((bi)localObject20).a(this.w.p);
          paramInt1 += 1;
        }
        for (;;)
        {
          if ((y.L != null) && (y.L.length > 0))
          {
            paramArrayOfByte4 = ((bz)localObject19).a(y.L);
            paramInt1 += 1;
          }
          for (;;)
          {
            if ((y.M != null) && (y.M.length > 0))
            {
              paramArrayOfByte5 = paramArrayOfByte5.a(y.M);
              paramInt1 += 1;
            }
            for (;;)
            {
              if ((y.J != null) && (y.J.length > 0))
              {
                localObject1 = ((ce)localObject1).a(y.J);
                paramInt1 += 1;
              }
              for (;;)
              {
                localObject18 = ((oicq.wlogin_sdk.b.k)localObject18).a(y.K);
                localObject19 = util.get_os_type();
                localObject20 = util.get_os_version();
                paramInt2 = y.B;
                localObject21 = y.A;
                localObject22 = y.D;
                localObject17 = localan.a((byte[])localObject18, ((ab)localObject17).a((byte[])localObject19, (byte[])localObject20, paramInt2, (byte[])localObject21, new byte[0], (byte[])localObject22), localaf.a(y.P, y.Q, y.R, y.U, y.G, y.y, y.N), localbg.a(y.G), y.b(this.w.h).l);
                localObject16 = ((al)localObject16).a(paramArrayOfByte7);
                paramInt1 = paramInt1 + 1 + 1;
                if ((this.w.g != null) && (!util.check_uin_account(this.w.g).booleanValue()))
                {
                  paramArrayOfByte7 = localq.a(this.w.g.getBytes());
                  paramInt1 += 1;
                }
                for (;;)
                {
                  if ((paramArrayOfByte6 != null) && (paramArrayOfByte6.length > 0))
                  {
                    paramArrayOfByte6 = localf.a(paramArrayOfByte6);
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
                        if ((localObject5 != null) && (((WloginSigInfo)localObject5)._G != null) && (((WloginSigInfo)localObject5)._G.length > 0) && (((WloginSigInfo)localObject5)._dpwd != null) && (((WloginSigInfo)localObject5)._dpwd.length > 0) && (((WloginSigInfo)localObject5)._randseed != null) && (((WloginSigInfo)localObject5)._randseed.length > 0))
                        {
                          localObject2 = ((ch)localObject2).a(((WloginSigInfo)localObject5)._G, paramLong3, y.y, ((WloginSigInfo)localObject5)._dpwd, paramLong1, paramLong2, ((WloginSigInfo)localObject5)._randseed);
                          paramInt1 += 1;
                        }
                        for (;;)
                        {
                          localObject5 = new byte[localObject3.length + localObject4.length + localObject6.length + localObject9.length + localObject7.length + localObject8.length + paramArrayOfByte1.length + localObject17.length + paramArrayOfByte6.length + localObject16.length + paramArrayOfByte7.length + localObject10.length + paramArrayOfByte2.length + paramArrayOfByte3.length + localObject11.length + localObject12.length + localObject13.length + paramList.length + localObject14.length + paramArrayOfLong.length + localObject15.length + localObject2.length + paramArrayOfByte4.length + paramArrayOfByte5.length + localObject1.length];
                          System.arraycopy(localObject3, 0, localObject5, 0, localObject3.length);
                          paramInt2 = 0 + localObject3.length;
                          System.arraycopy(localObject4, 0, localObject5, paramInt2, localObject4.length);
                          paramInt2 += localObject4.length;
                          System.arraycopy(localObject6, 0, localObject5, paramInt2, localObject6.length);
                          paramInt2 += localObject6.length;
                          System.arraycopy(localObject9, 0, localObject5, paramInt2, localObject9.length);
                          paramInt2 += localObject9.length;
                          System.arraycopy(localObject7, 0, localObject5, paramInt2, localObject7.length);
                          paramInt2 += localObject7.length;
                          System.arraycopy(localObject8, 0, localObject5, paramInt2, localObject8.length);
                          paramInt2 += localObject8.length;
                          System.arraycopy(paramArrayOfByte1, 0, localObject5, paramInt2, paramArrayOfByte1.length);
                          paramInt2 += paramArrayOfByte1.length;
                          System.arraycopy(localObject17, 0, localObject5, paramInt2, localObject17.length);
                          paramInt2 += localObject17.length;
                          System.arraycopy(localObject16, 0, localObject5, paramInt2, localObject16.length);
                          paramInt2 += localObject16.length;
                          System.arraycopy(paramArrayOfByte7, 0, localObject5, paramInt2, paramArrayOfByte7.length);
                          paramInt2 += paramArrayOfByte7.length;
                          System.arraycopy(paramArrayOfByte6, 0, localObject5, paramInt2, paramArrayOfByte6.length);
                          paramInt2 += paramArrayOfByte6.length;
                          System.arraycopy(localObject10, 0, localObject5, paramInt2, localObject10.length);
                          paramInt2 += localObject10.length;
                          System.arraycopy(paramArrayOfByte2, 0, localObject5, paramInt2, paramArrayOfByte2.length);
                          paramInt2 += paramArrayOfByte2.length;
                          System.arraycopy(paramArrayOfByte3, 0, localObject5, paramInt2, paramArrayOfByte3.length);
                          paramInt2 += paramArrayOfByte3.length;
                          System.arraycopy(localObject11, 0, localObject5, paramInt2, localObject11.length);
                          paramInt2 += localObject11.length;
                          System.arraycopy(localObject12, 0, localObject5, paramInt2, localObject12.length);
                          paramInt2 += localObject12.length;
                          System.arraycopy(localObject13, 0, localObject5, paramInt2, localObject13.length);
                          paramInt2 += localObject13.length;
                          System.arraycopy(paramList, 0, localObject5, paramInt2, paramList.length);
                          paramInt2 += paramList.length;
                          System.arraycopy(localObject14, 0, localObject5, paramInt2, localObject14.length);
                          paramInt2 += localObject14.length;
                          System.arraycopy(paramArrayOfLong, 0, localObject5, paramInt2, paramArrayOfLong.length);
                          paramInt2 += paramArrayOfLong.length;
                          System.arraycopy(localObject15, 0, localObject5, paramInt2, localObject15.length);
                          paramInt2 += localObject15.length;
                          System.arraycopy(localObject2, 0, localObject5, paramInt2, localObject2.length);
                          paramInt2 = localObject2.length + paramInt2;
                          System.arraycopy(paramArrayOfByte4, 0, localObject5, paramInt2, paramArrayOfByte4.length);
                          paramInt2 += paramArrayOfByte4.length;
                          System.arraycopy(paramArrayOfByte5, 0, localObject5, paramInt2, paramArrayOfByte5.length);
                          paramInt2 += paramArrayOfByte5.length;
                          System.arraycopy(localObject1, 0, localObject5, paramInt2, localObject1.length);
                          paramInt2 = localObject1.length;
                          return a((byte[])localObject5, this.t, paramInt1);
                          localObject2 = new byte[0];
                        }
                        paramList = new byte[0];
                      }
                      paramArrayOfByte3 = new byte[0];
                    }
                    paramArrayOfByte6 = new byte[0];
                  }
                  paramArrayOfByte7 = new byte[0];
                }
                localObject1 = new byte[0];
              }
              paramArrayOfByte5 = new byte[0];
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
 * Qualified Name:     oicq.wlogin_sdk.request.p
 * JD-Core Version:    0.7.0.1
 */