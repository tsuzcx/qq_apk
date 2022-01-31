package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.core.b.c;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.n;
import com.tencent.mobileqq.msf.sdk.n.a;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class f
{
  static String a = "MSF.C.LogManager";
  static boolean b = true;
  static int c = 0;
  static boolean d = false;
  static long e = 0L;
  static boolean f = false;
  static String g = "http://misc.3g.qq.com/g/mqqcl/upload.jsp";
  static String h = "http://misc.3g.qq.com/g/mqqcl/creport.jsp";
  private static final BroadcastReceiver i = new g();
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "zip file start");
    }
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt1, paramInt2 - 1, paramInt3, paramInt4, 0, 0);
    long l2 = ((Calendar)localObject1).getTimeInMillis();
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt5, paramInt6 - 1, paramInt7, paramInt8, 0, 0);
    long l4 = ((Calendar)localObject1).getTimeInMillis();
    long l1 = System.currentTimeMillis();
    if (l4 >= l1) {
      ((Calendar)localObject1).setTimeInMillis(l1);
    }
    localObject1 = new HashSet();
    int k = 0;
    l1 = l2;
    int j;
    long l3;
    do
    {
      localObject2 = n.d().format(Long.valueOf(l1)) + ".log";
      ((HashSet)localObject1).add(localObject2);
      j = k;
      if (k == 0) {
        j = ((String)localObject2).length();
      }
      l3 = l1 + 3600000L;
      k = j;
      l1 = l3;
    } while (l3 <= l4);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new File(n.b());
    int m;
    Object localObject5;
    if (((File)localObject2).exists())
    {
      localObject3 = ((File)localObject2).listFiles();
      if (localObject3 != null)
      {
        m = localObject3.length;
        k = 0;
        while (k < m)
        {
          localObject4 = localObject3[k];
          localObject5 = ((File)localObject4).getName();
          if ((((String)localObject5).startsWith(n.a())) && (((HashSet)localObject1).contains(((String)localObject5).substring(((String)localObject5).length() - j)))) {
            localArrayList.add(new n.a(((File)localObject4).getPath()));
          }
          k += 1;
        }
      }
    }
    else
    {
      ((File)localObject2).mkdirs();
    }
    Object localObject4 = new File(n.c());
    if (((File)localObject4).exists())
    {
      localObject3 = ((File)localObject4).listFiles();
      if (localObject3 != null)
      {
        m = localObject3.length;
        k = 0;
        while (k < m)
        {
          localObject5 = localObject3[k];
          String str = ((File)localObject5).getName();
          if ((str.startsWith(n.a())) && (((HashSet)localObject1).contains(str.substring(str.length() - j))))
          {
            localObject5 = new n.a(((File)localObject5).getPath());
            ((n.a)localObject5).a = ".old";
            localArrayList.add(localObject5);
          }
          k += 1;
        }
      }
    }
    localObject3 = null;
    for (;;)
    {
      try
      {
        if (((File)localObject2).exists()) {
          localObject1 = new n.a((File)localObject2, "FileList.log");
        }
      }
      catch (Exception localException2)
      {
        boolean bool;
        localObject1 = localObject3;
        continue;
      }
      try
      {
        localObject3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((File)localObject1)));
        if (localObject3 != null)
        {
          if (((File)localObject4).exists())
          {
            localObject4 = ((File)localObject4).listFiles();
            if (localObject4 != null)
            {
              k = localObject4.length;
              j = 0;
              if (j < k)
              {
                localObject5 = localObject4[j];
                ((BufferedWriter)localObject3).write(((File)localObject5).getName() + "\n");
                j += 1;
                continue;
              }
            }
          }
          localObject2 = ((File)localObject2).listFiles();
          if (localObject2 != null)
          {
            k = localObject2.length;
            j = 0;
            if (j < k)
            {
              localObject4 = localObject2[j];
              ((BufferedWriter)localObject3).write(((File)localObject4).getName() + "\n");
              j += 1;
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
        ((Calendar)localObject1).setTimeInMillis(l2);
        ((Calendar)localObject1).set(11, 0);
        ((Calendar)localObject1).set(12, 0);
        ((Calendar)localObject1).set(13, 0);
        ((Calendar)localObject1).set(14, 0);
        l1 = ((Calendar)localObject1).getTimeInMillis();
        localObject1 = null;
        if ((!d) || (e != l1))
        {
          localObject1 = c.a(l1, 86400000L + l1);
          if (QLog.isColorLevel())
          {
            localObject2 = a;
            localObject3 = new StringBuilder().append("get user 24h netflow ");
            if (localObject1 != null) {
              continue;
            }
            bool = false;
            QLog.d((String)localObject2, 2, bool);
          }
        }
        if (localObject1 != null)
        {
          d = true;
          e = l1;
          localArrayList.add(localObject1);
        }
        localObject1 = n.b() + paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4 + "-" + paramInt5 + "_" + paramInt6 + "_" + paramInt7 + "_" + paramInt8 + ".zip";
        a(localArrayList, (String)localObject1);
        return localObject1;
      }
      catch (Exception localException3)
      {
        continue;
      }
      ((File)localObject2).mkdir();
      localObject1 = new n.a((File)localObject2, "FileList.log");
      try
      {
        localObject2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((File)localObject1)));
        if (((File)localObject4).exists())
        {
          localObject3 = ((File)localObject4).listFiles();
          if (localObject3 != null)
          {
            k = localObject3.length;
            j = 0;
            if (j < k)
            {
              localObject4 = localObject3[j];
              ((BufferedWriter)localObject2).write(((File)localObject4).getName() + "\n");
              j += 1;
              continue;
            }
          }
        }
        else
        {
          ((BufferedWriter)localObject2).write("no log file in old and new path.");
        }
        ((BufferedWriter)localObject2).flush();
        ((BufferedWriter)localObject2).close();
      }
      catch (Exception localException1) {}
      QLog.d(a, 1, "read Log file list error. " + localException1, localException1);
      continue;
      bool = true;
    }
  }
  
  public static void a()
  {
    try
    {
      if (!f)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        BaseApplication.getContext().registerReceiver(i, localIntentFilter);
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "LogManager inited.");
        }
        f = true;
      }
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt, File paramFile, long paramLong)
    throws Exception
  {
    if (BaseConstants.REPORTLOGONCEMAXSIZE < 1024L) {
      BaseConstants.REPORTLOGONCEMAXSIZE = 1024L;
    }
    int k = 1;
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "want send size " + paramFile.length());
    }
    int j;
    if (paramFile.length() % BaseConstants.REPORTLOGONCEMAXSIZE > 0L)
    {
      j = (int)(paramFile.length() / BaseConstants.REPORTLOGONCEMAXSIZE + 1L);
      if (j <= BaseConstants.REPORTLOGMAXPACKAGECOUNT) {
        break label149;
      }
      a(paramInt, d(), "report size is too big " + paramFile.length(), MsfSdkUtils.insertMtype("reportLog", g), 1, j);
    }
    for (;;)
    {
      return;
      j = (int)(paramFile.length() / BaseConstants.REPORTLOGONCEMAXSIZE);
      break;
      label149:
      while (l1 < paramFile.length())
      {
        long l3 = paramFile.length() - l1;
        long l2 = l3;
        if (l3 > BaseConstants.REPORTLOGONCEMAXSIZE) {
          l2 = BaseConstants.REPORTLOGONCEMAXSIZE;
        }
        a(paramInt, d(), paramFile, MsfSdkUtils.insertMtype("reportLog", g), k, j, l1, l2, false, "", "", paramLong);
        l1 += l2;
        k += 1;
      }
    }
  }
  
  private static void a(int paramInt1, String paramString1, File paramFile, String paramString2, int paramInt2, int paramInt3, long paramLong1, long paramLong2, boolean paramBoolean, String paramString3, String paramString4, long paramLong3)
    throws Exception
  {
    k.c();
    Object localObject1 = MsfSdkUtils.getLoginedAccountList().iterator();
    Object localObject2;
    for (String str = ""; ((Iterator)localObject1).hasNext(); str = str + ((SimpleAccount)localObject2).getUin() + ",") {
      localObject2 = (SimpleAccount)((Iterator)localObject1).next();
    }
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
        localObject1 = new DataOutputStream(paramString2.getOutputStream());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=appid\r\n\r\n");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=os\r\n\r\n");
        ((StringBuilder)localObject2).append(Build.VERSION.SDK);
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=model\r\n\r\n");
        ((StringBuilder)localObject2).append(Build.MODEL + "|" + Build.VERSION.RELEASE);
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=fileKey\r\n\r\n");
        ((StringBuilder)localObject2).append(paramFile.getName());
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=imei\r\n\r\n");
        ((StringBuilder)localObject2).append(k.d());
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=fileSeq\r\n\r\n");
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=fileMaxSeq\r\n\r\n");
        ((StringBuilder)localObject2).append(paramInt3);
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=errormsg\r\n\r\n");
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=logFormat\r\n\r\n");
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=gzip\r\n\r\n");
        ((StringBuilder)localObject2).append("true");
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=clientuins\r\n\r\n");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=seq\r\n\r\n");
        ((StringBuilder)localObject2).append(paramLong3);
        ((StringBuilder)localObject2).append("\r\n");
        if (paramBoolean)
        {
          ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
          ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=cmdstr\r\n\r\n");
          ((StringBuilder)localObject2).append(paramString3);
          ((StringBuilder)localObject2).append("\r\n");
          ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
          ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=opinfo\r\n\r\n");
          ((StringBuilder)localObject2).append(paramString4);
          ((StringBuilder)localObject2).append("\r\n");
        }
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition:form-data;name=logFile;filename=\"" + paramFile.getName() + "\"\r\n");
        ((StringBuilder)localObject2).append("Content-Type: application/x-zip-compressed\r\n\r\n");
        ((DataOutputStream)localObject1).write(((StringBuilder)localObject2).toString().getBytes("UTF-8"));
        paramString3 = new FileInputStream(paramFile);
        try
        {
          paramString4 = new byte[20480];
          if (paramLong1 <= 0L) {
            continue;
          }
          paramString3.skip(paramLong1);
        }
        finally
        {
          paramString3.close();
        }
        paramInt1 = paramString3.read(paramString4, 0, 20480);
        if (paramInt1 != -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "read " + paramInt1 + " from " + paramFile.getName());
          }
          if (paramInt1 + paramLong1 <= paramLong2) {
            continue;
          }
          ((DataOutputStream)localObject1).write(paramString4, 0, (int)(paramLong2 - paramLong1));
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "send " + (paramLong1 + (paramLong2 - paramLong1)));
          }
        }
        paramString3.close();
        ((DataOutputStream)localObject1).write("\r\n".getBytes());
        ((DataOutputStream)localObject1).write(("--" + paramString1 + "--\r\n").getBytes());
        ((DataOutputStream)localObject1).flush();
        ((DataOutputStream)localObject1).close();
        a(paramString2);
        if (paramString2 != null) {
          paramString2.disconnect();
        }
        if (MsfCore.SysVerSion >= 14) {
          TrafficStats.clearThreadStatsTag();
        }
        return;
        ((DataOutputStream)localObject1).write(paramString4, 0, paramString4.length);
        paramLong3 = paramLong1 + paramInt1;
        paramLong1 = paramLong3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(a, 2, "send " + paramLong3);
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
    k.c();
    Object localObject = MsfSdkUtils.getLoginedAccountList().iterator();
    SimpleAccount localSimpleAccount;
    for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localSimpleAccount.getUin() + ",") {
      localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=appid\r\n\r\n");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=os\r\n\r\n");
    ((StringBuilder)localObject).append(Build.VERSION.SDK);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=model\r\n\r\n");
    ((StringBuilder)localObject).append(Build.MODEL + "|" + Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=errormsg\r\n\r\n");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=fileKey\r\n\r\n");
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=imei\r\n\r\n");
    ((StringBuilder)localObject).append(k.d());
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=fileSeq\r\n\r\n");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=fileMaxSeq\r\n\r\n");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=clientuins\r\n\r\n");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--" + paramString1 + "--\r\n");
    paramDataOutputStream.flush();
    paramDataOutputStream.close();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    label199:
    label213:
    do
    {
      for (;;)
      {
        return;
        paramString1 = new File(paramString1);
        if (!paramString1.exists()) {
          break;
        }
        int k;
        long l1;
        int j;
        for (;;)
        {
          try
          {
            if (BaseConstants.REPORTLOGONCEMAXSIZE < 1024L) {
              BaseConstants.REPORTLOGONCEMAXSIZE = 1024L;
            }
            k = 1;
            l1 = 0L;
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "want send size " + paramString1.length());
            }
            if (paramString1.length() % BaseConstants.REPORTLOGONCEMAXSIZE <= 0L) {
              break label199;
            }
            j = (int)(paramString1.length() / BaseConstants.REPORTLOGONCEMAXSIZE + 1L);
            if (j <= BaseConstants.REPORTLOGMAXPACKAGECOUNT) {
              break label213;
            }
            a(paramInt, d(), "report size is too big " + paramString1.length(), MsfSdkUtils.insertMtype("reportLog", h), 1, j);
            return;
          }
          catch (Exception paramString1) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(a, 2, "report log error " + paramString1, paramString1);
          return;
          j = (int)(paramString1.length() / BaseConstants.REPORTLOGONCEMAXSIZE);
        }
        while (l1 < paramString1.length())
        {
          long l3 = paramString1.length() - l1;
          long l2 = l3;
          if (l3 > BaseConstants.REPORTLOGONCEMAXSIZE) {
            l2 = BaseConstants.REPORTLOGONCEMAXSIZE;
          }
          a(paramInt, d(), paramString1, h, k, j, l1, l2, true, paramString2, paramString3, 0L);
          l1 += l2;
          k += 1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(a, 2, "logName is not existed.");
  }
  
  private static void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3)
    throws Exception
  {
    String str = null;
    try
    {
      paramString3 = (HttpURLConnection)new URL(paramString3).openConnection();
      str = paramString3;
      paramString3.setDoInput(true);
      str = paramString3;
      paramString3.setDoOutput(true);
      str = paramString3;
      paramString3.setUseCaches(false);
      str = paramString3;
      paramString3.setRequestMethod("POST");
      str = paramString3;
      paramString3.setRequestProperty("Charset", "UTF-8");
      str = paramString3;
      paramString3.setRequestProperty("Content-Type", "multipart/form-data" + ";boundary=" + paramString1);
      str = paramString3;
      a(paramInt1, paramString1, paramString2, paramInt2, paramInt3, new DataOutputStream(paramString3.getOutputStream()));
      str = paramString3;
      a(paramString3);
      return;
    }
    finally
    {
      if (str != null) {
        str.disconnect();
      }
      if (MsfCore.SysVerSion >= 14) {
        TrafficStats.clearThreadStatsTag();
      }
    }
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
        int j = paramHttpURLConnection.read(arrayOfByte, 0, 1024);
        if (j == -1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "read " + new String(arrayOfByte, 0, j));
        }
      }
    }
  }
  
  public static void a(ArrayList paramArrayList, String paramString)
  {
    try
    {
      paramString = new FileOutputStream(new File(paramString));
      ZipOutputStream localZipOutputStream = new ZipOutputStream(paramString);
      int j = 0;
      Iterator localIterator;
      n.a locala;
      long l3;
      byte[] arrayOfByte;
      long l1;
      int k;
      long l2;
      boolean bool;
      for (;;) {}
    }
    catch (IOException paramArrayList)
    {
      try
      {
        localIterator = paramArrayList.iterator();
        if (localIterator.hasNext())
        {
          locala = (n.a)localIterator.next();
          if (locala.exists())
          {
            localZipOutputStream.putNextEntry(new ZipEntry(locala.getName() + locala.a));
            localZipOutputStream.setLevel(9);
            l3 = locala.length();
            paramArrayList = new FileInputStream(locala);
          }
        }
        else
        {
          for (;;)
          {
            try
            {
              arrayOfByte = new byte[20480];
              l1 = 0L;
              k = paramArrayList.read(arrayOfByte, 0, 20480);
              if (k != -1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(a, 2, "read " + k + " from " + locala.getName());
                }
                localZipOutputStream.write(arrayOfByte, 0, k);
                j = 1;
                l2 = l1 + k;
                l1 = l2;
                if (l2 >= l3) {
                  j = 1;
                }
              }
            }
            finally
            {
              paramArrayList.close();
              localZipOutputStream.flush();
              localZipOutputStream.closeEntry();
            }
          }
        }
      }
      catch (IOException paramArrayList)
      {
        paramArrayList.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(a, 2, " zip file error " + paramArrayList, paramArrayList);
        }
        paramString.close();
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, " file out stream close.");
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(a, 2, "zip file finish");
          }
          return;
          if (j != 0) {
            localZipOutputStream.close();
          }
          paramArrayList = new File(n.b(), "com.tencent.qqlite_NETFLOW.log");
          if ((paramArrayList != null) && (paramArrayList.exists()))
          {
            bool = paramArrayList.delete();
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "netflow file has been deleted: " + bool);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, " zip stream close.");
          }
          paramString.close();
          if (QLog.isColorLevel())
          {
            QLog.d(a, 2, " file out stream close.");
            continue;
            paramArrayList = paramArrayList;
            paramArrayList.printStackTrace();
          }
        }
      }
      finally
      {
        paramString.close();
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, " file out stream close.");
        }
      }
    }
  }
  
  private static void c()
  {
    h localh = new h();
    localh.setName("delLogThread");
    localh.start();
  }
  
  private static String d()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int j = 0;
    while (j < 12)
    {
      str = str + String.valueOf(localRandom.nextInt(10));
      j += 1;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.f
 * JD-Core Version:    0.7.0.1
 */