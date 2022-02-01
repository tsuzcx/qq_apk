package com.tencent.mobileqq.mini.fake;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.app.IAppUIProxy;

public abstract interface IFakeBrandUI
{
  public abstract boolean doBeforeOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle);
  
  public abstract boolean doDispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract void doOnActivityResult(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void doOnBackPressed(BaseActivity paramBaseActivity, boolean paramBoolean);
  
  public abstract boolean doOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle);
  
  public abstract void doOnDestroy(BaseActivity paramBaseActivity);
  
  public abstract void doOnNewIntent(BaseActivity paramBaseActivity, Intent paramIntent);
  
  public abstract void doOnPause(BaseActivity paramBaseActivity);
  
  public abstract void doOnResume(BaseActivity paramBaseActivity);
  
  public abstract void doOnStart(BaseActivity paramBaseActivity);
  
  public abstract void doOnStop(BaseActivity paramBaseActivity);
  
  public abstract void doRefreshMiniBadge(BaseActivity paramBaseActivity, Bundle paramBundle);
  
  public abstract void finish(BaseActivity paramBaseActivity);
  
  public abstract IAppUIProxy getAppUIProxy();
  
  public abstract boolean isWrapContent(BaseActivity paramBaseActivity);
  
  public abstract boolean moveTaskToBack(BaseActivity paramBaseActivity, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onProcessBackground(BaseActivity paramBaseActivity, Bundle paramBundle);
  
  public abstract void onProcessForeGround(BaseActivity paramBaseActivity, Bundle paramBundle);
  
  public abstract void onRefreshMiniBadge(BaseActivity paramBaseActivity, Bundle paramBundle);
  
  public abstract void setColorNoteWithOutMoveTaskToBackThisTime();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.fake.IFakeBrandUI
 * JD-Core Version:    0.7.0.1
 */