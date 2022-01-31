package com.qzone.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class PropertyUtil
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
    catch (Throwable localThrowable) {}
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
  
  /* Error */
  private static String getWithCmd(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_3
    //   2: invokestatic 67	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: new 69	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 71
    //   11: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokevirtual 86	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   24: astore 5
    //   26: aconst_null
    //   27: astore_3
    //   28: aconst_null
    //   29: astore 4
    //   31: new 88	java/io/BufferedReader
    //   34: dup
    //   35: new 90	java/io/InputStreamReader
    //   38: dup
    //   39: aload 5
    //   41: invokevirtual 96	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: invokespecial 99	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   47: invokespecial 102	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_0
    //   51: new 69	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   58: astore_3
    //   59: aload_0
    //   60: invokevirtual 106	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore 4
    //   65: aload 4
    //   67: ifnonnull +41 -> 108
    //   70: aload_3
    //   71: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore_3
    //   75: aload_3
    //   76: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: istore_2
    //   80: iload_2
    //   81: ifne +5 -> 86
    //   84: aload_3
    //   85: astore_1
    //   86: aload_0
    //   87: ifnull +78 -> 165
    //   90: aload_1
    //   91: astore_3
    //   92: aload_0
    //   93: invokevirtual 109	java/io/BufferedReader:close	()V
    //   96: goto +69 -> 165
    //   99: aload_0
    //   100: astore_3
    //   101: aload 5
    //   103: invokevirtual 112	java/lang/Process:destroy	()V
    //   106: aload_0
    //   107: areturn
    //   108: aload_3
    //   109: aload 4
    //   111: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: goto -56 -> 59
    //   118: astore_3
    //   119: aload_0
    //   120: astore 4
    //   122: aload_1
    //   123: astore_0
    //   124: aload 4
    //   126: ifnull -27 -> 99
    //   129: aload_1
    //   130: astore_3
    //   131: aload 4
    //   133: invokevirtual 109	java/io/BufferedReader:close	()V
    //   136: aload_1
    //   137: astore_0
    //   138: goto -39 -> 99
    //   141: aload_0
    //   142: ifnull +9 -> 151
    //   145: aload_1
    //   146: astore_3
    //   147: aload_0
    //   148: invokevirtual 109	java/io/BufferedReader:close	()V
    //   151: aload_1
    //   152: astore_3
    //   153: aload 4
    //   155: athrow
    //   156: astore 4
    //   158: goto -17 -> 141
    //   161: astore_0
    //   162: goto -40 -> 122
    //   165: aload_1
    //   166: astore_0
    //   167: goto -68 -> 99
    //   170: astore_0
    //   171: aload_3
    //   172: areturn
    //   173: astore 4
    //   175: aload_3
    //   176: astore_0
    //   177: goto -36 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramString1	String
    //   0	180	1	paramString2	String
    //   79	2	2	bool	boolean
    //   1	108	3	localObject1	Object
    //   118	1	3	localIOException	java.io.IOException
    //   130	46	3	str1	String
    //   29	125	4	str2	String
    //   156	1	4	localObject2	Object
    //   173	1	4	localObject3	Object
    //   24	78	5	localProcess	java.lang.Process
    // Exception table:
    //   from	to	target	type
    //   51	59	118	java/io/IOException
    //   59	65	118	java/io/IOException
    //   70	80	118	java/io/IOException
    //   108	115	118	java/io/IOException
    //   51	59	156	finally
    //   59	65	156	finally
    //   70	80	156	finally
    //   108	115	156	finally
    //   31	51	161	java/io/IOException
    //   2	26	170	java/lang/Throwable
    //   92	96	170	java/lang/Throwable
    //   101	106	170	java/lang/Throwable
    //   131	136	170	java/lang/Throwable
    //   147	151	170	java/lang/Throwable
    //   153	156	170	java/lang/Throwable
    //   31	51	173	finally
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
    catch (Throwable paramString1) {}
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.PropertyUtil
 * JD-Core Version:    0.7.0.1
 */