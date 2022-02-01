package oicq.wlogin_sdk.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import oicq.wlogin_sdk.pow.b;
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
import oicq.wlogin_sdk.tlv_type.tlv_t17f;
import oicq.wlogin_sdk.tlv_type.tlv_t182;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import oicq.wlogin_sdk.tlv_type.tlv_t186;
import oicq.wlogin_sdk.tlv_type.tlv_t192;
import oicq.wlogin_sdk.tlv_type.tlv_t196;
import oicq.wlogin_sdk.tlv_type.tlv_t199;
import oicq.wlogin_sdk.tlv_type.tlv_t200;
import oicq.wlogin_sdk.tlv_type.tlv_t204;
import oicq.wlogin_sdk.tlv_type.tlv_t305;
import oicq.wlogin_sdk.tlv_type.tlv_t322;
import oicq.wlogin_sdk.tlv_type.tlv_t402;
import oicq.wlogin_sdk.tlv_type.tlv_t403;
import oicq.wlogin_sdk.tlv_type.tlv_t508;
import oicq.wlogin_sdk.tlv_type.tlv_t52b;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tlv_type.tlv_t546;
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
  static String[] E = { "240e:e1:a900:50::10", "2408:8711:10:10::10", "240e:928:1400:10::1b" };
  static String[] F = { "sslv6.wlogin.qq.com" };
  static int H = 0;
  static String I = "";
  static String J = "";
  protected byte[] A = new byte[0];
  protected byte[] B = new byte[0];
  int G = 0;
  public Context a;
  int b = 8192;
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
  public u x;
  protected EncryptionMethod y = EncryptionMethod.EM_ECDH;
  protected boolean z = false;
  
  private void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i1;
    if (!this.z) {
      i1 = 7;
    } else {
      i1 = 135;
    }
    a(paramInt1, paramInt2, paramLong, i1, paramInt3, paramInt4, paramInt5, paramInt6);
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
    localreport_t3._host = J;
    if (localreport_t3._host == null) {
      localreport_t3._host = "";
    }
    InetSocketAddress localInetSocketAddress = this.q;
    if (localInetSocketAddress == null) {
      localreport_t3._ip = "";
    } else {
      localreport_t3._ip = localInetSocketAddress.getAddress().getHostAddress();
    }
    localreport_t3._port = e(paramBoolean1);
    localreport_t3._conn = paramInt2;
    localreport_t3._net = u.E;
    localreport_t3._str = "";
    localreport_t3._slen = 0;
    localreport_t3._rlen = 0;
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        localreport_t3._wap = 2;
      } else {
        localreport_t3._wap = 1;
      }
    }
    else {
      localreport_t3._wap = 0;
    }
    u.at.add_t3(localreport_t3);
  }
  
  public static void a(int paramInt, String paramString)
  {
    H = paramInt;
    I = paramString;
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
    u.b(this.x.h)._last_flowid = paramInt;
    return paramInt;
  }
  
  public int a(String paramString, boolean paramBoolean, WUserSigInfo paramWUserSigInfo)
  {
    int i1;
    if (this.x.e()) {
      i1 = b(paramString, paramBoolean, paramWUserSigInfo);
    } else {
      i1 = e();
    }
    if (i1 == -1000)
    {
      paramString = new ErrMsg();
      paramString.setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_4));
      a(paramString);
    }
    return i1;
  }
  
  public int a(tlv_t161 paramtlv_t161)
  {
    tlv_t173 localtlv_t173 = new tlv_t173();
    tlv_t172 localtlv_t172 = new tlv_t172();
    tlv_t17f localtlv_t17f = new tlv_t17f();
    paramtlv_t161 = paramtlv_t161.get_data();
    int i1 = paramtlv_t161.length;
    if (localtlv_t17f.get_tlv(paramtlv_t161, 2, i1) > 0) {
      a(localtlv_t17f);
    }
    if (localtlv_t173.get_tlv(paramtlv_t161, 2, i1) > 0) {
      a(localtlv_t173);
    }
    if (localtlv_t172.get_tlv(paramtlv_t161, 2, i1) > 0)
    {
      paramtlv_t161 = this.x;
      paramtlv_t161.m = 1;
      paramtlv_t161.s = localtlv_t172.get_data();
      util.LOGI("get rollback sig", "");
    }
    return 0;
  }
  
  public int a(tlv_t173 paramtlv_t173)
  {
    paramtlv_t173 = paramtlv_t173.get_data();
    if ((paramtlv_t173 != null) && (paramtlv_t173.length > 2))
    {
      int i3 = util.buf_to_int8(paramtlv_t173, 1);
      int i1 = 0;
      int i2 = 2;
      while (i1 < i3)
      {
        int i4 = paramtlv_t173.length;
        int i5 = i2 + 1;
        if (i4 < i5) {
          break;
        }
        i4 = util.buf_to_int8(paramtlv_t173, i2);
        int i6 = paramtlv_t173.length;
        i2 = i5 + 2;
        if (i6 < i2) {
          break;
        }
        i6 = util.buf_to_int16(paramtlv_t173, i5);
        int i7 = paramtlv_t173.length;
        i5 = i2 + i6;
        if (i7 < i5) {
          break;
        }
        byte[] arrayOfByte = new byte[i6];
        System.arraycopy(paramtlv_t173, i2, arrayOfByte, 0, i6);
        i6 = paramtlv_t173.length;
        i2 = i5 + 2;
        if (i6 < i2) {
          break;
        }
        b(i4, arrayOfByte, util.buf_to_int16(paramtlv_t173, i5));
        i1 += 1;
      }
    }
    return 0;
  }
  
  public int a(tlv_t17f paramtlv_t17f)
  {
    paramtlv_t17f = paramtlv_t17f.get_data();
    if ((paramtlv_t17f != null) && (paramtlv_t17f.length > 2))
    {
      int i3 = util.buf_to_int8(paramtlv_t17f, 1);
      int i1 = 0;
      int i2 = 2;
      while (i1 < i3)
      {
        int i4 = paramtlv_t17f.length;
        int i5 = i2 + 1;
        if (i4 < i5) {
          break;
        }
        i4 = util.buf_to_int8(paramtlv_t17f, i2);
        int i6 = paramtlv_t17f.length;
        i2 = i5 + 2;
        if (i6 < i2) {
          break;
        }
        i6 = util.buf_to_int16(paramtlv_t17f, i5);
        int i7 = paramtlv_t17f.length;
        i5 = i2 + i6;
        if (i7 < i5) {
          break;
        }
        byte[] arrayOfByte = new byte[i6];
        System.arraycopy(paramtlv_t17f, i2, arrayOfByte, 0, i6);
        i6 = paramtlv_t17f.length;
        i2 = i5 + 2;
        if (i6 < i2) {
          break;
        }
        a(i4, arrayOfByte, util.buf_to_int16(paramtlv_t17f, i5));
        i1 += 1;
      }
    }
    return 0;
  }
  
  public int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = cryptor.decrypt(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2);
    if (paramArrayOfByte1 == null) {
      return -1002;
    }
    this.g = paramArrayOfByte1.length;
    paramInt2 = paramArrayOfByte1.length;
    int i1 = this.f;
    if (paramInt2 + i1 + 2 > this.b)
    {
      this.b = (paramArrayOfByte1.length + i1 + 2);
      paramArrayOfByte2 = new byte[this.b];
      System.arraycopy(this.h, 0, paramArrayOfByte2, 0, this.c);
      this.h = paramArrayOfByte2;
    }
    System.arraycopy(paramArrayOfByte1, 0, this.h, paramInt1, paramArrayOfByte1.length);
    this.c = (this.f + 2 + paramArrayOfByte1.length);
    return 0;
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    String str1 = "";
    int i1 = paramInt / 2;
    String str2;
    if (H != 0)
    {
      str2 = I;
      if ((str2 != null) && (str2.length() > 0))
      {
        str2 = I;
        break label346;
      }
    }
    if (i1 <= 0)
    {
      if (paramBoolean)
      {
        if (u.E == 1)
        {
          if (paramInt == 0) {
            str1 = new String(util.get_wap_server_ipv6_host1(u.u));
          }
          if (TextUtils.isEmpty(str1))
          {
            str1 = new String(util.get_wap_server_host1(u.u));
            break label272;
          }
          break label272;
        }
        if (u.E == 2)
        {
          if (paramInt == 0) {
            str1 = new String(util.get_wap_server_ipv6_host2(u.u));
          }
          if (TextUtils.isEmpty(str1))
          {
            str1 = new String(util.get_wap_server_host2(u.u));
            break label272;
          }
          break label272;
        }
      }
      else
      {
        if (u.E == 1)
        {
          if (paramInt == 0) {
            str1 = new String(util.get_server_ipv6_host1(u.u));
          }
          if (TextUtils.isEmpty(str1))
          {
            str1 = new String(util.get_server_host1(u.u));
            break label272;
          }
          break label272;
        }
        if (u.E == 2)
        {
          if (paramInt == 0) {
            str1 = new String(util.get_server_ipv6_host2(u.u));
          }
          if (TextUtils.isEmpty(str1))
          {
            str1 = new String(util.get_server_host2(u.u));
            break label272;
          }
          break label272;
        }
      }
      str1 = "";
      label272:
      str2 = str1;
      if (str1.length() <= 0) {
        str2 = c(paramBoolean);
      }
    }
    else if (i1 < 2)
    {
      str2 = c(paramBoolean);
    }
    else if (i1 < 3)
    {
      str2 = d(paramBoolean);
    }
    else if (i1 < 4)
    {
      str2 = b(paramBoolean);
    }
    else
    {
      str2 = a(paramBoolean);
    }
    label346:
    J = str2;
    return str2;
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
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return;
      }
      if (paramInt1 == 1)
      {
        if (u.E == 1) {
          util.set_server_ipv6_host1(u.u, paramArrayOfByte);
        } else if (u.E == 2) {
          util.set_server_ipv6_host2(u.u, paramArrayOfByte);
        }
      }
      else if (paramInt1 == 2) {
        if (u.E == 1) {
          util.set_wap_server_ipv6_host1(u.u, paramArrayOfByte);
        } else if (u.E == 2) {
          util.set_wap_server_ipv6_host2(u.u, paramArrayOfByte);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder("ipv6 net type:");
      localStringBuilder.append(u.E);
      localStringBuilder.append(" type:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" host:");
      localStringBuilder.append(new String(paramArrayOfByte));
      localStringBuilder.append(" port:");
      localStringBuilder.append(paramInt2);
      paramArrayOfByte = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.x.f);
      util.LOGI(paramArrayOfByte, localStringBuilder.toString());
      return;
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    a(this.i, this.t, paramLong, this.m, u.x, this.p, paramArrayOfByte);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte, EncryptionMethod paramEncryptionMethod)
  {
    if (paramEncryptionMethod == EncryptionMethod.EM_ST)
    {
      b(paramLong, paramArrayOfByte);
      return;
    }
    if (paramEncryptionMethod == EncryptionMethod.EM_ECDH)
    {
      a(paramLong, paramArrayOfByte);
      return;
    }
    util.LOGI("getRequestEncrptedPackage unknown encryption method ".concat(String.valueOf(paramEncryptionMethod)), String.valueOf(paramLong));
  }
  
  public void a(Socket paramSocket)
  {
    this.x.ap = paramSocket;
  }
  
  public void a(WloginSigInfo paramWloginSigInfo)
  {
    if (true == paramWloginSigInfo.isWtSessionTicketExpired()) {
      return;
    }
    if ((paramWloginSigInfo.wtSessionTicket != null) && (paramWloginSigInfo.wtSessionTicketKey != null))
    {
      this.A = ((byte[])paramWloginSigInfo.wtSessionTicket.clone());
      this.B = ((byte[])paramWloginSigInfo.wtSessionTicketKey.clone());
    }
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
        new f(u.u, localErrMsg).start();
      }
      return;
    }
    catch (Exception paramtlv_t149) {}
  }
  
  public void a(ErrMsg paramErrMsg)
  {
    async_context localasync_context = u.b(this.x.h);
    localasync_context._last_err_msg = new ErrMsg(0, 0, "", "", "");
    if (paramErrMsg != null) {}
    try
    {
      localasync_context._last_err_msg = ((ErrMsg)paramErrMsg.clone());
      return;
    }
    catch (CloneNotSupportedException paramErrMsg)
    {
      label46:
      break label46;
    }
    localasync_context._last_err_msg = new ErrMsg(0, 0, "", "", "");
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = this.c;
    if (paramInt + i1 + 1 > this.b)
    {
      this.b = (paramInt + i1 + 1 + 128);
      byte[] arrayOfByte = new byte[this.b];
      System.arraycopy(this.h, 0, arrayOfByte, 0, i1);
      this.h = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.h, this.c, paramInt);
    this.c += paramInt;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, tlv_t178 paramtlv_t178, tlv_t179 paramtlv_t179, tlv_t17d paramtlv_t17d, async_context paramasync_context)
  {
    StringBuffer localStringBuffer = new StringBuffer("handleDevlockInfo");
    int i1 = paramtlv_t178.get_tlv(paramArrayOfByte, paramInt, this.c - paramInt - 1);
    localStringBuffer.append(",t178 = ");
    localStringBuffer.append(i1);
    if (i1 >= 0)
    {
      paramasync_context._devlock_info.CountryCode = new String(paramtlv_t178.get_country_code());
      paramasync_context._devlock_info.Mobile = new String(paramtlv_t178.get_mobile());
      paramasync_context._devlock_info.MbItemSmsCodeStatus = paramtlv_t178.get_smscode_status();
      paramasync_context._devlock_info.AvailableMsgCount = paramtlv_t178.get_available_msg_cnt();
      paramasync_context._devlock_info.TimeLimit = paramtlv_t178.get_time_limit();
    }
    paramtlv_t178 = new tlv_t196();
    i1 = paramtlv_t178.get_tlv(paramArrayOfByte, paramInt, this.c - paramInt - 1);
    localStringBuffer.append(",t196 = ");
    localStringBuffer.append(i1);
    if (i1 >= 0)
    {
      paramasync_context._devlock_info.BakCountryCode = paramtlv_t178.getCountryCode();
      paramasync_context._devlock_info.BakMobile = paramtlv_t178.getBakMobile();
      paramasync_context._devlock_info.BakMobileState = paramtlv_t178.getBakMobileState();
    }
    paramtlv_t178 = new tlv_t204();
    i1 = paramtlv_t178.get_tlv(paramArrayOfByte, paramInt, this.c - paramInt - 1);
    localStringBuffer.append(",t204 = ");
    localStringBuffer.append(i1);
    if (i1 > 0) {
      paramasync_context._devlock_info.OtherDevLockVerifyUrl = new String(paramtlv_t178.get_data());
    }
    i1 = paramtlv_t179.get_tlv(paramArrayOfByte, paramInt, this.c - paramInt - 1);
    localStringBuffer.append(",t179 = ");
    localStringBuffer.append(i1);
    if (i1 >= 0) {
      paramasync_context._devlock_info.UnionVerifyUrl = new String(paramtlv_t179.get_verify_url());
    }
    paramInt = paramtlv_t17d.get_tlv(paramArrayOfByte, paramInt, this.c - paramInt - 1);
    localStringBuffer.append(",t17d = ");
    localStringBuffer.append(paramInt);
    if (paramInt >= 0)
    {
      paramasync_context._devlock_info.MbGuideType = paramtlv_t17d.get_mb_guide_type();
      paramasync_context._devlock_info.MbGuideMsg = new String(paramtlv_t17d.get_mb_guide_msg());
      paramasync_context._devlock_info.MbGuideInfoType = paramtlv_t17d.get_mb_guide_info_type();
      paramasync_context._devlock_info.MbGuideInfo = new String(paramtlv_t17d.get_mb_guide_info());
    }
    util.LOGI(localStringBuffer.toString(), "");
  }
  
  public byte[] a(tlv_t169 paramtlv_t169)
  {
    Object localObject4 = new tlv_t106();
    Object localObject3 = new tlv_t10c();
    Object localObject2 = new tlv_t16a();
    Object localObject1 = new tlv_t145();
    paramtlv_t169 = paramtlv_t169.get_data();
    int i1 = paramtlv_t169.length;
    if (((tlv_t106)localObject4).get_tlv(paramtlv_t169, 2, i1) < 0) {
      return null;
    }
    if (((tlv_t10c)localObject3).get_tlv(paramtlv_t169, 2, i1) < 0) {
      return null;
    }
    if (((tlv_t16a)localObject2).get_tlv(paramtlv_t169, 2, i1) < 0) {
      return null;
    }
    paramtlv_t169 = ((tlv_t106)localObject4).get_buf();
    localObject3 = ((tlv_t10c)localObject3).get_buf();
    localObject2 = ((tlv_t16a)localObject2).get_buf();
    localObject1 = ((tlv_t145)localObject1).get_tlv_145(u.B);
    localObject4 = new byte[paramtlv_t169.length + 3 + localObject3.length + localObject2.length + localObject1.length];
    localObject4[0] = 64;
    util.int16_to_buf((byte[])localObject4, 1, 4);
    System.arraycopy(paramtlv_t169, 0, localObject4, 3, paramtlv_t169.length);
    i1 = paramtlv_t169.length + 3;
    System.arraycopy(localObject3, 0, localObject4, i1, localObject3.length);
    i1 += localObject3.length;
    System.arraycopy(localObject2, 0, localObject4, i1, localObject2.length);
    System.arraycopy(localObject1, 0, localObject4, i1 + localObject2.length, localObject1.length);
    return localObject4;
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    if (this.x.m == 0) {
      return a(paramArrayOfByte, this.x.c, this.x.n, this.x.p, this.x.r);
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
  
  protected byte[] a(byte[] paramArrayOfByte1, EncryptionMethod paramEncryptionMethod, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (EncryptionMethod.EM_ST == paramEncryptionMethod) {
      return b(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
    }
    if (EncryptionMethod.EM_ECDH == paramEncryptionMethod) {
      return a(paramArrayOfByte1);
    }
    util.LOGI("encryptBody unknown encryption method ".concat(String.valueOf(paramEncryptionMethod)), "");
    return null;
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      if (this.x.m == 2) {
        i1 = 3;
      } else {
        i1 = 2;
      }
      paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
      byte[] arrayOfByte = new byte[paramArrayOfByte2.length + 2 + 2 + 2 + paramArrayOfByte1.length];
      util.int8_to_buf(arrayOfByte, 0, 1);
      util.int8_to_buf(arrayOfByte, 1, i1);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 2, paramArrayOfByte2.length);
      int i1 = paramArrayOfByte2.length + 2;
      util.int16_to_buf(arrayOfByte, i1, 258);
      i1 += 2;
      util.int16_to_buf(arrayOfByte, i1, 0);
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, i1 + 2, paramArrayOfByte1.length);
      return arrayOfByte;
    }
    return new byte[0];
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte3);
    paramArrayOfByte3 = new byte[paramArrayOfByte2.length + 2 + paramArrayOfByte1.length];
    util.int16_to_buf(paramArrayOfByte3, 0, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, 2, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, paramArrayOfByte2.length + 2, paramArrayOfByte1.length);
    return paramArrayOfByte3;
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null) && (paramArrayOfByte4 != null)) {
      try
      {
        paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte4);
        paramArrayOfByte4 = new byte[paramArrayOfByte2.length + 2 + 2 + 2 + 2 + paramArrayOfByte3.length + paramArrayOfByte1.length];
        util.int8_to_buf(paramArrayOfByte4, 0, 2);
        util.int8_to_buf(paramArrayOfByte4, 1, 1);
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte4, 2, paramArrayOfByte2.length);
        int i1 = paramArrayOfByte2.length + 2;
        util.int16_to_buf(paramArrayOfByte4, i1, 305);
        i1 += 2;
        util.int16_to_buf(paramArrayOfByte4, i1, paramInt);
        paramInt = i1 + 2;
        util.int16_to_buf(paramArrayOfByte4, paramInt, paramArrayOfByte3.length);
        paramInt += 2;
        System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte4, paramInt, paramArrayOfByte3.length);
        System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte4, paramInt + paramArrayOfByte3.length, paramArrayOfByte1.length);
        return paramArrayOfByte4;
      }
      catch (Throwable paramArrayOfByte1)
      {
        util.printThrowable(paramArrayOfByte1, "ecdh_encrypt_body");
        return new byte[0];
      }
    }
    return new byte[0];
  }
  
  public int b()
  {
    int i1 = this.c;
    int i2 = this.f;
    if (i1 <= i2 + 2) {
      return -1009;
    }
    this.g = (i1 - i2 - 2);
    i2 = util.buf_to_int16(this.h, 13);
    Object localObject1 = new StringBuilder("enrypt method ");
    ((StringBuilder)localObject1).append(this.y);
    ((StringBuilder)localObject1).append(" rsp flag ");
    ((StringBuilder)localObject1).append(i2);
    util.LOGI(((StringBuilder)localObject1).toString(), "");
    localObject1 = this.y;
    Object localObject2 = EncryptionMethod.EM_ECDH;
    i1 = 0;
    if ((localObject1 == localObject2) && (i2 == 0))
    {
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
      else
      {
        i2 = a(this.h, this.f + 1, this.g, this.x.c);
        i1 = i2;
        if (i2 < 0)
        {
          util.LOGI("use kc decrypt_body failed", "");
          i1 = i2;
        }
      }
    }
    else if ((this.y == EncryptionMethod.EM_ST) && (3 == i2))
    {
      i2 = a(this.h, this.f + 1, this.g, this.B);
      i1 = i2;
      if (i2 < 0)
      {
        u.at.attr_api(2494911);
        localObject1 = u.b(this.x.h);
        if (localObject1 != null)
        {
          localObject2 = this.x;
          ((u)localObject2).c(((u)localObject2).f, ((async_context)localObject1)._sappid);
        }
        util.LOGI("use session key decrypt_body failed", "");
        i1 = -1025;
      }
    }
    else if ((this.y == EncryptionMethod.EM_ECDH) && (true == this.z) && (4 == i2))
    {
      localObject1 = cryptor.decrypt(this.h, this.f + 1, this.g, this.x.p);
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.x.f);
        util.LOGI("decrypted outer body failed", ((StringBuilder)localObject1).toString());
        return -1002;
      }
      i2 = util.buf_to_int16((byte[])localObject1, 0);
      if (i2 > localObject1.length - 2)
      {
        localObject1 = "peer public key len wrong ".concat(String.valueOf(i2));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.x.f);
        util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
        return -1009;
      }
      localObject2 = new byte[i2];
      System.arraycopy(localObject1, 2, localObject2, 0, i2);
      localObject2 = new EcdhCrypt(this.a).calShareKeyMd5ByPeerPublicKey((byte[])localObject2);
      if (localObject2 != null)
      {
        if (localObject2.length == 0) {
          return -1002;
        }
        localObject1 = cryptor.decrypt((byte[])localObject1, i2 + 2, localObject1.length - 2 - i2, (byte[])localObject2);
        if (localObject1 == null)
        {
          u.at.attr_api(2461266);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.x.f);
          util.LOGI("use share key md5 decrypt failed", ((StringBuilder)localObject1).toString());
          return -1002;
        }
        localObject2 = this.h;
        i2 = localObject2.length;
        int i3 = this.f;
        if (i2 < i3 + 2 + localObject1.length)
        {
          this.b = (i3 + 2 + localObject1.length);
          byte[] arrayOfByte = new byte[this.b];
          System.arraycopy(localObject2, 0, arrayOfByte, 0, i3 + 1);
          this.h = arrayOfByte;
        }
        System.arraycopy(localObject1, 0, this.h, this.f + 1, localObject1.length);
        this.c = (this.f + 2 + localObject1.length);
      }
      else
      {
        return -1002;
      }
    }
    else
    {
      localObject1 = new StringBuilder("unknown encryption method ");
      ((StringBuilder)localObject1).append(this.y);
      util.LOGI(((StringBuilder)localObject1).toString(), "");
      i1 = -1024;
    }
    if (i1 < 0) {
      return i1;
    }
    return d(this.h, this.f + 1, this.g);
  }
  
  public int b(String paramString, boolean paramBoolean, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getClass().getName());
    ((StringBuilder)localObject1).append(":snd_rcv_req_msf ...");
    localObject1 = ((StringBuilder)localObject1).toString();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(this.x.f);
    util.LOGI((String)localObject1, localStringBuilder1.toString());
    int i2 = this.x.l;
    byte[] arrayOfByte = c();
    long l1 = System.currentTimeMillis();
    int i1 = -1000;
    localStringBuilder1 = null;
    localObject1 = localStringBuilder1;
    try
    {
      Object localObject2 = new StringBuilder("WtloginMsfListener uin:");
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(" service_cmd:");
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(this.v);
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(" timeout:");
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(i2);
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(" flag:");
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(paramBoolean);
      localObject1 = localStringBuilder1;
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localStringBuilder1;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localObject1 = localStringBuilder1;
      localStringBuilder2.append(this.x.f);
      localObject1 = localStringBuilder1;
      util.LOGI((String)localObject2, localStringBuilder2.toString());
      localObject1 = localStringBuilder1;
      paramWUserSigInfo = new WtloginMsfListener(paramString, this.v, arrayOfByte, i2, paramBoolean, paramWUserSigInfo);
      localObject1 = localStringBuilder1;
      paramString = new Thread(paramWUserSigInfo, "Wtlogin_msf");
      localObject1 = localStringBuilder1;
      paramString.start();
      localObject1 = localStringBuilder1;
      paramString.join(i2);
      localObject1 = localStringBuilder1;
      paramString = paramWUserSigInfo.getRetData();
      if (paramString == null)
      {
        localObject1 = paramString;
        localStringBuilder1 = new StringBuilder("recv data from server failed, ret=");
        localObject1 = paramString;
        localStringBuilder1.append(paramWUserSigInfo.getRet());
        localObject1 = paramString;
        paramWUserSigInfo = localStringBuilder1.toString();
        localObject1 = paramString;
        localStringBuilder1 = new StringBuilder();
        localObject1 = paramString;
        localStringBuilder1.append(this.x.f);
        localObject1 = paramString;
        util.LOGI(paramWUserSigInfo, localStringBuilder1.toString());
      }
      else
      {
        localObject1 = paramString;
        b(paramString, paramString.length);
        i1 = 0;
      }
    }
    catch (Exception paramString)
    {
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append(this.x.f);
      util.printException(paramString, paramWUserSigInfo.toString());
      paramString = (String)localObject1;
    }
    if (this.t != 2066)
    {
      paramWUserSigInfo = new report_t3();
      paramWUserSigInfo._cmd = this.t;
      paramWUserSigInfo._sub = this.u;
      paramWUserSigInfo._rst2 = i1;
      paramWUserSigInfo._used = ((int)(System.currentTimeMillis() - l1));
      paramWUserSigInfo._try = 0;
      paramWUserSigInfo._host = "";
      paramWUserSigInfo._ip = "";
      paramWUserSigInfo._port = 0;
      paramWUserSigInfo._conn = 0;
      paramWUserSigInfo._net = 0;
      paramWUserSigInfo._str = "";
      if (i1 == 0)
      {
        paramWUserSigInfo._slen = arrayOfByte.length;
        paramWUserSigInfo._rlen = paramString.length;
      }
      else
      {
        paramWUserSigInfo._slen = 0;
        paramWUserSigInfo._rlen = 0;
      }
      paramWUserSigInfo._wap = 3;
      u.at.add_t3(paramWUserSigInfo);
    }
    paramString = new StringBuilder();
    paramString.append(getClass().getName());
    paramString.append(":snd_rcv_req_msf ret=");
    paramString.append(i1);
    paramString = paramString.toString();
    paramWUserSigInfo = new StringBuilder();
    paramWUserSigInfo.append(this.x.f);
    util.LOGI(paramString, paramWUserSigInfo.toString());
    return i1;
  }
  
  public int b(byte[] paramArrayOfByte)
  {
    return util.buf_to_int16(paramArrayOfByte, 1);
  }
  
  public String b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return E[((int)(java.lang.Math.random() * 2147483647.0D) % E.length)];
    }
    return F[((int)(java.lang.Math.random() * 2147483647.0D) % F.length)];
  }
  
  void b(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return;
      }
      if (paramInt1 == 1)
      {
        if (u.E == 1) {
          util.set_server_host1(u.u, paramArrayOfByte);
        } else if (u.E == 2) {
          util.set_server_host2(u.u, paramArrayOfByte);
        }
      }
      else if (paramInt1 == 2) {
        if (u.E == 1) {
          util.set_wap_server_host1(u.u, paramArrayOfByte);
        } else if (u.E == 2) {
          util.set_wap_server_host2(u.u, paramArrayOfByte);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder("net type:");
      localStringBuilder.append(u.E);
      localStringBuilder.append(" type:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" host:");
      localStringBuilder.append(new String(paramArrayOfByte));
      localStringBuilder.append(" port:");
      localStringBuilder.append(paramInt2);
      paramArrayOfByte = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.x.f);
      util.LOGI(paramArrayOfByte, localStringBuilder.toString());
      return;
    }
  }
  
  public void b(long paramLong, byte[] paramArrayOfByte)
  {
    b(this.i, this.t, paramLong, this.m, u.x, this.p, paramArrayOfByte);
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
      return a(arrayOfByte, this.x.c, this.x.n, this.x.p, this.x.r);
    }
    return a(arrayOfByte, this.x.c);
  }
  
  protected byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
  }
  
  public int c(byte[] paramArrayOfByte, int paramInt)
  {
    this.w = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public String c(boolean paramBoolean)
  {
    String[] arrayOfString = new String[2];
    if (paramBoolean)
    {
      arrayOfString[0] = "wlogin.qq.com";
      arrayOfString[1] = "wlogin1.qq.com";
    }
    else
    {
      arrayOfString[0] = "wtlogin.qq.com";
      arrayOfString[1] = "wtlogin1.qq.com";
    }
    return arrayOfString[java.lang.Math.abs(new java.util.Random().nextInt() % 2)];
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    tlv_t146 localtlv_t146 = new tlv_t146();
    paramInt1 = localtlv_t146.get_tlv(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = u.b(this.x.h);
    if (paramInt1 >= 0)
    {
      paramArrayOfByte._last_err_msg.setVersion(localtlv_t146.get_ver());
      paramArrayOfByte._last_err_msg.setTitle(new String(localtlv_t146.get_title()));
      paramArrayOfByte._last_err_msg.setMessage(new String(localtlv_t146.get_msg()));
      paramArrayOfByte._last_err_msg.setType(localtlv_t146.get_type());
      paramArrayOfByte._last_err_msg.setOtherinfo(new String(localtlv_t146.get_errorinfo()));
    }
  }
  
  public byte[] c()
  {
    int i1 = this.c;
    byte[] arrayOfByte = new byte[i1];
    System.arraycopy(this.h, 0, arrayOfByte, 0, i1);
    return arrayOfByte;
  }
  
  public byte[] c(byte[] paramArrayOfByte)
  {
    Object localObject1;
    int i1;
    if ((u.C != null) && (u.C.length > 0))
    {
      localObject1 = new byte[16];
      if (u.C.length > 16)
      {
        System.arraycopy(u.C, 0, localObject1, 0, 16);
      }
      else
      {
        System.arraycopy(u.C, 0, localObject1, 0, u.C.length);
        int i2;
        for (i1 = u.C.length; i1 < 16; i1 = i2)
        {
          i2 = i1 + 1;
          localObject1[i1] = ((byte)i2);
        }
      }
      localObject2 = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, (byte[])localObject1);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length > 0) {}
      }
      else
      {
        localObject1 = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, "%4;7t>;28<fc.5*6".getBytes());
      }
    }
    else
    {
      localObject1 = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, "%4;7t>;28<fc.5*6".getBytes());
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = (byte[])paramArrayOfByte.clone();
    }
    if ((localObject2 != null) && (localObject2.length >= 16))
    {
      i1 = localObject2.length - 16;
      paramArrayOfByte = new byte[i1];
      System.arraycopy(localObject2, 0, paramArrayOfByte, 0, i1);
      localObject1 = new byte[16];
      System.arraycopy(localObject2, i1, localObject1, 0, 16);
      u.b(this.x.h)._tgtgt_key = ((byte[])localObject1);
      return paramArrayOfByte;
    }
    return null;
  }
  
  public byte[] c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null))
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length + paramArrayOfByte3.length];
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      int i1 = paramArrayOfByte1.length + 0;
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i1, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, i1 + paramArrayOfByte2.length, paramArrayOfByte3.length);
      return MD5.toMD5Byte(arrayOfByte);
    }
    return new byte[16];
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject13 = this;
    if (paramInt2 < 5) {
      return -1009;
    }
    Object localObject20 = new tlv_t104();
    tlv_t105 localtlv_t105 = new tlv_t105();
    tlv_t113 localtlv_t113 = new tlv_t113();
    Object localObject16 = new tlv_t119();
    tlv_t10d localtlv_t10d = new tlv_t10d();
    tlv_t10e localtlv_t10e = new tlv_t10e();
    tlv_t10a localtlv_t10a = new tlv_t10a();
    tlv_t114 localtlv_t114 = new tlv_t114();
    Object localObject4 = new tlv_t103();
    tlv_t11a localtlv_t11a = new tlv_t11a();
    Object localObject5 = new tlv_t102();
    Object localObject6 = new tlv_t10b();
    Object localObject7 = new tlv_t11c();
    tlv_t11d localtlv_t11d = new tlv_t11d();
    Object localObject8 = new tlv_t120();
    Object localObject9 = new tlv_t121();
    tlv_t130 localtlv_t130 = new tlv_t130();
    Object localObject10 = new tlv_t108();
    tlv_t106 localtlv_t106 = new tlv_t106();
    tlv_t10c localtlv_t10c = new tlv_t10c();
    Object localObject2 = new tlv_t125();
    tlv_t11f localtlv_t11f = new tlv_t11f();
    tlv_t138 localtlv_t138 = new tlv_t138();
    tlv_t132 localtlv_t132 = new tlv_t132();
    tlv_t149 localtlv_t149 = new tlv_t149();
    tlv_t150 localtlv_t150 = new tlv_t150();
    tlv_t143 localtlv_t143 = new tlv_t143();
    tlv_t305 localtlv_t305 = new tlv_t305();
    tlv_t164 localtlv_t164 = new tlv_t164();
    tlv_t165 localtlv_t165 = new tlv_t165();
    Object localObject19 = new tlv_t167();
    Object localObject11 = new tlv_t16a();
    tlv_t169 localtlv_t169 = new tlv_t169();
    Object localObject17 = new tlv_t161();
    tlv_t171 localtlv_t171 = new tlv_t171();
    Object localObject15 = new tlv_t(1298);
    Object localObject14 = new tlv_t16d();
    tlv_t174 localtlv_t174 = new tlv_t174();
    tlv_t178 localtlv_t178 = new tlv_t178();
    tlv_t179 localtlv_t179 = new tlv_t179();
    tlv_t17d localtlv_t17d = new tlv_t17d();
    tlv_t17e localtlv_t17e = new tlv_t17e();
    tlv_t126 localtlv_t126 = new tlv_t126();
    tlv_t182 localtlv_t182 = new tlv_t182();
    tlv_t183 localtlv_t183 = new tlv_t183();
    Object localObject3 = new tlv_t186();
    Object localObject18 = new tlv_t402();
    Object localObject12 = new tlv_t403();
    tlv_t546 localtlv_t546 = new tlv_t546();
    tlv_t136 localtlv_t136 = new tlv_t136();
    tlv_t118 localtlv_t118 = new tlv_t118();
    Object localObject1 = u.b(((oicq_request)localObject13).x.h);
    long l4 = ((async_context)localObject1)._sappid;
    long l5 = ((async_context)localObject1)._appid;
    int i1;
    if (((oicq_request)localObject13).t == 2064) {
      switch (((oicq_request)localObject13).u)
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
      case 18: 
        i1 = 7;
        break;
      case 15: 
        i1 = 5;
        break;
      case 13: 
        i1 = 4;
        break;
      case 10: 
      case 11: 
        i1 = 1;
        break;
      case 9: 
        i1 = 0;
        break;
      case 7: 
        i1 = 6;
        break;
      case 4: 
        i1 = 3;
        break;
      case 2: 
        i1 = 2;
        break;
      }
    } else {
      i1 = 0;
    }
    int i3 = ((oicq_request)localObject13).c(paramArrayOfByte, paramInt1 + 2);
    paramInt2 = paramInt1 + 5;
    u localu = ((oicq_request)localObject13).x;
    localu.d = null;
    switch (i3)
    {
    default: 
      break;
    case 232: 
      paramInt1 = ((tlv_t104)localObject20).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
      if (paramInt1 >= 0)
      {
        localObject2 = new tlv_t52b();
        paramInt1 = ((tlv_t52b)localObject2).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
        if (paramInt1 >= 0)
        {
          u.am = ((tlv_t104)localObject20).get_data();
          ((async_context)localObject1)._smslogin_zone = ((tlv_t52b)localObject2).get_zone();
          ((async_context)localObject1)._smslogin_hint_mobile = ((tlv_t52b)localObject2).get_mobile();
          paramInt1 = 0;
        }
        else {}
      }
      break;
    case 208: 
      paramInt1 = ((tlv_t104)localObject20).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
      if (paramInt1 >= 0)
      {
        ((async_context)localObject1)._t104 = ((tlv_t104)localObject20);
        paramInt1 = localtlv_t126.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
        if (paramInt1 >= 0)
        {
          ((async_context)localObject1)._t126 = localtlv_t126;
          paramInt1 = localtlv_t182.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
          if (paramInt1 >= 0)
          {
            ((async_context)localObject1)._smslogin_msgcnt = localtlv_t182.getMsgCnt();
            ((async_context)localObject1)._smslogin_timelimit = localtlv_t182.getTimeLimit();
            paramInt1 = localtlv_t183.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
            if (paramInt1 >= 0)
            {
              ((async_context)localObject1)._msalt = localtlv_t183.getMsalt();
              paramInt1 = 0;
              break label7243;
            }
          }
        }
        else {}
      }
      break;
    case 204: 
      if (localtlv_t113.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0)
      {
        ((oicq_request)localObject13).x.f = localtlv_t113.get_uin();
        localObject2 = ((oicq_request)localObject13).x;
        ((u)localObject2).a(((u)localObject2).g, Long.valueOf(((oicq_request)localObject13).x.f));
      }
      paramInt1 = ((tlv_t104)localObject20).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
      if (paramInt1 >= 0)
      {
        ((async_context)localObject1)._t104 = ((tlv_t104)localObject20);
        paramInt1 = ((tlv_t402)localObject18).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
        if (paramInt1 >= 0)
        {
          ((async_context)localObject1)._t402 = ((tlv_t402)localObject18);
          paramInt1 = ((tlv_t403)localObject12).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
          if (paramInt1 >= 0)
          {
            ((async_context)localObject1)._t403 = ((tlv_t403)localObject12);
            break;
          }
          break label7243;
        }
        break label7243;
      }
      break;
    case 180: 
      paramInt1 = ((tlv_t161)localObject17).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
      if (paramInt1 >= 0) {
        ((oicq_request)localObject13).a((tlv_t161)localObject17);
      }
      break;
    case 176: 
      ((oicq_request)localObject13).c(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
      localObject2 = ((oicq_request)localObject13).x;
      ((u)localObject2).a(((u)localObject2).g);
      break;
    case 160: 
    case 239: 
      if (localtlv_t113.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0)
      {
        ((oicq_request)localObject13).x.f = localtlv_t113.get_uin();
        localObject2 = ((oicq_request)localObject13).x;
        ((u)localObject2).a(((u)localObject2).g, Long.valueOf(((oicq_request)localObject13).x.f));
      }
      paramInt1 = ((tlv_t104)localObject20).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
      if (paramInt1 >= 0)
      {
        ((async_context)localObject1)._t104 = ((tlv_t104)localObject20);
        paramInt1 = localtlv_t174.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
        if (paramInt1 >= 0)
        {
          ((async_context)localObject1)._t174 = localtlv_t174;
          a(paramArrayOfByte, paramInt2, localtlv_t178, localtlv_t179, localtlv_t17d, (async_context)localObject1);
          if (localtlv_t17e.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0) {
            ((async_context)localObject1)._devlock_info.VerifyReason = new String(localtlv_t17e.get_data());
          }
          if (((tlv_t402)localObject18).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0) {
            ((async_context)localObject1)._t402 = ((tlv_t402)localObject18);
          } else {
            ((async_context)localObject1)._t402 = new tlv_t402();
          }
          if (((tlv_t403)localObject12).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0) {
            ((async_context)localObject1)._t403 = ((tlv_t403)localObject12);
          } else {
            ((async_context)localObject1)._t403 = new tlv_t403();
          }
          ((oicq_request)localObject13).c(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
          break label7240;
        }
        break label7243;
      }
      break;
    case 41: 
    case 116: 
      localObject2 = new tlv_t(405);
      paramInt1 = ((tlv_t)localObject2).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
      if (paramInt1 >= 0) {
        WloginSigInfo._LHSig = ((tlv_t)localObject2).get_data();
      }
      break;
    case 20: 
      localObject2 = new StringBuilder("cmd ");
      ((StringBuilder)localObject2).append(Integer.toHexString(((oicq_request)localObject13).t));
      ((StringBuilder)localObject2).append(" subcmd ");
      ((StringBuilder)localObject2).append(Integer.toHexString(((oicq_request)localObject13).u));
      ((StringBuilder)localObject2).append(" result ");
      ((StringBuilder)localObject2).append(i3);
      ((StringBuilder)localObject2).append(" seq error uin ");
      ((StringBuilder)localObject2).append(((oicq_request)localObject13).x.f);
      ((StringBuilder)localObject2).append(" appid ");
      ((StringBuilder)localObject2).append(l4);
      util.LOGI(((StringBuilder)localObject2).toString(), "");
      break;
    case 16: 
      localu.e(localu.f, l4);
      paramInt1 = localtlv_t130.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
      if (paramInt1 >= 0) {
        ((oicq_request)localObject13).x.a(localtlv_t130.get_time(), localtlv_t130.get_ipaddr());
      }
      break;
    case 2: 
      paramInt1 = ((tlv_t104)localObject20).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
      if (paramInt1 >= 0)
      {
        ((async_context)localObject1)._t104 = ((tlv_t104)localObject20);
        localObject2 = new tlv_t192();
        if (((tlv_t192)localObject2).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0)
        {
          util.LOGI("return 0x192", "");
          paramInt1 = localtlv_t546.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
          if (paramInt1 >= 0)
          {
            localObject3 = new StringBuilder("get tlv546 success len:");
            ((StringBuilder)localObject3).append(localtlv_t546.get_data_len());
            util.LOGI(((StringBuilder)localObject3).toString(), "");
            ((async_context)localObject1)._t546 = localtlv_t546;
          }
          else
          {
            util.LOGI("get tlv546 fail ret:".concat(String.valueOf(paramInt1)), "");
            ((async_context)localObject1)._t546 = new tlv_t546();
          }
          b.a(localtlv_t546.get_data());
          ((oicq_request)localObject13).a(new ErrMsg(0, i3, "", "", ((tlv_t192)localObject2).getUrl()));
        }
        else
        {
          paramInt1 = localtlv_t105.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
          if (paramInt1 < 0) {
            break label2166;
          }
          ((async_context)localObject1)._t105 = localtlv_t105;
          if (localtlv_t165.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0) {
            ((async_context)localObject1)._t165 = localtlv_t165;
          } else {
            ((async_context)localObject1)._t165 = new tlv_t165();
          }
          paramInt1 = localtlv_t546.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
          if (paramInt1 >= 0)
          {
            localObject2 = new StringBuilder("get tlv546 success len:");
            ((StringBuilder)localObject2).append(localtlv_t546.get_data_len());
            util.LOGI(((StringBuilder)localObject2).toString(), "");
            ((async_context)localObject1)._t546 = localtlv_t546;
          }
          else
          {
            util.LOGI("get tlv546 fail ret:".concat(String.valueOf(paramInt1)), "");
            ((async_context)localObject1)._t546 = new tlv_t546();
          }
          b.a(localtlv_t546.get_data());
          ((oicq_request)localObject13).a(null);
        }
        break label7240;
        break label7243;
      }
      break;
    case 1: 
    case 15: 
      localObject2 = new StringBuilder("cmd ");
      ((StringBuilder)localObject2).append(Integer.toHexString(((oicq_request)localObject13).t));
      ((StringBuilder)localObject2).append(" subcmd ");
      ((StringBuilder)localObject2).append(Integer.toHexString(((oicq_request)localObject13).u));
      ((StringBuilder)localObject2).append(" result ");
      ((StringBuilder)localObject2).append(i3);
      ((StringBuilder)localObject2).append(" will clean sig for uin ");
      ((StringBuilder)localObject2).append(((oicq_request)localObject13).x.f);
      ((StringBuilder)localObject2).append(" appid ");
      ((StringBuilder)localObject2).append(l4);
      util.LOGI(((StringBuilder)localObject2).toString(), "");
      localObject2 = ((oicq_request)localObject13).x;
      ((u)localObject2).e(((u)localObject2).f, l4);
      break;
    case 0: 
      label2166:
      if (i1 == 1)
      {
        if (localu.b == null) {
          return -1006;
        }
        if (localtlv_t150.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0) {
          ((oicq_request)localObject13).x.d = localtlv_t150;
        }
        if (((tlv_t161)localObject17).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0) {
          ((oicq_request)localObject13).a((tlv_t161)localObject17);
        }
        paramInt1 = ((tlv_t119)localObject16).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1, ((oicq_request)localObject13).x.b);
      }
      else
      {
        localObject18 = localObject16;
        if (i1 == 2)
        {
          if (localtlv_t183.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2) >= 0) {
            ((async_context)localObject1)._msalt = localtlv_t183.getMsalt();
          }
          if (f() == 3)
          {
            paramInt1 = localtlv_t113.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
            if (paramInt1 >= 0)
            {
              ((oicq_request)localObject13).x.f = localtlv_t113.get_uin();
              ((async_context)localObject1)._uin = ((oicq_request)localObject13).x.f;
              if (!((async_context)localObject1).ifQQLoginInQim(u.aA))
              {
                localObject2 = ((oicq_request)localObject13).x;
                ((u)localObject2).a(((u)localObject2).g, Long.valueOf(((oicq_request)localObject13).x.f));
              }
            }
            util.LOGI("flowid == 2 t113 = ".concat(String.valueOf(paramInt1)), String.valueOf(((oicq_request)localObject13).x.f));
            if (((tlv_t104)localObject20).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0) {
              ((async_context)localObject1)._t104 = ((tlv_t104)localObject20);
            }
            paramInt1 = 0;
            break label7243;
          }
          if (localtlv_t150.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0) {
            ((oicq_request)localObject13).x.d = localtlv_t150;
          }
          if (((tlv_t161)localObject17).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0) {
            ((oicq_request)localObject13).a((tlv_t161)localObject17);
          }
          paramInt1 = ((tlv_t119)localObject18).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1, ((async_context)localObject1)._tgtgt_key);
        }
        else
        {
          if ((i1 == 3) || (i1 == 7)) {
            break label7057;
          }
          if (22 == ((oicq_request)localObject13).u)
          {
            paramInt1 = ((tlv_t104)localObject20).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2);
            if (paramInt1 >= 0)
            {
              ((async_context)localObject1)._t104 = ((tlv_t104)localObject20);
              paramInt1 = 0;
              break label7243;
            }
            break label7243;
          }
          if (localtlv_t150.get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0) {
            ((oicq_request)localObject13).x.d = localtlv_t150;
          }
          if (((tlv_t161)localObject17).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1) >= 0) {
            ((oicq_request)localObject13).a((tlv_t161)localObject17);
          }
          paramInt1 = ((tlv_t119)localObject18).get_tlv(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1, ((async_context)localObject1)._tgtgt_key);
          t.K = 0;
        }
      }
      if (paramInt1 >= 0)
      {
        localObject16 = ((tlv_t119)localObject16).get_data();
        i2 = localObject16.length;
        if (localtlv_t149.get_tlv((byte[])localObject16, 2, i2) > 0) {
          ((oicq_request)localObject13).a(localtlv_t149);
        }
        localObject17 = new tlv_t543();
        paramInt1 = ((tlv_t543)localObject17).get_tlv((byte[])localObject16, 2, i2);
        ((async_context)localObject1).tlv543In119 = ((tlv_t543)localObject17);
        if (localtlv_t130.get_tlv((byte[])localObject16, 2, i2) > 0) {
          ((oicq_request)localObject13).x.a(localtlv_t130.get_time(), localtlv_t130.get_ipaddr());
        }
        int i4 = localtlv_t113.get_tlv((byte[])localObject16, 2, i2);
        if (i4 >= 0)
        {
          ((oicq_request)localObject13).x.f = localtlv_t113.get_uin();
          ((async_context)localObject1)._uin = ((oicq_request)localObject13).x.f;
          if (!((async_context)localObject1).ifQQLoginInQim(u.aA))
          {
            localObject17 = ((oicq_request)localObject13).x;
            ((u)localObject17).a(((u)localObject17).g, Long.valueOf(((oicq_request)localObject13).x.f));
          }
          else {}
        }
        localObject17 = new StringBuilder("quickLoginByGateway retTlv543In119:");
        ((StringBuilder)localObject17).append(paramInt1);
        ((StringBuilder)localObject17).append(" ,rett113=");
        ((StringBuilder)localObject17).append(i4);
        util.LOGI(((StringBuilder)localObject17).toString());
        localObject17 = new tlv_t(1320);
        if (((tlv_t)localObject17).get_tlv((byte[])localObject16, 2, i2) > 0)
        {
          localObject18 = new StringBuilder("get tlv528 and put into context from seq ");
          ((StringBuilder)localObject18).append(((oicq_request)localObject13).x.h);
          localObject18 = ((StringBuilder)localObject18).toString();
          localObject20 = new StringBuilder();
          ((StringBuilder)localObject20).append(((oicq_request)localObject13).x.f);
          util.LOGI((String)localObject18, ((StringBuilder)localObject20).toString());
          ((async_context)localObject1).tlv528 = ((tlv_t)localObject17);
        }
        localObject17 = new tlv_t(1328);
        if (((tlv_t)localObject17).get_tlv((byte[])localObject16, 2, i2) > 0)
        {
          localObject18 = new StringBuilder("get tlv530 and put into context from seq ");
          ((StringBuilder)localObject18).append(((oicq_request)localObject13).x.h);
          localObject18 = ((StringBuilder)localObject18).toString();
          localObject20 = new StringBuilder();
          ((StringBuilder)localObject20).append(((oicq_request)localObject13).x.f);
          util.LOGI((String)localObject18, ((StringBuilder)localObject20).toString());
          ((async_context)localObject1).tlv530 = ((tlv_t)localObject17);
        }
        localtlv_t10d.get_tlv((byte[])localObject16, 2, i2);
        localtlv_t10e.get_tlv((byte[])localObject16, 2, i2);
        localtlv_t10a.get_tlv((byte[])localObject16, 2, i2);
        localtlv_t114.get_tlv((byte[])localObject16, 2, i2);
        paramInt1 = localtlv_t11a.get_tlv((byte[])localObject16, 2, i2);
        if (paramInt1 >= 0)
        {
          if (localtlv_t118.get_tlv((byte[])localObject16, 2, i2) < 0)
          {
            localObject17 = new StringBuilder();
            ((StringBuilder)localObject17).append(((oicq_request)localObject13).x.f);
            util.LOGI("t118 get failed", ((StringBuilder)localObject17).toString());
          }
          if (((tlv_t103)localObject4).get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject4 = ((tlv_t103)localObject4).get_data();
          } else {
            localObject4 = null;
          }
          if (((tlv_t108)localObject10).get_tlv((byte[])localObject16, 2, i2) >= 0) {
            util.set_ksid(u.u, ((tlv_t108)localObject10).get_data());
          }
          if (((tlv_t102)localObject5).get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject5 = ((tlv_t102)localObject5).get_data();
          } else {
            localObject5 = null;
          }
          if (((tlv_t10b)localObject6).get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject6 = ((tlv_t10b)localObject6).get_data();
          } else {
            localObject6 = null;
          }
          if (((tlv_t11c)localObject7).get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject7 = ((tlv_t11c)localObject7).get_data();
          } else {
            localObject7 = null;
          }
          if (((tlv_t120)localObject8).get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject8 = ((tlv_t120)localObject8).get_data();
          } else {
            localObject8 = null;
          }
          if (((tlv_t121)localObject9).get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject9 = ((tlv_t121)localObject9).get_data();
          } else {
            localObject9 = null;
          }
          localObject10 = localObject2;
          if (((tlv_t125)localObject10).get_tlv((byte[])localObject16, 2, i2) >= 0)
          {
            localObject2 = ((tlv_t125)localObject10).get_openid();
            localObject10 = ((tlv_t125)localObject10).get_openkey();
          }
          else
          {
            localObject2 = null;
            localObject10 = null;
          }
          localObject18 = localObject3;
          if (((tlv_t186)localObject18).get_tlv((byte[])localObject16, 2, i2) >= 0)
          {
            localObject3 = ((oicq_request)localObject13).x.g;
            if (util.check_uin_account((String)localObject3).booleanValue())
            {
              localObject3 = ((oicq_request)localObject13).x;
              localObject3 = ((u)localObject3).e(((u)localObject3).f);
              if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
                break label3686;
              }
            }
            localObject17 = ((oicq_request)localObject13).x;
            ((u)localObject17).a((String)localObject3, Long.valueOf(((u)localObject17).f), ((tlv_t186)localObject18).getPwdflag());
            label3686:
            localObject17 = new StringBuilder("put t186: name: ");
            ((StringBuilder)localObject17).append((String)localObject3);
            ((StringBuilder)localObject17).append(" uin: ");
            localObject3 = ((oicq_request)localObject13).x;
            ((StringBuilder)localObject17).append(((u)localObject3).f);
            ((StringBuilder)localObject17).append(" pwd=");
            ((StringBuilder)localObject17).append(((tlv_t186)localObject18).getPwdflag());
            util.LOGI(((StringBuilder)localObject17).toString(), "");
          }
          localObject17 = localObject12;
          localObject3 = new StringBuilder("tgt len:");
          ((StringBuilder)localObject3).append(util.buf_len(localtlv_t10a.get_data()));
          ((StringBuilder)localObject3).append(" tgt_key len:");
          ((StringBuilder)localObject3).append(util.buf_len(localtlv_t10d.get_data()));
          ((StringBuilder)localObject3).append(" st len:");
          ((StringBuilder)localObject3).append(util.buf_len(localtlv_t114.get_data()));
          ((StringBuilder)localObject3).append(" st_key len:");
          ((StringBuilder)localObject3).append(util.buf_len(localtlv_t10e.get_data()));
          ((StringBuilder)localObject3).append(" stwx_web len:");
          ((StringBuilder)localObject3).append(util.buf_len((byte[])localObject4));
          ((StringBuilder)localObject3).append(" lskey len:");
          ((StringBuilder)localObject3).append(util.buf_len((byte[])localObject7));
          ((StringBuilder)localObject3).append(" skey len:");
          ((StringBuilder)localObject3).append(util.buf_len((byte[])localObject8));
          ((StringBuilder)localObject3).append(" sig64 len:");
          ((StringBuilder)localObject3).append(util.buf_len((byte[])localObject9));
          ((StringBuilder)localObject3).append(" openid len:");
          ((StringBuilder)localObject3).append(util.buf_len((byte[])localObject2));
          ((StringBuilder)localObject3).append(" openkey len:");
          ((StringBuilder)localObject3).append(util.buf_len((byte[])localObject10));
          ((StringBuilder)localObject3).append(" pwdflag: ");
          ((StringBuilder)localObject3).append(((tlv_t186)localObject18).get_data_len());
          ((StringBuilder)localObject3).append(" ");
          ((StringBuilder)localObject3).append(((tlv_t186)localObject18).getPwdflag());
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject12 = new StringBuilder();
          ((StringBuilder)localObject12).append(((oicq_request)localObject13).x.f);
          util.LOGI((String)localObject3, ((StringBuilder)localObject12).toString());
          if (localtlv_t169.get_tlv((byte[])localObject16, 2, i2) >= 0)
          {
            localObject3 = ((oicq_request)localObject13).a(localtlv_t169);
            if ((localObject3 != null) && (localObject3.length > 0)) {
              ((oicq_request)localObject13).x.j = new WFastLoginInfo((byte[])localObject3);
            } else {
              ((oicq_request)localObject13).x.j = new WFastLoginInfo();
            }
          }
          localObject18 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 3, 0 });
          if (((tlv_t167)localObject19).get_tlv((byte[])localObject16, 2, i2) >= 0)
          {
            localObject18[0] = ((tlv_t167)localObject19).get_img_type();
            localObject18[1] = ((tlv_t167)localObject19).get_img_format();
            localObject18[2] = ((tlv_t167)localObject19).get_img_url();
          }
          localObject19 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 5, 0 });
          paramInt1 = 0;
          while (paramInt1 < 5)
          {
            localObject19[paramInt1] = new byte[0];
            paramInt1 += 1;
          }
          paramInt1 = localtlv_t10c.get_tlv((byte[])localObject16, 2, i2);
          localObject12 = localObject2;
          i4 = localtlv_t106.get_tlv((byte[])localObject16, 2, i2);
          if ((paramInt1 >= 0) && (i4 >= 0))
          {
            localObject2 = localtlv_t10c.get_data();
            localObject19[0] = ((byte[])b(localtlv_t106.get_data(), (byte[])localObject2).clone());
          }
          if (((tlv_t16a)localObject11).get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject19[1] = ((tlv_t16a)localObject11).get_data();
          }
          localObject2 = new tlv_t(1329);
          paramInt1 = ((tlv_t)localObject2).get_tlv((byte[])localObject16, 2, i2);
          localObject3 = new StringBuilder("retT531: ");
          ((StringBuilder)localObject3).append(paramInt1);
          ((StringBuilder)localObject3).append(((oicq_request)localObject13).x.f);
          util.LOGI(((StringBuilder)localObject3).toString());
          if (paramInt1 >= 0)
          {
            localtlv_t106 = new tlv_t106();
            localtlv_t10c = new tlv_t10c();
            localObject3 = new tlv_t16a();
            localObject11 = new tlv_t113();
            paramInt1 = localtlv_t106.get_tlv(((tlv_t)localObject2).get_data(), 2, ((tlv_t)localObject2).get_data_len());
            i4 = localtlv_t10c.get_tlv(((tlv_t)localObject2).get_data(), 2, ((tlv_t)localObject2).get_data_len());
            int i5 = ((tlv_t)localObject3).get_tlv(((tlv_t)localObject2).get_data(), 2, ((tlv_t)localObject2).get_data_len());
            int i6 = ((tlv_t)localObject11).get_tlv(((tlv_t)localObject2).get_data(), 2, ((tlv_t)localObject2).get_data_len());
            if ((paramInt1 >= 0) && (i4 >= 0) && (i5 >= 0) && (i6 >= 0))
            {
              localObject2 = b(localtlv_t106.get_data(), localtlv_t10c.get_data());
              localObject3 = ((tlv_t)localObject3).get_data();
              l2 = util.buf_to_int32(((tlv_t)localObject11).get_data(), 0) & 0xFFFFFFFF;
              ((async_context)localObject1).tlv113 = ((tlv_t)localObject11);
              break label4687;
            }
            localObject2 = new StringBuilder("Get data from 0x531 failed: ");
            ((StringBuilder)localObject2).append(paramInt1);
            ((StringBuilder)localObject2).append(";");
            ((StringBuilder)localObject2).append(i4);
            ((StringBuilder)localObject2).append(";");
            ((StringBuilder)localObject2).append(i5);
            ((StringBuilder)localObject2).append(";");
            ((StringBuilder)localObject2).append(i6);
            ((StringBuilder)localObject2).append(";");
            ((StringBuilder)localObject2).append(((oicq_request)localObject13).x.f);
            util.LOGI(((StringBuilder)localObject2).toString());
          }
          long l2 = 0L;
          localObject2 = null;
          localObject3 = null;
          label4687:
          localObject11 = localObject1;
          if (((tlv_t403)localObject17).get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject19[4] = ((tlv_t403)localObject17).get_data();
          }
          if (((async_context)localObject11)._sec_guid_flag)
          {
            localObject19[2] = ((async_context)localObject11)._G;
            localObject19[3] = ((async_context)localObject11)._dpwd;
            localObject19[4] = ((async_context)localObject11)._t403.get_data();
            ((async_context)localObject11)._sec_guid_flag = false;
          }
          localObject17 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 16, 0 });
          paramInt1 = 0;
          while (paramInt1 < 16)
          {
            localObject17[paramInt1] = new byte[0];
            paramInt1 += 1;
          }
          if (localtlv_t136.get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject17[0] = localtlv_t136.get_data();
          }
          if (localtlv_t132.get_tlv((byte[])localObject16, 2, i2) >= 0)
          {
            localObject17[1] = localtlv_t132.get_access_token();
            localObject1 = localtlv_t132.get_openid();
          }
          else
          {
            localObject1 = localObject12;
          }
          if (localtlv_t143.get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject17[2] = localtlv_t143.get_data();
          }
          if (localtlv_t305.get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject17[3] = localtlv_t305.get_data();
          }
          if (localtlv_t164.get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject17[4] = localtlv_t164.get_data();
          }
          if (localtlv_t171.get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject17[5] = localtlv_t171.get_data();
          }
          if (((tlv_t)localObject15).get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject17[6] = ((tlv_t)localObject15).get_data();
          }
          if (((tlv_t16d)localObject14).get_tlv((byte[])localObject16, 2, i2) >= 0) {
            localObject17[7] = ((tlv_t16d)localObject14).get_data();
          }
          localObject12 = new tlv_t199();
          if (((tlv_t199)localObject12).get_tlv((byte[])localObject16, 2, i2) >= 0)
          {
            localObject17[8] = ((tlv_t199)localObject12).getPayToken();
            localObject1 = ((tlv_t199)localObject12).getOpenId();
          }
          localObject12 = new tlv_t200();
          if (((tlv_t200)localObject12).get_tlv((byte[])localObject16, 2, i2) >= 0)
          {
            localObject17[9] = ((tlv_t200)localObject12).getPf();
            localObject17[10] = ((tlv_t200)localObject12).getPfKey();
          }
          localObject12 = new tlv_t(515);
          if (((tlv_t)localObject12).get_tlv((byte[])localObject16, 2, i2) >= 0)
          {
            localObject17[11] = ((tlv_t)localObject12).get_data();
            util.LOGI("get DA2 in rsp", "");
          }
          else
          {
            util.LOGI("no DA2 in rsp", "");
          }
          localObject12 = new tlv_t(791);
          if (((tlv_t)localObject12).get_tlv((byte[])localObject16, 2, i2) >= 0) {
            WloginSigInfo._QRPUSHSig = ((tlv_t)localObject12).get_data();
          } else {
            WloginSigInfo._QRPUSHSig = new byte[0];
          }
          localObject12 = new tlv_t(307);
          if (((tlv_t)localObject12).get_tlv((byte[])localObject16, 2, i2) >= 0)
          {
            localObject17[13] = ((tlv_t)localObject12).get_data();
          }
          else
          {
            localObject12 = new StringBuilder();
            ((StringBuilder)localObject12).append(((oicq_request)localObject13).x.f);
            util.LOGW("get t133 failed", ((StringBuilder)localObject12).toString());
          }
          localObject12 = new tlv_t(308);
          if (((tlv_t)localObject12).get_tlv((byte[])localObject16, 2, i2) >= 0)
          {
            localObject17[14] = ((tlv_t)localObject12).get_data();
          }
          else
          {
            localObject12 = new StringBuilder();
            ((StringBuilder)localObject12).append(((oicq_request)localObject13).x.f);
            util.LOGW("get t134 failed", ((StringBuilder)localObject12).toString());
          }
          if (u.ac)
          {
            paramInt1 = ((oicq_request)localObject13).u;
            if ((paramInt1 == 9) || (paramInt1 == 15) || (paramInt1 == 20))
            {
              localObject12 = new tlv_t322();
              ((tlv_t322)localObject12).get_tlv((byte[])localObject16, 2, i2);
              localObject12 = ((tlv_t322)localObject12).get_data();
              if ((localObject12 != null) && (localObject12.length > 0))
              {
                localObject17[15] = localObject12;
                localObject12 = util.buf_to_string((byte[])localObject12);
              }
              else
              {
                localObject12 = "null";
              }
              localObject12 = "get t322, value=".concat(String.valueOf(localObject12));
              localObject14 = new StringBuilder();
              ((StringBuilder)localObject14).append(((oicq_request)localObject13).x.f);
              util.LOGI((String)localObject12, ((StringBuilder)localObject14).toString());
            }
          }
          localObject12 = new StringBuilder("encrypt_a1 len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject19[0]));
          ((StringBuilder)localObject12).append(" no_pic_sig len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject19[1]));
          ((StringBuilder)localObject12).append(" G len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject19[2]));
          ((StringBuilder)localObject12).append(" dpwd len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject19[3]));
          ((StringBuilder)localObject12).append(" randseed len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject19[4]));
          ((StringBuilder)localObject12).append(" vkey len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[0]));
          ((StringBuilder)localObject12).append(" openid len:");
          ((StringBuilder)localObject12).append(util.buf_len((byte[])localObject1));
          ((StringBuilder)localObject12).append(" access_token len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[1]));
          ((StringBuilder)localObject12).append(" d2 len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[2]));
          ((StringBuilder)localObject12).append(" d2_key len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[3]));
          ((StringBuilder)localObject12).append(" sid len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[4]));
          ((StringBuilder)localObject12).append(" aq_sig len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[5]));
          ((StringBuilder)localObject12).append(" pskey len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[6]));
          ((StringBuilder)localObject12).append(" super_key len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[7]));
          ((StringBuilder)localObject12).append(" paytoken len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[8]));
          ((StringBuilder)localObject12).append(" pf len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[9]));
          ((StringBuilder)localObject12).append(" pfkey len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[10]));
          ((StringBuilder)localObject12).append(" da2 len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[11]));
          ((StringBuilder)localObject12).append(" wt session ticket:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[13]));
          ((StringBuilder)localObject12).append(" wt session ticket key:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[14]));
          ((StringBuilder)localObject12).append(" device_token len:");
          ((StringBuilder)localObject12).append(util.buf_len(localObject17[15]));
          localObject12 = ((StringBuilder)localObject12).toString();
          localObject14 = new StringBuilder();
          ((StringBuilder)localObject14).append(((oicq_request)localObject13).x.f);
          util.LOGI((String)localObject12, ((StringBuilder)localObject14).toString());
          long l3;
          if (localtlv_t11f.get_tlv((byte[])localObject16, 2, i2) >= 0) {
            l3 = localtlv_t11f.get_tk_pri() & 0xFFFFFFFF;
          } else {
            l3 = 4294967295L;
          }
          localObject13 = new long[7];
          long l1 = 2160000L;
          paramInt1 = 2;
          for (;;)
          {
            paramInt1 = localtlv_t138.get_tlv((byte[])localObject16, paramInt1, i2);
            if (paramInt1 < 0) {
              break;
            }
            if (localtlv_t138.get_a2_chg_time() != 0) {
              l1 = localtlv_t138.get_a2_chg_time();
            }
            if (localtlv_t138.get_lskey_chg_time() != 0) {
              localObject13[0] = localtlv_t138.get_lskey_chg_time();
            } else {
              localObject13[0] = 1641600L;
            }
            if (localtlv_t138.get_skey_chg_time() != 0) {
              localObject13[1] = localtlv_t138.get_skey_chg_time();
            } else {
              localObject13[1] = 86400L;
            }
            if (localtlv_t138.get_vkey_chg_time() != 0) {
              localObject13[2] = localtlv_t138.get_vkey_chg_time();
            } else {
              localObject13[2] = 1728000L;
            }
            if (localtlv_t138.get_a8_chg_time() != 0) {
              localObject13[3] = localtlv_t138.get_a8_chg_time();
            } else {
              localObject13[3] = 72000L;
            }
            if (localtlv_t138.get_stweb_chg_time() != 0) {
              localObject13[4] = localtlv_t138.get_stweb_chg_time();
            } else {
              localObject13[4] = 6000L;
            }
            if (localtlv_t138.get_d2_chg_time() != 0) {
              localObject13[5] = localtlv_t138.get_d2_chg_time();
            } else {
              localObject13[5] = 1728000L;
            }
            if (localtlv_t138.get_sid_chg_time() != 0) {
              localObject13[6] = localtlv_t138.get_sid_chg_time();
            } else {
              localObject13[6] = 1728000L;
            }
          }
          localObject12 = new StringBuilder("sappid:");
          ((StringBuilder)localObject12).append(l4);
          ((StringBuilder)localObject12).append(" appid:");
          ((StringBuilder)localObject12).append(l5);
          ((StringBuilder)localObject12).append(" app_pri:");
          ((StringBuilder)localObject12).append(l3);
          ((StringBuilder)localObject12).append(" login_bitmap:");
          ((StringBuilder)localObject12).append(((async_context)localObject11)._login_bitmap);
          ((StringBuilder)localObject12).append(" tk_valid:0 a2_valid:");
          ((StringBuilder)localObject12).append(l1);
          ((StringBuilder)localObject12).append(" lskey_valid:");
          ((StringBuilder)localObject12).append(localObject13[0]);
          ((StringBuilder)localObject12).append(" skey_valid:");
          ((StringBuilder)localObject12).append(localObject13[1]);
          ((StringBuilder)localObject12).append(" vkey_valid:");
          ((StringBuilder)localObject12).append(localObject13[2]);
          ((StringBuilder)localObject12).append(" a8_valid:");
          ((StringBuilder)localObject12).append(localObject13[3]);
          ((StringBuilder)localObject12).append(" stweb_valid:");
          ((StringBuilder)localObject12).append(localObject13[4]);
          ((StringBuilder)localObject12).append(" d2_valid:");
          ((StringBuilder)localObject12).append(localObject13[5]);
          ((StringBuilder)localObject12).append(" sid_valid:");
          ((StringBuilder)localObject12).append(localObject13[6]);
          localObject14 = ((StringBuilder)localObject12).toString();
          localObject15 = new StringBuilder();
          localObject12 = this;
          ((StringBuilder)localObject15).append(((oicq_request)localObject12).x.f);
          util.LOGI((String)localObject14, ((StringBuilder)localObject15).toString());
          localObject14 = new WloginSimpleInfo();
          ((WloginSimpleInfo)localObject14).setUin(((oicq_request)localObject12).x.f);
          ((WloginSimpleInfo)localObject14).setFace(localtlv_t11a.get_face());
          ((WloginSimpleInfo)localObject14).setAge(localtlv_t11a.get_age());
          ((WloginSimpleInfo)localObject14).setGender(localtlv_t11a.get_gender());
          ((WloginSimpleInfo)localObject14).setNick(localtlv_t11a.get_nick());
          ((WloginSimpleInfo)localObject14).setReserveUinInfo((byte[][])localObject18);
          ((WloginSimpleInfo)localObject14).setMainDisplayName(localtlv_t118.get_data());
          ((oicq_request)localObject12).x.aw = ((async_context)localObject11)._main_sigmap;
          localObject15 = ((oicq_request)localObject12).x;
          paramInt1 = ((u)localObject15).a(((u)localObject15).f, l4, (byte[][])localObject19, l5, l3, u.f(), u.f() + 0L, u.f() + l1, (WloginSimpleInfo)localObject14, localtlv_t10a.get_data(), localtlv_t10d.get_data(), localtlv_t114.get_data(), localtlv_t10e.get_data(), (byte[])localObject4, (byte[])localObject6, (byte[])localObject5, (byte[])localObject7, (byte[])localObject8, (byte[])localObject9, (byte[])localObject1, (byte[])localObject10, (byte[][])localObject17, (long[])localObject13, ((async_context)localObject11)._login_bitmap);
          if (paramInt1 != 0)
          {
            localObject1 = new ErrMsg();
            ((ErrMsg)localObject1).setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
            ((oicq_request)localObject12).a((ErrMsg)localObject1);
            localObject1 = "put_siginfo fail,ret=".concat(String.valueOf(paramInt1));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((oicq_request)localObject12).x.f);
            util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
            localObject1 = localObject11;
          }
          else
          {
            if ((localObject2 != null) && (0L != l2))
            {
              localObject1 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { localObject19.length, 0 });
              localObject1[0] = localObject2;
              localObject1[1] = localObject3;
              localObject2 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { localObject17.length, 0 });
              paramInt1 = ((oicq_request)localObject12).x.a(l2, 16L, (byte[][])localObject1, 16L, l3, u.f(), u.f() + 0L, u.f() + l1, (WloginSimpleInfo)localObject14, null, null, null, null, null, null, null, null, null, null, null, null, (byte[][])localObject2, (long[])localObject13, ((async_context)localObject11)._login_bitmap);
              if (paramInt1 != 0)
              {
                localObject1 = new ErrMsg();
                ((ErrMsg)localObject1).setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
                ((oicq_request)localObject12).a((ErrMsg)localObject1);
                util.LOGI("put_siginfo fail ".concat(String.valueOf(paramInt1)), String.valueOf(l2));
                localObject1 = localObject11;
                break label7243;
              }
            }
            paramInt1 = 2;
            for (;;)
            {
              paramInt1 = localtlv_t11d.get_tlv((byte[])localObject16, paramInt1, i2);
              if (paramInt1 < 0) {
                break;
              }
              localObject1 = ((oicq_request)localObject12).x;
              ((u)localObject1).a(((u)localObject1).f, localtlv_t11d.get_appid(), u.f(), u.f() + 0L, localtlv_t11d.get_st(), localtlv_t11d.get_stkey());
            }
            paramInt1 = 0;
            localObject1 = localObject11;
          }
        }
      }
      else
      {
        break label7243;
        label7057:
        paramInt1 = ((oicq_request)localObject13).c;
        i2 = paramInt2;
        localObject2 = paramArrayOfByte;
        if (localtlv_t183.get_tlv((byte[])localObject2, i2, paramInt1 - paramInt2) >= 0) {
          ((async_context)localObject1)._msalt = localtlv_t183.getMsalt();
        }
        paramInt1 = localtlv_t113.get_tlv((byte[])localObject2, i2, ((oicq_request)localObject13).c - i2);
        if (paramInt1 >= 0)
        {
          ((oicq_request)localObject13).x.f = localtlv_t113.get_uin();
          localObject3 = ((oicq_request)localObject13).x;
          ((u)localObject3).a(((u)localObject3).g, Long.valueOf(((oicq_request)localObject13).x.f));
        }
        util.LOGI("flowid == 3 || flowid == 7 t113 = ".concat(String.valueOf(paramInt1)), String.valueOf(((oicq_request)localObject13).x.f));
        paramInt1 = ((tlv_t104)localObject20).get_tlv((byte[])localObject2, i2, ((oicq_request)localObject13).c - i2);
        if (paramInt1 >= 0)
        {
          ((async_context)localObject1)._t104 = ((tlv_t104)localObject20);
          paramInt1 = 0;
          paramInt2 = i2;
        }
        else
        {
          paramInt2 = i2;
        }
      }
      break;
    }
    ((oicq_request)localObject13).c(paramArrayOfByte, paramInt2, ((oicq_request)localObject13).c - paramInt2 - 1);
    label7240:
    paramInt1 = i3;
    label7243:
    localObject2 = this;
    localObject3 = paramArrayOfByte;
    paramArrayOfByte = new tlv_t543();
    int i2 = paramArrayOfByte.get_tlv((byte[])localObject3, paramInt2, ((oicq_request)localObject2).c - paramInt2 - 1);
    ((async_context)localObject1)._t543 = paramArrayOfByte;
    util.LOGI("tlv543_ret:".concat(String.valueOf(i2)), "");
    localObject1 = new StringBuilder("get_response_body cmd= 0x");
    ((StringBuilder)localObject1).append(Integer.toHexString(((oicq_request)localObject2).t));
    ((StringBuilder)localObject1).append(" subCmd= 0x");
    ((StringBuilder)localObject1).append(Integer.toHexString(((oicq_request)localObject2).u));
    ((StringBuilder)localObject1).append(" type:");
    ((StringBuilder)localObject1).append(i3);
    ((StringBuilder)localObject1).append(" ret:");
    if (paramInt1 > 0)
    {
      paramArrayOfByte = new StringBuilder("0x");
      paramArrayOfByte.append(Integer.toHexString(paramInt1));
      paramArrayOfByte = paramArrayOfByte.toString();
    }
    else
    {
      paramArrayOfByte = Integer.valueOf(paramInt1);
    }
    ((StringBuilder)localObject1).append(paramArrayOfByte);
    paramArrayOfByte = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(((oicq_request)localObject2).x.f);
    util.LOGI(paramArrayOfByte, ((StringBuilder)localObject1).toString());
    if (paramInt1 == 0)
    {
      ((oicq_request)localObject2).a(null);
    }
    else
    {
      new tlv_t508().get_tlv((byte[])localObject3, paramInt2, ((oicq_request)localObject2).c - paramInt2 - 1);
      if (tlv_t508.doFetch)
      {
        paramArrayOfByte = new ErrMsg();
        paramInt2 = new j(((oicq_request)localObject2).x, ((oicq_request)localObject2).t, ((oicq_request)localObject2).u, paramArrayOfByte).b(paramInt1);
        if (paramInt2 != -1000)
        {
          ((oicq_request)localObject2).a(paramArrayOfByte);
          paramInt1 = paramInt2;
        }
      }
    }
    if ((paramInt1 != 10) && (paramInt1 != 161) && (paramInt1 != 162) && (paramInt1 != 164) && (paramInt1 != 165) && (paramInt1 != 166) && (paramInt1 != 154) && ((paramInt1 < 128) || (paramInt1 > 143))) {
      break label7622;
    }
    paramInt1 = -1000;
    label7622:
    if ((i1 != 2) && (i1 != 6) && (i1 != 7)) {
      ((oicq_request)localObject2).a(i1);
    }
    return paramInt1;
  }
  
  public String d(boolean paramBoolean)
  {
    new String();
    if (paramBoolean) {
      return "sslv6.wlogin.qq.com";
    }
    return "wlogin-v6.qq.com";
  }
  
  public Socket d()
  {
    return this.x.ap;
  }
  
  public int e()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getClass().getName());
    ((StringBuilder)localObject1).append(":snd_rcv_req_tcp ...");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.x.f);
    util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
    byte[] arrayOfByte = c();
    localObject2 = d();
    long l1 = 0L;
    Object localObject17 = "";
    localObject1 = "";
    boolean bool1 = false;
    int i2 = 0;
    int i1 = 0;
    int i4 = 0;
    boolean bool2 = false;
    int i3 = 0;
    int i6;
    Object localObject18;
    int i7;
    int i5;
    Object localObject16;
    label516:
    label860:
    label2035:
    Object localObject11;
    label2092:
    Object localObject15;
    for (;;)
    {
      if (i1 < 10)
      {
        if (i1 != 0) {
          util.chg_retry_type(u.u);
        }
        bool1 = util.is_wap_retry(u.u);
        this.q = null;
        if ((i1 != 0) && (this.t != 2066)) {
          a(i2, l1, i4, i1, bool1, bool2);
        }
        i6 = i1;
        l1 = System.currentTimeMillis();
        if (bool1)
        {
          Object localObject8 = new StringBuilder("try http connect ");
          ((StringBuilder)localObject8).append(i6);
          ((StringBuilder)localObject8).append(" ...");
          localObject8 = ((StringBuilder)localObject8).toString();
          Object localObject12 = new StringBuilder();
          ((StringBuilder)localObject12).append(this.x.f);
          util.LOGI((String)localObject8, ((StringBuilder)localObject12).toString());
          localObject18 = a(i6, bool1);
          try
          {
            boolean bool5 = util.is_wap_proxy_retry(u.u);
            boolean bool3;
            boolean bool4;
            if (bool5)
            {
              bool3 = bool5;
              localObject12 = localObject1;
              bool4 = bool5;
              localObject8 = localObject1;
            }
            for (;;)
            {
              for (;;)
              {
                try
                {
                  localObject19 = util.get_proxy_ip();
                  bool3 = bool5;
                  localObject12 = localObject1;
                  bool4 = bool5;
                  localObject8 = localObject1;
                  i7 = util.get_proxy_port();
                  if (localObject19 != null)
                  {
                    bool3 = bool5;
                    localObject12 = localObject1;
                    bool4 = bool5;
                    localObject8 = localObject1;
                    i5 = ((String)localObject19).length();
                    if (i5 > 0)
                    {
                      bool2 = bool5;
                      i5 = i7;
                      localObject16 = localObject19;
                      if (i7 != -1) {
                        break label516;
                      }
                    }
                  }
                  try
                  {
                    localObject8 = new StringBuilder("proxy_ip=");
                    ((StringBuilder)localObject8).append((String)localObject19);
                    ((StringBuilder)localObject8).append(",proxy_port=");
                    ((StringBuilder)localObject8).append(i7);
                    ((StringBuilder)localObject8).append(",set is_wap_proxy_retry=false");
                    localObject8 = ((StringBuilder)localObject8).toString();
                    localObject12 = new StringBuilder();
                    ((StringBuilder)localObject12).append(this.x.f);
                    util.LOGI((String)localObject8, ((StringBuilder)localObject12).toString());
                    bool2 = false;
                    i5 = i7;
                    localObject16 = localObject19;
                  }
                  catch (Exception localException2)
                  {
                    bool2 = false;
                    break label2035;
                  }
                  catch (ConnectException localConnectException2)
                  {
                    bool2 = false;
                    break label2092;
                  }
                  i5 = -1;
                }
                catch (Exception localException3)
                {
                  localObject1 = localConnectException2;
                  bool2 = bool3;
                }
                catch (ConnectException localConnectException3)
                {
                  bool2 = bool4;
                  localObject1 = localException3;
                  break label2092;
                }
                localObject16 = null;
                bool2 = bool5;
                Object localObject13;
                Object localObject9;
                if (bool2)
                {
                  bool3 = bool2;
                  localObject13 = localObject1;
                  bool4 = bool2;
                  localObject9 = localObject1;
                  localObject19 = new StringBuilder("http://");
                  bool3 = bool2;
                  localObject13 = localObject1;
                  bool4 = bool2;
                  localObject9 = localObject1;
                  ((StringBuilder)localObject19).append((String)localObject16);
                  bool3 = bool2;
                  localObject13 = localObject1;
                  bool4 = bool2;
                  localObject9 = localObject1;
                  ((StringBuilder)localObject19).append(":");
                  bool3 = bool2;
                  localObject13 = localObject1;
                  bool4 = bool2;
                  localObject9 = localObject1;
                  ((StringBuilder)localObject19).append(i5);
                  bool3 = bool2;
                  localObject13 = localObject1;
                  bool4 = bool2;
                  localObject9 = localObject1;
                  ((StringBuilder)localObject19).append("/cgi-bin/wlogin_proxy_login");
                  bool3 = bool2;
                  localObject13 = localObject1;
                  bool4 = bool2;
                  localObject9 = localObject1;
                  localObject16 = new URL(((StringBuilder)localObject19).toString());
                }
                else
                {
                  bool3 = bool2;
                  localObject13 = localObject1;
                  bool4 = bool2;
                  localObject9 = localObject1;
                  this.q = a.a((String)localObject18, 0, this.x.l);
                  bool3 = bool2;
                  localObject13 = localObject1;
                  bool4 = bool2;
                  localObject9 = localObject1;
                  if (this.q == null) {
                    break label4153;
                  }
                  bool3 = bool2;
                  localObject13 = localObject1;
                  bool4 = bool2;
                  localObject9 = localObject1;
                  localObject16 = this.q.getAddress().getHostAddress();
                  bool3 = bool2;
                  localObject13 = localObject1;
                  bool4 = bool2;
                  localObject9 = localObject1;
                  bool5 = ((String)localObject1).equals(localObject16);
                  if (!bool5)
                  {
                    try
                    {
                      this.q = null;
                      localObject1 = localObject16;
                    }
                    catch (Exception localException4)
                    {
                      localObject1 = localObject16;
                      break label2035;
                    }
                    catch (ConnectException localConnectException4)
                    {
                      localObject1 = localObject16;
                      break label2092;
                    }
                  }
                  else
                  {
                    bool3 = bool2;
                    localObject14 = localObject1;
                    bool4 = bool2;
                    localObject10 = localObject1;
                    throw new Exception("repeated failed http ip ".concat(String.valueOf(localObject1)));
                  }
                  bool3 = bool2;
                  localObject14 = localObject1;
                  bool4 = bool2;
                  localObject10 = localObject1;
                  localObject19 = new StringBuilder("http://");
                  bool3 = bool2;
                  localObject14 = localObject1;
                  bool4 = bool2;
                  localObject10 = localObject1;
                  ((StringBuilder)localObject19).append((String)localObject16);
                  bool3 = bool2;
                  localObject14 = localObject1;
                  bool4 = bool2;
                  localObject10 = localObject1;
                  ((StringBuilder)localObject19).append("/cgi-bin/wlogin_proxy_login");
                  bool3 = bool2;
                  localObject14 = localObject1;
                  bool4 = bool2;
                  localObject10 = localObject1;
                  localObject16 = new URL(((StringBuilder)localObject19).toString());
                }
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                Object localObject10 = localObject1;
                Object localObject19 = new StringBuilder("try http proxy=");
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((StringBuilder)localObject19).append(bool2);
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((StringBuilder)localObject19).append(" connect to ");
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((StringBuilder)localObject19).append(localObject16);
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((StringBuilder)localObject19).append(" host ");
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((StringBuilder)localObject19).append((String)localObject18);
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                localObject19 = ((StringBuilder)localObject19).toString();
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                StringBuilder localStringBuilder = new StringBuilder();
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                localStringBuilder.append(this.x.f);
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                util.LOGI((String)localObject19, localStringBuilder.toString());
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                localObject16 = (HttpURLConnection)((URL)localObject16).openConnection();
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((HttpURLConnection)localObject16).setRequestMethod("POST");
                if (bool2)
                {
                  bool3 = bool2;
                  localObject14 = localObject1;
                  bool4 = bool2;
                  localObject10 = localObject1;
                  ((HttpURLConnection)localObject16).setRequestProperty("X-Online-Host", (String)localObject18);
                }
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((HttpURLConnection)localObject16).setRequestProperty("Content-Type", "application/octet-stream");
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((HttpURLConnection)localObject16).setRequestProperty("Content-Disposition", "attachment; filename=micromsgresp.dat");
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((HttpURLConnection)localObject16).setRequestProperty("Content-Length", String.valueOf(arrayOfByte.length));
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((HttpURLConnection)localObject16).setConnectTimeout(this.x.l);
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((HttpURLConnection)localObject16).setReadTimeout(this.x.l);
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((HttpURLConnection)localObject16).setDoOutput(true);
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((HttpURLConnection)localObject16).setDoInput(true);
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                localObject18 = new StringBuilder();
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((StringBuilder)localObject18).append(this.x.f);
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                util.LOGI("http request connect ...", ((StringBuilder)localObject18).toString());
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                if (!k.a((HttpURLConnection)localObject16, this.x.l))
                {
                  bool3 = bool2;
                  localObject14 = localObject1;
                  bool4 = bool2;
                  localObject10 = localObject1;
                  localObject16 = new StringBuilder();
                  bool3 = bool2;
                  localObject14 = localObject1;
                  bool4 = bool2;
                  localObject10 = localObject1;
                  ((StringBuilder)localObject16).append(this.x.f);
                  bool3 = bool2;
                  localObject14 = localObject1;
                  bool4 = bool2;
                  localObject10 = localObject1;
                  util.LOGI("http request connect failed", ((StringBuilder)localObject16).toString());
                  i1 = i2;
                  if (-1026 == i2) {
                    break label4160;
                  }
                  i1 = -1000;
                  break label4160;
                }
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                localObject18 = new StringBuilder();
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((StringBuilder)localObject18).append(this.x.f);
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                util.LOGI("http request write ...", ((StringBuilder)localObject18).toString());
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                localObject18 = ((HttpURLConnection)localObject16).getOutputStream();
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((OutputStream)localObject18).write(arrayOfByte, 0, arrayOfByte.length);
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                ((OutputStream)localObject18).flush();
                bool3 = bool2;
                localObject14 = localObject1;
                bool4 = bool2;
                localObject10 = localObject1;
                i5 = ((HttpURLConnection)localObject16).getResponseCode();
                bool4 = bool2;
                localObject10 = localObject1;
                try
                {
                  localObject14 = "http request response code=".concat(String.valueOf(i5));
                  bool4 = bool2;
                  localObject10 = localObject1;
                  localObject18 = new StringBuilder();
                  bool4 = bool2;
                  localObject10 = localObject1;
                  ((StringBuilder)localObject18).append(this.x.f);
                  bool4 = bool2;
                  localObject10 = localObject1;
                  util.LOGI((String)localObject14, ((StringBuilder)localObject18).toString());
                  if (200 != i5)
                  {
                    bool4 = bool2;
                    localObject10 = localObject1;
                    util.LOGI("http request error ret:".concat(String.valueOf(i5)), "");
                    i1 = i6 + 1;
                    i2 = -1000;
                    break;
                  }
                  bool4 = bool2;
                  localObject10 = localObject1;
                  localObject16 = ((HttpURLConnection)localObject16).getInputStream();
                  localObject14 = localObject2;
                  localObject2 = localObject16;
                  localObject10 = localObject1;
                  localObject1 = localObject14;
                }
                catch (Exception localException5)
                {
                  i2 = i5;
                }
              }
            }
          }
          catch (Exception localException6)
          {
            Object localObject14 = new StringBuilder("http request exception");
            ((StringBuilder)localObject14).append(localException6.toString());
            util.LOGI(((StringBuilder)localObject14).toString(), "");
            if (-1026 != i2) {
              i2 = -1000;
            }
            i1 = i6 + 1;
          }
          catch (ConnectException localConnectException5)
          {
            localObject11 = new StringBuilder("http request connect exception");
            ((StringBuilder)localObject11).append(localConnectException5.toString());
            util.LOGI(((StringBuilder)localObject11).toString(), "");
            i1 = i6 + 1;
            i2 = -1026;
          }
        }
        else
        {
          localObject11 = new StringBuilder("try bin connect ");
          ((StringBuilder)localObject11).append(i6);
          ((StringBuilder)localObject11).append(" ...");
          localObject11 = ((StringBuilder)localObject11).toString();
          localObject15 = new StringBuilder();
          ((StringBuilder)localObject15).append(this.x.f);
          util.LOGI((String)localObject11, ((StringBuilder)localObject15).toString());
          localObject11 = localObject17;
          if (localObject2 == null)
          {
            localObject11 = "";
            if (this.q == null)
            {
              localObject11 = a(i6, bool1);
              localObject15 = new StringBuilder("DNS for ");
              ((StringBuilder)localObject15).append((String)localObject11);
              ((StringBuilder)localObject15).append(" request ...");
              localObject15 = ((StringBuilder)localObject15).toString();
              localObject16 = new StringBuilder();
              ((StringBuilder)localObject16).append(this.x.f);
              util.LOGI((String)localObject15, ((StringBuilder)localObject16).toString());
            }
          }
        }
      }
    }
    label3144:
    label3280:
    label4177:
    for (;;)
    {
      try
      {
        for (;;)
        {
          this.r = e(bool1);
          this.q = a.a((String)localObject11, this.r, this.x.l);
          localObject15 = this.q;
          if ((localObject15 != null) && (((InetSocketAddress)localObject15).getAddress() == null))
          {
            if (this.q.getAddress() == null)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.x.f);
              util.LOGI("_server_ip get address failed", ((StringBuilder)localObject2).toString());
            }
            i1 = i6 + 1;
            this.q = null;
            a(null);
            i2 = -1007;
            i4 = 1;
            localObject2 = null;
            break;
          }
          localObject15 = this.q;
          if (localObject15 == null)
          {
            if (localObject15 == null)
            {
              localObject2 = new StringBuilder("DNS for ");
              ((StringBuilder)localObject2).append((String)localObject11);
              ((StringBuilder)localObject2).append(" request failed");
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject11 = new StringBuilder();
              ((StringBuilder)localObject11).append(this.x.f);
              util.LOGI((String)localObject2, ((StringBuilder)localObject11).toString());
              i2 = -1007;
            }
            else
            {
              localObject2 = "repeated failed bin ip ".concat(String.valueOf(localObject17));
              localObject11 = new StringBuilder();
              ((StringBuilder)localObject11).append(this.x.f);
              util.LOGI((String)localObject2, ((StringBuilder)localObject11).toString());
              if (-1026 != i2) {
                i2 = -1000;
              }
            }
            i1 = i6 + 1;
            this.q = null;
            a(null);
            i4 = 1;
            localObject2 = null;
            break;
          }
          localObject15 = ((InetSocketAddress)localObject15).getAddress().getHostAddress();
          localObject16 = new StringBuilder("DNS for ");
          ((StringBuilder)localObject16).append((String)localObject11);
          ((StringBuilder)localObject16).append("(");
          ((StringBuilder)localObject16).append(this.q.toString());
          ((StringBuilder)localObject16).append(") request OK");
          localObject11 = ((StringBuilder)localObject16).toString();
          localObject16 = new StringBuilder();
          ((StringBuilder)localObject16).append(this.x.f);
          util.LOGI((String)localObject11, ((StringBuilder)localObject16).toString());
          localObject11 = localObject15;
          i4 = 1;
          if (localObject2 != null) {
            break label4174;
          }
          try
          {
            for (;;)
            {
              localObject2 = new StringBuilder("tcp connect to ");
              ((StringBuilder)localObject2).append(this.q);
              ((StringBuilder)localObject2).append(" request ...");
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject15 = new StringBuilder();
              ((StringBuilder)localObject15).append(this.x.f);
              util.LOGI((String)localObject2, ((StringBuilder)localObject15).toString());
              localObject2 = new Socket();
              a((Socket)localObject2);
              ((Socket)localObject2).connect(this.q, this.x.l);
              ((Socket)localObject2).setSoTimeout(this.x.l);
              ((Socket)localObject2).setReceiveBufferSize(this.s.length);
              localObject15 = new StringBuilder("tcp connect to ");
              ((StringBuilder)localObject15).append(this.q);
              ((StringBuilder)localObject15).append(" OK");
              localObject15 = ((StringBuilder)localObject15).toString();
              localObject16 = new StringBuilder();
              ((StringBuilder)localObject16).append(this.x.f);
              util.LOGI((String)localObject15, ((StringBuilder)localObject16).toString());
              localObject15 = new StringBuilder();
              ((StringBuilder)localObject15).append(this.x.f);
              util.LOGI("tcp request write ...", ((StringBuilder)localObject15).toString());
              localObject15 = ((Socket)localObject2).getOutputStream();
              ((OutputStream)localObject15).write(arrayOfByte, 0, arrayOfByte.length);
              ((OutputStream)localObject15).flush();
              localObject16 = ((Socket)localObject2).getInputStream();
              localObject15 = localObject2;
              localObject2 = localObject16;
              localObject16 = localObject1;
              localObject17 = localObject11;
              localObject1 = localObject15;
              localObject11 = localObject16;
              try
              {
                for (;;)
                {
                  localObject15 = new StringBuilder();
                  ((StringBuilder)localObject15).append(this.x.f);
                  util.LOGI("recv data from server ...", ((StringBuilder)localObject15).toString());
                  i2 = 0;
                  for (i5 = 0; i2 < this.f + 1; i5 = i7)
                  {
                    i7 = ((InputStream)localObject2).read(this.s, i2, this.f + 1 - i2);
                    i5 = i7;
                    if (i7 < 0) {
                      break;
                    }
                    i2 += i7;
                  }
                  Object localObject3;
                  if (i5 < 0)
                  {
                    util.LOGI("recv from server with ret:".concat(String.valueOf(i5)), "");
                    i1 = i6 + 1;
                    if (!bool1)
                    {
                      try
                      {
                        ((Socket)localObject1).close();
                        this.q = null;
                        try
                        {
                          a(null);
                          localObject2 = null;
                        }
                        catch (Throwable localThrowable1) {}
                        localObject1 = null;
                      }
                      catch (Throwable localThrowable2) {}
                      break label3586;
                    }
                    else
                    {
                      localObject3 = localObject1;
                    }
                    i2 = -1000;
                    localObject1 = localObject11;
                    break;
                  }
                  i2 = b(this.s);
                  try
                  {
                    for (;;)
                    {
                      if (i2 > this.f + 1) {
                        break label3303;
                      }
                      localObject3 = new StringBuilder("recv from server with all_len:");
                      ((StringBuilder)localObject3).append(i2);
                      ((StringBuilder)localObject3).append(" head_len:");
                      ((StringBuilder)localObject3).append(this.f);
                      util.LOGI(((StringBuilder)localObject3).toString(), "");
                      i3 = i6 + 1;
                      if (bool1) {
                        break label3280;
                      }
                      i1 = i3;
                      try
                      {
                        ((Socket)localObject1).close();
                        i1 = i3;
                        this.q = null;
                        i1 = i3;
                        try
                        {
                          a(null);
                          localObject3 = null;
                        }
                        catch (Throwable localThrowable3)
                        {
                          i3 = i2;
                        }
                      }
                      catch (Throwable localThrowable4)
                      {
                        i3 = i2;
                      }
                    }
                    break label3144;
                    Object localObject4 = localObject1;
                    i5 = i2;
                    i2 = -1000;
                    localObject1 = localObject11;
                    i1 = i3;
                    i3 = i5;
                    break;
                    label3303:
                    if (i2 >= this.s.length)
                    {
                      localObject4 = new StringBuilder("recv from server with all_len:");
                      ((StringBuilder)localObject4).append(i2);
                      ((StringBuilder)localObject4).append(" buf_len:");
                      ((StringBuilder)localObject4).append(this.s.length);
                      util.LOGI(((StringBuilder)localObject4).toString(), "");
                      i3 = i6 + 1;
                      if (!bool1)
                      {
                        i1 = i3;
                        ((Socket)localObject1).close();
                        i1 = i3;
                        this.q = null;
                        i1 = i3;
                        a(null);
                        localObject4 = null;
                      }
                      else
                      {
                        localObject4 = localObject1;
                      }
                      i5 = i2;
                      i2 = -1000;
                      localObject1 = localObject11;
                      i1 = i3;
                      i3 = i5;
                      break;
                    }
                    i7 = this.f + 1;
                    i3 = i2 - i7;
                    for (;;)
                    {
                      if (i3 <= 0) {
                        break label4177;
                      }
                      int i8 = ((InputStream)localObject4).read(this.s, i7, i3);
                      i5 = i8;
                      if (i8 == -1) {
                        break;
                      }
                      i7 += i8;
                      i3 -= i8;
                      i5 = i8;
                    }
                    if (i5 == -1)
                    {
                      util.LOGI("recv from server in loop with ret:".concat(String.valueOf(i5)), "");
                      i3 = i6 + 1;
                      if (!bool1)
                      {
                        i1 = i3;
                        ((Socket)localObject1).close();
                        i1 = i3;
                        this.q = null;
                        i1 = i3;
                        a(null);
                        localObject4 = null;
                      }
                      else
                      {
                        localObject4 = localObject1;
                      }
                      i5 = i2;
                      i2 = -1000;
                      localObject1 = localObject11;
                      i1 = i3;
                      i3 = i5;
                      break;
                    }
                    i3 = i2;
                    i2 = i5;
                  }
                  catch (Throwable localThrowable5)
                  {
                    i1 = i6;
                    i3 = i2;
                  }
                }
                localObject15 = new StringBuilder("recv from server throw:");
              }
              catch (Throwable localThrowable6)
              {
                i1 = i6;
              }
            }
            ((StringBuilder)localObject15).append(Log.getStackTraceString(localThrowable6));
            util.LOGI(((StringBuilder)localObject15).toString(), "");
            i1 += 1;
            if (!bool1) {}
            try
            {
              if (((Socket)localObject1).isConnected()) {
                ((Socket)localObject1).close();
              }
            }
            catch (Exception localException1)
            {
              Object localObject5;
              Object localObject6;
              Object localObject7;
              break label3644;
            }
            this.q = null;
            a(null);
            localObject5 = null;
            break label3664;
            localObject5 = localObject1;
            i2 = -1000;
            localObject1 = localObject11;
          }
          catch (Throwable localThrowable7)
          {
            localObject15 = new StringBuilder("tcp request throw");
            ((StringBuilder)localObject15).append(Log.getStackTraceString(localThrowable7));
            util.LOGI(((StringBuilder)localObject15).toString(), "");
            if (-1026 != i2) {
              i2 = -1000;
            }
            i1 = i6 + 1;
            this.q = null;
            a(null);
            localObject6 = null;
            localObject17 = localObject11;
          }
          catch (ConnectException localConnectException1)
          {
            localObject15 = new StringBuilder("tcp request connect exception");
            ((StringBuilder)localObject15).append(localConnectException1.toString());
            util.LOGI(((StringBuilder)localObject15).toString(), "");
            i1 = i6 + 1;
            this.q = null;
            a(null);
            localObject7 = null;
            i2 = -1026;
            localObject17 = localObject11;
          }
        }
        break;
        i5 = i1;
        if (i5 >= 6)
        {
          i1 = i2;
          if (-1026 != i2) {
            i1 = -1000;
          }
        }
        else
        {
          i1 = 0;
        }
        if (i1 == 0) {
          b(this.s, i3);
        }
        if ((i1 == 0) && (this.t != 2066))
        {
          localObject1 = new report_t3();
          ((report_t3)localObject1)._cmd = this.t;
          ((report_t3)localObject1)._sub = this.u;
          ((report_t3)localObject1)._rst2 = i1;
          ((report_t3)localObject1)._used = ((int)(System.currentTimeMillis() - l1));
          ((report_t3)localObject1)._try = i5;
          ((report_t3)localObject1)._host = J;
          if (((report_t3)localObject1)._host == null) {
            ((report_t3)localObject1)._host = "";
          }
          localObject7 = this.q;
          if (localObject7 == null) {
            ((report_t3)localObject1)._ip = "";
          } else {
            ((report_t3)localObject1)._ip = ((InetSocketAddress)localObject7).getAddress().getHostAddress();
          }
          ((report_t3)localObject1)._port = this.r;
          ((report_t3)localObject1)._conn = i4;
          ((report_t3)localObject1)._net = u.E;
          ((report_t3)localObject1)._str = "";
          ((report_t3)localObject1)._slen = arrayOfByte.length;
          ((report_t3)localObject1)._rlen = i3;
          if (bool1)
          {
            if (bool2) {
              ((report_t3)localObject1)._wap = 2;
            } else {
              ((report_t3)localObject1)._wap = 1;
            }
          }
          else {
            ((report_t3)localObject1)._wap = 0;
          }
          u.at.add_t3((report_t3)localObject1);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getClass().getName());
        ((StringBuilder)localObject1).append(":snd_rcv_req_tcp ret=");
        ((StringBuilder)localObject1).append(i1);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject7 = new StringBuilder();
        ((StringBuilder)localObject7).append(this.x.f);
        util.LOGI((String)localObject1, ((StringBuilder)localObject7).toString());
        return i1;
      }
      catch (Exception localException7)
      {
        continue;
      }
      localObject16 = localObject18;
      break label860;
      i5 = i6 + 1;
      i2 = i1;
      i1 = i5;
      break;
    }
  }
  
  public int e(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 443;
    }
    return 443;
  }
  
  public int f()
  {
    return u.b(this.x.h)._last_flowid;
  }
  
  public void g()
  {
    this.z = true;
  }
  
  public static enum EncryptionMethod
  {
    EM_ECDH,  EM_ST;
    
    private EncryptionMethod() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.oicq_request
 * JD-Core Version:    0.7.0.1
 */