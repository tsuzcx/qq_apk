package com.tencent.mobileqq.filemanager.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dpz;
import dqa;
import dqb;
import dqc;
import dqd;
import dqe;
import dqf;
import dqg;
import dqh;
import dqi;
import dqj;
import dqk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import mqq.app.MobileQQ;

public class UniformDownloadMgr
{
  public static final int a = 0;
  private static UniformDownloadMgr jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr = null;
  public static final String a = "UniformDownloadMgr<FileAssistant>";
  public static final int b = -1;
  public static final String b = "_filename_from_dlg";
  public static final int c = 2;
  public static final String c = "_filesize_from_dlg";
  public static final int d = 1;
  public static final String d = "_url_from_dlg";
  public static final String e = "downloading_rb_resume_info";
  public static final String f = "download_suc_info";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public QQAppInterface a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = true;
  
  private UniformDownloadMgr()
  {
    try
    {
      UniformDownloadPkgInstallReceiver.a(BaseApplication.getContext());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private int a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] delDownloadInst.. total[" + this.jdField_a_of_type_JavaUtilMap.size() + "] del it. url[" + paramString + "]");
      return i;
    }
  }
  
  private int a(String paramString, Bundle paramBundle)
  {
    int i = 0;
    if ((paramString == null) || (paramBundle == null))
    {
      i = -1;
      return i;
    }
    String str = paramBundle.getString("_filename_from_dlg");
    long l = paramBundle.getLong("_filesize_from_dlg");
    paramBundle = a(paramString);
    if ((paramBundle == null) || ((paramBundle != null) && (paramBundle.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader == null)))
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRStartDownload. run a new download. url:" + paramString);
      return a(paramString, str, l, -1, false);
    }
    int j = paramBundle.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.f();
    QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRStartDownload. instance is exist.status:" + j + " may be do something. url:" + paramString);
    switch (j)
    {
    case 1: 
    case 2: 
    case 6: 
    default: 
      return -4;
    case 0: 
      return -3;
    case 3: 
      d(paramString);
      return 0;
    case 4: 
      a(paramString);
      a(paramString, str, l, -1, false);
      return 0;
    case 5: 
      d(paramString);
      return 0;
    }
    a(paramString);
    return 0;
  }
  
  private int a(String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] createAndStartDownloadTask.. param = null");
      return -1;
    }
    long l = a();
    UniformDownloader localUniformDownloader = new UniformDownloader(l, paramString1, null);
    Bundle localBundle;
    if (1 == localUniformDownloader.g())
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + " - NEW_ID]. >>> create UniformDownloader.using appbaby. url: " + paramString1);
      localBundle = new Bundle();
      localBundle.putString("_PARAM_FILENAME", paramString2);
      localBundle.putLong("_PARAM_FILESIZE", paramLong);
      localUniformDownloader.a(localBundle);
      localUniformDownloader.a(new dpz(this), true);
      localBundle = new Bundle();
      localBundle.putString("_notify_param_Filename", paramString2);
      localBundle.putString("_notify_param_ContentTitle", paramString2);
      localBundle.putString("_notify_param_Url", paramString1);
      localBundle.putLong("_notify_param_Filesize", paramLong);
      paramInt = UniformDownloadNfn.a().a(localUniformDownloader, localBundle, l, paramInt);
      a(paramString1, new dqj(this, null, localUniformDownloader.g(), localUniformDownloader, l, paramInt));
      if (!paramBoolean) {
        break label372;
      }
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + "] preHadStarted. url:" + paramString1);
      localUniformDownloader.a(true);
    }
    for (;;)
    {
      if (b(paramString1) == 0)
      {
        localUniformDownloader.a(true);
        UniformDownloadNfn.a().b(paramInt, localBundle);
      }
      this.b = false;
      return 0;
      if (2 == localUniformDownloader.g())
      {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + " - NEW_ID]. >>>create UniformDownloader.using common. url:" + paramString1);
        break;
      }
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + " - NEW_ID] create UniformDownloader failed. url:" + paramString1);
      return -2;
      label372:
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        if (1 == localUniformDownloader.g()) {
          StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Start_download_2-0_3-0");
        } else if (2 == localUniformDownloader.g()) {
          StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Start_download_2-0_3-1");
        }
      }
    }
  }
  
  private long a()
  {
    return (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
  }
  
  private UniformDownloadMgr.SucDownloadInfo a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] sucInfoOfString err, str=null");
      return null;
    }
    String[] arrayOfString = paramString.split("\\^");
    if (arrayOfString.length < 2)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] sucInfoOfString err,l=" + arrayOfString.length + " str=" + paramString);
      return null;
    }
    return new UniformDownloadMgr.SucDownloadInfo(arrayOfString[0], Integer.parseInt(arrayOfString[1]));
  }
  
  public static UniformDownloadMgr a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr == null)
      {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr.getInstance.create");
        jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr = new UniformDownloadMgr();
      }
      UniformDownloadMgr localUniformDownloadMgr = jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr;
      return localUniformDownloadMgr;
    }
    finally {}
  }
  
  private dqj a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (dqj)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  private dqk a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] rBobjectOfString err, str=null");
      return null;
    }
    String[] arrayOfString = paramString.split("\\^");
    if (arrayOfString.length < 4)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] rBobjectOfString err,l=" + arrayOfString.length + " str=" + paramString);
      return null;
    }
    paramString = new dqk(this);
    paramString.jdField_a_of_type_Int = Integer.parseInt(arrayOfString[0]);
    paramString.jdField_a_of_type_JavaLangString = arrayOfString[1];
    paramString.jdField_a_of_type_Long = Long.parseLong(arrayOfString[2]);
    paramString.jdField_a_of_type_Boolean = Boolean.parseBoolean(arrayOfString[3]);
    return paramString;
  }
  
  private String a(UniformDownloadMgr.SucDownloadInfo paramSucDownloadInfo)
  {
    if (paramSucDownloadInfo == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] stringOfSucInfo err, obj=null");
      return null;
    }
    return String.valueOf(paramSucDownloadInfo.jdField_a_of_type_JavaLangString) + "^" + String.valueOf(paramSucDownloadInfo.jdField_a_of_type_Int);
  }
  
  private String a(dqk paramdqk)
  {
    if (paramdqk == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] stringOfRbObject err, obj=null");
      return null;
    }
    return String.valueOf(paramdqk.jdField_a_of_type_Int) + "^" + paramdqk.jdField_a_of_type_JavaLangString + "^" + String.valueOf(paramdqk.jdField_a_of_type_Long) + "^" + String.valueOf(paramdqk.jdField_a_of_type_Boolean);
  }
  
  private boolean a(String paramString, dqj paramdqj)
  {
    if ((paramString == null) || (paramdqj == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] addDownloadInst.. param null");
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        return false;
      }
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramdqj);
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] addDownloadInst.. total[" + this.jdField_a_of_type_JavaUtilMap.size() + "] add it. url[" + paramString + "]");
    return true;
  }
  
  private int b(String paramString)
  {
    int i = 0;
    if ((NetworkUtil.e(BaseApplication.getContext())) && (!FileManagerUtil.a())) {}
    for (int m = 2;; m = 1)
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload. togetherDownloadMaxCount=" + m);
      Object localObject2 = new ArrayList();
      int j;
      int k;
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
        j = 0;
        if (localIterator.hasNext())
        {
          dqj localdqj = (dqj)localIterator.next();
          int n = i;
          k = j;
          if (localdqj.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader != null)
          {
            n = i;
            k = j;
            if (localdqj.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.b())
            {
              j += 1;
              n = i;
              k = j;
              if (paramString != null)
              {
                n = i;
                k = j;
                if (paramString.equalsIgnoreCase(localdqj.jdField_a_of_type_JavaLangString))
                {
                  QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload.. download is runing. traceUrl:" + paramString);
                  n = 1;
                  k = j;
                }
              }
            }
          }
          ((List)localObject2).add(localdqj);
          i = n;
          j = k;
        }
      }
      if (j < m)
      {
        ??? = ((List)localObject2).iterator();
        k = i;
        if (((Iterator)???).hasNext())
        {
          localObject2 = (dqj)((Iterator)???).next();
          k = j;
          if (((dqj)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader == null) {
            break label496;
          }
          k = j;
          if (!((dqj)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.a()) {
            break label496;
          }
          if (j < m)
          {
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>> Happy. start a download task, url:[" + ((dqj)localObject2).jdField_a_of_type_JavaLangString + "]");
            j += 1;
            ((dqj)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.a();
            k = j;
            if (paramString == null) {
              break label496;
            }
            k = j;
            if (!paramString.equalsIgnoreCase(((dqj)localObject2).jdField_a_of_type_JavaLangString)) {
              break label496;
            }
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload.. download is started. traceUrl:" + paramString);
            i = 2;
          }
        }
      }
      for (;;)
      {
        break;
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload.. total[" + this.jdField_a_of_type_JavaUtilMap.size() + "] the task of downloading is overload,other need waiting... 1");
        for (k = i;; k = i)
        {
          g();
          return k;
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTrystartNextDownload.. total[" + this.jdField_a_of_type_JavaUtilMap.size() + "] the task of downloading is overload,other need waiting... 2");
        }
        label496:
        j = k;
      }
    }
  }
  
  private int b(String paramString, Bundle paramBundle)
  {
    if ((paramString == null) || (paramBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inRPauseDownload. param error!!");
      return -1;
    }
    int i = paramBundle.getInt("_notify_param_Id");
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRPauseDownload. URL:" + paramString + " nofiyid:" + i);
    if (-1 == c(paramString)) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (!UniformDownloader.a(paramString)) {
          break label131;
        }
        StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Stop_download_2-2_3-0");
      }
    }
    for (;;)
    {
      UniformDownloadNfn.a().a(i, (Bundle)paramBundle.clone());
      b(null);
      return 0;
      label131:
      StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Stop_download_2-2_3-1");
    }
  }
  
  private int c(String paramString)
  {
    dqj localdqj = a(paramString);
    if (localdqj != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (localdqj.jdField_a_of_type_Int != 1) {
          break label71;
        }
        StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Stop_download_2-2_3-0");
      }
      for (;;)
      {
        if (localdqj.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader != null) {
          localdqj.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.b();
        }
        b(null);
        return 0;
        label71:
        StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Stop_download_2-2_3-1");
      }
    }
    QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPPauseDownload.. inst not exsited. url:" + paramString);
    return -1;
  }
  
  private int c(String paramString, Bundle paramBundle)
  {
    if ((paramString == null) || (paramBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inRResumeDownload. param error!!");
      return -1;
    }
    int i = paramBundle.getInt("_notify_param_Id");
    String str = paramBundle.getString("_notify_param_Filename");
    long l = paramBundle.getLong("_notify_param_Filesize");
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRResumeDownload. URL:" + paramString + " nofiyid:" + i);
    if (-1 == d(paramString)) {
      a(paramString, str, l, i, true);
    }
    return 0;
  }
  
  private int d(String paramString)
  {
    dqj localdqj = a(paramString);
    if (localdqj != null)
    {
      if (localdqj.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader != null) {
        localdqj.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.c();
      }
      b(null);
      return 0;
    }
    QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPResumeDownload.. inst not exsited. url:" + paramString);
    return -1;
  }
  
  private int d(String paramString, Bundle paramBundle)
  {
    return c(paramString, paramBundle);
  }
  
  private int e(String paramString)
  {
    dqj localdqj = a(paramString);
    if (localdqj != null)
    {
      if (localdqj.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader != null) {
        localdqj.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.d();
      }
      return 0;
    }
    QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPStopDownload.. inst not exsited. url:" + paramString);
    return -1;
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DL_MThread");
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>start thread:DL_MThread...");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void f()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quit();
        this.jdField_a_of_type_AndroidOsHandlerThread = null;
        this.jdField_a_of_type_AndroidOsHandler = null;
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>stop thread:DL_MThread...");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void g()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      if (i == 0) {
        f();
      }
    }
  }
  
  private void h()
  {
    e();
    this.jdField_a_of_type_AndroidOsHandler.post(new dqb(this));
  }
  
  private void i()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] pauseSlienceRuningGenDownloadOfOldApp ...");
    e();
    this.jdField_a_of_type_AndroidOsHandler.post(new dqi(this));
  }
  
  private void j()
  {
    e();
    this.jdField_a_of_type_AndroidOsHandler.post(new dqa(this));
  }
  
  private void k()
  {
    for (;;)
    {
      try
      {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo...");
        ??? = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).getAll();
        if (??? != null) {
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo, size:[" + ((Map)???).size() + "]");
        }
        if ((??? != null) && (((Map)???).size() > 0))
        {
          Iterator localIterator = ((Map)???).entrySet().iterator();
          if (localIterator.hasNext())
          {
            UniformDownloadMgr.SucDownloadInfo localSucDownloadInfo = a((String)((Map.Entry)localIterator.next()).getKey());
            if (localSucDownloadInfo == null) {
              break label211;
            }
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo, pkgName:[" + localSucDownloadInfo.jdField_a_of_type_JavaLangString + "]" + "] nId:[" + localSucDownloadInfo.jdField_a_of_type_Int + "] ");
            synchronized (this.jdField_a_of_type_JavaUtilList)
            {
              this.jdField_a_of_type_JavaUtilList.add(localSucDownloadInfo);
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label211:
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo, value error. ");
    }
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] APP=null.");
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public List a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      k();
      this.jdField_a_of_type_Boolean = true;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    UniformDownloadMgr.SucDownloadInfo localSucDownloadInfo;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localSucDownloadInfo = (UniformDownloadMgr.SucDownloadInfo)localIterator.next();
        if ((localSucDownloadInfo != null) && (paramString.equalsIgnoreCase("package:" + localSucDownloadInfo.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localSucDownloadInfo);
        }
      }
    }
    if ((localArrayList.size() > 0) && (paramBoolean))
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getSucDownloadInfoOfPkg. remove before size:" + this.jdField_a_of_type_JavaUtilList.size());
      try
      {
        paramString = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).edit();
        localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          localSucDownloadInfo = (UniformDownloadMgr.SucDownloadInfo)localIterator.next();
          this.jdField_a_of_type_JavaUtilList.remove(localSucDownloadInfo);
          paramString.remove(a(localSucDownloadInfo));
          continue;
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getSucDownloadInfoOfPkg. remove after size:" + this.jdField_a_of_type_JavaUtilList.size());
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    for (;;)
    {
      return localArrayList;
      paramString.commit();
    }
  }
  
  public Map a()
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      String str;
      try
      {
        Object localObject1 = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).getAll();
        if (localObject1 != null) {
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getDownloadingRbResmeInfo, size:[" + ((Map)localObject1).size() + "]");
        }
        if ((localObject1 != null) && (((Map)localObject1).size() > 0))
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
            str = (String)((Map.Entry)localObject2).getKey();
            localObject2 = a((String)((Map.Entry)localObject2).getValue());
            if (localObject2 == null) {
              break label224;
            }
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getDownloadingRbResmeInfo, url:[" + str + "]" + "] nId:[" + ((dqk)localObject2).jdField_a_of_type_Int + "] w:[" + ((dqk)localObject2).jdField_a_of_type_Boolean + "]");
            localHashMap.put(str, localObject2);
            continue;
          }
        }
        return localHashMap;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label224:
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getDownloadingRbResmeInfo, value error. url:[" + str + "]");
    }
  }
  
  public void a()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onAppDestroy...");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    i();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onAppInit...");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    j();
  }
  
  public void a(UniformDownloadMgr.SucDownloadInfo paramSucDownloadInfo)
  {
    if (paramSucDownloadInfo == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      k();
      this.jdField_a_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramSucDownloadInfo);
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] saveSucDownloadInfo. pkgName:" + paramSucDownloadInfo.jdField_a_of_type_JavaLangString + " notificationId:" + paramSucDownloadInfo.jdField_a_of_type_Int + " size:" + this.jdField_a_of_type_JavaUtilList.size());
      try
      {
        ??? = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).edit();
        ((SharedPreferences.Editor)???).putString(a(paramSucDownloadInfo), "-");
        ((SharedPreferences.Editor)???).commit();
        return;
      }
      catch (Exception paramSucDownloadInfo)
      {
        paramSucDownloadInfo.printStackTrace();
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (UniformDownloadUtil.b(paramString) != null)
    {
      UniformDownloadUtil.a(paramString);
      return;
    }
    UniformDownloadUtil.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] removeSucDownloadInfo. pkgName:" + paramString + " notificationId:" + paramInt);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          localObject = (UniformDownloadMgr.SucDownloadInfo)localIterator.next();
          if ((localObject == null) || (!paramString.equalsIgnoreCase(((UniformDownloadMgr.SucDownloadInfo)localObject).jdField_a_of_type_JavaLangString)) || (paramInt != ((UniformDownloadMgr.SucDownloadInfo)localObject).jdField_a_of_type_Int)) {
            continue;
          }
          if (localObject != null)
          {
            this.jdField_a_of_type_JavaUtilList.remove(localObject);
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] removeSucDownloadInfo done. pkgName:" + paramString + " notificationId:" + paramInt + " size:" + this.jdField_a_of_type_JavaUtilList.size());
          }
          try
          {
            localObject = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).edit();
            ((SharedPreferences.Editor)localObject).remove(a(new UniformDownloadMgr.SucDownloadInfo(paramString, paramInt)));
            ((SharedPreferences.Editor)localObject).commit();
            return;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
        }
      }
      Object localObject = null;
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    e();
    this.jdField_a_of_type_AndroidOsHandler.post(new dqc(this, paramString, paramBundle));
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean)
  {
    try
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] saveDownloadingRbResmeInfo, url:[" + paramString1 + "]" + " nId:[" + paramInt + "] w:[" + paramBoolean + "]");
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).edit();
      dqk localdqk = new dqk(this);
      localdqk.jdField_a_of_type_Int = paramInt;
      localdqk.jdField_a_of_type_JavaLangString = paramString2;
      localdqk.jdField_a_of_type_Long = paramLong;
      localdqk.jdField_a_of_type_Boolean = paramBoolean;
      localEditor.putString(paramString1, a(localdqk));
      localEditor.commit();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public boolean a(String paramString)
  {
    return a(paramString) != null;
  }
  
  public void b()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit...");
    UniformDownloaderAppBabySdk.a().a();
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      if (localIterator.hasNext())
      {
        dqj localdqj = (dqj)localIterator.next();
        if ((localdqj.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader != null) && (localdqj.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.b())) {
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onQQProcessExit. stop download:url:" + localdqj.jdField_a_of_type_JavaLangString);
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("_notify_param_Url", localdqj.jdField_a_of_type_JavaLangString);
        UniformDownloadNfn.a().c(localdqj.b, localBundle);
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onQQProcessExit. cancel notification:" + localdqj.b);
      }
    }
    d();
    c();
  }
  
  public void b(String paramString)
  {
    try
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] removeDownloadingRbResmeInfo, url:[" + paramString + "]");
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).edit();
      localEditor.remove(paramString);
      localEditor.commit();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(String paramString, Bundle paramBundle)
  {
    e();
    this.jdField_a_of_type_AndroidOsHandler.post(new dqd(this, paramString, paramBundle));
  }
  
  public void c()
  {
    try
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] clearDownloadingRbResmeInfo...");
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c(String paramString, Bundle paramBundle)
  {
    e();
    this.jdField_a_of_type_AndroidOsHandler.post(new dqe(this, paramString, paramBundle));
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      this.jdField_a_of_type_JavaUtilList.clear();
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] clearSucDownloadInfo...size:" + i);
    }
  }
  
  public void d(String paramString, Bundle paramBundle)
  {
    e();
    this.jdField_a_of_type_AndroidOsHandler.post(new dqf(this, paramString, paramBundle));
  }
  
  public void e(String paramString, Bundle paramBundle)
  {
    e();
    this.jdField_a_of_type_AndroidOsHandler.post(new dqg(this, paramString, paramBundle));
  }
  
  public void f(String paramString, Bundle paramBundle)
  {
    e();
    this.jdField_a_of_type_AndroidOsHandler.post(new dqh(this, paramString, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr
 * JD-Core Version:    0.7.0.1
 */