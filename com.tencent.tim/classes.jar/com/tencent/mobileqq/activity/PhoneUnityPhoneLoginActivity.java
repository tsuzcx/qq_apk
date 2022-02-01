package com.tencent.mobileqq.activity;

import acll;
import aclm;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import aqiw;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import vly;

public class PhoneUnityPhoneLoginActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private FormSwitchItem av;
  private aclm b = new vly(this);
  private byte[] ce;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561534);
    setTitle(getString(2131696798));
    setContentBackgroundResource(2130838900);
    this.leftView.setText(2131701652);
    this.av = ((FormSwitchItem)super.findViewById(2131373051));
    if (this.av != null) {
      this.av.setOnCheckedChangeListener(this);
    }
    addObserver(this.b);
    paramBundle = super.getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getExtras();
      if (paramBundle != null) {
        this.ce = paramBundle.getByteArray("phone_num_login_sig");
      }
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.b);
    super.doOnDestroy();
  }
  
  public boolean onBackEvent()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("phone_num_login_result", this.av.isChecked());
    super.setResult(-1, localIntent);
    super.finish();
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    boolean bool;
    if (paramCompoundButton == this.av.a())
    {
      this.av.setOnCheckedChangeListener(null);
      localObject = this.av;
      if (!this.av.isChecked()) {
        break label86;
      }
      bool = false;
      ((FormSwitchItem)localObject).setChecked(bool);
      this.av.setOnCheckedChangeListener(this);
      if (aqiw.isNetSupport(this)) {
        break label91;
      }
      QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label86:
      bool = true;
      break;
      label91:
      localObject = (acll)this.app.getBusinessHandler(34);
      if ((localObject != null) && (this.ce != null)) {
        if (paramBoolean) {
          ((acll)localObject).aL(this.ce);
        } else {
          ((acll)localObject).aM(this.ce);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityPhoneLoginActivity
 * JD-Core Version:    0.7.0.1
 */