package oicq.wlogin_sdk.request;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import oicq.wlogin_sdk.b.a;
import oicq.wlogin_sdk.b.aa;
import oicq.wlogin_sdk.b.ac;
import oicq.wlogin_sdk.b.ad;
import oicq.wlogin_sdk.b.ag;
import oicq.wlogin_sdk.b.ah;
import oicq.wlogin_sdk.b.ai;
import oicq.wlogin_sdk.b.aj;
import oicq.wlogin_sdk.b.am;
import oicq.wlogin_sdk.b.ao;
import oicq.wlogin_sdk.b.ap;
import oicq.wlogin_sdk.b.as;
import oicq.wlogin_sdk.b.at;
import oicq.wlogin_sdk.b.aw;
import oicq.wlogin_sdk.b.ax;
import oicq.wlogin_sdk.b.ay;
import oicq.wlogin_sdk.b.ba;
import oicq.wlogin_sdk.b.bb;
import oicq.wlogin_sdk.b.bc;
import oicq.wlogin_sdk.b.be;
import oicq.wlogin_sdk.b.bf;
import oicq.wlogin_sdk.b.bh;
import oicq.wlogin_sdk.b.bi;
import oicq.wlogin_sdk.b.bj;
import oicq.wlogin_sdk.b.bk;
import oicq.wlogin_sdk.b.bm;
import oicq.wlogin_sdk.b.bn;
import oicq.wlogin_sdk.b.br;
import oicq.wlogin_sdk.b.bs;
import oicq.wlogin_sdk.b.bu;
import oicq.wlogin_sdk.b.bv;
import oicq.wlogin_sdk.b.by;
import oicq.wlogin_sdk.b.cc;
import oicq.wlogin_sdk.b.cf;
import oicq.wlogin_sdk.b.cg;
import oicq.wlogin_sdk.b.ci;
import oicq.wlogin_sdk.b.cl;
import oicq.wlogin_sdk.b.co;
import oicq.wlogin_sdk.b.cp;
import oicq.wlogin_sdk.b.cq;
import oicq.wlogin_sdk.b.cr;
import oicq.wlogin_sdk.b.e;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.b.g;
import oicq.wlogin_sdk.b.h;
import oicq.wlogin_sdk.b.l;
import oicq.wlogin_sdk.b.m;
import oicq.wlogin_sdk.b.n;
import oicq.wlogin_sdk.b.o;
import oicq.wlogin_sdk.b.p;
import oicq.wlogin_sdk.b.r;
import oicq.wlogin_sdk.b.s;
import oicq.wlogin_sdk.b.u;
import oicq.wlogin_sdk.b.v;
import oicq.wlogin_sdk.b.w;
import oicq.wlogin_sdk.b.x;
import oicq.wlogin_sdk.b.y;
import oicq.wlogin_sdk.b.z;
import oicq.wlogin_sdk.report.report_t1;
import oicq.wlogin_sdk.report.report_t3;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.InternationMsg;
import oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class j
{
  static int A = 0;
  static String B = "";
  static String C = "";
  static String[] x = { "183.60.18.138", "112.90.85.191", "112.90.85.193", "183.60.18.150", "183.61.37.157", "120.204.200.34", "163.177.90.224" };
  static String[] y = { "112.90.141.48", "113.108.11.157", "113.108.11.159", "183.61.37.156" };
  int a = 4096;
  int b = 0;
  int c = 27;
  int d = 0;
  public int e = 15;
  protected int f = 0;
  protected byte[] g = new byte[this.a];
  protected int h = 8001;
  protected int i = 0;
  protected int j = 3;
  protected int k = 0;
  protected int l = 0;
  protected int m = 2;
  protected int n = 0;
  protected int o = 0;
  InetSocketAddress p = null;
  int q = 0;
  byte[] r = new byte[6144];
  protected int s = 0;
  protected int t = 0;
  protected String u = "";
  byte v;
  public t w;
  int z = 0;
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    report_t3 localreport_t3 = new report_t3();
    localreport_t3._cmd = this.s;
    localreport_t3._sub = this.t;
    localreport_t3._rst2 = paramInt1;
    localreport_t3._used = ((int)(System.currentTimeMillis() - paramLong));
    localreport_t3._try = paramInt3;
    localreport_t3._host = C;
    if (localreport_t3._host == null) {
      localreport_t3._host = "";
    }
    if (this.p == null)
    {
      localreport_t3._ip = "";
      localreport_t3._port = c(paramBoolean1);
      localreport_t3._conn = paramInt2;
      localreport_t3._net = t.B;
      localreport_t3._str = "";
      localreport_t3._slen = 0;
      localreport_t3._rlen = 0;
      if (!paramBoolean1) {
        break label185;
      }
      if (!paramBoolean2) {
        break label176;
      }
      localreport_t3._wap = 2;
    }
    for (;;)
    {
      t.ag.add_t3(localreport_t3);
      return;
      localreport_t3._ip = this.p.getAddress().getHostAddress();
      break;
      label176:
      localreport_t3._wap = 1;
      continue;
      label185:
      localreport_t3._wap = 0;
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    A = paramInt;
    B = paramString;
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public int a(int paramInt)
  {
    t.b(this.w.h)._last_flowid = paramInt;
    return paramInt;
  }
  
  public int a(String paramString, boolean paramBoolean, WUserSigInfo paramWUserSigInfo)
  {
    if (this.w.e()) {}
    for (int i1 = b(paramString, paramBoolean, paramWUserSigInfo);; i1 = e())
    {
      if (i1 == -1000)
      {
        paramString = new ErrMsg();
        paramString.setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_4));
        a(paramString);
      }
      return i1;
    }
  }
  
  public int a(aw paramaw)
  {
    bj localbj = new bj();
    bi localbi = new bi();
    paramaw = paramaw.b();
    int i1 = paramaw.length;
    if (localbj.b(paramaw, 2, i1) > 0) {
      a(localbj);
    }
    if (localbi.b(paramaw, 2, i1) > 0)
    {
      this.w.m = 1;
      this.w.p = localbi.b();
      util.LOGI("get rollback sig", "");
    }
    return 0;
  }
  
  public int a(bj parambj)
  {
    parambj = parambj.b();
    int i3;
    int i2;
    int i1;
    if ((parambj != null) && (parambj.length > 2))
    {
      i3 = util.buf_to_int8(parambj, 1);
      i2 = 2;
      i1 = 0;
    }
    for (;;)
    {
      if ((i1 >= i3) || (parambj.length < i2 + 1)) {}
      int i4;
      byte[] arrayOfByte;
      do
      {
        do
        {
          do
          {
            return 0;
            i4 = util.buf_to_int8(parambj, i2);
            i5 = i2 + 1;
          } while (parambj.length < i5 + 2);
          i2 = util.buf_to_int16(parambj, i5);
          i5 += 2;
        } while (parambj.length < i5 + i2);
        arrayOfByte = new byte[i2];
        System.arraycopy(parambj, i5, arrayOfByte, 0, i2);
        i2 = i5 + i2;
      } while (parambj.length < i2 + 2);
      int i5 = util.buf_to_int16(parambj, i2);
      i2 += 2;
      a(i4, arrayOfByte, i5);
      i1 += 1;
    }
  }
  
  public int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = cryptor.decrypt(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2);
    if (paramArrayOfByte1 == null) {
      return -1002;
    }
    this.f = paramArrayOfByte1.length;
    if (paramArrayOfByte1.length + this.e + 2 > this.a)
    {
      this.a = (paramArrayOfByte1.length + this.e + 2);
      paramArrayOfByte2 = new byte[this.a];
      System.arraycopy(this.g, 0, paramArrayOfByte2, 0, this.b);
      this.g = paramArrayOfByte2;
    }
    this.b = 0;
    System.arraycopy(paramArrayOfByte1, 0, this.g, paramInt1, paramArrayOfByte1.length);
    paramInt1 = this.b;
    paramInt2 = this.e;
    this.b = (paramArrayOfByte1.length + (paramInt2 + 2) + paramInt1);
    return 0;
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    String str1 = "";
    paramInt /= 2;
    String str2;
    if ((A != 0) && (B != null) && (B.length() > 0)) {
      str2 = B;
    }
    for (;;)
    {
      C = str2;
      return str2;
      if (paramInt < 1)
      {
        if (paramBoolean) {
          if (t.B == 1) {
            str1 = new String(util.get_wap_server_host1(t.r));
          }
        }
        for (;;)
        {
          str2 = str1;
          if (str1.length() > 0) {
            break;
          }
          str2 = b(paramBoolean);
          break;
          if (t.B == 2)
          {
            str1 = new String(util.get_wap_server_host2(t.r));
            continue;
            if (t.B == 1) {
              str1 = new String(util.get_server_host1(t.r));
            } else if (t.B == 2) {
              str1 = new String(util.get_server_host2(t.r));
            }
          }
        }
      }
      if (paramInt < 2) {
        str2 = b(paramBoolean);
      } else {
        str2 = a(paramBoolean);
      }
    }
  }
  
  public String a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return x[((int)(java.lang.Math.random() * 2147483647.0D) % x.length)];
    }
    return y[((int)(java.lang.Math.random() * 2147483647.0D) % y.length)];
  }
  
  public void a()
  {
    util.int8_to_buf(this.g, this.b, 3);
    this.b += 1;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt3 = this.i + 1;
    this.i = paramInt3;
    this.b = 0;
    util.int8_to_buf(this.g, this.b, 2);
    this.b += 1;
    util.int16_to_buf(this.g, this.b, this.c + 2 + paramInt8);
    this.b += 2;
    util.int16_to_buf(this.g, this.b, paramInt1);
    this.b += 2;
    util.int16_to_buf(this.g, this.b, paramInt2);
    this.b += 2;
    util.int16_to_buf(this.g, this.b, paramInt3);
    this.b += 2;
    util.int32_to_buf(this.g, this.b, (int)paramLong);
    this.b += 4;
    util.int8_to_buf(this.g, this.b, 3);
    this.b += 1;
    util.int8_to_buf(this.g, this.b, 7);
    this.b += 1;
    util.int8_to_buf(this.g, this.b, paramInt4);
    this.b += 1;
    util.int32_to_buf(this.g, this.b, paramInt5);
    this.b += 4;
    util.int32_to_buf(this.g, this.b, paramInt6);
    this.b += 4;
    util.int32_to_buf(this.g, this.b, paramInt7);
    this.b += 4;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte)
  {
    a(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte, int paramInt8)
  {
    a(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    a(paramArrayOfByte, paramInt8);
    a();
  }
  
  void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return;
    }
    if (paramInt1 == 1) {
      if (t.B == 1) {
        util.set_server_host1(t.r, paramArrayOfByte);
      }
    }
    for (;;)
    {
      util.LOGI("net type:" + t.B + " type:" + paramInt1 + " host:" + new String(paramArrayOfByte) + " port:" + paramInt2, "" + this.w.f);
      return;
      if (t.B == 2)
      {
        util.set_server_host2(t.r, paramArrayOfByte);
        continue;
        if (paramInt1 == 2) {
          if (t.B == 1) {
            util.set_wap_server_host1(t.r, paramArrayOfByte);
          } else if (t.B == 2) {
            util.set_wap_server_host2(t.r, paramArrayOfByte);
          }
        }
      }
    }
  }
  
  public void a(Socket paramSocket)
  {
    this.w.ac = paramSocket;
  }
  
  public void a(as paramas)
  {
    try
    {
      ErrMsg localErrMsg = new ErrMsg();
      if (paramas != null)
      {
        localErrMsg.setType(paramas.f());
        localErrMsg.setTitle(new String(paramas.g()));
        localErrMsg.setMessage(new String(paramas.h()));
        localErrMsg.setOtherinfo(new String(paramas.i()));
        new d(t.r, localErrMsg).start();
      }
      return;
    }
    catch (Exception paramas) {}
  }
  
  public void a(ErrMsg paramErrMsg)
  {
    async_context localasync_context = t.b(this.w.h);
    localasync_context._last_err_msg = new ErrMsg(0, "", "", "");
    if (paramErrMsg != null) {}
    try
    {
      localasync_context._last_err_msg = ((ErrMsg)paramErrMsg.clone());
      return;
    }
    catch (CloneNotSupportedException paramErrMsg)
    {
      localasync_context._last_err_msg = new ErrMsg(0, "", "", "");
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.b + paramInt + 1 > this.a)
    {
      this.a = (this.b + paramInt + 1 + 128);
      byte[] arrayOfByte = new byte[this.a];
      System.arraycopy(this.g, 0, arrayOfByte, 0, this.b);
      this.g = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.g, this.b, paramInt);
    this.b += paramInt;
  }
  
  public byte[] a(bb parambb)
  {
    Object localObject4 = new h();
    Object localObject3 = new n();
    Object localObject2 = new bc();
    Object localObject1 = new ao();
    parambb = parambb.b();
    int i1 = parambb.length;
    if (((h)localObject4).b(parambb, 2, i1) < 0) {}
    while ((((n)localObject3).b(parambb, 2, i1) < 0) || (((bc)localObject2).b(parambb, 2, i1) < 0)) {
      return null;
    }
    parambb = ((h)localObject4).a();
    localObject3 = ((n)localObject3).a();
    localObject2 = ((bc)localObject2).a();
    localObject1 = ((ao)localObject1).a(t.y);
    localObject4 = new byte[parambb.length + 3 + localObject3.length + localObject2.length + localObject1.length];
    localObject4[0] = 64;
    util.int16_to_buf((byte[])localObject4, 1, 4);
    System.arraycopy(parambb, 0, localObject4, 3, parambb.length);
    i1 = parambb.length + 3;
    System.arraycopy(localObject3, 0, localObject4, i1, localObject3.length);
    i1 += localObject3.length;
    System.arraycopy(localObject2, 0, localObject4, i1, localObject2.length);
    i1 += localObject2.length;
    System.arraycopy(localObject1, 0, localObject4, i1, localObject1.length);
    i1 = localObject1.length;
    return localObject4;
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    if (this.w.m == 0) {
      return a(paramArrayOfByte, this.w.c, this.w.n, this.w.o);
    }
    return a(paramArrayOfByte, this.w.c);
  }
  
  byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.int16_to_buf(arrayOfByte, 0, paramInt1);
    util.int16_to_buf(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    if (this.w.m == 0) {
      return a(arrayOfByte, this.w.c, this.w.n, this.w.o);
    }
    return a(arrayOfByte, this.w.c);
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return new byte[0];
    }
    if (this.w.m == 2) {}
    for (int i1 = 3;; i1 = 2)
    {
      paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
      byte[] arrayOfByte = new byte[paramArrayOfByte2.length + 2 + 2 + 2 + paramArrayOfByte1.length];
      util.int8_to_buf(arrayOfByte, 0, 1);
      util.int8_to_buf(arrayOfByte, 1, i1);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 2, paramArrayOfByte2.length);
      i1 = paramArrayOfByte2.length + 2;
      util.int16_to_buf(arrayOfByte, i1, 258);
      i1 += 2;
      util.int16_to_buf(arrayOfByte, i1, 0);
      i1 += 2;
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, i1, paramArrayOfByte1.length);
      i1 = paramArrayOfByte1.length;
      return arrayOfByte;
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte3 == null)) {
      return new byte[16];
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length + paramArrayOfByte3.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    int i1 = paramArrayOfByte1.length + 0;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i1, paramArrayOfByte2.length);
    i1 += paramArrayOfByte2.length;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, i1, paramArrayOfByte3.length);
    i1 = paramArrayOfByte3.length;
    return MD5.toMD5Byte(arrayOfByte);
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte3 == null) || (paramArrayOfByte4 == null)) {
      return new byte[0];
    }
    paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte4);
    paramArrayOfByte4 = new byte[paramArrayOfByte2.length + 2 + 2 + 2 + paramArrayOfByte3.length + paramArrayOfByte1.length];
    util.int8_to_buf(paramArrayOfByte4, 0, 1);
    util.int8_to_buf(paramArrayOfByte4, 1, 1);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte4, 2, paramArrayOfByte2.length);
    int i1 = paramArrayOfByte2.length + 2;
    util.int16_to_buf(paramArrayOfByte4, i1, 258);
    i1 += 2;
    util.int16_to_buf(paramArrayOfByte4, i1, paramArrayOfByte3.length);
    i1 += 2;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte4, i1, paramArrayOfByte3.length);
    i1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte4, i1, paramArrayOfByte1.length);
    i1 = paramArrayOfByte1.length;
    return paramArrayOfByte4;
  }
  
  public int b()
  {
    int i1 = this.b;
    int i2;
    if (i1 <= this.e + 2)
    {
      i2 = -1009;
      return i2;
    }
    this.f = (i1 - this.e - 2);
    if (this.w.m == 0)
    {
      i2 = a(this.g, this.e + 1, this.f, this.w.o);
      i1 = i2;
      if (i2 < 0)
      {
        util.LOGI("use ecdh decrypt_body failed", "");
        i2 = a(this.g, this.e + 1, this.f, this.w.c);
        i1 = i2;
        if (i2 < 0)
        {
          util.LOGI("use kc decrypt_body failed", "");
          i1 = i2;
        }
      }
    }
    for (;;)
    {
      i2 = i1;
      if (i1 < 0) {
        break;
      }
      return c(this.g, this.e + 1, this.f);
      i2 = a(this.g, this.e + 1, this.f, this.w.c);
      i1 = i2;
      if (i2 < 0)
      {
        util.LOGI("use kc decrypt_body failed", "");
        i1 = i2;
      }
    }
  }
  
  /* Error */
  public int b(String paramString, boolean paramBoolean, WUserSigInfo paramWUserSigInfo)
  {
    // Byte code:
    //   0: new 369	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 512	java/lang/Object:getClass	()Ljava/lang/Class;
    //   11: invokevirtual 517	java/lang/Class:getName	()Ljava/lang/String;
    //   14: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 519
    //   20: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: new 369	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   33: ldc 73
    //   35: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   42: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   45: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   58: getfield 520	oicq/wlogin_sdk/request/t:l	I
    //   61: istore 4
    //   63: aload_0
    //   64: invokevirtual 522	oicq/wlogin_sdk/request/j:c	()[B
    //   67: astore 7
    //   69: invokestatic 144	java/lang/System:currentTimeMillis	()J
    //   72: lstore 5
    //   74: new 369	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 524
    //   84: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 526
    //   94: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: getfield 123	oicq/wlogin_sdk/request/j:u	Ljava/lang/String;
    //   101: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 528
    //   107: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 4
    //   112: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc_w 530
    //   118: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_2
    //   122: invokevirtual 533	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   125: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: new 369	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   135: ldc 73
    //   137: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   144: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   147: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: new 535	oicq/wlogin_sdk/request/WtloginMsfListener
    //   159: dup
    //   160: aload_1
    //   161: aload_0
    //   162: getfield 123	oicq/wlogin_sdk/request/j:u	Ljava/lang/String;
    //   165: aload 7
    //   167: iload 4
    //   169: iload_2
    //   170: aload_3
    //   171: invokespecial 538	oicq/wlogin_sdk/request/WtloginMsfListener:<init>	(Ljava/lang/String;Ljava/lang/String;[BIZLoicq/wlogin_sdk/request/WUserSigInfo;)V
    //   174: astore_3
    //   175: new 540	java/lang/Thread
    //   178: dup
    //   179: aload_3
    //   180: invokespecial 543	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 544	java/lang/Thread:start	()V
    //   188: aload_1
    //   189: iload 4
    //   191: i2l
    //   192: invokevirtual 548	java/lang/Thread:join	(J)V
    //   195: aload_3
    //   196: invokevirtual 551	oicq/wlogin_sdk/request/WtloginMsfListener:getRetData	()[B
    //   199: astore_1
    //   200: aload_1
    //   201: ifnonnull +240 -> 441
    //   204: new 369	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 553
    //   214: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_3
    //   218: invokevirtual 556	oicq/wlogin_sdk/request/WtloginMsfListener:getRet	()I
    //   221: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: new 369	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   234: ldc 73
    //   236: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_0
    //   240: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   243: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   246: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: sipush -1000
    //   258: istore 4
    //   260: aload_0
    //   261: getfield 119	oicq/wlogin_sdk/request/j:s	I
    //   264: sipush 2066
    //   267: if_icmpeq +112 -> 379
    //   270: new 128	oicq/wlogin_sdk/report/report_t3
    //   273: dup
    //   274: invokespecial 129	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   277: astore_3
    //   278: aload_3
    //   279: aload_0
    //   280: getfield 119	oicq/wlogin_sdk/request/j:s	I
    //   283: putfield 132	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   286: aload_3
    //   287: aload_0
    //   288: getfield 121	oicq/wlogin_sdk/request/j:t	I
    //   291: putfield 135	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   294: aload_3
    //   295: iload 4
    //   297: putfield 138	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   300: aload_3
    //   301: invokestatic 144	java/lang/System:currentTimeMillis	()J
    //   304: lload 5
    //   306: lsub
    //   307: l2i
    //   308: putfield 147	oicq/wlogin_sdk/report/report_t3:_used	I
    //   311: aload_3
    //   312: iconst_0
    //   313: putfield 150	oicq/wlogin_sdk/report/report_t3:_try	I
    //   316: aload_3
    //   317: ldc 73
    //   319: putfield 153	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   322: aload_3
    //   323: ldc 73
    //   325: putfield 156	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   328: aload_3
    //   329: iconst_0
    //   330: putfield 162	oicq/wlogin_sdk/report/report_t3:_port	I
    //   333: aload_3
    //   334: iconst_0
    //   335: putfield 165	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   338: aload_3
    //   339: iconst_0
    //   340: putfield 172	oicq/wlogin_sdk/report/report_t3:_net	I
    //   343: aload_3
    //   344: ldc 73
    //   346: putfield 175	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   349: iload 4
    //   351: ifne +143 -> 494
    //   354: aload_3
    //   355: aload 7
    //   357: arraylength
    //   358: putfield 178	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   361: aload_3
    //   362: aload_1
    //   363: arraylength
    //   364: putfield 181	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   367: aload_3
    //   368: iconst_3
    //   369: putfield 184	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   372: getstatic 188	oicq/wlogin_sdk/request/t:ag	Loicq/wlogin_sdk/report/report_t1;
    //   375: aload_3
    //   376: invokevirtual 194	oicq/wlogin_sdk/report/report_t1:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   379: new 369	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   386: aload_0
    //   387: invokevirtual 512	java/lang/Object:getClass	()Ljava/lang/Class;
    //   390: invokevirtual 517	java/lang/Class:getName	()Ljava/lang/String;
    //   393: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: ldc_w 558
    //   399: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: iload 4
    //   404: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: new 369	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   417: ldc 73
    //   419: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_0
    //   423: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   426: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   429: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   432: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: iload 4
    //   440: ireturn
    //   441: aload_0
    //   442: aload_1
    //   443: aload_1
    //   444: arraylength
    //   445: invokevirtual 560	oicq/wlogin_sdk/request/j:b	([BI)V
    //   448: iconst_0
    //   449: istore 4
    //   451: goto -191 -> 260
    //   454: astore_3
    //   455: aconst_null
    //   456: astore_1
    //   457: aload_3
    //   458: new 369	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   465: ldc 73
    //   467: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_0
    //   471: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   474: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   477: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   480: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 564	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   486: sipush -1000
    //   489: istore 4
    //   491: goto -231 -> 260
    //   494: aload_3
    //   495: iconst_0
    //   496: putfield 178	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   499: aload_3
    //   500: iconst_0
    //   501: putfield 181	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   504: goto -137 -> 367
    //   507: astore_3
    //   508: goto -51 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	j
    //   0	511	1	paramString	String
    //   0	511	2	paramBoolean	boolean
    //   0	511	3	paramWUserSigInfo	WUserSigInfo
    //   61	429	4	i1	int
    //   72	233	5	l1	long
    //   67	289	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   74	200	454	java/lang/Exception
    //   204	255	507	java/lang/Exception
    //   441	448	507	java/lang/Exception
  }
  
  public int b(byte[] paramArrayOfByte)
  {
    return util.buf_to_int16(paramArrayOfByte, 1);
  }
  
  public String b(boolean paramBoolean)
  {
    String[] arrayOfString = new String[2];
    if (paramBoolean)
    {
      arrayOfString[0] = "wlogin.qq.com";
      arrayOfString[1] = "wlogin1.qq.com";
    }
    for (;;)
    {
      return arrayOfString[java.lang.Math.abs(new java.util.Random().nextInt() % arrayOfString.length)];
      arrayOfString[0] = "wtlogin.qq.com";
      arrayOfString[1] = "wtlogin1.qq.com";
    }
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > this.a)
    {
      this.a = (paramInt + 128);
      this.g = new byte[this.a];
    }
    this.b = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.g, 0, paramInt);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ap localap = new ap();
    paramInt1 = localap.b(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = t.b(this.w.h);
    if (paramInt1 >= 0)
    {
      paramArrayOfByte._last_err_msg.setTitle(new String(localap.f()));
      paramArrayOfByte._last_err_msg.setMessage(new String(localap.g()));
      paramArrayOfByte._last_err_msg.setType(localap.h());
      paramArrayOfByte._last_err_msg.setOtherinfo(new String(localap.i()));
    }
  }
  
  byte[] b(int paramInt)
  {
    Object localObject1 = ByteBuffer.allocate("5.4.0.7".length() + 24 + 2 + 2 + 1 + 4);
    Object localObject2 = t.b(this.w.h);
    ((ByteBuffer)localObject1).put(t.ab);
    ((ByteBuffer)localObject1).putInt((int)((async_context)localObject2)._sappid);
    ((ByteBuffer)localObject1).putInt((int)((async_context)localObject2)._sub_appid);
    ((ByteBuffer)localObject1).putShort((short)0);
    ((ByteBuffer)localObject1).putLong(this.w.f);
    ((ByteBuffer)localObject1).putShort((short)"5.4.0.7".length());
    ((ByteBuffer)localObject1).put("5.4.0.7".getBytes());
    ((ByteBuffer)localObject1).putShort((short)this.s);
    ((ByteBuffer)localObject1).putShort((short)this.t);
    if (paramInt == -1000) {}
    for (int i1 = 1;; i1 = 0)
    {
      ((ByteBuffer)localObject1).put((byte)i1);
      ((ByteBuffer)localObject1).putInt(paramInt);
      localObject2 = new cr().a(0, t.s, 0);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(((ByteBuffer)localObject1).capacity() + 4 + 4 + (cq.j.length + 4) + localObject2.length);
      localByteBuffer.putShort((short)2);
      localByteBuffer.putShort((short)3);
      localByteBuffer.putShort((short)512);
      localByteBuffer.putShort((short)((ByteBuffer)localObject1).capacity());
      localByteBuffer.put(((ByteBuffer)localObject1).array());
      localByteBuffer.putShort((short)2);
      localByteBuffer.putShort((short)cq.j.length);
      localByteBuffer.put(cq.j);
      localByteBuffer.put((byte[])localObject2);
      localObject2 = cryptor.encrypt(localByteBuffer.array(), 0, localByteBuffer.position(), this.w.c);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[0];
      }
      localObject2 = ByteBuffer.allocate(this.w.c.length + 2 + 2 + localObject1.length);
      ((ByteBuffer)localObject2).putShort((short)this.w.c.length);
      ((ByteBuffer)localObject2).put(this.w.c);
      ((ByteBuffer)localObject2).putShort((short)localObject1.length);
      ((ByteBuffer)localObject2).put((byte[])localObject1);
      return ((ByteBuffer)localObject2).array();
    }
  }
  
  /* Error */
  int c(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_3
    //   6: astore_2
    //   7: aload_0
    //   8: iload_1
    //   9: invokevirtual 653	oicq/wlogin_sdk/request/j:b	(I)[B
    //   12: astore 4
    //   14: aload_3
    //   15: astore_2
    //   16: new 369	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   23: astore 6
    //   25: aload_3
    //   26: astore_2
    //   27: invokestatic 339	java/lang/Math:random	()D
    //   30: ldc2_w 654
    //   33: dmul
    //   34: invokestatic 659	java/lang/Math:round	(D)J
    //   37: l2i
    //   38: istore_1
    //   39: aload_3
    //   40: astore_2
    //   41: aload 6
    //   43: iconst_3
    //   44: anewarray 43	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: ldc_w 661
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: ldc_w 663
    //   58: aastore
    //   59: dup
    //   60: iconst_2
    //   61: ldc_w 665
    //   64: aastore
    //   65: iload_1
    //   66: iconst_3
    //   67: irem
    //   68: aaload
    //   69: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 667
    //   75: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 6
    //   83: aload_3
    //   84: astore_2
    //   85: new 669	java/net/URL
    //   88: dup
    //   89: new 369	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 671
    //   99: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 6
    //   104: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc_w 673
    //   110: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokespecial 675	java/net/URL:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 679	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   122: checkcast 681	java/net/HttpURLConnection
    //   125: astore_3
    //   126: aload_3
    //   127: ldc_w 683
    //   130: invokevirtual 686	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   133: aload_3
    //   134: ldc_w 688
    //   137: new 369	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   144: aload 4
    //   146: arraylength
    //   147: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: ldc 73
    //   152: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokevirtual 691	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_3
    //   162: ldc_w 693
    //   165: ldc_w 695
    //   168: invokevirtual 691	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_3
    //   172: getstatic 696	oicq/wlogin_sdk/b/cq:i	I
    //   175: invokevirtual 699	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   178: aload_3
    //   179: getstatic 696	oicq/wlogin_sdk/b/cq:i	I
    //   182: invokevirtual 702	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   185: aload_3
    //   186: iconst_1
    //   187: invokevirtual 706	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   190: aload_3
    //   191: iconst_1
    //   192: invokevirtual 709	java/net/HttpURLConnection:setDoInput	(Z)V
    //   195: aload_3
    //   196: aload_0
    //   197: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   200: getfield 520	oicq/wlogin_sdk/request/t:l	I
    //   203: i2l
    //   204: invokestatic 714	oicq/wlogin_sdk/request/h:a	(Ljava/net/HttpURLConnection;J)Z
    //   207: ifne +46 -> 253
    //   210: ldc_w 716
    //   213: new 369	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   220: ldc 73
    //   222: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_0
    //   226: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   229: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   232: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   235: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_3
    //   242: ifnull +7 -> 249
    //   245: aload_3
    //   246: invokevirtual 719	java/net/HttpURLConnection:disconnect	()V
    //   249: sipush -1000
    //   252: ireturn
    //   253: aload_3
    //   254: invokevirtual 723	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   257: astore_2
    //   258: aload_2
    //   259: aload 4
    //   261: invokevirtual 728	java/io/OutputStream:write	([B)V
    //   264: aload_2
    //   265: invokevirtual 731	java/io/OutputStream:close	()V
    //   268: aload_3
    //   269: invokevirtual 734	java/net/HttpURLConnection:getResponseCode	()I
    //   272: istore_1
    //   273: new 369	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   280: ldc_w 736
    //   283: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: iload_1
    //   287: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: new 369	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   300: ldc 73
    //   302: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_0
    //   306: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   309: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   312: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   315: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: sipush 200
    //   324: iload_1
    //   325: if_icmpeq +15 -> 340
    //   328: aload_3
    //   329: ifnull +7 -> 336
    //   332: aload_3
    //   333: invokevirtual 719	java/net/HttpURLConnection:disconnect	()V
    //   336: sipush -1000
    //   339: ireturn
    //   340: ldc_w 738
    //   343: new 369	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   350: ldc 73
    //   352: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_0
    //   356: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   359: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   362: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   365: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload_3
    //   372: invokevirtual 742	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   375: astore_2
    //   376: new 744	java/io/ByteArrayOutputStream
    //   379: dup
    //   380: invokespecial 745	java/io/ByteArrayOutputStream:<init>	()V
    //   383: astore 4
    //   385: sipush 1024
    //   388: newarray byte
    //   390: astore 5
    //   392: aload_2
    //   393: aload 5
    //   395: invokevirtual 750	java/io/InputStream:read	([B)I
    //   398: istore_1
    //   399: iload_1
    //   400: iconst_m1
    //   401: if_icmpeq +36 -> 437
    //   404: aload 4
    //   406: aload 5
    //   408: iconst_0
    //   409: iload_1
    //   410: invokevirtual 752	java/io/ByteArrayOutputStream:write	([BII)V
    //   413: goto -21 -> 392
    //   416: astore 4
    //   418: aload_3
    //   419: astore_2
    //   420: aload 4
    //   422: invokestatic 755	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;)V
    //   425: aload_3
    //   426: ifnull +7 -> 433
    //   429: aload_3
    //   430: invokevirtual 719	java/net/HttpURLConnection:disconnect	()V
    //   433: sipush -1000
    //   436: ireturn
    //   437: aload_0
    //   438: aload 4
    //   440: invokevirtual 758	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   443: invokevirtual 760	oicq/wlogin_sdk/request/j:d	([B)I
    //   446: sipush -1000
    //   449: if_icmpeq +26 -> 475
    //   452: iconst_1
    //   453: istore_1
    //   454: aload 4
    //   456: invokevirtual 761	java/io/ByteArrayOutputStream:close	()V
    //   459: iload_1
    //   460: ifne +20 -> 480
    //   463: aload_3
    //   464: ifnull +7 -> 471
    //   467: aload_3
    //   468: invokevirtual 719	java/net/HttpURLConnection:disconnect	()V
    //   471: sipush -1000
    //   474: ireturn
    //   475: iconst_0
    //   476: istore_1
    //   477: goto -23 -> 454
    //   480: aload_3
    //   481: ifnull +7 -> 488
    //   484: aload_3
    //   485: invokevirtual 719	java/net/HttpURLConnection:disconnect	()V
    //   488: sipush 257
    //   491: ireturn
    //   492: astore 4
    //   494: aload_2
    //   495: astore_3
    //   496: aload 4
    //   498: astore_2
    //   499: aload_3
    //   500: ifnull +7 -> 507
    //   503: aload_3
    //   504: invokevirtual 719	java/net/HttpURLConnection:disconnect	()V
    //   507: aload_2
    //   508: athrow
    //   509: astore_2
    //   510: goto -11 -> 499
    //   513: astore 4
    //   515: aload 5
    //   517: astore_3
    //   518: goto -100 -> 418
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	j
    //   0	521	1	paramInt	int
    //   6	502	2	localObject1	Object
    //   509	1	2	localObject2	Object
    //   1	517	3	localObject3	Object
    //   12	393	4	localObject4	Object
    //   416	39	4	localException1	Exception
    //   492	5	4	localObject5	Object
    //   513	1	4	localException2	Exception
    //   3	513	5	arrayOfByte	byte[]
    //   23	80	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   126	241	416	java/lang/Exception
    //   253	321	416	java/lang/Exception
    //   340	392	416	java/lang/Exception
    //   392	399	416	java/lang/Exception
    //   404	413	416	java/lang/Exception
    //   437	452	416	java/lang/Exception
    //   454	459	416	java/lang/Exception
    //   7	14	492	finally
    //   16	25	492	finally
    //   27	39	492	finally
    //   41	83	492	finally
    //   85	126	492	finally
    //   420	425	492	finally
    //   126	241	509	finally
    //   253	321	509	finally
    //   340	392	509	finally
    //   392	399	509	finally
    //   404	413	509	finally
    //   437	452	509	finally
    //   454	459	509	finally
    //   7	14	513	java/lang/Exception
    //   16	25	513	java/lang/Exception
    //   27	39	513	java/lang/Exception
    //   41	83	513	java/lang/Exception
    //   85	126	513	java/lang/Exception
  }
  
  public int c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    return 443;
  }
  
  public int c(byte[] paramArrayOfByte, int paramInt)
  {
    this.v = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i1;
    if (paramInt2 < 5)
    {
      i1 = -1009;
      return i1;
    }
    long l2 = 4294967295L;
    f localf = new f();
    Object localObject9 = new g();
    r localr = new r();
    u localu = new u();
    o localo = new o();
    p localp = new p();
    l locall = new l();
    s locals = new s();
    e locale = new e();
    v localv = new v();
    oicq.wlogin_sdk.b.d locald = new oicq.wlogin_sdk.b.d();
    m localm = new m();
    w localw = new w();
    x localx = new x();
    z localz = new z();
    Object localObject4 = new aa();
    ag localag = new ag();
    oicq.wlogin_sdk.b.j localj = new oicq.wlogin_sdk.b.j();
    h localh = new h();
    Object localObject8 = new n();
    Object localObject3 = new ac();
    Object localObject5 = new y();
    aj localaj = new aj();
    ah localah = new ah();
    as localas = new as();
    at localat = new at();
    Object localObject6 = new am();
    cl localcl = new cl();
    ax localax = new ax();
    ay localay = new ay();
    ba localba = new ba();
    bc localbc = new bc();
    bb localbb = new bb();
    aw localaw = new aw();
    bh localbh = new bh();
    be localbe = new be();
    bf localbf = new bf();
    bk localbk = new bk();
    bm localbm = new bm();
    bn localbn = new bn();
    br localbr = new br();
    bs localbs = new bs();
    ad localad = new ad();
    bu localbu = new bu();
    bv localbv = new bv();
    by localby = new by();
    co localco = new co();
    Object localObject7 = new cp();
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte3 = null;
    byte[] arrayOfByte4 = null;
    byte[] arrayOfByte5 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    byte[] arrayOfByte6 = null;
    ai localai = new ai();
    async_context localasync_context = t.b(this.w.h);
    long l3 = localasync_context._sappid;
    long l4 = localasync_context._appid;
    if (this.s == 2064) {
      switch (this.t)
      {
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 12: 
      case 14: 
      case 16: 
      default: 
        return -1012;
      case 9: 
        paramInt2 = 0;
      }
    }
    for (;;)
    {
      label618:
      i1 = c(paramArrayOfByte, paramInt1 + 2);
      int i4 = paramInt1 + 5;
      this.w.d = null;
      label822:
      label872:
      int i2;
      label1135:
      int i5;
      int i3;
      switch (i1)
      {
      default: 
        b(paramArrayOfByte, i4, this.b - i4 - 1);
        paramInt1 = i1;
      case 0: 
        do
        {
          do
          {
            localObject2 = new StringBuilder().append("type:").append(i1).append(" ret:");
            if (paramInt1 <= 0) {
              break label5457;
            }
            localObject1 = "0x" + Integer.toHexString(paramInt1);
            util.LOGI(localObject1, "" + this.w.f);
            if (paramInt1 != 0) {
              break label5466;
            }
            a(null);
            i1 = paramInt1;
            if ((i1 != 10) && (i1 != 161) && (i1 != 162) && (i1 != 164) && (i1 != 165) && (i1 != 166) && (i1 != 154))
            {
              paramInt1 = i1;
              if (i1 >= 128)
              {
                paramInt1 = i1;
                if (i1 > 143) {}
              }
            }
            else
            {
              paramInt1 = -1000;
            }
            i1 = paramInt1;
            if (paramInt2 == 2) {
              break;
            }
            i1 = paramInt1;
            if (paramInt2 == 6) {
              break;
            }
            i1 = paramInt1;
            if (paramInt2 == 7) {
              break;
            }
            a(paramInt2);
            return paramInt1;
            paramInt2 = 1;
            break label618;
            paramInt2 = 2;
            break label618;
            paramInt2 = 3;
            break label618;
            paramInt2 = 4;
            break label618;
            paramInt2 = 5;
            break label618;
            paramInt2 = 6;
            break label618;
            paramInt2 = 7;
            break label618;
            paramInt2 = 0;
            break label618;
            paramInt2 = 0;
            break label618;
            if (paramInt2 != 1) {
              break label2044;
            }
            if (this.w.b == null) {
              return -1006;
            }
            if (localat.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
              this.w.d = localat;
            }
            if (localaw.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
              a(localaw);
            }
            i2 = localu.a(paramArrayOfByte, i4, this.b - i4 - 1, this.w.b);
            paramInt1 = i2;
          } while (i2 < 0);
          localObject9 = localu.b();
          i2 = 2;
          i5 = localObject9.length;
          if (localas.b((byte[])localObject9, 2, i5) > 0) {
            a(localas);
          }
          if (localag.b((byte[])localObject9, 2, i5) > 0) {
            this.w.a(localag.f(), localag.g());
          }
          if (localr.b((byte[])localObject9, 2, i5) >= 0)
          {
            this.w.f = localr.f();
            this.w.a(this.w.g, Long.valueOf(this.w.f));
          }
          localo.b((byte[])localObject9, 2, i5);
          localp.b((byte[])localObject9, 2, i5);
          locall.b((byte[])localObject9, 2, i5);
          locals.b((byte[])localObject9, 2, i5);
          i3 = localv.b((byte[])localObject9, 2, i5);
          paramInt1 = i3;
        } while (i3 < 0);
        if (locale.b((byte[])localObject9, 2, i5) >= 0) {
          localObject2 = locale.b();
        }
        if (localj.b((byte[])localObject9, 2, i5) >= 0) {
          util.set_ksid(t.r, localj.b());
        }
        if (locald.b((byte[])localObject9, 2, i5) >= 0) {
          arrayOfByte1 = locald.b();
        }
        if (localm.b((byte[])localObject9, 2, i5) >= 0) {
          arrayOfByte2 = localm.b();
        }
        if (localw.b((byte[])localObject9, 2, i5) >= 0) {
          arrayOfByte3 = localw.b();
        }
        if (localz.b((byte[])localObject9, 2, i5) >= 0) {
          arrayOfByte4 = localz.b();
        }
        if (((aa)localObject4).b((byte[])localObject9, 2, i5) >= 0) {
          arrayOfByte5 = ((aa)localObject4).b();
        }
        if (((ac)localObject3).b((byte[])localObject9, 2, i5) >= 0)
        {
          localObject1 = ((ac)localObject3).f();
          arrayOfByte6 = ((ac)localObject3).g();
        }
        if (localby.b((byte[])localObject9, 2, i5) >= 0)
        {
          localObject3 = this.w.g;
          if (util.check_uin_account((String)localObject3).booleanValue())
          {
            localObject4 = this.w.e(this.w.f);
            localObject3 = localObject4;
            if (localObject4 != null)
            {
              localObject3 = localObject4;
              if (((String)localObject4).length() > 0)
              {
                this.w.a((String)localObject4, Long.valueOf(this.w.f), localby.f());
                localObject3 = localObject4;
              }
            }
            label1589:
            util.LOGI("put t186: name: " + (String)localObject3 + " uin: " + this.w.f + " pwd=" + localby.f(), "");
          }
        }
        else
        {
          util.LOGI("tgt len:" + util.buf_len(locall.b()) + " tgt_key len:" + util.buf_len(localo.b()) + " st len:" + util.buf_len(locals.b()) + " st_key len:" + util.buf_len(localp.b()) + " stwx_web len:" + util.buf_len((byte[])localObject2) + " a8 len:" + util.buf_len(arrayOfByte1) + " a5 len:" + util.buf_len(arrayOfByte2) + " lskey len:" + util.buf_len(arrayOfByte3) + " skey len:" + util.buf_len(arrayOfByte4) + " sig64 len:" + util.buf_len(arrayOfByte5) + " openid len:" + util.buf_len((byte[])localObject1) + " openkey len:" + util.buf_len(arrayOfByte6) + " pwdflag: " + localby.c() + " " + localby.f(), "" + this.w.f);
          if (localbb.b((byte[])localObject9, 2, i5) >= 0)
          {
            localObject3 = a(localbb);
            if ((localObject3 == null) || (localObject3.length <= 0)) {
              break label2500;
            }
          }
        }
        label2500:
        for (this.w.j = new WFastLoginInfo((byte[])localObject3);; this.w.j = new WFastLoginInfo())
        {
          localObject3 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 3, 0 });
          if (localba.b((byte[])localObject9, 2, i5) >= 0)
          {
            localObject3[0] = localba.f();
            localObject3[1] = localba.g();
            localObject3[2] = localba.h();
          }
          localObject4 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 5, 0 });
          paramInt1 = 0;
          while (paramInt1 < 5)
          {
            localObject4[paramInt1] = new byte[0];
            paramInt1 += 1;
          }
          label2044:
          if (paramInt2 == 2)
          {
            if (localbv.b(paramArrayOfByte, i4, this.b - i4) >= 0) {
              localasync_context._msalt = localbv.f();
            }
            if (f() == 3)
            {
              if (localr.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
              {
                this.w.f = localr.f();
                this.w.a(this.w.g, Long.valueOf(this.w.f));
              }
              if (localf.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
                localasync_context._t104 = localf;
              }
              paramInt1 = 0;
              break;
            }
            if (localat.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
              this.w.d = localat;
            }
            if (localaw.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
              a(localaw);
            }
            i2 = localu.a(paramArrayOfByte, i4, this.b - i4 - 1, localasync_context._tgtgt_key);
            break label1135;
          }
          if ((paramInt2 == 3) || (paramInt2 == 7))
          {
            if (localbv.b(paramArrayOfByte, i4, this.b - i4) >= 0) {
              localasync_context._msalt = localbv.f();
            }
            if (localr.b(paramArrayOfByte, i4, this.b - i4) >= 0)
            {
              this.w.f = localr.f();
              this.w.a(this.w.g, Long.valueOf(this.w.f));
            }
            i2 = localf.b(paramArrayOfByte, i4, this.b - i4);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t104 = localf;
            paramInt1 = 0;
            break;
          }
          if (localat.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
            this.w.d = localat;
          }
          if (localaw.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
            a(localaw);
          }
          i2 = localu.a(paramArrayOfByte, i4, this.b - i4 - 1, localasync_context._tgtgt_key);
          r.D = 0;
          break label1135;
          this.w.a((String)localObject3, Long.valueOf(this.w.f), localby.f());
          break label1589;
        }
        paramInt1 = ((n)localObject8).b((byte[])localObject9, 2, i5);
        if ((localh.b((byte[])localObject9, 2, i5) >= 0) && (paramInt1 >= 0))
        {
          localObject8 = ((n)localObject8).b();
          localObject4[0] = ((byte[])b(localh.b(), (byte[])localObject8).clone());
        }
        if (localbc.b((byte[])localObject9, 2, i5) >= 0) {
          localObject4[1] = localbc.b();
        }
        if (((cp)localObject7).b((byte[])localObject9, 2, i5) >= 0) {
          localObject4[4] = ((cp)localObject7).b();
        }
        if (localasync_context._sec_guid_flag)
        {
          localObject4[2] = localasync_context._G;
          localObject4[3] = localasync_context._dpwd;
          localObject4[4] = localasync_context._t403.b();
          localasync_context._sec_guid_flag = false;
        }
        localObject7 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 12, 0 });
        paramInt1 = 0;
        while (paramInt1 < 12)
        {
          localObject7[paramInt1] = new byte[0];
          paramInt1 += 1;
        }
        if (localai.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[0] = localai.b();
        }
        if (localah.b((byte[])localObject9, 2, i5) >= 0)
        {
          localObject7[1] = localah.f();
          localObject1 = localah.g();
        }
        if (((am)localObject6).b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[2] = ((am)localObject6).b();
        }
        if (localcl.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[3] = localcl.b();
        }
        if (localax.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[4] = localax.b();
        }
        if (localbh.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[5] = localbh.b();
        }
        if (localbe.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[6] = localbe.b();
        }
        if (localbf.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[7] = localbf.b();
        }
        localObject6 = new cg();
        if (((cg)localObject6).b((byte[])localObject9, 2, i5) >= 0)
        {
          localObject7[8] = ((cg)localObject6).g();
          localObject1 = ((cg)localObject6).f();
        }
        break;
      }
      label3456:
      label3587:
      label3597:
      for (;;)
      {
        localObject6 = new ci();
        if (((ci)localObject6).b((byte[])localObject9, 2, i5) >= 0)
        {
          localObject7[9] = ((ci)localObject6).f();
          localObject7[10] = ((ci)localObject6).g();
        }
        localObject6 = new a(515);
        if (((a)localObject6).b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[11] = ((a)localObject6).b();
        }
        localObject6 = new a(791);
        long l1;
        if (((a)localObject6).b((byte[])localObject9, 2, i5) >= 0)
        {
          oicq.wlogin_sdk.sharemem.WloginSigInfo._QRPUSHSig = ((a)localObject6).b();
          util.LOGI("encrypt_a1 len:" + util.buf_len(localObject4[0]) + " no_pic_sig len:" + util.buf_len(localObject4[1]) + " G len:" + util.buf_len(localObject4[2]) + " dpwd len:" + util.buf_len(localObject4[3]) + " randseed len:" + util.buf_len(localObject4[4]) + " vkey len:" + util.buf_len(localObject7[0]) + " openid len:" + util.buf_len((byte[])localObject1) + " access_token len:" + util.buf_len(localObject7[1]) + " d2 len:" + util.buf_len(localObject7[2]) + " d2_key len:" + util.buf_len(localObject7[3]) + " sid len:" + util.buf_len(localObject7[4]) + " aq_sig len:" + util.buf_len(localObject7[5]) + " pskey len:" + util.buf_len(localObject7[6]) + " super_key len:" + util.buf_len(localObject7[7]) + " paytoken len:" + util.buf_len(localObject7[8]) + " pf len:" + util.buf_len(localObject7[9]) + " pfkey len:" + util.buf_len(localObject7[10]) + " da2 len:" + util.buf_len(localObject7[11]), "" + this.w.f);
          if (((y)localObject5).b((byte[])localObject9, 2, i5) >= 0) {
            l2 = 0xFFFFFFFF & ((y)localObject5).f();
          }
          localObject5 = new long[7];
          paramInt1 = 2;
          l1 = 2160000L;
          label3407:
          paramInt1 = localaj.b((byte[])localObject9, paramInt1, i5);
          if (paramInt1 < 0) {
            break label3648;
          }
          if (localaj.f() == 0) {
            break label5523;
          }
          l1 = localaj.f();
        }
        label3474:
        label5523:
        for (;;)
        {
          if (localaj.g() != 0)
          {
            localObject5[0] = localaj.g();
            if (localaj.h() == 0) {
              break label3587;
            }
            localObject5[1] = localaj.h();
            if (localaj.i() == 0) {
              break label3597;
            }
            localObject5[2] = localaj.i();
            label3492:
            if (localaj.j() == 0) {
              break label3607;
            }
            localObject5[3] = localaj.j();
            label3510:
            if (localaj.k() == 0) {
              break label3617;
            }
            localObject5[4] = localaj.k();
            label3528:
            if (localaj.l() == 0) {
              break label3627;
            }
            localObject5[5] = localaj.l();
          }
          for (;;)
          {
            if (localaj.m() == 0) {
              break label3637;
            }
            localObject5[6] = localaj.m();
            break label3407;
            oicq.wlogin_sdk.sharemem.WloginSigInfo._QRPUSHSig = new byte[0];
            break;
            localObject5[0] = 1641600L;
            break label3456;
            localObject5[1] = 86400L;
            break label3474;
            localObject5[2] = 1728000L;
            break label3492;
            label3607:
            localObject5[3] = 72000L;
            break label3510;
            label3617:
            localObject5[4] = 6000L;
            break label3528;
            label3627:
            localObject5[5] = 1728000L;
          }
          label3637:
          localObject5[6] = 1728000L;
          break label3407;
          label3648:
          util.LOGI("sappid:" + l3 + " appid:" + l4 + " app_pri:" + l2 + " login_bitmap:" + localasync_context._login_bitmap + " tk_valid:" + 0L + " a2_valid:" + l1 + " lskey_valid:" + localObject5[0] + " skey_valid:" + localObject5[1] + " vkey_valid:" + localObject5[2] + " a8_valid:" + localObject5[3] + " stweb_valid:" + localObject5[4] + " d2_valid:" + localObject5[5] + " sid_valid:" + localObject5[6], "" + this.w.f);
          i3 = this.w.a(this.w.f, l3, (byte[][])localObject4, l4, l2, t.f(), t.f() + 0L, l1 + t.f(), localv.f(), localv.g(), localv.h(), localv.i(), (byte[][])localObject3, locall.b(), localo.b(), locals.b(), localp.b(), (byte[])localObject2, arrayOfByte2, arrayOfByte1, arrayOfByte3, arrayOfByte4, arrayOfByte5, (byte[])localObject1, arrayOfByte6, (byte[][])localObject7, (long[])localObject5, localasync_context._login_bitmap);
          paramInt1 = i2;
          if (i3 != 0)
          {
            localObject1 = new ErrMsg();
            ((ErrMsg)localObject1).setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
            a((ErrMsg)localObject1);
            util.LOGI("put_siginfo fail,ret=" + i3, "" + this.w.f);
            paramInt1 = i3;
            break;
          }
          for (;;)
          {
            paramInt1 = localx.b((byte[])localObject9, paramInt1, i5);
            if (paramInt1 < 0) {
              break;
            }
            this.w.a(this.w.f, localx.f(), t.f(), t.f() + 0L, localx.h(), localx.g());
          }
          paramInt1 = 0;
          break;
          this.w.c(this.w.f, l3);
          b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i1;
          break;
          i2 = localf.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t104 = localf;
          localObject1 = new cc();
          if (((cc)localObject1).b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            a(new ErrMsg(i1, "", "", ((cc)localObject1).f()));
            paramInt1 = i1;
            break;
          }
          i2 = ((g)localObject9).b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t105 = ((g)localObject9);
          if (localay.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {}
          for (localasync_context._t165 = localay;; localasync_context._t165 = new ay())
          {
            a(null);
            break;
          }
          this.w.c(this.w.f, l3);
          i2 = localag.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          this.w.a(localag.f(), localag.g());
          b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i1;
          break;
          localObject1 = new a(405);
          i2 = ((a)localObject1).b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          oicq.wlogin_sdk.sharemem.WloginSigInfo._LHSig = ((a)localObject1).b();
          b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i1;
          break;
          if (localr.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            this.w.f = localr.f();
            this.w.a(this.w.g, Long.valueOf(this.w.f));
          }
          i2 = localf.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t104 = localf;
          i2 = localbk.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t174 = localbk;
          if (localbm.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            localasync_context._devlock_info.CountryCode = new String(localbm.f());
            localasync_context._devlock_info.Mobile = new String(localbm.g());
            localasync_context._devlock_info.MbItemSmsCodeStatus = localbm.h();
            localasync_context._devlock_info.AvailableMsgCount = localbm.i();
            localasync_context._devlock_info.TimeLimit = localbm.j();
          }
          localObject1 = new cf();
          if (((cf)localObject1).b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            localasync_context._devlock_info.BakCountryCode = ((cf)localObject1).g();
            localasync_context._devlock_info.BakMobile = ((cf)localObject1).h();
            localasync_context._devlock_info.BakMobileState = ((cf)localObject1).f();
          }
          if (localbn.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
            localasync_context._devlock_info.UnionVerifyUrl = new String(localbn.f());
          }
          if (localbr.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            localasync_context._devlock_info.MbGuideType = localbr.f();
            localasync_context._devlock_info.MbGuideMsg = new String(localbr.g());
            localasync_context._devlock_info.MbGuideInfoType = localbr.h();
            localasync_context._devlock_info.MbGuideInfo = new String(localbr.i());
          }
          if (localbs.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
            localasync_context._devlock_info.VerifyReason = new String(localbs.b());
          }
          if (localco.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            localasync_context._t402 = localco;
            label4949:
            if (((cp)localObject7).b(paramArrayOfByte, i4, this.b - i4 - 1) < 0) {
              break label5013;
            }
          }
          label5013:
          for (localasync_context._t403 = ((cp)localObject7);; localasync_context._t403 = new cp())
          {
            b(paramArrayOfByte, i4, this.b - i4 - 1);
            paramInt1 = i1;
            break;
            localasync_context._t402 = new co();
            break label4949;
          }
          b(paramArrayOfByte, i4, this.b - i4 - 1);
          this.w.a(this.w.g);
          paramInt1 = i1;
          break;
          i2 = localaw.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          a(localaw);
          b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i1;
          break;
          if (localr.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            this.w.f = localr.f();
            this.w.a(this.w.g, Long.valueOf(this.w.f));
          }
          i2 = localf.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t104 = localf;
          i2 = localco.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t402 = localco;
          i2 = ((cp)localObject7).b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t403 = ((cp)localObject7);
          b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i1;
          break;
          i2 = localf.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t104 = localf;
          i2 = localad.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t126 = localad;
          i2 = localbu.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._smslogin_msgcnt = localbu.f();
          localasync_context._smslogin_timelimit = localbu.g();
          i2 = localbv.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._msalt = localbv.f();
          paramInt1 = 0;
          break;
          label5457:
          localObject1 = Integer.valueOf(paramInt1);
          break label822;
          label5466:
          new cq().b(paramArrayOfByte, i4, this.b - i4 - 1);
          i1 = paramInt1;
          if (!cq.h) {
            break label872;
          }
          i2 = c(paramInt1);
          i1 = paramInt1;
          if (i2 == -1000) {
            break label872;
          }
          i1 = i2;
          break label872;
        }
      }
      paramInt2 = 0;
    }
  }
  
  public byte[] c()
  {
    byte[] arrayOfByte = new byte[this.b];
    System.arraycopy(this.g, 0, arrayOfByte, 0, this.b);
    return arrayOfByte;
  }
  
  public byte[] c(byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((t.z == null) || (t.z.length <= 0))
    {
      localObject = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, "%4;7t>;28<fc.5*6".getBytes());
      if (localObject != null) {
        break label210;
      }
    }
    label210:
    for (paramArrayOfByte = (byte[])paramArrayOfByte.clone();; paramArrayOfByte = (byte[])localObject)
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 16))
      {
        return (byte[])null;
        localObject = new byte[16];
        if (t.z.length > localObject.length) {
          System.arraycopy(t.z, 0, localObject, 0, localObject.length);
        }
        for (;;)
        {
          arrayOfByte = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, (byte[])localObject);
          if (arrayOfByte != null)
          {
            localObject = arrayOfByte;
            if (arrayOfByte.length > 0) {
              break;
            }
          }
          localObject = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, "%4;7t>;28<fc.5*6".getBytes());
          break;
          System.arraycopy(t.z, 0, localObject, 0, t.z.length);
          i1 = t.z.length;
          while (i1 < localObject.length)
          {
            localObject[i1] = ((byte)(i1 + 1));
            i1 += 1;
          }
        }
      }
      int i1 = paramArrayOfByte.length - 16;
      localObject = new byte[i1];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, i1);
      byte[] arrayOfByte = new byte[16];
      System.arraycopy(paramArrayOfByte, i1, arrayOfByte, 0, 16);
      t.b(this.w.h)._tgtgt_key = arrayOfByte;
      return localObject;
    }
  }
  
  int d(byte[] paramArrayOfByte)
  {
    Object localObject3 = null;
    localObject1 = null;
    util.LOGI("notice len " + paramArrayOfByte.length, this.w.f + "");
    localObject2 = util.string_to_buf("30820122300d06092a864886f70d01010105000382010f003082010a0282010100bb65a9189e42aabf8c4c97b8bb7e35f6239df71152c0108d5c9b98d86ed7b14fa4b6e2ca5749eda03b5746e97b10c1772eab364fcedbfc4b3bb4d839ed97f657daa54622b54dfb29fe66f37f3e26e779675fec2337d0f8cbdf550b04f936be0927bbbecc851b6d966a3ba51c9747a8c588979ec248d5c8a66d1dd4fed0bcd3eb78725fd04b25cdceeac17d0068f07b3a2a360105cc1f4a0fd361d8d3ff0a9e5598b4196304635482be7ceda63a80479aa396a341fb206c81d7c476f860ac6d90734d523d1015eb73f390104c2bb85d0c05db4d11feae941ff5c92be9a1c123283dc2e0dc1368420d6f71cc50e343534e7c0ff16345680859e14c35f1f021cdfb0203010001");
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new byte[localByteBuffer.getShort()];
      localByteBuffer.get(paramArrayOfByte);
      Object localObject4 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      ((Cipher)localObject4).init(2, (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec((byte[])localObject2)));
      paramArrayOfByte = ((Cipher)localObject4).doFinal(paramArrayOfByte);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        localObject4 = ByteBuffer.wrap(paramArrayOfByte);
        localObject2 = new byte[((ByteBuffer)localObject4).getShort()];
        paramArrayOfByte = localObject3;
      }
      int i2;
      int i1;
      int i3;
      byte[] arrayOfByte;
      return -1000;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          ((ByteBuffer)localObject4).get((byte[])localObject2);
          paramArrayOfByte = localObject3;
          localObject1 = new byte[((ByteBuffer)localObject4).getShort()];
          paramArrayOfByte = (byte[])localObject1;
          ((ByteBuffer)localObject4).get((byte[])localObject1);
          paramArrayOfByte = (byte[])localObject1;
          ((ByteBuffer)localObject4).getInt();
          paramArrayOfByte = (byte[])localObject2;
          if ((paramArrayOfByte != null) && (localObject1 != null)) {
            continue;
          }
          return -1000;
        }
        catch (Exception localException2)
        {
          localObject1 = paramArrayOfByte;
          paramArrayOfByte = (byte[])localObject2;
          continue;
        }
        localException1 = localException1;
        paramArrayOfByte = null;
        util.printException(localException1);
      }
      localObject2 = new byte[localByteBuffer.limit() - localByteBuffer.position()];
      localByteBuffer.get((byte[])localObject2);
      paramArrayOfByte = cryptor.decrypt((byte[])localObject2, 0, localObject2.length, paramArrayOfByte);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
        return -1000;
      }
      if (!Arrays.equals((byte[])localObject1, MD5.toMD5Byte(paramArrayOfByte))) {
        return -1000;
      }
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
      paramArrayOfByte.getShort();
      localObject1 = new ErrMsg();
      i2 = paramArrayOfByte.getShort();
      if (i2 == 0) {
        return -1000;
      }
      i1 = 0;
      if (i1 < i2)
      {
        i3 = paramArrayOfByte.getShort();
        localObject2 = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get((byte[])localObject2);
        switch (i3)
        {
        }
        for (;;)
        {
          i1 += 1;
          break;
          localObject2 = ByteBuffer.wrap((byte[])localObject2);
          i3 = ((ByteBuffer)localObject2).getInt();
          util.LOGI("what " + i3, "");
          if (i3 != 0) {
            return -1000;
          }
          arrayOfByte = new byte[((ByteBuffer)localObject2).getShort()];
          util.LOGI("msg len " + arrayOfByte.length, "");
          if (arrayOfByte.length == 0) {
            return -1000;
          }
          ((ByteBuffer)localObject2).get(arrayOfByte);
          ((ErrMsg)localObject1).setMessage(new String(arrayOfByte));
          ((ErrMsg)localObject1).setType(257);
          continue;
          ((ErrMsg)localObject1).setTitle(new String((byte[])localObject2));
        }
      }
      a((ErrMsg)localObject1);
      return ((ErrMsg)localObject1).getType();
    }
  }
  
  public Socket d()
  {
    return this.w.ac;
  }
  
  /* Error */
  public int e()
  {
    // Byte code:
    //   0: new 369	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 512	java/lang/Object:getClass	()Ljava/lang/Class;
    //   11: invokevirtual 517	java/lang/Class:getName	()Ljava/lang/String;
    //   14: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 1470
    //   20: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: new 369	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   33: ldc 73
    //   35: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   42: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   45: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: invokevirtual 522	oicq/wlogin_sdk/request/j:c	()[B
    //   58: astore 24
    //   60: iconst_0
    //   61: istore_3
    //   62: iconst_0
    //   63: istore_2
    //   64: iconst_0
    //   65: istore_1
    //   66: lconst_0
    //   67: lstore 9
    //   69: aload_0
    //   70: invokevirtual 1472	oicq/wlogin_sdk/request/j:d	()Ljava/net/Socket;
    //   73: astore 18
    //   75: iconst_0
    //   76: istore 14
    //   78: iconst_0
    //   79: istore 13
    //   81: iconst_0
    //   82: istore 4
    //   84: ldc 73
    //   86: astore 19
    //   88: ldc 73
    //   90: astore 17
    //   92: iload_1
    //   93: bipush 6
    //   95: if_icmpge +2235 -> 2330
    //   98: iload_1
    //   99: ifeq +9 -> 108
    //   102: getstatic 312	oicq/wlogin_sdk/request/t:r	Landroid/content/Context;
    //   105: invokestatic 1476	oicq/wlogin_sdk/tools/util:chg_retry_type	(Landroid/content/Context;)V
    //   108: getstatic 312	oicq/wlogin_sdk/request/t:r	Landroid/content/Context;
    //   111: invokestatic 1480	oicq/wlogin_sdk/tools/util:is_wap_retry	(Landroid/content/Context;)Z
    //   114: istore 15
    //   116: aload_0
    //   117: aconst_null
    //   118: putfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   121: iload_1
    //   122: ifeq +27 -> 149
    //   125: aload_0
    //   126: getfield 119	oicq/wlogin_sdk/request/j:s	I
    //   129: sipush 2066
    //   132: if_icmpeq +17 -> 149
    //   135: aload_0
    //   136: iload_2
    //   137: lload 9
    //   139: iload 4
    //   141: iload_1
    //   142: iload 15
    //   144: iload 13
    //   146: invokespecial 1482	oicq/wlogin_sdk/request/j:a	(IJIIZZ)V
    //   149: invokestatic 144	java/lang/System:currentTimeMillis	()J
    //   152: lstore 9
    //   154: iload 15
    //   156: ifeq +1035 -> 1191
    //   159: new 369	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 1484
    //   169: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: iload_1
    //   173: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: ldc_w 1486
    //   179: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: new 369	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   192: ldc 73
    //   194: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   201: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   204: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: iload_1
    //   215: iload 15
    //   217: invokevirtual 1488	oicq/wlogin_sdk/request/j:a	(IZ)Ljava/lang/String;
    //   220: astore 23
    //   222: iload 13
    //   224: istore 14
    //   226: getstatic 312	oicq/wlogin_sdk/request/t:r	Landroid/content/Context;
    //   229: invokestatic 1491	oicq/wlogin_sdk/tools/util:is_wap_proxy_retry	(Landroid/content/Context;)Z
    //   232: istore 13
    //   234: iload 13
    //   236: ifeq +2448 -> 2684
    //   239: iload 13
    //   241: istore 14
    //   243: invokestatic 1494	oicq/wlogin_sdk/tools/util:get_proxy_ip	()Ljava/lang/String;
    //   246: astore 20
    //   248: iload 13
    //   250: istore 14
    //   252: invokestatic 1497	oicq/wlogin_sdk/tools/util:get_proxy_port	()I
    //   255: istore_2
    //   256: aload 20
    //   258: ifnull +20 -> 278
    //   261: iload 13
    //   263: istore 14
    //   265: aload 20
    //   267: invokevirtual 309	java/lang/String:length	()I
    //   270: ifle +8 -> 278
    //   273: iload_2
    //   274: iconst_m1
    //   275: if_icmpne +2417 -> 2692
    //   278: iconst_0
    //   279: istore 13
    //   281: iconst_0
    //   282: istore 14
    //   284: new 369	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   291: ldc_w 1499
    //   294: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 20
    //   299: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc_w 1501
    //   305: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: iload_2
    //   309: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   312: ldc_w 1503
    //   315: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: iconst_0
    //   319: invokevirtual 533	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   322: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: new 369	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   332: ldc 73
    //   334: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_0
    //   338: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   341: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   344: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   347: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   353: goto +2339 -> 2692
    //   356: iload 13
    //   358: ifeq +322 -> 680
    //   361: iload 13
    //   363: istore 14
    //   365: new 669	java/net/URL
    //   368: dup
    //   369: new 369	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 671
    //   379: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload 20
    //   384: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc_w 1505
    //   390: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: iload_2
    //   394: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: ldc_w 1507
    //   400: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokespecial 675	java/net/URL:<init>	(Ljava/lang/String;)V
    //   409: astore 20
    //   411: new 369	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 1509
    //   421: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: iload 13
    //   426: invokevirtual 533	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   429: ldc_w 1511
    //   432: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload 20
    //   437: invokevirtual 922	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   440: ldc_w 1513
    //   443: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload 23
    //   448: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: new 369	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   461: ldc 73
    //   463: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_0
    //   467: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   470: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   473: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   476: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: aload 20
    //   484: invokevirtual 679	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   487: checkcast 681	java/net/HttpURLConnection
    //   490: astore 20
    //   492: aload 20
    //   494: ldc_w 683
    //   497: invokevirtual 686	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   500: iload 13
    //   502: ifeq +13 -> 515
    //   505: aload 20
    //   507: ldc_w 1515
    //   510: aload 23
    //   512: invokevirtual 691	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload 20
    //   517: ldc_w 693
    //   520: ldc_w 695
    //   523: invokevirtual 691	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: aload 20
    //   528: ldc_w 1517
    //   531: ldc_w 1519
    //   534: invokevirtual 691	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: aload 20
    //   539: ldc_w 688
    //   542: aload 24
    //   544: arraylength
    //   545: invokestatic 1521	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   548: invokevirtual 691	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: aload 20
    //   553: aload_0
    //   554: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   557: getfield 520	oicq/wlogin_sdk/request/t:l	I
    //   560: invokevirtual 699	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   563: aload 20
    //   565: aload_0
    //   566: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   569: getfield 520	oicq/wlogin_sdk/request/t:l	I
    //   572: invokevirtual 702	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   575: aload 20
    //   577: iconst_1
    //   578: invokevirtual 706	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   581: aload 20
    //   583: iconst_1
    //   584: invokevirtual 709	java/net/HttpURLConnection:setDoInput	(Z)V
    //   587: ldc_w 1523
    //   590: new 369	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   597: ldc 73
    //   599: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload_0
    //   603: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   606: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   609: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   612: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: aload 20
    //   620: aload_0
    //   621: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   624: getfield 520	oicq/wlogin_sdk/request/t:l	I
    //   627: i2l
    //   628: invokestatic 714	oicq/wlogin_sdk/request/h:a	(Ljava/net/HttpURLConnection;J)Z
    //   631: ifne +230 -> 861
    //   634: ldc_w 1525
    //   637: new 369	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   644: ldc 73
    //   646: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: aload_0
    //   650: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   653: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   656: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   659: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: iload_1
    //   666: iconst_1
    //   667: iadd
    //   668: istore_1
    //   669: sipush -1000
    //   672: istore_2
    //   673: iload 15
    //   675: istore 14
    //   677: goto -585 -> 92
    //   680: iload 13
    //   682: istore 14
    //   684: aload_0
    //   685: aload 23
    //   687: iconst_0
    //   688: aload_0
    //   689: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   692: getfield 520	oicq/wlogin_sdk/request/t:l	I
    //   695: i2l
    //   696: invokestatic 1530	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   699: putfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   702: iload 13
    //   704: istore 14
    //   706: aload_0
    //   707: getfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   710: ifnull +1967 -> 2677
    //   713: iload 13
    //   715: istore 14
    //   717: aload_0
    //   718: getfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   721: invokevirtual 200	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   724: invokevirtual 206	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   727: astore 21
    //   729: iload 13
    //   731: istore 14
    //   733: aload 17
    //   735: aload 21
    //   737: invokevirtual 1533	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   740: ifeq +57 -> 797
    //   743: iload 13
    //   745: istore 14
    //   747: new 410	java/lang/Exception
    //   750: dup
    //   751: new 369	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   758: ldc_w 1535
    //   761: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload 17
    //   766: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokespecial 1536	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   775: athrow
    //   776: astore 20
    //   778: iload 14
    //   780: istore 13
    //   782: sipush -1000
    //   785: istore_2
    //   786: iload_1
    //   787: iconst_1
    //   788: iadd
    //   789: istore_1
    //   790: iload 15
    //   792: istore 14
    //   794: goto -702 -> 92
    //   797: aload 21
    //   799: astore 20
    //   801: aload_0
    //   802: aconst_null
    //   803: putfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   806: aload 21
    //   808: astore 22
    //   810: aload 21
    //   812: astore 17
    //   814: aload 17
    //   816: astore 20
    //   818: new 669	java/net/URL
    //   821: dup
    //   822: new 369	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   829: ldc_w 671
    //   832: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: aload 22
    //   837: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: ldc_w 1507
    //   843: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokespecial 675	java/net/URL:<init>	(Ljava/lang/String;)V
    //   852: astore 21
    //   854: aload 21
    //   856: astore 20
    //   858: goto -447 -> 411
    //   861: ldc_w 1538
    //   864: new 369	java/lang/StringBuilder
    //   867: dup
    //   868: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   871: ldc 73
    //   873: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: aload_0
    //   877: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   880: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   883: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   886: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   892: aload 20
    //   894: invokevirtual 723	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   897: astore 21
    //   899: aload 21
    //   901: aload 24
    //   903: iconst_0
    //   904: aload 24
    //   906: arraylength
    //   907: invokevirtual 1539	java/io/OutputStream:write	([BII)V
    //   910: aload 21
    //   912: invokevirtual 1542	java/io/OutputStream:flush	()V
    //   915: aload 20
    //   917: invokevirtual 734	java/net/HttpURLConnection:getResponseCode	()I
    //   920: istore_2
    //   921: new 369	java/lang/StringBuilder
    //   924: dup
    //   925: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   928: ldc_w 1544
    //   931: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: iload_2
    //   935: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   938: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: new 369	java/lang/StringBuilder
    //   944: dup
    //   945: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   948: ldc 73
    //   950: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: aload_0
    //   954: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   957: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   960: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   963: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   969: sipush 200
    //   972: iload_2
    //   973: if_icmpeq +18 -> 991
    //   976: iload_1
    //   977: iconst_1
    //   978: iadd
    //   979: istore_1
    //   980: sipush -1000
    //   983: istore_2
    //   984: iload 15
    //   986: istore 14
    //   988: goto -896 -> 92
    //   991: aload 20
    //   993: invokevirtual 742	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   996: astore 21
    //   998: aload 18
    //   1000: astore 20
    //   1002: aload 19
    //   1004: astore 18
    //   1006: aload 17
    //   1008: astore 19
    //   1010: aload 20
    //   1012: astore 17
    //   1014: aload 17
    //   1016: astore 20
    //   1018: iload_1
    //   1019: istore_2
    //   1020: ldc_w 1546
    //   1023: new 369	java/lang/StringBuilder
    //   1026: dup
    //   1027: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1030: ldc 73
    //   1032: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: aload_0
    //   1036: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1039: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   1042: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1045: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1051: iconst_0
    //   1052: istore 5
    //   1054: iconst_0
    //   1055: istore 6
    //   1057: aload 17
    //   1059: astore 20
    //   1061: iload_1
    //   1062: istore_2
    //   1063: iload 6
    //   1065: aload_0
    //   1066: getfield 91	oicq/wlogin_sdk/request/j:e	I
    //   1069: iconst_1
    //   1070: iadd
    //   1071: if_icmpge +36 -> 1107
    //   1074: aload 17
    //   1076: astore 20
    //   1078: iload_1
    //   1079: istore_2
    //   1080: aload 21
    //   1082: aload_0
    //   1083: getfield 117	oicq/wlogin_sdk/request/j:r	[B
    //   1086: iload 6
    //   1088: aload_0
    //   1089: getfield 91	oicq/wlogin_sdk/request/j:e	I
    //   1092: iconst_1
    //   1093: iadd
    //   1094: iload 6
    //   1096: isub
    //   1097: invokevirtual 1548	java/io/InputStream:read	([BII)I
    //   1100: istore 5
    //   1102: iload 5
    //   1104: ifge +804 -> 1908
    //   1107: iload 5
    //   1109: ifge +809 -> 1918
    //   1112: sipush -1000
    //   1115: istore 5
    //   1117: iload_1
    //   1118: iconst_1
    //   1119: iadd
    //   1120: istore_1
    //   1121: aload 17
    //   1123: astore 20
    //   1125: iload 15
    //   1127: ifne +42 -> 1169
    //   1130: aload 17
    //   1132: astore 20
    //   1134: iload_1
    //   1135: istore_2
    //   1136: aload 17
    //   1138: invokevirtual 1551	java/net/Socket:close	()V
    //   1141: aload 17
    //   1143: astore 20
    //   1145: iload_1
    //   1146: istore_2
    //   1147: aload_0
    //   1148: aconst_null
    //   1149: putfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1152: aconst_null
    //   1153: astore 20
    //   1155: aconst_null
    //   1156: astore 17
    //   1158: iload_1
    //   1159: istore_2
    //   1160: aload_0
    //   1161: aconst_null
    //   1162: invokevirtual 1553	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   1165: aload 17
    //   1167: astore 20
    //   1169: aload 19
    //   1171: astore 17
    //   1173: aload 18
    //   1175: astore 19
    //   1177: iload 5
    //   1179: istore_2
    //   1180: iload 15
    //   1182: istore 14
    //   1184: aload 20
    //   1186: astore 18
    //   1188: goto -1096 -> 92
    //   1191: new 369	java/lang/StringBuilder
    //   1194: dup
    //   1195: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1198: ldc_w 1555
    //   1201: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: iload_1
    //   1205: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1208: ldc_w 1486
    //   1211: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1217: new 369	java/lang/StringBuilder
    //   1220: dup
    //   1221: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1224: ldc 73
    //   1226: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: aload_0
    //   1230: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1233: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   1236: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1239: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1242: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1245: aload 18
    //   1247: ifnonnull +1427 -> 2674
    //   1250: ldc 73
    //   1252: astore 20
    //   1254: iconst_1
    //   1255: istore_2
    //   1256: iconst_1
    //   1257: istore 4
    //   1259: aload_0
    //   1260: getfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1263: ifnonnull +98 -> 1361
    //   1266: aload_0
    //   1267: iload_1
    //   1268: iload 15
    //   1270: invokevirtual 1488	oicq/wlogin_sdk/request/j:a	(IZ)Ljava/lang/String;
    //   1273: astore 20
    //   1275: new 369	java/lang/StringBuilder
    //   1278: dup
    //   1279: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1282: ldc_w 1557
    //   1285: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: aload 20
    //   1290: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: ldc_w 1559
    //   1296: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1302: new 369	java/lang/StringBuilder
    //   1305: dup
    //   1306: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1309: ldc 73
    //   1311: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: aload_0
    //   1315: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1318: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   1321: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1330: aload_0
    //   1331: aload_0
    //   1332: iload 15
    //   1334: invokevirtual 159	oicq/wlogin_sdk/request/j:c	(Z)I
    //   1337: putfield 115	oicq/wlogin_sdk/request/j:q	I
    //   1340: aload_0
    //   1341: aload 20
    //   1343: aload_0
    //   1344: getfield 115	oicq/wlogin_sdk/request/j:q	I
    //   1347: aload_0
    //   1348: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1351: getfield 520	oicq/wlogin_sdk/request/t:l	I
    //   1354: i2l
    //   1355: invokestatic 1530	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   1358: putfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1361: aload_0
    //   1362: getfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1365: ifnull +21 -> 1386
    //   1368: aload 19
    //   1370: aload_0
    //   1371: getfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1374: invokevirtual 200	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1377: invokevirtual 206	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1380: invokevirtual 1533	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1383: ifeq +149 -> 1532
    //   1386: aload_0
    //   1387: getfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1390: ifnonnull +86 -> 1476
    //   1393: new 369	java/lang/StringBuilder
    //   1396: dup
    //   1397: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1400: ldc_w 1557
    //   1403: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: aload 20
    //   1408: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: ldc_w 1561
    //   1414: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1420: new 369	java/lang/StringBuilder
    //   1423: dup
    //   1424: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1427: ldc 73
    //   1429: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: aload_0
    //   1433: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1436: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   1439: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1442: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1445: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1448: sipush -1007
    //   1451: istore_2
    //   1452: iload_1
    //   1453: iconst_1
    //   1454: iadd
    //   1455: istore_1
    //   1456: aload_0
    //   1457: aconst_null
    //   1458: putfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1461: aconst_null
    //   1462: astore 18
    //   1464: aload_0
    //   1465: aconst_null
    //   1466: invokevirtual 1553	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   1469: iload 15
    //   1471: istore 14
    //   1473: goto -1381 -> 92
    //   1476: new 369	java/lang/StringBuilder
    //   1479: dup
    //   1480: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1483: ldc_w 1563
    //   1486: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: aload 19
    //   1491: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1497: new 369	java/lang/StringBuilder
    //   1500: dup
    //   1501: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1504: ldc 73
    //   1506: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1509: aload_0
    //   1510: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1513: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   1516: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1519: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1522: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1525: sipush -1000
    //   1528: istore_2
    //   1529: goto -77 -> 1452
    //   1532: aload_0
    //   1533: getfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1536: invokevirtual 200	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1539: invokevirtual 206	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1542: astore 19
    //   1544: new 369	java/lang/StringBuilder
    //   1547: dup
    //   1548: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1551: ldc_w 1557
    //   1554: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1557: aload 20
    //   1559: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: ldc_w 1565
    //   1565: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: aload_0
    //   1569: getfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1572: invokevirtual 1566	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   1575: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1578: ldc_w 1568
    //   1581: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1587: new 369	java/lang/StringBuilder
    //   1590: dup
    //   1591: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1594: ldc 73
    //   1596: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1599: aload_0
    //   1600: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1603: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   1606: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1609: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1612: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1615: iload_2
    //   1616: istore 4
    //   1618: aload 18
    //   1620: ifnonnull +1051 -> 2671
    //   1623: new 369	java/lang/StringBuilder
    //   1626: dup
    //   1627: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1630: ldc_w 1570
    //   1633: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1636: aload_0
    //   1637: getfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1640: invokevirtual 922	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1643: ldc_w 1559
    //   1646: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1649: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1652: new 369	java/lang/StringBuilder
    //   1655: dup
    //   1656: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1659: ldc 73
    //   1661: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: aload_0
    //   1665: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1668: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   1671: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1674: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1677: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1680: new 1550	java/net/Socket
    //   1683: dup
    //   1684: invokespecial 1571	java/net/Socket:<init>	()V
    //   1687: astore 18
    //   1689: aload_0
    //   1690: aload 18
    //   1692: invokevirtual 1553	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   1695: aload 18
    //   1697: aload_0
    //   1698: getfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1701: aload_0
    //   1702: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1705: getfield 520	oicq/wlogin_sdk/request/t:l	I
    //   1708: invokevirtual 1575	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   1711: aload 18
    //   1713: aload_0
    //   1714: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1717: getfield 520	oicq/wlogin_sdk/request/t:l	I
    //   1720: invokevirtual 1578	java/net/Socket:setSoTimeout	(I)V
    //   1723: aload 18
    //   1725: aload_0
    //   1726: getfield 117	oicq/wlogin_sdk/request/j:r	[B
    //   1729: arraylength
    //   1730: invokevirtual 1581	java/net/Socket:setReceiveBufferSize	(I)V
    //   1733: new 369	java/lang/StringBuilder
    //   1736: dup
    //   1737: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1740: ldc_w 1570
    //   1743: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: aload_0
    //   1747: getfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1750: invokevirtual 922	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1753: ldc_w 1583
    //   1756: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1762: new 369	java/lang/StringBuilder
    //   1765: dup
    //   1766: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1769: ldc 73
    //   1771: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1774: aload_0
    //   1775: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1778: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   1781: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1784: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1787: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1790: ldc_w 1585
    //   1793: new 369	java/lang/StringBuilder
    //   1796: dup
    //   1797: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   1800: ldc 73
    //   1802: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: aload_0
    //   1806: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1809: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   1812: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1815: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1818: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1821: aload 18
    //   1823: invokevirtual 1586	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   1826: astore 20
    //   1828: aload 20
    //   1830: aload 24
    //   1832: iconst_0
    //   1833: aload 24
    //   1835: arraylength
    //   1836: invokevirtual 1539	java/io/OutputStream:write	([BII)V
    //   1839: aload 20
    //   1841: invokevirtual 1542	java/io/OutputStream:flush	()V
    //   1844: aload 18
    //   1846: invokevirtual 1587	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   1849: astore 22
    //   1851: aload 17
    //   1853: astore 20
    //   1855: aload 19
    //   1857: astore 21
    //   1859: aload 18
    //   1861: astore 17
    //   1863: aload 20
    //   1865: astore 19
    //   1867: aload 21
    //   1869: astore 18
    //   1871: aload 22
    //   1873: astore 21
    //   1875: goto -861 -> 1014
    //   1878: astore 18
    //   1880: iload_1
    //   1881: iconst_1
    //   1882: iadd
    //   1883: istore_1
    //   1884: aload_0
    //   1885: aconst_null
    //   1886: putfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1889: aload_0
    //   1890: aconst_null
    //   1891: invokevirtual 1553	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   1894: sipush -1000
    //   1897: istore_2
    //   1898: aconst_null
    //   1899: astore 18
    //   1901: iload 15
    //   1903: istore 14
    //   1905: goto -1813 -> 92
    //   1908: iload 6
    //   1910: iload 5
    //   1912: iadd
    //   1913: istore 6
    //   1915: goto -858 -> 1057
    //   1918: aload 17
    //   1920: astore 20
    //   1922: iload_1
    //   1923: istore_2
    //   1924: aload_0
    //   1925: aload_0
    //   1926: getfield 117	oicq/wlogin_sdk/request/j:r	[B
    //   1929: invokevirtual 1589	oicq/wlogin_sdk/request/j:b	([B)I
    //   1932: istore 6
    //   1934: iload 6
    //   1936: istore_2
    //   1937: aload 17
    //   1939: astore 20
    //   1941: iload_1
    //   1942: istore_3
    //   1943: iload_2
    //   1944: aload_0
    //   1945: getfield 91	oicq/wlogin_sdk/request/j:e	I
    //   1948: iconst_1
    //   1949: iadd
    //   1950: if_icmpgt +58 -> 2008
    //   1953: iload_1
    //   1954: iconst_1
    //   1955: iadd
    //   1956: istore_1
    //   1957: aload 17
    //   1959: astore 20
    //   1961: iload 15
    //   1963: ifne +732 -> 2695
    //   1966: aload 17
    //   1968: astore 20
    //   1970: iload_1
    //   1971: istore_3
    //   1972: aload 17
    //   1974: invokevirtual 1551	java/net/Socket:close	()V
    //   1977: aload 17
    //   1979: astore 20
    //   1981: iload_1
    //   1982: istore_3
    //   1983: aload_0
    //   1984: aconst_null
    //   1985: putfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1988: aconst_null
    //   1989: astore 17
    //   1991: aconst_null
    //   1992: astore 20
    //   1994: iload_1
    //   1995: istore_3
    //   1996: aload_0
    //   1997: aconst_null
    //   1998: invokevirtual 1553	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   2001: aload 17
    //   2003: astore 20
    //   2005: goto +690 -> 2695
    //   2008: aload 17
    //   2010: astore 20
    //   2012: iload_1
    //   2013: istore_3
    //   2014: iload_2
    //   2015: aload_0
    //   2016: getfield 117	oicq/wlogin_sdk/request/j:r	[B
    //   2019: arraylength
    //   2020: if_icmplt +58 -> 2078
    //   2023: iload_1
    //   2024: iconst_1
    //   2025: iadd
    //   2026: istore_1
    //   2027: aload 17
    //   2029: astore 20
    //   2031: iload 15
    //   2033: ifne +687 -> 2720
    //   2036: aload 17
    //   2038: astore 20
    //   2040: iload_1
    //   2041: istore_3
    //   2042: aload 17
    //   2044: invokevirtual 1551	java/net/Socket:close	()V
    //   2047: aload 17
    //   2049: astore 20
    //   2051: iload_1
    //   2052: istore_3
    //   2053: aload_0
    //   2054: aconst_null
    //   2055: putfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   2058: aconst_null
    //   2059: astore 17
    //   2061: aconst_null
    //   2062: astore 20
    //   2064: iload_1
    //   2065: istore_3
    //   2066: aload_0
    //   2067: aconst_null
    //   2068: invokevirtual 1553	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   2071: aload 17
    //   2073: astore 20
    //   2075: goto +645 -> 2720
    //   2078: aload 17
    //   2080: astore 20
    //   2082: iload_1
    //   2083: istore_3
    //   2084: aload_0
    //   2085: getfield 91	oicq/wlogin_sdk/request/j:e	I
    //   2088: iconst_1
    //   2089: iadd
    //   2090: istore 7
    //   2092: iload_2
    //   2093: iload 7
    //   2095: isub
    //   2096: istore 6
    //   2098: iload 5
    //   2100: istore 8
    //   2102: iload 6
    //   2104: ifle +34 -> 2138
    //   2107: aload 17
    //   2109: astore 20
    //   2111: iload_1
    //   2112: istore_3
    //   2113: aload 21
    //   2115: aload_0
    //   2116: getfield 117	oicq/wlogin_sdk/request/j:r	[B
    //   2119: iload 7
    //   2121: iload 6
    //   2123: invokevirtual 1548	java/io/InputStream:read	([BII)I
    //   2126: istore 5
    //   2128: iload 5
    //   2130: iconst_m1
    //   2131: if_icmpne +108 -> 2239
    //   2134: iload 5
    //   2136: istore 8
    //   2138: iload_2
    //   2139: istore 5
    //   2141: lload 9
    //   2143: lstore 11
    //   2145: iload 4
    //   2147: istore_3
    //   2148: iload 15
    //   2150: istore 14
    //   2152: iload 13
    //   2154: istore 16
    //   2156: iload 8
    //   2158: iconst_m1
    //   2159: if_icmpne +185 -> 2344
    //   2162: iload_1
    //   2163: iconst_1
    //   2164: iadd
    //   2165: istore_1
    //   2166: aload 17
    //   2168: astore 20
    //   2170: iload 15
    //   2172: ifne +42 -> 2214
    //   2175: aload 17
    //   2177: astore 20
    //   2179: iload_1
    //   2180: istore_3
    //   2181: aload 17
    //   2183: invokevirtual 1551	java/net/Socket:close	()V
    //   2186: aload 17
    //   2188: astore 20
    //   2190: iload_1
    //   2191: istore_3
    //   2192: aload_0
    //   2193: aconst_null
    //   2194: putfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   2197: aconst_null
    //   2198: astore 20
    //   2200: aconst_null
    //   2201: astore 17
    //   2203: iload_1
    //   2204: istore_3
    //   2205: aload_0
    //   2206: aconst_null
    //   2207: invokevirtual 1553	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   2210: aload 17
    //   2212: astore 20
    //   2214: iload_2
    //   2215: istore_3
    //   2216: sipush -1000
    //   2219: istore_2
    //   2220: aload 19
    //   2222: astore 17
    //   2224: aload 18
    //   2226: astore 19
    //   2228: iload 15
    //   2230: istore 14
    //   2232: aload 20
    //   2234: astore 18
    //   2236: goto -2144 -> 92
    //   2239: iload 7
    //   2241: iload 5
    //   2243: iadd
    //   2244: istore 7
    //   2246: iload 6
    //   2248: iload 5
    //   2250: isub
    //   2251: istore 6
    //   2253: goto -155 -> 2098
    //   2256: astore 17
    //   2258: iload_2
    //   2259: istore_1
    //   2260: iload_3
    //   2261: istore_2
    //   2262: iload_1
    //   2263: iconst_1
    //   2264: iadd
    //   2265: istore_1
    //   2266: aload 20
    //   2268: astore 17
    //   2270: iload 15
    //   2272: ifne +29 -> 2301
    //   2275: aload 20
    //   2277: invokevirtual 1592	java/net/Socket:isConnected	()Z
    //   2280: ifeq +8 -> 2288
    //   2283: aload 20
    //   2285: invokevirtual 1551	java/net/Socket:close	()V
    //   2288: aload_0
    //   2289: aconst_null
    //   2290: putfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   2293: aconst_null
    //   2294: astore 17
    //   2296: aload_0
    //   2297: aconst_null
    //   2298: invokevirtual 1553	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   2301: aload 17
    //   2303: astore 20
    //   2305: iload_2
    //   2306: istore_3
    //   2307: sipush -1000
    //   2310: istore_2
    //   2311: aload 19
    //   2313: astore 17
    //   2315: aload 18
    //   2317: astore 19
    //   2319: iload 15
    //   2321: istore 14
    //   2323: aload 20
    //   2325: astore 18
    //   2327: goto -2235 -> 92
    //   2330: iload_3
    //   2331: istore 5
    //   2333: iload 13
    //   2335: istore 16
    //   2337: iload 4
    //   2339: istore_3
    //   2340: lload 9
    //   2342: lstore 11
    //   2344: iload_1
    //   2345: bipush 6
    //   2347: if_icmplt +252 -> 2599
    //   2350: sipush -1000
    //   2353: istore_2
    //   2354: iload_2
    //   2355: ifne +13 -> 2368
    //   2358: aload_0
    //   2359: aload_0
    //   2360: getfield 117	oicq/wlogin_sdk/request/j:r	[B
    //   2363: iload 5
    //   2365: invokevirtual 560	oicq/wlogin_sdk/request/j:b	([BI)V
    //   2368: iload_2
    //   2369: ifne +170 -> 2539
    //   2372: aload_0
    //   2373: getfield 119	oicq/wlogin_sdk/request/j:s	I
    //   2376: sipush 2066
    //   2379: if_icmpeq +160 -> 2539
    //   2382: new 128	oicq/wlogin_sdk/report/report_t3
    //   2385: dup
    //   2386: invokespecial 129	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   2389: astore 17
    //   2391: aload 17
    //   2393: aload_0
    //   2394: getfield 119	oicq/wlogin_sdk/request/j:s	I
    //   2397: putfield 132	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   2400: aload 17
    //   2402: aload_0
    //   2403: getfield 121	oicq/wlogin_sdk/request/j:t	I
    //   2406: putfield 135	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   2409: aload 17
    //   2411: iload_2
    //   2412: putfield 138	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   2415: aload 17
    //   2417: invokestatic 144	java/lang/System:currentTimeMillis	()J
    //   2420: lload 11
    //   2422: lsub
    //   2423: l2i
    //   2424: putfield 147	oicq/wlogin_sdk/report/report_t3:_used	I
    //   2427: aload 17
    //   2429: iload_1
    //   2430: putfield 150	oicq/wlogin_sdk/report/report_t3:_try	I
    //   2433: aload 17
    //   2435: getstatic 77	oicq/wlogin_sdk/request/j:C	Ljava/lang/String;
    //   2438: putfield 153	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   2441: aload 17
    //   2443: getfield 153	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   2446: ifnonnull +10 -> 2456
    //   2449: aload 17
    //   2451: ldc 73
    //   2453: putfield 153	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   2456: aload_0
    //   2457: getfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   2460: ifnonnull +144 -> 2604
    //   2463: aload 17
    //   2465: ldc 73
    //   2467: putfield 156	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   2470: aload 17
    //   2472: aload_0
    //   2473: getfield 115	oicq/wlogin_sdk/request/j:q	I
    //   2476: putfield 162	oicq/wlogin_sdk/report/report_t3:_port	I
    //   2479: aload 17
    //   2481: iload_3
    //   2482: putfield 165	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   2485: aload 17
    //   2487: getstatic 169	oicq/wlogin_sdk/request/t:B	I
    //   2490: putfield 172	oicq/wlogin_sdk/report/report_t3:_net	I
    //   2493: aload 17
    //   2495: ldc 73
    //   2497: putfield 175	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   2500: aload 17
    //   2502: aload 24
    //   2504: arraylength
    //   2505: putfield 178	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   2508: aload 17
    //   2510: iload 5
    //   2512: putfield 181	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   2515: iload 14
    //   2517: ifeq +114 -> 2631
    //   2520: iload 16
    //   2522: ifeq +100 -> 2622
    //   2525: aload 17
    //   2527: iconst_2
    //   2528: putfield 184	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   2531: getstatic 188	oicq/wlogin_sdk/request/t:ag	Loicq/wlogin_sdk/report/report_t1;
    //   2534: aload 17
    //   2536: invokevirtual 194	oicq/wlogin_sdk/report/report_t1:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   2539: new 369	java/lang/StringBuilder
    //   2542: dup
    //   2543: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   2546: aload_0
    //   2547: invokevirtual 512	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2550: invokevirtual 517	java/lang/Class:getName	()Ljava/lang/String;
    //   2553: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2556: ldc_w 1594
    //   2559: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2562: iload_2
    //   2563: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2566: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2569: new 369	java/lang/StringBuilder
    //   2572: dup
    //   2573: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   2576: ldc 73
    //   2578: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2581: aload_0
    //   2582: getfield 215	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   2585: getfield 390	oicq/wlogin_sdk/request/t:f	J
    //   2588: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2591: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2594: invokestatic 287	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2597: iload_2
    //   2598: ireturn
    //   2599: iconst_0
    //   2600: istore_2
    //   2601: goto -247 -> 2354
    //   2604: aload 17
    //   2606: aload_0
    //   2607: getfield 113	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   2610: invokevirtual 200	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   2613: invokevirtual 206	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2616: putfield 156	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   2619: goto -149 -> 2470
    //   2622: aload 17
    //   2624: iconst_1
    //   2625: putfield 184	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   2628: goto -97 -> 2531
    //   2631: aload 17
    //   2633: iconst_0
    //   2634: putfield 184	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   2637: goto -106 -> 2531
    //   2640: astore 17
    //   2642: goto -354 -> 2288
    //   2645: astore 17
    //   2647: iload_3
    //   2648: istore_1
    //   2649: goto -387 -> 2262
    //   2652: astore 21
    //   2654: goto -1293 -> 1361
    //   2657: astore 17
    //   2659: aload 20
    //   2661: astore 17
    //   2663: goto -1881 -> 782
    //   2666: astore 20
    //   2668: goto -1886 -> 782
    //   2671: goto -881 -> 1790
    //   2674: goto -1056 -> 1618
    //   2677: aload 23
    //   2679: astore 22
    //   2681: goto -1867 -> 814
    //   2684: aconst_null
    //   2685: astore 20
    //   2687: iconst_m1
    //   2688: istore_2
    //   2689: goto -2333 -> 356
    //   2692: goto -2336 -> 356
    //   2695: iload_2
    //   2696: istore_3
    //   2697: sipush -1000
    //   2700: istore_2
    //   2701: aload 19
    //   2703: astore 17
    //   2705: aload 18
    //   2707: astore 19
    //   2709: iload 15
    //   2711: istore 14
    //   2713: aload 20
    //   2715: astore 18
    //   2717: goto -2625 -> 92
    //   2720: iload_2
    //   2721: istore_3
    //   2722: sipush -1000
    //   2725: istore_2
    //   2726: aload 19
    //   2728: astore 17
    //   2730: aload 18
    //   2732: astore 19
    //   2734: iload 15
    //   2736: istore 14
    //   2738: aload 20
    //   2740: astore 18
    //   2742: goto -2650 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2745	0	this	j
    //   65	2584	1	i1	int
    //   63	2663	2	i2	int
    //   61	2661	3	i3	int
    //   82	2256	4	i4	int
    //   1052	1459	5	i5	int
    //   1055	1197	6	i6	int
    //   2090	155	7	i7	int
    //   2100	60	8	i8	int
    //   67	2274	9	l1	long
    //   2143	278	11	l2	long
    //   79	2255	13	bool1	boolean
    //   76	2661	14	bool2	boolean
    //   114	2621	15	bool3	boolean
    //   2154	367	16	bool4	boolean
    //   90	2133	17	localObject1	Object
    //   2256	1	17	localThrowable1	java.lang.Throwable
    //   2268	364	17	localObject2	Object
    //   2640	1	17	localException1	Exception
    //   2645	1	17	localThrowable2	java.lang.Throwable
    //   2657	1	17	localException2	Exception
    //   2661	68	17	localObject3	Object
    //   73	1797	18	localObject4	Object
    //   1878	1	18	localThrowable3	java.lang.Throwable
    //   1899	842	18	localObject5	Object
    //   86	2647	19	localObject6	Object
    //   246	373	20	localObject7	Object
    //   776	1	20	localException3	Exception
    //   799	1861	20	localObject8	Object
    //   2666	1	20	localException4	Exception
    //   2685	54	20	localObject9	Object
    //   727	1387	21	localObject10	Object
    //   2652	1	21	localException5	Exception
    //   808	1872	22	localObject11	Object
    //   220	2458	23	str	String
    //   58	2445	24	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   226	234	776	java/lang/Exception
    //   243	248	776	java/lang/Exception
    //   252	256	776	java/lang/Exception
    //   265	273	776	java/lang/Exception
    //   284	353	776	java/lang/Exception
    //   365	411	776	java/lang/Exception
    //   684	702	776	java/lang/Exception
    //   706	713	776	java/lang/Exception
    //   717	729	776	java/lang/Exception
    //   733	743	776	java/lang/Exception
    //   747	776	776	java/lang/Exception
    //   1623	1790	1878	java/lang/Throwable
    //   1790	1851	1878	java/lang/Throwable
    //   1020	1051	2256	java/lang/Throwable
    //   1063	1074	2256	java/lang/Throwable
    //   1080	1102	2256	java/lang/Throwable
    //   1136	1141	2256	java/lang/Throwable
    //   1147	1152	2256	java/lang/Throwable
    //   1160	1165	2256	java/lang/Throwable
    //   1924	1934	2256	java/lang/Throwable
    //   2275	2288	2640	java/lang/Exception
    //   1943	1953	2645	java/lang/Throwable
    //   1972	1977	2645	java/lang/Throwable
    //   1983	1988	2645	java/lang/Throwable
    //   1996	2001	2645	java/lang/Throwable
    //   2014	2023	2645	java/lang/Throwable
    //   2042	2047	2645	java/lang/Throwable
    //   2053	2058	2645	java/lang/Throwable
    //   2066	2071	2645	java/lang/Throwable
    //   2084	2092	2645	java/lang/Throwable
    //   2113	2128	2645	java/lang/Throwable
    //   2181	2186	2645	java/lang/Throwable
    //   2192	2197	2645	java/lang/Throwable
    //   2205	2210	2645	java/lang/Throwable
    //   1330	1361	2652	java/lang/Exception
    //   801	806	2657	java/lang/Exception
    //   818	854	2657	java/lang/Exception
    //   411	500	2666	java/lang/Exception
    //   505	515	2666	java/lang/Exception
    //   515	665	2666	java/lang/Exception
    //   861	969	2666	java/lang/Exception
    //   991	998	2666	java/lang/Exception
  }
  
  public int f()
  {
    return t.b(this.w.h)._last_flowid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.j
 * JD-Core Version:    0.7.0.1
 */