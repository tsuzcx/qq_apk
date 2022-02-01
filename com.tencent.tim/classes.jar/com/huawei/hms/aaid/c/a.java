package com.huawei.hms.aaid.c;

import alkx;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HEX;
import com.huawei.hms.utils.Util;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class a
{
  public static TokenReq a(String paramString1, String paramString2, Context paramContext)
  {
    TokenReq localTokenReq = new TokenReq();
    localTokenReq.setPackageName(paramContext.getPackageName());
    if (TextUtils.isEmpty(paramString1)) {
      localTokenReq.setAppId(Util.getAppId(paramContext));
    }
    if (TextUtils.isEmpty(paramString2)) {
      localTokenReq.setScope("HCM");
    }
    paramString1 = paramContext.getSharedPreferences("push_client_self_info", 0);
    if (!a("hasRequestAgreement", paramString1))
    {
      localTokenReq.setFirstTime(true);
      paramString1.edit().putBoolean("hasRequestAgreement", true).commit();
      return localTokenReq;
    }
    localTokenReq.setFirstTime(false);
    return localTokenReq;
  }
  
  private static String a(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    new SecureRandom().nextBytes(arrayOfByte);
    return HEX.encodeHexString(arrayOfByte, false);
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null)
    {
      HMSLog.e("AaidUtils", "getSign failed because context is null.");
      return null;
    }
    Iterator localIterator = alkx.a(paramContext.getPackageManager(), 64).iterator();
    while (localIterator.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      if (localPackageInfo.packageName.equals(paramContext.getPackageName())) {
        return localPackageInfo.signatures[0].toCharsString();
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    return b(paramString + a(32));
  }
  
  private static boolean a(String paramString, SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSharedPreferences != null)
    {
      bool1 = bool2;
      if (paramSharedPreferences.getBoolean(paramString, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 165	com/huawei/hms/aaid/c/c
    //   6: dup
    //   7: aload_0
    //   8: ldc 167
    //   10: invokespecial 170	com/huawei/hms/aaid/c/c:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: ldc 167
    //   17: invokevirtual 174	com/huawei/hms/aaid/c/c:d	(Ljava/lang/String;)Z
    //   20: ifeq +15 -> 35
    //   23: aload_1
    //   24: ldc 167
    //   26: invokevirtual 175	com/huawei/hms/aaid/c/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_0
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_0
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 18	android/content/Context:getPackageName	()Ljava/lang/String;
    //   39: astore_2
    //   40: aload_0
    //   41: invokestatic 177	com/huawei/hms/aaid/c/a:a	(Landroid/content/Context;)Ljava/lang/String;
    //   44: astore_0
    //   45: new 146	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   52: aload_2
    //   53: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 179	com/huawei/hms/aaid/c/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_0
    //   67: aload_1
    //   68: ldc 167
    //   70: aload_0
    //   71: invokevirtual 182	com/huawei/hms/aaid/c/c:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   74: pop
    //   75: aload_1
    //   76: ldc 184
    //   78: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   81: invokestatic 196	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   84: invokevirtual 199	com/huawei/hms/aaid/c/c:a	(Ljava/lang/String;Ljava/lang/Long;)V
    //   87: goto -57 -> 30
    //   90: astore_0
    //   91: ldc 2
    //   93: monitorexit
    //   94: aload_0
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramContext	Context
    //   13	63	1	localc	c
    //   39	14	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	30	90	finally
    //   35	87	90	finally
  }
  
  private static String b(String paramString)
  {
    paramString = d.a(paramString, "SHA-256");
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() != 64)) {
      return UUID.randomUUID().toString();
    }
    return c(paramString).toString();
  }
  
  private static UUID c(String paramString)
  {
    String str = paramString.substring(0, 32);
    paramString = paramString.substring(32, 64);
    return new UUID(d(str), d(paramString));
  }
  
  private static long d(String paramString)
  {
    String str1 = "0x" + paramString.substring(0, 8);
    String str2 = "0x" + paramString.substring(8, 16);
    String str3 = "0x" + paramString.substring(16, 24);
    paramString = "0x" + paramString.substring(24, 32);
    long l = Long.decode(str1).longValue();
    return ((Long.decode(str2).longValue() | l << 16) << 16 | Long.decode(str3).longValue()) << 16 | Long.decode(paramString).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.aaid.c.a
 * JD-Core Version:    0.7.0.1
 */