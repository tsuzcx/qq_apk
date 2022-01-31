package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebView;
import com.tencent.token.global.b;
import com.tencent.token.global.e;

public class FindPasswdH5Activity
  extends EmbedWebBaseActivity
{
  private static final int EVENT_DOBIND = -100;
  private String fsig;
  private Long real_uin;
  private int source_id;
  String url;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    paramBundle = getIntent().getStringExtra("captcha_sig");
    this.real_uin = Long.valueOf(getIntent().getLongExtra("real_uin", 0L));
    this.source_id = getIntent().getIntExtra("source_id", 0);
    e.a("captcha_sig=" + paramBundle);
    switch (b.a())
    {
    default: 
      this.mWebView.loadUrl(getResources().getString(2131361794) + "&key=" + paramBundle);
      return;
    case 0: 
      this.mWebView.loadUrl(getResources().getString(2131361795) + "&key=" + paramBundle);
      return;
    case 1: 
      this.mWebView.loadUrl(getResources().getString(2131361794) + "&key=" + paramBundle);
      return;
    case 2: 
      this.mWebView.loadUrl(getResources().getString(2131361796) + "&key=" + paramBundle);
      return;
    }
    this.mWebView.loadUrl(getResources().getString(2131361797) + "&key=" + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FindPasswdH5Activity
 * JD-Core Version:    0.7.0.1
 */