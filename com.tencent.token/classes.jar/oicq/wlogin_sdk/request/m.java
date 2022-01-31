package oicq.wlogin_sdk.request;

import java.util.List;
import oicq.wlogin_sdk.b.ab;
import oicq.wlogin_sdk.b.af;
import oicq.wlogin_sdk.b.ak;
import oicq.wlogin_sdk.b.al;
import oicq.wlogin_sdk.b.am;
import oicq.wlogin_sdk.b.an;
import oicq.wlogin_sdk.b.ao;
import oicq.wlogin_sdk.b.aq;
import oicq.wlogin_sdk.b.av;
import oicq.wlogin_sdk.b.bd;
import oicq.wlogin_sdk.b.bg;
import oicq.wlogin_sdk.b.bi;
import oicq.wlogin_sdk.b.bl;
import oicq.wlogin_sdk.b.bt;
import oicq.wlogin_sdk.b.bz;
import oicq.wlogin_sdk.b.c;
import oicq.wlogin_sdk.b.ca;
import oicq.wlogin_sdk.b.ce;
import oicq.wlogin_sdk.b.cj;
import oicq.wlogin_sdk.b.ck;
import oicq.wlogin_sdk.b.cr;
import oicq.wlogin_sdk.b.l;
import oicq.wlogin_sdk.b.q;
import oicq.wlogin_sdk.tools.util;

