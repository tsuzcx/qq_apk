package com.tencent.qqmail.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.qqmail.utilities.StatusBarUtil;
import com.tencent.qqmail.utilities.log.QMLog;

@TargetApi(23)
public class ShadowActivity
  extends Activity
{
  private static final String KEY_ORIGINAL_PID = "key_original_pid";
  public static final String TAG = "ShadowActivity";
  private int mOriginalProcessId;
  
  private void handleIntent(Intent paramIntent)
  {
    requestPermissions(paramIntent.getStringArrayExtra("permissions"), 42);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.onCreate(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder().append("savedInstanceState == null ");
    if (paramBundle == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QMLog.log(4, "ShadowActivity", bool1);
      StatusBarUtil.immerseWhite(this);
      if (paramBundle != null) {
        break;
      }
      handleIntent(getIntent());
      this.mOriginalProcessId = Process.myPid();
      return;
    }
    this.mOriginalProcessId = paramBundle.getInt("key_original_pid", this.mOriginalProcessId);
    if (this.mOriginalProcessId != Process.myPid()) {}
    for (bool1 = bool2;; bool1 = false)
    {
      QMLog.log(4, "ShadowActivity", "Process reborn!! " + bool1);
      if (!bool1) {
        break;
      }
      finish();
      return;
    }
  }
  
  protected void onDestroy()
  {
    QMLog.log(4, "ShadowActivity", "onDestroy");
    if (getIntent() != null) {}
    try
    {
      String[] arrayOfString = getIntent().getStringArrayExtra("permissions");
      RxPermissions.getInstance(this).removeResult(arrayOfString);
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(4, "ShadowActivity", "onDestroy", localException);
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    QMLog.log(4, "ShadowActivity", "onNewIntent");
    handleIntent(paramIntent);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    RxPermissions.getInstance(this).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    finish();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    QMLog.log(4, "ShadowActivity", "onSaveInstanceState");
    paramBundle.putInt("key_original_pid", this.mOriginalProcessId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.permission.ShadowActivity
 * JD-Core Version:    0.7.0.1
 */