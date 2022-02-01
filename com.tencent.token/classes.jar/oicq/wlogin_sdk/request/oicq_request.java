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
        break label182;
      }
    }
    if (paramInt <= 0)
    {
      if (paramBoolean)
      {
        if (t.D == 1)
        {
          str1 = new String(util.get_wap_server_host1(t.t));
          break label140;
        }
        if (t.D == 2)
        {
          str1 = new String(util.get_wap_server_host2(t.t));
          break label140;
        }
      }
      else
      {
        if (t.D == 1)
        {
          str1 = new String(util.get_server_host1(t.t));
          break label140;
        }
        if (t.D == 2)
        {
          str1 = new String(util.get_server_host2(t.t));
          break label140;
        }
      }
      str1 = "";
      label140:
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
    label182:
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
      StringBuilder localStringBuilder = new StringBuilder("net type:");
      localStringBuilder.append(t.D);
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
    util.LOGI("getRequestEncrptedPackage unknown encryption method ".concat(String.valueOf(paramEncryptionMethod)), String.valueOf(paramLong));
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
          t.an.attr_api(2461266);
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
        this.c += this.f + 2 + localObject1.length;
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
      t.an.add_t3(paramWUserSigInfo);
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
      if (t.B.length > 16)
      {
        System.arraycopy(t.B, 0, localObject1, 0, 16);
      }
      else
      {
        System.arraycopy(t.B, 0, localObject1, 0, t.B.length);
        int i2;
        for (i1 = t.B.length; i1 < 16; i1 = i2)
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
    if (paramInt2 < 5) {
      return -1009;
    }
    tlv_t104 localtlv_t104 = new tlv_t104();
    tlv_t105 localtlv_t105 = new tlv_t105();
    Object localObject1 = new tlv_t113();
    Object localObject15 = new tlv_t119();
    tlv_t10d localtlv_t10d = new tlv_t10d();
    tlv_t10e localtlv_t10e = new tlv_t10e();
    tlv_t10a localtlv_t10a = new tlv_t10a();
    tlv_t114 localtlv_t114 = new tlv_t114();
    Object localObject3 = new tlv_t103();
    tlv_t11a localtlv_t11a = new tlv_t11a();
    Object localObject4 = new tlv_t102();
    Object localObject5 = new tlv_t10b();
    Object localObject6 = new tlv_t11c();
    tlv_t11d localtlv_t11d = new tlv_t11d();
    Object localObject7 = new tlv_t120();
    Object localObject8 = new tlv_t121();
    tlv_t130 localtlv_t130 = new tlv_t130();
    Object localObject14 = new tlv_t108();
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
    Object localObject12 = new tlv_t171();
    Object localObject11 = new tlv_t(1298);
    Object localObject10 = new tlv_t16d();
    tlv_t174 localtlv_t174 = new tlv_t174();
    tlv_t178 localtlv_t178 = new tlv_t178();
    Object localObject17 = new tlv_t179();
    tlv_t17d localtlv_t17d = new tlv_t17d();
    tlv_t17e localtlv_t17e = new tlv_t17e();
    tlv_t126 localtlv_t126 = new tlv_t126();
    tlv_t182 localtlv_t182 = new tlv_t182();
    tlv_t183 localtlv_t183 = new tlv_t183();
    Object localObject2 = new tlv_t186();
    Object localObject16 = new tlv_t402();
    Object localObject13 = new tlv_t403();
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
    int i3 = c(paramArrayOfByte, paramInt1 + 2);
    int i4 = paramInt1 + 5;
    t localt = this.x;
    localt.d = null;
    label1009:
    int i5;
    if ((i3 != 41) && (i3 != 116))
    {
      label2298:
      int i7;
      label4948:
      int i6;
      int i8;
      if (i3 != 160)
      {
        if (i3 != 176)
        {
          if (i3 != 180)
          {
            if (i3 != 204)
            {
              if (i3 != 208)
              {
                switch (i3)
                {
                default: 
                  switch (i3)
                  {
                  default: 
                    break;
                  case 16: 
                    localt.e(localt.f, l3);
                    paramInt1 = localtlv_t130.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
                    if (paramInt1 >= 0)
                    {
                      this.x.a(localtlv_t130.get_time(), localtlv_t130.get_ipaddr());
                      break;
                    }
                    i2 = i3;
                    i1 = paramInt2;
                  }
                  break;
                case 2: 
                  paramInt1 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
                  if (paramInt1 >= 0)
                  {
                    localasync_context._t104 = localtlv_t104;
                    localObject1 = new tlv_t192();
                    if (((tlv_t192)localObject1).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
                    {
                      a(new ErrMsg(i3, "", "", ((tlv_t192)localObject1).getUrl()));
                    }
                    else
                    {
                      paramInt1 = localtlv_t105.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
                      if (paramInt1 < 0) {
                        break label1009;
                      }
                      localasync_context._t105 = localtlv_t105;
                      if (localtlv_t165.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
                        localasync_context._t165 = localtlv_t165;
                      } else {
                        localasync_context._t165 = new tlv_t165();
                      }
                      a(null);
                    }
                    break label6246;
                    i2 = i3;
                    i1 = paramInt2;
                    break label6256;
                  }
                  i2 = i3;
                  i1 = paramInt2;
                  break;
                case 1: 
                  localObject1 = new StringBuilder("cmd ");
                  ((StringBuilder)localObject1).append(Integer.toHexString(this.t));
                  ((StringBuilder)localObject1).append(" subcmd ");
                  ((StringBuilder)localObject1).append(Integer.toHexString(this.u));
                  ((StringBuilder)localObject1).append(" result ");
                  ((StringBuilder)localObject1).append(i3);
                  ((StringBuilder)localObject1).append(" will clean sig for uin ");
                  ((StringBuilder)localObject1).append(this.x.f);
                  ((StringBuilder)localObject1).append(" appid ");
                  ((StringBuilder)localObject1).append(l3);
                  util.LOGI(((StringBuilder)localObject1).toString());
                  localObject1 = this.x;
                  ((t)localObject1).e(((t)localObject1).f, l3);
                  break;
                case 0: 
                  if (paramInt2 == 1)
                  {
                    if (localt.b == null) {
                      return -1006;
                    }
                    if (localtlv_t150.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
                      this.x.d = localtlv_t150;
                    }
                    if (localtlv_t161.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
                      a(localtlv_t161);
                    }
                    paramInt1 = ((tlv_t119)localObject15).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1, this.x.b);
                  }
                  else
                  {
                    localObject17 = localObject15;
                    if (paramInt2 == 2)
                    {
                      if (localtlv_t183.get_tlv(paramArrayOfByte, i4, this.c - i4) >= 0) {
                        localasync_context._msalt = localtlv_t183.getMsalt();
                      }
                      if (f() == 3)
                      {
                        if (((tlv_t113)localObject1).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
                        {
                          this.x.f = ((tlv_t113)localObject1).get_uin();
                          localObject1 = this.x;
                          ((t)localObject1).a(((t)localObject1).g, Long.valueOf(this.x.f));
                        }
                        if (localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
                          localasync_context._t104 = localtlv_t104;
                        }
                        i2 = i3;
                        paramInt1 = 0;
                        i1 = paramInt2;
                        break label6256;
                      }
                      if (localtlv_t150.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
                        this.x.d = localtlv_t150;
                      }
                      if (localtlv_t161.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
                        a(localtlv_t161);
                      }
                      paramInt1 = ((tlv_t119)localObject17).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1, localasync_context._tgtgt_key);
                    }
                    else
                    {
                      localObject16 = localObject1;
                      if ((paramInt2 == 3) || (paramInt2 == 7)) {
                        break label4948;
                      }
                      if (22 == this.u)
                      {
                        paramInt1 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4);
                        if (paramInt1 >= 0)
                        {
                          localasync_context._t104 = localtlv_t104;
                          i2 = i3;
                          paramInt1 = 0;
                          i1 = paramInt2;
                          break label6256;
                        }
                        i2 = i3;
                        i1 = paramInt2;
                        break label6256;
                      }
                      if (localtlv_t150.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
                        this.x.d = localtlv_t150;
                      }
                      if (localtlv_t161.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
                        a(localtlv_t161);
                      }
                      paramInt1 = ((tlv_t119)localObject17).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1, localasync_context._tgtgt_key);
                      s.I = 0;
                    }
                  }
                  if (paramInt1 >= 0)
                  {
                    localObject16 = ((tlv_t119)localObject15).get_data();
                    i5 = localObject16.length;
                    if (localtlv_t149.get_tlv((byte[])localObject16, 2, i5) > 0) {
                      a(localtlv_t149);
                    }
                    if (localtlv_t130.get_tlv((byte[])localObject16, 2, i5) > 0) {
                      this.x.a(localtlv_t130.get_time(), localtlv_t130.get_ipaddr());
                    }
                    if (((tlv_t113)localObject1).get_tlv((byte[])localObject16, 2, i5) >= 0)
                    {
                      this.x.f = ((tlv_t113)localObject1).get_uin();
                      localObject1 = this.x;
                      ((t)localObject1).a(((t)localObject1).g, Long.valueOf(this.x.f));
                    }
                    localObject1 = new tlv_t(1320);
                    if (((tlv_t)localObject1).get_tlv((byte[])localObject16, 2, i5) > 0)
                    {
                      localObject15 = new StringBuilder("get tlv528 and put into context from seq ");
                      ((StringBuilder)localObject15).append(this.x.h);
                      localObject15 = ((StringBuilder)localObject15).toString();
                      localObject17 = new StringBuilder();
                      ((StringBuilder)localObject17).append(this.x.f);
                      util.LOGI((String)localObject15, ((StringBuilder)localObject17).toString());
                      localasync_context.tlv528 = ((tlv_t)localObject1);
                    }
                    localtlv_t10d.get_tlv((byte[])localObject16, 2, i5);
                    localtlv_t10e.get_tlv((byte[])localObject16, 2, i5);
                    localtlv_t10a.get_tlv((byte[])localObject16, 2, i5);
                    localtlv_t114.get_tlv((byte[])localObject16, 2, i5);
                    paramInt1 = localtlv_t11a.get_tlv((byte[])localObject16, 2, i5);
                    if (paramInt1 >= 0)
                    {
                      i2 = i3;
                      if (localtlv_t118.get_tlv((byte[])localObject16, 2, i5) < 0)
                      {
                        localObject1 = new StringBuilder();
                        ((StringBuilder)localObject1).append(this.x.f);
                        util.LOGI("t118 get failed", ((StringBuilder)localObject1).toString());
                      }
                      if (((tlv_t103)localObject3).get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject3 = ((tlv_t103)localObject3).get_data();
                      } else {
                        localObject3 = null;
                      }
                      if (((tlv_t108)localObject14).get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        util.set_ksid(t.t, ((tlv_t108)localObject14).get_data());
                      }
                      if (((tlv_t102)localObject4).get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject4 = ((tlv_t102)localObject4).get_data();
                      } else {
                        localObject4 = null;
                      }
                      if (((tlv_t10b)localObject5).get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject5 = ((tlv_t10b)localObject5).get_data();
                      } else {
                        localObject5 = null;
                      }
                      if (((tlv_t11c)localObject6).get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject6 = ((tlv_t11c)localObject6).get_data();
                      } else {
                        localObject6 = null;
                      }
                      if (((tlv_t120)localObject7).get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject7 = ((tlv_t120)localObject7).get_data();
                      } else {
                        localObject7 = null;
                      }
                      if (((tlv_t121)localObject8).get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject8 = ((tlv_t121)localObject8).get_data();
                      } else {
                        localObject8 = null;
                      }
                      if (((tlv_t125)localObject9).get_tlv((byte[])localObject16, 2, i5) >= 0)
                      {
                        localObject1 = ((tlv_t125)localObject9).get_openid();
                        localObject9 = ((tlv_t125)localObject9).get_openkey();
                      }
                      else
                      {
                        localObject1 = null;
                        localObject9 = null;
                      }
                      localObject14 = localObject2;
                      if (((tlv_t186)localObject14).get_tlv((byte[])localObject16, 2, i5) >= 0)
                      {
                        localObject15 = this.x.g;
                        localObject2 = localObject15;
                        if (util.check_uin_account((String)localObject15).booleanValue())
                        {
                          localObject2 = this.x;
                          localObject2 = ((t)localObject2).e(((t)localObject2).f);
                          if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
                            break label2298;
                          }
                        }
                        localObject15 = this.x;
                        ((t)localObject15).a((String)localObject2, Long.valueOf(((t)localObject15).f), ((tlv_t186)localObject14).getPwdflag());
                        localObject15 = new StringBuilder("put t186: name: ");
                        ((StringBuilder)localObject15).append((String)localObject2);
                        ((StringBuilder)localObject15).append(" uin: ");
                        ((StringBuilder)localObject15).append(this.x.f);
                        ((StringBuilder)localObject15).append(" pwd=");
                        ((StringBuilder)localObject15).append(((tlv_t186)localObject14).getPwdflag());
                        util.LOGI(((StringBuilder)localObject15).toString(), "");
                      }
                      localObject2 = new StringBuilder("tgt len:");
                      ((StringBuilder)localObject2).append(util.buf_len(localtlv_t10a.get_data()));
                      ((StringBuilder)localObject2).append(" tgt_key len:");
                      ((StringBuilder)localObject2).append(util.buf_len(localtlv_t10d.get_data()));
                      ((StringBuilder)localObject2).append(" st len:");
                      ((StringBuilder)localObject2).append(util.buf_len(localtlv_t114.get_data()));
                      ((StringBuilder)localObject2).append(" st_key len:");
                      ((StringBuilder)localObject2).append(util.buf_len(localtlv_t10e.get_data()));
                      ((StringBuilder)localObject2).append(" stwx_web len:");
                      ((StringBuilder)localObject2).append(util.buf_len((byte[])localObject3));
                      ((StringBuilder)localObject2).append(" lskey len:");
                      ((StringBuilder)localObject2).append(util.buf_len((byte[])localObject6));
                      ((StringBuilder)localObject2).append(" skey len:");
                      ((StringBuilder)localObject2).append(util.buf_len((byte[])localObject7));
                      ((StringBuilder)localObject2).append(" sig64 len:");
                      ((StringBuilder)localObject2).append(util.buf_len((byte[])localObject8));
                      ((StringBuilder)localObject2).append(" openid len:");
                      ((StringBuilder)localObject2).append(util.buf_len((byte[])localObject1));
                      ((StringBuilder)localObject2).append(" openkey len:");
                      ((StringBuilder)localObject2).append(util.buf_len((byte[])localObject9));
                      ((StringBuilder)localObject2).append(" pwdflag: ");
                      ((StringBuilder)localObject2).append(((tlv_t186)localObject14).get_data_len());
                      ((StringBuilder)localObject2).append(" ");
                      ((StringBuilder)localObject2).append(((tlv_t186)localObject14).getPwdflag());
                      localObject2 = ((StringBuilder)localObject2).toString();
                      localObject14 = new StringBuilder();
                      ((StringBuilder)localObject14).append(this.x.f);
                      util.LOGI((String)localObject2, ((StringBuilder)localObject14).toString());
                      if (localtlv_t169.get_tlv((byte[])localObject16, 2, i5) >= 0)
                      {
                        localObject2 = a(localtlv_t169);
                        if ((localObject2 != null) && (localObject2.length > 0)) {
                          this.x.j = new WFastLoginInfo((byte[])localObject2);
                        } else {
                          this.x.j = new WFastLoginInfo();
                        }
                      }
                      localObject2 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 3, 0 });
                      if (localtlv_t167.get_tlv((byte[])localObject16, 2, i5) >= 0)
                      {
                        localObject2[0] = localtlv_t167.get_img_type();
                        localObject2[1] = localtlv_t167.get_img_format();
                        localObject2[2] = localtlv_t167.get_img_url();
                      }
                      localObject14 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 5, 0 });
                      paramInt1 = 0;
                      while (paramInt1 < 5)
                      {
                        localObject14[paramInt1] = new byte[0];
                        paramInt1 += 1;
                      }
                      paramInt1 = localtlv_t10c.get_tlv((byte[])localObject16, 2, i5);
                      if ((localtlv_t106.get_tlv((byte[])localObject16, 2, i5) >= 0) && (paramInt1 >= 0))
                      {
                        localObject15 = localtlv_t10c.get_data();
                        localObject14[0] = ((byte[])b(localtlv_t106.get_data(), (byte[])localObject15).clone());
                      }
                      if (localtlv_t16a.get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject14[1] = localtlv_t16a.get_data();
                      }
                      if (((tlv_t403)localObject13).get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject14[4] = ((tlv_t403)localObject13).get_data();
                      }
                      if (localasync_context._sec_guid_flag)
                      {
                        localObject14[2] = localasync_context._G;
                        localObject14[3] = localasync_context._dpwd;
                        localObject14[4] = localasync_context._t403.get_data();
                        localasync_context._sec_guid_flag = false;
                      }
                      localObject13 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 15, 0 });
                      paramInt1 = 0;
                      while (paramInt1 < 15)
                      {
                        localObject13[paramInt1] = new byte[0];
                        paramInt1 += 1;
                      }
                      if (localtlv_t136.get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject13[0] = localtlv_t136.get_data();
                      }
                      if (localtlv_t132.get_tlv((byte[])localObject16, 2, i5) >= 0)
                      {
                        localObject13[1] = localtlv_t132.get_access_token();
                        localObject1 = localtlv_t132.get_openid();
                      }
                      if (localtlv_t143.get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject13[2] = localtlv_t143.get_data();
                      }
                      if (localtlv_t305.get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject13[3] = localtlv_t305.get_data();
                      }
                      if (localtlv_t164.get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject13[4] = localtlv_t164.get_data();
                      }
                      if (((tlv_t171)localObject12).get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject13[5] = ((tlv_t171)localObject12).get_data();
                      }
                      if (((tlv_t)localObject11).get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject13[6] = ((tlv_t)localObject11).get_data();
                      }
                      if (((tlv_t16d)localObject10).get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        localObject13[7] = ((tlv_t16d)localObject10).get_data();
                      }
                      localObject10 = new tlv_t199();
                      if (((tlv_t199)localObject10).get_tlv((byte[])localObject16, 2, i5) >= 0)
                      {
                        localObject13[8] = ((tlv_t199)localObject10).getPayToken();
                        localObject1 = ((tlv_t199)localObject10).getOpenId();
                      }
                      localObject10 = new tlv_t200();
                      if (((tlv_t200)localObject10).get_tlv((byte[])localObject16, 2, i5) >= 0)
                      {
                        localObject13[9] = ((tlv_t200)localObject10).getPf();
                        localObject13[10] = ((tlv_t200)localObject10).getPfKey();
                      }
                      localObject10 = new tlv_t(515);
                      if (((tlv_t)localObject10).get_tlv((byte[])localObject16, 2, i5) >= 0)
                      {
                        localObject13[11] = ((tlv_t)localObject10).get_data();
                        util.LOGI("get DA2 in rsp", "");
                      }
                      else
                      {
                        util.LOGI("no DA2 in rsp", "");
                      }
                      localObject10 = new tlv_t(791);
                      if (((tlv_t)localObject10).get_tlv((byte[])localObject16, 2, i5) >= 0) {
                        WloginSigInfo._QRPUSHSig = ((tlv_t)localObject10).get_data();
                      } else {
                        WloginSigInfo._QRPUSHSig = new byte[0];
                      }
                      localObject10 = new tlv_t(307);
                      if (((tlv_t)localObject10).get_tlv((byte[])localObject16, 2, i5) >= 0)
                      {
                        localObject13[13] = ((tlv_t)localObject10).get_data();
                      }
                      else
                      {
                        localObject10 = new StringBuilder();
                        ((StringBuilder)localObject10).append(this.x.f);
                        util.LOGW("get t133 failed", ((StringBuilder)localObject10).toString());
                      }
                      localObject10 = new tlv_t(308);
                      if (((tlv_t)localObject10).get_tlv((byte[])localObject16, 2, i5) >= 0)
                      {
                        localObject13[14] = ((tlv_t)localObject10).get_data();
                      }
                      else
                      {
                        localObject10 = new StringBuilder();
                        ((StringBuilder)localObject10).append(this.x.f);
                        util.LOGW("get t134 failed", ((StringBuilder)localObject10).toString());
                      }
                      localObject10 = new StringBuilder("encrypt_a1 len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject14[0]));
                      ((StringBuilder)localObject10).append(" no_pic_sig len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject14[1]));
                      ((StringBuilder)localObject10).append(" G len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject14[2]));
                      ((StringBuilder)localObject10).append(" dpwd len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject14[3]));
                      ((StringBuilder)localObject10).append(" randseed len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject14[4]));
                      ((StringBuilder)localObject10).append(" vkey len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[0]));
                      ((StringBuilder)localObject10).append(" openid len:");
                      ((StringBuilder)localObject10).append(util.buf_len((byte[])localObject1));
                      ((StringBuilder)localObject10).append(" access_token len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[1]));
                      ((StringBuilder)localObject10).append(" d2 len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[2]));
                      ((StringBuilder)localObject10).append(" d2_key len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[3]));
                      ((StringBuilder)localObject10).append(" sid len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[4]));
                      ((StringBuilder)localObject10).append(" aq_sig len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[5]));
                      ((StringBuilder)localObject10).append(" pskey len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[6]));
                      ((StringBuilder)localObject10).append(" super_key len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[7]));
                      ((StringBuilder)localObject10).append(" paytoken len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[8]));
                      ((StringBuilder)localObject10).append(" pf len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[9]));
                      ((StringBuilder)localObject10).append(" pfkey len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[10]));
                      ((StringBuilder)localObject10).append(" da2 len:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[11]));
                      ((StringBuilder)localObject10).append(" wt session ticket:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[13]));
                      ((StringBuilder)localObject10).append(" wt session ticket key:");
                      ((StringBuilder)localObject10).append(util.buf_len(localObject13[14]));
                      localObject10 = ((StringBuilder)localObject10).toString();
                      localObject11 = new StringBuilder();
                      ((StringBuilder)localObject11).append(this.x.f);
                      util.LOGI((String)localObject10, ((StringBuilder)localObject11).toString());
                      paramInt1 = localtlv_t11f.get_tlv((byte[])localObject16, 2, i5);
                      long l2 = 4294967295L;
                      if (paramInt1 >= 0) {
                        l2 = localtlv_t11f.get_tk_pri() & 0xFFFFFFFF;
                      }
                      localObject10 = new long[7];
                      paramInt1 = 2;
                      long l1 = 2160000L;
                      for (;;)
                      {
                        paramInt1 = localtlv_t138.get_tlv((byte[])localObject16, paramInt1, i5);
                        if (paramInt1 < 0) {
                          break;
                        }
                        if (localtlv_t138.get_a2_chg_time() != 0) {
                          l1 = localtlv_t138.get_a2_chg_time();
                        }
                        if (localtlv_t138.get_lskey_chg_time() != 0) {
                          localObject10[0] = localtlv_t138.get_lskey_chg_time();
                        } else {
                          localObject10[0] = 1641600L;
                        }
                        if (localtlv_t138.get_skey_chg_time() != 0) {
                          localObject10[1] = localtlv_t138.get_skey_chg_time();
                        } else {
                          localObject10[1] = 86400L;
                        }
                        if (localtlv_t138.get_vkey_chg_time() != 0) {
                          localObject10[2] = localtlv_t138.get_vkey_chg_time();
                        } else {
                          localObject10[2] = 1728000L;
                        }
                        if (localtlv_t138.get_a8_chg_time() != 0) {
                          localObject10[3] = localtlv_t138.get_a8_chg_time();
                        } else {
                          localObject10[3] = 72000L;
                        }
                        if (localtlv_t138.get_stweb_chg_time() != 0) {
                          localObject10[4] = localtlv_t138.get_stweb_chg_time();
                        } else {
                          localObject10[4] = 6000L;
                        }
                        if (localtlv_t138.get_d2_chg_time() != 0) {
                          localObject10[5] = localtlv_t138.get_d2_chg_time();
                        } else {
                          localObject10[5] = 1728000L;
                        }
                        if (localtlv_t138.get_sid_chg_time() != 0) {
                          localObject10[6] = localtlv_t138.get_sid_chg_time();
                        } else {
                          localObject10[6] = 1728000L;
                        }
                      }
                      localObject11 = new StringBuilder("sappid:");
                      ((StringBuilder)localObject11).append(l3);
                      ((StringBuilder)localObject11).append(" appid:");
                      ((StringBuilder)localObject11).append(l4);
                      ((StringBuilder)localObject11).append(" app_pri:");
                      ((StringBuilder)localObject11).append(l2);
                      ((StringBuilder)localObject11).append(" login_bitmap:");
                      ((StringBuilder)localObject11).append(localasync_context._login_bitmap);
                      ((StringBuilder)localObject11).append(" tk_valid:0 a2_valid:");
                      ((StringBuilder)localObject11).append(l1);
                      ((StringBuilder)localObject11).append(" lskey_valid:");
                      i1 = 0;
                      ((StringBuilder)localObject11).append(localObject10[0]);
                      ((StringBuilder)localObject11).append(" skey_valid:");
                      ((StringBuilder)localObject11).append(localObject10[1]);
                      ((StringBuilder)localObject11).append(" vkey_valid:");
                      ((StringBuilder)localObject11).append(localObject10[2]);
                      ((StringBuilder)localObject11).append(" a8_valid:");
                      ((StringBuilder)localObject11).append(localObject10[3]);
                      ((StringBuilder)localObject11).append(" stweb_valid:");
                      ((StringBuilder)localObject11).append(localObject10[4]);
                      ((StringBuilder)localObject11).append(" d2_valid:");
                      ((StringBuilder)localObject11).append(localObject10[5]);
                      ((StringBuilder)localObject11).append(" sid_valid:");
                      ((StringBuilder)localObject11).append(localObject10[6]);
                      localObject11 = ((StringBuilder)localObject11).toString();
                      localObject12 = new StringBuilder();
                      ((StringBuilder)localObject12).append(this.x.f);
                      util.LOGI((String)localObject11, ((StringBuilder)localObject12).toString());
                      localObject11 = new WloginSimpleInfo();
                      ((WloginSimpleInfo)localObject11).setUin(this.x.f);
                      ((WloginSimpleInfo)localObject11).setFace(localtlv_t11a.get_face());
                      ((WloginSimpleInfo)localObject11).setAge(localtlv_t11a.get_age());
                      ((WloginSimpleInfo)localObject11).setGender(localtlv_t11a.get_gender());
                      ((WloginSimpleInfo)localObject11).setNick(localtlv_t11a.get_nick());
                      ((WloginSimpleInfo)localObject11).setReserveUinInfo((byte[][])localObject2);
                      ((WloginSimpleInfo)localObject11).setMainDisplayName(localtlv_t118.get_data());
                      this.x.aq = localasync_context._main_sigmap;
                      localObject2 = this.x;
                      paramInt1 = ((t)localObject2).a(((t)localObject2).f, l3, (byte[][])localObject14, l4, l2, t.f(), t.f() + 0L, t.f() + l1, (WloginSimpleInfo)localObject11, localtlv_t10a.get_data(), localtlv_t10d.get_data(), localtlv_t114.get_data(), localtlv_t10e.get_data(), (byte[])localObject3, (byte[])localObject5, (byte[])localObject4, (byte[])localObject6, (byte[])localObject7, (byte[])localObject8, (byte[])localObject1, (byte[])localObject9, (byte[][])localObject13, (long[])localObject10, localasync_context._login_bitmap);
                      if (paramInt1 != 0)
                      {
                        localObject1 = new ErrMsg();
                        ((ErrMsg)localObject1).setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
                        a((ErrMsg)localObject1);
                        localObject1 = "put_siginfo fail,ret=".concat(String.valueOf(paramInt1));
                        localObject2 = new StringBuilder();
                        ((StringBuilder)localObject2).append(this.x.f);
                        util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
                        i1 = paramInt2;
                      }
                      else
                      {
                        paramInt1 = 2;
                        for (;;)
                        {
                          paramInt1 = localtlv_t11d.get_tlv((byte[])localObject16, paramInt1, i5);
                          if (paramInt1 < 0) {
                            break;
                          }
                          localObject1 = this.x;
                          ((t)localObject1).a(((t)localObject1).f, localtlv_t11d.get_appid(), t.f(), t.f() + 0L, localtlv_t11d.get_st(), localtlv_t11d.get_stkey());
                        }
                        paramInt1 = i1;
                        i1 = paramInt2;
                      }
                    }
                    else
                    {
                      i2 = i3;
                      i1 = paramInt2;
                    }
                  }
                  else
                  {
                    i2 = i3;
                    i1 = paramInt2;
                    break label6256;
                    i2 = i3;
                    paramInt1 = 0;
                    i3 = this.c;
                    i1 = i4;
                    localObject1 = paramArrayOfByte;
                    if (localtlv_t183.get_tlv((byte[])localObject1, i1, i3 - i4) >= 0) {
                      localasync_context._msalt = localtlv_t183.getMsalt();
                    }
                    if (((tlv_t113)localObject16).get_tlv((byte[])localObject1, i1, this.c - i1) >= 0)
                    {
                      this.x.f = ((tlv_t113)localObject16).get_uin();
                      localObject2 = this.x;
                      ((t)localObject2).a(((t)localObject2).g, Long.valueOf(this.x.f));
                    }
                    i1 = localtlv_t104.get_tlv((byte[])localObject1, i1, this.c - i1);
                    if (i1 >= 0)
                    {
                      localasync_context._t104 = localtlv_t104;
                      i1 = paramInt2;
                    }
                    else
                    {
                      paramInt1 = i1;
                      i1 = paramInt2;
                    }
                  }
                  break;
                }
              }
              else
              {
                localObject1 = paramArrayOfByte;
                paramInt1 = i4;
                i2 = i3;
                i1 = 0;
                i3 = localtlv_t104.get_tlv((byte[])localObject1, paramInt1, this.c - paramInt1 - 1);
                if (i3 >= 0)
                {
                  localasync_context._t104 = localtlv_t104;
                  i3 = localtlv_t126.get_tlv((byte[])localObject1, paramInt1, this.c - paramInt1 - 1);
                  if (i3 >= 0)
                  {
                    localasync_context._t126 = localtlv_t126;
                    i3 = localtlv_t182.get_tlv((byte[])localObject1, paramInt1, this.c - paramInt1 - 1);
                    if (i3 >= 0)
                    {
                      localasync_context._smslogin_msgcnt = localtlv_t182.getMsgCnt();
                      localasync_context._smslogin_timelimit = localtlv_t182.getTimeLimit();
                      paramInt1 = localtlv_t183.get_tlv((byte[])localObject1, paramInt1, this.c - paramInt1 - 1);
                      if (paramInt1 >= 0)
                      {
                        localasync_context._msalt = localtlv_t183.getMsalt();
                        paramInt1 = i1;
                        i1 = paramInt2;
                        break label6256;
                      }
                      i1 = paramInt2;
                      break label6256;
                    }
                    paramInt1 = i3;
                    i1 = paramInt2;
                    break label6256;
                  }
                  paramInt1 = i3;
                  i1 = paramInt2;
                  break label6256;
                }
                paramInt1 = i3;
                i1 = paramInt2;
                break label6256;
              }
            }
            else
            {
              localObject2 = paramArrayOfByte;
              i5 = paramInt2;
              i7 = i4;
              i6 = i3;
              if (((tlv_t113)localObject1).get_tlv((byte[])localObject2, i7, this.c - i7 - 1) >= 0)
              {
                this.x.f = ((tlv_t113)localObject1).get_uin();
                localObject1 = this.x;
                ((t)localObject1).a(((t)localObject1).g, Long.valueOf(this.x.f));
              }
              i8 = localtlv_t104.get_tlv((byte[])localObject2, i7, this.c - i7 - 1);
              paramInt1 = i8;
              i2 = i6;
              i1 = i5;
              if (i8 < 0) {
                break label6256;
              }
              localasync_context._t104 = localtlv_t104;
              i8 = ((tlv_t402)localObject16).get_tlv((byte[])localObject2, i7, this.c - i7 - 1);
              paramInt1 = i8;
              i2 = i6;
              i1 = i5;
              if (i8 < 0) {
                break label6256;
              }
              localasync_context._t402 = ((tlv_t402)localObject16);
              i7 = ((tlv_t403)localObject13).get_tlv((byte[])localObject2, i7, this.c - i7 - 1);
              paramInt1 = i7;
              i2 = i6;
              i1 = i5;
              if (i7 < 0) {
                break label6256;
              }
              localasync_context._t403 = ((tlv_t403)localObject13);
            }
          }
          else
          {
            i1 = paramInt2;
            paramInt1 = i4;
            i2 = i3;
            i5 = localtlv_t161.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
            paramInt1 = i5;
            if (i5 < 0) {
              break label6256;
            }
            a(localtlv_t161);
          }
        }
        else
        {
          paramInt1 = i4;
          c(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
          localObject1 = this.x;
          ((t)localObject1).a(((t)localObject1).g);
          break label6246;
        }
      }
      else
      {
        localObject2 = paramArrayOfByte;
        i5 = paramInt2;
        i7 = i4;
        i6 = i3;
        if (((tlv_t113)localObject1).get_tlv((byte[])localObject2, i7, this.c - i7 - 1) >= 0)
        {
          this.x.f = ((tlv_t113)localObject1).get_uin();
          localObject1 = this.x;
          ((t)localObject1).a(((t)localObject1).g, Long.valueOf(this.x.f));
        }
        i8 = localtlv_t104.get_tlv((byte[])localObject2, i7, this.c - i7 - 1);
        paramInt1 = i8;
        i2 = i6;
        i1 = i5;
        if (i8 < 0) {
          break label6256;
        }
        localasync_context._t104 = localtlv_t104;
        i8 = localtlv_t174.get_tlv((byte[])localObject2, i7, this.c - i7 - 1);
        paramInt1 = i8;
        i2 = i6;
        i1 = i5;
        if (i8 < 0) {
          break label6256;
        }
        localasync_context._t174 = localtlv_t174;
        if (localtlv_t178.get_tlv((byte[])localObject2, i7, this.c - i7 - 1) >= 0)
        {
          localasync_context._devlock_info.CountryCode = new String(localtlv_t178.get_country_code());
          localasync_context._devlock_info.Mobile = new String(localtlv_t178.get_mobile());
          localasync_context._devlock_info.MbItemSmsCodeStatus = localtlv_t178.get_smscode_status();
          localasync_context._devlock_info.AvailableMsgCount = localtlv_t178.get_available_msg_cnt();
          localasync_context._devlock_info.TimeLimit = localtlv_t178.get_time_limit();
        }
        localObject1 = new tlv_t196();
        if (((tlv_t196)localObject1).get_tlv((byte[])localObject2, i7, this.c - i7 - 1) >= 0)
        {
          localasync_context._devlock_info.BakCountryCode = ((tlv_t196)localObject1).getCountryCode();
          localasync_context._devlock_info.BakMobile = ((tlv_t196)localObject1).getBakMobile();
          localasync_context._devlock_info.BakMobileState = ((tlv_t196)localObject1).getBakMobileState();
        }
        if (((tlv_t179)localObject17).get_tlv((byte[])localObject2, i7, this.c - i7 - 1) >= 0) {
          localasync_context._devlock_info.UnionVerifyUrl = new String(((tlv_t179)localObject17).get_verify_url());
        }
        if (localtlv_t17d.get_tlv((byte[])localObject2, i7, this.c - i7 - 1) >= 0)
        {
          localasync_context._devlock_info.MbGuideType = localtlv_t17d.get_mb_guide_type();
          localasync_context._devlock_info.MbGuideMsg = new String(localtlv_t17d.get_mb_guide_msg());
          localasync_context._devlock_info.MbGuideInfoType = localtlv_t17d.get_mb_guide_info_type();
          localasync_context._devlock_info.MbGuideInfo = new String(localtlv_t17d.get_mb_guide_info());
        }
        if (localtlv_t17e.get_tlv((byte[])localObject2, i7, this.c - i7 - 1) >= 0) {
          localasync_context._devlock_info.VerifyReason = new String(localtlv_t17e.get_data());
        }
        if (((tlv_t402)localObject16).get_tlv((byte[])localObject2, i7, this.c - i7 - 1) >= 0) {
          localasync_context._t402 = ((tlv_t402)localObject16);
        } else {
          localasync_context._t402 = new tlv_t402();
        }
        if (((tlv_t403)localObject13).get_tlv((byte[])localObject2, i7, this.c - i7 - 1) >= 0) {
          localasync_context._t403 = ((tlv_t403)localObject13);
        } else {
          localasync_context._t403 = new tlv_t403();
        }
        c((byte[])localObject2, i7, this.c - i7 - 1);
        break label6246;
      }
    }
    else
    {
      i1 = paramInt2;
      paramInt1 = i4;
      i2 = i3;
      localObject1 = new tlv_t(405);
      i5 = ((tlv_t)localObject1).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
      paramInt1 = i5;
      if (i5 < 0) {
        break label6256;
      }
      WloginSigInfo._LHSig = ((tlv_t)localObject1).get_data();
    }
    paramInt1 = i4;
    c(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
    label6246:
    int i2 = i3;
    paramInt1 = i2;
    int i1 = paramInt2;
    label6256:
    localObject2 = new StringBuilder("type:");
    ((StringBuilder)localObject2).append(i2);
    ((StringBuilder)localObject2).append(" ret:");
    if (paramInt1 > 0)
    {
      localObject1 = new StringBuilder("0x");
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
    ((StringBuilder)localObject2).append(this.x.f);
    util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
    paramInt2 = -1000;
    if (paramInt1 == 0)
    {
      a(null);
    }
    else
    {
      new tlv_t508().get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
      if (tlv_t508.doFetch)
      {
        paramArrayOfByte = new ErrMsg();
        i2 = new i(this.x, this.t, this.u, paramArrayOfByte).b(paramInt1);
        if (i2 != -1000)
        {
          a(paramArrayOfByte);
          paramInt1 = i2;
        }
      }
    }
    if ((paramInt1 != 10) && (paramInt1 != 161) && (paramInt1 != 162) && (paramInt1 != 164) && (paramInt1 != 165) && (paramInt1 != 166) && (paramInt1 != 154) && ((paramInt1 < 128) || (paramInt1 > 143))) {
      break label6542;
    }
    paramInt1 = paramInt2;
    label6542:
    if ((i1 != 2) && (i1 != 6) && (i1 != 7)) {
      a(i1);
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
    //   4: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   7: astore 14
    //   9: aload 14
    //   11: aload_0
    //   12: invokevirtual 650	java/lang/Object:getClass	()Ljava/lang/Class;
    //   15: invokevirtual 655	java/lang/Class:getName	()Ljava/lang/String;
    //   18: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload 14
    //   24: ldc_w 1528
    //   27: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 14
    //   33: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 14
    //   38: new 426	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   45: astore 15
    //   47: aload 15
    //   49: aload_0
    //   50: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   53: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   56: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 14
    //   62: aload 15
    //   64: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: invokevirtual 660	oicq/wlogin_sdk/request/oicq_request:c	()[B
    //   74: astore 21
    //   76: aload_0
    //   77: invokevirtual 1530	oicq/wlogin_sdk/request/oicq_request:d	()Ljava/net/Socket;
    //   80: astore 15
    //   82: ldc 100
    //   84: astore 16
    //   86: iconst_0
    //   87: istore 9
    //   89: iconst_0
    //   90: istore_1
    //   91: iconst_0
    //   92: istore_2
    //   93: iconst_0
    //   94: istore 4
    //   96: iconst_0
    //   97: istore 10
    //   99: iconst_0
    //   100: istore_3
    //   101: ldc 100
    //   103: astore 14
    //   105: lconst_0
    //   106: lstore 12
    //   108: iload_2
    //   109: bipush 6
    //   111: if_icmpge +2865 -> 2976
    //   114: iload_2
    //   115: ifeq +9 -> 124
    //   118: getstatic 375	oicq/wlogin_sdk/request/t:t	Landroid/content/Context;
    //   121: invokestatic 1533	oicq/wlogin_sdk/tools/util:chg_retry_type	(Landroid/content/Context;)V
    //   124: getstatic 375	oicq/wlogin_sdk/request/t:t	Landroid/content/Context;
    //   127: invokestatic 1537	oicq/wlogin_sdk/tools/util:is_wap_retry	(Landroid/content/Context;)Z
    //   130: istore 9
    //   132: aload_0
    //   133: aconst_null
    //   134: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   137: iload_2
    //   138: ifeq +30 -> 168
    //   141: aload_0
    //   142: getfield 146	oicq/wlogin_sdk/request/oicq_request:t	I
    //   145: sipush 2066
    //   148: if_icmpeq +20 -> 168
    //   151: aload_0
    //   152: iload_1
    //   153: lload 12
    //   155: iload 4
    //   157: iload_2
    //   158: iload 9
    //   160: iload 10
    //   162: invokespecial 1539	oicq/wlogin_sdk/request/oicq_request:a	(IJIIZZ)V
    //   165: goto +3 -> 168
    //   168: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   171: lstore 12
    //   173: iload 9
    //   175: ifeq +1365 -> 1540
    //   178: new 426	java/lang/StringBuilder
    //   181: dup
    //   182: ldc_w 1541
    //   185: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: astore 17
    //   190: aload 17
    //   192: iload_2
    //   193: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 17
    //   199: ldc_w 1543
    //   202: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 17
    //   208: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: astore 17
    //   213: new 426	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   220: astore 18
    //   222: aload 18
    //   224: aload_0
    //   225: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   228: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   231: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 17
    //   237: aload 18
    //   239: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_0
    //   246: iload_2
    //   247: iload 9
    //   249: invokevirtual 1545	oicq/wlogin_sdk/request/oicq_request:a	(IZ)Ljava/lang/String;
    //   252: astore 20
    //   254: getstatic 375	oicq/wlogin_sdk/request/t:t	Landroid/content/Context;
    //   257: invokestatic 1548	oicq/wlogin_sdk/tools/util:is_wap_proxy_retry	(Landroid/content/Context;)Z
    //   260: istore 11
    //   262: iload 11
    //   264: ifeq +167 -> 431
    //   267: invokestatic 1551	oicq/wlogin_sdk/tools/util:get_proxy_ip	()Ljava/lang/String;
    //   270: astore 19
    //   272: invokestatic 1554	oicq/wlogin_sdk/tools/util:get_proxy_port	()I
    //   275: istore 6
    //   277: aload 19
    //   279: ifnull +31 -> 310
    //   282: aload 19
    //   284: invokevirtual 373	java/lang/String:length	()I
    //   287: istore 5
    //   289: iload 5
    //   291: ifle +19 -> 310
    //   294: iload 6
    //   296: iconst_m1
    //   297: if_icmpne +6 -> 303
    //   300: goto +10 -> 310
    //   303: iload 11
    //   305: istore 10
    //   307: goto +134 -> 441
    //   310: new 426	java/lang/StringBuilder
    //   313: dup
    //   314: ldc_w 1556
    //   317: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   320: astore 17
    //   322: aload 17
    //   324: aload 19
    //   326: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 17
    //   332: ldc_w 1558
    //   335: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 17
    //   341: iload 6
    //   343: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 17
    //   349: ldc_w 1560
    //   352: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 17
    //   358: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: astore 17
    //   363: new 426	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   370: astore 18
    //   372: aload_0
    //   373: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   376: astore 22
    //   378: aload 18
    //   380: aload 22
    //   382: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   385: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 17
    //   391: aload 18
    //   393: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: iconst_0
    //   400: istore 10
    //   402: goto +39 -> 441
    //   405: iconst_0
    //   406: istore 10
    //   408: goto +1100 -> 1508
    //   411: iconst_0
    //   412: istore 10
    //   414: goto +1115 -> 1529
    //   417: iload 11
    //   419: istore 10
    //   421: goto +1087 -> 1508
    //   424: iload 11
    //   426: istore 10
    //   428: goto +1101 -> 1529
    //   431: aconst_null
    //   432: astore 19
    //   434: iconst_m1
    //   435: istore 6
    //   437: iload 11
    //   439: istore 10
    //   441: iload_2
    //   442: istore 5
    //   444: iload 10
    //   446: ifeq +114 -> 560
    //   449: aload 14
    //   451: astore 17
    //   453: aload 14
    //   455: astore 18
    //   457: new 426	java/lang/StringBuilder
    //   460: dup
    //   461: ldc_w 1562
    //   464: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   467: astore 22
    //   469: aload 14
    //   471: astore 17
    //   473: aload 14
    //   475: astore 18
    //   477: aload 22
    //   479: aload 19
    //   481: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload 14
    //   487: astore 17
    //   489: aload 14
    //   491: astore 18
    //   493: aload 22
    //   495: ldc_w 1564
    //   498: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload 14
    //   504: astore 17
    //   506: aload 14
    //   508: astore 18
    //   510: aload 22
    //   512: iload 6
    //   514: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 14
    //   520: astore 17
    //   522: aload 14
    //   524: astore 18
    //   526: aload 22
    //   528: ldc_w 1566
    //   531: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload 14
    //   537: astore 17
    //   539: aload 14
    //   541: astore 18
    //   543: new 1568	java/net/URL
    //   546: dup
    //   547: aload 22
    //   549: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokespecial 1569	java/net/URL:<init>	(Ljava/lang/String;)V
    //   555: astore 19
    //   557: goto +214 -> 771
    //   560: aload 14
    //   562: astore 17
    //   564: aload 14
    //   566: astore 18
    //   568: aload_0
    //   569: aload 20
    //   571: iconst_0
    //   572: aload_0
    //   573: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   576: getfield 658	oicq/wlogin_sdk/request/t:l	I
    //   579: i2l
    //   580: invokestatic 1574	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   583: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   586: aload 14
    //   588: astore 17
    //   590: aload 14
    //   592: astore 18
    //   594: aload_0
    //   595: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   598: ifnull +2834 -> 3432
    //   601: aload 14
    //   603: astore 17
    //   605: aload 14
    //   607: astore 18
    //   609: aload_0
    //   610: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   613: invokevirtual 224	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   616: invokevirtual 230	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   619: astore 19
    //   621: aload 14
    //   623: astore 17
    //   625: aload 14
    //   627: astore 18
    //   629: aload 14
    //   631: aload 19
    //   633: invokevirtual 1578	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   636: istore 11
    //   638: iload 11
    //   640: ifne +29 -> 669
    //   643: aload_0
    //   644: aconst_null
    //   645: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   648: aload 19
    //   650: astore 14
    //   652: goto +44 -> 696
    //   655: aload 19
    //   657: astore 14
    //   659: goto +849 -> 1508
    //   662: aload 19
    //   664: astore 14
    //   666: goto +863 -> 1529
    //   669: aload 14
    //   671: astore 17
    //   673: aload 14
    //   675: astore 18
    //   677: new 503	java/lang/Exception
    //   680: dup
    //   681: ldc_w 1580
    //   684: aload 14
    //   686: invokestatic 471	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   689: invokevirtual 475	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   692: invokespecial 1581	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   695: athrow
    //   696: aload 14
    //   698: astore 17
    //   700: aload 14
    //   702: astore 18
    //   704: new 426	java/lang/StringBuilder
    //   707: dup
    //   708: ldc_w 1562
    //   711: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   714: astore 22
    //   716: aload 14
    //   718: astore 17
    //   720: aload 14
    //   722: astore 18
    //   724: aload 22
    //   726: aload 19
    //   728: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: aload 14
    //   734: astore 17
    //   736: aload 14
    //   738: astore 18
    //   740: aload 22
    //   742: ldc_w 1566
    //   745: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 14
    //   751: astore 17
    //   753: aload 14
    //   755: astore 18
    //   757: new 1568	java/net/URL
    //   760: dup
    //   761: aload 22
    //   763: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokespecial 1569	java/net/URL:<init>	(Ljava/lang/String;)V
    //   769: astore 19
    //   771: aload 14
    //   773: astore 17
    //   775: aload 14
    //   777: astore 18
    //   779: new 426	java/lang/StringBuilder
    //   782: dup
    //   783: ldc_w 1583
    //   786: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   789: astore 22
    //   791: aload 14
    //   793: astore 17
    //   795: aload 14
    //   797: astore 18
    //   799: aload 22
    //   801: iload 10
    //   803: invokevirtual 671	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload 14
    //   809: astore 17
    //   811: aload 14
    //   813: astore 18
    //   815: aload 22
    //   817: ldc_w 1585
    //   820: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload 14
    //   826: astore 17
    //   828: aload 14
    //   830: astore 18
    //   832: aload 22
    //   834: aload 19
    //   836: invokevirtual 602	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   839: pop
    //   840: aload 14
    //   842: astore 17
    //   844: aload 14
    //   846: astore 18
    //   848: aload 22
    //   850: ldc_w 1587
    //   853: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload 14
    //   859: astore 17
    //   861: aload 14
    //   863: astore 18
    //   865: aload 22
    //   867: aload 20
    //   869: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: pop
    //   873: aload 14
    //   875: astore 17
    //   877: aload 14
    //   879: astore 18
    //   881: aload 22
    //   883: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   886: astore 22
    //   888: aload 14
    //   890: astore 17
    //   892: aload 14
    //   894: astore 18
    //   896: new 426	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   903: astore 23
    //   905: aload 14
    //   907: astore 17
    //   909: aload 14
    //   911: astore 18
    //   913: aload 23
    //   915: aload_0
    //   916: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   919: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   922: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   925: pop
    //   926: aload 14
    //   928: astore 17
    //   930: aload 14
    //   932: astore 18
    //   934: aload 22
    //   936: aload 23
    //   938: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   944: aload 14
    //   946: astore 17
    //   948: aload 14
    //   950: astore 18
    //   952: aload 19
    //   954: invokevirtual 1591	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   957: checkcast 1593	java/net/HttpURLConnection
    //   960: astore 19
    //   962: aload 14
    //   964: astore 17
    //   966: aload 14
    //   968: astore 18
    //   970: aload 19
    //   972: ldc_w 1595
    //   975: invokevirtual 1598	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   978: iload 10
    //   980: ifeq +21 -> 1001
    //   983: aload 14
    //   985: astore 17
    //   987: aload 14
    //   989: astore 18
    //   991: aload 19
    //   993: ldc_w 1600
    //   996: aload 20
    //   998: invokevirtual 1603	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1001: aload 14
    //   1003: astore 17
    //   1005: aload 14
    //   1007: astore 18
    //   1009: aload 19
    //   1011: ldc_w 1605
    //   1014: ldc_w 1607
    //   1017: invokevirtual 1603	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1020: aload 14
    //   1022: astore 17
    //   1024: aload 14
    //   1026: astore 18
    //   1028: aload 19
    //   1030: ldc_w 1609
    //   1033: ldc_w 1611
    //   1036: invokevirtual 1603	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1039: aload 14
    //   1041: astore 17
    //   1043: aload 14
    //   1045: astore 18
    //   1047: aload 19
    //   1049: ldc_w 1613
    //   1052: aload 21
    //   1054: arraylength
    //   1055: invokestatic 629	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1058: invokevirtual 1603	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1061: aload 14
    //   1063: astore 17
    //   1065: aload 14
    //   1067: astore 18
    //   1069: aload 19
    //   1071: aload_0
    //   1072: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1075: getfield 658	oicq/wlogin_sdk/request/t:l	I
    //   1078: invokevirtual 1616	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1081: aload 14
    //   1083: astore 17
    //   1085: aload 14
    //   1087: astore 18
    //   1089: aload 19
    //   1091: aload_0
    //   1092: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1095: getfield 658	oicq/wlogin_sdk/request/t:l	I
    //   1098: invokevirtual 1619	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1101: aload 14
    //   1103: astore 17
    //   1105: aload 14
    //   1107: astore 18
    //   1109: aload 19
    //   1111: iconst_1
    //   1112: invokevirtual 1623	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1115: aload 14
    //   1117: astore 17
    //   1119: aload 14
    //   1121: astore 18
    //   1123: aload 19
    //   1125: iconst_1
    //   1126: invokevirtual 1626	java/net/HttpURLConnection:setDoInput	(Z)V
    //   1129: aload 14
    //   1131: astore 17
    //   1133: aload 14
    //   1135: astore 18
    //   1137: new 426	java/lang/StringBuilder
    //   1140: dup
    //   1141: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   1144: astore 20
    //   1146: aload 14
    //   1148: astore 17
    //   1150: aload 14
    //   1152: astore 18
    //   1154: aload 20
    //   1156: aload_0
    //   1157: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1160: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   1163: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1166: pop
    //   1167: aload 14
    //   1169: astore 17
    //   1171: aload 14
    //   1173: astore 18
    //   1175: ldc_w 1628
    //   1178: aload 20
    //   1180: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1183: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1186: aload 14
    //   1188: astore 17
    //   1190: aload 14
    //   1192: astore 18
    //   1194: aload 19
    //   1196: aload_0
    //   1197: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1200: getfield 658	oicq/wlogin_sdk/request/t:l	I
    //   1203: i2l
    //   1204: invokestatic 1633	oicq/wlogin_sdk/request/j:a	(Ljava/net/HttpURLConnection;J)Z
    //   1207: ifne +74 -> 1281
    //   1210: aload 14
    //   1212: astore 17
    //   1214: aload 14
    //   1216: astore 18
    //   1218: new 426	java/lang/StringBuilder
    //   1221: dup
    //   1222: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   1225: astore 19
    //   1227: aload 14
    //   1229: astore 17
    //   1231: aload 14
    //   1233: astore 18
    //   1235: aload 19
    //   1237: aload_0
    //   1238: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1241: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   1244: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1247: pop
    //   1248: aload 14
    //   1250: astore 17
    //   1252: aload 14
    //   1254: astore 18
    //   1256: ldc_w 1635
    //   1259: aload 19
    //   1261: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1264: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1267: sipush -1026
    //   1270: iload_1
    //   1271: if_icmpeq +2168 -> 3439
    //   1274: sipush -1000
    //   1277: istore_1
    //   1278: goto +2161 -> 3439
    //   1281: aload 14
    //   1283: astore 17
    //   1285: aload 14
    //   1287: astore 18
    //   1289: new 426	java/lang/StringBuilder
    //   1292: dup
    //   1293: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   1296: astore 20
    //   1298: aload 14
    //   1300: astore 17
    //   1302: aload 14
    //   1304: astore 18
    //   1306: aload 20
    //   1308: aload_0
    //   1309: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1312: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   1315: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1318: pop
    //   1319: aload 14
    //   1321: astore 17
    //   1323: aload 14
    //   1325: astore 18
    //   1327: ldc_w 1637
    //   1330: aload 20
    //   1332: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1335: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1338: aload 14
    //   1340: astore 17
    //   1342: aload 14
    //   1344: astore 18
    //   1346: aload 19
    //   1348: invokevirtual 1641	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1351: astore 20
    //   1353: aload 14
    //   1355: astore 17
    //   1357: aload 14
    //   1359: astore 18
    //   1361: aload 20
    //   1363: aload 21
    //   1365: iconst_0
    //   1366: aload 21
    //   1368: arraylength
    //   1369: invokevirtual 1646	java/io/OutputStream:write	([BII)V
    //   1372: aload 14
    //   1374: astore 17
    //   1376: aload 14
    //   1378: astore 18
    //   1380: aload 20
    //   1382: invokevirtual 1649	java/io/OutputStream:flush	()V
    //   1385: aload 14
    //   1387: astore 17
    //   1389: aload 14
    //   1391: astore 18
    //   1393: aload 19
    //   1395: invokevirtual 1652	java/net/HttpURLConnection:getResponseCode	()I
    //   1398: istore 6
    //   1400: aload 14
    //   1402: astore 17
    //   1404: ldc_w 1654
    //   1407: iload 6
    //   1409: invokestatic 629	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1412: invokevirtual 475	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1415: astore 18
    //   1417: aload 14
    //   1419: astore 17
    //   1421: new 426	java/lang/StringBuilder
    //   1424: dup
    //   1425: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   1428: astore 20
    //   1430: aload 14
    //   1432: astore 17
    //   1434: aload 20
    //   1436: aload_0
    //   1437: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1440: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   1443: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1446: pop
    //   1447: aload 14
    //   1449: astore 17
    //   1451: aload 18
    //   1453: aload 20
    //   1455: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1458: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1461: sipush 200
    //   1464: iload 6
    //   1466: if_icmpeq +15 -> 1481
    //   1469: iload 5
    //   1471: iconst_1
    //   1472: iadd
    //   1473: istore_2
    //   1474: sipush -1000
    //   1477: istore_1
    //   1478: goto -1370 -> 108
    //   1481: aload 14
    //   1483: astore 17
    //   1485: aload 19
    //   1487: invokevirtual 1658	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1490: astore 18
    //   1492: iload 5
    //   1494: istore_2
    //   1495: aload 18
    //   1497: astore 17
    //   1499: goto +887 -> 2386
    //   1502: iload 6
    //   1504: istore_1
    //   1505: goto -1084 -> 421
    //   1508: sipush -1026
    //   1511: iload_1
    //   1512: if_icmpeq +10 -> 1522
    //   1515: sipush -1000
    //   1518: istore_1
    //   1519: goto +3 -> 1522
    //   1522: iload_2
    //   1523: iconst_1
    //   1524: iadd
    //   1525: istore_2
    //   1526: goto -1418 -> 108
    //   1529: iload_2
    //   1530: iconst_1
    //   1531: iadd
    //   1532: istore_2
    //   1533: sipush -1026
    //   1536: istore_1
    //   1537: goto -1429 -> 108
    //   1540: new 426	java/lang/StringBuilder
    //   1543: dup
    //   1544: ldc_w 1660
    //   1547: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1550: astore 17
    //   1552: aload 17
    //   1554: iload_2
    //   1555: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1558: pop
    //   1559: aload 17
    //   1561: ldc_w 1543
    //   1564: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: pop
    //   1568: aload 17
    //   1570: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1573: astore 17
    //   1575: new 426	java/lang/StringBuilder
    //   1578: dup
    //   1579: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   1582: astore 18
    //   1584: aload 18
    //   1586: aload_0
    //   1587: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1590: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   1593: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1596: pop
    //   1597: aload 17
    //   1599: aload 18
    //   1601: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1604: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1607: aload 15
    //   1609: ifnonnull +513 -> 2122
    //   1612: ldc 100
    //   1614: astore 17
    //   1616: aload_0
    //   1617: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1620: ifnonnull +111 -> 1731
    //   1623: aload_0
    //   1624: iload_2
    //   1625: iload 9
    //   1627: invokevirtual 1545	oicq/wlogin_sdk/request/oicq_request:a	(IZ)Ljava/lang/String;
    //   1630: astore 17
    //   1632: new 426	java/lang/StringBuilder
    //   1635: dup
    //   1636: ldc_w 1662
    //   1639: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1642: astore 18
    //   1644: aload 18
    //   1646: aload 17
    //   1648: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: pop
    //   1652: aload 18
    //   1654: ldc_w 1664
    //   1657: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1660: pop
    //   1661: aload 18
    //   1663: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1666: astore 18
    //   1668: new 426	java/lang/StringBuilder
    //   1671: dup
    //   1672: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   1675: astore 19
    //   1677: aload 19
    //   1679: aload_0
    //   1680: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1683: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   1686: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1689: pop
    //   1690: aload 18
    //   1692: aload 19
    //   1694: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1697: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1700: aload_0
    //   1701: aload_0
    //   1702: iload 9
    //   1704: invokevirtual 233	oicq/wlogin_sdk/request/oicq_request:c	(Z)I
    //   1707: putfield 142	oicq/wlogin_sdk/request/oicq_request:r	I
    //   1710: aload_0
    //   1711: aload 17
    //   1713: aload_0
    //   1714: getfield 142	oicq/wlogin_sdk/request/oicq_request:r	I
    //   1717: aload_0
    //   1718: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1721: getfield 658	oicq/wlogin_sdk/request/t:l	I
    //   1724: i2l
    //   1725: invokestatic 1574	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   1728: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1731: aload_0
    //   1732: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1735: astore 18
    //   1737: aload 18
    //   1739: ifnull +81 -> 1820
    //   1742: aload 18
    //   1744: invokevirtual 224	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1747: ifnonnull +73 -> 1820
    //   1750: aload_0
    //   1751: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1754: invokevirtual 224	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1757: ifnonnull +36 -> 1793
    //   1760: new 426	java/lang/StringBuilder
    //   1763: dup
    //   1764: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   1767: astore 15
    //   1769: aload 15
    //   1771: aload_0
    //   1772: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1775: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   1778: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1781: pop
    //   1782: ldc_w 1666
    //   1785: aload 15
    //   1787: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1790: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1793: iload_2
    //   1794: iconst_1
    //   1795: iadd
    //   1796: istore_2
    //   1797: aload_0
    //   1798: aconst_null
    //   1799: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1802: aload_0
    //   1803: aconst_null
    //   1804: invokevirtual 1668	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   1807: aconst_null
    //   1808: astore 15
    //   1810: sipush -1007
    //   1813: istore_1
    //   1814: iconst_1
    //   1815: istore 4
    //   1817: goto -1709 -> 108
    //   1820: aload_0
    //   1821: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1824: astore 18
    //   1826: aload 18
    //   1828: ifnull +130 -> 1958
    //   1831: aload 16
    //   1833: aload 18
    //   1835: invokevirtual 224	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1838: invokevirtual 230	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1841: invokevirtual 1578	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1844: ifeq +6 -> 1850
    //   1847: goto +111 -> 1958
    //   1850: aload_0
    //   1851: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1854: invokevirtual 224	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1857: invokevirtual 230	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1860: astore 16
    //   1862: new 426	java/lang/StringBuilder
    //   1865: dup
    //   1866: ldc_w 1662
    //   1869: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1872: astore 18
    //   1874: aload 18
    //   1876: aload 17
    //   1878: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1881: pop
    //   1882: aload 18
    //   1884: ldc_w 1670
    //   1887: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1890: pop
    //   1891: aload 18
    //   1893: aload_0
    //   1894: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1897: invokevirtual 1671	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   1900: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: pop
    //   1904: aload 18
    //   1906: ldc_w 1673
    //   1909: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1912: pop
    //   1913: aload 18
    //   1915: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1918: astore 17
    //   1920: new 426	java/lang/StringBuilder
    //   1923: dup
    //   1924: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   1927: astore 18
    //   1929: aload 18
    //   1931: aload_0
    //   1932: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1935: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   1938: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1941: pop
    //   1942: aload 17
    //   1944: aload 18
    //   1946: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1949: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1952: iconst_1
    //   1953: istore 4
    //   1955: goto +167 -> 2122
    //   1958: aload_0
    //   1959: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1962: ifnonnull +78 -> 2040
    //   1965: new 426	java/lang/StringBuilder
    //   1968: dup
    //   1969: ldc_w 1662
    //   1972: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1975: astore 15
    //   1977: aload 15
    //   1979: aload 17
    //   1981: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1984: pop
    //   1985: aload 15
    //   1987: ldc_w 1675
    //   1990: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1993: pop
    //   1994: aload 15
    //   1996: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1999: astore 15
    //   2001: new 426	java/lang/StringBuilder
    //   2004: dup
    //   2005: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   2008: astore 17
    //   2010: aload 17
    //   2012: aload_0
    //   2013: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2016: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   2019: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2022: pop
    //   2023: aload 15
    //   2025: aload 17
    //   2027: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2030: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2033: sipush -1007
    //   2036: istore_1
    //   2037: goto +62 -> 2099
    //   2040: ldc_w 1677
    //   2043: aload 16
    //   2045: invokestatic 471	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2048: invokevirtual 475	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2051: astore 15
    //   2053: new 426	java/lang/StringBuilder
    //   2056: dup
    //   2057: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   2060: astore 17
    //   2062: aload 17
    //   2064: aload_0
    //   2065: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2068: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   2071: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2074: pop
    //   2075: aload 15
    //   2077: aload 17
    //   2079: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2082: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2085: sipush -1026
    //   2088: iload_1
    //   2089: if_icmpeq +10 -> 2099
    //   2092: sipush -1000
    //   2095: istore_1
    //   2096: goto +3 -> 2099
    //   2099: iload_2
    //   2100: iconst_1
    //   2101: iadd
    //   2102: istore_2
    //   2103: aload_0
    //   2104: aconst_null
    //   2105: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2108: aload_0
    //   2109: aconst_null
    //   2110: invokevirtual 1668	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2113: aconst_null
    //   2114: astore 15
    //   2116: iconst_1
    //   2117: istore 4
    //   2119: goto -2011 -> 108
    //   2122: aload 15
    //   2124: ifnonnull +1323 -> 3447
    //   2127: new 426	java/lang/StringBuilder
    //   2130: dup
    //   2131: ldc_w 1679
    //   2134: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2137: astore 15
    //   2139: aload 15
    //   2141: aload_0
    //   2142: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2145: invokevirtual 602	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2148: pop
    //   2149: aload 15
    //   2151: ldc_w 1664
    //   2154: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2157: pop
    //   2158: aload 15
    //   2160: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2163: astore 15
    //   2165: new 426	java/lang/StringBuilder
    //   2168: dup
    //   2169: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   2172: astore 17
    //   2174: aload 17
    //   2176: aload_0
    //   2177: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2180: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   2183: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2186: pop
    //   2187: aload 15
    //   2189: aload 17
    //   2191: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2194: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2197: new 1681	java/net/Socket
    //   2200: dup
    //   2201: invokespecial 1682	java/net/Socket:<init>	()V
    //   2204: astore 15
    //   2206: aload_0
    //   2207: aload 15
    //   2209: invokevirtual 1668	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2212: aload 15
    //   2214: aload_0
    //   2215: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2218: aload_0
    //   2219: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2222: getfield 658	oicq/wlogin_sdk/request/t:l	I
    //   2225: invokevirtual 1686	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   2228: aload 15
    //   2230: aload_0
    //   2231: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2234: getfield 658	oicq/wlogin_sdk/request/t:l	I
    //   2237: invokevirtual 1689	java/net/Socket:setSoTimeout	(I)V
    //   2240: aload 15
    //   2242: aload_0
    //   2243: getfield 144	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2246: arraylength
    //   2247: invokevirtual 1692	java/net/Socket:setReceiveBufferSize	(I)V
    //   2250: new 426	java/lang/StringBuilder
    //   2253: dup
    //   2254: ldc_w 1679
    //   2257: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2260: astore 17
    //   2262: aload 17
    //   2264: aload_0
    //   2265: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2268: invokevirtual 602	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2271: pop
    //   2272: aload 17
    //   2274: ldc_w 1694
    //   2277: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2280: pop
    //   2281: aload 17
    //   2283: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2286: astore 17
    //   2288: new 426	java/lang/StringBuilder
    //   2291: dup
    //   2292: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   2295: astore 18
    //   2297: aload 18
    //   2299: aload_0
    //   2300: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2303: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   2306: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2309: pop
    //   2310: aload 17
    //   2312: aload 18
    //   2314: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2317: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2320: goto +3 -> 2323
    //   2323: new 426	java/lang/StringBuilder
    //   2326: dup
    //   2327: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   2330: astore 17
    //   2332: aload 17
    //   2334: aload_0
    //   2335: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2338: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   2341: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2344: pop
    //   2345: ldc_w 1696
    //   2348: aload 17
    //   2350: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2353: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2356: aload 15
    //   2358: invokevirtual 1697	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   2361: astore 17
    //   2363: aload 17
    //   2365: aload 21
    //   2367: iconst_0
    //   2368: aload 21
    //   2370: arraylength
    //   2371: invokevirtual 1646	java/io/OutputStream:write	([BII)V
    //   2374: aload 17
    //   2376: invokevirtual 1649	java/io/OutputStream:flush	()V
    //   2379: aload 15
    //   2381: invokevirtual 1698	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   2384: astore 17
    //   2386: iload_2
    //   2387: istore 6
    //   2389: new 426	java/lang/StringBuilder
    //   2392: dup
    //   2393: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   2396: astore 18
    //   2398: iload_2
    //   2399: istore 6
    //   2401: aload 18
    //   2403: aload_0
    //   2404: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2407: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   2410: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2413: pop
    //   2414: iload_2
    //   2415: istore 6
    //   2417: ldc_w 1700
    //   2420: aload 18
    //   2422: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2425: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2428: iconst_0
    //   2429: istore_1
    //   2430: iconst_0
    //   2431: istore 5
    //   2433: iload_2
    //   2434: istore 6
    //   2436: iload_1
    //   2437: aload_0
    //   2438: getfield 118	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2441: iconst_1
    //   2442: iadd
    //   2443: if_icmpge +47 -> 2490
    //   2446: iload_2
    //   2447: istore 6
    //   2449: aload 17
    //   2451: aload_0
    //   2452: getfield 144	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2455: iload_1
    //   2456: aload_0
    //   2457: getfield 118	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2460: iconst_1
    //   2461: iadd
    //   2462: iload_1
    //   2463: isub
    //   2464: invokevirtual 1705	java/io/InputStream:read	([BII)I
    //   2467: istore 7
    //   2469: iload 7
    //   2471: istore 5
    //   2473: iload 7
    //   2475: iflt +15 -> 2490
    //   2478: iload_1
    //   2479: iload 7
    //   2481: iadd
    //   2482: istore_1
    //   2483: iload 7
    //   2485: istore 5
    //   2487: goto -54 -> 2433
    //   2490: iload 5
    //   2492: ifge +60 -> 2552
    //   2495: iload_2
    //   2496: iconst_1
    //   2497: iadd
    //   2498: istore_2
    //   2499: aload 15
    //   2501: astore 17
    //   2503: iload 9
    //   2505: ifne +36 -> 2541
    //   2508: iload_2
    //   2509: istore 6
    //   2511: aload 15
    //   2513: invokevirtual 1708	java/net/Socket:close	()V
    //   2516: iload_2
    //   2517: istore 6
    //   2519: aload_0
    //   2520: aconst_null
    //   2521: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2524: aload_0
    //   2525: aconst_null
    //   2526: invokevirtual 1668	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2529: aconst_null
    //   2530: astore 17
    //   2532: goto +9 -> 2541
    //   2535: aconst_null
    //   2536: astore 17
    //   2538: goto +334 -> 2872
    //   2541: sipush -1000
    //   2544: istore_1
    //   2545: aload 17
    //   2547: astore 15
    //   2549: goto -2441 -> 108
    //   2552: iload_2
    //   2553: istore 6
    //   2555: aload_0
    //   2556: aload_0
    //   2557: getfield 144	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2560: invokevirtual 1710	oicq/wlogin_sdk/request/oicq_request:b	([B)I
    //   2563: istore_1
    //   2564: iload_2
    //   2565: istore_3
    //   2566: iload_1
    //   2567: aload_0
    //   2568: getfield 118	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2571: iconst_1
    //   2572: iadd
    //   2573: if_icmpgt +68 -> 2641
    //   2576: iload_2
    //   2577: iconst_1
    //   2578: iadd
    //   2579: istore 5
    //   2581: aload 15
    //   2583: astore 17
    //   2585: iload 9
    //   2587: ifne +38 -> 2625
    //   2590: iload 5
    //   2592: istore_3
    //   2593: aload 15
    //   2595: invokevirtual 1708	java/net/Socket:close	()V
    //   2598: iload 5
    //   2600: istore_3
    //   2601: aload_0
    //   2602: aconst_null
    //   2603: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2606: iload 5
    //   2608: istore_2
    //   2609: aload_0
    //   2610: aconst_null
    //   2611: invokevirtual 1668	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2614: aconst_null
    //   2615: astore 17
    //   2617: goto +8 -> 2625
    //   2620: iload_1
    //   2621: istore_3
    //   2622: goto -87 -> 2535
    //   2625: iload_1
    //   2626: istore_3
    //   2627: sipush -1000
    //   2630: istore_1
    //   2631: iload 5
    //   2633: istore_2
    //   2634: aload 17
    //   2636: astore 15
    //   2638: goto -2530 -> 108
    //   2641: iload_2
    //   2642: istore_3
    //   2643: iload_1
    //   2644: aload_0
    //   2645: getfield 144	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2648: arraylength
    //   2649: if_icmplt +60 -> 2709
    //   2652: iload_2
    //   2653: iconst_1
    //   2654: iadd
    //   2655: istore 5
    //   2657: aload 15
    //   2659: astore 17
    //   2661: iload 9
    //   2663: ifne +30 -> 2693
    //   2666: iload 5
    //   2668: istore_3
    //   2669: aload 15
    //   2671: invokevirtual 1708	java/net/Socket:close	()V
    //   2674: iload 5
    //   2676: istore_3
    //   2677: aload_0
    //   2678: aconst_null
    //   2679: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2682: iload 5
    //   2684: istore_2
    //   2685: aload_0
    //   2686: aconst_null
    //   2687: invokevirtual 1668	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2690: aconst_null
    //   2691: astore 17
    //   2693: iload_1
    //   2694: istore_3
    //   2695: sipush -1000
    //   2698: istore_1
    //   2699: iload 5
    //   2701: istore_2
    //   2702: aload 17
    //   2704: astore 15
    //   2706: goto -2598 -> 108
    //   2709: iload_2
    //   2710: istore_3
    //   2711: aload_0
    //   2712: getfield 118	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2715: iconst_1
    //   2716: iadd
    //   2717: istore 7
    //   2719: iload_1
    //   2720: iload 7
    //   2722: isub
    //   2723: istore 6
    //   2725: iload 6
    //   2727: ifle +723 -> 3450
    //   2730: iload_2
    //   2731: istore_3
    //   2732: aload 17
    //   2734: aload_0
    //   2735: getfield 144	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2738: iload 7
    //   2740: iload 6
    //   2742: invokevirtual 1705	java/io/InputStream:read	([BII)I
    //   2745: istore 8
    //   2747: iload 8
    //   2749: istore 5
    //   2751: iload 8
    //   2753: iconst_m1
    //   2754: if_icmpeq +24 -> 2778
    //   2757: iload 7
    //   2759: iload 8
    //   2761: iadd
    //   2762: istore 7
    //   2764: iload 6
    //   2766: iload 8
    //   2768: isub
    //   2769: istore 6
    //   2771: iload 8
    //   2773: istore 5
    //   2775: goto -50 -> 2725
    //   2778: iload 5
    //   2780: iconst_m1
    //   2781: if_icmpne +60 -> 2841
    //   2784: iload_2
    //   2785: iconst_1
    //   2786: iadd
    //   2787: istore 5
    //   2789: aload 15
    //   2791: astore 17
    //   2793: iload 9
    //   2795: ifne +30 -> 2825
    //   2798: iload 5
    //   2800: istore_3
    //   2801: aload 15
    //   2803: invokevirtual 1708	java/net/Socket:close	()V
    //   2806: iload 5
    //   2808: istore_3
    //   2809: aload_0
    //   2810: aconst_null
    //   2811: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2814: iload 5
    //   2816: istore_2
    //   2817: aload_0
    //   2818: aconst_null
    //   2819: invokevirtual 1668	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2822: aconst_null
    //   2823: astore 17
    //   2825: iload_1
    //   2826: istore_3
    //   2827: sipush -1000
    //   2830: istore_1
    //   2831: iload 5
    //   2833: istore_2
    //   2834: aload 17
    //   2836: astore 15
    //   2838: goto -2730 -> 108
    //   2841: iload 4
    //   2843: istore_3
    //   2844: iload 5
    //   2846: istore 6
    //   2848: iload_1
    //   2849: istore 4
    //   2851: iload_2
    //   2852: istore 5
    //   2854: iload 6
    //   2856: istore_1
    //   2857: goto +132 -> 2989
    //   2860: iload_3
    //   2861: istore 6
    //   2863: iload_1
    //   2864: istore_3
    //   2865: aload 15
    //   2867: astore 17
    //   2869: iload 6
    //   2871: istore_2
    //   2872: iload_2
    //   2873: iconst_1
    //   2874: iadd
    //   2875: istore_2
    //   2876: aload 17
    //   2878: astore 15
    //   2880: iload 9
    //   2882: ifne +29 -> 2911
    //   2885: aload 17
    //   2887: invokevirtual 1713	java/net/Socket:isConnected	()Z
    //   2890: ifeq +8 -> 2898
    //   2893: aload 17
    //   2895: invokevirtual 1708	java/net/Socket:close	()V
    //   2898: aload_0
    //   2899: aconst_null
    //   2900: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2903: aload_0
    //   2904: aconst_null
    //   2905: invokevirtual 1668	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2908: aconst_null
    //   2909: astore 15
    //   2911: sipush -1000
    //   2914: istore_1
    //   2915: goto -2807 -> 108
    //   2918: sipush -1026
    //   2921: iload_1
    //   2922: if_icmpeq +10 -> 2932
    //   2925: sipush -1000
    //   2928: istore_1
    //   2929: goto +3 -> 2932
    //   2932: iload_2
    //   2933: iconst_1
    //   2934: iadd
    //   2935: istore_2
    //   2936: aload_0
    //   2937: aconst_null
    //   2938: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2941: aload_0
    //   2942: aconst_null
    //   2943: invokevirtual 1668	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2946: aconst_null
    //   2947: astore 15
    //   2949: goto -2841 -> 108
    //   2952: iload_2
    //   2953: iconst_1
    //   2954: iadd
    //   2955: istore_2
    //   2956: aload_0
    //   2957: aconst_null
    //   2958: putfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2961: aload_0
    //   2962: aconst_null
    //   2963: invokevirtual 1668	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2966: aconst_null
    //   2967: astore 15
    //   2969: sipush -1026
    //   2972: istore_1
    //   2973: goto -2865 -> 108
    //   2976: iload 4
    //   2978: istore 6
    //   2980: iload_2
    //   2981: istore 5
    //   2983: iload_3
    //   2984: istore 4
    //   2986: iload 6
    //   2988: istore_3
    //   2989: iload 5
    //   2991: bipush 6
    //   2993: if_icmplt +19 -> 3012
    //   2996: iload_1
    //   2997: istore_2
    //   2998: sipush -1026
    //   3001: iload_1
    //   3002: if_icmpeq +12 -> 3014
    //   3005: sipush -1000
    //   3008: istore_2
    //   3009: goto +5 -> 3014
    //   3012: iconst_0
    //   3013: istore_2
    //   3014: iload_2
    //   3015: ifne +13 -> 3028
    //   3018: aload_0
    //   3019: aload_0
    //   3020: getfield 144	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   3023: iload 4
    //   3025: invokevirtual 696	oicq/wlogin_sdk/request/oicq_request:b	([BI)V
    //   3028: iload_2
    //   3029: ifne +209 -> 3238
    //   3032: aload_0
    //   3033: getfield 146	oicq/wlogin_sdk/request/oicq_request:t	I
    //   3036: sipush 2066
    //   3039: if_icmpeq +199 -> 3238
    //   3042: new 190	oicq/wlogin_sdk/report/report_t3
    //   3045: dup
    //   3046: invokespecial 191	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   3049: astore 14
    //   3051: aload 14
    //   3053: aload_0
    //   3054: getfield 146	oicq/wlogin_sdk/request/oicq_request:t	I
    //   3057: putfield 194	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   3060: aload 14
    //   3062: aload_0
    //   3063: getfield 148	oicq/wlogin_sdk/request/oicq_request:u	I
    //   3066: putfield 197	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   3069: aload 14
    //   3071: iload_2
    //   3072: putfield 200	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   3075: aload 14
    //   3077: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   3080: lload 12
    //   3082: lsub
    //   3083: l2i
    //   3084: putfield 209	oicq/wlogin_sdk/report/report_t3:_used	I
    //   3087: aload 14
    //   3089: iload 5
    //   3091: putfield 212	oicq/wlogin_sdk/report/report_t3:_try	I
    //   3094: aload 14
    //   3096: getstatic 104	oicq/wlogin_sdk/request/oicq_request:H	Ljava/lang/String;
    //   3099: putfield 215	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   3102: aload 14
    //   3104: getfield 215	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   3107: ifnonnull +10 -> 3117
    //   3110: aload 14
    //   3112: ldc 100
    //   3114: putfield 215	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   3117: aload_0
    //   3118: getfield 140	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3121: astore 15
    //   3123: aload 15
    //   3125: ifnonnull +13 -> 3138
    //   3128: aload 14
    //   3130: ldc 100
    //   3132: putfield 218	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   3135: goto +16 -> 3151
    //   3138: aload 14
    //   3140: aload 15
    //   3142: invokevirtual 224	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   3145: invokevirtual 230	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   3148: putfield 218	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   3151: aload 14
    //   3153: aload_0
    //   3154: getfield 142	oicq/wlogin_sdk/request/oicq_request:r	I
    //   3157: putfield 236	oicq/wlogin_sdk/report/report_t3:_port	I
    //   3160: aload 14
    //   3162: iload_3
    //   3163: putfield 239	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   3166: aload 14
    //   3168: getstatic 243	oicq/wlogin_sdk/request/t:D	I
    //   3171: putfield 246	oicq/wlogin_sdk/report/report_t3:_net	I
    //   3174: aload 14
    //   3176: ldc 100
    //   3178: putfield 249	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   3181: aload 14
    //   3183: aload 21
    //   3185: arraylength
    //   3186: putfield 252	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   3189: aload 14
    //   3191: iload 4
    //   3193: putfield 255	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   3196: iload 9
    //   3198: ifeq +26 -> 3224
    //   3201: iload 10
    //   3203: ifeq +12 -> 3215
    //   3206: aload 14
    //   3208: iconst_2
    //   3209: putfield 258	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   3212: goto +18 -> 3230
    //   3215: aload 14
    //   3217: iconst_1
    //   3218: putfield 258	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   3221: goto +9 -> 3230
    //   3224: aload 14
    //   3226: iconst_0
    //   3227: putfield 258	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   3230: getstatic 262	oicq/wlogin_sdk/request/t:an	Loicq/wlogin_sdk/report/Reporter;
    //   3233: aload 14
    //   3235: invokevirtual 268	oicq/wlogin_sdk/report/Reporter:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   3238: new 426	java/lang/StringBuilder
    //   3241: dup
    //   3242: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   3245: astore 14
    //   3247: aload 14
    //   3249: aload_0
    //   3250: invokevirtual 650	java/lang/Object:getClass	()Ljava/lang/Class;
    //   3253: invokevirtual 655	java/lang/Class:getName	()Ljava/lang/String;
    //   3256: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3259: pop
    //   3260: aload 14
    //   3262: ldc_w 1715
    //   3265: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3268: pop
    //   3269: aload 14
    //   3271: iload_2
    //   3272: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3275: pop
    //   3276: aload 14
    //   3278: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3281: astore 14
    //   3283: new 426	java/lang/StringBuilder
    //   3286: dup
    //   3287: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   3290: astore 15
    //   3292: aload 15
    //   3294: aload_0
    //   3295: getfield 279	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   3298: getfield 449	oicq/wlogin_sdk/request/t:f	J
    //   3301: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3304: pop
    //   3305: aload 14
    //   3307: aload 15
    //   3309: invokevirtual 446	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3312: invokestatic 351	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3315: iload_2
    //   3316: ireturn
    //   3317: astore 17
    //   3319: goto -1790 -> 1529
    //   3322: astore 17
    //   3324: goto -1816 -> 1508
    //   3327: astore 17
    //   3329: goto -2905 -> 424
    //   3332: astore 17
    //   3334: goto -2917 -> 417
    //   3337: astore 17
    //   3339: goto -2928 -> 411
    //   3342: astore 17
    //   3344: goto -2939 -> 405
    //   3347: astore 17
    //   3349: goto -2938 -> 411
    //   3352: astore 17
    //   3354: goto -2949 -> 405
    //   3357: astore 14
    //   3359: aload 17
    //   3361: astore 14
    //   3363: goto -2935 -> 428
    //   3366: astore 14
    //   3368: aload 18
    //   3370: astore 14
    //   3372: goto -2951 -> 421
    //   3375: astore 14
    //   3377: goto -2715 -> 662
    //   3380: astore 14
    //   3382: goto -2727 -> 655
    //   3385: astore 17
    //   3387: goto -1885 -> 1502
    //   3390: astore 18
    //   3392: goto -1661 -> 1731
    //   3395: astore 15
    //   3397: goto -445 -> 2952
    //   3400: astore 15
    //   3402: goto -484 -> 2918
    //   3405: astore 17
    //   3407: iload_3
    //   3408: istore_1
    //   3409: goto -546 -> 2863
    //   3412: astore 15
    //   3414: goto -879 -> 2535
    //   3417: astore 17
    //   3419: goto -559 -> 2860
    //   3422: astore 15
    //   3424: goto -804 -> 2620
    //   3427: astore 15
    //   3429: goto -531 -> 2898
    //   3432: aload 20
    //   3434: astore 19
    //   3436: goto -2740 -> 696
    //   3439: iload 5
    //   3441: iconst_1
    //   3442: iadd
    //   3443: istore_2
    //   3444: goto -3336 -> 108
    //   3447: goto -1124 -> 2323
    //   3450: goto -672 -> 2778
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3453	0	this	oicq_request
    //   90	3319	1	i1	int
    //   92	3352	2	i2	int
    //   100	3308	3	i3	int
    //   94	3098	4	i4	int
    //   287	3156	5	i5	int
    //   275	2712	6	i6	int
    //   2467	296	7	i7	int
    //   2745	27	8	i8	int
    //   87	3110	9	bool1	boolean
    //   97	3105	10	bool2	boolean
    //   260	379	11	bool3	boolean
    //   106	2975	12	l1	long
    //   7	3299	14	localObject1	Object
    //   3357	1	14	localConnectException1	java.net.ConnectException
    //   3361	1	14	localObject2	Object
    //   3366	1	14	localException1	Exception
    //   3370	1	14	localObject3	Object
    //   3375	1	14	localConnectException2	java.net.ConnectException
    //   3380	1	14	localException2	Exception
    //   45	3263	15	localObject4	Object
    //   3395	1	15	localConnectException3	java.net.ConnectException
    //   3400	1	15	localThrowable1	java.lang.Throwable
    //   3412	1	15	localThrowable2	java.lang.Throwable
    //   3422	1	15	localThrowable3	java.lang.Throwable
    //   3427	1	15	localException3	Exception
    //   84	1960	16	str	String
    //   188	2706	17	localObject5	Object
    //   3317	1	17	localConnectException4	java.net.ConnectException
    //   3322	1	17	localException4	Exception
    //   3327	1	17	localConnectException5	java.net.ConnectException
    //   3332	1	17	localException5	Exception
    //   3337	1	17	localConnectException6	java.net.ConnectException
    //   3342	1	17	localException6	Exception
    //   3347	1	17	localConnectException7	java.net.ConnectException
    //   3352	8	17	localException7	Exception
    //   3385	1	17	localException8	Exception
    //   3405	1	17	localThrowable4	java.lang.Throwable
    //   3417	1	17	localThrowable5	java.lang.Throwable
    //   220	3149	18	localObject6	Object
    //   3390	1	18	localException9	Exception
    //   270	3165	19	localObject7	Object
    //   252	3181	20	localObject8	Object
    //   74	3110	21	arrayOfByte	byte[]
    //   376	559	22	localObject9	Object
    //   903	34	23	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   254	262	3317	java/net/ConnectException
    //   254	262	3322	java/lang/Exception
    //   267	277	3327	java/net/ConnectException
    //   282	289	3327	java/net/ConnectException
    //   267	277	3332	java/lang/Exception
    //   282	289	3332	java/lang/Exception
    //   310	378	3337	java/net/ConnectException
    //   310	378	3342	java/lang/Exception
    //   378	399	3347	java/net/ConnectException
    //   378	399	3352	java/lang/Exception
    //   457	469	3357	java/net/ConnectException
    //   477	485	3357	java/net/ConnectException
    //   493	502	3357	java/net/ConnectException
    //   510	518	3357	java/net/ConnectException
    //   526	535	3357	java/net/ConnectException
    //   543	557	3357	java/net/ConnectException
    //   568	586	3357	java/net/ConnectException
    //   594	601	3357	java/net/ConnectException
    //   609	621	3357	java/net/ConnectException
    //   629	638	3357	java/net/ConnectException
    //   677	696	3357	java/net/ConnectException
    //   704	716	3357	java/net/ConnectException
    //   724	732	3357	java/net/ConnectException
    //   740	749	3357	java/net/ConnectException
    //   757	771	3357	java/net/ConnectException
    //   779	791	3357	java/net/ConnectException
    //   799	807	3357	java/net/ConnectException
    //   815	824	3357	java/net/ConnectException
    //   832	840	3357	java/net/ConnectException
    //   848	857	3357	java/net/ConnectException
    //   865	873	3357	java/net/ConnectException
    //   881	888	3357	java/net/ConnectException
    //   896	905	3357	java/net/ConnectException
    //   913	926	3357	java/net/ConnectException
    //   934	944	3357	java/net/ConnectException
    //   952	962	3357	java/net/ConnectException
    //   970	978	3357	java/net/ConnectException
    //   991	1001	3357	java/net/ConnectException
    //   1009	1020	3357	java/net/ConnectException
    //   1028	1039	3357	java/net/ConnectException
    //   1047	1061	3357	java/net/ConnectException
    //   1069	1081	3357	java/net/ConnectException
    //   1089	1101	3357	java/net/ConnectException
    //   1109	1115	3357	java/net/ConnectException
    //   1123	1129	3357	java/net/ConnectException
    //   1137	1146	3357	java/net/ConnectException
    //   1154	1167	3357	java/net/ConnectException
    //   1175	1186	3357	java/net/ConnectException
    //   1194	1210	3357	java/net/ConnectException
    //   1218	1227	3357	java/net/ConnectException
    //   1235	1248	3357	java/net/ConnectException
    //   1256	1267	3357	java/net/ConnectException
    //   1289	1298	3357	java/net/ConnectException
    //   1306	1319	3357	java/net/ConnectException
    //   1327	1338	3357	java/net/ConnectException
    //   1346	1353	3357	java/net/ConnectException
    //   1361	1372	3357	java/net/ConnectException
    //   1380	1385	3357	java/net/ConnectException
    //   1393	1400	3357	java/net/ConnectException
    //   1404	1417	3357	java/net/ConnectException
    //   1421	1430	3357	java/net/ConnectException
    //   1434	1447	3357	java/net/ConnectException
    //   1451	1461	3357	java/net/ConnectException
    //   1485	1492	3357	java/net/ConnectException
    //   457	469	3366	java/lang/Exception
    //   477	485	3366	java/lang/Exception
    //   493	502	3366	java/lang/Exception
    //   510	518	3366	java/lang/Exception
    //   526	535	3366	java/lang/Exception
    //   543	557	3366	java/lang/Exception
    //   568	586	3366	java/lang/Exception
    //   594	601	3366	java/lang/Exception
    //   609	621	3366	java/lang/Exception
    //   629	638	3366	java/lang/Exception
    //   677	696	3366	java/lang/Exception
    //   704	716	3366	java/lang/Exception
    //   724	732	3366	java/lang/Exception
    //   740	749	3366	java/lang/Exception
    //   757	771	3366	java/lang/Exception
    //   779	791	3366	java/lang/Exception
    //   799	807	3366	java/lang/Exception
    //   815	824	3366	java/lang/Exception
    //   832	840	3366	java/lang/Exception
    //   848	857	3366	java/lang/Exception
    //   865	873	3366	java/lang/Exception
    //   881	888	3366	java/lang/Exception
    //   896	905	3366	java/lang/Exception
    //   913	926	3366	java/lang/Exception
    //   934	944	3366	java/lang/Exception
    //   952	962	3366	java/lang/Exception
    //   970	978	3366	java/lang/Exception
    //   991	1001	3366	java/lang/Exception
    //   1009	1020	3366	java/lang/Exception
    //   1028	1039	3366	java/lang/Exception
    //   1047	1061	3366	java/lang/Exception
    //   1069	1081	3366	java/lang/Exception
    //   1089	1101	3366	java/lang/Exception
    //   1109	1115	3366	java/lang/Exception
    //   1123	1129	3366	java/lang/Exception
    //   1137	1146	3366	java/lang/Exception
    //   1154	1167	3366	java/lang/Exception
    //   1175	1186	3366	java/lang/Exception
    //   1194	1210	3366	java/lang/Exception
    //   1218	1227	3366	java/lang/Exception
    //   1235	1248	3366	java/lang/Exception
    //   1256	1267	3366	java/lang/Exception
    //   1289	1298	3366	java/lang/Exception
    //   1306	1319	3366	java/lang/Exception
    //   1327	1338	3366	java/lang/Exception
    //   1346	1353	3366	java/lang/Exception
    //   1361	1372	3366	java/lang/Exception
    //   1380	1385	3366	java/lang/Exception
    //   1393	1400	3366	java/lang/Exception
    //   643	648	3375	java/net/ConnectException
    //   643	648	3380	java/lang/Exception
    //   1404	1417	3385	java/lang/Exception
    //   1421	1430	3385	java/lang/Exception
    //   1434	1447	3385	java/lang/Exception
    //   1451	1461	3385	java/lang/Exception
    //   1485	1492	3385	java/lang/Exception
    //   1700	1731	3390	java/lang/Exception
    //   2127	2320	3395	java/net/ConnectException
    //   2323	2386	3395	java/net/ConnectException
    //   2127	2320	3400	java/lang/Throwable
    //   2323	2386	3400	java/lang/Throwable
    //   2389	2398	3405	java/lang/Throwable
    //   2401	2414	3405	java/lang/Throwable
    //   2417	2428	3405	java/lang/Throwable
    //   2436	2446	3405	java/lang/Throwable
    //   2449	2469	3405	java/lang/Throwable
    //   2511	2516	3405	java/lang/Throwable
    //   2519	2524	3405	java/lang/Throwable
    //   2555	2564	3405	java/lang/Throwable
    //   2524	2529	3412	java/lang/Throwable
    //   2566	2576	3417	java/lang/Throwable
    //   2593	2598	3417	java/lang/Throwable
    //   2601	2606	3417	java/lang/Throwable
    //   2643	2652	3417	java/lang/Throwable
    //   2669	2674	3417	java/lang/Throwable
    //   2677	2682	3417	java/lang/Throwable
    //   2711	2719	3417	java/lang/Throwable
    //   2732	2747	3417	java/lang/Throwable
    //   2801	2806	3417	java/lang/Throwable
    //   2809	2814	3417	java/lang/Throwable
    //   2609	2614	3422	java/lang/Throwable
    //   2685	2690	3422	java/lang/Throwable
    //   2817	2822	3422	java/lang/Throwable
    //   2885	2898	3427	java/lang/Exception
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