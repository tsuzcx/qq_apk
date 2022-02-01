package com.tencent.mobileqq.activity;

import acfp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import vct;
import vcu;

public class GesturePWDSettingActivity
  extends IphoneTitleBarActivity
{
  private FormSwitchItem G;
  private boolean aXj;
  private int bHF;
  private int bHG;
  private View tk;
  private View tl;
  private View tm;
  private View tn;
  private View to;
  private View tq;
  private View.OnClickListener x = new vcu(this);
  
  private void aEh()
  {
    this.bHF = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    switch (this.bHF)
    {
    default: 
      return;
    case 0: 
    case 1: 
      xs(false);
      this.G.setChecked(false);
      return;
    }
    xs(true);
    this.G.setChecked(true);
  }
  
  private void initData()
  {
    this.aXj = getIntent().getBooleanExtra("key_reset", false);
    this.bHF = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    switch (this.bHF)
    {
    default: 
      return;
    case 0: 
      if (this.aXj)
      {
        if ((this.leftView != null) && ((this.leftView instanceof TextView))) {
          this.leftView.setText(2131719357);
        }
        startActivityForResult(new Intent(this, GesturePWDCreateActivity.class), 10);
        overridePendingTransition(2130772009, 2130772002);
        return;
      }
      startActivityForResult(new Intent(this, GesturePWDGuideActivity.class), 10);
      return;
    case 1: 
      this.G.setChecked(false);
      xs(false);
      return;
    }
    this.G.setChecked(true);
    xs(true);
    bPG();
  }
  
  private void initUI()
  {
    setTitle(2131694304);
    this.tl = findViewById(2131367981);
    this.tm = findViewById(2131367978);
    this.tn = findViewById(2131367995);
    this.to = findViewById(2131367983);
    this.tq = findViewById(2131367979);
    this.tk = findViewById(2131367982);
    this.tk.setContentDescription(acfp.m(2131706953));
    this.tl.setOnClickListener(this.x);
    this.tm.setOnClickListener(this.x);
    this.tn.setOnClickListener(this.x);
    this.tk.setOnClickListener(this.x);
    this.G = ((FormSwitchItem)findViewById(2131367996));
    this.G.setOnCheckedChangeListener(new vct(this));
  }
  
  public void bPG()
  {
    this.bHG = GesturePWDUtils.getGesturePWDMode(this, this.app.getCurrentAccountUin());
    if (this.bHG == 21)
    {
      this.to.setVisibility(4);
      this.tq.setVisibility(0);
      return;
    }
    this.to.setVisibility(0);
    this.tq.setVisibility(4);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10)
    {
      if (paramInt2 == -1)
      {
        aEh();
        bPG();
      }
    }
    else
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559408);
    initUI();
    initData();
    return true;
  }
  
  public boolean onBackEvent()
  {
    if (this.aXj)
    {
      Intent localIntent = new Intent(getActivity(), PermisionPrivacyActivity.class);
      localIntent.putExtra("key_reset", this.aXj);
      startActivity(localIntent);
      finish();
      return true;
    }
    return super.onBackEvent();
  }
  
  public String setLastActivityName()
  {
    if (this.bHF == 0) {
      return getString(2131701610);
    }
    return getString(2131694304);
  }
  
  public void xs(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.tl.setVisibility(0);
      this.tm.setVisibility(0);
      this.tn.setVisibility(0);
      return;
    }
    this.tl.setVisibility(4);
    this.tm.setVisibility(4);
    this.tn.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDSettingActivity
 * JD-Core Version:    0.7.0.1
 */