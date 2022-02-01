package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import acfp;
import aelc;
import aelc.a;
import aeld;
import akwl;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqiw;
import ausj;
import auss;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import yuw;
import zrd;

public class SettingActivity2
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public TextView Nj;
  public TextView Nk;
  public Boolean aj;
  public akwl c;
  public int ceB = -1;
  public Button eN;
  public Button eO;
  public akwl k;
  public akwl l;
  public int mCurState = 0;
  
  public void cN(String paramString, int paramInt)
  {
    anot.a(this.app, "CliOper", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public void crq()
  {
    if (!aqiw.isNetSupport(this))
    {
      showToast(2131696348);
      return;
    }
    SettingActivity2.3 local3 = new SettingActivity2.3(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this, new DenyRunnable.a(this.app));
    yuw.a(this, this.app, local3, localDenyRunnable);
  }
  
  public void crt()
  {
    int i = this.f.xy();
    boolean bool = this.f.Uw();
    String str = null;
    Object localObject2 = this.f.a();
    Object localObject1 = str;
    if (1 != i)
    {
      localObject1 = str;
      if (5 != i)
      {
        localObject1 = str;
        if (localObject2 != null) {
          localObject1 = ((RespondQueryQQBindingStat)localObject2).nationCode + " " + ((RespondQueryQQBindingStat)localObject2).mobileNo;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SettingActivity2", 2, "updateUIByState state[" + i + "], number[" + (String)localObject1 + "], hasPermission[" + this.aj + "]");
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (i <= 5)) {
      finish();
    }
    while ((i == this.mCurState) && (this.aj != null) && (this.aj.booleanValue() == bool)) {
      return;
    }
    this.mCurState = i;
    this.aj = Boolean.valueOf(bool);
    setTitle(acfp.m(2131714334));
    this.Nj = ((TextView)findViewById(2131365248));
    this.Nk = ((TextView)findViewById(2131365247));
    this.eN = ((Button)findViewById(2131371178));
    this.eN.setOnClickListener(this);
    this.eO = ((Button)findViewById(2131381910));
    this.eO.setOnClickListener(this);
    if ((i == 7) || (i == 6))
    {
      this.eO.setVisibility(8);
      this.eN.setVisibility(0);
      this.Nj.setVisibility(0);
      this.Nk.setVisibility(0);
      localObject1 = aeld.b();
      if (bool)
      {
        localObject2 = ((aelc)localObject1).b.title;
        str = ((aelc)localObject1).b.subTitle;
        localObject1 = ((aelc)localObject1).b.buttonTitle;
        this.Nj.setText((CharSequence)localObject2);
        this.Nk.setText(str);
        this.eN.setText((CharSequence)localObject1);
        label379:
        localObject1 = (ImageView)findViewById(2131369594);
        if (i != 7) {
          break label496;
        }
        ((ImageView)localObject1).setVisibility(8);
      }
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {
        ((ImageView)localObject1).setContentDescription(getString(2131696810));
      }
      ((ImageView)localObject1).setBackgroundResource(2130840663);
      ((ImageView)localObject1).setOnClickListener(this);
      return;
      localObject2 = ((aelc)localObject1).a.title;
      str = ((aelc)localObject1).a.subTitle;
      localObject1 = ((aelc)localObject1).a.buttonTitle;
      break;
      this.eO.setVisibility(0);
      this.eN.setVisibility(8);
      this.Nj.setVisibility(8);
      this.Nk.setVisibility(8);
      break label379;
      label496:
      ((ImageView)localObject1).setVisibility(0);
    }
  }
  
  public void cru()
  {
    ausj localausj = (ausj)auss.a(this, null);
    localausj.setCanceledOnTouchOutside(true);
    localausj.addButton(acfp.m(2131714335), 3);
    localausj.addCancelButton(2131721058);
    localausj.a(new zrd(this, localausj));
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
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
        ContactBindedActivity.a(this.app, 222, this.f.bT());
        return;
      }
      crt();
      return;
    }
    crt();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = super.getIntent();
    if (paramBundle == null)
    {
      super.finish();
      return true;
    }
    this.ceB = paramBundle.getIntExtra("kSrouce", -1);
    super.setContentView(2131559753);
    PhoneContactManagerImp.a(this.app, getResources(), (ImageView)findViewById(2131365246));
    crt();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.c != null)
    {
      this.app.unRegistObserver(this.c);
      this.c = null;
    }
    if (this.l != null)
    {
      this.app.unRegistObserver(this.l);
      this.l = null;
    }
    this.app.removeHandler(SettingActivity2.class);
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ThreadManager.excute(new SettingActivity2.1(this), 16, null, true);
    crt();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default: 
      throw new RuntimeException("unknown id: " + i);
    case 2131369594: 
      cru();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      cN("0X8005B89", 0);
      crq();
      continue;
      SettingActivity2.4 local4 = new SettingActivity2.4(this);
      DenyRunnable localDenyRunnable = new DenyRunnable(this, new DenyRunnable.a(this.app));
      yuw.a(this, this.app, local4, localDenyRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2
 * JD-Core Version:    0.7.0.1
 */