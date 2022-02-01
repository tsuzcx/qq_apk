package com.tencent.mobileqq.activity.contacts.device;

import acbn;
import acdl;
import acfd;
import achq;
import aehn;
import aehn.a;
import aehn.b;
import afsf;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import aurf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import syv;
import syw;
import wja;
import zaf;
import zai;
import zaj;
import zak;
import zal;

public class DeviceFragment
  extends ContactsBaseFragment
  implements aehn.b, Handler.Callback
{
  public zaf a;
  public boolean aUE;
  private final acdl jdField_b_of_type_Acdl = new zaj(this);
  private final achq jdField_b_of_type_Achq = new zai(this);
  private final syv jdField_b_of_type_Syv = new zal(this);
  public boolean bqj;
  public boolean bqk;
  protected boolean bql = true;
  private aurf g = new aurf(Looper.getMainLooper(), this);
  private final acfd m = new zak(this);
  protected XListView mListView;
  
  private void cnt()
  {
    Object localObject1 = (syw)this.mApp.getBusinessHandler(51);
    if (((syw)localObject1).Nz())
    {
      DeviceInfo[] arrayOfDeviceInfo = ((syw)localObject1).b();
      if (arrayOfDeviceInfo != null)
      {
        ((syw)localObject1).notifyUI(1, true, new ArrayList(Arrays.asList(arrayOfDeviceInfo)));
        ThreadManager.post(new DeviceFragment.2(this), 5, null, true);
      }
    }
    try
    {
      localObject1 = getActivity().getApplicationContext().getPackageManager().getPackageInfo(getActivity().getApplicationContext().getPackageName(), 0).packageName;
      afsf.a().b(this.mApp, (String)localObject1, 0L);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  public void Av(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DeviceFragment", 2, "doOnResume:" + paramBoolean);
    }
    if (this.mListView == null) {
      return;
    }
    bpM();
    if (this.a == null)
    {
      this.a = new zaf(this.mActivity, this.mApp, this.mListView, 104, true);
      this.mListView.setAdapter(this.a);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    cnt();
    cnu();
    this.a.notifyDataSetChanged();
    this.g.postDelayed(new DeviceFragment.1(this), 500L);
  }
  
  public void Aw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DeviceFragment", 2, "doOnPause:" + paramBoolean);
    }
    if (paramBoolean) {
      bpN();
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (this.mListView == null)
    {
      this.mListView = new XListView(this.mActivity);
      this.mListView.setId(2131370939);
      this.mListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.mListView.setNeedCheckSpringback(true);
      this.mListView.setCacheColorHint(0);
      this.mListView.setDivider(null);
      this.mListView.setOverScrollMode(0);
      this.mListView.setPadding(0, 0, 0, wja.dp2px(54.0F, getResources()));
      this.mListView.setClipToPadding(false);
      this.mListView.setScrollBarStyle(33554432);
      this.mListView.mForContacts = true;
    }
    for (;;)
    {
      return this.mListView;
      paramLayoutInflater = this.mListView.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.mListView);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aehn.a parama)
  {
    if ((parama != null) && ("smart_devices_discovery_config".equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceFragment", 2, "handleConfigForTag smartDeviceDiscoverCfg content = " + parama.strContent);
      }
      ThreadManager.post(new DeviceFragment.7(this, parama), 5, null, true);
    }
  }
  
  public void bpM()
  {
    if ((this.mApp != null) && (this.mk))
    {
      this.mApp.addObserver(this.jdField_b_of_type_Achq);
      this.mApp.addObserver(this.jdField_b_of_type_Acdl);
      this.mApp.addObserver(this.m);
      this.mApp.addObserver(this.jdField_b_of_type_Syv);
      this.mApp.a().a("smart_devices_discovery_config", this);
    }
  }
  
  public void bpN()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a.destroy();
      this.mListView.setAdapter(null);
      this.a = null;
    }
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.jdField_b_of_type_Achq);
      this.mApp.removeObserver(this.jdField_b_of_type_Acdl);
      this.mApp.removeObserver(this.m);
      this.mApp.removeObserver(this.jdField_b_of_type_Syv);
      this.mApp.a().b("smart_devices_discovery_config", this);
    }
  }
  
  public void cnu()
  {
    boolean bool = true;
    if (BaseApplication.getContext().getSharedPreferences(this.mApp.getCurrentAccountUin() + "smart_device_discovery_config_file", 0).getInt("smart_device_discovery_config_switch", 1) == 1) {}
    for (;;)
    {
      this.bql = bool;
      if (this.a != null) {
        this.a.Bj(this.bql);
      }
      return;
      bool = false;
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DeviceFragment", 2, "doOnDestroy");
    }
    if (this.a != null)
    {
      this.a.clear();
      this.a.destroy();
    }
    bpN();
    this.g.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (paramMessage.arg1 == 1)
    {
      bool1 = true;
      label36:
      if (bool1 == this.bql) {
        break label88;
      }
      if (this.bql) {
        break label90;
      }
    }
    label88:
    label90:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bql = bool1;
      if (this.a == null) {
        break;
      }
      this.a.Bj(this.bql);
      this.a.notifyDataSetChanged();
      return false;
      bool1 = false;
      break label36;
      break;
    }
  }
  
  public void refresh()
  {
    syw localsyw = (syw)this.mApp.getBusinessHandler(51);
    if (localsyw != null)
    {
      if (!localsyw.Nz()) {
        break label34;
      }
      this.aUE = true;
      localsyw.updateDeviceStatus();
    }
    label34:
    while (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$b == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$b.d(xZ(), true, null);
  }
  
  public void resetData()
  {
    if ((this.mk) && (this.mListView != null))
    {
      this.a = new zaf(this.mActivity, this.mApp, this.mListView, 104, true);
      this.mListView.setAdapter(this.a);
      this.a.am(this.bqj, acbn.bkw);
      this.a.am(this.bqk, acbn.bkx);
      cnu();
      this.a.notifyDataSetChanged();
      cnt();
    }
    for (;;)
    {
      this.g.removeCallbacksAndMessages(null);
      return;
      if (this.a != null) {
        this.a.bm(this.mApp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment
 * JD-Core Version:    0.7.0.1
 */