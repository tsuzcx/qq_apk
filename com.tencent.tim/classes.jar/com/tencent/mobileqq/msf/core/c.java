package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class c
{
  static int a = -1;
  private static final String b = "MSF.C.CoreUtil";
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | paramArrayOfByte[(paramInt + 2)] << 8 & 0xFF00 | paramArrayOfByte[(paramInt + 1)] << 16 & 0xFF0000 | paramArrayOfByte[(paramInt + 0)] << 24 & 0xFF000000;
  }
  
  public static File a(String paramString)
  {
    try
    {
      paramString = new File(paramString + "/load/");
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String a(Context paramContext)
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localObject2 = paramContext.getFilesDir();
        if (localObject2 != null) {
          continue;
        }
        paramContext = paramContext.getCacheDir();
        if (paramContext != null) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label293;
        }
        QLog.w("MSF.C.CoreUtil", 2, "load cache dir is null");
        paramContext = null;
        if (paramContext != null) {
          continue;
        }
        localObject2 = Environment.getExternalStorageDirectory().getPath() + "/MSF/files";
        File localFile = new File((String)localObject2);
        paramContext = (Context)localObject2;
        if (!localFile.exists())
        {
          localFile.mkdirs();
          paramContext = (Context)localObject2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.CoreUtil", 2, "load save root dir is " + paramContext);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        int i;
        paramContext = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("MSF.C.CoreUtil", 2, "getSaveRootPath error ", localThrowable);
        paramContext = localObject1;
        continue;
      }
      finally {}
      return paramContext;
      localObject2 = paramContext.getAbsolutePath();
      i = ((String)localObject2).lastIndexOf('/');
      paramContext = (Context)localObject2;
      if (i != -1)
      {
        paramContext = ((String)localObject2).substring(0, i);
        paramContext = paramContext + "/files/";
        continue;
        paramContext = ((File)localObject2).getAbsolutePath();
        continue;
        localObject2 = new File(paramContext);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        if ((!((File)localObject2).exists()) || (!((File)localObject2).canWrite()))
        {
          paramContext = Environment.getExternalStorageDirectory().getPath() + "/MSF/files";
          new File(paramContext).mkdirs();
          continue;
          label293:
          paramContext = null;
        }
      }
    }
  }
  
  public static String a(InputStream paramInputStream)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = new byte[64];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localStringBuffer.append(new String(arrayOfByte, 0, i));
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public static void a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: new 26	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokestatic 136	com/tencent/mobileqq/msf/core/c:h	(Landroid/content/Context;)Ljava/lang/String;
    //   8: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 46	java/io/File:exists	()Z
    //   16: ifeq +8 -> 24
    //   19: aload_0
    //   20: invokevirtual 139	java/io/File:delete	()Z
    //   23: pop
    //   24: aload_0
    //   25: invokevirtual 142	java/io/File:createNewFile	()Z
    //   28: pop
    //   29: new 144	java/io/FileOutputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_2
    //   38: aload_2
    //   39: astore_0
    //   40: aload_2
    //   41: iload_1
    //   42: invokestatic 150	com/tencent/mobileqq/msf/core/c:a	(I)[B
    //   45: invokevirtual 154	java/io/FileOutputStream:write	([B)V
    //   48: aload_2
    //   49: ifnull +7 -> 56
    //   52: aload_2
    //   53: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   56: return
    //   57: astore_3
    //   58: aconst_null
    //   59: astore_2
    //   60: aload_2
    //   61: astore_0
    //   62: aload_3
    //   63: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   66: aload_2
    //   67: ifnull -11 -> 56
    //   70: aload_2
    //   71: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   74: return
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   80: return
    //   81: astore_2
    //   82: aconst_null
    //   83: astore_0
    //   84: aload_0
    //   85: ifnull +7 -> 92
    //   88: aload_0
    //   89: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   92: aload_2
    //   93: athrow
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   99: goto -7 -> 92
    //   102: astore_0
    //   103: goto -27 -> 76
    //   106: astore_2
    //   107: goto -23 -> 84
    //   110: astore_3
    //   111: goto -51 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramContext	Context
    //   0	114	1	paramInt	int
    //   37	34	2	localFileOutputStream	FileOutputStream
    //   81	12	2	localObject1	Object
    //   106	1	2	localObject2	Object
    //   57	6	3	localException1	Exception
    //   110	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   24	38	57	java/lang/Exception
    //   70	74	75	java/io/IOException
    //   24	38	81	finally
    //   88	92	94	java/io/IOException
    //   52	56	102	java/io/IOException
    //   40	48	106	finally
    //   62	66	106	finally
    //   40	48	110	java/lang/Exception
  }
  
  private static void a(Context paramContext, String paramString, int paramInt, String[] paramArrayOfString)
    throws IOException
  {
    QLog.d("MSF.C.CoreUtil", 1, "MsfCore init ->realCopySoLib begin.");
    String[] arrayOfString = paramContext.getAssets().list("lib/" + paramString);
    String str1 = d(paramContext);
    Object localObject;
    if (arrayOfString != null)
    {
      localObject = new StringBuilder("realCopySoLib list assetsFileNames: ");
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append(arrayOfString[i]).append(" ");
        i += 1;
      }
      QLog.i("MSF.C.CoreUtil", 1, ((StringBuilder)localObject).toString());
    }
    int i2 = arrayOfString.length;
    int i = 0;
    int k = 0;
    int j = 0;
    if (i < i2)
    {
      localObject = arrayOfString[i];
      int i3 = paramArrayOfString.length;
      int i1 = 0;
      for (;;)
      {
        int m = k;
        int n = j;
        if (i1 < i3)
        {
          if (!paramArrayOfString[i1].equals(localObject)) {
            break label410;
          }
          String str2 = "lib/" + paramString + "/" + (String)localObject;
          File localFile = new File(str1 + (String)localObject);
          if ((localFile.exists()) && (!localFile.delete())) {
            QLog.w("MSF.C.CoreUtil", 1, "realCopySoLib delete " + localFile.getName() + " failed.");
          }
          boolean bool = a(str2, str1, paramContext);
          QLog.i("MSF.C.CoreUtil", 1, "realCopySoLib " + (String)localObject + " size=" + new File(new StringBuilder().append(str1).append((String)localObject).toString()).length() + " " + bool);
          if (bool) {
            break label397;
          }
          n = j + 1;
          m = k;
        }
        for (;;)
        {
          i += 1;
          k = m;
          j = n;
          break;
          label397:
          m = k + 1;
          n = j;
        }
        label410:
        i1 += 1;
      }
    }
    if (j == 0)
    {
      QLog.i("MSF.C.CoreUtil", 1, "realCopySoLib update versionCode and jniFile");
      a(paramContext, paramInt);
      j(paramContext);
    }
    QLog.d("MSF.C.CoreUtil", 1, "MsfCore init ->realCopySoLib end. copyFailCount:" + j + " copySuccCount=" + k);
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, int paramInt, String[] paramArrayOfString)
    throws IOException
  {
    if (paramBoolean) {
      a(paramContext, paramString, paramInt, paramArrayOfString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.CoreUtil", 2, "MsfCore init ->copySoLib end.");
      }
      return;
      try
      {
        String[] arrayOfString1 = m(paramContext);
        String[] arrayOfString2 = l(paramContext);
        if ((arrayOfString1 == null) || (arrayOfString2 == null) || (!arrayOfString2[0].equals(arrayOfString1[0])) || (!arrayOfString2[1].equals(arrayOfString1[1]))) {
          a(paramContext, paramString, paramInt, paramArrayOfString);
        }
      }
      catch (Exception paramContext)
      {
        QLog.w("MSF.C.CoreUtil", 1, "check package jni id error " + paramContext);
      }
    }
  }
  
  public static boolean a()
  {
    System.out.println("bRet=" + false);
    return false;
  }
  
  public static boolean a(String paramString, Context paramContext)
  {
    boolean bool2;
    if (paramContext == null)
    {
      bool2 = false;
      return bool2;
    }
    File localFile2 = new File(d(paramContext) + "lib" + paramString + ".so");
    File localFile1 = localFile2;
    if (!localFile2.exists()) {
      localFile1 = new File(paramContext.getFilesDir().getParent() + "/lib/lib" + paramString + ".so");
    }
    if (localFile1.exists()) {}
    for (;;)
    {
      try
      {
        System.load(localFile1.getAbsolutePath());
        boolean bool1 = true;
        bool2 = bool1;
        if (bool1) {
          break;
        }
        bool1 = false;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        try
        {
          System.loadLibrary(paramString);
          return true;
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          if (!QLog.isColorLevel()) {
            break label212;
          }
          QLog.d("MSF.C.CoreUtil", 2, "cannot load library " + paramString);
        }
        paramContext = paramContext;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.CoreUtil", 2, "cannot load library " + localFile1.getAbsolutePath());
        }
      }
    }
    label212:
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2, Context paramContext)
  {
    localObject = null;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramString1 == null) {}
    }
    for (;;)
    {
      String str;
      int i;
      try
      {
        bool1 = paramString1.contains(".so");
        if (!bool1)
        {
          bool1 = bool2;
          return bool1;
        }
        if (paramString2 != null)
        {
          str = paramString2;
          if (paramString2.trim().length() != 0) {}
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e("MSF.C.CoreUtil", 2, "not define lib out path");
          }
          str = paramContext.getFilesDir().getAbsolutePath();
        }
        new File(str).mkdirs();
        i = paramString1.lastIndexOf('/');
        if (i >= 0)
        {
          paramString2 = paramString1.substring(i + 1);
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.CoreUtil", 2, "copy lib:" + paramString1);
          }
        }
      }
      finally {}
      try
      {
        paramString1 = paramContext.getAssets().open(paramString1);
      }
      catch (Exception paramString1)
      {
        paramString1 = null;
        paramString2 = localObject;
        continue;
      }
      try
      {
        paramString2 = new File(str + "/" + paramString2);
        if (paramString2.exists()) {
          paramString2.delete();
        }
        paramString2.createNewFile();
        paramString2 = new FileOutputStream(paramString2);
        try
        {
          paramContext = new byte[4096];
          if (paramString1.available() > 0)
          {
            i = paramString1.read(paramContext);
            if (i > 0)
            {
              paramString2.write(paramContext, 0, i);
              continue;
              if (paramString2 == null) {}
            }
          }
        }
        catch (Exception paramContext) {}
      }
      catch (Exception paramString2)
      {
        paramString2 = localObject;
        continue;
      }
      try
      {
        paramString2.close();
        bool1 = bool2;
        if (paramString1 == null) {
          continue;
        }
        try
        {
          paramString1.close();
          bool1 = bool2;
        }
        catch (IOException paramString1)
        {
          bool1 = bool2;
        }
        continue;
        paramString2 = paramString1;
        continue;
        paramString2.close();
        paramString1.close();
        bool1 = true;
      }
      catch (IOException paramString2) {}
    }
  }
  
  public static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt >>> 24 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static File b(String paramString)
  {
    try
    {
      paramString = new File(paramString + "/cacheTemp/");
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 58	android/content/Context:getFilesDir	()Ljava/io/File;
    //   7: invokevirtual 90	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +25 -> 37
    //   15: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +12 -> 30
    //   21: ldc 11
    //   23: iconst_2
    //   24: ldc_w 315
    //   27: invokestatic 72	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: aconst_null
    //   31: astore_0
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_0
    //   36: areturn
    //   37: new 26	java/io/File
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_1
    //   47: astore_0
    //   48: aload_2
    //   49: invokevirtual 46	java/io/File:exists	()Z
    //   52: ifne -20 -> 32
    //   55: aload_2
    //   56: invokevirtual 49	java/io/File:mkdirs	()Z
    //   59: pop
    //   60: aload_1
    //   61: astore_0
    //   62: goto -30 -> 32
    //   65: astore_0
    //   66: ldc 2
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramContext	Context
    //   10	51	1	str	String
    //   45	11	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   3	11	65	finally
    //   15	30	65	finally
    //   37	46	65	finally
    //   48	60	65	finally
  }
  
  /* Error */
  public static String c(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 321	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: ldc_w 323
    //   15: invokevirtual 285	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +12 -> 30
    //   21: ldc_w 323
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: ifnull +20 -> 51
    //   34: aload_0
    //   35: ldc_w 325
    //   38: invokevirtual 285	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   41: ifeq +10 -> 51
    //   44: ldc_w 327
    //   47: astore_0
    //   48: goto -23 -> 25
    //   51: ldc_w 329
    //   54: astore_0
    //   55: goto -30 -> 25
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	7	58	finally
    //   11	21	58	finally
    //   34	44	58	finally
  }
  
  public static String d(Context paramContext)
  {
    return paramContext.getFilesDir().getParent() + "/txlib/";
  }
  
  public static int e(Context paramContext)
  {
    PackageManager localPackageManager;
    if ((a == -1) && (paramContext != null)) {
      localPackageManager = paramContext.getPackageManager();
    }
    try
    {
      a = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return a;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static String f(Context paramContext)
  {
    Object localObject = "";
    if (paramContext != null) {
      localObject = paramContext.getPackageManager();
    }
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return localObject;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public static int g(Context paramContext)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: new 26	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokestatic 359	com/tencent/mobileqq/msf/core/c:i	(Landroid/content/Context;)Ljava/lang/String;
    //   10: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 4
    //   15: aload 4
    //   17: invokevirtual 46	java/io/File:exists	()Z
    //   20: ifeq +9 -> 29
    //   23: aload 4
    //   25: invokevirtual 139	java/io/File:delete	()Z
    //   28: pop
    //   29: new 26	java/io/File
    //   32: dup
    //   33: aload_0
    //   34: invokestatic 136	com/tencent/mobileqq/msf/core/c:h	(Landroid/content/Context;)Ljava/lang/String;
    //   37: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore_0
    //   41: iload_2
    //   42: istore_3
    //   43: aload_0
    //   44: invokevirtual 46	java/io/File:exists	()Z
    //   47: ifeq +70 -> 117
    //   50: new 361	java/io/FileInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 362	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: astore 4
    //   60: iload_2
    //   61: istore_1
    //   62: aload 4
    //   64: astore_0
    //   65: aload 4
    //   67: invokevirtual 363	java/io/FileInputStream:available	()I
    //   70: iconst_4
    //   71: if_icmpne +32 -> 103
    //   74: aload 4
    //   76: astore_0
    //   77: iconst_4
    //   78: newarray byte
    //   80: astore 5
    //   82: aload 4
    //   84: astore_0
    //   85: aload 4
    //   87: aload 5
    //   89: invokevirtual 364	java/io/FileInputStream:read	([B)I
    //   92: pop
    //   93: aload 4
    //   95: astore_0
    //   96: aload 5
    //   98: iconst_0
    //   99: invokestatic 366	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   102: istore_1
    //   103: iload_1
    //   104: istore_3
    //   105: aload 4
    //   107: ifnull +10 -> 117
    //   110: aload 4
    //   112: invokevirtual 367	java/io/FileInputStream:close	()V
    //   115: iload_1
    //   116: istore_3
    //   117: iload_3
    //   118: ireturn
    //   119: astore 5
    //   121: aconst_null
    //   122: astore 4
    //   124: aload 4
    //   126: astore_0
    //   127: aload 5
    //   129: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   132: iload_2
    //   133: istore_3
    //   134: aload 4
    //   136: ifnull -19 -> 117
    //   139: aload 4
    //   141: invokevirtual 367	java/io/FileInputStream:close	()V
    //   144: iconst_m1
    //   145: ireturn
    //   146: astore_0
    //   147: iload_2
    //   148: istore_1
    //   149: aload_0
    //   150: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   153: iload_1
    //   154: ireturn
    //   155: astore 4
    //   157: aconst_null
    //   158: astore_0
    //   159: aload_0
    //   160: ifnull +7 -> 167
    //   163: aload_0
    //   164: invokevirtual 367	java/io/FileInputStream:close	()V
    //   167: aload 4
    //   169: athrow
    //   170: astore_0
    //   171: aload_0
    //   172: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   175: goto -8 -> 167
    //   178: astore_0
    //   179: goto -30 -> 149
    //   182: astore 4
    //   184: goto -25 -> 159
    //   187: astore 5
    //   189: goto -65 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   61	93	1	i	int
    //   1	147	2	j	int
    //   42	92	3	k	int
    //   13	127	4	localObject1	Object
    //   155	13	4	localObject2	Object
    //   182	1	4	localObject3	Object
    //   80	17	5	arrayOfByte	byte[]
    //   119	9	5	localException1	Exception
    //   187	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   50	60	119	java/lang/Exception
    //   139	144	146	java/io/IOException
    //   50	60	155	finally
    //   163	167	170	java/io/IOException
    //   110	115	178	java/io/IOException
    //   65	74	182	finally
    //   77	82	182	finally
    //   85	93	182	finally
    //   96	103	182	finally
    //   127	132	182	finally
    //   65	74	187	java/lang/Exception
    //   77	82	187	java/lang/Exception
    //   85	93	187	java/lang/Exception
    //   96	103	187	java/lang/Exception
  }
  
  public static String h(Context paramContext)
  {
    return paramContext.getFilesDir() + "/verFile";
  }
  
  public static String i(Context paramContext)
  {
    return paramContext.getFilesDir() + "/verFile2";
  }
  
  /* Error */
  public static void j(Context paramContext)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 11
    //   12: iconst_2
    //   13: ldc_w 373
    //   16: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 168	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: ldc_w 375
    //   26: invokevirtual 305	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore 4
    //   31: aload 4
    //   33: astore_2
    //   34: new 144	java/io/FileOutputStream
    //   37: dup
    //   38: new 28	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   45: aload_0
    //   46: invokevirtual 58	android/content/Context:getFilesDir	()Ljava/io/File;
    //   49: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: ldc_w 377
    //   55: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokespecial 378	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   64: astore_0
    //   65: sipush 128
    //   68: newarray byte
    //   70: astore_3
    //   71: aload_2
    //   72: aload_3
    //   73: invokevirtual 122	java/io/InputStream:read	([B)I
    //   76: istore_1
    //   77: iload_1
    //   78: ifle +52 -> 130
    //   81: aload_0
    //   82: aload_3
    //   83: iconst_0
    //   84: iload_1
    //   85: invokevirtual 381	java/io/OutputStream:write	([BII)V
    //   88: goto -17 -> 71
    //   91: astore_3
    //   92: aload_2
    //   93: ifnull +7 -> 100
    //   96: aload_2
    //   97: invokevirtual 311	java/io/InputStream:close	()V
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 382	java/io/OutputStream:close	()V
    //   108: return
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_2
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 311	java/io/InputStream:close	()V
    //   120: aload_3
    //   121: ifnull +7 -> 128
    //   124: aload_3
    //   125: invokevirtual 382	java/io/OutputStream:close	()V
    //   128: aload_0
    //   129: athrow
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 311	java/io/InputStream:close	()V
    //   138: aload_0
    //   139: ifnull -31 -> 108
    //   142: goto -38 -> 104
    //   145: astore_0
    //   146: goto -34 -> 112
    //   149: astore 4
    //   151: aload_0
    //   152: astore_3
    //   153: aload 4
    //   155: astore_0
    //   156: goto -44 -> 112
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_0
    //   162: goto -70 -> 92
    //   165: astore_0
    //   166: aconst_null
    //   167: astore_0
    //   168: goto -76 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramContext	Context
    //   76	9	1	i	int
    //   3	132	2	localObject1	Object
    //   1	82	3	arrayOfByte	byte[]
    //   91	34	3	localException	Exception
    //   152	1	3	localContext	Context
    //   29	3	4	localInputStream	InputStream
    //   149	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   65	71	91	java/lang/Exception
    //   71	77	91	java/lang/Exception
    //   81	88	91	java/lang/Exception
    //   19	31	109	finally
    //   34	65	145	finally
    //   65	71	149	finally
    //   71	77	149	finally
    //   81	88	149	finally
    //   19	31	159	java/lang/Exception
    //   34	65	165	java/lang/Exception
  }
  
  public static long k(Context paramContext)
  {
    try
    {
      paramContext = new StatFs(d(paramContext));
      long l = paramContext.getBlockSize();
      l = paramContext.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception paramContext) {}
    return 0L;
  }
  
  private static String[] l(Context paramContext)
  {
    int k = 0;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    for (;;)
    {
      try
      {
        paramContext = new FileInputStream(paramContext.getFilesDir() + "/jni.ini");
        if (paramContext == null) {}
      }
      catch (IOException paramContext)
      {
        int i;
        String str;
        int j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.CoreUtil", 2, "get oldJniID FileNotFoundException " + paramContext.getMessage());
        paramContext.printStackTrace();
        continue;
        j += 1;
        continue;
      }
      try
      {
        paramContext = new BufferedReader(new InputStreamReader(paramContext));
        i = 0;
        str = paramContext.readLine();
        j = k;
        if (str != null)
        {
          j = k;
          if (i < 2)
          {
            arrayOfString[i] = str;
            i += 1;
            continue;
          }
        }
        if (j < arrayOfString.length)
        {
          if (arrayOfString[j] == null) {
            continue;
          }
          arrayOfString[j].trim();
          if (arrayOfString[j].length() <= 4) {
            continue;
          }
          arrayOfString[j] = arrayOfString[j].substring(4);
          continue;
        }
        paramContext.close();
      }
      catch (IOException paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.CoreUtil", 2, "get oldJniID IOException " + paramContext.getMessage());
      }
    }
    QLog.d("MSF.C.CoreUtil", 1, "get old jni id = " + Arrays.toString(arrayOfString));
    return arrayOfString;
  }
  
  private static String[] m(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      try
      {
        localObject = paramContext.getAssets().open("jni.ini");
        paramContext = arrayOfString;
        if (localObject == null) {
          continue;
        }
        paramContext = new BufferedReader(new InputStreamReader((InputStream)localObject));
        i = 0;
        localObject = paramContext.readLine();
        if (localObject == null) {
          break label223;
        }
        j = 1;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.CoreUtil", 2, "read jni error " + paramContext);
        paramContext = new String[2];
        paramContext[0] = "0";
        paramContext[1] = "0";
        QLog.d("MSF.C.CoreUtil", 1, "get new jni id = " + Arrays.toString(paramContext));
        return paramContext;
      }
      paramContext = arrayOfString;
      if (i < arrayOfString.length)
      {
        if (arrayOfString[i] != null)
        {
          arrayOfString[i].trim();
          if (arrayOfString[i].length() > 4) {
            arrayOfString[i] = arrayOfString[i].substring(4);
          }
        }
        i += 1;
      }
      else
      {
        label197:
        if (i < 2) {}
        for (int k = 1;; k = 0)
        {
          if ((k & j) == 0) {
            break label233;
          }
          arrayOfString[i] = localObject;
          i += 1;
          break;
          label223:
          j = 0;
          break label197;
        }
        label233:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c
 * JD-Core Version:    0.7.0.1
 */