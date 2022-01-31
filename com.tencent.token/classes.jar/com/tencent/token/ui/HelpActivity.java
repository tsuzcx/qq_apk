package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;

public class HelpActivity
  extends EmbedWebBaseActivity
{
  public static final int H5_QQ_FRAUD = 0;
  public static final String H5_SCENE = "h5_scene";
  private int mH5Scene;
  private Handler mHandler = new lb(this);
  private boolean mNeedLoginSig = true;
  private String mTitle;
  private String mTitleBtn;
  private String mUrl;
  
  private void loadUrl(String paramString)
  {
    if (this.mWebView != null)
    {
      if (paramString.indexOf("kf.qq.com") != -1) {
        this.mWebView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 4.4; Nexus 4 Build/KRT16H)");
      }
      this.mWebView.loadUrl(this.mUrl);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    paramBundle = getIntent();
    this.mUrl = paramBundle.getStringExtra("help_url");
    this.mTitle = paramBundle.getStringExtra("help_title");
    this.mTitleBtn = paramBundle.getStringExtra("help_title_btn");
    this.mDynamicTitle = paramBundle.getBooleanExtra("help_dynamic_title", false);
    this.mH5Scene = paramBundle.getIntExtra("h5_scene", -1);
    this.mNeedLoginSig = paramBundle.getBooleanExtra("help_url_need_login_sig", true);
    if (this.mUrl == null) {
      this.mUrl = getString(2131231478);
    }
    h.a("needloginsig: " + this.mNeedLoginSig);
    paramBundle = do.a().e();
    if ((paramBundle != null) && (this.mUrl.contains("qq.com")) && (this.mNeedLoginSig))
    {
      cp.a(RqdApplication.l()).a("" + paramBundle.mRealUin, this.mHandler, 523005419L, 32);
      if (this.mH5Scene == 0)
      {
        if (this.mTitleBar != null) {
          this.mTitleBar.setBackgroundColor(getResources().getColor(2131492887));
        }
        if (this.mTitleDivider != null) {
          this.mTitleDivider.setVisibility(8);
        }
        if (this.mTitleText != null) {
          this.mTitleText.setTextColor(getResources().getColor(2131492933));
        }
        if (this.mBackArrowImg != null) {
          this.mBackArrowImg.setImageResource(2130837617);
        }
        setBackTextColor(getResources().getColor(2131492933));
      }
      if (this.mTitle == null) {
        break label375;
      }
      setTitle(this.mTitle);
    }
    for (;;)
    {
      if ((this.mTitleBtn != null) && (this.mTitleBtn.length() > 0))
      {
        paramBundle = getRightTitleButton();
        paramBundle.setVisibility(0);
        paramBundle.setText(this.mTitleBtn);
        paramBundle.setTextColor(getResources().getColor(2131492905));
        paramBundle.setOnClickListener(new lc(this));
      }
      return;
      loadUrl(this.mUrl);
      break;
      label375:
      setTitle(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.HelpActivity
 * JD-Core Version:    0.7.0.1
 */