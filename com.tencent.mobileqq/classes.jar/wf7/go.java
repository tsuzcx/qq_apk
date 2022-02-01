package wf7;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.io.File;
import java.net.NetworkInterface;
import java.util.List;

public class go
{
  private static String R(String paramString)
  {
    int i = 0;
    try
    {
      paramString = NetworkInterface.getByName(paramString).getHardwareAddress();
      if (paramString == null) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramString.length;
      while (i < j)
      {
        localStringBuilder.append(String.format("%02x:", new Object[] { Byte.valueOf(paramString[i]) }));
        i += 1;
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  private static String S(String paramString)
  {
    try
    {
      paramString = b(new File(String.format("/sys/class/net/%s/address", new Object[] { paramString })));
      String str;
      if ((paramString != null) && (paramString.size() == 1))
      {
        str = (String)paramString.get(0);
        paramString = str;
      }
      return "";
    }
    catch (Throwable paramString)
    {
      try
      {
        if (!TextUtils.isEmpty(str)) {
          paramString = str.trim();
        }
        return paramString;
      }
      catch (Throwable paramString)
      {
        return str;
      }
      paramString = paramString;
      return "";
    }
  }
  
  /* Error */
  private static List<String> b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 89	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 90	java/util/ArrayList:<init>	()V
    //   12: astore 5
    //   14: new 92	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore_0
    //   23: new 97	java/io/InputStreamReader
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 100	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   31: astore_2
    //   32: new 102	java/io/BufferedReader
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 105	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_3
    //   41: aload_3
    //   42: invokevirtual 108	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +47 -> 94
    //   50: aload 5
    //   52: aload_1
    //   53: invokeinterface 112 2 0
    //   58: pop
    //   59: goto -18 -> 41
    //   62: astore_1
    //   63: aload_0
    //   64: astore_1
    //   65: aload_3
    //   66: astore_0
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 115	java/io/FileInputStream:close	()V
    //   75: aload_2
    //   76: ifnull +7 -> 83
    //   79: aload_2
    //   80: invokevirtual 116	java/io/InputStreamReader:close	()V
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 117	java/io/BufferedReader:close	()V
    //   91: aload 5
    //   93: areturn
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 115	java/io/FileInputStream:close	()V
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokevirtual 116	java/io/InputStreamReader:close	()V
    //   110: aload_3
    //   111: ifnull -20 -> 91
    //   114: aload_3
    //   115: invokevirtual 117	java/io/BufferedReader:close	()V
    //   118: aload 5
    //   120: areturn
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 120	java/lang/Throwable:printStackTrace	()V
    //   126: aload 5
    //   128: areturn
    //   129: astore_0
    //   130: aload_0
    //   131: invokevirtual 120	java/lang/Throwable:printStackTrace	()V
    //   134: aload 5
    //   136: areturn
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_0
    //   142: aload 4
    //   144: astore_3
    //   145: aload_0
    //   146: ifnull +7 -> 153
    //   149: aload_0
    //   150: invokevirtual 115	java/io/FileInputStream:close	()V
    //   153: aload_2
    //   154: ifnull +7 -> 161
    //   157: aload_2
    //   158: invokevirtual 116	java/io/InputStreamReader:close	()V
    //   161: aload_3
    //   162: ifnull +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 117	java/io/BufferedReader:close	()V
    //   169: aload_1
    //   170: athrow
    //   171: astore_0
    //   172: aload_0
    //   173: invokevirtual 120	java/lang/Throwable:printStackTrace	()V
    //   176: goto -7 -> 169
    //   179: astore_1
    //   180: aconst_null
    //   181: astore_2
    //   182: aload 4
    //   184: astore_3
    //   185: goto -40 -> 145
    //   188: astore_1
    //   189: aload 4
    //   191: astore_3
    //   192: goto -47 -> 145
    //   195: astore_1
    //   196: goto -51 -> 145
    //   199: astore_0
    //   200: aconst_null
    //   201: astore_0
    //   202: aconst_null
    //   203: astore_1
    //   204: aload_3
    //   205: astore_2
    //   206: goto -139 -> 67
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_2
    //   212: aload_0
    //   213: astore_1
    //   214: aload_2
    //   215: astore_0
    //   216: aload_3
    //   217: astore_2
    //   218: goto -151 -> 67
    //   221: astore_1
    //   222: aconst_null
    //   223: astore_3
    //   224: aload_0
    //   225: astore_1
    //   226: aload_3
    //   227: astore_0
    //   228: goto -161 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramFile	File
    //   45	8	1	str	String
    //   62	1	1	localThrowable1	Throwable
    //   64	8	1	localFile1	File
    //   137	33	1	localObject1	Object
    //   179	1	1	localObject2	Object
    //   188	1	1	localObject3	Object
    //   195	1	1	localObject4	Object
    //   203	1	1	localObject5	Object
    //   209	1	1	localThrowable2	Throwable
    //   213	1	1	localFile2	File
    //   221	1	1	localThrowable3	Throwable
    //   225	1	1	localFile3	File
    //   31	187	2	localObject6	Object
    //   4	223	3	localObject7	Object
    //   1	189	4	localObject8	Object
    //   12	123	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   41	46	62	java/lang/Throwable
    //   50	59	62	java/lang/Throwable
    //   98	102	121	java/lang/Throwable
    //   106	110	121	java/lang/Throwable
    //   114	118	121	java/lang/Throwable
    //   71	75	129	java/lang/Throwable
    //   79	83	129	java/lang/Throwable
    //   87	91	129	java/lang/Throwable
    //   14	23	137	finally
    //   149	153	171	java/lang/Throwable
    //   157	161	171	java/lang/Throwable
    //   165	169	171	java/lang/Throwable
    //   23	32	179	finally
    //   32	41	188	finally
    //   41	46	195	finally
    //   50	59	195	finally
    //   14	23	199	java/lang/Throwable
    //   23	32	209	java/lang/Throwable
    //   32	41	221	java/lang/Throwable
  }
  
  public static String u(Context paramContext)
  {
    Object localObject1 = "";
    try
    {
      String str = v(paramContext);
      localObject1 = str;
      if (!TextUtils.isEmpty(str))
      {
        paramContext = str;
        localObject1 = str;
        if (!"02:00:00:00:00:00".equals(str)) {}
      }
      else
      {
        localObject1 = str;
        paramContext = gr.U("wifi.interface");
        Object localObject2 = paramContext;
        localObject1 = str;
        if (TextUtils.isEmpty(paramContext)) {
          localObject2 = "wlan0";
        }
        localObject1 = str;
        str = R((String)localObject2);
        localObject1 = str;
        if (!TextUtils.isEmpty(str))
        {
          paramContext = str;
          localObject1 = str;
          if (!"02:00:00:00:00:00".equals(str)) {}
        }
        else
        {
          localObject1 = str;
          paramContext = S((String)localObject2);
        }
      }
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return localObject1;
  }
  
  private static String v(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
        if (paramContext == null) {
          break label38;
        }
        paramContext = paramContext.getMacAddress();
      }
      catch (Throwable paramContext)
      {
        paramContext = "";
        continue;
      }
      if (paramContext != null) {
        return paramContext;
      }
      return "";
      label38:
      paramContext = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.go
 * JD-Core Version:    0.7.0.1
 */