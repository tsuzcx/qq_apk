package com.tencent.mobileqq.activity.specialcare;

import abaz;
import abbb;
import abbc;
import abbd;
import abbe;
import abbf;
import acfd;
import acff;
import ackl;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqdf;
import aqdf.a;
import aqhu;
import aqiw;
import aqlw;
import aqqj;
import arhz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQSpecialFriendSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, aqdf.a
{
  private View Aq;
  private View Ar;
  private ackl jdField_a_of_type_Ackl = new abbe(this);
  private aqdf jdField_a_of_type_Aqdf;
  private arhz jdField_a_of_type_Arhz;
  private SpecialCareInfo jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
  private FormSwitchItem aK;
  private FormSwitchItem aL;
  private FormSimpleItem as;
  private QvipSpecialSoundManager b;
  private boolean bBH;
  private boolean bBI = true;
  private boolean bBJ;
  private String bfa;
  private FriendListHandler c;
  private int cnz;
  private acfd e = new abbd(this);
  private acff k;
  public final Handler mHandler = new abbc(this);
  private TextView nickName;
  private ImageView wR;
  
  private void cAK()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo = this.k.a(this.bfa);
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "showItems mSpecInfo: " + this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo == null)
    {
      if (!this.bBH)
      {
        this.aK.setVisibility(8);
        this.aL.setVisibility(8);
        this.Aq.setVisibility(8);
        this.as.setVisibility(8);
        this.Ar.setVisibility(8);
        return;
      }
      this.Ar.setVisibility(8);
      cAM();
      return;
    }
    this.aK.setVisibility(8);
    if (!this.bBH) {
      this.Ar.setVisibility(0);
    }
    FormSwitchItem localFormSwitchItem = this.aK;
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.specialRingSwitch == 0)
    {
      bool1 = false;
      b(localFormSwitchItem, bool1);
      localFormSwitchItem = this.aL;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.qzoneSwitch != 0) {
        break label205;
      }
    }
    label205:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      b(localFormSwitchItem, bool1);
      cAM();
      return;
      bool1 = true;
      break;
    }
  }
  
  private void cAL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "loadSpecialSoundConfig start loading...");
    }
    startTitleProgress();
    this.b.a(new abbb(this));
  }
  
  private void cAM()
  {
    String str2;
    FormSimpleItem localFormSimpleItem;
    String str1;
    if (this.bBH)
    {
      this.cnz = aqlw.b(BaseApplicationImpl.getContext(), "com.tencent.mobileqq_preferences").getInt("special_care_id_cache" + this.bfa, 1);
      str2 = this.b.da(this.cnz);
      localFormSimpleItem = this.as;
      if (TextUtils.isEmpty(str2)) {}
      for (str1 = getString(2131696373);; str1 = str2)
      {
        localFormSimpleItem.setRightText(str1);
        if (QLog.isColorLevel()) {
          QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice FromForwardFriendActivity mFriUin: " + this.bfa + ", soundId: " + this.cnz + ", soundName: " + str2);
        }
        return;
      }
    }
    if (abbf.e(this.bfa, this.app))
    {
      if (!this.b.XO()) {
        cAL();
      }
      int i = abbf.a(this.bfa, this.app);
      str2 = this.b.da(i);
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice mFriUin: " + this.bfa + ", soundId: " + i + ", soundName: " + str2);
      }
      localFormSimpleItem = this.as;
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = getString(2131696373);
      }
      localFormSimpleItem.setRightText(str1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice not contain friend: " + this.bfa);
    }
    this.as.setRightText(getString(2131696373));
  }
  
  private void initData()
  {
    this.b = new QvipSpecialSoundManager(this, this.app);
    if (!this.b.XO())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "QvipSpecialSoundManager no cache data.");
      }
      cAL();
    }
    this.jdField_a_of_type_Aqdf = new aqdf(this, this.app);
    this.jdField_a_of_type_Aqdf.a(this);
    Object localObject = this.jdField_a_of_type_Aqdf.a(1, this.bfa, 0);
    if (localObject == null)
    {
      if (!this.jdField_a_of_type_Aqdf.isPausing()) {
        this.jdField_a_of_type_Aqdf.i(this.bfa, 1, true);
      }
      this.wR.setBackgroundDrawable((BitmapDrawable)aqhu.aU());
    }
    for (;;)
    {
      localObject = this.k.b(this.bfa);
      if (localObject != null) {
        break;
      }
      this.nickName.setText(this.bfa);
      return;
      this.wR.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    this.nickName.setText(((Friends)localObject).getFriendNickWithAlias());
  }
  
  private void initUI()
  {
    this.as = ((FormSimpleItem)findViewById(2131373022));
    this.as.setOnClickListener(this);
    this.aK = ((FormSwitchItem)findViewById(2131367699));
    this.aK.setVisibility(8);
    this.aK.setOnCheckedChangeListener(this);
    this.aL = ((FormSwitchItem)findViewById(2131367714));
    this.aL.setOnCheckedChangeListener(this);
    this.Aq = findViewById(2131376228);
    this.Ar = findViewById(2131364223);
    this.Ar.setOnClickListener(this);
    this.wR = ((ImageView)findViewById(2131366681));
    this.nickName = ((TextView)findViewById(2131372384));
    if (this.bBH)
    {
      setLeftViewName(2131721053);
      setRightButton(2131721066, new abaz(this));
      this.Ar.setVisibility(8);
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack)
      {
        this.aK.setContentDescription(getString(2131701728));
        this.aL.setContentDescription(getString(2131701729));
      }
      return;
      setLeftViewName(2131695655);
    }
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
    setContentView(2131561714);
    setTitle(2131701733);
    paramBundle = getIntent();
    this.bfa = paramBundle.getStringExtra("key_friend_uin");
    this.bBH = paramBundle.getBooleanExtra("key_is_from_friendsforward_activity", false);
    initUI();
    this.c = ((FriendListHandler)this.app.getBusinessHandler(1));
    this.k = ((acff)this.app.getManager(51));
    this.app.addObserver(this.e);
    this.app.addObserver(this.jdField_a_of_type_Ackl);
    initData();
    anot.a(null, "CliOper", "", "", "0X80050E5", "0X80050E5", 0, 0, "0", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "doOnCreate mFriUin: " + this.bfa);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Ackl);
      this.app.removeObserver(this.e);
    }
    if (this.bBH) {
      aqlw.b(BaseApplicationImpl.getContext(), "com.tencent.mobileqq_preferences").edit().remove("special_care_id_cache" + this.bfa).commit();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.bBI = false;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    cAK();
    this.bBI = true;
    if (this.bBJ)
    {
      this.bBJ = false;
      Intent localIntent = new Intent();
      localIntent.setClass(this, SpecailCareListActivity.class);
      localIntent.addFlags(67108864);
      localIntent.putExtra("selfSet_leftViewText", getString(2131697396));
      startActivity(localIntent);
      finish();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onCheckedChanged isCheck: " + paramBoolean + ", switched by user.");
    }
    if (this.bBH)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    if (paramCompoundButton == this.aK.a()) {}
    for (FormSwitchItem localFormSwitchItem = this.aK;; localFormSwitchItem = this.aL)
    {
      if (!aqiw.isNetworkAvailable(this)) {
        break label131;
      }
      this.c.b(i, new String[] { this.bfa }, new boolean[] { paramBoolean });
      break;
      if (paramCompoundButton != this.aL.a()) {
        break;
      }
      i = 3;
    }
    label131:
    Message localMessage = this.mHandler.obtainMessage(8195);
    localMessage.arg1 = 0;
    localMessage.arg2 = 2131693404;
    this.mHandler.sendMessage(localMessage);
    if (!localFormSwitchItem.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      b(localFormSwitchItem, bool);
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (paramView == null) {
      i = 0;
    }
    Object localObject;
    switch (i)
    {
    default: 
    case 2131373022: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        i = paramView.getId();
        break;
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", aqqj.getUrl("specialCareRingUrl") + "&suin=" + this.bfa + "&uin=" + this.app.getCurrentAccountUin() + "&_bid=279&lazy=" + this.bBH);
        ((Intent)localObject).putExtra("uin", this.bfa);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity((Intent)localObject);
      }
    }
    if (aqiw.isNetworkAvailable(this))
    {
      this.c.b(1, new String[] { this.bfa }, new boolean[] { false });
      localObject = this.mHandler.obtainMessage(8193);
      ((Message)localObject).obj = getString(2131701718);
      this.mHandler.sendMessage((Message)localObject);
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "0X80050E6", "0X80050E6", 0, 0, "0", "", "", "");
      break;
      localObject = this.mHandler.obtainMessage(8195);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).arg2 = 2131693404;
      this.mHandler.sendMessage((Message)localObject);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Aqdf.isPausing())) {
      return;
    }
    this.wR.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity
 * JD-Core Version:    0.7.0.1
 */