package com.tencent.qqmail.activity.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.ViewFlipper;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.template.Template;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.QMWebView;
import moai.oss.KvHelper;

public class SyncErrorActivity
  extends BaseActivityEx
{
  public static final String EXTRA_ERROR_CODE = "extra_error_code";
  private static final String TAG = "SyncErrorActivity";
  private QMBaseView baseView;
  private int mErrorCode;
  private QMTopBar topBar;
  private ViewFlipper viewFlipper;
  private WebView webView;
  
  public static Intent createIntent(Context paramContext, int paramInt)
  {
    paramContext = new Intent(paramContext, SyncErrorActivity.class);
    paramContext.putExtra("extra_error_code", paramInt);
    return paramContext;
  }
  
  private int getInitialScale()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay();
    switch (localDisplayMetrics.densityDpi)
    {
    }
    return 150;
  }
  
  private void initTopBar()
  {
    this.topBar = getTopBar();
    this.topBar.setButtonLeftBack();
    this.topBar.setButtonLeftOnclickListener(new SyncErrorActivity.1(this));
  }
  
  private void initWebView()
  {
    this.webView = new QMWebView(getActivity());
    QMUIHelper.setZoomControlGone(this.webView);
    this.webView.setHorizontalScrollBarEnabled(true);
    this.webView.setVisibility(0);
    this.webView.getSettings().setAllowFileAccess(true);
    this.webView.getSettings().setLoadsImagesAutomatically(true);
    this.webView.getSettings().setSavePassword(false);
    this.webView.getSettings().setSaveFormData(false);
    this.webView.getSettings().setJavaScriptEnabled(false);
    this.webView.getSettings().setSupportZoom(true);
    this.webView.getSettings().setBuiltInZoomControls(true);
    this.webView.getSettings().setAppCacheEnabled(false);
    this.webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    this.webView.getSettings().setUseWideViewPort(true);
    this.webView.getSettings().setDefaultTextEncodingName("UTF-8");
    this.webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    this.webView.setInitialScale(getInitialScale());
    if (this.webView.getParent() == null) {
      this.viewFlipper.addView(this.webView, 0);
    }
    this.viewFlipper.setDisplayedChild(0);
    String str;
    if (this.mErrorCode == 1)
    {
      str = Template.CONTENT_HTML_SYNC_ERROR_WITHOUT_NETWORK;
      KvHelper.syncWithoutNetworkClick(new double[0]);
    }
    for (;;)
    {
      str = Template.getTemplate(this, str);
      this.webView.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
      return;
      if (this.mErrorCode == 2)
      {
        str = Template.CONTENT_HTML_SYNC_ERROR_NETWORK_UNAVAILABLE;
        KvHelper.syncWithUnavailableNetworkClick(new double[0]);
      }
      else if (this.mErrorCode == 4)
      {
        str = Template.CONTENT_HTML_SYNC_ERROR_SERVER_ERROR;
        KvHelper.syncServerErrorClick(new double[0]);
      }
      else
      {
        QMLog.log(6, "SyncErrorActivity", "Unrecognized errorCode:" + this.mErrorCode);
        str = Template.CONTENT_HTML_SYNC_ERROR_SERVER_ERROR;
      }
    }
  }
  
  public void initDataSource()
  {
    this.mErrorCode = getIntent().getIntExtra("extra_error_code", 0);
  }
  
  public void initDom()
  {
    initTopBar();
    this.viewFlipper = ((ViewFlipper)findViewById(2131381892));
    this.viewFlipper.setBackgroundResource(2131167682);
    initWebView();
  }
  
  public void initUI()
  {
    this.baseView = initBaseView(this, 2131558523);
    setContentView(this.baseView);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SyncErrorActivity
 * JD-Core Version:    0.7.0.1
 */