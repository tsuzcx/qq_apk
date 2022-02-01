package com.tmsdk.base.appinfo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import btmsdkobf.bc;
import btmsdkobf.eg;
import com.tmsdk.base.utils.MD5Util;
import java.io.File;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppInfoUtil
{
  private static AppInfo a(PackageManager paramPackageManager, PackageInfo paramPackageInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramPackageInfo == null) {
      return null;
    }
    AppInfo localAppInfo = new AppInfo();
    for (;;)
    {
      try
      {
        if ((paramPackageInfo.applicationInfo != null) && (!TextUtils.isEmpty(paramPackageInfo.applicationInfo.packageName))) {
          localAppInfo.mPkgName = paramPackageInfo.applicationInfo.packageName;
        }
        if (paramPackageInfo.applicationInfo != null)
        {
          paramPackageManager = paramPackageManager.getApplicationLabel(paramPackageInfo.applicationInfo);
          if (paramPackageManager != null) {
            localAppInfo.mAppName = paramPackageManager.toString();
          }
        }
        localAppInfo.mVersionCode = paramPackageInfo.versionCode;
        localAppInfo.mVersionName = paramPackageInfo.versionName;
        localAppInfo.mApkPath = paramPackageInfo.applicationInfo.sourceDir;
        int i = -1;
        if (paramBoolean1)
        {
          localAppInfo.mIsSystemApp = false;
          localAppInfo.mUid = i;
        }
        else
        {
          if ((paramPackageInfo.applicationInfo.flags & 0x1) == 0) {
            break label282;
          }
          paramBoolean1 = true;
          localAppInfo.mIsSystemApp = paramBoolean1;
          if (paramPackageInfo.applicationInfo == null) {
            continue;
          }
          i = paramPackageInfo.applicationInfo.uid;
          continue;
        }
        paramPackageManager = new File(localAppInfo.mApkPath);
        if (paramPackageManager.exists())
        {
          localAppInfo.mSize = paramPackageManager.length();
          localAppInfo.mLastModified = paramPackageManager.lastModified();
        }
        if (paramBoolean2) {
          if (paramPackageInfo.signatures != null)
          {
            if (paramPackageInfo.signatures.length < 1) {
              return localAppInfo;
            }
            paramPackageManager = (X509Certificate)a(paramPackageInfo.signatures[0]);
            if (paramPackageManager != null)
            {
              localAppInfo.mSignatureMD5 = MD5Util.encrypt_bytes(paramPackageManager.getEncoded());
              return localAppInfo;
            }
          }
          else
          {
            return localAppInfo;
          }
        }
      }
      catch (Throwable paramPackageManager)
      {
        eg.g("AppInfoUtil", paramPackageManager.getMessage());
      }
      return localAppInfo;
      label282:
      paramBoolean1 = false;
    }
  }
  
  /* Error */
  private static java.security.cert.Certificate a(android.content.pm.Signature paramSignature)
  {
    // Byte code:
    //   0: new 142	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 147	android/content/pm/Signature:toByteArray	()[B
    //   8: invokespecial 150	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore_0
    //   12: ldc 152
    //   14: invokestatic 158	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   17: aload_0
    //   18: invokevirtual 162	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   21: checkcast 116	java/security/cert/X509Certificate
    //   24: astore_1
    //   25: aload_0
    //   26: invokevirtual 165	java/io/ByteArrayInputStream:close	()V
    //   29: aload_1
    //   30: areturn
    //   31: astore_0
    //   32: ldc 131
    //   34: aload_0
    //   35: invokevirtual 134	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   38: invokestatic 140	btmsdkobf/eg:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_1
    //   42: areturn
    //   43: astore_1
    //   44: goto +32 -> 76
    //   47: astore_1
    //   48: ldc 131
    //   50: aload_1
    //   51: invokevirtual 134	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   54: invokestatic 140	btmsdkobf/eg:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: invokevirtual 165	java/io/ByteArrayInputStream:close	()V
    //   61: goto +13 -> 74
    //   64: astore_0
    //   65: ldc 131
    //   67: aload_0
    //   68: invokevirtual 134	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   71: invokestatic 140	btmsdkobf/eg:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aconst_null
    //   75: areturn
    //   76: aload_0
    //   77: invokevirtual 165	java/io/ByteArrayInputStream:close	()V
    //   80: goto +13 -> 93
    //   83: astore_0
    //   84: ldc 131
    //   86: aload_0
    //   87: invokevirtual 134	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   90: invokestatic 140	btmsdkobf/eg:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramSignature	android.content.pm.Signature
    //   24	18	1	localX509Certificate	X509Certificate
    //   43	1	1	localObject	Object
    //   47	47	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   25	29	31	java/lang/Throwable
    //   12	25	43	finally
    //   48	57	43	finally
    //   12	25	47	java/lang/Throwable
    //   57	61	64	java/lang/Throwable
    //   76	80	83	java/lang/Throwable
  }
  
  /* Error */
  private static java.security.cert.Certificate a(CertificateFactory paramCertificateFactory, android.content.pm.Signature paramSignature)
  {
    // Byte code:
    //   0: new 142	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 147	android/content/pm/Signature:toByteArray	()[B
    //   8: invokespecial 150	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore_1
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 162	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   17: checkcast 116	java/security/cert/X509Certificate
    //   20: astore_0
    //   21: aload_1
    //   22: invokevirtual 165	java/io/ByteArrayInputStream:close	()V
    //   25: aload_0
    //   26: areturn
    //   27: astore_0
    //   28: aload_1
    //   29: invokevirtual 165	java/io/ByteArrayInputStream:close	()V
    //   32: aload_0
    //   33: athrow
    //   34: aload_1
    //   35: invokevirtual 165	java/io/ByteArrayInputStream:close	()V
    //   38: aconst_null
    //   39: areturn
    //   40: astore_0
    //   41: goto -7 -> 34
    //   44: astore_1
    //   45: aload_0
    //   46: areturn
    //   47: astore_1
    //   48: goto -16 -> 32
    //   51: astore_0
    //   52: goto -14 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramCertificateFactory	CertificateFactory
    //   0	55	1	paramSignature	android.content.pm.Signature
    // Exception table:
    //   from	to	target	type
    //   12	21	27	finally
    //   12	21	40	java/lang/Throwable
    //   21	25	44	java/lang/Throwable
    //   28	32	47	java/lang/Throwable
    //   34	38	51	java/lang/Throwable
  }
  
  public static ArrayList<String> extractPkgCertMd5s(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    localArrayList = new ArrayList();
    try
    {
      paramString = bc.n().getPackageManager().getPackageInfo(paramString, 64);
      if ((paramString != null) && (paramString.signatures != null) && (paramString.signatures.length > 0))
      {
        paramString = paramString.signatures;
        int i = 0;
        while ((i < paramString.length) && (i < paramInt))
        {
          X509Certificate localX509Certificate = (X509Certificate)a(CertificateFactory.getInstance("X.509"), paramString[i]);
          if (localX509Certificate != null) {
            try
            {
              localArrayList.add(MD5Util.encrypt_bytes(localX509Certificate.getEncoded()));
            }
            catch (Throwable localThrowable)
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("extractPkgCertMd5s(), e: ");
              localStringBuilder2.append(localThrowable.getMessage());
              eg.g("AppInfoUtil", localStringBuilder2.toString());
            }
          }
          i += 1;
        }
      }
      StringBuilder localStringBuilder1;
      return localArrayList;
    }
    catch (Throwable paramString)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("extractPkgCertMd5s(), e: ");
      localStringBuilder1.append(paramString.getMessage());
      eg.g("AppInfoUtil", localStringBuilder1.toString());
    }
  }
  
  public static AppInfo getAppInfo(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      PackageManager localPackageManager = bc.n().getPackageManager();
      int i = 0;
      if (paramBoolean2) {
        i = 64;
      }
      if (paramBoolean1)
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageArchiveInfo(paramString, i);
        localPackageInfo.applicationInfo.sourceDir = paramString;
        localPackageInfo.applicationInfo.publicSourceDir = paramString;
        paramString = localPackageInfo;
      }
      else
      {
        paramString = localPackageManager.getPackageInfo(paramString, i);
      }
      paramString = a(localPackageManager, paramString, paramBoolean1, paramBoolean2);
      return paramString;
    }
    catch (Throwable paramString)
    {
      eg.g("AppInfoUtil", paramString.getMessage());
    }
    return null;
  }
  
  public static List<AppInfo> getInstalledAppList(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        PackageManager localPackageManager = bc.n().getPackageManager();
        if (paramBoolean)
        {
          i = 64;
          Object localObject = localPackageManager.getInstalledPackages(i);
          if (localObject == null) {
            return null;
          }
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            AppInfo localAppInfo = a(localPackageManager, (PackageInfo)((Iterator)localObject).next(), false, paramBoolean);
            if (localAppInfo == null) {
              continue;
            }
            localArrayList.add(localAppInfo);
            continue;
          }
          return localArrayList;
        }
      }
      catch (Throwable localThrowable)
      {
        eg.g("AppInfoUtil", localThrowable.getMessage());
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.appinfo.AppInfoUtil
 * JD-Core Version:    0.7.0.1
 */