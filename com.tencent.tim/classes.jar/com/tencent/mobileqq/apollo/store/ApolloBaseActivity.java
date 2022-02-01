package com.tencent.mobileqq.apollo.store;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import aqiw;
import arbt;
import arbz;
import ardm.m;
import ardm.o;
import ardm.q;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import stw;

public class ApolloBaseActivity
  extends AbsBaseWebViewActivity
  implements ardm.m, ardm.o, ardm.q
{
  private static int crs;
  private SharedPreferences G;
  protected String YP;
  protected TouchWebView c;
  protected long mClickTime;
  protected int mCurrentStep;
  protected long mCurrentStepTime;
  private boolean mFirstRequest = true;
  private boolean mIsFirstOnPageStart = true;
  private boolean mIsWebViewCache;
  private stw mOfflinePlugin;
  protected long mOnCreateMilliTimeStamp;
  private boolean mReported;
  private long mStartLoadUrlMilliTimeStamp;
  protected long mTimeBeforeLoadUrl;
  protected long onCreateTime;
  
  private void cEE()
  {
    if (this.mReported) {}
    for (;;)
    {
      return;
      this.mReported = true;
      try
      {
        i = aqiw.getSystemNetwork(getApplicationContext());
        switch (i)
        {
        default: 
          CharSequence localCharSequence = null;
          i = crs;
          if (TextUtils.isEmpty(localCharSequence)) {
            continue;
          }
          if (this.G == null) {
            this.G = getSharedPreferences("apollo_WebView_Report_Step", 0);
          }
          ThreadManager.post(new ApolloBaseActivity.1(this, localCharSequence, i), 5, null, false);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i = 0;
          continue;
          String str = "2G";
          continue;
          str = "3G";
          continue;
          str = "4G";
          continue;
          str = "wifi";
        }
      }
    }
  }
  
  private void checkOfflinePlugin()
  {
    if ((this.mOfflinePlugin == null) && (this.c != null))
    {
      Object localObject = this.c.getPluginEngine();
      if (localObject != null)
      {
        localObject = ((WebViewPluginEngine)localObject).b("offline");
        if ((localObject != null) && ((localObject instanceof stw))) {
          this.mOfflinePlugin = ((stw)localObject);
        }
      }
    }
  }
  
  public void HY(int paramInt)
  {
    this.mCurrentStep = paramInt;
  }
  
  public void QK() {}
  
  public void Qq() {}
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    cEE();
    crs -= 1;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    resetTimer(paramIntent);
    this.mFirstRequest = false;
  }
  
  public void ff(boolean paramBoolean) {}
  
  public void gY(long paramLong)
  {
    this.mCurrentStepTime = paramLong;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBaseActivity", 2, "mClickTime->" + this.mClickTime + "mCurrentStepTime->" + this.mCurrentStepTime + " mCurrentStep->" + this.mCurrentStep);
    }
  }
  
  public String getCurrentUrl()
  {
    Object localObject2 = this.YP;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.c != null) {
        localObject1 = this.c.getUrl();
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "";
    }
    return localObject2;
  }
  
  public long getDetect302Time()
  {
    return 0L;
  }
  
  public boolean getIsReloadUrl()
  {
    return false;
  }
  
  public long getOpenUrlAfterCheckOfflineTime()
  {
    checkOfflinePlugin();
    if (this.mOfflinePlugin != null) {
      return this.mOfflinePlugin.Du;
    }
    return 0L;
  }
  
  public long getReadIndexFromOfflineTime()
  {
    checkOfflinePlugin();
    if (this.mOfflinePlugin != null) {
      return this.mOfflinePlugin.Dv;
    }
    return 0L;
  }
  
  public CustomWebView getWebView()
  {
    return this.c;
  }
  
  public JSONObject getX5Performance()
  {
    return null;
  }
  
  public long getgetWebViewTime()
  {
    return 0L;
  }
  
  public long getinitBrowserTime()
  {
    return 0L;
  }
  
  public long getinitTBSTime()
  {
    return 0L;
  }
  
  public long getinitTime()
  {
    return 0L;
  }
  
  public boolean getisWebViewCache()
  {
    return this.mIsWebViewCache;
  }
  
  public long getmClickTime()
  {
    return this.mClickTime;
  }
  
  public long getmOnCreateMilliTimeStamp()
  {
    return this.mOnCreateMilliTimeStamp;
  }
  
  public boolean getmPerfFirstLoadTag()
  {
    return this.mFirstRequest;
  }
  
  public long getmStartLoadUrlMilliTimeStamp()
  {
    return this.mStartLoadUrlMilliTimeStamp;
  }
  
  public long getmTimeBeforeLoadUrl()
  {
    return this.mTimeBeforeLoadUrl;
  }
  
  public long getonCreateTime()
  {
    return this.onCreateTime;
  }
  
  public long getpluginFinished()
  {
    return 0L;
  }
  
  public long getviewInflateTime()
  {
    return 0L;
  }
  
  public boolean isMainPageUseLocalFile()
  {
    checkOfflinePlugin();
    if (this.mOfflinePlugin != null) {
      return this.mOfflinePlugin.aNf;
    }
    return false;
  }
  
  public boolean mc()
  {
    return this.mIsResume;
  }
  
  public boolean onBackEvent()
  {
    cEE();
    return super.onBackEvent();
  }
  
  @TargetApi(14)
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    if (WebAccelerateHelper.isWebViewCache) {
      this.mIsWebViewCache = true;
    }
    this.mCurrentStep = 1;
    resetTimer(getIntent());
    super.onCreate(paramBundle);
    crs += 1;
    if ((this.c != null) && (Build.VERSION.SDK_INT >= 14) && (arbt.hq.length >= 1))
    {
      int i = arbt.hq[1];
      paramBundle = this.c.getSettings();
      if (paramBundle != null) {
        paramBundle.setTextZoom(i);
      }
    }
    if ((this.a != null) && (this.mRuntime != null) && (this.mRuntime.getLongAccountUin() != 0L) && (arbz.mSampleRate != 0))
    {
      paramBundle = this.a;
      if (this.mRuntime.getLongAccountUin() % arbz.mSampleRate != 6L) {
        break label147;
      }
    }
    for (;;)
    {
      paramBundle.cXQ = bool;
      return;
      label147:
      bool = false;
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((!"about:blank".equalsIgnoreCase(paramString)) && (this.mCurrentStep == 2))
    {
      this.mCurrentStep = 8;
      this.mCurrentStepTime = System.currentTimeMillis();
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (!this.mIsFirstOnPageStart)
    {
      this.mFirstRequest = false;
      resetTimer(null);
    }
    if (this.mIsFirstOnPageStart)
    {
      this.mIsFirstOnPageStart = false;
      this.mStartLoadUrlMilliTimeStamp = System.currentTimeMillis();
    }
    if (!"about:blank".equalsIgnoreCase(paramString))
    {
      this.mCurrentStep = 2;
      this.mCurrentStepTime = System.currentTimeMillis();
    }
  }
  
  public void resetTimer(Intent paramIntent)
  {
    long l = System.currentTimeMillis();
    this.mOnCreateMilliTimeStamp = l;
    this.mCurrentStepTime = l;
    if (paramIntent != null) {}
    for (this.mClickTime = paramIntent.getLongExtra("extra_key_click_time", this.mOnCreateMilliTimeStamp);; this.mClickTime = System.currentTimeMillis())
    {
      this.mStartLoadUrlMilliTimeStamp = System.currentTimeMillis();
      this.mTimeBeforeLoadUrl = System.currentTimeMillis();
      return;
    }
  }
  
  public void setX5Performance(JSONObject paramJSONObject) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      this.YP = paramString;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBaseActivity", 2, "mCurrentUrl->" + this.YP);
      }
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
  
  public int zP()
  {
    return this.mCurrentStep;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBaseActivity
 * JD-Core Version:    0.7.0.1
 */