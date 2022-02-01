package com.tencent.mobileqq.microapp.activity;

import Wallet.ApkgConfig;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import arhz;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.apkg.g;
import com.tencent.mobileqq.microapp.apkg.g.d;
import com.tencent.mobileqq.microapp.app.b.a;
import com.tencent.mobileqq.microapp.app.b.b;
import com.tencent.mobileqq.microapp.appbrand.b.h;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.widget.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;

public class LoadingFragment
  extends PublicBaseFragment
  implements DialogInterface.OnDismissListener, Handler.Callback, View.OnClickListener, g.d, TbsListener
{
  private static final String TAG = "LoadingActivity";
  private static int X5_STATE_DOWNLOAD_EXIST_IN_WX;
  private static int X5_STATE_DOWNLOAD_FAIL_INIT_THREAD;
  private static int X5_STATE_DOWNLOAD_OTHER_PROCESS;
  private static int X5_STATE_DOWNLOAD_READY;
  private static int X5_STATE_DOWNLOAD_REPEAT;
  private static int X5_STATE_DOWNLOAD_SUCC = 100;
  private static int X5_STATE_INSTALL_COPY_SUCC = 220;
  private static int X5_STATE_INSTALL_SUCC;
  final int CONF_LOAD_TIME_OUT = 60000;
  final int WHAT_LOAD_CONF_FAIL = 1;
  final int WHAT_LOAD_CONF_SUCC = 2;
  final int WHAT_LOAD_MINIAPP_ICON_SUCCESS = 7;
  final int WHAT_LOAD_X5_ERR = 3;
  final int WHAT_LOAD_X5_PROGRESS = 4;
  final int WHAT_LOAD_X5_SUCC = 6;
  final int WHAT_LOAD_X5_TIME_OUT = 5;
  final int X5_LOAD_TIME_OUT = 30000;
  private MiniAppConfig appConfig;
  private String appid;
  private String entryPath;
  private boolean isKill = false;
  boolean isLoadConf;
  private ImageView mCloseView;
  private ImageView mLogoView;
  private ImageView mMoreView;
  private TextView mNameView;
  private RelativeLayout root;
  b.b stateObserver = new c(this);
  Handler uiHandler;
  private d x5Dialog;
  private arhz x5LoadingDialog;
  
  static
  {
    X5_STATE_DOWNLOAD_REPEAT = 110;
    X5_STATE_DOWNLOAD_READY = 120;
    X5_STATE_DOWNLOAD_FAIL_INIT_THREAD = 121;
    X5_STATE_DOWNLOAD_EXIST_IN_WX = 122;
    X5_STATE_DOWNLOAD_OTHER_PROCESS = 177;
    X5_STATE_INSTALL_SUCC = 200;
  }
  
  private void loadConfig()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadingActivity", 2, "loadConfig appConfig=" + this.appConfig + ",isLoadConf=" + this.isLoadConf);
    }
    if (this.isLoadConf) {
      return;
    }
    this.isLoadConf = true;
    this.uiHandler.removeMessages(1);
    this.uiHandler.sendEmptyMessageDelayed(1, 60000L);
    g.a().a(this.appConfig, this);
    b.a locala = new b.a(3, this.appid, this.appConfig.getRuntimeType(), null);
    com.tencent.mobileqq.microapp.app.b.a().a(locala);
  }
  
  private void stopTbsInstall()
  {
    TbsDownloader.stopDownload();
    QbSdk.setTbsListener(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 3: 
    case 1: 
    case 4: 
    case 5: 
    case 6: 
    case 2: 
      do
      {
        do
        {
          return false;
          Toast.makeText(getActivity().getApplicationContext(), "浏览器组件升级失败！", 0).show();
          getActivity().doOnBackPressed();
          return false;
          Toast.makeText(getActivity().getApplicationContext(), "轻应用配置加载失败！", 0).show();
          getActivity().doOnBackPressed();
          return false;
        } while (this.x5LoadingDialog == null);
        this.x5LoadingDialog.setMessage("浏览器组件升级中，进度" + paramMessage.arg1 + "%");
        return false;
        if (this.x5LoadingDialog != null) {
          this.x5LoadingDialog.hide();
        }
        loadConfig();
        return false;
      } while (!(paramMessage.obj instanceof f));
      paramMessage = (f)paramMessage.obj;
      h.a().a(getActivity(), paramMessage);
      paramMessage = new b.a(1, paramMessage.d, paramMessage.f.getRuntimeType(), paramMessage);
      com.tencent.mobileqq.microapp.app.b.a().a(paramMessage);
      return false;
    }
    paramMessage = (URLDrawable)paramMessage.obj;
    this.mLogoView.setImageDrawable(paramMessage);
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    this.isKill = true;
    if (this.appConfig != null)
    {
      b.a locala = new b.a(-1, this.appConfig.config.mini_appid, this.appConfig.getRuntimeType(), null);
      com.tencent.mobileqq.microapp.app.b.a().a(locala);
    }
    if (this.x5LoadingDialog != null) {
      this.x5LoadingDialog.dismiss();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.l) {
      getActivity().doOnBackPressed();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      paramView.getId();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(R.layout.e, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    stopTbsInstall();
    this.uiHandler.removeMessages(1);
    this.uiHandler.removeMessages(5);
    this.uiHandler.removeMessages(6);
    this.uiHandler.removeMessages(3);
    if (QLog.isColorLevel()) {
      QLog.d("LoadingActivity", 2, "onDestroy...");
    }
    com.tencent.mobileqq.microapp.app.b.a().deleteObserver(this.stateObserver);
    this.stateObserver = null;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (d)paramDialogInterface;
    boolean bool1 = paramDialogInterface.b();
    boolean bool2 = paramDialogInterface.c();
    if (QLog.isColorLevel()) {
      QLog.d("LoadingActivity", 2, "onDismiss isConfirm=" + bool1 + ",isRefuse=" + bool2);
    }
    if (bool1)
    {
      this.uiHandler.removeMessages(5);
      this.uiHandler.sendEmptyMessageDelayed(5, 30000L);
      QbSdk.setTbsListener(this);
      TbsDownloader.startDownload(getActivity().getBaseContext(), true);
      if (this.x5LoadingDialog != null)
      {
        this.x5LoadingDialog.setMessage("浏览器组件升级中，请稍候...");
        this.x5LoadingDialog.show();
      }
    }
    while (getActivity() == null) {
      return;
    }
    getActivity().doOnBackPressed();
  }
  
  public void onDownloadFinish(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadingActivity", 2, "onDownloadFinish result=" + paramInt);
    }
    if (paramInt == X5_STATE_DOWNLOAD_SUCC) {
      this.uiHandler.removeMessages(5);
    }
    while ((paramInt == X5_STATE_DOWNLOAD_REPEAT) || (paramInt == X5_STATE_DOWNLOAD_OTHER_PROCESS) || (paramInt == X5_STATE_DOWNLOAD_READY) || (paramInt == X5_STATE_DOWNLOAD_EXIST_IN_WX)) {
      return;
    }
    stopTbsInstall();
    this.uiHandler.sendEmptyMessage(3);
  }
  
  public void onDownloadProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadingActivity", 2, "onDownloadProgress progress=" + paramInt);
    }
    this.uiHandler.removeMessages(5);
    Message localMessage = this.uiHandler.obtainMessage(4);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadingActivity", 2, "finish...");
    }
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 0);
    }
  }
  
  public void onInitApkgInfo(int paramInt, f paramf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadingActivity", 2, "onGetApkgIno...resCode=" + paramInt + ",isKill=" + this.isKill + ",apkgInfo=" + paramf);
    }
    if (this.isKill) {
      return;
    }
    this.uiHandler.removeMessages(1);
    if ((paramInt == 0) && (paramf != null))
    {
      com.tencent.mobileqq.microapp.appbrand.b.b.a().a(paramf);
      Message localMessage = this.uiHandler.obtainMessage(2);
      localMessage.obj = paramf;
      localMessage.sendToTarget();
      return;
    }
    this.uiHandler.sendEmptyMessage(1);
  }
  
  public void onInstallFinish(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadingActivity", 2, "onInstallFinish result=" + paramInt);
    }
    this.uiHandler.removeMessages(5);
    if ((paramInt == X5_STATE_INSTALL_SUCC) || (paramInt == X5_STATE_INSTALL_COPY_SUCC))
    {
      this.uiHandler.sendEmptyMessage(6);
      return;
    }
    this.uiHandler.sendEmptyMessage(3);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    new ImmersionBar(getActivity(), 0, paramView.findViewById(R.id.bh));
    this.uiHandler = new Handler(this);
    paramBundle = getActivity().getIntent();
    if (paramBundle != null) {}
    for (paramBundle = (MiniAppConfig)paramBundle.getSerializableExtra("CONFIG");; paramBundle = null)
    {
      this.appConfig = paramBundle;
      if ((this.appConfig != null) && (this.appConfig.launchParam != null) && (this.appConfig.config != null) && (this.appConfig.config.isValid())) {
        break;
      }
      getActivity().doOnBackPressed();
      return;
    }
    this.appid = this.appConfig.config.mini_appid;
    this.entryPath = this.appConfig.launchParam.entryPath;
    int i = QbSdk.getTbsVersion(getActivity().getBaseContext());
    if (QLog.isColorLevel()) {
      QLog.d("LoadingActivity", 2, "initApkgByConfig...tbsVersion=" + i + ",config=" + this.appConfig + ",appid=" + this.appid + ",entryPath=" + this.entryPath + ".iconUrl=" + this.appConfig.config.icon_url);
    }
    this.root = ((RelativeLayout)paramView.findViewById(R.id.ba));
    this.mMoreView = ((ImageView)paramView.findViewById(R.id.m));
    this.mCloseView = ((ImageView)paramView.findViewById(R.id.l));
    this.mNameView = ((TextView)paramView.findViewById(R.id.aa));
    this.mLogoView = ((ImageView)paramView.findViewById(R.id.aj));
    this.mMoreView.setOnClickListener(this);
    this.mCloseView.setOnClickListener(this);
    this.mNameView.setText(this.appConfig.config.app_name);
    ThreadManagerV2.excute(new a(this), 16, null, false);
    com.tencent.mobileqq.microapp.app.b.a().addObserver(this.stateObserver);
    if (i == 0)
    {
      this.x5LoadingDialog = new arhz(getActivity());
      this.x5LoadingDialog.setOnDismissListener(new b(this));
      this.x5Dialog = new d(getActivity());
      this.x5Dialog.setOnDismissListener(this);
      this.x5Dialog.a("升级提示", "该页面需要升级手Q浏览器组件才能继续访问，确认升级？", "取消", "#FF000000", "升级", "#FF000000", true, null);
      return;
    }
    loadConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.activity.LoadingFragment
 * JD-Core Version:    0.7.0.1
 */