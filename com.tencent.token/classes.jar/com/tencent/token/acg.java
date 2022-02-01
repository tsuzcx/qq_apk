package com.tencent.token;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Locale;

public final class acg
{
  public static Integer a;
  
  public static String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2;
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1) {
        localStringBuilder1.append(new String(arrayOfByte));
      }
      localInputStream.close();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      localStringBuilder2 = new StringBuilder("N/A");
    }
    return localStringBuilder2.toString().trim();
  }
  
  public static String a(String paramString)
  {
    try
    {
      localObject = aef.a.getClassLoader();
      localObject = ((ClassLoader)localObject).loadClass("android.os.SystemProperties");
      Method localMethod = ((Class)localObject).getMethod("get", new Class[] { String.class, String.class });
      paramString = new String(paramString);
      paramString = (String)localMethod.invoke(localObject, new Object[] { paramString, new String("") });
    }
    catch (IllegalArgumentException paramString)
    {
      Object localObject;
      throw paramString;
    }
    catch (Exception paramString)
    {
      label76:
      break label76;
    }
    paramString = "";
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public static long b()
  {
    long l1 = 0L;
    try
    {
      localFile = Environment.getRootDirectory();
      localObject = localFile;
      if (!localFile.exists()) {
        localObject = new File("/system");
      }
      localObject = new StatFs(((File)localObject).getPath());
      l2 = ((StatFs)localObject).getBlockSize();
      i = ((StatFs)localObject).getBlockCount();
      l3 = i;
    }
    catch (Throwable localThrowable1)
    {
      File localFile;
      Object localObject;
      long l2;
      int i;
      long l3;
      long l4;
      label123:
      return 0L;
    }
    try
    {
      localFile = Environment.getDataDirectory();
      localObject = localFile;
      if (!localFile.exists()) {
        localObject = new File("/data");
      }
      localObject = new StatFs(((File)localObject).getPath());
      l4 = ((StatFs)localObject).getBlockSize();
      i = ((StatFs)localObject).getBlockCount();
      l1 = i * l4;
    }
    catch (Throwable localThrowable2)
    {
      break label123;
    }
    return l1 + l2 * l3;
  }
  
  public static String c()
  {
    try
    {
      Object localObject = Class.forName("android.os.Build");
      localObject = (String)((Class)localObject).getMethod("getRadioVersion", new Class[0]).invoke(null, new Object[0]);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      aej localaej = aeh.a;
      aeh.b(localThrowable);
    }
    return "";
  }
  
  /* Error */
  public static String d()
  {
    // Byte code:
    //   0: new 164	java/io/FileInputStream
    //   3: dup
    //   4: ldc 166
    //   6: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   9: astore_0
    //   10: new 169	java/io/BufferedReader
    //   13: dup
    //   14: new 171	java/io/InputStreamReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 174	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: sipush 8192
    //   25: invokespecial 177	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   28: astore_2
    //   29: new 11	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 102
    //   35: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 180	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +12 -> 57
    //   48: aload_1
    //   49: aload_3
    //   50: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: goto -15 -> 39
    //   57: aload_2
    //   58: invokevirtual 181	java/io/BufferedReader:close	()V
    //   61: goto +8 -> 69
    //   64: astore_2
    //   65: aload_2
    //   66: invokestatic 184	com/tencent/token/aeh:a	(Ljava/lang/Object;)V
    //   69: aload_0
    //   70: invokevirtual 185	java/io/FileInputStream:close	()V
    //   73: goto +40 -> 113
    //   76: astore_0
    //   77: goto +32 -> 109
    //   80: astore_1
    //   81: goto +37 -> 118
    //   84: astore_3
    //   85: aload_3
    //   86: invokestatic 184	com/tencent/token/aeh:a	(Ljava/lang/Object;)V
    //   89: aload_2
    //   90: invokevirtual 181	java/io/BufferedReader:close	()V
    //   93: goto +8 -> 101
    //   96: astore_2
    //   97: aload_2
    //   98: invokestatic 184	com/tencent/token/aeh:a	(Ljava/lang/Object;)V
    //   101: aload_0
    //   102: invokevirtual 185	java/io/FileInputStream:close	()V
    //   105: goto +8 -> 113
    //   108: astore_0
    //   109: aload_0
    //   110: invokestatic 184	com/tencent/token/aeh:a	(Ljava/lang/Object;)V
    //   113: aload_1
    //   114: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: areturn
    //   118: aload_2
    //   119: invokevirtual 181	java/io/BufferedReader:close	()V
    //   122: goto +8 -> 130
    //   125: astore_2
    //   126: aload_2
    //   127: invokestatic 184	com/tencent/token/aeh:a	(Ljava/lang/Object;)V
    //   130: aload_0
    //   131: invokevirtual 185	java/io/FileInputStream:close	()V
    //   134: goto +8 -> 142
    //   137: astore_0
    //   138: aload_0
    //   139: invokestatic 184	com/tencent/token/aeh:a	(Ljava/lang/Object;)V
    //   142: aload_1
    //   143: athrow
    //   144: astore_0
    //   145: aload_0
    //   146: invokestatic 184	com/tencent/token/aeh:a	(Ljava/lang/Object;)V
    //   149: ldc 102
    //   151: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	61	0	localFileInputStream	java.io.FileInputStream
    //   76	26	0	localThrowable1	Throwable
    //   108	23	0	localThrowable2	Throwable
    //   137	2	0	localThrowable3	Throwable
    //   144	2	0	localThrowable4	Throwable
    //   38	11	1	localStringBuilder	StringBuilder
    //   80	63	1	localObject	Object
    //   28	30	2	localBufferedReader	java.io.BufferedReader
    //   64	26	2	localThrowable5	Throwable
    //   96	23	2	localThrowable6	Throwable
    //   125	2	2	localThrowable7	Throwable
    //   43	7	3	str	String
    //   84	2	3	localThrowable8	Throwable
    // Exception table:
    //   from	to	target	type
    //   57	61	64	java/lang/Throwable
    //   69	73	76	java/lang/Throwable
    //   39	44	80	finally
    //   48	54	80	finally
    //   85	89	80	finally
    //   39	44	84	java/lang/Throwable
    //   48	54	84	java/lang/Throwable
    //   89	93	96	java/lang/Throwable
    //   101	105	108	java/lang/Throwable
    //   118	122	125	java/lang/Throwable
    //   130	134	137	java/lang/Throwable
    //   0	10	144	java/lang/Throwable
  }
  
  public static String e()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = Build.MANUFACTURER;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return null;
        }
        localObject1 = ((String)localObject1).toLowerCase(Locale.ENGLISH);
        boolean bool = ((String)localObject1).contains("huawei");
        if (bool)
        {
          localObject1 = aek.a("ro.build.version.emui");
          return localObject1;
        }
        bool = ((String)localObject1).contains("xiaomi");
        if (bool)
        {
          localObject1 = aek.a("ro.miui.ui.version.name");
          return localObject1;
        }
        bool = ((String)localObject1).contains("gionee");
        if (bool)
        {
          localObject1 = aek.a("ro.gn.extvernumber");
          bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (bool) {
            localObject1 = aek.a("ro.build.display.id");
          }
          return localObject1;
        }
        bool = ((String)localObject1).contains("vivo");
        if (bool)
        {
          localObject1 = aek.a("ro.vivo.os.name");
          localObject3 = aek.a("ro.vivo.os.version");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("_");
            localStringBuilder.append((String)localObject3);
            localObject1 = localStringBuilder.toString();
            return localObject1;
          }
          localObject1 = aek.a("ro.vivo.os.build.display.id");
          return localObject1;
        }
        bool = ((String)localObject1).contains("meizu");
        if (bool)
        {
          localObject1 = aek.a("ro.build.display.id");
          return localObject1;
        }
        bool = ((String)localObject1).contains("lenovo");
        if (bool)
        {
          localObject1 = aek.a("ro.lenovo.lvp.version");
          bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (bool) {
            break label288;
          }
          localObject1 = ((String)localObject1).split("_");
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label288;
          }
          localObject1 = localObject1[0];
          bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (bool) {
            localObject1 = aek.a("ro.build.version.incremental");
          }
          return localObject1;
        }
        bool = ((String)localObject1).contains("letv");
        if (bool)
        {
          localObject1 = aek.a("ro.letv.eui");
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        Object localObject3 = aeh.a;
        aeh.b(localException);
      }
      return null;
      label288:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acg
 * JD-Core Version:    0.7.0.1
 */