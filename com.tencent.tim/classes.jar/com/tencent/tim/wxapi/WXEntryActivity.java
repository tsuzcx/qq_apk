package com.tencent.tim.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;

public class WXEntryActivity
  extends Activity
{
  private void eg(Intent paramIntent)
  {
    Intent localIntent = new Intent("com.tencent.tim.action.ACTION_WECHAT_RESPONSE");
    localIntent.putExtras(paramIntent);
    sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (QLog.isColorLevel()) {
      QLog.d("WXEntryActivity", 2, "onCreate");
    }
    eg(getIntent());
    finish();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("WXEntryActivity", 2, "onNewIntent");
    }
    eg(paramIntent);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.wxapi.WXEntryActivity
 * JD-Core Version:    0.7.0.1
 */