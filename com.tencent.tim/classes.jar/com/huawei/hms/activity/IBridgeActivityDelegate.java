package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

public abstract interface IBridgeActivityDelegate
{
  public abstract int getRequestCode();
  
  public abstract void onBridgeActivityCreate(Activity paramActivity);
  
  public abstract void onBridgeActivityDestroy();
  
  public abstract boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onBridgeConfigurationChanged();
  
  public abstract void onKeyUp(int paramInt, KeyEvent paramKeyEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.activity.IBridgeActivityDelegate
 * JD-Core Version:    0.7.0.1
 */