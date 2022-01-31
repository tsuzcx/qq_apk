package com.tencent.component.network.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public final class d
{
  private static Class a;
  private static Method b;
  
  static
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      a = localClass;
      b = localClass.getDeclaredMethod("get", new Class[] { String.class, String.class });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str2 = b(paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = c(paramString);
    }
    paramString = str1;
    if (TextUtils.isEmpty(str1)) {
      paramString = null;
    }
    return paramString;
  }
  
  private static String b(String paramString)
  {
    if ((a == null) || (b == null)) {
      return null;
    }
    try
    {
      paramString = (String)b.invoke(a, new Object[] { paramString, null });
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  /* Error */
  private static String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 59	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: new 61	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 63
    //   11: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokevirtual 79	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   24: astore 5
    //   26: new 81	java/io/BufferedReader
    //   29: dup
    //   30: new 83	java/io/InputStreamReader
    //   33: dup
    //   34: aload 5
    //   36: invokevirtual 89	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   39: invokespecial 92	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   42: invokespecial 95	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_0
    //   46: new 61	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   53: astore_3
    //   54: aload_0
    //   55: invokevirtual 100	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   58: astore 4
    //   60: aload 4
    //   62: ifnonnull +39 -> 101
    //   65: aload_3
    //   66: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore 4
    //   71: aload 4
    //   73: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: istore_1
    //   77: aload_0
    //   78: astore_3
    //   79: iload_1
    //   80: ifne +8 -> 88
    //   83: aload 4
    //   85: astore_2
    //   86: aload_0
    //   87: astore_3
    //   88: aload_3
    //   89: invokevirtual 103	java/io/BufferedReader:close	()V
    //   92: aload_2
    //   93: astore_0
    //   94: aload 5
    //   96: invokevirtual 106	java/lang/Process:destroy	()V
    //   99: aload_0
    //   100: areturn
    //   101: aload_3
    //   102: aload 4
    //   104: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: goto -54 -> 54
    //   111: astore_3
    //   112: aload_0
    //   113: astore_3
    //   114: aload_0
    //   115: ifnonnull -27 -> 88
    //   118: aconst_null
    //   119: astore_0
    //   120: goto -26 -> 94
    //   123: astore_2
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: ifnull +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 103	java/io/BufferedReader:close	()V
    //   134: aload_2
    //   135: athrow
    //   136: astore_0
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: aload_2
    //   141: areturn
    //   142: astore_2
    //   143: aload_0
    //   144: areturn
    //   145: astore_2
    //   146: goto -20 -> 126
    //   149: astore_0
    //   150: aconst_null
    //   151: astore_0
    //   152: goto -40 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramString	String
    //   76	4	1	bool	boolean
    //   1	92	2	localObject1	Object
    //   123	18	2	str1	String
    //   142	1	2	localThrowable	Throwable
    //   145	1	2	localObject2	Object
    //   53	49	3	localObject3	Object
    //   111	1	3	localIOException	java.io.IOException
    //   113	1	3	str2	String
    //   58	45	4	str3	String
    //   24	71	5	localProcess	java.lang.Process
    // Exception table:
    //   from	to	target	type
    //   46	54	111	java/io/IOException
    //   54	60	111	java/io/IOException
    //   65	77	111	java/io/IOException
    //   101	108	111	java/io/IOException
    //   26	46	123	finally
    //   2	26	136	java/lang/Throwable
    //   130	134	136	java/lang/Throwable
    //   134	136	136	java/lang/Throwable
    //   88	92	139	java/lang/Throwable
    //   94	99	142	java/lang/Throwable
    //   46	54	145	finally
    //   54	60	145	finally
    //   65	77	145	finally
    //   101	108	145	finally
    //   26	46	149	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.d
 * JD-Core Version:    0.7.0.1
 */