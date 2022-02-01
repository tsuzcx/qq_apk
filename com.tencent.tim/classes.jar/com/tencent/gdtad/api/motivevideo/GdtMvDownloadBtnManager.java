package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import arvv;
import arvz;
import aryv;
import aryx;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import jzk;
import tja;
import tjb;
import tkw;
import tky;
import tll;

public class GdtMvDownloadBtnManager
{
  private GdtMvAppBtnData jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData;
  private tjb jdField_a_of_type_Tjb;
  private int aTQ;
  private GdtAd ad;
  private aryx b = new a(this);
  private boolean isLoadingAppData;
  private Context mContext;
  private Runnable mLoadAppJob = new GdtMvDownloadBtnManager.1(this);
  
  public GdtMvDownloadBtnManager(Context paramContext, GdtAd paramGdtAd, String paramString, GdtMvAppBtnView paramGdtMvAppBtnView1, GdtMvAppBtnView paramGdtMvAppBtnView2)
  {
    tkw.d("GdtMvDownloadBtnManager", "GdtMvDownloadBtnManager: ");
    this.mContext = paramContext;
    this.ad = paramGdtAd;
    this.jdField_a_of_type_Tjb = new tjb(paramString, paramGdtMvAppBtnView1, paramGdtMvAppBtnView2, this);
  }
  
