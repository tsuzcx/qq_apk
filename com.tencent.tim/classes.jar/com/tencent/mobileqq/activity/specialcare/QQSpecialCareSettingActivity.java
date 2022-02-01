package com.tencent.mobileqq.activity.specialcare;

import abau;
import abav;
import abaw;
import abax;
import abay;
import abbf;
import acfd;
import acff;
import ackl;
import acsz;
import aean;
import aean.a;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import anot;
import aqiw;
import aqqj;
import arhz;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQSpecialCareSettingActivity
  extends IphoneTitleBarActivity
  implements aean.a, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private View Ap;
  private View Aq;
  private ackl jdField_a_of_type_Ackl = new abay(this);
  private arhz jdField_a_of_type_Arhz;
  private SpecialCareInfo jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
  private FormSwitchItem aJ;
  private FormSwitchItem aK;
  private FormSwitchItem aL;
  private FormSimpleItem as;
  private aean jdField_b_of_type_Aean;
  private Toast jdField_b_of_type_AndroidWidgetToast;
  private QvipSpecialSoundManager jdField_b_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private boolean bBF;
  private String bfa;
  private int bnC;
  private FriendListHandler c;
  private acfd e = new abax(this);
  private acff k;
  public final Handler mHandler = new abav(this);
  
  private void cAK()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo = this.k.a(this.bfa);
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "showItems mSpecInfo: " + this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo == null)
    {
      if (!this.k.aag())
      {
        this.aJ.setVisibility(8);
        this.Ap.setVisibility(8);
        this.aK.setVisibility(8);
        this.aL.setVisibility(8);
        this.Aq.setVisibility(8);
        this.as.setVisibility(8);
        return;
      }
      this.aJ.setVisibility(0);
      this.Ap.setVisibility(0);
      this.aK.setVisibility(8);
      this.aL.setVisibility(8);
      this.Aq.setVisibility(8);
      b(this.aJ, false);
      return;
    }
    this.aJ.setVisibility(0);
    this.Ap.setVisibility(0);
    Object localObject = this.aJ;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.globalSwitch == 0)
    {
      bool = false;
      label207:
      b((FormSwitchItem)localObject, bool);
      this.aJ.isChecked();
      this.aK.setVisibility(8);
      this.aK.setVisibility(8);
      this.aL.setVisibility(8);
      this.Aq.setVisibility(8);
      if (!this.bBF) {
        break label332;
      }
      localObject = getResources().getDrawable(2130851403);
      this.as.setRightIcon((Drawable)localObject);
    }
    for (;;)
    {
      this.as.setVisibility(8);
      if (this.as.getVisibility() != 0) {
        break;
      }
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bell", "care_show", "", 1, 0, 0, "", "", "");
      return;
      bool = true;
      break label207;
      label332:
      this.as.setRightIcon(null);
    }
  }
  
  private void cAL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "loadSpecialSoundConfig start loading...");
    }
    startTitleProgress();
    this.jdField_b_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new abau(this));
  }
  
  private void cAM()
  {
    Object localObject;
    if (abbf.e(this.bfa, this.app))
    {
      if (!this.jdField_b_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.XO()) {
        cAL();
      }
      i = abbf.a(this.bfa, this.app);
      localObject = this.jdField_b_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.da(i);
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "updatePersonalVoice mFriUin: " + this.bfa + ", soundId: " + i + ", soundName: " + (String)localObject);
      }
      localObject = ((acff)this.app.getManager(51)).a(this.bfa, false);
      if (localObject != null) {
        break label219;
      }
      QLog.d("QQSpecialCareSettingActivity", 1, new Object[] { "onResume: invoked. ", " extensionInfo: ", localObject });
    }
    label219:
    for (int i = 0;; i = ((ExtensionInfo)localObject).friendRingId)
    {
      this.jdField_b_of_type_Aean.a(this.as, i, this.bfa, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "updatePersonalVoice not contain friend: " + this.bfa);
      }
      this.as.setRightText("");
      break;
    }
  }
  
  public void BC(int paramInt)
  {
    this.jdField_b_of_type_Aean.a(this.as, paramInt, this.bfa, 0);
  }
  
  public void b(FormSwitchItem paramFormSwitchItem, boolean paramBoolean)
  {
    paramFormSwitchItem.setOnCheckedChangeListener(null);
    paramFormSwitchItem.setChecked(paramBoolean);
    paramFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561713);
    setTitle(2131701733);
    setLeftViewName(2131691039);
    this.aJ = ((FormSwitchItem)findViewById(2131378637));
    this.aJ.setOnCheckedChangeListener(this);
    this.Ap = findViewById(2131378638);
    this.aK = ((FormSwitchItem)findViewById(2131367699));
    this.aK.setOnCheckedChangeListener(this);
    this.aL = ((FormSwitchItem)findViewById(2131367714));
    this.aL.setOnCheckedChangeListener(this);
    this.Aq = findViewById(2131376228);
    this.as = ((FormSimpleItem)findViewById(2131373022));
    this.as.setOnClickListener(this);
    this.bfa = getIntent().getStringExtra("key_friend_uin");
    this.bnC = getIntent().getIntExtra("key_start_from", 5);
    this.aK.setVisibility(8);
    this.as.setVisibility(8);
    this.aL.setVisibility(8);
    this.Aq.setVisibility(8);
    if (this.app != null)
    {
      this.c = ((FriendListHandler)this.app.getBusinessHandler(1));
      this.k = ((acff)this.app.getManager(51));
      this.app.addObserver(this.e);
      this.app.addObserver(this.jdField_a_of_type_Ackl);
    }
    this.jdField_b_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.app);
    if (!this.jdField_b_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.XO())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "QvipSpecialSoundManager no cache data.");
      }
      cAL();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "doOnCreate mFriUin: " + this.bfa);
    }
    if (this.app == null) {}
    for (paramBundle = "";; paramBundle = this.app.getCurrentAccountUin())
    {
      VasWebviewUtil.reportCommercialDrainage(paramBundle, "Care", "PageView", Integer.toString(this.bnC), 1, 0, 0, null, null, null);
      this.aJ.setContentDescription(getString(2131717467));
      this.jdField_b_of_type_Aean = aean.a(this.app);
      this.jdField_b_of_type_Aean.a(this);
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Ackl);
      this.app.removeObserver(this.e);
      aean.a(this.app).b(this);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_b_of_type_Aean.eo(this.bfa, 0);
    cAK();
  }
  
  public void finish()
  {
    if (getIntent().getBooleanExtra("key_is_from_management_activity", false)) {
      setResult(-1);
    }
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 2;
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onCheckedChanged isCheck: " + paramBoolean + ", switched by user.");
    }
    if (paramCompoundButton == this.aJ.a()) {
      if ((QQToast.MK() == 0) && (paramBoolean))
      {
        localObject1 = new acsz(this, this.app, this.bfa);
        ((acsz)localObject1).setOnDismissListener(new abaw(this, paramBoolean, (acsz)localObject1));
        ((acsz)localObject1).show();
        anot.a(null, "dc00898", "", "", "0X8009ACB", "0X8009ACB", 0, 0, "", "", "", "");
      }
    }
    label194:
    while ((paramCompoundButton != this.aK.a()) && (paramCompoundButton != this.aL.a()))
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (aqiw.isNetworkAvailable(this))
      {
        this.c.b(1, new String[] { this.bfa }, new boolean[] { paramBoolean });
        localObject1 = this.mHandler.obtainMessage(8193);
        this.mHandler.sendMessage((Message)localObject1);
        localObject2 = this.app.getCurrentAccountUin();
        if (!paramBoolean) {
          break label277;
        }
      }
      for (localObject1 = "SwitchOn";; localObject1 = "SwitchOff")
      {
        VasWebviewUtil.reportCommercialDrainage((String)localObject2, "Care", (String)localObject1, Integer.toString(this.bnC), 1, 0, 0, null, null, null);
        break;
        localObject1 = this.mHandler.obtainMessage(8195);
        ((Message)localObject1).arg1 = 0;
        ((Message)localObject1).arg2 = 2131693404;
        this.mHandler.sendMessage((Message)localObject1);
        break label194;
      }
    }
    label277:
    if (paramCompoundButton == this.aK.a()) {}
    for (Object localObject1 = this.aK;; localObject1 = this.aL)
    {
      if (!aqiw.isNetworkAvailable(this)) {
        break label382;
      }
      this.c.b(i, new String[] { this.bfa }, new boolean[] { paramBoolean });
      break;
      if (paramCompoundButton != this.aL.a()) {
        break;
      }
      i = 3;
    }
    label382:
    Object localObject2 = this.mHandler.obtainMessage(8195);
    ((Message)localObject2).arg1 = 0;
    ((Message)localObject2).arg2 = 2131693404;
    this.mHandler.sendMessage((Message)localObject2);
    if (!((FormSwitchItem)localObject1).isChecked()) {}
    for (;;)
    {
      b((FormSwitchItem)localObject1, bool);
      break;
      bool = false;
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (paramView == null)
    {
      i = 0;
      switch (i)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = paramView.getId();
      break;
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", aqqj.getUrl("specialCareRingUrl").replace("[uid]", this.bfa).replace("[lType]", "2"));
      startActivity(localIntent);
      this.bBF = false;
      anot.a(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 2, 0, "", "", "", "");
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bell", " care_click", "", 1, 0, 0, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity
 * JD-Core Version:    0.7.0.1
 */