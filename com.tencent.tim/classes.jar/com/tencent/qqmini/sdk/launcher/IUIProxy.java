package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

public abstract interface IUIProxy
  extends IMiniLifecycle
{
  public static final String KEY_APPID = "KEY_APPID";
  public static final String KEY_APPINFO = "KEY_APPINFO";
  public static final String KEY_ASSET_PATH = "KEY_ASSET_PATH";
  public static final String KEY_BADGE_COUNT = "KEY_BADGE_COUNT";
  public static final String KEY_LOGININFO = "KEY_LOGININFO";
  public static final String KEY_RECEIVER = "receiver";
  
  public abstract boolean doDispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract boolean onBackPressed(Activity paramActivity);
  
  public abstract void onRefreshMiniBadge(Activity paramActivity, Bundle paramBundle);
  
  public abstract void onRequestPermissionsResult(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.IUIProxy
 * JD-Core Version:    0.7.0.1
 */