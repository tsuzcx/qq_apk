package com.tencent.biz.pubaccount.ecshopassit.view;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashSet;
import kee;
import ken;
import keo;
import ker;
import kes;
import ket;
import kev;

public class EcshopNewPageFragment
  extends IphoneTitleBarFragment
{
  private HashSet<Integer> G = new HashSet();
  private SparseArray<EcshopTabFragment> X = new SparseArray();
  private String YP;
  private CustomTabView jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView;
  private EcshopTabFragment jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment;
  private int aIp;
  public boolean aeA;
  private boolean aez;
  private BroadcastReceiver ah = new kes(this);
  private long mStartTime;
  
  private void a(EcshopTabFragment paramEcshopTabFragment)
  {
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment == null) {
      if (!paramEcshopTabFragment.isAdded()) {
        localFragmentTransaction.add(2131365366, paramEcshopTabFragment).commitAllowingStateLoss();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment = paramEcshopTabFragment;
      return;
      localFragmentTransaction.show(paramEcshopTabFragment).commitAllowingStateLoss();
      continue;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment.a(paramEcshopTabFragment)) {
        if (!paramEcshopTabFragment.isAdded()) {
          localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment).add(2131365366, paramEcshopTabFragment).commitAllowingStateLoss();
        } else {
          localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment).show(paramEcshopTabFragment).commitAllowingStateLoss();
        }
      }
    }
  }
  
  private void aM(Intent paramIntent)
  {
    if (paramIntent != null) {
      this.aIp = paramIntent.getIntExtra("tab_id", 1);
    }
    for (this.YP = paramIntent.getStringExtra("jump_url");; this.YP = getArguments().getString("jump_url", ""))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.oz(this.aIp);
      }
      EcshopTabFragment localEcshopTabFragment = (EcshopTabFragment)this.X.get(this.aIp);
      paramIntent = localEcshopTabFragment;
      if (localEcshopTabFragment == null)
      {
        paramIntent = new EcshopTabFragment();
        this.X.put(this.aIp, paramIntent);
      }
      paramIntent.an(this.aIp, this.YP);
      paramIntent = (EcshopTabFragment)this.X.get(this.aIp);
      if (paramIntent != null) {
        a(paramIntent);
      }
      return;
      this.aIp = getArguments().getInt("tab_id");
    }
  }
  
  private void bU(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView = ((CustomTabView)paramView.findViewById(2131365562));
    if (keo.a(ken.a(), 0, this.aIp))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.b(ken.a());
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.oz(this.aIp);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.setVisibility(8);
  }
  
  private void initView()
  {
    this.vg.setTitle(getResources().getString(2131692999));
    this.vg.setRightImage(getResources().getDrawable(2130851146));
    ((ImageView)this.vg.findViewById(2131369967)).setImageResource(2130851759);
    this.vg.setOnItemSelectListener(new ker(this));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
      this.mContentView.findViewById(2131372394).setVisibility(0);
      this.vg.setBackgroundColor(-16777216);
      return;
    }
    this.mContentView.findViewById(2131372394).setVisibility(8);
  }
  
  public int getContentLayoutId()
  {
    return 2131562092;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    initView();
    bU(this.mContentView);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopNewPageFragment", 2, "[onCreate]");
    }
    super.onCreate(paramBundle);
    try
    {
      if ((!this.aez) && (getActivity() != null))
      {
        getActivity().registerReceiver(this.ah, new IntentFilter("com.tencent.biz.pubaccount.ecshop.tabpage.finish"));
        this.aez = true;
      }
      aM(null);
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        QLog.e("EcshopNewPageFragment", 1, "[onCreate] regist exitreceiver fail " + paramBundle);
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.i("EcshopNewPageFragment", 2, "[onDestroy]");
    super.onDestroy();
    if ((this.X != null) && (this.X.size() > 0))
    {
      int i = 0;
      while (i < this.X.size())
      {
        EcshopTabFragment localEcshopTabFragment = (EcshopTabFragment)this.X.valueAt(i);
        if ((localEcshopTabFragment != null) && (localEcshopTabFragment.a != null)) {
          localEcshopTabFragment.a.onDestroy();
        }
        i += 1;
      }
    }
    if ((this.X != null) && (this.X.size() > 0)) {
      this.X.clear();
    }
    kev.a().a(null, "");
    try
    {
      if ((this.aez) && (getActivity() != null))
      {
        getActivity().unregisterReceiver(this.ah);
        this.aez = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    aM(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.i("EcshopNewPageFragment", 2, " EcshopNewPageFragment [onPause] mCurrentTabId: " + this.aIp + "isJumpToThirdPage: " + this.aeA);
    }
    EcshopTabFragment localEcshopTabFragment = (EcshopTabFragment)this.X.get(this.aIp);
    if ((localEcshopTabFragment != null) && (localEcshopTabFragment.a != null)) {
      localEcshopTabFragment.a.onPause();
    }
    if (this.aeA) {
      return;
    }
    kee.a(null, "gouwu.aio.stay", this.aIp + "", NetConnInfoCenter.getServerTimeMillis() + "", NetConnInfoCenter.getServerTimeMillis() - this.mStartTime + "");
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.i("EcshopNewPageFragment", 2, " EcshopNewPageFragment [onResume] mCurrentTabId: " + this.aIp);
    if (!this.aeA) {
      this.mStartTime = NetConnInfoCenter.getServerTimeMillis();
    }
    this.aeA = false;
    EcshopTabFragment localEcshopTabFragment = (EcshopTabFragment)this.X.get(this.aIp);
    if ((localEcshopTabFragment != null) && (localEcshopTabFragment.a != null)) {
      localEcshopTabFragment.a.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment
 * JD-Core Version:    0.7.0.1
 */