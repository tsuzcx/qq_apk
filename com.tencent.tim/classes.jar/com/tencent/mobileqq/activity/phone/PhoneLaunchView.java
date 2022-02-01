package com.tencent.mobileqq.activity.phone;

import acfp;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqgv;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@SuppressLint({"ViewConstructor"})
public class PhoneLaunchView
  extends BaseActivityView
  implements View.OnClickListener
{
  private boolean bsA;
  private Button jdField_do;
  private int mSrc;
  
  public PhoneLaunchView(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    setContentView(2131559748);
    this.jdField_do = ((Button)E(2131373046));
    this.jdField_do.setOnClickListener(this);
    PhoneContactManagerImp.a(this.app, getResources(), (ImageView)E(2131373048));
  }
  
  private void crr()
  {
    Intent localIntent = new Intent(getContext(), BindNumberActivity.class);
    localIntent.putExtra("key_is_modal_pop", true);
    localIntent.putExtra("kSrouce", this.mSrc);
    startActivityForResult(localIntent, 1);
    overridePendingTransition(2130772367, 2130772002);
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("k_start_number", false)) {
        this.bsA = true;
      }
      this.mSrc = paramIntent.getIntExtra("kSrouce", -1);
    }
    super.a(paramIntent, paramPhoneInnerFrame);
    if (this.reqType == 3) {
      ((TextView)E(2131373049)).setText(2131689880);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (this.reqType != 1) {
        break label26;
      }
      this.mActivity.setResult(paramInt2);
      finish();
    }
    label26:
    do
    {
      return;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("refuse_upload", false)))
        {
          finish();
          return;
        }
        this.mActivity.setResult(paramInt2, paramIntent);
        startActivity(new Intent(getContext(), ContactListView.class));
        return;
      }
    } while (paramInt2 != 0);
    finish();
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (paramView == this.jdField_do)
    {
      i = this.f.xy();
      anot.a(this.app, "CliOper", "", "", "QQPim", "Clk_address_on", 0, 0, "", "", "", "");
      if ((i != 1) && (i != 2) && (i != 3) && (i != 4)) {
        break label80;
      }
      aqgv.Xr(6);
      crr();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label80:
      if (i == 5)
      {
        startActivityForResult(new Intent(getContext(), BindNumberFromPcActivity.class), 1);
        overridePendingTransition(2130772367, 2130772002);
      }
      else
      {
        dV(acfp.m(2131709516), acfp.m(2131709512));
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.reqType == 3) {
      this.centerView.setText(acfp.m(2131709514));
    }
    for (;;)
    {
      this.MZ.setVisibility(8);
      if (this.bsA) {
        crr();
      }
      return;
      this.centerView.setText(acfp.m(2131709506));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchView
 * JD-Core Version:    0.7.0.1
 */