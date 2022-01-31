package oicq.wlogin_sdk.request;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import java.net.Socket;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public class y
{
  public static byte[] A = new byte[0];
  public static int B = 0;
  public static byte[] C = new byte[0];
  public static byte[] D = new byte[0];
  public static byte[] E = new byte[0];
  public static byte[] F = new byte[0];
  public static byte[] G = new byte[0];
  public static byte[] H = new byte[0];
  public static byte[] I = "android".getBytes();
  static byte[] J = new byte[0];
  static byte[] K = new byte[0];
  static byte[] L = new byte[0];
  static byte[] M = new byte[0];
  static byte[] N = new byte[0];
  static byte[] O = new byte[0];
  static int P = 0;
  static int Q = 0;
  static int R = 0;
  static int S = 0;
  static int T = 0;
  public static int U = 0;
  public static int V = 0;
  static byte[] W = new byte[0];
  static long X = 0L;
  static long Y = 0L;
  static byte[] Z = new byte[4];
  public static SecureRandom a = ;
  public static g ac = null;
  protected static String ad = "";
  static report_t1 ae = new report_t1();
  public static long af = 0L;
  public static TreeMap<Long, k> ag = new TreeMap();
  private static Object ah = new Object();
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
  Socket aa = null;
  Socket ab = null;
  public byte[] b = null;
  public byte[] c = new byte[16];
  public at d = null;
  public long f = 0L;
  public String g = "";
  public long h = 0L;
  public int i = 0;
  public WFastLoginInfo j;
  public int k = 0;
  public int l = 10000;
  public int m = 0;
  public byte[] n = new byte[16];
  public byte[] o = new byte[16];
  public byte[] p = new byte[0];
  public int q = 0;
  
  public y(Context paramContext) {}
  
  public static long a()
  {
    try
    {
      if (af > 200L) {
        af = 0L;
      }
      long l1 = af + 1L;
      af = l1;
      return l1;
    }
    finally {}
  }
  
  public static k b(long paramLong)
  {
    for (;;)
    {
      synchronized (ah)
      {
        k localk2 = (k)ag.get(Long.valueOf(paramLong));
        if (localk2 == null)
        {
          for (;;)
          {
            try
            {
              localk1 = new k();
            }
            catch (Exception localException3)
            {
              k localk1;
              Exception localException1 = localException2;
              Object localObject2 = localException3;
              continue;
            }
            try
            {
              ag.put(Long.valueOf(paramLong), localk1);
              return localk1;
            }
            catch (Exception localException2) {}
          }
          util.printException(localk2, "");
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
      new l(r).start();
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
        T |= 0x1;
      }
      if (!Arrays.equals((byte[])localObject2, arrayOfByte2)) {
        T |= 0x2;
      }
      if (!Arrays.equals((byte[])localObject3, arrayOfByte3)) {
        T |= 0x4;
      }
    }
    util.save_cur_flag(r, 1);
    util.save_cur_mac(r, (byte[])localObject1);
    util.save_cur_imei(r, (byte[])localObject2);
    util.save_cur_guid(r, (byte[])localObject3);
  }
  
  public static void c(long paramLong)
  {
    synchronized (ah)
    {
      try
      {
        ag.remove(Long.valueOf(paramLong));
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
    U = 0;
    byte[] arrayOfByte = util.get_file_imei(r);
    Object localObject1 = util.get_IMEI(r);
    label343:
    Object localObject2;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
      if ((localObject1 == null) || (localObject1.length <= 0))
      {
        localObject1 = new String("%4;7t>;28<fc.5*6").getBytes();
        Q = 0;
        S = 20;
        util.save_file_imei(r, (byte[])localObject1);
        R = 0;
        P = 1;
        c();
        U |= S << 24 & 0xFF000000;
        U |= T << 8 & 0xFF00;
        y = (byte[])((byte[])localObject1).clone();
        z = (byte[])((byte[])localObject1).clone();
        K = util.get_imei_id(r);
        if ((K != null) && (K.length > 0)) {
          K = MD5.toMD5Byte(K);
        }
        L = util.get_mac_addr(r);
        if ((L != null) && (L.length > 0)) {
          L = MD5.toMD5Byte(L);
        }
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
        W = util.get_ksid(r);
        if ((W != null) && (W.length > 0)) {
          break label582;
        }
        util.LOGD("ksid=null");
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
          break label613;
        }
        G = new byte[0];
        label429:
        localObject1 = Build.BRAND;
        if (localObject1 != null) {
          break label623;
        }
        N = new byte[0];
        label443:
        if ((!util.isFileExist("/system/bin/su")) && (!util.isFileExist("/system/xbin/su")) && (!util.isFileExist("/sbin/su"))) {
          break label633;
        }
        i1 = 1;
        label472:
        if (i1 != 1) {
          break label638;
        }
      }
    }
    label582:
    label613:
    label623:
    label633:
    label638:
    for (i1 = 1;; i1 = 0)
    {
      V = i1;
      ae = report_t.read_fromfile(r);
      if (ae == null) {
        ae = new report_t1();
      }
      return;
      Q = 1;
      S = 17;
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
      for (R = 0;; R = 1)
      {
        Q = 1;
        P = 0;
        S = 1;
        localObject1 = arrayOfByte;
        break;
      }
      util.LOGD("ksid=" + util.buf_to_string(W));
      break label343;
      G = ((String)localObject1).getBytes();
      break label429;
      N = ((String)localObject1).getBytes();
      break label443;
      i1 = 0;
      break label472;
    }
  }
  
  public static long f()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  public static long g()
  {
    return System.currentTimeMillis() / 1000L + Y;
  }
  
  public static String l()
  {
    if ((ad != null) && (ad.length() > 0)) {
      return ad;
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
          ad = localRunningAppProcessInfo.processName;
          localObject = ad;
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
      util.LOGD("put st sig:" + paramLong1 + "," + paramLong2 + "," + paramLong3 + "," + paramLong4 + "," + "," + util.buf_len(paramArrayOfByte1) + "," + util.buf_len(paramArrayOfByte2));
      int i1 = ac.a(paramLong1, paramLong2, paramLong3, paramLong4, paramArrayOfByte1, paramArrayOfByte2);
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
      int i1 = ac.a(paramLong1, paramLong2, paramArrayOfByte);
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
      paramInt = ac.a(paramLong1, paramLong2, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfByte15, paramArrayOfByte16, paramArrayOfByte17, paramArrayOfByte18, paramArrayOfByte19, paramArrayOfLong, paramInt);
      return paramInt;
    }
    finally
    {
      paramArrayOfByte1 = finally;
      throw paramArrayOfByte1;
    }
  }
  
  public y a(long paramLong)
  {
    y localy = new y(null);
    localy.k = this.k;
    localy.l = this.l;
    if (this.c != null) {
      localy.c = ((byte[])this.c.clone());
    }
    if ((this.n != null) && (this.o != null))
    {
      localy.n = ((byte[])this.n.clone());
      localy.o = ((byte[])this.o.clone());
    }
    if (paramLong <= 0L)
    {
      localy.h = a();
      return localy;
    }
    localy.h = paramLong;
    return localy;
  }
  
  public WloginSigInfo a(long paramLong1, long paramLong2)
  {
    try
    {
      util.LOGD("get_siginfo", "uin=" + paramLong1 + "appid=" + paramLong2);
      WloginSigInfo localWloginSigInfo = ac.a(paramLong1, paramLong2);
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
    ac = new g(paramContext);
    paramContext = util.get_rand_16byte(a);
    System.arraycopy(paramContext, 0, this.c, 0, paramContext.length);
  }
  
  public void a(String paramString)
  {
    try
    {
      ac.a(paramString);
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
      ac.a(paramString, paramLong, true);
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
      ac.a(paramString, paramLong, paramBoolean);
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
    X = (util.buf_to_int32(paramArrayOfByte1, 0) & 0xFFFFFFFF) - System.currentTimeMillis() / 1000L;
    Y = X;
    Z = paramArrayOfByte2;
  }
  
  /* Error */
  public Long b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 174	oicq/wlogin_sdk/request/y:ac	Loicq/wlogin_sdk/request/g;
    //   5: aload_1
    //   6: iconst_1
    //   7: invokevirtual 575	oicq/wlogin_sdk/request/g:a	(Ljava/lang/String;Z)Loicq/wlogin_sdk/request/UinInfo;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +24 -> 36
    //   15: aload_1
    //   16: getfield 581	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   19: invokevirtual 584	java/lang/Long:longValue	()J
    //   22: lconst_0
    //   23: lcmp
    //   24: ifeq +12 -> 36
    //   27: aload_1
    //   28: getfield 581	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: areturn
    //   36: aconst_null
    //   37: astore_1
    //   38: goto -6 -> 32
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	y
    //   0	46	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	11	41	finally
    //   15	32	41	finally
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    try
    {
      ac.a(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public UinInfo c(String paramString)
  {
    try
    {
      paramString = ac.a(paramString, false);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public WloginSimpleInfo d(long paramLong)
  {
    try
    {
      WloginSimpleInfo localWloginSimpleInfo = ac.b(paramLong);
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
      ac.b(paramString);
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
      String str = ac.a(Long.valueOf(paramLong));
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
    if (this.aa != null) {}
    try
    {
      util.LOGD("close_connect", this.aa.toString());
      this.aa.close();
      this.aa = null;
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
    if (this.ab != null) {}
    try
    {
      util.LOGD("close_transport_connect", this.ab.toString());
      this.ab.close();
      this.ab = null;
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
      ac.a();
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
      new ArrayList();
      List localList = ac.a(true);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.y
 * JD-Core Version:    0.7.0.1
 */