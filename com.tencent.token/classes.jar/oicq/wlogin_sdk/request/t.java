package oicq.wlogin_sdk.request;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.token.xr;
import java.net.Socket;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.report_t;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.util;

public class t
{
  public static byte[] A;
  static byte[] B;
  public static byte[] C;
  public static int D;
  public static byte[] E;
  public static byte[] F;
  public static byte[] G;
  public static byte[] H;
  public static byte[] I;
  public static byte[] J;
  public static byte[] K;
  static byte[] L;
  static byte[] M;
  static byte[] N;
  static byte[] O;
  static byte[] P;
  static byte[] Q;
  static byte[] R;
  static byte[] S;
  static int T;
  static int U;
  static int V;
  static int W;
  static int X;
  public static int Y;
  public static int Z;
  public static SecureRandom a = ;
  static byte[] aa;
  static long ab;
  public static long ac;
  static byte[] ad;
  static int ae;
  static int af;
  public static boolean ag;
  public static int ah;
  public static byte[] ai;
  public static d al;
  protected static String am;
  public static Reporter an;
  public static long ao;
  public static TreeMap<Long, async_context> ap;
  public static boolean ar = false;
  public static boolean as = true;
  public static String at;
  public static int au = 0;
  private static Object av;
  static Boolean e = Boolean.FALSE;
  public static Context t = null;
  public static int u = 2052;
  public static String v = "";
  static int w = 0;
  static int x = 1;
  static int y = 0;
  static int z = 0;
  Socket aj = null;
  Socket ak = null;
  public int aq;
  public byte[] b = null;
  public byte[] c = new byte[16];
  public tlv_t150 d = null;
  public long f = 0L;
  public String g = "";
  public long h = 0L;
  public int i = 0;
  public WFastLoginInfo j;
  public int k = 0;
  public int l = 5000;
  public int m = 0;
  public byte[] n = new byte[16];
  public byte[] o = new byte[16];
  public byte[] p = new byte[16];
  public byte[] q = new byte[0];
  public byte[] r = new byte[0];
  public int s = 0;
  
  static
  {
    A = new byte[0];
    B = new byte[0];
    C = new byte[0];
    D = 0;
    E = new byte[0];
    F = new byte[0];
    G = new byte[0];
    H = new byte[0];
    I = new byte[0];
    J = new byte[0];
    K = "android".getBytes();
    L = new byte[0];
    M = new byte[0];
    N = new byte[0];
    O = new byte[0];
    P = new byte[0];
    Q = new byte[0];
    R = new byte[0];
    S = new byte[0];
    T = 0;
    U = 0;
    V = 0;
    W = 0;
    X = 0;
    Y = 0;
    Z = 0;
    aa = new byte[0];
    ab = 0L;
    ac = 0L;
    ad = new byte[4];
    ae = 0;
    af = 0;
    ag = false;
    ah = 1;
    al = null;
    am = "";
    an = new Reporter();
    ao = 0L;
    ap = new TreeMap();
    av = new Object();
  }
  
  public t(Context paramContext) {}
  
  public static long a()
  {
    try
    {
      if (ao > 200L) {
        ao = 0L;
      }
      long l1 = ao + 1L;
      ao = l1;
      return l1;
    }
    finally {}
  }
  
  public static byte[] a(Context paramContext)
  {
    return null;
  }
  
  public static async_context b(long paramLong)
  {
    synchronized (av)
    {
      async_context localasync_context2 = (async_context)ap.get(Long.valueOf(paramLong));
      async_context localasync_context1 = localasync_context2;
      if (localasync_context2 == null) {
        try
        {
          localasync_context1 = new async_context();
          try
          {
            ap.put(Long.valueOf(paramLong), localasync_context1);
          }
          catch (Exception localException1) {}
          util.printException(localException2, "");
        }
        catch (Exception localException2)
        {
          localasync_context1 = localasync_context2;
        }
      }
      return localasync_context1;
    }
  }
  
  public static void b()
  {
    String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
    if (str.compareTo(v) != 0)
    {
      v = str;
      new h(t).start();
    }
  }
  
