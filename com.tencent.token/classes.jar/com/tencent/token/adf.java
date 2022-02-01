package com.tencent.token;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

public final class adf
{
  public static String a;
  public static String b;
  public static String c;
  
  public static int a()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    finally
    {
      label9:
      break label9;
    }
    return 0;
  }
  
  public static String a(Context paramContext)
  {
    String str = a;
    if (str != null) {
      return str;
    }
    try
    {
      str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
      a = paramContext;
    }
    finally
    {
      label36:
      break label36;
    }
    return a;
  }
  
  /* Error */
  public static String a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_0
    //   1: ifeq +12 -> 13
    //   4: ldc 45
    //   6: astore_1
    //   7: ldc 47
    //   9: astore_2
    //   10: goto +9 -> 19
    //   13: ldc 49
    //   15: astore_1
    //   16: ldc 51
    //   18: astore_2
    //   19: new 53	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   26: astore_3
    //   27: aload_3
    //   28: aload_1
    //   29: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_3
    //   34: ldc 63
    //   36: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: new 65	java/io/BufferedReader
    //   43: dup
    //   44: new 67	java/io/FileReader
    //   47: dup
    //   48: aload_3
    //   49: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 73	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   55: invokespecial 76	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   58: astore_3
    //   59: aload_3
    //   60: invokevirtual 79	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore 4
    //   65: aload 4
    //   67: ifnull +91 -> 158
    //   70: aload 4
    //   72: invokevirtual 84	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   75: aload_2
    //   76: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq +79 -> 158
    //   82: new 53	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   89: astore_2
    //   90: aload_2
    //   91: aload_1
    //   92: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_2
    //   97: ldc 90
    //   99: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: new 65	java/io/BufferedReader
    //   106: dup
    //   107: new 67	java/io/FileReader
    //   110: dup
    //   111: aload_2
    //   112: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokespecial 73	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   118: invokespecial 76	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   121: astore_2
    //   122: aload_2
    //   123: invokevirtual 79	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   126: astore 4
    //   128: aload_2
    //   129: astore_1
    //   130: aload 4
    //   132: ifnull +28 -> 160
    //   135: aload 4
    //   137: invokevirtual 93	java/lang/String:trim	()Ljava/lang/String;
    //   140: astore_1
    //   141: aload_3
    //   142: invokevirtual 96	java/io/BufferedReader:close	()V
    //   145: aload_2
    //   146: invokevirtual 96	java/io/BufferedReader:close	()V
    //   149: aload_1
    //   150: areturn
    //   151: aload_2
    //   152: astore_1
    //   153: aload_3
    //   154: astore_2
    //   155: goto +29 -> 184
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_3
    //   161: invokevirtual 96	java/io/BufferedReader:close	()V
    //   164: aload_1
    //   165: ifnull +43 -> 208
    //   168: aload_1
    //   169: astore_2
    //   170: goto +34 -> 204
    //   173: aconst_null
    //   174: astore_1
    //   175: aload_3
    //   176: astore_2
    //   177: goto +7 -> 184
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_1
    //   183: astore_2
    //   184: aload_2
    //   185: ifnull +10 -> 195
    //   188: aload_2
    //   189: invokevirtual 96	java/io/BufferedReader:close	()V
    //   192: goto +3 -> 195
    //   195: aload_1
    //   196: astore_2
    //   197: aload_1
    //   198: ifnonnull +6 -> 204
    //   201: goto +7 -> 208
    //   204: aload_2
    //   205: invokevirtual 96	java/io/BufferedReader:close	()V
    //   208: ldc 40
    //   210: areturn
    //   211: astore_1
    //   212: goto -32 -> 180
    //   215: astore_1
    //   216: goto -43 -> 173
    //   219: astore_1
    //   220: goto -69 -> 151
    //   223: astore_3
    //   224: goto -79 -> 145
    //   227: astore_2
    //   228: aload_1
    //   229: areturn
    //   230: astore_2
    //   231: goto -67 -> 164
    //   234: astore_2
    //   235: goto -40 -> 195
    //   238: astore_1
    //   239: goto -31 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramBoolean	boolean
    //   6	192	1	localObject1	Object
    //   211	1	1	localObject2	Object
    //   215	1	1	localObject3	Object
    //   219	10	1	str1	String
    //   238	1	1	localIOException1	java.io.IOException
    //   9	196	2	localObject4	Object
    //   227	1	2	localIOException2	java.io.IOException
    //   230	1	2	localIOException3	java.io.IOException
    //   234	1	2	localIOException4	java.io.IOException
    //   26	150	3	localObject5	Object
    //   223	1	3	localIOException5	java.io.IOException
    //   63	73	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   19	59	211	finally
    //   59	65	215	finally
    //   70	122	215	finally
    //   122	128	219	finally
    //   135	141	219	finally
    //   141	145	223	java/io/IOException
    //   145	149	227	java/io/IOException
    //   160	164	230	java/io/IOException
    //   188	192	234	java/io/IOException
    //   204	208	238	java/io/IOException
  }
  
  public static String b(Context paramContext)
  {
    String str = b;
    if (str != null) {
      return str;
    }
    try
    {
      str = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
      b = paramContext;
      return paramContext;
    }
    finally
    {
      label38:
      break label38;
    }
    return "";
  }
  
  public static String c(Context paramContext)
  {
    String str = c;
    if (str != null) {
      return str;
    }
    try
    {
      c = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    }
    finally
    {
      label25:
      break label25;
    }
    c = "";
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adf
 * JD-Core Version:    0.7.0.1
 */