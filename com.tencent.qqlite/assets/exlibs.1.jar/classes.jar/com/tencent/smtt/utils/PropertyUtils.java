package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class PropertyUtils
{
  private static final String CMD_GET_PROP = "getprop";
  public static final String PROPERTY_DNS_PRIMARY = "net.dns1";
  public static final String PROPERTY_DNS_SECNDARY = "net.dns2";
  private static Class sClassSystemProperties;
  private static Method sMethodGetString;
  
  static
  {
    try
    {
      sClassSystemProperties = Class.forName("android.os.SystemProperties");
      sMethodGetString = sClassSystemProperties.getDeclaredMethod("get", new Class[] { String.class, String.class });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public static String get(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    String str2 = getWithReflect(paramString1, null);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = getWithCmd(paramString1, null);
    }
    paramString1 = str1;
    if (TextUtils.isEmpty(str1)) {
      paramString1 = paramString2;
    }
    return paramString1;
  }
  
  public static String getQuickly(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return getWithReflect(paramString1, paramString2);
  }
  
  /* Error */
  private static String getWithCmd(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_3
    //   2: invokestatic 71	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: new 73	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   12: ldc 76
    //   14: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 88	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   27: astore 5
    //   29: aconst_null
    //   30: astore_3
    //   31: aconst_null
    //   32: astore 4
    //   34: new 90	java/io/BufferedReader
    //   37: dup
    //   38: new 92	java/io/InputStreamReader
    //   41: dup
    //   42: aload 5
    //   44: invokevirtual 98	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   47: invokespecial 101	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   50: invokespecial 104	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   53: astore_0
    //   54: new 73	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   61: astore_3
    //   62: aload_0
    //   63: invokevirtual 107	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: astore 4
    //   68: aload 4
    //   70: ifnull +42 -> 112
    //   73: aload_3
    //   74: aload 4
    //   76: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: goto -18 -> 62
    //   83: astore_3
    //   84: aload_0
    //   85: astore 4
    //   87: aload_1
    //   88: astore_0
    //   89: aload 4
    //   91: ifnull +12 -> 103
    //   94: aload_1
    //   95: astore_3
    //   96: aload 4
    //   98: invokevirtual 110	java/io/BufferedReader:close	()V
    //   101: aload_1
    //   102: astore_0
    //   103: aload_0
    //   104: astore_3
    //   105: aload 5
    //   107: invokevirtual 113	java/lang/Process:destroy	()V
    //   110: aload_0
    //   111: areturn
    //   112: aload_3
    //   113: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore_3
    //   117: aload_3
    //   118: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   121: istore_2
    //   122: iload_2
    //   123: ifne +5 -> 128
    //   126: aload_3
    //   127: astore_1
    //   128: aload_0
    //   129: ifnull +43 -> 172
    //   132: aload_1
    //   133: astore_3
    //   134: aload_0
    //   135: invokevirtual 110	java/io/BufferedReader:close	()V
    //   138: goto +34 -> 172
    //   141: aload_0
    //   142: ifnull +9 -> 151
    //   145: aload_1
    //   146: astore_3
    //   147: aload_0
    //   148: invokevirtual 110	java/io/BufferedReader:close	()V
    //   151: aload_1
    //   152: astore_3
    //   153: aload 4
    //   155: athrow
    //   156: astore_0
    //   157: aload_0
    //   158: invokevirtual 45	java/lang/Throwable:printStackTrace	()V
    //   161: aload_3
    //   162: areturn
    //   163: astore 4
    //   165: goto -24 -> 141
    //   168: astore_0
    //   169: goto -82 -> 87
    //   172: aload_1
    //   173: astore_0
    //   174: goto -71 -> 103
    //   177: astore 4
    //   179: aload_3
    //   180: astore_0
    //   181: goto -40 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramString1	String
    //   0	184	1	paramString2	String
    //   121	2	2	bool	boolean
    //   1	73	3	localObject1	Object
    //   83	1	3	localIOException	java.io.IOException
    //   95	85	3	str1	String
    //   32	122	4	str2	String
    //   163	1	4	localObject2	Object
    //   177	1	4	localObject3	Object
    //   27	79	5	localProcess	java.lang.Process
    // Exception table:
    //   from	to	target	type
    //   54	62	83	java/io/IOException
    //   62	68	83	java/io/IOException
    //   73	80	83	java/io/IOException
    //   112	122	83	java/io/IOException
    //   2	29	156	java/lang/Throwable
    //   96	101	156	java/lang/Throwable
    //   105	110	156	java/lang/Throwable
    //   134	138	156	java/lang/Throwable
    //   147	151	156	java/lang/Throwable
    //   153	156	156	java/lang/Throwable
    //   54	62	163	finally
    //   62	68	163	finally
    //   73	80	163	finally
    //   112	122	163	finally
    //   34	54	168	java/io/IOException
    //   34	54	177	finally
  }
  
  private static String getWithReflect(String paramString1, String paramString2)
  {
    if ((sClassSystemProperties == null) || (sMethodGetString == null)) {
      return paramString2;
    }
    try
    {
      paramString1 = (String)sMethodGetString.invoke(sClassSystemProperties, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.PropertyUtils
 * JD-Core Version:    0.7.0.1
 */