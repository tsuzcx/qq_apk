package com.tencent.turingfd.sdk.base;

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

public class u
{
  public static String a = "EnvUtil";
  public static Integer b;
  
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
      localObject = bt.a.getClassLoader();
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
  
  /* Error */
  public static String a(boolean paramBoolean)
  {
    // Byte code:
    //   0: new 117	java/io/FileInputStream
    //   3: dup
    //   4: ldc 119
    //   6: invokespecial 120	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   9: astore_1
    //   10: new 122	java/io/BufferedReader
    //   13: dup
    //   14: new 124	java/io/InputStreamReader
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 127	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: sipush 8192
    //   25: invokespecial 130	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   28: astore_3
    //   29: new 15	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 106
    //   35: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: astore_2
    //   39: aload_3
    //   40: invokevirtual 133	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore 4
    //   45: aload 4
    //   47: ifnull +13 -> 60
    //   50: aload_2
    //   51: aload 4
    //   53: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: goto -18 -> 39
    //   60: aload_3
    //   61: invokevirtual 134	java/io/BufferedReader:close	()V
    //   64: goto +11 -> 75
    //   67: astore_3
    //   68: getstatic 136	com/tencent/turingfd/sdk/base/u:a	Ljava/lang/String;
    //   71: aload_3
    //   72: invokestatic 141	com/tencent/turingfd/sdk/base/bv:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   75: aload_1
    //   76: invokevirtual 142	java/io/FileInputStream:close	()V
    //   79: goto +52 -> 131
    //   82: astore_1
    //   83: goto +41 -> 124
    //   86: astore 4
    //   88: goto +106 -> 194
    //   91: astore 4
    //   93: getstatic 136	com/tencent/turingfd/sdk/base/u:a	Ljava/lang/String;
    //   96: aload 4
    //   98: invokestatic 141	com/tencent/turingfd/sdk/base/bv:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   101: aload_3
    //   102: invokevirtual 134	java/io/BufferedReader:close	()V
    //   105: goto +11 -> 116
    //   108: astore_3
    //   109: getstatic 136	com/tencent/turingfd/sdk/base/u:a	Ljava/lang/String;
    //   112: aload_3
    //   113: invokestatic 141	com/tencent/turingfd/sdk/base/bv:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   116: aload_1
    //   117: invokevirtual 142	java/io/FileInputStream:close	()V
    //   120: goto +11 -> 131
    //   123: astore_1
    //   124: getstatic 136	com/tencent/turingfd/sdk/base/u:a	Ljava/lang/String;
    //   127: aload_1
    //   128: invokestatic 141	com/tencent/turingfd/sdk/base/bv:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   131: aload_2
    //   132: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore_1
    //   136: iload_0
    //   137: ifne +5 -> 142
    //   140: aload_1
    //   141: areturn
    //   142: aload_1
    //   143: ifnull +48 -> 191
    //   146: aload_1
    //   147: ldc 106
    //   149: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   152: ifne +39 -> 191
    //   155: aload_1
    //   156: aload_1
    //   157: ldc 148
    //   159: invokevirtual 152	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   162: bipush 8
    //   164: iadd
    //   165: invokevirtual 156	java/lang/String:substring	(I)Ljava/lang/String;
    //   168: astore_1
    //   169: aload_1
    //   170: iconst_0
    //   171: aload_1
    //   172: ldc 158
    //   174: invokevirtual 152	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   177: invokevirtual 161	java/lang/String:substring	(II)Ljava/lang/String;
    //   180: astore_1
    //   181: aload_1
    //   182: areturn
    //   183: astore_1
    //   184: getstatic 136	com/tencent/turingfd/sdk/base/u:a	Ljava/lang/String;
    //   187: aload_1
    //   188: invokestatic 141	com/tencent/turingfd/sdk/base/bv:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   191: ldc 106
    //   193: areturn
    //   194: aload_3
    //   195: invokevirtual 134	java/io/BufferedReader:close	()V
    //   198: goto +11 -> 209
    //   201: astore_3
    //   202: getstatic 136	com/tencent/turingfd/sdk/base/u:a	Ljava/lang/String;
    //   205: aload_3
    //   206: invokestatic 141	com/tencent/turingfd/sdk/base/bv:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   209: aload_1
    //   210: invokevirtual 142	java/io/FileInputStream:close	()V
    //   213: goto +11 -> 224
    //   216: astore_1
    //   217: getstatic 136	com/tencent/turingfd/sdk/base/u:a	Ljava/lang/String;
    //   220: aload_1
    //   221: invokestatic 141	com/tencent/turingfd/sdk/base/bv:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   224: aload_2
    //   225: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: pop
    //   229: aload 4
    //   231: athrow
    //   232: astore_1
    //   233: getstatic 136	com/tencent/turingfd/sdk/base/u:a	Ljava/lang/String;
    //   236: aload_1
    //   237: invokestatic 141	com/tencent/turingfd/sdk/base/bv:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   240: ldc 106
    //   242: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramBoolean	boolean
    //   9	67	1	localFileInputStream	java.io.FileInputStream
    //   82	35	1	localThrowable1	Throwable
    //   123	5	1	localThrowable2	Throwable
    //   135	47	1	str1	String
    //   183	27	1	localThrowable3	Throwable
    //   216	5	1	localThrowable4	Throwable
    //   232	5	1	localThrowable5	Throwable
    //   38	187	2	localStringBuilder	StringBuilder
    //   28	33	3	localBufferedReader	java.io.BufferedReader
    //   67	35	3	localThrowable6	Throwable
    //   108	87	3	localThrowable7	Throwable
    //   201	5	3	localThrowable8	Throwable
    //   43	9	4	str2	String
    //   86	1	4	localObject	Object
    //   91	139	4	localThrowable9	Throwable
    // Exception table:
    //   from	to	target	type
    //   60	64	67	java/lang/Throwable
    //   75	79	82	java/lang/Throwable
    //   39	45	86	finally
    //   50	57	86	finally
    //   93	101	86	finally
    //   39	45	91	java/lang/Throwable
    //   50	57	91	java/lang/Throwable
    //   101	105	108	java/lang/Throwable
    //   116	120	123	java/lang/Throwable
    //   155	169	183	java/lang/Throwable
    //   169	181	183	java/lang/Throwable
    //   194	198	201	java/lang/Throwable
    //   209	213	216	java/lang/Throwable
    //   0	10	232	java/lang/Throwable
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
    String str2 = Build.MANUFACTURER;
    String str1 = str2;
    if (str2 == null) {
      str1 = "UNKNOWN";
    }
    return str1;
  }
  
