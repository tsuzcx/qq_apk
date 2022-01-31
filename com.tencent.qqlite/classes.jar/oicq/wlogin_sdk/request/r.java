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
import oicq.wlogin_sdk.b.cl;
import oicq.wlogin_sdk.b.j;
import oicq.wlogin_sdk.b.k;
import oicq.wlogin_sdk.b.l;
import oicq.wlogin_sdk.b.q;
import oicq.wlogin_sdk.b.t;
import oicq.wlogin_sdk.tools.util;

public class r
  extends o
{
  public r(y paramy)
  {
    this.s = 2064;
    this.t = 10;
    this.u = "wtlogin.exchange_emp";
    this.w = paramy;
    this.w.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte2, WUserSigInfo paramWUserSigInfo)
  {
    int i = y.u;
    paramInt1 = 0;
    for (;;)
    {
      a(this.h, this.s, this.i, paramLong1, this.l, this.m, i, this.o, a(paramLong1, paramLong2, paramLong3, i, paramInt2, paramArrayOfByte1, paramInt3, paramInt4, paramArrayOfLong, y.W, paramArrayOfByte2, paramWUserSigInfo._domains));
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
    Object localObject4 = new c();
    Object localObject5 = new l();
    Object localObject6 = new t();
    Object localObject20 = new j();
    Object localObject14 = new k();
    Object localObject7 = new ab();
    af localaf = new af();
    Object localObject3 = new am();
    q localq = new q();
    an localan = new an();
    Object localObject9 = new ao();
    Object localObject15 = new aq();
    Object localObject8 = new al();
    Object localObject10 = new av();
    Object localObject11 = new bt();
    Object localObject12 = new ak();
    Object localObject13 = new cl();
    Object localObject19 = new bd();
    bg localbg = new bg();
    Object localObject18 = new bi();
    Object localObject16 = new bl();
    Object localObject17 = new bz();
    Object localObject1 = new ca();
    Object localObject2 = new ce();
    localObject4 = ((c)localObject4).a(paramLong2, paramLong3, paramInt1, paramInt2);
    localObject5 = ((l)localObject5).a(paramArrayOfByte1);
    localObject6 = ((t)localObject6).a(paramInt3, paramInt4, paramArrayOfLong);
    localObject9 = ((ao)localObject9).a(y.y);
    localObject8 = ((al)localObject8).a(y.C);
    localObject10 = ((av)localObject10).b(this.w.i);
    localObject11 = ((bt)localObject11).a(paramLong2, paramInt1, paramLong1, 0);
    localObject12 = ((ak)localObject12).b(y.A, y.B, y.D);
    localObject13 = ((cl)localObject13).a(0, y.s, 0);
    localObject15 = ((aq)localObject15).a(paramLong2, y.E, y.F);
    localObject16 = ((bl)localObject16).a(1414386621L, "5.2.3.1");
    byte[] arrayOfByte = new byte[0];
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
      paramArrayOfByte1 = ((j)localObject20).a(paramArrayOfByte2);
    }
    for (paramInt1 = 11;; paramInt1 = 10)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramArrayOfLong = ((bd)localObject19).a(paramList);
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((this.w.p != null) && (this.w.p.length > 0))
        {
          paramArrayOfByte2 = ((bi)localObject18).a(this.w.p);
          paramInt1 += 1;
        }
        for (;;)
        {
          if ((y.L != null) && (y.L.length > 0))
          {
            paramList = ((bz)localObject17).a(y.L);
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
                localObject14 = ((k)localObject14).a(y.K);
                localObject17 = util.get_os_type();
                localObject18 = util.get_os_version();
                paramInt2 = y.B;
                localObject19 = y.A;
                localObject20 = y.D;
                localObject7 = localan.a((byte[])localObject14, ((ab)localObject7).a((byte[])localObject17, (byte[])localObject18, paramInt2, (byte[])localObject19, new byte[0], (byte[])localObject20), localaf.a(y.P, y.Q, y.R, y.U, y.G, y.y, y.N), localbg.a(y.G), this.w.b);
                if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
                {
                  localObject3 = ((am)localObject3).a(paramArrayOfByte3);
                  paramInt1 = paramInt1 + 1 + 1;
                  paramInt2 = 11;
                  paramArrayOfByte3 = new byte[localObject4.length + localObject5.length + localObject6.length + paramArrayOfByte1.length + localObject7.length + localObject3.length + localObject8.length + localObject10.length + localObject11.length + localObject12.length + localObject13.length + paramArrayOfLong.length + localObject15.length + paramArrayOfByte2.length + localObject16.length + paramList.length + localObject1.length + localObject2.length];
                  System.arraycopy(localObject4, 0, paramArrayOfByte3, 0, localObject4.length);
                  paramInt3 = 0 + localObject4.length;
                  System.arraycopy(localObject5, 0, paramArrayOfByte3, paramInt3, localObject5.length);
                  paramInt3 += localObject5.length;
                  System.arraycopy(localObject6, 0, paramArrayOfByte3, paramInt3, localObject6.length);
                  paramInt3 += localObject6.length;
                  System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, paramInt3, paramArrayOfByte1.length);
                  paramInt3 += paramArrayOfByte1.length;
                  System.arraycopy(localObject7, 0, paramArrayOfByte3, paramInt3, localObject7.length);
                  paramInt3 = localObject7.length + paramInt3;
                  System.arraycopy(localObject3, 0, paramArrayOfByte3, paramInt3, localObject3.length);
                  paramInt3 += localObject3.length;
                  System.arraycopy(localObject8, 0, paramArrayOfByte3, paramInt3, localObject8.length);
                  paramInt3 += localObject8.length;
                  System.arraycopy(localObject10, 0, paramArrayOfByte3, paramInt3, localObject10.length);
                  paramInt3 += localObject10.length;
                  System.arraycopy(localObject11, 0, paramArrayOfByte3, paramInt3, localObject11.length);
                  paramInt3 += localObject11.length;
                  System.arraycopy(localObject12, 0, paramArrayOfByte3, paramInt3, localObject12.length);
                  paramInt3 += localObject12.length;
                  System.arraycopy(localObject13, 0, paramArrayOfByte3, paramInt3, localObject13.length);
                  paramInt3 += localObject13.length;
                  System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte3, paramInt3, paramArrayOfLong.length);
                  paramInt3 += paramArrayOfLong.length;
                  System.arraycopy(localObject15, 0, paramArrayOfByte3, paramInt3, localObject15.length);
                  paramInt3 += localObject15.length;
                  System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt3, paramArrayOfByte2.length);
                  paramInt3 += paramArrayOfByte2.length;
                  System.arraycopy(localObject16, 0, paramArrayOfByte3, paramInt3, localObject16.length);
                  paramInt3 += localObject16.length;
                  System.arraycopy(paramList, 0, paramArrayOfByte3, paramInt3, paramList.length);
                  paramInt3 += paramList.length;
                  System.arraycopy(localObject1, 0, paramArrayOfByte3, paramInt3, localObject1.length);
                  paramInt3 += localObject1.length;
                  System.arraycopy(localObject2, 0, paramArrayOfByte3, paramInt3, localObject2.length);
                  paramInt3 = localObject2.length;
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
                  localObject3 = new byte[localObject4.length + localObject5.length + localObject6.length + paramArrayOfByte1.length + localObject7.length + arrayOfByte.length + paramArrayOfByte3.length + localObject9.length + localObject8.length + localObject10.length + localObject11.length + localObject12.length + localObject13.length + paramArrayOfLong.length + localObject15.length + paramArrayOfByte2.length + localObject16.length + paramList.length + localObject1.length + localObject2.length];
                  System.arraycopy(localObject4, 0, localObject3, 0, localObject4.length);
                  paramInt2 = 0 + localObject4.length;
                  System.arraycopy(localObject5, 0, localObject3, paramInt2, localObject5.length);
                  paramInt2 += localObject5.length;
                  System.arraycopy(localObject6, 0, localObject3, paramInt2, localObject6.length);
                  paramInt2 += localObject6.length;
                  System.arraycopy(paramArrayOfByte1, 0, localObject3, paramInt2, paramArrayOfByte1.length);
                  paramInt2 += paramArrayOfByte1.length;
                  System.arraycopy(localObject7, 0, localObject3, paramInt2, localObject7.length);
                  paramInt2 = localObject7.length + paramInt2;
                  System.arraycopy(arrayOfByte, 0, localObject3, paramInt2, arrayOfByte.length);
                  paramInt2 += arrayOfByte.length;
                  System.arraycopy(paramArrayOfByte3, 0, localObject3, paramInt2, paramArrayOfByte3.length);
                  paramInt2 = paramArrayOfByte3.length + paramInt2;
                  System.arraycopy(localObject9, 0, localObject3, paramInt2, localObject9.length);
                  paramInt2 += localObject9.length;
                  System.arraycopy(localObject8, 0, localObject3, paramInt2, localObject8.length);
                  paramInt2 += localObject8.length;
                  System.arraycopy(localObject10, 0, localObject3, paramInt2, localObject10.length);
                  paramInt2 += localObject10.length;
                  System.arraycopy(localObject11, 0, localObject3, paramInt2, localObject11.length);
                  paramInt2 += localObject11.length;
                  System.arraycopy(localObject12, 0, localObject3, paramInt2, localObject12.length);
                  paramInt2 += localObject12.length;
                  System.arraycopy(localObject13, 0, localObject3, paramInt2, localObject13.length);
                  paramInt2 += localObject13.length;
                  System.arraycopy(paramArrayOfLong, 0, localObject3, paramInt2, paramArrayOfLong.length);
                  paramInt2 += paramArrayOfLong.length;
                  System.arraycopy(localObject15, 0, localObject3, paramInt2, localObject15.length);
                  paramInt2 += localObject15.length;
                  System.arraycopy(paramArrayOfByte2, 0, localObject3, paramInt2, paramArrayOfByte2.length);
                  paramInt2 += paramArrayOfByte2.length;
                  System.arraycopy(localObject16, 0, localObject3, paramInt2, localObject16.length);
                  paramInt2 += localObject16.length;
                  System.arraycopy(paramList, 0, localObject3, paramInt2, paramList.length);
                  paramInt2 += paramList.length;
                  System.arraycopy(localObject1, 0, localObject3, paramInt2, localObject1.length);
                  paramInt2 += localObject1.length;
                  System.arraycopy(localObject2, 0, localObject3, paramInt2, localObject2.length);
                  paramInt2 = localObject2.length;
                  paramArrayOfByte1 = (byte[])localObject3;
                  paramInt2 = i;
                  break;
                  paramArrayOfByte3 = new byte[0];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.r
 * JD-Core Version:    0.7.0.1
 */