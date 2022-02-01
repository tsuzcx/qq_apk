package com.tencent.mobileqq.activity.phone;

import acfp;
import akwo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import anot;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import yuw;

public class GuideBindPhoneActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected akwo a;
  protected int mFromType = 0;
  protected int mSource = -1;
  
  public void crk()
  {
    if (((PhoneContactManagerImp)this.app.getManager(11)).aC(true))
    {
      ContactBindedActivity.a(this.app, -1, 2, null);
      setResult(-1);
      finish();
    }
  }
  
  public void crl()
  {
    if ((VersionUtils.isM()) && (yuw.ij("android.permission.WRITE_CONTACTS")))
    {
      String str1 = getIntent().getStringExtra("key_contact_name");
      String str2 = getIntent().getStringExtra("key_contact_phone");
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(11);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (localPhoneContactManagerImp.ad(str1, str2))) {
        QQToast.a(getApplicationContext(), 2, acfp.m(2131707099), 0).show();
      }
      finish();
    }
  }
  
  public void crm()
  {
    if (((PhoneContactManagerImp)this.app.getManager(11)).Uw())
    {
      setResult(-1);
      finish();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 99999)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
      if ((this.mFromType == 2) || (this.mFromType == 1)) {
        crk();
      }
    }
    else
    {
      return;
    }
    if (this.mFromType == 5)
    {
      crl();
      return;
    }
    if (this.mFromType == 6)
    {
      crm();
      return;
    }
    crm();
  }
  
  public void doOnBackPressed()
  {
    setResult(0);
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mSource = getIntent().getIntExtra("kSrouce", -1);
    this.mFromType = getIntent().getIntExtra("fromKeyForContactBind", 0);
    if (getIntent().getBooleanExtra("key_runtime_req_permission", false))
    {
      paramBundle = new GuideBindPhoneActivity.1(this);
      GuideBindPhoneActivity.2 local2 = new GuideBindPhoneActivity.2(this);
      yuw.a(this, this.app, paramBundle, local2);
    }
    setContentView(2131559422);
    PhoneContactManagerImp.a(this.app, getResources(), (ImageView)findViewById(2131365246));
    paramBundle = findViewById(2131370144);
    if ((paramBundle != null) && ("1000".equals(ThemeUtil.curThemeId))) {
      paramBundle.setBackgroundResource(2130839642);
    }
    for (;;)
    {
      setTitle(null, getString(2131696837));
      setLeftViewName(2131690700);
      this.a = new akwo(this, getPackageName());
      findViewById(2131365245).setOnClickListener(this);
      anot.a(this.app, "dc00898", "", "", "0X8009F1B", "0X8009F1B", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.i("GuideBindPhoneActivity", 2, String.format("init [%s, %s]", new Object[] { Integer.valueOf(this.mSource), Integer.valueOf(this.mFromType) }));
      }
      return true;
      if (paramBundle != null) {
        paramBundle.setBackgroundResource(2130838900);
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365245)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GuideBindPhoneActivity", 2, "jump permission page");
      }
      if (!VersionUtils.isM()) {
        break label121;
      }
      if ((this.mFromType == 2) || (this.mFromType == 1)) {
        ((PhoneContactManagerImp)this.app.getManager(11)).AP(true);
      }
    }
    for (;;)
    {
      try
      {
        this.a.dDC();
        anot.a(this.app, "dc00898", "", "", "0X8009F1C", "0X8009F1C", 0, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        this.a.dDD();
        continue;
      }
      label121:
      this.a.dDD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity
 * JD-Core Version:    0.7.0.1
 */