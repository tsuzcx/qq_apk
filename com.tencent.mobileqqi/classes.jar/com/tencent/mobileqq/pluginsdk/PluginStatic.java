package com.tencent.mobileqq.pluginsdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public abstract class PluginStatic
{
  static final String CONTAINER_PACKAGE_NAME = "com.tencent.mobileqqi";
  public static final String PARAM_CLASS_STATISTICS_UPLOADER = "clsUploader";
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
  public static final int USER_QQ_RESOURCES_NO = -1;
  public static final int USER_QQ_RESOURCES_YES = 1;
  static final HashMap<String, DexClassLoader> sClassLoaderMap = new HashMap();
  private static ArrayList<WeakReference<IPluginActivity>> sInstances = new ArrayList();
  static final ConcurrentHashMap<String, PackageInfo> sPackageInfoMap = new ConcurrentHashMap();
  
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
    //   0: ldc 131
    //   2: astore_2
    //   3: new 133	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 140	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_0
    //   20: invokevirtual 143	java/io/File:isFile	()Z
    //   23: ifne +6 -> 29
    //   26: ldc 131
    //   28: areturn
    //   29: ldc 145
    //   31: invokestatic 151	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   34: astore_3
    //   35: new 153	java/io/FileInputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 156	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: astore 4
    //   45: sipush 1024
    //   48: newarray byte
    //   50: astore 5
    //   52: aconst_null
    //   53: astore_0
    //   54: aload 4
    //   56: aload 5
    //   58: invokevirtual 160	java/io/FileInputStream:read	([B)I
    //   61: istore_1
    //   62: iload_1
    //   63: iconst_m1
    //   64: if_icmpeq +27 -> 91
    //   67: aload_3
    //   68: aload 5
    //   70: iconst_0
    //   71: iload_1
    //   72: invokevirtual 164	java/security/MessageDigest:update	([BII)V
    //   75: goto -21 -> 54
    //   78: astore_3
    //   79: aload 4
    //   81: invokevirtual 167	java/io/FileInputStream:close	()V
    //   84: aload_0
    //   85: invokestatic 169	com/tencent/mobileqq/pluginsdk/PluginStatic:byteArrayToHex	([B)Ljava/lang/String;
    //   88: astore_0
    //   89: aload_0
    //   90: areturn
    //   91: aload_3
    //   92: invokevirtual 173	java/security/MessageDigest:digest	()[B
    //   95: astore_3
    //   96: aload_3
    //   97: astore_0
    //   98: aload 4
    //   100: invokevirtual 167	java/io/FileInputStream:close	()V
    //   103: goto -19 -> 84
    //   106: astore_3
    //   107: aload_3
    //   108: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   111: goto -27 -> 84
    //   114: astore_3
    //   115: aload_3
    //   116: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   119: goto -35 -> 84
    //   122: astore_0
    //   123: aload 4
    //   125: invokevirtual 167	java/io/FileInputStream:close	()V
    //   128: aload_0
    //   129: athrow
    //   130: astore_3
    //   131: aload_3
    //   132: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   135: goto -7 -> 128
    //   138: astore_0
    //   139: aload_2
    //   140: astore_0
    //   141: goto -52 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramString	String
    //   61	11	1	i	int
    //   2	138	2	str	String
    //   34	34	3	localMessageDigest	java.security.MessageDigest
    //   78	14	3	localIOException1	java.io.IOException
    //   95	2	3	arrayOfByte1	byte[]
    //   106	2	3	localIOException2	java.io.IOException
    //   114	2	3	localIOException3	java.io.IOException
    //   130	2	3	localIOException4	java.io.IOException
    //   43	81	4	localFileInputStream	java.io.FileInputStream
    //   50	19	5	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   54	62	78	java/io/IOException
    //   67	75	78	java/io/IOException
    //   91	96	78	java/io/IOException
    //   98	103	106	java/io/IOException
    //   79	84	114	java/io/IOException
    //   54	62	122	finally
    //   67	75	122	finally
    //   91	96	122	finally
    //   123	128	130	java/io/IOException
    //   29	52	138	java/lang/Exception
    //   79	84	138	java/lang/Exception
    //   84	89	138	java/lang/Exception
    //   98	103	138	java/lang/Exception
    //   107	111	138	java/lang/Exception
    //   115	119	138	java/lang/Exception
    //   123	128	138	java/lang/Exception
    //   128	130	138	java/lang/Exception
    //   131	135	138	java/lang/Exception
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
      paramContext = getOrCreateClassLoaderByPath(paramContext, paramString, PluginUtils.getInstallPath(paramContext, paramString).getCanonicalPath());
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static ClassLoader getOrCreateClassLoaderByPath(Context paramContext, String paramString1, String paramString2)
    throws Exception
  {
    try
    {
      DexClassLoader localDexClassLoader2 = (DexClassLoader)sClassLoaderMap.get(paramString1);
      DexClassLoader localDexClassLoader1 = localDexClassLoader2;
      if (localDexClassLoader2 == null)
      {
        localDexClassLoader1 = new DexClassLoader(paramString2, PluginUtils.getOptimizedDexPath(paramContext).getCanonicalPath(), PluginUtils.getLibPath(paramContext).getCanonicalPath(), paramContext.getClassLoader());
        sClassLoaderMap.put(paramString1, localDexClassLoader1);
      }
      return localDexClassLoader1;
    }
    finally {}
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
  
  static boolean isValidPluginIntent(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return false;
      try
      {
        if ((!TextUtils.isEmpty(paramBundle.getString("pluginsdk_pluginLocation"))) && (!TextUtils.isEmpty(paramBundle.getString("pluginsdk_pluginName"))))
        {
          paramBundle = paramBundle.getString("pluginsdk_pluginpath");
          if (!TextUtils.isEmpty(paramBundle))
          {
            boolean bool = paramBundle.startsWith(MobileQQ.getContext().getFilesDir().getCanonicalFile().getParent());
            if (!bool) {}
          }
          else
          {
            return true;
          }
        }
      }
      catch (Exception paramBundle) {}
    }
    return false;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginStatic
 * JD-Core Version:    0.7.0.1
 */