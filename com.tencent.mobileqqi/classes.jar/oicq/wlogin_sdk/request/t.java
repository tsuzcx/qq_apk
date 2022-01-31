package oicq.wlogin_sdk.request;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import java.net.Socket;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import oicq.wlogin_sdk.b.at;
import oicq.wlogin_sdk.report.report_t;
import oicq.wlogin_sdk.report.report_t1;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.util;

public class t
{
  public static byte[] A;
  public static int B;
  public static byte[] C;
  public static byte[] D;
  public static byte[] E;
  public static byte[] F;
  public static byte[] G;
  public static byte[] H;
  public static byte[] I;
  static byte[] J;
  static byte[] K;
  static byte[] L;
  static byte[] M;
  static byte[] N;
  static byte[] O;
  static byte[] P;
  static byte[] Q;
  static int R;
  static int S;
  static int T;
  static int U;
  static int V;
  public static int W;
  public static int X;
  static byte[] Y;
  static long Z;
  public static SecureRandom a = ;
  static long aa;
  static byte[] ab;
  static int ac;
  public static c af;
  protected static String ag;
  static report_t1 ah;
  public static long ai;
  public static TreeMap<Long, async_context> aj;
  public static int ak = 0;
  private static Object al;
  static Boolean e = Boolean.valueOf(false);
  public static Context r = null;
  public static int s = 2052;
  public static String t = "";
  static int u = 0;
  static int v = 1;
  static int w = 0;
  static int x = 0;
  public static byte[] y = new byte[0];
  static byte[] z = new byte[0];
  Socket ad = null;
  Socket ae = null;
  public byte[] b = null;
  public byte[] c = new byte[16];
  public at d = null;
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
  public byte[] p = new byte[0];
  public int q = 0;
  
  static
  {
    A = new byte[0];
    B = 0;
    C = new byte[0];
    D = new byte[0];
    E = new byte[0];
    F = new byte[0];
    G = new byte[0];
    H = new byte[0];
    I = "android".getBytes();
    J = new byte[0];
    K = new byte[0];
    L = new byte[0];
    M = new byte[0];
    N = new byte[0];
    O = new byte[0];
    P = new byte[0];
    Q = new byte[0];
    R = 0;
    S = 0;
    T = 0;
    U = 0;
    V = 0;
    W = 0;
    X = 0;
    Y = new byte[0];
    Z = 0L;
    aa = 0L;
    ab = new byte[4];
    ac = 0;
    af = null;
    ag = "";
    ah = new report_t1();
    ai = 0L;
    aj = new TreeMap();
    al = new Object();
  }
  
  public t(Context paramContext) {}
  
  public static long a()
  {
    try
    {
      if (ai > 200L) {
        ai = 0L;
      }
      long l1 = ai + 1L;
      ai = l1;
      return l1;
    }
    finally {}
  }
  
  public static async_context b(long paramLong)
  {
    for (;;)
    {
      synchronized (al)
      {
        async_context localasync_context2 = (async_context)aj.get(Long.valueOf(paramLong));
        if (localasync_context2 == null)
        {
          for (;;)
          {
            try
            {
              localasync_context1 = new async_context();
            }
            catch (Exception localException3)
            {
              async_context localasync_context1;
              Exception localException1 = localException2;
              Object localObject2 = localException3;
              continue;
            }
            try
            {
              aj.put(Long.valueOf(paramLong), localasync_context1);
              return localasync_context1;
            }
            catch (Exception localException2) {}
          }
          util.printException(localasync_context2, "");
        }
      }
      localException1 = localException2;
    }
  }
  
  public static void b()
  {
    String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
    if (str.compareTo(t) != 0)
    {
      t = str;
      new g(r).start();
    }
  }
  
