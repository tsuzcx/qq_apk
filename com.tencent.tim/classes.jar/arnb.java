import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Pandora.Pandora;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class arnb
{
  public static String CZ()
  {
    String str2 = "";
    try
    {
      byte[] arrayOfByte = b(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/.tmfs/sk_v.dat"));
      str1 = str2;
      if (arrayOfByte != null) {
        str1 = qp(new String(arrayOfByte));
      }
    }
    catch (Throwable localThrowable)
    {
      do
      {
        String str1 = str2;
      } while (!QLog.isColorLevel());
      QLog.i("WifiSdk", 2, "getVidInSD exception: " + localThrowable.getMessage());
    }
    return str1;
    return "";
  }
  
  public static int aL(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if ((paramContext == null) || (paramContext.getSimState() == 1)) {
      return 3;
    }
    paramContext = paramContext.getNetworkOperator();
    if ((paramContext.equals("46000")) || (paramContext.equals("46002")) || (paramContext.equals("46007"))) {
      return 0;
    }
    if (paramContext.equals("46001")) {
      return 1;
    }
    if (paramContext.equals("46003")) {
      return 2;
    }
    return 3;
  }
  
  public static String am(long paramLong)
  {
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = ((int)(paramLong >> 24 & 0xFF));
    arrayOfInt[1] = ((int)(paramLong >> 16 & 0xFF));
    arrayOfInt[2] = ((int)(paramLong >> 8 & 0xFF));
    arrayOfInt[3] = ((int)(paramLong & 0xFF));
    return Integer.toString(arrayOfInt[3]) + "." + Integer.toString(arrayOfInt[2]) + "." + Integer.toString(arrayOfInt[1]) + "." + Integer.toString(arrayOfInt[0]);
  }
  
  /* Error */
  public static byte[] b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 118	java/io/BufferedInputStream
    //   6: dup
    //   7: new 120	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 123	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: invokespecial 126	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: new 128	java/io/ByteArrayOutputStream
    //   22: dup
    //   23: invokespecial 129	java/io/ByteArrayOutputStream:<init>	()V
    //   26: astore_0
    //   27: aload_0
    //   28: astore 4
    //   30: aload_2
    //   31: astore_3
    //   32: sipush 1024
    //   35: newarray byte
    //   37: astore 5
    //   39: aload_0
    //   40: astore 4
    //   42: aload_2
    //   43: astore_3
    //   44: aload_2
    //   45: aload 5
    //   47: invokevirtual 133	java/io/BufferedInputStream:read	([B)I
    //   50: istore_1
    //   51: iload_1
    //   52: iconst_m1
    //   53: if_icmpeq +90 -> 143
    //   56: aload_0
    //   57: astore 4
    //   59: aload_2
    //   60: astore_3
    //   61: aload_0
    //   62: aload 5
    //   64: iconst_0
    //   65: iload_1
    //   66: invokevirtual 137	java/io/ByteArrayOutputStream:write	([BII)V
    //   69: goto -30 -> 39
    //   72: astore 5
    //   74: aload_0
    //   75: astore 4
    //   77: aload_2
    //   78: astore_3
    //   79: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +37 -> 119
    //   85: aload_0
    //   86: astore 4
    //   88: aload_2
    //   89: astore_3
    //   90: ldc 60
    //   92: iconst_2
    //   93: new 14	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   100: ldc 139
    //   102: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 5
    //   107: invokevirtual 65	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   110: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 142	java/io/ByteArrayOutputStream:close	()V
    //   127: aload 6
    //   129: astore_0
    //   130: aload_2
    //   131: ifnull +10 -> 141
    //   134: aload_2
    //   135: invokevirtual 143	java/io/BufferedInputStream:close	()V
    //   138: aload 6
    //   140: astore_0
    //   141: aload_0
    //   142: areturn
    //   143: aload_0
    //   144: astore 4
    //   146: aload_2
    //   147: astore_3
    //   148: aload_0
    //   149: invokevirtual 147	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   152: astore 5
    //   154: aload 5
    //   156: astore_3
    //   157: aload_0
    //   158: ifnull +7 -> 165
    //   161: aload_0
    //   162: invokevirtual 142	java/io/ByteArrayOutputStream:close	()V
    //   165: aload_3
    //   166: astore_0
    //   167: aload_2
    //   168: ifnull -27 -> 141
    //   171: aload_2
    //   172: invokevirtual 143	java/io/BufferedInputStream:close	()V
    //   175: aload_3
    //   176: areturn
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   182: aload_3
    //   183: areturn
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   189: goto -24 -> 165
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   197: goto -70 -> 127
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   205: aconst_null
    //   206: areturn
    //   207: astore_0
    //   208: aconst_null
    //   209: astore 4
    //   211: aconst_null
    //   212: astore_2
    //   213: aload 4
    //   215: ifnull +8 -> 223
    //   218: aload 4
    //   220: invokevirtual 142	java/io/ByteArrayOutputStream:close	()V
    //   223: aload_2
    //   224: ifnull +7 -> 231
    //   227: aload_2
    //   228: invokevirtual 143	java/io/BufferedInputStream:close	()V
    //   231: aload_0
    //   232: athrow
    //   233: astore_3
    //   234: aload_3
    //   235: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   238: goto -15 -> 223
    //   241: astore_2
    //   242: aload_2
    //   243: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   246: goto -15 -> 231
    //   249: astore_0
    //   250: aconst_null
    //   251: astore 4
    //   253: goto -40 -> 213
    //   256: astore_0
    //   257: aload_3
    //   258: astore_2
    //   259: goto -46 -> 213
    //   262: astore 5
    //   264: aconst_null
    //   265: astore_0
    //   266: aconst_null
    //   267: astore_2
    //   268: goto -194 -> 74
    //   271: astore 5
    //   273: aconst_null
    //   274: astore_0
    //   275: goto -201 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramFile	File
    //   50	16	1	i	int
    //   18	210	2	localBufferedInputStream	java.io.BufferedInputStream
    //   241	2	2	localIOException1	java.io.IOException
    //   258	10	2	localObject1	Object
    //   31	152	3	localObject2	Object
    //   233	25	3	localIOException2	java.io.IOException
    //   28	224	4	localFile	File
    //   37	26	5	arrayOfByte1	byte[]
    //   72	34	5	localThrowable1	Throwable
    //   152	3	5	arrayOfByte2	byte[]
    //   262	1	5	localThrowable2	Throwable
    //   271	1	5	localThrowable3	Throwable
    //   1	138	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   32	39	72	java/lang/Throwable
    //   44	51	72	java/lang/Throwable
    //   61	69	72	java/lang/Throwable
    //   148	154	72	java/lang/Throwable
    //   171	175	177	java/io/IOException
    //   161	165	184	java/io/IOException
    //   123	127	192	java/io/IOException
    //   134	138	200	java/io/IOException
    //   3	19	207	finally
    //   218	223	233	java/io/IOException
    //   227	231	241	java/io/IOException
    //   19	27	249	finally
    //   32	39	256	finally
    //   44	51	256	finally
    //   61	69	256	finally
    //   79	85	256	finally
    //   90	119	256	finally
    //   148	154	256	finally
    //   3	19	262	java/lang/Throwable
    //   19	27	271	java/lang/Throwable
  }
  
  public static boolean cm(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      return true;
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", paramContext.getPackageName()) != 0)
        {
          int i = localPackageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", paramContext.getPackageName());
          if (i != 0) {
            return false;
          }
        }
      }
      catch (Throwable paramContext) {}
    }
    return false;
  }
  
  @TargetApi(19)
  public static boolean cn(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    for (;;)
    {
      return true;
      try
      {
        int i = Settings.Secure.getInt(paramContext.getContentResolver(), "location_mode");
        if (i == 0) {
          return false;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public static String getMac()
  {
    Object localObject = "";
    try
    {
      String str = Pandora.getMac(BaseApplicationImpl.getContext());
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("WifiSdk", 2, "getMac exception: " + localThrowable.getMessage());
    }
    return localObject;
    return "";
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    if (!aqiw.isNetworkAvailable(paramContext)) {
      return 0;
    }
    switch (aroc.getNetType(paramContext))
    {
    case 0: 
    default: 
      return 5;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 1;
  }
  
  public static boolean isWifiEnabled(Context paramContext)
  {
    try
    {
      boolean bool = ((WifiManager)paramContext.getSystemService("wifi")).isWifiEnabled();
      return bool;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static String qp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramString = arnd.decrypt(arml.decode(paramString, 0), arnd.getKey());
      if (paramString != null)
      {
        paramString = new String(paramString, "gbk");
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WifiSdk", 2, "getDecodeString exception: " + paramString.getMessage());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arnb
 * JD-Core Version:    0.7.0.1
 */