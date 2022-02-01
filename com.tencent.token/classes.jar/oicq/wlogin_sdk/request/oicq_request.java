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
    localreport_t3._host = H;
    if (localreport_t3._host == null) {
      localreport_t3._host = "";
    }
    InetSocketAddress localInetSocketAddress = this.q;
    if (localInetSocketAddress == null) {
      localreport_t3._ip = "";
    } else {
      localreport_t3._ip = localInetSocketAddress.getAddress().getHostAddress();
    }
    localreport_t3._port = c(paramBoolean1);
    localreport_t3._conn = paramInt2;
    localreport_t3._net = t.D;
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
    t.an.add_t3(localreport_t3);
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
    paramtlv_t161 = paramtlv_t161.get_data();
    int i1 = paramtlv_t161.length;
    if (localtlv_t173.get_tlv(paramtlv_t161, 2, i1) > 0) {
      a(localtlv_t173);
    }
    if (localtlv_t172.get_tlv(paramtlv_t161, 2, i1) > 0)
    {
      paramtlv_t161 = this.x;
      paramtlv_t161.m = 1;
      paramtlv_t161.r = localtlv_t172.get_data();
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
          return 0;
        }
        i4 = util.buf_to_int8(paramtlv_t173, i2);
        int i6 = paramtlv_t173.length;
        i2 = i5 + 2;
        if (i6 < i2) {
          return 0;
        }
        i6 = util.buf_to_int16(paramtlv_t173, i5);
        int i7 = paramtlv_t173.length;
        i5 = i2 + i6;
        if (i7 < i5) {
          return 0;
        }
        byte[] arrayOfByte = new byte[i6];
        System.arraycopy(paramtlv_t173, i2, arrayOfByte, 0, i6);
        i6 = paramtlv_t173.length;
        i2 = i5 + 2;
        if (i6 < i2) {
          return 0;
        }
        a(i4, arrayOfByte, util.buf_to_int16(paramtlv_t173, i5));
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
    this.c = 0;
    System.arraycopy(paramArrayOfByte1, 0, this.h, paramInt1, paramArrayOfByte1.length);
    this.c += this.f + 2 + paramArrayOfByte1.length;
    return 0;
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    paramInt /= 2;
    String str1;
    String str2;
    if (F != 0)
    {
      str1 = G;
      if ((str1 != null) && (str1.length() > 0))
      {
        str2 = G;
        break label183;
      }
    }
    if (paramInt < 1)
    {
      if (paramBoolean)
      {
        if (t.D == 1)
        {
          str1 = new String(util.get_wap_server_host1(t.t));
          break label141;
        }
        if (t.D == 2)
        {
          str1 = new String(util.get_wap_server_host2(t.t));
          break label141;
        }
      }
      else
      {
        if (t.D == 1)
        {
          str1 = new String(util.get_server_host1(t.t));
          break label141;
        }
        if (t.D == 2)
        {
          str1 = new String(util.get_server_host2(t.t));
          break label141;
        }
      }
      str1 = "";
      label141:
      str2 = str1;
      if (str1.length() <= 0) {
        str2 = b(paramBoolean);
      }
    }
    else if (paramInt < 2)
    {
      str2 = b(paramBoolean);
    }
    else
    {
      str2 = a(paramBoolean);
    }
    label183:
    H = str2;
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
        if (t.D == 1) {
          util.set_server_host1(t.t, paramArrayOfByte);
        } else if (t.D == 2) {
          util.set_server_host2(t.t, paramArrayOfByte);
        }
      }
      else if (paramInt1 == 2) {
        if (t.D == 1) {
          util.set_wap_server_host1(t.t, paramArrayOfByte);
        } else if (t.D == 2) {
          util.set_wap_server_host2(t.t, paramArrayOfByte);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("net type:");
      localStringBuilder.append(t.D);
      localStringBuilder.append(" type:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" host:");
      localStringBuilder.append(new String(paramArrayOfByte));
      localStringBuilder.append(" port:");
      localStringBuilder.append(paramInt2);
      paramArrayOfByte = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.x.f);
      util.LOGI(paramArrayOfByte, localStringBuilder.toString());
      return;
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    a(this.i, this.t, paramLong, this.m, t.w, this.p, paramArrayOfByte);
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
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("getRequestEncrptedPackage unknown encryption method ");
    paramArrayOfByte.append(paramEncryptionMethod);
    paramArrayOfByte = paramArrayOfByte.toString();
    paramEncryptionMethod = new StringBuilder();
    paramEncryptionMethod.append("");
    paramEncryptionMethod.append(paramLong);
    util.LOGI(paramArrayOfByte, paramEncryptionMethod.toString());
  }
  
  public void a(Socket paramSocket)
  {
    this.x.aj = paramSocket;
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
      label45:
      break label45;
    }
    localasync_context._last_err_msg = new ErrMsg(0, "", "", "");
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
    localObject1 = ((tlv_t145)localObject1).get_tlv_145(t.A);
    localObject4 = new byte[paramtlv_t169.length + 3 + localObject3.length + localObject2.length + localObject1.length];
    localObject4[0] = 64;
    util.int16_to_buf((byte[])localObject4, 1, 4);
    System.arraycopy(paramtlv_t169, 0, localObject4, 3, paramtlv_t169.length);
    i1 = 3 + paramtlv_t169.length;
    System.arraycopy(localObject3, 0, localObject4, i1, localObject3.length);
    i1 += localObject3.length;
    System.arraycopy(localObject2, 0, localObject4, i1, localObject2.length);
    System.arraycopy(localObject1, 0, localObject4, i1 + localObject2.length, localObject1.length);
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
  
  protected byte[] a(byte[] paramArrayOfByte1, EncryptionMethod paramEncryptionMethod, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (EncryptionMethod.EM_ST == paramEncryptionMethod) {
      return b(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
    }
    if (EncryptionMethod.EM_ECDH == paramEncryptionMethod) {
      return a(paramArrayOfByte1);
    }
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("encryptBody unknown encryption method ");
    paramArrayOfByte1.append(paramEncryptionMethod);
    util.LOGI(paramArrayOfByte1.toString(), "");
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
      i1 = paramArrayOfByte1.length;
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
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, 2 + paramArrayOfByte2.length, paramArrayOfByte1.length);
    int i1 = paramArrayOfByte1.length;
    return paramArrayOfByte3;
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null) && (paramArrayOfByte4 != null))
    {
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
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte4, i1 + paramArrayOfByte3.length, paramArrayOfByte1.length);
      i1 = paramArrayOfByte1.length;
      return paramArrayOfByte4;
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("enrypt method ");
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
        t.an.attr_api(2494911);
        localObject1 = t.b(this.x.h);
        if (localObject1 != null)
        {
          localObject2 = this.x;
          ((t)localObject2).c(((t)localObject2).f, ((async_context)localObject1)._sappid);
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
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.x.f);
        util.LOGI("decrypted outer body failed", ((StringBuilder)localObject1).toString());
        return -1002;
      }
      i2 = util.buf_to_int16((byte[])localObject1, 0);
      if (i2 > localObject1.length - 2)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("peer public key len wrong ");
        ((StringBuilder)localObject1).append(i2);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
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
          t.an.attr_api(2461266);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
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
        this.c += this.f + 2 + localObject1.length;
      }
      else
      {
        return -1002;
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unknown encryption method ");
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
    localStringBuilder1.append("");
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
      Object localObject2 = new StringBuilder();
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append("WtloginMsfListener uin:");
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
      localStringBuilder2.append("");
      localObject1 = localStringBuilder1;
      localStringBuilder2.append(this.x.f);
      localObject1 = localStringBuilder1;
      util.LOGI((String)localObject2, localStringBuilder2.toString());
      localObject1 = localStringBuilder1;
      paramWUserSigInfo = new WtloginMsfListener(paramString, this.v, arrayOfByte, i2, paramBoolean, paramWUserSigInfo);
      localObject1 = localStringBuilder1;
      paramString = new Thread(paramWUserSigInfo);
      localObject1 = localStringBuilder1;
      paramString.start();
      localObject1 = localStringBuilder1;
      paramString.join(i2);
      localObject1 = localStringBuilder1;
      paramString = paramWUserSigInfo.getRetData();
      if (paramString == null)
      {
        localObject1 = paramString;
        localStringBuilder1 = new StringBuilder();
        localObject1 = paramString;
        localStringBuilder1.append("recv data from server failed, ret=");
        localObject1 = paramString;
        localStringBuilder1.append(paramWUserSigInfo.getRet());
        localObject1 = paramString;
        paramWUserSigInfo = localStringBuilder1.toString();
        localObject1 = paramString;
        localStringBuilder1 = new StringBuilder();
        localObject1 = paramString;
        localStringBuilder1.append("");
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
      paramWUserSigInfo.append("");
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
      t.an.add_t3(paramWUserSigInfo);
    }
    paramString = new StringBuilder();
    paramString.append(getClass().getName());
    paramString.append(":snd_rcv_req_msf ret=");
    paramString.append(i1);
    paramString = paramString.toString();
    paramWUserSigInfo = new StringBuilder();
    paramWUserSigInfo.append("");
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
    return arrayOfString[java.lang.Math.abs(new java.util.Random().nextInt() % arrayOfString.length)];
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
    if (paramBoolean) {
      return 443;
    }
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
    int i1 = this.c;
    byte[] arrayOfByte = new byte[i1];
    System.arraycopy(this.h, 0, arrayOfByte, 0, i1);
    return arrayOfByte;
  }
  
  public byte[] c(byte[] paramArrayOfByte)
  {
    Object localObject1;
    int i1;
    if ((t.B != null) && (t.B.length > 0))
    {
      localObject1 = new byte[16];
      if (t.B.length > localObject1.length)
      {
        System.arraycopy(t.B, 0, localObject1, 0, localObject1.length);
      }
      else
      {
        System.arraycopy(t.B, 0, localObject1, 0, t.B.length);
        int i2;
        for (i1 = t.B.length; i1 < localObject1.length; i1 = i2)
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
      t.b(this.x.h)._tgtgt_key = ((byte[])localObject1);
      return paramArrayOfByte;
    }
    return (byte[])null;
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
      i1 = paramArrayOfByte3.length;
      return MD5.toMD5Byte(arrayOfByte);
    }
    return new byte[16];
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 5) {
      return -1009;
    }
    tlv_t104 localtlv_t104 = new tlv_t104();
    tlv_t105 localtlv_t105 = new tlv_t105();
    Object localObject2 = new tlv_t113();
    Object localObject17 = new tlv_t119();
    tlv_t10d localtlv_t10d = new tlv_t10d();
    tlv_t10e localtlv_t10e = new tlv_t10e();
    tlv_t10a localtlv_t10a = new tlv_t10a();
    tlv_t114 localtlv_t114 = new tlv_t114();
    Object localObject3 = new tlv_t103();
    Object localObject1 = new tlv_t11a();
    Object localObject4 = new tlv_t102();
    Object localObject5 = new tlv_t10b();
    Object localObject6 = new tlv_t11c();
    tlv_t11d localtlv_t11d = new tlv_t11d();
    Object localObject7 = new tlv_t120();
    Object localObject8 = new tlv_t121();
    tlv_t130 localtlv_t130 = new tlv_t130();
    Object localObject16 = new tlv_t108();
    tlv_t106 localtlv_t106 = new tlv_t106();
    tlv_t10c localtlv_t10c = new tlv_t10c();
    Object localObject9 = new tlv_t125();
    tlv_t11f localtlv_t11f = new tlv_t11f();
    tlv_t138 localtlv_t138 = new tlv_t138();
    tlv_t132 localtlv_t132 = new tlv_t132();
    tlv_t149 localtlv_t149 = new tlv_t149();
    tlv_t150 localtlv_t150 = new tlv_t150();
    tlv_t143 localtlv_t143 = new tlv_t143();
    tlv_t305 localtlv_t305 = new tlv_t305();
    tlv_t164 localtlv_t164 = new tlv_t164();
    tlv_t165 localtlv_t165 = new tlv_t165();
    tlv_t167 localtlv_t167 = new tlv_t167();
    tlv_t16a localtlv_t16a = new tlv_t16a();
    tlv_t169 localtlv_t169 = new tlv_t169();
    tlv_t161 localtlv_t161 = new tlv_t161();
    Object localObject13 = new tlv_t171();
    Object localObject12 = new tlv_t(1298);
    Object localObject11 = new tlv_t16d();
    tlv_t174 localtlv_t174 = new tlv_t174();
    tlv_t178 localtlv_t178 = new tlv_t178();
    Object localObject19 = new tlv_t179();
    tlv_t17d localtlv_t17d = new tlv_t17d();
    tlv_t17e localtlv_t17e = new tlv_t17e();
    tlv_t126 localtlv_t126 = new tlv_t126();
    tlv_t182 localtlv_t182 = new tlv_t182();
    tlv_t183 localtlv_t183 = new tlv_t183();
    Object localObject10 = new tlv_t186();
    Object localObject18 = new tlv_t402();
    Object localObject14 = new tlv_t403();
    tlv_t136 localtlv_t136 = new tlv_t136();
    tlv_t118 localtlv_t118 = new tlv_t118();
    Object localObject15 = t.b(this.x.h);
    long l3 = ((async_context)localObject15)._sappid;
    long l4 = ((async_context)localObject15)._appid;
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
      case 18: 
        paramInt2 = 7;
        break;
      case 15: 
        paramInt2 = 5;
        break;
      case 13: 
        paramInt2 = 4;
        break;
      case 10: 
      case 11: 
        paramInt2 = 1;
        break;
      case 9: 
        paramInt2 = 0;
        break;
      case 7: 
        paramInt2 = 6;
        break;
      case 4: 
        paramInt2 = 3;
        break;
      case 2: 
        paramInt2 = 2;
        break;
      }
    } else {
      paramInt2 = 0;
    }
    int i2 = c(paramArrayOfByte, paramInt1 + 2);
    int i1 = paramInt1 + 5;
    t localt = this.x;
    localt.d = null;
    if ((i2 != 41) && (i2 != 116))
    {
      if (i2 != 160)
      {
        if (i2 != 176)
        {
          if (i2 != 180)
          {
            if (i2 != 204)
            {
              if (i2 != 208)
              {
                switch (i2)
                {
                default: 
                  switch (i2)
                  {
                  default: 
                    c(paramArrayOfByte, i1, this.c - i1 - 1);
                    break;
                  case 16: 
                    localt.e(localt.f, l3);
                    paramInt1 = localtlv_t130.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1);
                    if (paramInt1 < 0) {
                      break label6300;
                    }
                    this.x.a(localtlv_t130.get_time(), localtlv_t130.get_ipaddr());
                    c(paramArrayOfByte, i1, this.c - i1 - 1);
                  }
                  break;
                case 2: 
                  paramInt1 = localtlv_t104.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1);
                  if (paramInt1 < 0) {
                    break label6300;
                  }
                  ((async_context)localObject15)._t104 = localtlv_t104;
                  localObject1 = new tlv_t192();
                  if (((tlv_t192)localObject1).get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0)
                  {
                    a(new ErrMsg(i2, "", "", ((tlv_t192)localObject1).getUrl()));
                  }
                  else
                  {
                    paramInt1 = localtlv_t105.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1);
                    if (paramInt1 < 0) {
                      break label6300;
                    }
                    ((async_context)localObject15)._t105 = localtlv_t105;
                    if (localtlv_t165.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0) {
                      ((async_context)localObject15)._t165 = localtlv_t165;
                    } else {
                      ((async_context)localObject15)._t165 = new tlv_t165();
                    }
                    a(null);
                  }
                  break;
                case 1: 
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("cmd ");
                  ((StringBuilder)localObject1).append(Integer.toHexString(this.t));
                  ((StringBuilder)localObject1).append(" subcmd ");
                  ((StringBuilder)localObject1).append(Integer.toHexString(this.u));
                  ((StringBuilder)localObject1).append(" result ");
                  ((StringBuilder)localObject1).append(i2);
                  ((StringBuilder)localObject1).append(" will clean sig for uin ");
                  ((StringBuilder)localObject1).append(this.x.f);
                  ((StringBuilder)localObject1).append(" appid ");
                  ((StringBuilder)localObject1).append(l3);
                  util.LOGI(((StringBuilder)localObject1).toString());
                  localObject1 = this.x;
                  ((t)localObject1).e(((t)localObject1).f, l3);
                  c(paramArrayOfByte, i1, this.c - i1 - 1);
                  break;
                case 0: 
                  if (paramInt2 == 1)
                  {
                    if (localt.b == null) {
                      return -1006;
                    }
                    if (localtlv_t150.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0) {
                      this.x.d = localtlv_t150;
                    }
                    if (localtlv_t161.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0) {
                      a(localtlv_t161);
                    }
                    paramInt1 = ((tlv_t119)localObject17).get_tlv(paramArrayOfByte, i1, this.c - i1 - 1, this.x.b);
                  }
                  else
                  {
                    localObject19 = localObject17;
                    if (paramInt2 == 2)
                    {
                      if (localtlv_t183.get_tlv(paramArrayOfByte, i1, this.c - i1) >= 0) {
                        ((async_context)localObject15)._msalt = localtlv_t183.getMsalt();
                      }
                      if (f() == 3)
                      {
                        if (((tlv_t113)localObject2).get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0)
                        {
                          this.x.f = ((tlv_t113)localObject2).get_uin();
                          localObject1 = this.x;
                          ((t)localObject1).a(((t)localObject1).g, Long.valueOf(this.x.f));
                        }
                        if (localtlv_t104.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0) {
                          ((async_context)localObject15)._t104 = localtlv_t104;
                        }
                        paramInt1 = 0;
                        break label6300;
                      }
                      if (localtlv_t150.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0) {
                        this.x.d = localtlv_t150;
                      }
                      if (localtlv_t161.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0) {
                        a(localtlv_t161);
                      }
                      paramInt1 = ((tlv_t119)localObject19).get_tlv(paramArrayOfByte, i1, this.c - i1 - 1, ((async_context)localObject15)._tgtgt_key);
                    }
                    else
                    {
                      localObject18 = localObject2;
                      if ((paramInt2 == 3) || (paramInt2 == 7)) {
                        break label5089;
                      }
                      if (22 == this.u)
                      {
                        paramInt1 = localtlv_t104.get_tlv(paramArrayOfByte, i1, this.c - i1);
                        if (paramInt1 < 0) {
                          break label6300;
                        }
                        ((async_context)localObject15)._t104 = localtlv_t104;
                        paramInt1 = 0;
                        break label6300;
                      }
                      if (localtlv_t150.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0) {
                        this.x.d = localtlv_t150;
                      }
                      if (localtlv_t161.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0) {
                        a(localtlv_t161);
                      }
                      paramInt1 = ((tlv_t119)localObject19).get_tlv(paramArrayOfByte, i1, this.c - i1 - 1, ((async_context)localObject15)._tgtgt_key);
                      s.I = 0;
                    }
                  }
                  if (paramInt1 < 0) {
                    break label6300;
                  }
                  localObject17 = ((tlv_t119)localObject17).get_data();
                  int i3 = localObject17.length;
                  if (localtlv_t149.get_tlv((byte[])localObject17, 2, i3) > 0) {
                    a(localtlv_t149);
                  }
                  if (localtlv_t130.get_tlv((byte[])localObject17, 2, i3) > 0) {
                    this.x.a(localtlv_t130.get_time(), localtlv_t130.get_ipaddr());
                  }
                  if (((tlv_t113)localObject2).get_tlv((byte[])localObject17, 2, i3) >= 0)
                  {
                    this.x.f = ((tlv_t113)localObject2).get_uin();
                    localObject2 = this.x;
                    ((t)localObject2).a(((t)localObject2).g, Long.valueOf(this.x.f));
                  }
                  localObject2 = new tlv_t(1320);
                  if (((tlv_t)localObject2).get_tlv((byte[])localObject17, 2, i3) > 0)
                  {
                    localObject18 = new StringBuilder();
                    ((StringBuilder)localObject18).append("get tlv528 and put into context from seq ");
                    ((StringBuilder)localObject18).append(this.x.h);
                    localObject18 = ((StringBuilder)localObject18).toString();
                    localObject19 = new StringBuilder();
                    ((StringBuilder)localObject19).append("");
                    ((StringBuilder)localObject19).append(this.x.f);
                    util.LOGI((String)localObject18, ((StringBuilder)localObject19).toString());
                    ((async_context)localObject15).tlv528 = ((tlv_t)localObject2);
                  }
                  localtlv_t10d.get_tlv((byte[])localObject17, 2, i3);
                  localtlv_t10e.get_tlv((byte[])localObject17, 2, i3);
                  localtlv_t10a.get_tlv((byte[])localObject17, 2, i3);
                  localtlv_t114.get_tlv((byte[])localObject17, 2, i3);
                  paramInt1 = ((tlv_t11a)localObject1).get_tlv((byte[])localObject17, 2, i3);
                  if (paramInt1 < 0) {
                    break label6300;
                  }
                  if (localtlv_t118.get_tlv((byte[])localObject17, 2, i3) < 0)
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("");
                    ((StringBuilder)localObject2).append(this.x.f);
                    util.LOGI("t118 get failed", ((StringBuilder)localObject2).toString());
                  }
                  if (((tlv_t103)localObject3).get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject3 = ((tlv_t103)localObject3).get_data();
                  } else {
                    localObject3 = null;
                  }
                  if (((tlv_t108)localObject16).get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    util.set_ksid(t.t, ((tlv_t108)localObject16).get_data());
                  }
                  if (((tlv_t102)localObject4).get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject4 = ((tlv_t102)localObject4).get_data();
                  } else {
                    localObject4 = null;
                  }
                  if (((tlv_t10b)localObject5).get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject5 = ((tlv_t10b)localObject5).get_data();
                  } else {
                    localObject5 = null;
                  }
                  if (((tlv_t11c)localObject6).get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject6 = ((tlv_t11c)localObject6).get_data();
                  } else {
                    localObject6 = null;
                  }
                  if (((tlv_t120)localObject7).get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject7 = ((tlv_t120)localObject7).get_data();
                  } else {
                    localObject7 = null;
                  }
                  if (((tlv_t121)localObject8).get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject8 = ((tlv_t121)localObject8).get_data();
                  } else {
                    localObject8 = null;
                  }
                  if (((tlv_t125)localObject9).get_tlv((byte[])localObject17, 2, i3) >= 0)
                  {
                    localObject2 = ((tlv_t125)localObject9).get_openid();
                    localObject9 = ((tlv_t125)localObject9).get_openkey();
                  }
                  else
                  {
                    localObject2 = null;
                    localObject9 = null;
                  }
                  localObject16 = localObject10;
                  if (((tlv_t186)localObject16).get_tlv((byte[])localObject17, 2, i3) >= 0)
                  {
                    localObject10 = this.x.g;
                    if (util.check_uin_account((String)localObject10).booleanValue())
                    {
                      localObject10 = this.x;
                      localObject10 = ((t)localObject10).e(((t)localObject10).f);
                      if ((localObject10 != null) && (((String)localObject10).length() > 0))
                      {
                        localObject18 = this.x;
                        ((t)localObject18).a((String)localObject10, Long.valueOf(((t)localObject18).f), ((tlv_t186)localObject16).getPwdflag());
                      }
                    }
                    else
                    {
                      localObject18 = this.x;
                      ((t)localObject18).a((String)localObject10, Long.valueOf(((t)localObject18).f), ((tlv_t186)localObject16).getPwdflag());
                    }
                    localObject18 = new StringBuilder();
                    ((StringBuilder)localObject18).append("put t186: name: ");
                    ((StringBuilder)localObject18).append((String)localObject10);
                    ((StringBuilder)localObject18).append(" uin: ");
                    ((StringBuilder)localObject18).append(this.x.f);
                    ((StringBuilder)localObject18).append(" pwd=");
                    ((StringBuilder)localObject18).append(((tlv_t186)localObject16).getPwdflag());
                    util.LOGI(((StringBuilder)localObject18).toString(), "");
                  }
                  localObject10 = localObject15;
                  localObject15 = new StringBuilder();
                  ((StringBuilder)localObject15).append("tgt len:");
                  ((StringBuilder)localObject15).append(util.buf_len(localtlv_t10a.get_data()));
                  ((StringBuilder)localObject15).append(" tgt_key len:");
                  ((StringBuilder)localObject15).append(util.buf_len(localtlv_t10d.get_data()));
                  ((StringBuilder)localObject15).append(" st len:");
                  ((StringBuilder)localObject15).append(util.buf_len(localtlv_t114.get_data()));
                  ((StringBuilder)localObject15).append(" st_key len:");
                  ((StringBuilder)localObject15).append(util.buf_len(localtlv_t10e.get_data()));
                  ((StringBuilder)localObject15).append(" stwx_web len:");
                  ((StringBuilder)localObject15).append(util.buf_len((byte[])localObject3));
                  ((StringBuilder)localObject15).append(" lskey len:");
                  ((StringBuilder)localObject15).append(util.buf_len((byte[])localObject6));
                  ((StringBuilder)localObject15).append(" skey len:");
                  ((StringBuilder)localObject15).append(util.buf_len((byte[])localObject7));
                  ((StringBuilder)localObject15).append(" sig64 len:");
                  ((StringBuilder)localObject15).append(util.buf_len((byte[])localObject8));
                  ((StringBuilder)localObject15).append(" openid len:");
                  ((StringBuilder)localObject15).append(util.buf_len((byte[])localObject2));
                  ((StringBuilder)localObject15).append(" openkey len:");
                  ((StringBuilder)localObject15).append(util.buf_len((byte[])localObject9));
                  ((StringBuilder)localObject15).append(" pwdflag: ");
                  ((StringBuilder)localObject15).append(((tlv_t186)localObject16).get_data_len());
                  ((StringBuilder)localObject15).append(" ");
                  ((StringBuilder)localObject15).append(((tlv_t186)localObject16).getPwdflag());
                  localObject15 = ((StringBuilder)localObject15).toString();
                  localObject16 = new StringBuilder();
                  ((StringBuilder)localObject16).append("");
                  ((StringBuilder)localObject16).append(this.x.f);
                  util.LOGI((String)localObject15, ((StringBuilder)localObject16).toString());
                  if (localtlv_t169.get_tlv((byte[])localObject17, 2, i3) >= 0)
                  {
                    localObject15 = a(localtlv_t169);
                    if ((localObject15 != null) && (localObject15.length > 0)) {
                      this.x.j = new WFastLoginInfo((byte[])localObject15);
                    } else {
                      this.x.j = new WFastLoginInfo();
                    }
                  }
                  localObject15 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 3, 0 });
                  if (localtlv_t167.get_tlv((byte[])localObject17, 2, i3) >= 0)
                  {
                    localObject15[0] = localtlv_t167.get_img_type();
                    localObject15[1] = localtlv_t167.get_img_format();
                    localObject15[2] = localtlv_t167.get_img_url();
                  }
                  localObject16 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 5, 0 });
                  paramInt1 = 0;
                  while (paramInt1 < 5)
                  {
                    localObject16[paramInt1] = new byte[0];
                    paramInt1 += 1;
                  }
                  paramInt1 = localtlv_t10c.get_tlv((byte[])localObject17, 2, i3);
                  if ((localtlv_t106.get_tlv((byte[])localObject17, 2, i3) >= 0) && (paramInt1 >= 0))
                  {
                    localObject18 = localtlv_t10c.get_data();
                    localObject16[0] = ((byte[])b(localtlv_t106.get_data(), (byte[])localObject18).clone());
                  }
                  if (localtlv_t16a.get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject16[1] = localtlv_t16a.get_data();
                  }
                  if (((tlv_t403)localObject14).get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject16[4] = ((tlv_t403)localObject14).get_data();
                  }
                  if (((async_context)localObject10)._sec_guid_flag)
                  {
                    localObject16[2] = ((async_context)localObject10)._G;
                    localObject16[3] = ((async_context)localObject10)._dpwd;
                    localObject16[4] = ((async_context)localObject10)._t403.get_data();
                    ((async_context)localObject10)._sec_guid_flag = false;
                  }
                  localObject14 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 15, 0 });
                  paramInt1 = 0;
                  while (paramInt1 < 15)
                  {
                    localObject14[paramInt1] = new byte[0];
                    paramInt1 += 1;
                  }
                  if (localtlv_t136.get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject14[0] = localtlv_t136.get_data();
                  }
                  if (localtlv_t132.get_tlv((byte[])localObject17, 2, i3) >= 0)
                  {
                    localObject14[1] = localtlv_t132.get_access_token();
                    localObject2 = localtlv_t132.get_openid();
                  }
                  if (localtlv_t143.get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject14[2] = localtlv_t143.get_data();
                  }
                  if (localtlv_t305.get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject14[3] = localtlv_t305.get_data();
                  }
                  if (localtlv_t164.get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject14[4] = localtlv_t164.get_data();
                  }
                  if (((tlv_t171)localObject13).get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject14[5] = ((tlv_t171)localObject13).get_data();
                  }
                  if (((tlv_t)localObject12).get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject14[6] = ((tlv_t)localObject12).get_data();
                  }
                  if (((tlv_t16d)localObject11).get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    localObject14[7] = ((tlv_t16d)localObject11).get_data();
                  }
                  localObject11 = new tlv_t199();
                  if (((tlv_t199)localObject11).get_tlv((byte[])localObject17, 2, i3) >= 0)
                  {
                    localObject14[8] = ((tlv_t199)localObject11).getPayToken();
                    localObject2 = ((tlv_t199)localObject11).getOpenId();
                  }
                  localObject11 = new tlv_t200();
                  if (((tlv_t200)localObject11).get_tlv((byte[])localObject17, 2, i3) >= 0)
                  {
                    localObject14[9] = ((tlv_t200)localObject11).getPf();
                    localObject14[10] = ((tlv_t200)localObject11).getPfKey();
                  }
                  localObject11 = new tlv_t(515);
                  if (((tlv_t)localObject11).get_tlv((byte[])localObject17, 2, i3) >= 0)
                  {
                    localObject14[11] = ((tlv_t)localObject11).get_data();
                    util.LOGI("get DA2 in rsp", "");
                  }
                  else
                  {
                    util.LOGI("no DA2 in rsp", "");
                  }
                  localObject11 = new tlv_t(791);
                  if (((tlv_t)localObject11).get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    WloginSigInfo._QRPUSHSig = ((tlv_t)localObject11).get_data();
                  } else {
                    WloginSigInfo._QRPUSHSig = new byte[0];
                  }
                  localObject11 = new tlv_t(307);
                  if (((tlv_t)localObject11).get_tlv((byte[])localObject17, 2, i3) >= 0)
                  {
                    localObject14[13] = ((tlv_t)localObject11).get_data();
                  }
                  else
                  {
                    localObject11 = new StringBuilder();
                    ((StringBuilder)localObject11).append("");
                    ((StringBuilder)localObject11).append(this.x.f);
                    util.LOGW("get t133 failed", ((StringBuilder)localObject11).toString());
                  }
                  localObject11 = new tlv_t(308);
                  if (((tlv_t)localObject11).get_tlv((byte[])localObject17, 2, i3) >= 0)
                  {
                    localObject14[14] = ((tlv_t)localObject11).get_data();
                  }
                  else
                  {
                    localObject11 = new StringBuilder();
                    ((StringBuilder)localObject11).append("");
                    ((StringBuilder)localObject11).append(this.x.f);
                    util.LOGW("get t134 failed", ((StringBuilder)localObject11).toString());
                  }
                  localObject11 = new StringBuilder();
                  ((StringBuilder)localObject11).append("encrypt_a1 len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject16[0]));
                  ((StringBuilder)localObject11).append(" no_pic_sig len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject16[1]));
                  ((StringBuilder)localObject11).append(" G len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject16[2]));
                  ((StringBuilder)localObject11).append(" dpwd len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject16[3]));
                  ((StringBuilder)localObject11).append(" randseed len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject16[4]));
                  ((StringBuilder)localObject11).append(" vkey len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[0]));
                  ((StringBuilder)localObject11).append(" openid len:");
                  ((StringBuilder)localObject11).append(util.buf_len((byte[])localObject2));
                  ((StringBuilder)localObject11).append(" access_token len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[1]));
                  ((StringBuilder)localObject11).append(" d2 len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[2]));
                  ((StringBuilder)localObject11).append(" d2_key len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[3]));
                  ((StringBuilder)localObject11).append(" sid len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[4]));
                  ((StringBuilder)localObject11).append(" aq_sig len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[5]));
                  ((StringBuilder)localObject11).append(" pskey len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[6]));
                  ((StringBuilder)localObject11).append(" super_key len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[7]));
                  ((StringBuilder)localObject11).append(" paytoken len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[8]));
                  ((StringBuilder)localObject11).append(" pf len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[9]));
                  ((StringBuilder)localObject11).append(" pfkey len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[10]));
                  ((StringBuilder)localObject11).append(" da2 len:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[11]));
                  ((StringBuilder)localObject11).append(" wt session ticket:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[13]));
                  ((StringBuilder)localObject11).append(" wt session ticket key:");
                  ((StringBuilder)localObject11).append(util.buf_len(localObject14[14]));
                  localObject11 = ((StringBuilder)localObject11).toString();
                  localObject12 = new StringBuilder();
                  ((StringBuilder)localObject12).append("");
                  ((StringBuilder)localObject12).append(this.x.f);
                  util.LOGI((String)localObject11, ((StringBuilder)localObject12).toString());
                  long l2;
                  if (localtlv_t11f.get_tlv((byte[])localObject17, 2, i3) >= 0) {
                    l2 = localtlv_t11f.get_tk_pri() & 0xFFFFFFFF;
                  } else {
                    l2 = 4294967295L;
                  }
                  localObject11 = new long[7];
                  long l1 = 2160000L;
                  paramInt1 = 2;
                  for (;;)
                  {
                    paramInt1 = localtlv_t138.get_tlv((byte[])localObject17, paramInt1, i3);
                    if (paramInt1 < 0) {
                      break;
                    }
                    if (localtlv_t138.get_a2_chg_time() != 0) {
                      l1 = localtlv_t138.get_a2_chg_time();
                    }
                    if (localtlv_t138.get_lskey_chg_time() != 0) {
                      localObject11[0] = localtlv_t138.get_lskey_chg_time();
                    } else {
                      localObject11[0] = 1641600L;
                    }
                    if (localtlv_t138.get_skey_chg_time() != 0) {
                      localObject11[1] = localtlv_t138.get_skey_chg_time();
                    } else {
                      localObject11[1] = 86400L;
                    }
                    if (localtlv_t138.get_vkey_chg_time() != 0) {
                      localObject11[2] = localtlv_t138.get_vkey_chg_time();
                    } else {
                      localObject11[2] = 1728000L;
                    }
                    if (localtlv_t138.get_a8_chg_time() != 0) {
                      localObject11[3] = localtlv_t138.get_a8_chg_time();
                    } else {
                      localObject11[3] = 72000L;
                    }
                    if (localtlv_t138.get_stweb_chg_time() != 0) {
                      localObject11[4] = localtlv_t138.get_stweb_chg_time();
                    } else {
                      localObject11[4] = 6000L;
                    }
                    if (localtlv_t138.get_d2_chg_time() != 0) {
                      localObject11[5] = localtlv_t138.get_d2_chg_time();
                    } else {
                      localObject11[5] = 1728000L;
                    }
                    if (localtlv_t138.get_sid_chg_time() != 0) {
                      localObject11[6] = localtlv_t138.get_sid_chg_time();
                    } else {
                      localObject11[6] = 1728000L;
                    }
                  }
                  localObject12 = new StringBuilder();
                  ((StringBuilder)localObject12).append("sappid:");
                  ((StringBuilder)localObject12).append(l3);
                  ((StringBuilder)localObject12).append(" appid:");
                  ((StringBuilder)localObject12).append(l4);
                  ((StringBuilder)localObject12).append(" app_pri:");
                  ((StringBuilder)localObject12).append(l2);
                  ((StringBuilder)localObject12).append(" login_bitmap:");
                  ((StringBuilder)localObject12).append(((async_context)localObject10)._login_bitmap);
                  ((StringBuilder)localObject12).append(" tk_valid:");
                  ((StringBuilder)localObject12).append(0L);
                  ((StringBuilder)localObject12).append(" a2_valid:");
                  ((StringBuilder)localObject12).append(l1);
                  ((StringBuilder)localObject12).append(" lskey_valid:");
                  ((StringBuilder)localObject12).append(localObject11[0]);
                  ((StringBuilder)localObject12).append(" skey_valid:");
                  ((StringBuilder)localObject12).append(localObject11[1]);
                  ((StringBuilder)localObject12).append(" vkey_valid:");
                  ((StringBuilder)localObject12).append(localObject11[2]);
                  ((StringBuilder)localObject12).append(" a8_valid:");
                  ((StringBuilder)localObject12).append(localObject11[3]);
                  ((StringBuilder)localObject12).append(" stweb_valid:");
                  ((StringBuilder)localObject12).append(localObject11[4]);
                  ((StringBuilder)localObject12).append(" d2_valid:");
                  ((StringBuilder)localObject12).append(localObject11[5]);
                  ((StringBuilder)localObject12).append(" sid_valid:");
                  ((StringBuilder)localObject12).append(localObject11[6]);
                  localObject12 = ((StringBuilder)localObject12).toString();
                  localObject13 = new StringBuilder();
                  ((StringBuilder)localObject13).append("");
                  ((StringBuilder)localObject13).append(this.x.f);
                  util.LOGI((String)localObject12, ((StringBuilder)localObject13).toString());
                  localObject12 = new WloginSimpleInfo();
                  ((WloginSimpleInfo)localObject12).setUin(this.x.f);
                  ((WloginSimpleInfo)localObject12).setFace(((tlv_t11a)localObject1).get_face());
                  ((WloginSimpleInfo)localObject12).setAge(((tlv_t11a)localObject1).get_age());
                  ((WloginSimpleInfo)localObject12).setGender(((tlv_t11a)localObject1).get_gender());
                  ((WloginSimpleInfo)localObject12).setNick(((tlv_t11a)localObject1).get_nick());
                  ((WloginSimpleInfo)localObject12).setReserveUinInfo((byte[][])localObject15);
                  ((WloginSimpleInfo)localObject12).setMainDisplayName(localtlv_t118.get_data());
                  this.x.aq = ((async_context)localObject10)._main_sigmap;
                  localObject1 = this.x;
                  paramInt1 = ((t)localObject1).a(((t)localObject1).f, l3, (byte[][])localObject16, l4, l2, t.f(), t.f() + 0L, t.f() + l1, (WloginSimpleInfo)localObject12, localtlv_t10a.get_data(), localtlv_t10d.get_data(), localtlv_t114.get_data(), localtlv_t10e.get_data(), (byte[])localObject3, (byte[])localObject5, (byte[])localObject4, (byte[])localObject6, (byte[])localObject7, (byte[])localObject8, (byte[])localObject2, (byte[])localObject9, (byte[][])localObject14, (long[])localObject11, ((async_context)localObject10)._login_bitmap);
                  if (paramInt1 != 0)
                  {
                    localObject1 = new ErrMsg();
                    ((ErrMsg)localObject1).setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
                    a((ErrMsg)localObject1);
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("put_siginfo fail,ret=");
                    ((StringBuilder)localObject1).append(paramInt1);
                    localObject1 = ((StringBuilder)localObject1).toString();
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("");
                    ((StringBuilder)localObject2).append(this.x.f);
                    util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
                  }
                  else
                  {
                    paramInt1 = 2;
                    for (;;)
                    {
                      paramInt1 = localtlv_t11d.get_tlv((byte[])localObject17, paramInt1, i3);
                      if (paramInt1 < 0) {
                        break;
                      }
                      localObject1 = this.x;
                      ((t)localObject1).a(((t)localObject1).f, localtlv_t11d.get_appid(), t.f(), t.f() + 0L, localtlv_t11d.get_st(), localtlv_t11d.get_stkey());
                    }
                    paramInt1 = 0;
                    break label6300;
                    label5089:
                    i3 = this.c;
                    paramInt1 = i1;
                    localObject1 = paramArrayOfByte;
                    if (localtlv_t183.get_tlv((byte[])localObject1, paramInt1, i3 - i1) >= 0) {
                      ((async_context)localObject15)._msalt = localtlv_t183.getMsalt();
                    }
                    if (((tlv_t113)localObject18).get_tlv((byte[])localObject1, paramInt1, this.c - paramInt1) >= 0)
                    {
                      this.x.f = ((tlv_t113)localObject18).get_uin();
                      localObject2 = this.x;
                      ((t)localObject2).a(((t)localObject2).g, Long.valueOf(this.x.f));
                    }
                    i3 = localtlv_t104.get_tlv((byte[])localObject1, paramInt1, this.c - paramInt1);
                    if (i3 < 0)
                    {
                      i1 = paramInt1;
                      paramInt1 = i3;
                    }
                    else
                    {
                      ((async_context)localObject15)._t104 = localtlv_t104;
                      i3 = 0;
                      i1 = paramInt1;
                      paramInt1 = i3;
                    }
                  }
                  break;
                }
              }
              else
              {
                localObject1 = paramArrayOfByte;
                paramInt1 = localtlv_t104.get_tlv((byte[])localObject1, i1, this.c - i1 - 1);
                if (paramInt1 < 0) {
                  break label6300;
                }
                ((async_context)localObject15)._t104 = localtlv_t104;
                paramInt1 = localtlv_t126.get_tlv((byte[])localObject1, i1, this.c - i1 - 1);
                if (paramInt1 < 0) {
                  break label6300;
                }
                ((async_context)localObject15)._t126 = localtlv_t126;
                paramInt1 = localtlv_t182.get_tlv((byte[])localObject1, i1, this.c - i1 - 1);
                if (paramInt1 < 0) {
                  break label6300;
                }
                ((async_context)localObject15)._smslogin_msgcnt = localtlv_t182.getMsgCnt();
                ((async_context)localObject15)._smslogin_timelimit = localtlv_t182.getTimeLimit();
                paramInt1 = localtlv_t183.get_tlv((byte[])localObject1, i1, this.c - i1 - 1);
                if (paramInt1 < 0) {
                  break label6300;
                }
                ((async_context)localObject15)._msalt = localtlv_t183.getMsalt();
                paramInt1 = 0;
                break label6300;
              }
            }
            else
            {
              localObject1 = paramArrayOfByte;
              if (((tlv_t113)localObject2).get_tlv((byte[])localObject1, i1, this.c - i1 - 1) >= 0)
              {
                this.x.f = ((tlv_t113)localObject2).get_uin();
                localObject2 = this.x;
                ((t)localObject2).a(((t)localObject2).g, Long.valueOf(this.x.f));
              }
              paramInt1 = localtlv_t104.get_tlv((byte[])localObject1, i1, this.c - i1 - 1);
              if (paramInt1 < 0) {
                break label6300;
              }
              ((async_context)localObject15)._t104 = localtlv_t104;
              paramInt1 = ((tlv_t402)localObject18).get_tlv((byte[])localObject1, i1, this.c - i1 - 1);
              if (paramInt1 < 0) {
                break label6300;
              }
              ((async_context)localObject15)._t402 = ((tlv_t402)localObject18);
              paramInt1 = ((tlv_t403)localObject14).get_tlv((byte[])localObject1, i1, this.c - i1 - 1);
              if (paramInt1 < 0) {
                break label6300;
              }
              ((async_context)localObject15)._t403 = ((tlv_t403)localObject14);
              c((byte[])localObject1, i1, this.c - i1 - 1);
            }
          }
          else
          {
            localObject1 = paramArrayOfByte;
            paramInt1 = localtlv_t161.get_tlv((byte[])localObject1, i1, this.c - i1 - 1);
            if (paramInt1 < 0) {
              break label6300;
            }
            a(localtlv_t161);
            c((byte[])localObject1, i1, this.c - i1 - 1);
          }
        }
        else
        {
          c(paramArrayOfByte, i1, this.c - i1 - 1);
          localObject1 = this.x;
          ((t)localObject1).a(((t)localObject1).g);
        }
      }
      else
      {
        localObject1 = paramArrayOfByte;
        if (((tlv_t113)localObject2).get_tlv((byte[])localObject1, i1, this.c - i1 - 1) >= 0)
        {
          this.x.f = ((tlv_t113)localObject2).get_uin();
          localObject2 = this.x;
          ((t)localObject2).a(((t)localObject2).g, Long.valueOf(this.x.f));
        }
        paramInt1 = localtlv_t104.get_tlv((byte[])localObject1, i1, this.c - i1 - 1);
        if (paramInt1 < 0) {
          break label6300;
        }
        ((async_context)localObject15)._t104 = localtlv_t104;
        paramInt1 = localtlv_t174.get_tlv((byte[])localObject1, i1, this.c - i1 - 1);
        if (paramInt1 < 0) {
          break label6300;
        }
        ((async_context)localObject15)._t174 = localtlv_t174;
        if (localtlv_t178.get_tlv((byte[])localObject1, i1, this.c - i1 - 1) >= 0)
        {
          ((async_context)localObject15)._devlock_info.CountryCode = new String(localtlv_t178.get_country_code());
          ((async_context)localObject15)._devlock_info.Mobile = new String(localtlv_t178.get_mobile());
          ((async_context)localObject15)._devlock_info.MbItemSmsCodeStatus = localtlv_t178.get_smscode_status();
          ((async_context)localObject15)._devlock_info.AvailableMsgCount = localtlv_t178.get_available_msg_cnt();
          ((async_context)localObject15)._devlock_info.TimeLimit = localtlv_t178.get_time_limit();
        }
        localObject2 = new tlv_t196();
        if (((tlv_t196)localObject2).get_tlv((byte[])localObject1, i1, this.c - i1 - 1) >= 0)
        {
          ((async_context)localObject15)._devlock_info.BakCountryCode = ((tlv_t196)localObject2).getCountryCode();
          ((async_context)localObject15)._devlock_info.BakMobile = ((tlv_t196)localObject2).getBakMobile();
          ((async_context)localObject15)._devlock_info.BakMobileState = ((tlv_t196)localObject2).getBakMobileState();
        }
        if (((tlv_t179)localObject19).get_tlv((byte[])localObject1, i1, this.c - i1 - 1) >= 0) {
          ((async_context)localObject15)._devlock_info.UnionVerifyUrl = new String(((tlv_t179)localObject19).get_verify_url());
        }
        if (localtlv_t17d.get_tlv((byte[])localObject1, i1, this.c - i1 - 1) >= 0)
        {
          ((async_context)localObject15)._devlock_info.MbGuideType = localtlv_t17d.get_mb_guide_type();
          ((async_context)localObject15)._devlock_info.MbGuideMsg = new String(localtlv_t17d.get_mb_guide_msg());
          ((async_context)localObject15)._devlock_info.MbGuideInfoType = localtlv_t17d.get_mb_guide_info_type();
          ((async_context)localObject15)._devlock_info.MbGuideInfo = new String(localtlv_t17d.get_mb_guide_info());
        }
        if (localtlv_t17e.get_tlv((byte[])localObject1, i1, this.c - i1 - 1) >= 0) {
          ((async_context)localObject15)._devlock_info.VerifyReason = new String(localtlv_t17e.get_data());
        }
        if (((tlv_t402)localObject18).get_tlv((byte[])localObject1, i1, this.c - i1 - 1) >= 0) {
          ((async_context)localObject15)._t402 = ((tlv_t402)localObject18);
        } else {
          ((async_context)localObject15)._t402 = new tlv_t402();
        }
        if (((tlv_t403)localObject14).get_tlv((byte[])localObject1, i1, this.c - i1 - 1) >= 0) {
          ((async_context)localObject15)._t403 = ((tlv_t403)localObject14);
        } else {
          ((async_context)localObject15)._t403 = new tlv_t403();
        }
        c((byte[])localObject1, i1, this.c - i1 - 1);
      }
    }
    else
    {
      localObject1 = paramArrayOfByte;
      localObject2 = new tlv_t(405);
      paramInt1 = ((tlv_t)localObject2).get_tlv((byte[])localObject1, i1, this.c - i1 - 1);
      if (paramInt1 < 0) {
        break label6300;
      }
      WloginSigInfo._LHSig = ((tlv_t)localObject2).get_data();
      c((byte[])localObject1, i1, this.c - i1 - 1);
    }
    paramInt1 = i2;
    label6300:
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("type:");
    ((StringBuilder)localObject2).append(i2);
    ((StringBuilder)localObject2).append(" ret:");
    if (paramInt1 > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0x");
      ((StringBuilder)localObject1).append(Integer.toHexString(paramInt1));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = Integer.valueOf(paramInt1);
    }
    ((StringBuilder)localObject2).append(localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.x.f);
    util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
    if (paramInt1 == 0)
    {
      a(null);
    }
    else
    {
      new tlv_t508().get_tlv(paramArrayOfByte, i1, this.c - i1 - 1);
      if (tlv_t508.doFetch)
      {
        paramArrayOfByte = new ErrMsg();
        i1 = new i(this.x, this.t, this.u, paramArrayOfByte).b(paramInt1);
        if (i1 != -1000)
        {
          a(paramArrayOfByte);
          paramInt1 = i1;
        }
      }
    }
    if ((paramInt1 != 10) && (paramInt1 != 161) && (paramInt1 != 162) && (paramInt1 != 164) && (paramInt1 != 165) && (paramInt1 != 166) && (paramInt1 != 154) && ((paramInt1 < 128) || (paramInt1 > 143))) {
      break label6604;
    }
    paramInt1 = -1000;
    label6604:
    if ((paramInt2 != 2) && (paramInt2 != 6) && (paramInt2 != 7)) {
      a(paramInt2);
    }
    return paramInt1;
  }
  
  public Socket d()
  {
    return this.x.aj;
  }
  
  /* Error */
  public int e()
  {
    // Byte code:
    //   0: new 426	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   7: astore 13
    //   9: aload 13
    //   11: aload_0
    //   12: invokevirtual 634	java/lang/Object:getClass	()Ljava/lang/Class;
    //   15: invokevirtual 639	java/lang/Class:getName	()Ljava/lang/String;
    //   18: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload 13
    //   24: ldc_w 1517
    //   27: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 13
    //   33: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 13
    //   38: new 426	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   45: astore 14
    //   47: aload 14
    //   49: ldc 100
    //   51: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 14
    //   57: aload_0
    //   58: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   61: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   64: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 13
    //   70: aload 14
    //   72: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload_0
    //   79: invokevirtual 644	oicq/wlogin_sdk/request/oicq_request:c	()[B
    //   82: astore 20
    //   84: aload_0
    //   85: invokevirtual 1519	oicq/wlogin_sdk/request/oicq_request:d	()Ljava/net/Socket;
    //   88: astore 14
    //   90: ldc 100
    //   92: astore 15
    //   94: iconst_0
    //   95: istore 8
    //   97: iconst_0
    //   98: istore_1
    //   99: iconst_0
    //   100: istore_2
    //   101: iconst_0
    //   102: istore 4
    //   104: iconst_0
    //   105: istore 9
    //   107: iconst_0
    //   108: istore_3
    //   109: ldc 100
    //   111: astore 13
    //   113: lconst_0
    //   114: lstore 11
    //   116: iload_2
    //   117: bipush 6
    //   119: if_icmpge +3215 -> 3334
    //   122: iload_2
    //   123: ifeq +9 -> 132
    //   126: getstatic 375	oicq/wlogin_sdk/request/t:t	Landroid/content/Context;
    //   129: invokestatic 1522	oicq/wlogin_sdk/tools/util:chg_retry_type	(Landroid/content/Context;)V
    //   132: getstatic 375	oicq/wlogin_sdk/request/t:t	Landroid/content/Context;
    //   135: invokestatic 1526	oicq/wlogin_sdk/tools/util:is_wap_retry	(Landroid/content/Context;)Z
    //   138: istore 8
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   145: iload_2
    //   146: ifeq +30 -> 176
    //   149: aload_0
    //   150: getfield 146	oicq/wlogin_sdk/request/oicq_request:t	I
    //   153: sipush 2066
    //   156: if_icmpeq +20 -> 176
    //   159: aload_0
    //   160: iload_1
    //   161: lload 11
    //   163: iload 4
    //   165: iload_2
    //   166: iload 8
    //   168: iload 9
    //   170: invokespecial 1528	oicq/wlogin_sdk/request/oicq_request:a	(IJIIZZ)V
    //   173: goto +3 -> 176
    //   176: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   179: lstore 11
    //   181: iload 8
    //   183: ifeq +1608 -> 1791
    //   186: new 426	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   193: astore 16
    //   195: aload 16
    //   197: ldc_w 1530
    //   200: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 16
    //   206: iload_2
    //   207: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 16
    //   213: ldc_w 1532
    //   216: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 16
    //   222: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: astore 16
    //   227: new 426	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   234: astore 17
    //   236: aload 17
    //   238: ldc 100
    //   240: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 17
    //   246: aload_0
    //   247: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   250: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   253: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 16
    //   259: aload 17
    //   261: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_0
    //   268: iload_2
    //   269: iload 8
    //   271: invokevirtual 1534	oicq/wlogin_sdk/request/oicq_request:a	(IZ)Ljava/lang/String;
    //   274: astore 19
    //   276: getstatic 375	oicq/wlogin_sdk/request/t:t	Landroid/content/Context;
    //   279: invokestatic 1537	oicq/wlogin_sdk/tools/util:is_wap_proxy_retry	(Landroid/content/Context;)Z
    //   282: istore 10
    //   284: iload 10
    //   286: ifeq +202 -> 488
    //   289: invokestatic 1540	oicq/wlogin_sdk/tools/util:get_proxy_ip	()Ljava/lang/String;
    //   292: astore 18
    //   294: invokestatic 1543	oicq/wlogin_sdk/tools/util:get_proxy_port	()I
    //   297: istore 6
    //   299: aload 18
    //   301: ifnull +45 -> 346
    //   304: aload 18
    //   306: invokevirtual 373	java/lang/String:length	()I
    //   309: istore 5
    //   311: iload 5
    //   313: ifle +33 -> 346
    //   316: iload 6
    //   318: iconst_m1
    //   319: if_icmpne +6 -> 325
    //   322: goto +24 -> 346
    //   325: iload 10
    //   327: istore 9
    //   329: goto +169 -> 498
    //   332: iload 10
    //   334: istore 9
    //   336: goto +1423 -> 1759
    //   339: iload 10
    //   341: istore 9
    //   343: goto +1437 -> 1780
    //   346: new 426	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   353: astore 16
    //   355: aload 16
    //   357: ldc_w 1545
    //   360: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 16
    //   366: aload 18
    //   368: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 16
    //   374: ldc_w 1547
    //   377: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 16
    //   383: iload 6
    //   385: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 16
    //   391: ldc_w 1549
    //   394: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 16
    //   400: iconst_0
    //   401: invokevirtual 655	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload 16
    //   407: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: astore 16
    //   412: new 426	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   419: astore 17
    //   421: aload 17
    //   423: ldc 100
    //   425: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload_0
    //   430: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   433: astore 21
    //   435: aload 17
    //   437: aload 21
    //   439: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   442: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 16
    //   448: aload 17
    //   450: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: iconst_0
    //   457: istore 9
    //   459: goto +39 -> 498
    //   462: iconst_0
    //   463: istore 9
    //   465: goto +1294 -> 1759
    //   468: iconst_0
    //   469: istore 9
    //   471: goto +1309 -> 1780
    //   474: iload 10
    //   476: istore 9
    //   478: goto +1281 -> 1759
    //   481: iload 10
    //   483: istore 9
    //   485: goto +1295 -> 1780
    //   488: aconst_null
    //   489: astore 18
    //   491: iconst_m1
    //   492: istore 6
    //   494: iload 10
    //   496: istore 9
    //   498: iload_2
    //   499: istore 5
    //   501: iload 9
    //   503: ifeq +128 -> 631
    //   506: aload 13
    //   508: astore 16
    //   510: aload 13
    //   512: astore 17
    //   514: new 426	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   521: astore 21
    //   523: aload 13
    //   525: astore 16
    //   527: aload 13
    //   529: astore 17
    //   531: aload 21
    //   533: ldc_w 1551
    //   536: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload 13
    //   542: astore 16
    //   544: aload 13
    //   546: astore 17
    //   548: aload 21
    //   550: aload 18
    //   552: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload 13
    //   558: astore 16
    //   560: aload 13
    //   562: astore 17
    //   564: aload 21
    //   566: ldc_w 1553
    //   569: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload 13
    //   575: astore 16
    //   577: aload 13
    //   579: astore 17
    //   581: aload 21
    //   583: iload 6
    //   585: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 13
    //   591: astore 16
    //   593: aload 13
    //   595: astore 17
    //   597: aload 21
    //   599: ldc_w 1555
    //   602: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload 13
    //   608: astore 16
    //   610: aload 13
    //   612: astore 17
    //   614: new 1557	java/net/URL
    //   617: dup
    //   618: aload 21
    //   620: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokespecial 1559	java/net/URL:<init>	(Ljava/lang/String;)V
    //   626: astore 18
    //   628: goto +272 -> 900
    //   631: aload 13
    //   633: astore 16
    //   635: aload 13
    //   637: astore 17
    //   639: aload_0
    //   640: aload 19
    //   642: iconst_0
    //   643: aload_0
    //   644: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   647: getfield 642	oicq/wlogin_sdk/request/t:l	I
    //   650: i2l
    //   651: invokestatic 1564	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   654: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   657: aload 13
    //   659: astore 16
    //   661: aload 13
    //   663: astore 17
    //   665: aload_0
    //   666: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   669: ifnull +3147 -> 3816
    //   672: aload 13
    //   674: astore 16
    //   676: aload 13
    //   678: astore 17
    //   680: aload_0
    //   681: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   684: invokevirtual 224	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   687: invokevirtual 230	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   690: astore 18
    //   692: aload 13
    //   694: astore 16
    //   696: aload 13
    //   698: astore 17
    //   700: aload 13
    //   702: aload 18
    //   704: invokevirtual 1568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   707: istore 10
    //   709: iload 10
    //   711: ifne +29 -> 740
    //   714: aload_0
    //   715: aconst_null
    //   716: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   719: aload 18
    //   721: astore 13
    //   723: goto +88 -> 811
    //   726: aload 18
    //   728: astore 13
    //   730: goto +1029 -> 1759
    //   733: aload 18
    //   735: astore 13
    //   737: goto +1043 -> 1780
    //   740: aload 13
    //   742: astore 16
    //   744: aload 13
    //   746: astore 17
    //   748: new 426	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   755: astore 18
    //   757: aload 13
    //   759: astore 16
    //   761: aload 13
    //   763: astore 17
    //   765: aload 18
    //   767: ldc_w 1570
    //   770: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: pop
    //   774: aload 13
    //   776: astore 16
    //   778: aload 13
    //   780: astore 17
    //   782: aload 18
    //   784: aload 13
    //   786: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload 13
    //   792: astore 16
    //   794: aload 13
    //   796: astore 17
    //   798: new 493	java/lang/Exception
    //   801: dup
    //   802: aload 18
    //   804: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokespecial 1571	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   810: athrow
    //   811: aload 13
    //   813: astore 16
    //   815: aload 13
    //   817: astore 17
    //   819: new 426	java/lang/StringBuilder
    //   822: dup
    //   823: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   826: astore 21
    //   828: aload 13
    //   830: astore 16
    //   832: aload 13
    //   834: astore 17
    //   836: aload 21
    //   838: ldc_w 1551
    //   841: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload 13
    //   847: astore 16
    //   849: aload 13
    //   851: astore 17
    //   853: aload 21
    //   855: aload 18
    //   857: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: pop
    //   861: aload 13
    //   863: astore 16
    //   865: aload 13
    //   867: astore 17
    //   869: aload 21
    //   871: ldc_w 1555
    //   874: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: pop
    //   878: aload 13
    //   880: astore 16
    //   882: aload 13
    //   884: astore 17
    //   886: new 1557	java/net/URL
    //   889: dup
    //   890: aload 21
    //   892: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   895: invokespecial 1559	java/net/URL:<init>	(Ljava/lang/String;)V
    //   898: astore 18
    //   900: aload 13
    //   902: astore 16
    //   904: aload 13
    //   906: astore 17
    //   908: new 426	java/lang/StringBuilder
    //   911: dup
    //   912: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   915: astore 21
    //   917: aload 13
    //   919: astore 16
    //   921: aload 13
    //   923: astore 17
    //   925: aload 21
    //   927: ldc_w 1573
    //   930: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: pop
    //   934: aload 13
    //   936: astore 16
    //   938: aload 13
    //   940: astore 17
    //   942: aload 21
    //   944: iload 9
    //   946: invokevirtual 655	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload 13
    //   952: astore 16
    //   954: aload 13
    //   956: astore 17
    //   958: aload 21
    //   960: ldc_w 1575
    //   963: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: aload 13
    //   969: astore 16
    //   971: aload 13
    //   973: astore 17
    //   975: aload 21
    //   977: aload 18
    //   979: invokevirtual 468	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   982: pop
    //   983: aload 13
    //   985: astore 16
    //   987: aload 13
    //   989: astore 17
    //   991: aload 21
    //   993: ldc_w 1577
    //   996: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: pop
    //   1000: aload 13
    //   1002: astore 16
    //   1004: aload 13
    //   1006: astore 17
    //   1008: aload 21
    //   1010: aload 19
    //   1012: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: pop
    //   1016: aload 13
    //   1018: astore 16
    //   1020: aload 13
    //   1022: astore 17
    //   1024: aload 21
    //   1026: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: astore 21
    //   1031: aload 13
    //   1033: astore 16
    //   1035: aload 13
    //   1037: astore 17
    //   1039: new 426	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1046: astore 22
    //   1048: aload 13
    //   1050: astore 16
    //   1052: aload 13
    //   1054: astore 17
    //   1056: aload 22
    //   1058: ldc 100
    //   1060: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: pop
    //   1064: aload 13
    //   1066: astore 16
    //   1068: aload 13
    //   1070: astore 17
    //   1072: aload 22
    //   1074: aload_0
    //   1075: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1078: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   1081: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1084: pop
    //   1085: aload 13
    //   1087: astore 16
    //   1089: aload 13
    //   1091: astore 17
    //   1093: aload 21
    //   1095: aload 22
    //   1097: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1100: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1103: aload 13
    //   1105: astore 16
    //   1107: aload 13
    //   1109: astore 17
    //   1111: aload 18
    //   1113: invokevirtual 1581	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1116: checkcast 1583	java/net/HttpURLConnection
    //   1119: astore 18
    //   1121: aload 13
    //   1123: astore 16
    //   1125: aload 13
    //   1127: astore 17
    //   1129: aload 18
    //   1131: ldc_w 1585
    //   1134: invokevirtual 1588	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   1137: iload 9
    //   1139: ifeq +21 -> 1160
    //   1142: aload 13
    //   1144: astore 16
    //   1146: aload 13
    //   1148: astore 17
    //   1150: aload 18
    //   1152: ldc_w 1590
    //   1155: aload 19
    //   1157: invokevirtual 1593	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1160: aload 13
    //   1162: astore 16
    //   1164: aload 13
    //   1166: astore 17
    //   1168: aload 18
    //   1170: ldc_w 1595
    //   1173: ldc_w 1597
    //   1176: invokevirtual 1593	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1179: aload 13
    //   1181: astore 16
    //   1183: aload 13
    //   1185: astore 17
    //   1187: aload 18
    //   1189: ldc_w 1599
    //   1192: ldc_w 1601
    //   1195: invokevirtual 1593	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1198: aload 13
    //   1200: astore 16
    //   1202: aload 13
    //   1204: astore 17
    //   1206: aload 18
    //   1208: ldc_w 1603
    //   1211: aload 20
    //   1213: arraylength
    //   1214: invokestatic 1605	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1217: invokevirtual 1593	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1220: aload 13
    //   1222: astore 16
    //   1224: aload 13
    //   1226: astore 17
    //   1228: aload 18
    //   1230: aload_0
    //   1231: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1234: getfield 642	oicq/wlogin_sdk/request/t:l	I
    //   1237: invokevirtual 1608	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1240: aload 13
    //   1242: astore 16
    //   1244: aload 13
    //   1246: astore 17
    //   1248: aload 18
    //   1250: aload_0
    //   1251: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1254: getfield 642	oicq/wlogin_sdk/request/t:l	I
    //   1257: invokevirtual 1611	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1260: aload 13
    //   1262: astore 16
    //   1264: aload 13
    //   1266: astore 17
    //   1268: aload 18
    //   1270: iconst_1
    //   1271: invokevirtual 1615	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1274: aload 13
    //   1276: astore 16
    //   1278: aload 13
    //   1280: astore 17
    //   1282: aload 18
    //   1284: iconst_1
    //   1285: invokevirtual 1618	java/net/HttpURLConnection:setDoInput	(Z)V
    //   1288: aload 13
    //   1290: astore 16
    //   1292: aload 13
    //   1294: astore 17
    //   1296: new 426	java/lang/StringBuilder
    //   1299: dup
    //   1300: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1303: astore 19
    //   1305: aload 13
    //   1307: astore 16
    //   1309: aload 13
    //   1311: astore 17
    //   1313: aload 19
    //   1315: ldc 100
    //   1317: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: pop
    //   1321: aload 13
    //   1323: astore 16
    //   1325: aload 13
    //   1327: astore 17
    //   1329: aload 19
    //   1331: aload_0
    //   1332: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1335: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   1338: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1341: pop
    //   1342: aload 13
    //   1344: astore 16
    //   1346: aload 13
    //   1348: astore 17
    //   1350: ldc_w 1620
    //   1353: aload 19
    //   1355: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1358: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1361: aload 13
    //   1363: astore 16
    //   1365: aload 13
    //   1367: astore 17
    //   1369: aload 18
    //   1371: aload_0
    //   1372: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1375: getfield 642	oicq/wlogin_sdk/request/t:l	I
    //   1378: i2l
    //   1379: invokestatic 1625	oicq/wlogin_sdk/request/j:a	(Ljava/net/HttpURLConnection;J)Z
    //   1382: ifne +90 -> 1472
    //   1385: aload 13
    //   1387: astore 16
    //   1389: aload 13
    //   1391: astore 17
    //   1393: new 426	java/lang/StringBuilder
    //   1396: dup
    //   1397: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1400: astore 18
    //   1402: aload 13
    //   1404: astore 16
    //   1406: aload 13
    //   1408: astore 17
    //   1410: aload 18
    //   1412: ldc 100
    //   1414: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: pop
    //   1418: aload 13
    //   1420: astore 16
    //   1422: aload 13
    //   1424: astore 17
    //   1426: aload 18
    //   1428: aload_0
    //   1429: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1432: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   1435: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1438: pop
    //   1439: aload 13
    //   1441: astore 16
    //   1443: aload 13
    //   1445: astore 17
    //   1447: ldc_w 1627
    //   1450: aload 18
    //   1452: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1455: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1458: sipush -1026
    //   1461: iload_1
    //   1462: if_icmpeq +2361 -> 3823
    //   1465: sipush -1000
    //   1468: istore_1
    //   1469: goto +2354 -> 3823
    //   1472: aload 13
    //   1474: astore 16
    //   1476: aload 13
    //   1478: astore 17
    //   1480: new 426	java/lang/StringBuilder
    //   1483: dup
    //   1484: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1487: astore 19
    //   1489: aload 13
    //   1491: astore 16
    //   1493: aload 13
    //   1495: astore 17
    //   1497: aload 19
    //   1499: ldc 100
    //   1501: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: pop
    //   1505: aload 13
    //   1507: astore 16
    //   1509: aload 13
    //   1511: astore 17
    //   1513: aload 19
    //   1515: aload_0
    //   1516: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1519: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   1522: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1525: pop
    //   1526: aload 13
    //   1528: astore 16
    //   1530: aload 13
    //   1532: astore 17
    //   1534: ldc_w 1629
    //   1537: aload 19
    //   1539: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1542: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1545: aload 13
    //   1547: astore 16
    //   1549: aload 13
    //   1551: astore 17
    //   1553: aload 18
    //   1555: invokevirtual 1633	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1558: astore 19
    //   1560: aload 13
    //   1562: astore 16
    //   1564: aload 13
    //   1566: astore 17
    //   1568: aload 19
    //   1570: aload 20
    //   1572: iconst_0
    //   1573: aload 20
    //   1575: arraylength
    //   1576: invokevirtual 1638	java/io/OutputStream:write	([BII)V
    //   1579: aload 13
    //   1581: astore 16
    //   1583: aload 13
    //   1585: astore 17
    //   1587: aload 19
    //   1589: invokevirtual 1641	java/io/OutputStream:flush	()V
    //   1592: aload 13
    //   1594: astore 16
    //   1596: aload 13
    //   1598: astore 17
    //   1600: aload 18
    //   1602: invokevirtual 1644	java/net/HttpURLConnection:getResponseCode	()I
    //   1605: istore 6
    //   1607: aload 13
    //   1609: astore 16
    //   1611: new 426	java/lang/StringBuilder
    //   1614: dup
    //   1615: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1618: astore 17
    //   1620: aload 13
    //   1622: astore 16
    //   1624: aload 17
    //   1626: ldc_w 1646
    //   1629: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: pop
    //   1633: aload 13
    //   1635: astore 16
    //   1637: aload 17
    //   1639: iload 6
    //   1641: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1644: pop
    //   1645: aload 13
    //   1647: astore 16
    //   1649: aload 17
    //   1651: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1654: astore 17
    //   1656: aload 13
    //   1658: astore 16
    //   1660: new 426	java/lang/StringBuilder
    //   1663: dup
    //   1664: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1667: astore 19
    //   1669: aload 13
    //   1671: astore 16
    //   1673: aload 19
    //   1675: ldc 100
    //   1677: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: pop
    //   1681: aload 13
    //   1683: astore 16
    //   1685: aload 19
    //   1687: aload_0
    //   1688: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1691: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   1694: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1697: pop
    //   1698: aload 13
    //   1700: astore 16
    //   1702: aload 17
    //   1704: aload 19
    //   1706: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1709: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1712: sipush 200
    //   1715: iload 6
    //   1717: if_icmpeq +15 -> 1732
    //   1720: iload 5
    //   1722: iconst_1
    //   1723: iadd
    //   1724: istore_2
    //   1725: sipush -1000
    //   1728: istore_1
    //   1729: goto -1613 -> 116
    //   1732: aload 13
    //   1734: astore 16
    //   1736: aload 18
    //   1738: invokevirtual 1650	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1741: astore 17
    //   1743: iload 5
    //   1745: istore_2
    //   1746: aload 17
    //   1748: astore 16
    //   1750: goto +1015 -> 2765
    //   1753: iload 6
    //   1755: istore_1
    //   1756: goto -1278 -> 478
    //   1759: sipush -1026
    //   1762: iload_1
    //   1763: if_icmpeq +10 -> 1773
    //   1766: sipush -1000
    //   1769: istore_1
    //   1770: goto +3 -> 1773
    //   1773: iload_2
    //   1774: iconst_1
    //   1775: iadd
    //   1776: istore_2
    //   1777: goto -1661 -> 116
    //   1780: iload_2
    //   1781: iconst_1
    //   1782: iadd
    //   1783: istore_2
    //   1784: sipush -1026
    //   1787: istore_1
    //   1788: goto -1672 -> 116
    //   1791: new 426	java/lang/StringBuilder
    //   1794: dup
    //   1795: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1798: astore 16
    //   1800: aload 16
    //   1802: ldc_w 1652
    //   1805: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1808: pop
    //   1809: aload 16
    //   1811: iload_2
    //   1812: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1815: pop
    //   1816: aload 16
    //   1818: ldc_w 1532
    //   1821: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: pop
    //   1825: aload 16
    //   1827: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1830: astore 16
    //   1832: new 426	java/lang/StringBuilder
    //   1835: dup
    //   1836: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1839: astore 17
    //   1841: aload 17
    //   1843: ldc 100
    //   1845: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: pop
    //   1849: aload 17
    //   1851: aload_0
    //   1852: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1855: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   1858: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1861: pop
    //   1862: aload 16
    //   1864: aload 17
    //   1866: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1869: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1872: aload 14
    //   1874: ifnonnull +591 -> 2465
    //   1877: ldc 100
    //   1879: astore 16
    //   1881: aload_0
    //   1882: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1885: ifnonnull +125 -> 2010
    //   1888: aload_0
    //   1889: iload_2
    //   1890: iload 8
    //   1892: invokevirtual 1534	oicq/wlogin_sdk/request/oicq_request:a	(IZ)Ljava/lang/String;
    //   1895: astore 16
    //   1897: new 426	java/lang/StringBuilder
    //   1900: dup
    //   1901: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1904: astore 17
    //   1906: aload 17
    //   1908: ldc_w 1654
    //   1911: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1914: pop
    //   1915: aload 17
    //   1917: aload 16
    //   1919: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1922: pop
    //   1923: aload 17
    //   1925: ldc_w 1656
    //   1928: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1931: pop
    //   1932: aload 17
    //   1934: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1937: astore 17
    //   1939: new 426	java/lang/StringBuilder
    //   1942: dup
    //   1943: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1946: astore 18
    //   1948: aload 18
    //   1950: ldc 100
    //   1952: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1955: pop
    //   1956: aload 18
    //   1958: aload_0
    //   1959: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1962: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   1965: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1968: pop
    //   1969: aload 17
    //   1971: aload 18
    //   1973: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1976: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1979: aload_0
    //   1980: aload_0
    //   1981: iload 8
    //   1983: invokevirtual 233	oicq/wlogin_sdk/request/oicq_request:c	(Z)I
    //   1986: putfield 142	oicq/wlogin_sdk/request/oicq_request:r	I
    //   1989: aload_0
    //   1990: aload 16
    //   1992: aload_0
    //   1993: getfield 142	oicq/wlogin_sdk/request/oicq_request:r	I
    //   1996: aload_0
    //   1997: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2000: getfield 642	oicq/wlogin_sdk/request/t:l	I
    //   2003: i2l
    //   2004: invokestatic 1564	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   2007: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2010: aload_0
    //   2011: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2014: astore 17
    //   2016: aload 17
    //   2018: ifnull +89 -> 2107
    //   2021: aload 17
    //   2023: invokevirtual 224	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   2026: ifnonnull +81 -> 2107
    //   2029: aload_0
    //   2030: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2033: invokevirtual 224	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   2036: ifnonnull +44 -> 2080
    //   2039: new 426	java/lang/StringBuilder
    //   2042: dup
    //   2043: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   2046: astore 14
    //   2048: aload 14
    //   2050: ldc 100
    //   2052: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2055: pop
    //   2056: aload 14
    //   2058: aload_0
    //   2059: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2062: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   2065: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2068: pop
    //   2069: ldc_w 1658
    //   2072: aload 14
    //   2074: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2077: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2080: iload_2
    //   2081: iconst_1
    //   2082: iadd
    //   2083: istore_2
    //   2084: aload_0
    //   2085: aconst_null
    //   2086: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2089: aload_0
    //   2090: aconst_null
    //   2091: invokevirtual 1660	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2094: aconst_null
    //   2095: astore 14
    //   2097: sipush -1007
    //   2100: istore_1
    //   2101: iconst_1
    //   2102: istore 4
    //   2104: goto -1988 -> 116
    //   2107: aload_0
    //   2108: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2111: astore 17
    //   2113: aload 17
    //   2115: ifnull +144 -> 2259
    //   2118: aload 15
    //   2120: aload 17
    //   2122: invokevirtual 224	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   2125: invokevirtual 230	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2128: invokevirtual 1568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2131: ifeq +6 -> 2137
    //   2134: goto +125 -> 2259
    //   2137: aload_0
    //   2138: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2141: invokevirtual 224	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   2144: invokevirtual 230	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2147: astore 15
    //   2149: new 426	java/lang/StringBuilder
    //   2152: dup
    //   2153: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   2156: astore 17
    //   2158: aload 17
    //   2160: ldc_w 1654
    //   2163: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2166: pop
    //   2167: aload 17
    //   2169: aload 16
    //   2171: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2174: pop
    //   2175: aload 17
    //   2177: ldc_w 1662
    //   2180: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2183: pop
    //   2184: aload 17
    //   2186: aload_0
    //   2187: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2190: invokevirtual 1663	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   2193: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2196: pop
    //   2197: aload 17
    //   2199: ldc_w 1665
    //   2202: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2205: pop
    //   2206: aload 17
    //   2208: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2211: astore 16
    //   2213: new 426	java/lang/StringBuilder
    //   2216: dup
    //   2217: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   2220: astore 17
    //   2222: aload 17
    //   2224: ldc 100
    //   2226: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2229: pop
    //   2230: aload 17
    //   2232: aload_0
    //   2233: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2236: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   2239: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2242: pop
    //   2243: aload 16
    //   2245: aload 17
    //   2247: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2250: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2253: iconst_1
    //   2254: istore 4
    //   2256: goto +209 -> 2465
    //   2259: aload_0
    //   2260: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2263: ifnonnull +92 -> 2355
    //   2266: new 426	java/lang/StringBuilder
    //   2269: dup
    //   2270: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   2273: astore 14
    //   2275: aload 14
    //   2277: ldc_w 1654
    //   2280: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2283: pop
    //   2284: aload 14
    //   2286: aload 16
    //   2288: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2291: pop
    //   2292: aload 14
    //   2294: ldc_w 1667
    //   2297: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2300: pop
    //   2301: aload 14
    //   2303: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2306: astore 14
    //   2308: new 426	java/lang/StringBuilder
    //   2311: dup
    //   2312: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   2315: astore 16
    //   2317: aload 16
    //   2319: ldc 100
    //   2321: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2324: pop
    //   2325: aload 16
    //   2327: aload_0
    //   2328: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2331: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   2334: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2337: pop
    //   2338: aload 14
    //   2340: aload 16
    //   2342: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2345: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2348: sipush -1007
    //   2351: istore_1
    //   2352: goto +90 -> 2442
    //   2355: new 426	java/lang/StringBuilder
    //   2358: dup
    //   2359: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   2362: astore 14
    //   2364: aload 14
    //   2366: ldc_w 1669
    //   2369: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2372: pop
    //   2373: aload 14
    //   2375: aload 15
    //   2377: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2380: pop
    //   2381: aload 14
    //   2383: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2386: astore 14
    //   2388: new 426	java/lang/StringBuilder
    //   2391: dup
    //   2392: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   2395: astore 16
    //   2397: aload 16
    //   2399: ldc 100
    //   2401: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2404: pop
    //   2405: aload 16
    //   2407: aload_0
    //   2408: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2411: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   2414: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2417: pop
    //   2418: aload 14
    //   2420: aload 16
    //   2422: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2425: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2428: sipush -1026
    //   2431: iload_1
    //   2432: if_icmpeq +10 -> 2442
    //   2435: sipush -1000
    //   2438: istore_1
    //   2439: goto +3 -> 2442
    //   2442: iload_2
    //   2443: iconst_1
    //   2444: iadd
    //   2445: istore_2
    //   2446: aload_0
    //   2447: aconst_null
    //   2448: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2451: aload_0
    //   2452: aconst_null
    //   2453: invokevirtual 1660	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2456: aconst_null
    //   2457: astore 14
    //   2459: iconst_1
    //   2460: istore 4
    //   2462: goto -2346 -> 116
    //   2465: aload 14
    //   2467: ifnonnull +1364 -> 3831
    //   2470: new 426	java/lang/StringBuilder
    //   2473: dup
    //   2474: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   2477: astore 14
    //   2479: aload 14
    //   2481: ldc_w 1671
    //   2484: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2487: pop
    //   2488: aload 14
    //   2490: aload_0
    //   2491: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2494: invokevirtual 468	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2497: pop
    //   2498: aload 14
    //   2500: ldc_w 1656
    //   2503: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2506: pop
    //   2507: aload 14
    //   2509: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2512: astore 14
    //   2514: new 426	java/lang/StringBuilder
    //   2517: dup
    //   2518: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   2521: astore 16
    //   2523: aload 16
    //   2525: ldc 100
    //   2527: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2530: pop
    //   2531: aload 16
    //   2533: aload_0
    //   2534: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2537: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   2540: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2543: pop
    //   2544: aload 14
    //   2546: aload 16
    //   2548: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2551: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2554: new 1673	java/net/Socket
    //   2557: dup
    //   2558: invokespecial 1674	java/net/Socket:<init>	()V
    //   2561: astore 14
    //   2563: aload_0
    //   2564: aload 14
    //   2566: invokevirtual 1660	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2569: aload 14
    //   2571: aload_0
    //   2572: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2575: aload_0
    //   2576: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2579: getfield 642	oicq/wlogin_sdk/request/t:l	I
    //   2582: invokevirtual 1678	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   2585: aload 14
    //   2587: aload_0
    //   2588: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2591: getfield 642	oicq/wlogin_sdk/request/t:l	I
    //   2594: invokevirtual 1681	java/net/Socket:setSoTimeout	(I)V
    //   2597: aload 14
    //   2599: aload_0
    //   2600: getfield 144	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2603: arraylength
    //   2604: invokevirtual 1684	java/net/Socket:setReceiveBufferSize	(I)V
    //   2607: new 426	java/lang/StringBuilder
    //   2610: dup
    //   2611: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   2614: astore 16
    //   2616: aload 16
    //   2618: ldc_w 1671
    //   2621: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2624: pop
    //   2625: aload 16
    //   2627: aload_0
    //   2628: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2631: invokevirtual 468	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2634: pop
    //   2635: aload 16
    //   2637: ldc_w 1686
    //   2640: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2643: pop
    //   2644: aload 16
    //   2646: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2649: astore 16
    //   2651: new 426	java/lang/StringBuilder
    //   2654: dup
    //   2655: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   2658: astore 17
    //   2660: aload 17
    //   2662: ldc 100
    //   2664: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2667: pop
    //   2668: aload 17
    //   2670: aload_0
    //   2671: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2674: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   2677: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2680: pop
    //   2681: aload 16
    //   2683: aload 17
    //   2685: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2688: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2691: goto +3 -> 2694
    //   2694: new 426	java/lang/StringBuilder
    //   2697: dup
    //   2698: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   2701: astore 16
    //   2703: aload 16
    //   2705: ldc 100
    //   2707: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2710: pop
    //   2711: aload 16
    //   2713: aload_0
    //   2714: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2717: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   2720: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2723: pop
    //   2724: ldc_w 1688
    //   2727: aload 16
    //   2729: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2732: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2735: aload 14
    //   2737: invokevirtual 1689	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   2740: astore 16
    //   2742: aload 16
    //   2744: aload 20
    //   2746: iconst_0
    //   2747: aload 20
    //   2749: arraylength
    //   2750: invokevirtual 1638	java/io/OutputStream:write	([BII)V
    //   2753: aload 16
    //   2755: invokevirtual 1641	java/io/OutputStream:flush	()V
    //   2758: aload 14
    //   2760: invokevirtual 1690	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   2763: astore 16
    //   2765: iload_2
    //   2766: istore 6
    //   2768: new 426	java/lang/StringBuilder
    //   2771: dup
    //   2772: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   2775: astore 17
    //   2777: iload_2
    //   2778: istore 6
    //   2780: aload 17
    //   2782: ldc 100
    //   2784: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2787: pop
    //   2788: iload_2
    //   2789: istore 6
    //   2791: aload 17
    //   2793: aload_0
    //   2794: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2797: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   2800: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2803: pop
    //   2804: iload_2
    //   2805: istore 6
    //   2807: ldc_w 1692
    //   2810: aload 17
    //   2812: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2815: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2818: iconst_0
    //   2819: istore_1
    //   2820: iconst_0
    //   2821: istore 5
    //   2823: iload_2
    //   2824: istore 6
    //   2826: iload_1
    //   2827: aload_0
    //   2828: getfield 118	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2831: iconst_1
    //   2832: iadd
    //   2833: if_icmpge +34 -> 2867
    //   2836: iload_2
    //   2837: istore 6
    //   2839: aload 16
    //   2841: aload_0
    //   2842: getfield 144	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2845: iload_1
    //   2846: aload_0
    //   2847: getfield 118	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2850: iconst_1
    //   2851: iadd
    //   2852: iload_1
    //   2853: isub
    //   2854: invokevirtual 1697	java/io/InputStream:read	([BII)I
    //   2857: istore 5
    //   2859: iload 5
    //   2861: ifge +973 -> 3834
    //   2864: goto +3 -> 2867
    //   2867: iload 5
    //   2869: ifge +63 -> 2932
    //   2872: iload_2
    //   2873: iconst_1
    //   2874: iadd
    //   2875: istore_2
    //   2876: aload 14
    //   2878: astore 16
    //   2880: iload 8
    //   2882: ifne +39 -> 2921
    //   2885: iload_2
    //   2886: istore 6
    //   2888: aload 14
    //   2890: invokevirtual 1700	java/net/Socket:close	()V
    //   2893: iload_2
    //   2894: istore 6
    //   2896: aload_0
    //   2897: aconst_null
    //   2898: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2901: aload_0
    //   2902: aconst_null
    //   2903: invokevirtual 1660	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2906: aconst_null
    //   2907: astore 16
    //   2909: goto +12 -> 2921
    //   2912: aconst_null
    //   2913: astore 16
    //   2915: iload_3
    //   2916: istore 5
    //   2918: goto +309 -> 3227
    //   2921: sipush -1000
    //   2924: istore_1
    //   2925: aload 16
    //   2927: astore 14
    //   2929: goto -2813 -> 116
    //   2932: iload_2
    //   2933: istore 6
    //   2935: aload_0
    //   2936: aload_0
    //   2937: getfield 144	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2940: invokevirtual 1702	oicq/wlogin_sdk/request/oicq_request:b	([B)I
    //   2943: istore_1
    //   2944: iload_2
    //   2945: istore_3
    //   2946: iload_1
    //   2947: aload_0
    //   2948: getfield 118	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2951: iconst_1
    //   2952: iadd
    //   2953: if_icmpgt +68 -> 3021
    //   2956: iload_2
    //   2957: iconst_1
    //   2958: iadd
    //   2959: istore 5
    //   2961: aload 14
    //   2963: astore 16
    //   2965: iload 8
    //   2967: ifne +38 -> 3005
    //   2970: iload 5
    //   2972: istore_3
    //   2973: aload 14
    //   2975: invokevirtual 1700	java/net/Socket:close	()V
    //   2978: iload 5
    //   2980: istore_3
    //   2981: aload_0
    //   2982: aconst_null
    //   2983: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2986: iload 5
    //   2988: istore_2
    //   2989: aload_0
    //   2990: aconst_null
    //   2991: invokevirtual 1660	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2994: aconst_null
    //   2995: astore 16
    //   2997: goto +8 -> 3005
    //   3000: iload_1
    //   3001: istore_3
    //   3002: goto -90 -> 2912
    //   3005: iload_1
    //   3006: istore_3
    //   3007: sipush -1000
    //   3010: istore_1
    //   3011: iload 5
    //   3013: istore_2
    //   3014: aload 16
    //   3016: astore 14
    //   3018: goto -2902 -> 116
    //   3021: iload_2
    //   3022: istore_3
    //   3023: iload_1
    //   3024: aload_0
    //   3025: getfield 144	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   3028: arraylength
    //   3029: if_icmplt +60 -> 3089
    //   3032: iload_2
    //   3033: iconst_1
    //   3034: iadd
    //   3035: istore 5
    //   3037: aload 14
    //   3039: astore 16
    //   3041: iload 8
    //   3043: ifne +30 -> 3073
    //   3046: iload 5
    //   3048: istore_3
    //   3049: aload 14
    //   3051: invokevirtual 1700	java/net/Socket:close	()V
    //   3054: iload 5
    //   3056: istore_3
    //   3057: aload_0
    //   3058: aconst_null
    //   3059: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3062: iload 5
    //   3064: istore_2
    //   3065: aload_0
    //   3066: aconst_null
    //   3067: invokevirtual 1660	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   3070: aconst_null
    //   3071: astore 16
    //   3073: iload_1
    //   3074: istore_3
    //   3075: sipush -1000
    //   3078: istore_1
    //   3079: iload 5
    //   3081: istore_2
    //   3082: aload 16
    //   3084: astore 14
    //   3086: goto -2970 -> 116
    //   3089: iload_2
    //   3090: istore_3
    //   3091: aload_0
    //   3092: getfield 118	oicq/wlogin_sdk/request/oicq_request:f	I
    //   3095: iconst_1
    //   3096: iadd
    //   3097: istore 7
    //   3099: iload_1
    //   3100: iload 7
    //   3102: isub
    //   3103: istore 6
    //   3105: iload 6
    //   3107: ifle +752 -> 3859
    //   3110: iload_2
    //   3111: istore_3
    //   3112: aload 16
    //   3114: aload_0
    //   3115: getfield 144	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   3118: iload 7
    //   3120: iload 6
    //   3122: invokevirtual 1697	java/io/InputStream:read	([BII)I
    //   3125: istore 5
    //   3127: iload 5
    //   3129: iconst_m1
    //   3130: if_icmpne +712 -> 3842
    //   3133: goto +3 -> 3136
    //   3136: iload 5
    //   3138: iconst_m1
    //   3139: if_icmpne +60 -> 3199
    //   3142: iload_2
    //   3143: iconst_1
    //   3144: iadd
    //   3145: istore 5
    //   3147: aload 14
    //   3149: astore 16
    //   3151: iload 8
    //   3153: ifne +30 -> 3183
    //   3156: iload 5
    //   3158: istore_3
    //   3159: aload 14
    //   3161: invokevirtual 1700	java/net/Socket:close	()V
    //   3164: iload 5
    //   3166: istore_3
    //   3167: aload_0
    //   3168: aconst_null
    //   3169: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3172: iload 5
    //   3174: istore_2
    //   3175: aload_0
    //   3176: aconst_null
    //   3177: invokevirtual 1660	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   3180: aconst_null
    //   3181: astore 16
    //   3183: iload_1
    //   3184: istore_3
    //   3185: sipush -1000
    //   3188: istore_1
    //   3189: iload 5
    //   3191: istore_2
    //   3192: aload 16
    //   3194: astore 14
    //   3196: goto -3080 -> 116
    //   3199: iload 4
    //   3201: istore_3
    //   3202: iload 5
    //   3204: istore 6
    //   3206: iload_1
    //   3207: istore 4
    //   3209: iload_2
    //   3210: istore 5
    //   3212: iload 6
    //   3214: istore_1
    //   3215: goto +132 -> 3347
    //   3218: iload_1
    //   3219: istore 5
    //   3221: aload 14
    //   3223: astore 16
    //   3225: iload_3
    //   3226: istore_2
    //   3227: iload_2
    //   3228: iconst_1
    //   3229: iadd
    //   3230: istore_2
    //   3231: aload 16
    //   3233: astore 14
    //   3235: iload 8
    //   3237: ifne +29 -> 3266
    //   3240: aload 16
    //   3242: invokevirtual 1705	java/net/Socket:isConnected	()Z
    //   3245: ifeq +8 -> 3253
    //   3248: aload 16
    //   3250: invokevirtual 1700	java/net/Socket:close	()V
    //   3253: aload_0
    //   3254: aconst_null
    //   3255: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3258: aload_0
    //   3259: aconst_null
    //   3260: invokevirtual 1660	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   3263: aconst_null
    //   3264: astore 14
    //   3266: sipush -1000
    //   3269: istore_1
    //   3270: iload 5
    //   3272: istore_3
    //   3273: goto -3157 -> 116
    //   3276: sipush -1026
    //   3279: iload_1
    //   3280: if_icmpeq +10 -> 3290
    //   3283: sipush -1000
    //   3286: istore_1
    //   3287: goto +3 -> 3290
    //   3290: iload_2
    //   3291: iconst_1
    //   3292: iadd
    //   3293: istore_2
    //   3294: aload_0
    //   3295: aconst_null
    //   3296: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3299: aload_0
    //   3300: aconst_null
    //   3301: invokevirtual 1660	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   3304: aconst_null
    //   3305: astore 14
    //   3307: goto -3191 -> 116
    //   3310: iload_2
    //   3311: iconst_1
    //   3312: iadd
    //   3313: istore_2
    //   3314: aload_0
    //   3315: aconst_null
    //   3316: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3319: aload_0
    //   3320: aconst_null
    //   3321: invokevirtual 1660	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   3324: aconst_null
    //   3325: astore 14
    //   3327: sipush -1026
    //   3330: istore_1
    //   3331: goto -3215 -> 116
    //   3334: iload 4
    //   3336: istore 6
    //   3338: iload_2
    //   3339: istore 5
    //   3341: iload_3
    //   3342: istore 4
    //   3344: iload 6
    //   3346: istore_3
    //   3347: iload 5
    //   3349: bipush 6
    //   3351: if_icmplt +19 -> 3370
    //   3354: iload_1
    //   3355: istore_2
    //   3356: sipush -1026
    //   3359: iload_1
    //   3360: if_icmpeq +12 -> 3372
    //   3363: sipush -1000
    //   3366: istore_2
    //   3367: goto +5 -> 3372
    //   3370: iconst_0
    //   3371: istore_2
    //   3372: iload_2
    //   3373: ifne +13 -> 3386
    //   3376: aload_0
    //   3377: aload_0
    //   3378: getfield 144	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   3381: iload 4
    //   3383: invokevirtual 680	oicq/wlogin_sdk/request/oicq_request:b	([BI)V
    //   3386: iload_2
    //   3387: ifne +209 -> 3596
    //   3390: aload_0
    //   3391: getfield 146	oicq/wlogin_sdk/request/oicq_request:t	I
    //   3394: sipush 2066
    //   3397: if_icmpeq +199 -> 3596
    //   3400: new 190	oicq/wlogin_sdk/report/report_t3
    //   3403: dup
    //   3404: invokespecial 191	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   3407: astore 13
    //   3409: aload 13
    //   3411: aload_0
    //   3412: getfield 146	oicq/wlogin_sdk/request/oicq_request:t	I
    //   3415: putfield 194	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   3418: aload 13
    //   3420: aload_0
    //   3421: getfield 148	oicq/wlogin_sdk/request/oicq_request:u	I
    //   3424: putfield 197	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   3427: aload 13
    //   3429: iload_2
    //   3430: putfield 200	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   3433: aload 13
    //   3435: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   3438: lload 11
    //   3440: lsub
    //   3441: l2i
    //   3442: putfield 209	oicq/wlogin_sdk/report/report_t3:_used	I
    //   3445: aload 13
    //   3447: iload 5
    //   3449: putfield 212	oicq/wlogin_sdk/report/report_t3:_try	I
    //   3452: aload 13
    //   3454: getstatic 104	oicq/wlogin_sdk/request/oicq_request:H	Ljava/lang/String;
    //   3457: putfield 215	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   3460: aload 13
    //   3462: getfield 215	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   3465: ifnonnull +10 -> 3475
    //   3468: aload 13
    //   3470: ldc 100
    //   3472: putfield 215	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   3475: aload_0
    //   3476: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3479: astore 14
    //   3481: aload 14
    //   3483: ifnonnull +13 -> 3496
    //   3486: aload 13
    //   3488: ldc 100
    //   3490: putfield 218	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   3493: goto +16 -> 3509
    //   3496: aload 13
    //   3498: aload 14
    //   3500: invokevirtual 224	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   3503: invokevirtual 230	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   3506: putfield 218	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   3509: aload 13
    //   3511: aload_0
    //   3512: getfield 142	oicq/wlogin_sdk/request/oicq_request:r	I
    //   3515: putfield 236	oicq/wlogin_sdk/report/report_t3:_port	I
    //   3518: aload 13
    //   3520: iload_3
    //   3521: putfield 239	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   3524: aload 13
    //   3526: getstatic 243	oicq/wlogin_sdk/request/t:D	I
    //   3529: putfield 246	oicq/wlogin_sdk/report/report_t3:_net	I
    //   3532: aload 13
    //   3534: ldc 100
    //   3536: putfield 249	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   3539: aload 13
    //   3541: aload 20
    //   3543: arraylength
    //   3544: putfield 252	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   3547: aload 13
    //   3549: iload 4
    //   3551: putfield 255	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   3554: iload 8
    //   3556: ifeq +26 -> 3582
    //   3559: iload 9
    //   3561: ifeq +12 -> 3573
    //   3564: aload 13
    //   3566: iconst_2
    //   3567: putfield 258	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   3570: goto +18 -> 3588
    //   3573: aload 13
    //   3575: iconst_1
    //   3576: putfield 258	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   3579: goto +9 -> 3588
    //   3582: aload 13
    //   3584: iconst_0
    //   3585: putfield 258	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   3588: getstatic 262	oicq/wlogin_sdk/request/t:an	Loicq/wlogin_sdk/report/Reporter;
    //   3591: aload 13
    //   3593: invokevirtual 268	oicq/wlogin_sdk/report/Reporter:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   3596: new 426	java/lang/StringBuilder
    //   3599: dup
    //   3600: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   3603: astore 13
    //   3605: aload 13
    //   3607: aload_0
    //   3608: invokevirtual 634	java/lang/Object:getClass	()Ljava/lang/Class;
    //   3611: invokevirtual 639	java/lang/Class:getName	()Ljava/lang/String;
    //   3614: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3617: pop
    //   3618: aload 13
    //   3620: ldc_w 1707
    //   3623: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3626: pop
    //   3627: aload 13
    //   3629: iload_2
    //   3630: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3633: pop
    //   3634: aload 13
    //   3636: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3639: astore 13
    //   3641: new 426	java/lang/StringBuilder
    //   3644: dup
    //   3645: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   3648: astore 14
    //   3650: aload 14
    //   3652: ldc 100
    //   3654: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3657: pop
    //   3658: aload 14
    //   3660: aload_0
    //   3661: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   3664: getfield 447	oicq/wlogin_sdk/request/t:f	J
    //   3667: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3670: pop
    //   3671: aload 13
    //   3673: aload 14
    //   3675: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3678: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3681: iload_2
    //   3682: ireturn
    //   3683: astore 16
    //   3685: goto -1905 -> 1780
    //   3688: astore 16
    //   3690: goto -1931 -> 1759
    //   3693: astore 16
    //   3695: goto -3214 -> 481
    //   3698: astore 16
    //   3700: goto -3226 -> 474
    //   3703: astore 16
    //   3705: goto -3366 -> 339
    //   3708: astore 16
    //   3710: goto -3378 -> 332
    //   3713: astore 16
    //   3715: goto -3247 -> 468
    //   3718: astore 16
    //   3720: goto -3258 -> 462
    //   3723: astore 16
    //   3725: goto -3257 -> 468
    //   3728: astore 16
    //   3730: goto -3268 -> 462
    //   3733: astore 13
    //   3735: aload 16
    //   3737: astore 13
    //   3739: goto -3254 -> 485
    //   3742: astore 13
    //   3744: aload 17
    //   3746: astore 13
    //   3748: goto -3270 -> 478
    //   3751: astore 13
    //   3753: goto -3020 -> 733
    //   3756: astore 13
    //   3758: goto -3032 -> 726
    //   3761: astore 16
    //   3763: goto -2010 -> 1753
    //   3766: astore 17
    //   3768: goto -1758 -> 2010
    //   3771: astore 14
    //   3773: goto -463 -> 3310
    //   3776: astore 14
    //   3778: goto -502 -> 3276
    //   3781: astore 16
    //   3783: iload 6
    //   3785: istore_2
    //   3786: aload 14
    //   3788: astore 16
    //   3790: iload_3
    //   3791: istore 5
    //   3793: goto -566 -> 3227
    //   3796: astore 14
    //   3798: goto -886 -> 2912
    //   3801: astore 16
    //   3803: goto -585 -> 3218
    //   3806: astore 14
    //   3808: goto -808 -> 3000
    //   3811: astore 14
    //   3813: goto -560 -> 3253
    //   3816: aload 19
    //   3818: astore 18
    //   3820: goto -3009 -> 811
    //   3823: iload 5
    //   3825: iconst_1
    //   3826: iadd
    //   3827: istore_2
    //   3828: goto -3712 -> 116
    //   3831: goto -1137 -> 2694
    //   3834: iload_1
    //   3835: iload 5
    //   3837: iadd
    //   3838: istore_1
    //   3839: goto -1016 -> 2823
    //   3842: iload 7
    //   3844: iload 5
    //   3846: iadd
    //   3847: istore 7
    //   3849: iload 6
    //   3851: iload 5
    //   3853: isub
    //   3854: istore 6
    //   3856: goto -751 -> 3105
    //   3859: goto -723 -> 3136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3862	0	this	oicq_request
    //   98	3741	1	i1	int
    //   100	3728	2	i2	int
    //   108	3683	3	i3	int
    //   102	3448	4	i4	int
    //   309	3545	5	i5	int
    //   297	3558	6	i6	int
    //   3097	751	7	i7	int
    //   95	3460	8	bool1	boolean
    //   105	3455	9	bool2	boolean
    //   282	428	10	bool3	boolean
    //   114	3325	11	l1	long
    //   7	3665	13	localObject1	Object
    //   3733	1	13	localConnectException1	java.net.ConnectException
    //   3737	1	13	localObject2	Object
    //   3742	1	13	localException1	Exception
    //   3746	1	13	localObject3	Object
    //   3751	1	13	localConnectException2	java.net.ConnectException
    //   3756	1	13	localException2	Exception
    //   45	3629	14	localObject4	Object
    //   3771	1	14	localConnectException3	java.net.ConnectException
    //   3776	11	14	localThrowable1	java.lang.Throwable
    //   3796	1	14	localThrowable2	java.lang.Throwable
    //   3806	1	14	localThrowable3	java.lang.Throwable
    //   3811	1	14	localException3	Exception
    //   92	2284	15	str	String
    //   193	3056	16	localObject5	Object
    //   3683	1	16	localConnectException4	java.net.ConnectException
    //   3688	1	16	localException4	Exception
    //   3693	1	16	localConnectException5	java.net.ConnectException
    //   3698	1	16	localException5	Exception
    //   3703	1	16	localConnectException6	java.net.ConnectException
    //   3708	1	16	localException6	Exception
    //   3713	1	16	localConnectException7	java.net.ConnectException
    //   3718	1	16	localException7	Exception
    //   3723	1	16	localConnectException8	java.net.ConnectException
    //   3728	8	16	localException8	Exception
    //   3761	1	16	localException9	Exception
    //   3781	1	16	localThrowable4	java.lang.Throwable
    //   3788	1	16	localThrowable5	java.lang.Throwable
    //   3801	1	16	localThrowable6	java.lang.Throwable
    //   234	3511	17	localObject6	Object
    //   3766	1	17	localException10	Exception
    //   292	3527	18	localObject7	Object
    //   274	3543	19	localObject8	Object
    //   82	3460	20	arrayOfByte	byte[]
    //   433	661	21	localObject9	Object
    //   1046	50	22	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   276	284	3683	java/net/ConnectException
    //   276	284	3688	java/lang/Exception
    //   289	299	3693	java/net/ConnectException
    //   289	299	3698	java/lang/Exception
    //   304	311	3703	java/net/ConnectException
    //   304	311	3708	java/lang/Exception
    //   346	435	3713	java/net/ConnectException
    //   346	435	3718	java/lang/Exception
    //   435	456	3723	java/net/ConnectException
    //   435	456	3728	java/lang/Exception
    //   514	523	3733	java/net/ConnectException
    //   531	540	3733	java/net/ConnectException
    //   548	556	3733	java/net/ConnectException
    //   564	573	3733	java/net/ConnectException
    //   581	589	3733	java/net/ConnectException
    //   597	606	3733	java/net/ConnectException
    //   614	628	3733	java/net/ConnectException
    //   639	657	3733	java/net/ConnectException
    //   665	672	3733	java/net/ConnectException
    //   680	692	3733	java/net/ConnectException
    //   700	709	3733	java/net/ConnectException
    //   748	757	3733	java/net/ConnectException
    //   765	774	3733	java/net/ConnectException
    //   782	790	3733	java/net/ConnectException
    //   798	811	3733	java/net/ConnectException
    //   819	828	3733	java/net/ConnectException
    //   836	845	3733	java/net/ConnectException
    //   853	861	3733	java/net/ConnectException
    //   869	878	3733	java/net/ConnectException
    //   886	900	3733	java/net/ConnectException
    //   908	917	3733	java/net/ConnectException
    //   925	934	3733	java/net/ConnectException
    //   942	950	3733	java/net/ConnectException
    //   958	967	3733	java/net/ConnectException
    //   975	983	3733	java/net/ConnectException
    //   991	1000	3733	java/net/ConnectException
    //   1008	1016	3733	java/net/ConnectException
    //   1024	1031	3733	java/net/ConnectException
    //   1039	1048	3733	java/net/ConnectException
    //   1056	1064	3733	java/net/ConnectException
    //   1072	1085	3733	java/net/ConnectException
    //   1093	1103	3733	java/net/ConnectException
    //   1111	1121	3733	java/net/ConnectException
    //   1129	1137	3733	java/net/ConnectException
    //   1150	1160	3733	java/net/ConnectException
    //   1168	1179	3733	java/net/ConnectException
    //   1187	1198	3733	java/net/ConnectException
    //   1206	1220	3733	java/net/ConnectException
    //   1228	1240	3733	java/net/ConnectException
    //   1248	1260	3733	java/net/ConnectException
    //   1268	1274	3733	java/net/ConnectException
    //   1282	1288	3733	java/net/ConnectException
    //   1296	1305	3733	java/net/ConnectException
    //   1313	1321	3733	java/net/ConnectException
    //   1329	1342	3733	java/net/ConnectException
    //   1350	1361	3733	java/net/ConnectException
    //   1369	1385	3733	java/net/ConnectException
    //   1393	1402	3733	java/net/ConnectException
    //   1410	1418	3733	java/net/ConnectException
    //   1426	1439	3733	java/net/ConnectException
    //   1447	1458	3733	java/net/ConnectException
    //   1480	1489	3733	java/net/ConnectException
    //   1497	1505	3733	java/net/ConnectException
    //   1513	1526	3733	java/net/ConnectException
    //   1534	1545	3733	java/net/ConnectException
    //   1553	1560	3733	java/net/ConnectException
    //   1568	1579	3733	java/net/ConnectException
    //   1587	1592	3733	java/net/ConnectException
    //   1600	1607	3733	java/net/ConnectException
    //   1611	1620	3733	java/net/ConnectException
    //   1624	1633	3733	java/net/ConnectException
    //   1637	1645	3733	java/net/ConnectException
    //   1649	1656	3733	java/net/ConnectException
    //   1660	1669	3733	java/net/ConnectException
    //   1673	1681	3733	java/net/ConnectException
    //   1685	1698	3733	java/net/ConnectException
    //   1702	1712	3733	java/net/ConnectException
    //   1736	1743	3733	java/net/ConnectException
    //   514	523	3742	java/lang/Exception
    //   531	540	3742	java/lang/Exception
    //   548	556	3742	java/lang/Exception
    //   564	573	3742	java/lang/Exception
    //   581	589	3742	java/lang/Exception
    //   597	606	3742	java/lang/Exception
    //   614	628	3742	java/lang/Exception
    //   639	657	3742	java/lang/Exception
    //   665	672	3742	java/lang/Exception
    //   680	692	3742	java/lang/Exception
    //   700	709	3742	java/lang/Exception
    //   748	757	3742	java/lang/Exception
    //   765	774	3742	java/lang/Exception
    //   782	790	3742	java/lang/Exception
    //   798	811	3742	java/lang/Exception
    //   819	828	3742	java/lang/Exception
    //   836	845	3742	java/lang/Exception
    //   853	861	3742	java/lang/Exception
    //   869	878	3742	java/lang/Exception
    //   886	900	3742	java/lang/Exception
    //   908	917	3742	java/lang/Exception
    //   925	934	3742	java/lang/Exception
    //   942	950	3742	java/lang/Exception
    //   958	967	3742	java/lang/Exception
    //   975	983	3742	java/lang/Exception
    //   991	1000	3742	java/lang/Exception
    //   1008	1016	3742	java/lang/Exception
    //   1024	1031	3742	java/lang/Exception
    //   1039	1048	3742	java/lang/Exception
    //   1056	1064	3742	java/lang/Exception
    //   1072	1085	3742	java/lang/Exception
    //   1093	1103	3742	java/lang/Exception
    //   1111	1121	3742	java/lang/Exception
    //   1129	1137	3742	java/lang/Exception
    //   1150	1160	3742	java/lang/Exception
    //   1168	1179	3742	java/lang/Exception
    //   1187	1198	3742	java/lang/Exception
    //   1206	1220	3742	java/lang/Exception
    //   1228	1240	3742	java/lang/Exception
    //   1248	1260	3742	java/lang/Exception
    //   1268	1274	3742	java/lang/Exception
    //   1282	1288	3742	java/lang/Exception
    //   1296	1305	3742	java/lang/Exception
    //   1313	1321	3742	java/lang/Exception
    //   1329	1342	3742	java/lang/Exception
    //   1350	1361	3742	java/lang/Exception
    //   1369	1385	3742	java/lang/Exception
    //   1393	1402	3742	java/lang/Exception
    //   1410	1418	3742	java/lang/Exception
    //   1426	1439	3742	java/lang/Exception
    //   1447	1458	3742	java/lang/Exception
    //   1480	1489	3742	java/lang/Exception
    //   1497	1505	3742	java/lang/Exception
    //   1513	1526	3742	java/lang/Exception
    //   1534	1545	3742	java/lang/Exception
    //   1553	1560	3742	java/lang/Exception
    //   1568	1579	3742	java/lang/Exception
    //   1587	1592	3742	java/lang/Exception
    //   1600	1607	3742	java/lang/Exception
    //   714	719	3751	java/net/ConnectException
    //   714	719	3756	java/lang/Exception
    //   1611	1620	3761	java/lang/Exception
    //   1624	1633	3761	java/lang/Exception
    //   1637	1645	3761	java/lang/Exception
    //   1649	1656	3761	java/lang/Exception
    //   1660	1669	3761	java/lang/Exception
    //   1673	1681	3761	java/lang/Exception
    //   1685	1698	3761	java/lang/Exception
    //   1702	1712	3761	java/lang/Exception
    //   1736	1743	3761	java/lang/Exception
    //   1979	2010	3766	java/lang/Exception
    //   2470	2691	3771	java/net/ConnectException
    //   2694	2765	3771	java/net/ConnectException
    //   2470	2691	3776	java/lang/Throwable
    //   2694	2765	3776	java/lang/Throwable
    //   2768	2777	3781	java/lang/Throwable
    //   2780	2788	3781	java/lang/Throwable
    //   2791	2804	3781	java/lang/Throwable
    //   2807	2818	3781	java/lang/Throwable
    //   2826	2836	3781	java/lang/Throwable
    //   2839	2859	3781	java/lang/Throwable
    //   2888	2893	3781	java/lang/Throwable
    //   2896	2901	3781	java/lang/Throwable
    //   2935	2944	3781	java/lang/Throwable
    //   2901	2906	3796	java/lang/Throwable
    //   2946	2956	3801	java/lang/Throwable
    //   2973	2978	3801	java/lang/Throwable
    //   2981	2986	3801	java/lang/Throwable
    //   3023	3032	3801	java/lang/Throwable
    //   3049	3054	3801	java/lang/Throwable
    //   3057	3062	3801	java/lang/Throwable
    //   3091	3099	3801	java/lang/Throwable
    //   3112	3127	3801	java/lang/Throwable
    //   3159	3164	3801	java/lang/Throwable
    //   3167	3172	3801	java/lang/Throwable
    //   2989	2994	3806	java/lang/Throwable
    //   3065	3070	3806	java/lang/Throwable
    //   3175	3180	3806	java/lang/Throwable
    //   3240	3253	3811	java/lang/Exception
  }
  
  public int f()
  {
    return t.b(this.x.h)._last_flowid;
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