  public static String d()
  {
    try
    {
      Object localObject = Class.forName("android.os.Build");
      localObject = (String)((Class)localObject).getMethod("getRadioVersion", new Class[0]).invoke(null, new Object[0]);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      String str = a;
      bv.a.a(5, str, bv.a(localThrowable));
    }
    return "";
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
          localObject1 = by.a("ro.build.version.emui");
          return localObject1;
        }
        bool = ((String)localObject1).contains("xiaomi");
        if (bool)
        {
          localObject1 = by.a("ro.miui.ui.version.name");
          return localObject1;
        }
        bool = ((String)localObject1).contains("gionee");
        if (bool)
        {
          localObject1 = by.a("ro.gn.extvernumber");
          bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (bool) {
            localObject1 = by.a("ro.build.display.id");
          }
          return localObject1;
        }
        bool = ((String)localObject1).contains("vivo");
        if (bool)
        {
          localObject1 = by.a("ro.vivo.os.name");
          str = by.a("ro.vivo.os.version");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("_");
            localStringBuilder.append(str);
            localObject1 = localStringBuilder.toString();
            return localObject1;
          }
          localObject1 = by.a("ro.vivo.os.build.display.id");
          return localObject1;
        }
        bool = ((String)localObject1).contains("meizu");
        if (bool)
        {
          localObject1 = by.a("ro.build.display.id");
          return localObject1;
        }
        bool = ((String)localObject1).contains("lenovo");
        if (bool)
        {
          localObject1 = by.a("ro.lenovo.lvp.version");
          bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (bool) {
            break label311;
          }
          localObject1 = ((String)localObject1).split("_");
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label311;
          }
          localObject1 = localObject1[0];
          bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (bool) {
            localObject1 = by.a("ro.build.version.incremental");
          }
          return localObject1;
        }
        bool = ((String)localObject1).contains("letv");
        if (bool)
        {
          localObject1 = by.a("ro.letv.eui");
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        String str = a;
        bv.a.a(5, str, bv.a(localException));
      }
      return null;
      label311:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.u
 * JD-Core Version:    0.7.0.1
 */