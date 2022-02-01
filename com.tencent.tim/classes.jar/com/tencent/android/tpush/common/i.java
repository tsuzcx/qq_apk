package com.tencent.android.tpush.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.android.tpush.TpnsActivity;
import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.XGPushProvider;
import com.tencent.android.tpush.XGPushReceiver;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.channel.security.a;
import com.tencent.android.tpush.service.util.f;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.android.tpush.stat.StatServiceImpl;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.RC4;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import com.tencent.tpns.mqttchannel.api.MqttTools;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.security.auth.x500.X500Principal;
import org.json.JSONObject;

public class i
{
  public static String a = null;
  private static AtomicBoolean b = new AtomicBoolean(false);
  private static boolean c = false;
  private static final X500Principal d = new X500Principal("CN=Android Debug,O=Android,C=US");
  private static String e = "";
  private static String f = "";
  
  public static int a(Context paramContext)
  {
    if (b.get()) {
      return 0;
    }
    try
    {
      TBaseLogger.init(paramContext);
      if (XGPushManager.getContext() == null) {
        XGPushManager.setContext(paramContext);
      }
      if (b.e() == null) {
        b.b(paramContext);
      }
      XGPushProvider.fetchProviderAuthorities(paramContext);
      if (!h(paramContext))
      {
        TLogger.ee("Util", "XG is disable");
        return ReturnCode.CODE_SERVICE_DISABLED.getType();
      }
      if (!Security.checkTpnsSecurityLibSo(paramContext))
      {
        TLogger.ee("Util", "can not load library from so file");
        ServiceStat.reportErrCode(paramContext, ReturnCode.CODE_SO_ERROR.getType(), "can not load library from so file", 0L, "inner");
        return ReturnCode.CODE_SO_ERROR.getType();
      }
      AppInfos.checkApplicationIcon(paramContext);
      StatServiceImpl.init(paramContext);
      g(paramContext);
      q(paramContext);
      b.set(true);
      return 0;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("Util", "Util -> initGlobal", paramContext);
    }
    return -1;
  }
  