  private static void a(Activity paramActivity, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if ((paramActivity == null) || (paramGdtMvAppBtnData == null)) {
      return;
    }
    String str1 = paramGdtMvAppBtnData.packageName;
    String str2 = paramGdtMvAppBtnData.mGdtAd_appId;
    String str3 = paramGdtMvAppBtnData.apkUrlhttp;
    String str4 = paramGdtMvAppBtnData.name;
    String str5 = paramGdtMvAppBtnData.via;
    Object localObject = paramActivity.getIntent().getStringExtra("big_brother_ref_source_key");
    paramGdtMvAppBtnData = (GdtMvAppBtnData)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramGdtMvAppBtnData = paramActivity.getIntent().getStringExtra("big_brother_source_key");
    }
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)))
    {
      tkw.e("GdtMvDownloadBtnPresenter", "startRealDownload param null");
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString(aryv.PARAM_TASK_PACKNAME, str1);
    ((Bundle)localObject).putString(aryv.PARAM_SNG_APPID, str2);
    ((Bundle)localObject).putString(aryv.PARAM_URL, str3);
    ((Bundle)localObject).putString(aryv.PARAM_APPNAME, str4);
    ((Bundle)localObject).putInt(aryv.PARAM_ACTIONCODE, 2);
    ((Bundle)localObject).putInt(aryv.PARAM_WOWNLOAD_TYPE, 0);
    ((Bundle)localObject).putBoolean(aryv.PARAM_BLOCK_NOTIFY, false);
    ((Bundle)localObject).putInt(aryv.PARAM_SHOW_NOTIFICATION, 0);
    ((Bundle)localObject).putBoolean(aryv.PARAM_IS_APK, true);
    ((Bundle)localObject).putBoolean(aryv.PARAM_AUTO_INSTALL, true);
    ((Bundle)localObject).putBoolean(aryv.PARAM_SHOW_NETWORK_DIALOG, false);
    ((Bundle)localObject).putBoolean(aryv.PARAM_IS_AUTOINSTALL_BY_SDK, false);
    ((Bundle)localObject).putString(aryv.PARAM_VIA, str5);
    ((Bundle)localObject).putString("big_brother_ref_source_key", paramGdtMvAppBtnData);
    tkw.d("GdtMvDownloadBtnManager", "startRealDownload pkg:" + str1 + ", appid:" + str2 + ", name:" + str4 + ", url:" + str3);
    arvz.a().d(paramActivity, (Bundle)localObject, "biz_src_ads", null, 0);
  }
  
  private void a(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    tkw.d("GdtMvDownloadBtnManager", "setCGdtMvAppBtnData() called with: gdtMvAppBtnData = [" + paramGdtMvAppBtnData + "]");
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData == null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData = paramGdtMvAppBtnData;
      this.jdField_a_of_type_Tjb.l(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
    }
  }
  
  private static void a(GdtMvDownloadBtnManager paramGdtMvDownloadBtnManager, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    paramGdtMvAppBtnData.mGdtAd_appId = paramGdtMvDownloadBtnManager.ad.getAppId();
    paramGdtMvAppBtnData.packageName = paramGdtMvDownloadBtnManager.ad.getAppPackageName();
    paramGdtMvAppBtnData.name = paramGdtMvDownloadBtnManager.ad.getAdvertiser_corporate_image_name();
    paramGdtMvAppBtnData.via = paramGdtMvDownloadBtnManager.ad.getVia();
    if (jzk.C(paramGdtMvDownloadBtnManager.mContext, paramGdtMvAppBtnData.packageName))
    {
      paramGdtMvAppBtnData.cState = 1;
      paramGdtMvAppBtnData.cProgerss = 100;
      return;
    }
    paramGdtMvDownloadBtnManager = arvv.a().e(paramGdtMvAppBtnData.apkUrlhttp);
    if (paramGdtMvDownloadBtnManager != null)
    {
      paramGdtMvAppBtnData.cState = ex(paramGdtMvDownloadBtnManager.getState());
      paramGdtMvAppBtnData.cProgerss = paramGdtMvDownloadBtnManager.progress;
      return;
    }
    tkw.d("GdtMvDownloadBtnManager", "updateMvAppBtnData: getDownloadInfoByUrl return null");
  }
  
  private boolean d(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return (TextUtils.equals(paramString1, paramString3)) && (TextUtils.equals(paramString2, paramString4));
  }
  
  private static int ex(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 10: 
    case 30: 
    default: 
      return 0;
    case 4: 
      return 5;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 2;
  }
  
  private static void uq(String paramString)
  {
    tkw.d("GdtMvDownloadBtnManager", "triggerRegisterDownloadCallback: ");
    ThreadManagerV2.executeOnSubThread(new GdtMvDownloadBtnManager.2(paramString));
  }
  
  public void a(GdtMvAppBtnData paramGdtMvAppBtnData, int paramInt)
  {
    tkw.w("GdtMvDownloadBtnManager", "startDownload " + paramGdtMvAppBtnData.packageName + " progress " + paramInt);
    paramGdtMvAppBtnData.cState = 3;
    this.jdField_a_of_type_Tjb.c(paramGdtMvAppBtnData, paramInt);
    Activity localActivity = (Activity)this.mContext;
    this.jdField_a_of_type_Tjb.resumeDownload = true;
    a(localActivity, paramGdtMvAppBtnData);
  }
  
  public void click()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData == null)
    {
      this.jdField_a_of_type_Tjb.b(null, 0);
      return;
    }
    this.jdField_a_of_type_Tjb.b(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.cState);
  }
  
  public void fetchAppData()
  {
    tkw.d("GdtMvDownloadBtnManager", "going fetch AppData");
    if ((!this.isLoadingAppData) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData == null) && (tky.isNetValid(this.mContext)))
    {
      this.isLoadingAppData = true;
      ThreadManager.excute(this.mLoadAppJob, 128, null, true);
    }
  }
  
  void firstClickInitDownloadApp()
  {
    if ((this.mContext == null) || (this.jdField_a_of_type_Tjb == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData == null) || (!this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.isValid())) {
      return;
    }
    if (jzk.C(this.mContext, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.packageName))
    {
      this.jdField_a_of_type_Tjb.h(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
      return;
    }
    if (tll.K(this.mContext, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.apkUrlhttp))
    {
      this.jdField_a_of_type_Tjb.g(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
      DownloadInfo localDownloadInfo = arvv.a().e(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.apkUrlhttp);
      if (localDownloadInfo != null) {
        localDownloadInfo.source = "biz_src_ads";
      }
      arvv.a().d(localDownloadInfo);
      return;
    }
    int j = tll.a(this.mContext, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData, i);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    tkw.i("GdtMvDownloadBtnPresenter", "installSucceed " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = paramString1;
    localDownloadInfo.packageName = paramString2;
    this.jdField_a_of_type_Tjb.a(paramString1, paramString2, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void onActivityResume()
  {
    tkw.d("GdtMvDownloadBtnManager", "onActivityResume: ");
    GdtMvAppBtnData localGdtMvAppBtnData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData;
    if (localGdtMvAppBtnData != null)
    {
      if (jzk.C(this.mContext, localGdtMvAppBtnData.packageName))
      {
        tkw.w("GdtMvDownloadBtnPresenter", "onActivityResume already installed." + localGdtMvAppBtnData.packageName);
        this.jdField_a_of_type_Tjb.h(localGdtMvAppBtnData);
      }
      do
      {
        return;
        if (tll.K(this.mContext, localGdtMvAppBtnData.apkUrlhttp))
        {
          tkw.w("GdtMvDownloadBtnPresenter", "onActivityResume already finishDownload." + localGdtMvAppBtnData.packageName);
          this.jdField_a_of_type_Tjb.g(localGdtMvAppBtnData);
          return;
        }
      } while ((localGdtMvAppBtnData.cState != 1) && (localGdtMvAppBtnData.cState != 0) && (localGdtMvAppBtnData.cState != 5));
      tkw.w("GdtMvDownloadBtnManager", "onActivityResume already installed or finishDownload but not exist." + localGdtMvAppBtnData.packageName);
      this.jdField_a_of_type_Tjb.j(localGdtMvAppBtnData);
      return;
    }
    tkw.d("GdtMvDownloadBtnManager", "onActivityResume: app btn data is null");
  }
  
  public void onCreate()
  {
    tkw.d("GdtMvDownloadBtnManager", "onCreate() called");
    arvv.a().a(this.b);
  }
  
  public void onDestroy()
  {
    tkw.i("GdtMvDownloadBtnPresenter", "onDestroy");
    this.isLoadingAppData = false;
    ThreadManager.removeJobFromThreadPool(this.mLoadAppJob, 128);
    arvv.a().b(this.b);
    this.jdField_a_of_type_Tjb = null;
    this.mContext = null;
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    tkw.i("GdtMvDownloadBtnPresenter", "onDownloadCancel " + paramDownloadInfo.packageName);
    this.jdField_a_of_type_Tjb.c(paramDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    tkw.i("GdtMvDownloadBtnPresenter", "onDownloadError " + paramDownloadInfo.packageName);
    this.jdField_a_of_type_Tjb.a(paramDownloadInfo, paramInt1, paramString, paramInt2, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    tkw.i("GdtMvDownloadBtnPresenter", "onDownloadFinish " + paramDownloadInfo.packageName);
    this.jdField_a_of_type_Tjb.d(paramDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    tkw.i("GdtMvDownloadBtnPresenter", "onDownloadPause " + paramDownloadInfo.packageName);
    this.jdField_a_of_type_Tjb.a(paramDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    tkw.d("GdtMvDownloadBtnManager", "onDownloadUpdate: ");
    if ((paramList != null) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (d(localDownloadInfo.packageName, localDownloadInfo.appId, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.packageName, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.mGdtAd_appId)) {
          this.jdField_a_of_type_Tjb.e(localDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    tkw.i("GdtMvDownloadBtnPresenter", "onDownloadWait " + paramDownloadInfo.packageName);
    this.jdField_a_of_type_Tjb.b(paramDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    tkw.i("GdtMvDownloadBtnPresenter", "packageReplaced " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = paramString1;
    localDownloadInfo.packageName = paramString2;
    this.jdField_a_of_type_Tjb.c(paramString1, paramString2, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    tkw.i("GdtMvDownloadBtnPresenter", "uninstallSucceed " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = paramString1;
    localDownloadInfo.packageName = paramString2;
    this.jdField_a_of_type_Tjb.b(paramString1, paramString2, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  static class FirstLoadDataTask
    implements Runnable
  {
    private WeakReference<GdtMvDownloadBtnManager> dy;
    private volatile boolean mCanceled;
    
    private void b(GdtMvAppBtnData paramGdtMvAppBtnData)
    {
      tkw.d("FirstLoadDataTask", "postResultToUI() called with: tempAppBtnData = [" + paramGdtMvAppBtnData + "]");
      new Handler(Looper.getMainLooper()).post(new GdtMvDownloadBtnManager.FirstLoadDataTask.1(this, paramGdtMvAppBtnData));
    }
    
    public void run()
    {
      tkw.d("FirstLoadDataTask", "run() called");
      if (this.mCanceled) {}
      GdtMvDownloadBtnManager localGdtMvDownloadBtnManager;
      do
      {
        return;
        localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.dy.get();
      } while ((localGdtMvDownloadBtnManager == null) || (GdtMvDownloadBtnManager.a(localGdtMvDownloadBtnManager) == null) || (TextUtils.isEmpty(GdtMvDownloadBtnManager.a(localGdtMvDownloadBtnManager).getUrlForClick())));
      GdtMvAppBtnData localGdtMvAppBtnData = new tja().a(GdtMvDownloadBtnManager.a(localGdtMvDownloadBtnManager).getUrlForClick(), "&gd=1", 1);
      if ((localGdtMvAppBtnData != null) && (localGdtMvAppBtnData.isValid()))
      {
        GdtMvDownloadBtnManager.ur(localGdtMvAppBtnData.apkUrlhttp);
        GdtMvDownloadBtnManager.c(localGdtMvDownloadBtnManager, localGdtMvAppBtnData);
        b(localGdtMvAppBtnData);
        return;
      }
      tkw.i("FirstLoadDataTask", "load gdt mv app btn data error");
    }
  }
  
  static class a
    implements aryx
  {
    private WeakReference<GdtMvDownloadBtnManager> dy;
    
    a(GdtMvDownloadBtnManager paramGdtMvDownloadBtnManager)
    {
      this.dy = new WeakReference(paramGdtMvDownloadBtnManager);
    }
    
    public void installSucceed(String paramString1, String paramString2)
    {
      GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.dy.get();
      if (localGdtMvDownloadBtnManager != null) {
        localGdtMvDownloadBtnManager.installSucceed(paramString1, paramString2);
      }
    }
    
    public void onDownloadCancel(DownloadInfo paramDownloadInfo)
    {
      tkw.d("GdtMvDownloadBtnManager", "onDownloadCancel: ");
      GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.dy.get();
      if (localGdtMvDownloadBtnManager != null) {
        localGdtMvDownloadBtnManager.onDownloadCancel(paramDownloadInfo);
      }
    }
    
    public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
    {
      GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.dy.get();
      if (localGdtMvDownloadBtnManager != null) {
        localGdtMvDownloadBtnManager.onDownloadError(paramDownloadInfo, paramInt1, paramString, paramInt2);
      }
    }
    
    public void onDownloadFinish(DownloadInfo paramDownloadInfo)
    {
      tkw.d("GdtMvDownloadBtnManager", "onDownloadFinish: ");
      GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.dy.get();
      if (localGdtMvDownloadBtnManager != null) {
        localGdtMvDownloadBtnManager.onDownloadFinish(paramDownloadInfo);
      }
    }
    
    public void onDownloadPause(DownloadInfo paramDownloadInfo)
    {
      tkw.d("GdtMvDownloadBtnManager", "onDownloadPause: ");
      GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.dy.get();
      if (localGdtMvDownloadBtnManager != null) {
        localGdtMvDownloadBtnManager.onDownloadPause(paramDownloadInfo);
      }
    }
    
    public void onDownloadUpdate(List<DownloadInfo> paramList)
    {
      tkw.d("GdtMvDownloadBtnManager", "onDownloadUpdate: ");
      GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.dy.get();
      if (localGdtMvDownloadBtnManager != null) {
        localGdtMvDownloadBtnManager.onDownloadUpdate(paramList);
      }
    }
    
    public void onDownloadWait(DownloadInfo paramDownloadInfo)
    {
      tkw.d("GdtMvDownloadBtnManager", "onDownloadWait: ");
      GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.dy.get();
      if (localGdtMvDownloadBtnManager != null) {
        localGdtMvDownloadBtnManager.onDownloadWait(paramDownloadInfo);
      }
    }
    
    public void packageReplaced(String paramString1, String paramString2)
    {
      GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.dy.get();
      if (localGdtMvDownloadBtnManager != null) {
        localGdtMvDownloadBtnManager.packageReplaced(paramString1, paramString2);
      }
    }
    
    public void uninstallSucceed(String paramString1, String paramString2)
    {
      GdtMvDownloadBtnManager localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.dy.get();
      if (localGdtMvDownloadBtnManager != null) {
        localGdtMvDownloadBtnManager.uninstallSucceed(paramString1, paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnManager
 * JD-Core Version:    0.7.0.1
 */