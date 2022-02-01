package oicq.wlogin_sdk.request;

import android.content.Context;
import android.util.Log;
import com.tencent.loginsecsdk.ProtocolDet;
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
    Object localObject9 = new tlv_t18();
    Object localObject10 = new tlv_t1();
    Object localObject11 = new tlv_t106();
    Object localObject14 = new tlv_t116();
    Object localObject12 = new tlv_t100();
    Object localObject13 = new tlv_t107();
    Object localObject34 = new tlv_t108();
    Object localObject32 = new tlv_t109();
    Object localObject31 = new tlv_t52d();
    Object localObject30 = new tlv_t124();
    Object localObject29 = new tlv_t128();
    Object localObject26 = new tlv_t142();
    tlv_t112 localtlv_t112 = new tlv_t112();
    Object localObject27 = new tlv_t144();
    Object localObject15 = new tlv_t145();
    Object localObject19 = new tlv_t147();
    Object localObject33 = new tlv_t166();
    tlv_t16a localtlv_t16a = new tlv_t16a();
    Object localObject17 = new tlv_t141();
    Object localObject18 = new tlv_t8();
    Object localObject16 = new tlv_t154();
    tlv_t511 localtlv_t511 = new tlv_t511();
    Object localObject28 = new tlv_t16e();
    Object localObject1 = new tlv_t172();
    Object localObject20 = new tlv_t177();
    Object localObject8 = new tlv_t400();
    Object localObject2 = new tlv_t187();
    Object localObject3 = new tlv_t188();
    Object localObject4 = new tlv_t194();
    Object localObject5 = new tlv_t201();
    Object localObject6 = new tlv_t202();
    Object localObject24 = new tlv_t(1302);
    Object localObject23 = new tlv_t(1313);
    Object localObject21 = new tlv_t(1317);
    Object localObject7 = new tlv_t545();
    Object localObject22 = new tlv_t544();
    oicq.wlogin_sdk.report.c.a(Thread.currentThread());
    long l1 = System.currentTimeMillis();
    Object localObject25 = this.x.a(paramLong2, paramLong4);
    localObject9 = ((tlv_t18)localObject9).get_tlv_18(paramLong1, paramInt1, paramLong2, paramInt2);
    localObject10 = ((tlv_t1)localObject10).get_tlv_1(paramLong2, paramArrayOfByte1);
    ((tlv_t106)localObject11).set_data(paramArrayOfByte2, paramArrayOfByte2.length);
    localObject11 = ((tlv_t106)localObject11).get_buf();
    util.LOGD("req2 a1:", util.buf_to_string((byte[])localObject11));
    localObject12 = ((tlv_t100)localObject12).get_tlv_100(paramLong1, paramLong3, paramInt1, paramInt5);
    localObject13 = ((tlv_t107)localObject13).get_tlv_107(paramInt7, paramInt8, paramInt9, paramInt10);
    localObject14 = ((tlv_t116)localObject14).get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
    localObject15 = ((tlv_t145)localObject15).get_tlv_145(u.B);
    localObject16 = ((tlv_t154)localObject16).get_tlv_154(this.x.i);
    localObject17 = ((tlv_t141)localObject17).get_tlv_141(u.D, u.E, u.G);
    localObject18 = ((tlv_t8)localObject18).get_tlv_8(0, u.v, 0);
    localObject19 = ((tlv_t147)localObject19).get_tlv_147(paramLong4, u.H, u.I);
    localObject20 = ((tlv_t177)localObject20).get_tlv_177(1630062176L, "6.0.0.2484");
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0)) {
      paramArrayOfLong = ((tlv_t108)localObject34).get_tlv_108(paramArrayOfByte4);
    }
    for (paramInt1 = 13;; paramInt1 = 12)
    {
      if ((paramInt3 & 0x80) != 0)
      {
        paramArrayOfByte4 = ((tlv_t166)localObject33).get_tlv_166(u.y);
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((this.x.s != null) && (this.x.s.length > 0))
        {
          localObject1 = ((tlv_t172)localObject1).get_tlv_172(this.x.s);
          paramInt1 += 1;
        }
        for (;;)
        {
          if ((u.O != null) && (u.O.length > 0))
          {
            localObject2 = ((tlv_t187)localObject2).get_tlv_187(u.O);
            paramInt1 += 1;
          }
          for (;;)
          {
            if ((u.P != null) && (u.P.length > 0))
            {
              localObject3 = ((tlv_t188)localObject3).get_tlv_188(u.P);
              paramInt1 += 1;
            }
            for (;;)
            {
              if ((u.M != null) && (u.M.length > 0))
              {
                localObject4 = ((tlv_t194)localObject4).get_tlv_194(u.M);
                paramInt1 += 1;
              }
              for (;;)
              {
                if ((l.L != null) && (l.L.length > 0))
                {
                  localObject5 = ((tlv_t201)localObject5).get_tlv_201(l.L, l.M, "qq".getBytes(), l.N);
                  paramInt1 += 1;
                }
                for (;;)
                {
                  if ((u.S != null) && (u.S.length > 0))
                  {
                    localObject6 = ((tlv_t202)localObject6).get_tlv_202(u.S, u.T);
                    paramInt1 += 1;
                  }
                  for (;;)
                  {
                    if ((u.U == null) || (u.U.length == 0)) {
                      u.U = util.get_qimei(u.u);
                    }
                    if ((u.U != null) && (u.U.length > 0))
                    {
                      localObject7 = ((tlv_t545)localObject7).get_tlv_545(u.U);
                      util.LOGI(util.LOG_TAG_QIMEI + "tgtgt_nopicsig qimei len =" + u.U.length, "");
                      paramInt1 += 1;
                      paramArrayOfByte1 = ((tlv_t109)localObject32).get_tlv_109(u.P);
                      paramArrayOfByte2 = ((tlv_t52d)localObject31).get_tlv_52d(this.a);
                      localObject31 = util.get_os_type();
                      localObject32 = util.get_os_version();
                      paramInt2 = u.E;
                      localObject33 = u.D;
                      localObject34 = u.G;
                      localObject30 = ((tlv_t124)localObject30).get_tlv_124((byte[])localObject31, (byte[])localObject32, paramInt2, (byte[])localObject33, new byte[0], (byte[])localObject34);
                      localObject29 = ((tlv_t128)localObject29).get_tlv_128(u.V, u.W, u.X, u.aa, u.J, u.B, u.Q);
                      localObject28 = ((tlv_t16e)localObject28).get_tlv_16e(u.J);
                      util.LOGI("nopicsig tlv16e", "");
                      localObject27 = ((tlv_t144)localObject27).get_tlv_144(paramArrayOfByte1, paramArrayOfByte2, (byte[])localObject30, (byte[])localObject29, (byte[])localObject28, u.b(this.x.h)._tgtgt_key);
                      localObject26 = ((tlv_t142)localObject26).get_tlv_142(paramArrayOfByte5);
                      paramInt1 = paramInt1 + 1 + 1;
                      if ((this.x.g == null) || (util.check_uin_account(this.x.g).booleanValue())) {
                        break label2957;
                      }
                      paramArrayOfByte5 = localtlv_t112.get_tlv_112(this.x.g.getBytes());
                      paramInt1 += 1;
                      util.LOGI("nopicsig tlv112", "");
                    }
                    for (;;)
                    {
                      if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
                      {
                        paramArrayOfByte3 = localtlv_t16a.get_tlv_16a(paramArrayOfByte3);
                        paramInt1 += 1;
                        util.LOGI("nopicsig tlv16a", "");
                      }
                      for (;;)
                      {
                        if ((paramList != null) && (paramList.size() > 0))
                        {
                          paramList = localtlv_t511.get_tlv_511(paramList);
                          paramInt1 += 1;
                          util.LOGI("nopicsig tlv511", "");
                        }
                        for (;;)
                        {
                          if ((localObject25 != null) && (((WloginSigInfo)localObject25)._G != null) && (((WloginSigInfo)localObject25)._G.length > 0) && (((WloginSigInfo)localObject25)._dpwd != null) && (((WloginSigInfo)localObject25)._dpwd.length > 0) && (((WloginSigInfo)localObject25)._randseed != null) && (((WloginSigInfo)localObject25)._randseed.length > 0))
                          {
                            localObject8 = ((tlv_t400)localObject8).get_tlv_400(((WloginSigInfo)localObject25)._G, paramLong2, u.B, ((WloginSigInfo)localObject25)._dpwd, paramLong4, 1L, ((WloginSigInfo)localObject25)._randseed);
                            util.LOGI("nopicsig tlv400", "");
                            paramInt1 += 1;
                          }
                          for (;;)
                          {
                            paramArrayOfByte1 = new byte[4];
                            util.int32_to_buf(paramArrayOfByte1, 0, paramInt11);
                            ((tlv_t)localObject24).set_data(paramArrayOfByte1, 4);
                            localObject24 = ((tlv_t)localObject24).get_buf();
                            util.LOGI("nopicsig tlv516", "");
                            paramArrayOfByte1 = new byte[6];
                            util.int32_to_buf(paramArrayOfByte1, 0, u.aA);
                            util.int16_to_buf(paramArrayOfByte1, 4, 0);
                            ((tlv_t)localObject23).set_data(paramArrayOfByte1, 6);
                            localObject23 = ((tlv_t)localObject23).get_buf();
                            paramInt1 = paramInt1 + 1 + 1;
                            util.LOGI("nopicsig tlv521", "");
                            paramLong3 = System.currentTimeMillis();
                            paramArrayOfByte1 = "6.0.0.2484".getBytes();
                            paramArrayOfByte2 = new byte[u.B.length + 10 + 2 + paramArrayOfByte1.length + 4];
                            util.int64_to_buf(paramArrayOfByte2, 0, (int)paramLong2);
                            util.int16_to_buf(paramArrayOfByte2, 4, u.B.length);
                            System.arraycopy(u.B, 0, paramArrayOfByte2, 6, u.B.length);
                            paramInt2 = u.B.length + 6;
                            util.int16_to_buf(paramArrayOfByte2, paramInt2, paramArrayOfByte1.length);
                            paramInt2 += 2;
                            System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt2, paramArrayOfByte1.length);
                            util.int32_to_buf(paramArrayOfByte2, paramInt2 + paramArrayOfByte1.length, this.u);
                            localObject22 = ((tlv_t544)localObject22).get_tlv_544(String.valueOf(paramLong2), "810_f", paramArrayOfByte2);
                            paramLong4 = System.currentTimeMillis();
                            util.LOGI("nopicsig tlv544 cost:" + (paramLong4 - paramLong3), "");
                            try
                            {
                              paramLong2 = System.currentTimeMillis();
                            }
                            catch (Throwable paramArrayOfByte2)
                            {
                              for (;;)
                              {
                                label1858:
                                paramLong1 = 0L;
                                paramLong2 = 0L;
                                paramArrayOfByte1 = null;
                                util.LOGI("request_tgtgt_nopicsig tlv536 error" + Log.getStackTraceString(paramArrayOfByte2), "");
                              }
                              paramArrayOfByte2 = new byte[paramInt2];
                              System.arraycopy(localObject9, 0, paramArrayOfByte2, 0, localObject9.length);
                              paramInt1 = 0 + localObject9.length;
                              System.arraycopy(localObject10, 0, paramArrayOfByte2, paramInt1, localObject10.length);
                              paramInt1 += localObject10.length;
                              System.arraycopy(localObject11, 0, paramArrayOfByte2, paramInt1, localObject11.length);
                              paramInt1 += localObject11.length;
                              System.arraycopy(localObject14, 0, paramArrayOfByte2, paramInt1, localObject14.length);
                              paramInt1 += localObject14.length;
                              System.arraycopy(localObject12, 0, paramArrayOfByte2, paramInt1, localObject12.length);
                              paramInt1 += localObject12.length;
                              System.arraycopy(localObject13, 0, paramArrayOfByte2, paramInt1, localObject13.length);
                              paramInt1 += localObject13.length;
                              System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte2, paramInt1, paramArrayOfLong.length);
                              paramInt1 += paramArrayOfLong.length;
                              System.arraycopy(localObject27, 0, paramArrayOfByte2, paramInt1, localObject27.length);
                              paramInt1 += localObject27.length;
                              System.arraycopy(localObject26, 0, paramArrayOfByte2, paramInt1, localObject26.length);
                              paramInt1 += localObject26.length;
                              System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte2, paramInt1, paramArrayOfByte5.length);
                              paramInt1 += paramArrayOfByte5.length;
                              System.arraycopy(localObject15, 0, paramArrayOfByte2, paramInt1, localObject15.length);
                              paramInt1 += localObject15.length;
                              System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte2, paramInt1, paramArrayOfByte4.length);
                              paramInt1 += paramArrayOfByte4.length;
                              System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte2, paramInt1, paramArrayOfByte3.length);
                              paramInt1 += paramArrayOfByte3.length;
                              System.arraycopy(localObject16, 0, paramArrayOfByte2, paramInt1, localObject16.length);
                              paramInt1 += localObject16.length;
                              System.arraycopy(localObject17, 0, paramArrayOfByte2, paramInt1, localObject17.length);
                              paramInt1 += localObject17.length;
                              System.arraycopy(localObject18, 0, paramArrayOfByte2, paramInt1, localObject18.length);
                              paramInt1 += localObject18.length;
                              System.arraycopy(paramList, 0, paramArrayOfByte2, paramInt1, paramList.length);
                              paramInt1 += paramList.length;
                              System.arraycopy(localObject19, 0, paramArrayOfByte2, paramInt1, localObject19.length);
                              paramInt1 += localObject19.length;
                              System.arraycopy(localObject1, 0, paramArrayOfByte2, paramInt1, localObject1.length);
                              paramInt1 += localObject1.length;
                              System.arraycopy(localObject20, 0, paramArrayOfByte2, paramInt1, localObject20.length);
                              paramInt1 += localObject20.length;
                              System.arraycopy(localObject8, 0, paramArrayOfByte2, paramInt1, localObject8.length);
                              paramInt1 += localObject8.length;
                              System.arraycopy(localObject2, 0, paramArrayOfByte2, paramInt1, localObject2.length);
                              paramInt1 += localObject2.length;
                              System.arraycopy(localObject3, 0, paramArrayOfByte2, paramInt1, localObject3.length);
                              paramInt1 += localObject3.length;
                              System.arraycopy(localObject4, 0, paramArrayOfByte2, paramInt1, localObject4.length);
                              paramInt1 += localObject4.length;
                              System.arraycopy(localObject5, 0, paramArrayOfByte2, paramInt1, localObject5.length);
                              paramInt1 += localObject5.length;
                              System.arraycopy(localObject6, 0, paramArrayOfByte2, paramInt1, localObject6.length);
                              paramInt1 += localObject6.length;
                              System.arraycopy(localObject24, 0, paramArrayOfByte2, paramInt1, localObject24.length);
                              paramInt1 += localObject24.length;
                              System.arraycopy(localObject23, 0, paramArrayOfByte2, paramInt1, localObject23.length);
                              paramInt2 = paramInt1 + localObject23.length;
                              paramInt1 = paramInt2;
                              if (paramArrayOfByte1 != null)
                              {
                                System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt2, paramArrayOfByte1.length);
                                paramInt1 = paramInt2 + paramArrayOfByte1.length;
                              }
                              paramInt2 = paramInt1;
                              if (localObject22 != null)
                              {
                                System.arraycopy(localObject22, 0, paramArrayOfByte2, paramInt1, localObject22.length);
                                paramInt2 = paramInt1 + localObject22.length;
                              }
                              paramInt1 = paramInt2;
                              if (localObject7 != null)
                              {
                                paramInt1 = paramInt2;
                                if (localObject7.length > 0)
                                {
                                  System.arraycopy(localObject7, 0, paramArrayOfByte2, paramInt2, localObject7.length);
                                  paramInt1 = paramInt2 + localObject7.length;
                                  util.LOGI("nopicsig qimei len:" + localObject7.length, "");
                                }
                              }
                              paramArrayOfByte1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
                              while (paramArrayOfByte1.hasNext())
                              {
                                paramArrayOfByte3 = (Integer)paramArrayOfByte1.next();
                                paramArrayOfLong = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte3)).get_buf();
                                System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte2, paramInt1, paramArrayOfLong.length);
                                paramInt2 = paramArrayOfLong.length;
                                util.LOGI("Extra Tlv from user：0x" + paramArrayOfByte3);
                                paramInt1 = paramInt2 + paramInt1;
                              }
                              long l2 = System.currentTimeMillis();
                              a.a().a(2, l2 - l1, paramLong4 - paramLong3, paramLong1 - paramLong2);
                              oicq.wlogin_sdk.report.c.b(Thread.currentThread());
                              return a(a(paramArrayOfByte2, this.u, paramInt3), this.y, this.A, this.B);
                            }
                            for (;;)
                            {
                              try
                              {
                                paramArrayOfByte1 = new tlv_t(1334);
                                paramArrayOfByte2 = ProtocolDet.getLoginExtraData(this.a);
                                if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0)) {
                                  continue;
                                }
                                paramArrayOfByte1.set_data(paramArrayOfByte2, paramArrayOfByte2.length);
                                paramArrayOfByte1 = paramArrayOfByte1.get_buf();
                                localObject25 = new byte[paramArrayOfByte1.length + 2];
                                util.int16_to_buf((byte[])localObject25, 0, 1);
                                System.arraycopy(paramArrayOfByte1, 0, localObject25, 2, paramArrayOfByte1.length);
                                ((tlv_t)localObject21).set_data((byte[])localObject25, localObject25.length);
                                paramArrayOfByte1 = ((tlv_t)localObject21).get_buf();
                                paramInt1 += 1;
                              }
                              catch (Throwable paramArrayOfByte2)
                              {
                                paramLong1 = 0L;
                                paramArrayOfByte1 = null;
                                break label2074;
                                paramArrayOfByte1 = null;
                                break;
                              }
                              try
                              {
                                util.LOGI("nopicsig tlv536 " + paramArrayOfByte2.length, "" + this.x.f);
                              }
                              catch (Throwable paramArrayOfByte2)
                              {
                                paramLong1 = 0L;
                                break label2074;
                              }
                            }
                            try
                            {
                              paramLong1 = System.currentTimeMillis();
                            }
                            catch (Throwable paramArrayOfByte2)
                            {
                              paramLong1 = 0L;
                              break label2074;
                            }
                            try
                            {
                              util.LOGI("nopicsig tlv536 cost:" + (paramLong1 - paramLong2), "");
                              paramInt2 = localObject9.length + localObject10.length + localObject11.length + localObject14.length + localObject12.length + localObject13.length + paramArrayOfLong.length + localObject27.length + localObject26.length + paramArrayOfByte5.length + localObject15.length + paramArrayOfByte4.length + paramArrayOfByte3.length + localObject16.length + localObject17.length + localObject18.length + paramList.length + localObject19.length + localObject1.length + localObject20.length + localObject8.length + localObject2.length + localObject3.length + localObject4.length + localObject5.length + localObject6.length + localObject24.length + localObject23.length;
                              paramInt3 = paramInt2;
                              if (paramArrayOfByte1 != null) {
                                paramInt3 = paramInt2 + paramArrayOfByte1.length;
                              }
                              paramInt2 = paramInt3;
                              if (localObject7 != null)
                              {
                                paramInt2 = paramInt3;
                                if (localObject7.length > 0) {
                                  paramInt2 = paramInt3 + localObject7.length;
                                }
                              }
                              if (localObject22 == null) {
                                break label2932;
                              }
                              paramInt3 = localObject22.length;
                              paramInt1 += 1;
                              paramInt2 += paramInt3;
                            }
                            catch (Throwable paramArrayOfByte2)
                            {
                              break label2074;
                              break label1858;
                            }
                            paramArrayOfByte2 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
                            paramInt3 = paramInt1;
                            while (paramArrayOfByte2.hasNext())
                            {
                              localObject21 = (Integer)paramArrayOfByte2.next();
                              localObject25 = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(localObject21)).get_buf();
                              paramInt1 = localObject25.length;
                              util.LOGI("Extra Tlv from user：0x" + localObject21 + " body_len:" + localObject25.length, "");
                              paramInt3 += 1;
                              paramInt2 = paramInt1 + paramInt2;
                            }
                            oicq.wlogin_sdk.report.event.c.a(new b("wtlogin_qimei_error", "tgtgt_nopicsig_error", ""));
                            util.LOGI(util.LOG_TAG_QIMEI + "tgtgt_nopicsig qimei len = null", "");
                            localObject7 = new byte[0];
                            break;
                            util.LOGI("request_tgtgt_nopicsig req without DA1", "" + paramLong2);
                            localObject8 = new byte[0];
                          }
                          label2074:
                          label2932:
                          paramList = new byte[0];
                        }
                        paramArrayOfByte3 = new byte[0];
                      }
                      label2957:
                      paramArrayOfByte5 = new byte[0];
                    }
                    localObject6 = new byte[0];
                  }
                  localObject5 = new byte[0];
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
  }
  
  public int a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, long paramLong4, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("start request_tgtgt_nopicsig", "" + paramLong2);
    int i = u.x;
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
        u.at.attr_api(2413503);
        util.LOGI("using wt st encrypt body but no st key", "" + paramLong2);
      }
      a(paramLong2, a(paramLong1, i, paramLong2, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong3, i, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfByte4, paramLong4, u.F, paramWUserSigInfo._domains, paramWUserSigInfo._source_type, paramWUserSigInfo), this.y);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.ab
 * JD-Core Version:    0.7.0.1
 */