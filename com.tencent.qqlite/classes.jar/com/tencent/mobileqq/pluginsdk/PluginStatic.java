package com.tencent.mobileqq.pluginsdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class PluginStatic
{
  static final String CONTAINER_PACKAGE_NAME = "com.tencent.mobileqq";
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
  
  public static String encodeFile(String paramString)
  {
    str = "";
    paramString = new File(paramString);
    if ((!paramString.exists()) || (!paramString.isFile())) {
      return "";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      try
      {
        paramString = new byte[16384];
        localObject = null;
      }
      catch (OutOfMemoryError paramString)
      {
        try
        {
          for (;;)
          {
            int i = localFileInputStream.read(paramString);
            if (i == -1) {
              break;
            }
            localMessageDigest.update(paramString, 0, i);
          }
        }
        catch (IOException paramString)
        {
          Object localObject;
          paramString = paramString;
          for (;;)
          {
            try
            {
              localFileInputStream.close();
              paramString = localObject;
            }
            catch (IOException paramString)
            {
              paramString.printStackTrace();
              paramString = localIOException1;
              continue;
            }
            paramString = byteArrayToHex(paramString);
            break label151;
            paramString = paramString;
            paramString = new byte[4096];
            break;
            paramString = localMessageDigest.digest();
            try
            {
              localFileInputStream.close();
            }
            catch (IOException localIOException1)
            {
              localIOException1.printStackTrace();
            }
          }
        }
        finally {}
      }
      try
      {
        localFileInputStream.close();
        throw paramString;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label151:
        paramString = str;
      }
    }
    return paramString;
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
        String str = paramBundle.getString("pluginsdk_pluginLocation");
        if ((!TextUtils.isEmpty(str)) && (!str.substring(0, str.lastIndexOf(".")).contains(".")))
        {
          boolean bool = TextUtils.isEmpty(paramBundle.getString("pluginsdk_pluginName"));
          if (!bool) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginStatic
 * JD-Core Version:    0.7.0.1
 */