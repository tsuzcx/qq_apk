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

public class aj
{
  public static String a = "EnvUtil";
  public static Integer b;
  
  public static String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    InputStream localInputStream;
    try
    {
      localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1)
      {
        localStringBuilder1.append(new String(arrayOfByte));
        continue;
        StringBuilder localStringBuilder2;
        return localStringBuilder2.toString().trim();
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      localStringBuilder2 = new StringBuilder("N/A");
    }
    for (;;)
    {
      localInputStream.close();
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      localObject = cm.a.getClassLoader();
      localObject = ((ClassLoader)localObject).loadClass("android.os.SystemProperties");
      Method localMethod = ((Class)localObject).getMethod("get", new Class[] { String.class, String.class });
      paramString = new String(paramString);
      paramString = (String)localMethod.invoke(localObject, new Object[] { paramString, new String("") });
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        paramString = "";
      }
    }
    catch (IllegalArgumentException paramString)
    {
      throw paramString;
    }
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
    //   35: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: astore_2
    //   39: aload_3
    //   40: invokevirtual 133	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore 4
    //   45: aload 4
    //   47: ifnull +42 -> 89
    //   50: aload_2
    //   51: aload 4
    //   53: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: goto -18 -> 39
    //   60: astore 4
    //   62: getstatic 135	com/tencent/turingfd/sdk/base/aj:a	Ljava/lang/String;
    //   65: aload 4
    //   67: invokestatic 140	com/tencent/turingfd/sdk/base/cq:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   70: aload_3
    //   71: invokevirtual 141	java/io/BufferedReader:close	()V
    //   74: aload_1
    //   75: invokevirtual 142	java/io/FileInputStream:close	()V
    //   78: aload_2
    //   79: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_1
    //   83: iload_0
    //   84: ifne +49 -> 133
    //   87: aload_1
    //   88: areturn
    //   89: aload_3
    //   90: invokevirtual 141	java/io/BufferedReader:close	()V
    //   93: aload_1
    //   94: invokevirtual 142	java/io/FileInputStream:close	()V
    //   97: goto -19 -> 78
    //   100: astore_1
    //   101: getstatic 135	com/tencent/turingfd/sdk/base/aj:a	Ljava/lang/String;
    //   104: aload_1
    //   105: invokestatic 140	com/tencent/turingfd/sdk/base/cq:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   108: goto -30 -> 78
    //   111: astore_3
    //   112: getstatic 135	com/tencent/turingfd/sdk/base/aj:a	Ljava/lang/String;
    //   115: aload_3
    //   116: invokestatic 140	com/tencent/turingfd/sdk/base/cq:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   119: goto -26 -> 93
    //   122: astore_3
    //   123: getstatic 135	com/tencent/turingfd/sdk/base/aj:a	Ljava/lang/String;
    //   126: aload_3
    //   127: invokestatic 140	com/tencent/turingfd/sdk/base/cq:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   130: goto -56 -> 74
    //   133: aload_1
    //   134: ifnull +48 -> 182
    //   137: aload_1
    //   138: ldc 106
    //   140: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifne +39 -> 182
    //   146: aload_1
    //   147: aload_1
    //   148: ldc 148
    //   150: invokevirtual 152	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   153: bipush 8
    //   155: iadd
    //   156: invokevirtual 156	java/lang/String:substring	(I)Ljava/lang/String;
    //   159: astore_1
    //   160: aload_1
    //   161: iconst_0
    //   162: aload_1
    //   163: ldc 158
    //   165: invokevirtual 152	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   168: invokevirtual 161	java/lang/String:substring	(II)Ljava/lang/String;
    //   171: astore_1
    //   172: aload_1
    //   173: areturn
    //   174: astore_1
    //   175: getstatic 135	com/tencent/turingfd/sdk/base/aj:a	Ljava/lang/String;
    //   178: aload_1
    //   179: invokestatic 140	com/tencent/turingfd/sdk/base/cq:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   182: ldc 106
    //   184: areturn
    //   185: astore 4
    //   187: aload_3
    //   188: invokevirtual 141	java/io/BufferedReader:close	()V
    //   191: aload_1
    //   192: invokevirtual 142	java/io/FileInputStream:close	()V
    //   195: aload_2
    //   196: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: pop
    //   200: aload 4
    //   202: athrow
    //   203: astore_3
    //   204: getstatic 135	com/tencent/turingfd/sdk/base/aj:a	Ljava/lang/String;
    //   207: aload_3
    //   208: invokestatic 140	com/tencent/turingfd/sdk/base/cq:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   211: goto -20 -> 191
    //   214: astore_1
    //   215: getstatic 135	com/tencent/turingfd/sdk/base/aj:a	Ljava/lang/String;
    //   218: aload_1
    //   219: invokestatic 140	com/tencent/turingfd/sdk/base/cq:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   222: goto -27 -> 195
    //   225: astore_1
    //   226: getstatic 135	com/tencent/turingfd/sdk/base/aj:a	Ljava/lang/String;
    //   229: aload_1
    //   230: invokestatic 140	com/tencent/turingfd/sdk/base/cq:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   233: ldc 106
    //   235: areturn
    //   236: astore_1
    //   237: goto -136 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramBoolean	boolean
    //   9	85	1	localObject1	Object
    //   100	48	1	localThrowable1	Throwable
    //   159	14	1	str1	String
    //   174	18	1	localThrowable2	Throwable
    //   214	5	1	localThrowable3	Throwable
    //   225	5	1	localThrowable4	Throwable
    //   236	1	1	localThrowable5	Throwable
    //   38	158	2	localStringBuilder	StringBuilder
    //   28	62	3	localBufferedReader	java.io.BufferedReader
    //   111	5	3	localThrowable6	Throwable
    //   122	66	3	localThrowable7	Throwable
    //   203	5	3	localThrowable8	Throwable
    //   43	9	4	str2	String
    //   60	6	4	localThrowable9	Throwable
    //   185	16	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   39	45	60	java/lang/Throwable
    //   50	57	60	java/lang/Throwable
    //   93	97	100	java/lang/Throwable
    //   89	93	111	java/lang/Throwable
    //   70	74	122	java/lang/Throwable
    //   146	160	174	java/lang/Throwable
    //   160	172	174	java/lang/Throwable
    //   39	45	185	finally
    //   50	57	185	finally
    //   62	70	185	finally
    //   187	191	203	java/lang/Throwable
    //   191	195	214	java/lang/Throwable
    //   0	10	225	java/lang/Throwable
    //   74	78	236	java/lang/Throwable
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
      cq.a.a(5, str, cq.a(localThrowable));
    }
    return "";
  }
  
  public static String e()
  {
    label302:
    String str;
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
          localObject1 = cu.a("ro.build.version.emui");
          return localObject1;
        }
        bool = ((String)localObject1).contains("xiaomi");
        if (bool)
        {
          localObject1 = cu.a("ro.miui.ui.version.name");
          return localObject1;
        }
        bool = ((String)localObject1).contains("gionee");
        if (bool)
        {
          localObject1 = cu.a("ro.gn.extvernumber");
          bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (!bool) {
            break;
          }
          localObject1 = cu.a("ro.build.display.id");
          return localObject1;
        }
        bool = ((String)localObject1).contains("vivo");
        if (bool)
        {
          localObject2 = cu.a("ro.vivo.os.name");
          localObject1 = cu.a("ro.vivo.os.version");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localObject2 = new StringBuilder().append((String)localObject2);
            localObject1 = "_" + (String)localObject1;
            return localObject1;
          }
          localObject1 = cu.a("ro.vivo.os.build.display.id");
          return localObject1;
        }
        bool = ((String)localObject1).contains("meizu");
        if (bool)
        {
          localObject1 = cu.a("ro.build.display.id");
          return localObject1;
        }
        bool = ((String)localObject1).contains("lenovo");
        if (bool)
        {
          localObject1 = cu.a("ro.lenovo.lvp.version");
          bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (bool) {
            break label302;
          }
          localObject1 = ((String)localObject1).split("_");
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label302;
          }
          localObject1 = localObject1[0];
          bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (!bool) {
            break;
          }
          localObject1 = cu.a("ro.build.version.incremental");
          return localObject1;
        }
        bool = ((String)localObject1).contains("letv");
        if (bool)
        {
          localObject1 = cu.a("ro.letv.eui");
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = a;
        cq.a.a(5, (String)localObject2, cq.a(localException));
      }
      return null;
      str = null;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.aj
 * JD-Core Version:    0.7.0.1
 */