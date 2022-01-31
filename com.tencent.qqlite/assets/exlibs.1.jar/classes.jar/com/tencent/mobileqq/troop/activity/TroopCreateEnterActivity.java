package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.qphone.base.util.QLog;

public class TroopCreateEnterActivity
  extends BaseActivity
{
  protected static final String a = "TroopCreateEnterActivity";
  TroopCreateLogic a = null;
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, TroopCreateEnterActivity.class);
    localIntent.putExtra("from", paramInt1);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopCreateEnterActivity", 2, "doOnActivityResult: " + paramInt1 + " " + paramInt2);
    }
    setResult(paramInt2, paramIntent);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (getIntent() != null) {}
    for (int i = getIntent().getIntExtra("from", 0);; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreateEnterActivity", 2, "doOnCreate, from:" + i);
      }
      this.a = ((TroopCreateLogic)this.app.getManager(29));
      if (this.a != null) {
        this.a.a(this, i);
      }
      for (;;)
      {
        return true;
        finish();
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("TroopCreateEnterActivity", 2, "doOnDestroy");
    }
    this.a = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (this.a != null) {
      bool = this.a.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopCreateEnterActivity", 2, "onTouchEvent, isDialogShowing:" + bool);
    }
    if (!bool) {
      finish();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateEnterActivity
 * JD-Core Version:    0.7.0.1
 */