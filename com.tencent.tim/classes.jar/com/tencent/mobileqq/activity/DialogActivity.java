package com.tencent.mobileqq.activity;

import acsv;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import anot;
import aobp;
import aqha;
import aqju;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import uub;
import uuc;
import uud;
import uue;
import uuf;
import uug;
import uuh;
import uui;

public class DialogActivity
  extends BaseActivity
{
  public static int bGs;
  public static int bGt = 1;
  public static int bGu = 2;
  public static int bGv = 3;
  private int bGr;
  Dialog dialog;
  private int dialogType;
  
  private void bMX()
  {
    aqju localaqju = aqha.a(this, 230).setMessage(getString(this.bGr)).setPositiveButton(getString(2131720230), new uuc(this)).setNegativeButton(getString(2131720231), new uub(this));
    localaqju.setOnCancelListener(new uud(this));
    showDialog(localaqju);
  }
  
  private void bMY()
  {
    this.dialog = aqha.a(this, 230, null, getString(2131700733), getString(2131721058), getString(2131700734), new uue(this), new uuf(this));
    showDialog(this.dialog);
  }
  
  private void bMZ()
  {
    this.dialog = new acsv(this);
    this.dialog.setOnDismissListener(new uug(this));
    showDialog(this.dialog);
  }
  
  private void bNa()
  {
    if (getIntent() == null) {
      return;
    }
    new aobp(this, getIntent().getStringExtra("key_dialog_title"), getIntent().getStringExtra("key_dialog_content"), new uuh(this), new uui(this)).show();
  }
  
  private void showDialog(Dialog paramDialog)
  {
    QLog.d("qqBaseActivity", 1, "DialogActivity showDialog dialogType=" + this.dialogType + " dialog=" + paramDialog);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "showDialog dialogType=" + this.dialogType);
      }
      paramDialog.show();
      if (this.dialogType == bGu) {
        anot.a(null, "dc00898", "", "", "0X8009AC7", "0X8009AC7", 0, 0, "", "", "", "");
      }
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("raw_photo", 2, "showDialog ", localBadTokenException);
      }
      getWindow().getDecorView().post(new DialogActivity.1(this, paramDialog));
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.dialogType = localIntent.getIntExtra("key_dialog_type", bGs);
      this.bGr = localIntent.getIntExtra("key_dialog_msg_id", 2131692261);
    }
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.dialogType == bGt)
    {
      QLog.d("qqBaseActivity", 1, "DialogActivity dimissDialog dialogType=" + this.dialogType + " dialog=" + this.dialog);
      if (this.dialog != null)
      {
        this.dialog.dismiss();
        finish();
        this.dialog = null;
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      return;
    }
    if (this.dialogType == bGt)
    {
      bMY();
      return;
    }
    if (this.dialogType == bGu)
    {
      bMZ();
      return;
    }
    if (this.dialogType == bGv)
    {
      bNa();
      return;
    }
    bMX();
  }
  
  public void finish()
  {
    super.finish();
    if (this.dialog != null) {
      this.dialog.setOnDismissListener(null);
    }
    overridePendingTransition(0, 2130772067);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DialogActivity
 * JD-Core Version:    0.7.0.1
 */