public class m
  extends j
{
  public m(t paramt)
  {
    this.s = 2064;
    this.t = 10;
    this.u = "wtlogin.exchange_emp";
    this.w = paramt;
    this.w.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte2, WUserSigInfo paramWUserSigInfo)
  {
    int i = t.u;
    paramInt1 = 0;
    for (;;)
    {
      a(this.h, this.s, this.i, paramLong1, this.l, this.m, i, this.o, a(paramLong1, paramLong2, paramLong3, i, paramInt2, paramArrayOfByte1, paramInt3, paramInt4, paramArrayOfLong, t.Y, paramArrayOfByte2, paramWUserSigInfo._domains));
      int j = a(String.valueOf(this.w.f), false, paramWUserSigInfo);
      if (j != 0) {
        return j;
      }
      j = b();
      util.LOGI("retry num:" + paramInt1 + " ret:" + j, "" + paramLong1);
      if (j != 180) {
        return j;
      }
      if (paramInt1 >= 1) {
        return j;
      }
      paramInt1 += 1;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, List<String> paramList)
  {
    int i = this.t;
    Object localObject6 = new c();
    Object localObject7 = new l();
    Object localObject8 = new oicq.wlogin_sdk.b.t();
    Object localObject22 = new oicq.wlogin_sdk.b.j();
    Object localObject16 = new oicq.wlogin_sdk.b.k();
    Object localObject9 = new ab();
    af localaf = new af();
    Object localObject5 = new am();
    q localq = new q();
    an localan = new an();
    Object localObject11 = new ao();
    Object localObject17 = new aq();
    Object localObject10 = new al();
    Object localObject12 = new av();
    Object localObject13 = new bt();
    Object localObject14 = new ak();
    Object localObject15 = new cr();
    Object localObject21 = new bd();
    bg localbg = new bg();
    Object localObject20 = new bi();
    Object localObject18 = new bl();
    Object localObject19 = new bz();
    Object localObject1 = new ca();
    Object localObject2 = new ce();
    Object localObject3 = new cj();
    Object localObject4 = new ck();
    localObject6 = ((c)localObject6).a(paramLong2, paramLong3, paramInt1, paramInt2);
    localObject7 = ((l)localObject7).a(paramArrayOfByte1);
    localObject8 = ((oicq.wlogin_sdk.b.t)localObject8).a(paramInt3, paramInt4, paramArrayOfLong);
    localObject11 = ((ao)localObject11).a(t.y);
    localObject10 = ((al)localObject10).a(t.C);
    localObject12 = ((av)localObject12).b(this.w.i);
    localObject13 = ((bt)localObject13).a(paramLong2, paramInt1, paramLong1, 0);
    localObject14 = ((ak)localObject14).b(t.A, t.B, t.D);
    localObject15 = ((cr)localObject15).a(0, t.s, 0);
    localObject17 = ((aq)localObject17).a(paramLong2, t.E, t.F);
    localObject18 = ((bl)localObject18).a(1453167956L, "5.4.0.7");
    byte[] arrayOfByte = new byte[0];
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
      paramArrayOfByte1 = ((oicq.wlogin_sdk.b.j)localObject22).a(paramArrayOfByte2);
    }
    for (paramInt1 = 11;; paramInt1 = 10)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramArrayOfLong = ((bd)localObject21).a(paramList);
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((this.w.p != null) && (this.w.p.length > 0))
        {
          paramArrayOfByte2 = ((bi)localObject20).a(this.w.p);
          paramInt1 += 1;
        }
        for (;;)
        {
          if ((t.L != null) && (t.L.length > 0))
          {
            paramList = ((bz)localObject19).a(t.L);
            paramInt1 += 1;
          }
          for (;;)
          {
            if ((t.M != null) && (t.M.length > 0))
            {
              localObject1 = ((ca)localObject1).a(t.M);
              paramInt1 += 1;
            }
            for (;;)
            {
              if ((t.J != null) && (t.J.length > 0))
              {
                localObject2 = ((ce)localObject2).a(t.J);
                paramInt1 += 1;
              }
              for (;;)
              {
                if ((k.E != null) && (k.E.length > 0))
                {
                  localObject3 = ((cj)localObject3).a(k.E, k.F, "qq".getBytes(), k.G);
                  paramInt1 += 1;
                }
                for (;;)
                {
                  if ((t.P != null) && (t.P.length > 0))
                  {
                    localObject4 = ((ck)localObject4).a(t.P, t.Q);
                    paramInt1 += 1;
                  }
                  for (;;)
                  {
                    localObject16 = ((oicq.wlogin_sdk.b.k)localObject16).a(t.K);
                    localObject19 = util.get_os_type();
                    localObject20 = util.get_os_version();
                    paramInt2 = t.B;
                    localObject21 = t.A;
                    localObject22 = t.D;
                    localObject9 = localan.a((byte[])localObject16, ((ab)localObject9).a((byte[])localObject19, (byte[])localObject20, paramInt2, (byte[])localObject21, new byte[0], (byte[])localObject22), localaf.a(t.R, t.S, t.T, t.W, t.G, t.y, t.N), localbg.a(t.G), this.w.b);
                    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
                    {
                      localObject5 = ((am)localObject5).a(paramArrayOfByte3);
                      paramInt1 = paramInt1 + 1 + 1;
                      paramInt2 = 11;
                      paramArrayOfByte3 = new byte[localObject6.length + localObject7.length + localObject8.length + paramArrayOfByte1.length + localObject9.length + localObject5.length + localObject10.length + localObject12.length + localObject13.length + localObject14.length + localObject15.length + paramArrayOfLong.length + localObject17.length + paramArrayOfByte2.length + localObject18.length + paramList.length + localObject1.length + localObject2.length + localObject3.length + localObject4.length];
                      System.arraycopy(localObject6, 0, paramArrayOfByte3, 0, localObject6.length);
                      paramInt3 = 0 + localObject6.length;
                      System.arraycopy(localObject7, 0, paramArrayOfByte3, paramInt3, localObject7.length);
                      paramInt3 += localObject7.length;
                      System.arraycopy(localObject8, 0, paramArrayOfByte3, paramInt3, localObject8.length);
                      paramInt3 += localObject8.length;
                      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, paramInt3, paramArrayOfByte1.length);
                      paramInt3 += paramArrayOfByte1.length;
                      System.arraycopy(localObject9, 0, paramArrayOfByte3, paramInt3, localObject9.length);
                      paramInt3 = localObject9.length + paramInt3;
                      System.arraycopy(localObject5, 0, paramArrayOfByte3, paramInt3, localObject5.length);
                      paramInt3 += localObject5.length;
                      System.arraycopy(localObject10, 0, paramArrayOfByte3, paramInt3, localObject10.length);
                      paramInt3 += localObject10.length;
                      System.arraycopy(localObject12, 0, paramArrayOfByte3, paramInt3, localObject12.length);
                      paramInt3 += localObject12.length;
                      System.arraycopy(localObject13, 0, paramArrayOfByte3, paramInt3, localObject13.length);
                      paramInt3 += localObject13.length;
                      System.arraycopy(localObject14, 0, paramArrayOfByte3, paramInt3, localObject14.length);
                      paramInt3 += localObject14.length;
                      System.arraycopy(localObject15, 0, paramArrayOfByte3, paramInt3, localObject15.length);
                      paramInt3 += localObject15.length;
                      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte3, paramInt3, paramArrayOfLong.length);
                      paramInt3 += paramArrayOfLong.length;
                      System.arraycopy(localObject17, 0, paramArrayOfByte3, paramInt3, localObject17.length);
                      paramInt3 += localObject17.length;
                      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt3, paramArrayOfByte2.length);
                      paramInt3 += paramArrayOfByte2.length;
                      System.arraycopy(localObject18, 0, paramArrayOfByte3, paramInt3, localObject18.length);
                      paramInt3 += localObject18.length;
                      System.arraycopy(paramList, 0, paramArrayOfByte3, paramInt3, paramList.length);
                      paramInt3 += paramList.length;
                      System.arraycopy(localObject1, 0, paramArrayOfByte3, paramInt3, localObject1.length);
                      paramInt3 += localObject1.length;
                      System.arraycopy(localObject2, 0, paramArrayOfByte3, paramInt3, localObject2.length);
                      paramInt3 += localObject2.length;
                      System.arraycopy(localObject3, 0, paramArrayOfByte3, paramInt3, localObject3.length);
                      paramInt3 += localObject3.length;
                      System.arraycopy(localObject4, 0, paramArrayOfByte3, paramInt3, localObject4.length);
                      paramInt3 = localObject4.length;
                      paramArrayOfByte1 = paramArrayOfByte3;
                      return a(paramArrayOfByte1, paramInt2, paramInt1);
                    }
                    paramInt1 += 2;
                    if ((this.w.g != null) && (!util.check_uin_account(this.w.g).booleanValue()))
                    {
                      paramArrayOfByte3 = localq.a(this.w.g.getBytes());
                      paramInt1 += 1;
                    }
                    for (;;)
                    {
                      localObject5 = new byte[localObject6.length + localObject7.length + localObject8.length + paramArrayOfByte1.length + localObject9.length + arrayOfByte.length + paramArrayOfByte3.length + localObject11.length + localObject10.length + localObject12.length + localObject13.length + localObject14.length + localObject15.length + paramArrayOfLong.length + localObject17.length + paramArrayOfByte2.length + localObject18.length + paramList.length + localObject1.length + localObject2.length + localObject3.length + localObject4.length];
                      System.arraycopy(localObject6, 0, localObject5, 0, localObject6.length);
                      paramInt2 = 0 + localObject6.length;
                      System.arraycopy(localObject7, 0, localObject5, paramInt2, localObject7.length);
                      paramInt2 += localObject7.length;
                      System.arraycopy(localObject8, 0, localObject5, paramInt2, localObject8.length);
                      paramInt2 += localObject8.length;
                      System.arraycopy(paramArrayOfByte1, 0, localObject5, paramInt2, paramArrayOfByte1.length);
                      paramInt2 += paramArrayOfByte1.length;
                      System.arraycopy(localObject9, 0, localObject5, paramInt2, localObject9.length);
                      paramInt2 = localObject9.length + paramInt2;
                      System.arraycopy(arrayOfByte, 0, localObject5, paramInt2, arrayOfByte.length);
                      paramInt2 += arrayOfByte.length;
                      System.arraycopy(paramArrayOfByte3, 0, localObject5, paramInt2, paramArrayOfByte3.length);
                      paramInt2 = paramArrayOfByte3.length + paramInt2;
                      System.arraycopy(localObject11, 0, localObject5, paramInt2, localObject11.length);
                      paramInt2 += localObject11.length;
                      System.arraycopy(localObject10, 0, localObject5, paramInt2, localObject10.length);
                      paramInt2 += localObject10.length;
                      System.arraycopy(localObject12, 0, localObject5, paramInt2, localObject12.length);
                      paramInt2 += localObject12.length;
                      System.arraycopy(localObject13, 0, localObject5, paramInt2, localObject13.length);
                      paramInt2 += localObject13.length;
                      System.arraycopy(localObject14, 0, localObject5, paramInt2, localObject14.length);
                      paramInt2 += localObject14.length;
                      System.arraycopy(localObject15, 0, localObject5, paramInt2, localObject15.length);
                      paramInt2 += localObject15.length;
                      System.arraycopy(paramArrayOfLong, 0, localObject5, paramInt2, paramArrayOfLong.length);
                      paramInt2 += paramArrayOfLong.length;
                      System.arraycopy(localObject17, 0, localObject5, paramInt2, localObject17.length);
                      paramInt2 += localObject17.length;
                      System.arraycopy(paramArrayOfByte2, 0, localObject5, paramInt2, paramArrayOfByte2.length);
                      paramInt2 += paramArrayOfByte2.length;
                      System.arraycopy(localObject18, 0, localObject5, paramInt2, localObject18.length);
                      paramInt2 += localObject18.length;
                      System.arraycopy(paramList, 0, localObject5, paramInt2, paramList.length);
                      paramInt2 += paramList.length;
                      System.arraycopy(localObject1, 0, localObject5, paramInt2, localObject1.length);
                      paramInt2 += localObject1.length;
                      System.arraycopy(localObject2, 0, localObject5, paramInt2, localObject2.length);
                      paramInt2 += localObject2.length;
                      System.arraycopy(localObject3, 0, localObject5, paramInt2, localObject3.length);
                      paramInt2 += localObject3.length;
                      System.arraycopy(localObject4, 0, localObject5, paramInt2, localObject4.length);
                      paramInt2 = localObject4.length;
                      paramArrayOfByte1 = (byte[])localObject5;
                      paramInt2 = i;
                      break;
                      paramArrayOfByte3 = new byte[0];
                    }
                    localObject4 = new byte[0];
                  }
                  localObject3 = new byte[0];
                }
                localObject2 = new byte[0];
              }
              localObject1 = new byte[0];
            }
            paramList = new byte[0];
          }
          paramArrayOfByte2 = new byte[0];
        }
        paramArrayOfLong = new byte[0];
      }
      paramArrayOfByte1 = new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.m
 * JD-Core Version:    0.7.0.1
 */