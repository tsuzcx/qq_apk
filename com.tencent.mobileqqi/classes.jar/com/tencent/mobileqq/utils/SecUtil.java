package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public class SecUtil
{
  private static final String jdField_a_of_type_JavaLangString = "SecUtil";
  private static final char[] jdField_a_of_type_ArrayOfChar;
  
  static
  {
    a = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  }
  
  public static String a(Context paramContext)
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
  
  public static String a(String paramString)
  {
    byte[] arrayOfByte = new byte[8192];
    try
    {
      paramString = new FileInputStream(paramString);
      try
      {
        localMessageDigest = MessageDigest.getInstance("MD5");
        for (;;)
        {
          int i = paramString.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localMessageDigest.update(arrayOfByte, 0, i);
        }
        localException1.printStackTrace();
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        MessageDigest localMessageDigest;
        String str;
        paramString = null;
      }
    }
    str = "";
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        paramString.close();
        if (QLog.isColorLevel()) {
          QLog.d("SecUtil", 2, "getFileMd5" + str);
        }
        return str;
        str = a(localMessageDigest.digest());
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
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
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(a[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(a[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: new 152	java/util/jar/JarFile
    //   9: dup
    //   10: new 154	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokevirtual 44	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   18: invokevirtual 48	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   21: getfield 53	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   24: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 158	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   30: invokevirtual 162	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   33: astore_0
    //   34: new 164	java/util/HashSet
    //   37: dup
    //   38: invokespecial 165	java/util/HashSet:<init>	()V
    //   41: astore_1
    //   42: aload_0
    //   43: invokeinterface 170 1 0
    //   48: ifeq +45 -> 93
    //   51: aload_0
    //   52: invokeinterface 174 1 0
    //   57: checkcast 176	java/util/jar/JarEntry
    //   60: invokevirtual 179	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   63: astore_2
    //   64: aload_1
    //   65: aload_2
    //   66: invokeinterface 185 2 0
    //   71: iconst_1
    //   72: if_icmpne +5 -> 77
    //   75: iconst_1
    //   76: ireturn
    //   77: aload_1
    //   78: aload_2
    //   79: invokeinterface 188 2 0
    //   84: pop
    //   85: goto -43 -> 42
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 189	java/lang/OutOfMemoryError:printStackTrace	()V
    //   100: goto -7 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramContext	Context
    //   41	37	1	localHashSet	java.util.HashSet
    //   63	16	2	str	String
    // Exception table:
    //   from	to	target	type
    //   6	42	88	java/lang/Exception
    //   42	75	88	java/lang/Exception
    //   77	85	88	java/lang/Exception
    //   6	42	95	java/lang/OutOfMemoryError
    //   42	75	95	java/lang/OutOfMemoryError
    //   77	85	95	java/lang/OutOfMemoryError
  }
  
  public static byte[] a(Context paramContext)
  {
    String str = "fail " + paramContext.getPackageName() + " ";
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecUtil", 2, "getSign context null");
      }
      return (str + " getSign context null ").getBytes();
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 64);
      if (paramContext == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SecUtil", 2, "get sign fail");
        }
        return (str + " get sign fail ").getBytes();
      }
    }
    catch (Exception paramContext)
    {
      return (str + " getInstallPackages exception ").getBytes();
    }
    if (paramContext.signatures == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecUtil", 2, "get signatures fail");
      }
      return (str + " get signatures fail ").getBytes();
    }
    if (paramContext.signatures[0] == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecUtil", 2, "get signatures[0] fail");
      }
      return (str + " get signatures[0] fail ").getBytes();
    }
    int i = 0;
    while (i < paramContext.signatures.length)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecUtil", 2, "sig:" + paramContext.signatures[i].toCharsString());
      }
      i += 1;
    }
    if (paramContext.signatures[0].toByteArray().length == 0) {
      return (str + " byteSig len 0 ").getBytes();
    }
    return paramContext.signatures[0].toByteArray();
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecUtil", 2, "getPublicKey signature null");
      }
      localObject = "getPublicKey signature null ";
    }
    String str;
    do
    {
      return localObject;
      str = new String(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("SecUtil", 2, str);
      }
      localObject = str;
    } while (str.indexOf("fail") != -1);
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      paramArrayOfByte = a(((MessageDigest)localObject).digest());
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("SecUtil", 2, "get signature hash failed!");
      }
    }
    return "get signature hash failed!";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SecUtil
 * JD-Core Version:    0.7.0.1
 */