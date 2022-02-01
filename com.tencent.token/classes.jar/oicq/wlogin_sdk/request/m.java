package oicq.wlogin_sdk.request;

import android.content.Context;
import com.tencent.secprotocol.t.ReportLogHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import oicq.wlogin_sdk.report.a;
import oicq.wlogin_sdk.report.event.b;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t1;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
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
import oicq.wlogin_sdk.tlv_type.tlv_t185;
import oicq.wlogin_sdk.tlv_type.tlv_t187;
import oicq.wlogin_sdk.tlv_type.tlv_t188;
import oicq.wlogin_sdk.tlv_type.tlv_t191;
import oicq.wlogin_sdk.tlv_type.tlv_t194;
import oicq.wlogin_sdk.tlv_type.tlv_t201;
import oicq.wlogin_sdk.tlv_type.tlv_t202;
import oicq.wlogin_sdk.tlv_type.tlv_t400;
import oicq.wlogin_sdk.tlv_type.tlv_t511;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t545;
import oicq.wlogin_sdk.tlv_type.tlv_t548;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class m
  extends oicq_request
{
  public static int K = 130;
  public static byte[] L = new byte[0];
  public static byte[] M = new byte[0];
  public static byte[] N = new byte[0];
  
  public m(u paramu, Context paramContext)
  {
    this.t = 2064;
    this.u = 9;
    this.v = "wtlogin.login";
    this.x = paramu;
    this.x.m = 0;
    this.a = paramContext;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong4, int paramInt6, int paramInt7, int paramInt8, int paramInt9, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    int m = u.x;
    Object localObject = u.b(this.x.h);
    ((async_context)localObject)._tgtgt_key = util.get_rand_16byte(u.C);
    byte[] arrayOfByte = ((async_context)localObject)._tgtgt_key;
    localObject = ((async_context)localObject)._t104;
    if (localObject == null) {
      localObject = new tlv_t104();
    }
    ReportLogHelper.startTimeTask();
    ReportLogHelper.report(7, 0);
    int k;
    for (int i = 0;; i = k)
    {
      a(paramLong3, a(paramLong1, paramLong2, m, paramLong3, paramInt1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, arrayOfByte, paramInt2, null, null, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong4, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfByte4, ((tlv_t104)localObject).get_data(), u.F, paramWUserSigInfo._domains, paramWUserSigInfo), this.y);
      int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (j != 0)
      {
        ReportLogHelper.report(7, 2);
        paramInt1 = j;
      }
      else
      {
        j = b();
        StringBuilder localStringBuilder = new StringBuilder("retry num:");
        localStringBuilder.append(i);
        localStringBuilder.append(" ret:");
        localStringBuilder.append(j);
        util.LOGI(localStringBuilder.toString(), String.valueOf(paramLong3));
        if (j != 180)
        {
          ReportLogHelper.report(7, 3);
          paramInt1 = j;
        }
        else
        {
          k = i + 1;
          if (i <= 0) {
            continue;
          }
          paramInt1 = j;
        }
      }
      ReportLogHelper.report(7, 1);
      ReportLogHelper.stopTimeTask();
      return paramInt1;
    }
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, long[] paramArrayOfLong, int paramInt4, long paramLong4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    ReportLogHelper.report(6, 0);
    int m = u.x;
    tlv_t104 localtlv_t104 = u.b(this.x.h)._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    paramArrayOfByte2 = c(paramArrayOfByte2);
    if (paramArrayOfByte2 == null) {
      return -1014;
    }
    int k;
    for (int i = 0;; i = k)
    {
      Object localObject = a(paramLong1, paramLong2, m, paramLong3, paramInt1, paramArrayOfByte1, null, null, null, 0, paramArrayOfByte2, paramArrayOfByte3, paramInt2, paramInt3, paramArrayOfLong, paramInt4, paramLong4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfByte4, localtlv_t104.get_data(), u.F, paramWUserSigInfo._domains, paramWUserSigInfo);
      a(this.i, this.t, this.j, paramLong3, this.m, this.n, m, this.p, (byte[])localObject);
      int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (j != 0)
      {
        ReportLogHelper.report(6, 2);
        paramInt1 = j;
      }
      else
      {
        j = b();
        localObject = new StringBuilder("retry num:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" ret:");
        ((StringBuilder)localObject).append(j);
        util.LOGI(((StringBuilder)localObject).toString(), String.valueOf(paramLong3));
        if (j != 180)
        {
          ReportLogHelper.report(6, 3);
          paramInt1 = j;
        }
        else
        {
          k = i + 1;
          if (i <= 0) {
            continue;
          }
          paramInt1 = j;
        }
      }
      ReportLogHelper.report(6, 1);
      return paramInt1;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt3, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, int paramInt4, int paramInt5, long[] paramArrayOfLong, int paramInt6, long paramLong4, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, List<String> paramList, WUserSigInfo paramWUserSigInfo)
  {
    long l1 = paramLong3;
    Object localObject3 = paramArrayOfByte8;
    int[] arrayOfInt = new int[37];
    int[] tmp16_14 = arrayOfInt;
    tmp16_14[0] = 24;
    int[] tmp21_16 = tmp16_14;
    tmp21_16[1] = 1;
    int[] tmp25_21 = tmp21_16;
    tmp25_21[2] = 262;
    int[] tmp31_25 = tmp25_21;
    tmp31_25[3] = 278;
    int[] tmp37_31 = tmp31_25;
    tmp37_31[4] = 256;
    int[] tmp43_37 = tmp37_31;
    tmp43_37[5] = 263;
    int[] tmp49_43 = tmp43_37;
    tmp49_43[6] = 264;
    int[] tmp56_49 = tmp49_43;
    tmp56_49[7] = 260;
    int[] tmp63_56 = tmp56_49;
    tmp63_56[8] = 322;
    int[] tmp70_63 = tmp63_56;
    tmp70_63[9] = 274;
    int[] tmp77_70 = tmp70_63;
    tmp77_70[10] = 324;
    int[] tmp84_77 = tmp77_70;
    tmp84_77[11] = 325;
    int[] tmp91_84 = tmp84_77;
    tmp91_84[12] = 327;
    int[] tmp98_91 = tmp91_84;
    tmp98_91[13] = 358;
    int[] tmp105_98 = tmp98_91;
    tmp105_98[14] = 362;
    int[] tmp112_105 = tmp105_98;
    tmp112_105[15] = 340;
    int[] tmp119_112 = tmp112_105;
    tmp119_112[16] = 321;
    int[] tmp126_119 = tmp119_112;
    tmp126_119[17] = 8;
    int[] tmp132_126 = tmp126_119;
    tmp132_126[18] = 1297;
    int[] tmp139_132 = tmp132_126;
    tmp139_132[19] = 370;
    int[] tmp146_139 = tmp139_132;
    tmp146_139[20] = 389;
    int[] tmp153_146 = tmp146_139;
    tmp153_146[21] = 1024;
    int[] tmp160_153 = tmp153_146;
    tmp160_153[22] = 391;
    int[] tmp167_160 = tmp160_153;
    tmp167_160[23] = 392;
    int[] tmp174_167 = tmp167_160;
    tmp174_167[24] = 404;
    int[] tmp181_174 = tmp174_167;
    tmp181_174[25] = 401;
    int[] tmp188_181 = tmp181_174;
    tmp188_181[26] = 513;
    int[] tmp195_188 = tmp188_181;
    tmp195_188[27] = 514;
    int[] tmp202_195 = tmp195_188;
    tmp202_195[28] = 375;
    int[] tmp209_202 = tmp202_195;
    tmp209_202[29] = 1302;
    int[] tmp216_209 = tmp209_202;
    tmp216_209[30] = 1313;
    int[] tmp223_216 = tmp216_209;
    tmp223_216[31] = 1317;
    int[] tmp230_223 = tmp223_216;
    tmp230_223[32] = 1321;
    int[] tmp237_230 = tmp230_223;
    tmp237_230[33] = 792;
    int[] tmp244_237 = tmp237_230;
    tmp244_237[34] = 1348;
    int[] tmp251_244 = tmp244_237;
    tmp251_244[35] = 1349;
    int[] tmp258_251 = tmp251_244;
    tmp258_251[36] = 1352;
    tmp258_251;
    Object localObject1 = u.b(this.x.h);
    ArrayList localArrayList = new ArrayList();
    util.LOGI("tgtgt getRequestBody start", "");
    oicq.wlogin_sdk.report.c.a(Thread.currentThread());
    long l4 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder("tgtgt getRequestBody");
    localStringBuilder.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
    long l3 = 0L;
    long l2 = l3;
    int k = 0;
    int i = 0;
    Object localObject2;
    for (;;)
    {
      int j = paramInt4;
      byte[] arrayOfByte3 = paramArrayOfByte6;
      byte[] arrayOfByte2 = paramArrayOfByte7;
      Object localObject5 = paramList;
      localObject2 = paramWUserSigInfo;
      Object localObject4 = this;
      if (k >= 37) {
        break;
      }
      int m = tmp25_21[k];
      byte[] arrayOfByte1 = null;
      switch (m)
      {
      default: 
        break;
      case 1352: 
        if ((u.ao != null) && (u.ao.length > 0))
        {
          localObject3 = new tlv_t548().get_tlv_548(u.ao);
          localObject2 = arrayOfByte1;
          if (localObject3 != null)
          {
            localObject2 = arrayOfByte1;
            if (localObject3.length > 0) {
              localObject2 = localObject3;
            }
          }
          localObject4 = new StringBuilder("t548_data ");
          if (localObject3 == null) {
            j = 0;
          } else {
            j = localObject3.length;
          }
          localObject3 = localObject4;
        }
        break;
      case 1349: 
        if ((u.U == null) || (u.U.length == 0)) {
          u.U = util.get_qimei(u.u);
        }
        if ((u.U != null) && (u.U.length > 0))
        {
          localObject2 = new tlv_t545().get_tlv_545(u.U);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(util.LOG_TAG_QIMEI);
          ((StringBuilder)localObject4).append("tgtgt qimei len =");
          ((StringBuilder)localObject4).append(u.U.length);
          util.LOGI(((StringBuilder)localObject4).toString(), String.valueOf(paramLong3));
          break label2887;
        }
        oicq.wlogin_sdk.report.event.c.a(new b("wtlogin_qimei_error", "tgtgt_error", "").a(String.valueOf(paramLong3)));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(util.LOG_TAG_QIMEI);
        ((StringBuilder)localObject2).append("tgtgt qimei = null ");
        util.LOGI(((StringBuilder)localObject2).toString(), String.valueOf(paramLong3));
        break;
      case 1348: 
        l3 = System.currentTimeMillis();
        localObject2 = "6.0.0.2484".getBytes();
        localObject3 = new byte[u.B.length + 10 + 2 + localObject2.length + 4];
        util.int64_to_buf((byte[])localObject3, 0, (int)l1);
        util.int16_to_buf((byte[])localObject3, 4, u.B.length);
        System.arraycopy(u.B, 0, localObject3, 6, u.B.length);
        j = u.B.length + 6;
        util.int16_to_buf((byte[])localObject3, j, localObject2.length);
        j += 2;
        System.arraycopy(localObject2, 0, localObject3, j, localObject2.length);
        util.int32_to_buf((byte[])localObject3, j + localObject2.length, ((m)localObject4).u);
        localObject2 = new tlv_t544().get_tlv_544(String.valueOf(paramLong3), "810_9", (byte[])localObject3);
        l2 = System.currentTimeMillis();
        localObject3 = new StringBuilder("tgt 0x544 cost:");
        ((StringBuilder)localObject3).append(l2 - l3);
        util.LOGI(((StringBuilder)localObject3).toString(), String.valueOf(paramLong3));
        localObject3 = paramArrayOfByte8;
        break;
      case 1317: 
        localObject3 = paramArrayOfByte8;
        break;
      case 1313: 
        localObject2 = new tlv_t(1313);
        localObject3 = new byte[6];
        util.int32_to_buf((byte[])localObject3, 0, u.aA);
        util.int16_to_buf((byte[])localObject3, 4, 0);
        ((tlv_t)localObject2).set_data((byte[])localObject3, 6);
        localObject2 = ((tlv_t)localObject2).get_buf();
        localObject3 = paramArrayOfByte8;
        break;
      case 1302: 
        localObject3 = new tlv_t(1302);
        localObject4 = new byte[4];
        util.int32_to_buf((byte[])localObject4, 0, ((WUserSigInfo)localObject2)._source_type);
        ((tlv_t)localObject3).set_data((byte[])localObject4, 4);
        localObject2 = ((tlv_t)localObject3).get_buf();
        localObject3 = paramArrayOfByte8;
        break;
      case 1297: 
        if ((localObject5 != null) && (paramList.size() != 0))
        {
          localObject2 = new tlv_t511().get_tlv_511((List)localObject5);
          localObject3 = paramArrayOfByte8;
          break label2887;
        }
        localObject3 = paramArrayOfByte8;
        break;
      case 1024: 
        localObject2 = ((m)localObject4).x.a(l1, paramLong1);
        if ((localObject2 != null) && (((WloginSigInfo)localObject2)._G != null) && (((WloginSigInfo)localObject2)._G.length != 0))
        {
          if ((((WloginSigInfo)localObject2)._dpwd != null) && (((WloginSigInfo)localObject2)._dpwd.length != 0))
          {
            if ((((WloginSigInfo)localObject2)._randseed != null) && (((WloginSigInfo)localObject2)._randseed.length != 0))
            {
              localObject2 = new tlv_t400().get_tlv_400(((WloginSigInfo)localObject2)._G, paramLong3, u.B, ((WloginSigInfo)localObject2)._dpwd, paramLong1, paramLong2, ((WloginSigInfo)localObject2)._randseed);
              l1 = paramLong3;
              localObject3 = paramArrayOfByte8;
              break label2887;
            }
            l1 = paramLong3;
            localObject3 = paramArrayOfByte8;
          }
          else
          {
            l1 = paramLong3;
            localObject3 = paramArrayOfByte8;
          }
        }
        else
        {
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
        }
        break;
      case 792: 
        if ((((async_context)localObject1).tgtQR != null) && (((async_context)localObject1).tgtQR.length != 0))
        {
          localObject2 = new tlv_t(792);
          ((tlv_t)localObject2).set_data(((async_context)localObject1).tgtQR, ((async_context)localObject1).tgtQR.length);
          localObject2 = ((tlv_t)localObject2).get_buf();
          localObject3 = new StringBuilder("tgtQR len ");
          ((StringBuilder)localObject3).append(((async_context)localObject1).tgtQR.length);
          util.LOGI(((StringBuilder)localObject3).toString(), String.valueOf(paramLong3));
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
          break label2887;
        }
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 514: 
        if ((u.S != null) && (u.S.length != 0))
        {
          localObject2 = new tlv_t202().get_tlv_202(u.S, u.T);
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
          break label2887;
        }
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 513: 
        localObject2 = L;
        if ((localObject2 != null) && (localObject2.length != 0))
        {
          localObject2 = new tlv_t201().get_tlv_201(L, M, "qq".getBytes(), N);
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
          break label2887;
        }
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 404: 
        if ((u.M != null) && (u.M.length != 0))
        {
          localObject2 = new tlv_t194().get_tlv_194(u.M);
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
          break label2887;
        }
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 401: 
        localObject2 = new tlv_t191().get_tlv_191(K);
        localObject3 = new StringBuilder("request_TGTGT canWebVerify");
        j = K;
        ((StringBuilder)localObject3).append(j);
        util.LOGI(((StringBuilder)localObject3).toString(), "");
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 392: 
        if ((u.P != null) && (u.P.length != 0))
        {
          localObject2 = new tlv_t188().get_tlv_188(u.P);
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
          break label2887;
        }
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 391: 
        if ((u.O != null) && (u.O.length != 0))
        {
          localObject2 = new tlv_t187().get_tlv_187(u.O);
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
          break label2887;
        }
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 389: 
        if (paramInt3 == 3)
        {
          localObject2 = new tlv_t185().get_tlv_185(1);
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
          break label2887;
        }
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 375: 
        localObject2 = new tlv_t177().get_tlv_177(1630563984L, "6.0.0.2484");
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 370: 
        if ((((m)localObject4).x.s != null) && (((m)localObject4).x.s.length != 0))
        {
          localObject2 = new tlv_t172().get_tlv_172(((m)localObject4).x.s);
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
          break label2887;
        }
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 362: 
        if ((arrayOfByte3 != null) && (arrayOfByte3.length != 0))
        {
          localObject2 = new tlv_t16a().get_tlv_16a(arrayOfByte3);
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
          break label2887;
        }
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 358: 
        if ((j & 0x80) != 0)
        {
          localObject2 = new tlv_t166().get_tlv_166(u.y);
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
          break label2887;
        }
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 340: 
        localObject2 = new tlv_t154().get_tlv_154(((m)localObject4).x.i);
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 327: 
        localObject2 = new tlv_t147().get_tlv_147(paramLong1, u.H, u.I);
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 325: 
        localObject2 = new tlv_t145().get_tlv_145(u.B);
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 324: 
        localObject2 = new tlv_t109().get_tlv_109(u.P);
        localObject3 = new tlv_t52d().get_tlv_52d(((m)localObject4).a);
        localObject4 = new tlv_t124();
        arrayOfByte1 = util.get_os_type();
        localObject5 = util.get_os_version();
        j = u.E;
        arrayOfByte2 = u.D;
        arrayOfByte3 = u.G;
        localObject4 = ((tlv_t124)localObject4).get_tlv_124(arrayOfByte1, (byte[])localObject5, j, arrayOfByte2, new byte[0], arrayOfByte3);
        arrayOfByte1 = new tlv_t128().get_tlv_128(u.V, u.W, u.X, u.aa, u.J, u.B, u.Q);
        localObject5 = new tlv_t16e().get_tlv_16e(u.J);
        localObject2 = new tlv_t144().get_tlv_144((byte[])localObject2, (byte[])localObject3, (byte[])localObject4, arrayOfByte1, (byte[])localObject5, ((async_context)localObject1)._tgtgt_key);
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 322: 
        localObject2 = new tlv_t142().get_tlv_142(paramArrayOfByte9);
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 321: 
        localObject2 = new tlv_t141().get_tlv_141(u.D, u.E, u.G);
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 278: 
        localObject2 = new tlv_t116().get_tlv_116(j, paramInt5, paramArrayOfLong);
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 274: 
        if ((((m)localObject4).x.g != null) && (!util.check_uin_account(((m)localObject4).x.g).booleanValue()))
        {
          localObject2 = new tlv_t112().get_tlv_112(((m)localObject4).x.g.getBytes());
          localStringBuilder.append(",0x404 = ");
          localStringBuilder.append(((m)localObject4).x.g);
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
          break label2887;
        }
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 264: 
        if ((arrayOfByte2 != null) && (arrayOfByte2.length != 0))
        {
          localObject2 = new tlv_t108().get_tlv_108(arrayOfByte2);
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
          break label2887;
        }
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 263: 
        localObject2 = new tlv_t107().get_tlv_107(paramInt7, paramInt8, paramInt9, paramInt10);
        l1 = paramLong3;
        localObject3 = paramArrayOfByte8;
        break;
      case 262: 
        localObject2 = new tlv_t106();
        if ((paramArrayOfByte5 != null) && (paramArrayOfByte5.length > 0))
        {
          ((tlv_t106)localObject2).set_data(paramArrayOfByte5, paramArrayOfByte5.length);
          localObject2 = ((tlv_t106)localObject2).get_buf();
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
        }
        else
        {
          l1 = ((async_context)localObject1)._msalt;
          localObject3 = ((m)localObject4).x.g.getBytes();
          localObject2 = ((tlv_t106)localObject2).get_tlv_106(paramLong1, paramLong2, paramInt1, paramLong3, paramArrayOfByte2, paramArrayOfByte1, 1, paramArrayOfByte3, l1, (byte[])localObject3, paramArrayOfByte4, u.W, u.B, paramInt3);
          l1 = paramLong3;
          localObject3 = paramArrayOfByte8;
        }
        break;
      case 260: 
        localObject4 = localObject1;
        if ((localObject3 != null) && (localObject3.length != 0))
        {
          localObject2 = new tlv_t104().get_tlv_104((byte[])localObject3);
          l1 = paramLong3;
          localObject1 = localObject4;
          break label2887;
        }
        l1 = paramLong3;
        break;
      case 256: 
        localObject2 = new tlv_t100().get_tlv_100(paramLong1, paramLong4, paramInt1, paramInt6);
        l1 = paramLong3;
        break;
      case 24: 
        localObject2 = new tlv_t18().get_tlv_18(paramLong1, paramInt1, paramLong3, paramInt2);
        l1 = paramLong3;
        break;
      case 8: 
        localObject2 = new tlv_t8().get_tlv_8(0, u.v, 0);
        l1 = paramLong3;
        break;
      }
      localObject2 = new tlv_t1();
      l1 = paramLong3;
      localObject2 = ((tlv_t1)localObject2).get_tlv_1(l1, paramArrayOfByte1);
      break label2887;
      localObject2 = null;
      label2887:
      if (localObject2 != null)
      {
        localArrayList.add(localObject2);
        i += localObject2.length;
      }
      k += 1;
    }
    paramArrayOfByte1 = ((WUserSigInfo)localObject2).extraLoginTLVMap.keySet().iterator();
    while (paramArrayOfByte1.hasNext())
    {
      paramArrayOfByte2 = (Integer)paramArrayOfByte1.next();
      paramArrayOfByte3 = ((tlv_t)((WUserSigInfo)localObject2).extraLoginTLVMap.get(paramArrayOfByte2)).get_buf();
      localArrayList.add(paramArrayOfByte3);
      i += paramArrayOfByte3.length;
      paramArrayOfByte4 = new StringBuilder("Extra Tlv from user：0x");
      paramArrayOfByte4.append(paramArrayOfByte2);
      paramArrayOfByte4.append(" len:");
      if (paramArrayOfByte3 != null) {
        paramInt1 = paramArrayOfByte3.length;
      } else {
        paramInt1 = 0;
      }
      paramArrayOfByte4.append(paramInt1);
      localStringBuilder.append(paramArrayOfByte4.toString());
    }
    util.LOGI(localStringBuilder.toString());
    paramArrayOfByte1 = new byte[i];
    paramInt3 = localArrayList.size();
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < paramInt3)
    {
      paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, paramArrayOfByte2.length);
      paramInt2 += paramArrayOfByte2.length;
      paramInt1 += 1;
    }
    paramLong1 = System.currentTimeMillis();
    a.a().a(1, paramLong1 - l4, l2 - l3, 0L);
    oicq.wlogin_sdk.report.c.b(Thread.currentThread());
    return b(paramArrayOfByte1, this.u, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.m
 * JD-Core Version:    0.7.0.1
 */