package com.tencent.mobileqq.filemanager.util;

import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import dvk;
import java.util.ArrayList;
import java.util.List;

public class UniformDownloader
{
  public static final int A = 16;
  public static final int B = 17;
  public static final int C = 18;
  public static final int D = 19;
  public static final int E = 20;
  public static final int F = 21;
  public static final int G = 22;
  public static final int H = 23;
  public static final int I = 24;
  public static final int J = 25;
  public static final int K = 26;
  public static final int L = 27;
  public static final int M = 28;
  public static final int N = 29;
  public static final int O = 30;
  public static final int P = 31;
  public static final int Q = 32;
  public static final int R = 34;
  public static final int S = 35;
  public static final int T = 36;
  public static final int U = 37;
  public static final int V = 38;
  public static final int W = 39;
  public static final int X = 40;
  public static final int Y = 41;
  public static final int Z = 0;
  public static final int a = -1;
  public static String a;
  public static final int aa = 1;
  public static final int ab = 2;
  public static final int b = 0;
  public static final String b = "_PARAM_FILENAME";
  public static final int c = 1;
  public static final String c = "_PARAM_FILEPATH";
  public static final int d = 2;
  public static final String d = "_PARAM_TMP_FILEPATH";
  public static final int e = 3;
  public static final String e = "_PARAM_FILESIZE";
  public static final int f = 4;
  public static final String f = "_PARAM_POS";
  public static final int g = 5;
  public static final String g = "_FILEINFO_PATH";
  public static final int h = 6;
  public static final String h = "_FILEINFO_SIZE";
  public static final int i = 7;
  public static final String i = "_CB_SID";
  public static final int j = 8;
  public static final String j = "_CB_URL";
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 3;
  public static final int o = 4;
  public static final int p = 5;
  public static final int q = 6;
  public static final int r = 7;
  public static final int s = 8;
  public static final int t = 9;
  public static final int u = 10;
  public static final int v = 11;
  public static final int w = 12;
  public static final int x = 13;
  public static final int y = 14;
  public static final int z = 15;
  public final long a;
  private final Bundle jdField_a_of_type_AndroidOsBundle;
  private UniformDownloader.IUniformDownloader jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int ac = 0;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private boolean jdField_b_of_type_Boolean = false;
  private final String k;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloader<FileAssistant>";
  }
  
  public UniformDownloader(long paramLong, String paramString, Bundle paramBundle)
  {
    this.k = paramString;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    if (a(paramString)) {
      this.ac = 1;
    }
    for (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader = new UniformDownloaderAppBaby(paramLong);; this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader = new UniformDownloaderGen(paramLong))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.a(new dvk(this));
      return;
      this.ac = 2;
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "下载失败" + "[" + String.valueOf(paramInt) + "]";
    case 0: 
      return "";
    case 1: 
      return "下载失败" + "[" + String.valueOf(paramInt) + "]";
    case 2: 
      return "网络异常";
    case 3: 
      return "文件写入异常";
    case 4: 
      return "临时文件关闭异常";
    case 5: 
      return "未知异常";
    case 6: 
      return "下载器异常";
    case 7: 
      return "重命名文件异常";
    case 8: 
      return "文件打开异常";
    case 9: 
      return "存储空间已满";
    case 10: 
      return "SDK下载服务错误";
    case 11: 
      return "下载努力尝试失败";
    case 12: 
      return "下载器DC失败";
    case 13: 
      return "下载器启动错误";
    }
    return "下载结束错误";
  }
  
  private List a()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        localArrayList.add((UniformDownloader.IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.get(i1));
        i1 += 1;
      }
      return localArrayList;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = UniformDownloadUtil.a(paramString);
    } while ((paramString == null) || (!FileUtil.a(paramString).equalsIgnoreCase(".apk")));
    return true;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. start. ");
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.a();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. start. mDownloadler = null.");
    return -1;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public String a()
  {
    return this.k;
  }
  
  public void a()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. removListenser. size=" + this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. >>>init UniformDownload start ...");
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader != null)
    {
      Object localObject = paramBundle.getString("_PARAM_FILENAME");
      long l1 = paramBundle.getLong("_PARAM_FILESIZE");
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. init err. filename=null");
        paramBundle = "unnamefile";
      }
      if (0L == l1) {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. init err. filesize=0");
      }
      do
      {
        return;
        localObject = new Bundle();
        String str1 = UniformDownloadUtil.c(AppConstants.aA + paramBundle);
        String str2 = AppConstants.ay + paramBundle;
        ((Bundle)localObject).putString("_PARAM_FILENAME", paramBundle);
        ((Bundle)localObject).putString("_PARAM_TMP_FILEPATH", str1);
        ((Bundle)localObject).putString("_PARAM_FILEPATH", str2);
        ((Bundle)localObject).putLong("_PARAM_FILESIZE", l1);
        ((Bundle)localObject).putLong("_PARAM_POS", 0L);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. >>>init UniformDownload info :: filename:[" + paramBundle + "] fileSize:[" + l1 + "] tmpPath(maybe change):[" + str1 + "] savePath(maybe change):[" + str2 + "] url:[" + this.k + "]");
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.a(this.k, (Bundle)localObject) == 0);
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. mDownloadler init error.");
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. init UniformDownload failed. Der = null");
  }
  
  public void a(UniformDownloader.IUniformDownloaderListener paramIUniformDownloaderListener, boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        int i2 = this.jdField_a_of_type_JavaUtilList.size();
        i1 = 0;
        if (i1 >= i2) {
          break label245;
        }
        if ((UniformDownloader.IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.get(i1) == paramIUniformDownloaderListener)
        {
          if (paramBoolean == true)
          {
            if ((!paramBoolean) || (i1 < 0)) {
              break label109;
            }
            paramIUniformDownloaderListener = (UniformDownloader.IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.remove(i1);
            this.jdField_a_of_type_JavaUtilList.add(paramIUniformDownloaderListener);
            this.jdField_b_of_type_Boolean = true;
            return;
          }
          return;
        }
      }
      i1 += 1;
      continue;
      label109:
      if (paramIUniformDownloaderListener != null)
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label231;
        }
        i1 = this.jdField_a_of_type_JavaUtilList.size();
        UniformDownloader.IUniformDownloaderListener localIUniformDownloaderListener = (UniformDownloader.IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.remove(i1 - 1);
        this.jdField_a_of_type_JavaUtilList.add(paramIUniformDownloaderListener);
        this.jdField_a_of_type_JavaUtilList.add(localIUniformDownloaderListener);
      }
      for (;;)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. addListenser. size=" + this.jdField_a_of_type_JavaUtilList.size());
        if (paramBoolean) {
          this.jdField_b_of_type_Boolean = true;
        }
        return;
        label231:
        this.jdField_a_of_type_JavaUtilList.add(paramIUniformDownloaderListener);
      }
      label245:
      int i1 = -1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. setNotifyUserStarted." + this.jdField_a_of_type_Boolean + "->" + paramBoolean);
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public boolean a()
  {
    int i1 = f();
    if ((1 == i1) || (6 == i1)) {}
    while ((2 == this.ac) && (8 == i1)) {
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. pause. ");
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.c();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. pause. mDownloadler = null.");
    return -1;
  }
  
  public boolean b()
  {
    return 2 == f();
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. resume. ");
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.d();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. resume. mDownloadler = null.");
    return -1;
  }
  
  public boolean c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. stop. ");
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.b();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. stop. mDownloadler = null.");
    return -1;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. pauseSlience. ");
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.f();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. pauseSlience. mDownloadler = null.");
    return -1;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.e();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. getStatus. mDownloadler = null.");
    return 0;
  }
  
  public int g()
  {
    return this.ac;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloader
 * JD-Core Version:    0.7.0.1
 */