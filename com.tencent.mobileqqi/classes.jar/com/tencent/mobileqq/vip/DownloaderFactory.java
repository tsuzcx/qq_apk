package com.tencent.mobileqq.vip;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hjb;
import hjd;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.manager.Manager;

public class DownloaderFactory
  implements Manager
{
  public static final int a = 2048;
  public static ConnectivityManager a;
  public static final String a;
  private static Map a;
  public static boolean a = false;
  public static final int b = 600;
  private static final String b = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/DownloadConf/";
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 1;
  public static final int f = 2;
  protected AppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = DownloaderFactory.class.getSimpleName();
    jdField_a_of_type_AndroidNetConnectivityManager = null;
    jdField_a_of_type_Boolean = true;
  }
  
  public DownloaderFactory(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    if (jdField_a_of_type_AndroidNetConnectivityManager == null) {
      jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      File localFile = new File(b + paramString + ".cfg");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "delConf fileName=" + paramString);
      }
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 50	java/io/File
    //   6: dup
    //   7: getstatic 64	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/lang/String;
    //   10: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 7
    //   15: aload 7
    //   17: invokevirtual 109	java/io/File:exists	()Z
    //   20: ifne +9 -> 29
    //   23: aload 7
    //   25: invokevirtual 120	java/io/File:mkdir	()Z
    //   28: pop
    //   29: new 50	java/io/File
    //   32: dup
    //   33: new 39	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   40: getstatic 64	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/lang/String;
    //   43: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 93
    //   52: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 109	java/io/File:exists	()Z
    //   66: ifne +8 -> 74
    //   69: aload_0
    //   70: invokevirtual 123	java/io/File:createNewFile	()Z
    //   73: pop
    //   74: new 125	java/io/FileOutputStream
    //   77: dup
    //   78: aload_0
    //   79: iconst_0
    //   80: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   83: astore_0
    //   84: new 39	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   91: ldc 130
    //   93: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: lload_1
    //   97: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   100: ldc 135
    //   102: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 137
    //   107: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: lload_3
    //   111: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   114: ldc 135
    //   116: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 139
    //   121: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: lload 5
    //   126: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   129: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore 7
    //   134: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +30 -> 167
    //   140: getstatic 33	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   143: iconst_2
    //   144: new 39	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   151: ldc 141
    //   153: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 7
    //   158: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload_0
    //   168: aload 7
    //   170: invokevirtual 147	java/lang/String:getBytes	()[B
    //   173: invokevirtual 151	java/io/FileOutputStream:write	([B)V
    //   176: aload_0
    //   177: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   180: ldc 2
    //   182: monitorexit
    //   183: return
    //   184: astore_0
    //   185: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq -8 -> 180
    //   191: getstatic 33	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   194: iconst_2
    //   195: new 39	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   202: ldc 156
    //   204: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_0
    //   208: invokevirtual 159	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   211: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: aload_0
    //   218: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: goto -41 -> 180
    //   224: astore_0
    //   225: ldc 2
    //   227: monitorexit
    //   228: aload_0
    //   229: athrow
    //   230: astore_0
    //   231: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq -54 -> 180
    //   237: getstatic 33	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   240: iconst_2
    //   241: new 39	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   248: ldc 164
    //   250: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_0
    //   254: invokevirtual 165	java/io/IOException:getMessage	()Ljava/lang/String;
    //   257: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: aload_0
    //   264: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   267: goto -87 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramString	String
    //   0	270	1	paramLong1	long
    //   0	270	3	paramLong2	long
    //   0	270	5	paramLong3	long
    //   13	156	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	29	184	java/io/FileNotFoundException
    //   29	74	184	java/io/FileNotFoundException
    //   74	167	184	java/io/FileNotFoundException
    //   167	180	184	java/io/FileNotFoundException
    //   3	29	224	finally
    //   29	74	224	finally
    //   74	167	224	finally
    //   167	180	224	finally
    //   185	221	224	finally
    //   231	267	224	finally
    //   3	29	230	java/io/IOException
    //   29	74	230	java/io/IOException
    //   74	167	230	java/io/IOException
    //   167	180	230	java/io/IOException
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = Integer.toString(NetworkUtil.a(paramContext));
    if (paramString2 != null) {}
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "VipDownload", "ip", 0, paramInt, paramString1, paramContext, paramString2, "");
      return;
      paramString2 = "unknow";
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      int i = NetworkUtil.a(paramContext);
      if ((i != 3) && (i != 4))
      {
        bool1 = bool2;
        if (i != 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramFile1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        bool2 = paramFile1.exists();
        if (!bool2)
        {
          bool2 = bool1;
          return bool2;
        }
        long l = System.currentTimeMillis();
        try
        {
          if (!paramFile2.exists()) {
            break label249;
          }
          File[] arrayOfFile1 = paramFile2.listFiles();
          i = 0;
          if (i >= arrayOfFile1.length) {
            break label254;
          }
          File localFile = arrayOfFile1[i];
          if (localFile.isDirectory())
          {
            File[] arrayOfFile2 = localFile.listFiles();
            if (arrayOfFile2 != null)
            {
              int k = arrayOfFile2.length;
              int j = 0;
              if (j < k)
              {
                arrayOfFile2[j].delete();
                j += 1;
                continue;
              }
              localFile.delete();
            }
          }
          else
          {
            arrayOfFile1[i].delete();
          }
        }
        catch (Exception paramFile1)
        {
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "unzipResource|unzip resource fail targetDir=" + paramFile2.getAbsolutePath());
            bool1 = bool3;
          }
        }
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "unzipResource|use time " + (System.currentTimeMillis() - l) + " targetDir=" + paramFile2.getAbsolutePath());
        bool2 = bool1;
        continue;
        paramFile2.mkdirs();
      }
      finally {}
      label249:
      label254:
      ZipUtils.a(paramFile1, paramFile2.getAbsolutePath() + File.separatorChar);
      paramFile1.delete();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "unzipResource|unzip resource succ targetDir=" + paramFile2.getAbsolutePath());
      }
      bool1 = true;
      continue;
      i += 1;
    }
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (URLUtil.isNetworkUrl(paramString));
  }
  
  public static long[] a(String paramString)
  {
    for (;;)
    {
      long[] arrayOfLong;
      Object localObject;
      try
      {
        arrayOfLong = new long[3];
        paramString = new File(b + paramString + ".cfg");
        boolean bool = paramString.exists();
        if (bool) {}
        try
        {
          FileInputStream localFileInputStream = new FileInputStream(paramString);
          localObject = new byte[4096];
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          int i = localFileInputStream.read((byte[])localObject);
          if (i != -1)
          {
            localByteArrayOutputStream.write((byte[])localObject, 0, i);
            continue;
          }
          paramString = finally;
        }
        catch (FileNotFoundException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getConf FileNotFoundException:" + paramString.getMessage(), paramString);
          }
          return arrayOfLong;
          localObject = localByteArrayOutputStream.toString().split(":");
          localByteArrayOutputStream.close();
          localFileInputStream.close();
          if ((localObject == null) || (localObject.length < 6))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "getConf read error,string.length < 6");
            }
            arrayOfLong[0] = 0L;
            arrayOfLong[1] = 0L;
            arrayOfLong[2] = 0L;
            continue;
          }
        }
        catch (IOException localIOException)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getConf IOException:" + localIOException.getMessage(), localIOException);
          }
          paramString.delete();
          continue;
        }
        l1 = Long.parseLong(localObject[1]);
      }
      finally {}
      long l1;
      long l2 = Long.parseLong(localObject[3]);
      long l3 = Long.parseLong(localObject[5]);
      if (l1 != l2)
      {
        arrayOfLong[0] = l1;
        arrayOfLong[1] = l2;
        arrayOfLong[2] = l3;
      }
    }
  }
  
  public DownloaderInterface a(DownloaderFactory.DownloadConfig paramDownloadConfig)
  {
    DownloaderFactory.DownloadConfig localDownloadConfig = paramDownloadConfig;
    if (paramDownloadConfig == null) {
      localDownloadConfig = new DownloaderFactory.DownloadConfig();
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        paramDownloadConfig = (WeakReference)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(localDownloadConfig.a));
        if ((paramDownloadConfig != null) && (paramDownloadConfig.get() != null))
        {
          paramDownloadConfig = (DownloaderInterface)paramDownloadConfig.get();
          return paramDownloadConfig;
        }
        switch (localDownloadConfig.b)
        {
        case 1: 
          paramDownloadConfig = new hjb(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localDownloadConfig);
          jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(localDownloadConfig.a), new WeakReference(paramDownloadConfig));
          return paramDownloadConfig;
        }
      }
      paramDownloadConfig = new hjd(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localDownloadConfig);
      continue;
      paramDownloadConfig = new hjb(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localDownloadConfig);
    }
  }
  
  public void a(DownloaderFactory.DownloadConfig paramDownloadConfig)
  {
    if ((paramDownloadConfig == null) || (paramDownloadConfig.a == 0)) {}
    while (jdField_a_of_type_JavaUtilMap == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      if (jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramDownloadConfig.a))) {
        jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramDownloadConfig.a));
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy...");
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Integer localInteger = (Integer)localIterator.next();
        Object localObject1 = (WeakReference)jdField_a_of_type_JavaUtilMap.get(localInteger);
        if (localObject1 != null)
        {
          localObject1 = (DownloaderInterface)((WeakReference)localObject1).get();
          if (localObject1 == null) {
            continue;
          }
          ((DownloaderInterface)localObject1).a();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "downloader " + localInteger + " onDestroy()...");
        }
      }
      Object localObject3 = null;
    }
    jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */