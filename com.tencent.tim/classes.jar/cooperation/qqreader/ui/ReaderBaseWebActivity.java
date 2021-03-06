package cooperation.qqreader.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import avmr;
import avmw;
import avna;
import avno;
import avoc;
import avoh;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import cooperation.qqreader.host.ChannelIdHelper;
import cooperation.qqreader.utils.QRDebugEnvUrlUtils;

public class ReaderBaseWebActivity
  extends QQBrowserActivity
{
  private static boolean dnE;
  private avna b;
  
  private void initData()
  {
    if (!dnE)
    {
      dnE = true;
      avoh.cH(this);
      ChannelIdHelper.initChannelId(getIntent());
      if ((!avoh.dnI) && (!"Meizu_M040".equals(Build.MANUFACTURER + "_" + Build.MODEL)))
      {
        avoc.i("WebLog_QQBrowserActivity", "HardAcc true");
        getWindow().addFlags(16777216);
      }
      if (QRDebugEnvUrlUtils.isDebugEnv()) {
        QRDebugEnvUrlUtils.initTestEnv(this);
      }
      avoh.gt(this);
    }
  }
  
  @Nullable
  public avna a(TouchWebView paramTouchWebView)
  {
    if ((this.b == null) && (paramTouchWebView != null) && (paramTouchWebView.getPluginEngine() != null))
    {
      paramTouchWebView = paramTouchWebView.getPluginEngine();
      if (paramTouchWebView != null)
      {
        paramTouchWebView = paramTouchWebView.a(207, true);
        if ((paramTouchWebView instanceof avna)) {
          this.b = ((avna)paramTouchWebView);
        }
      }
    }
    return this.b;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    bSL();
    initData();
    if (!avmr.da())
    {
      paramBundle = new Intent(this, ForceUserUpdateActivity.class);
      paramBundle.putExtra("origin_intent", getIntent());
      paramBundle.putExtra("key_click_leba_start_time", getIntent().getLongExtra("key_click_leba_start_time", 0L));
      startActivity(paramBundle);
      finish();
      return true;
    }
    super.doOnCreate(paramBundle);
    new avmw(this).eAW();
    return true;
  }
  
  protected void ek(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      avoc.e("WebLog_QQBrowserActivity", "[putReaderExtra] intent = null");
      return;
    }
    paramIntent.putExtra("fragmentStyle", 4);
    paramIntent.putExtra("tabBarStyle", 2);
    paramIntent.putExtra("titleBarStyle", 3);
    paramIntent.putExtra("hide_more_button", true);
    paramIntent.putExtra("isScreenOrientationPortrait", true);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ek(getIntent());
    avno.S(this, true);
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderBaseWebActivity
 * JD-Core Version:    0.7.0.1
 */