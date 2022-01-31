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
import oicq.wlogin_sdk.b.bd;
import oicq.wlogin_sdk.b.bf;
import oicq.wlogin_sdk.b.bg;
import oicq.wlogin_sdk.b.bh;
import oicq.wlogin_sdk.b.bi;
import oicq.wlogin_sdk.b.bk;
import oicq.wlogin_sdk.b.bl;
import oicq.wlogin_sdk.b.bp;
import oicq.wlogin_sdk.b.bq;
import oicq.wlogin_sdk.b.bs;
import oicq.wlogin_sdk.b.bt;
import oicq.wlogin_sdk.b.bw;
import oicq.wlogin_sdk.b.ca;
import oicq.wlogin_sdk.b.cd;
import oicq.wlogin_sdk.b.ce;
import oicq.wlogin_sdk.b.cg;
import oicq.wlogin_sdk.b.cj;
import oicq.wlogin_sdk.b.cm;
import oicq.wlogin_sdk.b.cn;
import oicq.wlogin_sdk.b.co;
import oicq.wlogin_sdk.b.cq;
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
  static String[] x = { "111.30.137.20", "123.126.122.126", "123.151.176.23", "120.198.203.150", "14.17.41.156", "163.177.71.159", "101.227.130.77", "117.135.172.187", "140.207.69.123" };
  static String[] y = { "180.163.15.182", "183.192.200.28", "223.167.105.36", "183.61.56.18", "183.232.119.221", "163.177.86.123", "123.151.92.19", "125.39.52.120", "123.126.121.172", "117.135.169.107" };
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
      t.ah.add_t3(localreport_t3);
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
    bh localbh = new bh();
    bg localbg = new bg();
    paramaw = paramaw.b();
    int i1 = paramaw.length;
    if (localbh.b(paramaw, 2, i1) > 0) {
      a(localbh);
    }
    if (localbg.b(paramaw, 2, i1) > 0)
    {
      this.w.m = 1;
      this.w.p = localbg.b();
      util.LOGI("get rollback sig", "");
    }
    return 0;
  }
  
  public int a(bh parambh)
  {
    parambh = parambh.b();
    int i3;
    int i2;
    int i1;
    if ((parambh != null) && (parambh.length > 2))
    {
      i3 = util.buf_to_int8(parambh, 1);
      i2 = 2;
      i1 = 0;
    }
    for (;;)
    {
      if ((i1 >= i3) || (parambh.length < i2 + 1)) {}
      int i4;
      byte[] arrayOfByte;
      do
      {
        do
        {
          do
          {
            return 0;
            i4 = util.buf_to_int8(parambh, i2);
            i5 = i2 + 1;
          } while (parambh.length < i5 + 2);
          i2 = util.buf_to_int16(parambh, i5);
          i5 += 2;
        } while (parambh.length < i5 + i2);
        arrayOfByte = new byte[i2];
        System.arraycopy(parambh, i5, arrayOfByte, 0, i2);
        i2 = i5 + i2;
      } while (parambh.length < i2 + 2);
      int i5 = util.buf_to_int16(parambh, i2);
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
    this.w.ad = paramSocket;
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
    //   0: new 385	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 528	java/lang/Object:getClass	()Ljava/lang/Class;
    //   11: invokevirtual 533	java/lang/Class:getName	()Ljava/lang/String;
    //   14: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 535
    //   20: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: new 385	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   33: ldc 89
    //   35: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   42: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   45: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   58: getfield 536	oicq/wlogin_sdk/request/t:l	I
    //   61: istore 4
    //   63: aload_0
    //   64: invokevirtual 538	oicq/wlogin_sdk/request/j:c	()[B
    //   67: astore 7
    //   69: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   72: lstore 5
    //   74: new 385	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 540
    //   84: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 542
    //   94: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: getfield 139	oicq/wlogin_sdk/request/j:u	Ljava/lang/String;
    //   101: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 544
    //   107: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 4
    //   112: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc_w 546
    //   118: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_2
    //   122: invokevirtual 549	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   125: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: new 385	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   135: ldc 89
    //   137: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   144: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   147: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: new 551	oicq/wlogin_sdk/request/WtloginMsfListener
    //   159: dup
    //   160: aload_1
    //   161: aload_0
    //   162: getfield 139	oicq/wlogin_sdk/request/j:u	Ljava/lang/String;
    //   165: aload 7
    //   167: iload 4
    //   169: iload_2
    //   170: aload_3
    //   171: invokespecial 554	oicq/wlogin_sdk/request/WtloginMsfListener:<init>	(Ljava/lang/String;Ljava/lang/String;[BIZLoicq/wlogin_sdk/request/WUserSigInfo;)V
    //   174: astore_3
    //   175: new 556	java/lang/Thread
    //   178: dup
    //   179: aload_3
    //   180: invokespecial 559	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 560	java/lang/Thread:start	()V
    //   188: aload_1
    //   189: iload 4
    //   191: i2l
    //   192: invokevirtual 564	java/lang/Thread:join	(J)V
    //   195: aload_3
    //   196: invokevirtual 567	oicq/wlogin_sdk/request/WtloginMsfListener:getRetData	()[B
    //   199: astore_1
    //   200: aload_1
    //   201: ifnonnull +240 -> 441
    //   204: new 385	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 569
    //   214: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_3
    //   218: invokevirtual 572	oicq/wlogin_sdk/request/WtloginMsfListener:getRet	()I
    //   221: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: new 385	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   234: ldc 89
    //   236: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_0
    //   240: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   243: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   246: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: sipush -1000
    //   258: istore 4
    //   260: aload_0
    //   261: getfield 135	oicq/wlogin_sdk/request/j:s	I
    //   264: sipush 2066
    //   267: if_icmpeq +112 -> 379
    //   270: new 144	oicq/wlogin_sdk/report/report_t3
    //   273: dup
    //   274: invokespecial 145	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   277: astore_3
    //   278: aload_3
    //   279: aload_0
    //   280: getfield 135	oicq/wlogin_sdk/request/j:s	I
    //   283: putfield 148	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   286: aload_3
    //   287: aload_0
    //   288: getfield 137	oicq/wlogin_sdk/request/j:t	I
    //   291: putfield 151	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   294: aload_3
    //   295: iload 4
    //   297: putfield 154	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   300: aload_3
    //   301: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   304: lload 5
    //   306: lsub
    //   307: l2i
    //   308: putfield 163	oicq/wlogin_sdk/report/report_t3:_used	I
    //   311: aload_3
    //   312: iconst_0
    //   313: putfield 166	oicq/wlogin_sdk/report/report_t3:_try	I
    //   316: aload_3
    //   317: ldc 89
    //   319: putfield 169	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   322: aload_3
    //   323: ldc 89
    //   325: putfield 172	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   328: aload_3
    //   329: iconst_0
    //   330: putfield 178	oicq/wlogin_sdk/report/report_t3:_port	I
    //   333: aload_3
    //   334: iconst_0
    //   335: putfield 181	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   338: aload_3
    //   339: iconst_0
    //   340: putfield 188	oicq/wlogin_sdk/report/report_t3:_net	I
    //   343: aload_3
    //   344: ldc 89
    //   346: putfield 191	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   349: iload 4
    //   351: ifne +143 -> 494
    //   354: aload_3
    //   355: aload 7
    //   357: arraylength
    //   358: putfield 194	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   361: aload_3
    //   362: aload_1
    //   363: arraylength
    //   364: putfield 197	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   367: aload_3
    //   368: iconst_3
    //   369: putfield 200	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   372: getstatic 204	oicq/wlogin_sdk/request/t:ah	Loicq/wlogin_sdk/report/report_t1;
    //   375: aload_3
    //   376: invokevirtual 210	oicq/wlogin_sdk/report/report_t1:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   379: new 385	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   386: aload_0
    //   387: invokevirtual 528	java/lang/Object:getClass	()Ljava/lang/Class;
    //   390: invokevirtual 533	java/lang/Class:getName	()Ljava/lang/String;
    //   393: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: ldc_w 574
    //   399: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: iload 4
    //   404: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: new 385	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   417: ldc 89
    //   419: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_0
    //   423: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   426: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   429: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   432: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: iload 4
    //   440: ireturn
    //   441: aload_0
    //   442: aload_1
    //   443: aload_1
    //   444: arraylength
    //   445: invokevirtual 576	oicq/wlogin_sdk/request/j:b	([BI)V
    //   448: iconst_0
    //   449: istore 4
    //   451: goto -191 -> 260
    //   454: astore_3
    //   455: aconst_null
    //   456: astore_1
    //   457: aload_3
    //   458: new 385	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   465: ldc 89
    //   467: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_0
    //   471: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   474: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   477: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   480: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 580	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   486: sipush -1000
    //   489: istore 4
    //   491: goto -231 -> 260
    //   494: aload_3
    //   495: iconst_0
    //   496: putfield 194	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   499: aload_3
    //   500: iconst_0
    //   501: putfield 197	oicq/wlogin_sdk/report/report_t3:_rlen	I
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
    Object localObject1 = ByteBuffer.allocate("6.3.1.2293".length() + 24 + 2 + 2 + 1 + 4);
    Object localObject2 = t.b(this.w.h);
    ((ByteBuffer)localObject1).put(t.ab);
    ((ByteBuffer)localObject1).putInt((int)((async_context)localObject2)._sappid);
    ((ByteBuffer)localObject1).putInt((int)((async_context)localObject2)._sub_appid);
    ((ByteBuffer)localObject1).putShort((short)0);
    ((ByteBuffer)localObject1).putLong(this.w.f);
    ((ByteBuffer)localObject1).putShort((short)"6.3.1.2293".length());
    ((ByteBuffer)localObject1).put("6.3.1.2293".getBytes());
    ((ByteBuffer)localObject1).putShort((short)this.s);
    ((ByteBuffer)localObject1).putShort((short)this.t);
    if (paramInt == -1000) {}
    for (int i1 = 1;; i1 = 0)
    {
      ((ByteBuffer)localObject1).put((byte)i1);
      ((ByteBuffer)localObject1).putInt(paramInt);
      localObject2 = new cq().a(0, t.s, 0);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(((ByteBuffer)localObject1).capacity() + 4 + 4 + (co.j.length + 4) + localObject2.length);
      localByteBuffer.putShort((short)2);
      localByteBuffer.putShort((short)3);
      localByteBuffer.putShort((short)512);
      localByteBuffer.putShort((short)((ByteBuffer)localObject1).capacity());
      localByteBuffer.put(((ByteBuffer)localObject1).array());
      localByteBuffer.putShort((short)2);
      localByteBuffer.putShort((short)co.j.length);
      localByteBuffer.put(co.j);
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
    //   9: invokevirtual 669	oicq/wlogin_sdk/request/j:b	(I)[B
    //   12: astore 4
    //   14: aload_3
    //   15: astore_2
    //   16: new 385	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   23: astore 6
    //   25: aload_3
    //   26: astore_2
    //   27: invokestatic 355	java/lang/Math:random	()D
    //   30: ldc2_w 670
    //   33: dmul
    //   34: invokestatic 675	java/lang/Math:round	(D)J
    //   37: l2i
    //   38: istore_1
    //   39: aload_3
    //   40: astore_2
    //   41: aload 6
    //   43: iconst_3
    //   44: anewarray 43	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: ldc_w 677
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: ldc_w 679
    //   58: aastore
    //   59: dup
    //   60: iconst_2
    //   61: ldc_w 681
    //   64: aastore
    //   65: iload_1
    //   66: iconst_3
    //   67: irem
    //   68: aaload
    //   69: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 683
    //   75: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 6
    //   83: aload_3
    //   84: astore_2
    //   85: new 685	java/net/URL
    //   88: dup
    //   89: new 385	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 687
    //   99: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 6
    //   104: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc_w 689
    //   110: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokespecial 691	java/net/URL:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 695	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   122: checkcast 697	java/net/HttpURLConnection
    //   125: astore_3
    //   126: aload_3
    //   127: ldc_w 699
    //   130: invokevirtual 702	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   133: aload_3
    //   134: ldc_w 704
    //   137: new 385	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   144: aload 4
    //   146: arraylength
    //   147: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: ldc 89
    //   152: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokevirtual 707	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_3
    //   162: ldc_w 709
    //   165: ldc_w 711
    //   168: invokevirtual 707	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_3
    //   172: getstatic 712	oicq/wlogin_sdk/b/co:i	I
    //   175: invokevirtual 715	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   178: aload_3
    //   179: getstatic 712	oicq/wlogin_sdk/b/co:i	I
    //   182: invokevirtual 718	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   185: aload_3
    //   186: iconst_1
    //   187: invokevirtual 722	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   190: aload_3
    //   191: iconst_1
    //   192: invokevirtual 725	java/net/HttpURLConnection:setDoInput	(Z)V
    //   195: aload_3
    //   196: aload_0
    //   197: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   200: getfield 536	oicq/wlogin_sdk/request/t:l	I
    //   203: i2l
    //   204: invokestatic 730	oicq/wlogin_sdk/request/h:a	(Ljava/net/HttpURLConnection;J)Z
    //   207: ifne +46 -> 253
    //   210: ldc_w 732
    //   213: new 385	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   220: ldc 89
    //   222: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_0
    //   226: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   229: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   232: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   235: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_3
    //   242: ifnull +7 -> 249
    //   245: aload_3
    //   246: invokevirtual 735	java/net/HttpURLConnection:disconnect	()V
    //   249: sipush -1000
    //   252: ireturn
    //   253: aload_3
    //   254: invokevirtual 739	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   257: astore_2
    //   258: aload_2
    //   259: aload 4
    //   261: invokevirtual 744	java/io/OutputStream:write	([B)V
    //   264: aload_2
    //   265: invokevirtual 747	java/io/OutputStream:close	()V
    //   268: aload_3
    //   269: invokevirtual 750	java/net/HttpURLConnection:getResponseCode	()I
    //   272: istore_1
    //   273: new 385	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   280: ldc_w 752
    //   283: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: iload_1
    //   287: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: new 385	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   300: ldc 89
    //   302: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_0
    //   306: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   309: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   312: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   315: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: sipush 200
    //   324: iload_1
    //   325: if_icmpeq +15 -> 340
    //   328: aload_3
    //   329: ifnull +7 -> 336
    //   332: aload_3
    //   333: invokevirtual 735	java/net/HttpURLConnection:disconnect	()V
    //   336: sipush -1000
    //   339: ireturn
    //   340: ldc_w 754
    //   343: new 385	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   350: ldc 89
    //   352: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_0
    //   356: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   359: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   362: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   365: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload_3
    //   372: invokevirtual 758	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   375: astore_2
    //   376: new 760	java/io/ByteArrayOutputStream
    //   379: dup
    //   380: invokespecial 761	java/io/ByteArrayOutputStream:<init>	()V
    //   383: astore 4
    //   385: sipush 1024
    //   388: newarray byte
    //   390: astore 5
    //   392: aload_2
    //   393: aload 5
    //   395: invokevirtual 766	java/io/InputStream:read	([B)I
    //   398: istore_1
    //   399: iload_1
    //   400: iconst_m1
    //   401: if_icmpeq +36 -> 437
    //   404: aload 4
    //   406: aload 5
    //   408: iconst_0
    //   409: iload_1
    //   410: invokevirtual 768	java/io/ByteArrayOutputStream:write	([BII)V
    //   413: goto -21 -> 392
    //   416: astore 4
    //   418: aload_3
    //   419: astore_2
    //   420: aload 4
    //   422: invokestatic 771	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;)V
    //   425: aload_3
    //   426: ifnull +7 -> 433
    //   429: aload_3
    //   430: invokevirtual 735	java/net/HttpURLConnection:disconnect	()V
    //   433: sipush -1000
    //   436: ireturn
    //   437: aload_0
    //   438: aload 4
    //   440: invokevirtual 774	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   443: invokevirtual 776	oicq/wlogin_sdk/request/j:d	([B)I
    //   446: sipush -1000
    //   449: if_icmpeq +26 -> 475
    //   452: iconst_1
    //   453: istore_1
    //   454: aload 4
    //   456: invokevirtual 777	java/io/ByteArrayOutputStream:close	()V
    //   459: iload_1
    //   460: ifne +20 -> 480
    //   463: aload_3
    //   464: ifnull +7 -> 471
    //   467: aload_3
    //   468: invokevirtual 735	java/net/HttpURLConnection:disconnect	()V
    //   471: sipush -1000
    //   474: ireturn
    //   475: iconst_0
    //   476: istore_1
    //   477: goto -23 -> 454
    //   480: aload_3
    //   481: ifnull +7 -> 488
    //   484: aload_3
    //   485: invokevirtual 735	java/net/HttpURLConnection:disconnect	()V
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
    //   504: invokevirtual 735	java/net/HttpURLConnection:disconnect	()V
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
    cj localcj = new cj();
    ax localax = new ax();
    ay localay = new ay();
    ba localba = new ba();
    bc localbc = new bc();
    bb localbb = new bb();
    aw localaw = new aw();
    bf localbf = new bf();
    a locala = new a(1298);
    bd localbd = new bd();
    bi localbi = new bi();
    bk localbk = new bk();
    bl localbl = new bl();
    bp localbp = new bp();
    bq localbq = new bq();
    ad localad = new ad();
    bs localbs = new bs();
    bt localbt = new bt();
    bw localbw = new bw();
    cm localcm = new cm();
    Object localObject7 = new cn();
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
    label2048:
    label3460:
    label3478:
    label3496:
    label3631:
    label5553:
    for (;;)
    {
      label622:
      i1 = c(paramArrayOfByte, paramInt1 + 2);
      int i4 = paramInt1 + 5;
      this.w.d = null;
      label826:
      label876:
      int i2;
      label1139:
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
              break label5544;
            }
            localObject1 = "0x" + Integer.toHexString(paramInt1);
            util.LOGI(localObject1, "" + this.w.f);
            if (paramInt1 != 0) {
              break label5553;
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
            break label622;
            paramInt2 = 2;
            break label622;
            paramInt2 = 3;
            break label622;
            paramInt2 = 4;
            break label622;
            paramInt2 = 5;
            break label622;
            paramInt2 = 6;
            break label622;
            paramInt2 = 7;
            break label622;
            paramInt2 = 0;
            break label622;
            paramInt2 = 0;
            break label622;
            if (paramInt2 != 1) {
              break label2048;
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
        if (localbw.b((byte[])localObject9, 2, i5) >= 0)
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
                this.w.a((String)localObject4, Long.valueOf(this.w.f), localbw.f());
                localObject3 = localObject4;
              }
            }
            label1593:
            util.LOGI("put t186: name: " + (String)localObject3 + " uin: " + this.w.f + " pwd=" + localbw.f(), "");
          }
        }
        else
        {
          util.LOGI("tgt len:" + util.buf_len(locall.b()) + " tgt_key len:" + util.buf_len(localo.b()) + " st len:" + util.buf_len(locals.b()) + " st_key len:" + util.buf_len(localp.b()) + " stwx_web len:" + util.buf_len((byte[])localObject2) + " a8 len:" + util.buf_len(arrayOfByte1) + " a5 len:" + util.buf_len(arrayOfByte2) + " lskey len:" + util.buf_len(arrayOfByte3) + " skey len:" + util.buf_len(arrayOfByte4) + " sig64 len:" + util.buf_len(arrayOfByte5) + " openid len:" + util.buf_len((byte[])localObject1) + " openkey len:" + util.buf_len(arrayOfByte6) + " pwdflag: " + localbw.c() + " " + localbw.f(), "" + this.w.f);
          if (localbb.b((byte[])localObject9, 2, i5) >= 0)
          {
            localObject3 = a(localbb);
            if ((localObject3 == null) || (localObject3.length <= 0)) {
              break label2504;
            }
          }
        }
        label2504:
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
          if (paramInt2 == 2)
          {
            if (localbt.b(paramArrayOfByte, i4, this.b - i4) >= 0) {
              localasync_context._msalt = localbt.f();
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
            break label1139;
          }
          if ((paramInt2 == 3) || (paramInt2 == 7))
          {
            if (localbt.b(paramArrayOfByte, i4, this.b - i4) >= 0) {
              localasync_context._msalt = localbt.f();
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
          break label1139;
          this.w.a((String)localObject3, Long.valueOf(this.w.f), localbw.f());
          break label1593;
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
        if (((cn)localObject7).b((byte[])localObject9, 2, i5) >= 0) {
          localObject4[4] = ((cn)localObject7).b();
        }
        if (localasync_context._sec_guid_flag)
        {
          localObject4[2] = localasync_context._G;
          localObject4[3] = localasync_context._dpwd;
          localObject4[4] = localasync_context._t403.b();
          localasync_context._sec_guid_flag = false;
        }
        localObject7 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 13, 0 });
        paramInt1 = 0;
        while (paramInt1 < 13)
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
        if (localcj.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[3] = localcj.b();
        }
        if (localax.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[4] = localax.b();
        }
        if (localbf.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[5] = localbf.b();
        }
        if (locala.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[6] = locala.b();
        }
        if (localbd.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[7] = localbd.b();
        }
        localObject6 = new ce();
        if (((ce)localObject6).b((byte[])localObject9, 2, i5) >= 0)
        {
          localObject7[8] = ((ce)localObject6).g();
          localObject1 = ((ce)localObject6).f();
        }
        break;
      }
      label3514:
      label3652:
      for (;;)
      {
        localObject6 = new cg();
        if (((cg)localObject6).b((byte[])localObject9, 2, i5) >= 0)
        {
          localObject7[9] = ((cg)localObject6).f();
          localObject7[10] = ((cg)localObject6).g();
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
          label3411:
          paramInt1 = localaj.b((byte[])localObject9, paramInt1, i5);
          if (paramInt1 < 0) {
            break label3652;
          }
          if (localaj.f() == 0) {
            break label5610;
          }
          l1 = localaj.f();
        }
        label3532:
        label5610:
        for (;;)
        {
          if (localaj.g() != 0)
          {
            localObject5[0] = localaj.g();
            if (localaj.h() == 0) {
              break label3591;
            }
            localObject5[1] = localaj.h();
            if (localaj.i() == 0) {
              break label3601;
            }
            localObject5[2] = localaj.i();
            if (localaj.j() == 0) {
              break label3611;
            }
            localObject5[3] = localaj.j();
            if (localaj.k() == 0) {
              break label3621;
            }
            localObject5[4] = localaj.k();
            if (localaj.l() == 0) {
              break label3631;
            }
            localObject5[5] = localaj.l();
          }
          for (;;)
          {
            if (localaj.m() == 0) {
              break label3641;
            }
            localObject5[6] = localaj.m();
            break label3411;
            oicq.wlogin_sdk.sharemem.WloginSigInfo._QRPUSHSig = new byte[0];
            break;
            localObject5[0] = 1641600L;
            break label3460;
            localObject5[1] = 86400L;
            break label3478;
            localObject5[2] = 1728000L;
            break label3496;
            localObject5[3] = 72000L;
            break label3514;
            localObject5[4] = 6000L;
            break label3532;
            localObject5[5] = 1728000L;
          }
          localObject5[6] = 1728000L;
          break label3411;
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
          util.LOGI("cmd " + Integer.toHexString(this.s) + " subcmd " + Integer.toHexString(this.t) + " result " + i1 + " will clean sig for uin " + this.w.f + " appid " + l3);
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
          localObject1 = new ca();
          if (((ca)localObject1).b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            a(new ErrMsg(i1, "", "", ((ca)localObject1).f()));
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
          i2 = localbi.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t174 = localbi;
          if (localbk.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            localasync_context._devlock_info.CountryCode = new String(localbk.f());
            localasync_context._devlock_info.Mobile = new String(localbk.g());
            localasync_context._devlock_info.MbItemSmsCodeStatus = localbk.h();
            localasync_context._devlock_info.AvailableMsgCount = localbk.i();
            localasync_context._devlock_info.TimeLimit = localbk.j();
          }
          localObject1 = new cd();
          if (((cd)localObject1).b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            localasync_context._devlock_info.BakCountryCode = ((cd)localObject1).g();
            localasync_context._devlock_info.BakMobile = ((cd)localObject1).h();
            localasync_context._devlock_info.BakMobileState = ((cd)localObject1).f();
          }
          if (localbl.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
            localasync_context._devlock_info.UnionVerifyUrl = new String(localbl.f());
          }
          if (localbp.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            localasync_context._devlock_info.MbGuideType = localbp.f();
            localasync_context._devlock_info.MbGuideMsg = new String(localbp.g());
            localasync_context._devlock_info.MbGuideInfoType = localbp.h();
            localasync_context._devlock_info.MbGuideInfo = new String(localbp.i());
          }
          if (localbq.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
            localasync_context._devlock_info.VerifyReason = new String(localbq.b());
          }
          if (localcm.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            localasync_context._t402 = localcm;
            if (((cn)localObject7).b(paramArrayOfByte, i4, this.b - i4 - 1) < 0) {
              break label5100;
            }
          }
          label5100:
          for (localasync_context._t403 = ((cn)localObject7);; localasync_context._t403 = new cn())
          {
            b(paramArrayOfByte, i4, this.b - i4 - 1);
            paramInt1 = i1;
            break;
            localasync_context._t402 = new cm();
            break label5036;
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
          i2 = localcm.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t402 = localcm;
          i2 = ((cn)localObject7).b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t403 = ((cn)localObject7);
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
          i2 = localbs.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._smslogin_msgcnt = localbs.f();
          localasync_context._smslogin_timelimit = localbs.g();
          i2 = localbt.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._msalt = localbt.f();
          paramInt1 = 0;
          break;
          localObject1 = Integer.valueOf(paramInt1);
          break label826;
          new co().b(paramArrayOfByte, i4, this.b - i4 - 1);
          i1 = paramInt1;
          if (!co.h) {
            break label876;
          }
          i2 = c(paramInt1);
          i1 = paramInt1;
          if (i2 == -1000) {
            break label876;
          }
          i1 = i2;
          break label876;
        }
      }
      label3641:
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
    return this.w.ad;
  }
  
  /* Error */
  public int e()
  {
    // Byte code:
    //   0: new 385	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 528	java/lang/Object:getClass	()Ljava/lang/Class;
    //   11: invokevirtual 533	java/lang/Class:getName	()Ljava/lang/String;
    //   14: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 1493
    //   20: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: new 385	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   33: ldc 89
    //   35: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   42: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   45: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: invokevirtual 538	oicq/wlogin_sdk/request/j:c	()[B
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
    //   70: invokevirtual 1495	oicq/wlogin_sdk/request/j:d	()Ljava/net/Socket;
    //   73: astore 18
    //   75: iconst_0
    //   76: istore 14
    //   78: iconst_0
    //   79: istore 13
    //   81: iconst_0
    //   82: istore 4
    //   84: ldc 89
    //   86: astore 19
    //   88: ldc 89
    //   90: astore 17
    //   92: iload_1
    //   93: bipush 6
    //   95: if_icmpge +2321 -> 2416
    //   98: iload_1
    //   99: ifeq +9 -> 108
    //   102: getstatic 328	oicq/wlogin_sdk/request/t:r	Landroid/content/Context;
    //   105: invokestatic 1499	oicq/wlogin_sdk/tools/util:chg_retry_type	(Landroid/content/Context;)V
    //   108: getstatic 328	oicq/wlogin_sdk/request/t:r	Landroid/content/Context;
    //   111: invokestatic 1503	oicq/wlogin_sdk/tools/util:is_wap_retry	(Landroid/content/Context;)Z
    //   114: istore 15
    //   116: aload_0
    //   117: aconst_null
    //   118: putfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   121: iload_1
    //   122: ifeq +27 -> 149
    //   125: aload_0
    //   126: getfield 135	oicq/wlogin_sdk/request/j:s	I
    //   129: sipush 2066
    //   132: if_icmpeq +17 -> 149
    //   135: aload_0
    //   136: iload_2
    //   137: lload 9
    //   139: iload 4
    //   141: iload_1
    //   142: iload 15
    //   144: iload 13
    //   146: invokespecial 1505	oicq/wlogin_sdk/request/j:a	(IJIIZZ)V
    //   149: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   152: lstore 9
    //   154: iload 15
    //   156: ifeq +1035 -> 1191
    //   159: new 385	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 1507
    //   169: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: iload_1
    //   173: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: ldc_w 1509
    //   179: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: new 385	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   192: ldc 89
    //   194: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   201: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   204: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: iload_1
    //   215: iload 15
    //   217: invokevirtual 1511	oicq/wlogin_sdk/request/j:a	(IZ)Ljava/lang/String;
    //   220: astore 23
    //   222: iload 13
    //   224: istore 14
    //   226: getstatic 328	oicq/wlogin_sdk/request/t:r	Landroid/content/Context;
    //   229: invokestatic 1514	oicq/wlogin_sdk/tools/util:is_wap_proxy_retry	(Landroid/content/Context;)Z
    //   232: istore 13
    //   234: iload 13
    //   236: ifeq +2534 -> 2770
    //   239: iload 13
    //   241: istore 14
    //   243: invokestatic 1517	oicq/wlogin_sdk/tools/util:get_proxy_ip	()Ljava/lang/String;
    //   246: astore 20
    //   248: iload 13
    //   250: istore 14
    //   252: invokestatic 1520	oicq/wlogin_sdk/tools/util:get_proxy_port	()I
    //   255: istore_2
    //   256: aload 20
    //   258: ifnull +20 -> 278
    //   261: iload 13
    //   263: istore 14
    //   265: aload 20
    //   267: invokevirtual 325	java/lang/String:length	()I
    //   270: ifle +8 -> 278
    //   273: iload_2
    //   274: iconst_m1
    //   275: if_icmpne +2503 -> 2778
    //   278: iconst_0
    //   279: istore 13
    //   281: iconst_0
    //   282: istore 14
    //   284: new 385	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   291: ldc_w 1522
    //   294: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 20
    //   299: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc_w 1524
    //   305: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: iload_2
    //   309: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   312: ldc_w 1526
    //   315: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: iconst_0
    //   319: invokevirtual 549	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   322: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: new 385	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   332: ldc 89
    //   334: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_0
    //   338: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   341: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   344: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   347: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   353: goto +2425 -> 2778
    //   356: iload 13
    //   358: ifeq +322 -> 680
    //   361: iload 13
    //   363: istore 14
    //   365: new 685	java/net/URL
    //   368: dup
    //   369: new 385	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 687
    //   379: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload 20
    //   384: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc_w 1528
    //   390: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: iload_2
    //   394: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: ldc_w 1530
    //   400: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokespecial 691	java/net/URL:<init>	(Ljava/lang/String;)V
    //   409: astore 20
    //   411: new 385	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 1532
    //   421: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: iload 13
    //   426: invokevirtual 549	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   429: ldc_w 1534
    //   432: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload 20
    //   437: invokevirtual 939	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   440: ldc_w 1536
    //   443: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload 23
    //   448: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: new 385	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   461: ldc 89
    //   463: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_0
    //   467: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   470: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   473: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   476: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: aload 20
    //   484: invokevirtual 695	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   487: checkcast 697	java/net/HttpURLConnection
    //   490: astore 20
    //   492: aload 20
    //   494: ldc_w 699
    //   497: invokevirtual 702	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   500: iload 13
    //   502: ifeq +13 -> 515
    //   505: aload 20
    //   507: ldc_w 1538
    //   510: aload 23
    //   512: invokevirtual 707	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload 20
    //   517: ldc_w 709
    //   520: ldc_w 711
    //   523: invokevirtual 707	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: aload 20
    //   528: ldc_w 1540
    //   531: ldc_w 1542
    //   534: invokevirtual 707	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: aload 20
    //   539: ldc_w 704
    //   542: aload 24
    //   544: arraylength
    //   545: invokestatic 1544	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   548: invokevirtual 707	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: aload 20
    //   553: aload_0
    //   554: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   557: getfield 536	oicq/wlogin_sdk/request/t:l	I
    //   560: invokevirtual 715	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   563: aload 20
    //   565: aload_0
    //   566: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   569: getfield 536	oicq/wlogin_sdk/request/t:l	I
    //   572: invokevirtual 718	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   575: aload 20
    //   577: iconst_1
    //   578: invokevirtual 722	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   581: aload 20
    //   583: iconst_1
    //   584: invokevirtual 725	java/net/HttpURLConnection:setDoInput	(Z)V
    //   587: ldc_w 1546
    //   590: new 385	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   597: ldc 89
    //   599: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload_0
    //   603: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   606: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   609: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   612: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: aload 20
    //   620: aload_0
    //   621: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   624: getfield 536	oicq/wlogin_sdk/request/t:l	I
    //   627: i2l
    //   628: invokestatic 730	oicq/wlogin_sdk/request/h:a	(Ljava/net/HttpURLConnection;J)Z
    //   631: ifne +230 -> 861
    //   634: ldc_w 1548
    //   637: new 385	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   644: ldc 89
    //   646: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: aload_0
    //   650: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   653: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   656: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   659: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   689: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   692: getfield 536	oicq/wlogin_sdk/request/t:l	I
    //   695: i2l
    //   696: invokestatic 1553	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   699: putfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   702: iload 13
    //   704: istore 14
    //   706: aload_0
    //   707: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   710: ifnull +2053 -> 2763
    //   713: iload 13
    //   715: istore 14
    //   717: aload_0
    //   718: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   721: invokevirtual 216	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   724: invokevirtual 222	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   727: astore 21
    //   729: iload 13
    //   731: istore 14
    //   733: aload 17
    //   735: aload 21
    //   737: invokevirtual 1556	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   740: ifeq +57 -> 797
    //   743: iload 13
    //   745: istore 14
    //   747: new 426	java/lang/Exception
    //   750: dup
    //   751: new 385	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   758: ldc_w 1558
    //   761: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload 17
    //   766: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokespecial 1559	java/lang/Exception:<init>	(Ljava/lang/String;)V
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
    //   803: putfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   806: aload 21
    //   808: astore 22
    //   810: aload 21
    //   812: astore 17
    //   814: aload 17
    //   816: astore 20
    //   818: new 685	java/net/URL
    //   821: dup
    //   822: new 385	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   829: ldc_w 687
    //   832: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: aload 22
    //   837: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: ldc_w 1530
    //   843: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokespecial 691	java/net/URL:<init>	(Ljava/lang/String;)V
    //   852: astore 21
    //   854: aload 21
    //   856: astore 20
    //   858: goto -447 -> 411
    //   861: ldc_w 1561
    //   864: new 385	java/lang/StringBuilder
    //   867: dup
    //   868: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   871: ldc 89
    //   873: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: aload_0
    //   877: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   880: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   883: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   886: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   892: aload 20
    //   894: invokevirtual 739	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   897: astore 21
    //   899: aload 21
    //   901: aload 24
    //   903: iconst_0
    //   904: aload 24
    //   906: arraylength
    //   907: invokevirtual 1562	java/io/OutputStream:write	([BII)V
    //   910: aload 21
    //   912: invokevirtual 1565	java/io/OutputStream:flush	()V
    //   915: aload 20
    //   917: invokevirtual 750	java/net/HttpURLConnection:getResponseCode	()I
    //   920: istore_2
    //   921: new 385	java/lang/StringBuilder
    //   924: dup
    //   925: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   928: ldc_w 1567
    //   931: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: iload_2
    //   935: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   938: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: new 385	java/lang/StringBuilder
    //   944: dup
    //   945: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   948: ldc 89
    //   950: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: aload_0
    //   954: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   957: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   960: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   963: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   993: invokevirtual 758	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
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
    //   1020: ldc_w 1569
    //   1023: new 385	java/lang/StringBuilder
    //   1026: dup
    //   1027: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1030: ldc 89
    //   1032: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: aload_0
    //   1036: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1039: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1042: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1045: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1066: getfield 107	oicq/wlogin_sdk/request/j:e	I
    //   1069: iconst_1
    //   1070: iadd
    //   1071: if_icmpge +36 -> 1107
    //   1074: aload 17
    //   1076: astore 20
    //   1078: iload_1
    //   1079: istore_2
    //   1080: aload 21
    //   1082: aload_0
    //   1083: getfield 133	oicq/wlogin_sdk/request/j:r	[B
    //   1086: iload 6
    //   1088: aload_0
    //   1089: getfield 107	oicq/wlogin_sdk/request/j:e	I
    //   1092: iconst_1
    //   1093: iadd
    //   1094: iload 6
    //   1096: isub
    //   1097: invokevirtual 1571	java/io/InputStream:read	([BII)I
    //   1100: istore 5
    //   1102: iload 5
    //   1104: ifge +890 -> 1994
    //   1107: iload 5
    //   1109: ifge +895 -> 2004
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
    //   1138: invokevirtual 1574	java/net/Socket:close	()V
    //   1141: aload 17
    //   1143: astore 20
    //   1145: iload_1
    //   1146: istore_2
    //   1147: aload_0
    //   1148: aconst_null
    //   1149: putfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1152: aconst_null
    //   1153: astore 20
    //   1155: aconst_null
    //   1156: astore 17
    //   1158: iload_1
    //   1159: istore_2
    //   1160: aload_0
    //   1161: aconst_null
    //   1162: invokevirtual 1576	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
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
    //   1191: new 385	java/lang/StringBuilder
    //   1194: dup
    //   1195: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1198: ldc_w 1578
    //   1201: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: iload_1
    //   1205: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1208: ldc_w 1509
    //   1211: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1217: new 385	java/lang/StringBuilder
    //   1220: dup
    //   1221: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1224: ldc 89
    //   1226: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: aload_0
    //   1230: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1233: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1236: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1239: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1242: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1245: aload 18
    //   1247: ifnonnull +1513 -> 2760
    //   1250: ldc 89
    //   1252: astore 20
    //   1254: iconst_1
    //   1255: istore_2
    //   1256: iconst_1
    //   1257: istore 4
    //   1259: aload_0
    //   1260: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1263: ifnonnull +98 -> 1361
    //   1266: aload_0
    //   1267: iload_1
    //   1268: iload 15
    //   1270: invokevirtual 1511	oicq/wlogin_sdk/request/j:a	(IZ)Ljava/lang/String;
    //   1273: astore 20
    //   1275: new 385	java/lang/StringBuilder
    //   1278: dup
    //   1279: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1282: ldc_w 1580
    //   1285: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: aload 20
    //   1290: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: ldc_w 1582
    //   1296: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1302: new 385	java/lang/StringBuilder
    //   1305: dup
    //   1306: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1309: ldc 89
    //   1311: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: aload_0
    //   1315: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1318: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1321: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1330: aload_0
    //   1331: aload_0
    //   1332: iload 15
    //   1334: invokevirtual 175	oicq/wlogin_sdk/request/j:c	(Z)I
    //   1337: putfield 131	oicq/wlogin_sdk/request/j:q	I
    //   1340: aload_0
    //   1341: aload 20
    //   1343: aload_0
    //   1344: getfield 131	oicq/wlogin_sdk/request/j:q	I
    //   1347: aload_0
    //   1348: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1351: getfield 536	oicq/wlogin_sdk/request/t:l	I
    //   1354: i2l
    //   1355: invokestatic 1553	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   1358: putfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1361: aload_0
    //   1362: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1365: ifnull +82 -> 1447
    //   1368: aload_0
    //   1369: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1372: invokevirtual 216	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1375: ifnonnull +72 -> 1447
    //   1378: aload_0
    //   1379: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1382: invokevirtual 216	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1385: ifnonnull +34 -> 1419
    //   1388: ldc_w 1584
    //   1391: new 385	java/lang/StringBuilder
    //   1394: dup
    //   1395: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1398: ldc 89
    //   1400: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: aload_0
    //   1404: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1407: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1410: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1413: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1416: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1419: sipush -1007
    //   1422: istore_2
    //   1423: iload_1
    //   1424: iconst_1
    //   1425: iadd
    //   1426: istore_1
    //   1427: aload_0
    //   1428: aconst_null
    //   1429: putfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1432: aload_0
    //   1433: aconst_null
    //   1434: invokevirtual 1576	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   1437: aconst_null
    //   1438: astore 18
    //   1440: iload 15
    //   1442: istore 14
    //   1444: goto -1352 -> 92
    //   1447: aload_0
    //   1448: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1451: ifnull +21 -> 1472
    //   1454: aload 19
    //   1456: aload_0
    //   1457: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1460: invokevirtual 216	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1463: invokevirtual 222	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1466: invokevirtual 1556	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1469: ifeq +149 -> 1618
    //   1472: aload_0
    //   1473: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1476: ifnonnull +86 -> 1562
    //   1479: new 385	java/lang/StringBuilder
    //   1482: dup
    //   1483: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1486: ldc_w 1580
    //   1489: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: aload 20
    //   1494: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: ldc_w 1586
    //   1500: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1506: new 385	java/lang/StringBuilder
    //   1509: dup
    //   1510: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1513: ldc 89
    //   1515: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1518: aload_0
    //   1519: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1522: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1525: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1528: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1531: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1534: sipush -1007
    //   1537: istore_2
    //   1538: iload_1
    //   1539: iconst_1
    //   1540: iadd
    //   1541: istore_1
    //   1542: aload_0
    //   1543: aconst_null
    //   1544: putfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1547: aconst_null
    //   1548: astore 18
    //   1550: aload_0
    //   1551: aconst_null
    //   1552: invokevirtual 1576	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   1555: iload 15
    //   1557: istore 14
    //   1559: goto -1467 -> 92
    //   1562: new 385	java/lang/StringBuilder
    //   1565: dup
    //   1566: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1569: ldc_w 1588
    //   1572: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: aload 19
    //   1577: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1583: new 385	java/lang/StringBuilder
    //   1586: dup
    //   1587: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1590: ldc 89
    //   1592: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: aload_0
    //   1596: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1599: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1602: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1605: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1608: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1611: sipush -1000
    //   1614: istore_2
    //   1615: goto -77 -> 1538
    //   1618: aload_0
    //   1619: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1622: invokevirtual 216	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1625: invokevirtual 222	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1628: astore 19
    //   1630: new 385	java/lang/StringBuilder
    //   1633: dup
    //   1634: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1637: ldc_w 1580
    //   1640: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: aload 20
    //   1645: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: ldc_w 1590
    //   1651: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: aload_0
    //   1655: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1658: invokevirtual 1591	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   1661: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: ldc_w 1593
    //   1667: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1670: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1673: new 385	java/lang/StringBuilder
    //   1676: dup
    //   1677: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1680: ldc 89
    //   1682: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1685: aload_0
    //   1686: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1689: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1692: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1695: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1698: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1701: iload_2
    //   1702: istore 4
    //   1704: aload 18
    //   1706: ifnonnull +1051 -> 2757
    //   1709: new 385	java/lang/StringBuilder
    //   1712: dup
    //   1713: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1716: ldc_w 1595
    //   1719: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1722: aload_0
    //   1723: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1726: invokevirtual 939	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1729: ldc_w 1582
    //   1732: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1735: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1738: new 385	java/lang/StringBuilder
    //   1741: dup
    //   1742: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1745: ldc 89
    //   1747: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: aload_0
    //   1751: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1754: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1757: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1760: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1763: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1766: new 1573	java/net/Socket
    //   1769: dup
    //   1770: invokespecial 1596	java/net/Socket:<init>	()V
    //   1773: astore 18
    //   1775: aload_0
    //   1776: aload 18
    //   1778: invokevirtual 1576	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   1781: aload 18
    //   1783: aload_0
    //   1784: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1787: aload_0
    //   1788: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1791: getfield 536	oicq/wlogin_sdk/request/t:l	I
    //   1794: invokevirtual 1600	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   1797: aload 18
    //   1799: aload_0
    //   1800: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1803: getfield 536	oicq/wlogin_sdk/request/t:l	I
    //   1806: invokevirtual 1603	java/net/Socket:setSoTimeout	(I)V
    //   1809: aload 18
    //   1811: aload_0
    //   1812: getfield 133	oicq/wlogin_sdk/request/j:r	[B
    //   1815: arraylength
    //   1816: invokevirtual 1606	java/net/Socket:setReceiveBufferSize	(I)V
    //   1819: new 385	java/lang/StringBuilder
    //   1822: dup
    //   1823: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1826: ldc_w 1595
    //   1829: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1832: aload_0
    //   1833: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1836: invokevirtual 939	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1839: ldc_w 1608
    //   1842: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1848: new 385	java/lang/StringBuilder
    //   1851: dup
    //   1852: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1855: ldc 89
    //   1857: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1860: aload_0
    //   1861: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1864: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1867: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1870: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1873: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1876: ldc_w 1610
    //   1879: new 385	java/lang/StringBuilder
    //   1882: dup
    //   1883: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1886: ldc 89
    //   1888: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1891: aload_0
    //   1892: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   1895: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1898: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1901: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1904: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1907: aload 18
    //   1909: invokevirtual 1611	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   1912: astore 20
    //   1914: aload 20
    //   1916: aload 24
    //   1918: iconst_0
    //   1919: aload 24
    //   1921: arraylength
    //   1922: invokevirtual 1562	java/io/OutputStream:write	([BII)V
    //   1925: aload 20
    //   1927: invokevirtual 1565	java/io/OutputStream:flush	()V
    //   1930: aload 18
    //   1932: invokevirtual 1612	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   1935: astore 22
    //   1937: aload 17
    //   1939: astore 20
    //   1941: aload 19
    //   1943: astore 21
    //   1945: aload 18
    //   1947: astore 17
    //   1949: aload 20
    //   1951: astore 19
    //   1953: aload 21
    //   1955: astore 18
    //   1957: aload 22
    //   1959: astore 21
    //   1961: goto -947 -> 1014
    //   1964: astore 18
    //   1966: iload_1
    //   1967: iconst_1
    //   1968: iadd
    //   1969: istore_1
    //   1970: aload_0
    //   1971: aconst_null
    //   1972: putfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   1975: aload_0
    //   1976: aconst_null
    //   1977: invokevirtual 1576	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   1980: sipush -1000
    //   1983: istore_2
    //   1984: aconst_null
    //   1985: astore 18
    //   1987: iload 15
    //   1989: istore 14
    //   1991: goto -1899 -> 92
    //   1994: iload 6
    //   1996: iload 5
    //   1998: iadd
    //   1999: istore 6
    //   2001: goto -944 -> 1057
    //   2004: aload 17
    //   2006: astore 20
    //   2008: iload_1
    //   2009: istore_2
    //   2010: aload_0
    //   2011: aload_0
    //   2012: getfield 133	oicq/wlogin_sdk/request/j:r	[B
    //   2015: invokevirtual 1614	oicq/wlogin_sdk/request/j:b	([B)I
    //   2018: istore 6
    //   2020: iload 6
    //   2022: istore_2
    //   2023: aload 17
    //   2025: astore 20
    //   2027: iload_1
    //   2028: istore_3
    //   2029: iload_2
    //   2030: aload_0
    //   2031: getfield 107	oicq/wlogin_sdk/request/j:e	I
    //   2034: iconst_1
    //   2035: iadd
    //   2036: if_icmpgt +58 -> 2094
    //   2039: iload_1
    //   2040: iconst_1
    //   2041: iadd
    //   2042: istore_1
    //   2043: aload 17
    //   2045: astore 20
    //   2047: iload 15
    //   2049: ifne +732 -> 2781
    //   2052: aload 17
    //   2054: astore 20
    //   2056: iload_1
    //   2057: istore_3
    //   2058: aload 17
    //   2060: invokevirtual 1574	java/net/Socket:close	()V
    //   2063: aload 17
    //   2065: astore 20
    //   2067: iload_1
    //   2068: istore_3
    //   2069: aload_0
    //   2070: aconst_null
    //   2071: putfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   2074: aconst_null
    //   2075: astore 17
    //   2077: aconst_null
    //   2078: astore 20
    //   2080: iload_1
    //   2081: istore_3
    //   2082: aload_0
    //   2083: aconst_null
    //   2084: invokevirtual 1576	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   2087: aload 17
    //   2089: astore 20
    //   2091: goto +690 -> 2781
    //   2094: aload 17
    //   2096: astore 20
    //   2098: iload_1
    //   2099: istore_3
    //   2100: iload_2
    //   2101: aload_0
    //   2102: getfield 133	oicq/wlogin_sdk/request/j:r	[B
    //   2105: arraylength
    //   2106: if_icmplt +58 -> 2164
    //   2109: iload_1
    //   2110: iconst_1
    //   2111: iadd
    //   2112: istore_1
    //   2113: aload 17
    //   2115: astore 20
    //   2117: iload 15
    //   2119: ifne +687 -> 2806
    //   2122: aload 17
    //   2124: astore 20
    //   2126: iload_1
    //   2127: istore_3
    //   2128: aload 17
    //   2130: invokevirtual 1574	java/net/Socket:close	()V
    //   2133: aload 17
    //   2135: astore 20
    //   2137: iload_1
    //   2138: istore_3
    //   2139: aload_0
    //   2140: aconst_null
    //   2141: putfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   2144: aconst_null
    //   2145: astore 17
    //   2147: aconst_null
    //   2148: astore 20
    //   2150: iload_1
    //   2151: istore_3
    //   2152: aload_0
    //   2153: aconst_null
    //   2154: invokevirtual 1576	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   2157: aload 17
    //   2159: astore 20
    //   2161: goto +645 -> 2806
    //   2164: aload 17
    //   2166: astore 20
    //   2168: iload_1
    //   2169: istore_3
    //   2170: aload_0
    //   2171: getfield 107	oicq/wlogin_sdk/request/j:e	I
    //   2174: iconst_1
    //   2175: iadd
    //   2176: istore 7
    //   2178: iload_2
    //   2179: iload 7
    //   2181: isub
    //   2182: istore 6
    //   2184: iload 5
    //   2186: istore 8
    //   2188: iload 6
    //   2190: ifle +34 -> 2224
    //   2193: aload 17
    //   2195: astore 20
    //   2197: iload_1
    //   2198: istore_3
    //   2199: aload 21
    //   2201: aload_0
    //   2202: getfield 133	oicq/wlogin_sdk/request/j:r	[B
    //   2205: iload 7
    //   2207: iload 6
    //   2209: invokevirtual 1571	java/io/InputStream:read	([BII)I
    //   2212: istore 5
    //   2214: iload 5
    //   2216: iconst_m1
    //   2217: if_icmpne +108 -> 2325
    //   2220: iload 5
    //   2222: istore 8
    //   2224: iload_2
    //   2225: istore 5
    //   2227: lload 9
    //   2229: lstore 11
    //   2231: iload 4
    //   2233: istore_3
    //   2234: iload 15
    //   2236: istore 14
    //   2238: iload 13
    //   2240: istore 16
    //   2242: iload 8
    //   2244: iconst_m1
    //   2245: if_icmpne +185 -> 2430
    //   2248: iload_1
    //   2249: iconst_1
    //   2250: iadd
    //   2251: istore_1
    //   2252: aload 17
    //   2254: astore 20
    //   2256: iload 15
    //   2258: ifne +42 -> 2300
    //   2261: aload 17
    //   2263: astore 20
    //   2265: iload_1
    //   2266: istore_3
    //   2267: aload 17
    //   2269: invokevirtual 1574	java/net/Socket:close	()V
    //   2272: aload 17
    //   2274: astore 20
    //   2276: iload_1
    //   2277: istore_3
    //   2278: aload_0
    //   2279: aconst_null
    //   2280: putfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   2283: aconst_null
    //   2284: astore 20
    //   2286: aconst_null
    //   2287: astore 17
    //   2289: iload_1
    //   2290: istore_3
    //   2291: aload_0
    //   2292: aconst_null
    //   2293: invokevirtual 1576	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   2296: aload 17
    //   2298: astore 20
    //   2300: iload_2
    //   2301: istore_3
    //   2302: sipush -1000
    //   2305: istore_2
    //   2306: aload 19
    //   2308: astore 17
    //   2310: aload 18
    //   2312: astore 19
    //   2314: iload 15
    //   2316: istore 14
    //   2318: aload 20
    //   2320: astore 18
    //   2322: goto -2230 -> 92
    //   2325: iload 7
    //   2327: iload 5
    //   2329: iadd
    //   2330: istore 7
    //   2332: iload 6
    //   2334: iload 5
    //   2336: isub
    //   2337: istore 6
    //   2339: goto -155 -> 2184
    //   2342: astore 17
    //   2344: iload_2
    //   2345: istore_1
    //   2346: iload_3
    //   2347: istore_2
    //   2348: iload_1
    //   2349: iconst_1
    //   2350: iadd
    //   2351: istore_1
    //   2352: aload 20
    //   2354: astore 17
    //   2356: iload 15
    //   2358: ifne +29 -> 2387
    //   2361: aload 20
    //   2363: invokevirtual 1617	java/net/Socket:isConnected	()Z
    //   2366: ifeq +8 -> 2374
    //   2369: aload 20
    //   2371: invokevirtual 1574	java/net/Socket:close	()V
    //   2374: aload_0
    //   2375: aconst_null
    //   2376: putfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   2379: aconst_null
    //   2380: astore 17
    //   2382: aload_0
    //   2383: aconst_null
    //   2384: invokevirtual 1576	oicq/wlogin_sdk/request/j:a	(Ljava/net/Socket;)V
    //   2387: aload 17
    //   2389: astore 20
    //   2391: iload_2
    //   2392: istore_3
    //   2393: sipush -1000
    //   2396: istore_2
    //   2397: aload 19
    //   2399: astore 17
    //   2401: aload 18
    //   2403: astore 19
    //   2405: iload 15
    //   2407: istore 14
    //   2409: aload 20
    //   2411: astore 18
    //   2413: goto -2321 -> 92
    //   2416: iload_3
    //   2417: istore 5
    //   2419: iload 13
    //   2421: istore 16
    //   2423: iload 4
    //   2425: istore_3
    //   2426: lload 9
    //   2428: lstore 11
    //   2430: iload_1
    //   2431: bipush 6
    //   2433: if_icmplt +252 -> 2685
    //   2436: sipush -1000
    //   2439: istore_2
    //   2440: iload_2
    //   2441: ifne +13 -> 2454
    //   2444: aload_0
    //   2445: aload_0
    //   2446: getfield 133	oicq/wlogin_sdk/request/j:r	[B
    //   2449: iload 5
    //   2451: invokevirtual 576	oicq/wlogin_sdk/request/j:b	([BI)V
    //   2454: iload_2
    //   2455: ifne +170 -> 2625
    //   2458: aload_0
    //   2459: getfield 135	oicq/wlogin_sdk/request/j:s	I
    //   2462: sipush 2066
    //   2465: if_icmpeq +160 -> 2625
    //   2468: new 144	oicq/wlogin_sdk/report/report_t3
    //   2471: dup
    //   2472: invokespecial 145	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   2475: astore 17
    //   2477: aload 17
    //   2479: aload_0
    //   2480: getfield 135	oicq/wlogin_sdk/request/j:s	I
    //   2483: putfield 148	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   2486: aload 17
    //   2488: aload_0
    //   2489: getfield 137	oicq/wlogin_sdk/request/j:t	I
    //   2492: putfield 151	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   2495: aload 17
    //   2497: iload_2
    //   2498: putfield 154	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   2501: aload 17
    //   2503: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   2506: lload 11
    //   2508: lsub
    //   2509: l2i
    //   2510: putfield 163	oicq/wlogin_sdk/report/report_t3:_used	I
    //   2513: aload 17
    //   2515: iload_1
    //   2516: putfield 166	oicq/wlogin_sdk/report/report_t3:_try	I
    //   2519: aload 17
    //   2521: getstatic 93	oicq/wlogin_sdk/request/j:C	Ljava/lang/String;
    //   2524: putfield 169	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   2527: aload 17
    //   2529: getfield 169	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   2532: ifnonnull +10 -> 2542
    //   2535: aload 17
    //   2537: ldc 89
    //   2539: putfield 169	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   2542: aload_0
    //   2543: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   2546: ifnonnull +144 -> 2690
    //   2549: aload 17
    //   2551: ldc 89
    //   2553: putfield 172	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   2556: aload 17
    //   2558: aload_0
    //   2559: getfield 131	oicq/wlogin_sdk/request/j:q	I
    //   2562: putfield 178	oicq/wlogin_sdk/report/report_t3:_port	I
    //   2565: aload 17
    //   2567: iload_3
    //   2568: putfield 181	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   2571: aload 17
    //   2573: getstatic 185	oicq/wlogin_sdk/request/t:B	I
    //   2576: putfield 188	oicq/wlogin_sdk/report/report_t3:_net	I
    //   2579: aload 17
    //   2581: ldc 89
    //   2583: putfield 191	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   2586: aload 17
    //   2588: aload 24
    //   2590: arraylength
    //   2591: putfield 194	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   2594: aload 17
    //   2596: iload 5
    //   2598: putfield 197	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   2601: iload 14
    //   2603: ifeq +114 -> 2717
    //   2606: iload 16
    //   2608: ifeq +100 -> 2708
    //   2611: aload 17
    //   2613: iconst_2
    //   2614: putfield 200	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   2617: getstatic 204	oicq/wlogin_sdk/request/t:ah	Loicq/wlogin_sdk/report/report_t1;
    //   2620: aload 17
    //   2622: invokevirtual 210	oicq/wlogin_sdk/report/report_t1:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   2625: new 385	java/lang/StringBuilder
    //   2628: dup
    //   2629: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   2632: aload_0
    //   2633: invokevirtual 528	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2636: invokevirtual 533	java/lang/Class:getName	()Ljava/lang/String;
    //   2639: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2642: ldc_w 1619
    //   2645: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2648: iload_2
    //   2649: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2652: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2655: new 385	java/lang/StringBuilder
    //   2658: dup
    //   2659: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   2662: ldc 89
    //   2664: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2667: aload_0
    //   2668: getfield 231	oicq/wlogin_sdk/request/j:w	Loicq/wlogin_sdk/request/t;
    //   2671: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   2674: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2677: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2680: invokestatic 303	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2683: iload_2
    //   2684: ireturn
    //   2685: iconst_0
    //   2686: istore_2
    //   2687: goto -247 -> 2440
    //   2690: aload 17
    //   2692: aload_0
    //   2693: getfield 129	oicq/wlogin_sdk/request/j:p	Ljava/net/InetSocketAddress;
    //   2696: invokevirtual 216	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   2699: invokevirtual 222	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2702: putfield 172	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   2705: goto -149 -> 2556
    //   2708: aload 17
    //   2710: iconst_1
    //   2711: putfield 200	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   2714: goto -97 -> 2617
    //   2717: aload 17
    //   2719: iconst_0
    //   2720: putfield 200	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   2723: goto -106 -> 2617
    //   2726: astore 17
    //   2728: goto -354 -> 2374
    //   2731: astore 17
    //   2733: iload_3
    //   2734: istore_1
    //   2735: goto -387 -> 2348
    //   2738: astore 21
    //   2740: goto -1379 -> 1361
    //   2743: astore 17
    //   2745: aload 20
    //   2747: astore 17
    //   2749: goto -1967 -> 782
    //   2752: astore 20
    //   2754: goto -1972 -> 782
    //   2757: goto -881 -> 1876
    //   2760: goto -1056 -> 1704
    //   2763: aload 23
    //   2765: astore 22
    //   2767: goto -1953 -> 814
    //   2770: aconst_null
    //   2771: astore 20
    //   2773: iconst_m1
    //   2774: istore_2
    //   2775: goto -2419 -> 356
    //   2778: goto -2422 -> 356
    //   2781: iload_2
    //   2782: istore_3
    //   2783: sipush -1000
    //   2786: istore_2
    //   2787: aload 19
    //   2789: astore 17
    //   2791: aload 18
    //   2793: astore 19
    //   2795: iload 15
    //   2797: istore 14
    //   2799: aload 20
    //   2801: astore 18
    //   2803: goto -2711 -> 92
    //   2806: iload_2
    //   2807: istore_3
    //   2808: sipush -1000
    //   2811: istore_2
    //   2812: aload 19
    //   2814: astore 17
    //   2816: aload 18
    //   2818: astore 19
    //   2820: iload 15
    //   2822: istore 14
    //   2824: aload 20
    //   2826: astore 18
    //   2828: goto -2736 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2831	0	this	j
    //   65	2670	1	i1	int
    //   63	2749	2	i2	int
    //   61	2747	3	i3	int
    //   82	2342	4	i4	int
    //   1052	1545	5	i5	int
    //   1055	1283	6	i6	int
    //   2176	155	7	i7	int
    //   2186	60	8	i8	int
    //   67	2360	9	l1	long
    //   2229	278	11	l2	long
    //   79	2341	13	bool1	boolean
    //   76	2747	14	bool2	boolean
    //   114	2707	15	bool3	boolean
    //   2240	367	16	bool4	boolean
    //   90	2219	17	localObject1	Object
    //   2342	1	17	localThrowable1	java.lang.Throwable
    //   2354	364	17	localObject2	Object
    //   2726	1	17	localException1	Exception
    //   2731	1	17	localThrowable2	java.lang.Throwable
    //   2743	1	17	localException2	Exception
    //   2747	68	17	localObject3	Object
    //   73	1883	18	localObject4	Object
    //   1964	1	18	localThrowable3	java.lang.Throwable
    //   1985	842	18	localObject5	Object
    //   86	2733	19	localObject6	Object
    //   246	373	20	localObject7	Object
    //   776	1	20	localException3	Exception
    //   799	1947	20	localObject8	Object
    //   2752	1	20	localException4	Exception
    //   2771	54	20	localObject9	Object
    //   727	1473	21	localObject10	Object
    //   2738	1	21	localException5	Exception
    //   808	1958	22	localObject11	Object
    //   220	2544	23	str	String
    //   58	2531	24	arrayOfByte	byte[]
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
    //   1709	1876	1964	java/lang/Throwable
    //   1876	1937	1964	java/lang/Throwable
    //   1020	1051	2342	java/lang/Throwable
    //   1063	1074	2342	java/lang/Throwable
    //   1080	1102	2342	java/lang/Throwable
    //   1136	1141	2342	java/lang/Throwable
    //   1147	1152	2342	java/lang/Throwable
    //   1160	1165	2342	java/lang/Throwable
    //   2010	2020	2342	java/lang/Throwable
    //   2361	2374	2726	java/lang/Exception
    //   2029	2039	2731	java/lang/Throwable
    //   2058	2063	2731	java/lang/Throwable
    //   2069	2074	2731	java/lang/Throwable
    //   2082	2087	2731	java/lang/Throwable
    //   2100	2109	2731	java/lang/Throwable
    //   2128	2133	2731	java/lang/Throwable
    //   2139	2144	2731	java/lang/Throwable
    //   2152	2157	2731	java/lang/Throwable
    //   2170	2178	2731	java/lang/Throwable
    //   2199	2214	2731	java/lang/Throwable
    //   2267	2272	2731	java/lang/Throwable
    //   2278	2283	2731	java/lang/Throwable
    //   2291	2296	2731	java/lang/Throwable
    //   1330	1361	2738	java/lang/Exception
    //   801	806	2743	java/lang/Exception
    //   818	854	2743	java/lang/Exception
    //   411	500	2752	java/lang/Exception
    //   505	515	2752	java/lang/Exception
    //   515	665	2752	java/lang/Exception
    //   861	969	2752	java/lang/Exception
    //   991	998	2752	java/lang/Exception
  }
  
  public int f()
  {
    return t.b(this.w.h)._last_flowid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.j
 * JD-Core Version:    0.7.0.1
 */