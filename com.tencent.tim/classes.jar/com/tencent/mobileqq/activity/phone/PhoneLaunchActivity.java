package com.tencent.mobileqq.activity.phone;

import acfp;
import akwl;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import anot;
import aqgv;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import yuw;
import zra;

public class PhoneLaunchActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private boolean bsv;
  private boolean bsw;
  private boolean bsx;
  private boolean bsy;
  private boolean bsz;
  private Button jdField_do;
  public akwl k;
  
  private void crr()
  {
    aqgv.Xr(2);
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    if (getIntent().getIntExtra("kSrouce", -1) == 8) {
      localIntent.putExtra("kSrouce", 8);
    }
    startActivityForResult(localIntent, 1);
  }
  
  public void crq()
  {
    PhoneLaunchActivity.1 local1 = new PhoneLaunchActivity.1(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this, new zra(this));
    yuw.a(this, this.app, local1, localDenyRunnable);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      if (paramInt2 != 0)
      {
        setResult(paramInt2, paramIntent);
        finish();
      }
    }
    while ((paramInt2 != 2) || (!this.bsv) || (!this.f.Ur())) {
      return;
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    boolean bool = getIntent().hasExtra("needAlert");
    this.bsv = getIntent().getBooleanExtra("fromStopAndMatch", false);
    this.bsw = getIntent().getBooleanExtra("fromCall", false);
    this.bsx = getIntent().getBooleanExtra("fromPermiPriv", false);
    this.bsy = getIntent().getBooleanExtra("fromAVCallInvite", false);
    this.bsz = getIntent().getBooleanExtra("returnAndFinish", false);
    if ((!bool) && (paramBundle == null))
    {
      finish();
      return false;
    }
    if (!this.bsv) {
      if (getIntent().getStringExtra("leftViewText") == null) {
        getIntent().putExtra("leftViewText", acfp.m(2131709511));
      }
    }
    for (;;)
    {
      setContentView(2131559748);
      setTitle(acfp.m(2131709507));
      this.jdField_do = ((Button)findViewById(2131373046));
      this.jdField_do.setOnClickListener(this);
      if (getIntent().getBooleanExtra("k_start_number", false)) {
        crr();
      }
      return true;
      getIntent().putExtra("leftViewText", acfp.m(2131709513));
    }
  }
  
  public void finish()
  {
    super.finish();
    if (!this.bsv) {
      overridePendingTransition(2130772002, 2130772369);
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (paramView == this.jdField_do)
    {
      i = this.f.xy();
      if ((i == 1) || (i == 2) || (i == 3) || (i == 4))
      {
        crr();
        if (this.bsy) {
          anot.a(this.app, "CliOper", "", "", "0X8005D10", "0X8005D10", 0, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 5)
      {
        Intent localIntent = new Intent(this, BindNumberFromPcActivity.class);
        localIntent.putExtra("key_is_first_activity", false);
        startActivityForResult(localIntent, 1);
        break;
      }
      if (i == 7)
      {
        this.jdField_do.setEnabled(false);
        crq();
        break;
      }
      dV(acfp.m(2131709509), acfp.m(2131709508));
      break;
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchActivity
 * JD-Core Version:    0.7.0.1
 */