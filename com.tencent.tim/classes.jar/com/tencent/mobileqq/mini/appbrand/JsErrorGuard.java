package com.tencent.mobileqq.mini.appbrand;

import acfp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import aqju;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;

public class JsErrorGuard
  implements AppBrandRuntime.JsConsoleMessageListener, TbsListener
{
  private static final String TAG = "miniapp-start_JsConsoleGuard";
  private static int X5_STATE_DOWNLOAD_EXIST_IN_WX;
  private static int X5_STATE_DOWNLOAD_FAIL_INIT_THREAD;
  private static int X5_STATE_DOWNLOAD_OTHER_PROCESS;
  private static int X5_STATE_DOWNLOAD_READY;
  private static int X5_STATE_DOWNLOAD_REPEAT;
  private static int X5_STATE_DOWNLOAD_SUCC = 100;
  private static int X5_STATE_INSTALL_COPY_SUCC = 220;
  private static int X5_STATE_INSTALL_SUCC;
  private static int X5_STATE_INSTALL_SUCCESS_AND_RELEASE_LOCK = 232;
  private AppBrandRuntime mAppBrandRuntime;
  private boolean mGuideShowed;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private LoadingDialog mLoadingDialog;
  private PermissionDialog mRestartDialog;
  private Runnable mTimeoutRunnable = new JsErrorGuard.1(this);
  
  static
  {
    X5_STATE_DOWNLOAD_REPEAT = 110;
    X5_STATE_DOWNLOAD_READY = 120;
    X5_STATE_DOWNLOAD_FAIL_INIT_THREAD = 121;
    X5_STATE_DOWNLOAD_EXIST_IN_WX = 122;
    X5_STATE_DOWNLOAD_OTHER_PROCESS = 177;
    X5_STATE_INSTALL_SUCC = 200;
  }
  
  public JsErrorGuard(AppBrandRuntime paramAppBrandRuntime)
  {
    this.mAppBrandRuntime = paramAppBrandRuntime;
  }
  
  private void onX5Failed()
  {
    if ((this.mLoadingDialog != null) && (this.mLoadingDialog.isShowing())) {
      this.mLoadingDialog.dismiss();
    }
    QQToast.a(this.mAppBrandRuntime.activity, acfp.m(2131707535), 0).show();
  }
  
  private void onX5Succeed()
  {
    try
    {
      if ((this.mLoadingDialog != null) && (this.mLoadingDialog.isShowing())) {
        this.mLoadingDialog.dismiss();
      }
      if (this.mRestartDialog == null)
      {
        this.mRestartDialog = new PermissionDialog(this.mAppBrandRuntime.activity, 2131756467);
        this.mRestartDialog.setTitle(acfp.m(2131707533));
        this.mRestartDialog.setMessage(acfp.m(2131707531));
        this.mRestartDialog.setNegativeButton(acfp.m(2131707529), new JsErrorGuard.7(this));
        this.mRestartDialog.setPositiveButton(acfp.m(2131707532), new JsErrorGuard.8(this));
        this.mRestartDialog.setCanceledOnTouchOutside(false);
      }
      if (!this.mRestartDialog.isShowing()) {
        this.mRestartDialog.show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-start_JsConsoleGuard", 1, "", localThrowable);
    }
  }
  
  private void showX5Guide()
  {
    int i = QbSdk.getTbsVersion(this.mAppBrandRuntime.activity);
    int j = QbSdk.getTmpDirTbsVersion(this.mAppBrandRuntime.activity);
    QLog.d("miniapp-start_JsConsoleGuard", 1, "getTbsVersion=" + i + " tmpDirTbsVersion=" + j);
    if ((i > 0) || (j > 0)) {}
    do
    {
      return;
      this.mHandler.postDelayed(this.mTimeoutRunnable, 15000L);
      QbSdk.setTbsListener(this);
      TbsDownloader.startDownload(this.mAppBrandRuntime.activity, true);
      if (this.mLoadingDialog == null) {
        this.mLoadingDialog = new LoadingDialog(this.mAppBrandRuntime.activity);
      }
      this.mLoadingDialog.setTitle(acfp.m(2131707534));
    } while (this.mLoadingDialog.isShowing());
    this.mLoadingDialog.show();
  }
  
  public void onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.activity == null) || (this.mAppBrandRuntime.isFirstDomReady) || (this.mGuideShowed)) {
      break label34;
    }
    label34:
    while ((paramConsoleMessage == null) || (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR)) {
      return;
    }
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_jserror_tip_enable", 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.e("miniapp-start_JsConsoleGuard", 1, paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber() + " enableGuide:" + bool);
      if (!bool) {
        break;
      }
      AppBrandTask.runTaskOnUiThreadDelay(new JsErrorGuard.2(this), 1500L);
      return;
    }
  }
  
  public void onDownloadFinish(int paramInt)
  {
    QLog.d("miniapp-start_JsConsoleGuard", 1, "Tbs download result=" + paramInt);
    this.mHandler.removeCallbacks(this.mTimeoutRunnable);
    AppBrandTask.runTaskOnUiThread(new JsErrorGuard.4(this, paramInt));
  }
  
  public void onDownloadProgress(int paramInt)
  {
    QLog.d("miniapp-start_JsConsoleGuard", 1, "Tbs install onDownloadProgress=" + paramInt);
    this.mHandler.removeCallbacks(this.mTimeoutRunnable);
    AppBrandTask.runTaskOnUiThread(new JsErrorGuard.6(this, paramInt));
  }
  
  public void onInstallFinish(int paramInt)
  {
    QLog.d("miniapp-start_JsConsoleGuard", 1, "Tbs install result=" + paramInt);
    this.mHandler.removeCallbacks(this.mTimeoutRunnable);
    AppBrandTask.runTaskOnUiThread(new JsErrorGuard.5(this, paramInt));
  }
  
  public void startShowX5Guide()
  {
    if ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.activity == null) || (this.mAppBrandRuntime.isFirstDomReady) || (this.mGuideShowed)) {
      return;
    }
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_jserror_tip_enable", 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.e("miniapp-start_JsConsoleGuard", 1, "startShowX5Guide enableGuide:" + bool);
      if (!bool) {
        break;
      }
      AppBrandTask.runTaskOnUiThreadDelay(new JsErrorGuard.3(this), 1500L);
      return;
    }
  }
  
  public static class LoadingDialog
    extends ReportDialog
  {
    LoadingDialog(Context paramContext)
    {
      super(2131756293);
      setContentView(2131562441);
      getWindow().setFlags(1024, 2048);
    }
    
    public void dismiss()
    {
      try
      {
        super.dismiss();
        return;
      }
      catch (Exception localException)
      {
        QZLog.w(localException);
      }
    }
    
    public void setTitle(int paramInt)
    {
      if (paramInt == 0) {}
      for (String str = null;; str = getContext().getResources().getString(paramInt))
      {
        setTitle(str);
        return;
      }
    }
    
    public void setTitle(String paramString)
    {
      ((TextView)findViewById(2131379769)).setText(paramString);
    }
    
    public void show()
    {
      try
      {
        super.show();
        return;
      }
      catch (Exception localException)
      {
        QZLog.w(localException);
      }
    }
  }
  
  static class PermissionDialog
    extends aqju
  {
    private Activity mActivity;
    
    public PermissionDialog(Activity paramActivity, int paramInt)
    {
      super(paramInt);
      this.mActivity = paramActivity;
      initUI();
    }
    
    public void initUI()
    {
      setContentView(2131559142);
      findViewById(2131370174).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.JsErrorGuard
 * JD-Core Version:    0.7.0.1
 */