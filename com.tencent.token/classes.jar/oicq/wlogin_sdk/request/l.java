package oicq.wlogin_sdk.request;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
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
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class l
  extends oicq_request
{
  public static int I;
  public static byte[] J = new byte[0];
  public static byte[] K = new byte[0];
  public static byte[] L = new byte[0];
  
  public l(t paramt, Context paramContext)
  {
    this.t = 2064;
    this.u = 9;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
    this.a = paramContext;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong4, int paramInt6, int paramInt7, int paramInt8, int paramInt9, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    int m = t.w;
    Object localObject = t.b(this.x.h);
    ((async_context)localObject)._tgtgt_key = util.get_rand_16byte(t.B);
    byte[] arrayOfByte = ((async_context)localObject)._tgtgt_key;
    localObject = ((async_context)localObject)._t104;
    if (localObject == null) {
      localObject = new tlv_t104();
    }
    int i = 0;
    for (;;)
    {
      int j = i;
      a(paramLong3, a(paramLong1, paramLong2, m, paramLong3, paramInt1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, arrayOfByte, paramInt2, null, null, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong4, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfByte4, ((tlv_t104)localObject).get_data(), t.E, paramWUserSigInfo._domains, paramWUserSigInfo), this.y);
      int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      i = k;
      if (k != 0) {
        break;
      }
      k = b();
      StringBuilder localStringBuilder = new StringBuilder("retry num:");
      localStringBuilder.append(j);
      localStringBuilder.append(" ret:");
      localStringBuilder.append(k);
      util.LOGI(localStringBuilder.toString(), String.valueOf(paramLong3));
      i = k;
      if (k != 180) {
        break;
      }
      i = j + 1;
      if (j > 0) {
        return k;
      }
    }
    return i;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, long[] paramArrayOfLong, int paramInt4, long paramLong4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    int m = t.w;
    tlv_t104 localtlv_t104 = t.b(this.x.h)._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    paramArrayOfByte2 = c(paramArrayOfByte2);
    if (paramArrayOfByte2 == null) {
      return -1014;
    }
    int i = 0;
    for (;;)
    {
      int j = i;
      Object localObject = a(paramLong1, paramLong2, m, paramLong3, paramInt1, paramArrayOfByte1, null, null, null, 0, paramArrayOfByte2, paramArrayOfByte3, paramInt2, paramInt3, paramArrayOfLong, paramInt4, paramLong4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfByte4, localtlv_t104.get_data(), t.E, paramWUserSigInfo._domains, paramWUserSigInfo);
      a(this.i, this.t, this.j, paramLong3, this.m, this.n, m, this.p, (byte[])localObject);
      int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      i = k;
      if (k != 0) {
        break;
      }
      k = b();
      localObject = new StringBuilder("retry num:");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" ret:");
      ((StringBuilder)localObject).append(k);
      util.LOGI(((StringBuilder)localObject).toString(), String.valueOf(paramLong3));
      i = k;
      if (k != 180) {
        break;
      }
      i = j + 1;
      if (j > 0) {
        return k;
      }
    }
    return i;
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt3, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, int paramInt4, int paramInt5, long[] paramArrayOfLong, int paramInt6, long paramLong4, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, List<String> paramList, WUserSigInfo paramWUserSigInfo)
  {
    long l = paramLong3;
    Object localObject2 = paramArrayOfByte8;
    int[] arrayOfInt = new int[33];
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
    tmp230_223[32] = 792;
    tmp230_223;
    async_context localasync_context = t.b(this.x.h);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    for (;;)
    {
      byte[] arrayOfByte1 = paramArrayOfByte5;
      int k = paramInt4;
      byte[] arrayOfByte3 = paramArrayOfByte6;
      byte[] arrayOfByte2 = paramArrayOfByte7;
      Object localObject3 = paramList;
      Object localObject1 = this;
      if (i >= 33) {
        break;
      }
      switch (tmp16_14[i])
      {
      default: 
        break;
      case 1317: 
        break;
      case 1313: 
        localObject1 = new tlv_t(1313);
        arrayOfByte1 = new byte[6];
        util.int32_to_buf(arrayOfByte1, 0, t.au);
        util.int16_to_buf(arrayOfByte1, 4, 0);
        ((tlv_t)localObject1).set_data(arrayOfByte1, 6);
        localObject1 = ((tlv_t)localObject1).get_buf();
        break;
      case 1302: 
        localObject1 = new tlv_t(1302);
        arrayOfByte1 = new byte[4];
        util.int32_to_buf(arrayOfByte1, 0, paramWUserSigInfo._source_type);
        ((tlv_t)localObject1).set_data(arrayOfByte1, 4);
        localObject1 = ((tlv_t)localObject1).get_buf();
        break;
      case 1297: 
        if ((localObject3 != null) && (paramList.size() != 0))
        {
          localObject1 = new tlv_t511().get_tlv_511((List)localObject3);
          break label2221;
        }
        break;
      case 1024: 
        localObject1 = ((l)localObject1).x.a(l, paramLong1);
        if ((localObject1 != null) && (((WloginSigInfo)localObject1)._G != null) && (((WloginSigInfo)localObject1)._G.length != 0))
        {
          if ((((WloginSigInfo)localObject1)._dpwd != null) && (((WloginSigInfo)localObject1)._dpwd.length != 0))
          {
            if ((((WloginSigInfo)localObject1)._randseed != null) && (((WloginSigInfo)localObject1)._randseed.length != 0))
            {
              localObject1 = new tlv_t400().get_tlv_400(((WloginSigInfo)localObject1)._G, paramLong3, t.A, ((WloginSigInfo)localObject1)._dpwd, paramLong1, paramLong2, ((WloginSigInfo)localObject1)._randseed);
              l = paramLong3;
              localObject2 = paramArrayOfByte8;
              break label2221;
            }
            l = paramLong3;
            localObject2 = paramArrayOfByte8;
          }
          else
          {
            l = paramLong3;
            localObject2 = paramArrayOfByte8;
          }
        }
        else
        {
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
        }
        break;
      case 792: 
        if ((localasync_context.tgtQR != null) && (localasync_context.tgtQR.length != 0))
        {
          localObject1 = new tlv_t(792);
          ((tlv_t)localObject1).set_data(localasync_context.tgtQR, localasync_context.tgtQR.length);
          localObject1 = ((tlv_t)localObject1).get_buf();
          localObject2 = new StringBuilder("tgtQR len ");
          ((StringBuilder)localObject2).append(localasync_context.tgtQR.length);
          util.LOGI(((StringBuilder)localObject2).toString(), String.valueOf(paramLong3));
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
          break label2221;
        }
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 514: 
        if ((t.R != null) && (t.R.length != 0))
        {
          localObject1 = new tlv_t202().get_tlv_202(t.R, t.S);
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
          break label2221;
        }
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 513: 
        localObject1 = J;
        if ((localObject1 != null) && (localObject1.length != 0))
        {
          localObject1 = new tlv_t201().get_tlv_201(J, K, "qq".getBytes(), L);
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
          break label2221;
        }
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 404: 
        if ((t.L != null) && (t.L.length != 0))
        {
          localObject1 = new tlv_t194().get_tlv_194(t.L);
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
          break label2221;
        }
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 401: 
        localObject1 = new tlv_t191().get_tlv_191(I);
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 392: 
        if ((t.O != null) && (t.O.length != 0))
        {
          localObject1 = new tlv_t188().get_tlv_188(t.O);
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
          break label2221;
        }
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 391: 
        if ((t.N != null) && (t.N.length != 0))
        {
          localObject1 = new tlv_t187().get_tlv_187(t.N);
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
          break label2221;
        }
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 389: 
        if (paramInt3 == 3)
        {
          localObject1 = new tlv_t185().get_tlv_185(1);
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
          break label2221;
        }
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 375: 
        localObject1 = new tlv_t177().get_tlv_177(1502965326L, "6.0.0.2202");
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 370: 
        if ((((l)localObject1).x.r != null) && (((l)localObject1).x.r.length != 0))
        {
          localObject1 = new tlv_t172().get_tlv_172(((l)localObject1).x.r);
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
          break label2221;
        }
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 362: 
        if ((arrayOfByte3 != null) && (arrayOfByte3.length != 0))
        {
          localObject1 = new tlv_t16a().get_tlv_16a(arrayOfByte3);
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
          break label2221;
        }
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 358: 
        if ((k & 0x80) != 0)
        {
          localObject1 = new tlv_t166().get_tlv_166(t.x);
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
          break label2221;
        }
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 340: 
        localObject1 = new tlv_t154().get_tlv_154(((l)localObject1).x.i);
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 327: 
        localObject1 = new tlv_t147().get_tlv_147(paramLong1, t.G, t.H);
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 325: 
        localObject1 = new tlv_t145().get_tlv_145(t.A);
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 324: 
        localObject1 = new tlv_t109().get_tlv_109(t.M);
        localObject2 = new tlv_t124();
        arrayOfByte1 = util.get_os_type();
        localObject3 = util.get_os_version();
        k = t.D;
        arrayOfByte2 = t.C;
        arrayOfByte3 = t.F;
        localObject2 = ((tlv_t124)localObject2).get_tlv_124(arrayOfByte1, (byte[])localObject3, k, arrayOfByte2, new byte[0], arrayOfByte3);
        arrayOfByte1 = new tlv_t128().get_tlv_128(t.T, t.U, t.V, t.Y, t.I, t.A, t.P);
        localObject3 = new tlv_t16e().get_tlv_16e(t.I);
        localObject1 = new tlv_t144().get_tlv_144((byte[])localObject1, (byte[])localObject2, arrayOfByte1, (byte[])localObject3, localasync_context._tgtgt_key);
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 322: 
        localObject1 = new tlv_t142().get_tlv_142(paramArrayOfByte9);
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 321: 
        localObject1 = new tlv_t141().get_tlv_141(t.C, t.D, t.F);
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 278: 
        localObject1 = new tlv_t116().get_tlv_116(k, paramInt5, paramArrayOfLong);
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 274: 
        if ((((l)localObject1).x.g != null) && (!util.check_uin_account(((l)localObject1).x.g).booleanValue()))
        {
          localObject1 = new tlv_t112().get_tlv_112(((l)localObject1).x.g.getBytes());
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
          break label2221;
        }
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 264: 
        if ((arrayOfByte2 != null) && (arrayOfByte2.length != 0))
        {
          localObject1 = new tlv_t108().get_tlv_108(arrayOfByte2);
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
          break label2221;
        }
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 263: 
        localObject1 = new tlv_t107().get_tlv_107(paramInt7, paramInt8, paramInt9, paramInt10);
        l = paramLong3;
        localObject2 = paramArrayOfByte8;
        break;
      case 262: 
        localObject2 = new tlv_t106();
        if ((arrayOfByte1 != null) && (arrayOfByte1.length > 0))
        {
          ((tlv_t106)localObject2).set_data(arrayOfByte1, arrayOfByte1.length);
          localObject1 = ((tlv_t106)localObject2).get_buf();
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
        }
        else
        {
          localObject1 = ((tlv_t106)localObject2).get_tlv_106(paramLong1, paramLong2, paramInt1, paramLong3, paramArrayOfByte2, paramArrayOfByte1, 1, paramArrayOfByte3, localasync_context._msalt, ((l)localObject1).x.g.getBytes(), paramArrayOfByte4, t.U, t.A, paramInt3);
          l = paramLong3;
          localObject2 = paramArrayOfByte8;
        }
        break;
      case 260: 
        if ((localObject2 != null) && (localObject2.length != 0))
        {
          localObject1 = new tlv_t104().get_tlv_104((byte[])localObject2);
          l = paramLong3;
          break label2221;
        }
        l = paramLong3;
        break;
      case 256: 
        localObject1 = new tlv_t100().get_tlv_100(paramLong1, paramLong4, paramInt1, paramInt6);
        l = paramLong3;
        break;
      case 24: 
        localObject1 = new tlv_t18().get_tlv_18(paramLong1, paramInt1, paramLong3, paramInt2);
        l = paramLong3;
        break;
      case 8: 
        localObject1 = new tlv_t8().get_tlv_8(0, t.u, 0);
        l = paramLong3;
        break;
      case 1: 
        localObject1 = new tlv_t1();
        l = paramLong3;
        localObject1 = ((tlv_t1)localObject1).get_tlv_1(l, paramArrayOfByte1);
        break;
      }
      localObject1 = null;
      label2221:
      if (localObject1 != null)
      {
        localArrayList.add(localObject1);
        j += localObject1.length;
      }
      i += 1;
    }
    paramArrayOfByte1 = new byte[j];
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
    return b(paramArrayOfByte1, this.u, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.l
 * JD-Core Version:    0.7.0.1
 */