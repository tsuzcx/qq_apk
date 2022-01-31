package oicq.wlogin_sdk.request;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
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
import oicq.wlogin_sdk.b.cg;
import oicq.wlogin_sdk.b.cj;
import oicq.wlogin_sdk.b.ck;
import oicq.wlogin_sdk.b.d;
import oicq.wlogin_sdk.b.e;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.b.g;
import oicq.wlogin_sdk.b.j;
import oicq.wlogin_sdk.b.l;
import oicq.wlogin_sdk.b.n;
import oicq.wlogin_sdk.b.p;
import oicq.wlogin_sdk.b.r;
import oicq.wlogin_sdk.b.s;
import oicq.wlogin_sdk.b.u;
import oicq.wlogin_sdk.b.v;
import oicq.wlogin_sdk.b.w;
import oicq.wlogin_sdk.b.x;
import oicq.wlogin_sdk.b.z;
import oicq.wlogin_sdk.report.report_t1;
import oicq.wlogin_sdk.report.report_t3;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.InternationMsg;
import oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class o
{
  static int A = 0;
  static String B = "";
  static String C = "";
  static String[] x = { "183.60.18.138", "112.90.85.191", "112.90.85.193", "183.60.18.150", "120.196.212.233", "120.204.200.34", "27.115.124.244" };
  static String[] y = { "112.90.141.41", "112.90.141.48", "113.108.11.157", "113.108.11.159", "120.196.212.232" };
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
  public y w;
  int z = 0;
  
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
    y.b(this.w.h).i = paramInt;
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
      util.LOGD("resolve_server_addr OK", "host:" + str2 + " tryno:" + paramInt);
      return str2;
      if (paramInt < 1)
      {
        if (paramBoolean) {
          if (y.B == 1) {
            str1 = new String(util.get_wap_server_host1(y.r));
          }
        }
        for (;;)
        {
          if (str1 != null)
          {
            str2 = str1;
            if (str1.length() > 0) {
              break;
            }
          }
          str2 = b(paramBoolean);
          break;
          if (y.B == 2)
          {
            str1 = new String(util.get_wap_server_host2(y.r));
            continue;
            if (y.B == 1) {
              str1 = new String(util.get_server_host1(y.r));
            } else if (y.B == 2) {
              str1 = new String(util.get_server_host2(y.r));
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
      if (y.B == 1) {
        util.set_server_host1(y.r, paramArrayOfByte);
      }
    }
    for (;;)
    {
      util.LOGI("net type:" + y.B + " type:" + paramInt1 + " host:" + new String(paramArrayOfByte) + " port:" + paramInt2, "" + this.w.f);
      return;
      if (y.B == 2)
      {
        util.set_server_host2(y.r, paramArrayOfByte);
        continue;
        if (paramInt1 == 2) {
          if (y.B == 1) {
            util.set_wap_server_host1(y.r, paramArrayOfByte);
          } else if (y.B == 2) {
            util.set_wap_server_host2(y.r, paramArrayOfByte);
          }
        }
      }
    }
  }
  
  public void a(Socket paramSocket)
  {
    this.w.aa = paramSocket;
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
        new h(y.r, localErrMsg).start();
      }
      return;
    }
    catch (Exception paramas) {}
  }
  
  public void a(ErrMsg paramErrMsg)
  {
    k localk = y.b(this.w.h);
    localk.k = new ErrMsg(0, "", "", "");
    if (paramErrMsg != null) {}
    try
    {
      localk.k = ((ErrMsg)paramErrMsg.clone());
      return;
    }
    catch (CloneNotSupportedException paramErrMsg)
    {
      localk.k = new ErrMsg(0, "", "", "");
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
    Object localObject4 = new oicq.wlogin_sdk.b.h();
    Object localObject3 = new n();
    Object localObject2 = new bc();
    Object localObject1 = new ao();
    parambb = parambb.b();
    int i1 = parambb.length;
    if (((oicq.wlogin_sdk.b.h)localObject4).b(parambb, 2, i1) < 0) {}
    while ((((n)localObject3).b(parambb, 2, i1) < 0) || (((bc)localObject2).b(parambb, 2, i1) < 0)) {
      return null;
    }
    parambb = ((oicq.wlogin_sdk.b.h)localObject4).a();
    localObject3 = ((n)localObject3).a();
    localObject2 = ((bc)localObject2).a();
    localObject1 = ((ao)localObject1).a(y.y);
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
      util.LOGD("req body:" + util.buf_to_string(arrayOfByte));
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
    //   0: new 236	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 454	java/lang/Object:getClass	()Ljava/lang/Class;
    //   11: invokevirtual 459	java/lang/Class:getName	()Ljava/lang/String;
    //   14: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 461
    //   20: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: new 236	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   33: ldc 75
    //   35: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 138	oicq/wlogin_sdk/request/o:w	Loicq/wlogin_sdk/request/y;
    //   42: getfield 325	oicq/wlogin_sdk/request/y:f	J
    //   45: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 210	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 138	oicq/wlogin_sdk/request/o:w	Loicq/wlogin_sdk/request/y;
    //   58: getfield 462	oicq/wlogin_sdk/request/y:l	I
    //   61: istore 4
    //   63: aload_0
    //   64: invokevirtual 464	oicq/wlogin_sdk/request/o:c	()[B
    //   67: astore 7
    //   69: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   72: lstore 5
    //   74: new 236	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 470
    //   84: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 472
    //   94: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: getfield 125	oicq/wlogin_sdk/request/o:u	Ljava/lang/String;
    //   101: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 474
    //   107: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 4
    //   112: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc_w 476
    //   118: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_2
    //   122: invokevirtual 479	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   125: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: new 236	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   135: ldc 75
    //   137: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 138	oicq/wlogin_sdk/request/o:w	Loicq/wlogin_sdk/request/y;
    //   144: getfield 325	oicq/wlogin_sdk/request/y:f	J
    //   147: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 210	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: new 481	oicq/wlogin_sdk/request/WtloginMsfListener
    //   159: dup
    //   160: aload_1
    //   161: aload_0
    //   162: getfield 125	oicq/wlogin_sdk/request/o:u	Ljava/lang/String;
    //   165: aload 7
    //   167: iload 4
    //   169: iload_2
    //   170: aload_3
    //   171: invokespecial 484	oicq/wlogin_sdk/request/WtloginMsfListener:<init>	(Ljava/lang/String;Ljava/lang/String;[BIZLoicq/wlogin_sdk/request/WUserSigInfo;)V
    //   174: astore_3
    //   175: new 486	java/lang/Thread
    //   178: dup
    //   179: aload_3
    //   180: invokespecial 489	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 490	java/lang/Thread:start	()V
    //   188: aload_1
    //   189: iload 4
    //   191: i2l
    //   192: invokevirtual 494	java/lang/Thread:join	(J)V
    //   195: aload_3
    //   196: invokevirtual 497	oicq/wlogin_sdk/request/WtloginMsfListener:getRetData	()[B
    //   199: astore_1
    //   200: aload_1
    //   201: ifnonnull +240 -> 441
    //   204: new 236	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 499
    //   214: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_3
    //   218: invokevirtual 502	oicq/wlogin_sdk/request/WtloginMsfListener:getRet	()I
    //   221: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: new 236	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   234: ldc 75
    //   236: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_0
    //   240: getfield 138	oicq/wlogin_sdk/request/o:w	Loicq/wlogin_sdk/request/y;
    //   243: getfield 325	oicq/wlogin_sdk/request/y:f	J
    //   246: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 210	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: sipush -1000
    //   258: istore 4
    //   260: aload_0
    //   261: getfield 121	oicq/wlogin_sdk/request/o:s	I
    //   264: sipush 2066
    //   267: if_icmpeq +112 -> 379
    //   270: new 504	oicq/wlogin_sdk/report/report_t3
    //   273: dup
    //   274: invokespecial 505	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   277: astore_3
    //   278: aload_3
    //   279: aload_0
    //   280: getfield 121	oicq/wlogin_sdk/request/o:s	I
    //   283: putfield 508	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   286: aload_3
    //   287: aload_0
    //   288: getfield 123	oicq/wlogin_sdk/request/o:t	I
    //   291: putfield 511	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   294: aload_3
    //   295: iload 4
    //   297: putfield 514	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   300: aload_3
    //   301: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   304: lload 5
    //   306: lsub
    //   307: l2i
    //   308: putfield 517	oicq/wlogin_sdk/report/report_t3:_used	I
    //   311: aload_3
    //   312: iconst_0
    //   313: putfield 520	oicq/wlogin_sdk/report/report_t3:_try	I
    //   316: aload_3
    //   317: ldc 75
    //   319: putfield 523	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   322: aload_3
    //   323: ldc 75
    //   325: putfield 526	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   328: aload_3
    //   329: iconst_0
    //   330: putfield 529	oicq/wlogin_sdk/report/report_t3:_port	I
    //   333: aload_3
    //   334: iconst_0
    //   335: putfield 532	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   338: aload_3
    //   339: iconst_0
    //   340: putfield 535	oicq/wlogin_sdk/report/report_t3:_net	I
    //   343: aload_3
    //   344: ldc 75
    //   346: putfield 538	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   349: iload 4
    //   351: ifne +143 -> 494
    //   354: aload_3
    //   355: aload 7
    //   357: arraylength
    //   358: putfield 541	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   361: aload_3
    //   362: aload_1
    //   363: arraylength
    //   364: putfield 544	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   367: aload_3
    //   368: iconst_3
    //   369: putfield 547	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   372: getstatic 551	oicq/wlogin_sdk/request/y:ae	Loicq/wlogin_sdk/report/report_t1;
    //   375: aload_3
    //   376: invokevirtual 557	oicq/wlogin_sdk/report/report_t1:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   379: new 236	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   386: aload_0
    //   387: invokevirtual 454	java/lang/Object:getClass	()Ljava/lang/Class;
    //   390: invokevirtual 459	java/lang/Class:getName	()Ljava/lang/String;
    //   393: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: ldc_w 559
    //   399: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: iload 4
    //   404: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: new 236	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   417: ldc 75
    //   419: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_0
    //   423: getfield 138	oicq/wlogin_sdk/request/o:w	Loicq/wlogin_sdk/request/y;
    //   426: getfield 325	oicq/wlogin_sdk/request/y:f	J
    //   429: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   432: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 210	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: iload 4
    //   440: ireturn
    //   441: aload_0
    //   442: aload_1
    //   443: aload_1
    //   444: arraylength
    //   445: invokevirtual 561	oicq/wlogin_sdk/request/o:b	([BI)V
    //   448: iconst_0
    //   449: istore 4
    //   451: goto -191 -> 260
    //   454: astore_3
    //   455: aconst_null
    //   456: astore_1
    //   457: aload_3
    //   458: new 236	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   465: ldc 75
    //   467: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_0
    //   471: getfield 138	oicq/wlogin_sdk/request/o:w	Loicq/wlogin_sdk/request/y;
    //   474: getfield 325	oicq/wlogin_sdk/request/y:f	J
    //   477: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   480: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 565	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   486: sipush -1000
    //   489: istore 4
    //   491: goto -231 -> 260
    //   494: aload_3
    //   495: iconst_0
    //   496: putfield 541	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   499: aload_3
    //   500: iconst_0
    //   501: putfield 544	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   504: goto -137 -> 367
    //   507: astore_3
    //   508: goto -51 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	o
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
    paramArrayOfByte = y.b(this.w.h);
    if (paramInt1 >= 0)
    {
      paramArrayOfByte.k.setTitle(new String(localap.f()));
      paramArrayOfByte.k.setMessage(new String(localap.g()));
      paramArrayOfByte.k.setType(localap.h());
      paramArrayOfByte.k.setOtherinfo(new String(localap.i()));
    }
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
    Object localObject7 = new g();
    r localr = new r();
    u localu = new u();
    oicq.wlogin_sdk.b.o localo = new oicq.wlogin_sdk.b.o();
    p localp = new p();
    l locall = new l();
    s locals = new s();
    e locale = new e();
    v localv = new v();
    d locald = new d();
    oicq.wlogin_sdk.b.m localm = new oicq.wlogin_sdk.b.m();
    w localw = new w();
    x localx = new x();
    z localz = new z();
    aa localaa = new aa();
    ag localag = new ag();
    j localj = new j();
    Object localObject5 = new oicq.wlogin_sdk.b.h();
    Object localObject6 = new n();
    Object localObject3 = new ac();
    Object localObject4 = new oicq.wlogin_sdk.b.y();
    aj localaj = new aj();
    ah localah = new ah();
    as localas = new as();
    at localat = new at();
    am localam = new am();
    cg localcg = new cg();
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
    cj localcj = new cj();
    ck localck = new ck();
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte3 = null;
    byte[] arrayOfByte4 = null;
    byte[] arrayOfByte5 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    byte[] arrayOfByte6 = null;
    ai localai = new ai();
    k localk = y.b(this.w.h);
    long l3 = localk.a;
    long l4 = localk.b;
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
      util.LOGD(getClass().getName(), "get_response_body type=" + i1);
      int i2 = paramInt1 + 5;
      this.w.d = null;
      label818:
      label1515:
      int i4;
      switch (i1)
      {
      default: 
        b(paramArrayOfByte, i2, this.b - i2 - 1);
        paramInt1 = i1;
      case 0: 
        label933:
        do
        {
          localObject1 = new StringBuilder().append("type:").append(i1).append(" ret:0x");
          if (paramInt1 <= 0) {
            break label5012;
          }
          paramArrayOfByte = Integer.toHexString(paramInt1);
          util.LOGI(paramArrayOfByte, "" + this.w.f);
          if (paramInt1 == 0) {
            a((ErrMsg)null);
          }
          if ((paramInt1 != 10) && (paramInt1 != 161) && (paramInt1 != 162) && (paramInt1 != 164) && (paramInt1 != 165) && (paramInt1 != 166) && (paramInt1 != 154) && ((paramInt1 < 128) || (paramInt1 > 143))) {
            break label5020;
          }
          paramInt1 = -1000;
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
          if (paramInt2 == 1)
          {
            if (this.w.b == null) {
              return -1006;
            }
            if (localat.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0) {
              this.w.d = localat;
            }
            if (localaw.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0)
            {
              a(localaw);
              util.LOGD("parse t161 called");
            }
            paramInt1 = localu.a(paramArrayOfByte, i2, this.b - i2 - 1, this.w.b);
          }
          for (;;)
          {
            if (paramInt1 >= 0) {
              break label1515;
            }
            util.LOGD("119 can not decrypt");
            break;
            if (paramInt2 == 2)
            {
              if (f() == 3)
              {
                if (localr.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0)
                {
                  this.w.f = localr.f();
                  this.w.a(this.w.g, Long.valueOf(this.w.f));
                }
                if (localf.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0) {
                  localk.m = localf;
                }
                paramInt1 = 0;
                break;
              }
              if (localat.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0) {
                this.w.d = localat;
              }
              if (localaw.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0)
              {
                a(localaw);
                util.LOGD("parse t161 called");
              }
              paramInt1 = localu.a(paramArrayOfByte, i2, this.b - i2 - 1, localk.l);
              continue;
            }
            if ((paramInt2 == 3) || (paramInt2 == 7))
            {
              paramInt1 = localr.b(paramArrayOfByte, i2, this.b - i2);
              if (paramInt1 < 0) {
                break;
              }
              this.w.f = localr.f();
              this.w.a(this.w.g, Long.valueOf(this.w.f));
              paramInt1 = localf.b(paramArrayOfByte, i2, this.b - i2);
              if (paramInt1 < 0) {
                break;
              }
              localk.m = localf;
              paramInt1 = 0;
              break;
            }
            if (localat.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0) {
              this.w.d = localat;
            }
            if (localaw.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0)
            {
              a(localaw);
              util.LOGD("parse t161 called");
            }
            paramInt1 = localu.a(paramArrayOfByte, i2, this.b - i2 - 1, localk.l);
          }
          localObject7 = localu.b();
          i2 = 2;
          i4 = localObject7.length;
          if (localas.b((byte[])localObject7, 2, i4) > 0) {
            a(localas);
          }
          if (localag.b((byte[])localObject7, 2, i4) > 0) {
            this.w.a(localag.f(), localag.g());
          }
          localo.b((byte[])localObject7, 2, i4);
          localp.b((byte[])localObject7, 2, i4);
          locall.b((byte[])localObject7, 2, i4);
          locals.b((byte[])localObject7, 2, i4);
          paramInt1 = localv.b((byte[])localObject7, 2, i4);
        } while (paramInt1 < 0);
        if (locale.b((byte[])localObject7, 2, i4) >= 0) {
          localObject1 = locale.b();
        }
        if (localj.b((byte[])localObject7, 2, i4) >= 0) {
          util.set_ksid(y.r, localj.b());
        }
        if (locald.b((byte[])localObject7, 2, i4) >= 0) {
          arrayOfByte1 = locald.b();
        }
        if (localm.b((byte[])localObject7, 2, i4) >= 0) {
          arrayOfByte2 = localm.b();
        }
        if (localw.b((byte[])localObject7, 2, i4) >= 0) {
          arrayOfByte3 = localw.b();
        }
        if (localz.b((byte[])localObject7, 2, i4) >= 0) {
          arrayOfByte4 = localz.b();
        }
        if (localaa.b((byte[])localObject7, 2, i4) >= 0) {
          arrayOfByte5 = localaa.b();
        }
        paramArrayOfByte = (byte[])localObject2;
        if (((ac)localObject3).b((byte[])localObject7, 2, i4) >= 0)
        {
          paramArrayOfByte = ((ac)localObject3).f();
          arrayOfByte6 = ((ac)localObject3).g();
        }
        if (localby.b((byte[])localObject7, 2, i4) >= 0)
        {
          localObject2 = this.w.g;
          if (util.check_uin_account((String)localObject2).booleanValue())
          {
            localObject3 = this.w.e(this.w.f);
            localObject2 = localObject3;
            if (localObject3 != null)
            {
              localObject2 = localObject3;
              if (((String)localObject3).length() > 0)
              {
                this.w.a((String)localObject3, Long.valueOf(this.w.f), localby.f());
                localObject2 = localObject3;
              }
            }
            util.LOGI("put t186: name: " + (String)localObject2 + " uin: " + this.w.f + " pwd=" + localby.f(), "");
          }
        }
        else
        {
          util.LOGI("tgt len:" + util.buf_len(locall.b()) + " tgt_key len:" + util.buf_len(localo.b()) + " st len:" + util.buf_len(locals.b()) + " st_key len:" + util.buf_len(localp.b()) + " stwx_web len:" + util.buf_len((byte[])localObject1) + " a8 len:" + util.buf_len(arrayOfByte1) + " a5 len:" + util.buf_len(arrayOfByte2) + " lskey len:" + util.buf_len(arrayOfByte3) + " skey len:" + util.buf_len(arrayOfByte4) + " sig64 len:" + util.buf_len(arrayOfByte5) + " openid len:" + util.buf_len(paramArrayOfByte) + " openkey len:" + util.buf_len(arrayOfByte6) + " pwdflag: " + localby.c() + " " + localby.f(), "" + this.w.f);
          if (localbb.b((byte[])localObject7, 2, i4) >= 0)
          {
            localObject2 = a(localbb);
            if ((localObject2 == null) || (localObject2.length <= 0)) {
              break label2458;
            }
          }
        }
        label2458:
        for (this.w.j = new WFastLoginInfo((byte[])localObject2);; this.w.j = new WFastLoginInfo())
        {
          localObject2 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 3, 0 });
          if (localba.b((byte[])localObject7, 2, i4) >= 0)
          {
            localObject2[0] = localba.f();
            localObject2[1] = localba.g();
            localObject2[2] = localba.h();
            util.LOGD("type:" + util.buf_to_string(localObject2[0]) + " format:" + util.buf_to_string(localObject2[1]) + " url:" + new String(localObject2[2]));
          }
          localObject3 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 5, 0 });
          paramInt1 = 0;
          while (paramInt1 < 5)
          {
            localObject3[paramInt1] = new byte[0];
            paramInt1 += 1;
          }
          this.w.a((String)localObject2, Long.valueOf(this.w.f), localby.f());
          break;
        }
        paramInt1 = ((n)localObject6).b((byte[])localObject7, 2, i4);
        if ((((oicq.wlogin_sdk.b.h)localObject5).b((byte[])localObject7, 2, i4) >= 0) && (paramInt1 >= 0))
        {
          localObject6 = ((n)localObject6).b();
          localObject3[0] = ((byte[])b(((oicq.wlogin_sdk.b.h)localObject5).b(), (byte[])localObject6).clone());
        }
        if (localbc.b((byte[])localObject7, 2, i4) >= 0) {
          localObject3[1] = localbc.b();
        }
        if (localck.b((byte[])localObject7, 2, i4) >= 0)
        {
          localObject3[4] = localck.b();
          util.LOGD("t403 data:" + util.buf_to_string(localck.b()));
        }
        if (localk.q)
        {
          localObject3[2] = localk.u;
          localObject3[3] = localk.t;
          localObject3[4] = localk.s.b();
          localk.q = false;
          util.LOGD("G:" + util.buf_to_string(localObject3[2]));
          util.LOGD("dpwd:" + util.buf_to_string(localObject3[3]));
          util.LOGD("randseed:" + util.buf_to_string(localObject3[4]));
        }
        localObject5 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 8, 0 });
        paramInt1 = 0;
        while (paramInt1 < 8)
        {
          localObject5[paramInt1] = new byte[0];
          paramInt1 += 1;
        }
        if (localai.b((byte[])localObject7, 2, i4) >= 0) {
          localObject5[0] = localai.b();
        }
        if (localah.b((byte[])localObject7, 2, i4) >= 0)
        {
          localObject5[1] = localah.f();
          paramArrayOfByte = localah.g();
        }
        break;
      }
      label3330:
      label3348:
      label5020:
      for (;;)
      {
        if (localam.b((byte[])localObject7, 2, i4) >= 0) {
          localObject5[2] = localam.b();
        }
        if (localcg.b((byte[])localObject7, 2, i4) >= 0) {
          localObject5[3] = localcg.b();
        }
        if (localax.b((byte[])localObject7, 2, i4) >= 0) {
          localObject5[4] = localax.b();
        }
        if (localbh.b((byte[])localObject7, 2, i4) >= 0) {
          localObject5[5] = localbh.b();
        }
        if (localbe.b((byte[])localObject7, 2, i4) >= 0) {
          localObject5[6] = localbe.b();
        }
        if (localbf.b((byte[])localObject7, 2, i4) >= 0) {
          localObject5[7] = localbf.b();
        }
        util.LOGI("encrypt_a1 len:" + util.buf_len(localObject3[0]) + " no_pic_sig len:" + util.buf_len(localObject3[1]) + " G len:" + util.buf_len(localObject3[2]) + " dpwd len:" + util.buf_len(localObject3[3]) + " randseed len:" + util.buf_len(localObject3[4]) + " vkey len:" + util.buf_len(localObject5[0]) + " openid len:" + util.buf_len(paramArrayOfByte) + " access_token len:" + util.buf_len(localObject5[1]) + " d2 len:" + util.buf_len(localObject5[2]) + " d2_key len:" + util.buf_len(localObject5[3]) + " sid len:" + util.buf_len(localObject5[4]) + " aq_sig len:" + util.buf_len(localObject5[5]) + " pskey len:" + util.buf_len(localObject5[6]) + " super_key len:" + util.buf_len(localObject5[7]), "" + this.w.f);
        if (((oicq.wlogin_sdk.b.y)localObject4).b((byte[])localObject7, 2, i4) >= 0) {
          l2 = 0xFFFFFFFF & ((oicq.wlogin_sdk.b.y)localObject4).f();
        }
        localObject4 = new long[7];
        paramInt1 = 2;
        long l1 = 2160000L;
        label3263:
        paramInt1 = localaj.b((byte[])localObject7, paramInt1, i4);
        if (paramInt1 >= 0)
        {
          if (localaj.f() == 0) {
            break label5023;
          }
          l1 = localaj.f();
        }
        label3484:
        label5023:
        for (;;)
        {
          if (localaj.g() != 0)
          {
            localObject4[0] = localaj.g();
            label3312:
            if (localaj.h() == 0) {
              break label3434;
            }
            localObject4[1] = localaj.h();
            if (localaj.i() == 0) {
              break label3444;
            }
            localObject4[2] = localaj.i();
            if (localaj.j() == 0) {
              break label3454;
            }
            localObject4[3] = localaj.j();
            label3366:
            if (localaj.k() == 0) {
              break label3464;
            }
            localObject4[4] = localaj.k();
            label3384:
            if (localaj.l() == 0) {
              break label3474;
            }
            localObject4[5] = localaj.l();
          }
          for (;;)
          {
            if (localaj.m() == 0) {
              break label3484;
            }
            localObject4[6] = localaj.m();
            break;
            localObject4[0] = 1641600L;
            break label3312;
            label3434:
            localObject4[1] = 2880L;
            break label3330;
            label3444:
            localObject4[2] = 1728000L;
            break label3348;
            label3454:
            localObject4[3] = 72000L;
            break label3366;
            localObject4[4] = 6000L;
            break label3384;
            localObject4[5] = 1728000L;
          }
          localObject4[6] = 1728000L;
          break label3263;
          util.LOGI("sappid:" + l3 + " appid:" + l4 + " app_pri:" + l2 + " login_bitmap:" + localk.j + " tk_valid:" + 0L + " a2_valid:" + l1 + " lskey_valid:" + localObject4[0] + " skey_valid:" + localObject4[1] + " vkey_valid:" + localObject4[2] + " a8_valid:" + localObject4[3] + " stweb_valid:" + localObject4[4] + " d2_valid:" + localObject4[5] + " sid_valid:" + localObject4[6], "" + this.w.f);
          int i3 = this.w.a(this.w.f, l3, (byte[][])localObject3, l4, l2, y.f(), y.f() + 0L, l1 + y.f(), localv.f(), localv.g(), localv.h(), localv.i(), (byte[][])localObject2, locall.b(), localo.b(), locals.b(), localp.b(), (byte[])localObject1, arrayOfByte2, arrayOfByte1, arrayOfByte3, arrayOfByte4, arrayOfByte5, paramArrayOfByte, arrayOfByte6, (byte[][])localObject5, (long[])localObject4, localk.j);
          paramInt1 = i2;
          if (i3 != 0)
          {
            paramArrayOfByte = new ErrMsg();
            paramArrayOfByte.setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
            a(paramArrayOfByte);
            util.LOGI("put_siginfo fail,ret=" + i3, "" + this.w.f);
            paramInt1 = i3;
            break;
          }
          for (;;)
          {
            paramInt1 = localx.b((byte[])localObject7, paramInt1, i4);
            if (paramInt1 < 0) {
              break;
            }
            this.w.a(this.w.f, localx.f(), y.f(), y.f() + 0L, localx.h(), localx.g());
          }
          paramInt1 = 0;
          break;
          this.w.b(this.w.f, l3);
          b(paramArrayOfByte, i2, this.b - i2 - 1);
          paramInt1 = i1;
          break;
          paramInt1 = localf.b(paramArrayOfByte, i2, this.b - i2 - 1);
          if (paramInt1 < 0) {
            break;
          }
          localk.m = localf;
          localObject1 = new cc();
          if (((cc)localObject1).b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0)
          {
            a(new ErrMsg(i1, "", "", ((cc)localObject1).f()));
            paramInt1 = i1;
            break;
          }
          paramInt1 = ((g)localObject7).b(paramArrayOfByte, i2, this.b - i2 - 1);
          if (paramInt1 < 0) {
            break;
          }
          localk.n = ((g)localObject7);
          if (localay.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0) {}
          for (localk.o = localay;; localk.o = new ay())
          {
            a((ErrMsg)null);
            break;
          }
          paramInt1 = localag.b(paramArrayOfByte, i2, this.b - i2 - 1);
          if (paramInt1 < 0) {
            break;
          }
          this.w.a(localag.f(), localag.g());
          b(paramArrayOfByte, i2, this.b - i2 - 1);
          paramInt1 = i1;
          break;
          paramInt1 = localf.b(paramArrayOfByte, i2, this.b - i2 - 1);
          if (paramInt1 < 0) {
            break;
          }
          localk.m = localf;
          paramInt1 = localbk.b(paramArrayOfByte, i2, this.b - i2 - 1);
          if (paramInt1 < 0) {
            break;
          }
          localk.v = localbk;
          if (localbm.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0)
          {
            localk.x.CountryCode = new String(localbm.f());
            localk.x.Mobile = new String(localbm.g());
            localk.x.MbItemSmsCodeStatus = localbm.h();
            localk.x.AvailableMsgCount = localbm.i();
            localk.x.TimeLimit = localbm.j();
          }
          if (localbn.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0) {
            localk.x.UnionVerifyUrl = new String(localbn.f());
          }
          if (localbr.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0)
          {
            localk.x.MbGuideType = localbr.f();
            localk.x.MbGuideMsg = new String(localbr.g());
            localk.x.MbGuideInfoType = localbr.h();
            localk.x.MbGuideInfo = new String(localbr.i());
          }
          if (localbs.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0) {
            localk.x.VerifyReason = new String(localbs.b());
          }
          if (localcj.b(paramArrayOfByte, i2, this.b - i2 - 1) >= 0)
          {
            localk.r = localcj;
            label4576:
            if (localck.b(paramArrayOfByte, i2, this.b - i2 - 1) < 0) {
              break label4640;
            }
          }
          label4640:
          for (localk.s = localck;; localk.s = new ck())
          {
            b(paramArrayOfByte, i2, this.b - i2 - 1);
            paramInt1 = i1;
            break;
            localk.r = new cj();
            break label4576;
          }
          b(paramArrayOfByte, i2, this.b - i2 - 1);
          this.w.a(this.w.g);
          paramInt1 = i1;
          break;
          paramInt1 = localaw.b(paramArrayOfByte, i2, this.b - i2 - 1);
          if (paramInt1 < 0) {
            break;
          }
          a(localaw);
          b(paramArrayOfByte, i2, this.b - i2 - 1);
          paramInt1 = i1;
          break;
          paramInt1 = localf.b(paramArrayOfByte, i2, this.b - i2 - 1);
          if (paramInt1 < 0) {
            break;
          }
          localk.m = localf;
          paramInt1 = localcj.b(paramArrayOfByte, i2, this.b - i2 - 1);
          if (paramInt1 < 0) {
            break;
          }
          localk.r = localcj;
          paramInt1 = localck.b(paramArrayOfByte, i2, this.b - i2 - 1);
          if (paramInt1 < 0) {
            break;
          }
          localk.s = localck;
          b(paramArrayOfByte, i2, this.b - i2 - 1);
          paramInt1 = i1;
          break;
          paramInt1 = localf.b(paramArrayOfByte, i2, this.b - i2 - 1);
          if (paramInt1 < 0) {
            break;
          }
          localk.m = localf;
          paramInt1 = localad.b(paramArrayOfByte, i2, this.b - i2 - 1);
          if (paramInt1 < 0) {
            break;
          }
          localk.p = localad;
          paramInt1 = localbu.b(paramArrayOfByte, i2, this.b - i2 - 1);
          if (paramInt1 < 0) {
            break;
          }
          localk.z = localbu.f();
          localk.A = localbu.g();
          paramInt1 = localbv.b(paramArrayOfByte, i2, this.b - i2 - 1);
          if (paramInt1 < 0) {
            break;
          }
          localk.B = localbv.f();
          paramInt1 = 0;
          break;
          paramArrayOfByte = Integer.valueOf(paramInt1);
          break label818;
          break label933;
        }
      }
      label3464:
      label3474:
      label5012:
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
    if ((y.z == null) || (y.z.length <= 0))
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
        if (y.z.length > localObject.length) {
          System.arraycopy(y.z, 0, localObject, 0, localObject.length);
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
          System.arraycopy(y.z, 0, localObject, 0, y.z.length);
          i1 = y.z.length;
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
      y.b(this.w.h).l = arrayOfByte;
      return localObject;
    }
  }
  
  public Socket d()
  {
    return this.w.aa;
  }
  
  public int e()
  {
    util.LOGI(getClass().getName() + ":snd_rcv_req_tcp ...", "" + this.w.f);
    byte[] arrayOfByte = c();
    int i1 = 0;
    long l1 = 0L;
    Object localObject1 = d();
    boolean bool2 = false;
    int i4 = 0;
    int i2 = 0;
    int i3 = 0;
    boolean bool1 = false;
    for (;;)
    {
      Object localObject4;
      label215:
      Object localObject6;
      label276:
      boolean bool3;
      if (i1 < 6)
      {
        if (i1 != 0) {
          util.chg_retry_type(y.r);
        }
        bool1 = util.is_wap_retry(y.r);
        this.p = null;
        if ((i1 != 0) && (this.s != 2066))
        {
          localObject4 = new report_t3();
          ((report_t3)localObject4)._cmd = this.s;
          ((report_t3)localObject4)._sub = this.t;
          ((report_t3)localObject4)._rst2 = i2;
          ((report_t3)localObject4)._used = ((int)(System.currentTimeMillis() - l1));
          ((report_t3)localObject4)._try = i1;
          ((report_t3)localObject4)._host = C;
          if (((report_t3)localObject4)._host == null) {
            ((report_t3)localObject4)._host = "";
          }
          if (this.p == null)
          {
            ((report_t3)localObject4)._ip = "";
            ((report_t3)localObject4)._port = c(bool1);
            ((report_t3)localObject4)._conn = i4;
            ((report_t3)localObject4)._net = y.B;
            ((report_t3)localObject4)._str = "";
            ((report_t3)localObject4)._slen = 0;
            ((report_t3)localObject4)._rlen = 0;
            if (!bool1) {
              break label885;
            }
            if (!bool2) {
              break label876;
            }
            ((report_t3)localObject4)._wap = 2;
            y.ae.add_t3((report_t3)localObject4);
          }
        }
        else
        {
          l1 = System.currentTimeMillis();
          if (!bool1) {
            break label1305;
          }
          util.LOGI("try http connect " + i1 + " ...", "" + this.w.f);
          localObject6 = a(i1, bool1);
          localObject4 = null;
          i2 = -1;
          bool3 = bool2;
        }
      }
      try
      {
        bool2 = util.is_wap_proxy_retry(y.r);
        if (bool2) {
          bool3 = bool2;
        }
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject4 = util.get_proxy_ip();
              bool3 = bool2;
              i2 = util.get_proxy_port();
              if (localObject4 != null)
              {
                bool3 = bool2;
                if ((((String)localObject4).length() > 0) && (i2 != -1)) {
                  break label2663;
                }
              }
              bool3 = false;
              util.LOGI("proxy_ip=" + (String)localObject4 + ",proxy_port=" + i2 + ",set is_wap_proxy_retry=" + false, "" + this.w.f);
              bool2 = false;
              if (bool2) {
                bool3 = bool2;
              }
              for (localObject4 = new URL("http://" + (String)localObject4 + ":" + i2 + "/cgi-bin/wlogin_proxy_login");; localObject4 = new URL("http://" + (String)localObject6 + "/cgi-bin/wlogin_proxy_login"))
              {
                bool3 = bool2;
                util.LOGI("try http proxy=" + bool2 + " connect to " + localObject4, "" + this.w.f);
                bool3 = bool2;
                localObject4 = (HttpURLConnection)((URL)localObject4).openConnection();
                bool3 = bool2;
                ((HttpURLConnection)localObject4).setRequestMethod("POST");
                if (bool2)
                {
                  bool3 = bool2;
                  ((HttpURLConnection)localObject4).setRequestProperty("X-Online-Host", (String)localObject6);
                }
                bool3 = bool2;
                ((HttpURLConnection)localObject4).setRequestProperty("Content-Type", "application/octet-stream");
                bool3 = bool2;
                ((HttpURLConnection)localObject4).setRequestProperty("Content-Disposition", "attachment; filename=micromsgresp.dat");
                bool3 = bool2;
                ((HttpURLConnection)localObject4).setRequestProperty("Content-Length", String.valueOf(arrayOfByte.length));
                bool3 = bool2;
                ((HttpURLConnection)localObject4).setConnectTimeout(this.w.l);
                bool3 = bool2;
                ((HttpURLConnection)localObject4).setReadTimeout(this.w.l);
                bool3 = bool2;
                ((HttpURLConnection)localObject4).setDoOutput(true);
                bool3 = bool2;
                ((HttpURLConnection)localObject4).setDoInput(true);
                bool3 = bool2;
                util.LOGI("http request connect ...", "" + this.w.f);
                bool3 = bool2;
                if (m.a((HttpURLConnection)localObject4, this.w.l)) {
                  break label937;
                }
                bool3 = bool2;
                util.LOGI("http request connect failed", "" + this.w.f);
                i1 += 1;
                i2 = -1000;
                break;
                ((report_t3)localObject4)._ip = this.p.getAddress().getHostAddress();
                break label215;
                label876:
                ((report_t3)localObject4)._wap = 1;
                break label276;
                label885:
                ((report_t3)localObject4)._wap = 0;
                break label276;
                bool3 = bool2;
              }
              label937:
              bool3 = bool2;
              util.LOGI("http request write ...", "" + this.w.f);
              bool3 = bool2;
              localObject6 = ((HttpURLConnection)localObject4).getOutputStream();
              bool3 = bool2;
              ((OutputStream)localObject6).write(arrayOfByte, 0, arrayOfByte.length);
              bool3 = bool2;
              ((OutputStream)localObject6).flush();
              bool3 = bool2;
              i2 = ((HttpURLConnection)localObject4).getResponseCode();
              bool3 = bool2;
              util.LOGI("http request response code=" + i2, "" + this.w.f);
              if (200 != i2)
              {
                bool3 = bool2;
                util.LOGD("use http ret=" + i2 + " msg=" + ((HttpURLConnection)localObject4).getResponseMessage());
                i1 += 1;
                i2 = -1000;
                break;
              }
              bool3 = bool2;
              localObject4 = ((HttpURLConnection)localObject4).getInputStream();
              i2 = i3;
              try
              {
                util.LOGI("recv data from server ...", "" + this.w.f);
                i5 = 0;
                i6 = 0;
                i2 = i3;
                if (i6 < this.e + 1)
                {
                  i2 = i3;
                  i5 = ((InputStream)localObject4).read(this.r, i6, this.e + 1 - i6);
                  if (i5 >= 0) {}
                }
                else
                {
                  if (i5 >= 0) {
                    break label1913;
                  }
                  i6 = -1000;
                  i5 = i1 + 1;
                  localObject4 = localObject1;
                  if (!bool1)
                  {
                    localObject4 = localObject1;
                    i1 = i5;
                    i2 = i3;
                  }
                }
              }
              catch (Exception localException3)
              {
                try
                {
                  ((Socket)localObject1).close();
                  localObject4 = localObject1;
                  i1 = i5;
                  i2 = i3;
                  this.p = null;
                  localObject4 = null;
                  localObject1 = null;
                  i1 = i5;
                  i2 = i3;
                  a(null);
                  localObject4 = localObject1;
                  i1 = i5;
                  localObject1 = localObject4;
                  i2 = i6;
                  break;
                  label1305:
                  util.LOGI("try bin connect " + i1 + " ...", "" + this.w.f);
                  util.LOGD("use bin connect type");
                  if (localObject1 == null)
                  {
                    localObject4 = "";
                    i2 = 1;
                    i4 = 1;
                    if (this.p == null)
                    {
                      localObject4 = a(i1, bool1);
                      util.LOGI("DNS for " + (String)localObject4 + " request ...", "" + this.w.f);
                    }
                  }
                }
                catch (Exception localException3)
                {
                  try
                  {
                    int i5;
                    label1481:
                    Object localObject2;
                    for (;;)
                    {
                      for (;;)
                      {
                        this.q = c(bool1);
                        this.p = a.a((String)localObject4, this.q, this.w.l);
                        if (this.p == null)
                        {
                          util.LOGI("DNS for " + (String)localObject4 + " request failed", "" + this.w.f);
                          i1 += 1;
                          this.p = null;
                          a(null);
                          i2 = -1007;
                          localObject1 = null;
                          break;
                        }
                        util.LOGI("DNS for " + (String)localObject4 + "(" + this.p.toString() + ") request OK", "" + this.w.f);
                        i4 = i2;
                        if (localObject1 != null) {
                          break label2660;
                        }
                        try
                        {
                          util.LOGI("tcp connect to " + this.p + " request ...", "" + this.w.f);
                          localObject1 = new Socket();
                          a((Socket)localObject1);
                          ((Socket)localObject1).connect(this.p, this.w.l);
                          ((Socket)localObject1).setSoTimeout(this.w.l);
                          ((Socket)localObject1).setReceiveBufferSize(this.r.length);
                          util.LOGI("tcp connect to " + this.p + " OK", "" + this.w.f);
                          util.LOGI("tcp request write ...", "" + this.w.f);
                          localObject4 = ((Socket)localObject1).getOutputStream();
                          ((OutputStream)localObject4).write(arrayOfByte, 0, arrayOfByte.length);
                          ((OutputStream)localObject4).flush();
                          localObject4 = ((Socket)localObject1).getInputStream();
                        }
                        catch (Exception localException1)
                        {
                          i1 += 1;
                          this.p = null;
                          a(null);
                          i2 = -1000;
                          localObject2 = null;
                        }
                      }
                      break;
                      i6 += i5;
                    }
                    label1913:
                    i2 = i3;
                    i3 = b(this.r);
                    i2 = i3;
                    int i6 = this.e;
                    if (i3 <= i6 + 1)
                    {
                      i6 = -1000;
                      i5 = i1 + 1;
                      localObject4 = localObject2;
                      if (!bool1)
                      {
                        localObject4 = localObject2;
                        i1 = i5;
                        i2 = i3;
                        ((Socket)localObject2).close();
                        localObject4 = localObject2;
                        i1 = i5;
                        i2 = i3;
                        this.p = null;
                        localObject4 = null;
                        localObject2 = null;
                        i1 = i5;
                        i2 = i3;
                        a(null);
                        localObject4 = localObject2;
                      }
                      i1 = i5;
                      localObject2 = localObject4;
                      i2 = i6;
                      break;
                    }
                    i2 = i3;
                    i6 = this.r.length;
                    if (i3 >= i6)
                    {
                      i6 = -1000;
                      i5 = i1 + 1;
                      localObject4 = localObject2;
                      if (!bool1)
                      {
                        localObject4 = localObject2;
                        i1 = i5;
                        i2 = i3;
                        ((Socket)localObject2).close();
                        localObject4 = localObject2;
                        i1 = i5;
                        i2 = i3;
                        this.p = null;
                        localObject4 = null;
                        localObject2 = null;
                        i1 = i5;
                        i2 = i3;
                        a(null);
                        localObject4 = localObject2;
                      }
                      i1 = i5;
                      localObject2 = localObject4;
                      i2 = i6;
                      break;
                    }
                    i2 = i3;
                    int i7 = this.e + 1;
                    i6 = i3 - i7;
                    for (;;)
                    {
                      if (i6 > 0)
                      {
                        i2 = i3;
                        i5 = ((InputStream)localObject4).read(this.r, i7, i6);
                        if (i5 != -1) {}
                      }
                      else
                      {
                        if (i5 != -1) {
                          break label2262;
                        }
                        i6 = -1000;
                        i5 = i1 + 1;
                        localObject4 = localObject2;
                        if (!bool1)
                        {
                          localObject4 = localObject2;
                          i1 = i5;
                          i2 = i3;
                          ((Socket)localObject2).close();
                          localObject4 = localObject2;
                          i1 = i5;
                          i2 = i3;
                          this.p = null;
                          localObject4 = null;
                          localObject2 = null;
                          i1 = i5;
                          i2 = i3;
                          a(null);
                          localObject4 = localObject2;
                        }
                        i1 = i5;
                        localObject2 = localObject4;
                        i2 = i6;
                        break;
                      }
                      i7 += i5;
                      i6 -= i5;
                    }
                    label2262:
                    i2 = i4;
                    if (i1 >= 6)
                    {
                      i4 = -1000;
                      label2276:
                      if (i4 == 0) {
                        b(this.r, i3);
                      }
                      if ((i4 == 0) && (this.s != 2066))
                      {
                        localObject2 = new report_t3();
                        ((report_t3)localObject2)._cmd = this.s;
                        ((report_t3)localObject2)._sub = this.t;
                        ((report_t3)localObject2)._rst2 = i4;
                        ((report_t3)localObject2)._used = ((int)(System.currentTimeMillis() - l1));
                        ((report_t3)localObject2)._try = i1;
                        ((report_t3)localObject2)._host = C;
                        if (((report_t3)localObject2)._host == null) {
                          ((report_t3)localObject2)._host = "";
                        }
                        if (this.p != null) {
                          break label2594;
                        }
                        ((report_t3)localObject2)._ip = "";
                        label2394:
                        ((report_t3)localObject2)._port = this.q;
                        ((report_t3)localObject2)._conn = i2;
                        ((report_t3)localObject2)._net = y.B;
                        ((report_t3)localObject2)._str = "";
                        ((report_t3)localObject2)._slen = arrayOfByte.length;
                        ((report_t3)localObject2)._rlen = i3;
                        if (!bool1) {
                          break label2621;
                        }
                        if (!bool2) {
                          break label2612;
                        }
                        ((report_t3)localObject2)._wap = 2;
                        label2454:
                        y.ae.add_t3((report_t3)localObject2);
                      }
                      util.LOGI(getClass().getName() + ":snd_rcv_req_tcp ret=" + i4, "" + this.w.f);
                      return i4;
                      localException4 = localException4;
                      i3 = i1;
                      i1 = i2;
                      i2 = i3;
                    }
                    for (;;)
                    {
                      Object localObject5;
                      for (;;)
                      {
                        localObject5 = localObject2;
                        if (!bool1) {}
                        try
                        {
                          if (((Socket)localObject2).isConnected()) {
                            ((Socket)localObject2).close();
                          }
                          label2554:
                          this.p = null;
                          localObject5 = null;
                          a(null);
                          i5 = -1000;
                          i3 = i1;
                          i1 = i2 + 1;
                          localObject2 = localObject5;
                          i2 = i5;
                          break;
                          i4 = 0;
                          break label2276;
                          label2594:
                          ((report_t3)localObject2)._ip = this.p.getAddress().getHostAddress();
                          break label2394;
                          label2612:
                          ((report_t3)localObject2)._wap = 1;
                          break label2454;
                          label2621:
                          ((report_t3)localObject2)._wap = 0;
                        }
                        catch (Exception localException2)
                        {
                          break label2554;
                        }
                      }
                      localException3 = localException3;
                      i3 = i2;
                      Object localObject3 = localObject5;
                      i2 = i1;
                      i1 = i3;
                    }
                  }
                  catch (Exception localException7)
                  {
                    break label1481;
                  }
                }
              }
            }
            continue;
          }
          catch (Exception localException5) {}
          label2660:
          label2663:
          continue;
          continue;
          i2 = i4;
        }
      }
      catch (Exception localException6)
      {
        i2 = -1000;
        i1 += 1;
        bool2 = bool3;
      }
    }
  }
  
  public int f()
  {
    return y.b(this.w.h).i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.o
 * JD-Core Version:    0.7.0.1
 */