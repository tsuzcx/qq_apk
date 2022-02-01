package com.huawei.hms.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.List;

public class PackageManagerHelper
{
  private final PackageManager a;
  
  public PackageManagerHelper(Context paramContext)
  {
    this.a = paramContext.getPackageManager();
  }
  
  private byte[] a(String paramString)
  {
    try
    {
      paramString = this.a.getPackageInfo(paramString, 64);
      if ((paramString != null) && (paramString.signatures != null) && (paramString.signatures.length > 0))
      {
        paramString = paramString.signatures[0].toByteArray();
        return paramString;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + paramString.getMessage());
      HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
    }
    return new byte[0];
  }
  
  public static boolean isBackground(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      if (localObject == null) {
        return false;
      }
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.processName.equals(paramContext.getPackageName()))
        {
          int i = localRunningAppProcessInfo.importance;
          if (i >= 200) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PackageManagerHelper", "check the app isBackground", paramContext);
    }
    return false;
  }
  
  public String getPackageSignature(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (paramString.length == 0)) {
      return null;
    }
    return HEX.encodeHexString(SHA256.digest(paramString), true);
  }
  
  public PackageStates getPackageStates(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return PackageStates.NOT_INSTALLED;
    }
    try
    {
      if (this.a.getApplicationInfo(paramString, 0).enabled) {
        return PackageStates.ENABLED;
      }
      paramString = PackageStates.DISABLED;
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return PackageStates.NOT_INSTALLED;
  }
  
  public int getPackageVersionCode(String paramString)
  {
    int i = 0;
    try
    {
      paramString = this.a.getPackageInfo(paramString, 16);
      if (paramString != null) {
        i = paramString.versionCode;
      }
      return i;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return 0;
  }
  
  public String getPackageVersionName(String paramString)
  {
    try
    {
      paramString = this.a.getPackageInfo(paramString, 16);
      if ((paramString != null) && (paramString.versionName != null)) {
        return paramString.versionName;
      }
      return "";
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return "";
  }
  
  public boolean hasProvider(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    try
    {
      paramString1 = this.a.getPackageInfo(paramString1, 8);
      boolean bool1 = bool2;
      int j;
      int i;
      if (paramString1 != null)
      {
        bool1 = bool2;
        if (paramString1.providers != null)
        {
          paramString1 = paramString1.providers;
          j = paramString1.length;
          i = 0;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < j)
        {
          bool1 = paramString2.equals(paramString1[i].authority);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramString1) {}
  }
  
  /* Error */
  public boolean verifyPackageArchive(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/huawei/hms/utils/PackageManagerHelper:a	Landroid/content/pm/PackageManager;
    //   4: aload_1
    //   5: bipush 64
    //   7: invokevirtual 199	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   10: astore 6
    //   12: aload 6
    //   14: ifnull +24 -> 38
    //   17: aload 6
    //   19: getfield 38	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   22: arraylength
    //   23: ifle +15 -> 38
    //   26: aload_2
    //   27: aload 6
    //   29: getfield 202	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   32: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifne +5 -> 40
    //   38: iconst_0
    //   39: ireturn
    //   40: aconst_null
    //   41: astore_1
    //   42: aconst_null
    //   43: astore 5
    //   45: aconst_null
    //   46: astore_2
    //   47: aload 6
    //   49: getfield 38	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   52: iconst_0
    //   53: aaload
    //   54: invokevirtual 44	android/content/pm/Signature:toByteArray	()[B
    //   57: invokestatic 208	com/huawei/hms/utils/IOUtils:toInputStream	([B)Ljava/io/InputStream;
    //   60: astore 6
    //   62: aload 6
    //   64: astore_2
    //   65: aload 6
    //   67: astore_1
    //   68: aload 6
    //   70: astore 5
    //   72: aload_3
    //   73: ldc 210
    //   75: invokestatic 216	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   78: aload 6
    //   80: invokevirtual 220	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   83: invokevirtual 225	java/security/cert/Certificate:getEncoded	()[B
    //   86: invokestatic 134	com/huawei/hms/utils/SHA256:digest	([B)[B
    //   89: iconst_1
    //   90: invokestatic 140	com/huawei/hms/utils/HEX:encodeHexString	([BZ)Ljava/lang/String;
    //   93: invokevirtual 229	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   96: istore 4
    //   98: aload 6
    //   100: invokestatic 233	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   103: iload 4
    //   105: ireturn
    //   106: astore_3
    //   107: aload_2
    //   108: astore_1
    //   109: ldc 46
    //   111: new 48	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   118: ldc 51
    //   120: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_3
    //   124: invokevirtual 234	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   127: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 68	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_2
    //   137: invokestatic 233	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   140: iconst_0
    //   141: ireturn
    //   142: astore_2
    //   143: aload_1
    //   144: invokestatic 233	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   147: aload_2
    //   148: athrow
    //   149: astore_3
    //   150: aload 5
    //   152: astore_2
    //   153: goto -46 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	PackageManagerHelper
    //   0	156	1	paramString1	String
    //   0	156	2	paramString2	String
    //   0	156	3	paramString3	String
    //   96	8	4	bool	boolean
    //   43	108	5	localObject1	Object
    //   10	89	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   47	62	106	java/security/cert/CertificateException
    //   72	98	106	java/security/cert/CertificateException
    //   47	62	142	finally
    //   72	98	142	finally
    //   109	136	142	finally
    //   47	62	149	java/io/IOException
    //   72	98	149	java/io/IOException
  }
  
  public static enum PackageStates
  {
    private PackageStates() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.utils.PackageManagerHelper
 * JD-Core Version:    0.7.0.1
 */