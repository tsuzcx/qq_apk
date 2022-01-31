package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.b.ab;
import oicq.wlogin_sdk.b.af;
import oicq.wlogin_sdk.b.ak;
import oicq.wlogin_sdk.b.al;
import oicq.wlogin_sdk.b.an;
import oicq.wlogin_sdk.b.ao;
import oicq.wlogin_sdk.b.aq;
import oicq.wlogin_sdk.b.av;
import oicq.wlogin_sdk.b.az;
import oicq.wlogin_sdk.b.b;
import oicq.wlogin_sdk.b.bc;
import oicq.wlogin_sdk.b.bd;
import oicq.wlogin_sdk.b.bg;
import oicq.wlogin_sdk.b.bi;
import oicq.wlogin_sdk.b.bl;
import oicq.wlogin_sdk.b.bt;
import oicq.wlogin_sdk.b.bx;
import oicq.wlogin_sdk.b.bz;
import oicq.wlogin_sdk.b.c;
import oicq.wlogin_sdk.b.ca;
import oicq.wlogin_sdk.b.cb;
import oicq.wlogin_sdk.b.ce;
import oicq.wlogin_sdk.b.cj;
import oicq.wlogin_sdk.b.ck;
import oicq.wlogin_sdk.b.cm;
import oicq.wlogin_sdk.b.cr;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.b.h;
import oicq.wlogin_sdk.b.i;
import oicq.wlogin_sdk.b.q;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public class k
  extends j
{
  public static boolean D = false;
  public static byte[] E = new byte[0];
  public static byte[] F = new byte[0];
  public static byte[] G = new byte[0];
  
  public k(t paramt)
  {
    this.s = 2064;
    this.t = 9;
    this.u = "wtlogin.login";
    this.w = paramt;
    this.w.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong4, int paramInt6, int paramInt7, int paramInt8, int paramInt9, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.u;
    Object localObject = t.b(this.w.h);
    ((async_context)localObject)._tgtgt_key = util.get_rand_16byte(t.z);
    byte[] arrayOfByte1 = ((async_context)localObject)._tgtgt_key;
    localObject = ((async_context)localObject)._t104;
    if (localObject == null) {
      localObject = new f();
    }
    for (;;)
    {
      int i = 0;
      for (;;)
      {
        byte[] arrayOfByte2 = a(paramLong1, paramLong2, j, paramLong3, paramInt1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, arrayOfByte1, paramInt2, null, null, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong4, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfByte4, ((f)localObject).b(), t.C, paramWUserSigInfo._domains);
        a(this.h, this.s, this.i, paramLong3, this.l, this.m, j, this.o, arrayOfByte2);
        int k = a(String.valueOf(this.w.f), false, paramWUserSigInfo);
        if (k != 0) {
          return k;
        }
        k = b();
        util.LOGI("retry num:" + i + " ret:" + k, "" + paramLong3);
        if (k != 180) {
          return k;
        }
        if (i >= 1) {
          return k;
        }
        i += 1;
      }
    }
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, long[] paramArrayOfLong, int paramInt4, long paramLong4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    int m = t.u;
    f localf = t.b(this.w.h)._t104;
    if (localf == null) {
      localf = new f();
    }
    for (;;)
    {
      paramArrayOfByte2 = c(paramArrayOfByte2);
      int j;
      if (paramArrayOfByte2 == null)
      {
        j = -1014;
        return j;
      }
      int i = 0;
      for (;;)
      {
        byte[] arrayOfByte = a(paramLong1, paramLong2, m, paramLong3, paramInt1, paramArrayOfByte1, null, null, null, 0, paramArrayOfByte2, paramArrayOfByte3, paramInt2, paramInt3, paramArrayOfLong, paramInt4, paramLong4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfByte4, localf.b(), t.C, paramWUserSigInfo._domains);
        a(this.h, this.s, this.i, paramLong3, this.l, this.m, m, this.o, arrayOfByte);
        int k = a(String.valueOf(this.w.f), false, paramWUserSigInfo);
        j = k;
        if (k != 0) {
          break;
        }
        j = b();
        util.LOGI("retry num:" + i + " ret:" + j, "" + paramLong3);
        if (j != 180) {
          return j;
        }
        if (i >= 1) {
          return j;
        }
        i += 1;
      }
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt3, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, int paramInt4, int paramInt5, long[] paramArrayOfLong, int paramInt6, long paramLong4, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, List<String> paramList)
  {
    int[] arrayOfInt = new int[29];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 24;
    int[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 1;
    int[] tmp17_13 = tmp13_8;
    tmp17_13[2] = 262;
    int[] tmp23_17 = tmp17_13;
    tmp23_17[3] = 278;
    int[] tmp29_23 = tmp23_17;
    tmp29_23[4] = 256;
    int[] tmp35_29 = tmp29_23;
    tmp35_29[5] = 263;
    int[] tmp41_35 = tmp35_29;
    tmp41_35[6] = 264;
    int[] tmp48_41 = tmp41_35;
    tmp48_41[7] = 260;
    int[] tmp55_48 = tmp48_41;
    tmp55_48[8] = 322;
    int[] tmp62_55 = tmp55_48;
    tmp62_55[9] = 274;
    int[] tmp69_62 = tmp62_55;
    tmp69_62[10] = 324;
    int[] tmp76_69 = tmp69_62;
    tmp76_69[11] = 325;
    int[] tmp83_76 = tmp76_69;
    tmp83_76[12] = 327;
    int[] tmp90_83 = tmp83_76;
    tmp90_83[13] = 358;
    int[] tmp97_90 = tmp90_83;
    tmp97_90[14] = 362;
    int[] tmp104_97 = tmp97_90;
    tmp104_97[15] = 340;
    int[] tmp111_104 = tmp104_97;
    tmp111_104[16] = 321;
    int[] tmp118_111 = tmp111_104;
    tmp118_111[17] = 8;
    int[] tmp124_118 = tmp118_111;
    tmp124_118[18] = 363;
    int[] tmp131_124 = tmp124_118;
    tmp131_124[19] = 370;
    int[] tmp138_131 = tmp131_124;
    tmp138_131[20] = 389;
    int[] tmp145_138 = tmp138_131;
    tmp145_138[21] = 1024;
    int[] tmp152_145 = tmp145_138;
    tmp152_145[22] = 391;
    int[] tmp159_152 = tmp152_145;
    tmp159_152[23] = 392;
    int[] tmp166_159 = tmp159_152;
    tmp166_159[24] = 404;
    int[] tmp173_166 = tmp166_159;
    tmp173_166[25] = 401;
    int[] tmp180_173 = tmp173_166;
    tmp180_173[26] = 513;
    int[] tmp187_180 = tmp180_173;
    tmp187_180[27] = 514;
    int[] tmp194_187 = tmp187_180;
    tmp194_187[28] = 375;
    tmp194_187;
    async_context localasync_context = t.b(this.w.h);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k = arrayOfInt.length;
    int j = 0;
    int m;
    Object localObject2;
    Object localObject1;
    if (j < k)
    {
      m = arrayOfInt[j];
      localObject2 = null;
      switch (m)
      {
      default: 
        localObject1 = localObject2;
        label500:
        if (localObject1 != null)
        {
          localArrayList.add(localObject1);
          i = localObject1.length + i;
        }
        break;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      localObject1 = new bt().a(paramLong1, paramInt1, paramLong3, paramInt2);
      break label500;
      localObject1 = new b().a(paramLong3, paramArrayOfByte1);
      break label500;
      localObject1 = new h();
      if ((paramArrayOfByte5 != null) && (paramArrayOfByte5.length > 0))
      {
        ((h)localObject1).a(paramArrayOfByte5, paramArrayOfByte5.length);
        localObject1 = ((h)localObject1).a();
        break label500;
      }
      localObject1 = ((h)localObject1).a(paramLong1, paramLong2, paramInt1, paramLong3, paramArrayOfByte2, paramArrayOfByte1, 1, paramArrayOfByte3, localasync_context._msalt, this.w.g.getBytes(), paramArrayOfByte4, t.S, t.y, paramInt3);
      break label500;
      localObject1 = new oicq.wlogin_sdk.b.t().a(paramInt4, paramInt5, paramArrayOfLong);
      break label500;
      localObject1 = new c().a(paramLong1, paramLong4, paramInt1, paramInt6);
      break label500;
      localObject1 = new i().a(paramInt7, paramInt8, paramInt9, paramInt10);
      break label500;
      localObject1 = localObject2;
      if (paramArrayOfByte7 == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (paramArrayOfByte7.length == 0) {
        break label500;
      }
      localObject1 = new oicq.wlogin_sdk.b.j().a(paramArrayOfByte7);
      break label500;
      localObject1 = localObject2;
      if (paramArrayOfByte8 == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (paramArrayOfByte8.length == 0) {
        break label500;
      }
      localObject1 = new f().a(paramArrayOfByte8);
      break label500;
      localObject1 = new al().a(paramArrayOfByte9);
      break label500;
      localObject1 = localObject2;
      if (this.w.g == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (util.check_uin_account(this.w.g).booleanValue()) {
        break label500;
      }
      localObject1 = new q().a(this.w.g.getBytes());
      break label500;
      localObject1 = new oicq.wlogin_sdk.b.k().a(t.K);
      localObject2 = new ab();
      Object localObject3 = util.get_os_type();
      byte[] arrayOfByte1 = util.get_os_version();
      m = t.B;
      byte[] arrayOfByte2 = t.A;
      byte[] arrayOfByte3 = t.D;
      localObject2 = ((ab)localObject2).a((byte[])localObject3, arrayOfByte1, m, arrayOfByte2, new byte[0], arrayOfByte3);
      localObject3 = new af().a(t.R, t.S, t.T, t.W, t.G, t.y, t.N);
      arrayOfByte1 = new bg().a(t.G);
      localObject1 = new an().a((byte[])localObject1, (byte[])localObject2, (byte[])localObject3, arrayOfByte1, localasync_context._tgtgt_key);
      break label500;
      localObject1 = new ao().a(t.y);
      break label500;
      localObject1 = new aq().a(paramLong1, t.E, t.F);
      break label500;
      localObject1 = localObject2;
      if ((paramInt4 & 0x80) == 0) {
        break label500;
      }
      localObject1 = new az().b(t.v);
      break label500;
      localObject1 = localObject2;
      if (paramArrayOfByte6 == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (paramArrayOfByte6.length == 0) {
        break label500;
      }
      localObject1 = new bc().a(paramArrayOfByte6);
      break label500;
      localObject1 = new av().b(this.w.i);
      break label500;
      localObject1 = new ak().b(t.A, t.B, t.D);
      break label500;
      localObject1 = new cr().a(0, t.s, 0);
      break label500;
      localObject1 = localObject2;
      if (paramList == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (paramList.size() == 0) {
        break label500;
      }
      localObject1 = new bd().a(paramList);
      break label500;
      localObject1 = localObject2;
      if (this.w.p == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (this.w.p.length == 0) {
        break label500;
      }
      localObject1 = new bi().a(this.w.p);
      break label500;
      localObject1 = localObject2;
      if (paramInt3 != 3) {
        break label500;
      }
      localObject1 = new bx().b(1);
      break label500;
      localObject3 = this.w.a(paramLong3, paramLong1);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (((WloginSigInfo)localObject3)._G == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (((WloginSigInfo)localObject3)._G.length == 0) {
        break label500;
      }
      localObject1 = localObject2;
      if (((WloginSigInfo)localObject3)._dpwd == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (((WloginSigInfo)localObject3)._dpwd.length == 0) {
        break label500;
      }
      localObject1 = localObject2;
      if (((WloginSigInfo)localObject3)._randseed == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (((WloginSigInfo)localObject3)._randseed.length == 0) {
        break label500;
      }
      localObject1 = new cm().a(((WloginSigInfo)localObject3)._G, paramLong3, t.y, ((WloginSigInfo)localObject3)._dpwd, paramLong1, paramLong2, ((WloginSigInfo)localObject3)._randseed);
      break label500;
      localObject1 = localObject2;
      if (t.L == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (t.L.length == 0) {
        break label500;
      }
      localObject1 = new bz().a(t.L);
      break label500;
      localObject1 = localObject2;
      if (t.M == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (t.M.length == 0) {
        break label500;
      }
      localObject1 = new ca().a(t.M);
      break label500;
      localObject1 = localObject2;
      if (t.J == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (t.J.length == 0) {
        break label500;
      }
      localObject1 = new ce().a(t.J);
      break label500;
      localObject1 = new cb().a(D);
      break label500;
      localObject1 = localObject2;
      if (E == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (E.length == 0) {
        break label500;
      }
      localObject1 = new cj().a(E, F, "qq".getBytes(), G);
      break label500;
      localObject1 = localObject2;
      if (t.P == null) {
        break label500;
      }
      localObject1 = localObject2;
      if (t.P.length == 0) {
        break label500;
      }
      localObject1 = new ck().a(t.P, t.Q);
      break label500;
      localObject1 = new bl().a(1453167956L, "5.4.0.7");
      break label500;
      paramArrayOfByte1 = new byte[i];
      paramInt3 = localArrayList.size();
      paramInt2 = 0;
      paramInt1 = 0;
      while (paramInt1 < paramInt3)
      {
        paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, paramArrayOfByte2.length);
        paramInt2 += paramArrayOfByte2.length;
        paramInt1 += 1;
      }
      return a(paramArrayOfByte1, this.t, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.k
 * JD-Core Version:    0.7.0.1
 */