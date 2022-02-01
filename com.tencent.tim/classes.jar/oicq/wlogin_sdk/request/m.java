package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t112;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t124;
import oicq.wlogin_sdk.tlv_type.tlv_t128;
import oicq.wlogin_sdk.tlv_type.tlv_t141;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t144;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t147;
import oicq.wlogin_sdk.tlv_type.tlv_t148;
import oicq.wlogin_sdk.tlv_type.tlv_t153;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t16e;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tlv_type.tlv_t177;
import oicq.wlogin_sdk.tlv_type.tlv_t18;
import oicq.wlogin_sdk.tlv_type.tlv_t187;
import oicq.wlogin_sdk.tlv_type.tlv_t188;
import oicq.wlogin_sdk.tlv_type.tlv_t194;
import oicq.wlogin_sdk.tlv_type.tlv_t202;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class m
  extends oicq_request
{
  public m(u paramu)
  {
    this.t = 2064;
    this.u = 13;
    this.v = "wtlogin.login";
    this.x = paramu;
    this.x.m = 0;
    this.a = this.x.h();
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte3, long paramLong4, long paramLong5, long paramLong6, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, WUserSigInfo paramWUserSigInfo)
  {
    int k = u.x;
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
      byte[] arrayOfByte = a(paramLong1, paramLong2, paramLong3, k, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt3, paramInt4, paramArrayOfLong, u.ad, paramArrayOfByte3, paramLong4, paramLong5, paramLong6, paramArrayOfByte4, paramArrayOfByte5);
      a(this.i, this.t, this.j, paramLong1, this.m, this.n, k, this.p, arrayOfByte);
      int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
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
    Object localObject5 = new tlv_t106();
    tlv_t144 localtlv_t144 = new tlv_t144();
    Object localObject6 = new tlv_t100();
    Object localObject23 = new tlv_t108();
    Object localObject7 = new tlv_t116();
    Object localObject22 = new tlv_t112();
    Object localObject8 = new tlv_t142();
    Object localObject10 = new tlv_t145();
    Object localObject21 = new tlv_t16a();
    Object localObject11 = new tlv_t18();
    Object localObject12 = new tlv_t141();
    Object localObject14 = new tlv_t8();
    Object localObject19 = new tlv_t109();
    Object localObject18 = new tlv_t52d();
    Object localObject15 = new tlv_t124();
    Object localObject13 = new tlv_t128();
    Object localObject16 = new tlv_t147();
    tlv_t148 localtlv_t148 = new tlv_t148();
    tlv_t153 localtlv_t153 = new tlv_t153();
    Object localObject9 = new tlv_t16e();
    Object localObject20 = new tlv_t172();
    Object localObject17 = new tlv_t177();
    Object localObject1 = new tlv_t187();
    Object localObject2 = new tlv_t188();
    Object localObject3 = new tlv_t194();
    Object localObject4 = new tlv_t202();
    tlv_t544 localtlv_t544 = new tlv_t544();
    ((tlv_t106)localObject5).set_data(paramArrayOfByte1, paramArrayOfByte1.length);
    localObject5 = ((tlv_t106)localObject5).get_buf();
    localObject6 = ((tlv_t100)localObject6).get_tlv_100(paramLong5, paramLong6, paramInt1, paramInt2);
    localObject7 = ((tlv_t116)localObject7).get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
    localObject8 = ((tlv_t142)localObject8).get_tlv_142(u.F);
    localObject10 = ((tlv_t145)localObject10).get_tlv_145(u.B);
    localObject11 = ((tlv_t18)localObject11).get_tlv_18(paramLong2, paramInt1, paramLong1, 0);
    localObject12 = ((tlv_t141)localObject12).get_tlv_141(u.D, u.E, u.G);
    localObject14 = ((tlv_t8)localObject14).get_tlv_8(0, u.v, 0);
    localObject16 = ((tlv_t147)localObject16).get_tlv_147(paramLong2, u.H, u.I);
    localObject17 = ((tlv_t177)localObject17).get_tlv_177(1630062176L, "6.0.0.2484");
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0)) {
      paramArrayOfByte1 = ((tlv_t108)localObject23).get_tlv_108(paramArrayOfByte3);
    }
    for (paramInt1 = 11;; paramInt1 = 10)
    {
      if ((this.x.g != null) && (!util.check_uin_account(this.x.g).booleanValue()))
      {
        paramArrayOfLong = ((tlv_t112)localObject22).get_tlv_112(this.x.g.getBytes());
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0))
        {
          paramArrayOfByte2 = ((tlv_t16a)localObject21).get_tlv_16a(paramArrayOfByte2);
          paramInt1 += 1;
        }
        for (;;)
        {
          if ((this.x.s != null) && (this.x.s.length > 0))
          {
            paramArrayOfByte3 = ((tlv_t172)localObject20).get_tlv_172(this.x.s);
            paramInt1 += 1;
          }
          for (;;)
          {
            if ((u.O != null) && (u.O.length > 0))
            {
              localObject1 = ((tlv_t187)localObject1).get_tlv_187(u.O);
              paramInt1 += 1;
            }
            for (;;)
            {
              if ((u.P != null) && (u.P.length > 0))
              {
                localObject2 = ((tlv_t188)localObject2).get_tlv_188(u.P);
                paramInt1 += 1;
              }
              for (;;)
              {
                if ((u.M != null) && (u.M.length > 0))
                {
                  localObject3 = ((tlv_t194)localObject3).get_tlv_194(u.M);
                  paramInt1 += 1;
                }
                for (;;)
                {
                  if ((u.S != null) && (u.S.length > 0))
                  {
                    localObject4 = ((tlv_t202)localObject4).get_tlv_202(u.S, u.T);
                    paramInt1 += 1;
                  }
                  for (;;)
                  {
                    localObject19 = ((tlv_t109)localObject19).get_tlv_109(u.P);
                    localObject18 = ((tlv_t52d)localObject18).get_tlv_52d(this.a);
                    localObject20 = util.get_os_type();
                    localObject21 = util.get_os_version();
                    paramInt2 = u.E;
                    localObject22 = u.D;
                    localObject23 = u.G;
                    localObject15 = ((tlv_t124)localObject15).get_tlv_124((byte[])localObject20, (byte[])localObject21, paramInt2, (byte[])localObject22, new byte[0], (byte[])localObject23);
                    localObject13 = ((tlv_t128)localObject13).get_tlv_128(u.V, u.W, u.X, 0, u.J, u.B, u.Q);
                    paramArrayOfByte4 = localtlv_t148.get_tlv_148(paramArrayOfByte4, paramLong4, paramLong5, paramLong6, paramArrayOfByte5, paramArrayOfByte6);
                    paramArrayOfByte5 = localtlv_t153.get_tlv_153(u.ab);
                    paramArrayOfByte6 = ((tlv_t16e)localObject9).get_tlv_16e(u.J);
                    localObject9 = u.b(this.x.h)._tgtgt_key;
                    paramArrayOfByte4 = localtlv_t144.get_tlv_144((byte[])localObject19, (byte[])localObject18, (byte[])localObject15, (byte[])localObject13, paramArrayOfByte4, new byte[0], paramArrayOfByte5, paramArrayOfByte6, (byte[])localObject9);
                    paramInt3 = paramInt1 + 1;
                    paramArrayOfByte5 = "6.0.0.2484".getBytes();
                    paramArrayOfByte6 = new byte[u.B.length + 10 + 2 + paramArrayOfByte5.length + 4];
                    util.int64_to_buf(paramArrayOfByte6, 0, (int)paramLong1);
                    util.int16_to_buf(paramArrayOfByte6, 4, u.B.length);
                    System.arraycopy(u.B, 0, paramArrayOfByte6, 6, u.B.length);
                    paramInt1 = u.B.length + 6;
                    util.int16_to_buf(paramArrayOfByte6, paramInt1, paramArrayOfByte5.length);
                    paramInt1 += 2;
                    System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte6, paramInt1, paramArrayOfByte5.length);
                    util.int32_to_buf(paramArrayOfByte6, paramInt1 + paramArrayOfByte5.length, this.u);
                    paramArrayOfByte5 = localtlv_t544.get_tlv_544(String.valueOf(paramLong1), "810_d", paramArrayOfByte6);
                    paramInt4 = localObject5.length + localObject6.length + paramArrayOfByte1.length + localObject7.length + paramArrayOfLong.length + localObject8.length + localObject10.length + paramArrayOfByte4.length + paramArrayOfByte2.length + localObject11.length + localObject12.length + localObject14.length + localObject16.length + paramArrayOfByte3.length + localObject17.length + localObject1.length + localObject2.length + localObject3.length + localObject4.length;
                    paramInt2 = paramInt4;
                    paramInt1 = paramInt3;
                    if (paramArrayOfByte5 != null)
                    {
                      paramInt2 = paramInt4 + paramArrayOfByte5.length;
                      paramInt1 = paramInt3 + 1;
                    }
                    paramArrayOfByte6 = new byte[paramInt2];
                    System.arraycopy(localObject5, 0, paramArrayOfByte6, 0, localObject5.length);
                    paramInt2 = 0 + localObject5.length;
                    System.arraycopy(localObject6, 0, paramArrayOfByte6, paramInt2, localObject6.length);
                    paramInt2 += localObject6.length;
                    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte6, paramInt2, paramArrayOfByte1.length);
                    paramInt2 += paramArrayOfByte1.length;
                    System.arraycopy(localObject7, 0, paramArrayOfByte6, paramInt2, localObject7.length);
                    paramInt2 += localObject7.length;
                    System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte6, paramInt2, paramArrayOfLong.length);
                    paramInt2 += paramArrayOfLong.length;
                    System.arraycopy(localObject8, 0, paramArrayOfByte6, paramInt2, localObject8.length);
                    paramInt2 += localObject8.length;
                    System.arraycopy(localObject10, 0, paramArrayOfByte6, paramInt2, localObject10.length);
                    paramInt2 += localObject10.length;
                    System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte6, paramInt2, paramArrayOfByte4.length);
                    paramInt2 = paramArrayOfByte4.length + paramInt2;
                    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte6, paramInt2, paramArrayOfByte2.length);
                    paramInt2 += paramArrayOfByte2.length;
                    System.arraycopy(localObject11, 0, paramArrayOfByte6, paramInt2, localObject11.length);
                    paramInt2 += localObject11.length;
                    System.arraycopy(localObject12, 0, paramArrayOfByte6, paramInt2, localObject12.length);
                    paramInt2 += localObject12.length;
                    System.arraycopy(localObject14, 0, paramArrayOfByte6, paramInt2, localObject14.length);
                    paramInt2 += localObject14.length;
                    System.arraycopy(localObject16, 0, paramArrayOfByte6, paramInt2, localObject16.length);
                    paramInt2 += localObject16.length;
                    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte6, paramInt2, paramArrayOfByte3.length);
                    paramInt2 += paramArrayOfByte3.length;
                    System.arraycopy(localObject17, 0, paramArrayOfByte6, paramInt2, localObject17.length);
                    paramInt2 += localObject17.length;
                    System.arraycopy(localObject1, 0, paramArrayOfByte6, paramInt2, localObject1.length);
                    paramInt2 += localObject1.length;
                    System.arraycopy(localObject2, 0, paramArrayOfByte6, paramInt2, localObject2.length);
                    paramInt2 += localObject2.length;
                    System.arraycopy(localObject3, 0, paramArrayOfByte6, paramInt2, localObject3.length);
                    paramInt2 += localObject3.length;
                    System.arraycopy(localObject4, 0, paramArrayOfByte6, paramInt2, localObject4.length);
                    paramInt2 += localObject4.length;
                    if (paramArrayOfByte5 != null)
                    {
                      System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte6, paramInt2, paramArrayOfByte5.length);
                      paramInt2 = paramArrayOfByte5.length;
                    }
                    return b(paramArrayOfByte6, this.u, paramInt1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.m
 * JD-Core Version:    0.7.0.1
 */