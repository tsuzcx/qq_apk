package com.tencent.qqmail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;

public class PushDialActivity
  extends Activity
{
  private static final String TAG = "PushDialActivity";
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.d("donald dial", "onCreatPhone");
    try
    {
      paramBundle = getIntent().getStringExtra("phone");
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(QMApplicationContext.sharedInstance().getString(2131692646))).setMessage(QMApplicationContext.sharedInstance().getString(2131697136) + "\n " + paramBundle).addAction(2131691246, new PushDialActivity.2(this))).addAction(2131696547, new PushDialActivity.1(this, paramBundle))).create().show();
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QMLog.log(4, "PushDialActivity", "get phone error", paramBundle);
        finish();
        paramBundle = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.PushDialActivity
 * JD-Core Version:    0.7.0.1
 */