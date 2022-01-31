package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.n;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

public class e
{
  static String a = "MSF.C.LogManager";
  static boolean b = true;
  static int c = 0;
  static boolean d = false;
  static String e = "http://misc.3g.qq.com/g/mqqcl/upload.jsp";
  static String f = "http://misc.3g.qq.com/g/mqqcl/creport.jsp";
  private static final BroadcastReceiver g = new f();
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "zip file start");
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt1, paramInt2 - 1, paramInt3, paramInt4, 0, 0);
    long l1 = ((Calendar)localObject1).getTimeInMillis();
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt5, paramInt6 - 1, paramInt7, paramInt8, 0, 0);
    long l3 = ((Calendar)localObject1).getTimeInMillis();
    long l2 = System.currentTimeMillis();
    if (l3 >= l2) {
      ((Calendar)localObject1).setTimeInMillis(l2);
    }
    localObject1 = new HashSet();
    int j = 0;
    int i;
    do
    {
      localObject2 = n.c().format(Long.valueOf(l1)) + ".log";
      ((HashSet)localObject1).add(localObject2);
      i = j;
      if (j == 0) {
        i = ((String)localObject2).length();
      }
      l2 = l1 + 3600000L;
      j = i;
      l1 = l2;
    } while (l2 <= l3);
    Object localObject2 = new ArrayList();
    Object localObject3 = new File(n.b());
    if (((File)localObject3).exists())
    {
      localObject3 = ((File)localObject3).listFiles();
      if (localObject3 != null)
      {
        int k = localObject3.length;
        j = 0;
        while (j < k)
        {
          Object localObject4 = localObject3[j];
          String str = localObject4.getName();
          if ((str.startsWith(n.a())) && (((HashSet)localObject1).contains(str.substring(str.length() - i)))) {
            ((ArrayList)localObject2).add(localObject4);
          }
          j += 1;
        }
      }
    }
    localObject1 = n.b() + paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4 + "-" + paramInt5 + "_" + paramInt6 + "_" + paramInt7 + "_" + paramInt8 + ".zip";
    a((ArrayList)localObject2, (String)localObject1);
    return localObject1;
  }
  
  public static void a()
  {
    try
    {
      if (!d)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        BaseApplication.getContext().registerReceiver(g, localIntentFilter);
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "LogManager inited.");
        }
        d = true;
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
    int j = 1;
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "want send size " + paramFile.length());
    }
    int i;
    if (paramFile.length() % BaseConstants.REPORTLOGONCEMAXSIZE > 0L)
    {
      i = (int)(paramFile.length() / BaseConstants.REPORTLOGONCEMAXSIZE + 1L);
      if (i <= BaseConstants.REPORTLOGMAXPACKAGECOUNT) {
        break label141;
      }
      a(paramInt, d(), "report size is too big " + paramFile.length(), e, 1, i);
    }
    for (;;)
    {
      return;
      i = (int)(paramFile.length() / BaseConstants.REPORTLOGONCEMAXSIZE);
      break;
      label141:
      while (l1 < paramFile.length())
      {
        long l3 = paramFile.length() - l1;
        long l2 = l3;
        if (l3 > BaseConstants.REPORTLOGONCEMAXSIZE) {
          l2 = BaseConstants.REPORTLOGONCEMAXSIZE;
        }
        a(paramInt, d(), paramFile, e, j, i, l1, l2, false, "", "", paramLong);
        l1 += l2;
        j += 1;
      }
    }
  }
  
  private static void a(int paramInt1, String paramString1, File paramFile, String paramString2, int paramInt2, int paramInt3, long paramLong1, long paramLong2, boolean paramBoolean, String paramString3, String paramString4, long paramLong3)
    throws Exception
  {
    j.c();
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
        ((StringBuilder)localObject2).append(j.d());
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
    j.c();
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
    ((StringBuilder)localObject).append(j.d());
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
    label191:
    label205:
    do
    {
      for (;;)
      {
        return;
        paramString1 = new File(paramString1);
        if (!paramString1.exists()) {
          break;
        }
        int j;
        long l1;
        int i;
        for (;;)
        {
          try
          {
            if (BaseConstants.REPORTLOGONCEMAXSIZE < 1024L) {
              BaseConstants.REPORTLOGONCEMAXSIZE = 1024L;
            }
            j = 1;
            l1 = 0L;
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "want send size " + paramString1.length());
            }
            if (paramString1.length() % BaseConstants.REPORTLOGONCEMAXSIZE <= 0L) {
              break label191;
            }
            i = (int)(paramString1.length() / BaseConstants.REPORTLOGONCEMAXSIZE + 1L);
            if (i <= BaseConstants.REPORTLOGMAXPACKAGECOUNT) {
              break label205;
            }
            a(paramInt, d(), "report size is too big " + paramString1.length(), f, 1, i);
            return;
          }
          catch (Exception paramString1) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(a, 2, "report log error " + paramString1, paramString1);
          return;
          i = (int)(paramString1.length() / BaseConstants.REPORTLOGONCEMAXSIZE);
        }
        while (l1 < paramString1.length())
        {
          long l3 = paramString1.length() - l1;
          long l2 = l3;
          if (l3 > BaseConstants.REPORTLOGONCEMAXSIZE) {
            l2 = BaseConstants.REPORTLOGONCEMAXSIZE;
          }
          a(paramInt, d(), paramString1, f, j, i, l1, l2, true, paramString2, paramString3, 0L);
          l1 += l2;
          j += 1;
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
        int i = paramHttpURLConnection.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "read " + new String(arrayOfByte, 0, i));
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
      int i = 0;
      Iterator localIterator;
      File localFile;
      long l3;
      byte[] arrayOfByte;
      long l1;
      int j;
      long l2;
      for (;;) {}
    }
    catch (IOException paramArrayList)
    {
      try
      {
        localIterator = paramArrayList.iterator();
        if (localIterator.hasNext())
        {
          localFile = (File)localIterator.next();
          if (localFile.exists())
          {
            localZipOutputStream.putNextEntry(new ZipEntry(localFile.getName()));
            localZipOutputStream.setLevel(9);
            l3 = localFile.length();
            paramArrayList = new FileInputStream(localFile);
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
              j = paramArrayList.read(arrayOfByte, 0, 20480);
              if (j != -1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(a, 2, "read " + j + " from " + localFile.getName());
                }
                localZipOutputStream.write(arrayOfByte, 0, j);
                i = 1;
                l2 = l1 + j;
                l1 = l2;
                if (l2 >= l3) {
                  i = 1;
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
          if (i != 0) {
            localZipOutputStream.close();
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
    g localg = new g();
    localg.setName("delLogThread");
    localg.start();
  }
  
  private static String d()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int i = 0;
    while (i < 12)
    {
      str = str + String.valueOf(localRandom.nextInt(10));
      i += 1;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.e
 * JD-Core Version:    0.7.0.1
 */