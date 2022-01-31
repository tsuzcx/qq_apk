package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import dcf;

public class QQLSUnlockActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(4718592);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "enter QQLSUnlockActivity");
    }
    new dcf(this).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSUnlockActivity
 * JD-Core Version:    0.7.0.1
 */