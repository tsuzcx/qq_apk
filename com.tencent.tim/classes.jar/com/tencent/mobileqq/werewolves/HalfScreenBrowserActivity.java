package com.tencent.mobileqq.werewolves;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqfy;
import ardo;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.smtt.sdk.WebView;
import wja;

public class HalfScreenBrowserActivity
  extends AbsBaseWebViewActivity
{
  private static final int eeI = Color.argb(63, 0, 0, 0);
  private ProgressBar as;
  private RelativeLayout mRoot;
  private CustomWebView mWebView;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setImmersiveStatus(0);
    super.doOnCreate(paramBundle);
    this.mRoot = new RelativeLayout(this);
    this.mRoot.setOnClickListener(new ardo(this));
    paramBundle = getIntent().getStringExtra("url");
    FrameLayout localFrameLayout = new FrameLayout(this);
    this.as = new ProgressBar(this);
    this.as.setIndeterminateDrawable(getResources().getDrawable(2130841142));
    Object localObject = new FrameLayout.LayoutParams(wja.dp2px(25.0F, getResources()), wja.dp2px(25.0F, getResources()));
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    localFrameLayout.addView(this.as, (ViewGroup.LayoutParams)localObject);
    int i;
    if (paramBundle.indexOf("https://nearby.qq.com/werewolf/gift.html") >= 0) {
      i = 1;
    }
    for (;;)
    {
      int j;
      if (i != 0)
      {
        j = wja.dp2px(338.0F, getResources());
        localObject = new RelativeLayout.LayoutParams(-1, j);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        this.mRoot.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject);
        this.mWebView = b(localFrameLayout);
        this.mWebView.setVisibility(4);
        setContentView(this.mRoot);
        if (i == 0) {}
      }
      try
      {
        findViewById(2131377361).setVisibility(8);
        label226:
        this.mWebView.loadUrl(paramBundle);
        aqfy.anim(this, false, true);
        return true;
        i = 0;
        continue;
        j = -1;
      }
      catch (Throwable localThrowable)
      {
        break label226;
      }
    }
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    overridePendingTransition(0, 0);
    return bool;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.mWebView.setVisibility(0);
    this.as.setVisibility(8);
    runOnUiThread(new HalfScreenBrowserActivity.2(this));
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.mRoot.setBackgroundColor(eeI);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.HalfScreenBrowserActivity
 * JD-Core Version:    0.7.0.1
 */