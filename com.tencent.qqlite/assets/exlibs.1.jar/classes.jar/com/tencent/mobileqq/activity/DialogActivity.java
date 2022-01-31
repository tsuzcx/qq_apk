package com.tencent.mobileqq.activity;

import aim;
import ain;
import aio;
import aip;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class DialogActivity
  extends BaseActivity
{
  public static final String a = "key_dialog_msg_id";
  private int a;
  
  private void a(QQCustomDialog paramQQCustomDialog)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "showDialog ");
      }
      paramQQCustomDialog.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("raw_photo", 2, "showDialog ", localBadTokenException);
      }
      getWindow().getDecorView().post(new aip(this, paramQQCustomDialog));
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.a = localIntent.getIntExtra("key_dialog_msg_id", 2131364056);
    }
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setMessage(getString(this.a)).setPositiveButton(getString(2131362789), new ain(this)).setNegativeButton(getString(2131362788), new aim(this));
    localQQCustomDialog.setOnCancelListener(new aio(this));
    a(localQQCustomDialog);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DialogActivity
 * JD-Core Version:    0.7.0.1
 */