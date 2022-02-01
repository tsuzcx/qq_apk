package oicq.wlogin_sdk.request;

import java.util.List;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t10a;
import oicq.wlogin_sdk.tlv_type.tlv_t112;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t124;
import oicq.wlogin_sdk.tlv_type.tlv_t128;
import oicq.wlogin_sdk.tlv_type.tlv_t141;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t143;
import oicq.wlogin_sdk.tlv_type.tlv_t144;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t147;
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t16e;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tlv_type.tlv_t177;
import oicq.wlogin_sdk.tlv_type.tlv_t18;
import oicq.wlogin_sdk.tlv_type.tlv_t187;
import oicq.wlogin_sdk.tlv_type.tlv_t188;
import oicq.wlogin_sdk.tlv_type.tlv_t194;
import oicq.wlogin_sdk.tlv_type.tlv_t201;
import oicq.wlogin_sdk.tlv_type.tlv_t202;
import oicq.wlogin_sdk.tlv_type.tlv_t511;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class n
  extends oicq_request
{
  public n(t paramt)
  {
    this.t = 2064;
    this.u = 10;
    this.v = "wtlogin.exchange_emp";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte2, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("start request_change_sig", String.valueOf(paramLong1));
    int k = t.w;
    paramInt2 &= 0xFDFFFFFF;
    t.b(this.x.h)._main_sigmap = paramInt2;
    paramInt1 = 0;
    for (;;)
    {
      int i = paramInt1;
      Object localObject = this;
      a(((n)localObject).i, ((n)localObject).t, ((n)localObject).j, paramLong1, ((n)localObject).m, ((n)localObject).n, k, ((n)localObject).p, a(paramLong1, paramLong2, paramLong3, k, paramInt2, paramArrayOfByte1, paramInt3, paramInt4, paramArrayOfLong, t.aa, paramArrayOfByte2, paramWUserSigInfo._domains));
      int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      paramInt1 = j;
      if (j != 0) {
        break;
      }
      j = b();
      localObject = new StringBuilder("retry num:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" ret:");
      ((StringBuilder)localObject).append(j);
      util.LOGI(((StringBuilder)localObject).toString(), String.valueOf(paramLong1));
      paramInt1 = j;
      if (j != 180) {
        break;
      }
      paramInt1 = i + 1;
      if (i > 0)
      {
        paramInt1 = j;
        break;
      }
    }
    util.LOGI("end request_change_sig for user ret ".concat(String.valueOf(paramInt1)), String.valueOf(paramLong1));
    return paramInt1;
  }
  
  public byte[] a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, List<String> paramList)
  {
    int i = this.u;
    Object localObject11 = new tlv_t100();
    Object localObject12 = new tlv_t10a();
    Object localObject13 = new tlv_t116();
    Object localObject1 = new tlv_t108();
    Object localObject17 = new tlv_t109();
    tlv_t124 localtlv_t124 = new tlv_t124();
    tlv_t128 localtlv_t128 = new tlv_t128();
    tlv_t143 localtlv_t143 = new tlv_t143();
    tlv_t112 localtlv_t112 = new tlv_t112();
    tlv_t144 localtlv_t144 = new tlv_t144();
    Object localObject4 = new tlv_t145();
    Object localObject3 = new tlv_t147();
    Object localObject14 = new tlv_t142();
    Object localObject15 = new tlv_t154();
    Object localObject16 = new tlv_t18();
    Object localObject6 = new tlv_t141();
    Object localObject5 = new tlv_t8();
    tlv_t511 localtlv_t511 = new tlv_t511();
    tlv_t16e localtlv_t16e = new tlv_t16e();
    Object localObject19 = new tlv_t172();
    Object localObject2 = new tlv_t177();
    Object localObject10 = new tlv_t187();
    Object localObject7 = new tlv_t188();
    Object localObject8 = new tlv_t194();
    Object localObject9 = new tlv_t201();
    Object localObject18 = new tlv_t202();
    localObject11 = ((tlv_t100)localObject11).get_tlv_100(paramLong2, paramLong3, paramInt1, paramInt2);
    localObject12 = ((tlv_t10a)localObject12).get_tlv_10a(paramArrayOfByte1);
    localObject13 = ((tlv_t116)localObject13).get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
    localObject4 = ((tlv_t145)localObject4).get_tlv_145(t.A);
    localObject14 = ((tlv_t142)localObject14).get_tlv_142(t.E);
    localObject15 = ((tlv_t154)localObject15).get_tlv_154(this.x.i);
    localObject16 = ((tlv_t18)localObject16).get_tlv_18(paramLong2, paramInt1, paramLong1, 0);
    byte[] arrayOfByte1 = ((tlv_t141)localObject6).get_tlv_141(t.C, t.D, t.F);
    byte[] arrayOfByte2 = ((tlv_t8)localObject5).get_tlv_8(0, t.u, 0);
    localObject5 = ((tlv_t147)localObject3).get_tlv_147(paramLong2, t.G, t.H);
    localObject6 = ((tlv_t177)localObject2).get_tlv_177(1502965326L, "6.0.0.2202");
    byte[] arrayOfByte3 = new byte[0];
    localObject2 = new byte[0];
    localObject3 = new byte[0];
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0))
    {
      localObject1 = ((tlv_t108)localObject1).get_tlv_108(paramArrayOfByte2);
      paramInt1 = 11;
    }
    else
    {
      localObject1 = new byte[0];
      paramInt1 = 10;
    }
    paramArrayOfByte1 = paramList;
    if ((paramArrayOfByte1 != null) && (paramList.size() > 0))
    {
      paramList = localtlv_t511.get_tlv_511(paramArrayOfByte1);
      paramInt1 += 1;
    }
    else
    {
      paramList = new byte[0];
    }
    if ((this.x.r != null) && (this.x.r.length > 0))
    {
      paramArrayOfByte1 = ((tlv_t172)localObject19).get_tlv_172(this.x.r);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte1 = new byte[0];
    }
    if ((t.N != null) && (t.N.length > 0))
    {
      paramArrayOfLong = ((tlv_t187)localObject10).get_tlv_187(t.N);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfLong = new byte[0];
    }
    if ((t.O != null) && (t.O.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t188)localObject7).get_tlv_188(t.O);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte2 = new byte[0];
    }
    localObject7 = paramArrayOfLong;
    if ((t.L != null) && (t.L.length > 0))
    {
      paramArrayOfLong = ((tlv_t194)localObject8).get_tlv_194(t.L);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfLong = new byte[0];
    }
    localObject8 = paramArrayOfByte2;
    if ((l.J != null) && (l.J.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t201)localObject9).get_tlv_201(l.J, l.K, "qq".getBytes(), l.L);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte2 = new byte[0];
    }
    localObject9 = paramArrayOfByte1;
    localObject10 = paramArrayOfLong;
    if ((t.R != null) && (t.R.length > 0))
    {
      paramArrayOfByte1 = ((tlv_t202)localObject18).get_tlv_202(t.R, t.S);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte1 = (byte[])localObject3;
    }
    paramArrayOfLong = ((tlv_t109)localObject17).get_tlv_109(t.M);
    localObject3 = util.get_os_type();
    localObject17 = util.get_os_version();
    paramInt2 = t.D;
    localObject18 = t.C;
    localObject19 = t.F;
    localObject3 = localtlv_t144.get_tlv_144(paramArrayOfLong, localtlv_t124.get_tlv_124((byte[])localObject3, (byte[])localObject17, paramInt2, (byte[])localObject18, new byte[0], (byte[])localObject19), localtlv_t128.get_tlv_128(t.T, t.U, t.V, t.Y, t.I, t.A, t.P), localtlv_t16e.get_tlv_16e(t.I), this.x.b);
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
    {
      paramArrayOfByte3 = localtlv_t143.get_tlv_143(paramArrayOfByte3);
      paramArrayOfLong = new byte[localObject11.length + localObject12.length + localObject13.length + localObject1.length + localObject3.length + paramArrayOfByte3.length + localObject14.length + localObject15.length + localObject16.length + arrayOfByte1.length + arrayOfByte2.length + paramList.length + localObject5.length + localObject9.length + localObject6.length + localObject7.length + localObject8.length + localObject10.length + paramArrayOfByte2.length + paramArrayOfByte1.length];
      System.arraycopy(localObject11, 0, paramArrayOfLong, 0, localObject11.length);
      paramInt2 = localObject11.length + 0;
      System.arraycopy(localObject12, 0, paramArrayOfLong, paramInt2, localObject12.length);
      paramInt2 += localObject12.length;
      System.arraycopy(localObject13, 0, paramArrayOfLong, paramInt2, localObject13.length);
      paramInt2 += localObject13.length;
      System.arraycopy(localObject1, 0, paramArrayOfLong, paramInt2, localObject1.length);
      paramInt2 += localObject1.length;
      System.arraycopy(localObject3, 0, paramArrayOfLong, paramInt2, localObject3.length);
      paramInt2 += localObject3.length;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfLong, paramInt2, paramArrayOfByte3.length);
      paramInt2 += paramArrayOfByte3.length;
      System.arraycopy(localObject14, 0, paramArrayOfLong, paramInt2, localObject14.length);
      paramInt2 += localObject14.length;
      System.arraycopy(localObject15, 0, paramArrayOfLong, paramInt2, localObject15.length);
      paramInt2 += localObject15.length;
      System.arraycopy(localObject16, 0, paramArrayOfLong, paramInt2, localObject16.length);
      paramInt2 += localObject16.length;
      System.arraycopy(arrayOfByte1, 0, paramArrayOfLong, paramInt2, arrayOfByte1.length);
      paramInt2 += arrayOfByte1.length;
      System.arraycopy(arrayOfByte2, 0, paramArrayOfLong, paramInt2, arrayOfByte2.length);
      paramInt2 += arrayOfByte2.length;
      System.arraycopy(paramList, 0, paramArrayOfLong, paramInt2, paramList.length);
      paramInt2 += paramList.length;
      System.arraycopy(localObject5, 0, paramArrayOfLong, paramInt2, localObject5.length);
      paramInt2 += localObject5.length;
      System.arraycopy(localObject9, 0, paramArrayOfLong, paramInt2, localObject9.length);
      paramInt2 += localObject9.length;
      System.arraycopy(localObject6, 0, paramArrayOfLong, paramInt2, localObject6.length);
      paramInt2 += localObject6.length;
      System.arraycopy(localObject7, 0, paramArrayOfLong, paramInt2, localObject7.length);
      paramInt2 += localObject7.length;
      System.arraycopy(localObject8, 0, paramArrayOfLong, paramInt2, localObject8.length);
      paramInt2 += localObject8.length;
      System.arraycopy(localObject10, 0, paramArrayOfLong, paramInt2, localObject10.length);
      paramInt2 += localObject10.length;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfLong, paramInt2, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfLong, paramInt2 + paramArrayOfByte2.length, paramArrayOfByte1.length);
      paramArrayOfByte1 = paramArrayOfLong;
      paramInt1 = paramInt1 + 1 + 1;
      paramInt2 = 11;
    }
    else
    {
      paramInt1 += 2;
      if ((this.x.g != null) && (!util.check_uin_account(this.x.g).booleanValue()))
      {
        paramArrayOfLong = localtlv_t112.get_tlv_112(this.x.g.getBytes());
        paramInt1 += 1;
      }
      else
      {
        paramArrayOfLong = (long[])localObject2;
      }
      paramArrayOfByte3 = new byte[localObject11.length + localObject12.length + localObject13.length + localObject1.length + localObject3.length + 0 + paramArrayOfLong.length + localObject4.length + localObject14.length + localObject15.length + localObject16.length + arrayOfByte1.length + arrayOfByte2.length + paramList.length + localObject5.length + localObject9.length + localObject6.length + localObject7.length + localObject8.length + localObject10.length + paramArrayOfByte2.length + paramArrayOfByte1.length];
      System.arraycopy(localObject11, 0, paramArrayOfByte3, 0, localObject11.length);
      paramInt2 = localObject11.length + 0;
      System.arraycopy(localObject12, 0, paramArrayOfByte3, paramInt2, localObject12.length);
      paramInt2 += localObject12.length;
      System.arraycopy(localObject13, 0, paramArrayOfByte3, paramInt2, localObject13.length);
      paramInt2 += localObject13.length;
      System.arraycopy(localObject1, 0, paramArrayOfByte3, paramInt2, localObject1.length);
      paramInt2 += localObject1.length;
      System.arraycopy(localObject3, 0, paramArrayOfByte3, paramInt2, localObject3.length);
      paramInt2 += localObject3.length;
      System.arraycopy(arrayOfByte3, 0, paramArrayOfByte3, paramInt2, 0);
      paramInt2 += 0;
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte3, paramInt2, paramArrayOfLong.length);
      paramInt2 += paramArrayOfLong.length;
      System.arraycopy(localObject4, 0, paramArrayOfByte3, paramInt2, localObject4.length);
      paramInt2 += localObject4.length;
      System.arraycopy(localObject14, 0, paramArrayOfByte3, paramInt2, localObject14.length);
      paramInt2 += localObject14.length;
      System.arraycopy(localObject15, 0, paramArrayOfByte3, paramInt2, localObject15.length);
      paramInt2 += localObject15.length;
      System.arraycopy(localObject16, 0, paramArrayOfByte3, paramInt2, localObject16.length);
      paramInt2 += localObject16.length;
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte3, paramInt2, arrayOfByte1.length);
      paramInt2 += arrayOfByte1.length;
      System.arraycopy(arrayOfByte2, 0, paramArrayOfByte3, paramInt2, arrayOfByte2.length);
      paramInt2 += arrayOfByte2.length;
      System.arraycopy(paramList, 0, paramArrayOfByte3, paramInt2, paramList.length);
      paramInt2 += paramList.length;
      System.arraycopy(localObject5, 0, paramArrayOfByte3, paramInt2, localObject5.length);
      paramInt2 += localObject5.length;
      System.arraycopy(localObject9, 0, paramArrayOfByte3, paramInt2, localObject9.length);
      paramInt2 += localObject9.length;
      System.arraycopy(localObject6, 0, paramArrayOfByte3, paramInt2, localObject6.length);
      paramInt2 += localObject6.length;
      System.arraycopy(localObject7, 0, paramArrayOfByte3, paramInt2, localObject7.length);
      paramInt2 += localObject7.length;
      System.arraycopy(localObject8, 0, paramArrayOfByte3, paramInt2, localObject8.length);
      paramInt2 += localObject8.length;
      System.arraycopy(localObject10, 0, paramArrayOfByte3, paramInt2, localObject10.length);
      paramInt2 += localObject10.length;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt2, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, paramInt2 + paramArrayOfByte2.length, paramArrayOfByte1.length);
      paramInt2 = i;
      paramArrayOfByte1 = paramArrayOfByte3;
    }
    return b(paramArrayOfByte1, paramInt2, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.n
 * JD-Core Version:    0.7.0.1
 */