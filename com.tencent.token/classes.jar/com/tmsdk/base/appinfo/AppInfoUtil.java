package com.tmsdk.base.appinfo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import btmsdkobf.bc;
import btmsdkobf.eg;
import com.tmsdk.base.utils.MD5Util;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppInfoUtil
{
  private static AppInfo a(PackageManager paramPackageManager, PackageInfo paramPackageInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = -1;
    boolean bool = false;
    if (paramPackageInfo == null) {
      return null;
    }
    AppInfo localAppInfo = new AppInfo();
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
      if (paramBoolean1) {
        localAppInfo.mIsSystemApp = false;
      }
      for (localAppInfo.mUid = -1;; localAppInfo.mUid = i)
      {
        paramPackageManager = new File(localAppInfo.mApkPath);
        if (paramPackageManager.exists())
        {
          localAppInfo.mSize = paramPackageManager.length();
          localAppInfo.mLastModified = paramPackageManager.lastModified();
        }
        if (!paramBoolean2) {
          break;
        }
        if (paramPackageInfo.signatures == null) {
          break label285;
        }
        if (paramPackageInfo.signatures.length >= 1) {
          break label253;
        }
        break label285;
        paramBoolean1 = bool;
        if ((paramPackageInfo.applicationInfo.flags & 0x1) != 0) {
          paramBoolean1 = true;
        }
        localAppInfo.mIsSystemApp = paramBoolean1;
        if (paramPackageInfo.applicationInfo != null) {
          i = paramPackageInfo.applicationInfo.uid;
        }
      }
      return localAppInfo;
    }
    catch (Throwable paramPackageManager)
    {
      eg.g("AppInfoUtil", paramPackageManager.getMessage());
    }
    for (;;)
    {
      label253:
      paramPackageManager = (X509Certificate)a(paramPackageInfo.signatures[0]);
      if (paramPackageManager != null) {
        localAppInfo.mSignatureMD5 = MD5Util.encrypt_bytes(paramPackageManager.getEncoded());
      }
    }
    label285:
    return localAppInfo;
  }
  
  private static Certificate a(Signature paramSignature)
  {
    paramSignature = new ByteArrayInputStream(paramSignature.toByteArray());
    try
    {
      X509Certificate localX509Certificate = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(paramSignature);
      if (paramSignature != null) {}
      try
      {
        paramSignature.close();
        return localX509Certificate;
      }
      catch (Throwable paramSignature)
      {
        eg.g("AppInfoUtil", paramSignature.getMessage());
        return localX509Certificate;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      eg.g("AppInfoUtil", localThrowable.getMessage());
      if (paramSignature != null) {
        try
        {
          paramSignature.close();
          return null;
        }
        catch (Throwable paramSignature)
        {
          eg.g("AppInfoUtil", paramSignature.getMessage());
          return null;
        }
      }
    }
    finally
    {
      if (paramSignature != null) {}
      try
      {
        paramSignature.close();
        throw localObject;
      }
      catch (Throwable paramSignature)
      {
        for (;;)
        {
          eg.g("AppInfoUtil", paramSignature.getMessage());
        }
      }
    }
  }
  
  /* Error */
  private static Certificate a(CertificateFactory paramCertificateFactory, Signature paramSignature)
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
    //   17: checkcast 127	java/security/cert/X509Certificate
    //   20: astore_0
    //   21: aload_1
    //   22: ifnull +7 -> 29
    //   25: aload_1
    //   26: invokevirtual 165	java/io/ByteArrayInputStream:close	()V
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: aload_1
    //   33: ifnull +30 -> 63
    //   36: aload_1
    //   37: invokevirtual 165	java/io/ByteArrayInputStream:close	()V
    //   40: aconst_null
    //   41: areturn
    //   42: astore_0
    //   43: aconst_null
    //   44: areturn
    //   45: astore_0
    //   46: aload_1
    //   47: ifnull +7 -> 54
    //   50: aload_1
    //   51: invokevirtual 165	java/io/ByteArrayInputStream:close	()V
    //   54: aload_0
    //   55: athrow
    //   56: astore_1
    //   57: aload_0
    //   58: areturn
    //   59: astore_1
    //   60: goto -6 -> 54
    //   63: aconst_null
    //   64: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramCertificateFactory	CertificateFactory
    //   0	65	1	paramSignature	Signature
    // Exception table:
    //   from	to	target	type
    //   12	21	31	java/lang/Throwable
    //   36	40	42	java/lang/Throwable
    //   12	21	45	finally
    //   25	29	56	java/lang/Throwable
    //   50	54	59	java/lang/Throwable
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
        for (;;)
        {
          if ((i < paramString.length) && (i < paramInt))
          {
            X509Certificate localX509Certificate = (X509Certificate)a(CertificateFactory.getInstance("X.509"), paramString[i]);
            if (localX509Certificate != null) {}
            try
            {
              localArrayList.add(MD5Util.encrypt_bytes(localX509Certificate.getEncoded()));
              i += 1;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                eg.g("AppInfoUtil", "extractPkgCertMd5s(), e: " + localThrowable.getMessage());
              }
            }
          }
        }
      }
      return localArrayList;
    }
    catch (Throwable paramString)
    {
      eg.g("AppInfoUtil", "extractPkgCertMd5s(), e: " + paramString.getMessage());
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
      PackageInfo localPackageInfo;
      if (paramBoolean1)
      {
        localPackageInfo = localPackageManager.getPackageArchiveInfo(paramString, i);
        localPackageInfo.applicationInfo.sourceDir = paramString;
        localPackageInfo.applicationInfo.publicSourceDir = paramString;
      }
      for (paramString = localPackageInfo;; paramString = localPackageManager.getPackageInfo(paramString, i)) {
        return a(localPackageManager, paramString, paramBoolean1, paramBoolean2);
      }
      return null;
    }
    catch (Throwable paramString)
    {
      eg.g("AppInfoUtil", paramString.getMessage());
    }
  }
  
  public static List<AppInfo> getInstalledAppList(boolean paramBoolean)
  {
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      PackageManager localPackageManager = bc.n().getPackageManager();
      if (paramBoolean) {
        i = 64;
      }
      Object localObject = localPackageManager.getInstalledPackages(i);
      if (localObject == null) {
        return null;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppInfo localAppInfo = a(localPackageManager, (PackageInfo)((Iterator)localObject).next(), false, paramBoolean);
        if (localAppInfo != null) {
          localArrayList.add(localAppInfo);
        }
      }
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      eg.g("AppInfoUtil", localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.appinfo.AppInfoUtil
 * JD-Core Version:    0.7.0.1
 */