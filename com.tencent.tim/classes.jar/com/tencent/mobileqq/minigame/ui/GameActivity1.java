package com.tencent.mobileqq.minigame.ui;

import aeay;
import aeee;
import aeeg;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import arlc;
import asuh.a;
import asvm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.ui.MiniAIOEntryView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONObject;
import tlo;
import tlo.a;

public class GameActivity1
  extends BaseActivity
{
  private asuh.a mAddColorSingListener;
  protected aeay mColorNoteController;
  private aeeg mColorNoteServiceListenr;
  private RelativeLayout mRoot;
  private IUIProxy mUIProxy;
  private MiniAIOEntryView miniAIOEntryView;
  
  private void initUIProxy(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QMLog.e("qqBaseActivity", "Failed to initUIProxy, intent is null");
      return;
    }
    paramIntent = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
    if (paramIntent != null) {
      ThreadManagerV2.excute(new GameActivity1.5(this), 16, null, true);
    }
    this.mUIProxy = AppLoaderFactory.g().getAppUIProxy(paramIntent);
  }
  
  /* Error */
  private static byte[] packMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 91	asvo:a	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   6: astore_2
    //   7: invokestatic 97	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: iconst_0
    //   15: invokevirtual 101	android/os/Parcel:setDataPosition	(I)V
    //   18: aload_0
    //   19: astore_1
    //   20: aload_0
    //   21: aload_2
    //   22: getfield 107	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   25: iconst_0
    //   26: invokevirtual 111	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   29: aload_0
    //   30: astore_1
    //   31: aload_0
    //   32: invokevirtual 115	android/os/Parcel:marshall	()[B
    //   35: astore_2
    //   36: aload_2
    //   37: astore_1
    //   38: aload_0
    //   39: ifnull +9 -> 48
    //   42: aload_0
    //   43: invokevirtual 118	android/os/Parcel:recycle	()V
    //   46: aload_2
    //   47: astore_1
    //   48: aload_1
    //   49: areturn
    //   50: astore_2
    //   51: aconst_null
    //   52: astore_0
    //   53: aload_0
    //   54: astore_1
    //   55: ldc 42
    //   57: iconst_1
    //   58: new 120	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   65: ldc 123
    //   67: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_2
    //   71: invokestatic 133	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   74: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 142	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_3
    //   84: astore_1
    //   85: aload_0
    //   86: ifnull -38 -> 48
    //   89: aload_0
    //   90: invokevirtual 118	android/os/Parcel:recycle	()V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 118	android/os/Parcel:recycle	()V
    //   106: aload_0
    //   107: athrow
    //   108: astore_0
    //   109: goto -11 -> 98
    //   112: astore_2
    //   113: goto -60 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramMiniAppInfo	MiniAppInfo
    //   12	91	1	localObject1	Object
    //   6	41	2	localObject2	Object
    //   50	21	2	localThrowable1	Throwable
    //   112	1	2	localThrowable2	Throwable
    //   1	83	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	11	50	java/lang/Throwable
    //   7	11	95	finally
    //   13	18	108	finally
    //   20	29	108	finally
    //   31	36	108	finally
    //   55	83	108	finally
    //   13	18	112	java/lang/Throwable
    //   20	29	112	java/lang/Throwable
    //   31	36	112	java/lang/Throwable
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mUIProxy != null) {
      this.mUIProxy.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.mUIProxy != null) {}
    for (boolean bool = this.mUIProxy.onBackPressed(this);; bool = false)
    {
      if (!bool) {
        super.doOnBackPressed();
      }
      return;
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    QLog.d("qqBaseActivity", 1, "--onConfigurationChanged-- screenWidthDp=" + paramConfiguration.screenWidthDp + ", screenHeightDp=" + paramConfiguration.screenHeightDp);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    MiniSDK.init(getApplicationContext());
    boolean bool;
    try
    {
      super.getIntent().putExtra("fling_action_key", 0);
      this.mNeedStatusTrans = false;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        DisplayUtil.setActivityTransparent(this);
        bool = super.doOnCreate(paramBundle);
        RelativeLayout localRelativeLayout = new RelativeLayout(this);
        this.mRoot = localRelativeLayout;
        setContentView(localRelativeLayout);
        localFrameLayout = new FrameLayout(this);
        localRelativeLayout.addView(localFrameLayout, new RelativeLayout.LayoutParams(-1, -1));
        asvm.registerModule();
        initUIProxy(getIntent());
        if (this.mUIProxy == null)
        {
          QMLog.e("qqBaseActivity", "Failed to start GameActivity, UIProxy is null!");
          finish();
          return false;
          localThrowable1 = localThrowable1;
          QLog.e("qqBaseActivity", 1, "[MiniEng]禁用右滑关闭失败:" + localThrowable1.getMessage());
        }
      }
      catch (Throwable localThrowable2)
      {
        FrameLayout localFrameLayout;
        for (;;)
        {
          QLog.e("qqBaseActivity", 1, "setActivityTransparent fail:" + localThrowable2.getMessage());
        }
        this.mUIProxy.onAttachActivity(this, paramBundle, localFrameLayout);
        this.mUIProxy.onIntentUpdate(getIntent());
        paramBundle = (MiniAppInfo)getIntent().getParcelableExtra("KEY_APPINFO");
        this.mColorNoteController = new aeay(this, false, true);
        this.mColorNoteController.attachToActivity(this);
        this.mColorNoteController.setServiceInfo(new GameActivity1.1(this, paramBundle));
        this.mColorNoteController.a(new GameActivity1.2(this));
        this.mColorNoteController.setOnColorNoteCurdListener(new GameActivity1.3(this));
        this.mColorNoteServiceListenr = new GameActivity1.4(this);
        this.mColorNoteController.a(this.mColorNoteServiceListenr);
        tlo.a().a(this, new tlo.a());
        getSharedPreferences("sdk_conf", 4).edit().putInt("usersdk", 1).apply();
      }
    }
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onDestroy();
    }
    if (this.mUIProxy != null) {
      this.mUIProxy.onDetachActivity(this);
    }
    asvm.unRegisterModule();
    QLog.i("qqBaseActivity", 1, "[MiniEng]doOnDestroy " + this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.mUIProxy != null) {}
      for (boolean bool = this.mUIProxy.onBackPressed(this); bool; bool = false) {
        return true;
      }
      super.doOnBackPressed();
      return false;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    QMLog.i("qqBaseActivity", "--doOnNewIntent");
    super.doOnNewIntent(paramIntent);
    initUIProxy(paramIntent);
    if (this.mUIProxy == null)
    {
      QMLog.e("qqBaseActivity", "Failed to start GameActivity, UIProxy is null!");
      finish();
      return;
    }
    this.mUIProxy.onIntentUpdate(paramIntent);
  }
  
  public void doOnPause()
  {
    QMLog.i("qqBaseActivity", "doOnPause ");
    super.doOnPause();
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniPause();
    }
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onPause();
    }
    aeee.e(this, 2, true);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniResume();
    }
    arlc.sendWindowClosedBroadcast(this);
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onResume();
    }
    aeee.e(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    QMLog.i("qqBaseActivity", "doOnStart game");
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniStart();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    ThreadManagerV2.excute(new GameActivity1.6(this), 16, null, true);
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniStop();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    setActivityFullScreen(this);
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public void doRefreshMiniBadge(Bundle paramBundle)
  {
    super.doRefreshMiniBadge(paramBundle);
    if (this.mUIProxy != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("KEY_APPID", paramBundle.getString("miniAppID"));
      localBundle.putInt("KEY_BADGE_COUNT", paramBundle.getInt("param_proc_badge_count"));
      this.mUIProxy.onRefreshMiniBadge(this, localBundle);
    }
  }
  
  public aeay getColorNoteController()
  {
    return this.mColorNoteController;
  }
  
  public void hideMiniAIOEntrance()
  {
    if (this.miniAIOEntryView != null)
    {
      this.miniAIOEntryView.setVisibility(8);
      this.miniAIOEntryView.onDestroy();
      this.miniAIOEntryView = null;
    }
  }
  
  public void onProcessForeGround(Bundle paramBundle)
  {
    QMLog.i("qqBaseActivity", "onProcessForeGround");
    super.onProcessForeGround(paramBundle);
  }
  
  public void onRefreshMiniBadge(Bundle paramBundle)
  {
    QMLog.i("qqBaseActivity", "onRefreshMiniBadge");
    super.onRefreshMiniBadge(paramBundle);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.mUIProxy != null) {
      this.mUIProxy.onRequestPermissionsResult(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void setColorSignAddListener(asuh.a parama)
  {
    this.mAddColorSingListener = parama;
  }
  
  public boolean showMiniAIOEntrance(JSONObject paramJSONObject)
  {
    int i = -10;
    Object localObject = "";
    int j;
    if (paramJSONObject != null)
    {
      float f = 0.0F;
      if (Build.VERSION.SDK_INT >= 17)
      {
        localObject = new DisplayMetrics();
        ((WindowManager)getSystemService("window")).getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject);
        f = ((DisplayMetrics)localObject).density;
      }
      j = (int)(paramJSONObject.optInt("x", -10) * f + 0.5F);
      i = (int)(f * paramJSONObject.optInt("y", -10) + 0.5F);
    }
    for (paramJSONObject = paramJSONObject.optString("style");; paramJSONObject = (JSONObject)localObject)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = j;
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      if ((j < 0) || (i < 0)) {
        return false;
      }
      if (this.miniAIOEntryView == null)
      {
        this.miniAIOEntryView = new MiniAIOEntryView(this, paramJSONObject);
        this.mRoot.addView(this.miniAIOEntryView, (ViewGroup.LayoutParams)localObject);
      }
      for (;;)
      {
        return true;
        this.miniAIOEntryView.setMiniAIOStyle(paramJSONObject);
        this.miniAIOEntryView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.mRoot.requestLayout();
      }
      j = -10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1
 * JD-Core Version:    0.7.0.1
 */