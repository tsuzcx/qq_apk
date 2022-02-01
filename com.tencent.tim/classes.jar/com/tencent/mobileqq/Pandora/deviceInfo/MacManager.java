package com.tencent.mobileqq.Pandora.deviceInfo;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mobileqq.Pandora.util.BackgroundUtil;
import com.tencent.mobileqq.Pandora.util.Log;
import com.tencent.mobileqq.Pandora.util.SharedPreferencesManager;
import java.io.File;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.List;

public class MacManager
{
  private static final String DEFAULTMACADDRESS = "02:00:00:00:00:00";
  private static final Object LOCKMAC = new Object();
  private static final Object LOCKREALMAC = new Object();
  private static final String TAG = "MacManager";
  private static String sMacAddress;
  private static String sRealMacAddress;
  
  public static String getMac(Context paramContext)
  {
    if (!TextUtils.isEmpty(sMacAddress)) {
      return sMacAddress;
    }
    if (SharedPreferencesManager.contain(paramContext, "mac_address").booleanValue())
    {
      sMacAddress = SharedPreferencesManager.getData(paramContext, "mac_address");
      return sMacAddress;
    }
    for (;;)
    {
      synchronized (LOCKMAC)
      {
        if (SharedPreferencesManager.contain(paramContext, "mac_address").booleanValue()) {
          sMacAddress = SharedPreferencesManager.getData(paramContext, "mac_address");
        }
      }
      sMacAddress = updateMac(paramContext);
    }
  }
  
