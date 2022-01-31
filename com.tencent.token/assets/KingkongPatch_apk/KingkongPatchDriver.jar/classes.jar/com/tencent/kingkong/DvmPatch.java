package com.tencent.kingkong;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.kingkong.xposed.XposedBridge;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

public class DvmPatch
  extends Patch
{
  private static final String LOG_TAG = "KingKongDvmPatch";
  private static final String TAG_BASIC_CONFIG = "basic_config";
  private static final String TAG_CLASS_NAME = "class_name";
  private static final String TAG_PATCH_NAME = "name";
  private static final String TAG_TYPE = "type";
  private static final String TAG_VERSION = "ver";
  private static boolean isCheckedDeviceSupport = false;
  private static boolean isDeviceSupportDVM = false;
  private String mClassName = "";
  
  public DvmPatch(String paramString1, String paramString2)
  {
    this.mPath = paramString1;
    this.mPatchName = paramString2;
  }
  
  public static Patch CreatePatch(String paramString, PatchInfo paramPatchInfo)
  {
    paramString = new DvmPatch(paramString, paramPatchInfo.mPatchName);
    if (paramString.parseConfig(paramString.getConfigFileName())) {
      return paramString;
    }
    return null;
  }
  
  public static String getProperty(String paramString)
    throws IOException
  {
    Object localObject1 = new ProcessBuilder(new String[] { "getprop", paramString }).start();
    paramString = null;
    try
    {
      localObject1 = new Scanner(((Process)localObject1).getInputStream());
      if (paramString == null) {
        break label62;
      }
    }
    finally
    {
      try
      {
        paramString = ((Scanner)localObject1).nextLine();
        if (localObject1 != null) {
          ((Scanner)localObject1).close();
        }
        return paramString;
      }
      finally
      {
        paramString = localObject2;
        Object localObject3 = localObject4;
      }
      localObject2 = finally;
    }
    paramString.close();
    label62:
    throw localObject2;
  }
  
  private static boolean isArm64CPU()
  {
    try
    {
      getProperty("ro.product.cpu.abi");
      return false;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private static boolean isArtandkk()
  {
    if (Build.VERSION.SDK_INT == 19) {
      try
      {
        boolean bool = getProperty("persist.sys.dalvik.vm.lib").contains("art");
        if (bool) {
          return true;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    Common.Log.d("KingKongDvmPatch", "===isArtandkk : false");
    return false;
  }
  
  /* Error */
  public static boolean isDeviceSupportDVM()
  {
    // Byte code:
    //   0: getstatic 31	com/tencent/kingkong/DvmPatch:isCheckedDeviceSupport	Z
    //   3: ifeq +36 -> 39
    //   6: getstatic 33	com/tencent/kingkong/DvmPatch:isDeviceSupportDVM	Z
    //   9: istore_0
    //   10: ldc 8
    //   12: new 131	java/lang/StringBuilder
    //   15: dup
    //   16: ldc 133
    //   18: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: getstatic 33	com/tencent/kingkong/DvmPatch:isDeviceSupportDVM	Z
    //   24: invokevirtual 140	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 129	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: iconst_1
    //   34: putstatic 31	com/tencent/kingkong/DvmPatch:isCheckedDeviceSupport	Z
    //   37: iload_0
    //   38: ireturn
    //   39: invokestatic 145	com/tencent/kingkong/DvmPatch:isArtandkk	()Z
    //   42: ifne +50 -> 92
    //   45: invokestatic 148	com/tencent/kingkong/DvmPatch:isX86CPU	()Z
    //   48: ifne +44 -> 92
    //   51: invokestatic 151	com/tencent/kingkong/DvmPatch:isYunOS	()Z
    //   54: ifne +38 -> 92
    //   57: iconst_1
    //   58: putstatic 33	com/tencent/kingkong/DvmPatch:isDeviceSupportDVM	Z
    //   61: ldc 8
    //   63: new 131	java/lang/StringBuilder
    //   66: dup
    //   67: ldc 133
    //   69: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: getstatic 33	com/tencent/kingkong/DvmPatch:isDeviceSupportDVM	Z
    //   75: invokevirtual 140	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   78: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 129	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: iconst_1
    //   85: putstatic 31	com/tencent/kingkong/DvmPatch:isCheckedDeviceSupport	Z
    //   88: getstatic 33	com/tencent/kingkong/DvmPatch:isDeviceSupportDVM	Z
    //   91: ireturn
    //   92: iconst_0
    //   93: putstatic 33	com/tencent/kingkong/DvmPatch:isDeviceSupportDVM	Z
    //   96: goto -35 -> 61
    //   99: astore_1
    //   100: ldc 8
    //   102: new 131	java/lang/StringBuilder
    //   105: dup
    //   106: ldc 133
    //   108: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: getstatic 33	com/tencent/kingkong/DvmPatch:isDeviceSupportDVM	Z
    //   114: invokevirtual 140	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   117: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 129	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: iconst_1
    //   124: putstatic 31	com/tencent/kingkong/DvmPatch:isCheckedDeviceSupport	Z
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	29	0	bool	boolean
    //   99	29	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	10	99	finally
    //   39	61	99	finally
    //   92	96	99	finally
  }
  
  private static boolean isX86CPU()
  {
    try
    {
      boolean bool = getProperty("ro.product.cpu.abi").contains("x86");
      if (bool) {
        return true;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      Common.Log.d("KingKongDvmPatch", "===isX86CPU : false");
    }
    return false;
  }
  
  @SuppressLint({"DefaultLocale"})
  private static boolean isYunOS()
  {
    String str2 = null;
    Object localObject10 = null;
    Object localObject11 = null;
    String str1 = null;
    localObject9 = null;
    localObject5 = str1;
    localObject6 = str2;
    localObject7 = localObject10;
    localObject8 = localObject11;
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      localObject5 = str1;
      localObject6 = str2;
      localObject7 = localObject10;
      localObject8 = localObject11;
      str1 = (String)localMethod.invoke(null, new Object[] { "ro.yunos.version" });
      localObject5 = str1;
      localObject6 = str1;
      localObject7 = str1;
      localObject8 = str1;
      str2 = (String)localMethod.invoke(null, new Object[] { "java.vm.name" });
      localObject5 = str2;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Object localObject1 = localObject5;
        localObject5 = localObject9;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Object localObject2 = localObject6;
        localObject5 = localObject9;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject3 = localObject7;
        localObject5 = localObject9;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Object localObject4 = localObject8;
        localObject5 = localObject9;
      }
    }
    localObject7 = new StringBuilder("isYunOS-s1 = ");
    if (str1 == null)
    {
      localObject6 = "";
      Common.Log.d("KingKongDvmPatch", (String)localObject6);
      localObject7 = new StringBuilder("isYunOS-s2 = ");
      if (localObject5 != null) {
        break label207;
      }
    }
    label207:
    for (localObject6 = "";; localObject6 = localObject5)
    {
      Common.Log.d("KingKongDvmPatch", (String)localObject6);
      if (((localObject5 == null) || (!((String)localObject5).toLowerCase().contains("lemur"))) && ((str1 == null) || (str1.trim().length() <= 0))) {
        break label212;
      }
      return true;
      localObject6 = str1;
      break;
    }
    label212:
    Common.Log.d("KingKongDvmPatch", "===isYunOS : false");
    return false;
  }
  
  private boolean parseConfig(String paramString)
  {
    paramString = Utils.ReadFileToString(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      this.mPatchName = paramString.getString("name");
      this.mPatchVersion = paramString.getString("ver");
      this.mPatchType = paramString.getString("type");
      this.mClassName = paramString.getJSONObject("basic_config").getString("class_name").trim();
      Common.Log.d("KingKongDvmPatch", "--> Hookpoint Class Name : " + this.mClassName);
      return true;
    }
    catch (JSONException paramString)
    {
      Common.Log.d("KingKongDvmPatch", "Parse dvm config failed : " + paramString);
    }
    return false;
  }
  
  public int doPatch(Context paramContext)
  {
    return XposedBridge.doPatch(paramContext, this.mPath, this.mPatchName, this.mPatchType, this.mPatchVersion, this.mClassName);
  }
  
  public boolean generateInstallFiles()
  {
    return true;
  }
  
  public boolean initPatch()
  {
    return XposedBridge.initPatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.DvmPatch
 * JD-Core Version:    0.7.0.1
 */