package com.tencent.qqmini.sdk.launcher.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

public class MiniActivity
  extends Activity
{
  protected static final String TAG = "MiniActivity";
  private IUIProxy mUIProxy;
  
  private static MiniAppInfo getMiniAppInfoFromIntent(Intent paramIntent)
  {
    try
    {
      paramIntent = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      QMLog.e("MiniActivity", "Failed to getMiniAppInfoFromIntent", paramIntent);
    }
    return null;
  }
  
  private void initUIProxy(Intent paramIntent)
  {
    if (paramIntent == null) {
      QMLog.e("MiniActivity", "Failed to initUIProxy, intent is null");
    }
    for (;;)
    {
      return;
      MiniAppInfo localMiniAppInfo = getMiniAppInfoFromIntent(paramIntent);
      this.mUIProxy = AppLoaderFactory.g().getAppUIProxy(localMiniAppInfo);
      try
      {
        paramIntent = (LoginInfo)paramIntent.getParcelableExtra("KEY_LOGININFO");
        if (paramIntent == null) {
          continue;
        }
        AppLoaderFactory.g().getMiniAppEnv().setLoginInfo(paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          QMLog.i("minisdk-start", "parse loginInfo error", paramIntent);
          paramIntent = null;
        }
      }
    }
  }
  
  public static void setActivityFullScreen(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null) {
        paramActivity.getDecorView().setSystemUiVisibility(23075586);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mUIProxy != null) {
      this.mUIProxy.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (this.mUIProxy != null) {}
    for (boolean bool = this.mUIProxy.onBackPressed(this);; bool = false)
    {
      if ((!bool) && (!moveTaskToBack(false))) {
        finish();
      }
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    QMLog.i("MiniActivity", this + " onCreate(). " + getIntent());
    super.onCreate(paramBundle);
    MiniSDK.init(getApplicationContext());
    Intent localIntent = getIntent();
    Object localObject;
    if (localIntent != null)
    {
      localObject = getMiniAppInfoFromIntent(localIntent);
      if ((localObject == null) || (!((MiniAppInfo)localObject).isEngineTypeMiniGame())) {
        break label138;
      }
      DisplayUtil.setActivityTransparent(this);
    }
    FrameLayout localFrameLayout;
    for (;;)
    {
      localObject = new RelativeLayout(this);
      setContentView((View)localObject);
      localFrameLayout = new FrameLayout(this);
      ((RelativeLayout)localObject).addView(localFrameLayout, new RelativeLayout.LayoutParams(-1, -1));
      initUIProxy(getIntent());
      if (this.mUIProxy != null) {
        break;
      }
      QMLog.e("MiniActivity", "onCreate(). Failed to start MiniActivity, UIProxy is null!");
      finish();
      return;
      label138:
      requestWindowFeature(1);
      getWindow().addFlags(1);
      getWindow().addFlags(67108864);
    }
    this.mUIProxy.onAttachActivity(this, paramBundle, localFrameLayout);
    this.mUIProxy.onIntentUpdate(getIntent());
    QMLog.e("MiniActivity", this + " onCreate(). " + localIntent.getData());
  }
  
  protected void onDestroy()
  {
    if (this.mUIProxy != null) {
      this.mUIProxy.onDetachActivity(this);
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    if (paramInt == 4)
    {
      boolean bool1;
      if (this.mUIProxy != null)
      {
        bool1 = this.mUIProxy.onBackPressed(this);
        if (!bool1) {
          break label39;
        }
        bool1 = true;
      }
      label39:
      do
      {
        return bool1;
        bool1 = false;
        break;
        bool1 = bool2;
      } while (moveTaskToBack(false));
      finish();
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QMLog.i("MiniActivity", this + " onNewIntent(). " + paramIntent);
    initUIProxy(paramIntent);
    if (this.mUIProxy == null)
    {
      QMLog.e("MiniActivity", "onNewIntent(). Failed to start MiniActivity, UIProxy is null!");
      finish();
      return;
    }
    this.mUIProxy.onIntentUpdate(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniPause();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.mUIProxy != null) {
      this.mUIProxy.onRequestPermissionsResult(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniResume();
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniStart();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniStop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    setActivityFullScreen(this);
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ui.MiniActivity
 * JD-Core Version:    0.7.0.1
 */