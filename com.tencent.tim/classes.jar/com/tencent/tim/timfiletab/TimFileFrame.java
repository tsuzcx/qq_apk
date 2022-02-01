package com.tencent.tim.timfiletab;

import acep;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import aqzs;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.tim.timfiletab.fragment.TimFileWebViewFragment;
import com.tencent.tim.widget.TimFileUploadInfoBar;
import com.tencent.widget.immersive.ImmersiveUtils;

public class TimFileFrame
  extends acep
  implements aqzs
{
  private View KO;
  private View KP;
  private TimFileUploadInfoBar a;
  FrameLayout cs;
  private WebViewFragment e;
  RelativeLayout mRoot;
  public Class<? extends WebViewFragment> s = TimFileWebViewFragment.class;
  
  private WebViewFragment a(String paramString)
  {
    this.e = TimFileWebViewFragment.a(paramString, (FragmentActivity)a(), 2131382159, false, false, "tim_file_web_fragment_desktop");
    return this.e;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return LayoutInflater.from(a()).inflate(2131563188, null);
  }
  
  public WebViewFragment a(Intent paramIntent)
  {
    return null;
  }
  
  public boolean an(boolean paramBoolean)
  {
    return false;
  }
  
  public WebViewFragment c()
  {
    return this.e;
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    CookieSyncManager.createInstance(a());
    CookieManager.getInstance().removeAllCookie();
    if (Build.VERSION.SDK_INT >= 22) {
      CookieManager.getInstance().flush();
    }
    for (;;)
    {
      SwiftBrowserCookieMonster.egU();
      a("https://docs.qq.com/desktop/m/tim-recent/");
      return;
      CookieSyncManager.getInstance().sync();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    WebViewFragment localWebViewFragment = c();
    if (localWebViewFragment != null) {
      localWebViewFragment.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackPressed()
  {
    if ((this.e != null) && (this.e.isVisible())) {
      this.e.biT();
    }
    for (;;)
    {
      return true;
      finish();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mRoot = ((RelativeLayout)findViewById(2131377546));
    this.cs = ((FrameLayout)findViewById(2131382159));
    this.a = ((TimFileUploadInfoBar)findViewById(2131363313));
    this.KO = findViewById(2131367159);
    this.KP = findViewById(2131367160);
    a("https://docs.qq.com/desktop/m/tim-recent/");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume(boolean paramBoolean)
  {
    super.onResume(paramBoolean);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.a(a().getWindow(), true);
    }
    ThreadManagerV2.executeOnSubThread(new TimFileFrame.1(this));
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  @RequiresApi(api=19)
  public void pE(boolean paramBoolean)
  {
    this.a.initData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.timfiletab.TimFileFrame
 * JD-Core Version:    0.7.0.1
 */