  public static void c()
  {
    Object localObject2 = util.get_mac_addr(t);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > 0) {
        localObject1 = MD5.toMD5Byte((byte[])localObject2);
      }
    }
    Object localObject3 = util.get_imei_id(t);
    localObject2 = localObject3;
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (localObject3.length > 0) {
        localObject2 = MD5.toMD5Byte((byte[])localObject3);
      }
    }
    byte[] arrayOfByte1 = util.generateGuid(t);
    localObject3 = arrayOfByte1;
    if (arrayOfByte1 != null)
    {
      localObject3 = arrayOfByte1;
      if (arrayOfByte1.length > 0) {
        localObject3 = MD5.toMD5Byte(arrayOfByte1);
      }
    }
    if (util.get_last_flag(t) != 0)
    {
      arrayOfByte1 = util.get_last_mac(t);
      byte[] arrayOfByte2 = util.get_last_imei(t);
      byte[] arrayOfByte3 = util.get_last_guid(t);
      if (!Arrays.equals((byte[])localObject1, arrayOfByte1)) {
        X |= 0x1;
      }
      if (!Arrays.equals((byte[])localObject2, arrayOfByte2)) {
        X |= 0x2;
      }
      if (!Arrays.equals((byte[])localObject3, arrayOfByte3)) {
        X |= 0x4;
      }
    }
    util.save_cur_flag(t, 1);
    util.save_cur_mac(t, (byte[])localObject1);
    util.save_cur_imei(t, (byte[])localObject2);
    util.save_cur_guid(t, (byte[])localObject3);
  }
  
  public static void c(long paramLong)
  {
    try
    {
      synchronized (av)
      {
        ap.remove(Long.valueOf(paramLong));
      }
    }
    catch (Exception localException)
    {
      util.printException(localException, "");
      return;
    }
  }
  
  public static void d()
  {
    util.LOGI("init start", "");
    int i1 = util.get_saved_network_type(t);
    int i2 = 0;
    Y = 0;
    a(t);
    byte[] arrayOfByte = util.getGuidFromFile(t);
    Object localObject1 = new StringBuilder("get saved guid ");
    ((StringBuilder)localObject1).append(util.buf_to_string(arrayOfByte));
    util.LOGI(((StringBuilder)localObject1).toString(), "");
    localObject1 = util.generateGuid(t);
    Object localObject2 = new StringBuilder("get current guid ");
    ((StringBuilder)localObject2).append(util.buf_to_string((byte[])localObject1));
    util.LOGI(((StringBuilder)localObject2).toString(), "");
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (localObject1.length > 0) {}
      }
      else
      {
        localObject2 = new String("%4;7t>;28<fc.5*6").getBytes();
      }
      if (Arrays.equals((byte[])localObject2, arrayOfByte)) {
        V = 0;
      } else {
        V = 1;
      }
      U = 1;
      T = 0;
      W = 1;
      localObject1 = arrayOfByte;
    }
    else
    {
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        U = 1;
        W = 17;
      }
      else
      {
        localObject1 = new String("%4;7t>;28<fc.5*6").getBytes();
        U = 0;
        W = 20;
      }
      util.saveGuidToFile(t, (byte[])localObject1);
      V = 0;
      T = 1;
    }
    c();
    int i3 = Y | W << 24 & 0xFF000000;
    Y = i3;
    Y = i3 | X << 8 & 0xFF00;
    A = (byte[])((byte[])localObject1).clone();
    B = (byte[])((byte[])localObject1).clone();
    localObject1 = new StringBuilder("guid src ");
    ((StringBuilder)localObject1).append(W);
    util.LOGI(((StringBuilder)localObject1).toString(), "");
    localObject1 = util.get_imei_id(t);
    M = (byte[])localObject1;
    if (localObject1 != null)
    {
      localObject1 = M;
      if (localObject1.length > 0) {
        M = MD5.toMD5Byte((byte[])localObject1);
      }
    }
    ae = Build.VERSION.SDK_INT;
    localObject1 = util.get_mac_addr(t);
    N = (byte[])localObject1;
    if (localObject1 != null)
    {
      localObject1 = N;
      if (localObject1.length > 0) {
        N = MD5.toMD5Byte((byte[])localObject1);
      }
    }
    localObject1 = util.get_bssid_addr(t);
    R = (byte[])localObject1;
    if (localObject1 != null)
    {
      localObject1 = R;
      if (localObject1.length > 0) {
        R = MD5.toMD5Byte((byte[])localObject1);
      }
    }
    S = util.get_ssid_addr(t);
    localObject1 = util.get_android_id(t);
    O = (byte[])localObject1;
    if (localObject1 != null)
    {
      localObject1 = O;
      if (localObject1.length > 0) {
        O = MD5.toMD5Byte((byte[])localObject1);
      }
    }
    localObject1 = util.get_IMSI(t);
    L = (byte[])localObject1;
    if (localObject1 != null)
    {
      localObject1 = L;
      if (localObject1.length > 0) {
        L = MD5.toMD5Byte((byte[])localObject1);
      }
    }
    C = util.get_sim_operator_name(t);
    D = util.get_network_type(t);
    if (i1 != D)
    {
      util.set_net_retry_type(t, 0);
      util.save_network_type(t, D);
    }
    F = util.get_apn_string(t).getBytes();
    aa = util.get_ksid(t);
    E = util.get_apk_id(t);
    G = util.get_apk_v(t, new String(E));
    localObject1 = t;
    H = util.getPkgSigFromApkName((Context)localObject1, ((Context)localObject1).getPackageName());
    Q = util.getAppName(t);
    localObject2 = Build.VERSION.RELEASE;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = localObject1;
    if (16 < ((String)localObject1).length()) {
      localObject2 = ((String)localObject1).substring(0, 16);
    }
    J = ((String)localObject2).getBytes();
    localObject1 = xr.a;
    if (localObject1 == null) {
      localObject1 = new byte[0];
    } else {
      localObject1 = ((String)localObject1).getBytes();
    }
    I = (byte[])localObject1;
    localObject1 = Build.BRAND;
    if (localObject1 == null) {
      localObject1 = new byte[0];
    } else {
      localObject1 = ((String)localObject1).getBytes();
    }
    P = (byte[])localObject1;
    if ((!util.isFileExist("/system/bin/su")) && (!util.isFileExist("/system/xbin/su")) && (!util.isFileExist("/sbin/su"))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 1) {
      i2 = 1;
    }
    Z = i2;
    al = new d(t);
    localObject1 = report_t.read_fromfile(t);
    an = (Reporter)localObject1;
    if (localObject1 == null) {
      an = new Reporter();
    }
    util.LOGI("init done", "");
  }
  
  public static long f()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  public static long g()
  {
    return System.currentTimeMillis() / 1000L + ac;
  }
  
  @SuppressLint({"NewApi"})
  public static String l()
  {
    Object localObject = am;
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      return am;
    }
    try
    {
      int i1 = Process.myPid();
      localObject = ((ActivityManager)t.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i1)
        {
          localObject = localRunningAppProcessInfo.processName;
          am = (String)localObject;
          return localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "");
    }
    return "";
  }
  
  private static SecureRandom m()
  {
    try
    {
      SecureRandom localSecureRandom = new SecureRandom();
      return localSecureRandom;
    }
    catch (Throwable localThrowable)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      int i1 = al.a(paramLong1, paramLong2, paramLong3, paramLong4, paramArrayOfByte1, paramArrayOfByte2);
      return i1;
    }
    finally
    {
      paramArrayOfByte1 = finally;
      throw paramArrayOfByte1;
    }
  }
  
  public int a(long paramLong1, long paramLong2, byte[][] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, WloginSimpleInfo paramWloginSimpleInfo, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[][] paramArrayOfByte14, long[] paramArrayOfLong, int paramInt)
  {
    try
    {
      al.e = this.aq;
      paramInt = al.a(paramLong1, paramLong2, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramWloginSimpleInfo, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfLong, paramInt);
      return paramInt;
    }
    finally
    {
      paramArrayOfByte1 = finally;
      throw paramArrayOfByte1;
    }
  }
  
  public t a(long paramLong)
  {
    t localt = new t(null);
    localt.k = this.k;
    localt.l = this.l;
    byte[] arrayOfByte = this.c;
    if (arrayOfByte != null) {
      localt.c = ((byte[])arrayOfByte.clone());
    }
    arrayOfByte = this.n;
    if ((arrayOfByte != null) && (this.p != null))
    {
      localt.n = ((byte[])arrayOfByte.clone());
      localt.p = ((byte[])this.p.clone());
    }
    long l1 = paramLong;
    if (paramLong <= 0L) {
      l1 = a();
    }
    localt.h = l1;
    return localt;
  }
  
  public WloginSigInfo a(long paramLong1, long paramLong2)
  {
    try
    {
      util.LOGI("get_siginfo appid=".concat(String.valueOf(paramLong2)), String.valueOf(paramLong1));
      WloginSigInfo localWloginSigInfo = al.d(paramLong1, paramLong2);
      if (localWloginSigInfo != null) {
        return localWloginSigInfo;
      }
      return localWloginSigInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    try
    {
      al.a(paramLong1, paramLong2, paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      al.a(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, Long paramLong)
  {
    try
    {
      al.a(paramString, paramLong, true);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, Long paramLong, boolean paramBoolean)
  {
    try
    {
      al.a(paramString, paramLong, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    long l1 = (util.buf_to_int32(paramArrayOfByte1, 0) & 0xFFFFFFFF) - System.currentTimeMillis() / 1000L;
    ab = l1;
    ac = l1;
    ad = paramArrayOfByte2;
  }
  
  public int b(long paramLong1, long paramLong2)
  {
    try
    {
      int i1 = al.a(paramLong1, paramLong2);
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long b(String paramString)
  {
    try
    {
      paramString = al.a(paramString, true);
      if ((paramString != null) && (paramString._uin.longValue() != 0L))
      {
        long l1 = paramString._uin.longValue();
        return l1;
      }
      return 0L;
    }
    finally {}
  }
  
  public void b(Context paramContext)
  {
    t = paramContext;
    paramContext = util.get_rand_16byte(a);
    System.arraycopy(paramContext, 0, this.c, 0, paramContext.length);
  }
  
  public UinInfo c(String paramString)
  {
    try
    {
      paramString = al.a(paramString, false);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    try
    {
      al.b(paramLong1, paramLong2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public WloginSimpleInfo d(long paramLong)
  {
    try
    {
      WloginSimpleInfo localWloginSimpleInfo = al.b(paramLong);
      if (localWloginSimpleInfo != null) {
        return localWloginSimpleInfo;
      }
      return localWloginSimpleInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d(long paramLong1, long paramLong2)
  {
    al.c(paramLong1, paramLong2);
  }
  
  public void d(String paramString)
  {
    try
    {
      al.b(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String e(long paramLong)
  {
    try
    {
      String str = al.b(Long.valueOf(paramLong));
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e(long paramLong1, long paramLong2)
  {
    try
    {
      al.a(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean e()
  {
    return this.k != 0;
  }
  
  public void h()
  {
    util.LOGD("close_connect", "close_connect");
    Socket localSocket = this.aj;
    if (localSocket != null)
    {
      try
      {
        util.LOGD("close_connect", localSocket.toString());
        this.aj.close();
      }
      catch (Exception localException)
      {
        util.printException(localException, "");
      }
      this.aj = null;
    }
  }
  
  public void i()
  {
    util.LOGD("close_transport_connect", "close_transport_connect");
    Socket localSocket = this.ak;
    if (localSocket != null)
    {
      try
      {
        util.LOGD("close_transport_connect", localSocket.toString());
        this.ak.close();
      }
      catch (Exception localException)
      {
        util.printException(localException, "");
      }
      this.ak = null;
    }
  }
  
  public void j()
  {
    try
    {
      al.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<WloginLoginInfo> k()
  {
    try
    {
      List localList = al.a(true);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.t
 * JD-Core Version:    0.7.0.1
 */