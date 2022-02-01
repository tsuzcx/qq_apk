package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import aqha;
import aqju;
import com.tencent.mobileqq.app.BaseActivity;
import vkp;
import vkq;

public class OverloadTipsActivity
  extends BaseActivity
{
  private aqju dialog;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559712);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {}
    for (paramBundle = getIntent().getExtras().getString("msg");; paramBundle = null)
    {
      if (paramBundle == null)
      {
        finish();
        return false;
      }
      if ((this.dialog != null) && (this.dialog.isShowing())) {
        this.dialog.dismiss();
      }
      this.dialog = null;
      this.dialog = aqha.a(this, 230);
      this.dialog.setContentView(2131559127);
      this.dialog.setTitle(null).setMessage(paramBundle).setPositiveButton(2131696701, new vkp(this));
      this.dialog.setTextContentDescription(paramBundle);
      this.dialog.setOnKeyListener(new vkq(this));
      this.dialog.show();
      return false;
    }
  }
  
  public void finish()
  {
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      this.dialog.dismiss();
    }
    this.dialog = null;
    super.finish();
  }
  
  public void onBackPressed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.OverloadTipsActivity
 * JD-Core Version:    0.7.0.1
 */