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
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class o
  extends oicq_request
{
  public o(u paramu)
  {
    this.t = 2064;
    this.u = 10;
    this.v = "wtlogin.exchange_emp";
    this.x = paramu;
    this.x.m = 0;
    this.a = this.x.h();
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte2, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("start request_change_sig", String.valueOf(paramLong1));
    int k = u.x;
    paramInt2 &= 0xFDFFFFFF;
    u.b(this.x.h)._main_sigmap = paramInt2;
    paramInt1 = 0;
    for (;;)
    {
      int i = paramInt1;
      Object localObject = this;
      a(((o)localObject).i, ((o)localObject).t, ((o)localObject).j, paramLong1, ((o)localObject).m, ((o)localObject).n, k, ((o)localObject).p, a(paramLong1, paramLong2, paramLong3, k, paramInt2, paramArrayOfByte1, paramInt3, paramInt4, paramArrayOfLong, u.ad, paramArrayOfByte2, paramWUserSigInfo._domains));
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
    Object localObject9 = new tlv_t100();
    Object localObject10 = new tlv_t10a();
    Object localObject11 = new tlv_t116();
    Object localObject1 = new tlv_t108();
    Object localObject18 = new tlv_t109();
    Object localObject17 = new tlv_t52d();
    Object localObject16 = new tlv_t124();
    tlv_t128 localtlv_t128 = new tlv_t128();
    tlv_t143 localtlv_t143 = new tlv_t143();
    tlv_t112 localtlv_t112 = new tlv_t112();
    tlv_t144 localtlv_t144 = new tlv_t144();
    Object localObject13 = new tlv_t145();
    Object localObject3 = new tlv_t147();
    Object localObject12 = new tlv_t142();
    Object localObject14 = new tlv_t154();
    Object localObject15 = new tlv_t18();
    Object localObject6 = new tlv_t141();
    Object localObject4 = new tlv_t8();
    tlv_t511 localtlv_t511 = new tlv_t511();
    tlv_t16e localtlv_t16e = new tlv_t16e();
    tlv_t172 localtlv_t172 = new tlv_t172();
    Object localObject2 = new tlv_t177();
    Object localObject20 = new tlv_t187();
    Object localObject8 = new tlv_t188();
    Object localObject5 = new tlv_t194();
    Object localObject7 = new tlv_t201();
    Object localObject19 = new tlv_t202();
    tlv_t544 localtlv_t544 = new tlv_t544();
    localObject9 = ((tlv_t100)localObject9).get_tlv_100(paramLong2, paramLong3, paramInt1, paramInt2);
    localObject10 = ((tlv_t10a)localObject10).get_tlv_10a(paramArrayOfByte1);
    localObject11 = ((tlv_t116)localObject11).get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
    localObject13 = ((tlv_t145)localObject13).get_tlv_145(u.B);
    localObject12 = ((tlv_t142)localObject12).get_tlv_142(u.F);
    localObject14 = ((tlv_t154)localObject14).get_tlv_154(this.x.i);
    localObject15 = ((tlv_t18)localObject15).get_tlv_18(paramLong2, paramInt1, paramLong1, 0);
    byte[] arrayOfByte1 = ((tlv_t141)localObject6).get_tlv_141(u.D, u.E, u.G);
    byte[] arrayOfByte2 = ((tlv_t8)localObject4).get_tlv_8(0, u.v, 0);
    byte[] arrayOfByte3 = ((tlv_t147)localObject3).get_tlv_147(paramLong2, u.H, u.I);
    localObject6 = ((tlv_t177)localObject2).get_tlv_177(1630563984L, "6.0.0.2484");
    byte[] arrayOfByte4 = new byte[0];
    localObject3 = new byte[0];
    paramArrayOfByte1 = new byte[0];
    paramArrayOfLong = new byte[0];
    localObject4 = new byte[0];
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0))
    {
      localObject1 = ((tlv_t108)localObject1).get_tlv_108(paramArrayOfByte2);
      paramInt2 = 11;
    }
    else
    {
      localObject1 = new byte[0];
      paramInt2 = 10;
    }
    paramArrayOfByte2 = paramList;
    localObject2 = paramArrayOfByte1;
    paramInt1 = paramInt2;
    if (paramArrayOfByte2 != null)
    {
      localObject2 = paramArrayOfByte1;
      paramInt1 = paramInt2;
      if (paramList.size() > 0)
      {
        localObject2 = localtlv_t511.get_tlv_511(paramArrayOfByte2);
        paramInt1 = paramInt2 + 1;
      }
    }
    paramArrayOfByte1 = paramArrayOfLong;
    paramInt2 = paramInt1;
    if (this.x.s != null)
    {
      paramArrayOfByte1 = paramArrayOfLong;
      paramInt2 = paramInt1;
      if (this.x.s.length > 0)
      {
        paramArrayOfByte1 = localtlv_t172.get_tlv_172(this.x.s);
        paramInt2 = paramInt1 + 1;
      }
    }
    if ((u.O != null) && (u.O.length > 0))
    {
      paramArrayOfLong = ((tlv_t187)localObject20).get_tlv_187(u.O);
      paramInt2 += 1;
    }
    else
    {
      paramArrayOfLong = new byte[0];
    }
    if ((u.P != null) && (u.P.length > 0))
    {
      paramList = ((tlv_t188)localObject8).get_tlv_188(u.P);
      paramInt2 += 1;
    }
    else
    {
      paramList = new byte[0];
    }
    if ((u.M != null) && (u.M.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t194)localObject5).get_tlv_194(u.M);
      paramInt2 += 1;
    }
    else
    {
      paramArrayOfByte2 = new byte[0];
    }
    localObject5 = paramList;
    if ((m.L != null) && (m.L.length > 0))
    {
      paramList = ((tlv_t201)localObject7).get_tlv_201(m.L, m.M, "qq".getBytes(), m.N);
      paramInt2 += 1;
    }
    else
    {
      paramList = new byte[0];
    }
    localObject7 = paramArrayOfByte1;
    localObject8 = paramArrayOfLong;
    if ((u.S != null) && (u.S.length > 0))
    {
      paramArrayOfByte1 = ((tlv_t202)localObject19).get_tlv_202(u.S, u.T);
      paramInt2 += 1;
    }
    else
    {
      paramArrayOfByte1 = (byte[])localObject4;
    }
    paramArrayOfLong = ((tlv_t109)localObject18).get_tlv_109(u.P);
    localObject4 = ((tlv_t52d)localObject17).get_tlv_52d(this.a);
    localObject17 = util.get_os_type();
    localObject18 = util.get_os_version();
    paramInt1 = u.E;
    localObject19 = u.D;
    localObject20 = u.G;
    localObject16 = localtlv_t144.get_tlv_144(paramArrayOfLong, (byte[])localObject4, ((tlv_t124)localObject16).get_tlv_124((byte[])localObject17, (byte[])localObject18, paramInt1, (byte[])localObject19, new byte[0], (byte[])localObject20), localtlv_t128.get_tlv_128(u.V, u.W, u.X, u.aa, u.J, u.B, u.Q), localtlv_t16e.get_tlv_16e(u.J), this.x.b);
    paramArrayOfLong = "6.0.0.2484".getBytes();
    localObject4 = new byte[u.B.length + 10 + 2 + paramArrayOfLong.length + 4];
    util.int64_to_buf((byte[])localObject4, 0, (int)paramLong1);
    util.int16_to_buf((byte[])localObject4, 4, u.B.length);
    System.arraycopy(u.B, 0, localObject4, 6, u.B.length);
    paramInt1 = u.B.length + 6;
    util.int16_to_buf((byte[])localObject4, paramInt1, paramArrayOfLong.length);
    paramInt1 += 2;
    System.arraycopy(paramArrayOfLong, 0, localObject4, paramInt1, paramArrayOfLong.length);
    util.int32_to_buf((byte[])localObject4, paramInt1 + paramArrayOfLong.length, this.u);
    localObject4 = localtlv_t544.get_tlv_544(String.valueOf(paramLong1), "810_a", (byte[])localObject4);
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
    {
      paramArrayOfByte3 = localtlv_t143.get_tlv_143(paramArrayOfByte3);
      paramInt3 = paramInt2 + 1 + 1;
      paramInt4 = localObject9.length + localObject10.length + localObject11.length + localObject1.length + localObject16.length + paramArrayOfByte3.length + localObject12.length + localObject14.length + localObject15.length + arrayOfByte1.length + arrayOfByte2.length + localObject2.length + arrayOfByte3.length + localObject7.length + localObject6.length + localObject8.length + localObject5.length + paramArrayOfByte2.length + paramList.length + paramArrayOfByte1.length;
      paramInt2 = paramInt4;
      paramInt1 = paramInt3;
      if (localObject4 != null)
      {
        paramInt2 = paramInt4 + localObject4.length;
        paramInt1 = paramInt3 + 1;
      }
      paramArrayOfLong = new byte[paramInt2];
      System.arraycopy(localObject9, 0, paramArrayOfLong, 0, localObject9.length);
      paramInt2 = localObject9.length + 0;
      System.arraycopy(localObject10, 0, paramArrayOfLong, paramInt2, localObject10.length);
      paramInt2 += localObject10.length;
      System.arraycopy(localObject11, 0, paramArrayOfLong, paramInt2, localObject11.length);
      paramInt2 += localObject11.length;
      System.arraycopy(localObject1, 0, paramArrayOfLong, paramInt2, localObject1.length);
      paramInt2 += localObject1.length;
      System.arraycopy(localObject16, 0, paramArrayOfLong, paramInt2, localObject16.length);
      paramInt2 += localObject16.length;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfLong, paramInt2, paramArrayOfByte3.length);
      paramInt2 += paramArrayOfByte3.length;
      System.arraycopy(localObject12, 0, paramArrayOfLong, paramInt2, localObject12.length);
      paramInt2 += localObject12.length;
      System.arraycopy(localObject14, 0, paramArrayOfLong, paramInt2, localObject14.length);
      paramInt2 += localObject14.length;
      System.arraycopy(localObject15, 0, paramArrayOfLong, paramInt2, localObject15.length);
      paramInt2 += localObject15.length;
      System.arraycopy(arrayOfByte1, 0, paramArrayOfLong, paramInt2, arrayOfByte1.length);
      paramInt2 += arrayOfByte1.length;
      System.arraycopy(arrayOfByte2, 0, paramArrayOfLong, paramInt2, arrayOfByte2.length);
      paramInt2 += arrayOfByte2.length;
      System.arraycopy(localObject2, 0, paramArrayOfLong, paramInt2, localObject2.length);
      paramInt2 += localObject2.length;
      System.arraycopy(arrayOfByte3, 0, paramArrayOfLong, paramInt2, arrayOfByte3.length);
      paramInt2 += arrayOfByte3.length;
      System.arraycopy(localObject7, 0, paramArrayOfLong, paramInt2, localObject7.length);
      paramInt2 += localObject7.length;
      System.arraycopy(localObject6, 0, paramArrayOfLong, paramInt2, localObject6.length);
      paramInt2 += localObject6.length;
      System.arraycopy(localObject8, 0, paramArrayOfLong, paramInt2, localObject8.length);
      paramInt2 += localObject8.length;
      System.arraycopy(localObject5, 0, paramArrayOfLong, paramInt2, localObject5.length);
      paramInt2 += localObject5.length;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfLong, paramInt2, paramArrayOfByte2.length);
      paramInt2 += paramArrayOfByte2.length;
      System.arraycopy(paramList, 0, paramArrayOfLong, paramInt2, paramList.length);
      paramInt2 += paramList.length;
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfLong, paramInt2, paramArrayOfByte1.length);
      paramInt3 = paramArrayOfByte1.length;
      if (localObject4 != null) {
        System.arraycopy(localObject4, 0, paramArrayOfLong, paramInt2 + paramInt3, localObject4.length);
      }
      paramInt2 = 11;
      paramArrayOfByte1 = paramArrayOfLong;
    }
    else
    {
      paramInt1 = paramInt2 + 2;
      if ((this.x.g != null) && (!util.check_uin_account(this.x.g).booleanValue()))
      {
        paramArrayOfLong = localtlv_t112.get_tlv_112(this.x.g.getBytes());
        paramInt1 += 1;
      }
      else
      {
        paramArrayOfLong = (long[])localObject3;
      }
      paramInt2 = localObject9.length + localObject10.length + localObject11.length + localObject1.length + localObject16.length + 0 + paramArrayOfLong.length + localObject13.length + localObject12.length + localObject14.length + localObject15.length + arrayOfByte1.length + arrayOfByte2.length + localObject2.length + arrayOfByte3.length + localObject7.length + localObject6.length + localObject8.length + localObject5.length + paramArrayOfByte2.length + paramList.length + paramArrayOfByte1.length;
      if (localObject4 != null)
      {
        paramInt2 += localObject4.length;
        paramInt1 += 1;
      }
      paramArrayOfByte3 = new byte[paramInt2];
      System.arraycopy(localObject9, 0, paramArrayOfByte3, 0, localObject9.length);
      paramInt2 = localObject9.length + 0;
      System.arraycopy(localObject10, 0, paramArrayOfByte3, paramInt2, localObject10.length);
      paramInt2 += localObject10.length;
      System.arraycopy(localObject11, 0, paramArrayOfByte3, paramInt2, localObject11.length);
      paramInt2 += localObject11.length;
      System.arraycopy(localObject1, 0, paramArrayOfByte3, paramInt2, localObject1.length);
      paramInt2 += localObject1.length;
      System.arraycopy(localObject16, 0, paramArrayOfByte3, paramInt2, localObject16.length);
      paramInt2 += localObject16.length;
      System.arraycopy(arrayOfByte4, 0, paramArrayOfByte3, paramInt2, 0);
      paramInt2 += 0;
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte3, paramInt2, paramArrayOfLong.length);
      paramInt2 += paramArrayOfLong.length;
      System.arraycopy(localObject13, 0, paramArrayOfByte3, paramInt2, localObject13.length);
      paramInt2 += localObject13.length;
      System.arraycopy(localObject12, 0, paramArrayOfByte3, paramInt2, localObject12.length);
      paramInt2 += localObject12.length;
      System.arraycopy(localObject14, 0, paramArrayOfByte3, paramInt2, localObject14.length);
      paramInt2 += localObject14.length;
      System.arraycopy(localObject15, 0, paramArrayOfByte3, paramInt2, localObject15.length);
      paramInt2 += localObject15.length;
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte3, paramInt2, arrayOfByte1.length);
      paramInt2 += arrayOfByte1.length;
      System.arraycopy(arrayOfByte2, 0, paramArrayOfByte3, paramInt2, arrayOfByte2.length);
      paramInt2 += arrayOfByte2.length;
      System.arraycopy(localObject2, 0, paramArrayOfByte3, paramInt2, localObject2.length);
      paramInt2 += localObject2.length;
      System.arraycopy(arrayOfByte3, 0, paramArrayOfByte3, paramInt2, arrayOfByte3.length);
      paramInt2 += arrayOfByte3.length;
      System.arraycopy(localObject7, 0, paramArrayOfByte3, paramInt2, localObject7.length);
      paramInt2 += localObject7.length;
      System.arraycopy(localObject6, 0, paramArrayOfByte3, paramInt2, localObject6.length);
      paramInt2 += localObject6.length;
      System.arraycopy(localObject8, 0, paramArrayOfByte3, paramInt2, localObject8.length);
      paramInt2 += localObject8.length;
      System.arraycopy(localObject5, 0, paramArrayOfByte3, paramInt2, localObject5.length);
      paramInt2 += localObject5.length;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt2, paramArrayOfByte2.length);
      paramInt2 += paramArrayOfByte2.length;
      System.arraycopy(paramList, 0, paramArrayOfByte3, paramInt2, paramList.length);
      paramInt2 += paramList.length;
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, paramInt2, paramArrayOfByte1.length);
      paramInt3 = paramArrayOfByte1.length;
      if (localObject4 != null) {
        System.arraycopy(localObject4, 0, paramArrayOfByte3, paramInt2 + paramInt3, localObject4.length);
      }
      paramInt2 = i;
      paramArrayOfByte1 = paramArrayOfByte3;
    }
    return b(paramArrayOfByte1, paramInt2, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.o
 * JD-Core Version:    0.7.0.1
 */