  public static void c()
  {
    Object localObject2 = util.get_mac_addr(r);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > 0) {
        localObject1 = MD5.toMD5Byte((byte[])localObject2);
      }
    }
    Object localObject3 = util.get_imei_id(r);
    localObject2 = localObject3;
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (localObject3.length > 0) {
        localObject2 = MD5.toMD5Byte((byte[])localObject3);
      }
    }
    byte[] arrayOfByte1 = util.get_IMEI(r);
    localObject3 = arrayOfByte1;
    if (arrayOfByte1 != null)
    {
      localObject3 = arrayOfByte1;
      if (arrayOfByte1.length > 0) {
        localObject3 = MD5.toMD5Byte(arrayOfByte1);
      }
    }
    if (util.get_last_flag(r) != 0)
    {
      arrayOfByte1 = util.get_last_mac(r);
      byte[] arrayOfByte2 = util.get_last_imei(r);
      byte[] arrayOfByte3 = util.get_last_guid(r);
      if (!Arrays.equals((byte[])localObject1, arrayOfByte1)) {
        V |= 0x1;
      }
      if (!Arrays.equals((byte[])localObject2, arrayOfByte2)) {
        V |= 0x2;
      }
      if (!Arrays.equals((byte[])localObject3, arrayOfByte3)) {
        V |= 0x4;
      }
    }
    util.save_cur_flag(r, 1);
    util.save_cur_mac(r, (byte[])localObject1);
    util.save_cur_imei(r, (byte[])localObject2);
    util.save_cur_guid(r, (byte[])localObject3);
  }
  
  public static void c(long paramLong)
  {
    synchronized (al)
    {
      try
      {
        aj.remove(Long.valueOf(paramLong));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          util.printException(localException, "");
        }
      }
    }
  }
  
  public static void d()
  {
    int i1 = util.get_saved_network_type(r);
    W = 0;
    byte[] arrayOfByte = util.get_file_imei(r);
    Object localObject1 = util.get_IMEI(r);
    Object localObject2;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
      if ((localObject1 == null) || (localObject1.length <= 0))
      {
        localObject1 = new String("%4;7t>;28<fc.5*6").getBytes();
        S = 0;
        U = 20;
        util.save_file_imei(r, (byte[])localObject1);
        T = 0;
        R = 1;
        c();
        W |= U << 24 & 0xFF000000;
        W |= V << 8 & 0xFF00;
        y = (byte[])((byte[])localObject1).clone();
        z = (byte[])((byte[])localObject1).clone();
        K = util.get_imei_id(r);
        if ((K != null) && (K.length > 0)) {
          K = MD5.toMD5Byte(K);
        }
        ac = Build.VERSION.SDK_INT;
        L = util.get_mac_addr(r);
        if ((L != null) && (L.length > 0)) {
          L = MD5.toMD5Byte(L);
        }
        P = util.get_bssid_addr(r);
        if ((P != null) && (P.length > 0)) {
          P = MD5.toMD5Byte(P);
        }
        Q = util.get_ssid_addr(r);
        M = util.get_android_id(r);
        if ((M != null) && (M.length > 0)) {
          M = MD5.toMD5Byte(M);
        }
        J = util.get_IMSI(r);
        if ((J != null) && (J.length > 0)) {
          J = MD5.toMD5Byte(J);
        }
        A = util.get_sim_operator_name(r);
        B = util.get_network_type(r);
        if (i1 != B)
        {
          util.set_net_retry_type(r, 0);
          util.save_network_type(r, B);
        }
        D = util.get_apn_string(r).getBytes();
        Y = util.get_ksid(r);
        C = util.get_apk_id(r);
        E = util.get_apk_v(r, new String(C));
        F = util.getPkgSigFromApkName(r, r.getPackageName());
        O = util.getAppName(r);
        localObject2 = Build.VERSION.RELEASE;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        H = ((String)localObject1).getBytes();
        localObject1 = Build.MODEL;
        if (localObject1 != null) {
          break label622;
        }
        G = new byte[0];
        label456:
        localObject1 = Build.BRAND;
        if (localObject1 != null) {
          break label632;
        }
        N = new byte[0];
        label470:
        if ((!util.isFileExist("/system/bin/su")) && (!util.isFileExist("/system/xbin/su")) && (!util.isFileExist("/sbin/su"))) {
          break label642;
        }
        i1 = 1;
        label499:
        if (i1 != 1) {
          break label647;
        }
      }
    }
    label642:
    label647:
    for (i1 = 1;; i1 = 0)
    {
      X = i1;
      af = new c(r);
      ah = report_t.read_fromfile(r);
      if (ah == null) {
        ah = new report_t1();
      }
      return;
      S = 1;
      U = 17;
      break;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (localObject1.length > 0) {}
      }
      else
      {
        localObject2 = new String("%4;7t>;28<fc.5*6").getBytes();
      }
      if (Arrays.equals((byte[])localObject2, arrayOfByte)) {}
      for (T = 0;; T = 1)
      {
        S = 1;
        R = 0;
        U = 1;
        localObject1 = arrayOfByte;
        break;
      }
      label622:
      G = ((String)localObject1).getBytes();
      break label456;
      label632:
      N = ((String)localObject1).getBytes();
      break label470;
      i1 = 0;
      break label499;
    }
  }
  
  public static long f()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  public static long g()
  {
    return System.currentTimeMillis() / 1000L + aa;
  }
  
  @SuppressLint({"NewApi"})
  public static String l()
  {
    if ((ag != null) && (ag.length() > 0)) {
      return ag;
    }
    try
    {
      int i1 = Process.myPid();
      Object localObject = ((ActivityManager)r.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i1)
        {
          ag = localRunningAppProcessInfo.processName;
          localObject = ag;
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
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      int i1 = af.a(paramLong1, paramLong2, paramLong3, paramLong4, paramArrayOfByte1, paramArrayOfByte2);
      return i1;
    }
    finally
    {
      paramArrayOfByte1 = finally;
      throw paramArrayOfByte1;
    }
  }
  
  public int a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    try
    {
      int i1 = af.a(paramLong1, paramLong2, paramArrayOfByte);
      return i1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public int a(long paramLong1, long paramLong2, byte[][] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[][] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[] paramArrayOfByte14, byte[] paramArrayOfByte15, byte[] paramArrayOfByte16, byte[] paramArrayOfByte17, byte[] paramArrayOfByte18, byte[][] paramArrayOfByte19, long[] paramArrayOfLong, int paramInt)
  {
    try
    {
      paramInt = af.a(paramLong1, paramLong2, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfByte15, paramArrayOfByte16, paramArrayOfByte17, paramArrayOfByte18, paramArrayOfByte19, paramArrayOfLong, paramInt);
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
    if (this.c != null) {
      localt.c = ((byte[])this.c.clone());
    }
    if ((this.n != null) && (this.o != null))
    {
      localt.n = ((byte[])this.n.clone());
      localt.o = ((byte[])this.o.clone());
    }
    if (paramLong <= 0L)
    {
      localt.h = a();
      return localt;
    }
    localt.h = paramLong;
    return localt;
  }
  
  public WloginSigInfo a(long paramLong1, long paramLong2)
  {
    try
    {
      util.LOGI("get_siginfo appid=" + paramLong2, paramLong1 + "");
      WloginSigInfo localWloginSigInfo = af.b(paramLong1, paramLong2);
      if (localWloginSigInfo != null) {}
      return localWloginSigInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Context paramContext)
  {
    r = paramContext;
    paramContext = util.get_rand_16byte(a);
    System.arraycopy(paramContext, 0, this.c, 0, paramContext.length);
  }
  
  public void a(String paramString)
  {
    try
    {
      af.a(paramString);
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
      af.a(paramString, paramLong, true);
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
      af.a(paramString, paramLong, paramBoolean);
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
    Z = (util.buf_to_int32(paramArrayOfByte1, 0) & 0xFFFFFFFF) - System.currentTimeMillis() / 1000L;
    aa = Z;
    ab = paramArrayOfByte2;
  }
  
  public int b(long paramLong1, long paramLong2)
  {
    try
    {
      int i1 = af.a(paramLong1, paramLong2);
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
    long l2 = 0L;
    try
    {
      paramString = af.a(paramString, true);
      long l1 = l2;
      if (paramString != null)
      {
        l1 = l2;
        if (paramString._uin.longValue() != 0L) {
          l1 = paramString._uin.longValue();
        }
      }
      return l1;
    }
    finally {}
  }
  
  public UinInfo c(String paramString)
  {
    try
    {
      paramString = af.a(paramString, false);
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
      af.a(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
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
      WloginSimpleInfo localWloginSimpleInfo = af.b(paramLong);
      if (localWloginSimpleInfo != null) {}
      return localWloginSimpleInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      af.b(paramString);
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
      String str = af.b(Long.valueOf(paramLong));
      return str;
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
    if (this.ad != null) {}
    try
    {
      util.LOGD("close_connect", this.ad.toString());
      this.ad.close();
      this.ad = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        util.printException(localException, "");
      }
    }
  }
  
  public void i()
  {
    util.LOGD("close_transport_connect", "close_transport_connect");
    if (this.ae != null) {}
    try
    {
      util.LOGD("close_transport_connect", this.ae.toString());
      this.ae.close();
      this.ae = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        util.printException(localException, "");
      }
    }
  }
  
  public void j()
  {
    try
    {
      af.a();
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
      List localList = af.a(true);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.t
 * JD-Core Version:    0.7.0.1
 */