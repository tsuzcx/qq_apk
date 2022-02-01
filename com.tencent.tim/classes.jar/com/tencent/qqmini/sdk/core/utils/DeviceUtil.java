package com.tencent.qqmini.sdk.core.utils;

import alky;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import java.io.File;

public class DeviceUtil
{
  public static final int BUFFER_SIZE = 1024;
  public static final String TAG = "DeviceUtil";
  private static long cachedTotalMemory = 0L;
  private static long initial_rate;
  protected static String location;
  public static int sCpuCoreNum = -1;
  private static long sCpuMaxFreq = 0L;
  
  /* Error */
  public static long getCpuFrequency()
  {
    // Byte code:
    //   0: getstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   3: lconst_0
    //   4: lcmp
    //   5: ifle +7 -> 12
    //   8: getstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   11: lreturn
    //   12: iconst_0
    //   13: istore_0
    //   14: invokestatic 41	com/tencent/qqmini/sdk/core/utils/DeviceUtil:getCpuNumber	()I
    //   17: istore_1
    //   18: getstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   21: lconst_0
    //   22: lcmp
    //   23: ifgt +126 -> 149
    //   26: iload_0
    //   27: iload_1
    //   28: if_icmpge +121 -> 149
    //   31: aconst_null
    //   32: astore_3
    //   33: new 43	java/io/BufferedReader
    //   36: dup
    //   37: new 45	java/io/FileReader
    //   40: dup
    //   41: new 47	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   48: ldc 50
    //   50: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: iload_0
    //   54: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc 59
    //   59: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokespecial 66	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   68: sipush 1024
    //   71: invokespecial 69	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 72	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: astore_3
    //   80: aload_3
    //   81: ifnull +20 -> 101
    //   84: aload_3
    //   85: invokestatic 78	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   88: putstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   91: getstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   94: ldc2_w 79
    //   97: ldiv
    //   98: putstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 83	java/io/BufferedReader:close	()V
    //   109: iload_0
    //   110: iconst_1
    //   111: iadd
    //   112: istore_0
    //   113: goto -95 -> 18
    //   116: astore_3
    //   117: aload_2
    //   118: ifnull -9 -> 109
    //   121: aload_2
    //   122: invokevirtual 83	java/io/BufferedReader:close	()V
    //   125: goto -16 -> 109
    //   128: astore_2
    //   129: goto -20 -> 109
    //   132: astore 4
    //   134: aload_2
    //   135: astore_3
    //   136: aload 4
    //   138: astore_2
    //   139: aload_3
    //   140: ifnull +7 -> 147
    //   143: aload_3
    //   144: invokevirtual 83	java/io/BufferedReader:close	()V
    //   147: aload_2
    //   148: athrow
    //   149: ldc 11
    //   151: new 47	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   158: ldc 85
    //   160: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: getstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   166: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: ldc 90
    //   171: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload_0
    //   175: iconst_1
    //   176: isub
    //   177: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 96	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: getstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   189: lreturn
    //   190: astore_2
    //   191: goto -82 -> 109
    //   194: astore_3
    //   195: goto -48 -> 147
    //   198: astore_2
    //   199: goto -60 -> 139
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_2
    //   205: goto -88 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	164	0	i	int
    //   17	12	1	j	int
    //   74	48	2	localBufferedReader	java.io.BufferedReader
    //   128	7	2	localIOException1	java.io.IOException
    //   138	10	2	localObject1	Object
    //   190	1	2	localIOException2	java.io.IOException
    //   198	1	2	localObject2	Object
    //   202	1	2	localException1	Exception
    //   204	1	2	localObject3	Object
    //   32	53	3	str	String
    //   116	1	3	localException2	Exception
    //   135	9	3	localObject4	Object
    //   194	1	3	localIOException3	java.io.IOException
    //   132	5	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   75	80	116	java/lang/Exception
    //   84	101	116	java/lang/Exception
    //   121	125	128	java/io/IOException
    //   75	80	132	finally
    //   84	101	132	finally
    //   105	109	190	java/io/IOException
    //   143	147	194	java/io/IOException
    //   33	75	198	finally
    //   33	75	202	java/lang/Exception
  }
  
  public static long getCpuMaxFreq()
  {
    if (sCpuMaxFreq == 0L) {
      initCpuMaxFreq();
    }
    return sCpuMaxFreq;
  }
  
