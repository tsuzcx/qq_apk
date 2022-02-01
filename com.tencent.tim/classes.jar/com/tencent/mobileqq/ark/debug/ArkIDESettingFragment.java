package com.tencent.mobileqq.ark.debug;

import acbn;
import acfp;
import acxw;
import adph;
import adsc;
import adsd;
import adse;
import adsh;
import adsk;
import adsl;
import adsm;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import aqfe;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ArkIDESettingFragment
  extends IphoneTitleBarFragment
{
  public static ArkIDESettingFragment a;
  private TextView QN;
  
  private void Lt(int paramInt)
  {
    adsm.a(paramInt, new adsl(this));
  }
  
  public static ArkIDESettingFragment a()
  {
    if (a == null) {
      a = new ArkIDESettingFragment();
    }
    return a;
  }
  
  public void GQ(String paramString)
  {
    aqfe.J(BaseApplication.getContext(), "ark_ide_state_" + getCurrentUin(), paramString);
  }
  
  protected QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
  }
  
  public void cUg()
  {
    long l = NetConnInfoCenter.getServerTime();
    Object localObject = a();
    if (localObject == null)
    {
      ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
      return;
    }
    localObject = ((QQAppInterface)localObject).a().a();
    RecentUser localRecentUser = ((acxw)localObject).a(acbn.blJ, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    localRecentUser.showUpTime = (System.currentTimeMillis() / 1000L);
    ((acxw)localObject).e(localRecentUser);
    ((acxw)localObject).updateCache(localRecentUser);
    Lt(1);
  }
  
  public void cUh()
  {
    long l = NetConnInfoCenter.getServerTime();
    Object localObject = a();
    if (localObject == null)
    {
      ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
      return;
    }
    localObject = ((QQAppInterface)localObject).a().a();
    RecentUser localRecentUser = ((acxw)localObject).a(acbn.blJ, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    ((acxw)localObject).f(localRecentUser);
    ((acxw)localObject).removeCache(localRecentUser);
  }
  
  public void cUi()
  {
    ArkAppMgr.deleteAllLocalApps();
    ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("App is clear", new Object[0]));
  }
  
  public void cUj()
  {
    Object localObject = a();
    if (localObject == null)
    {
      ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
      return;
    }
    localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
    ArkAppCenter.cTM();
    ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("AppData is clear", new Object[0]));
    ((ArkAppCenter)localObject).a().cTB();
    ((ArkAppCenter)localObject).a().cTz();
    ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("Dict is clear", new Object[0]));
    ArkAppCenter.cTL();
    ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("HttpCache is clear", new Object[0]));
    ArkAppConfigMgr.getInstance().cleanAllConfig();
    ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("AppConfig is clear", new Object[0]));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setTitle(acfp.m(2131702831));
    initView();
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public int getContentLayoutId()
  {
    return 2131561223;
  }
  
  public String getCurrentUin()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
      return "";
    }
    return localQQAppInterface.getCurrentAccountUin();
  }
  
  void initView()
  {
    FormSwitchItem localFormSwitchItem1 = (FormSwitchItem)this.mContentView.findViewById(2131363998);
    FormSwitchItem localFormSwitchItem2 = (FormSwitchItem)this.mContentView.findViewById(2131364000);
    this.QN = ((TextView)this.mContentView.findViewById(2131369983));
    View localView1 = this.mContentView.findViewById(2131363818);
    View localView2 = this.mContentView.findViewById(2131363817);
    View localView3 = this.mContentView.findViewById(2131364036);
    localFormSwitchItem1.setChecked(true);
    localFormSwitchItem1.setOnCheckedChangeListener(new adsc(this));
    if ((!TextUtils.isEmpty(sU())) && (sU().equals("close")))
    {
      localFormSwitchItem2.setChecked(false);
      ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("btnSetupIDE is closed and idestate=%s", new Object[] { sU() }));
    }
    for (;;)
    {
      localFormSwitchItem2.setOnCheckedChangeListener(new adsd(this));
      localView1.setOnClickListener(new adse(this));
      localView2.setOnClickListener(new adsh(this));
      localView3.setOnClickListener(new adsk(this));
      return;
      localFormSwitchItem2.setChecked(true);
      cUg();
      ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("btnSetupIDE is open", new Object[0]));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    adsm.a(1, null);
  }
  
  public String sU()
  {
    return aqfe.get(BaseApplication.getContext(), "ark_ide_state_" + getCurrentUin()).toString();
  }
  
  public void showToast(String paramString)
  {
    int i = this.mContentView.getHeight();
    QQToast.a(BaseApplication.getContext(), paramString, 0).show(i - 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkIDESettingFragment
 * JD-Core Version:    0.7.0.1
 */