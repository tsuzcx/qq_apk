package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import cnf;
import cng;
import cnh;
import cni;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class DialogActivity
  extends BaseActivity
{
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
      getWindow().getDecorView().post(new cni(this, paramQQCustomDialog));
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setMessage(getString(2131561491)).setPositiveButton(getString(2131563227), new cng(this)).setNegativeButton(getString(2131562473), new cnf(this));
    localQQCustomDialog.setOnCancelListener(new cnh(this));
    a(localQQCustomDialog);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DialogActivity
 * JD-Core Version:    0.7.0.1
 */