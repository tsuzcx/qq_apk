package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.qphone.base.util.QLog;

class BaseActivity$8
  implements TeleScreenRunnable
{
  BaseActivity$8(BaseActivity paramBaseActivity, Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      BaseActivity.access$701(this.this$0, this.val$intent, this.val$requestCode, this.S);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("qqBaseActivity", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity.8
 * JD-Core Version:    0.7.0.1
 */