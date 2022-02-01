package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public class SecUtil
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  /* Error */
  public static boolean check0DayRepack(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: new 38	java/util/jar/JarFile
    //   9: dup
    //   10: new 40	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokevirtual 46	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   18: invokevirtual 50	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   21: getfield 56	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   24: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 62	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual 66	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   35: astore_1
    //   36: new 68	java/util/HashSet
    //   39: dup
    //   40: invokespecial 69	java/util/HashSet:<init>	()V
    //   43: astore_2
    //   44: aload_1
    //   45: invokeinterface 75 1 0
    //   50: ifeq +51 -> 101
    //   53: aload_1
    //   54: invokeinterface 79 1 0
    //   59: checkcast 81	java/util/jar/JarEntry
    //   62: invokevirtual 85	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   65: astore_3
    //   66: aload_2
    //   67: aload_3
    //   68: invokeinterface 91 2 0
    //   73: iconst_1
    //   74: if_icmpne +9 -> 83
    //   77: aload_0
    //   78: invokevirtual 94	java/util/jar/JarFile:close	()V
    //   81: iconst_1
    //   82: ireturn
    //   83: aload_2
    //   84: aload_3
    //   85: invokeinterface 97 2 0
    //   90: pop
    //   91: goto -47 -> 44
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 100	java/lang/Exception:printStackTrace	()V
    //   99: iconst_0
    //   100: ireturn
    //   101: aload_0
    //   102: invokevirtual 94	java/util/jar/JarFile:close	()V
    //   105: goto -6 -> 99
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 101	java/lang/OutOfMemoryError:printStackTrace	()V
    //   113: goto -14 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramContext	Context
    //   35	19	1	localEnumeration	java.util.Enumeration
    //   43	41	2	localHashSet	java.util.HashSet
    //   65	20	3	str	String
    // Exception table:
    //   from	to	target	type
    //   6	44	94	java/lang/Exception
    //   44	81	94	java/lang/Exception
    //   83	91	94	java/lang/Exception
    //   101	105	94	java/lang/Exception
    //   6	44	108	java/lang/OutOfMemoryError
    //   44	81	108	java/lang/OutOfMemoryError
    //   83	91	108	java/lang/OutOfMemoryError
    //   101	105	108	java/lang/OutOfMemoryError
  }
  
  public static String getFileMd5(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[8192];
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramInputStream = toHexString(localMessageDigest.digest());
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
      return "";
    }
    return paramInputStream;
  }
  
  public static String getFileMd5(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new FileInputStream(paramString);
        String str1;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            str1 = getFileMd5(paramString);
            if (paramString == null) {}
          }
          catch (Exception localException2)
          {
            String str2;
            continue;
          }
          try
          {
            paramString.close();
            return str1;
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
            return str2;
          }
        }
        localException1 = localException1;
        paramString = null;
      }
      str2 = "";
    }
  }
  
  public static String getPackageVersion(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramContext.getApplicationContext().getApplicationInfo().sourceDir, 1);
    if (paramContext == null) {
      return "";
    }
    return paramContext.versionName;
  }
  
  public static byte[] getSign(Context paramContext)
  {
    String str = "fail " + paramContext.getPackageName() + " ";
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 64);
      if (paramContext == null) {
        return (str + " get sign fail ").getBytes();
      }
    }
    catch (Exception paramContext)
    {
      return (str + " getInstallPackages exception ").getBytes();
    }
    if (paramContext.signatures == null) {
      return (str + " get signatures fail ").getBytes();
    }
    if (paramContext.signatures[0] == null) {
      return (str + " get signatures[0] fail ").getBytes();
    }
    if (paramContext.signatures[0].toByteArray().length == 0) {
      return (str + " byteSig len 0 ").getBytes();
    }
    return paramContext.signatures[0].toByteArray();
  }
  
  public static String getSignatureHash(byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      localObject = "getPublicKey signature null ";
    }
    String str;
    do
    {
      return localObject;
      str = new String(paramArrayOfByte);
      localObject = str;
    } while (str.indexOf("fail") != -1);
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      paramArrayOfByte = toHexString(((MessageDigest)localObject).digest());
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return "get signature hash failed!";
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(HEX_DIGITS[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(HEX_DIGITS[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String xor(String paramString1, String paramString2)
  {
    int i = 0;
    int j = 0;
    if (paramString1 == null) {
      localObject = null;
    }
    do
    {
      do
      {
        return localObject;
        localObject = paramString1;
      } while (paramString2 == null);
      localObject = paramString1;
    } while (paramString2 == "");
    paramString2 = paramString2.toCharArray();
    int k = paramString2.length;
    paramString1 = paramString1.toCharArray();
    Object localObject = new char[paramString1.length];
    if (k >= paramString1.length)
    {
      i = j;
      while (i < paramString1.length)
      {
        localObject[i] = ((char)(paramString1[i] ^ paramString2[i]));
        i += 1;
      }
    }
    while (i < paramString1.length)
    {
      localObject[i] = ((char)(paramString1[i] ^ paramString2[(i % k)]));
      i += 1;
    }
    if (localObject.length == 0) {
      return "";
    }
    return new String((char[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SecUtil
 * JD-Core Version:    0.7.0.1
 */