  private static String getMacByAPI(String paramString)
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
    catch (Throwable paramString)
    {
      Log.e("MacManager", "getMacByAPI exception: ", paramString);
    }
    return "";
  }
  
  private static String getMacFromFile(String paramString)
  {
    try
    {
      paramString = readLines(new File(String.format("/sys/class/net/%s/address", new Object[] { paramString })));
      String str;
      if ((paramString != null) && (paramString.size() == 1))
      {
        paramString = (String)paramString.get(0);
        str = paramString;
      }
      label69:
      return "";
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          str = paramString.trim();
        }
        return str;
      }
      catch (Throwable localThrowable2)
      {
        break label69;
      }
      localThrowable1 = localThrowable1;
      paramString = "";
      Log.e("MacManager", "getMacFromFile exception: ", localThrowable1);
      return paramString;
    }
  }
  
  public static String getRealMac(Context paramContext)
  {
    if (!TextUtils.isEmpty(sRealMacAddress)) {
      return sRealMacAddress;
    }
    if (SharedPreferencesManager.contain(paramContext, "real_mac_address").booleanValue())
    {
      sRealMacAddress = SharedPreferencesManager.getData(paramContext, "real_mac_address");
      return sRealMacAddress;
    }
    for (;;)
    {
      synchronized (LOCKREALMAC)
      {
        if (SharedPreferencesManager.contain(paramContext, "real_mac_address").booleanValue()) {
          sRealMacAddress = SharedPreferencesManager.getData(paramContext, "real_mac_address");
        }
      }
      sRealMacAddress = updateRealMac(paramContext);
    }
  }
  
  private static String getSysPropByReflect(String paramString)
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      localObject = (String)((Method)localObject).invoke(null, new Object[] { paramString });
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("MacManager", "getSysPropByReflect exception: ", paramString);
    }
    return "";
  }
  
  /* Error */
  private static List<String> readLines(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 176	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 177	java/util/ArrayList:<init>	()V
    //   12: astore 5
    //   14: new 179	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 182	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore_1
    //   23: new 184	java/io/InputStreamReader
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 187	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   31: astore_2
    //   32: new 189	java/io/BufferedReader
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 192	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 195	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +57 -> 104
    //   50: aload 5
    //   52: aload_3
    //   53: invokeinterface 199 2 0
    //   58: pop
    //   59: goto -18 -> 41
    //   62: astore 4
    //   64: aload_2
    //   65: astore_3
    //   66: aload 4
    //   68: astore_2
    //   69: ldc 14
    //   71: ldc 201
    //   73: aload_2
    //   74: invokestatic 114	com/tencent/mobileqq/Pandora/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: aload_1
    //   78: ifnull +7 -> 85
    //   81: aload_1
    //   82: invokevirtual 204	java/io/FileInputStream:close	()V
    //   85: aload_3
    //   86: ifnull +7 -> 93
    //   89: aload_3
    //   90: invokevirtual 205	java/io/InputStreamReader:close	()V
    //   93: aload_0
    //   94: ifnull +7 -> 101
    //   97: aload_0
    //   98: invokevirtual 206	java/io/BufferedReader:close	()V
    //   101: aload 5
    //   103: areturn
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 204	java/io/FileInputStream:close	()V
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 205	java/io/InputStreamReader:close	()V
    //   120: aload_0
    //   121: ifnull -20 -> 101
    //   124: aload_0
    //   125: invokevirtual 206	java/io/BufferedReader:close	()V
    //   128: aload 5
    //   130: areturn
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 209	java/lang/Throwable:printStackTrace	()V
    //   136: aload 5
    //   138: areturn
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 209	java/lang/Throwable:printStackTrace	()V
    //   144: aload 5
    //   146: areturn
    //   147: astore_0
    //   148: aconst_null
    //   149: astore_2
    //   150: aconst_null
    //   151: astore_1
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 204	java/io/FileInputStream:close	()V
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 205	java/io/InputStreamReader:close	()V
    //   168: aload_3
    //   169: ifnull +7 -> 176
    //   172: aload_3
    //   173: invokevirtual 206	java/io/BufferedReader:close	()V
    //   176: aload_0
    //   177: athrow
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 209	java/lang/Throwable:printStackTrace	()V
    //   183: goto -7 -> 176
    //   186: astore_0
    //   187: aconst_null
    //   188: astore_2
    //   189: goto -37 -> 152
    //   192: astore_0
    //   193: goto -41 -> 152
    //   196: astore 4
    //   198: aload_0
    //   199: astore_3
    //   200: aload 4
    //   202: astore_0
    //   203: goto -51 -> 152
    //   206: astore 4
    //   208: aload_3
    //   209: astore_2
    //   210: aload_0
    //   211: astore_3
    //   212: aload 4
    //   214: astore_0
    //   215: goto -63 -> 152
    //   218: astore_2
    //   219: aconst_null
    //   220: astore_0
    //   221: aconst_null
    //   222: astore_1
    //   223: aload 4
    //   225: astore_3
    //   226: goto -157 -> 69
    //   229: astore_2
    //   230: aconst_null
    //   231: astore_0
    //   232: aload 4
    //   234: astore_3
    //   235: goto -166 -> 69
    //   238: astore 4
    //   240: aconst_null
    //   241: astore_0
    //   242: aload_2
    //   243: astore_3
    //   244: aload 4
    //   246: astore_2
    //   247: goto -178 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramFile	File
    //   22	135	1	localFileInputStream	java.io.FileInputStream
    //   178	2	1	localThrowable1	Throwable
    //   222	1	1	localObject1	Object
    //   31	179	2	localObject2	Object
    //   218	1	2	localThrowable2	Throwable
    //   229	14	2	localThrowable3	Throwable
    //   246	1	2	localThrowable4	Throwable
    //   1	243	3	localObject3	Object
    //   3	1	4	localObject4	Object
    //   62	5	4	localThrowable5	Throwable
    //   196	5	4	localObject5	Object
    //   206	27	4	localObject6	Object
    //   238	7	4	localThrowable6	Throwable
    //   12	133	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   41	46	62	java/lang/Throwable
    //   50	59	62	java/lang/Throwable
    //   108	112	131	java/lang/Throwable
    //   116	120	131	java/lang/Throwable
    //   124	128	131	java/lang/Throwable
    //   81	85	139	java/lang/Throwable
    //   89	93	139	java/lang/Throwable
    //   97	101	139	java/lang/Throwable
    //   14	23	147	finally
    //   156	160	178	java/lang/Throwable
    //   164	168	178	java/lang/Throwable
    //   172	176	178	java/lang/Throwable
    //   23	32	186	finally
    //   32	41	192	finally
    //   41	46	196	finally
    //   50	59	196	finally
    //   69	77	206	finally
    //   14	23	218	java/lang/Throwable
    //   23	32	229	java/lang/Throwable
    //   32	41	238	java/lang/Throwable
  }
  
  private static String updateMac(Context paramContext)
  {
    if (BackgroundUtil.isOnBackgroud(paramContext)) {
      return "02:00:00:00:00:00";
    }
    Object localObject = (WifiManager)paramContext.getSystemService("wifi");
    try
    {
      localObject = ((WifiManager)localObject).getConnectionInfo().getMacAddress();
      Log.e("MacManager", "getMacAddress class ", new Throwable());
      sMacAddress = (String)localObject;
      SharedPreferencesManager.save(paramContext, "mac_address", sMacAddress);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = "02:00:00:00:00:00";
        Log.e("MacManager", "WifiManager get mac_address exception is ", localException);
      }
    }
  }
  
  private static String updateRealMac(Context paramContext)
  {
    if (BackgroundUtil.isOnBackgroud(paramContext)) {
      return "02:00:00:00:00:00";
    }
    String str2 = getMac(paramContext);
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!"02:00:00:00:00:00".equals(str2)) {}
    }
    else
    {
      str2 = getSysPropByReflect("wifi.interface");
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "wlan0";
      }
      str2 = getMacByAPI(str1);
      if ((!TextUtils.isEmpty(str2)) && (!"02:00:00:00:00:00".equals(str2))) {
        break label108;
      }
    }
    label108:
    for (String str1 = getMacFromFile(str1);; str1 = str2)
    {
      Log.e("MacManager", "getHardwareAddress class ", new Throwable());
      sRealMacAddress = str1;
      SharedPreferencesManager.save(paramContext, "real_mac_address", sRealMacAddress);
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Pandora.deviceInfo.MacManager
 * JD-Core Version:    0.7.0.1
 */