package com.tencent.mobileqq.pluginsdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public abstract class PluginStatic
{
  static final String CONTAINER_PACKAGE_NAME = "com.tencent.mobileqq";
  public static final String PARAM_CLASS_STATISTICS_UPLOADER = "clsUploader";
  @Deprecated
  public static final String PARAM_CLEAR_TOP = "cleartop";
  public static final String PARAM_EXTRA_INFO = "pluginsdk_extraInfo";
  static final String PARAM_IS_IN_PLUGIN = "pluginsdk_IsPluginActivity";
  public static final String PARAM_LAUNCH_ACTIVITY = "pluginsdk_launchActivity";
  public static final String PARAM_LAUNCH_SERVICE = "pluginsdk_launchService";
  public static final String PARAM_PATH = "pluginsdk_pluginpath";
  public static final String PARAM_PLUGIN_GESTURELOCK = "param_plugin_gesturelock";
  public static final String PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY = "PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY";
  public static final String PARAM_PLUGIN_LOCATION = "pluginsdk_pluginLocation";
  public static final String PARAM_PLUGIN_NAME = "pluginsdk_pluginName";
  public static final String PARAM_PLUGIN_RECEIVER_CLASS_NAME = "pluginsdk_launchReceiver";
  public static final String PARAM_UIN = "pluginsdk_selfuin";
  public static final String PARAM_USE_QQ_RESOURCES = "userQqResources";
  public static final String PARAM_USE_SKIN_ENGINE = "useSkinEngine";
  public static final int USER_QQ_RESOURCES_BOTH = 2;
  public static final int USER_QQ_RESOURCES_NO = -1;
  public static final int USER_QQ_RESOURCES_YES = 1;
  static final ConcurrentHashMap<String, DexClassLoader> sClassLoaderMap;
  static final ConcurrentHashMap<String, Long> sClassLoaderStartTimeMap = new ConcurrentHashMap();
  private static ArrayList<WeakReference<IPluginActivity>> sInstances = new ArrayList();
  private static final HashMap<String, IPluginLife> sLife = new HashMap();
  static final ConcurrentHashMap<String, PackageInfo> sPackageInfoMap;
  
  static
  {
    sClassLoaderMap = new ConcurrentHashMap();
    sPackageInfoMap = new ConcurrentHashMap();
  }
  
  static void add(IPluginActivity paramIPluginActivity)
  {
    
    synchronized (sInstances)
    {
      sInstances.add(new WeakReference(paramIPluginActivity));
      return;
    }
  }
  
  public static String byteArrayToHex(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar1 = new char[16];
    char[] tmp10_8 = arrayOfChar1;
    tmp10_8[0] = 48;
    char[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 49;
    char[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 50;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 51;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 52;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 53;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 54;
    char[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 55;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 56;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 57;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 65;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 66;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 67;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 68;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 69;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 70;
    tmp94_88;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  /* Error */
  public static String encodeFile(String paramString)
  {
    // Byte code:
    //   0: new 147	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 154	java/io/File:exists	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: invokevirtual 157	java/io/File:isFile	()Z
    //   20: ifne +22 -> 42
    //   23: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +11 -> 37
    //   29: ldc 164
    //   31: iconst_2
    //   32: ldc 166
    //   34: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: ldc 172
    //   39: astore_3
    //   40: aload_3
    //   41: areturn
    //   42: ldc 174
    //   44: invokestatic 180	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   47: astore 4
    //   49: new 182	java/io/FileInputStream
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 185	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: astore_2
    //   58: aload_2
    //   59: astore_0
    //   60: sipush 16384
    //   63: newarray byte
    //   65: astore_3
    //   66: aload_2
    //   67: astore_0
    //   68: aload_2
    //   69: aload_3
    //   70: invokevirtual 189	java/io/FileInputStream:read	([B)I
    //   73: istore_1
    //   74: iload_1
    //   75: iconst_m1
    //   76: if_icmpeq +78 -> 154
    //   79: aload_2
    //   80: astore_0
    //   81: aload 4
    //   83: aload_3
    //   84: iconst_0
    //   85: iload_1
    //   86: invokevirtual 193	java/security/MessageDigest:update	([BII)V
    //   89: goto -23 -> 66
    //   92: astore_3
    //   93: aload_2
    //   94: astore_0
    //   95: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +33 -> 131
    //   101: aload_2
    //   102: astore_0
    //   103: ldc 164
    //   105: iconst_2
    //   106: new 195	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   113: ldc 198
    //   115: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_3
    //   119: invokestatic 206	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   122: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_2
    //   132: ifnull +81 -> 213
    //   135: aload_2
    //   136: invokevirtual 213	java/io/FileInputStream:close	()V
    //   139: ldc 172
    //   141: areturn
    //   142: astore_0
    //   143: aload_2
    //   144: astore_0
    //   145: sipush 4096
    //   148: newarray byte
    //   150: astore_3
    //   151: goto -85 -> 66
    //   154: aload_2
    //   155: astore_0
    //   156: aload 4
    //   158: invokevirtual 217	java/security/MessageDigest:digest	()[B
    //   161: invokestatic 219	com/tencent/mobileqq/pluginsdk/PluginStatic:byteArrayToHex	([B)Ljava/lang/String;
    //   164: astore_3
    //   165: aload_3
    //   166: astore_0
    //   167: aload_0
    //   168: astore_3
    //   169: aload_2
    //   170: ifnull -130 -> 40
    //   173: aload_2
    //   174: invokevirtual 213	java/io/FileInputStream:close	()V
    //   177: aload_0
    //   178: areturn
    //   179: astore_2
    //   180: aload_0
    //   181: areturn
    //   182: astore_0
    //   183: ldc 172
    //   185: areturn
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_0
    //   189: aload_0
    //   190: ifnull +7 -> 197
    //   193: aload_0
    //   194: invokevirtual 213	java/io/FileInputStream:close	()V
    //   197: aload_2
    //   198: athrow
    //   199: astore_0
    //   200: goto -3 -> 197
    //   203: astore_2
    //   204: goto -15 -> 189
    //   207: astore_3
    //   208: aconst_null
    //   209: astore_2
    //   210: goto -117 -> 93
    //   213: ldc 172
    //   215: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramString	String
    //   73	13	1	i	int
    //   57	117	2	localFileInputStream	java.io.FileInputStream
    //   179	1	2	localIOException	IOException
    //   186	12	2	localObject1	Object
    //   203	1	2	localObject2	Object
    //   209	1	2	localObject3	Object
    //   39	45	3	localObject4	Object
    //   92	27	3	localException1	Exception
    //   150	19	3	localObject5	Object
    //   207	1	3	localException2	Exception
    //   47	110	4	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   60	66	92	java/lang/Exception
    //   68	74	92	java/lang/Exception
    //   81	89	92	java/lang/Exception
    //   145	151	92	java/lang/Exception
    //   156	165	92	java/lang/Exception
    //   60	66	142	java/lang/OutOfMemoryError
    //   173	177	179	java/io/IOException
    //   135	139	182	java/io/IOException
    //   42	58	186	finally
    //   193	197	199	java/io/IOException
    //   60	66	203	finally
    //   68	74	203	finally
    //   81	89	203	finally
    //   95	101	203	finally
    //   103	131	203	finally
    //   145	151	203	finally
    //   156	165	203	finally
    //   42	58	207	java/lang/Exception
  }
  
  static List<WeakReference<IPluginActivity>> getActivitys()
  {
    return sInstances;
  }
  
  public static ClassLoader getClassLoader(String paramString)
  {
    try
    {
      paramString = (DexClassLoader)sClassLoaderMap.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static ClassLoader getOrCreateClassLoader(Context paramContext, String paramString)
    throws Exception
  {
    try
    {
      ClassLoader localClassLoader2 = (ClassLoader)sClassLoaderMap.get(paramString);
      ClassLoader localClassLoader1 = localClassLoader2;
      if (localClassLoader2 == null) {
        localClassLoader1 = getOrCreateClassLoaderByPath(paramContext, paramString, PluginUtils.getInstalledPluginPath(paramContext, paramString).getCanonicalPath());
      }
      return localClassLoader1;
    }
    finally {}
  }
  
  /* Error */
  static ClassLoader getOrCreateClassLoaderByPath(Context paramContext, String paramString1, String paramString2)
    throws Exception
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 90	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 229	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 231	dalvik/system/DexClassLoader
    //   13: astore 8
    //   15: aload 8
    //   17: astore 7
    //   19: aload 8
    //   21: ifnonnull +272 -> 293
    //   24: ldc 164
    //   26: iconst_1
    //   27: new 195	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   34: ldc 253
    //   36: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   52: lstore_3
    //   53: aload_0
    //   54: invokestatic 266	com/tencent/mobileqq/pluginsdk/PluginUtils:getOptimizedDexPath	(Landroid/content/Context;)Ljava/io/File;
    //   57: invokevirtual 244	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   60: astore 8
    //   62: aload_0
    //   63: aload_1
    //   64: invokestatic 269	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginLibPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   67: invokevirtual 244	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   70: astore 9
    //   72: aload_2
    //   73: ldc_w 271
    //   76: invokevirtual 275	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   79: ifeq +220 -> 299
    //   82: new 277	com/tencent/commonsdk/soload/SoDexClassLoader
    //   85: dup
    //   86: aload_2
    //   87: aload 8
    //   89: aload 9
    //   91: aload_0
    //   92: invokevirtual 282	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   95: invokespecial 285	com/tencent/commonsdk/soload/SoDexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   98: astore 7
    //   100: getstatic 92	com/tencent/mobileqq/pluginsdk/PluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   103: aload_2
    //   104: invokevirtual 229	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 287	android/content/pm/PackageInfo
    //   110: astore 9
    //   112: aload 9
    //   114: astore 8
    //   116: aload 9
    //   118: ifnonnull +61 -> 179
    //   121: aload_0
    //   122: aload_2
    //   123: sipush 129
    //   126: invokestatic 293	com/tencent/mobileqq/pluginsdk/ApkFileParser:getPackageInfoWithException	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   129: astore_0
    //   130: aload_0
    //   131: ifnonnull +36 -> 167
    //   134: new 195	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 295
    //   144: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: new 147	java/io/File
    //   150: dup
    //   151: aload_2
    //   152: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   155: invokevirtual 154	java/io/File:exists	()Z
    //   158: invokevirtual 298	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   161: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 303	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   167: getstatic 92	com/tencent/mobileqq/pluginsdk/PluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   170: aload_2
    //   171: aload_0
    //   172: invokevirtual 307	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: aload_0
    //   177: astore 8
    //   179: getstatic 94	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderStartTimeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   182: aload_1
    //   183: invokevirtual 229	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   186: checkcast 309	java/lang/Long
    //   189: astore 9
    //   191: aload 9
    //   193: astore_0
    //   194: aload 9
    //   196: ifnonnull +21 -> 217
    //   199: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   202: lload_3
    //   203: lsub
    //   204: invokestatic 313	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   207: astore_0
    //   208: getstatic 94	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderStartTimeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   211: aload_1
    //   212: aload_0
    //   213: invokevirtual 307	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   216: pop
    //   217: getstatic 92	com/tencent/mobileqq/pluginsdk/PluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   220: aload_2
    //   221: aload 8
    //   223: invokevirtual 307	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   226: pop
    //   227: aload 8
    //   229: ifnull +11 -> 240
    //   232: aload 8
    //   234: aload_1
    //   235: aload 7
    //   237: invokestatic 317	com/tencent/mobileqq/pluginsdk/PluginStatic:invokePluginLife	(Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   240: ldc 164
    //   242: iconst_1
    //   243: new 195	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 319
    //   253: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_1
    //   257: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc_w 321
    //   263: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_0
    //   267: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 327	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: getstatic 333	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   279: aload_1
    //   280: invokevirtual 336	mqq/app/MobileQQ:loadModule	(Ljava/lang/String;)V
    //   283: getstatic 90	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   286: aload_1
    //   287: aload 7
    //   289: invokevirtual 307	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   292: pop
    //   293: ldc 2
    //   295: monitorexit
    //   296: aload 7
    //   298: areturn
    //   299: aload_1
    //   300: ldc_w 338
    //   303: invokevirtual 341	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   306: ifeq +73 -> 379
    //   309: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   312: lstore 5
    //   314: aload_0
    //   315: ldc_w 343
    //   318: invokestatic 345	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   321: astore 7
    //   323: ldc 164
    //   325: iconst_1
    //   326: new 195	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   333: ldc_w 347
    //   336: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   342: lload 5
    //   344: lsub
    //   345: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: new 352	com/tencent/mobileqq/pluginsdk/QZoneLiveClassLoader
    //   357: dup
    //   358: aload_2
    //   359: aload 8
    //   361: aload 9
    //   363: aload 7
    //   365: invokespecial 353	com/tencent/mobileqq/pluginsdk/QZoneLiveClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   368: astore 7
    //   370: goto -270 -> 100
    //   373: astore_0
    //   374: ldc 2
    //   376: monitorexit
    //   377: aload_0
    //   378: athrow
    //   379: aload_1
    //   380: ldc_w 355
    //   383: invokevirtual 341	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   386: ifeq +67 -> 453
    //   389: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   392: lstore 5
    //   394: aload_0
    //   395: ldc_w 343
    //   398: invokestatic 345	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   401: astore 7
    //   403: ldc 164
    //   405: iconst_1
    //   406: new 195	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 347
    //   416: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   422: lload 5
    //   424: lsub
    //   425: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   428: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: new 357	com/tencent/mobileqq/pluginsdk/QZoneVerticalVideoClassLoader
    //   437: dup
    //   438: aload_2
    //   439: aload 8
    //   441: aload 9
    //   443: aload 7
    //   445: invokespecial 358	com/tencent/mobileqq/pluginsdk/QZoneVerticalVideoClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   448: astore 7
    //   450: goto -350 -> 100
    //   453: aload_1
    //   454: ldc_w 360
    //   457: invokevirtual 341	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   460: ifeq +67 -> 527
    //   463: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   466: lstore 5
    //   468: aload_0
    //   469: ldc_w 343
    //   472: invokestatic 345	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   475: astore 7
    //   477: ldc 164
    //   479: iconst_1
    //   480: new 195	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   487: ldc_w 347
    //   490: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   496: lload 5
    //   498: lsub
    //   499: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   502: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: new 362	com/tencent/mobileqq/pluginsdk/QZoneWeishiFeedsClassLoader
    //   511: dup
    //   512: aload_2
    //   513: aload 8
    //   515: aload 9
    //   517: aload 7
    //   519: invokespecial 363	com/tencent/mobileqq/pluginsdk/QZoneWeishiFeedsClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   522: astore 7
    //   524: goto -424 -> 100
    //   527: aload_2
    //   528: ifnull +65 -> 593
    //   531: new 147	java/io/File
    //   534: dup
    //   535: aload_2
    //   536: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   539: invokevirtual 154	java/io/File:exists	()Z
    //   542: ifne +51 -> 593
    //   545: ldc 164
    //   547: iconst_1
    //   548: new 195	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   555: ldc_w 365
    //   558: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload_2
    //   562: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: new 231	dalvik/system/DexClassLoader
    //   574: dup
    //   575: ldc 172
    //   577: aload 8
    //   579: aload 9
    //   581: aload_0
    //   582: invokevirtual 282	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   585: invokespecial 366	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   588: astore 7
    //   590: goto -297 -> 293
    //   593: invokestatic 369	com/tencent/mobileqq/pluginsdk/PluginUtils:isOsNeedReleaseDex	()Z
    //   596: ifeq +150 -> 746
    //   599: invokestatic 375	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:getProxy	()Lcom/tencent/mobileqq/pluginsdk/IPluginAdapterProxy;
    //   602: aload_1
    //   603: invokevirtual 378	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:isSupportMultiDex	(Ljava/lang/String;)Z
    //   606: ifeq +140 -> 746
    //   609: aload_0
    //   610: aload_1
    //   611: invokestatic 381	com/tencent/mobileqq/pluginsdk/PluginUtils:getMultiDexSecondDex	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   614: astore 7
    //   616: aload 7
    //   618: invokevirtual 154	java/io/File:exists	()Z
    //   621: ifeq +125 -> 746
    //   624: new 195	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   631: aload_2
    //   632: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: getstatic 384	java/io/File:pathSeparator	Ljava/lang/String;
    //   638: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload 7
    //   643: invokevirtual 387	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   646: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: astore 7
    //   654: ldc 164
    //   656: iconst_1
    //   657: new 195	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   664: ldc_w 389
    //   667: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload 7
    //   672: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   681: ldc 164
    //   683: iconst_1
    //   684: new 195	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   691: ldc_w 391
    //   694: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload 7
    //   699: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: new 231	dalvik/system/DexClassLoader
    //   711: dup
    //   712: aload 7
    //   714: aload 8
    //   716: aload 9
    //   718: aload_0
    //   719: invokevirtual 282	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   722: invokespecial 366	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   725: astore 7
    //   727: goto -627 -> 100
    //   730: astore_0
    //   731: ldc 164
    //   733: ldc_w 393
    //   736: aload_0
    //   737: invokestatic 396	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   740: aload 9
    //   742: astore_0
    //   743: goto -613 -> 130
    //   746: aload_2
    //   747: astore 7
    //   749: goto -68 -> 681
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	752	0	paramContext	Context
    //   0	752	1	paramString1	String
    //   0	752	2	paramString2	String
    //   52	151	3	l1	long
    //   312	185	5	l2	long
    //   17	731	7	localObject1	Object
    //   13	702	8	localObject2	Object
    //   70	671	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	373	finally
    //   24	100	373	finally
    //   100	112	373	finally
    //   121	130	373	finally
    //   134	167	373	finally
    //   167	176	373	finally
    //   179	191	373	finally
    //   199	217	373	finally
    //   217	227	373	finally
    //   232	240	373	finally
    //   240	293	373	finally
    //   299	370	373	finally
    //   379	450	373	finally
    //   453	524	373	finally
    //   531	590	373	finally
    //   593	681	373	finally
    //   681	727	373	finally
    //   731	740	373	finally
    //   121	130	730	java/lang/Throwable
  }
  
  static void invokePluginLife(PackageInfo paramPackageInfo, String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      if ((IPluginLife)sLife.get(paramString) != null) {
        return;
      }
      if ((paramPackageInfo != null) && (paramPackageInfo.applicationInfo != null) && (paramPackageInfo.applicationInfo.metaData != null))
      {
        paramPackageInfo = paramPackageInfo.applicationInfo.metaData.getString("PLUGIN_LIFE_CLASS");
        if (paramPackageInfo != null)
        {
          paramPackageInfo = (IPluginLife)paramClassLoader.loadClass(paramPackageInfo).newInstance();
          sLife.put(paramString, paramPackageInfo);
          paramPackageInfo.onLoad();
          return;
        }
      }
    }
    catch (Throwable paramPackageInfo) {}
  }
  
  public static List<Boolean> isProcessesExist(Context paramContext, List<String> paramList)
  {
    ArrayList localArrayList = null;
    if (paramList != null)
    {
      localArrayList = new ArrayList();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext == null)
      {
        int i = 0;
        while (i < paramList.size())
        {
          localArrayList.add(Boolean.FALSE);
          i += 1;
        }
      }
    }
    else
    {
      return localArrayList;
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Iterator localIterator = paramContext.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!str.equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName));
      for (boolean bool = true;; bool = false)
      {
        localArrayList.add(Boolean.valueOf(bool));
        break;
      }
    }
    return localArrayList;
  }
  
  private static boolean isSubFile(String paramString, File paramFile)
    throws IOException
  {
    paramFile = paramFile.getCanonicalPath();
    String str = new File(paramString).getParentFile().getCanonicalPath();
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "path:" + paramString + "-> [" + str + ", " + paramFile + "]");
    }
    return str.equals(paramFile);
  }
  
  static boolean isValidPluginIntent(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return false;
      try
      {
        String str = paramBundle.getString("pluginsdk_pluginLocation");
        if ((!TextUtils.isEmpty(str)) && (!str.substring(0, str.lastIndexOf(".")).contains(".")) && (!TextUtils.isEmpty(paramBundle.getString("pluginsdk_pluginName"))))
        {
          paramBundle = paramBundle.getString("pluginsdk_pluginpath");
          if (!TextUtils.isEmpty(paramBundle))
          {
            if (TextUtils.isEmpty(paramBundle)) {
              return true;
            }
            boolean bool = isValidPluginPath(paramBundle);
            return bool;
          }
        }
      }
      catch (Throwable paramBundle) {}
    }
    return false;
  }
  
  static boolean isValidPluginPath(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (paramString.contains("..")) {
        return bool1;
      }
      if (paramString.endsWith(".so"))
      {
        String str = MobileQQ.getContext().getFilesDir().getParent();
        File localFile = new File(str + "/txlib/");
        if ((isSubFile(paramString, new File(str + "/lib/"))) || (!isSubFile(paramString, localFile))) {}
      }
      else
      {
        bool1 = bool2;
        if (!paramString.endsWith(".apk")) {
          return bool1;
        }
        bool1 = isSubFile(paramString, PluginUtils.getPluginInstallDir(MobileQQ.getContext()));
        return bool1;
      }
    }
    catch (Exception paramString)
    {
      return false;
    }
    bool1 = true;
    return bool1;
  }
  
  static void remove(IPluginActivity paramIPluginActivity)
  {
    updateReference();
    removeActivity(paramIPluginActivity);
  }
  
  private static boolean removeActivity(IPluginActivity paramIPluginActivity)
  {
    ArrayList localArrayList = sInstances;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < sInstances.size())
        {
          if (((WeakReference)sInstances.get(i)).get() == paramIPluginActivity)
          {
            sInstances.remove(i);
            return true;
          }
        }
        else {
          return false;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public static ClassLoader removeClassLoader(String paramString)
  {
    try
    {
      QLog.d("plugin_tag", 1, "removeClassLoader:" + paramString);
      paramString = (ClassLoader)sClassLoaderMap.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static void updateReference()
  {
    ArrayList localArrayList = sInstances;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < sInstances.size())
        {
          if (((WeakReference)sInstances.get(i)).get() == null)
          {
            sInstances.remove(i);
            i -= 1;
          }
        }
        else {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public static abstract interface IPluginLife
  {
    public abstract void onLoad();
    
    @Deprecated
    public abstract void onUnload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginStatic
 * JD-Core Version:    0.7.0.1
 */