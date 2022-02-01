package com.tencent.mobileqq.activity;

import acfp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anot;
import aqha;
import aqju;
import com.tencent.mobileqq.app.BaseActivity;
import vkr;
import vks;

public class PCActiveNoticeActiviy
  extends BaseActivity
{
  private aqju dialog;
  private String uin;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559712);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {}
    for (this.uin = getIntent().getExtras().getString("uin"); TextUtils.isEmpty(this.uin); this.uin = null)
    {
      finish();
      return false;
    }
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      this.dialog.dismiss();
    }
    paramBundle = acfp.m(2131709419);
    this.dialog = null;
    this.dialog = aqha.a(this, 230);
    this.dialog.setContentView(2131559127);
    this.dialog.setTitle(null).setMessage(getString(2131696745)).setPositiveButton(2131696744, new vkr(this));
    this.dialog.setTextContentDescription(paramBundle);
    this.dialog.setOnKeyListener(new vks(this));
    this.dialog.show();
    anot.a(null, "CliOper", "", "", "0X8004973", "0X8004973", 0, 0, "", "", "", "");
    return false;
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
 * Qualified Name:     com.tencent.mobileqq.activity.PCActiveNoticeActiviy
 * JD-Core Version:    0.7.0.1
 */