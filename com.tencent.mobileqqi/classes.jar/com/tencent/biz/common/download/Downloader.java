package com.tencent.biz.common.download;

import android.content.Context;
import android.net.NetworkInfo;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Downloader
{
  public static final int a = 0;
  protected static final String a = ".tmp";
  public static final int b = 2;
  public static final int c = 1;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 11;
  public static final int g = 12;
  public static final int h = 13;
  protected static final int i = 1;
  protected static final int j = 2;
  protected static final int k = 3;
  protected NetworkInfo a;
  protected DownloadDao a;
  protected AsyncBack a;
  protected List a;
  protected String b;
  protected String c;
  protected final String d = "OfflineDownload";
  protected int l = 2;
  protected int m;
  protected int n = 1;
  protected int o;
  protected int p;
  
  public Downloader(Context paramContext, String paramString1, int paramInt, String paramString2, NetworkInfo paramNetworkInfo, AsyncBack paramAsyncBack)
  {
    this.b = paramString1;
    this.c = (paramString2 + ".tmp");
    this.jdField_a_of_type_AndroidNetNetworkInfo = paramNetworkInfo;
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = paramAsyncBack;
    this.m = paramInt;
    this.p = 0;
    this.jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao = new DownloadDao(paramContext);
    this.n = 1;
    paramContext = new File(paramString2);
    if ((!this.jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao.a(paramString1)) && (paramContext.exists())) {
      this.n = 3;
    }
    this.o = 0;
  }
  
  public static String a(String paramString)
  {
    return paramString.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
  }
  
  private void a(List paramList)
  {
    Iterator localIterator = paramList.iterator();
    DownloadInfo localDownloadInfo;
    for (paramList = ""; localIterator.hasNext(); paramList = paramList + "******:threadId:" + localDownloadInfo.a() + ", start:" + localDownloadInfo.b() + ", end:" + localDownloadInfo.c() + ", completeSize:" + localDownloadInfo.d()) {
      localDownloadInfo = (DownloadInfo)localIterator.next();
    }
    a("=*********init thread info:" + paramList);
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  private LoadInfo b()
  {
    if (!b()) {
      return null;
    }
    if (this.m < 204800) {
      this.l = 1;
    }
    int i2 = this.m / this.l;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    int i1 = 0;
    while (i1 < this.l - 1)
    {
      localDownloadInfo = new DownloadInfo(i1, i1 * i2, (i1 + 1) * i2 - 1, 0, this.b);
      this.jdField_a_of_type_JavaUtilList.add(localDownloadInfo);
      i1 += 1;
    }
    DownloadInfo localDownloadInfo = new DownloadInfo(this.l - 1, (this.l - 1) * i2, this.m - 1, 0, this.b);
    this.jdField_a_of_type_JavaUtilList.add(localDownloadInfo);
    this.jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao.a(this.jdField_a_of_type_JavaUtilList);
    a(this.jdField_a_of_type_JavaUtilList);
    return new LoadInfo(this.m, 0, this.b);
  }
  
  private boolean b()
  {
    try
    {
      if (this.m < 1)
      {
        localObject = (HttpURLConnection)new URL(this.b).openConnection();
        ((HttpURLConnection)localObject).setConnectTimeout(6000);
        ((HttpURLConnection)localObject).setRequestMethod("HEAD");
        ((HttpURLConnection)localObject).setRequestProperty("Accept-Encoding", "identity");
        int i1 = ((HttpURLConnection)localObject).getResponseCode();
        if (i1 != 200)
        {
          a("error :get lenth:" + i1);
          return false;
        }
        this.m = ((HttpURLConnection)localObject).getContentLength();
        ((HttpURLConnection)localObject).disconnect();
        a("filesize:" + this.m);
        if (this.m < 1) {
          return false;
        }
      }
      Object localObject = new File(this.c);
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      localObject = new RandomAccessFile((File)localObject, "rwd");
      ((RandomAccessFile)localObject).setLength(this.m);
      ((RandomAccessFile)localObject).close();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public int a()
  {
    return this.n;
  }
  
  public LoadInfo a()
  {
    int i4 = 0;
    File localFile = new File(this.c);
    if (!this.jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao.a(this.b))
    {
      if (localFile.exists()) {}
      try
      {
        localFile.delete();
        return b();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    if (!localException.exists())
    {
      this.jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao.a(this.b);
      return b();
    }
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao.a(this.b);
    a("This is not First launch the size=" + this.jdField_a_of_type_JavaUtilList.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i2 = 0;
    DownloadInfo localDownloadInfo;
    for (int i1 = 0;; i1 = localDownloadInfo.c() - localDownloadInfo.b() + 1 + i1)
    {
      int i3 = i4;
      if (localIterator.hasNext())
      {
        localDownloadInfo = (DownloadInfo)localIterator.next();
        if ((localDownloadInfo.b() > localDownloadInfo.c()) || (localDownloadInfo.c() - localDownloadInfo.b() < localDownloadInfo.d())) {
          i3 = 1;
        }
      }
      else
      {
        if (i3 == 0) {
          break;
        }
        a("dirty download info, resart down");
        this.jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao.a(this.b);
        return b();
      }
      i2 += localDownloadInfo.d();
    }
    a(this.jdField_a_of_type_JavaUtilList);
    return new LoadInfo(i1, i2, this.b);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.n == 2)) {}
    for (;;)
    {
      return;
      this.n = 2;
      this.o = 0;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        new Downloader.DownloadThread(this, localDownloadInfo.a(), localDownloadInfo.b(), localDownloadInfo.c(), localDownloadInfo.d(), localDownloadInfo.a()).start();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 6)) {
      this.l = paramInt;
    }
  }
  
  public void a(AsyncBack paramAsyncBack)
  {
    if (paramAsyncBack == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = null;
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = paramAsyncBack;
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OfflineDownload", 2, paramString);
    }
  }
  
  public boolean a()
  {
    return this.n == 2;
  }
  
  public void b()
  {
    this.n = 3;
  }
  
  protected void b(int paramInt)
  {
    if (paramInt < 0) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack == null)
        {
          a("mAsyncCallback is null");
          continue;
        }
      }
      finally {}
      this.p += paramInt;
      this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(this.p * 100 / this.m);
    }
  }
  
  protected void c(int paramInt)
  {
    this.o += 1;
    if (paramInt != 0) {
      this.n = 3;
    }
    if (paramInt != 0) {
      d(2);
    }
    while (this.l != this.o) {
      return;
    }
    try
    {
      new File(this.c).renameTo(new File(this.c.substring(0, this.c.lastIndexOf("."))));
      this.jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao.a(this.b);
      d(0);
      a("offline download finished");
      this.n = 1;
      OfflineDownloader.b(this.b);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      d(2);
      a("rename error");
    }
  }
  
  protected void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack == null)
    {
      a("mAsyncCallback is null");
      return;
    }
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(this.b, paramInt);
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.common.download.Downloader
 * JD-Core Version:    0.7.0.1
 */