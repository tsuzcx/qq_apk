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
    Object localObject13 = new tlv_t18();
    Object localObject15 = new tlv_t1();
    Object localObject16 = new tlv_t106();
    Object localObject19 = new tlv_t116();
    Object localObject17 = new tlv_t100();
    Object localObject18 = new tlv_t107();
    tlv_t108 localtlv_t108 = new tlv_t108();
    Object localObject21 = new tlv_t109();
    tlv_t124 localtlv_t124 = new tlv_t124();
    tlv_t128 localtlv_t128 = new tlv_t128();
    Object localObject20 = new tlv_t142();
    tlv_t112 localtlv_t112 = new tlv_t112();
    tlv_t144 localtlv_t144 = new tlv_t144();
    Object localObject12 = new tlv_t145();
    Object localObject6 = new tlv_t147();
    Object localObject1 = new tlv_t166();
    tlv_t16a localtlv_t16a = new tlv_t16a();
    Object localObject9 = new tlv_t141();
    Object localObject10 = new tlv_t8();
    Object localObject8 = new tlv_t154();
    tlv_t511 localtlv_t511 = new tlv_t511();
    tlv_t16e localtlv_t16e = new tlv_t16e();
    Object localObject23 = new tlv_t172();
    Object localObject3 = new tlv_t177();
    tlv_t400 localtlv_t400 = new tlv_t400();
    Object localObject4 = new tlv_t187();
    Object localObject5 = new tlv_t188();
    Object localObject7 = new tlv_t194();
    Object localObject11 = new tlv_t201();
    Object localObject22 = new tlv_t202();
    tlv_t localtlv_t = new tlv_t(1302);
    Object localObject14 = new tlv_t(1313);
    new tlv_t(1317);
    Object localObject2 = this.x.a(paramLong2, paramLong4);
    localObject13 = ((tlv_t18)localObject13).get_tlv_18(paramLong1, paramInt1, paramLong2, paramInt2);
    localObject15 = ((tlv_t1)localObject15).get_tlv_1(paramLong2, paramArrayOfByte1);
    ((tlv_t106)localObject16).set_data(paramArrayOfByte2, paramArrayOfByte2.length);
    localObject16 = ((tlv_t106)localObject16).get_buf();
    util.LOGD("req2 a1:", util.buf_to_string((byte[])localObject16));
    localObject17 = ((tlv_t100)localObject17).get_tlv_100(paramLong1, paramLong3, paramInt1, paramInt5);
    localObject18 = ((tlv_t107)localObject18).get_tlv_107(paramInt7, paramInt8, paramInt9, paramInt10);
    localObject19 = ((tlv_t116)localObject19).get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
    byte[] arrayOfByte1 = ((tlv_t145)localObject12).get_tlv_145(t.A);
    localObject8 = ((tlv_t154)localObject8).get_tlv_154(this.x.i);
    localObject9 = ((tlv_t141)localObject9).get_tlv_141(t.C, t.D, t.F);
    byte[] arrayOfByte2 = ((tlv_t8)localObject10).get_tlv_8(0, t.u, 0);
    localObject10 = ((tlv_t147)localObject6).get_tlv_147(paramLong4, t.G, t.H);
    localObject3 = ((tlv_t177)localObject3).get_tlv_177(1502965326L, "6.0.0.2202");
    localObject6 = new byte[0];
    localObject12 = new byte[0];
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0))
    {
      paramArrayOfByte4 = localtlv_t108.get_tlv_108(paramArrayOfByte4);
      paramInt1 = 13;
    }
    else
    {
      paramInt1 = 12;
      paramArrayOfByte4 = new byte[0];
    }
    if ((paramInt3 & 0x80) != 0)
    {
      localObject1 = ((tlv_t166)localObject1).get_tlv_166(t.x);
      paramInt1 += 1;
    }
    else
    {
      localObject1 = new byte[0];
    }
    if ((this.x.r != null) && (this.x.r.length > 0))
    {
      paramArrayOfByte1 = ((tlv_t172)localObject23).get_tlv_172(this.x.r);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte1 = new byte[0];
    }
    if ((t.N != null) && (t.N.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t187)localObject4).get_tlv_187(t.N);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte2 = new byte[0];
    }
    localObject4 = paramArrayOfByte1;
    if ((t.O != null) && (t.O.length > 0))
    {
      paramArrayOfLong = ((tlv_t188)localObject5).get_tlv_188(t.O);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfLong = new byte[0];
    }
    localObject5 = paramArrayOfByte2;
    if ((t.L != null) && (t.L.length > 0))
    {
      paramArrayOfByte1 = ((tlv_t194)localObject7).get_tlv_194(t.L);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte1 = new byte[0];
    }
    localObject7 = paramArrayOfLong;
    if ((l.J != null) && (l.J.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t201)localObject11).get_tlv_201(l.J, l.K, "qq".getBytes(), l.L);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte2 = new byte[0];
    }
    localObject11 = paramArrayOfByte1;
    if ((t.R != null) && (t.R.length > 0))
    {
      paramArrayOfLong = ((tlv_t202)localObject22).get_tlv_202(t.R, t.S);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfLong = (long[])localObject12;
    }
    paramArrayOfByte1 = ((tlv_t109)localObject21).get_tlv_109(t.M);
    localObject12 = util.get_os_type();
    localObject21 = util.get_os_version();
    paramInt2 = t.D;
    localObject22 = t.C;
    localObject23 = t.F;
    localObject12 = localtlv_t144.get_tlv_144(paramArrayOfByte1, localtlv_t124.get_tlv_124((byte[])localObject12, (byte[])localObject21, paramInt2, (byte[])localObject22, new byte[0], (byte[])localObject23), localtlv_t128.get_tlv_128(t.T, t.U, t.V, t.Y, t.I, t.A, t.P), localtlv_t16e.get_tlv_16e(t.I), t.b(this.x.h)._tgtgt_key);
    localObject20 = ((tlv_t142)localObject20).get_tlv_142(paramArrayOfByte5);
    paramInt1 = paramInt1 + 1 + 1;
    if ((this.x.g != null) && (!util.check_uin_account(this.x.g).booleanValue()))
    {
      paramArrayOfByte5 = localtlv_t112.get_tlv_112(this.x.g.getBytes());
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte5 = (byte[])localObject6;
    }
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
    {
      paramArrayOfByte3 = localtlv_t16a.get_tlv_16a(paramArrayOfByte3);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte3 = new byte[0];
    }
    paramArrayOfByte1 = paramList;
    if ((paramArrayOfByte1 != null) && (paramList.size() > 0))
    {
      paramArrayOfByte1 = localtlv_t511.get_tlv_511(paramArrayOfByte1);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte1 = new byte[0];
    }
    if ((localObject2 != null) && (((WloginSigInfo)localObject2)._G != null) && (((WloginSigInfo)localObject2)._G.length > 0) && (((WloginSigInfo)localObject2)._dpwd != null) && (((WloginSigInfo)localObject2)._dpwd.length > 0) && (((WloginSigInfo)localObject2)._randseed != null) && (((WloginSigInfo)localObject2)._randseed.length > 0))
    {
      paramList = localtlv_t400.get_tlv_400(((WloginSigInfo)localObject2)._G, paramLong2, t.A, ((WloginSigInfo)localObject2)._dpwd, paramLong4, 1L, ((WloginSigInfo)localObject2)._randseed);
      paramInt1 += 1;
    }
    else
    {
      util.LOGI("request_tgtgt_nopicsig req without DA1", String.valueOf(paramLong2));
      paramList = new byte[0];
    }
    localObject2 = new byte[4];
    util.int32_to_buf((byte[])localObject2, 0, paramInt11);
    localtlv_t.set_data((byte[])localObject2, 4);
    localObject2 = localtlv_t.get_buf();
    localObject6 = new byte[6];
    util.int32_to_buf((byte[])localObject6, 0, t.au);
    util.int16_to_buf((byte[])localObject6, 4, 0);
    ((tlv_t)localObject14).set_data((byte[])localObject6, 6);
    localObject6 = ((tlv_t)localObject14).get_buf();
    localObject14 = new byte[localObject13.length + localObject15.length + localObject16.length + localObject19.length + localObject17.length + localObject18.length + paramArrayOfByte4.length + localObject12.length + localObject20.length + paramArrayOfByte5.length + arrayOfByte1.length + localObject1.length + paramArrayOfByte3.length + localObject8.length + localObject9.length + arrayOfByte2.length + paramArrayOfByte1.length + localObject10.length + localObject4.length + localObject3.length + paramList.length + localObject5.length + localObject7.length + localObject11.length + paramArrayOfByte2.length + paramArrayOfLong.length + localObject2.length + localObject6.length];
    System.arraycopy(localObject13, 0, localObject14, 0, localObject13.length);
    paramInt2 = localObject13.length + 0;
    System.arraycopy(localObject15, 0, localObject14, paramInt2, localObject15.length);
    paramInt2 += localObject15.length;
    System.arraycopy(localObject16, 0, localObject14, paramInt2, localObject16.length);
    paramInt2 += localObject16.length;
    System.arraycopy(localObject19, 0, localObject14, paramInt2, localObject19.length);
    paramInt2 += localObject19.length;
    System.arraycopy(localObject17, 0, localObject14, paramInt2, localObject17.length);
    paramInt2 += localObject17.length;
    System.arraycopy(localObject18, 0, localObject14, paramInt2, localObject18.length);
    paramInt2 += localObject18.length;
    System.arraycopy(paramArrayOfByte4, 0, localObject14, paramInt2, paramArrayOfByte4.length);
    paramInt2 += paramArrayOfByte4.length;
    System.arraycopy(localObject12, 0, localObject14, paramInt2, localObject12.length);
    paramInt2 += localObject12.length;
    System.arraycopy(localObject20, 0, localObject14, paramInt2, localObject20.length);
    paramInt2 += localObject20.length;
    System.arraycopy(paramArrayOfByte5, 0, localObject14, paramInt2, paramArrayOfByte5.length);
    paramInt2 += paramArrayOfByte5.length;
    System.arraycopy(arrayOfByte1, 0, localObject14, paramInt2, arrayOfByte1.length);
    paramInt2 += arrayOfByte1.length;
    System.arraycopy(localObject1, 0, localObject14, paramInt2, localObject1.length);
    paramInt2 += localObject1.length;
    System.arraycopy(paramArrayOfByte3, 0, localObject14, paramInt2, paramArrayOfByte3.length);
    paramInt2 += paramArrayOfByte3.length;
    System.arraycopy(localObject8, 0, localObject14, paramInt2, localObject8.length);
    paramInt2 += localObject8.length;
    System.arraycopy(localObject9, 0, localObject14, paramInt2, localObject9.length);
    paramInt2 += localObject9.length;
    System.arraycopy(arrayOfByte2, 0, localObject14, paramInt2, arrayOfByte2.length);
    paramInt2 += arrayOfByte2.length;
    System.arraycopy(paramArrayOfByte1, 0, localObject14, paramInt2, paramArrayOfByte1.length);
    paramInt2 += paramArrayOfByte1.length;
    System.arraycopy(localObject10, 0, localObject14, paramInt2, localObject10.length);
    paramInt2 += localObject10.length;
    System.arraycopy(localObject4, 0, localObject14, paramInt2, localObject4.length);
    paramInt2 += localObject4.length;
    System.arraycopy(localObject3, 0, localObject14, paramInt2, localObject3.length);
    paramInt2 += localObject3.length;
    System.arraycopy(paramList, 0, localObject14, paramInt2, paramList.length);
    paramInt2 += paramList.length;
    System.arraycopy(localObject5, 0, localObject14, paramInt2, localObject5.length);
    paramInt2 += localObject5.length;
    System.arraycopy(localObject7, 0, localObject14, paramInt2, localObject7.length);
    paramInt2 += localObject7.length;
    System.arraycopy(localObject11, 0, localObject14, paramInt2, localObject11.length);
    paramInt2 += localObject11.length;
    System.arraycopy(paramArrayOfByte2, 0, localObject14, paramInt2, paramArrayOfByte2.length);
    paramInt2 += paramArrayOfByte2.length;
    System.arraycopy(paramArrayOfLong, 0, localObject14, paramInt2, paramArrayOfLong.length);
    paramInt2 += paramArrayOfLong.length;
    System.arraycopy(localObject2, 0, localObject14, paramInt2, localObject2.length);
    System.arraycopy(localObject6, 0, localObject14, paramInt2 + localObject2.length, localObject6.length);
    return a(a((byte[])localObject14, this.u, paramInt1 + 1 + 1), this.y, this.A, this.B);
  }
  
  public int a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, long paramLong4, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("start request_tgtgt_nopicsig", String.valueOf(paramLong2));
    int j = t.w;
    byte[] arrayOfByte = c(paramArrayOfByte2);
    if (arrayOfByte == null) {
      return -1014;
    }
    paramInt1 = 0;
    for (;;)
    {
      paramInt6 = paramInt1;
      WUserSigInfo localWUserSigInfo = paramWUserSigInfo;
      paramArrayOfByte2 = this;
      if ((paramArrayOfByte2.y == oicq_request.EncryptionMethod.EM_ST) && ((paramArrayOfByte2.B == null) || (paramArrayOfByte2.B.length == 0) || (paramArrayOfByte2.A == null) || (paramArrayOfByte2.A.length == 0)))
      {
        paramArrayOfByte2.y = oicq_request.EncryptionMethod.EM_ECDH;
        t.an.attr_api(2413503);
        util.LOGI("using wt st encrypt body but no st key", String.valueOf(paramLong2));
      }
      a(paramLong2, a(paramLong1, j, paramLong2, paramInt2, paramArrayOfByte1, arrayOfByte, paramArrayOfByte3, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong3, j, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfByte4, paramLong4, t.E, localWUserSigInfo._domains, localWUserSigInfo._source_type), this.y);
      int i = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      paramInt1 = i;
      if (i != 0) {
        break;
      }
      i = b();
      paramArrayOfByte2 = new StringBuilder("retry num:");
      paramArrayOfByte2.append(paramInt6);
      paramArrayOfByte2.append(" ret:");
      paramArrayOfByte2.append(i);
      util.LOGI(paramArrayOfByte2.toString(), String.valueOf(paramLong2));
      paramInt1 = i;
      if (i != 180) {
        break;
      }
      paramInt1 = paramInt6 + 1;
      if (paramInt6 > 0)
      {
        paramInt1 = i;
        break;
      }
    }
    util.LOGI("end request_tgtgt_nopicsig ret ".concat(String.valueOf(paramInt1)), String.valueOf(paramLong2));
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.y
 * JD-Core Version:    0.7.0.1
 */