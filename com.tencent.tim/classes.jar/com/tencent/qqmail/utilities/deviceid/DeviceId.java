package com.tencent.qqmail.utilities.deviceid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.TimeZone;

public class DeviceId
{
  private static final String DEVIDE_ID_FILE = "did";
  private static final String TAG = "DeviceId";
  private static String deviceId = "";
  
  private static void checkDeviceId(Context paramContext)
  {
    if (deviceId.length() > 0)
    {
      paramContext = readDeviceIDFile(paramContext);
      if (!paramContext.equals(deviceId)) {
        QMLog.log(4, "DeviceId", "deviceid change, " + paramContext + ", " + deviceId);
      }
    }
  }
  
  private static String getDeviceId()
  {
    String str = "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10;
    TimeZone.getDefault().getRawOffset();
    return str;
  }
  
  public static String getDeviceId4()
  {
    if (TextUtils.isEmpty(deviceId)) {
      initDeviceId(QMApplicationContext.sharedInstance());
    }
    return deviceId;
  }
  
  public static void init(Context paramContext)
  {
    Threads.runInBackground(new DeviceId.1(paramContext));
  }
  
  /* Error */
  public static String initDeviceId(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 18	com/tencent/qqmail/utilities/deviceid/DeviceId:deviceId	Ljava/lang/String;
    //   3: invokevirtual 30	java/lang/String:length	()I
    //   6: ifle +7 -> 13
    //   9: getstatic 18	com/tencent/qqmail/utilities/deviceid/DeviceId:deviceId	Ljava/lang/String;
    //   12: areturn
    //   13: aload_0
    //   14: invokestatic 34	com/tencent/qqmail/utilities/deviceid/DeviceId:readDeviceIDFile	(Landroid/content/Context;)Ljava/lang/String;
    //   17: putstatic 18	com/tencent/qqmail/utilities/deviceid/DeviceId:deviceId	Ljava/lang/String;
    //   20: aload_0
    //   21: invokestatic 146	com/tencent/qqmail/utilities/deviceid/DeviceId:checkDeviceId	(Landroid/content/Context;)V
    //   24: getstatic 18	com/tencent/qqmail/utilities/deviceid/DeviceId:deviceId	Ljava/lang/String;
    //   27: invokevirtual 30	java/lang/String:length	()I
    //   30: ifne +69 -> 99
    //   33: invokestatic 148	com/tencent/qqmail/utilities/deviceid/DeviceId:getDeviceId	()Ljava/lang/String;
    //   36: putstatic 18	com/tencent/qqmail/utilities/deviceid/DeviceId:deviceId	Ljava/lang/String;
    //   39: aload_0
    //   40: invokevirtual 154	android/content/Context:getFilesDir	()Ljava/io/File;
    //   43: astore_1
    //   44: aconst_null
    //   45: astore_0
    //   46: new 156	java/io/FileWriter
    //   49: dup
    //   50: new 40	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   57: aload_1
    //   58: invokevirtual 161	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   61: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 163
    //   66: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 8
    //   71: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 166	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   80: astore_1
    //   81: aload_1
    //   82: astore_0
    //   83: aload_1
    //   84: getstatic 18	com/tencent/qqmail/utilities/deviceid/DeviceId:deviceId	Ljava/lang/String;
    //   87: invokevirtual 169	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   90: pop
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 172	java/io/FileWriter:close	()V
    //   99: getstatic 18	com/tencent/qqmail/utilities/deviceid/DeviceId:deviceId	Ljava/lang/String;
    //   102: areturn
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: astore_0
    //   108: bipush 6
    //   110: ldc 11
    //   112: ldc 174
    //   114: aload_2
    //   115: invokestatic 177	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: aload_1
    //   119: ifnull -20 -> 99
    //   122: aload_1
    //   123: invokevirtual 172	java/io/FileWriter:close	()V
    //   126: goto -27 -> 99
    //   129: astore_0
    //   130: goto -31 -> 99
    //   133: astore_2
    //   134: aload_0
    //   135: astore_1
    //   136: aload_2
    //   137: astore_0
    //   138: aload_1
    //   139: ifnull +7 -> 146
    //   142: aload_1
    //   143: invokevirtual 172	java/io/FileWriter:close	()V
    //   146: aload_0
    //   147: athrow
    //   148: astore_0
    //   149: goto -50 -> 99
    //   152: astore_1
    //   153: goto -7 -> 146
    //   156: astore_2
    //   157: aload_0
    //   158: astore_1
    //   159: aload_2
    //   160: astore_0
    //   161: goto -23 -> 138
    //   164: astore_2
    //   165: goto -59 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramContext	Context
    //   43	100	1	localObject1	Object
    //   152	1	1	localIOException1	java.io.IOException
    //   158	1	1	localContext	Context
    //   103	12	2	localIOException2	java.io.IOException
    //   133	4	2	localObject2	Object
    //   156	4	2	localObject3	Object
    //   164	1	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   46	81	103	java/io/IOException
    //   122	126	129	java/io/IOException
    //   46	81	133	finally
    //   95	99	148	java/io/IOException
    //   142	146	152	java/io/IOException
    //   83	91	156	finally
    //   108	118	156	finally
    //   83	91	164	java/io/IOException
  }
  
