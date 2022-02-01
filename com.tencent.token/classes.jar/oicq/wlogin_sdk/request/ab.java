package oicq.wlogin_sdk.request;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.a;
import oicq.wlogin_sdk.report.event.b;
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
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t545;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class ab
  extends oicq_request
{
  public ab(u paramu, Context paramContext)
  {
    this.t = 2064;
    this.u = 15;
    this.v = "wtlogin.exchange_emp";
    this.x = paramu;
    this.x.m = 0;
    this.y = oicq_request.EncryptionMethod.EM_ST;
    this.a = paramContext;
  }
  
  private byte[] a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, long paramLong4, byte[] paramArrayOfByte5, List<String> paramList, int paramInt11, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject13 = new tlv_t18();
    Object localObject14 = new tlv_t1();
    Object localObject15 = new tlv_t106();
    Object localObject18 = new tlv_t116();
    Object localObject16 = new tlv_t100();
    Object localObject17 = new tlv_t107();
    Object localObject1 = new tlv_t108();
    Object localObject30 = new tlv_t109();
    Object localObject29 = new tlv_t52d();
    Object localObject28 = new tlv_t124();
    Object localObject27 = new tlv_t128();
    Object localObject24 = new tlv_t142();
    tlv_t112 localtlv_t112 = new tlv_t112();
    Object localObject25 = new tlv_t144();
    Object localObject10 = new tlv_t145();
    Object localObject8 = new tlv_t147();
    tlv_t166 localtlv_t166 = new tlv_t166();
    tlv_t16a localtlv_t16a = new tlv_t16a();
    Object localObject12 = new tlv_t141();
    Object localObject11 = new tlv_t8();
    Object localObject19 = new tlv_t154();
    tlv_t511 localtlv_t511 = new tlv_t511();
    Object localObject26 = new tlv_t16e();
    Object localObject9 = new tlv_t172();
    Object localObject2 = new tlv_t177();
    Object localObject23 = new tlv_t400();
    Object localObject4 = new tlv_t187();
    Object localObject5 = new tlv_t188();
    Object localObject6 = new tlv_t194();
    Object localObject7 = new tlv_t201();
    Object localObject32 = new tlv_t202();
    Object localObject22 = new tlv_t(1302);
    Object localObject21 = new tlv_t(1313);
    new tlv_t(1317);
    Object localObject31 = new tlv_t545();
    Object localObject20 = new tlv_t544();
    oicq.wlogin_sdk.report.c.a(Thread.currentThread());
    long l = System.currentTimeMillis();
    Object localObject3 = this.x.a(paramLong2, paramLong4);
    localObject13 = ((tlv_t18)localObject13).get_tlv_18(paramLong1, paramInt1, paramLong2, paramInt2);
    localObject14 = ((tlv_t1)localObject14).get_tlv_1(paramLong2, paramArrayOfByte1);
    ((tlv_t106)localObject15).set_data(paramArrayOfByte2, paramArrayOfByte2.length);
    localObject15 = ((tlv_t106)localObject15).get_buf();
    util.LOGD("req2 a1:", util.buf_to_string((byte[])localObject15));
    localObject16 = ((tlv_t100)localObject16).get_tlv_100(paramLong1, paramLong3, paramInt1, paramInt5);
    localObject17 = ((tlv_t107)localObject17).get_tlv_107(paramInt7, paramInt8, paramInt9, paramInt10);
    localObject18 = ((tlv_t116)localObject18).get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
    localObject10 = ((tlv_t145)localObject10).get_tlv_145(u.B);
    localObject19 = ((tlv_t154)localObject19).get_tlv_154(this.x.i);
    byte[] arrayOfByte1 = ((tlv_t141)localObject12).get_tlv_141(u.D, u.E, u.G);
    byte[] arrayOfByte2 = ((tlv_t8)localObject11).get_tlv_8(0, u.v, 0);
    localObject8 = ((tlv_t147)localObject8).get_tlv_147(paramLong4, u.H, u.I);
    localObject2 = ((tlv_t177)localObject2).get_tlv_177(1630563984L, "6.0.0.2484");
    localObject11 = new byte[0];
    localObject12 = new byte[0];
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0))
    {
      localObject1 = ((tlv_t108)localObject1).get_tlv_108(paramArrayOfByte4);
      paramInt1 = 13;
    }
    else
    {
      paramInt1 = 12;
      localObject1 = new byte[0];
    }
    if ((paramInt3 & 0x80) != 0)
    {
      paramArrayOfByte1 = localtlv_t166.get_tlv_166(u.y);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte1 = new byte[0];
    }
    if ((this.x.s != null) && (this.x.s.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t172)localObject9).get_tlv_172(this.x.s);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte2 = new byte[0];
    }
    if ((u.O != null) && (u.O.length > 0))
    {
      paramArrayOfLong = ((tlv_t187)localObject4).get_tlv_187(u.O);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfLong = new byte[0];
    }
    localObject4 = paramArrayOfByte2;
    if ((u.P != null) && (u.P.length > 0))
    {
      paramArrayOfByte4 = ((tlv_t188)localObject5).get_tlv_188(u.P);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte4 = new byte[0];
    }
    localObject5 = paramArrayOfLong;
    if ((u.M != null) && (u.M.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t194)localObject6).get_tlv_194(u.M);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte2 = new byte[0];
    }
    localObject6 = paramArrayOfByte4;
    if ((m.L != null) && (m.L.length > 0))
    {
      paramArrayOfLong = ((tlv_t201)localObject7).get_tlv_201(m.L, m.M, "qq".getBytes(), m.N);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfLong = new byte[0];
    }
    localObject7 = paramArrayOfByte1;
    localObject9 = paramArrayOfByte2;
    if ((u.S != null) && (u.S.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t202)localObject32).get_tlv_202(u.S, u.T);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte2 = new byte[0];
    }
    if ((u.U == null) || (u.U.length == 0)) {
      u.U = util.get_qimei(u.u);
    }
    if ((u.U != null) && (u.U.length > 0))
    {
      paramArrayOfByte1 = ((tlv_t545)localObject31).get_tlv_545(u.U);
      paramInt1 += 1;
      paramArrayOfByte4 = new StringBuilder();
      paramArrayOfByte4.append(util.LOG_TAG_QIMEI);
      paramArrayOfByte4.append("tgtgt_nopicsig qimei len =");
      paramArrayOfByte4.append(u.U.length);
      util.LOGI(paramArrayOfByte4.toString(), "");
    }
    else
    {
      oicq.wlogin_sdk.report.event.c.a(new b("wtlogin_qimei_error", "tgtgt_nopicsig_error", ""));
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append(util.LOG_TAG_QIMEI);
      paramArrayOfByte1.append("tgtgt_nopicsig qimei len = null");
      util.LOGI(paramArrayOfByte1.toString(), "");
      paramArrayOfByte1 = (byte[])localObject12;
    }
    paramArrayOfByte4 = ((tlv_t109)localObject30).get_tlv_109(u.P);
    localObject12 = ((tlv_t52d)localObject29).get_tlv_52d(this.a);
    localObject29 = util.get_os_type();
    localObject30 = util.get_os_version();
    paramInt2 = u.E;
    localObject31 = u.D;
    localObject32 = u.G;
    localObject28 = ((tlv_t124)localObject28).get_tlv_124((byte[])localObject29, (byte[])localObject30, paramInt2, (byte[])localObject31, new byte[0], (byte[])localObject32);
    localObject27 = ((tlv_t128)localObject27).get_tlv_128(u.V, u.W, u.X, u.aa, u.J, u.B, u.Q);
    localObject26 = ((tlv_t16e)localObject26).get_tlv_16e(u.J);
    util.LOGI("nopicsig tlv16e", "");
    localObject25 = ((tlv_t144)localObject25).get_tlv_144(paramArrayOfByte4, (byte[])localObject12, (byte[])localObject28, (byte[])localObject27, (byte[])localObject26, u.b(this.x.h)._tgtgt_key);
    localObject24 = ((tlv_t142)localObject24).get_tlv_142(paramArrayOfByte5);
    paramInt1 = paramInt1 + 1 + 1;
    if ((this.x.g != null) && (!util.check_uin_account(this.x.g).booleanValue()))
    {
      paramArrayOfByte5 = localtlv_t112.get_tlv_112(this.x.g.getBytes());
      util.LOGI("nopicsig tlv112", "");
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte5 = (byte[])localObject11;
    }
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
    {
      paramArrayOfByte3 = localtlv_t16a.get_tlv_16a(paramArrayOfByte3);
      paramInt1 += 1;
      util.LOGI("nopicsig tlv16a", "");
    }
    else
    {
      paramArrayOfByte3 = new byte[0];
    }
    paramArrayOfByte4 = paramList;
    if ((paramArrayOfByte4 != null) && (paramList.size() > 0))
    {
      paramArrayOfByte4 = localtlv_t511.get_tlv_511(paramArrayOfByte4);
      paramInt1 += 1;
      util.LOGI("nopicsig tlv511", "");
    }
    else
    {
      paramArrayOfByte4 = new byte[0];
    }
    paramList = paramArrayOfLong;
    if ((localObject3 != null) && (((WloginSigInfo)localObject3)._G != null) && (((WloginSigInfo)localObject3)._G.length > 0) && (((WloginSigInfo)localObject3)._dpwd != null) && (((WloginSigInfo)localObject3)._dpwd.length > 0) && (((WloginSigInfo)localObject3)._randseed != null) && (((WloginSigInfo)localObject3)._randseed.length > 0))
    {
      paramArrayOfLong = ((tlv_t400)localObject23).get_tlv_400(((WloginSigInfo)localObject3)._G, paramLong2, u.B, ((WloginSigInfo)localObject3)._dpwd, paramLong4, 1L, ((WloginSigInfo)localObject3)._randseed);
      paramInt1 += 1;
      util.LOGI("nopicsig tlv400", "");
    }
    else
    {
      util.LOGI("request_tgtgt_nopicsig req without DA1", String.valueOf(paramLong2));
      paramArrayOfLong = new byte[0];
    }
    localObject3 = paramArrayOfByte3;
    paramArrayOfByte3 = new byte[4];
    util.int32_to_buf(paramArrayOfByte3, 0, paramInt11);
    ((tlv_t)localObject22).set_data(paramArrayOfByte3, 4);
    localObject22 = ((tlv_t)localObject22).get_buf();
    util.LOGI("nopicsig tlv516", "");
    paramArrayOfByte3 = new byte[6];
    util.int32_to_buf(paramArrayOfByte3, 0, u.aA);
    util.int16_to_buf(paramArrayOfByte3, 4, 0);
    ((tlv_t)localObject21).set_data(paramArrayOfByte3, 6);
    localObject12 = ((tlv_t)localObject21).get_buf();
    paramInt2 = paramInt1 + 1 + 1;
    util.LOGI("nopicsig tlv521", "");
    paramLong1 = System.currentTimeMillis();
    paramArrayOfByte3 = "6.0.0.2484".getBytes();
    localObject11 = new byte[u.B.length + 10 + 2 + paramArrayOfByte3.length + 4];
    util.int64_to_buf((byte[])localObject11, 0, (int)paramLong2);
    util.int16_to_buf((byte[])localObject11, 4, u.B.length);
    System.arraycopy(u.B, 0, localObject11, 6, u.B.length);
    paramInt1 = u.B.length + 6;
    util.int16_to_buf((byte[])localObject11, paramInt1, paramArrayOfByte3.length);
    paramInt1 += 2;
    System.arraycopy(paramArrayOfByte3, 0, localObject11, paramInt1, paramArrayOfByte3.length);
    util.int32_to_buf((byte[])localObject11, paramInt1 + paramArrayOfByte3.length, this.u);
    localObject20 = ((tlv_t544)localObject20).get_tlv_544(String.valueOf(paramLong2), "810_f", (byte[])localObject11);
    paramLong2 = System.currentTimeMillis();
    paramArrayOfByte3 = new StringBuilder("nopicsig tlv544 cost:");
    paramLong1 = paramLong2 - paramLong1;
    paramArrayOfByte3.append(paramLong1);
    util.LOGI(paramArrayOfByte3.toString(), "");
    paramInt1 = localObject13.length;
    paramInt3 = localObject14.length;
    paramInt4 = localObject15.length;
    paramInt5 = localObject18.length;
    paramInt6 = localObject16.length;
    paramInt7 = localObject17.length;
    paramInt8 = localObject1.length;
    paramInt9 = localObject25.length;
    paramInt10 = localObject24.length;
    paramInt11 = paramArrayOfByte5.length;
    int i = localObject10.length;
    int j = localObject7.length;
    int k = localObject3.length;
    int m = localObject19.length;
    int n = arrayOfByte1.length;
    int i1 = arrayOfByte2.length;
    int i2 = paramArrayOfByte4.length;
    int i3 = localObject8.length;
    int i4 = localObject4.length;
    int i5 = localObject2.length;
    int i6 = paramArrayOfLong.length;
    int i7 = localObject5.length;
    int i8 = localObject6.length;
    int i9 = localObject9.length;
    int i10 = paramList.length;
    paramInt3 = paramInt1 + paramInt3 + paramInt4 + paramInt5 + paramInt6 + paramInt7 + paramInt8 + paramInt9 + paramInt10 + paramInt11 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + paramArrayOfByte2.length + localObject22.length + localObject12.length;
    if (paramArrayOfByte1 != null)
    {
      paramArrayOfByte3 = paramArrayOfByte1;
      paramInt1 = paramInt3;
      if (paramArrayOfByte3.length > 0) {
        paramInt1 = paramInt3 + paramArrayOfByte3.length;
      }
    }
    else
    {
      paramInt1 = paramInt3;
    }
    localObject11 = paramArrayOfByte1;
    if (localObject20 != null)
    {
      paramInt4 = localObject20.length;
      paramInt3 = paramInt2 + 1;
      paramInt2 = paramInt1 + paramInt4;
      paramInt1 = paramInt3;
    }
    else
    {
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = paramInt3;
    }
    paramArrayOfByte3 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
    paramInt3 = paramInt2;
    paramArrayOfByte1 = paramArrayOfByte2;
    paramInt2 = paramInt1;
    while (paramArrayOfByte3.hasNext())
    {
      paramArrayOfByte2 = (Integer)paramArrayOfByte3.next();
      localObject21 = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte2)).get_buf();
      paramInt1 = localObject21.length;
      paramInt2 += 1;
      localObject23 = new StringBuilder("Extra Tlv from user：0x");
      ((StringBuilder)localObject23).append(paramArrayOfByte2);
      ((StringBuilder)localObject23).append(" body_len:");
      ((StringBuilder)localObject23).append(localObject21.length);
      util.LOGI(((StringBuilder)localObject23).toString(), "");
      paramInt3 += paramInt1;
    }
    paramArrayOfByte2 = new byte[paramInt3];
    System.arraycopy(localObject13, 0, paramArrayOfByte2, 0, localObject13.length);
    paramInt1 = localObject13.length + 0;
    System.arraycopy(localObject14, 0, paramArrayOfByte2, paramInt1, localObject14.length);
    paramInt1 += localObject14.length;
    System.arraycopy(localObject15, 0, paramArrayOfByte2, paramInt1, localObject15.length);
    paramInt1 += localObject15.length;
    System.arraycopy(localObject18, 0, paramArrayOfByte2, paramInt1, localObject18.length);
    paramInt1 += localObject18.length;
    System.arraycopy(localObject16, 0, paramArrayOfByte2, paramInt1, localObject16.length);
    paramInt1 += localObject16.length;
    System.arraycopy(localObject17, 0, paramArrayOfByte2, paramInt1, localObject17.length);
    paramInt1 += localObject17.length;
    System.arraycopy(localObject1, 0, paramArrayOfByte2, paramInt1, localObject1.length);
    paramInt1 += localObject1.length;
    System.arraycopy(localObject25, 0, paramArrayOfByte2, paramInt1, localObject25.length);
    paramInt1 += localObject25.length;
    System.arraycopy(localObject24, 0, paramArrayOfByte2, paramInt1, localObject24.length);
    paramInt1 += localObject24.length;
    System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte2, paramInt1, paramArrayOfByte5.length);
    paramInt1 += paramArrayOfByte5.length;
    System.arraycopy(localObject10, 0, paramArrayOfByte2, paramInt1, localObject10.length);
    paramInt1 += localObject10.length;
    System.arraycopy(localObject7, 0, paramArrayOfByte2, paramInt1, localObject7.length);
    paramInt1 += localObject7.length;
    System.arraycopy(localObject3, 0, paramArrayOfByte2, paramInt1, localObject3.length);
    paramInt1 += localObject3.length;
    System.arraycopy(localObject19, 0, paramArrayOfByte2, paramInt1, localObject19.length);
    paramInt1 += localObject19.length;
    System.arraycopy(arrayOfByte1, 0, paramArrayOfByte2, paramInt1, arrayOfByte1.length);
    paramInt1 += arrayOfByte1.length;
    System.arraycopy(arrayOfByte2, 0, paramArrayOfByte2, paramInt1, arrayOfByte2.length);
    paramInt1 += arrayOfByte2.length;
    System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte2, paramInt1, paramArrayOfByte4.length);
    paramInt1 += paramArrayOfByte4.length;
    System.arraycopy(localObject8, 0, paramArrayOfByte2, paramInt1, localObject8.length);
    paramInt1 += localObject8.length;
    System.arraycopy(localObject4, 0, paramArrayOfByte2, paramInt1, localObject4.length);
    paramInt1 += localObject4.length;
    System.arraycopy(localObject2, 0, paramArrayOfByte2, paramInt1, localObject2.length);
    paramInt1 += localObject2.length;
    System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte2, paramInt1, paramArrayOfLong.length);
    paramInt1 += paramArrayOfLong.length;
    System.arraycopy(localObject5, 0, paramArrayOfByte2, paramInt1, localObject5.length);
    paramInt1 += localObject5.length;
    System.arraycopy(localObject6, 0, paramArrayOfByte2, paramInt1, localObject6.length);
    paramInt1 += localObject6.length;
    System.arraycopy(localObject9, 0, paramArrayOfByte2, paramInt1, localObject9.length);
    paramInt1 += localObject9.length;
    System.arraycopy(paramList, 0, paramArrayOfByte2, paramInt1, paramList.length);
    paramInt1 += paramList.length;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt1, paramArrayOfByte1.length);
    paramInt1 += paramArrayOfByte1.length;
    System.arraycopy(localObject22, 0, paramArrayOfByte2, paramInt1, localObject22.length);
    paramInt1 += localObject22.length;
    System.arraycopy(localObject12, 0, paramArrayOfByte2, paramInt1, localObject12.length);
    paramInt3 = paramInt1 + localObject12.length;
    paramInt1 = paramInt3;
    if (localObject20 != null)
    {
      System.arraycopy(localObject20, 0, paramArrayOfByte2, paramInt3, localObject20.length);
      paramInt1 = paramInt3 + localObject20.length;
    }
    if ((localObject11 != null) && (localObject11.length > 0))
    {
      System.arraycopy(localObject11, 0, paramArrayOfByte2, paramInt1, localObject11.length);
      paramInt1 += localObject11.length;
      paramArrayOfByte1 = new StringBuilder("nopicsig qimei len:");
      paramArrayOfByte1.append(localObject11.length);
      util.LOGI(paramArrayOfByte1.toString(), "");
    }
    paramArrayOfByte1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
    while (paramArrayOfByte1.hasNext())
    {
      paramArrayOfByte3 = (Integer)paramArrayOfByte1.next();
      paramArrayOfLong = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte3)).get_buf();
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte2, paramInt1, paramArrayOfLong.length);
      paramInt1 += paramArrayOfLong.length;
      util.LOGI("Extra Tlv from user：0x".concat(String.valueOf(paramArrayOfByte3)));
    }
    paramLong2 = System.currentTimeMillis();
    a.a().a(2, paramLong2 - l, paramLong1, 0L);
    oicq.wlogin_sdk.report.c.b(Thread.currentThread());
    return a(a(paramArrayOfByte2, this.u, paramInt2), this.y, this.A, this.B);
  }
  
  public int a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, long paramLong4, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("start request_tgtgt_nopicsig", String.valueOf(paramLong2));
    int j = u.x;
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
        u.at.attr_api(2413503);
        util.LOGI("using wt st encrypt body but no st key", String.valueOf(paramLong2));
      }
      a(paramLong2, a(paramLong1, j, paramLong2, paramInt2, paramArrayOfByte1, arrayOfByte, paramArrayOfByte3, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong3, j, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfByte4, paramLong4, u.F, localWUserSigInfo._domains, localWUserSigInfo._source_type, paramWUserSigInfo), this.y);
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
 * Qualified Name:     oicq.wlogin_sdk.request.ab
 * JD-Core Version:    0.7.0.1
 */