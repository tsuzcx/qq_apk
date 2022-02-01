package com.tencent.camerasdk.avreporter;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Process;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppInfo
{
  private static final String TAG = "MobileBase-AppInfo";
  private static final String UNKNOWN_INFO = "unknown";
  private static ActivityManager activityManager;
  
  private static String byte2Hex(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase();
  }
  
  @SuppressLint({"PackageManagerGetSignatures"})
  public static String getApkCertificate(Context paramContext)
  {
    Object localObject = getPackageName(paramContext);
    if (localObject == null) {}
    for (;;)
    {
      return null;
      paramContext = paramContext.getPackageManager();
      if (paramContext != null) {
        try
        {
          paramContext = paramContext.getPackageInfo((String)localObject, 64);
          if (paramContext != null)
          {
            localObject = paramContext.signatures;
            if ((localObject != null) && (localObject.length != 0)) {
              return getSignature(paramContext.signatures[0].toByteArray());
            }
          }
        }
        catch (PackageManager.NameNotFoundException paramContext) {}
      }
    }
    return null;
  }
  
  public static String getAppName(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return null;
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        paramContext = paramContext.getApplicationInfo();
        if ((localPackageManager != null) && (paramContext != null))
        {
          paramContext = localPackageManager.getApplicationLabel(paramContext);
          if (paramContext != null)
          {
            paramContext = paramContext.toString();
            return paramContext;
          }
        }
      }
      catch (Throwable paramContext)
      {
        LogUtils.e("MobileBase-AppInfo", "getAppName error", paramContext);
      }
    }
    return null;
  }
  
  public static String getCurProcessName(Context paramContext)
  {
    if (paramContext != null)
    {
      int i = Process.myPid();
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null) {
        try
        {
          paramContext = paramContext.getRunningAppProcesses();
          if (paramContext != null)
          {
            paramContext = paramContext.iterator();
            while (paramContext.hasNext())
            {
              ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
              if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.pid == i)) {
                return localRunningAppProcessInfo.processName;
              }
            }
          }
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            LogUtils.e("MobileBase-AppInfo", "Exception occurred when getting process name.", paramContext);
            paramContext = null;
          }
        }
      }
    }
    return null;
  }
  
  public static Map<String, String> getManifestMetadata(Context paramContext, Set<String> paramSet)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return null;
      localHashMap = new HashMap();
      try
      {
        Object localObject1 = paramContext.getPackageManager();
        if (localObject1 == null) {
          continue;
        }
        paramContext = ((PackageManager)localObject1).getApplicationInfo(paramContext.getPackageName(), 128);
        if (paramContext.metaData != null)
        {
          paramSet = paramSet.iterator();
          while (paramSet.hasNext())
          {
            localObject1 = (String)paramSet.next();
            Object localObject2 = paramContext.metaData.get((String)localObject1);
            if (localObject2 != null) {
              localHashMap.put(localObject1, localObject2.toString());
            }
          }
        }
        return localHashMap;
      }
      catch (Throwable paramContext)
      {
        LogUtils.e("MobileBase-AppInfo", "getManifestMetaDatas error", paramContext);
      }
    }
  }
  
  public static PackageInfo getPackageInfo(Context paramContext)
  {
    try
    {
      String str = getPackageName(paramContext);
      paramContext = paramContext.getPackageManager();
      if (paramContext != null)
      {
        paramContext = paramContext.getPackageInfo(str, 0);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      LogUtils.e("MobileBase-AppInfo", "getPackageInfo error", paramContext);
    }
    return null;
  }
  
  public static String getPackageName(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageName();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      LogUtils.e("MobileBase-AppInfo", "getPackageName error", paramContext);
    }
    return "fail";
  }
  
  /* Error */
  public static String getProcessName(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 199	java/io/FileReader
    //   5: dup
    //   6: new 24	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   13: ldc 201
    //   15: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload_1
    //   19: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc 206
    //   24: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 209	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   33: astore_3
    //   34: aload_3
    //   35: astore_0
    //   36: sipush 512
    //   39: newarray char
    //   41: astore 4
    //   43: aload_3
    //   44: astore_0
    //   45: aload_3
    //   46: aload 4
    //   48: invokevirtual 213	java/io/FileReader:read	([C)I
    //   51: pop
    //   52: aload_3
    //   53: astore_0
    //   54: iload_2
    //   55: aload 4
    //   57: arraylength
    //   58: if_icmpge +10 -> 68
    //   61: aload 4
    //   63: iload_2
    //   64: caload
    //   65: ifne +37 -> 102
    //   68: aload_3
    //   69: astore_0
    //   70: new 33	java/lang/String
    //   73: dup
    //   74: aload 4
    //   76: invokespecial 216	java/lang/String:<init>	([C)V
    //   79: iconst_0
    //   80: iload_2
    //   81: invokevirtual 220	java/lang/String:substring	(II)Ljava/lang/String;
    //   84: astore 4
    //   86: aload 4
    //   88: astore_0
    //   89: aload_3
    //   90: ifnull +10 -> 100
    //   93: aload_3
    //   94: invokevirtual 223	java/io/FileReader:close	()V
    //   97: aload 4
    //   99: astore_0
    //   100: aload_0
    //   101: areturn
    //   102: iload_2
    //   103: iconst_1
    //   104: iadd
    //   105: istore_2
    //   106: goto -54 -> 52
    //   109: astore 4
    //   111: aconst_null
    //   112: astore_3
    //   113: aload_3
    //   114: astore_0
    //   115: ldc 8
    //   117: ldc 225
    //   119: aload 4
    //   121: invokestatic 110	com/tencent/camerasdk/avreporter/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: iload_1
    //   125: invokestatic 228	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   128: astore 4
    //   130: aload 4
    //   132: astore_0
    //   133: aload_3
    //   134: ifnull -34 -> 100
    //   137: aload_3
    //   138: invokevirtual 223	java/io/FileReader:close	()V
    //   141: aload 4
    //   143: areturn
    //   144: astore_0
    //   145: aload 4
    //   147: areturn
    //   148: astore_3
    //   149: aconst_null
    //   150: astore_0
    //   151: aload_0
    //   152: ifnull +7 -> 159
    //   155: aload_0
    //   156: invokevirtual 223	java/io/FileReader:close	()V
    //   159: aload_3
    //   160: athrow
    //   161: astore_0
    //   162: aload 4
    //   164: areturn
    //   165: astore_0
    //   166: goto -7 -> 159
    //   169: astore_3
    //   170: goto -19 -> 151
    //   173: astore 4
    //   175: goto -62 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramContext	Context
    //   0	178	1	paramInt	int
    //   1	105	2	i	int
    //   33	105	3	localFileReader	java.io.FileReader
    //   148	12	3	localObject1	Object
    //   169	1	3	localObject2	Object
    //   41	57	4	localObject3	Object
    //   109	11	4	localThrowable1	Throwable
    //   128	35	4	str	String
    //   173	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	34	109	java/lang/Throwable
    //   137	141	144	java/lang/Throwable
    //   2	34	148	finally
    //   93	97	161	java/lang/Throwable
    //   155	159	165	java/lang/Throwable
    //   36	43	169	finally
    //   45	52	169	finally
    //   54	61	169	finally
    //   70	86	169	finally
    //   115	124	169	finally
    //   36	43	173	java/lang/Throwable
    //   45	52	173	java/lang/Throwable
    //   54	61	173	java/lang/Throwable
    //   70	86	173	java/lang/Throwable
  }
  
  public static String getSignature(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    for (;;)
    {
      try
      {
        localObject1 = CertificateFactory.getInstance("X.509");
        if (localObject1 == null) {
          return null;
        }
        paramArrayOfByte = (X509Certificate)((CertificateFactory)localObject1).generateCertificate(new ByteArrayInputStream(paramArrayOfByte));
        if (paramArrayOfByte == null) {
          return null;
        }
        localStringBuilder.append("Issuer|");
        localObject1 = paramArrayOfByte.getIssuerDN();
        if (localObject1 == null) {
          continue;
        }
        localStringBuilder.append(((Principal)localObject1).toString());
        localStringBuilder.append("\n");
        localStringBuilder.append("SerialNumber|");
        localObject2 = paramArrayOfByte.getSerialNumber();
        if (localObject1 == null) {
          continue;
        }
        localStringBuilder.append(((BigInteger)localObject2).toString(16));
      }
      catch (CertificateException paramArrayOfByte)
      {
        Object localObject1;
        Object localObject2;
        LogUtils.e("MobileBase-AppInfo", "getSignature CertificateException error", paramArrayOfByte);
        continue;
        localStringBuilder.append("unknown");
        continue;
      }
      catch (Throwable paramArrayOfByte)
      {
        LogUtils.e("MobileBase-AppInfo", "getSignature error", paramArrayOfByte);
        continue;
        localStringBuilder.append("unknown");
        continue;
        localStringBuilder.append("unknown");
        continue;
        localStringBuilder.append("unknown");
        continue;
        localStringBuilder.append("unknown");
        continue;
      }
      localStringBuilder.append("\n");
      localStringBuilder.append("NotBefore|");
      localObject2 = paramArrayOfByte.getNotBefore();
      if (localObject1 == null) {
        continue;
      }
      localStringBuilder.append(((Date)localObject2).toString());
      localStringBuilder.append("\n");
      localStringBuilder.append("NotAfter|");
      localObject2 = paramArrayOfByte.getNotAfter();
      if (localObject1 == null) {
        continue;
      }
      localStringBuilder.append(((Date)localObject2).toString());
      localStringBuilder.append("\n");
      localStringBuilder.append("SHA1|");
      localObject1 = byte2Hex(MessageDigest.getInstance("SHA1").digest(paramArrayOfByte.getEncoded()));
      if (((String)localObject1).length() <= 0) {
        continue;
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("\n");
      localStringBuilder.append("MD5|");
      paramArrayOfByte = byte2Hex(MessageDigest.getInstance("MD5").digest(paramArrayOfByte.getEncoded()));
      if (paramArrayOfByte.length() <= 0) {
        continue;
      }
      localStringBuilder.append(paramArrayOfByte);
      if (localStringBuilder.length() != 0) {
        break label370;
      }
      return "unknown";
      localStringBuilder.append("unknown");
    }
    label370:
    return localStringBuilder.toString();
  }
  
  public static int getVersionCode(Context paramContext)
  {
    paramContext = getPackageInfo(paramContext);
    if (paramContext == null) {
      return -1;
    }
    return paramContext.versionCode;
  }
  
  public static String getVersionName(Context paramContext)
  {
    paramContext = getPackageInfo(paramContext);
    if (paramContext == null) {
      return "CantGetVersionName";
    }
    return paramContext.versionName;
  }
  
  public static boolean isContainPermission(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {}
    for (;;)
    {
      return false;
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager == null) {
          continue;
        }
        paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
        if (paramContext == null) {
          continue;
        }
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = paramString.equals(paramContext[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (Throwable paramContext)
      {
        LogUtils.e("MobileBase-AppInfo", "isContainPermission error", paramContext);
      }
    }
  }
  
  public static boolean isLowMemory(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (activityManager == null) {
      activityManager = (ActivityManager)paramContext.getSystemService("activity");
    }
    try
    {
      paramContext = new ActivityManager.MemoryInfo();
      activityManager.getMemoryInfo(paramContext);
      LogUtils.d("MobileBase-AppInfo", "Memory is low.");
      boolean bool = paramContext.lowMemory;
      return bool;
    }
    catch (Throwable paramContext)
    {
      LogUtils.e("MobileBase-AppInfo", "isLowMemory error", paramContext);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.camerasdk.avreporter.AppInfo
 * JD-Core Version:    0.7.0.1
 */