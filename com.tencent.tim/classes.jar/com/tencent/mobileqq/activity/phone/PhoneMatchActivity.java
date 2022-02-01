package com.tencent.mobileqq.activity.phone;

import acfp;
import aelc;
import aelc.a;
import aeld;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import yuw;

public class PhoneMatchActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private Button eM;
  private int mSource;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 99999)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
      if (((PhoneContactManagerImp)this.app.getManager(11)).aC(true))
      {
        ContactBindedActivity.a(this.app, -1, 2, null);
        setResult(-1);
        finish();
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559422);
    PhoneContactManagerImp.a(this.app, getResources(), (ImageView)findViewById(2131365246));
    paramBundle = findViewById(2131370144);
    Object localObject;
    String str;
    if ((paramBundle != null) && ("1000".equals(ThemeUtil.curThemeId)))
    {
      paramBundle.setBackgroundResource(2130839642);
      this.centerView.setText(acfp.m(2131709518));
      this.mSource = getIntent().getIntExtra("kSrouce", -1);
      localObject = aeld.b();
      if (!this.f.Uw()) {
        break label251;
      }
      paramBundle = ((aelc)localObject).b.title;
      str = ((aelc)localObject).b.subTitle;
      localObject = ((aelc)localObject).b.buttonTitle;
      label124:
      ((TextView)findViewById(2131365248)).setText(paramBundle);
      ((TextView)findViewById(2131365247)).setText(str);
      this.eM = ((Button)findViewById(2131365245));
      this.eM.setOnClickListener(this);
      this.eM.setText((CharSequence)localObject);
      if (this.mSource != 14) {
        break label278;
      }
      setLeftViewName(2131690700);
    }
    for (;;)
    {
      anot.a(this.app, "dc00898", "", "", "0X800689B", "0X800689B", 0, 0, "", "", "", "");
      ThreadManager.excute(new PhoneMatchActivity.1(this), 16, null, true);
      return true;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setBackgroundResource(2130838900);
      break;
      label251:
      paramBundle = ((aelc)localObject).a.title;
      str = ((aelc)localObject).a.subTitle;
      localObject = ((aelc)localObject).a.buttonTitle;
      break label124;
      label278:
      setLeftButton("", null);
      setRightButton(2131721059, this);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    if (this.mSource == 14) {
      return;
    }
    overridePendingTransition(0, 2130771990);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.eM) {
      if (!aqiw.isNetSupport(this)) {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131696348, 0).show(getTitleBarHeight());
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, "clickMatch state: " + this.f.xy());
      }
      anot.a(this.app, "dc00898", "", "", "0X80095ED", "0X80095ED", 0, 0, "", "", "", "");
      PhoneMatchActivity.2 local2 = new PhoneMatchActivity.2(this);
      DenyRunnable localDenyRunnable = new DenyRunnable(this, new DenyRunnable.a(this.app));
      yuw.a(this, this.app, local2, localDenyRunnable);
      continue;
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchActivity
 * JD-Core Version:    0.7.0.1
 */