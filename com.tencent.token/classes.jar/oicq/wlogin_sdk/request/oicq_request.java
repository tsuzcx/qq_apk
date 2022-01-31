package oicq.wlogin_sdk.request;

import android.content.Context;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.report_t3;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t102;
import oicq.wlogin_sdk.tlv_type.tlv_t103;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t10a;
import oicq.wlogin_sdk.tlv_type.tlv_t10b;
import oicq.wlogin_sdk.tlv_type.tlv_t10c;
import oicq.wlogin_sdk.tlv_type.tlv_t10d;
import oicq.wlogin_sdk.tlv_type.tlv_t10e;
import oicq.wlogin_sdk.tlv_type.tlv_t113;
import oicq.wlogin_sdk.tlv_type.tlv_t114;
import oicq.wlogin_sdk.tlv_type.tlv_t118;
import oicq.wlogin_sdk.tlv_type.tlv_t119;
import oicq.wlogin_sdk.tlv_type.tlv_t11a;
import oicq.wlogin_sdk.tlv_type.tlv_t11c;
import oicq.wlogin_sdk.tlv_type.tlv_t11d;
import oicq.wlogin_sdk.tlv_type.tlv_t11f;
import oicq.wlogin_sdk.tlv_type.tlv_t120;
import oicq.wlogin_sdk.tlv_type.tlv_t121;
import oicq.wlogin_sdk.tlv_type.tlv_t125;
import oicq.wlogin_sdk.tlv_type.tlv_t126;
import oicq.wlogin_sdk.tlv_type.tlv_t130;
import oicq.wlogin_sdk.tlv_type.tlv_t132;
import oicq.wlogin_sdk.tlv_type.tlv_t136;
import oicq.wlogin_sdk.tlv_type.tlv_t138;
import oicq.wlogin_sdk.tlv_type.tlv_t143;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t146;
import oicq.wlogin_sdk.tlv_type.tlv_t149;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tlv_type.tlv_t161;
import oicq.wlogin_sdk.tlv_type.tlv_t164;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t167;
import oicq.wlogin_sdk.tlv_type.tlv_t169;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t16d;
import oicq.wlogin_sdk.tlv_type.tlv_t171;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tlv_type.tlv_t173;
import oicq.wlogin_sdk.tlv_type.tlv_t174;
import oicq.wlogin_sdk.tlv_type.tlv_t178;
import oicq.wlogin_sdk.tlv_type.tlv_t179;
import oicq.wlogin_sdk.tlv_type.tlv_t17d;
import oicq.wlogin_sdk.tlv_type.tlv_t17e;
import oicq.wlogin_sdk.tlv_type.tlv_t182;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import oicq.wlogin_sdk.tlv_type.tlv_t186;
import oicq.wlogin_sdk.tlv_type.tlv_t192;
import oicq.wlogin_sdk.tlv_type.tlv_t196;
import oicq.wlogin_sdk.tlv_type.tlv_t199;
import oicq.wlogin_sdk.tlv_type.tlv_t200;
import oicq.wlogin_sdk.tlv_type.tlv_t305;
import oicq.wlogin_sdk.tlv_type.tlv_t402;
import oicq.wlogin_sdk.tlv_type.tlv_t403;
import oicq.wlogin_sdk.tlv_type.tlv_t508;
import oicq.wlogin_sdk.tools.EcdhCrypt;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.InternationMsg;
import oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class oicq_request
{
  static String[] C = { "111.30.137.20", "123.126.122.126", "123.151.176.23", "120.198.203.150", "14.17.41.156", "163.177.71.159", "101.227.130.77", "117.135.172.187", "140.207.69.123" };
  static String[] D = { "180.163.15.182", "183.192.200.28", "223.167.105.36", "183.61.56.18", "183.232.119.221", "163.177.86.123", "123.151.92.19", "125.39.52.120", "123.126.121.172", "117.135.169.107" };
  static int F = 0;
  static String G = "";
  static String H = "";
  protected byte[] A = new byte[0];
  protected byte[] B = new byte[0];
  int E = 0;
  public Context a;
  int b = 4096;
  int c = 0;
  int d = 27;
  int e = 0;
  public int f = 15;
  protected int g = 0;
  protected byte[] h = new byte[this.b];
  protected int i = 8001;
  protected int j = 0;
  protected int k = 3;
  protected int l = 0;
  protected int m = 0;
  protected int n = 2;
  protected int o = 0;
  protected int p = 0;
  InetSocketAddress q = null;
  int r = 0;
  byte[] s = new byte[6144];
  protected int t = 0;
  protected int u = 0;
  protected String v = "";
  byte w;
  public t x;
  protected oicq_request.EncryptionMethod y = oicq_request.EncryptionMethod.EM_ECDH;
  protected boolean z = false;
  
  private void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (!this.z) {}
    for (int i1 = 7;; i1 = 135)
    {
      a(paramInt1, paramInt2, paramLong, i1, paramInt3, paramInt4, paramInt5, paramInt6);
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int i1 = this.j + 1;
    this.j = i1;
    this.c = 0;
    util.int8_to_buf(this.h, this.c, 2);
    this.c += 1;
    util.int16_to_buf(this.h, this.c, this.d + 2 + paramInt7);
    this.c += 2;
    util.int16_to_buf(this.h, this.c, paramInt1);
    this.c += 2;
    util.int16_to_buf(this.h, this.c, paramInt2);
    this.c += 2;
    util.int16_to_buf(this.h, this.c, i1);
    this.c += 2;
    util.int32_to_buf(this.h, this.c, (int)paramLong);
    this.c += 4;
    util.int8_to_buf(this.h, this.c, 3);
    this.c += 1;
    util.int8_to_buf(this.h, this.c, paramInt3);
    this.c += 1;
    util.int8_to_buf(this.h, this.c, paramInt4);
    this.c += 1;
    util.int32_to_buf(this.h, this.c, 2);
    this.c += 4;
    util.int32_to_buf(this.h, this.c, paramInt5);
    this.c += 4;
    util.int32_to_buf(this.h, this.c, paramInt6);
    this.c += 4;
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte)
  {
    a(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramInt5, paramArrayOfByte.length);
    a(paramArrayOfByte, paramArrayOfByte.length);
    a();
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    report_t3 localreport_t3 = new report_t3();
    localreport_t3._cmd = this.t;
    localreport_t3._sub = this.u;
    localreport_t3._rst2 = paramInt1;
    localreport_t3._used = ((int)(System.currentTimeMillis() - paramLong));
    localreport_t3._try = paramInt3;
    localreport_t3._host = H;
    if (localreport_t3._host == null) {
      localreport_t3._host = "";
    }
    if (this.q == null)
    {
      localreport_t3._ip = "";
      localreport_t3._port = c(paramBoolean1);
      localreport_t3._conn = paramInt2;
      localreport_t3._net = t.D;
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
      t.an.add_t3(localreport_t3);
      return;
      localreport_t3._ip = this.q.getAddress().getHostAddress();
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
    F = paramInt;
    G = paramString;
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a(paramInt1, paramInt2, paramLong, 69, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte)
  {
    b(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramInt5, paramArrayOfByte.length);
    a(paramArrayOfByte, paramArrayOfByte.length);
    a();
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
    t.b(this.x.h)._last_flowid = paramInt;
    return paramInt;
  }
  
  public int a(String paramString, boolean paramBoolean, WUserSigInfo paramWUserSigInfo)
  {
    if (this.x.e()) {}
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
  
  public int a(tlv_t161 paramtlv_t161)
  {
    tlv_t173 localtlv_t173 = new tlv_t173();
    tlv_t172 localtlv_t172 = new tlv_t172();
    paramtlv_t161 = paramtlv_t161.get_data();
    int i1 = paramtlv_t161.length;
    if (localtlv_t173.get_tlv(paramtlv_t161, 2, i1) > 0) {
      a(localtlv_t173);
    }
    if (localtlv_t172.get_tlv(paramtlv_t161, 2, i1) > 0)
    {
      this.x.m = 1;
      this.x.r = localtlv_t172.get_data();
      util.LOGI("get rollback sig", "");
    }
    return 0;
  }
  
  public int a(tlv_t173 paramtlv_t173)
  {
    paramtlv_t173 = paramtlv_t173.get_data();
    int i3;
    int i2;
    int i1;
    if ((paramtlv_t173 != null) && (paramtlv_t173.length > 2))
    {
      i3 = util.buf_to_int8(paramtlv_t173, 1);
      i2 = 2;
      i1 = 0;
    }
    for (;;)
    {
      if ((i1 >= i3) || (paramtlv_t173.length < i2 + 1)) {}
      int i4;
      byte[] arrayOfByte;
      do
      {
        do
        {
          do
          {
            return 0;
            i4 = util.buf_to_int8(paramtlv_t173, i2);
            i5 = i2 + 1;
          } while (paramtlv_t173.length < i5 + 2);
          i2 = util.buf_to_int16(paramtlv_t173, i5);
          i5 += 2;
        } while (paramtlv_t173.length < i5 + i2);
        arrayOfByte = new byte[i2];
        System.arraycopy(paramtlv_t173, i5, arrayOfByte, 0, i2);
        i2 = i5 + i2;
      } while (paramtlv_t173.length < i2 + 2);
      int i5 = util.buf_to_int16(paramtlv_t173, i2);
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
    this.g = paramArrayOfByte1.length;
    if (paramArrayOfByte1.length + this.f + 2 > this.b)
    {
      this.b = (paramArrayOfByte1.length + this.f + 2);
      paramArrayOfByte2 = new byte[this.b];
      System.arraycopy(this.h, 0, paramArrayOfByte2, 0, this.c);
      this.h = paramArrayOfByte2;
    }
    this.c = 0;
    System.arraycopy(paramArrayOfByte1, 0, this.h, paramInt1, paramArrayOfByte1.length);
    paramInt1 = this.c;
    paramInt2 = this.f;
    this.c = (paramArrayOfByte1.length + (paramInt2 + 2) + paramInt1);
    return 0;
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    String str1 = "";
    paramInt /= 2;
    String str2;
    if ((F != 0) && (G != null) && (G.length() > 0)) {
      str2 = G;
    }
    for (;;)
    {
      H = str2;
      return str2;
      if (paramInt < 1)
      {
        if (paramBoolean) {
          if (t.D == 1) {
            str1 = new String(util.get_wap_server_host1(t.t));
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
          if (t.D == 2)
          {
            str1 = new String(util.get_wap_server_host2(t.t));
            continue;
            if (t.D == 1) {
              str1 = new String(util.get_server_host1(t.t));
            } else if (t.D == 2) {
              str1 = new String(util.get_server_host2(t.t));
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
      return C[((int)(java.lang.Math.random() * 2147483647.0D) % C.length)];
    }
    return D[((int)(java.lang.Math.random() * 2147483647.0D) % D.length)];
  }
  
  public void a()
  {
    util.int8_to_buf(this.h, this.c, 3);
    this.c += 1;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt3 = this.j + 1;
    this.j = paramInt3;
    this.c = 0;
    util.int8_to_buf(this.h, this.c, 2);
    this.c += 1;
    util.int16_to_buf(this.h, this.c, this.d + 2 + paramInt8);
    this.c += 2;
    util.int16_to_buf(this.h, this.c, paramInt1);
    this.c += 2;
    util.int16_to_buf(this.h, this.c, paramInt2);
    this.c += 2;
    util.int16_to_buf(this.h, this.c, paramInt3);
    this.c += 2;
    util.int32_to_buf(this.h, this.c, (int)paramLong);
    this.c += 4;
    util.int8_to_buf(this.h, this.c, 3);
    this.c += 1;
    util.int8_to_buf(this.h, this.c, 7);
    this.c += 1;
    util.int8_to_buf(this.h, this.c, paramInt4);
    this.c += 1;
    util.int32_to_buf(this.h, this.c, paramInt5);
    this.c += 4;
    util.int32_to_buf(this.h, this.c, paramInt6);
    this.c += 4;
    util.int32_to_buf(this.h, this.c, paramInt7);
    this.c += 4;
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
      if (t.D == 1) {
        util.set_server_host1(t.t, paramArrayOfByte);
      }
    }
    for (;;)
    {
      util.LOGI("net type:" + t.D + " type:" + paramInt1 + " host:" + new String(paramArrayOfByte) + " port:" + paramInt2, "" + this.x.f);
      return;
      if (t.D == 2)
      {
        util.set_server_host2(t.t, paramArrayOfByte);
        continue;
        if (paramInt1 == 2) {
          if (t.D == 1) {
            util.set_wap_server_host1(t.t, paramArrayOfByte);
          } else if (t.D == 2) {
            util.set_wap_server_host2(t.t, paramArrayOfByte);
          }
        }
      }
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    a(this.i, this.t, paramLong, this.m, t.w, this.p, paramArrayOfByte);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte, oicq_request.EncryptionMethod paramEncryptionMethod)
  {
    if (paramEncryptionMethod == oicq_request.EncryptionMethod.EM_ST)
    {
      b(paramLong, paramArrayOfByte);
      return;
    }
    if (paramEncryptionMethod == oicq_request.EncryptionMethod.EM_ECDH)
    {
      a(paramLong, paramArrayOfByte);
      return;
    }
    util.LOGI("getRequestEncrptedPackage unknown encryption method " + paramEncryptionMethod, "" + paramLong);
  }
  
  public void a(Socket paramSocket)
  {
    this.x.aj = paramSocket;
  }
  
  public void a(WloginSigInfo paramWloginSigInfo)
  {
    if (true == paramWloginSigInfo.isWtSessionTicketExpired()) {}
    while ((paramWloginSigInfo.wtSessionTicket == null) || (paramWloginSigInfo.wtSessionTicketKey == null)) {
      return;
    }
    this.A = ((byte[])paramWloginSigInfo.wtSessionTicket.clone());
    this.B = ((byte[])paramWloginSigInfo.wtSessionTicketKey.clone());
  }
  
  public void a(tlv_t149 paramtlv_t149)
  {
    try
    {
      ErrMsg localErrMsg = new ErrMsg();
      if (paramtlv_t149 != null)
      {
        localErrMsg.setType(paramtlv_t149.get_type());
        localErrMsg.setTitle(new String(paramtlv_t149.get_title()));
        localErrMsg.setMessage(new String(paramtlv_t149.get_content()));
        localErrMsg.setOtherinfo(new String(paramtlv_t149.get_otherinfo()));
        new e(t.t, localErrMsg).start();
      }
      return;
    }
    catch (Exception paramtlv_t149) {}
  }
  
  public void a(ErrMsg paramErrMsg)
  {
    async_context localasync_context = t.b(this.x.h);
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
    if (this.c + paramInt + 1 > this.b)
    {
      this.b = (this.c + paramInt + 1 + 128);
      byte[] arrayOfByte = new byte[this.b];
      System.arraycopy(this.h, 0, arrayOfByte, 0, this.c);
      this.h = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.h, this.c, paramInt);
    this.c += paramInt;
  }
  
  public byte[] a(tlv_t169 paramtlv_t169)
  {
    Object localObject4 = new tlv_t106();
    Object localObject3 = new tlv_t10c();
    Object localObject2 = new tlv_t16a();
    Object localObject1 = new tlv_t145();
    paramtlv_t169 = paramtlv_t169.get_data();
    int i1 = paramtlv_t169.length;
    if (((tlv_t106)localObject4).get_tlv(paramtlv_t169, 2, i1) < 0) {}
    while ((((tlv_t10c)localObject3).get_tlv(paramtlv_t169, 2, i1) < 0) || (((tlv_t16a)localObject2).get_tlv(paramtlv_t169, 2, i1) < 0)) {
      return null;
    }
    paramtlv_t169 = ((tlv_t106)localObject4).get_buf();
    localObject3 = ((tlv_t10c)localObject3).get_buf();
    localObject2 = ((tlv_t16a)localObject2).get_buf();
    localObject1 = ((tlv_t145)localObject1).get_tlv_145(t.A);
    localObject4 = new byte[paramtlv_t169.length + 3 + localObject3.length + localObject2.length + localObject1.length];
    localObject4[0] = 64;
    util.int16_to_buf((byte[])localObject4, 1, 4);
    System.arraycopy(paramtlv_t169, 0, localObject4, 3, paramtlv_t169.length);
    i1 = paramtlv_t169.length + 3;
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
    if (this.x.m == 0) {
      return a(paramArrayOfByte, this.x.c, this.x.n, this.x.p);
    }
    return a(paramArrayOfByte, this.x.c);
  }
  
  byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.int16_to_buf(arrayOfByte, 0, paramInt1);
    util.int16_to_buf(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  protected byte[] a(byte[] paramArrayOfByte1, oicq_request.EncryptionMethod paramEncryptionMethod, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (oicq_request.EncryptionMethod.EM_ST == paramEncryptionMethod) {
      return b(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
    }
    if (oicq_request.EncryptionMethod.EM_ECDH == paramEncryptionMethod) {
      return a(paramArrayOfByte1);
    }
    util.LOGI("encryptBody unknown encryption method " + paramEncryptionMethod, "");
    return null;
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return new byte[0];
    }
    if (this.x.m == 2) {}
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
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte3);
    paramArrayOfByte3 = new byte[paramArrayOfByte2.length + 2 + paramArrayOfByte1.length];
    util.int16_to_buf(paramArrayOfByte3, 0, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, 2, paramArrayOfByte2.length);
    int i1 = paramArrayOfByte2.length + 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, i1, paramArrayOfByte1.length);
    i1 = paramArrayOfByte1.length;
    return paramArrayOfByte3;
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
    int i2 = -1009;
    int i1 = this.c;
    if (i1 <= this.f + 2) {
      return i2;
    }
    this.g = (i1 - this.f - 2);
    i1 = util.buf_to_int16(this.h, 13);
    util.LOGI("enrypt method " + this.y + " rsp flag " + i1, "");
    if ((this.y == oicq_request.EncryptionMethod.EM_ECDH) && (i1 == 0)) {
      if (this.x.m == 0)
      {
        i2 = a(this.h, this.f + 1, this.g, this.x.p);
        i1 = i2;
        if (i2 < 0)
        {
          util.LOGI("use ecdh decrypt_body failed", "");
          i2 = a(this.h, this.f + 1, this.g, this.x.c);
          i1 = i2;
          if (i2 < 0)
          {
            util.LOGI("use kc decrypt_body failed", "");
            i1 = i2;
          }
        }
      }
    }
    for (;;)
    {
      i2 = i1;
      if (i1 < 0) {
        break;
      }
      return d(this.h, this.f + 1, this.g);
      i2 = a(this.h, this.f + 1, this.g, this.x.c);
      i1 = i2;
      if (i2 < 0)
      {
        util.LOGI("use kc decrypt_body failed", "");
        i1 = i2;
        continue;
        Object localObject;
        if ((this.y == oicq_request.EncryptionMethod.EM_ST) && (3 == i1))
        {
          i2 = a(this.h, this.f + 1, this.g, this.B);
          i1 = i2;
          if (i2 < 0)
          {
            t.an.attr_api(2494911);
            localObject = t.b(this.x.h);
            if (localObject != null) {
              this.x.c(this.x.f, ((async_context)localObject)._sappid);
            }
            util.LOGI("use session key decrypt_body failed", "");
            i1 = -1025;
          }
        }
        else if ((this.y == oicq_request.EncryptionMethod.EM_ECDH) && (true == this.z) && (4 == i1))
        {
          localObject = cryptor.decrypt(this.h, this.f + 1, this.g, this.x.p);
          if (localObject == null)
          {
            util.LOGI("decrypted outer body failed", "" + this.x.f);
            return -1002;
          }
          i1 = util.buf_to_int16((byte[])localObject, 0);
          if (i1 > localObject.length - 2)
          {
            util.LOGI("peer public key len wrong " + i1, "" + this.x.f);
            return -1009;
          }
          byte[] arrayOfByte = new byte[i1];
          System.arraycopy(localObject, 2, arrayOfByte, 0, i1);
          arrayOfByte = new EcdhCrypt(this.a).calShareKeyMd5ByPeerPublicKey(arrayOfByte);
          if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
            return -1002;
          }
          localObject = cryptor.decrypt((byte[])localObject, i1 + 2, localObject.length - 2 - i1, arrayOfByte);
          if (localObject == null)
          {
            t.an.attr_api(2461266);
            util.LOGI("use share key md5 decrypt failed", "" + this.x.f);
            return -1002;
          }
          if (this.h.length < this.f + 2 + localObject.length)
          {
            this.b = (this.f + 2 + localObject.length);
            arrayOfByte = new byte[this.b];
            System.arraycopy(this.h, 0, arrayOfByte, 0, this.f + 1);
            this.h = arrayOfByte;
          }
          System.arraycopy(localObject, 0, this.h, this.f + 1, localObject.length);
          i1 = this.c;
          i2 = this.f;
          this.c = (localObject.length + (i2 + 2) + i1);
          i1 = 0;
        }
        else
        {
          util.LOGI("unknown encryption method " + this.y, "");
          i1 = -1024;
        }
      }
    }
  }
  
  /* Error */
  public int b(String paramString, boolean paramBoolean, WUserSigInfo paramWUserSigInfo)
  {
    // Byte code:
    //   0: new 416	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 633	java/lang/Object:getClass	()Ljava/lang/Class;
    //   11: invokevirtual 638	java/lang/Class:getName	()Ljava/lang/String;
    //   14: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 640
    //   20: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: new 416	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   33: ldc 97
    //   35: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   42: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   45: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   58: getfield 641	oicq/wlogin_sdk/request/t:l	I
    //   61: istore 4
    //   63: aload_0
    //   64: invokevirtual 643	oicq/wlogin_sdk/request/oicq_request:c	()[B
    //   67: astore 7
    //   69: invokestatic 205	java/lang/System:currentTimeMillis	()J
    //   72: lstore 5
    //   74: new 416	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 645
    //   84: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 647
    //   94: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: getfield 147	oicq/wlogin_sdk/request/oicq_request:v	Ljava/lang/String;
    //   101: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 649
    //   107: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 4
    //   112: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc_w 651
    //   118: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_2
    //   122: invokevirtual 654	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   125: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: new 416	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   135: ldc 97
    //   137: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   144: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   147: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: new 656	oicq/wlogin_sdk/request/WtloginMsfListener
    //   159: dup
    //   160: aload_1
    //   161: aload_0
    //   162: getfield 147	oicq/wlogin_sdk/request/oicq_request:v	Ljava/lang/String;
    //   165: aload 7
    //   167: iload 4
    //   169: iload_2
    //   170: aload_3
    //   171: invokespecial 659	oicq/wlogin_sdk/request/WtloginMsfListener:<init>	(Ljava/lang/String;Ljava/lang/String;[BIZLoicq/wlogin_sdk/request/WUserSigInfo;)V
    //   174: astore_3
    //   175: new 661	java/lang/Thread
    //   178: dup
    //   179: aload_3
    //   180: invokespecial 664	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 665	java/lang/Thread:start	()V
    //   188: aload_1
    //   189: iload 4
    //   191: i2l
    //   192: invokevirtual 669	java/lang/Thread:join	(J)V
    //   195: aload_3
    //   196: invokevirtual 672	oicq/wlogin_sdk/request/WtloginMsfListener:getRetData	()[B
    //   199: astore_1
    //   200: aload_1
    //   201: ifnonnull +240 -> 441
    //   204: new 416	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 674
    //   214: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_3
    //   218: invokevirtual 677	oicq/wlogin_sdk/request/WtloginMsfListener:getRet	()I
    //   221: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: new 416	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   234: ldc 97
    //   236: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_0
    //   240: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   243: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   246: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: sipush -1000
    //   258: istore 4
    //   260: aload_0
    //   261: getfield 143	oicq/wlogin_sdk/request/oicq_request:t	I
    //   264: sipush 2066
    //   267: if_icmpeq +112 -> 379
    //   270: new 189	oicq/wlogin_sdk/report/report_t3
    //   273: dup
    //   274: invokespecial 190	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   277: astore_3
    //   278: aload_3
    //   279: aload_0
    //   280: getfield 143	oicq/wlogin_sdk/request/oicq_request:t	I
    //   283: putfield 193	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   286: aload_3
    //   287: aload_0
    //   288: getfield 145	oicq/wlogin_sdk/request/oicq_request:u	I
    //   291: putfield 196	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   294: aload_3
    //   295: iload 4
    //   297: putfield 199	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   300: aload_3
    //   301: invokestatic 205	java/lang/System:currentTimeMillis	()J
    //   304: lload 5
    //   306: lsub
    //   307: l2i
    //   308: putfield 208	oicq/wlogin_sdk/report/report_t3:_used	I
    //   311: aload_3
    //   312: iconst_0
    //   313: putfield 211	oicq/wlogin_sdk/report/report_t3:_try	I
    //   316: aload_3
    //   317: ldc 97
    //   319: putfield 214	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   322: aload_3
    //   323: ldc 97
    //   325: putfield 217	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   328: aload_3
    //   329: iconst_0
    //   330: putfield 223	oicq/wlogin_sdk/report/report_t3:_port	I
    //   333: aload_3
    //   334: iconst_0
    //   335: putfield 226	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   338: aload_3
    //   339: iconst_0
    //   340: putfield 233	oicq/wlogin_sdk/report/report_t3:_net	I
    //   343: aload_3
    //   344: ldc 97
    //   346: putfield 236	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   349: iload 4
    //   351: ifne +143 -> 494
    //   354: aload_3
    //   355: aload 7
    //   357: arraylength
    //   358: putfield 239	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   361: aload_3
    //   362: aload_1
    //   363: arraylength
    //   364: putfield 242	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   367: aload_3
    //   368: iconst_3
    //   369: putfield 245	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   372: getstatic 249	oicq/wlogin_sdk/request/t:an	Loicq/wlogin_sdk/report/Reporter;
    //   375: aload_3
    //   376: invokevirtual 255	oicq/wlogin_sdk/report/Reporter:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   379: new 416	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   386: aload_0
    //   387: invokevirtual 633	java/lang/Object:getClass	()Ljava/lang/Class;
    //   390: invokevirtual 638	java/lang/Class:getName	()Ljava/lang/String;
    //   393: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: ldc_w 679
    //   399: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: iload 4
    //   404: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: new 416	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   417: ldc 97
    //   419: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_0
    //   423: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   426: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   429: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   432: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: iload 4
    //   440: ireturn
    //   441: aload_0
    //   442: aload_1
    //   443: aload_1
    //   444: arraylength
    //   445: invokevirtual 681	oicq/wlogin_sdk/request/oicq_request:b	([BI)V
    //   448: iconst_0
    //   449: istore 4
    //   451: goto -191 -> 260
    //   454: astore_3
    //   455: aconst_null
    //   456: astore_1
    //   457: aload_3
    //   458: new 416	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   465: ldc 97
    //   467: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_0
    //   471: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   474: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   477: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   480: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 685	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   486: sipush -1000
    //   489: istore 4
    //   491: goto -231 -> 260
    //   494: aload_3
    //   495: iconst_0
    //   496: putfield 239	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   499: aload_3
    //   500: iconst_0
    //   501: putfield 242	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   504: goto -137 -> 367
    //   507: astore_3
    //   508: goto -51 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	oicq_request
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
  
  public void b(long paramLong, byte[] paramArrayOfByte)
  {
    b(this.i, this.t, paramLong, this.m, t.w, this.p, paramArrayOfByte);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > this.b)
    {
      this.b = (paramInt + 128);
      this.h = new byte[this.b];
    }
    this.c = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.h, 0, paramInt);
  }
  
  byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.int16_to_buf(arrayOfByte, 0, paramInt1);
    util.int16_to_buf(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    if (this.x.m == 0) {
      return a(arrayOfByte, this.x.c, this.x.n, this.x.p);
    }
    return a(arrayOfByte, this.x.c);
  }
  
  protected byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
  }
  
  public int c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    return 443;
  }
  
  public int c(byte[] paramArrayOfByte, int paramInt)
  {
    this.w = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    tlv_t146 localtlv_t146 = new tlv_t146();
    paramInt1 = localtlv_t146.get_tlv(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = t.b(this.x.h);
    if (paramInt1 >= 0)
    {
      paramArrayOfByte._last_err_msg.setTitle(new String(localtlv_t146.get_title()));
      paramArrayOfByte._last_err_msg.setMessage(new String(localtlv_t146.get_msg()));
      paramArrayOfByte._last_err_msg.setType(localtlv_t146.get_type());
      paramArrayOfByte._last_err_msg.setOtherinfo(new String(localtlv_t146.get_errorinfo()));
    }
  }
  
  public byte[] c()
  {
    byte[] arrayOfByte = new byte[this.c];
    System.arraycopy(this.h, 0, arrayOfByte, 0, this.c);
    return arrayOfByte;
  }
  
  public byte[] c(byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((t.B == null) || (t.B.length <= 0))
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
        if (t.B.length > localObject.length) {
          System.arraycopy(t.B, 0, localObject, 0, localObject.length);
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
          System.arraycopy(t.B, 0, localObject, 0, t.B.length);
          i1 = t.B.length;
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
      t.b(this.x.h)._tgtgt_key = arrayOfByte;
      return localObject;
    }
  }
  
  public byte[] c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
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
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i1;
    if (paramInt2 < 5)
    {
      i1 = -1009;
      return i1;
    }
    long l2 = 4294967295L;
    tlv_t104 localtlv_t104 = new tlv_t104();
    Object localObject10 = new tlv_t105();
    Object localObject11 = new tlv_t113();
    tlv_t119 localtlv_t119 = new tlv_t119();
    tlv_t10d localtlv_t10d = new tlv_t10d();
    tlv_t10e localtlv_t10e = new tlv_t10e();
    tlv_t10a localtlv_t10a = new tlv_t10a();
    tlv_t114 localtlv_t114 = new tlv_t114();
    tlv_t103 localtlv_t103 = new tlv_t103();
    tlv_t11a localtlv_t11a = new tlv_t11a();
    tlv_t102 localtlv_t102 = new tlv_t102();
    tlv_t10b localtlv_t10b = new tlv_t10b();
    tlv_t11c localtlv_t11c = new tlv_t11c();
    tlv_t11d localtlv_t11d = new tlv_t11d();
    Object localObject4 = new tlv_t120();
    Object localObject1 = new tlv_t121();
    tlv_t130 localtlv_t130 = new tlv_t130();
    tlv_t108 localtlv_t108 = new tlv_t108();
    tlv_t106 localtlv_t106 = new tlv_t106();
    Object localObject9 = new tlv_t10c();
    Object localObject3 = new tlv_t125();
    Object localObject6 = new tlv_t11f();
    Object localObject5 = new tlv_t138();
    tlv_t132 localtlv_t132 = new tlv_t132();
    tlv_t149 localtlv_t149 = new tlv_t149();
    tlv_t150 localtlv_t150 = new tlv_t150();
    Object localObject7 = new tlv_t143();
    tlv_t305 localtlv_t305 = new tlv_t305();
    tlv_t164 localtlv_t164 = new tlv_t164();
    tlv_t165 localtlv_t165 = new tlv_t165();
    tlv_t167 localtlv_t167 = new tlv_t167();
    tlv_t16a localtlv_t16a = new tlv_t16a();
    tlv_t169 localtlv_t169 = new tlv_t169();
    tlv_t161 localtlv_t161 = new tlv_t161();
    tlv_t171 localtlv_t171 = new tlv_t171();
    tlv_t localtlv_t = new tlv_t(1298);
    tlv_t16d localtlv_t16d = new tlv_t16d();
    tlv_t174 localtlv_t174 = new tlv_t174();
    tlv_t178 localtlv_t178 = new tlv_t178();
    tlv_t179 localtlv_t179 = new tlv_t179();
    tlv_t17d localtlv_t17d = new tlv_t17d();
    tlv_t17e localtlv_t17e = new tlv_t17e();
    tlv_t126 localtlv_t126 = new tlv_t126();
    tlv_t182 localtlv_t182 = new tlv_t182();
    tlv_t183 localtlv_t183 = new tlv_t183();
    tlv_t186 localtlv_t186 = new tlv_t186();
    tlv_t402 localtlv_t402 = new tlv_t402();
    Object localObject8 = new tlv_t403();
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte3 = null;
    byte[] arrayOfByte4 = null;
    byte[] arrayOfByte5 = null;
    Object localObject2 = null;
    byte[] arrayOfByte6 = null;
    tlv_t136 localtlv_t136 = new tlv_t136();
    tlv_t118 localtlv_t118 = new tlv_t118();
    async_context localasync_context = t.b(this.x.h);
    long l3 = localasync_context._sappid;
    long l4 = localasync_context._appid;
    if (this.t == 2064) {
      switch (this.u)
      {
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 12: 
      case 14: 
      case 16: 
      case 21: 
      default: 
        return -1012;
      case 9: 
        paramInt2 = 0;
      }
    }
    for (;;)
    {
      label638:
      i1 = c(paramArrayOfByte, paramInt1 + 2);
      int i4 = paramInt1 + 5;
      this.x.d = null;
      label842:
      label892:
      int i2;
      label1160:
      int i5;
      int i3;
      switch (i1)
      {
      default: 
        c(paramArrayOfByte, i4, this.c - i4 - 1);
        paramInt1 = i1;
      case 0: 
        do
        {
          do
          {
            localObject2 = new StringBuilder().append("type:").append(i1).append(" ret:");
            if (paramInt1 <= 0) {
              break label5974;
            }
            localObject1 = "0x" + Integer.toHexString(paramInt1);
            util.LOGI(localObject1, "" + this.x.f);
            if (paramInt1 != 0) {
              break label5983;
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
            break label638;
            paramInt2 = 2;
            break label638;
            paramInt2 = 3;
            break label638;
            paramInt2 = 4;
            break label638;
            paramInt2 = 5;
            break label638;
            paramInt2 = 6;
            break label638;
            paramInt2 = 7;
            break label638;
            paramInt2 = 0;
            break label638;
            paramInt2 = 0;
            break label638;
            paramInt2 = 0;
            break label638;
            if (paramInt2 != 1) {
              break label2171;
            }
            if (this.x.b == null) {
              return -1006;
            }
            if (localtlv_t150.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
              this.x.d = localtlv_t150;
            }
            if (localtlv_t161.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
              a(localtlv_t161);
            }
            i2 = localtlv_t119.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1, this.x.b);
            paramInt1 = i2;
          } while (i2 < 0);
          localObject10 = localtlv_t119.get_data();
          i2 = 2;
          i5 = localObject10.length;
          if (localtlv_t149.get_tlv((byte[])localObject10, 2, i5) > 0) {
            a(localtlv_t149);
          }
          if (localtlv_t130.get_tlv((byte[])localObject10, 2, i5) > 0) {
            this.x.a(localtlv_t130.get_time(), localtlv_t130.get_ipaddr());
          }
          if (((tlv_t113)localObject11).get_tlv((byte[])localObject10, 2, i5) >= 0)
          {
            this.x.f = ((tlv_t113)localObject11).get_uin();
            this.x.a(this.x.g, Long.valueOf(this.x.f));
          }
          localObject11 = new tlv_t(1320);
          if (((tlv_t)localObject11).get_tlv((byte[])localObject10, 2, i5) > 0)
          {
            util.LOGI("get tlv528 and put into context from seq " + this.x.h, "" + this.x.f);
            localasync_context.tlv528 = ((tlv_t)localObject11);
          }
          localtlv_t10d.get_tlv((byte[])localObject10, 2, i5);
          localtlv_t10e.get_tlv((byte[])localObject10, 2, i5);
          localtlv_t10a.get_tlv((byte[])localObject10, 2, i5);
          localtlv_t114.get_tlv((byte[])localObject10, 2, i5);
          i3 = localtlv_t11a.get_tlv((byte[])localObject10, 2, i5);
          paramInt1 = i3;
        } while (i3 < 0);
        if (localtlv_t118.get_tlv((byte[])localObject10, 2, i5) < 0) {
          util.LOGI("t118 get failed", "" + this.x.f);
        }
        if (localtlv_t103.get_tlv((byte[])localObject10, 2, i5) >= 0) {
          localObject2 = localtlv_t103.get_data();
        }
        if (localtlv_t108.get_tlv((byte[])localObject10, 2, i5) >= 0) {
          util.set_ksid(t.t, localtlv_t108.get_data());
        }
        if (localtlv_t102.get_tlv((byte[])localObject10, 2, i5) >= 0) {
          arrayOfByte1 = localtlv_t102.get_data();
        }
        if (localtlv_t10b.get_tlv((byte[])localObject10, 2, i5) >= 0) {
          arrayOfByte2 = localtlv_t10b.get_data();
        }
        if (localtlv_t11c.get_tlv((byte[])localObject10, 2, i5) >= 0) {
          arrayOfByte3 = localtlv_t11c.get_data();
        }
        if (((tlv_t120)localObject4).get_tlv((byte[])localObject10, 2, i5) >= 0) {
          arrayOfByte4 = ((tlv_t120)localObject4).get_data();
        }
        if (((tlv_t121)localObject1).get_tlv((byte[])localObject10, 2, i5) >= 0) {
          arrayOfByte5 = ((tlv_t121)localObject1).get_data();
        }
        if (((tlv_t125)localObject3).get_tlv((byte[])localObject10, 2, i5) >= 0)
        {
          localObject1 = ((tlv_t125)localObject3).get_openid();
          arrayOfByte6 = ((tlv_t125)localObject3).get_openkey();
        }
        break;
      }
      label3220:
      label3991:
      for (;;)
      {
        if (localtlv_t186.get_tlv((byte[])localObject10, 2, i5) >= 0)
        {
          localObject3 = this.x.g;
          if (util.check_uin_account((String)localObject3).booleanValue())
          {
            localObject4 = this.x.e(this.x.f);
            localObject3 = localObject4;
            if (localObject4 != null)
            {
              localObject3 = localObject4;
              if (((String)localObject4).length() > 0)
              {
                this.x.a((String)localObject4, Long.valueOf(this.x.f), localtlv_t186.getPwdflag());
                localObject3 = localObject4;
              }
            }
            label1744:
            util.LOGI("put t186: name: " + (String)localObject3 + " uin: " + this.x.f + " pwd=" + localtlv_t186.getPwdflag(), "");
          }
        }
        else
        {
          util.LOGI("tgt len:" + util.buf_len(localtlv_t10a.get_data()) + " tgt_key len:" + util.buf_len(localtlv_t10d.get_data()) + " st len:" + util.buf_len(localtlv_t114.get_data()) + " st_key len:" + util.buf_len(localtlv_t10e.get_data()) + " stwx_web len:" + util.buf_len((byte[])localObject2) + " lskey len:" + util.buf_len(arrayOfByte3) + " skey len:" + util.buf_len(arrayOfByte4) + " sig64 len:" + util.buf_len(arrayOfByte5) + " openid len:" + util.buf_len((byte[])localObject1) + " openkey len:" + util.buf_len(arrayOfByte6) + " pwdflag: " + localtlv_t186.get_data_len() + " " + localtlv_t186.getPwdflag(), "" + this.x.f);
          if (localtlv_t169.get_tlv((byte[])localObject10, 2, i5) >= 0)
          {
            localObject3 = a(localtlv_t169);
            if ((localObject3 == null) || (localObject3.length <= 0)) {
              break label2673;
            }
          }
        }
        label2673:
        for (this.x.j = new WFastLoginInfo((byte[])localObject3);; this.x.j = new WFastLoginInfo())
        {
          localObject3 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 3, 0 });
          if (localtlv_t167.get_tlv((byte[])localObject10, 2, i5) >= 0)
          {
            localObject3[0] = localtlv_t167.get_img_type();
            localObject3[1] = localtlv_t167.get_img_format();
            localObject3[2] = localtlv_t167.get_img_url();
          }
          localObject4 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 5, 0 });
          paramInt1 = 0;
          while (paramInt1 < 5)
          {
            localObject4[paramInt1] = new byte[0];
            paramInt1 += 1;
          }
          label2171:
          if (paramInt2 == 2)
          {
            if (localtlv_t183.get_tlv(paramArrayOfByte, i4, this.c - i4) >= 0) {
              localasync_context._msalt = localtlv_t183.getMsalt();
            }
            if (f() == 3)
            {
              if (((tlv_t113)localObject11).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
              {
                this.x.f = ((tlv_t113)localObject11).get_uin();
                this.x.a(this.x.g, Long.valueOf(this.x.f));
              }
              if (localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
                localasync_context._t104 = localtlv_t104;
              }
              paramInt1 = 0;
              break;
            }
            if (localtlv_t150.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
              this.x.d = localtlv_t150;
            }
            if (localtlv_t161.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
              a(localtlv_t161);
            }
            i2 = localtlv_t119.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1, localasync_context._tgtgt_key);
            break label1160;
          }
          if ((paramInt2 == 3) || (paramInt2 == 7))
          {
            if (localtlv_t183.get_tlv(paramArrayOfByte, i4, this.c - i4) >= 0) {
              localasync_context._msalt = localtlv_t183.getMsalt();
            }
            if (((tlv_t113)localObject11).get_tlv(paramArrayOfByte, i4, this.c - i4) >= 0)
            {
              this.x.f = ((tlv_t113)localObject11).get_uin();
              this.x.a(this.x.g, Long.valueOf(this.x.f));
            }
            i2 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t104 = localtlv_t104;
            paramInt1 = 0;
            break;
          }
          if (22 == this.u)
          {
            i2 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t104 = localtlv_t104;
            paramInt1 = 0;
            break;
          }
          if (localtlv_t150.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
            this.x.d = localtlv_t150;
          }
          if (localtlv_t161.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
            a(localtlv_t161);
          }
          i2 = localtlv_t119.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1, localasync_context._tgtgt_key);
          s.I = 0;
          break label1160;
          this.x.a((String)localObject3, Long.valueOf(this.x.f), localtlv_t186.getPwdflag());
          break label1744;
        }
        paramInt1 = ((tlv_t10c)localObject9).get_tlv((byte[])localObject10, 2, i5);
        if ((localtlv_t106.get_tlv((byte[])localObject10, 2, i5) >= 0) && (paramInt1 >= 0))
        {
          localObject9 = ((tlv_t10c)localObject9).get_data();
          localObject4[0] = ((byte[])b(localtlv_t106.get_data(), (byte[])localObject9).clone());
        }
        if (localtlv_t16a.get_tlv((byte[])localObject10, 2, i5) >= 0) {
          localObject4[1] = localtlv_t16a.get_data();
        }
        if (((tlv_t403)localObject8).get_tlv((byte[])localObject10, 2, i5) >= 0) {
          localObject4[4] = ((tlv_t403)localObject8).get_data();
        }
        if (localasync_context._sec_guid_flag)
        {
          localObject4[2] = localasync_context._G;
          localObject4[3] = localasync_context._dpwd;
          localObject4[4] = localasync_context._t403.get_data();
          localasync_context._sec_guid_flag = false;
        }
        localObject8 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 15, 0 });
        paramInt1 = 0;
        while (paramInt1 < 15)
        {
          localObject8[paramInt1] = new byte[0];
          paramInt1 += 1;
        }
        if (localtlv_t136.get_tlv((byte[])localObject10, 2, i5) >= 0) {
          localObject8[0] = localtlv_t136.get_data();
        }
        if (localtlv_t132.get_tlv((byte[])localObject10, 2, i5) >= 0)
        {
          localObject8[1] = localtlv_t132.get_access_token();
          localObject1 = localtlv_t132.get_openid();
        }
        if (((tlv_t143)localObject7).get_tlv((byte[])localObject10, 2, i5) >= 0) {
          localObject8[2] = ((tlv_t143)localObject7).get_data();
        }
        if (localtlv_t305.get_tlv((byte[])localObject10, 2, i5) >= 0) {
          localObject8[3] = localtlv_t305.get_data();
        }
        if (localtlv_t164.get_tlv((byte[])localObject10, 2, i5) >= 0) {
          localObject8[4] = localtlv_t164.get_data();
        }
        if (localtlv_t171.get_tlv((byte[])localObject10, 2, i5) >= 0) {
          localObject8[5] = localtlv_t171.get_data();
        }
        if (localtlv_t.get_tlv((byte[])localObject10, 2, i5) >= 0) {
          localObject8[6] = localtlv_t.get_data();
        }
        if (localtlv_t16d.get_tlv((byte[])localObject10, 2, i5) >= 0) {
          localObject8[7] = localtlv_t16d.get_data();
        }
        localObject7 = new tlv_t199();
        if (((tlv_t199)localObject7).get_tlv((byte[])localObject10, 2, i5) >= 0)
        {
          localObject8[8] = ((tlv_t199)localObject7).getPayToken();
          localObject1 = ((tlv_t199)localObject7).getOpenId();
        }
        label3741:
        label3873:
        label4001:
        label4012:
        for (;;)
        {
          localObject7 = new tlv_t200();
          if (((tlv_t200)localObject7).get_tlv((byte[])localObject10, 2, i5) >= 0)
          {
            localObject8[9] = ((tlv_t200)localObject7).getPf();
            localObject8[10] = ((tlv_t200)localObject7).getPfKey();
          }
          localObject7 = new tlv_t(515);
          label3255:
          label3290:
          long l1;
          if (((tlv_t)localObject7).get_tlv((byte[])localObject10, 2, i5) >= 0)
          {
            localObject8[11] = ((tlv_t)localObject7).get_data();
            util.LOGI("get DA2 in rsp", "");
            localObject7 = new tlv_t(791);
            if (((tlv_t)localObject7).get_tlv((byte[])localObject10, 2, i5) < 0) {
              break label3864;
            }
            WloginSigInfo._QRPUSHSig = ((tlv_t)localObject7).get_data();
            localObject7 = new tlv_t(307);
            if (((tlv_t)localObject7).get_tlv((byte[])localObject10, 2, i5) < 0) {
              break label3873;
            }
            localObject8[13] = ((tlv_t)localObject7).get_data();
            localObject7 = new tlv_t(308);
            if (((tlv_t)localObject7).get_tlv((byte[])localObject10, 2, i5) < 0) {
              break label3907;
            }
            localObject8[14] = ((tlv_t)localObject7).get_data();
            util.LOGI("encrypt_a1 len:" + util.buf_len(localObject4[0]) + " no_pic_sig len:" + util.buf_len(localObject4[1]) + " G len:" + util.buf_len(localObject4[2]) + " dpwd len:" + util.buf_len(localObject4[3]) + " randseed len:" + util.buf_len(localObject4[4]) + " vkey len:" + util.buf_len(localObject8[0]) + " openid len:" + util.buf_len((byte[])localObject1) + " access_token len:" + util.buf_len(localObject8[1]) + " d2 len:" + util.buf_len(localObject8[2]) + " d2_key len:" + util.buf_len(localObject8[3]) + " sid len:" + util.buf_len(localObject8[4]) + " aq_sig len:" + util.buf_len(localObject8[5]) + " pskey len:" + util.buf_len(localObject8[6]) + " super_key len:" + util.buf_len(localObject8[7]) + " paytoken len:" + util.buf_len(localObject8[8]) + " pf len:" + util.buf_len(localObject8[9]) + " pfkey len:" + util.buf_len(localObject8[10]) + " da2 len:" + util.buf_len(localObject8[11]) + " wt session ticket:" + util.buf_len(localObject8[13]) + " wt session ticket key:" + util.buf_len(localObject8[14]), "" + this.x.f);
            if (((tlv_t11f)localObject6).get_tlv((byte[])localObject10, 2, i5) >= 0) {
              l2 = ((tlv_t11f)localObject6).get_tk_pri() & 0xFFFFFFFF;
            }
            localObject6 = new long[7];
            paramInt1 = 2;
            l1 = 2160000L;
            label3692:
            paramInt1 = ((tlv_t138)localObject5).get_tlv((byte[])localObject10, paramInt1, i5);
            if (paramInt1 < 0) {
              break label4012;
            }
            if (((tlv_t138)localObject5).get_a2_chg_time() == 0) {
              break label6072;
            }
            l1 = ((tlv_t138)localObject5).get_a2_chg_time();
          }
          label3759:
          label6072:
          for (;;)
          {
            if (((tlv_t138)localObject5).get_lskey_chg_time() != 0)
            {
              localObject6[0] = ((tlv_t138)localObject5).get_lskey_chg_time();
              if (((tlv_t138)localObject5).get_skey_chg_time() == 0) {
                break label3951;
              }
              localObject6[1] = ((tlv_t138)localObject5).get_skey_chg_time();
              if (((tlv_t138)localObject5).get_vkey_chg_time() == 0) {
                break label3961;
              }
              localObject6[2] = ((tlv_t138)localObject5).get_vkey_chg_time();
              label3777:
              if (((tlv_t138)localObject5).get_a8_chg_time() == 0) {
                break label3971;
              }
              localObject6[3] = ((tlv_t138)localObject5).get_a8_chg_time();
              label3795:
              if (((tlv_t138)localObject5).get_stweb_chg_time() == 0) {
                break label3981;
              }
              localObject6[4] = ((tlv_t138)localObject5).get_stweb_chg_time();
              label3813:
              if (((tlv_t138)localObject5).get_d2_chg_time() == 0) {
                break label3991;
              }
              localObject6[5] = ((tlv_t138)localObject5).get_d2_chg_time();
            }
            for (;;)
            {
              if (((tlv_t138)localObject5).get_sid_chg_time() == 0) {
                break label4001;
              }
              localObject6[6] = ((tlv_t138)localObject5).get_sid_chg_time();
              break label3692;
              util.LOGI("no DA2 in rsp", "");
              break;
              WloginSigInfo._QRPUSHSig = new byte[0];
              break label3220;
              util.LOGW("get t133 failed", "" + this.x.f);
              break label3255;
              label3907:
              util.LOGW("get t134 failed", "" + this.x.f);
              break label3290;
              localObject6[0] = 1641600L;
              break label3741;
              label3951:
              localObject6[1] = 86400L;
              break label3759;
              label3961:
              localObject6[2] = 1728000L;
              break label3777;
              localObject6[3] = 72000L;
              break label3795;
              localObject6[4] = 6000L;
              break label3813;
              localObject6[5] = 1728000L;
            }
            localObject6[6] = 1728000L;
            break label3692;
            util.LOGI("sappid:" + l3 + " appid:" + l4 + " app_pri:" + l2 + " login_bitmap:" + localasync_context._login_bitmap + " tk_valid:" + 0L + " a2_valid:" + l1 + " lskey_valid:" + localObject6[0] + " skey_valid:" + localObject6[1] + " vkey_valid:" + localObject6[2] + " a8_valid:" + localObject6[3] + " stweb_valid:" + localObject6[4] + " d2_valid:" + localObject6[5] + " sid_valid:" + localObject6[6], "" + this.x.f);
            localObject5 = new WloginSimpleInfo();
            ((WloginSimpleInfo)localObject5).setUin(this.x.f);
            ((WloginSimpleInfo)localObject5).setFace(localtlv_t11a.get_face());
            ((WloginSimpleInfo)localObject5).setAge(localtlv_t11a.get_age());
            ((WloginSimpleInfo)localObject5).setGender(localtlv_t11a.get_gender());
            ((WloginSimpleInfo)localObject5).setNick(localtlv_t11a.get_nick());
            ((WloginSimpleInfo)localObject5).setReserveUinInfo((byte[][])localObject3);
            ((WloginSimpleInfo)localObject5).setMainDisplayName(localtlv_t118.get_data());
            this.x.aq = localasync_context._main_sigmap;
            i3 = this.x.a(this.x.f, l3, (byte[][])localObject4, l4, l2, t.f(), t.f() + 0L, l1 + t.f(), (WloginSimpleInfo)localObject5, localtlv_t10a.get_data(), localtlv_t10d.get_data(), localtlv_t114.get_data(), localtlv_t10e.get_data(), (byte[])localObject2, arrayOfByte2, arrayOfByte1, arrayOfByte3, arrayOfByte4, arrayOfByte5, (byte[])localObject1, arrayOfByte6, (byte[][])localObject8, (long[])localObject6, localasync_context._login_bitmap);
            paramInt1 = i2;
            if (i3 != 0)
            {
              localObject1 = new ErrMsg();
              ((ErrMsg)localObject1).setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
              a((ErrMsg)localObject1);
              util.LOGI("put_siginfo fail,ret=" + i3, "" + this.x.f);
              paramInt1 = i3;
              break;
            }
            for (;;)
            {
              paramInt1 = localtlv_t11d.get_tlv((byte[])localObject10, paramInt1, i5);
              if (paramInt1 < 0) {
                break;
              }
              this.x.a(this.x.f, localtlv_t11d.get_appid(), t.f(), t.f() + 0L, localtlv_t11d.get_st(), localtlv_t11d.get_stkey());
            }
            paramInt1 = 0;
            break;
            util.LOGI("cmd " + Integer.toHexString(this.t) + " subcmd " + Integer.toHexString(this.u) + " result " + i1 + " will clean sig for uin " + this.x.f + " appid " + l3);
            this.x.e(this.x.f, l3);
            c(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i1;
            break;
            i2 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t104 = localtlv_t104;
            localObject1 = new tlv_t192();
            if (((tlv_t192)localObject1).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
            {
              a(new ErrMsg(i1, "", "", ((tlv_t192)localObject1).getUrl()));
              paramInt1 = i1;
              break;
            }
            i2 = ((tlv_t105)localObject10).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t105 = ((tlv_t105)localObject10);
            if (localtlv_t165.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {}
            for (localasync_context._t165 = localtlv_t165;; localasync_context._t165 = new tlv_t165())
            {
              a(null);
              break;
            }
            this.x.e(this.x.f, l3);
            i2 = localtlv_t130.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            this.x.a(localtlv_t130.get_time(), localtlv_t130.get_ipaddr());
            c(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i1;
            break;
            localObject1 = new tlv_t(405);
            i2 = ((tlv_t)localObject1).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            WloginSigInfo._LHSig = ((tlv_t)localObject1).get_data();
            c(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i1;
            break;
            if (((tlv_t113)localObject11).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
            {
              this.x.f = ((tlv_t113)localObject11).get_uin();
              this.x.a(this.x.g, Long.valueOf(this.x.f));
            }
            i2 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t104 = localtlv_t104;
            i2 = localtlv_t174.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t174 = localtlv_t174;
            if (localtlv_t178.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
            {
              localasync_context._devlock_info.CountryCode = new String(localtlv_t178.get_country_code());
              localasync_context._devlock_info.Mobile = new String(localtlv_t178.get_mobile());
              localasync_context._devlock_info.MbItemSmsCodeStatus = localtlv_t178.get_smscode_status();
              localasync_context._devlock_info.AvailableMsgCount = localtlv_t178.get_available_msg_cnt();
              localasync_context._devlock_info.TimeLimit = localtlv_t178.get_time_limit();
            }
            localObject1 = new tlv_t196();
            if (((tlv_t196)localObject1).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
            {
              localasync_context._devlock_info.BakCountryCode = ((tlv_t196)localObject1).getCountryCode();
              localasync_context._devlock_info.BakMobile = ((tlv_t196)localObject1).getBakMobile();
              localasync_context._devlock_info.BakMobileState = ((tlv_t196)localObject1).getBakMobileState();
            }
            if (localtlv_t179.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
              localasync_context._devlock_info.UnionVerifyUrl = new String(localtlv_t179.get_verify_url());
            }
            if (localtlv_t17d.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
            {
              localasync_context._devlock_info.MbGuideType = localtlv_t17d.get_mb_guide_type();
              localasync_context._devlock_info.MbGuideMsg = new String(localtlv_t17d.get_mb_guide_msg());
              localasync_context._devlock_info.MbGuideInfoType = localtlv_t17d.get_mb_guide_info_type();
              localasync_context._devlock_info.MbGuideInfo = new String(localtlv_t17d.get_mb_guide_info());
            }
            if (localtlv_t17e.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
              localasync_context._devlock_info.VerifyReason = new String(localtlv_t17e.get_data());
            }
            if (localtlv_t402.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
            {
              localasync_context._t402 = localtlv_t402;
              label5466:
              if (((tlv_t403)localObject8).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) < 0) {
                break label5530;
              }
            }
            for (localasync_context._t403 = ((tlv_t403)localObject8);; localasync_context._t403 = new tlv_t403())
            {
              c(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i1;
              break;
              localasync_context._t402 = new tlv_t402();
              break label5466;
            }
            c(paramArrayOfByte, i4, this.c - i4 - 1);
            this.x.a(this.x.g);
            paramInt1 = i1;
            break;
            i2 = localtlv_t161.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            a(localtlv_t161);
            c(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i1;
            break;
            if (((tlv_t113)localObject11).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
            {
              this.x.f = ((tlv_t113)localObject11).get_uin();
              this.x.a(this.x.g, Long.valueOf(this.x.f));
            }
            i2 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t104 = localtlv_t104;
            i2 = localtlv_t402.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t402 = localtlv_t402;
            i2 = ((tlv_t403)localObject8).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t403 = ((tlv_t403)localObject8);
            c(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i1;
            break;
            i2 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t104 = localtlv_t104;
            i2 = localtlv_t126.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t126 = localtlv_t126;
            i2 = localtlv_t182.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._smslogin_msgcnt = localtlv_t182.getMsgCnt();
            localasync_context._smslogin_timelimit = localtlv_t182.getTimeLimit();
            i2 = localtlv_t183.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._msalt = localtlv_t183.getMsalt();
            paramInt1 = 0;
            break;
            label5974:
            localObject1 = Integer.valueOf(paramInt1);
            break label842;
            label5983:
            new tlv_t508().get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
            i1 = paramInt1;
            if (!tlv_t508.doFetch) {
              break label892;
            }
            paramArrayOfByte = new ErrMsg();
            i2 = new i(this.x, this.t, this.u, paramArrayOfByte).b(paramInt1);
            i1 = paramInt1;
            if (i2 == -1000) {
              break label892;
            }
            a(paramArrayOfByte);
            i1 = i2;
            break label892;
          }
        }
        label3864:
        label5530:
        localObject1 = null;
      }
      label3971:
      label3981:
      paramInt2 = 0;
    }
  }
  
  public Socket d()
  {
    return this.x.aj;
  }
  
  /* Error */
  public int e()
  {
    // Byte code:
    //   0: new 416	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 633	java/lang/Object:getClass	()Ljava/lang/Class;
    //   11: invokevirtual 638	java/lang/Class:getName	()Ljava/lang/String;
    //   14: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 1516
    //   20: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: new 416	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   33: ldc 97
    //   35: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   42: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   45: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: invokevirtual 643	oicq/wlogin_sdk/request/oicq_request:c	()[B
    //   58: astore 22
    //   60: iconst_0
    //   61: istore_3
    //   62: iconst_0
    //   63: istore_1
    //   64: iconst_0
    //   65: istore_2
    //   66: aload_0
    //   67: invokevirtual 1518	oicq/wlogin_sdk/request/oicq_request:d	()Ljava/net/Socket;
    //   70: astore 15
    //   72: iconst_0
    //   73: istore 9
    //   75: iconst_0
    //   76: istore 8
    //   78: iconst_0
    //   79: istore 4
    //   81: ldc 97
    //   83: astore 16
    //   85: ldc 97
    //   87: astore 14
    //   89: lconst_0
    //   90: lstore 12
    //   92: iload_2
    //   93: bipush 6
    //   95: if_icmpge +2903 -> 2998
    //   98: iload_2
    //   99: ifeq +9 -> 108
    //   102: getstatic 374	oicq/wlogin_sdk/request/t:t	Landroid/content/Context;
    //   105: invokestatic 1521	oicq/wlogin_sdk/tools/util:chg_retry_type	(Landroid/content/Context;)V
    //   108: getstatic 374	oicq/wlogin_sdk/request/t:t	Landroid/content/Context;
    //   111: invokestatic 1525	oicq/wlogin_sdk/tools/util:is_wap_retry	(Landroid/content/Context;)Z
    //   114: istore 11
    //   116: aload_0
    //   117: aconst_null
    //   118: putfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   121: iload_2
    //   122: ifeq +27 -> 149
    //   125: aload_0
    //   126: getfield 143	oicq/wlogin_sdk/request/oicq_request:t	I
    //   129: sipush 2066
    //   132: if_icmpeq +17 -> 149
    //   135: aload_0
    //   136: iload_1
    //   137: lload 12
    //   139: iload 4
    //   141: iload_2
    //   142: iload 11
    //   144: iload 8
    //   146: invokespecial 1527	oicq/wlogin_sdk/request/oicq_request:a	(IJIIZZ)V
    //   149: invokestatic 205	java/lang/System:currentTimeMillis	()J
    //   152: lstore 12
    //   154: iload 11
    //   156: ifeq +1198 -> 1354
    //   159: new 416	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 1529
    //   169: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: iload_2
    //   173: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: ldc_w 1531
    //   179: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: new 416	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   192: ldc 97
    //   194: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   201: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   204: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: iload_2
    //   215: iload 11
    //   217: invokevirtual 1533	oicq/wlogin_sdk/request/oicq_request:a	(IZ)Ljava/lang/String;
    //   220: astore 21
    //   222: iload 8
    //   224: istore 9
    //   226: iload 8
    //   228: istore 10
    //   230: getstatic 374	oicq/wlogin_sdk/request/t:t	Landroid/content/Context;
    //   233: invokestatic 1536	oicq/wlogin_sdk/tools/util:is_wap_proxy_retry	(Landroid/content/Context;)Z
    //   236: istore 8
    //   238: iload 8
    //   240: ifeq +2749 -> 2989
    //   243: iload 8
    //   245: istore 9
    //   247: iload 8
    //   249: istore 10
    //   251: invokestatic 1539	oicq/wlogin_sdk/tools/util:get_proxy_ip	()Ljava/lang/String;
    //   254: astore 17
    //   256: iload 8
    //   258: istore 9
    //   260: iload 8
    //   262: istore 10
    //   264: invokestatic 1542	oicq/wlogin_sdk/tools/util:get_proxy_port	()I
    //   267: istore 5
    //   269: aload 17
    //   271: ifnull +25 -> 296
    //   274: iload 8
    //   276: istore 9
    //   278: iload 8
    //   280: istore 10
    //   282: aload 17
    //   284: invokevirtual 372	java/lang/String:length	()I
    //   287: ifle +9 -> 296
    //   290: iload 5
    //   292: iconst_m1
    //   293: if_icmpne +2711 -> 3004
    //   296: iconst_0
    //   297: istore 10
    //   299: iconst_0
    //   300: istore 8
    //   302: iconst_0
    //   303: istore 9
    //   305: new 416	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 1544
    //   315: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload 17
    //   320: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: ldc_w 1546
    //   326: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: iload 5
    //   331: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   334: ldc_w 1548
    //   337: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: iconst_0
    //   341: invokevirtual 654	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   344: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: new 416	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   354: ldc 97
    //   356: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_0
    //   360: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   363: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   366: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   369: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: goto +2629 -> 3004
    //   378: iload 8
    //   380: ifeq +383 -> 763
    //   383: iload 8
    //   385: istore 9
    //   387: iload 8
    //   389: istore 10
    //   391: new 1550	java/net/URL
    //   394: dup
    //   395: new 416	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 1552
    //   405: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload 17
    //   410: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc_w 1554
    //   416: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: iload 5
    //   421: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   424: ldc_w 1556
    //   427: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokespecial 1558	java/net/URL:<init>	(Ljava/lang/String;)V
    //   436: astore 17
    //   438: iload_1
    //   439: istore 5
    //   441: new 416	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   448: ldc_w 1560
    //   451: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: iload 8
    //   456: invokevirtual 654	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   459: ldc_w 1562
    //   462: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload 17
    //   467: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   470: ldc_w 1564
    //   473: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 21
    //   478: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: new 416	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   491: ldc 97
    //   493: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_0
    //   497: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   500: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   503: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   506: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: iload_1
    //   513: istore 5
    //   515: aload 17
    //   517: invokevirtual 1568	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   520: checkcast 1570	java/net/HttpURLConnection
    //   523: astore 17
    //   525: iload_1
    //   526: istore 5
    //   528: aload 17
    //   530: ldc_w 1572
    //   533: invokevirtual 1575	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   536: iload 8
    //   538: ifeq +16 -> 554
    //   541: iload_1
    //   542: istore 5
    //   544: aload 17
    //   546: ldc_w 1577
    //   549: aload 21
    //   551: invokevirtual 1580	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: iload_1
    //   555: istore 5
    //   557: aload 17
    //   559: ldc_w 1582
    //   562: ldc_w 1584
    //   565: invokevirtual 1580	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: iload_1
    //   569: istore 5
    //   571: aload 17
    //   573: ldc_w 1586
    //   576: ldc_w 1588
    //   579: invokevirtual 1580	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   582: iload_1
    //   583: istore 5
    //   585: aload 17
    //   587: ldc_w 1590
    //   590: aload 22
    //   592: arraylength
    //   593: invokestatic 1592	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   596: invokevirtual 1580	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   599: iload_1
    //   600: istore 5
    //   602: aload 17
    //   604: aload_0
    //   605: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   608: getfield 641	oicq/wlogin_sdk/request/t:l	I
    //   611: invokevirtual 1595	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   614: iload_1
    //   615: istore 5
    //   617: aload 17
    //   619: aload_0
    //   620: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   623: getfield 641	oicq/wlogin_sdk/request/t:l	I
    //   626: invokevirtual 1598	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   629: iload_1
    //   630: istore 5
    //   632: aload 17
    //   634: iconst_1
    //   635: invokevirtual 1602	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   638: iload_1
    //   639: istore 5
    //   641: aload 17
    //   643: iconst_1
    //   644: invokevirtual 1605	java/net/HttpURLConnection:setDoInput	(Z)V
    //   647: iload_1
    //   648: istore 5
    //   650: ldc_w 1607
    //   653: new 416	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   660: ldc 97
    //   662: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload_0
    //   666: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   669: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   672: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   675: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   681: iload_1
    //   682: istore 5
    //   684: aload 17
    //   686: aload_0
    //   687: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   690: getfield 641	oicq/wlogin_sdk/request/t:l	I
    //   693: i2l
    //   694: invokestatic 1612	oicq/wlogin_sdk/request/j:a	(Ljava/net/HttpURLConnection;J)Z
    //   697: ifne +271 -> 968
    //   700: iload_1
    //   701: istore 5
    //   703: ldc_w 1614
    //   706: new 416	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   713: ldc 97
    //   715: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: aload_0
    //   719: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   722: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   725: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   728: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   731: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   734: iload_1
    //   735: istore 5
    //   737: sipush -1026
    //   740: iload_1
    //   741: if_icmpeq +8 -> 749
    //   744: sipush -1000
    //   747: istore 5
    //   749: iload_2
    //   750: iconst_1
    //   751: iadd
    //   752: istore_2
    //   753: iload 5
    //   755: istore_1
    //   756: iload 11
    //   758: istore 9
    //   760: goto -668 -> 92
    //   763: iload 8
    //   765: istore 9
    //   767: iload 8
    //   769: istore 10
    //   771: aload_0
    //   772: aload 21
    //   774: iconst_0
    //   775: aload_0
    //   776: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   779: getfield 641	oicq/wlogin_sdk/request/t:l	I
    //   782: i2l
    //   783: invokestatic 1619	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   786: putfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   789: iload 8
    //   791: istore 9
    //   793: iload 8
    //   795: istore 10
    //   797: aload_0
    //   798: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   801: ifnull +2181 -> 2982
    //   804: iload 8
    //   806: istore 9
    //   808: iload 8
    //   810: istore 10
    //   812: aload_0
    //   813: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   816: invokevirtual 261	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   819: invokevirtual 267	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   822: astore 17
    //   824: iload 8
    //   826: istore 9
    //   828: iload 8
    //   830: istore 10
    //   832: aload 14
    //   834: aload 17
    //   836: invokevirtual 1623	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   839: ifeq +61 -> 900
    //   842: iload 8
    //   844: istore 9
    //   846: iload 8
    //   848: istore 10
    //   850: new 492	java/lang/Exception
    //   853: dup
    //   854: new 416	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   861: ldc_w 1625
    //   864: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload 14
    //   869: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: invokespecial 1626	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   878: athrow
    //   879: astore 17
    //   881: iload 9
    //   883: istore 8
    //   885: sipush -1026
    //   888: istore_1
    //   889: iload_2
    //   890: iconst_1
    //   891: iadd
    //   892: istore_2
    //   893: iload 11
    //   895: istore 9
    //   897: goto -805 -> 92
    //   900: aload 17
    //   902: astore 18
    //   904: aload 17
    //   906: astore 19
    //   908: aload_0
    //   909: aconst_null
    //   910: putfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   913: aload 17
    //   915: astore 20
    //   917: aload 17
    //   919: astore 14
    //   921: aload 14
    //   923: astore 18
    //   925: aload 14
    //   927: astore 19
    //   929: new 1550	java/net/URL
    //   932: dup
    //   933: new 416	java/lang/StringBuilder
    //   936: dup
    //   937: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   940: ldc_w 1552
    //   943: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: aload 20
    //   948: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: ldc_w 1556
    //   954: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   960: invokespecial 1558	java/net/URL:<init>	(Ljava/lang/String;)V
    //   963: astore 17
    //   965: goto -527 -> 438
    //   968: iload_1
    //   969: istore 5
    //   971: ldc_w 1628
    //   974: new 416	java/lang/StringBuilder
    //   977: dup
    //   978: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   981: ldc 97
    //   983: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload_0
    //   987: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   990: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   993: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   996: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   999: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1002: iload_1
    //   1003: istore 5
    //   1005: aload 17
    //   1007: invokevirtual 1632	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1010: astore 18
    //   1012: iload_1
    //   1013: istore 5
    //   1015: aload 18
    //   1017: aload 22
    //   1019: iconst_0
    //   1020: aload 22
    //   1022: arraylength
    //   1023: invokevirtual 1637	java/io/OutputStream:write	([BII)V
    //   1026: iload_1
    //   1027: istore 5
    //   1029: aload 18
    //   1031: invokevirtual 1640	java/io/OutputStream:flush	()V
    //   1034: iload_1
    //   1035: istore 5
    //   1037: aload 17
    //   1039: invokevirtual 1643	java/net/HttpURLConnection:getResponseCode	()I
    //   1042: istore_1
    //   1043: iload_1
    //   1044: istore 5
    //   1046: new 416	java/lang/StringBuilder
    //   1049: dup
    //   1050: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1053: ldc_w 1645
    //   1056: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: iload_1
    //   1060: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1063: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1066: new 416	java/lang/StringBuilder
    //   1069: dup
    //   1070: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1073: ldc 97
    //   1075: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: aload_0
    //   1079: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1082: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   1085: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1088: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1091: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1094: sipush 200
    //   1097: iload_1
    //   1098: if_icmpeq +18 -> 1116
    //   1101: sipush -1000
    //   1104: istore_1
    //   1105: iload_2
    //   1106: iconst_1
    //   1107: iadd
    //   1108: istore_2
    //   1109: iload 11
    //   1111: istore 9
    //   1113: goto -1021 -> 92
    //   1116: iload_1
    //   1117: istore 5
    //   1119: aload 17
    //   1121: invokevirtual 1649	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1124: astore 18
    //   1126: aload 15
    //   1128: astore 19
    //   1130: aload 16
    //   1132: astore 17
    //   1134: aload 14
    //   1136: astore 15
    //   1138: aload 19
    //   1140: astore 14
    //   1142: aload 14
    //   1144: astore 16
    //   1146: iload_2
    //   1147: istore_1
    //   1148: ldc_w 1651
    //   1151: new 416	java/lang/StringBuilder
    //   1154: dup
    //   1155: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1158: ldc 97
    //   1160: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: aload_0
    //   1164: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1167: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   1170: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1173: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1176: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1179: iconst_0
    //   1180: istore 5
    //   1182: iconst_0
    //   1183: istore 6
    //   1185: aload 14
    //   1187: astore 16
    //   1189: iload_2
    //   1190: istore_1
    //   1191: iload 6
    //   1193: aload_0
    //   1194: getfield 115	oicq/wlogin_sdk/request/oicq_request:f	I
    //   1197: iconst_1
    //   1198: iadd
    //   1199: if_icmpge +36 -> 1235
    //   1202: aload 14
    //   1204: astore 16
    //   1206: iload_2
    //   1207: istore_1
    //   1208: aload 18
    //   1210: aload_0
    //   1211: getfield 141	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   1214: iload 6
    //   1216: aload_0
    //   1217: getfield 115	oicq/wlogin_sdk/request/oicq_request:f	I
    //   1220: iconst_1
    //   1221: iadd
    //   1222: iload 6
    //   1224: isub
    //   1225: invokevirtual 1656	java/io/InputStream:read	([BII)I
    //   1228: istore 5
    //   1230: iload 5
    //   1232: ifge +982 -> 2214
    //   1235: iload 5
    //   1237: ifge +987 -> 2224
    //   1240: sipush -1000
    //   1243: istore 5
    //   1245: iload_2
    //   1246: iconst_1
    //   1247: iadd
    //   1248: istore_2
    //   1249: aload 14
    //   1251: astore 16
    //   1253: iload 11
    //   1255: ifne +42 -> 1297
    //   1258: aload 14
    //   1260: astore 16
    //   1262: iload_2
    //   1263: istore_1
    //   1264: aload 14
    //   1266: invokevirtual 1661	java/net/Socket:close	()V
    //   1269: aload 14
    //   1271: astore 16
    //   1273: iload_2
    //   1274: istore_1
    //   1275: aload_0
    //   1276: aconst_null
    //   1277: putfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1280: aconst_null
    //   1281: astore 16
    //   1283: aconst_null
    //   1284: astore 14
    //   1286: iload_2
    //   1287: istore_1
    //   1288: aload_0
    //   1289: aconst_null
    //   1290: invokevirtual 1663	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   1293: aload 14
    //   1295: astore 16
    //   1297: aload 15
    //   1299: astore 14
    //   1301: aload 16
    //   1303: astore 15
    //   1305: iload 5
    //   1307: istore_1
    //   1308: iload 11
    //   1310: istore 9
    //   1312: aload 17
    //   1314: astore 16
    //   1316: goto -1224 -> 92
    //   1319: astore 17
    //   1321: iload 10
    //   1323: istore 8
    //   1325: iload_1
    //   1326: istore 5
    //   1328: sipush -1026
    //   1331: iload_1
    //   1332: if_icmpeq +8 -> 1340
    //   1335: sipush -1000
    //   1338: istore 5
    //   1340: iload_2
    //   1341: iconst_1
    //   1342: iadd
    //   1343: istore_2
    //   1344: iload 5
    //   1346: istore_1
    //   1347: iload 11
    //   1349: istore 9
    //   1351: goto -1259 -> 92
    //   1354: new 416	java/lang/StringBuilder
    //   1357: dup
    //   1358: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1361: ldc_w 1665
    //   1364: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: iload_2
    //   1368: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1371: ldc_w 1531
    //   1374: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1377: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1380: new 416	java/lang/StringBuilder
    //   1383: dup
    //   1384: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1387: ldc 97
    //   1389: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: aload_0
    //   1393: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1396: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   1399: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1402: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1405: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1408: aload 15
    //   1410: ifnonnull +1569 -> 2979
    //   1413: ldc 97
    //   1415: astore 17
    //   1417: iconst_1
    //   1418: istore 4
    //   1420: iconst_1
    //   1421: istore 5
    //   1423: aload_0
    //   1424: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1427: ifnonnull +98 -> 1525
    //   1430: aload_0
    //   1431: iload_2
    //   1432: iload 11
    //   1434: invokevirtual 1533	oicq/wlogin_sdk/request/oicq_request:a	(IZ)Ljava/lang/String;
    //   1437: astore 17
    //   1439: new 416	java/lang/StringBuilder
    //   1442: dup
    //   1443: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1446: ldc_w 1667
    //   1449: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: aload 17
    //   1454: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: ldc_w 1669
    //   1460: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1466: new 416	java/lang/StringBuilder
    //   1469: dup
    //   1470: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1473: ldc 97
    //   1475: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: aload_0
    //   1479: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1482: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   1485: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1488: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1491: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1494: aload_0
    //   1495: aload_0
    //   1496: iload 11
    //   1498: invokevirtual 220	oicq/wlogin_sdk/request/oicq_request:c	(Z)I
    //   1501: putfield 139	oicq/wlogin_sdk/request/oicq_request:r	I
    //   1504: aload_0
    //   1505: aload 17
    //   1507: aload_0
    //   1508: getfield 139	oicq/wlogin_sdk/request/oicq_request:r	I
    //   1511: aload_0
    //   1512: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1515: getfield 641	oicq/wlogin_sdk/request/t:l	I
    //   1518: i2l
    //   1519: invokestatic 1619	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   1522: putfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1525: aload_0
    //   1526: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1529: ifnull +86 -> 1615
    //   1532: aload_0
    //   1533: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1536: invokevirtual 261	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1539: ifnonnull +76 -> 1615
    //   1542: aload_0
    //   1543: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1546: invokevirtual 261	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1549: ifnonnull +34 -> 1583
    //   1552: ldc_w 1671
    //   1555: new 416	java/lang/StringBuilder
    //   1558: dup
    //   1559: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1562: ldc 97
    //   1564: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: aload_0
    //   1568: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1571: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   1574: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1577: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1580: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1583: sipush -1007
    //   1586: istore_1
    //   1587: iload_2
    //   1588: iconst_1
    //   1589: iadd
    //   1590: istore_2
    //   1591: aload_0
    //   1592: aconst_null
    //   1593: putfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1596: aconst_null
    //   1597: astore 15
    //   1599: aload_0
    //   1600: aconst_null
    //   1601: invokevirtual 1663	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   1604: iload 5
    //   1606: istore 4
    //   1608: iload 11
    //   1610: istore 9
    //   1612: goto -1520 -> 92
    //   1615: aload_0
    //   1616: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1619: ifnull +21 -> 1640
    //   1622: aload 16
    //   1624: aload_0
    //   1625: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1628: invokevirtual 261	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1631: invokevirtual 267	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1634: invokevirtual 1623	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1637: ifeq +168 -> 1805
    //   1640: aload_0
    //   1641: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1644: ifnonnull +94 -> 1738
    //   1647: new 416	java/lang/StringBuilder
    //   1650: dup
    //   1651: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1654: ldc_w 1667
    //   1657: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1660: aload 17
    //   1662: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: ldc_w 1673
    //   1668: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1671: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1674: new 416	java/lang/StringBuilder
    //   1677: dup
    //   1678: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1681: ldc 97
    //   1683: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: aload_0
    //   1687: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1690: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   1693: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1696: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1699: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1702: sipush -1007
    //   1705: istore 4
    //   1707: iload_2
    //   1708: iconst_1
    //   1709: iadd
    //   1710: istore_2
    //   1711: aload_0
    //   1712: aconst_null
    //   1713: putfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1716: aconst_null
    //   1717: astore 15
    //   1719: aload_0
    //   1720: aconst_null
    //   1721: invokevirtual 1663	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   1724: iload 4
    //   1726: istore_1
    //   1727: iload 5
    //   1729: istore 4
    //   1731: iload 11
    //   1733: istore 9
    //   1735: goto -1643 -> 92
    //   1738: new 416	java/lang/StringBuilder
    //   1741: dup
    //   1742: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1745: ldc_w 1675
    //   1748: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1751: aload 16
    //   1753: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1756: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1759: new 416	java/lang/StringBuilder
    //   1762: dup
    //   1763: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1766: ldc 97
    //   1768: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1771: aload_0
    //   1772: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1775: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   1778: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1781: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1784: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1787: iload_1
    //   1788: istore 4
    //   1790: sipush -1026
    //   1793: iload_1
    //   1794: if_icmpeq -87 -> 1707
    //   1797: sipush -1000
    //   1800: istore 4
    //   1802: goto -95 -> 1707
    //   1805: aload_0
    //   1806: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1809: invokevirtual 261	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1812: invokevirtual 267	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1815: astore 16
    //   1817: new 416	java/lang/StringBuilder
    //   1820: dup
    //   1821: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1824: ldc_w 1667
    //   1827: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: aload 17
    //   1832: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1835: ldc_w 1677
    //   1838: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1841: aload_0
    //   1842: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1845: invokevirtual 1678	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   1848: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1851: ldc_w 1680
    //   1854: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1857: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1860: new 416	java/lang/StringBuilder
    //   1863: dup
    //   1864: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1867: ldc 97
    //   1869: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1872: aload_0
    //   1873: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1876: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   1879: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1882: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1885: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1888: aload 15
    //   1890: ifnonnull +1086 -> 2976
    //   1893: new 416	java/lang/StringBuilder
    //   1896: dup
    //   1897: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1900: ldc_w 1682
    //   1903: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1906: aload_0
    //   1907: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1910: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1913: ldc_w 1669
    //   1916: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1922: new 416	java/lang/StringBuilder
    //   1925: dup
    //   1926: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   1929: ldc 97
    //   1931: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1934: aload_0
    //   1935: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1938: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   1941: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1944: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1947: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1950: new 1658	java/net/Socket
    //   1953: dup
    //   1954: invokespecial 1683	java/net/Socket:<init>	()V
    //   1957: astore 15
    //   1959: aload_0
    //   1960: aload 15
    //   1962: invokevirtual 1663	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   1965: aload 15
    //   1967: aload_0
    //   1968: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1971: aload_0
    //   1972: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1975: getfield 641	oicq/wlogin_sdk/request/t:l	I
    //   1978: invokevirtual 1687	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   1981: aload 15
    //   1983: aload_0
    //   1984: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1987: getfield 641	oicq/wlogin_sdk/request/t:l	I
    //   1990: invokevirtual 1690	java/net/Socket:setSoTimeout	(I)V
    //   1993: aload 15
    //   1995: aload_0
    //   1996: getfield 141	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   1999: arraylength
    //   2000: invokevirtual 1693	java/net/Socket:setReceiveBufferSize	(I)V
    //   2003: new 416	java/lang/StringBuilder
    //   2006: dup
    //   2007: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   2010: ldc_w 1682
    //   2013: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2016: aload_0
    //   2017: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2020: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2023: ldc_w 1695
    //   2026: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2032: new 416	java/lang/StringBuilder
    //   2035: dup
    //   2036: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   2039: ldc 97
    //   2041: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2044: aload_0
    //   2045: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2048: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   2051: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2054: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2057: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2060: ldc_w 1697
    //   2063: new 416	java/lang/StringBuilder
    //   2066: dup
    //   2067: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   2070: ldc 97
    //   2072: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2075: aload_0
    //   2076: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2079: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   2082: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2085: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2088: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2091: aload 15
    //   2093: invokevirtual 1698	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   2096: astore 17
    //   2098: aload 17
    //   2100: aload 22
    //   2102: iconst_0
    //   2103: aload 22
    //   2105: arraylength
    //   2106: invokevirtual 1637	java/io/OutputStream:write	([BII)V
    //   2109: aload 17
    //   2111: invokevirtual 1640	java/io/OutputStream:flush	()V
    //   2114: aload 15
    //   2116: invokevirtual 1699	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   2119: astore 18
    //   2121: aload 14
    //   2123: astore 17
    //   2125: aload 15
    //   2127: astore 14
    //   2129: aload 17
    //   2131: astore 15
    //   2133: aload 16
    //   2135: astore 17
    //   2137: goto -995 -> 1142
    //   2140: astore 15
    //   2142: sipush -1026
    //   2145: istore_1
    //   2146: iload_2
    //   2147: iconst_1
    //   2148: iadd
    //   2149: istore_2
    //   2150: aload_0
    //   2151: aconst_null
    //   2152: putfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2155: aconst_null
    //   2156: astore 15
    //   2158: aload_0
    //   2159: aconst_null
    //   2160: invokevirtual 1663	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2163: iload 11
    //   2165: istore 9
    //   2167: goto -2075 -> 92
    //   2170: astore 15
    //   2172: iload_1
    //   2173: istore 5
    //   2175: sipush -1026
    //   2178: iload_1
    //   2179: if_icmpeq +8 -> 2187
    //   2182: sipush -1000
    //   2185: istore 5
    //   2187: iload_2
    //   2188: iconst_1
    //   2189: iadd
    //   2190: istore_2
    //   2191: aload_0
    //   2192: aconst_null
    //   2193: putfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2196: aconst_null
    //   2197: astore 15
    //   2199: aload_0
    //   2200: aconst_null
    //   2201: invokevirtual 1663	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2204: iload 5
    //   2206: istore_1
    //   2207: iload 11
    //   2209: istore 9
    //   2211: goto -2119 -> 92
    //   2214: iload 6
    //   2216: iload 5
    //   2218: iadd
    //   2219: istore 6
    //   2221: goto -1036 -> 1185
    //   2224: aload 14
    //   2226: astore 16
    //   2228: iload_2
    //   2229: istore_1
    //   2230: aload_0
    //   2231: aload_0
    //   2232: getfield 141	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2235: invokevirtual 1701	oicq/wlogin_sdk/request/oicq_request:b	([B)I
    //   2238: istore 6
    //   2240: iload 6
    //   2242: istore_1
    //   2243: aload 14
    //   2245: astore 16
    //   2247: iload_2
    //   2248: istore_3
    //   2249: iload_1
    //   2250: aload_0
    //   2251: getfield 115	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2254: iconst_1
    //   2255: iadd
    //   2256: if_icmpgt +58 -> 2314
    //   2259: iload_2
    //   2260: iconst_1
    //   2261: iadd
    //   2262: istore_2
    //   2263: aload 14
    //   2265: astore 16
    //   2267: iload 11
    //   2269: ifne +738 -> 3007
    //   2272: aload 14
    //   2274: astore 16
    //   2276: iload_2
    //   2277: istore_3
    //   2278: aload 14
    //   2280: invokevirtual 1661	java/net/Socket:close	()V
    //   2283: aload 14
    //   2285: astore 16
    //   2287: iload_2
    //   2288: istore_3
    //   2289: aload_0
    //   2290: aconst_null
    //   2291: putfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2294: aconst_null
    //   2295: astore 14
    //   2297: aconst_null
    //   2298: astore 16
    //   2300: iload_2
    //   2301: istore_3
    //   2302: aload_0
    //   2303: aconst_null
    //   2304: invokevirtual 1663	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2307: aload 14
    //   2309: astore 16
    //   2311: goto +696 -> 3007
    //   2314: aload 14
    //   2316: astore 16
    //   2318: iload_2
    //   2319: istore_3
    //   2320: iload_1
    //   2321: aload_0
    //   2322: getfield 141	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2325: arraylength
    //   2326: if_icmplt +58 -> 2384
    //   2329: iload_2
    //   2330: iconst_1
    //   2331: iadd
    //   2332: istore_2
    //   2333: aload 14
    //   2335: astore 16
    //   2337: iload 11
    //   2339: ifne +693 -> 3032
    //   2342: aload 14
    //   2344: astore 16
    //   2346: iload_2
    //   2347: istore_3
    //   2348: aload 14
    //   2350: invokevirtual 1661	java/net/Socket:close	()V
    //   2353: aload 14
    //   2355: astore 16
    //   2357: iload_2
    //   2358: istore_3
    //   2359: aload_0
    //   2360: aconst_null
    //   2361: putfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2364: aconst_null
    //   2365: astore 14
    //   2367: aconst_null
    //   2368: astore 16
    //   2370: iload_2
    //   2371: istore_3
    //   2372: aload_0
    //   2373: aconst_null
    //   2374: invokevirtual 1663	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2377: aload 14
    //   2379: astore 16
    //   2381: goto +651 -> 3032
    //   2384: aload 14
    //   2386: astore 16
    //   2388: iload_2
    //   2389: istore_3
    //   2390: aload_0
    //   2391: getfield 115	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2394: iconst_1
    //   2395: iadd
    //   2396: istore 7
    //   2398: iload_1
    //   2399: iload 7
    //   2401: isub
    //   2402: istore 6
    //   2404: iload 6
    //   2406: ifle +30 -> 2436
    //   2409: aload 14
    //   2411: astore 16
    //   2413: iload_2
    //   2414: istore_3
    //   2415: aload 18
    //   2417: aload_0
    //   2418: getfield 141	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2421: iload 7
    //   2423: iload 6
    //   2425: invokevirtual 1656	java/io/InputStream:read	([BII)I
    //   2428: istore 5
    //   2430: iload 5
    //   2432: iconst_m1
    //   2433: if_icmpne +86 -> 2519
    //   2436: iload 5
    //   2438: iconst_m1
    //   2439: if_icmpne +97 -> 2536
    //   2442: iload_2
    //   2443: iconst_1
    //   2444: iadd
    //   2445: istore_2
    //   2446: aload 14
    //   2448: astore 16
    //   2450: iload 11
    //   2452: ifne +42 -> 2494
    //   2455: aload 14
    //   2457: astore 16
    //   2459: iload_2
    //   2460: istore_3
    //   2461: aload 14
    //   2463: invokevirtual 1661	java/net/Socket:close	()V
    //   2466: aload 14
    //   2468: astore 16
    //   2470: iload_2
    //   2471: istore_3
    //   2472: aload_0
    //   2473: aconst_null
    //   2474: putfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2477: aconst_null
    //   2478: astore 16
    //   2480: aconst_null
    //   2481: astore 14
    //   2483: iload_2
    //   2484: istore_3
    //   2485: aload_0
    //   2486: aconst_null
    //   2487: invokevirtual 1663	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2490: aload 14
    //   2492: astore 16
    //   2494: aload 15
    //   2496: astore 14
    //   2498: iload_1
    //   2499: istore_3
    //   2500: sipush -1000
    //   2503: istore_1
    //   2504: aload 16
    //   2506: astore 15
    //   2508: iload 11
    //   2510: istore 9
    //   2512: aload 17
    //   2514: astore 16
    //   2516: goto -2424 -> 92
    //   2519: iload 7
    //   2521: iload 5
    //   2523: iadd
    //   2524: istore 7
    //   2526: iload 6
    //   2528: iload 5
    //   2530: isub
    //   2531: istore 6
    //   2533: goto -129 -> 2404
    //   2536: iload 5
    //   2538: istore_3
    //   2539: iload 11
    //   2541: istore 9
    //   2543: iload_1
    //   2544: istore 5
    //   2546: iload_3
    //   2547: istore_1
    //   2548: iload_2
    //   2549: bipush 6
    //   2551: if_icmplt +336 -> 2887
    //   2554: iload_1
    //   2555: istore_3
    //   2556: sipush -1026
    //   2559: iload_1
    //   2560: if_icmpeq +7 -> 2567
    //   2563: sipush -1000
    //   2566: istore_3
    //   2567: iload_3
    //   2568: ifne +13 -> 2581
    //   2571: aload_0
    //   2572: aload_0
    //   2573: getfield 141	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2576: iload 5
    //   2578: invokevirtual 681	oicq/wlogin_sdk/request/oicq_request:b	([BI)V
    //   2581: iload_3
    //   2582: ifne +171 -> 2753
    //   2585: aload_0
    //   2586: getfield 143	oicq/wlogin_sdk/request/oicq_request:t	I
    //   2589: sipush 2066
    //   2592: if_icmpeq +161 -> 2753
    //   2595: new 189	oicq/wlogin_sdk/report/report_t3
    //   2598: dup
    //   2599: invokespecial 190	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   2602: astore 14
    //   2604: aload 14
    //   2606: aload_0
    //   2607: getfield 143	oicq/wlogin_sdk/request/oicq_request:t	I
    //   2610: putfield 193	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   2613: aload 14
    //   2615: aload_0
    //   2616: getfield 145	oicq/wlogin_sdk/request/oicq_request:u	I
    //   2619: putfield 196	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   2622: aload 14
    //   2624: iload_3
    //   2625: putfield 199	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   2628: aload 14
    //   2630: invokestatic 205	java/lang/System:currentTimeMillis	()J
    //   2633: lload 12
    //   2635: lsub
    //   2636: l2i
    //   2637: putfield 208	oicq/wlogin_sdk/report/report_t3:_used	I
    //   2640: aload 14
    //   2642: iload_2
    //   2643: putfield 211	oicq/wlogin_sdk/report/report_t3:_try	I
    //   2646: aload 14
    //   2648: getstatic 101	oicq/wlogin_sdk/request/oicq_request:H	Ljava/lang/String;
    //   2651: putfield 214	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   2654: aload 14
    //   2656: getfield 214	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   2659: ifnonnull +10 -> 2669
    //   2662: aload 14
    //   2664: ldc 97
    //   2666: putfield 214	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   2669: aload_0
    //   2670: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2673: ifnonnull +219 -> 2892
    //   2676: aload 14
    //   2678: ldc 97
    //   2680: putfield 217	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   2683: aload 14
    //   2685: aload_0
    //   2686: getfield 139	oicq/wlogin_sdk/request/oicq_request:r	I
    //   2689: putfield 223	oicq/wlogin_sdk/report/report_t3:_port	I
    //   2692: aload 14
    //   2694: iload 4
    //   2696: putfield 226	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   2699: aload 14
    //   2701: getstatic 230	oicq/wlogin_sdk/request/t:D	I
    //   2704: putfield 233	oicq/wlogin_sdk/report/report_t3:_net	I
    //   2707: aload 14
    //   2709: ldc 97
    //   2711: putfield 236	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   2714: aload 14
    //   2716: aload 22
    //   2718: arraylength
    //   2719: putfield 239	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   2722: aload 14
    //   2724: iload 5
    //   2726: putfield 242	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   2729: iload 9
    //   2731: ifeq +188 -> 2919
    //   2734: iload 8
    //   2736: ifeq +174 -> 2910
    //   2739: aload 14
    //   2741: iconst_2
    //   2742: putfield 245	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   2745: getstatic 249	oicq/wlogin_sdk/request/t:an	Loicq/wlogin_sdk/report/Reporter;
    //   2748: aload 14
    //   2750: invokevirtual 255	oicq/wlogin_sdk/report/Reporter:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   2753: new 416	java/lang/StringBuilder
    //   2756: dup
    //   2757: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   2760: aload_0
    //   2761: invokevirtual 633	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2764: invokevirtual 638	java/lang/Class:getName	()Ljava/lang/String;
    //   2767: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2770: ldc_w 1703
    //   2773: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2776: iload_3
    //   2777: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2780: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2783: new 416	java/lang/StringBuilder
    //   2786: dup
    //   2787: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   2790: ldc 97
    //   2792: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2795: aload_0
    //   2796: getfield 278	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2799: getfield 437	oicq/wlogin_sdk/request/t:f	J
    //   2802: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2805: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2808: invokestatic 350	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2811: iload_3
    //   2812: ireturn
    //   2813: astore 14
    //   2815: iload_1
    //   2816: istore_2
    //   2817: iload_3
    //   2818: istore_1
    //   2819: iload_2
    //   2820: iconst_1
    //   2821: iadd
    //   2822: istore_2
    //   2823: aload 16
    //   2825: astore 14
    //   2827: iload 11
    //   2829: ifne +29 -> 2858
    //   2832: aload 16
    //   2834: invokevirtual 1706	java/net/Socket:isConnected	()Z
    //   2837: ifeq +8 -> 2845
    //   2840: aload 16
    //   2842: invokevirtual 1661	java/net/Socket:close	()V
    //   2845: aload_0
    //   2846: aconst_null
    //   2847: putfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2850: aconst_null
    //   2851: astore 14
    //   2853: aload_0
    //   2854: aconst_null
    //   2855: invokevirtual 1663	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2858: iload_1
    //   2859: istore_3
    //   2860: sipush -1000
    //   2863: istore_1
    //   2864: aload 14
    //   2866: astore 16
    //   2868: iload 11
    //   2870: istore 9
    //   2872: aload 15
    //   2874: astore 14
    //   2876: aload 16
    //   2878: astore 15
    //   2880: aload 17
    //   2882: astore 16
    //   2884: goto -2792 -> 92
    //   2887: iconst_0
    //   2888: istore_3
    //   2889: goto -322 -> 2567
    //   2892: aload 14
    //   2894: aload_0
    //   2895: getfield 137	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2898: invokevirtual 261	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   2901: invokevirtual 267	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2904: putfield 217	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   2907: goto -224 -> 2683
    //   2910: aload 14
    //   2912: iconst_1
    //   2913: putfield 245	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   2916: goto -171 -> 2745
    //   2919: aload 14
    //   2921: iconst_0
    //   2922: putfield 245	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   2925: goto -180 -> 2745
    //   2928: astore 14
    //   2930: goto -85 -> 2845
    //   2933: astore 14
    //   2935: iload_3
    //   2936: istore_2
    //   2937: goto -118 -> 2819
    //   2940: astore 18
    //   2942: goto -1417 -> 1525
    //   2945: astore 14
    //   2947: aload 18
    //   2949: astore 14
    //   2951: goto -1626 -> 1325
    //   2954: astore 17
    //   2956: iload 5
    //   2958: istore_1
    //   2959: goto -1634 -> 1325
    //   2962: astore 14
    //   2964: aload 19
    //   2966: astore 14
    //   2968: goto -2083 -> 885
    //   2971: astore 17
    //   2973: goto -2088 -> 885
    //   2976: goto -916 -> 2060
    //   2979: goto -1091 -> 1888
    //   2982: aload 21
    //   2984: astore 20
    //   2986: goto -2065 -> 921
    //   2989: aconst_null
    //   2990: astore 17
    //   2992: iconst_m1
    //   2993: istore 5
    //   2995: goto -2617 -> 378
    //   2998: iload_3
    //   2999: istore 5
    //   3001: goto -453 -> 2548
    //   3004: goto -2626 -> 378
    //   3007: aload 15
    //   3009: astore 14
    //   3011: iload_1
    //   3012: istore_3
    //   3013: sipush -1000
    //   3016: istore_1
    //   3017: aload 16
    //   3019: astore 15
    //   3021: iload 11
    //   3023: istore 9
    //   3025: aload 17
    //   3027: astore 16
    //   3029: goto -2937 -> 92
    //   3032: aload 15
    //   3034: astore 14
    //   3036: iload_1
    //   3037: istore_3
    //   3038: sipush -1000
    //   3041: istore_1
    //   3042: aload 16
    //   3044: astore 15
    //   3046: iload 11
    //   3048: istore 9
    //   3050: aload 17
    //   3052: astore 16
    //   3054: goto -2962 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3057	0	this	oicq_request
    //   63	2979	1	i1	int
    //   65	2872	2	i2	int
    //   61	2977	3	i3	int
    //   79	2616	4	i4	int
    //   267	2733	5	i5	int
    //   1183	1349	6	i6	int
    //   2396	129	7	i7	int
    //   76	2659	8	bool1	boolean
    //   73	2976	9	bool2	boolean
    //   228	1094	10	bool3	boolean
    //   114	2933	11	bool4	boolean
    //   90	2544	12	l1	long
    //   87	2662	14	localObject1	Object
    //   2813	1	14	localThrowable1	java.lang.Throwable
    //   2825	95	14	localObject2	Object
    //   2928	1	14	localException1	Exception
    //   2933	1	14	localThrowable2	java.lang.Throwable
    //   2945	1	14	localException2	Exception
    //   2949	1	14	localObject3	Object
    //   2962	1	14	localConnectException1	java.net.ConnectException
    //   2966	69	14	localObject4	Object
    //   70	2062	15	localObject5	Object
    //   2140	1	15	localConnectException2	java.net.ConnectException
    //   2156	1	15	localObject6	Object
    //   2170	1	15	localThrowable3	java.lang.Throwable
    //   2197	848	15	localObject7	Object
    //   83	2970	16	localObject8	Object
    //   254	581	17	localObject9	Object
    //   879	39	17	localConnectException3	java.net.ConnectException
    //   963	350	17	localObject10	Object
    //   1319	1	17	localException3	Exception
    //   1415	1466	17	localObject11	Object
    //   2954	1	17	localException4	Exception
    //   2971	1	17	localConnectException4	java.net.ConnectException
    //   2990	61	17	localObject12	Object
    //   902	1514	18	localObject13	Object
    //   2940	8	18	localException5	Exception
    //   906	2059	19	localObject14	Object
    //   915	2070	20	localObject15	Object
    //   220	2763	21	str	String
    //   58	2659	22	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   230	238	879	java/net/ConnectException
    //   251	256	879	java/net/ConnectException
    //   264	269	879	java/net/ConnectException
    //   282	290	879	java/net/ConnectException
    //   305	375	879	java/net/ConnectException
    //   391	438	879	java/net/ConnectException
    //   771	789	879	java/net/ConnectException
    //   797	804	879	java/net/ConnectException
    //   812	824	879	java/net/ConnectException
    //   832	842	879	java/net/ConnectException
    //   850	879	879	java/net/ConnectException
    //   230	238	1319	java/lang/Exception
    //   251	256	1319	java/lang/Exception
    //   264	269	1319	java/lang/Exception
    //   282	290	1319	java/lang/Exception
    //   305	375	1319	java/lang/Exception
    //   391	438	1319	java/lang/Exception
    //   771	789	1319	java/lang/Exception
    //   797	804	1319	java/lang/Exception
    //   812	824	1319	java/lang/Exception
    //   832	842	1319	java/lang/Exception
    //   850	879	1319	java/lang/Exception
    //   1893	2060	2140	java/net/ConnectException
    //   2060	2121	2140	java/net/ConnectException
    //   1893	2060	2170	java/lang/Throwable
    //   2060	2121	2170	java/lang/Throwable
    //   1148	1179	2813	java/lang/Throwable
    //   1191	1202	2813	java/lang/Throwable
    //   1208	1230	2813	java/lang/Throwable
    //   1264	1269	2813	java/lang/Throwable
    //   1275	1280	2813	java/lang/Throwable
    //   1288	1293	2813	java/lang/Throwable
    //   2230	2240	2813	java/lang/Throwable
    //   2832	2845	2928	java/lang/Exception
    //   2249	2259	2933	java/lang/Throwable
    //   2278	2283	2933	java/lang/Throwable
    //   2289	2294	2933	java/lang/Throwable
    //   2302	2307	2933	java/lang/Throwable
    //   2320	2329	2933	java/lang/Throwable
    //   2348	2353	2933	java/lang/Throwable
    //   2359	2364	2933	java/lang/Throwable
    //   2372	2377	2933	java/lang/Throwable
    //   2390	2398	2933	java/lang/Throwable
    //   2415	2430	2933	java/lang/Throwable
    //   2461	2466	2933	java/lang/Throwable
    //   2472	2477	2933	java/lang/Throwable
    //   2485	2490	2933	java/lang/Throwable
    //   1494	1525	2940	java/lang/Exception
    //   908	913	2945	java/lang/Exception
    //   929	965	2945	java/lang/Exception
    //   441	512	2954	java/lang/Exception
    //   515	525	2954	java/lang/Exception
    //   528	536	2954	java/lang/Exception
    //   544	554	2954	java/lang/Exception
    //   557	568	2954	java/lang/Exception
    //   571	582	2954	java/lang/Exception
    //   585	599	2954	java/lang/Exception
    //   602	614	2954	java/lang/Exception
    //   617	629	2954	java/lang/Exception
    //   632	638	2954	java/lang/Exception
    //   641	647	2954	java/lang/Exception
    //   650	681	2954	java/lang/Exception
    //   684	700	2954	java/lang/Exception
    //   703	734	2954	java/lang/Exception
    //   971	1002	2954	java/lang/Exception
    //   1005	1012	2954	java/lang/Exception
    //   1015	1026	2954	java/lang/Exception
    //   1029	1034	2954	java/lang/Exception
    //   1037	1043	2954	java/lang/Exception
    //   1046	1094	2954	java/lang/Exception
    //   1119	1126	2954	java/lang/Exception
    //   908	913	2962	java/net/ConnectException
    //   929	965	2962	java/net/ConnectException
    //   441	512	2971	java/net/ConnectException
    //   515	525	2971	java/net/ConnectException
    //   528	536	2971	java/net/ConnectException
    //   544	554	2971	java/net/ConnectException
    //   557	568	2971	java/net/ConnectException
    //   571	582	2971	java/net/ConnectException
    //   585	599	2971	java/net/ConnectException
    //   602	614	2971	java/net/ConnectException
    //   617	629	2971	java/net/ConnectException
    //   632	638	2971	java/net/ConnectException
    //   641	647	2971	java/net/ConnectException
    //   650	681	2971	java/net/ConnectException
    //   684	700	2971	java/net/ConnectException
    //   703	734	2971	java/net/ConnectException
    //   971	1002	2971	java/net/ConnectException
    //   1005	1012	2971	java/net/ConnectException
    //   1015	1026	2971	java/net/ConnectException
    //   1029	1034	2971	java/net/ConnectException
    //   1037	1043	2971	java/net/ConnectException
    //   1046	1094	2971	java/net/ConnectException
    //   1119	1126	2971	java/net/ConnectException
  }
  
  public int f()
  {
    return t.b(this.x.h)._last_flowid;
  }
  
  public void g()
  {
    this.z = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.oicq_request
 * JD-Core Version:    0.7.0.1
 */