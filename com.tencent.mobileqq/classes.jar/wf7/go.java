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
    try
    {
      paramString = NetworkInterface.getByName(paramString).getHardwareAddress();
      if (paramString == null) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramString.length;
      int i = 0;
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
    String str = "";
    try
    {
      List localList = b(new File(String.format("/sys/class/net/%s/address", new Object[] { paramString })));
      paramString = str;
      if (localList != null)
      {
        paramString = str;
        if (localList.size() == 1) {
          paramString = (String)localList.get(0);
        }
      }
    }
    catch (Throwable paramString)
    {
      label70:
      return "";
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        str = paramString.trim();
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      break label70;
    }
    return paramString;
  }
  
  /* Error */
  private static List<String> b(File paramFile)
  {
    // Byte code:
    //   0: new 89	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 90	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: new 92	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore_1
    //   23: new 97	java/io/InputStreamReader
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 100	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   31: astore_2
    //   32: new 102	java/io/BufferedReader
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 105	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 108	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +15 -> 62
    //   50: aload 5
    //   52: aload_3
    //   53: invokeinterface 112 2 0
    //   58: pop
    //   59: goto -18 -> 41
    //   62: aload_1
    //   63: invokevirtual 115	java/io/FileInputStream:close	()V
    //   66: aload_2
    //   67: invokevirtual 116	java/io/InputStreamReader:close	()V
    //   70: aload_0
    //   71: invokevirtual 117	java/io/BufferedReader:close	()V
    //   74: aload 5
    //   76: areturn
    //   77: astore 4
    //   79: aload_0
    //   80: astore_3
    //   81: aload 4
    //   83: astore_0
    //   84: aload_1
    //   85: astore 4
    //   87: aload_2
    //   88: astore_1
    //   89: goto +44 -> 133
    //   92: aload_0
    //   93: astore_3
    //   94: aload_2
    //   95: astore_0
    //   96: goto +82 -> 178
    //   99: astore_0
    //   100: aload_1
    //   101: astore 4
    //   103: aload_2
    //   104: astore_1
    //   105: goto +28 -> 133
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_2
    //   111: aload_1
    //   112: astore 4
    //   114: aload_2
    //   115: astore_1
    //   116: goto +17 -> 133
    //   119: aconst_null
    //   120: astore_0
    //   121: aload 4
    //   123: astore_3
    //   124: goto +54 -> 178
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: astore 4
    //   133: aload 4
    //   135: ifnull +11 -> 146
    //   138: aload 4
    //   140: invokevirtual 115	java/io/FileInputStream:close	()V
    //   143: goto +3 -> 146
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 116	java/io/InputStreamReader:close	()V
    //   154: aload_3
    //   155: ifnull +14 -> 169
    //   158: aload_3
    //   159: invokevirtual 117	java/io/BufferedReader:close	()V
    //   162: goto +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 120	java/lang/Throwable:printStackTrace	()V
    //   169: aload_0
    //   170: athrow
    //   171: aconst_null
    //   172: astore_0
    //   173: aload_0
    //   174: astore_1
    //   175: aload 4
    //   177: astore_3
    //   178: aload_1
    //   179: ifnull +10 -> 189
    //   182: aload_1
    //   183: invokevirtual 115	java/io/FileInputStream:close	()V
    //   186: goto +3 -> 189
    //   189: aload_0
    //   190: ifnull +7 -> 197
    //   193: aload_0
    //   194: invokevirtual 116	java/io/InputStreamReader:close	()V
    //   197: aload_3
    //   198: ifnull +14 -> 212
    //   201: aload_3
    //   202: invokevirtual 117	java/io/BufferedReader:close	()V
    //   205: aload 5
    //   207: areturn
    //   208: aload_0
    //   209: invokevirtual 120	java/lang/Throwable:printStackTrace	()V
    //   212: aload 5
    //   214: areturn
    //   215: astore_0
    //   216: goto -45 -> 171
    //   219: astore_0
    //   220: goto -101 -> 119
    //   223: astore_0
    //   224: aload 4
    //   226: astore_3
    //   227: aload_2
    //   228: astore_0
    //   229: goto -51 -> 178
    //   232: astore_3
    //   233: goto -141 -> 92
    //   236: astore_1
    //   237: goto -72 -> 165
    //   240: astore_0
    //   241: goto -33 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramFile	File
    //   22	161	1	localObject1	Object
    //   236	1	1	localThrowable1	Throwable
    //   31	197	2	localInputStreamReader	java.io.InputStreamReader
    //   13	214	3	localObject2	Object
    //   232	1	3	localThrowable2	Throwable
    //   10	1	4	localObject3	Object
    //   77	5	4	localObject4	Object
    //   85	140	4	localObject5	Object
    //   7	206	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   41	46	77	finally
    //   50	59	77	finally
    //   32	41	99	finally
    //   23	32	108	finally
    //   14	23	127	finally
    //   14	23	215	java/lang/Throwable
    //   23	32	219	java/lang/Throwable
    //   32	41	223	java/lang/Throwable
    //   41	46	232	java/lang/Throwable
    //   50	59	232	java/lang/Throwable
    //   138	143	236	java/lang/Throwable
    //   150	154	236	java/lang/Throwable
    //   158	162	236	java/lang/Throwable
    //   62	74	240	java/lang/Throwable
    //   182	186	240	java/lang/Throwable
    //   193	197	240	java/lang/Throwable
    //   201	205	240	java/lang/Throwable
  }
  
  public static String u(Context paramContext)
  {
    try
    {
      String str2 = v(paramContext);
      String str1 = str2;
      boolean bool;
      Object localObject;
      return str1;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        try
        {
          bool = TextUtils.isEmpty(str2);
          if (!bool)
          {
            paramContext = str2;
            str1 = str2;
            if (!"02:00:00:00:00:00".equals(str2)) {}
          }
          else
          {
            str1 = str2;
            paramContext = gr.U("wifi.interface");
            localObject = paramContext;
            str1 = str2;
            if (TextUtils.isEmpty(paramContext)) {
              localObject = "wlan0";
            }
            str1 = str2;
            str2 = R((String)localObject);
            str1 = str2;
            if (!TextUtils.isEmpty(str2))
            {
              paramContext = str2;
              str1 = str2;
              if (!"02:00:00:00:00:00".equals(str2)) {}
            }
            else
            {
              str1 = str2;
              paramContext = S((String)localObject);
              return paramContext;
              paramContext = "";
            }
          }
          return paramContext;
        }
        catch (Throwable paramContext) {}
        paramContext = paramContext;
      }
    }
  }
  
  private static String v(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext != null) {
        paramContext = paramContext.getMacAddress();
      }
    }
    catch (Throwable paramContext)
    {
      label25:
      break label25;
    }
    paramContext = "";
    if (paramContext != null) {
      return paramContext;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.go
 * JD-Core Version:    0.7.0.1
 */