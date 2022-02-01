package com.tencent.mobileqq.chat.ui;

import acfd;
import acff;
import acms;
import acnd;
import aean;
import aean.a;
import aeat;
import aeau;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import anot;
import aqiw;
import aqqj;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MessageNotificationSettingFragment
  extends IphoneTitleBarFragment
  implements aean.a, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private acfd jdField_a_of_type_Acfd;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FormSwitchItem aQ;
  private FormSwitchItem aR;
  private FormSwitchItem aS;
  private FormSimpleItem at;
  private acff jdField_b_of_type_Acff;
  private acnd jdField_b_of_type_Acnd;
  private aean jdField_b_of_type_Aean;
  private TroopManager jdField_b_of_type_ComTencentMobileqqAppTroopManager;
  private acms c;
  private QQAppInterface mApp;
  private String mUin;
  private int mUinType;
  
  private void bpM()
  {
    this.jdField_a_of_type_Acfd = new aeat(this);
    this.mApp.addObserver(this.jdField_a_of_type_Acfd);
    this.jdField_b_of_type_Acnd = new aeau(this);
    this.mApp.addObserver(this.jdField_b_of_type_Acnd);
    this.jdField_b_of_type_Aean.a(this);
  }
  
  private void cf(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).show();
  }
  
  private void initData()
  {
    Intent localIntent = getActivity().getIntent();
    if (localIntent != null)
    {
      this.mUin = localIntent.getStringExtra("uin");
      this.mUinType = localIntent.getIntExtra("uintype", -1);
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageNotificationSettingFragment", 2, new Object[] { "initData . ", " mUin: " + this.mUin, " mUinType: " + this.mUinType });
    }
    if ((!TextUtils.isEmpty(this.mUin)) && (this.mUinType == -1)) {}
    this.jdField_b_of_type_Aean.eo(this.mUin, this.mUinType);
    if (this.mUinType == 0) {
      anot.a(null, "dc00898", "", "", "0X800A3C7", "0X800A3C7", 1, 0, "", "", "", "");
    }
    while (this.mUinType != 1) {
      return;
    }
    anot.a(null, "dc00898", "", "", "0X800A3C7", "0X800A3C7", 2, 0, "", "", "", "");
  }
  
  private void initViews()
  {
    setTitle(getString(2131696477));
    this.aQ = ((FormSwitchItem)$(2131378096));
    this.aR = ((FormSwitchItem)$(2131378097));
    this.at = ((FormSimpleItem)$(2131378098));
    this.aS = ((FormSwitchItem)$(2131378099));
    Object localObject;
    if (this.mUinType == 0)
    {
      localObject = this.jdField_b_of_type_Acff.a(this.mUin, true);
      if (localObject == null)
      {
        QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "initViews: invoked. ", " extensionInfo: ", localObject });
        this.aQ.setOnCheckedChangeListener(this);
        this.aR.setOnCheckedChangeListener(this);
        this.at.setOnClickListener(this);
        this.aS.setOnCheckedChangeListener(this);
        if (Build.VERSION.SDK_INT >= 29)
        {
          this.aS.setVisibility(8);
          this.aR.setBgType(3);
        }
        if (this.mUinType != 0) {
          break label400;
        }
        VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "bell", "C2C_show", "", 1, 0, 0, "", "", "");
      }
    }
    label214:
    label233:
    while (this.mUinType != 1)
    {
      return;
      FormSwitchItem localFormSwitchItem = this.aQ;
      if (((ExtensionInfo)localObject).messageEnablePreviewNew == 0)
      {
        bool = true;
        localFormSwitchItem.setChecked(bool);
        localFormSwitchItem = this.aR;
        if (((ExtensionInfo)localObject).messageEnableSoundNew != 0) {
          break label265;
        }
        bool = true;
        localFormSwitchItem.setChecked(bool);
        localFormSwitchItem = this.aS;
        if (((ExtensionInfo)localObject).messageEnableVibrateNew != 0) {
          break label270;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        localFormSwitchItem.setChecked(bool);
        break;
        bool = false;
        break label214;
        bool = false;
        break label233;
      }
      if (this.mUinType != 1) {
        break;
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.b(this.mUin);
      if (localObject == null)
      {
        QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "initViews: invoked. ", " troopInfo: ", localObject });
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingFragment", 2, new Object[] { "initViews: invoked. ", " troopInfo.cmdUinFlagEx2: ", Long.valueOf(((TroopInfo)localObject).cmdUinFlagEx2) });
      }
      this.aQ.setChecked(((TroopInfo)localObject).messageEnablePreview());
      this.aR.setChecked(((TroopInfo)localObject).messageEnableSound());
      this.aS.setChecked(((TroopInfo)localObject).messageEnableVibrate());
      break;
    }
    label265:
    label270:
    label400:
    VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "bell", "group_show", "", 1, 0, 0, "", "", "");
  }
  
  public static void launch(Activity paramActivity, Intent paramIntent)
  {
    PublicFragmentActivity.start(paramActivity, paramIntent, MessageNotificationSettingFragment.class);
  }
  
  protected final <T extends View> T $(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public void BC(int paramInt)
  {
    this.jdField_b_of_type_Aean.a(this.at, paramInt, this.mUin, this.mUinType);
  }
  
  public int getContentLayoutId()
  {
    return 2131559351;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int k = 1;
    int m = 1;
    boolean bool2 = true;
    int n = 1;
    int i1 = 1;
    boolean bool3 = true;
    int i2 = 1;
    int i3 = 1;
    boolean bool1 = true;
    Object localObject = new String[1];
    localObject[0] = this.mUin;
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = paramBoolean;
    int j;
    label68:
    int i4;
    if (this.mUinType == 1)
    {
      i = 1;
      if (!paramBoolean) {
        break label152;
      }
      j = 1;
      i4 = (int)NetConnInfoCenter.getServerTime();
      if (this.aQ.a() != paramCompoundButton) {
        break label287;
      }
      if (aqiw.isNetSupport(BaseApplication.getContext())) {
        break label164;
      }
      cf(2131693404, 1);
      this.aQ.setOnCheckedChangeListener(null);
      localObject = this.aQ;
      if (paramCompoundButton.isChecked()) {
        break label158;
      }
      label123:
      ((FormSwitchItem)localObject).setChecked(bool1);
      this.aQ.setOnCheckedChangeListener(this);
    }
    label152:
    label158:
    label164:
    do
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      j = 0;
      break label68;
      bool1 = false;
      break label123;
      if (i != 0)
      {
        this.c.c(this.mUin, this.mApp.getCurrentUin(), j, 1024, i4);
        if (paramBoolean) {}
        for (i = k;; i = 2)
        {
          anot.a(null, "dc00898", "", "", "0X800A3CB", "0X800A3CB", i, 0, "", "", "", "");
          break;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(1, (String[])localObject, arrayOfBoolean);
      if (paramBoolean) {}
      for (i = m;; i = 2)
      {
        anot.a(null, "dc00898", "", "", "0X800A3C8", "0X800A3C8", i, 0, "", "", "", "");
        break;
      }
      if (this.aR.a() == paramCompoundButton)
      {
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          cf(2131693404, 1);
          this.aR.setOnCheckedChangeListener(null);
          localObject = this.aR;
          if (!paramCompoundButton.isChecked()) {}
          for (bool1 = bool2;; bool1 = false)
          {
            ((FormSwitchItem)localObject).setChecked(bool1);
            this.aR.setOnCheckedChangeListener(this);
            break;
          }
        }
        if (i != 0)
        {
          this.c.c(this.mUin, this.mApp.getCurrentUin(), j, 2048, i4);
          if (paramBoolean) {}
          for (i = n;; i = 2)
          {
            anot.a(null, "dc00898", "", "", "0X800A3CC", "0X800A3CC", i, 0, "", "", "", "");
            break;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(2, (String[])localObject, arrayOfBoolean);
        if (paramBoolean) {}
        for (i = i1;; i = 2)
        {
          anot.a(null, "dc00898", "", "", "0X800A3C9", "0X800A3C9", i, 0, "", "", "", "");
          break;
        }
      }
    } while (this.aS.a() != paramCompoundButton);
    label287:
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      cf(2131693404, 1);
      this.aS.setOnCheckedChangeListener(null);
      localObject = this.aS;
      if (!paramCompoundButton.isChecked()) {}
      for (bool1 = bool3;; bool1 = false)
      {
        ((FormSwitchItem)localObject).setChecked(bool1);
        this.aS.setOnCheckedChangeListener(this);
        break;
      }
    }
    if (i != 0)
    {
      this.c.c(this.mUin, this.mApp.getCurrentUin(), j, 4096, i4);
      if (paramBoolean) {}
      for (i = i2;; i = 2)
      {
        anot.a(null, "dc00898", "", "", "0X800A3CD", "0X800A3CD", i, 0, "", "", "", "");
        break;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(3, (String[])localObject, arrayOfBoolean);
    if (paramBoolean) {}
    for (int i = i3;; i = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800A3CA", "0X800A3CA", i, 0, "", "", "", "");
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    label91:
    Intent localIntent;
    String str2;
    int i;
    if (this.mUinType == 0)
    {
      anot.a(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 1, 0, "", "", "", "");
      VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "bell", "C2C_click", "", 1, 0, 0, "", "", "");
      localIntent = new Intent(getActivity(), QQBrowserActivity.class);
      str2 = aqqj.getUrl("specialCareRingUrl");
      if (this.mUinType != 1) {
        break label233;
      }
      i = 1;
      label125:
      if (i == 0) {
        break label238;
      }
    }
    label233:
    label238:
    for (String str1 = "3";; str1 = "2")
    {
      localIntent.putExtra("url", str2.replace("[uid]", this.mUin).replace("[lType]", str1));
      startActivity(localIntent);
      break;
      if (this.mUinType != 1) {
        break label91;
      }
      anot.a(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 3, 0, "", "", "", "");
      VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "bell", "group_click", "", 1, 0, 0, "", "", "");
      break label91;
      i = 0;
      break label125;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
    this.mApp.removeObserver(this.jdField_b_of_type_Acnd);
    this.jdField_b_of_type_Aean.b(this);
  }
  
  public void onResume()
  {
    int j = 0;
    int i = 0;
    super.onResume();
    if (this.mUinType == 0)
    {
      localObject = this.jdField_b_of_type_Acff.a(this.mUin, false);
      if (localObject == null)
      {
        QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "onResume: invoked. ", " extensionInfo: ", localObject });
        this.jdField_b_of_type_Aean.a(this.at, i, this.mUin, this.mUinType);
      }
    }
    while (this.mUinType != 1) {
      for (;;)
      {
        return;
        i = ((ExtensionInfo)localObject).friendRingId;
      }
    }
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.b(this.mUin);
    if (localObject == null) {
      QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "onResume: invoked. ", " troopInfo: ", localObject });
    }
    for (i = j;; i = (int)((TroopInfo)localObject).udwCmdUinRingtoneID)
    {
      this.jdField_b_of_type_Aean.a(this.at, i);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingFragment", 2, new Object[] { "onResume: invoked. ", " troopInfo.cmdUinFlagEx2: ", Long.valueOf(((TroopInfo)localObject).cmdUinFlagEx2) });
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mApp = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.mApp.getBusinessHandler(1));
    this.c = ((acms)this.mApp.getBusinessHandler(20));
    this.jdField_b_of_type_Acff = ((acff)this.mApp.getManager(51));
    this.jdField_b_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.mApp.getManager(52));
    this.jdField_b_of_type_Aean = aean.a(this.mApp);
    initData();
    initViews();
    bpM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment
 * JD-Core Version:    0.7.0.1
 */