  /* Error */
  private static String readDeviceIDFile(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: invokevirtual 154	android/content/Context:getFilesDir	()Ljava/io/File;
    //   8: astore_0
    //   9: new 40	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: invokevirtual 161	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 163
    //   25: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 8
    //   30: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_0
    //   37: new 158	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: invokevirtual 184	java/io/File:exists	()Z
    //   48: ifeq +47 -> 95
    //   51: new 186	java/io/BufferedReader
    //   54: dup
    //   55: new 188	java/io/FileReader
    //   58: dup
    //   59: aload_0
    //   60: invokespecial 189	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   63: invokespecial 192	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_1
    //   67: aload_1
    //   68: astore_0
    //   69: aload_1
    //   70: invokevirtual 195	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore_2
    //   74: aload_2
    //   75: astore_0
    //   76: aload_1
    //   77: ifnull +106 -> 183
    //   80: aload_1
    //   81: invokevirtual 196	java/io/BufferedReader:close	()V
    //   84: aload_0
    //   85: astore_1
    //   86: aload_0
    //   87: ifnonnull +6 -> 93
    //   90: ldc 16
    //   92: astore_1
    //   93: aload_1
    //   94: areturn
    //   95: bipush 6
    //   97: ldc 11
    //   99: ldc 198
    //   101: invokestatic 59	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_2
    //   107: astore_0
    //   108: goto -32 -> 76
    //   111: astore_1
    //   112: goto -28 -> 84
    //   115: astore_2
    //   116: aconst_null
    //   117: astore_1
    //   118: aload_1
    //   119: astore_0
    //   120: bipush 6
    //   122: ldc 11
    //   124: ldc 200
    //   126: aload_2
    //   127: invokestatic 177	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: aload_1
    //   131: ifnull +47 -> 178
    //   134: aload_1
    //   135: invokevirtual 196	java/io/BufferedReader:close	()V
    //   138: aconst_null
    //   139: astore_0
    //   140: goto -56 -> 84
    //   143: astore_0
    //   144: aconst_null
    //   145: astore_0
    //   146: goto -62 -> 84
    //   149: astore_0
    //   150: aload_3
    //   151: astore_1
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 196	java/io/BufferedReader:close	()V
    //   160: aload_0
    //   161: athrow
    //   162: astore_1
    //   163: goto -3 -> 160
    //   166: astore_2
    //   167: aload_0
    //   168: astore_1
    //   169: aload_2
    //   170: astore_0
    //   171: goto -19 -> 152
    //   174: astore_2
    //   175: goto -57 -> 118
    //   178: aconst_null
    //   179: astore_0
    //   180: goto -96 -> 84
    //   183: goto -99 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramContext	Context
    //   66	40	1	localObject1	Object
    //   111	1	1	localIOException1	java.io.IOException
    //   117	40	1	localObject2	Object
    //   162	1	1	localIOException2	java.io.IOException
    //   168	1	1	localContext	Context
    //   3	104	2	str	String
    //   115	12	2	localException1	java.lang.Exception
    //   166	4	2	localObject3	Object
    //   174	1	2	localException2	java.lang.Exception
    //   1	150	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   80	84	111	java/io/IOException
    //   9	67	115	java/lang/Exception
    //   95	104	115	java/lang/Exception
    //   134	138	143	java/io/IOException
    //   9	67	149	finally
    //   95	104	149	finally
    //   156	160	162	java/io/IOException
    //   69	74	166	finally
    //   120	130	166	finally
    //   69	74	174	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.deviceid.DeviceId
 * JD-Core Version:    0.7.0.1
 */