  public static int getCpuNumber()
  {
    return getNumberOfCores();
  }
  
  public static int getDeviceBenchmarkLevel()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        return 0;
      }
      int k = getCpuNumber();
      if (k <= 0) {
        return -1;
      }
      int m = (int)(getCpuMaxFreq() / 100000L);
      if (m <= 0) {
        return -1;
      }
      int n = (int)(getSystemTotalMemory() / 1048576L);
      if (n <= 0) {
        return -1;
      }
      int j = (k * 200 + m * m * 10 + n / 1024 * (n / 1024) * 100) / 400;
      int i = j;
      if (j > 50) {
        i = 50;
      }
      QMLog.d("getDeviceBenchmarkLevel", "getDeviceBenchmarkLevel coreNum:" + k + " cpuFreq:" + m + " ramSize:" + n + " score:" + i);
      return i;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("getDeviceBenchmarkLevel", "getDeviceBenchmarkLevel error", localThrowable);
    }
    return -1;
  }
  
  public static String getLocation()
  {
    if (!TextUtils.isEmpty(location)) {
      return location;
    }
    Object localObject1 = AppLoaderFactory.g().getMiniAppEnv().getContext();
    if (localObject1 == null) {
      return "";
    }
    try
    {
      localObject1 = (LocationManager)((Context)localObject1).getSystemService("location");
      Object localObject2 = new Criteria();
      ((Criteria)localObject2).setCostAllowed(false);
      ((Criteria)localObject2).setAccuracy(2);
      localObject2 = ((LocationManager)localObject1).getBestProvider((Criteria)localObject2, true);
      if (localObject2 != null)
      {
        localObject1 = alky.a((LocationManager)localObject1, (String)localObject2);
        if (localObject1 == null) {
          return "";
        }
        double d1 = ((Location)localObject1).getLatitude();
        double d2 = ((Location)localObject1).getLongitude();
        localObject1 = d1 + "*" + d2;
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("getLocation", "getLocation>>>", localException);
    }
    return "";
  }
  
  private static final int getNumCoresOldPhones()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new DeviceUtil.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  @SuppressLint({"NewApi"})
  public static final int getNumberOfCores()
  {
    if (sCpuCoreNum == -1) {
      if (Build.VERSION.SDK_INT < 17) {
        break label28;
      }
    }
    label28:
    for (sCpuCoreNum = Runtime.getRuntime().availableProcessors();; sCpuCoreNum = getNumCoresOldPhones()) {
      return sCpuCoreNum;
    }
  }
  
  /* Error */
  public static long getSystemTotalMemory()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_0
    //   4: getstatic 25	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   7: lconst_0
    //   8: lcmp
    //   9: ifne +138 -> 147
    //   12: new 45	java/io/FileReader
    //   15: dup
    //   16: ldc 239
    //   18: invokespecial 66	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: new 43	java/io/BufferedReader
    //   25: dup
    //   26: aload_1
    //   27: sipush 1024
    //   30: invokespecial 69	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 72	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +24 -> 64
    //   43: aload_2
    //   44: ldc 241
    //   46: invokevirtual 247	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   49: iconst_1
    //   50: aaload
    //   51: invokestatic 251	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   54: invokevirtual 254	java/lang/Long:longValue	()J
    //   57: ldc2_w 79
    //   60: lmul
    //   61: putstatic 25	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 83	java/io/BufferedReader:close	()V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 255	java/io/FileReader:close	()V
    //   80: getstatic 25	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   83: lconst_0
    //   84: lcmp
    //   85: ifne +62 -> 147
    //   88: ldc2_w 256
    //   91: lreturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_0
    //   96: astore_1
    //   97: aload_2
    //   98: astore_0
    //   99: lconst_0
    //   100: putstatic 25	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 83	java/io/BufferedReader:close	()V
    //   111: aload_1
    //   112: ifnull -32 -> 80
    //   115: aload_1
    //   116: invokevirtual 255	java/io/FileReader:close	()V
    //   119: goto -39 -> 80
    //   122: astore_0
    //   123: goto -43 -> 80
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_2
    //   130: ifnull +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 83	java/io/BufferedReader:close	()V
    //   137: aload_1
    //   138: ifnull +7 -> 145
    //   141: aload_1
    //   142: invokevirtual 255	java/io/FileReader:close	()V
    //   145: aload_0
    //   146: athrow
    //   147: getstatic 25	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   150: lreturn
    //   151: astore_1
    //   152: goto -7 -> 145
    //   155: astore_0
    //   156: goto -27 -> 129
    //   159: astore_3
    //   160: aload_0
    //   161: astore_2
    //   162: aload_3
    //   163: astore_0
    //   164: goto -35 -> 129
    //   167: astore_3
    //   168: aload_0
    //   169: astore_2
    //   170: aload_3
    //   171: astore_0
    //   172: goto -43 -> 129
    //   175: astore_0
    //   176: aconst_null
    //   177: astore_0
    //   178: goto -79 -> 99
    //   181: astore_2
    //   182: goto -83 -> 99
    //   185: astore_0
    //   186: goto -106 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	105	0	localObject1	Object
    //   122	1	0	localException1	Exception
    //   126	20	0	localObject2	Object
    //   155	6	0	localObject3	Object
    //   163	9	0	localObject4	Object
    //   175	1	0	localException2	Exception
    //   177	1	0	localObject5	Object
    //   185	1	0	localException3	Exception
    //   21	56	1	localFileReader	java.io.FileReader
    //   92	1	1	localException4	Exception
    //   96	46	1	localObject6	Object
    //   151	1	1	localException5	Exception
    //   1	169	2	localObject7	Object
    //   181	1	2	localException6	Exception
    //   159	4	3	localObject8	Object
    //   167	4	3	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   12	22	92	java/lang/Exception
    //   107	111	122	java/lang/Exception
    //   115	119	122	java/lang/Exception
    //   12	22	126	finally
    //   133	137	151	java/lang/Exception
    //   141	145	151	java/lang/Exception
    //   22	34	155	finally
    //   34	39	159	finally
    //   43	64	159	finally
    //   99	103	167	finally
    //   22	34	175	java/lang/Exception
    //   34	39	181	java/lang/Exception
    //   43	64	181	java/lang/Exception
    //   68	72	185	java/lang/Exception
    //   76	80	185	java/lang/Exception
  }
  
  /* Error */
  private static void initCpuFreq(String paramString)
  {
    // Byte code:
    //   0: invokestatic 41	com/tencent/qqmini/sdk/core/utils/DeviceUtil:getCpuNumber	()I
    //   3: istore_2
    //   4: iconst_0
    //   5: istore_1
    //   6: iload_1
    //   7: iload_2
    //   8: if_icmpge +314 -> 322
    //   11: new 45	java/io/FileReader
    //   14: dup
    //   15: new 47	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   22: ldc 50
    //   24: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_1
    //   28: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc_w 260
    //   34: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 66	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   47: astore 6
    //   49: new 43	java/io/BufferedReader
    //   52: dup
    //   53: aload 6
    //   55: sipush 1024
    //   58: invokespecial 69	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   61: astore 5
    //   63: aload 5
    //   65: astore 7
    //   67: aload 6
    //   69: astore 9
    //   71: aload 5
    //   73: invokevirtual 72	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   76: astore 8
    //   78: aload 8
    //   80: ifnull +112 -> 192
    //   83: aload 5
    //   85: astore 7
    //   87: aload 6
    //   89: astore 9
    //   91: aload 8
    //   93: invokestatic 78	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   96: lstore_3
    //   97: aload 5
    //   99: astore 7
    //   101: aload 6
    //   103: astore 9
    //   105: getstatic 23	com/tencent/qqmini/sdk/core/utils/DeviceUtil:sCpuMaxFreq	J
    //   108: lload_3
    //   109: lcmp
    //   110: ifge +15 -> 125
    //   113: aload 5
    //   115: astore 7
    //   117: aload 6
    //   119: astore 9
    //   121: lload_3
    //   122: putstatic 23	com/tencent/qqmini/sdk/core/utils/DeviceUtil:sCpuMaxFreq	J
    //   125: aload 5
    //   127: astore 7
    //   129: aload 6
    //   131: astore 9
    //   133: ldc 121
    //   135: invokestatic 266	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   138: ldc_w 268
    //   141: iconst_2
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: iload_1
    //   148: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: aastore
    //   152: dup
    //   153: iconst_1
    //   154: lload_3
    //   155: invokestatic 276	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   158: aastore
    //   159: invokestatic 280	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   162: invokestatic 96	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload 5
    //   167: ifnull +8 -> 175
    //   170: aload 5
    //   172: invokevirtual 83	java/io/BufferedReader:close	()V
    //   175: aload 6
    //   177: ifnull +8 -> 185
    //   180: aload 6
    //   182: invokevirtual 255	java/io/FileReader:close	()V
    //   185: iload_1
    //   186: iconst_1
    //   187: iadd
    //   188: istore_1
    //   189: goto -183 -> 6
    //   192: lconst_0
    //   193: lstore_3
    //   194: goto -97 -> 97
    //   197: astore 5
    //   199: aload 5
    //   201: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   204: goto -29 -> 175
    //   207: astore 5
    //   209: aload 5
    //   211: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   214: goto -29 -> 185
    //   217: astore 8
    //   219: aload 5
    //   221: astore 7
    //   223: aload 6
    //   225: astore 9
    //   227: aload 8
    //   229: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   232: aload 5
    //   234: ifnull +8 -> 242
    //   237: aload 5
    //   239: invokevirtual 83	java/io/BufferedReader:close	()V
    //   242: aload 6
    //   244: ifnull -59 -> 185
    //   247: aload 6
    //   249: invokevirtual 255	java/io/FileReader:close	()V
    //   252: goto -67 -> 185
    //   255: astore 5
    //   257: aload 5
    //   259: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   262: goto -77 -> 185
    //   265: astore 5
    //   267: aload 5
    //   269: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   272: goto -30 -> 242
    //   275: astore_0
    //   276: aload 9
    //   278: astore 6
    //   280: aload 7
    //   282: ifnull +8 -> 290
    //   285: aload 7
    //   287: invokevirtual 83	java/io/BufferedReader:close	()V
    //   290: aload 6
    //   292: ifnull +8 -> 300
    //   295: aload 6
    //   297: invokevirtual 255	java/io/FileReader:close	()V
    //   300: aload_0
    //   301: athrow
    //   302: astore 5
    //   304: aload 5
    //   306: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   309: goto -19 -> 290
    //   312: astore 5
    //   314: aload 5
    //   316: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   319: goto -19 -> 300
    //   322: return
    //   323: astore_0
    //   324: aconst_null
    //   325: astore 7
    //   327: aconst_null
    //   328: astore 6
    //   330: goto -50 -> 280
    //   333: astore_0
    //   334: aconst_null
    //   335: astore 7
    //   337: goto -57 -> 280
    //   340: astore 8
    //   342: aconst_null
    //   343: astore 5
    //   345: aconst_null
    //   346: astore 6
    //   348: goto -129 -> 219
    //   351: astore 8
    //   353: aconst_null
    //   354: astore 5
    //   356: goto -137 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	paramString	String
    //   5	184	1	i	int
    //   3	6	2	j	int
    //   96	98	3	l	long
    //   61	110	5	localBufferedReader	java.io.BufferedReader
    //   197	3	5	localException1	Exception
    //   207	31	5	localException2	Exception
    //   255	3	5	localException3	Exception
    //   265	3	5	localException4	Exception
    //   302	3	5	localException5	Exception
    //   312	3	5	localException6	Exception
    //   343	12	5	localObject1	Object
    //   47	300	6	localObject2	Object
    //   65	271	7	localObject3	Object
    //   76	16	8	str	String
    //   217	11	8	localException7	Exception
    //   340	1	8	localException8	Exception
    //   351	1	8	localException9	Exception
    //   69	208	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   170	175	197	java/lang/Exception
    //   180	185	207	java/lang/Exception
    //   71	78	217	java/lang/Exception
    //   91	97	217	java/lang/Exception
    //   105	113	217	java/lang/Exception
    //   121	125	217	java/lang/Exception
    //   133	165	217	java/lang/Exception
    //   247	252	255	java/lang/Exception
    //   237	242	265	java/lang/Exception
    //   71	78	275	finally
    //   91	97	275	finally
    //   105	113	275	finally
    //   121	125	275	finally
    //   133	165	275	finally
    //   227	232	275	finally
    //   285	290	302	java/lang/Exception
    //   295	300	312	java/lang/Exception
    //   11	49	323	finally
    //   49	63	333	finally
    //   11	49	340	java/lang/Exception
    //   49	63	351	java/lang/Exception
  }
  
  private static void initCpuMaxFreq()
  {
    initCpuFreq("cpuinfo_max_freq");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.DeviceUtil
 * JD-Core Version:    0.7.0.1
 */