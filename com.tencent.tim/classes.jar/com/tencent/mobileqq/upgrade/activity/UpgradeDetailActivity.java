package com.tencent.mobileqq.upgrade.activity;

import Override;
import acej;
import acfp;
import aiim;
import aiim.b;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import anot;
import aqap;
import aqap.c;
import aqbm;
import aqha;
import aqju;
import arzk;
import aurf;
import avpw;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.ProtectedWebView;
import protocol.KQQConfig.UpgradeInfo;

@SuppressLint({"SetJavaScriptEnabled"})
public class UpgradeDetailActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, aqap.c
{
  private View IX;
  private aiim jdField_a_of_type_Aiim;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  ProgressBar ao;
  private long asx;
  aurf b;
  private boolean cLv;
  boolean cTx;
  private String csi;
  private String csj;
  WebView mWebView;
  
  private void Sx(boolean paramBoolean)
  {
    Object localObject;
    String str1;
    if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("checkAndStartdownload");
        if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
          break label80;
        }
      }
      label80:
      for (str1 = "null";; str1 = "iIncrementUpgrade==1")
      {
        QLog.d("UpgradeDetailActivity", 2, str1);
        aqap.a().startDownload(false);
        return;
      }
    }
    int i = fa(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.csh);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeDetailActivity", 2, "checkAndStartdownload market supportMarketID:" + i);
    }
    if (i != 0)
    {
      if (paramBoolean) {
        this.b.obtainMessage(100, 0, 0).sendToTarget();
      }
      localObject = aqha.a(this, 230);
      aqbm localaqbm = new aqbm(this, i);
      str1 = "";
      switch (i)
      {
      }
      for (;;)
      {
        String str2 = getString(2131692662, new Object[] { str1 });
        str1 = getString(2131692660, new Object[] { str1 });
        ((aqju)localObject).setMessage(str2);
        ((aqju)localObject).setTitle(2131692664);
        ((aqju)localObject).setNegativeButton(2131692659, localaqbm);
        ((aqju)localObject).setPositiveButton(str1, getResources().getColor(2131165409), localaqbm);
        ((aqju)localObject).show();
        kf(i, 1);
        return;
        str1 = getString(2131692666);
        continue;
        str1 = getString(2131692665);
        continue;
        str1 = getString(2131692663);
        continue;
        str1 = getString(2131692661);
      }
    }
    aqap.a().startDownload(false);
  }
  
  private void Ul(String paramString)
  {
    if ((!getIntent().getBooleanExtra("need_left_back", true)) && (this.leftView != null)) {
      this.leftView.setVisibility(4);
    }
    setTitle(paramString);
    removeWebViewLayerType();
  }
  
  public static void a(Activity paramActivity, UpgradeDetailWrapper paramUpgradeDetailWrapper, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, UpgradeDetailActivity.class);
    localIntent.putExtra("detail_wrapper", paramUpgradeDetailWrapper);
    localIntent.putExtra("is_anim", paramBoolean1);
    localIntent.putExtra("download_right_now", paramBoolean2);
    localIntent.putExtra("need_left_back", paramBoolean3);
    paramActivity.startActivity(localIntent);
    if (paramBoolean1) {
      paramActivity.overridePendingTransition(2130771991, 2130771992);
    }
  }
  
  private boolean aBR()
  {
    boolean bool = false;
    if (this.mWebView.canGoBack()) {
      if (this.IX.getVisibility() == 0) {
        this.IX.setVisibility(8);
      }
    }
    try
    {
      this.mWebView.stopLoading();
      label38:
      this.mWebView.goBack();
      bool = true;
      return bool;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  private void au(Context paramContext, int paramInt)
  {
    Object localObject1;
    Intent localIntent;
    Object localObject4;
    String str;
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
          localObject1 = new Intent();
          ((Intent)localObject1).setData(Uri.parse("vivomarket://details?id=" + "com.tencent.mobileqq" + "&th_name=self_update"));
          ((Intent)localObject1).setPackage("com.bbk.appstore");
          ((Intent)localObject1).setFlags(335544320);
          ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_appstore");
          paramContext.startActivity((Intent)localObject1);
        } while (!QLog.isColorLevel());
        QLog.i("UpgradeDetailActivity", 2, "jumpToPhoneMarketDetailUpdate vivo");
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).setData(Uri.parse("mimarket://details?id=" + "com.tencent.mobileqq" + "&ref=com.tencent.mobileqq_selfupdate&startDownload=true"));
        ((Intent)localObject1).setPackage("com.xiaomi.market");
        ((Intent)localObject1).setFlags(335544320);
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_appstore");
        paramContext.startActivity((Intent)localObject1);
      } while (!QLog.isColorLevel());
      QLog.i("UpgradeDetailActivity", 2, "jumpToPhoneMarketDetailUpdate xiaomi");
      return;
    case 3: 
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + "com.tencent.mobileqq" + "&caller=" + "com.tencent.mobileqq" + "&token=273b98f0a5b2c20d&atd=true&style=0"));
      localObject4 = paramContext.getPackageManager();
      str = "";
    }
    for (;;)
    {
      try
      {
        PackageInfo localPackageInfo = ((PackageManager)localObject4).getPackageInfo("com.oppo.market", 0);
        localObject1 = str;
        if (localPackageInfo != null)
        {
          localObject1 = str;
          if (localPackageInfo.applicationInfo != null)
          {
            localObject1 = str;
            if (localPackageInfo.applicationInfo.enabled) {
              localObject1 = "com.oppo.market";
            }
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localIntent.setPackage((String)localObject1);
          localIntent.setFlags(270532608);
          localIntent.putExtra("big_brother_source_key", "biz_src_jc_appstore");
          paramContext.startActivity(localIntent);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("UpgradeDetailActivity", 2, "jumpToPhoneMarketDetailUpdate oppo,oppopkg:" + (String)localObject1);
        return;
      }
      catch (Throwable localThrowable1) {}
      try
      {
        localObject4 = ((PackageManager)localObject4).getPackageInfo("com.heytap.market", 0);
        localObject2 = str;
        if (localObject4 == null) {
          continue;
        }
        localObject2 = str;
        if (((PackageInfo)localObject4).applicationInfo == null) {
          continue;
        }
        localObject2 = str;
        if (!((PackageInfo)localObject4).applicationInfo.enabled) {
          continue;
        }
        localObject2 = "com.heytap.market";
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        Object localObject3 = str;
      }
      localObject2 = new Intent("android.intent.action.VIEW", Uri.parse("hiapplink://com.huawei.appmarket?appId=C9319&accessID=%2F687abcc2447f49059f0c8873390a1686&caller=" + "com.tencent.mobileqq"));
      ((Intent)localObject2).setPackage("com.huawei.appmarket");
      ((Intent)localObject2).setFlags(335544320);
      ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_appstore");
      paramContext.startActivity((Intent)localObject2);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("UpgradeDetailActivity", 2, "jumpToPhoneMarketDetailUpdate huawei");
      return;
    }
  }
  
  private int fa(String paramString)
  {
    j = 0;
    i = j;
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.i("UpgradeDetailActivity", 2, "supportGoMarketPhoneID,jumpMarketSupportPhone," + paramString + ",manufacture:" + Build.MANUFACTURER);
      }
    }
    for (;;)
    {
      try
      {
        localObject = getPackageManager();
        if ((!paramString.contains("vivo")) || (!Build.MANUFACTURER.equalsIgnoreCase("vivo"))) {
          continue;
        }
        k = ((PackageManager)localObject).getPackageInfo("com.bbk.appstore", 0).versionCode;
        if (QLog.isColorLevel()) {
          QLog.i("UpgradeDetailActivity", 2, "supportGoMarketPhoneID versioncode:" + k);
        }
        i = j;
        if (k >= 3100) {
          i = 1;
        }
      }
      catch (Exception paramString)
      {
        Object localObject;
        boolean bool;
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("UpgradeDetailActivity", 2, "supportGoMarketPhoneID exception:" + paramString.getMessage());
        i = j;
        continue;
        i = j;
        if (!paramString.contains("huawei")) {
          continue;
        }
        i = j;
        if (!Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
          continue;
        }
        int k = ((PackageManager)localObject).getPackageInfo("com.huawei.appmarket", 0).versionCode;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("UpgradeDetailActivity", 2, "supportGoMarketPhoneID versioncode:" + k);
        i = j;
        if (k < 80003300) {
          continue;
        }
        i = 4;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("UpgradeDetailActivity", 2, "supportGoMarketPhoneID returnid:" + i);
      }
      return i;
      if ((paramString.contains("xiaomi")) && (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")))
      {
        i = j;
        if (((PackageManager)localObject).getPackageInfo("com.xiaomi.market", 0) != null) {
          i = 2;
        }
      }
      else
      {
        if (!paramString.contains("oppo")) {
          continue;
        }
        bool = Build.MANUFACTURER.equalsIgnoreCase("oppo");
        if (!bool) {
          continue;
        }
        try
        {
          paramString = ((PackageManager)localObject).getPackageInfo("com.oppo.market", 0);
          i = j;
          if (paramString == null) {
            continue;
          }
          i = j;
          if (paramString.applicationInfo == null) {
            continue;
          }
          i = j;
          if (!paramString.applicationInfo.enabled) {
            continue;
          }
          k = paramString.versionCode;
          if (QLog.isColorLevel()) {
            QLog.i("UpgradeDetailActivity", 2, "supportGoMarketPhoneID oppo market versioncode:" + k);
          }
          i = j;
          if (k <= 6300) {
            continue;
          }
          i = 3;
        }
        catch (Throwable paramString)
        {
          try
          {
            localObject = ((PackageManager)localObject).getPackageInfo("com.heytap.market", 0);
            if (QLog.isColorLevel()) {
              QLog.i("UpgradeDetailActivity", 2, "oppo.market exception:" + paramString.getMessage());
            }
            i = j;
            if (localObject == null) {
              continue;
            }
            i = j;
            if (((PackageInfo)localObject).applicationInfo == null) {
              continue;
            }
            bool = ((PackageInfo)localObject).applicationInfo.enabled;
            i = j;
            if (!bool) {
              continue;
            }
            i = 3;
          }
          catch (Throwable paramString)
          {
            i = j;
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.i("UpgradeDetailActivity", 2, "heytap.market exception:" + paramString.getMessage());
          i = j;
        }
      }
    }
  }
  
  private void initUI()
  {
    this.IX = findViewById(2131380386);
    this.IX.setVisibility(8);
    this.mWebView = ((ProtectedWebView)findViewById(2131380388));
    WebSettings localWebSettings = this.mWebView.getSettings();
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " " + avpw.getQUA());
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setGeolocationEnabled(true);
    localWebSettings.setCacheMode(2);
    this.mWebView.setWebViewClient(new b(null));
    this.mWebView.setWebChromeClient(new a(null));
    this.jdField_a_of_type_Aiim = new aiim();
    this.jdField_a_of_type_Aiim.a(new JsCover(), "qqupgrade");
    this.ao = ((ProgressBar)findViewById(2131380389));
  }
  
  private void kf(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt2 == 1)
            {
              anot.a(null, "dc00898", "", "", "0X800AB96", "0X800AB96", 0, 0, "", "", "", "");
              return;
            }
            if (paramInt2 == 2)
            {
              anot.a(null, "dc00898", "", "", "0X800AB97", "0X800AB97", 0, 0, "", "", "", "");
              return;
            }
          } while (paramInt2 != 3);
          anot.a(null, "dc00898", "", "", "0X800AB98", "0X800AB98", 0, 0, "", "", "", "");
          return;
          if (paramInt2 == 1)
          {
            anot.a(null, "dc00898", "", "", "0X800AB99", "0X800AB99", 0, 0, "", "", "", "");
            return;
          }
          if (paramInt2 == 2)
          {
            anot.a(null, "dc00898", "", "", "0X800AB9A", "0X800AB9A", 0, 0, "", "", "", "");
            return;
          }
        } while (paramInt2 != 3);
        anot.a(null, "dc00898", "", "", "0X800AB9B", "0X800AB9B", 0, 0, "", "", "", "");
        return;
        if (paramInt2 == 1)
        {
          anot.a(null, "dc00898", "", "", "0X800AB9C", "0X800AB9C", 0, 0, "", "", "", "");
          return;
        }
        if (paramInt2 == 2)
        {
          anot.a(null, "dc00898", "", "", "0X800AB9D", "0X800AB9D", 0, 0, "", "", "", "");
          return;
        }
      } while (paramInt2 != 3);
      anot.a(null, "dc00898", "", "", "0X800AB9E", "0X800AB9E", 0, 0, "", "", "", "");
      return;
      if (paramInt2 == 1)
      {
        anot.a(null, "dc00898", "", "", "0X800AB9F", "0X800AB9F", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt2 == 2)
      {
        anot.a(null, "dc00898", "", "", "0X800ABA0", "0X800ABA0", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt2 != 3);
    anot.a(null, "dc00898", "", "", "0X800ABA1", "0X800ABA1", 0, 0, "", "", "", "");
  }
  
  void Sy(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mWebView.clearView();
    }
    this.ao.setVisibility(8);
    this.IX.setVisibility(0);
  }
  
  void Xp(int paramInt)
  {
    if (this.mWebView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeDetailActivity", 2, "invokeDownloadStateToWebView: " + paramInt);
    }
    this.mWebView.loadUrl("javascript:onDownloadStateChanged(" + paramInt + ")");
  }
  
  public void a(int paramInt, aqap paramaqap)
  {
    if (this.cTx) {
      this.b.obtainMessage(100, paramInt, 0).sendToTarget();
    }
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "UpgradeDetailActivity.finish start");
    }
    super.finish();
    if (this.cTx)
    {
      this.cTx = false;
      if (this.b != null)
      {
        this.b.removeMessages(100);
        this.b.removeMessages(101);
      }
      if (this.mWebView == null) {}
    }
    try
    {
      this.mWebView.loadUrl("javascript:onDestroy()");
      label74:
      if (this.cLv) {
        overridePendingTransition(2130771989, 2130771990);
      }
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "UpgradeDetailActivity.finish stop");
      }
      return;
    }
    catch (Exception localException)
    {
      break label74;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {
      Xp(paramMessage.arg1);
    }
    for (;;)
    {
      return true;
      if (paramMessage.what == 101) {
        Sx(false);
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  void loadUrl(String paramString)
  {
    try
    {
      this.mWebView.stopLoading();
      label7:
      this.mWebView.loadUrl(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeDetailActivity", 2, "loadUrl: " + paramString);
      }
      return;
    }
    catch (Exception localException)
    {
      break label7;
    }
  }
  
  public boolean onBackEvent()
  {
    if (aBR()) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = aqap.a().b();
    if ((paramBundle == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType <= 0))
    {
      finish();
      return;
    }
    super.setContentView(2131563285);
    removeWebViewLayerType();
    Intent localIntent = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = ((UpgradeDetailWrapper)localIntent.getParcelableExtra("detail_wrapper"));
    this.cLv = localIntent.getBooleanExtra("is_anim", true);
    aqap.a().a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a != null)
    {
      this.csj = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.csj;
      this.csi = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.csi;
      this.asx = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.asx;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 4)) {
      this.asx = Math.min(this.asx, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.patchsize);
    }
    String str1 = acfp.m(2131716266);
    paramBundle = null;
    String str2;
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL;
      str2 = "fontSetting=" + acej.aV();
      if (!paramBundle.endsWith("?")) {
        break label329;
      }
      paramBundle = paramBundle + str2;
    }
    for (;;)
    {
      this.b = new aurf(this);
      if (localIntent.getBooleanExtra("download_right_now", false)) {
        this.b.sendEmptyMessageAtTime(101, 1500L);
      }
      Ul(str1);
      initUI();
      if (paramBundle != null) {
        loadUrl(paramBundle);
      }
      this.ao.setVisibility(0);
      return;
      label329:
      if (paramBundle.contains("?")) {
        paramBundle = paramBundle + "&" + str2;
      } else {
        paramBundle = paramBundle + "?" + str2;
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.cTx)
    {
      this.cTx = false;
      if (this.b != null)
      {
        this.b.removeMessages(100);
        this.b.removeMessages(101);
      }
      if (this.mWebView == null) {}
    }
    try
    {
      this.mWebView.loadUrl("javascript:onDestroy()");
      label54:
      aqap.a().b(this);
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Aiim.Lf("qqupgrade");
    try
    {
      this.mWebView.stopLoading();
      this.mWebView.clearView();
      try
      {
        label28:
        this.mWebView.destroy();
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label28;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (aBR())) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    arzk.a().cu(this);
    try
    {
      if (this.cTx) {
        Xp(aqap.a().getDownloadState());
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  boolean rf(String paramString)
  {
    return false;
  }
  
  public class JsCover
    extends aiim.b
  {
    protected JsCover() {}
    
    public String getApkName()
    {
      return UpgradeDetailActivity.a(UpgradeDetailActivity.this);
    }
    
    public long getApkSize()
    {
      return UpgradeDetailActivity.a(UpgradeDetailActivity.this);
    }
    
    public String getApkVersion()
    {
      return UpgradeDetailActivity.b(UpgradeDetailActivity.this);
    }
    
    public int getDownloadState()
    {
      return aqap.a().getDownloadState();
    }
    
    public long getUpgradeTime()
    {
      return UpgradeDetailActivity.a(UpgradeDetailActivity.this).a.iNewTimeStamp;
    }
    
    public int installApk()
    {
      aqap.a().ft(UpgradeDetailActivity.this);
      return 0;
    }
    
    public int pauseDownload()
    {
      aqap.a().pauseDownload();
      return 0;
    }
    
    public int resumeDownload()
    {
      if (QLog.isColorLevel()) {
        QLog.d("preLoad_configServlet", 2, "resume download from web, mark it.");
      }
      aqap.a().resumeDownload();
      return 0;
    }
    
    public int startDownload()
    {
      if (QLog.isColorLevel()) {
        QLog.d("preLoad_configServlet", 2, "start download from web, mark it.");
      }
      UpgradeDetailActivity.a(UpgradeDetailActivity.this, true);
      return 0;
    }
    
    public int stopDownload()
    {
      aqap.a().stopDownload();
      return 0;
    }
    
    public int tipsLoadComplete()
    {
      QLog.d("Hyim", 2, "loadTipsComplete");
      UpgradeDetailActivity.this.cTx = true;
      int i = getDownloadState();
      UpgradeDetailActivity.this.a(i, aqap.a());
      return 0;
    }
  }
  
  class a
    extends WebChromeClient
  {
    private a() {}
    
    public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
    {
      super.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
      paramGeolocationPermissionsCallback.invoke(paramString, true, false);
    }
    
    @Override
    public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
    {
      if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
        return true;
      }
      return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
    }
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeDetailActivity", 2, "onProgressChanged: " + paramInt + "%");
      }
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeDetailActivity", 2, "onReceivedTitle:" + paramString);
      }
      UpgradeDetailActivity.this.setTitle(paramString);
    }
  }
  
  class b
    extends WebViewClient
  {
    private b() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeDetailActivity", 2, "onPageFinished: " + paramString);
      }
      UpgradeDetailActivity.this.ao.setVisibility(8);
      super.onPageFinished(paramWebView, paramString);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeDetailActivity", 2, "onPageStarted: " + paramString);
      }
      if (UpgradeDetailActivity.this.rf(paramString)) {
        UpgradeDetailActivity.this.ao.setVisibility(8);
      }
      try
      {
        UpgradeDetailActivity.this.mWebView.stopLoading();
        return;
      }
      catch (Exception paramWebView) {}
      UpgradeDetailActivity.this.ao.setVisibility(0);
      return;
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      UpgradeDetailActivity.this.Sy(true);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeDetailActivity", 2, "shouldOverrideUrlLoading: " + paramString);
      }
      if ((paramString == null) || ("".equals(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString))) {}
      for (;;)
      {
        return true;
        if ((!UpgradeDetailActivity.a(UpgradeDetailActivity.this).b(paramWebView, paramString)) && (!UpgradeDetailActivity.this.rf(paramString))) {
          UpgradeDetailActivity.this.loadUrl(paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity
 * JD-Core Version:    0.7.0.1
 */