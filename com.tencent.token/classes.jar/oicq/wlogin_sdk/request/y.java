package oicq.wlogin_sdk.request;

import android.content.Context;
import java.util.List;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t1;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t107;
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
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t166;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t16e;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tlv_type.tlv_t177;
import oicq.wlogin_sdk.tlv_type.tlv_t18;
import oicq.wlogin_sdk.tlv_type.tlv_t187;
import oicq.wlogin_sdk.tlv_type.tlv_t188;
import oicq.wlogin_sdk.tlv_type.tlv_t194;
import oicq.wlogin_sdk.tlv_type.tlv_t201;
import oicq.wlogin_sdk.tlv_type.tlv_t202;
import oicq.wlogin_sdk.tlv_type.tlv_t400;
import oicq.wlogin_sdk.tlv_type.tlv_t511;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class y
  extends oicq_request
{
  public y(t paramt, Context paramContext)
  {
    this.t = 2064;
    this.u = 15;
    this.v = "wtlogin.exchange_emp";
    this.x = paramt;
    this.x.m = 0;
    this.y = oicq_request.EncryptionMethod.EM_ST;
    this.a = paramContext;
  }
  
  private byte[] a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, long paramLong4, byte[] paramArrayOfByte5, List<String> paramList, int paramInt11)
  {
    Object localObject6 = new tlv_t18();
    Object localObject8 = new tlv_t1();
    Object localObject10 = new tlv_t106();
    Object localObject14 = new tlv_t116();
    Object localObject11 = new tlv_t100();
    Object localObject12 = new tlv_t107();
    Object localObject27 = new tlv_t108();
    Object localObject23 = new tlv_t109();
    Object localObject22 = new tlv_t124();
    tlv_t128 localtlv_t128 = new tlv_t128();
    Object localObject21 = new tlv_t142();
    tlv_t112 localtlv_t112 = new tlv_t112();
    tlv_t144 localtlv_t144 = new tlv_t144();
    Object localObject15 = new tlv_t145();
    Object localObject19 = new tlv_t147();
    Object localObject26 = new tlv_t166();
    tlv_t16a localtlv_t16a = new tlv_t16a();
    Object localObject17 = new tlv_t141();
    Object localObject18 = new tlv_t8();
    Object localObject16 = new tlv_t154();
    tlv_t511 localtlv_t511 = new tlv_t511();
    tlv_t16e localtlv_t16e = new tlv_t16e();
    Object localObject25 = new tlv_t172();
    Object localObject20 = new tlv_t177();
    Object localObject5 = new tlv_t400();
    Object localObject24 = new tlv_t187();
    Object localObject1 = new tlv_t188();
    Object localObject2 = new tlv_t194();
    Object localObject3 = new tlv_t201();
    Object localObject4 = new tlv_t202();
    Object localObject9 = new tlv_t(1302);
    Object localObject7 = new tlv_t(1313);
    new tlv_t(1317);
    Object localObject13 = this.x.a(paramLong2, paramLong4);
    localObject6 = ((tlv_t18)localObject6).get_tlv_18(paramLong1, paramInt1, paramLong2, paramInt2);
    localObject8 = ((tlv_t1)localObject8).get_tlv_1(paramLong2, paramArrayOfByte1);
    ((tlv_t106)localObject10).set_data(paramArrayOfByte2, paramArrayOfByte2.length);
    localObject10 = ((tlv_t106)localObject10).get_buf();
    util.LOGD("req2 a1:", util.buf_to_string((byte[])localObject10));
    localObject11 = ((tlv_t100)localObject11).get_tlv_100(paramLong1, paramLong3, paramInt1, paramInt5);
    localObject12 = ((tlv_t107)localObject12).get_tlv_107(paramInt7, paramInt8, paramInt9, paramInt10);
    localObject14 = ((tlv_t116)localObject14).get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
    localObject15 = ((tlv_t145)localObject15).get_tlv_145(t.A);
    localObject16 = ((tlv_t154)localObject16).get_tlv_154(this.x.i);
    localObject17 = ((tlv_t141)localObject17).get_tlv_141(t.C, t.D, t.F);
    localObject18 = ((tlv_t8)localObject18).get_tlv_8(0, t.u, 0);
    localObject19 = ((tlv_t147)localObject19).get_tlv_147(paramLong4, t.G, t.H);
    localObject20 = ((tlv_t177)localObject20).get_tlv_177(1502965326L, "6.0.0.2202");
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0)) {
      paramArrayOfByte1 = ((tlv_t108)localObject27).get_tlv_108(paramArrayOfByte4);
    }
    for (paramInt1 = 13;; paramInt1 = 12)
    {
      if ((paramInt3 & 0x80) != 0)
      {
        paramArrayOfByte2 = ((tlv_t166)localObject26).get_tlv_166(t.x);
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((this.x.r != null) && (this.x.r.length > 0))
        {
          paramArrayOfLong = ((tlv_t172)localObject25).get_tlv_172(this.x.r);
          paramInt1 += 1;
        }
        for (;;)
        {
          if ((t.N != null) && (t.N.length > 0))
          {
            paramArrayOfByte4 = ((tlv_t187)localObject24).get_tlv_187(t.N);
            paramInt1 += 1;
          }
          for (;;)
          {
            if ((t.O != null) && (t.O.length > 0))
            {
              localObject1 = ((tlv_t188)localObject1).get_tlv_188(t.O);
              paramInt1 += 1;
            }
            for (;;)
            {
              if ((t.L != null) && (t.L.length > 0))
              {
                localObject2 = ((tlv_t194)localObject2).get_tlv_194(t.L);
                paramInt1 += 1;
              }
              for (;;)
              {
                if ((l.J != null) && (l.J.length > 0))
                {
                  localObject3 = ((tlv_t201)localObject3).get_tlv_201(l.J, l.K, "qq".getBytes(), l.L);
                  paramInt1 += 1;
                }
                for (;;)
                {
                  if ((t.R != null) && (t.R.length > 0))
                  {
                    localObject4 = ((tlv_t202)localObject4).get_tlv_202(t.R, t.S);
                    paramInt1 += 1;
                  }
                  for (;;)
                  {
                    localObject23 = ((tlv_t109)localObject23).get_tlv_109(t.M);
                    localObject24 = util.get_os_type();
                    localObject25 = util.get_os_version();
                    paramInt2 = t.D;
                    localObject26 = t.C;
                    localObject27 = t.F;
                    localObject22 = localtlv_t144.get_tlv_144((byte[])localObject23, ((tlv_t124)localObject22).get_tlv_124((byte[])localObject24, (byte[])localObject25, paramInt2, (byte[])localObject26, new byte[0], (byte[])localObject27), localtlv_t128.get_tlv_128(t.T, t.U, t.V, t.Y, t.I, t.A, t.P), localtlv_t16e.get_tlv_16e(t.I), t.b(this.x.h)._tgtgt_key);
                    localObject21 = ((tlv_t142)localObject21).get_tlv_142(paramArrayOfByte5);
                    paramInt1 = paramInt1 + 1 + 1;
                    if ((this.x.g != null) && (!util.check_uin_account(this.x.g).booleanValue()))
                    {
                      paramArrayOfByte5 = localtlv_t112.get_tlv_112(this.x.g.getBytes());
                      paramInt1 += 1;
                    }
                    for (;;)
                    {
                      if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
                      {
                        paramArrayOfByte3 = localtlv_t16a.get_tlv_16a(paramArrayOfByte3);
                        paramInt1 += 1;
                      }
                      for (;;)
                      {
                        if ((paramList != null) && (paramList.size() > 0))
                        {
                          paramList = localtlv_t511.get_tlv_511(paramList);
                          paramInt1 += 1;
                        }
                        for (;;)
                        {
                          if ((localObject13 != null) && (((WloginSigInfo)localObject13)._G != null) && (((WloginSigInfo)localObject13)._G.length > 0) && (((WloginSigInfo)localObject13)._dpwd != null) && (((WloginSigInfo)localObject13)._dpwd.length > 0) && (((WloginSigInfo)localObject13)._randseed != null) && (((WloginSigInfo)localObject13)._randseed.length > 0))
                          {
                            localObject5 = ((tlv_t400)localObject5).get_tlv_400(((WloginSigInfo)localObject13)._G, paramLong2, t.A, ((WloginSigInfo)localObject13)._dpwd, paramLong4, 1L, ((WloginSigInfo)localObject13)._randseed);
                            paramInt1 += 1;
                          }
                          for (;;)
                          {
                            localObject13 = new byte[4];
                            util.int32_to_buf((byte[])localObject13, 0, paramInt11);
                            ((tlv_t)localObject9).set_data((byte[])localObject13, 4);
                            localObject9 = ((tlv_t)localObject9).get_buf();
                            localObject13 = new byte[6];
                            util.int32_to_buf((byte[])localObject13, 0, t.au);
                            util.int16_to_buf((byte[])localObject13, 4, 0);
                            ((tlv_t)localObject7).set_data((byte[])localObject13, 6);
                            localObject7 = ((tlv_t)localObject7).get_buf();
                            paramInt3 = localObject6.length + localObject8.length + localObject10.length + localObject14.length + localObject11.length + localObject12.length + paramArrayOfByte1.length + localObject22.length + localObject21.length + paramArrayOfByte5.length + localObject15.length + paramArrayOfByte2.length + paramArrayOfByte3.length + localObject16.length + localObject17.length + localObject18.length + paramList.length + localObject19.length + paramArrayOfLong.length + localObject20.length + localObject5.length + paramArrayOfByte4.length + localObject1.length + localObject2.length + localObject3.length + localObject4.length + localObject9.length + localObject7.length;
                            paramInt2 = paramInt3;
                            if (0 != 0) {
                              paramInt2 = paramInt3 + null.length;
                            }
                            localObject13 = new byte[paramInt2];
                            System.arraycopy(localObject6, 0, localObject13, 0, localObject6.length);
                            paramInt2 = 0 + localObject6.length;
                            System.arraycopy(localObject8, 0, localObject13, paramInt2, localObject8.length);
                            paramInt2 += localObject8.length;
                            System.arraycopy(localObject10, 0, localObject13, paramInt2, localObject10.length);
                            paramInt2 += localObject10.length;
                            System.arraycopy(localObject14, 0, localObject13, paramInt2, localObject14.length);
                            paramInt2 += localObject14.length;
                            System.arraycopy(localObject11, 0, localObject13, paramInt2, localObject11.length);
                            paramInt2 += localObject11.length;
                            System.arraycopy(localObject12, 0, localObject13, paramInt2, localObject12.length);
                            paramInt2 += localObject12.length;
                            System.arraycopy(paramArrayOfByte1, 0, localObject13, paramInt2, paramArrayOfByte1.length);
                            paramInt2 += paramArrayOfByte1.length;
                            System.arraycopy(localObject22, 0, localObject13, paramInt2, localObject22.length);
                            paramInt2 += localObject22.length;
                            System.arraycopy(localObject21, 0, localObject13, paramInt2, localObject21.length);
                            paramInt2 += localObject21.length;
                            System.arraycopy(paramArrayOfByte5, 0, localObject13, paramInt2, paramArrayOfByte5.length);
                            paramInt2 += paramArrayOfByte5.length;
                            System.arraycopy(localObject15, 0, localObject13, paramInt2, localObject15.length);
                            paramInt2 += localObject15.length;
                            System.arraycopy(paramArrayOfByte2, 0, localObject13, paramInt2, paramArrayOfByte2.length);
                            paramInt2 += paramArrayOfByte2.length;
                            System.arraycopy(paramArrayOfByte3, 0, localObject13, paramInt2, paramArrayOfByte3.length);
                            paramInt2 += paramArrayOfByte3.length;
                            System.arraycopy(localObject16, 0, localObject13, paramInt2, localObject16.length);
                            paramInt2 += localObject16.length;
                            System.arraycopy(localObject17, 0, localObject13, paramInt2, localObject17.length);
                            paramInt2 += localObject17.length;
                            System.arraycopy(localObject18, 0, localObject13, paramInt2, localObject18.length);
                            paramInt2 += localObject18.length;
                            System.arraycopy(paramList, 0, localObject13, paramInt2, paramList.length);
                            paramInt2 += paramList.length;
                            System.arraycopy(localObject19, 0, localObject13, paramInt2, localObject19.length);
                            paramInt2 += localObject19.length;
                            System.arraycopy(paramArrayOfLong, 0, localObject13, paramInt2, paramArrayOfLong.length);
                            paramInt2 += paramArrayOfLong.length;
                            System.arraycopy(localObject20, 0, localObject13, paramInt2, localObject20.length);
                            paramInt2 += localObject20.length;
                            System.arraycopy(localObject5, 0, localObject13, paramInt2, localObject5.length);
                            paramInt2 = localObject5.length + paramInt2;
                            System.arraycopy(paramArrayOfByte4, 0, localObject13, paramInt2, paramArrayOfByte4.length);
                            paramInt2 += paramArrayOfByte4.length;
                            System.arraycopy(localObject1, 0, localObject13, paramInt2, localObject1.length);
                            paramInt2 += localObject1.length;
                            System.arraycopy(localObject2, 0, localObject13, paramInt2, localObject2.length);
                            paramInt2 += localObject2.length;
                            System.arraycopy(localObject3, 0, localObject13, paramInt2, localObject3.length);
                            paramInt2 += localObject3.length;
                            System.arraycopy(localObject4, 0, localObject13, paramInt2, localObject4.length);
                            paramInt2 += localObject4.length;
                            System.arraycopy(localObject9, 0, localObject13, paramInt2, localObject9.length);
                            paramInt2 += localObject9.length;
                            System.arraycopy(localObject7, 0, localObject13, paramInt2, localObject7.length);
                            paramInt2 += localObject7.length;
                            if (0 != 0)
                            {
                              System.arraycopy(null, 0, localObject13, paramInt2, null.length);
                              paramInt2 = null.length;
                            }
                            return a(a((byte[])localObject13, this.u, paramInt1 + 1 + 1), this.y, this.A, this.B);
                            util.LOGI("request_tgtgt_nopicsig req without DA1", "" + paramLong2);
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
  
  public int a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, long paramLong4, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("start request_tgtgt_nopicsig", "" + paramLong2);
    int i = t.w;
    paramArrayOfByte2 = c(paramArrayOfByte2);
    if (paramArrayOfByte2 == null) {
      return -1014;
    }
    paramInt1 = 0;
    for (;;)
    {
      if ((this.y == oicq_request.EncryptionMethod.EM_ST) && ((this.B == null) || (this.B.length == 0) || (this.A == null) || (this.A.length == 0)))
      {
        this.y = oicq_request.EncryptionMethod.EM_ECDH;
        t.an.attr_api(2413503);
        util.LOGI("using wt st encrypt body but no st key", "" + paramLong2);
      }
      a(paramLong2, a(paramLong1, i, paramLong2, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong3, i, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfByte4, paramLong4, t.E, paramWUserSigInfo._domains, paramWUserSigInfo._source_type), this.y);
      paramInt6 = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (paramInt6 != 0) {
        paramInt1 = paramInt6;
      }
      for (;;)
      {
        util.LOGI("end request_tgtgt_nopicsig ret " + paramInt1, "" + paramLong2);
        return paramInt1;
        paramInt6 = b();
        util.LOGI("retry num:" + paramInt1 + " ret:" + paramInt6, "" + paramLong2);
        if (paramInt6 != 180)
        {
          paramInt1 = paramInt6;
        }
        else
        {
          if (paramInt1 < 1) {
            break;
          }
          paramInt1 = paramInt6;
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.y
 * JD-Core Version:    0.7.0.1
 */