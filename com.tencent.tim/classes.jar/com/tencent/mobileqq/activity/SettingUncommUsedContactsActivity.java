package com.tencent.mobileqq.activity;

import acfd;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import arie;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import vuh;
import vui;

public class SettingUncommUsedContactsActivity
  extends IphoneTitleBarActivity
{
  final String TAG = "SettingUnommUsedContacts";
  CompoundButton.OnCheckedChangeListener a = new vui(this);
  public FormSwitchItem aA;
  public FormSwitchItem aB;
  acfd c = new vuh(this);
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.a);
  }
  
  public void cf(int paramInt1, int paramInt2)
  {
    new arie(this).V(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    initUI();
    addObserver(this.c);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.c);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((FriendListHandler)this.app.getBusinessHandler(1)).du(this.app.getCurrentAccountUin(), 3);
  }
  
  void initUI()
  {
    setContentViewB(2131561696);
    setTitle(2131720004);
    this.leftView.setText(2131691039);
    this.rightViewText.setVisibility(8);
    this.aA = ((FormSwitchItem)findViewById(2131372176));
    this.aA.setOnCheckedChangeListener(this.a);
    a(this.aA.a(), this.app.aT(false));
    this.aB = ((FormSwitchItem)findViewById(2131378249));
    this.aB.setOnCheckedChangeListener(this.a);
    a(this.aB.a(), this.app.aU(false));
    if (AppSetting.enableTalkBack)
    {
      this.centerView.setContentDescription(getString(2131720004));
      this.aA.setContentDescription(getString(2131696380));
      this.aA.setFocusable(true);
      this.aB.setContentDescription(getString(2131720208));
      this.aB.setFocusable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity
 * JD-Core Version:    0.7.0.1
 */