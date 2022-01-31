package cooperation.qzone;

import android.content.Intent;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;

public class QZoneCrashHandler
  extends CrashHandler
{
  public static final String a = "/Tencent/MobileQQ/log/";
  private static Thread.UncaughtExceptionHandler a = null;
  
  public QZoneCrashHandler()
  {
    if (a == null) {
      a = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 28	java/io/File
    //   6: dup
    //   7: getstatic 33	com/tencent/mobileqq/app/AppConstants:ao	Ljava/lang/String;
    //   10: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 4
    //   15: aload 4
    //   17: invokevirtual 40	java/io/File:exists	()Z
    //   20: ifne +9 -> 29
    //   23: aload 4
    //   25: invokevirtual 43	java/io/File:mkdirs	()Z
    //   28: pop
    //   29: new 28	java/io/File
    //   32: dup
    //   33: new 45	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   40: getstatic 33	com/tencent/mobileqq/app/AppConstants:ao	Ljava/lang/String;
    //   43: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 52
    //   48: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore 4
    //   59: aload 4
    //   61: invokevirtual 40	java/io/File:exists	()Z
    //   64: ifne +231 -> 295
    //   67: iconst_1
    //   68: istore_3
    //   69: new 58	java/io/FileWriter
    //   72: dup
    //   73: aload 4
    //   75: iconst_1
    //   76: invokespecial 61	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   79: astore 4
    //   81: iload_3
    //   82: ifeq +105 -> 187
    //   85: aload 4
    //   87: new 45	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   94: ldc 63
    //   96: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: getstatic 68	android/os/Build:MODEL	Ljava/lang/String;
    //   102: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 70
    //   107: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: getstatic 75	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   113: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokevirtual 78	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   122: aload 4
    //   124: ldc 80
    //   126: invokevirtual 78	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   129: new 82	android/text/format/Time
    //   132: dup
    //   133: invokespecial 83	android/text/format/Time:<init>	()V
    //   136: astore 5
    //   138: aload 5
    //   140: invokevirtual 86	android/text/format/Time:setToNow	()V
    //   143: aload 4
    //   145: new 45	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   152: aload 5
    //   154: ldc 88
    //   156: invokevirtual 92	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 94
    //   164: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokevirtual 78	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   173: aload 4
    //   175: ldc 96
    //   177: invokevirtual 78	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   180: aload 4
    //   182: ldc 80
    //   184: invokevirtual 78	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   187: new 82	android/text/format/Time
    //   190: dup
    //   191: invokespecial 83	android/text/format/Time:<init>	()V
    //   194: astore 5
    //   196: aload 5
    //   198: invokevirtual 86	android/text/format/Time:setToNow	()V
    //   201: aload 4
    //   203: new 45	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   210: aload 5
    //   212: ldc 88
    //   214: invokevirtual 92	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   217: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc 94
    //   222: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokevirtual 78	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   231: aload_0
    //   232: ifnull +32 -> 264
    //   235: aload 4
    //   237: new 45	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   244: ldc 98
    //   246: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_0
    //   250: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc 100
    //   255: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokevirtual 78	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   264: aload 4
    //   266: aload_1
    //   267: invokevirtual 78	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   270: aload 4
    //   272: ldc 80
    //   274: invokevirtual 78	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   277: aload 4
    //   279: invokevirtual 103	java/io/FileWriter:close	()V
    //   282: iconst_0
    //   283: ifeq +11 -> 294
    //   286: new 105	java/lang/NullPointerException
    //   289: dup
    //   290: invokespecial 106	java/lang/NullPointerException:<init>	()V
    //   293: athrow
    //   294: return
    //   295: iconst_0
    //   296: istore_3
    //   297: goto -228 -> 69
    //   300: astore_0
    //   301: ldc 108
    //   303: iconst_1
    //   304: new 45	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   311: ldc 110
    //   313: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_0
    //   317: invokevirtual 113	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   320: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: return
    //   330: astore_1
    //   331: aload 5
    //   333: astore_0
    //   334: aload_1
    //   335: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   338: aload_0
    //   339: ifnull -45 -> 294
    //   342: aload_0
    //   343: invokevirtual 103	java/io/FileWriter:close	()V
    //   346: return
    //   347: astore_0
    //   348: ldc 108
    //   350: iconst_1
    //   351: new 45	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   358: ldc 110
    //   360: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_0
    //   364: invokevirtual 113	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   367: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: return
    //   377: astore_0
    //   378: aconst_null
    //   379: astore_1
    //   380: aload_1
    //   381: ifnull +7 -> 388
    //   384: aload_1
    //   385: invokevirtual 103	java/io/FileWriter:close	()V
    //   388: aload_0
    //   389: athrow
    //   390: astore_1
    //   391: ldc 108
    //   393: iconst_1
    //   394: new 45	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   401: ldc 110
    //   403: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_1
    //   407: invokevirtual 113	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   410: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: goto -31 -> 388
    //   422: astore_0
    //   423: aload 4
    //   425: astore_1
    //   426: goto -46 -> 380
    //   429: astore 4
    //   431: aload_0
    //   432: astore_1
    //   433: aload 4
    //   435: astore_0
    //   436: goto -56 -> 380
    //   439: astore_1
    //   440: aload 4
    //   442: astore_0
    //   443: goto -109 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	paramString1	String
    //   0	446	1	paramString2	String
    //   0	446	2	paramBoolean	boolean
    //   68	229	3	i	int
    //   13	411	4	localObject1	java.lang.Object
    //   429	12	4	localObject2	java.lang.Object
    //   1	331	5	localTime	android.text.format.Time
    // Exception table:
    //   from	to	target	type
    //   286	294	300	java/lang/Exception
    //   3	29	330	java/lang/Exception
    //   29	67	330	java/lang/Exception
    //   69	81	330	java/lang/Exception
    //   342	346	347	java/lang/Exception
    //   3	29	377	finally
    //   29	67	377	finally
    //   69	81	377	finally
    //   384	388	390	java/lang/Exception
    //   85	187	422	finally
    //   187	231	422	finally
    //   235	264	422	finally
    //   264	282	422	finally
    //   334	338	429	finally
    //   85	187	439	java/lang/Exception
    //   187	231	439	java/lang/Exception
    //   235	264	439	java/lang/Exception
    //   264	282	439	java/lang/Exception
  }
  
  void a() {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    paramThread = BaseApplicationImpl.a.getAllAccounts();
    if (paramThread != null)
    {
      paramThread = (SimpleAccount)paramThread.get(0);
      if (paramThread == null) {
        break label117;
      }
    }
    label117:
    for (paramThread = paramThread.getUin();; paramThread = "0")
    {
      long l = Long.valueOf(paramThread).longValue();
      CrashGuard.a().a(paramThrowable, l);
      paramThread = (MobileQQ)BaseApplication.getContext();
      paramThrowable = Log.getStackTraceString(paramThrowable);
      QLog.e("crash", 1, paramThrowable);
      QZoneHelper.LocalConfig.a("key_last_crash_info", paramThrowable);
      a("crash", paramThrowable, true);
      paramThrowable = new Intent(paramThread, CrashNotificationActivity.class);
      paramThrowable.addFlags(268435456);
      paramThread.startActivity(paramThrowable);
      paramThread.crashed();
      paramThread.otherProcessExit(false);
      return;
      paramThread = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneCrashHandler
 * JD-Core Version:    0.7.0.1
 */