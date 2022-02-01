package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.QLog.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtloginHelper;

public class i
{
  public static final String a = "private-";
  static String b = "MSF.C.LogManager";
  static boolean c = true;
  static int d = 0;
  static boolean e = false;
  static long f = 0L;
  static String g = "log_manager_sp";
  static boolean h = false;
  static String i = "https://qqlog.qq.com/log/passive/upload.jsp";
  static String j = "https://qqlog.qq.com/log/active/creport.jsp";
  static String k = "https://qqlog.qq.com/log/passive/report.jsp";
  public static final String l = "/tencent/msflogs/corruptInfo";
  public static int m = 1;
  public static int n = 2;
  public static int o = 3;
  private static final int p = 10000;
  private static final String q = "/data/anr/traces.txt";
  private static long r = 0L;
  private static Handler s = new j(Looper.getMainLooper());
  private static final BroadcastReceiver t = new k();
  private static final String u = "/tencent/wtlogin/com.tencent.tim/";
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString, a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "zip file start");
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt1, paramInt2 - 1, paramInt3, paramInt4, 0, 0);
    long l3 = ((Calendar)localObject1).getTimeInMillis();
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt5, paramInt6 - 1, paramInt7, paramInt8, 0, 0);
    long l1 = ((Calendar)localObject1).getTimeInMillis();
    long l2 = System.currentTimeMillis();
    if (l1 >= l2)
    {
      ((Calendar)localObject1).setTimeInMillis(l2);
      l1 = l2;
    }
    Object localObject4;
    label1187:
    for (;;)
    {
      localObject4 = new HashSet();
      int i2 = 0;
      l2 = l3;
      int i1;
      long l4;
      do
      {
        localObject1 = QLog.getLogFileFormatter().format(Long.valueOf(l2));
        ((HashSet)localObject4).add(localObject1);
        i1 = i2;
        if (i2 == 0) {
          i1 = ((String)localObject1).length();
        }
        l4 = l2 + 3600000L;
        i2 = i1;
        l2 = l4;
      } while (l4 <= l1);
      ArrayList localArrayList = new ArrayList();
      File localFile1 = new File(QLog.getLogPath());
      Object localObject3;
      if (localFile1.exists())
      {
        File[] arrayOfFile = localFile1.listFiles();
        if (arrayOfFile != null)
        {
          int i3 = arrayOfFile.length;
          i2 = 0;
          if (i2 < i3)
          {
            File localFile2 = arrayOfFile[i2];
            localObject3 = localFile2.getName();
            if (((String)localObject3).endsWith(".log")) {
              localObject1 = ((String)localObject3).substring(0, ((String)localObject3).length() - 4);
            }
            for (;;)
            {
              if ((((String)localObject1).startsWith(QLog.packageName)) && (((HashSet)localObject4).contains(((String)localObject1).substring(((String)localObject1).length() - i1))))
              {
                localObject1 = new QLog.a(localFile2.getPath());
                localArrayList.add(localObject1);
                parama.c += ((QLog.a)localObject1).length();
                parama.e = 0L;
              }
              i2 += 1;
              break;
              if (((String)localObject3).endsWith(".log.zip"))
              {
                localObject1 = ((String)localObject3).substring(0, ((String)localObject3).length() - 8);
              }
              else
              {
                localObject1 = localObject3;
                if (((String)localObject3).endsWith(".qlog")) {
                  localObject1 = ((String)localObject3).substring(0, ((String)localObject3).length() - 5);
                }
              }
            }
          }
        }
      }
      else
      {
        localFile1.mkdirs();
      }
      localObject1 = new QLog.a("/data/anr/traces.txt");
      if ((((QLog.a)localObject1).exists()) && (((QLog.a)localObject1).length() > 0L)) {
        localArrayList.add(localObject1);
      }
      localObject4 = null;
      for (;;)
      {
        try
        {
          if (localFile1.exists()) {
            localObject1 = new QLog.a(localFile1, "FileList.log");
          }
        }
        catch (Exception localException2)
        {
          boolean bool;
          Object localObject2 = localObject4;
          continue;
        }
        try
        {
          localObject3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((File)localObject1)));
          if (localObject3 != null)
          {
            localObject4 = localFile1.listFiles();
            if (localObject4 != null)
            {
              i2 = localObject4.length;
              i1 = 0;
              if (i1 < i2)
              {
                localFile1 = localObject4[i1];
                ((BufferedWriter)localObject3).write(localFile1.getName() + "\n");
                i1 += 1;
                continue;
              }
            }
          }
          ((BufferedWriter)localObject3).flush();
          ((BufferedWriter)localObject3).close();
          if (localObject1 != null) {
            localArrayList.add(localObject1);
          }
          localObject1 = Calendar.getInstance();
          ((Calendar)localObject1).setTimeInMillis(l3);
          ((Calendar)localObject1).set(11, 0);
          ((Calendar)localObject1).set(12, 0);
          ((Calendar)localObject1).set(13, 0);
          ((Calendar)localObject1).set(14, 0);
          l1 = ((Calendar)localObject1).getTimeInMillis();
          localObject1 = null;
          if ((!e) || (f != l1))
          {
            localObject1 = e.a(l1, 86400000L + l1);
            if (QLog.isColorLevel())
            {
              localObject3 = b;
              localObject4 = new StringBuilder().append("get user 24h netflow ");
              if (localObject1 != null) {
                continue;
              }
              bool = false;
              QLog.d((String)localObject3, 2, bool);
            }
          }
          if (localObject1 != null)
          {
            e = true;
            f = l1;
            localArrayList.add(localObject1);
          }
          a(localArrayList);
          a(localArrayList, paramInt1, paramInt2, paramInt3, paramInt5, paramInt6, paramInt7);
        }
        catch (Exception localException3)
        {
          continue;
          continue;
        }
        try
        {
          a(localArrayList, parama, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
          if (parama.c == 0L) {
            parama.e = 1L;
          }
          com.tencent.mobileqq.msf.core.b.a.a(com.tencent.mobileqq.msf.core.b.a.j, paramString, 20, parama);
          localObject3 = QLog.getLogPath() + String.format("%d_%d_%d_%d--%d_%d_%d_%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8) });
          paramInt1 = -1;
          paramInt1 += 1;
          if (paramInt1 != 0)
          {
            localObject1 = (String)localObject3 + "_" + paramInt1 + ".zip";
            if (new File((String)localObject1).exists()) {
              break label1187;
            }
            a(localArrayList, (String)localObject1);
            b(localArrayList);
            parama.d = new File((String)localObject1).length();
            com.tencent.mobileqq.msf.core.b.a.a(com.tencent.mobileqq.msf.core.b.a.j, paramString, 30, parama);
            return localObject1;
            localFile1.mkdir();
            localObject1 = new QLog.a(localFile1, "FileList.log");
            try
            {
              localObject3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((File)localObject1)));
              ((BufferedWriter)localObject3).write("no log file in old and new path.");
              ((BufferedWriter)localObject3).flush();
              ((BufferedWriter)localObject3).close();
            }
            catch (Exception localException1) {}
            QLog.d(b, 1, "read Log file list error. " + localException1, localException1);
            continue;
            bool = true;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          QLog.e(b, 1, "zipLog: failed. ", localThrowable);
          continue;
          localObject2 = localException1 + ".zip";
        }
      }
    }
  }
  
  public static void a()
  {
    try
    {
      if (!h)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        BaseApplication.getContext().registerReceiver(t, localIntentFilter);
        if (QLog.isColorLevel()) {
          QLog.d(b, 2, "LogManager inited.");
        }
        h = true;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(int paramInt)
  {
    // Byte code:
    //   0: iload_0
    //   1: iconst_1
    //   2: if_icmplt +8 -> 10
    //   5: iload_0
    //   6: iconst_4
    //   7: if_icmple +4 -> 11
    //   10: return
    //   11: iload_0
    //   12: invokestatic 389	com/tencent/qphone/base/util/QLog:setManualLogLevel	(I)V
    //   15: invokestatic 392	com/tencent/qphone/base/util/QLog:isExistSDCard	()Z
    //   18: ifeq +115 -> 133
    //   21: aconst_null
    //   22: astore_3
    //   23: aconst_null
    //   24: astore 5
    //   26: aconst_null
    //   27: astore 4
    //   29: aload 5
    //   31: astore_1
    //   32: new 183	java/io/File
    //   35: dup
    //   36: getstatic 395	com/tencent/qphone/base/util/QLog:manualLogLevelPath	Ljava/lang/String;
    //   39: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 6
    //   44: aload 5
    //   46: astore_1
    //   47: aload 6
    //   49: invokevirtual 193	java/io/File:exists	()Z
    //   52: ifne +12 -> 64
    //   55: aload 5
    //   57: astore_1
    //   58: aload 6
    //   60: invokevirtual 398	java/io/File:createNewFile	()Z
    //   63: pop
    //   64: aload 4
    //   66: astore_2
    //   67: aload 5
    //   69: astore_1
    //   70: aload 6
    //   72: invokevirtual 193	java/io/File:exists	()Z
    //   75: ifeq +50 -> 125
    //   78: aload 4
    //   80: astore_2
    //   81: aload 5
    //   83: astore_1
    //   84: aload 6
    //   86: invokevirtual 401	java/io/File:isFile	()Z
    //   89: ifeq +36 -> 125
    //   92: aload 5
    //   94: astore_1
    //   95: new 250	java/io/BufferedWriter
    //   98: dup
    //   99: new 403	java/io/FileWriter
    //   102: dup
    //   103: getstatic 395	com/tencent/qphone/base/util/QLog:manualLogLevelPath	Ljava/lang/String;
    //   106: invokespecial 404	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   109: invokespecial 263	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   112: astore_2
    //   113: aload_2
    //   114: iload_0
    //   115: invokestatic 406	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   118: invokevirtual 278	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   121: aload_2
    //   122: invokevirtual 281	java/io/BufferedWriter:flush	()V
    //   125: aload_2
    //   126: ifnull +7 -> 133
    //   129: aload_2
    //   130: invokevirtual 284	java/io/BufferedWriter:close	()V
    //   133: ldc_w 408
    //   136: getstatic 414	com/tencent/mobileqq/msf/service/MsfService:core	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   139: invokevirtual 419	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   142: invokestatic 423	com/tencent/mobileqq/msf/core/MsfCore:initAppProMsg	(Ljava/lang/String;I)V
    //   145: return
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   151: goto -18 -> 133
    //   154: astore_1
    //   155: aload_3
    //   156: astore_2
    //   157: aload_1
    //   158: astore_3
    //   159: aload_2
    //   160: astore_1
    //   161: getstatic 51	com/tencent/mobileqq/msf/core/i:b	Ljava/lang/String;
    //   164: iconst_1
    //   165: ldc_w 426
    //   168: aload_3
    //   169: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: aload_2
    //   173: ifnull -40 -> 133
    //   176: aload_2
    //   177: invokevirtual 284	java/io/BufferedWriter:close	()V
    //   180: goto -47 -> 133
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   188: goto -55 -> 133
    //   191: astore_3
    //   192: aload_1
    //   193: astore_2
    //   194: aload_3
    //   195: astore_1
    //   196: aload_2
    //   197: ifnull +7 -> 204
    //   200: aload_2
    //   201: invokevirtual 284	java/io/BufferedWriter:close	()V
    //   204: aload_1
    //   205: athrow
    //   206: astore_2
    //   207: aload_2
    //   208: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   211: goto -7 -> 204
    //   214: astore_1
    //   215: goto -19 -> 196
    //   218: astore_3
    //   219: goto -60 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramInt	int
    //   31	64	1	localObject1	Object
    //   146	2	1	localIOException1	IOException
    //   154	4	1	localThrowable1	Throwable
    //   160	1	1	localObject2	Object
    //   183	10	1	localIOException2	IOException
    //   195	10	1	localObject3	Object
    //   214	1	1	localObject4	Object
    //   66	135	2	localObject5	Object
    //   206	2	2	localIOException3	IOException
    //   22	147	3	localObject6	Object
    //   191	4	3	localObject7	Object
    //   218	1	3	localThrowable2	Throwable
    //   27	52	4	localObject8	Object
    //   24	69	5	localObject9	Object
    //   42	43	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   129	133	146	java/io/IOException
    //   32	44	154	java/lang/Throwable
    //   47	55	154	java/lang/Throwable
    //   58	64	154	java/lang/Throwable
    //   70	78	154	java/lang/Throwable
    //   84	92	154	java/lang/Throwable
    //   95	113	154	java/lang/Throwable
    //   176	180	183	java/io/IOException
    //   32	44	191	finally
    //   47	55	191	finally
    //   58	64	191	finally
    //   70	78	191	finally
    //   84	92	191	finally
    //   95	113	191	finally
    //   161	172	191	finally
    //   200	204	206	java/io/IOException
    //   113	125	214	finally
    //   113	125	218	java/lang/Throwable
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    QLog.d(b, 1, new Object[] { "checkManualLogLevel, opType: ", Integer.valueOf(paramInt1), " logLevel: ", Integer.valueOf(paramInt2) });
    if (paramInt1 == m) {
      a(paramInt2);
    }
    do
    {
      return;
      if (paramInt1 == o)
      {
        QLog.setUIN_REPORTLOG_LEVEL(paramInt2);
        MsfStore.getNativeConfigStore().setConfig("LOGLEVEL_", String.valueOf(paramInt2));
        MsfStore.getNativeConfigStore().setConfig("LOGLEVELTIME", String.valueOf(System.currentTimeMillis()));
        MsfCore.initAppProMsg("*", MsfService.core.getMsfAppid());
        return;
      }
    } while (paramInt1 != n);
    File localFile = new File(QLog.manualLogLevelPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    QLog.setUIN_REPORTLOG_LEVEL(paramInt2);
    MsfStore.getNativeConfigStore().setConfig("LOGLEVEL_", String.valueOf(paramInt2));
    MsfStore.getNativeConfigStore().setConfig("LOGLEVELTIME", String.valueOf(System.currentTimeMillis()));
    MsfCore.initAppProMsg("*", MsfService.core.getMsfAppid());
  }
  
  public static void a(int paramInt, File paramFile, String paramString, a parama)
    throws Exception
  {
    if (BaseConstants.REPORTLOGONCEMAXSIZE < 1024L) {
      BaseConstants.REPORTLOGONCEMAXSIZE = 1024L;
    }
    int i3 = 1;
    long l1 = 0L;
    long l4 = paramFile.length();
    parama.f = true;
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, new Object[] { "want send size ", Long.valueOf(l4) });
    }
    int i1;
    if (l4 % BaseConstants.REPORTLOGONCEMAXSIZE > 0L)
    {
      i1 = (int)(l4 / BaseConstants.REPORTLOGONCEMAXSIZE + 1L);
      if (!NetConnInfoCenter.isWifiConn()) {
        break label170;
      }
    }
    label170:
    for (int i2 = BaseConstants.REPORTLOG_WIFI_MAXPACKAGECOUNT;; i2 = BaseConstants.REPORTLOGMAXPACKAGECOUNT)
    {
      if (i1 <= i2) {
        break label178;
      }
      a(paramInt, p(), "report size is too big " + l4, MsfSdkUtils.insertMtype("reportLog", i), 1, i1, parama, null, null);
      com.tencent.mobileqq.msf.core.b.a.a(com.tencent.mobileqq.msf.core.b.a.j, paramString, 41, parama);
      return;
      i1 = (int)(l4 / BaseConstants.REPORTLOGONCEMAXSIZE);
      break;
    }
    label178:
    while (l1 < l4)
    {
      long l3 = l4 - l1;
      long l2 = l3;
      if (l3 > BaseConstants.REPORTLOGONCEMAXSIZE) {
        l2 = BaseConstants.REPORTLOGONCEMAXSIZE;
      }
      a(paramInt, p(), paramFile, MsfSdkUtils.insertMtype("reportLog", i), i3, i1, l1, l2, false, "", "", parama.b, null, null);
      l1 += l2;
      i3 += 1;
    }
    com.tencent.mobileqq.msf.core.b.b.a(parama.b);
    com.tencent.mobileqq.msf.core.b.a.a(com.tencent.mobileqq.msf.core.b.a.j, paramString, 40, parama);
  }
  
  private static void a(int paramInt1, String paramString1, File paramFile, String paramString2, int paramInt2, int paramInt3, long paramLong1, long paramLong2, boolean paramBoolean, String paramString3, String paramString4, long paramLong3, String paramString5, String paramString6)
    throws Exception
  {
    localObject = null;
    for (;;)
    {
      try
      {
        paramString2 = (HttpURLConnection)new URL(paramString2).openConnection();
      }
      finally
      {
        continue;
        paramLong1 = 0L;
      }
      try
      {
        paramString2.setDoInput(true);
        paramString2.setDoOutput(true);
        paramString2.setUseCaches(false);
        paramString2.setRequestMethod("POST");
        paramString2.setRequestProperty("Charset", "UTF-8");
        paramString2.setRequestProperty("Content-Type", "multipart/form-data" + ";boundary=" + paramString1);
        a(paramString2, paramLong3, paramString5, paramString6);
        paramString5 = new DataOutputStream(paramString2.getOutputStream());
        paramString6 = new StringBuilder();
        a(paramString6, paramString1, paramInt1, paramInt2, paramInt3);
        paramString6.append("--").append(paramString1).append("\r\n");
        paramString6.append("Content-Disposition: form-data; name=fileKey\r\n\r\n");
        paramString6.append(paramFile.getName());
        paramString6.append("\r\n");
        paramString6.append("--").append(paramString1).append("\r\n");
        paramString6.append("Content-Disposition: form-data; name=gzip\r\n\r\n");
        paramString6.append("true");
        paramString6.append("\r\n");
        paramString6.append("--").append(paramString1).append("\r\n");
        paramString6.append("Content-Disposition: form-data; name=seq\r\n\r\n");
        paramString6.append(paramLong3);
        paramString6.append("\r\n");
        if (paramBoolean)
        {
          paramString6.append("--").append(paramString1).append("\r\n");
          paramString6.append("Content-Disposition: form-data; name=cmdstr\r\n\r\n");
          paramString6.append(paramString3);
          paramString6.append("\r\n");
          paramString6.append("--").append(paramString1).append("\r\n");
          paramString6.append("Content-Disposition: form-data; name=opinfo\r\n\r\n");
          paramString6.append(paramString4);
          paramString6.append("\r\n");
        }
        paramString6.append("--").append(paramString1).append("\r\n");
        paramString6.append("Content-Disposition:form-data;name=logFile;filename=\"" + paramFile.getName() + "\"\r\n");
        paramString6.append("Content-Type: application/x-zip-compressed\r\n\r\n");
        paramString5.write(paramString6.toString().getBytes("UTF-8"));
        paramFile = new FileInputStream(paramFile);
        try
        {
          paramString3 = new byte[20480];
          if (paramLong1 <= 0L) {
            continue;
          }
          paramFile.skip(paramLong1);
        }
        finally
        {
          paramFile.close();
        }
        paramInt1 = paramFile.read(paramString3, 0, 20480);
        if (paramInt1 != -1)
        {
          if (paramInt1 + paramLong1 <= paramLong2) {
            continue;
          }
          paramLong2 -= paramLong1;
          paramString5.write(paramString3, 0, (int)paramLong2);
          if (QLog.isColorLevel()) {
            QLog.d(b, 2, "send " + (paramLong1 + paramLong2));
          }
        }
        paramFile.close();
        paramString5.write("\r\n".getBytes());
        paramString5.write(("--" + paramString1 + "--\r\n").getBytes());
        paramString5.flush();
        paramString5.close();
        a(paramString2);
        if (paramString2 != null) {
          paramString2.disconnect();
        }
        if (MsfCore.SysVerSion >= 14) {
          TrafficStats.clearThreadStatsTag();
        }
        return;
        paramString5.write(paramString3, 0, paramInt1);
        paramLong3 = paramLong1 + paramInt1;
        paramLong1 = paramLong3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(b, 2, "send " + paramLong3);
        paramLong1 = paramLong3;
        continue;
        paramFile = finally;
      }
      finally
      {
        paramString1 = paramString2;
        if (paramString1 != null) {
          paramString1.disconnect();
        }
        if (MsfCore.SysVerSion >= 14) {
          TrafficStats.clearThreadStatsTag();
        }
      }
    }
  }
  
  private static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DataOutputStream paramDataOutputStream)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, paramString1, paramInt1, paramInt2, paramInt3);
    localStringBuilder.append("--").append(paramString1).append("\r\n");
    localStringBuilder.append("Content-Disposition: form-data; name=errormsg\r\n\r\n");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("--").append(paramString1).append("\r\n");
    localStringBuilder.append("Content-Disposition: form-data; name=fileKey\r\n\r\n");
    localStringBuilder.append("");
    localStringBuilder.append("\r\n");
    localStringBuilder.append("--" + paramString1 + "--\r\n");
    paramDataOutputStream.write(localStringBuilder.toString().getBytes("UTF-8"));
    paramDataOutputStream.flush();
    paramDataOutputStream.close();
  }
  
  /* Error */
  private static void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, a parama, String paramString4, String paramString5)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: new 515	java/net/URL
    //   6: dup
    //   7: aload_3
    //   8: invokespecial 516	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 520	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   14: checkcast 522	java/net/HttpURLConnection
    //   17: astore_3
    //   18: aload_3
    //   19: astore 11
    //   21: aload_3
    //   22: iconst_1
    //   23: invokevirtual 526	java/net/HttpURLConnection:setDoInput	(Z)V
    //   26: aload_3
    //   27: astore 11
    //   29: aload_3
    //   30: iconst_1
    //   31: invokevirtual 529	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   34: aload_3
    //   35: astore 11
    //   37: aload_3
    //   38: iconst_0
    //   39: invokevirtual 532	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   42: aload_3
    //   43: astore 11
    //   45: aload_3
    //   46: ldc_w 534
    //   49: invokevirtual 537	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   52: aload_3
    //   53: astore 11
    //   55: aload_3
    //   56: ldc_w 539
    //   59: ldc_w 541
    //   62: invokevirtual 545	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_3
    //   66: astore 11
    //   68: aload_3
    //   69: ldc_w 547
    //   72: new 265	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 549
    //   82: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 551
    //   88: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokevirtual 545	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 6
    //   103: ifnull +77 -> 180
    //   106: aload_3
    //   107: astore 11
    //   109: aload 6
    //   111: getfield 505	com/tencent/mobileqq/msf/core/i$a:b	J
    //   114: lstore 9
    //   116: aload_3
    //   117: astore 11
    //   119: aload_3
    //   120: lload 9
    //   122: aload 7
    //   124: aload 8
    //   126: invokestatic 554	com/tencent/mobileqq/msf/core/i:a	(Ljava/net/HttpURLConnection;JLjava/lang/String;Ljava/lang/String;)V
    //   129: aload_3
    //   130: astore 11
    //   132: iload_0
    //   133: aload_1
    //   134: aload_2
    //   135: iload 4
    //   137: iload 5
    //   139: new 556	java/io/DataOutputStream
    //   142: dup
    //   143: aload_3
    //   144: invokevirtual 560	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   147: invokespecial 561	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   150: invokestatic 635	com/tencent/mobileqq/msf/core/i:a	(ILjava/lang/String;Ljava/lang/String;IILjava/io/DataOutputStream;)V
    //   153: aload_3
    //   154: astore 11
    //   156: aload_3
    //   157: invokestatic 619	com/tencent/mobileqq/msf/core/i:a	(Ljava/net/HttpURLConnection;)V
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 622	java/net/HttpURLConnection:disconnect	()V
    //   168: getstatic 625	com/tencent/mobileqq/msf/core/MsfCore:SysVerSion	I
    //   171: bipush 14
    //   173: if_icmplt +6 -> 179
    //   176: invokestatic 630	android/net/TrafficStats:clearThreadStatsTag	()V
    //   179: return
    //   180: lconst_0
    //   181: lstore 9
    //   183: goto -67 -> 116
    //   186: astore_1
    //   187: aload 11
    //   189: ifnull +8 -> 197
    //   192: aload 11
    //   194: invokevirtual 622	java/net/HttpURLConnection:disconnect	()V
    //   197: getstatic 625	com/tencent/mobileqq/msf/core/MsfCore:SysVerSion	I
    //   200: bipush 14
    //   202: if_icmplt +6 -> 208
    //   205: invokestatic 630	android/net/TrafficStats:clearThreadStatsTag	()V
    //   208: aload_1
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramInt1	int
    //   0	210	1	paramString1	String
    //   0	210	2	paramString2	String
    //   0	210	3	paramString3	String
    //   0	210	4	paramInt2	int
    //   0	210	5	paramInt3	int
    //   0	210	6	parama	a
    //   0	210	7	paramString4	String
    //   0	210	8	paramString5	String
    //   114	68	9	l1	long
    //   1	192	11	str	String
    // Exception table:
    //   from	to	target	type
    //   3	18	186	finally
    //   21	26	186	finally
    //   29	34	186	finally
    //   37	42	186	finally
    //   45	52	186	finally
    //   55	65	186	finally
    //   68	101	186	finally
    //   109	116	186	finally
    //   119	129	186	finally
    //   132	153	186	finally
    //   156	160	186	finally
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    label214:
    label228:
    label236:
    do
    {
      for (;;)
      {
        return;
        paramString1 = new File(paramString1);
        if (!paramString1.exists()) {
          break;
        }
        int i3;
        long l1;
        int i1;
        for (;;)
        {
          try
          {
            if (BaseConstants.REPORTLOGONCEMAXSIZE < 1024L) {
              BaseConstants.REPORTLOGONCEMAXSIZE = 1024L;
            }
            i3 = 1;
            l1 = 0L;
            if (QLog.isColorLevel()) {
              QLog.d(b, 2, "want send size " + paramString1.length());
            }
            if (paramString1.length() % BaseConstants.REPORTLOGONCEMAXSIZE <= 0L) {
              break label214;
            }
            i1 = (int)(paramString1.length() / BaseConstants.REPORTLOGONCEMAXSIZE + 1L);
            if (!NetConnInfoCenter.isWifiConn()) {
              break label228;
            }
            i2 = BaseConstants.REPORTLOG_WIFI_MAXPACKAGECOUNT;
            if (i1 <= i2) {
              break label236;
            }
            a(paramInt, p(), "report size is too big " + paramString1.length(), MsfSdkUtils.insertMtype("reportLog", j), 1, i1, null, paramString4, paramString5);
            return;
          }
          catch (Exception paramString1) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(b, 2, "report log error " + paramString1, paramString1);
          return;
          i1 = (int)(paramString1.length() / BaseConstants.REPORTLOGONCEMAXSIZE);
          continue;
          int i2 = BaseConstants.REPORTLOGMAXPACKAGECOUNT;
        }
        while (l1 < paramString1.length())
        {
          long l3 = paramString1.length() - l1;
          long l2 = l3;
          if (l3 > BaseConstants.REPORTLOGONCEMAXSIZE) {
            l2 = BaseConstants.REPORTLOGONCEMAXSIZE;
          }
          a(paramInt, p(), paramString1, j, i3, i1, l1, l2, true, paramString2, paramString3, 0L, paramString4, paramString5);
          l1 += l2;
          i3 += 1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(b, 2, "logName is not existed.");
  }
  
  /* Error */
  public static void a(a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 643	com/tencent/mobileqq/msf/core/i$a:a	I
    //   9: invokestatic 645	com/tencent/mobileqq/msf/core/b/a:a	(I)Ljava/lang/String;
    //   12: astore 5
    //   14: getstatic 647	com/tencent/mobileqq/msf/core/b/a:a	Ljava/lang/String;
    //   17: iconst_1
    //   18: aload_0
    //   19: invokevirtual 648	com/tencent/mobileqq/msf/core/i$a:toString	()Ljava/lang/String;
    //   22: invokestatic 301	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: getstatic 651	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   28: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   31: invokevirtual 659	com/tencent/mobileqq/msf/core/ak:k	()I
    //   34: istore_1
    //   35: invokestatic 482	com/tencent/mobileqq/msf/core/i:p	()Ljava/lang/String;
    //   38: astore 6
    //   40: new 515	java/net/URL
    //   43: dup
    //   44: getstatic 99	com/tencent/mobileqq/msf/core/i:k	Ljava/lang/String;
    //   47: invokespecial 516	java/net/URL:<init>	(Ljava/lang/String;)V
    //   50: invokevirtual 520	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   53: checkcast 522	java/net/HttpURLConnection
    //   56: astore_3
    //   57: aload_3
    //   58: iconst_1
    //   59: invokevirtual 526	java/net/HttpURLConnection:setDoInput	(Z)V
    //   62: aload_3
    //   63: iconst_1
    //   64: invokevirtual 529	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   67: aload_3
    //   68: iconst_0
    //   69: invokevirtual 532	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   72: aload_3
    //   73: ldc_w 534
    //   76: invokevirtual 537	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   79: aload_3
    //   80: ldc_w 539
    //   83: ldc_w 541
    //   86: invokevirtual 545	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_3
    //   90: ldc_w 547
    //   93: new 265	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 549
    //   103: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 551
    //   109: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 6
    //   114: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokevirtual 545	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_3
    //   124: aload_0
    //   125: getfield 505	com/tencent/mobileqq/msf/core/i$a:b	J
    //   128: aconst_null
    //   129: aconst_null
    //   130: invokestatic 554	com/tencent/mobileqq/msf/core/i:a	(Ljava/net/HttpURLConnection;JLjava/lang/String;Ljava/lang/String;)V
    //   133: new 556	java/io/DataOutputStream
    //   136: dup
    //   137: aload_3
    //   138: invokevirtual 560	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   141: invokespecial 561	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   144: astore_2
    //   145: new 265	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   152: astore 4
    //   154: aload 4
    //   156: aload 6
    //   158: iload_1
    //   159: iconst_0
    //   160: iconst_0
    //   161: invokestatic 564	com/tencent/mobileqq/msf/core/i:a	(Ljava/lang/StringBuilder;Ljava/lang/String;III)V
    //   164: aload 4
    //   166: ldc_w 566
    //   169: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 6
    //   174: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc_w 568
    //   180: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 4
    //   186: ldc_w 661
    //   189: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 4
    //   195: invokestatic 664	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getAppVersion	()Ljava/lang/String;
    //   198: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 4
    //   204: ldc_w 568
    //   207: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 4
    //   213: ldc_w 566
    //   216: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 6
    //   221: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc_w 568
    //   227: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 4
    //   233: ldc_w 666
    //   236: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 4
    //   242: invokestatic 669	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetStateString	()Ljava/lang/String;
    //   245: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 4
    //   251: ldc_w 568
    //   254: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 4
    //   260: ldc_w 566
    //   263: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 6
    //   268: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc_w 568
    //   274: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 4
    //   280: ldc_w 576
    //   283: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 4
    //   289: aload_0
    //   290: getfield 505	com/tencent/mobileqq/msf/core/i$a:b	J
    //   293: invokevirtual 487	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 4
    //   299: ldc_w 568
    //   302: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 4
    //   308: ldc_w 566
    //   311: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload 6
    //   316: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc_w 568
    //   322: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 4
    //   328: ldc_w 671
    //   331: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload 4
    //   337: aload 5
    //   339: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 4
    //   345: ldc_w 568
    //   348: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 4
    //   354: ldc_w 566
    //   357: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 6
    //   362: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc_w 568
    //   368: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 4
    //   374: ldc_w 673
    //   377: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 4
    //   383: aload_0
    //   384: getfield 231	com/tencent/mobileqq/msf/core/i$a:c	J
    //   387: invokevirtual 487	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 4
    //   393: ldc_w 568
    //   396: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 4
    //   402: ldc_w 566
    //   405: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload 6
    //   410: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc_w 568
    //   416: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 4
    //   422: ldc_w 675
    //   425: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 4
    //   431: aload_0
    //   432: getfield 341	com/tencent/mobileqq/msf/core/i$a:d	J
    //   435: invokevirtual 487	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload 4
    //   441: ldc_w 568
    //   444: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload 4
    //   450: ldc_w 566
    //   453: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload 6
    //   458: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: ldc_w 568
    //   464: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 4
    //   470: ldc_w 677
    //   473: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 4
    //   479: aload_0
    //   480: getfield 235	com/tencent/mobileqq/msf/core/i$a:e	J
    //   483: invokevirtual 487	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 4
    //   489: ldc_w 568
    //   492: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 4
    //   498: ldc_w 566
    //   501: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload 6
    //   506: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc_w 568
    //   512: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 4
    //   518: ldc_w 679
    //   521: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload 4
    //   527: iconst_m1
    //   528: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 4
    //   534: ldc_w 568
    //   537: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 4
    //   543: new 265	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   550: ldc_w 566
    //   553: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 6
    //   558: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: ldc_w 614
    //   564: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload_2
    //   575: aload 4
    //   577: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: ldc_w 541
    //   583: invokevirtual 590	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   586: invokevirtual 593	java/io/DataOutputStream:write	([B)V
    //   589: aload_2
    //   590: invokevirtual 615	java/io/DataOutputStream:flush	()V
    //   593: aload_2
    //   594: invokevirtual 616	java/io/DataOutputStream:close	()V
    //   597: aload_3
    //   598: invokestatic 619	com/tencent/mobileqq/msf/core/i:a	(Ljava/net/HttpURLConnection;)V
    //   601: aload_3
    //   602: ifnull +7 -> 609
    //   605: aload_3
    //   606: invokevirtual 622	java/net/HttpURLConnection:disconnect	()V
    //   609: getstatic 625	com/tencent/mobileqq/msf/core/MsfCore:SysVerSion	I
    //   612: bipush 14
    //   614: if_icmplt +6 -> 620
    //   617: invokestatic 630	android/net/TrafficStats:clearThreadStatsTag	()V
    //   620: return
    //   621: astore_3
    //   622: aload 4
    //   624: astore_0
    //   625: aload_0
    //   626: astore_2
    //   627: getstatic 51	com/tencent/mobileqq/msf/core/i:b	Ljava/lang/String;
    //   630: iconst_1
    //   631: ldc_w 681
    //   634: aload_3
    //   635: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   638: aload_0
    //   639: ifnull +7 -> 646
    //   642: aload_0
    //   643: invokevirtual 622	java/net/HttpURLConnection:disconnect	()V
    //   646: getstatic 625	com/tencent/mobileqq/msf/core/MsfCore:SysVerSion	I
    //   649: bipush 14
    //   651: if_icmplt -31 -> 620
    //   654: invokestatic 630	android/net/TrafficStats:clearThreadStatsTag	()V
    //   657: return
    //   658: astore_0
    //   659: aload_2
    //   660: ifnull +7 -> 667
    //   663: aload_2
    //   664: invokevirtual 622	java/net/HttpURLConnection:disconnect	()V
    //   667: getstatic 625	com/tencent/mobileqq/msf/core/MsfCore:SysVerSion	I
    //   670: bipush 14
    //   672: if_icmplt +6 -> 678
    //   675: invokestatic 630	android/net/TrafficStats:clearThreadStatsTag	()V
    //   678: aload_0
    //   679: athrow
    //   680: astore_0
    //   681: aload_3
    //   682: astore_2
    //   683: goto -24 -> 659
    //   686: astore_2
    //   687: aload_3
    //   688: astore_0
    //   689: aload_2
    //   690: astore_3
    //   691: goto -66 -> 625
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	694	0	parama	a
    //   34	125	1	i1	int
    //   1	682	2	localObject	Object
    //   686	4	2	localException1	Exception
    //   56	550	3	localHttpURLConnection	HttpURLConnection
    //   621	67	3	localException2	Exception
    //   690	1	3	localException3	Exception
    //   3	620	4	localStringBuilder	StringBuilder
    //   12	326	5	str1	String
    //   38	519	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   40	57	621	java/lang/Exception
    //   40	57	658	finally
    //   627	638	658	finally
    //   57	601	680	finally
    //   57	601	686	java/lang/Exception
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    w.c();
    Iterator localIterator = MsfSdkUtils.getLoginedAccountList().iterator();
    SimpleAccount localSimpleAccount;
    for (String str = ""; localIterator.hasNext(); str = str + localSimpleAccount.getUin() + ",") {
      localSimpleAccount = (SimpleAccount)localIterator.next();
    }
    paramStringBuilder.append("--").append(paramString).append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=appid\r\n\r\n");
    paramStringBuilder.append(paramInt1);
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("--").append(paramString).append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=os\r\n\r\n");
    paramStringBuilder.append("Android");
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("--").append(paramString).append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=model\r\n\r\n");
    paramStringBuilder.append(Build.MODEL + "|" + Build.VERSION.RELEASE);
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("--").append(paramString).append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=imei\r\n\r\n");
    paramStringBuilder.append(w.d());
    paramStringBuilder.append("\r\n");
    if (paramInt2 != 0)
    {
      paramStringBuilder.append("--").append(paramString).append("\r\n");
      paramStringBuilder.append("Content-Disposition: form-data; name=fileSeq\r\n\r\n");
      paramStringBuilder.append(paramInt2);
      paramStringBuilder.append("\r\n");
    }
    if (paramInt3 != 0)
    {
      paramStringBuilder.append("--").append(paramString).append("\r\n");
      paramStringBuilder.append("Content-Disposition: form-data; name=fileMaxSeq\r\n\r\n");
      paramStringBuilder.append(paramInt3);
      paramStringBuilder.append("\r\n");
    }
    paramStringBuilder.append("--").append(paramString).append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=clientuins\r\n\r\n");
    paramStringBuilder.append(str);
    paramStringBuilder.append("\r\n");
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    if (paramHttpURLConnection.getResponseCode() == 200)
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i1 = paramHttpURLConnection.read(arrayOfByte, 0, 1024);
        if (i1 == -1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(b, 2, "read " + new String(arrayOfByte, 0, i1));
        }
      }
    }
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, long paramLong, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {}
    for (;;)
    {
      try
      {
        str = MsfService.getCore().getAccountCenter().i();
        Object localObject = "uin=o" + str;
        paramString1 = (String)localObject;
        if (paramLong != 0L) {
          paramString1 = ((String)localObject).concat("; seq=" + paramLong);
        }
        if (paramString2 == null)
        {
          Ticket localTicket = com.tencent.mobileqq.msf.core.auth.l.e.GetLocalTicket(str, 16L, 4096);
          localObject = paramString1;
          if (localTicket != null)
          {
            localObject = localTicket._sig;
            if (localObject != null) {
              localObject = paramString1.concat("; skey=" + new String((byte[])localObject));
            }
          }
          else
          {
            paramHttpURLConnection.setRequestProperty("Cookie", (String)localObject);
            paramHttpURLConnection = b;
            if (str != null) {
              break label284;
            }
            bool1 = true;
            if (paramString2 != null) {
              break label290;
            }
            bool2 = true;
            QLog.d(paramHttpURLConnection, 1, new Object[] { "setUrlConnCookie, uinIsNull", Boolean.valueOf(bool1), " skeyIsNull", Boolean.valueOf(bool2) });
            return;
          }
          QLog.i(b, 1, "setUrlConnCookie skey is null");
          localObject = paramString1;
          continue;
        }
        localObject = paramString1.concat("; skey=" + new String(paramString2));
      }
      catch (Exception paramHttpURLConnection)
      {
        QLog.e(b, 1, "setUrlConnCookie error, ", paramHttpURLConnection);
        return;
      }
      continue;
      label284:
      boolean bool1 = false;
      continue;
      label290:
      boolean bool2 = false;
    }
  }
  
  public static void a(ArrayList paramArrayList)
  {
    if ((c()) && (com.tencent.mobileqq.msf.core.a.a.ak()))
    {
      String str = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/corruptInfo";
      File localFile = new File(str);
      if ((localFile.exists()) && (localFile.length() < 8388608L)) {
        paramArrayList.add(new QLog.a(str));
      }
    }
  }
  
  public static void a(ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt1, paramInt2 - 1, paramInt3, 0, 0, 0);
    long l3 = ((Calendar)localObject1).getTimeInMillis();
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt4, paramInt5 - 1, paramInt6, 23, 59, 59);
    long l1 = ((Calendar)localObject1).getTimeInMillis();
    long l2 = System.currentTimeMillis();
    if (l1 >= l2)
    {
      ((Calendar)localObject1).setTimeInMillis(l2);
      l1 = l2;
    }
    for (;;)
    {
      localObject1 = new File(BaseApplication.getContext().getExternalCacheDir().getAbsolutePath() + "/tencent/wtlogin/com.tencent.tim/");
      if (((File)localObject1).exists())
      {
        localObject1 = ((File)localObject1).listFiles();
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          paramInt2 = localObject1.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            Object localObject2 = localObject1[paramInt1];
            l2 = localObject2.lastModified();
            if ((l2 >= l3) && (l2 <= l1)) {
              paramArrayList.add(new QLog.a(localObject2.getPath()));
            }
            paramInt1 += 1;
          }
        }
      }
      return;
    }
  }
  
  private static void a(ArrayList paramArrayList, a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (!QLog.isHasStoragePermission(BaseApplication.context))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, new Object[] { "addPivateDirLog: invoked. 如果无权限，旧有逻辑会读取私有目录上传，公有目录本身也没有权限访问，也不用上传 ", " targetLogFiles: ", paramArrayList });
      }
      return;
    }
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(paramInt1, paramInt2 - 1, paramInt3, paramInt4, 0, 0);
    long l2 = ((Calendar)localObject).getTimeInMillis();
    localObject = Calendar.getInstance();
    ((Calendar)localObject).set(paramInt5, paramInt6 - 1, paramInt7, paramInt8, 0, 0);
    long l1 = ((Calendar)localObject).getTimeInMillis();
    long l3 = System.currentTimeMillis();
    if (l1 >= l3)
    {
      ((Calendar)localObject).setTimeInMillis(l3);
      l1 = l3;
    }
    for (;;)
    {
      HashSet localHashSet = new HashSet();
      paramInt2 = 0;
      do
      {
        localObject = QLog.getLogFileFormatter().format(Long.valueOf(l2));
        localHashSet.add(localObject);
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = ((String)localObject).length();
        }
        l3 = l2 + 3600000L;
        paramInt2 = paramInt1;
        l2 = l3;
      } while (l3 <= l1);
      localObject = new File(BaseApplication.context.getExternalFilesDir(null) + "/tencent/msflogs/com/tencent/mobileqq/");
      if (((File)localObject).exists())
      {
        File[] arrayOfFile = ((File)localObject).listFiles();
        if (arrayOfFile == null) {
          break;
        }
        paramInt3 = arrayOfFile.length;
        paramInt2 = 0;
        label251:
        File localFile;
        String str;
        if (paramInt2 < paramInt3)
        {
          localFile = arrayOfFile[paramInt2];
          str = localFile.getName();
          if (!str.endsWith(".log")) {
            break label422;
          }
          localObject = str.substring(0, str.length() - 4);
        }
        for (;;)
        {
          if ((((String)localObject).startsWith(QLog.packageName)) && (localHashSet.contains(((String)localObject).substring(((String)localObject).length() - paramInt1))))
          {
            localObject = new File(localFile.getParent(), "private-" + localFile.getName());
            localFile.renameTo((File)localObject);
            localObject = new QLog.a(((File)localObject).getPath());
            paramArrayList.add(localObject);
            l1 = parama.c;
            parama.c = (((QLog.a)localObject).length() + l1);
            parama.e = 0L;
          }
          paramInt2 += 1;
          break label251;
          break;
          label422:
          if (str.endsWith(".log.zip"))
          {
            localObject = str.substring(0, str.length() - 8);
          }
          else
          {
            localObject = str;
            if (str.endsWith(".qlog")) {
              localObject = str.substring(0, str.length() - 5);
            }
          }
        }
      }
      ((File)localObject).mkdirs();
      return;
    }
  }
  
  /* Error */
  public static void a(ArrayList paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 865	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 254	java/io/FileOutputStream
    //   7: dup
    //   8: new 183	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 257	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 866	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_1
    //   23: new 868	java/util/zip/ZipOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 869	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 12
    //   33: iconst_0
    //   34: istore_2
    //   35: aload_0
    //   36: invokevirtual 693	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   39: astore_0
    //   40: aload_0
    //   41: invokeinterface 698 1 0
    //   46: ifeq +262 -> 308
    //   49: aload_0
    //   50: invokeinterface 702 1 0
    //   55: checkcast 224	com/tencent/qphone/base/util/QLog$a
    //   58: astore 13
    //   60: aload 13
    //   62: invokevirtual 243	com/tencent/qphone/base/util/QLog$a:exists	()Z
    //   65: ifeq +387 -> 452
    //   68: aload 12
    //   70: new 871	java/util/zip/ZipEntry
    //   73: dup
    //   74: new 265	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   81: aload 13
    //   83: invokevirtual 872	com/tencent/qphone/base/util/QLog$a:getName	()Ljava/lang/String;
    //   86: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 13
    //   91: getfield 873	com/tencent/qphone/base/util/QLog$a:a	Ljava/lang/String;
    //   94: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 874	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   103: invokevirtual 878	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   106: aload 12
    //   108: bipush 9
    //   110: invokevirtual 881	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   113: aload 13
    //   115: invokevirtual 233	com/tencent/qphone/base/util/QLog$a:length	()J
    //   118: lstore 9
    //   120: new 595	java/io/FileInputStream
    //   123: dup
    //   124: aload 13
    //   126: invokespecial 596	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   129: astore 13
    //   131: sipush 20480
    //   134: newarray byte
    //   136: astore 14
    //   138: lconst_0
    //   139: lstore 5
    //   141: aload 13
    //   143: aload 14
    //   145: iconst_0
    //   146: sipush 20480
    //   149: invokevirtual 603	java/io/FileInputStream:read	([BII)I
    //   152: istore 4
    //   154: iload 4
    //   156: iconst_m1
    //   157: if_icmpeq +39 -> 196
    //   160: aload 12
    //   162: aload 14
    //   164: iconst_0
    //   165: iload 4
    //   167: invokevirtual 882	java/util/zip/ZipOutputStream:write	([BII)V
    //   170: iconst_1
    //   171: istore_3
    //   172: iconst_1
    //   173: istore_2
    //   174: lload 5
    //   176: iload 4
    //   178: i2l
    //   179: ladd
    //   180: lstore 7
    //   182: lload 7
    //   184: lstore 5
    //   186: lload 7
    //   188: lload 9
    //   190: lcmp
    //   191: iflt -50 -> 141
    //   194: iload_3
    //   195: istore_2
    //   196: aload 13
    //   198: invokevirtual 609	java/io/FileInputStream:close	()V
    //   201: aload 12
    //   203: invokevirtual 883	java/util/zip/ZipOutputStream:flush	()V
    //   206: aload 12
    //   208: invokevirtual 886	java/util/zip/ZipOutputStream:closeEntry	()V
    //   211: goto +241 -> 452
    //   214: astore_0
    //   215: aload 13
    //   217: invokevirtual 609	java/io/FileInputStream:close	()V
    //   220: aload 12
    //   222: invokevirtual 883	java/util/zip/ZipOutputStream:flush	()V
    //   225: aload 12
    //   227: invokevirtual 886	java/util/zip/ZipOutputStream:closeEntry	()V
    //   230: aload_0
    //   231: athrow
    //   232: astore_0
    //   233: aload_0
    //   234: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   237: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +31 -> 271
    //   243: getstatic 51	com/tencent/mobileqq/msf/core/i:b	Ljava/lang/String;
    //   246: iconst_2
    //   247: new 265	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 888
    //   257: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_0
    //   261: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: aload_0
    //   268: invokestatic 890	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   271: aload_1
    //   272: invokevirtual 891	java/io/BufferedOutputStream:close	()V
    //   275: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +13 -> 291
    //   281: getstatic 51	com/tencent/mobileqq/msf/core/i:b	Ljava/lang/String;
    //   284: iconst_2
    //   285: ldc_w 893
    //   288: invokestatic 301	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +13 -> 307
    //   297: getstatic 51	com/tencent/mobileqq/msf/core/i:b	Ljava/lang/String;
    //   300: iconst_2
    //   301: ldc_w 895
    //   304: invokestatic 124	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: return
    //   308: iload_2
    //   309: ifeq +8 -> 317
    //   312: aload 12
    //   314: invokevirtual 896	java/util/zip/ZipOutputStream:close	()V
    //   317: new 183	java/io/File
    //   320: dup
    //   321: invokestatic 187	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   324: ldc_w 898
    //   327: invokespecial 859	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: astore_0
    //   331: aload_0
    //   332: ifnull +50 -> 382
    //   335: aload_0
    //   336: invokevirtual 193	java/io/File:exists	()Z
    //   339: ifeq +43 -> 382
    //   342: aload_0
    //   343: invokevirtual 460	java/io/File:delete	()Z
    //   346: istore 11
    //   348: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq +31 -> 382
    //   354: getstatic 51	com/tencent/mobileqq/msf/core/i:b	Ljava/lang/String;
    //   357: iconst_2
    //   358: new 265	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   365: ldc_w 900
    //   368: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: iload 11
    //   373: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   376: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 301	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +13 -> 398
    //   388: getstatic 51	com/tencent/mobileqq/msf/core/i:b	Ljava/lang/String;
    //   391: iconst_2
    //   392: ldc_w 902
    //   395: invokestatic 301	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload_1
    //   399: invokevirtual 891	java/io/BufferedOutputStream:close	()V
    //   402: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   405: ifeq -114 -> 291
    //   408: getstatic 51	com/tencent/mobileqq/msf/core/i:b	Ljava/lang/String;
    //   411: iconst_2
    //   412: ldc_w 893
    //   415: invokestatic 301	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto -127 -> 291
    //   421: astore_0
    //   422: aload_0
    //   423: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   426: goto -135 -> 291
    //   429: astore_0
    //   430: aload_1
    //   431: invokevirtual 891	java/io/BufferedOutputStream:close	()V
    //   434: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq +13 -> 450
    //   440: getstatic 51	com/tencent/mobileqq/msf/core/i:b	Ljava/lang/String;
    //   443: iconst_2
    //   444: ldc_w 893
    //   447: invokestatic 301	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: aload_0
    //   451: athrow
    //   452: goto -412 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	paramArrayList	ArrayList
    //   0	455	1	paramString	String
    //   34	275	2	i1	int
    //   171	24	3	i2	int
    //   152	25	4	i3	int
    //   139	46	5	l1	long
    //   180	7	7	l2	long
    //   118	71	9	l3	long
    //   346	26	11	bool	boolean
    //   31	282	12	localZipOutputStream	ZipOutputStream
    //   58	158	13	localObject	Object
    //   136	27	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   131	138	214	finally
    //   141	154	214	finally
    //   160	170	214	finally
    //   35	40	232	java/io/IOException
    //   40	131	232	java/io/IOException
    //   196	211	232	java/io/IOException
    //   215	232	232	java/io/IOException
    //   312	317	232	java/io/IOException
    //   317	331	232	java/io/IOException
    //   335	382	232	java/io/IOException
    //   382	398	232	java/io/IOException
    //   0	33	421	java/io/IOException
    //   271	291	421	java/io/IOException
    //   398	418	421	java/io/IOException
    //   430	450	421	java/io/IOException
    //   450	452	421	java/io/IOException
    //   35	40	429	finally
    //   40	131	429	finally
    //   196	211	429	finally
    //   215	232	429	finally
    //   233	271	429	finally
    //   312	317	429	finally
    //   317	331	429	finally
    //   335	382	429	finally
    //   382	398	429	finally
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    Object localObject;
    try
    {
      if (MsfStore.getNativeConfigStore() == null)
      {
        localObject = new MsfStore();
        try
        {
          if (!((MsfStore)localObject).init(paramContext))
          {
            QLog.e(b, 1, "initLogLevel, MsfStore init fail");
            return false;
          }
        }
        catch (Exception paramContext)
        {
          QLog.e(b, 1, "initLogLevel, MsfStore init error " + paramContext);
          return false;
        }
      }
      paramContext = MsfStore.getNativeConfigStore().getConfig("LOGLEVEL_");
    }
    catch (Exception paramContext)
    {
      QLog.d(b, 1, "initLogLevel error " + paramContext);
      return false;
    }
    if ((paramContext != null) && (paramContext.length() > 0))
    {
      localObject = MsfStore.getNativeConfigStore().getConfig("LOGLEVELTIME");
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label218;
      }
      long l1 = Long.parseLong((String)localObject);
      if ((System.currentTimeMillis() - l1 <= 259200000L) || (!paramBoolean)) {
        break label208;
      }
      localObject = new p();
      ((Thread)localObject).setName("resetLogLevelThread");
      ((Thread)localObject).start();
    }
    for (;;)
    {
      QLog.d(b, 1, new Object[] { "initLogLevel succ ,value =", paramContext });
      return true;
      label208:
      QLog.setUIN_REPORTLOG_LEVEL(Integer.parseInt(paramContext));
      continue;
      label218:
      if (paramBoolean) {
        MsfStore.getNativeConfigStore().setConfig("LOGLEVELTIME", String.valueOf(System.currentTimeMillis()));
      }
      QLog.setUIN_REPORTLOG_LEVEL(Integer.parseInt(paramContext));
    }
  }
  
  public static void b()
  {
    for (;;)
    {
      int i3;
      int i2;
      String str2;
      try
      {
        Object localObject1 = BaseApplication.getContext().getSharedPreferences(g, 0);
        l1 = ((SharedPreferences)localObject1).getLong("lastReportTime", 0L);
        bool1 = ((SharedPreferences)localObject1).getBoolean("opened", false);
        l2 = System.currentTimeMillis();
        if ((l1 != 0L) && (l2 - l1 <= 86400000L)) {
          break;
        }
        ((SharedPreferences)localObject1).edit().putLong("lastReportTime", l2).commit();
        localObject1 = new File(QLog.getLogPath());
        if (((File)localObject1).exists())
        {
          l1 = 0L;
          l3 = 0L;
          File[] arrayOfFile = ((File)localObject1).listFiles();
          if ((arrayOfFile != null) && (arrayOfFile.length > 0))
          {
            int i4 = arrayOfFile.length;
            i3 = 0;
            localObject1 = "";
            localObject3 = "";
            String str1 = "";
            i1 = 0;
            l2 = 0L;
            if (i3 < i4)
            {
              Object localObject5 = arrayOfFile[i3];
              localObject4 = ((File)localObject5).getName();
              if ((!((String)localObject4).endsWith(".log")) && (!((String)localObject4).endsWith(".qlog")) && (!((String)localObject4).endsWith(".log.zip"))) {
                break label1122;
              }
              i2 = i1 + 1;
              l5 = ((File)localObject5).length();
              l4 = ((File)localObject5).length() + l2;
              if (l1 >= l5) {
                break label1115;
              }
              str1 = ((File)localObject5).getName();
              l2 = l5;
              boolean bool2 = ((String)localObject4).startsWith(QLog.packageName);
              if (!bool2) {
                break label1102;
              }
              Object localObject6 = localObject1;
              localObject5 = localObject3;
              try
              {
                i1 = ((String)localObject4).length();
                localObject6 = localObject1;
                localObject5 = localObject3;
                if (((String)localObject4).endsWith(".log"))
                {
                  localObject6 = localObject1;
                  localObject5 = localObject3;
                  i1 = ((String)localObject4).indexOf(".log");
                  localObject6 = localObject1;
                  localObject5 = localObject3;
                  str2 = ((String)localObject4).substring(((String)localObject4).indexOf(".", ((String)localObject4).indexOf("mobileqq")) + 1, i1);
                  localObject6 = localObject1;
                  localObject5 = localObject3;
                  if (((String)localObject3).equals("")) {
                    break label1141;
                  }
                  localObject4 = localObject3;
                  localObject6 = localObject1;
                  localObject5 = localObject3;
                  if (str2.compareTo((String)localObject3) < 0) {
                    break label1141;
                  }
                  localObject6 = localObject1;
                  localObject5 = localObject4;
                  if (((String)localObject1).equals("")) {
                    break label1148;
                  }
                  localObject3 = localObject1;
                  localObject6 = localObject1;
                  localObject5 = localObject4;
                  if (str2.compareTo((String)localObject1) > 0) {
                    break label1148;
                  }
                  localObject6 = localObject3;
                  localObject5 = localObject4;
                  localObject1 = new SimpleDateFormat("yy.MM.dd.HH");
                  localObject6 = localObject3;
                  localObject5 = localObject4;
                  l1 = (((SimpleDateFormat)localObject1).parse((String)localObject3).getTime() - ((SimpleDateFormat)localObject1).parse((String)localObject4).getTime()) / 3600000L + 1L;
                  i1 = i2;
                  localObject1 = localObject3;
                  localObject3 = localObject4;
                  l3 = l4;
                  break label1155;
                }
                localObject6 = localObject1;
                localObject5 = localObject3;
                if (((String)localObject4).endsWith(".qlog"))
                {
                  localObject6 = localObject1;
                  localObject5 = localObject3;
                  i1 = ((String)localObject4).indexOf(".qlog");
                  continue;
                }
                localObject6 = localObject1;
                localObject5 = localObject3;
                if (!((String)localObject4).endsWith(".log.zip")) {
                  continue;
                }
                localObject6 = localObject1;
                localObject5 = localObject3;
                i1 = ((String)localObject4).indexOf(".log.zip");
                continue;
                localObject4 = new HashMap();
              }
              catch (ParseException localParseException)
              {
                localParseException.printStackTrace();
                l1 = -1L;
                i1 = i2;
                localObject2 = localObject6;
                localObject3 = localObject5;
                l3 = l4;
              }
            }
            ((HashMap)localObject4).put("fileCount", "" + i1);
            ((HashMap)localObject4).put("sizeTotal", "" + l2);
            ((HashMap)localObject4).put("sizeMax", "" + l1);
            ((HashMap)localObject4).put("maxSizeName", "" + str1);
            ((HashMap)localObject4).put("startLogTime", "" + (String)localObject3);
            ((HashMap)localObject4).put("endLogTime", "" + (String)localObject2);
            ((HashMap)localObject4).put("logHours", "" + l3);
            ((HashMap)localObject4).put("sdcardsize", "" + q());
            ((HashMap)localObject4).put("freesize", "" + r());
            ((HashMap)localObject4).put("compressed", "" + com.tencent.mobileqq.msf.core.a.a.r());
            ((HashMap)localObject4).put("logLevel", "" + QLog.getUIN_REPORTLOG_LEVEL());
            ((HashMap)localObject4).put("account", "" + MsfService.getCore().getAccountCenter().i());
            ((HashMap)localObject4).put("logTestOpened", "" + bool1);
            if (MsfService.getCore().getStatReporter() == null) {
              break;
            }
            MsfService.getCore().getStatReporter().a("msflogInfo2", bool1, l3, l2, (Map)localObject4, false, false);
            return;
          }
        }
        if (MsfService.getCore().getStatReporter() == null) {
          break;
        }
        Object localObject2 = MsfService.getCore().getStatReporter();
        if (!QLog.isColorLevel())
        {
          bool1 = true;
          ((com.tencent.mobileqq.msf.core.c.k)localObject2).a("msflogInfoEmpty", bool1, 0L, 0L, null, false, false);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      boolean bool1 = false;
      continue;
      label1102:
      int i1 = i2;
      long l1 = l3;
      long l3 = l4;
      break label1155;
      label1115:
      long l2 = l1;
      continue;
      label1122:
      long l4 = l2;
      l2 = l1;
      l1 = l3;
      l3 = l4;
      break label1155;
      label1141:
      Object localObject4 = str2;
      continue;
      label1148:
      Object localObject3 = str2;
      continue;
      label1155:
      i3 += 1;
      l4 = l3;
      long l5 = l2;
      l3 = l1;
      l2 = l4;
      l1 = l5;
    }
  }
  
  private static void b(ArrayList paramArrayList)
  {
    if (!QLog.isHasStoragePermission(BaseApplication.context)) {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "revertFileNameAfterZip: invoked. 如果无权限，就没有私有目录更名的逻辑，也不用回退 ");
      }
    }
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        QLog.a locala = (QLog.a)paramArrayList.next();
        if ((locala != null) && (locala.getName().startsWith("private-"))) {
          locala.renameTo(new File(locala.getParent(), locala.getName().substring("private-".length())));
        }
      }
    }
  }
  
  private static String c(File paramFile)
  {
    String str = QLog.getLogPath() + paramFile.getName();
    paramFile = str;
    if (str.endsWith(".log")) {
      paramFile = str.substring(0, str.indexOf(".log"));
    }
    return paramFile + ".qlog";
  }
  
  public static boolean c()
  {
    if (NetConnInfoCenter.isWifiConn()) {
      return true;
    }
    return (NetConnInfoCenter.isMobileConn()) && (((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkType() == 13);
  }
  
  private static boolean d(File paramFile)
  {
    ZipOutputStream localZipOutputStream;
    try
    {
      localZipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(new File(c(paramFile)))));
      localZipOutputStream.setLevel(com.tencent.mobileqq.msf.core.a.a.bj());
      byte[] arrayOfByte = new byte[8192];
      ZipEntry localZipEntry = new ZipEntry(paramFile.getName());
      localZipEntry.setSize(paramFile.length());
      localZipEntry.setTime(paramFile.lastModified());
      localZipOutputStream.putNextEntry(localZipEntry);
      paramFile = new BufferedInputStream(new FileInputStream(paramFile));
      for (;;)
      {
        int i1 = paramFile.read(arrayOfByte, 0, 8192);
        if (i1 == -1) {
          break;
        }
        localZipOutputStream.write(arrayOfByte, 0, i1);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return false;
    }
    localZipOutputStream.close();
    return true;
  }
  
  private static boolean e(File paramFile)
  {
    int i3 = 3;
    Calendar localCalendar;
    int i1;
    if (paramFile.exists())
    {
      paramFile = paramFile.listFiles();
      if ((paramFile == null) || (paramFile.length == 0)) {
        return true;
      }
      Arrays.sort(paramFile, new o());
      localCalendar = Calendar.getInstance();
      try
      {
        String str = com.tencent.mobileqq.msf.core.a.a.h();
        if ((str == null) || (str.length() <= 0)) {
          break label219;
        }
        i1 = Integer.parseInt(str);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          i1 = 3;
        }
      }
      i2 = i3;
      if (i1 >= 1) {
        if (i1 <= 14) {
          break label226;
        }
      }
    }
    label219:
    label226:
    for (int i2 = i3;; i2 = i1)
    {
      localCalendar.add(6, i2 - i2 * 2);
      long l1 = localCalendar.getTimeInMillis();
      i2 = paramFile.length;
      i1 = 0;
      while (i1 < i2)
      {
        localCalendar = paramFile[i1];
        if (QLog.isColorLevel()) {
          QLog.d(b, 2, "found log file " + localCalendar.getName());
        }
        if (l1 > localCalendar.lastModified())
        {
          localCalendar.delete();
          if (QLog.isColorLevel()) {
            QLog.d(b, 2, "del expires log " + localCalendar.getName());
          }
        }
        i1 += 1;
      }
      return false;
    }
  }
  
  private static boolean k()
  {
    try
    {
      if (com.tencent.mobileqq.msf.core.a.a.t()) {
        return false;
      }
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(g, 0);
      if (localSharedPreferences.getBoolean("opened", false)) {
        return true;
      }
      long l1 = Long.parseLong(MsfService.getCore().getAccountCenter().i());
      if ((com.tencent.mobileqq.msf.core.a.a.s()) && (l1 % 2L == 0L))
      {
        localSharedPreferences.edit().putBoolean("opened", true).commit();
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  private static void l()
  {
    l locall = new l();
    locall.setName("delLogThread");
    locall.start();
  }
  
  private static String m()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis() - 3600000L);
    return new SimpleDateFormat("yy.MM.dd.HH").format(localCalendar.getTime());
  }
  
  private static void n()
  {
    n localn = new n();
    localn.setName("delLogThread");
    localn.start();
  }
  
  private static void o()
  {
    if (QLog.isHasStoragePermission(BaseApplication.context))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "delPrivateExpiresLogIfNeed: invoked. ");
      }
      e(new File(BaseApplication.context.getExternalFilesDir(null) + "/tencent/msflogs/com/tencent/mobileqq/"));
    }
  }
  
  private static String p()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int i1 = 0;
    while (i1 < 12)
    {
      str = str + String.valueOf(localRandom.nextInt(10));
      i1 += 1;
    }
    return str;
  }
  
  private static long q()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l1 = localStatFs.getBlockSize();
      int i1 = localStatFs.getBlockCount();
      return i1 * l1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0L;
  }
  
  private static long r()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l1 = localStatFs.getBlockSize();
      int i1 = localStatFs.getAvailableBlocks();
      return i1 * l1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0L;
  }
  
  public static class a
  {
    public int a;
    public long b;
    public long c;
    public long d;
    public long e = -1L;
    public boolean f;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("logInfoContext, stat:").append(this.a).append(", reqSeq:").append(this.b).append(", logSize:").append(this.c).append(", zipLogSize:").append(this.d).append(", failCode:").append(this.e);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.i
 * JD-Core Version:    0.7.0.1
 */