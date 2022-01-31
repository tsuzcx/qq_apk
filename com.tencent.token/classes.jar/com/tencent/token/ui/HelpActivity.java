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
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.x;

public class HelpActivity
  extends EmbedWebBaseActivity
{
  public static final int H5_QQ_FRAUD = 0;
  public static final String H5_SCENE = "h5_scene";
  private int mH5Scene;
  private Handler mHandler = new ln(this);
  private String mTitle;
  private String mTitleBtn;
  private String mUrl;
  
  private void loadUrl(String paramString)
  {
    if (paramString.indexOf("kf.qq.com") != -1) {
      this.mWebView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 4.4; Nexus 4 Build/KRT16H)");
    }
    this.mWebView.loadUrl(this.mUrl);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    paramBundle = getIntent();
    this.mUrl = paramBundle.getStringExtra("help_url");
    this.mTitle = paramBundle.getStringExtra("help_title");
    this.mTitleBtn = paramBundle.getStringExtra("help_title_btn");
    this.mH5Scene = paramBundle.getIntExtra("h5_scene", -1);
    if (this.mUrl == null) {
      this.mUrl = getString(2131361973);
    }
    paramBundle = ax.a().e();
    if ((paramBundle != null) && (this.mUrl.contains("qq.com"))) {
      x.a(RqdApplication.i()).a("" + paramBundle.mRealUin, this.mHandler);
    }
    for (;;)
    {
      if (this.mH5Scene == 0)
      {
        if (this.mTitleBar != null) {
          this.mTitleBar.setBackgroundColor(getResources().getColor(2131165331));
        }
        if (this.mTitleDivider != null) {
          this.mTitleDivider.setVisibility(8);
        }
        if (this.mTitleText != null) {
          this.mTitleText.setTextColor(getResources().getColor(2131165194));
        }
        if (this.mBackArrowImg != null) {
          this.mBackArrowImg.setImageResource(2130837538);
        }
        setBackTextColor(getResources().getColor(2131165194));
      }
      if (this.mTitle != null) {
        setTitle(this.mTitle);
      }
      if ((this.mTitleBtn != null) && (this.mTitleBtn.length() > 0))
      {
        paramBundle = getRightTitleButton();
        paramBundle.setVisibility(0);
        paramBundle.setText(this.mTitleBtn);
        paramBundle.setTextColor(getResources().getColor(2131165223));
        paramBundle.setOnClickListener(new lo(this));
      }
      return;
      loadUrl(this.mUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.HelpActivity
 * JD-Core Version:    0.7.0.1
 */