package com.tencent.open.agent;

import acfp;
import acms;
import acnd;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import aqha;
import aqju;
import arhz;
import arpt;
import arpz;
import arqa;
import arqb;
import arqc;
import arqd;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wja;

public class BindGroupFragment
  extends PublicBaseFragment
{
  private TextView Bi;
  private TextView GS;
  private List<TroopInfo> Jy = new ArrayList();
  private arpt a;
  private acnd jdField_b_of_type_Acnd = new arqd(this);
  private ListView jdField_b_of_type_ComTencentWidgetListView;
  private String cBA;
  private String cBz;
  private int ekK = -1;
  private FragmentActivity mActivity;
  private QQAppInterface mApp;
  private String mAppId;
  private String mAppName;
  private String mOpenId;
  private Bundle mParams;
  private String mPkgName;
  private arhz mProgress;
  private TextView mRightBtn;
  private View mRootView;
  private TextView mTitleView;
  
  private void WQ(String paramString)
  {
    QQToast.a(this.mActivity, 1, paramString, 0).show(getTitleBarHeight());
  }
  
  private boolean aGY()
  {
    this.mParams = this.mActivity.getIntent().getBundleExtra("key_params");
    if (this.mParams == null)
    {
      QLog.i("TroopAbility.BindGroup.Fragment", 1, "doOnCreate params is null.");
      return false;
    }
    this.mAppId = this.mParams.getString("appid");
    this.mOpenId = this.mParams.getString("openid");
    this.mAppName = this.mParams.getString("app_name");
    this.cBz = this.mParams.getString("organization_name");
    this.cBA = this.mParams.getString("organization_id");
    this.mPkgName = this.mParams.getString("pkg_name");
    if ((TextUtils.isEmpty(this.mAppId)) || (TextUtils.isEmpty(this.mOpenId)))
    {
      QLog.d("TroopAbility.BindGroup.Fragment", 1, "appId: " + this.mAppId + ", openId: " + this.mOpenId + ", return.");
      return false;
    }
    try
    {
      Integer.valueOf(this.mAppId);
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void bpM()
  {
    this.mApp.addObserver(this.jdField_b_of_type_Acnd);
  }
  
  private void bpN()
  {
    this.mApp.removeObserver(this.jdField_b_of_type_Acnd);
  }
  
  private void elb()
  {
    boolean bool = false;
    int j = this.Jy.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      int k = this.ekK + 1;
      this.ekK = k;
      if ((k >= j) || (i > 100)) {
        break;
      }
      localArrayList.add(this.Jy.get(this.ekK));
      i += 1;
    }
    if (this.ekK == j) {
      bool = true;
    }
    ((acms)this.mApp.getBusinessHandler(20)).al(localArrayList, bool);
    QLog.i("TroopAbility.BindGroup.Fragment", 1, "getTroopProfilePageByPage isLastPage: " + bool);
  }
  
  private List<TroopInfo> gM()
  {
    Object localObject = new ArrayList(((TroopManager)this.mApp.getManager(52)).cE());
    ArrayList localArrayList = new ArrayList();
    String str = this.mApp.getCurrentUin();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject).next();
      if (((localTroopInfo.dwAdditionalFlag & 1L) == 1L) || ((localTroopInfo.troopowneruin != null) && (localTroopInfo.troopowneruin.equals(str)))) {
        localArrayList.add(localTroopInfo);
      }
    }
    QLog.i("TroopAbility.BindGroup.Fragment", 1, "getCreateTroopList list size: " + localArrayList.size());
    return localArrayList;
  }
  
  private int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  private void gz(String paramString, int paramInt)
  {
    QLog.i("TroopAbility.BindGroup.Fragment", 1, "enterAIO, troopUin: " + paramString + " action: " + paramInt);
    Intent localIntent = wja.a(new Intent(this.mActivity, SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("fromThirdAppByOpenSDK", true);
    localIntent.putExtra("action", paramInt);
    localIntent.putExtra("appid", this.mAppId);
    localIntent.putExtra("app_name", this.mAppName);
    localIntent.putExtra("pkg_name", this.mPkgName);
    startActivity(localIntent);
  }
  
  private void hideProgress()
  {
    if ((this.mProgress != null) && (this.mProgress.isShowing()) && (this.mActivity.isResume())) {
      this.mProgress.dismiss();
    }
  }
  
  private void iF(String paramString1, String paramString2)
  {
    aqju localaqju = aqha.a(this.mActivity, 230);
    paramString2 = new arqc(this, paramString2);
    localaqju.setMessage(paramString1);
    localaqju.setNegativeButton(acfp.m(2131703206), paramString2);
    localaqju.setPositiveButton(acfp.m(2131703196), paramString2);
    localaqju.show();
  }
  
  private void initViews()
  {
    this.Bi = ((TextView)this.mRootView.findViewById(2131369579));
    this.GS = ((TextView)this.mRootView.findViewById(2131369581));
    this.mRightBtn = ((TextView)this.mRootView.findViewById(2131369612));
    this.mTitleView = ((TextView)this.mRootView.findViewById(2131369627));
    this.jdField_b_of_type_ComTencentWidgetListView = ((ListView)this.mRootView.findViewById(2131370952));
    this.Bi.setVisibility(0);
    this.Bi.setText(this.mAppName);
    this.Bi.setOnClickListener(new arpz(this));
    this.GS.setVisibility(4);
    this.mRightBtn.setVisibility(4);
    this.mTitleView.setText(getResources().getString(2131690860));
    Object localObject = new TextView(this.mActivity);
    ((TextView)localObject).setText(acfp.m(2131703200));
    ((TextView)localObject).setTextSize(1, 14.0F);
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setTextColor(getResources().getColor(2131167383));
    ((TextView)localObject).setPadding(wja.dp2px(16.0F, getResources()), wja.dp2px(16.0F, getResources()), 0, wja.dp2px(8.0F, getResources()));
    this.jdField_b_of_type_ComTencentWidgetListView.addHeaderView((View)localObject);
    localObject = LayoutInflater.from(this.mActivity).inflate(2131560154, null);
    this.jdField_b_of_type_ComTencentWidgetListView.addHeaderView((View)localObject);
    this.a = new arpt(this.mActivity, this.mApp, this.jdField_b_of_type_ComTencentWidgetListView, 4, true);
    this.jdField_b_of_type_ComTencentWidgetListView.setAdapter(this.a);
    this.Jy.addAll(gM());
    this.a.nj(this.Jy);
    ((View)localObject).setOnClickListener(new arqa(this));
    this.jdField_b_of_type_ComTencentWidgetListView.setOnItemClickListener(new arqb(this));
  }
  
  private void showProgress(String paramString)
  {
    if (this.mProgress == null) {
      this.mProgress = new arhz(this.mActivity, getTitleBarHeight());
    }
    hideProgress();
    this.mProgress.setMessage(paramString);
    if (this.mActivity.isResume()) {
      this.mProgress.show();
    }
  }
  
  private void showSuccessToast(String paramString)
  {
    QQToast.a(this.mActivity, 2, paramString, 0).show(getTitleBarHeight());
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("TroopAbility.BindGroup.Fragment", 1, "onCreateView.");
    this.mApp = getActivity().app;
    this.mActivity = getActivity();
    this.mRootView = paramLayoutInflater.inflate(2131560152, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.mRootView.setFitsSystemWindows(true);
      this.mRootView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    if (!aGY()) {
      this.mActivity.finish();
    }
    for (paramLayoutInflater = this.mRootView;; paramLayoutInflater = this.mRootView)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      initViews();
      bpM();
      showProgress(acfp.m(2131703203));
      elb();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bpN();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("doOnNewIntent intent is null: ");
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("TroopAbility.BindGroup.Fragment", 1, bool);
      super.onNewIntent(paramIntent);
      if (paramIntent != null)
      {
        int i = paramIntent.getIntExtra("action", 0);
        paramIntent = paramIntent.getStringExtra("troop_uin");
        if (i == 2)
        {
          gz(paramIntent, 2);
          this.mActivity.finish();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupFragment
 * JD-Core Version:    0.7.0.1
 */