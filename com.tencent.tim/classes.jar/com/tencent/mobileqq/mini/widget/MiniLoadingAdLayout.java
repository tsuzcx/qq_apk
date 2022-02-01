package com.tencent.mobileqq.mini.widget;

import acfp;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ayxa;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.net.URLDecoder;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class MiniLoadingAdLayout
  extends RelativeLayout
{
  private static final String TAG = "MiniLoadingAdLayout";
  private boolean autoDownload;
  private int countdownTime = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_duration", 5);
  private GdtAd mAdInfo;
  private RelativeLayout mAppLayout;
  private ImageView mAppLogoView;
  private TextView mAppNameView;
  private ImageView mCloseBtn;
  private RelativeLayout mCountdownContainer;
  private Runnable mCountdownRunnable;
  private TextView mCountdownTextView;
  private TextView mDeveloperDescView;
  private RelativeLayout mGameLayout;
  private ImageView mGameLogoView;
  private TextView mGameNameView;
  private GdtAppReceiver mGdtAppReceiver;
  private ImageView mLoadingAdImgView;
  private TextView mLoadingAdSkipBtn;
  private RelativeLayout mRightContainer;
  private Handler mUiHandler;
  private int showSkipTime = this.countdownTime - QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_skip_time", 1);
  
  public MiniLoadingAdLayout(Context paramContext)
  {
    super(paramContext);
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_auto_download", 0) == 1) {}
    for (;;)
    {
      this.autoDownload = bool;
      initUI();
      return;
      bool = false;
    }
  }
  
  public MiniLoadingAdLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_auto_download", 0) == 1) {}
    for (;;)
    {
      this.autoDownload = bool;
      initUI();
      return;
      bool = false;
    }
  }
  
  public MiniLoadingAdLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_auto_download", 0) == 1) {}
    for (;;)
    {
      this.autoDownload = bool;
      initUI();
      return;
      bool = false;
    }
  }
  
  private void initUI()
  {
    LayoutInflater.from(getContext()).inflate(2131559621, this, true);
    this.mAppLayout = ((RelativeLayout)findViewById(2131371741));
    this.mGameLayout = ((RelativeLayout)findViewById(2131371747));
    this.mRightContainer = ((RelativeLayout)findViewById(2131365356));
    this.mCloseBtn = ((ImageView)findViewById(2131363823));
    this.mCountdownContainer = ((RelativeLayout)findViewById(2131371743));
    this.mCountdownTextView = ((TextView)findViewById(2131370792));
    this.mLoadingAdSkipBtn = ((TextView)findViewById(2131371749));
    this.mDeveloperDescView = ((TextView)findViewById(2131365801));
    this.mAppNameView = ((TextView)findViewById(2131371742));
    this.mGameNameView = ((TextView)findViewById(2131371748));
    this.mAppLogoView = ((ImageView)findViewById(2131371740));
    this.mGameLogoView = ((ImageView)findViewById(2131371745));
    this.mLoadingAdImgView = ((ImageView)findViewById(2131370793));
  }
  
  private void negativeReport()
  {
    if ((this.mAdInfo != null) && (this.mAdInfo.info != null) && (this.mAdInfo.info.report_info != null) && (this.mAdInfo.info.report_info.negative_feedback_url != null)) {
      reportToGdt(this.mAdInfo.info.report_info.negative_feedback_url.get(), System.currentTimeMillis());
    }
  }
  
  private void reportToGdt(String paramString, long paramLong)
  {
    QLog.i("MiniLoadingAdLayout", 1, "yuki reportToGdt LoadingAd reportUrl = " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString))) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(new MiniLoadingAdLayout.5(this, paramString));
  }
  
  private void startCountDown(OnDismissListener paramOnDismissListener)
  {
    this.mUiHandler = new Handler(Looper.getMainLooper());
    this.mCountdownRunnable = new MiniLoadingAdLayout.4(this, paramOnDismissListener);
    this.mUiHandler.postDelayed(this.mCountdownRunnable, 1000L);
  }
  
  public void dismiss(boolean paramBoolean, OnDismissListener paramOnDismissListener)
  {
    setVisibility(8);
    if (paramBoolean) {
      negativeReport();
    }
    this.mUiHandler.removeCallbacks(this.mCountdownRunnable);
    if (paramOnDismissListener != null) {
      paramOnDismissListener.onDismiss();
    }
  }
  
  public void setupUI(MiniAppConfig paramMiniAppConfig, boolean paramBoolean, String paramString, GdtAd paramGdtAd)
  {
    int j = 8;
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramString)) || (paramGdtAd == null)) {
      return;
    }
    this.mAdInfo = paramGdtAd;
    this.mLoadingAdImgView.setImageDrawable(Drawable.createFromPath(paramString));
    String str1 = paramMiniAppConfig.config.name;
    String str2 = URLDecoder.decode(paramMiniAppConfig.config.iconUrl);
    paramString = this.mGameLayout;
    int i;
    label97:
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 0;
      paramString.setVisibility(i);
      paramString = this.mAppLayout;
      if (!paramBoolean) {
        break label370;
      }
      i = j;
      paramString.setVisibility(i);
      this.mCountdownTextView.setText(this.countdownTime + "秒");
      paramString = paramMiniAppConfig.config.developerDesc;
      paramMiniAppConfig = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramMiniAppConfig = acfp.m(2131695904);
      }
      this.mDeveloperDescView.setText(acfp.m(2131706710) + paramMiniAppConfig + acfp.m(2131706709));
      localLayoutParams = (RelativeLayout.LayoutParams)this.mCountdownContainer.getLayoutParams();
      paramMiniAppConfig = (RelativeLayout.LayoutParams)this.mRightContainer.getLayoutParams();
      if (!paramBoolean) {
        break label406;
      }
      if (!ayxa.isLiuHaiUseValid()) {
        break label376;
      }
      i = ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), 10.0F);
      label249:
      localLayoutParams.topMargin = i;
      if (!ayxa.isLiuHaiUseValid()) {
        break label391;
      }
      i = ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), 10.0F);
      label282:
      paramMiniAppConfig.topMargin = i;
      paramString = this.mGameNameView;
    }
    for (paramMiniAppConfig = this.mGameLogoView;; paramMiniAppConfig = this.mAppLogoView)
    {
      this.mCountdownContainer.setLayoutParams(localLayoutParams);
      paramString.setText(str1);
      paramMiniAppConfig.setImageDrawable(MiniAppUtils.getIcon(getContext(), str2, true, 10));
      this.mLoadingAdImgView.setOnClickListener(new MiniLoadingAdLayout.1(this, paramGdtAd));
      this.mCloseBtn.setOnClickListener(new MiniLoadingAdLayout.2(this, paramBoolean));
      return;
      i = 8;
      break;
      label370:
      i = 0;
      break label97;
      label376:
      i = DisplayUtil.dip2px(getContext(), 10.0F);
      break label249;
      label391:
      i = DisplayUtil.dip2px(getContext(), 10.0F);
      break label282;
      label406:
      localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), 10.0F));
      paramMiniAppConfig.topMargin = (ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), 10.0F));
      paramString = this.mAppNameView;
    }
  }
  
  public void show(OnDismissListener paramOnDismissListener)
  {
    setVisibility(0);
    startCountDown(paramOnDismissListener);
    if ((this.mAdInfo != null) && (this.mAdInfo.info != null) && (this.mAdInfo.info.report_info != null) && (this.mAdInfo.info.report_info.exposure_url != null)) {
      reportToGdt(this.mAdInfo.info.report_info.exposure_url.get(), System.currentTimeMillis());
    }
    this.mLoadingAdSkipBtn.setOnClickListener(new MiniLoadingAdLayout.3(this, paramOnDismissListener));
  }
  
  public static abstract interface OnDismissListener
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout
 * JD-Core Version:    0.7.0.1
 */