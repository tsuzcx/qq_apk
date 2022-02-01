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
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class m
  extends oicq_request
{
  public m(t paramt)
  {
    this.t = 2064;
    this.u = 13;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte3, long paramLong4, long paramLong5, long paramLong6, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, WUserSigInfo paramWUserSigInfo)
  {
    int k = t.w;
    paramArrayOfByte1 = c(paramArrayOfByte1);
    if (paramArrayOfByte1 == null) {
      return -1014;
    }
    paramInt1 = 0;
    for (;;)
    {
      int i = paramInt1;
      Object localObject = a(paramLong1, paramLong2, paramLong3, k, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt3, paramInt4, paramArrayOfLong, t.aa, paramArrayOfByte3, paramLong4, paramLong5, paramLong6, paramArrayOfByte4, paramArrayOfByte5);
      a(this.i, this.t, this.j, paramLong1, this.m, this.n, k, this.p, (byte[])localObject);
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
      if (i > 0) {
        return j;
      }
    }
    return paramInt1;
  }
  
  public byte[] a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, long paramLong4, long paramLong5, long paramLong6, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
  {
    Object localObject10 = new tlv_t106();
    tlv_t144 localtlv_t144 = new tlv_t144();
    Object localObject11 = new tlv_t100();
    Object localObject3 = new tlv_t108();
    Object localObject12 = new tlv_t116();
    Object localObject1 = new tlv_t112();
    Object localObject13 = new tlv_t142();
    Object localObject15 = new tlv_t145();
    tlv_t16a localtlv_t16a = new tlv_t16a();
    Object localObject7 = new tlv_t18();
    Object localObject6 = new tlv_t141();
    Object localObject4 = new tlv_t8();
    Object localObject17 = new tlv_t109();
    Object localObject16 = new tlv_t124();
    Object localObject14 = new tlv_t128();
    Object localObject5 = new tlv_t147();
    tlv_t148 localtlv_t148 = new tlv_t148();
    tlv_t153 localtlv_t153 = new tlv_t153();
    tlv_t16e localtlv_t16e = new tlv_t16e();
    Object localObject20 = new tlv_t172();
    Object localObject2 = new tlv_t177();
    Object localObject8 = new tlv_t187();
    Object localObject9 = new tlv_t188();
    Object localObject19 = new tlv_t194();
    Object localObject18 = new tlv_t202();
    ((tlv_t106)localObject10).set_data(paramArrayOfByte1, paramArrayOfByte1.length);
    localObject10 = ((tlv_t106)localObject10).get_buf();
    localObject11 = ((tlv_t100)localObject11).get_tlv_100(paramLong5, paramLong6, paramInt1, paramInt2);
    localObject12 = ((tlv_t116)localObject12).get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
    localObject13 = ((tlv_t142)localObject13).get_tlv_142(t.E);
    localObject15 = ((tlv_t145)localObject15).get_tlv_145(t.A);
    byte[] arrayOfByte1 = ((tlv_t18)localObject7).get_tlv_18(paramLong2, paramInt1, paramLong1, 0);
    byte[] arrayOfByte2 = ((tlv_t141)localObject6).get_tlv_141(t.C, t.D, t.F);
    localObject4 = ((tlv_t8)localObject4).get_tlv_8(0, t.u, 0);
    localObject7 = ((tlv_t147)localObject5).get_tlv_147(paramLong2, t.G, t.H);
    localObject5 = ((tlv_t177)localObject2).get_tlv_177(1502965326L, "6.0.0.2202");
    localObject2 = new byte[0];
    localObject6 = new byte[0];
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
    {
      paramArrayOfByte3 = ((tlv_t108)localObject3).get_tlv_108(paramArrayOfByte3);
      paramInt1 = 11;
    }
    else
    {
      paramInt1 = 10;
      paramArrayOfByte3 = new byte[0];
    }
    localObject3 = this;
    if ((((m)localObject3).x.g != null) && (!util.check_uin_account(((m)localObject3).x.g).booleanValue()))
    {
      localObject1 = ((tlv_t112)localObject1).get_tlv_112(((m)localObject3).x.g.getBytes());
      paramInt1 += 1;
    }
    else
    {
      localObject1 = new byte[0];
    }
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0))
    {
      localObject2 = localtlv_t16a.get_tlv_16a(paramArrayOfByte2);
      paramInt1 += 1;
    }
    if ((((m)localObject3).x.r != null) && (((m)localObject3).x.r.length > 0))
    {
      paramArrayOfByte1 = ((tlv_t172)localObject20).get_tlv_172(((m)localObject3).x.r);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte1 = new byte[0];
    }
    if ((t.N != null) && (t.N.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t187)localObject8).get_tlv_187(t.N);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte2 = new byte[0];
    }
    localObject8 = paramArrayOfByte1;
    if ((t.O != null) && (t.O.length > 0))
    {
      paramArrayOfLong = ((tlv_t188)localObject9).get_tlv_188(t.O);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfLong = new byte[0];
    }
    localObject9 = paramArrayOfByte2;
    if ((t.L != null) && (t.L.length > 0))
    {
      paramArrayOfByte1 = ((tlv_t194)localObject19).get_tlv_194(t.L);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte1 = new byte[0];
    }
    if ((t.R != null) && (t.R.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t202)localObject18).get_tlv_202(t.R, t.S);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte2 = (byte[])localObject6;
    }
    localObject6 = ((tlv_t109)localObject17).get_tlv_109(t.M);
    localObject17 = util.get_os_type();
    localObject18 = util.get_os_version();
    paramInt2 = t.D;
    localObject19 = t.C;
    localObject20 = t.F;
    localObject16 = ((tlv_t124)localObject16).get_tlv_124((byte[])localObject17, (byte[])localObject18, paramInt2, (byte[])localObject19, new byte[0], (byte[])localObject20);
    localObject14 = ((tlv_t128)localObject14).get_tlv_128(t.T, t.U, t.V, 0, t.I, t.A, t.P);
    paramArrayOfByte4 = localtlv_t148.get_tlv_148(paramArrayOfByte4, paramLong4, paramLong5, paramLong6, paramArrayOfByte5, paramArrayOfByte6);
    paramArrayOfByte5 = localtlv_t153.get_tlv_153(t.Z);
    paramArrayOfByte6 = localtlv_t16e.get_tlv_16e(t.I);
    localObject3 = t.b(((m)localObject3).x.h)._tgtgt_key;
    paramArrayOfByte4 = localtlv_t144.get_tlv_144((byte[])localObject6, (byte[])localObject16, (byte[])localObject14, paramArrayOfByte4, new byte[0], paramArrayOfByte5, paramArrayOfByte6, (byte[])localObject3);
    paramArrayOfByte5 = new byte[localObject10.length + localObject11.length + paramArrayOfByte3.length + localObject12.length + localObject1.length + localObject13.length + localObject15.length + paramArrayOfByte4.length + localObject2.length + arrayOfByte1.length + arrayOfByte2.length + localObject4.length + localObject7.length + localObject8.length + localObject5.length + localObject9.length + paramArrayOfLong.length + paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(localObject10, 0, paramArrayOfByte5, 0, localObject10.length);
    paramInt2 = localObject10.length + 0;
    System.arraycopy(localObject11, 0, paramArrayOfByte5, paramInt2, localObject11.length);
    paramInt2 += localObject11.length;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt2, paramArrayOfByte3.length);
    paramInt2 += paramArrayOfByte3.length;
    System.arraycopy(localObject12, 0, paramArrayOfByte5, paramInt2, localObject12.length);
    paramInt2 += localObject12.length;
    System.arraycopy(localObject1, 0, paramArrayOfByte5, paramInt2, localObject1.length);
    paramInt2 += localObject1.length;
    System.arraycopy(localObject13, 0, paramArrayOfByte5, paramInt2, localObject13.length);
    paramInt2 += localObject13.length;
    System.arraycopy(localObject15, 0, paramArrayOfByte5, paramInt2, localObject15.length);
    paramInt2 += localObject15.length;
    System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt2, paramArrayOfByte4.length);
    paramInt2 += paramArrayOfByte4.length;
    System.arraycopy(localObject2, 0, paramArrayOfByte5, paramInt2, localObject2.length);
    paramInt2 += localObject2.length;
    System.arraycopy(arrayOfByte1, 0, paramArrayOfByte5, paramInt2, arrayOfByte1.length);
    paramInt2 += arrayOfByte1.length;
    System.arraycopy(arrayOfByte2, 0, paramArrayOfByte5, paramInt2, arrayOfByte2.length);
    paramInt2 += arrayOfByte2.length;
    System.arraycopy(localObject4, 0, paramArrayOfByte5, paramInt2, localObject4.length);
    paramInt2 += localObject4.length;
    System.arraycopy(localObject7, 0, paramArrayOfByte5, paramInt2, localObject7.length);
    paramInt2 += localObject7.length;
    System.arraycopy(localObject8, 0, paramArrayOfByte5, paramInt2, localObject8.length);
    paramInt2 += localObject8.length;
    System.arraycopy(localObject5, 0, paramArrayOfByte5, paramInt2, localObject5.length);
    paramInt2 += localObject5.length;
    System.arraycopy(localObject9, 0, paramArrayOfByte5, paramInt2, localObject9.length);
    paramInt2 += localObject9.length;
    System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte5, paramInt2, paramArrayOfLong.length);
    paramInt2 += paramArrayOfLong.length;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, paramInt2, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt2 + paramArrayOfByte1.length, paramArrayOfByte2.length);
    return b(paramArrayOfByte5, this.u, paramInt1 + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.m
 * JD-Core Version:    0.7.0.1
 */