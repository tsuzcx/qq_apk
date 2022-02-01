package com.tencent.mobileqq.activity;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import java.io.File;
import mqq.app.MobileQQ;
import vma;

public class PreloadWebService
  extends Service
{
  private CustomWebView mWebView;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {
      return paramInt1;
    }
    String str3 = paramIntent.getStringExtra("url");
    if (!TextUtils.isEmpty(str3))
    {
      if (this.mWebView == null)
      {
        this.mWebView = new CustomWebView(getBaseContext());
        this.mWebView.setWebViewClient(new vma(this));
        WebSettings localWebSettings = this.mWebView.getSettings();
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setCacheMode(-1);
        localWebSettings.setDatabaseEnabled(true);
        String str4 = MobileQQ.getMobileQQ().getQQProcessName();
        String str2 = "";
        String str1 = str2;
        if (str4 != null)
        {
          int i = str4.lastIndexOf(':');
          str1 = str2;
          if (i > -1) {
            str1 = "_" + str4.substring(i + 1);
          }
        }
        localWebSettings.setDatabasePath(getApplicationContext().getDir("database" + str1, 0).getPath());
        localWebSettings.setAppCachePath(getApplicationContext().getDir("appcache" + str1, 0).getPath());
        localWebSettings.setAppCacheEnabled(true);
      }
      this.mWebView.loadUrl(str3);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadWebService", 2, "preload url:" + str3);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PreloadWebService
 * JD-Core Version:    0.7.0.1
 */