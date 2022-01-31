package com.tencent.mobileqq.pluginsdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
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
  static final HashMap<String, DexClassLoader> sClassLoaderMap;
  private static ArrayList<WeakReference<IPluginActivity>> sInstances = new ArrayList();
  private static final HashMap<String, IPluginLife> sLife = new HashMap();
  static final ConcurrentHashMap<String, PackageInfo> sPackageInfoMap;
  
  static
  {
    sClassLoaderMap = new HashMap();
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
    char[] arrayOfChar1 = new char[16];
    char[] tmp8_6 = arrayOfChar1;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 65;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 66;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 67;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 68;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 69;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 70;
    tmp92_86;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int i = 0;
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
    //   0: ldc 143
    //   2: astore 4
    //   4: new 145	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore 6
    //   14: aload 6
    //   16: invokevirtual 152	java/io/File:exists	()Z
    //   19: ifeq +11 -> 30
    //   22: aload 6
    //   24: invokevirtual 155	java/io/File:isFile	()Z
    //   27: ifne +20 -> 47
    //   30: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +11 -> 44
    //   36: ldc 162
    //   38: iconst_2
    //   39: ldc 164
    //   41: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: ldc 143
    //   46: areturn
    //   47: aconst_null
    //   48: astore_2
    //   49: aconst_null
    //   50: astore 5
    //   52: aload_2
    //   53: astore_0
    //   54: ldc 170
    //   56: invokestatic 176	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   59: astore_3
    //   60: aload_2
    //   61: astore_0
    //   62: new 178	java/io/FileInputStream
    //   65: dup
    //   66: aload 6
    //   68: invokespecial 181	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore_2
    //   72: sipush 16384
    //   75: newarray byte
    //   77: astore_0
    //   78: aload_2
    //   79: aload_0
    //   80: invokevirtual 185	java/io/FileInputStream:read	([B)I
    //   83: istore_1
    //   84: iload_1
    //   85: iconst_m1
    //   86: if_icmpeq +78 -> 164
    //   89: aload_3
    //   90: aload_0
    //   91: iconst_0
    //   92: iload_1
    //   93: invokevirtual 189	java/security/MessageDigest:update	([BII)V
    //   96: goto -18 -> 78
    //   99: astore_3
    //   100: aload_2
    //   101: astore_0
    //   102: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +33 -> 138
    //   108: aload_2
    //   109: astore_0
    //   110: ldc 162
    //   112: iconst_2
    //   113: new 191	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   120: ldc 194
    //   122: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_3
    //   126: invokestatic 202	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   129: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload 4
    //   140: astore_0
    //   141: aload_2
    //   142: ifnull +10 -> 152
    //   145: aload_2
    //   146: invokevirtual 209	java/io/FileInputStream:close	()V
    //   149: aload 4
    //   151: astore_0
    //   152: aload_0
    //   153: areturn
    //   154: astore_0
    //   155: sipush 4096
    //   158: newarray byte
    //   160: astore_0
    //   161: goto -83 -> 78
    //   164: aload_3
    //   165: invokevirtual 213	java/security/MessageDigest:digest	()[B
    //   168: invokestatic 215	com/tencent/mobileqq/pluginsdk/PluginStatic:byteArrayToHex	([B)Ljava/lang/String;
    //   171: astore_0
    //   172: aload_2
    //   173: ifnull +51 -> 224
    //   176: aload_2
    //   177: invokevirtual 209	java/io/FileInputStream:close	()V
    //   180: goto -28 -> 152
    //   183: astore_2
    //   184: goto -32 -> 152
    //   187: astore_0
    //   188: aload 4
    //   190: astore_0
    //   191: goto -39 -> 152
    //   194: astore_2
    //   195: aload_0
    //   196: ifnull +7 -> 203
    //   199: aload_0
    //   200: invokevirtual 209	java/io/FileInputStream:close	()V
    //   203: aload_2
    //   204: athrow
    //   205: astore_0
    //   206: goto -3 -> 203
    //   209: astore_3
    //   210: aload_2
    //   211: astore_0
    //   212: aload_3
    //   213: astore_2
    //   214: goto -19 -> 195
    //   217: astore_3
    //   218: aload 5
    //   220: astore_2
    //   221: goto -121 -> 100
    //   224: goto -72 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramString	String
    //   83	10	1	i	int
    //   48	129	2	localFileInputStream	java.io.FileInputStream
    //   183	1	2	localIOException	IOException
    //   194	17	2	localObject1	Object
    //   213	8	2	localObject2	Object
    //   59	31	3	localMessageDigest	java.security.MessageDigest
    //   99	66	3	localException1	Exception
    //   209	4	3	localObject3	Object
    //   217	1	3	localException2	Exception
    //   2	187	4	str	String
    //   50	169	5	localObject4	Object
    //   12	55	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   72	78	99	java/lang/Exception
    //   78	84	99	java/lang/Exception
    //   89	96	99	java/lang/Exception
    //   155	161	99	java/lang/Exception
    //   164	172	99	java/lang/Exception
    //   72	78	154	java/lang/OutOfMemoryError
    //   176	180	183	java/io/IOException
    //   145	149	187	java/io/IOException
    //   54	60	194	finally
    //   62	72	194	finally
    //   102	108	194	finally
    //   110	138	194	finally
    //   199	203	205	java/io/IOException
    //   72	78	209	finally
    //   78	84	209	finally
    //   89	96	209	finally
    //   155	161	209	finally
    //   164	172	209	finally
    //   54	60	217	java/lang/Exception
    //   62	72	217	java/lang/Exception
  }
  
  static List<WeakReference<IPluginActivity>> getActivitys()
  {
    return sInstances;
  }
  
  static ClassLoader getClassLoader(String paramString)
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
    //   3: getstatic 85	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderMap	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 225	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 227	dalvik/system/DexClassLoader
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: aload 4
    //   20: ifnonnull +78 -> 98
    //   23: aload_0
    //   24: invokestatic 249	com/tencent/mobileqq/pluginsdk/PluginUtils:getOptimizedDexPath	(Landroid/content/Context;)Ljava/io/File;
    //   27: invokevirtual 240	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   30: astore_3
    //   31: aload_0
    //   32: aload_1
    //   33: invokestatic 252	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginLibPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   36: invokevirtual 240	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   39: astore 4
    //   41: aload_2
    //   42: ldc 254
    //   44: invokevirtual 258	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   47: ifeq +56 -> 103
    //   50: new 260	com/tencent/commonsdk/soload/SoDexClassLoader
    //   53: dup
    //   54: aload_2
    //   55: aload_3
    //   56: aload 4
    //   58: aload_0
    //   59: invokevirtual 265	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   62: invokespecial 268	com/tencent/commonsdk/soload/SoDexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   65: astore_0
    //   66: getstatic 90	com/tencent/mobileqq/pluginsdk/PluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: aload_2
    //   70: invokevirtual 269	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 271	android/content/pm/PackageInfo
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +9 -> 87
    //   81: aload_2
    //   82: aload_1
    //   83: aload_0
    //   84: invokestatic 275	com/tencent/mobileqq/pluginsdk/PluginStatic:invokePluginLife	(Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   87: getstatic 85	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderMap	Ljava/util/HashMap;
    //   90: aload_1
    //   91: aload_0
    //   92: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: aload_0
    //   97: astore_3
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_3
    //   102: areturn
    //   103: new 227	dalvik/system/DexClassLoader
    //   106: dup
    //   107: aload_2
    //   108: aload_3
    //   109: aload 4
    //   111: aload_0
    //   112: invokevirtual 265	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   115: invokespecial 280	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   118: astore_0
    //   119: goto -53 -> 66
    //   122: astore_0
    //   123: ldc 2
    //   125: monitorexit
    //   126: aload_0
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramContext	Context
    //   0	128	1	paramString1	String
    //   0	128	2	paramString2	String
    //   17	92	3	localObject1	Object
    //   13	97	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	122	finally
    //   23	66	122	finally
    //   66	77	122	finally
    //   81	87	122	finally
    //   87	96	122	finally
    //   103	119	122	finally
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
    Object localObject = null;
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext == null)
      {
        int i = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i >= paramList.size()) {
            break;
          }
          localArrayList.add(Boolean.FALSE);
          i += 1;
        }
      }
      paramList = paramList.iterator();
      for (;;)
      {
        localObject = localArrayList;
        if (!paramList.hasNext()) {
          break;
        }
        localObject = (String)paramList.next();
        boolean bool2 = false;
        Iterator localIterator = paramContext.iterator();
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((String)localObject).equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName));
        boolean bool1 = true;
        localArrayList.add(Boolean.valueOf(bool1));
      }
    }
    return localObject;
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
    boolean bool;
    for (;;)
    {
      return false;
      try
      {
        String str = paramBundle.getString("pluginsdk_pluginLocation");
        if ((!TextUtils.isEmpty(str)) && (!str.substring(0, str.lastIndexOf(".")).contains(".")) && (!TextUtils.isEmpty(paramBundle.getString("pluginsdk_pluginName"))))
        {
          paramBundle = paramBundle.getString("pluginsdk_pluginpath");
          if (!TextUtils.isEmpty(paramBundle)) {
            if (TextUtils.isEmpty(paramBundle)) {
              bool = true;
            } else {
              bool = isValidPluginPath(paramBundle);
            }
          }
        }
      }
      catch (Throwable paramBundle)
      {
        return false;
      }
    }
    return bool;
  }
  
  static boolean isValidPluginPath(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!paramString.contains("..")) {
        if (paramString.endsWith(".so"))
        {
          String str = MobileQQ.getContext().getFilesDir().getParent();
          File localFile = new File(str + "/txlib/");
          if (!isSubFile(paramString, new File(str + "/lib/"))) {
            if (!isSubFile(paramString, localFile)) {
              break label140;
            }
          }
        }
        else
        {
          bool1 = bool2;
          if (!paramString.endsWith(".apk")) {
            break label138;
          }
          bool1 = isSubFile(paramString, PluginUtils.getPluginInstallDir(MobileQQ.getContext()));
          return bool1;
        }
      }
    }
    catch (Exception paramString)
    {
      return false;
    }
    label138:
    label140:
    for (;;)
    {
      bool1 = true;
      return bool1;
    }
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
  
  static void updateReference()
  {
    ArrayList localArrayList = sInstances;
    int j;
    for (int i = 0;; i = j + 1) {
      try
      {
        if (i < sInstances.size())
        {
          j = i;
          if (((WeakReference)sInstances.get(i)).get() == null)
          {
            sInstances.remove(i);
            j = i - 1;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
    }
  }
  
  public static abstract interface IPluginLife
  {
    public abstract void onLoad();
    
    @Deprecated
    public abstract void onUnload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginStatic
 * JD-Core Version:    0.7.0.1
 */