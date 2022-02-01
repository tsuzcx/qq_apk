package com.tencent.mobileqq.activity;

import affr;
import afgb;
import afgf;
import afgf.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import anot;
import aqha;
import aqju;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import uws;
import uwt;
import uwu;
import zdf;

public class FavEmosmManageActivity
  extends IphoneTitleBarActivity
  implements afgf.b
{
  private affr jdField_a_of_type_Affr;
  private afgf jdField_a_of_type_Afgf;
  private zdf jdField_a_of_type_Zdf;
  BroadcastReceiver ay = new uws(this);
  
  private void bNI()
  {
    Intent localIntent = getIntent();
    if (localIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmManageActivity", 2, "SDKEmotionSettingManager not init ");
      }
    }
    boolean bool;
    do
    {
      return;
      bool = localIntent.getBooleanExtra("key_from_sdk_set_emotion", false);
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmManageActivity", 2, "initParam fromSdkSetAvatar =  " + bool);
      }
    } while (!bool);
    this.jdField_a_of_type_Zdf = new zdf(this);
    this.jdField_a_of_type_Zdf.cA(localIntent);
    this.jdField_a_of_type_Zdf.start();
  }
  
  public static void dd(Context paramContext)
  {
    aqha.a(paramContext, 230, null, paramContext.getString(2131689842), 2131693342, 2131693341, new uwt(paramContext), new uwu()).show();
  }
  
  public void db(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      xe(paramBoolean);
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559285);
    int i = getIntent().getIntExtra("camera_emo_mode", 0);
    this.jdField_a_of_type_Afgf = new afgf(this.app, this);
    this.jdField_a_of_type_Afgf.a(this);
    this.jdField_a_of_type_Affr = afgb.a(this.app, this.jdField_a_of_type_Afgf, i);
    this.jdField_a_of_type_Afgf.a(this.jdField_a_of_type_Affr);
    if (this.ay != null)
    {
      paramBundle = new IntentFilter("com.tencent.mobileqq.action.update.emotiom");
      paramBundle.addAction("com.tencent.mobileqq.action.refresh.emotiom");
      paramBundle.addAction("com.tencent.mobileqq.action.upload.emotiom");
      getApplicationContext().registerReceiver(this.ay, paramBundle);
    }
    bNI();
    this.jdField_a_of_type_Affr.cYP();
    this.jdField_a_of_type_Affr.cYV();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.ay != null)
    {
      getApplicationContext().unregisterReceiver(this.ay);
      this.ay = null;
    }
    if (this.jdField_a_of_type_Affr.bXR) {
      getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
    }
    if (this.jdField_a_of_type_Zdf != null) {
      this.jdField_a_of_type_Zdf.onDestory();
    }
    this.jdField_a_of_type_Affr.cYS();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_Zdf != null)
    {
      this.jdField_a_of_type_Zdf.onNewIntent(paramIntent);
      return;
    }
    setIntent(paramIntent);
    bNI();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Afgf.onPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Afgf.onResume();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
  }
  
  public boolean isWrapContent()
  {
    return super.isWrapContent();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Affr != null) {
      this.jdField_a_of_type_Affr.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    anot.a(this.app, "CliOper", "", "", "ep_mall", "0X80057D4", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Zdf != null) {
      this.jdField_a_of_type_Zdf.caS();
    }
    if (this.jdField_a_of_type_Afgf != null) {
      this.jdField_a_of_type_Afgf.caS();
    }
    return super.onBackEvent();
  }
  
  public void xe(boolean paramBoolean)
  {
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      FlingGestureHandler localFlingGestureHandler = (FlingGestureHandler)this.mFlingHandler;
      if (localFlingGestureHandler.mTopLayout != null) {
        localFlingGestureHandler.mTopLayout.setInterceptScrollLRFlag(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FavEmosmManageActivity
 * JD-Core Version:    0.7.0.1
 */