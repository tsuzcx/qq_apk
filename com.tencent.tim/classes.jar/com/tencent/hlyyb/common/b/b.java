package com.tencent.hlyyb.common.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public final class b
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  private static String d = "";
  
  public static int a()
  {
    return (int)(Math.random() * 2147483647.0D);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, 1), 5);
  }
  
  /* Error */
  private static String a(int paramInt)
  {
    // Byte code:
    //   0: new 46	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   7: ldc 51
    //   9: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: iload_0
    //   13: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16: ldc 60
    //   18: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_1
    //   25: new 66	java/io/BufferedReader
    //   28: dup
    //   29: new 68	java/io/FileReader
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 71	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   37: invokespecial 74	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 77	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore 4
    //   49: aload 4
    //   51: astore_3
    //   52: aload_2
    //   53: astore_1
    //   54: aload 4
    //   56: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +11 -> 70
    //   62: aload_2
    //   63: astore_1
    //   64: aload 4
    //   66: invokevirtual 88	java/lang/String:trim	()Ljava/lang/String;
    //   69: astore_3
    //   70: aload_2
    //   71: ifnull +7 -> 78
    //   74: aload_2
    //   75: invokevirtual 91	java/io/BufferedReader:close	()V
    //   78: aload_3
    //   79: areturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_1
    //   85: aload_3
    //   86: invokevirtual 94	java/lang/Exception:printStackTrace	()V
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 91	java/io/BufferedReader:close	()V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 91	java/io/BufferedReader:close	()V
    //   110: aload_2
    //   111: athrow
    //   112: astore_1
    //   113: aload_3
    //   114: areturn
    //   115: astore_1
    //   116: goto -19 -> 97
    //   119: astore_1
    //   120: goto -10 -> 110
    //   123: astore_2
    //   124: goto -22 -> 102
    //   127: astore_3
    //   128: goto -45 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramInt	int
    //   24	83	1	localObject1	Object
    //   112	1	1	localIOException1	java.io.IOException
    //   115	1	1	localIOException2	java.io.IOException
    //   119	1	1	localIOException3	java.io.IOException
    //   40	54	2	localBufferedReader	java.io.BufferedReader
    //   99	12	2	localObject2	Object
    //   123	1	2	localObject3	Object
    //   51	28	3	str1	String
    //   80	34	3	localException1	Exception
    //   127	1	3	localException2	Exception
    //   47	18	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   25	41	80	java/lang/Exception
    //   25	41	99	finally
    //   74	78	112	java/io/IOException
    //   93	97	115	java/io/IOException
    //   106	110	119	java/io/IOException
    //   43	49	123	finally
    //   54	62	123	finally
    //   64	70	123	finally
    //   85	89	123	finally
    //   43	49	127	java/lang/Exception
    //   54	62	127	java/lang/Exception
    //   64	70	127	java/lang/Exception
  }
  
  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(d)) {
      return d;
    }
    String str3 = paramContext.getPackageName();
    String str2 = a(Process.myPid());
    String str1;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.startsWith(str3)) {}
    }
    else
    {
      str1 = a(paramContext, Process.myPid());
    }
    d = str1;
    return str1;
  }
  
  private static String a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSystemService("activity");
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (ActivityManager)paramContext;
        if (paramContext != null) {
          break;
        }
        return null;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
      paramContext = null;
    }
    paramContext = paramContext.getRunningAppProcesses();
    int i;
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      int j = paramContext.size();
      i = 0;
      if (i < j)
      {
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.get(i);
        if ((localRunningAppProcessInfo == null) || (localRunningAppProcessInfo.pid != paramInt)) {}
      }
    }
    for (paramContext = localRunningAppProcessInfo.processName;; paramContext = null)
    {
      return paramContext;
      i += 1;
      break;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new URL(paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1.getProtocol()).append("://");
      localStringBuilder.append(paramString2);
      if (paramString1.getPort() != -1) {
        localStringBuilder.append(":" + paramString1.getPort());
      }
      localStringBuilder.append(paramString1.getPath());
      if (!TextUtils.isEmpty(paramString1.getQuery())) {
        localStringBuilder.append("?" + paramString1.getQuery());
      }
      if (!TextUtils.isEmpty(paramString1.getRef())) {
        localStringBuilder.append("#" + paramString1.getRef());
      }
      paramString1 = localStringBuilder.toString();
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      throw new NullPointerException();
    }
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = paramString;
    if (paramBoolean) {
      str = paramString;
    }
    try
    {
      if (paramString.length() > 30) {
        str = paramString.substring(0, 30);
      }
      paramString = URLEncoder.encode(str);
      return paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    while (paramString.trim().length() == 0) {
      return true;
    }
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0);
  }
  
  public static String b()
  {
    return "";
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static String c()
  {
    return "";
  }
  
  public static String d()
  {
    Context localContext = com.tencent.hlyyb.common.a.a();
    if (localContext == null) {
      return null;
    }
    return localContext.getPackageName();
  }
  
  public static String e()
  {
    Context localContext = com.tencent.hlyyb.common.a.a();
    if (localContext == null) {
      return null;
    }
    Object localObject = com.tencent.hlyyb.common.a.a();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Context)localObject).getPackageName()) {
      try
      {
        localObject = localContext.getPackageManager().getPackageInfo((String)localObject, 0).versionName;
        return localObject;
      }
      catch (Exception localException) {}
    }
    return null;
  }
  
  public static int f()
  {
    Context localContext = com.tencent.hlyyb.common.a.a();
    if (localContext == null) {
      return 0;
    }
    Object localObject = com.tencent.hlyyb.common.a.a();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Context)localObject).getPackageName()) {
      try
      {
        int i = localContext.getPackageManager().getPackageInfo((String)localObject, 0).versionCode;
        return i;
      }
      catch (Exception localException) {}
    }
    return 0;
  }
  
  public static String g()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(b());
    localStringBuilder.append(c());
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(h());
    localStringBuilder.append((int)(Math.random() * 2147483647.0D));
    return a.a(localStringBuilder.toString());
  }
  
  private static String h()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.common.b.b
 * JD-Core Version:    0.7.0.1
 */