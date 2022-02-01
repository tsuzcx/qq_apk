package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.AppViewBaseActivity;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.img.ImageCache;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import com.tencent.open.downloadnew.common.NoticeDownloadListener;
import com.tencent.open.downloadnew.common.PackageInstallReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKSettingClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import hmr;
import hms;
import hmt;
import hmu;
import hmv;
import hmw;
import hmx;
import hmz;
import hnc;
import hnd;
import hne;
import hnf;
import hng;
import hnj;
import hnk;
import hnl;
import hnm;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DownloadManager
{
  protected static final int a = 3;
  public static final long a = 1000L;
  protected static DownloadManager a;
  public static final String a;
  protected static final byte[] a;
  protected static final int b = 200;
  public static final String b;
  public static final String c = "open_sdk";
  public static final String e = "com.opensdk.downloadmanager.renameFilename";
  protected PackageInstallReceiver a;
  public ITMAssistantDownloadSDKClientListener a;
  protected WeakReference a;
  public ConcurrentHashMap a;
  protected ConcurrentLinkedQueue a;
  public boolean a;
  protected long b;
  protected boolean b;
  protected final int c;
  protected long c;
  protected String d = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = DownloadManager.class.getName();
    jdField_b_of_type_JavaLangString = File.separator + "tencent" + File.separator + ".qqdownload" + File.separator;
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected DownloadManager()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentTmassistantsdkDownloadclientITMAssistantDownloadSDKClientListener = new hng(this);
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 1000;
    LogUtility.c(jdField_a_of_type_JavaLangString, "DownloadManager create QQ5.0");
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver = new PackageInstallReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addDataScheme("package");
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    CommonDataAdapter.a().a().registerReceiver(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver, localIntentFilter);
    NoticeDownloadListener.a().a(ThreadManager.b().getLooper());
    a(WebViewDownloadListener.a());
    a(NoticeDownloadListener.a());
    ThreadManager.b().post(new hnd(this));
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 1: 
      return 20;
    case 2: 
      return 2;
    case 4: 
      return 4;
    case 3: 
      return 3;
    case 6: 
      return 10;
    }
    return -2;
  }
  
  public static DownloadManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager == null)
      {
        jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager = new DownloadManager();
        jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.d = ("open_sdk" + Common.q());
        jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.b();
        jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.f();
      }
      DownloadManager localDownloadManager = jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager;
      return localDownloadManager;
    }
    finally {}
  }
  
  public static DownloadManager a(String paramString)
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager == null)
      {
        if (TextUtils.isEmpty(paramString)) {
          LogUtility.e(jdField_a_of_type_JavaLangString, "getInstance error, clientKey == null !!!!");
        }
        jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager = new DownloadManager();
        jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.d = paramString;
        jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.b();
      }
      paramString = jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager;
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 178	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localDownloadManager	DownloadManager
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  public int a(String paramString)
  {
    Object localObject = a(paramString);
    if (localObject != null) {
      if (((DownloadInfo)localObject).jdField_f_of_type_Int != 1) {
        break label75;
      }
    }
    label75:
    for (localObject = ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString;; localObject = ((DownloadInfo)localObject).jdField_c_of_type_JavaLangString)
    {
      ThreadManager.b().post(new hmu(this, (String)localObject));
      LogUtility.a(jdField_a_of_type_JavaLangString, "pause url=" + (String)localObject + ", appid=" + paramString);
      return 0;
    }
  }
  
  public DownloadInfo a(String paramString)
  {
    if (paramString == null)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "getDownloadInfoById appId == null");
      return null;
    }
    return (DownloadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public DownloadInfo a(String paramString, int paramInt)
  {
    paramString = c(paramString);
    if ((paramString != null) && (paramInt != -2)) {
      paramString.a(paramInt);
    }
    return paramString;
  }
  
  public TMAssistantDownloadSDKClient a()
  {
    TMAssistantDownloadSDKManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKClient(this.d).registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmassistantsdkDownloadclientITMAssistantDownloadSDKClientListener);
    if (!this.jdField_b_of_type_Boolean) {}
    try
    {
      TMAssistantDownloadSDKSettingClient localTMAssistantDownloadSDKSettingClient = TMAssistantDownloadSDKManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKSettingClient();
      if (localTMAssistantDownloadSDKSettingClient != null) {
        localTMAssistantDownloadSDKSettingClient.setDownloadSDKMaxTaskNum(3);
      }
    }
    catch (Exception localException)
    {
      label53:
      break label53;
    }
    this.jdField_b_of_type_Boolean = true;
    return TMAssistantDownloadSDKManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKClient(this.d);
  }
  
  public TMAssistantDownloadTaskInfo a(DownloadInfo paramDownloadInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, paramDownloadInfo.jdField_i_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.jdField_c_of_type_JavaLangString, paramDownloadInfo.j);
    localBundle.putString(DownloadConstants.e, paramDownloadInfo.d);
    localBundle.putInt(DownloadConstants.d, paramDownloadInfo.jdField_g_of_type_Int);
    localBundle.putString(DownloadConstants.jdField_h_of_type_JavaLangString, paramDownloadInfo.jdField_g_of_type_JavaLangString);
    try
    {
      LogUtility.a("State_Log", "OpenSDK getTaskInfoFromMyApp param SNGAppId=" + paramDownloadInfo.jdField_b_of_type_JavaLangString + " apkId=" + paramDownloadInfo.j + " taskAppId=" + paramDownloadInfo.jdField_i_of_type_JavaLangString + " packageName=" + paramDownloadInfo.d + " version=" + paramDownloadInfo.jdField_g_of_type_Int + " via=" + paramDownloadInfo.jdField_g_of_type_JavaLangString);
      paramDownloadInfo = MyAppApi.a().a(localBundle);
      if (paramDownloadInfo != null) {}
      try
      {
        LogUtility.a("State_Log", "OpenSDK getTaskInfoFromMyApp result taskInfo path=" + paramDownloadInfo.mSavePath + " state=" + paramDownloadInfo.mState);
        return paramDownloadInfo;
      }
      catch (Exception localException1) {}
      LogUtility.a("State_Log", "OpenSDK getTaskInfoFromMyApp result taskInfo is null");
      return paramDownloadInfo;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        paramDownloadInfo = null;
      }
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "getTaskInfoFromMyApp>>>", localException1);
    return paramDownloadInfo;
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = a().getDownloadTaskState(paramString);
        if (localTMAssistantDownloadTaskInfo == null) {
          LogUtility.a(jdField_a_of_type_JavaLangString, "getTaskInfoFromSDK null url=" + paramString);
        }
        return localTMAssistantDownloadTaskInfo;
      }
      catch (Exception localException)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", localException);
      }
      Object localObject = null;
    }
  }
  
  public String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.jdField_k_of_type_JavaLangString;
    }
    return "";
  }
  
  public WeakReference a()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 == null) {}
      try
      {
        localObject1 = (AppInterface)BaseApplicationImpl.a().a();
        if (localObject1 != null) {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          LogUtility.c(jdField_a_of_type_JavaLangString, "getQQAppInterface>>>", localException);
        }
      }
      localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
      return localObject1;
    }
    finally {}
  }
  
  protected List a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (localDownloadInfo.a() == paramInt) {
          localArrayList.add(localDownloadInfo);
        }
      }
    }
    finally {}
    return localList;
  }
  
  public ConcurrentHashMap a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public ConcurrentLinkedQueue a()
  {
    try
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
      return localConcurrentLinkedQueue;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    ThreadManager.b().post(new hmr(this));
  }
  
  public void a(int paramInt, DownloadInfo paramDownloadInfo)
  {
    a(paramInt, paramDownloadInfo, 0, "");
  }
  
  public void a(int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2, String paramString)
  {
    if (paramDownloadInfo == null) {}
    for (;;)
    {
      try
      {
        LogUtility.e(jdField_a_of_type_JavaLangString, "notifyListener info == null id=" + paramInt1);
        return;
      }
      finally {}
      switch (paramInt1)
      {
      default: 
        break;
      case -2: 
        a(paramDownloadInfo, paramInt2, paramString);
        break;
      case 20: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载等待:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).b(paramDownloadInfo);
        }
      case 3: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载暂停:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).a(paramDownloadInfo);
        }
      case 4: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载完成:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).c(paramDownloadInfo);
        }
      case 10: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载取消:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramDownloadInfo.jdField_b_of_type_JavaLangString);
        DownloadDBHelper.a().a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
        AppNotificationManager.a().a(paramDownloadInfo.jdField_f_of_type_JavaLangString);
        paramDownloadInfo.a(10);
        LogUtility.a(jdField_a_of_type_JavaLangString, "downloadInfo.state = " + paramDownloadInfo.a());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).d(paramDownloadInfo);
        }
      case 2: 
        if ((paramDownloadInfo.jdField_h_of_type_Int == 1) || (System.currentTimeMillis() - this.jdField_b_of_type_Long > 1000L))
        {
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载进度更新:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
          paramDownloadInfo = a(2);
          LogUtility.a(jdField_a_of_type_JavaLangString, "###下载进度更新  size=" + paramDownloadInfo.size());
          paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
          while (paramString.hasNext()) {
            ((DownloadListener)paramString.next()).a(paramDownloadInfo);
          }
        }
        break;
      case 6: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###安装成功:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).a(paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo.d);
        }
      case 13: 
        Log.v(jdField_a_of_type_JavaLangString, "###包被替换:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).c(paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo.d);
        }
      case 9: 
        Log.v(jdField_a_of_type_JavaLangString, "###卸载成功:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).b(paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo.d);
        }
      }
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt1, ApkUpdateDetail paramApkUpdateDetail, int paramInt2)
  {
    new Handler(Looper.getMainLooper()).post(new hmz(this, paramBundle, paramActivity, paramInt1, paramApkUpdateDetail, paramInt2));
  }
  
  public void a(AppInterface paramAppInterface)
  {
    try
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
      return;
    }
    finally
    {
      paramAppInterface = finally;
      throw paramAppInterface;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    for (;;)
    {
      try
      {
        if (paramDownloadInfo.jdField_c_of_type_Boolean) {
          ImageCache.a("app", ImageUtil.a(paramDownloadInfo.jdField_b_of_type_JavaLangString, 100), new hms(this, paramDownloadInfo));
        }
        Object localObject = a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
        if (localObject != null)
        {
          if (a((DownloadInfo)localObject, paramDownloadInfo))
          {
            LogUtility.a(jdField_a_of_type_JavaLangString, "+++++startDownload()+++++ downloadInfo != null>>>downloadInfo.url=" + paramDownloadInfo.jdField_c_of_type_JavaLangString + "+++++downloadInfo.downloadType=" + paramDownloadInfo.jdField_f_of_type_Int + "  test" + a(paramDownloadInfo.jdField_b_of_type_JavaLangString));
            paramDownloadInfo = (DownloadInfo)localObject;
            e(paramDownloadInfo);
            if (paramDownloadInfo.jdField_f_of_type_Int == 1)
            {
              localObject = paramDownloadInfo.jdField_h_of_type_JavaLangString;
              int i = paramDownloadInfo.jdField_f_of_type_Int;
              ThreadManager.b().post(new hmt(this, (String)localObject, i, paramDownloadInfo));
            }
          }
          else
          {
            localObject = paramDownloadInfo;
            continue;
          }
        }
        else
        {
          localObject = "900";
          if (paramDownloadInfo.l == 12) {
            localObject = "2000";
          }
          StaticAnalyz.a((String)localObject, paramDownloadInfo.jdField_g_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_JavaLangString);
          LogUtility.a(jdField_a_of_type_JavaLangString, "+++++startDownload()+++++ downloadInfo == null>>>downloadInfo.url=" + paramDownloadInfo.jdField_c_of_type_JavaLangString + "+++++downloadInfo.downloadType=" + paramDownloadInfo.jdField_f_of_type_Int);
          continue;
        }
        localObject = paramDownloadInfo.jdField_c_of_type_JavaLangString;
      }
      finally {}
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt, String paramString)
  {
    if (paramDownloadInfo == null)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "handleDownloadErrorCallBack info == null code = " + paramInt + " msg = " + paramString);
      return;
    }
    LogUtility.c(jdField_a_of_type_JavaLangString, "handleDownloadErrorCallBack code = " + paramInt + " msg = " + paramString);
    label107:
    int i;
    if ((paramInt >= 400) && (paramInt <= 599))
    {
      try
      {
        CommonDataAdapter.a().a().getString(2131559995);
      }
      catch (Exception paramDownloadInfo)
      {
        paramDownloadInfo.printStackTrace();
        return;
      }
      paramString = CommonDataAdapter.a().a().getString(2131559996);
      i = 3;
    }
    for (;;)
    {
      paramDownloadInfo.a(i);
      LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载错误:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ((DownloadListener)((Iterator)localObject).next()).a(paramDownloadInfo, paramInt, paramString, i);
          continue;
          paramDownloadInfo.a(4);
          if (paramDownloadInfo.jdField_f_of_type_Int == 1)
          {
            ThreadManager.b().post(new hnj(this, paramDownloadInfo));
            return;
          }
          ThreadManager.b().post(new hnk(this, paramDownloadInfo));
          return;
          paramString = CommonDataAdapter.a().a().getString(2131559999);
          i = 3;
          break;
          paramString = CommonDataAdapter.a().a().getString(2131559995);
          i = 3;
          break;
          paramString = CommonDataAdapter.a().a().getString(2131559996);
          i = 3;
          break;
          paramString = CommonDataAdapter.a().a().getString(2131559998);
          i = 3;
          break;
          paramString = CommonDataAdapter.a().a().getString(2131559997);
          i = 3;
          break;
          paramString = CommonDataAdapter.a().a().getString(2131559994);
          if (paramDownloadInfo == null) {
            break label429;
          }
          if (paramDownloadInfo.jdField_f_of_type_Int == 1) {}
          for (localObject = paramDownloadInfo.jdField_h_of_type_JavaLangString; localObject != null; localObject = paramDownloadInfo.jdField_c_of_type_JavaLangString)
          {
            ThreadManager.b().post(new hnl(this, (String)localObject));
            break;
          }
        }
      }
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      c(paramString);
      return;
      label429:
      i = 10;
      continue;
      switch (paramInt)
      {
      }
      break label107;
      i = 10;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong)
  {
    int i;
    if ((AppInterface)a().get() != null)
    {
      i = 14;
      switch (paramDownloadInfo.jdField_i_of_type_Int)
      {
      default: 
        i = 40;
      }
    }
    for (;;)
    {
      Bundle localBundle1 = null;
      if (!TextUtils.isEmpty(paramDownloadInfo.e))
      {
        localBundle1 = new Bundle();
        localBundle1.putString("appname", paramDownloadInfo.e + ".apk");
      }
      Intent localIntent = new Intent("com.opensdk.downloadmanager.renameFilename");
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("filePath", paramDownloadInfo.jdField_k_of_type_JavaLangString);
      localBundle2.putLong("dataLength", paramLong);
      localBundle2.putInt("fileSourceId", i);
      localBundle2.putBundle("otherData", localBundle1);
      localBundle2.putInt("peerType", -1);
      localIntent.putExtra("extraBundle", localBundle2);
      CommonDataAdapter.a().a().sendBroadcast(localIntent);
      return;
      i = 15;
      continue;
      i = 17;
      continue;
      i = 18;
      continue;
      i = 40;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramDownloadInfo == null)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "trafficReport info == null code = " + paramInt);
      return;
    }
    LogUtility.c(jdField_a_of_type_JavaLangString, "trafficReport code = " + paramInt);
    if ((paramInt >= 400) && (paramInt <= 599)) {
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "open appstore network error");
    }
    switch (paramInt)
    {
    default: 
      return;
    case -24: 
      a(paramDownloadInfo, 0L, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "package invalid");
      return;
    case 0: 
    case 5: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "do not need to handle error");
      return;
    case 4: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "DownloadSDK_START_FAILED_EXISTED");
      return;
    case 1: 
    case 601: 
    case 602: 
    case 603: 
    case 605: 
    case 701: 
    case 702: 
    case 706: 
    case 707: 
    case 708: 
    case 709: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "network error");
      return;
    case 3: 
    case 600: 
    case 604: 
    case 700: 
    case 704: 
    case 705: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "download error");
      return;
    }
    a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "write file error");
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong1, long paramLong2, String paramString)
  {
    if (paramLong2 > 0L)
    {
      paramDownloadInfo.jdField_b_of_type_Long = paramLong1;
      e(paramDownloadInfo);
      a(paramString, paramLong2, paramDownloadInfo.jdField_i_of_type_Int);
    }
  }
  
  /* Error */
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnull +11 -> 14
    //   6: aload_2
    //   7: getfield 678	com/tencent/apkupdate/logic/data/ApkUpdateDetail:updatemethod	I
    //   10: iconst_4
    //   11: if_icmpeq +20 -> 31
    //   14: getstatic 38	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: ldc_w 680
    //   20: invokestatic 103	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 681	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_2
    //   32: getfield 684	com/tencent/apkupdate/logic/data/ApkUpdateDetail:url	Ljava/lang/String;
    //   35: astore 5
    //   37: aload_2
    //   38: getfield 687	com/tencent/apkupdate/logic/data/ApkUpdateDetail:patchsize	I
    //   41: i2l
    //   42: lstore_3
    //   43: getstatic 38	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   46: new 40	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 689
    //   56: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: lload_3
    //   60: ldc2_w 690
    //   63: ldiv
    //   64: invokevirtual 694	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: ldc_w 696
    //   70: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 698
    //   76: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 5
    //   81: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 103	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_1
    //   91: aload 5
    //   93: putfield 212	com/tencent/open/downloadnew/DownloadInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   96: aload_1
    //   97: iconst_1
    //   98: putfield 209	com/tencent/open/downloadnew/DownloadInfo:jdField_f_of_type_Int	I
    //   101: aload_0
    //   102: aload_1
    //   103: invokevirtual 681	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   106: goto -78 -> 28
    //   109: astore_2
    //   110: getstatic 38	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   113: ldc_w 700
    //   116: aload_2
    //   117: invokestatic 354	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload_0
    //   121: aload_1
    //   122: invokevirtual 681	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   125: goto -97 -> 28
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	DownloadManager
    //   0	133	1	paramDownloadInfo	DownloadInfo
    //   0	133	2	paramApkUpdateDetail	ApkUpdateDetail
    //   42	18	3	l	long
    //   35	57	5	str	String
    // Exception table:
    //   from	to	target	type
    //   31	106	109	java/lang/Exception
    //   6	14	128	finally
    //   14	28	128	finally
    //   31	106	128	finally
    //   110	125	128	finally
  }
  
  public void a(DownloadListener paramDownloadListener)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramDownloadListener)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramDownloadListener);
      }
      return;
    }
    finally
    {
      paramDownloadListener = finally;
      throw paramDownloadListener;
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      AppNotificationManager.a().a(paramString);
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    String[] arrayOfString = null;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
      switch (paramInt)
      {
      }
    }
    while ((a() == null) || (arrayOfString == null))
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "application or tags is null");
      return;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIAppCenterDefaultDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
      continue;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIAppCenterQQUpdateDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
      continue;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIAppCenterGameCenterDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
      continue;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIAppCenterOthersDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
      continue;
      switch (paramInt)
      {
      default: 
        arrayOfString = null;
        break;
      case 0: 
        arrayOfString = new String[] { "param_XGAppCenterDefaultDownloadFlow", "param_XGFlow", "param_Flow" };
        break;
      case 1: 
        arrayOfString = new String[] { "param_XGAppCenterQQUpdateDownloadFlow", "param_XGFlow", "param_Flow" };
        break;
      case 2: 
        arrayOfString = new String[] { "param_XGAppCenterGameCenterDownloadFlow", "param_XGFlow", "param_Flow" };
        break;
      case 3: 
        arrayOfString = new String[] { "param_XGAppCenterOthersDownloadFlow", "param_XGFlow", "param_Flow" };
      }
    }
    AppInterface localAppInterface = (AppInterface)a().get();
    if (localAppInterface == null)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "appinterface is null");
      return;
    }
    try
    {
      localAppInterface.a(localAppInterface.a(), arrayOfString, paramLong);
      LogUtility.c(jdField_a_of_type_JavaLangString, "sendAppDataIncerment logMsg: " + paramString + " ,fileSize : " + paramLong);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    int i = 0;
    String str = "";
    Object localObject2 = new ArrayList();
    if (((Iterator)localObject1).hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)((Iterator)localObject1).next();
      if ((localDownloadInfo == null) || (localDownloadInfo.jdField_h_of_type_Int != 1)) {
        break label269;
      }
      ((ArrayList)localObject2).add(localDownloadInfo);
      if ((!TextUtils.isEmpty(str)) || (AppUtil.a(localDownloadInfo.d))) {
        break label266;
      }
      str = localDownloadInfo.e;
      label99:
      i += 1;
    }
    label266:
    label269:
    for (;;)
    {
      break;
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DownloadInfo)((Iterator)localObject1).next();
          ((DownloadInfo)localObject2).a(10);
          a(10, (DownloadInfo)localObject2);
        }
      }
      boolean bool = AppViewBaseActivity.f();
      if ((paramBoolean) && (i > 0))
      {
        localObject1 = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
          break label249;
        }
      }
      label249:
      for (str = str + "等";; str = "")
      {
        str = str + i + "款应用下载失败，请重新下载";
        if (!bool) {
          break;
        }
        ToastUtil.a().a(str, 1);
        return;
      }
      MyAppApi.a().a(true, str);
      return;
      break label99;
    }
  }
  
  public boolean a(DownloadInfo paramDownloadInfo)
  {
    int i = 3;
    DownloadInfo localDownloadInfo = a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    Object localObject;
    label180:
    label192:
    label204:
    int j;
    if (localDownloadInfo != null)
    {
      if (localDownloadInfo.jdField_h_of_type_Int == 0)
      {
        if (localDownloadInfo.jdField_f_of_type_Int == 1)
        {
          localObject = localDownloadInfo.jdField_h_of_type_JavaLangString;
          localObject = a().a((String)localObject);
          if (localObject == null) {
            break label204;
          }
          LogUtility.a(jdField_a_of_type_JavaLangString, "refreshDownloadInfo sdk getReceiveDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen + " getTotalDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen);
          paramDownloadInfo.jdField_k_of_type_Int = ((int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen * 100.0F / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen));
          paramDownloadInfo.a(a(((TMAssistantDownloadTaskInfo)localObject).mState));
          paramDownloadInfo.jdField_h_of_type_Int = 0;
          if (localDownloadInfo.jdField_f_of_type_Int != 1) {
            break label192;
          }
          if (!TextUtils.isEmpty(localDownloadInfo.jdField_k_of_type_JavaLangString)) {
            break label180;
          }
          paramDownloadInfo.jdField_k_of_type_JavaLangString = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
        }
        for (;;)
        {
          return true;
          localObject = localDownloadInfo.jdField_c_of_type_JavaLangString;
          break;
          paramDownloadInfo.jdField_k_of_type_JavaLangString = localDownloadInfo.jdField_k_of_type_JavaLangString;
          continue;
          paramDownloadInfo.jdField_k_of_type_JavaLangString = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_b_of_type_JavaLangString);
        DownloadDBHelper.a().a(localDownloadInfo.jdField_b_of_type_JavaLangString);
      }
      while (localDownloadInfo.jdField_h_of_type_Int != 1) {
        return false;
      }
      localObject = a(localDownloadInfo);
      if (localObject != null)
      {
        j = a(((TMAssistantDownloadTaskInfo)localObject).mState);
        if (j != -2) {
          break label452;
        }
      }
    }
    for (;;)
    {
      paramDownloadInfo.a(i);
      paramDownloadInfo.jdField_h_of_type_Int = 1;
      paramDownloadInfo.jdField_k_of_type_JavaLangString = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
      long l1 = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
      long l2 = ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen;
      paramDownloadInfo.jdField_k_of_type_Int = ((int)((float)l1 * 100.0F / (float)l2));
      if (!MyAppApi.a().e()) {
        paramDownloadInfo.jdField_k_of_type_Int = 0;
      }
      return true;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_b_of_type_JavaLangString);
      DownloadDBHelper.a().a(localDownloadInfo.jdField_b_of_type_JavaLangString);
      break;
      localObject = a(paramDownloadInfo);
      if (localObject == null) {
        break;
      }
      j = a(((TMAssistantDownloadTaskInfo)localObject).mState);
      if (j == -2) {}
      for (;;)
      {
        paramDownloadInfo.a(i);
        l1 = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
        l2 = ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen;
        paramDownloadInfo.jdField_k_of_type_Int = ((int)((float)l1 * 100.0F / (float)l2));
        if (!MyAppApi.a().e()) {
          paramDownloadInfo.jdField_k_of_type_Int = 0;
        }
        paramDownloadInfo.jdField_h_of_type_Int = 1;
        e(paramDownloadInfo);
        return true;
        i = j;
      }
      label452:
      i = j;
    }
  }
  
  protected boolean a(DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2)
  {
    paramDownloadInfo1.jdField_a_of_type_Boolean = paramDownloadInfo2.jdField_a_of_type_Boolean;
    paramDownloadInfo1.jdField_b_of_type_Boolean = paramDownloadInfo2.jdField_b_of_type_Boolean;
    paramDownloadInfo1.jdField_h_of_type_Int = paramDownloadInfo2.jdField_h_of_type_Int;
    paramDownloadInfo1.jdField_g_of_type_JavaLangString = paramDownloadInfo2.jdField_g_of_type_JavaLangString;
    if (!paramDownloadInfo1.jdField_c_of_type_JavaLangString.equals(paramDownloadInfo2.jdField_c_of_type_JavaLangString))
    {
      b(paramDownloadInfo2.jdField_b_of_type_JavaLangString);
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    paramString = a().a(paramString);
    return (paramString != null) && (paramString.a() == 4);
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = a(paramString1);
    if (paramString2 != null) {
      b(paramString1);
    }
    if (paramString2 != null)
    {
      if (!paramBoolean) {
        break label32;
      }
      a(10, paramString2);
    }
    for (;;)
    {
      return true;
      try
      {
        label32:
        AppNotificationManager.a().a(paramString2.jdField_f_of_type_JavaLangString);
      }
      catch (Exception paramString1)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", paramString1);
      }
    }
  }
  
  /* Error */
  public DownloadInfo b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +57 -> 63
    //   9: aload_0
    //   10: getfield 76	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: invokevirtual 386	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   16: invokeinterface 392 1 0
    //   21: astore 4
    //   23: aload 4
    //   25: invokeinterface 397 1 0
    //   30: ifeq +33 -> 63
    //   33: aload 4
    //   35: invokeinterface 401 1 0
    //   40: checkcast 207	com/tencent/open/downloadnew/DownloadInfo
    //   43: astore_3
    //   44: aload_1
    //   45: aload_3
    //   46: getfield 287	com/tencent/open/downloadnew/DownloadInfo:d	Ljava/lang/String;
    //   49: invokevirtual 815	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: istore_2
    //   53: iload_2
    //   54: ifeq -31 -> 23
    //   57: aload_3
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -6 -> 59
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	DownloadManager
    //   0	73	1	paramString	String
    //   52	2	2	bool	boolean
    //   43	15	3	localDownloadInfo	DownloadInfo
    //   21	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	23	68	finally
    //   23	53	68	finally
  }
  
  public DownloadInfo b(String paramString, int paramInt)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      int i = paramInt;
      if (paramInt == -2) {
        i = 3;
      }
      paramString.a(i);
    }
    return paramString;
  }
  
  protected void b()
  {
    ThreadManager.b().postDelayed(new hne(this), 5000L);
    ThreadManager.b().postDelayed(new hnf(this), 10000L);
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    for (;;)
    {
      try
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "complete info == null ");
        return;
      }
      finally {}
      LogUtility.a(jdField_a_of_type_JavaLangString, "onDownload complete, info = " + paramDownloadInfo.toString());
      if (paramDownloadInfo.jdField_h_of_type_Int == 0)
      {
        if (paramDownloadInfo.jdField_f_of_type_Int == 1) {
          ThreadManager.b().post(new hmv(this, paramDownloadInfo));
        } else {
          ThreadManager.b().post(new hmw(this, paramDownloadInfo));
        }
      }
      else {
        ThreadManager.b().post(new hmx(this, paramDownloadInfo));
      }
    }
  }
  
  public void b(DownloadListener paramDownloadListener)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramDownloadListener)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramDownloadListener);
      }
      return;
    }
    finally
    {
      paramDownloadListener = finally;
      throw paramDownloadListener;
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      LogUtility.d(jdField_a_of_type_JavaLangString, "appid is empty");
      return;
    }
    Object localObject = a(paramString);
    if (localObject == null)
    {
      LogUtility.d(jdField_a_of_type_JavaLangString, "clearDownloadInfo info == null");
      return;
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "clearDownloadInfo info =" + ((DownloadInfo)localObject).toString());
    if (((DownloadInfo)localObject).jdField_h_of_type_Int == 0) {
      if (((DownloadInfo)localObject).jdField_f_of_type_Int != 1) {
        break label126;
      }
    }
    label126:
    for (localObject = ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString;; localObject = ((DownloadInfo)localObject).jdField_c_of_type_JavaLangString)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.b().post(new hnm(this, (String)localObject));
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      DownloadDBHelper.a().a(paramString);
      return;
    }
  }
  
  public DownloadInfo c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (((localDownloadInfo.jdField_f_of_type_Int == 0) && (paramString.equals(localDownloadInfo.jdField_c_of_type_JavaLangString))) || ((localDownloadInfo.jdField_f_of_type_Int == 1) && (paramString.equals(localDownloadInfo.jdField_h_of_type_JavaLangString))) || ((localDownloadInfo.jdField_f_of_type_Int == 2) && (paramString.equals(localDownloadInfo.jdField_c_of_type_JavaLangString)))) {
          return localDownloadInfo;
        }
      }
    }
    return null;
  }
  
  public DownloadInfo c(String paramString, int paramInt)
  {
    paramString = c(paramString);
    if (paramString != null)
    {
      paramString.a(2);
      paramString.jdField_k_of_type_Int = paramInt;
    }
    return paramString;
  }
  
  public void c()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if ((localDownloadInfo != null) && ((localDownloadInfo.a() == 2) || (localDownloadInfo.a() == 20))) {
          a(localDownloadInfo.jdField_b_of_type_JavaLangString);
        }
      }
    }
    finally {}
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    Object localObject3 = null;
    if (paramDownloadInfo == null)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "installDownload info == null");
      return;
    }
    if (!paramDownloadInfo.jdField_c_of_type_Boolean)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "installDownload info is not apk");
      return;
    }
    Object localObject2 = "";
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
    Object localObject1;
    if (TextUtils.isEmpty(paramDownloadInfo.jdField_k_of_type_JavaLangString)) {
      if (paramDownloadInfo.jdField_h_of_type_Int == 0)
      {
        localTMAssistantDownloadTaskInfo = a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localTMAssistantDownloadTaskInfo != null)
        {
          localObject1 = localObject2;
          if (localTMAssistantDownloadTaskInfo.mState == 4) {
            localObject1 = localTMAssistantDownloadTaskInfo.mSavePath;
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = a(paramDownloadInfo);
          localObject2 = localObject1;
        }
        label106:
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((TMAssistantDownloadTaskInfo)localObject3).mState == 4) {
            localObject1 = ((TMAssistantDownloadTaskInfo)localObject3).mSavePath;
          }
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramDownloadInfo.jdField_k_of_type_JavaLangString = ((String)localObject1);
          paramDownloadInfo.a(4);
          e(paramDownloadInfo);
        }
      }
    }
    for (localObject2 = localObject1;; localObject2 = paramDownloadInfo.jdField_k_of_type_JavaLangString)
    {
      localObject1 = AppUtil.a((String)localObject2);
      LogUtility.a(jdField_a_of_type_JavaLangString, "installDownload localAPKPath=" + (String)localObject2 + ", apkPackageName=" + (String)localObject1 + " updateType=" + paramDownloadInfo.jdField_f_of_type_Int);
      if (localObject1 == null) {
        break label392;
      }
      if ((!AppUtil.a(CommonDataAdapter.a().a(), (String)localObject2)) || (!((String)localObject1).equals("com.tencent.android.qqdownloader")) || (!paramDownloadInfo.jdField_b_of_type_JavaLangString.equals("1101070898"))) {
        break;
      }
      LogUtility.a(jdField_a_of_type_JavaLangString, "report yyb start install");
      localObject3 = StaticAnalyz.a(paramDownloadInfo.jdField_g_of_type_JavaLangString, "NEWYYB");
      MyAppApi.a().b();
      localObject2 = MyAppApi.a().a();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramDownloadInfo.jdField_b_of_type_JavaLangString;
      }
      StaticAnalyz.a("311", (String)localObject3, (String)localObject1);
      paramDownloadInfo = CommonDataAdapter.a().a();
      if (paramDownloadInfo == null) {
        break;
      }
      StaticAnalyz.a(paramDownloadInfo, "312", (String)localObject3, (String)localObject1);
      return;
      localTMAssistantDownloadTaskInfo = a(paramDownloadInfo);
      localObject1 = localObject2;
      if (localTMAssistantDownloadTaskInfo != null)
      {
        localObject1 = localObject2;
        if (localTMAssistantDownloadTaskInfo.mState == 4) {
          localObject1 = localTMAssistantDownloadTaskInfo.mSavePath;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label106;
      }
      localObject3 = a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
      localObject2 = localObject1;
      break label106;
    }
    label392:
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      LogUtility.a(jdField_a_of_type_JavaLangString, "package invaild del file");
    }
    try
    {
      localObject1 = new File((String)localObject2);
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      label429:
      a(-2, paramDownloadInfo, -24, "");
      return;
    }
    catch (Exception localException)
    {
      break label429;
    }
  }
  
  public void c(String paramString)
  {
    LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect showToast:" + paramString + " isResuming=" + AppViewBaseActivity.f());
    try
    {
      if ((BaseActivity.a.isResume()) && (System.currentTimeMillis() - this.jdField_c_of_type_Long > 1000L))
      {
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        ToastUtil.a().a(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "showToast>>>", paramString);
    }
  }
  
  public void d()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if ((localDownloadInfo != null) && (localDownloadInfo.jdField_h_of_type_Int == 1) && ((localDownloadInfo.a() == 2) || (localDownloadInfo.a() == 20)))
        {
          localDownloadInfo.a(3);
          a(3, localDownloadInfo);
        }
      }
    }
    finally {}
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "onReveiveInstallIntent info=" + paramDownloadInfo);
    if (paramDownloadInfo.jdField_h_of_type_Int == 0) {
      StaticAnalyz.a("310", paramDownloadInfo.jdField_g_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_JavaLangString);
    }
    if (paramDownloadInfo.jdField_i_of_type_Int != 5) {
      b(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    }
    AppNotificationManager.a().a(paramDownloadInfo.jdField_f_of_type_JavaLangString);
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   4: invokevirtual 430	java/util/concurrent/ConcurrentLinkedQueue:iterator	()Ljava/util/Iterator;
    //   7: astore_1
    //   8: aload_1
    //   9: invokeinterface 397 1 0
    //   14: ifeq +41 -> 55
    //   17: aload_0
    //   18: aload_1
    //   19: invokeinterface 401 1 0
    //   24: checkcast 432	com/tencent/open/downloadnew/DownloadListener
    //   27: invokevirtual 929	com/tencent/open/downloadnew/DownloadManager:b	(Lcom/tencent/open/downloadnew/DownloadListener;)V
    //   30: goto -22 -> 8
    //   33: astore_1
    //   34: getstatic 38	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: ldc_w 931
    //   40: aload_1
    //   41: invokestatic 342	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   44: ldc 2
    //   46: monitorenter
    //   47: aconst_null
    //   48: putstatic 178	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   51: ldc 2
    //   53: monitorexit
    //   54: return
    //   55: invokestatic 150	com/tencent/mobileqq/app/ThreadManager:b	()Landroid/os/Handler;
    //   58: new 933	hmy
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 934	hmy:<init>	(Lcom/tencent/open/downloadnew/DownloadManager;)V
    //   66: invokevirtual 174	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   69: pop
    //   70: goto -26 -> 44
    //   73: astore_1
    //   74: ldc 2
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	DownloadManager
    //   7	12	1	localIterator	Iterator
    //   33	8	1	localException	Exception
    //   73	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	33	java/lang/Exception
    //   8	30	33	java/lang/Exception
    //   55	70	33	java/lang/Exception
    //   47	54	73	finally
    //   74	77	73	finally
  }
  
  public void e(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {}
    try
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "addDownloadInfo info = " + paramDownloadInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo);
      DownloadDBHelper.a().a(paramDownloadInfo);
      return;
    }
    finally
    {
      paramDownloadInfo = finally;
      throw paramDownloadInfo;
    }
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 200) {
      ThreadManager.b().postDelayed(new hnc(this), 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager
 * JD-Core Version:    0.7.0.1
 */