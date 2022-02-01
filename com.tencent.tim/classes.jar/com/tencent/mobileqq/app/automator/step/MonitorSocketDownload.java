package com.tencent.mobileqq.app.automator.step;

import acph;
import android.content.SharedPreferences;
import aoll;
import aolm;
import aolm.a;
import aolm.b;
import aomg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MonitorSocketDownload
  extends AsyncStep
  implements aolm.b
{
  protected static aolm.a b = new acph();
  private final String bqm = "https://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
  private final String bqn = "https://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
  private long curTime;
  private int mVersion = -1;
  
  private int Be()
  {
    this.curTime = System.currentTimeMillis();
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      try
      {
        if (QLog.isColorLevel())
        {
          int i = BaseApplicationImpl.getApplication().getSharedPreferences("monitor_socket_config", 0).getInt("version", -1);
          QLog.d("MonitorSocketDownload", 2, "checkVersion currentVersion: " + i);
        }
        String str = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + "/com.tencent.mobileqq_checkurl";
        localObject = ((QQAppInterface)localObject).getNetEngine(0);
        aoll localaoll = new aoll();
        localaoll.f = this;
        localaoll.bZ = "https://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
        localaoll.mHttpMethod = 0;
        localaoll.atY = str;
        localaoll.dPo = 0;
        localaoll.a = b;
        ((aolm)localObject).a(localaoll);
        if (QLog.isColorLevel()) {
          QLog.d("MonitorSocketDownload", 2, "send request to check version and decide whether to download MS config");
        }
        return 7;
      }
      catch (Exception localException)
      {
        QLog.d("MonitorSocketDownload", 1, "" + localException);
        return 6;
      }
    }
    return 7;
  }
  
  private void download()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    try
    {
      String str = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + "/monitor_config.properties";
      localObject = ((QQAppInterface)localObject).getNetEngine(0);
      aoll localaoll = new aoll();
      localaoll.f = this;
      localaoll.bZ = "https://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
      localaoll.mHttpMethod = 0;
      localaoll.atY = str;
      localaoll.dPo = 0;
      localaoll.a = b;
      ((aolm)localObject).a(localaoll);
      if (QLog.isColorLevel()) {
        QLog.d("MonitorSocketDownload", 2, "download MS config");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MonitorSocketDownload", 1, "" + localException);
    }
  }
  
  public int od()
  {
    return Be();
  }
  
  /* Error */
  public void onResp(aomh paramaomh)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: getfield 168	aomh:mResult	I
    //   7: ifne +222 -> 229
    //   10: iconst_1
    //   11: istore_2
    //   12: aload_1
    //   13: getfield 171	aomh:b	Laomg;
    //   16: checkcast 119	aoll
    //   19: astore_3
    //   20: new 108	java/io/File
    //   23: dup
    //   24: aload_3
    //   25: getfield 133	aoll:atY	Ljava/lang/String;
    //   28: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore 4
    //   33: iload_2
    //   34: ifeq +488 -> 522
    //   37: aload_3
    //   38: getfield 127	aoll:bZ	Ljava/lang/String;
    //   41: ldc 32
    //   43: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq +280 -> 326
    //   49: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +32 -> 84
    //   55: ldc 82
    //   57: iconst_2
    //   58: new 84	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   65: ldc 182
    //   67: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload 4
    //   72: invokevirtual 185	java/io/File:exists	()Z
    //   75: invokevirtual 188	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   78: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: new 190	java/io/FileInputStream
    //   87: dup
    //   88: aload 4
    //   90: invokespecial 193	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   93: astore 4
    //   95: new 195	java/io/BufferedReader
    //   98: dup
    //   99: new 197	java/io/InputStreamReader
    //   102: dup
    //   103: aload 4
    //   105: invokespecial 200	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   108: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   111: astore_3
    //   112: aload_3
    //   113: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   116: astore_1
    //   117: aload_1
    //   118: ifnull +92 -> 210
    //   121: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +10 -> 134
    //   127: ldc 82
    //   129: iconst_2
    //   130: aload_1
    //   131: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_1
    //   135: ldc 208
    //   137: invokevirtual 212	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   140: iconst_1
    //   141: aaload
    //   142: invokestatic 218	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   145: istore_2
    //   146: invokestatic 54	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   149: ldc 68
    //   151: iconst_0
    //   152: invokevirtual 72	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   155: ldc 74
    //   157: iconst_m1
    //   158: invokeinterface 80 3 0
    //   163: iload_2
    //   164: if_icmpne +70 -> 234
    //   167: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +40 -> 210
    //   173: ldc 82
    //   175: iconst_2
    //   176: new 84	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   183: ldc 220
    //   185: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   191: aload_0
    //   192: getfield 48	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:curTime	J
    //   195: lsub
    //   196: invokevirtual 223	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   199: ldc 225
    //   201: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: aload_3
    //   211: ifnull +7 -> 218
    //   214: aload_3
    //   215: invokevirtual 228	java/io/BufferedReader:close	()V
    //   218: aload 4
    //   220: ifnull +8 -> 228
    //   223: aload 4
    //   225: invokevirtual 229	java/io/FileInputStream:close	()V
    //   228: return
    //   229: iconst_0
    //   230: istore_2
    //   231: goto -219 -> 12
    //   234: aload_0
    //   235: invokespecial 231	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:download	()V
    //   238: aload_0
    //   239: iload_2
    //   240: putfield 36	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:mVersion	I
    //   243: goto -33 -> 210
    //   246: astore 5
    //   248: aload 4
    //   250: astore_1
    //   251: aload 5
    //   253: astore 4
    //   255: ldc 82
    //   257: iconst_1
    //   258: new 84	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   265: ldc 148
    //   267: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload 4
    //   272: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_3
    //   282: ifnull +7 -> 289
    //   285: aload_3
    //   286: invokevirtual 228	java/io/BufferedReader:close	()V
    //   289: aload_1
    //   290: ifnull -62 -> 228
    //   293: aload_1
    //   294: invokevirtual 229	java/io/FileInputStream:close	()V
    //   297: return
    //   298: astore_1
    //   299: return
    //   300: astore_1
    //   301: aconst_null
    //   302: astore_3
    //   303: aconst_null
    //   304: astore 4
    //   306: aload_3
    //   307: ifnull +7 -> 314
    //   310: aload_3
    //   311: invokevirtual 228	java/io/BufferedReader:close	()V
    //   314: aload 4
    //   316: ifnull +8 -> 324
    //   319: aload 4
    //   321: invokevirtual 229	java/io/FileInputStream:close	()V
    //   324: aload_1
    //   325: athrow
    //   326: aload_3
    //   327: getfield 127	aoll:bZ	Ljava/lang/String;
    //   330: ldc 28
    //   332: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   335: ifeq -107 -> 228
    //   338: invokestatic 54	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   341: ldc 68
    //   343: iconst_0
    //   344: invokevirtual 72	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   347: invokeinterface 235 1 0
    //   352: ldc 74
    //   354: aload_0
    //   355: getfield 36	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:mVersion	I
    //   358: invokeinterface 241 3 0
    //   363: invokeinterface 244 1 0
    //   368: pop
    //   369: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq -144 -> 228
    //   375: ldc 82
    //   377: iconst_2
    //   378: new 84	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   385: ldc 246
    //   387: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_0
    //   391: getfield 36	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:mVersion	I
    //   394: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: new 195	java/io/BufferedReader
    //   406: dup
    //   407: new 197	java/io/InputStreamReader
    //   410: dup
    //   411: new 190	java/io/FileInputStream
    //   414: dup
    //   415: aload 4
    //   417: invokespecial 193	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   420: invokespecial 200	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   423: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   426: astore_3
    //   427: aload_3
    //   428: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   431: astore_1
    //   432: aload_1
    //   433: ifnull +57 -> 490
    //   436: ldc 82
    //   438: iconst_2
    //   439: new 84	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   446: ldc 248
    //   448: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_1
    //   452: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: ldc 250
    //   457: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   463: aload_0
    //   464: getfield 48	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:curTime	J
    //   467: lsub
    //   468: invokevirtual 223	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   471: ldc 225
    //   473: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: aload_3
    //   483: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   486: astore_1
    //   487: goto -55 -> 432
    //   490: aload_3
    //   491: invokevirtual 228	java/io/BufferedReader:close	()V
    //   494: return
    //   495: astore_1
    //   496: ldc 82
    //   498: iconst_1
    //   499: new 84	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   506: ldc 148
    //   508: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: return
    //   522: ldc 82
    //   524: iconst_1
    //   525: new 84	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   532: ldc 252
    //   534: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload_1
    //   538: getfield 168	aomh:mResult	I
    //   541: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   544: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: return
    //   551: astore_1
    //   552: goto -334 -> 218
    //   555: astore_1
    //   556: return
    //   557: astore_3
    //   558: goto -269 -> 289
    //   561: astore_3
    //   562: goto -248 -> 314
    //   565: astore_3
    //   566: goto -242 -> 324
    //   569: astore_1
    //   570: aconst_null
    //   571: astore_3
    //   572: goto -266 -> 306
    //   575: astore_1
    //   576: goto -270 -> 306
    //   579: astore 5
    //   581: aload_1
    //   582: astore 4
    //   584: aload 5
    //   586: astore_1
    //   587: goto -281 -> 306
    //   590: astore 4
    //   592: aconst_null
    //   593: astore_3
    //   594: aload 5
    //   596: astore_1
    //   597: goto -342 -> 255
    //   600: astore 5
    //   602: aconst_null
    //   603: astore_3
    //   604: aload 4
    //   606: astore_1
    //   607: aload 5
    //   609: astore 4
    //   611: goto -356 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	614	0	this	MonitorSocketDownload
    //   0	614	1	paramaomh	aomh
    //   11	229	2	i	int
    //   19	472	3	localObject1	Object
    //   557	1	3	localIOException1	java.io.IOException
    //   561	1	3	localIOException2	java.io.IOException
    //   565	1	3	localIOException3	java.io.IOException
    //   571	33	3	localObject2	Object
    //   31	552	4	localObject3	Object
    //   590	15	4	localException1	Exception
    //   609	1	4	localException2	Exception
    //   1	1	5	localObject4	Object
    //   246	6	5	localException3	Exception
    //   579	16	5	localObject5	Object
    //   600	8	5	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   112	117	246	java/lang/Exception
    //   121	134	246	java/lang/Exception
    //   134	210	246	java/lang/Exception
    //   234	243	246	java/lang/Exception
    //   293	297	298	java/io/IOException
    //   84	95	300	finally
    //   403	432	495	java/lang/Exception
    //   436	487	495	java/lang/Exception
    //   490	494	495	java/lang/Exception
    //   214	218	551	java/io/IOException
    //   223	228	555	java/io/IOException
    //   285	289	557	java/io/IOException
    //   310	314	561	java/io/IOException
    //   319	324	565	java/io/IOException
    //   95	112	569	finally
    //   112	117	575	finally
    //   121	134	575	finally
    //   134	210	575	finally
    //   234	243	575	finally
    //   255	281	579	finally
    //   84	95	590	java/lang/Exception
    //   95	112	600	java/lang/Exception
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.MonitorSocketDownload
 * JD-Core Version:    0.7.0.1
 */