  public static String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyyMMdd").format(Long.valueOf(paramLong));
      return str;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("Util", "getDateString", localThrowable);
    }
    return "20141111";
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 43	com/tencent/android/tpush/common/i:a	Ljava/lang/String;
    //   6: invokestatic 165	com/tencent/android/tpush/common/i:b	(Ljava/lang/String;)Z
    //   9: ifne +9 -> 18
    //   12: getstatic 43	com/tencent/android/tpush/common/i:a	Ljava/lang/String;
    //   15: astore_0
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual 171	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   22: invokevirtual 177	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   25: aload_1
    //   26: invokevirtual 183	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnonnull +33 -> 64
    //   34: iconst_0
    //   35: ifeq +11 -> 46
    //   38: new 185	java/lang/NullPointerException
    //   41: dup
    //   42: invokespecial 187	java/lang/NullPointerException:<init>	()V
    //   45: athrow
    //   46: aload 4
    //   48: astore_0
    //   49: iconst_0
    //   50: ifeq -34 -> 16
    //   53: new 185	java/lang/NullPointerException
    //   56: dup
    //   57: invokespecial 187	java/lang/NullPointerException:<init>	()V
    //   60: athrow
    //   61: astore_0
    //   62: aconst_null
    //   63: areturn
    //   64: new 189	java/io/InputStreamReader
    //   67: dup
    //   68: aload_0
    //   69: ldc 191
    //   71: invokespecial 194	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   74: astore_1
    //   75: new 196	java/io/BufferedReader
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 199	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   83: astore_0
    //   84: aload_0
    //   85: astore_3
    //   86: aload_1
    //   87: astore_2
    //   88: new 201	java/lang/StringBuffer
    //   91: dup
    //   92: invokespecial 202	java/lang/StringBuffer:<init>	()V
    //   95: astore 5
    //   97: aload_0
    //   98: astore_3
    //   99: aload_1
    //   100: astore_2
    //   101: aload_0
    //   102: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   105: astore 6
    //   107: aload 6
    //   109: ifnull +54 -> 163
    //   112: aload_0
    //   113: astore_3
    //   114: aload_1
    //   115: astore_2
    //   116: aload 5
    //   118: aload 6
    //   120: invokevirtual 210	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   123: pop
    //   124: goto -27 -> 97
    //   127: astore_2
    //   128: aload_0
    //   129: astore_3
    //   130: aload_1
    //   131: astore_2
    //   132: ldc 83
    //   134: ldc 212
    //   136: invokestatic 214	com/tencent/android/tpush/logging/TLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: ifnull +7 -> 147
    //   143: aload_0
    //   144: invokevirtual 217	java/io/BufferedReader:close	()V
    //   147: aload 4
    //   149: astore_0
    //   150: aload_1
    //   151: ifnull -135 -> 16
    //   154: aload_1
    //   155: invokevirtual 218	java/io/InputStreamReader:close	()V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_0
    //   161: aconst_null
    //   162: areturn
    //   163: aload_0
    //   164: astore_3
    //   165: aload_1
    //   166: astore_2
    //   167: aload 5
    //   169: invokevirtual 221	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   172: putstatic 43	com/tencent/android/tpush/common/i:a	Ljava/lang/String;
    //   175: aload_0
    //   176: astore_3
    //   177: aload_1
    //   178: astore_2
    //   179: getstatic 43	com/tencent/android/tpush/common/i:a	Ljava/lang/String;
    //   182: astore 5
    //   184: aload_0
    //   185: ifnull +7 -> 192
    //   188: aload_0
    //   189: invokevirtual 217	java/io/BufferedReader:close	()V
    //   192: aload 5
    //   194: astore_0
    //   195: aload_1
    //   196: ifnull -180 -> 16
    //   199: aload_1
    //   200: invokevirtual 218	java/io/InputStreamReader:close	()V
    //   203: aload 5
    //   205: areturn
    //   206: astore_0
    //   207: aload 5
    //   209: areturn
    //   210: astore_0
    //   211: aconst_null
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_3
    //   215: aload_3
    //   216: ifnull +7 -> 223
    //   219: aload_3
    //   220: invokevirtual 217	java/io/BufferedReader:close	()V
    //   223: aload_1
    //   224: ifnull +7 -> 231
    //   227: aload_1
    //   228: invokevirtual 218	java/io/InputStreamReader:close	()V
    //   231: aload_0
    //   232: athrow
    //   233: astore_0
    //   234: goto -188 -> 46
    //   237: astore_0
    //   238: goto -46 -> 192
    //   241: astore_0
    //   242: goto -95 -> 147
    //   245: astore_2
    //   246: goto -23 -> 223
    //   249: astore_1
    //   250: goto -19 -> 231
    //   253: astore_0
    //   254: aconst_null
    //   255: astore_3
    //   256: goto -41 -> 215
    //   259: astore_0
    //   260: aload_2
    //   261: astore_1
    //   262: goto -47 -> 215
    //   265: astore_0
    //   266: aconst_null
    //   267: astore_0
    //   268: aconst_null
    //   269: astore_1
    //   270: goto -142 -> 128
    //   273: astore_0
    //   274: aconst_null
    //   275: astore_0
    //   276: goto -148 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramContext	Context
    //   0	279	1	paramString	String
    //   87	29	2	str1	String
    //   127	1	2	localThrowable1	Throwable
    //   131	48	2	str2	String
    //   245	16	2	localThrowable2	Throwable
    //   85	171	3	localContext	Context
    //   1	147	4	localObject1	Object
    //   95	113	5	localObject2	Object
    //   105	14	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   53	61	61	java/lang/Throwable
    //   88	97	127	java/lang/Throwable
    //   101	107	127	java/lang/Throwable
    //   116	124	127	java/lang/Throwable
    //   167	175	127	java/lang/Throwable
    //   179	184	127	java/lang/Throwable
    //   154	158	160	java/lang/Throwable
    //   199	203	206	java/lang/Throwable
    //   18	30	210	finally
    //   64	75	210	finally
    //   38	46	233	java/lang/Throwable
    //   188	192	237	java/lang/Throwable
    //   143	147	241	java/lang/Throwable
    //   219	223	245	java/lang/Throwable
    //   227	231	249	java/lang/Throwable
    //   75	84	253	finally
    //   88	97	259	finally
    //   101	107	259	finally
    //   116	124	259	finally
    //   132	139	259	finally
    //   167	175	259	finally
    //   179	184	259	finally
    //   18	30	265	java/lang/Throwable
    //   64	75	265	java/lang/Throwable
    //   75	84	273	java/lang/Throwable
  }
  
  public static void a()
  {
    try
    {
      PowerManager.WakeLock localWakeLock = com.tencent.android.tpush.service.d.a().b();
      if (localWakeLock != null)
      {
        boolean bool = localWakeLock.isHeld();
        if (bool) {}
        try
        {
          localWakeLock.release();
          TLogger.d("Util", "stop WakeLock CPU");
          return;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            TLogger.e("Util", "Wakelock exception", localThrowable1);
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      TLogger.e("Util", "stopWakeLock", localThrowable2);
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (2 == paramInt) {}
    String str;
    do
    {
      try
      {
        str = (String)CommonHelper.getMetaData(paramContext, "com.meizu.push.api_id", "");
        paramContext = (String)CommonHelper.getMetaData(paramContext, "com.meizu.push.api_key", "");
        com.tencent.android.tpush.d.d.c = str.substring(4);
        com.tencent.android.tpush.d.d.d = paramContext.substring(4);
        TLogger.d("Util", "mz:" + com.tencent.android.tpush.d.d.c + ", " + com.tencent.android.tpush.d.d.d);
        return;
      }
      catch (Throwable paramContext)
      {
        TLogger.w("Util", "unexpected for init mz");
        return;
      }
      if (1 == paramInt) {
        try
        {
          str = (String)CommonHelper.getMetaData(paramContext, "com.xiaomi.push.api_id", "");
          paramContext = (String)CommonHelper.getMetaData(paramContext, "com.xiaomi.push.api_key", "");
          com.tencent.android.tpush.d.d.a = str.substring(4);
          com.tencent.android.tpush.d.d.b = paramContext.substring(4);
          TLogger.d("Util", "mi:" + com.tencent.android.tpush.d.d.a + ", " + com.tencent.android.tpush.d.d.b);
          return;
        }
        catch (Throwable paramContext)
        {
          TLogger.w("Util", "unexpected for init xm");
          return;
        }
      }
    } while (6 != paramInt);
    try
    {
      str = (String)CommonHelper.getMetaData(paramContext, "com.oppo.push.api_id", "");
      paramContext = (String)CommonHelper.getMetaData(paramContext, "com.oppo.push.api_key", "");
      com.tencent.android.tpush.d.d.e = str.substring(4);
      com.tencent.android.tpush.d.d.f = paramContext.substring(4);
      TLogger.d("Util", "oppo:" + com.tencent.android.tpush.d.d.e + ", " + com.tencent.android.tpush.d.d.f);
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.w("Util", "unexpected for init oppo");
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, long paramLong)
  {
    if ((paramString != null) && (paramLong > 0L)) {}
    try
    {
      paramJSONObject.put(paramString, paramLong);
      return;
    }
    catch (Throwable paramJSONObject) {}
  }
  
  public static void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramString2 != null) {}
    try
    {
      if (paramString2.length() > 0) {
        paramJSONObject.put(paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramJSONObject) {}
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    try
    {
      Calendar localCalendar1 = Calendar.getInstance();
      Calendar localCalendar2 = Calendar.getInstance();
      Object localObject2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
      Object localObject1 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
      String str2 = ((SimpleDateFormat)localObject2).format(Long.valueOf(paramLong1));
      String str1 = ((SimpleDateFormat)localObject1).format(Long.valueOf(paramLong2));
      localObject2 = ((SimpleDateFormat)localObject2).parse(str2);
      localObject1 = ((SimpleDateFormat)localObject1).parse(str1);
      localCalendar1.setTime((Date)localObject2);
      localCalendar2.setTime((Date)localObject1);
      boolean bool = a(localCalendar1, localCalendar2);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Logger.w("Util", "");
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (paramActivity != null) {
      try
      {
        TypedArray localTypedArray = paramActivity.getTheme().obtainStyledAttributes(new int[] { 16842838, 16842841, 16842836, 16842840, 16843435 });
        boolean bool1 = localTypedArray.getBoolean(0, false);
        Drawable localDrawable1 = localTypedArray.getDrawable(1);
        int i = localTypedArray.getColor(2, -1);
        boolean bool2 = localTypedArray.getBoolean(3, false);
        Drawable localDrawable2 = localTypedArray.getDrawable(4);
        localTypedArray.recycle();
        if ((bool1) && (bool2) && (localDrawable1 == null) && (localDrawable2 == null))
        {
          int j = paramActivity.getResources().getColor(17170445);
          if (i == j) {
            return true;
          }
        }
      }
      catch (Throwable paramActivity)
      {
        Logger.w("Util", "run TranslucentNotitleTheme failed: " + paramActivity.getMessage());
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, BroadcastReceiver paramBroadcastReceiver)
  {
    try
    {
      BroadcastAgent.unregisterReceiver(paramContext, paramBroadcastReceiver);
      return true;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("Util", "safeUnregisterReceiver error", paramContext);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.length() >= 32);
  }
  
  public static boolean a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (paramCalendar1 != null)
    {
      bool1 = bool3;
      if (paramCalendar2 == null) {}
    }
    try
    {
      if ((paramCalendar1.get(0) == paramCalendar2.get(0)) && (paramCalendar1.get(1) == paramCalendar2.get(1)))
      {
        int i = paramCalendar1.get(6);
        int j = paramCalendar2.get(6);
        if (i != j) {}
      }
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
      return false;
    }
    catch (Throwable paramCalendar1) {}
  }
  
  public static String b()
  {
    String str2 = Build.MANUFACTURER;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      str1 = str2.trim().toLowerCase();
    }
    return str1;
  }
  
  private static void b(PackageManager paramPackageManager, Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null)) {
      try
      {
        if (paramString.trim().length() == 0) {
          return;
        }
        if (paramPackageManager != null)
        {
          paramContext = new ComponentName(paramContext.getPackageName(), paramString);
          if (paramPackageManager.getComponentEnabledSetting(paramContext) != 2)
          {
            paramPackageManager.setComponentEnabledSetting(paramContext, 2, 1);
            return;
          }
        }
      }
      catch (Throwable paramPackageManager) {}
    }
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      paramContext = f.c(paramContext, paramContext.getPackageName() + ".XGVIP_PUSH_ACTION");
      if (paramContext != null)
      {
        int i = paramContext.size();
        if (i > 0) {
          return true;
        }
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.e("Util", "Util -> isAIDLConfiged", paramContext);
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    return (MqttTools.isPushMsgTopic(paramContext, paramString)) || (MqttTools.isAesPushMsgTopic(paramContext, paramString)) || (MqttTools.isGZipPushMsgTopic(paramContext, paramString)) || (MqttTools.isGZipAesPushMsgTopic(paramContext, paramString));
  }
  
  public static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.replace(".", "");
      paramString2 = paramString2.replace(".", "");
      float f1 = Float.valueOf(paramString1).floatValue();
      float f2 = Float.valueOf(paramString2).floatValue();
      if (f2 > f1) {
        return true;
      }
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  public static int c(Context paramContext)
  {
    TLogger.d("Util", "action getServiceStatus");
    if (paramContext != null) {
      try
      {
        Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          String str1 = XGVipPushService.class.getName();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
            String str2 = localRunningServiceInfo.service.getClassName();
            String str3 = localRunningServiceInfo.service.getPackageName();
            if ((str1.equals(str2)) && (str3.equals(paramContext.getPackageName())))
            {
              int i = localRunningServiceInfo.pid;
              if (i != 0) {
                return 1;
              }
              return 2;
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        TLogger.e("Util", "getServiceStatus", paramContext);
      }
    }
    return 0;
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      long l1 = paramContext.firstInstallTime;
      long l2 = paramContext.lastUpdateTime;
      if (l1 == l2) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("Util", "unexpected for isFirstInstall: " + paramContext.getMessage());
    }
    return false;
  }
  
  public static boolean c(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() != 0);
  }
  
  public static long d(String paramString)
  {
    if ((paramString == null) || (paramString.equals("0")) || (paramString.equals(""))) {
      return 0L;
    }
    paramString = paramString.trim();
    long[] arrayOfLong = new long[4];
    int i = paramString.indexOf(".");
    int j = paramString.indexOf(".", i + 1);
    int k = paramString.indexOf(".", j + 1);
    try
    {
      arrayOfLong[3] = Long.parseLong(paramString.substring(0, i));
      arrayOfLong[2] = Long.parseLong(paramString.substring(i + 1, j));
      arrayOfLong[1] = Long.parseLong(paramString.substring(j + 1, k));
      arrayOfLong[0] = Long.parseLong(paramString.substring(k + 1));
      return (arrayOfLong[0] << 24) + (arrayOfLong[1] << 16) + (arrayOfLong[2] << 8) + arrayOfLong[3];
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i = 0;
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = 0L;
          i += 1;
        }
        TLogger.e("Util", "service Util@@parseIpAddress(" + paramString + ")", localThrowable);
      }
    }
  }
  
  public static void d(Context paramContext)
  {
    TLogger.d("Util", "startCurrentAppService " + paramContext.getPackageName());
    paramContext.startService(new Intent(paramContext, XGVipPushService.class));
  }
  
  public static boolean d(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      try
      {
        Object localObject2 = Class.forName("android.app.ActivityThread");
        Object localObject1 = ((Class)localObject2).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        localObject2 = ((Class)localObject2).getDeclaredField("mActivities");
        ((Field)localObject2).setAccessible(true);
        localObject1 = (Map)((Field)localObject2).get(localObject1);
        if (localObject1 == null)
        {
          Logger.w("Util", "get current activities for currentActivityThread, activities is null");
          return false;
        }
        localObject2 = ((Map)localObject1).values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          Class localClass = localObject1.getClass();
          Field localField = localClass.getDeclaredField("paused");
          localField.setAccessible(true);
          if (!localField.getBoolean(localObject1))
          {
            localObject2 = localClass.getDeclaredField("activity");
            ((Field)localObject2).setAccessible(true);
            localObject1 = (Activity)((Field)localObject2).get(localObject1);
            if (localObject1 == null)
            {
              Logger.w("Util", "[getCurrentActivity] activity is null");
              return false;
            }
            if (!((Activity)localObject1).getPackageName().equals(paramContext.getPackageName()))
            {
              Logger.w("Util", "current activity packageName: " + ((Activity)localObject1).getPackageName() + ", appPackageName: " + paramContext.getPackageName());
              return false;
            }
            Logger.d("Util", "getCurrentActivity: " + ((Activity)localObject1).getLocalClassName());
            return true;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Logger.w("Util", "[getCurrentActivity] error: " + localThrowable.getMessage());
        return e(paramContext, paramString);
      }
    }
    return false;
  }
  
  public static String e(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (Build.VERSION.SDK_INT < 8);
    try
    {
      str = new String(RC4.decrypt(a.a(paramString.getBytes("UTF-8"), 0)), "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("Util", "decode error", localThrowable);
    }
    return paramString;
  }
  
  public static void e(Context paramContext)
  {
    if (paramContext != null)
    {
      try
      {
        if (f.a(paramContext.getPackageName()))
        {
          d(paramContext);
          return;
        }
        b.b(paramContext.getApplicationContext());
        b.a(paramContext);
        TLogger.v("Util", "Action -> start Local Service()");
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          TLogger.e("Util", "StartService", localThrowable);
        }
      }
      CommonWorkingThread.getInstance().execute(new i.2(paramContext), 1500L);
      return;
    }
  }
  
  public static boolean e(Context paramContext, String paramString)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.processName.equals(paramString))
        {
          int i = localRunningAppProcessInfo.importance;
          if (i == 100) {
            return true;
          }
        }
      }
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static String f(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (Build.VERSION.SDK_INT < 8);
    try
    {
      str = new String(a.b(RC4.encrypt(paramString.getBytes("UTF-8")), 0), "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("Util", "encode error", localThrowable);
    }
    return paramString;
  }
  
  public static void f(Context paramContext)
  {
    if (paramContext == null) {}
    while (c) {
      return;
    }
    for (;;)
    {
      try
      {
        f(paramContext, XGVipPushService.class.getName());
        f(paramContext, TpnsActivity.class.getName());
        f(paramContext, XGPushProvider.class.getName());
        f(paramContext, SettingsContentProvider.class.getName());
        Object localObject = paramContext.getPackageName();
        localObject = paramContext.getPackageManager().getPackageInfo((String)localObject, 2).receivers;
        int j = localObject.length;
        i = 0;
        if (i < j) {
          str = localObject[i].name;
        }
      }
      catch (Throwable paramContext)
      {
        int i;
        String str;
        Class localClass;
        TLogger.e("Util", "enableComponents", paramContext);
        c = true;
        return;
      }
      try
      {
        localClass = paramContext.getClassLoader().loadClass(str);
        if ((XGPushBaseReceiver.class.isAssignableFrom(localClass)) || (localClass.getName().equals(XGPushReceiver.class.getName()))) {
          f(paramContext, str);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        continue;
      }
      i += 1;
    }
  }
  
  private static void f(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null)) {
      try
      {
        if (paramString.trim().length() == 0) {
          return;
        }
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager != null)
        {
          paramContext = new ComponentName(paramContext.getPackageName(), paramString);
          if (localPackageManager.getComponentEnabledSetting(paramContext) != 1)
          {
            localPackageManager.setComponentEnabledSetting(paramContext, 1, 1);
            return;
          }
        }
      }
      catch (Throwable paramContext) {}
    }
  }
  
  public static void g(Context paramContext)
  {
    CommonWorkingThread.getInstance().execute(new i.3(paramContext));
  }
  
  public static boolean h(Context paramContext)
  {
    return XGApiConfig.isEnableService(paramContext);
  }
  
  public static void i(Context paramContext)
  {
    try
    {
      if ("oppo".equals(b()))
      {
        Intent localIntent = new Intent("oppo.safecenter.intent.action.CHANGE_NOTIFICATION_STATE");
        localIntent.putExtra("package_name", paramContext.getPackageName());
        localIntent.putExtra("allow_notify", true);
        BroadcastAgent.sendBroadcast(paramContext, localIntent);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.d("openNotification", "openNotification", paramContext);
    }
  }
  
  public static void j(Context paramContext)
  {
    Object localObject = b();
    if ("meizu".equals(localObject)) {}
    while (!"oppo".equals(localObject)) {
      return;
    }
    try
    {
      localObject = new Intent();
      ((Intent)localObject).setClassName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity");
      ((Intent)localObject).setAction("com.coloros.notificationmanager.app.detail");
      ((Intent)localObject).setData(Uri.parse("package:" + paramContext.getPackageName()));
      ((Intent)localObject).putExtra("pkg_name", paramContext.getPackageName());
      ((Intent)localObject).putExtra("app_name", AppInfos.getApplicationName(paramContext));
      ((Intent)localObject).putExtra("class_name", paramContext.getPackageName());
      paramContext.startActivity((Intent)localObject);
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.d("Util", "openNotificationSettings", paramContext);
    }
  }
  
  public static void k(Context paramContext)
  {
    paramContext = a(paramContext, "otherpush_config.json");
    if (b(paramContext)) {}
    for (;;)
    {
      return;
      for (;;)
      {
        try
        {
          paramContext = new JSONObject(paramContext);
        }
        catch (Throwable paramContext)
        {
          JSONObject localJSONObject;
          TLogger.e("Util", "", paramContext);
          return;
        }
        try
        {
          localJSONObject = paramContext.optJSONObject("xiaomi");
          if (localJSONObject != null)
          {
            com.tencent.android.tpush.d.d.a = localJSONObject.optString("appid", null);
            com.tencent.android.tpush.d.d.b = localJSONObject.optString("appkey", null);
          }
        }
        catch (Throwable localThrowable)
        {
          continue;
        }
        try
        {
          paramContext = paramContext.optJSONObject("meizu");
          if (paramContext == null) {
            break;
          }
          com.tencent.android.tpush.d.d.c = paramContext.optString("appid", null);
          com.tencent.android.tpush.d.d.d = paramContext.optString("appkey", null);
          return;
        }
        catch (Throwable paramContext) {}
      }
    }
  }
  
  public static String l(Context paramContext)
  {
    try
    {
      if (b(e)) {
        e = String.valueOf(CommonHelper.getMetaData(paramContext, "com.huawei.hms.client.appid", ""));
      }
      if (TextUtils.isEmpty(e)) {
        e = com.tencent.android.tpush.d.d.h;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TLogger.w("Util", "unexpected for getHwConfig");
      }
    }
    return e;
  }
  
  public static String m(Context paramContext)
  {
    try
    {
      if (b(f)) {
        f = String.valueOf(CommonHelper.getMetaData(paramContext, "com.vivo.push.app_id", ""));
      }
      return f;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TLogger.w("Util", "unexpected for getVivoConfig");
      }
    }
  }
  
  public static boolean n(Context paramContext)
  {
    try
    {
      boolean bool = ((Boolean)CommonHelper.getMetaData(paramContext, "ENABLE_OTHER_PUSH", Boolean.valueOf(false))).booleanValue();
      return bool;
    }
    catch (Throwable paramContext)
    {
      TLogger.w("Util", "unexpected for init isUsedOtherPush4Plugin");
    }
    return false;
  }
  
  public static byte o(Context paramContext)
  {
    byte b1 = MobileType.UNKNOWN.getType();
    if (paramContext != null) {
      try
      {
        paramContext = CustomDeviceInfos.getSimOperator(paramContext);
        if (paramContext != null)
        {
          if ((paramContext.equals("46000")) || (paramContext.equals("46002")) || (paramContext.equals("46007")) || (paramContext.equals("46020"))) {
            return MobileType.CHINAMOBILE.getType();
          }
          if ((paramContext.equals("46001")) || (paramContext.equals("46006"))) {
            return MobileType.UNICOM.getType();
          }
          if ((paramContext.equals("46003")) || (paramContext.equals("46005")))
          {
            byte b2 = MobileType.TELCOM.getType();
            return b2;
          }
        }
      }
      catch (Throwable paramContext)
      {
        TLogger.e("Util", "getIsp", paramContext);
      }
    }
    return b1;
  }
  
  public static String p(Context paramContext)
  {
    try
    {
      Object localObject1 = paramContext.getPackageManager();
      Object localObject2 = new Intent("android.intent.action.MAIN");
      ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
      localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResolveInfo)((Iterator)localObject1).next();
        if (((ResolveInfo)localObject2).activityInfo.applicationInfo.packageName.equalsIgnoreCase(paramContext.getPackageName()))
        {
          paramContext = ((ResolveInfo)localObject2).activityInfo.name;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.e("Util", "get launcher class name error: " + paramContext.toString());
    }
    return "";
  }
  
  private static void q(Context paramContext)
  {
    if ((paramContext.getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; i != 0; i = 0) {
      try
      {
        new Thread(new i.1(paramContext)).start();
        return;
      }
      catch (Throwable paramContext)
      {
        Logger.e("Util", "checkVersionUpdate error " + paramContext.toString());
        return;
      }
    }
    Logger.d("Util", "It is release");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.i
 * JD-Core Version:    0.7.0.1
 */