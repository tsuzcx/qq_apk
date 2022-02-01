package com.tencent.mobileqq.location.ui;

import aiqs;
import aira;
import airk;
import aitg;
import aitw;
import aitx;
import aitz;
import aivd;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqiw;
import auvj;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.os.MqqHandler;

public class LocationShareFragment
  extends PublicBaseFragment
{
  private static long JZ;
  private LocationRoom.b jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b;
  private HeadSetView jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private aitg d;
  private View mContentView;
  
  private void bTv()
  {
    initData();
    initView();
  }
  
  public static void c(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    if (System.currentTimeMillis() - JZ < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareFragment", 2, new Object[] { "launch: invoked. ", " sLastLaunchTime: ", Long.valueOf(JZ) });
      }
      return;
    }
    JZ = System.currentTimeMillis();
    if (aitz.av(paramActivity) <= 0)
    {
      QQToast.a(paramActivity, 1, paramActivity.getString(2131696323), 1).show();
      return;
    }
    aira localaira = aiqs.a(((BaseActivity)paramActivity).app).a;
    if (!localaira.ac(paramString, paramInt1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareFragment", 2, new Object[] { "[location_fragment]launch: invoked. ", " notSameSession: ", Boolean.valueOf(bool) });
      }
      if (localaira.apC()) {
        break label210;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareFragment", 2, new Object[] { "launch: invoked. not reporting ", " from: ", Integer.valueOf(paramInt2) });
      }
      if (paramInt2 == 1) {
        break;
      }
      airk.b(paramActivity, paramInt1, paramString, paramInt2);
      return;
    }
    d(paramActivity, paramInt1, paramString, paramInt2);
    return;
    label210:
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, new Object[] { "launch: invoked. reporting ", " from: ", Integer.valueOf(paramInt2) });
    }
    if (bool)
    {
      airk.a((BaseActivity)paramActivity, paramInt1, paramString, paramInt2);
      return;
    }
    d(paramActivity, paramInt1, paramString, paramInt2);
  }
  
  public static void d(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("FROM_KEY", paramInt2);
    localIntent.putExtra("FRAGMENT_KEY", "LocationShareFragment");
    PublicFragmentActivity.start(paramActivity, localIntent, LocationShareFragment.class);
  }
  
  private void initData()
  {
    boolean bool = true;
    this.d = new aitg(getActivity().app);
    Object localObject = getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("FROM_KEY", -1);
    aiqs.a(getActivity().app).setFrom(i);
    String str = ((Intent)localObject).getStringExtra("uin");
    int j = ((Intent)localObject).getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b = new LocationRoom.b(j, str);
    localObject = this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView;
    aitg localaitg = this.d;
    LocationRoom.b localb = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b;
    if (i == 1) {}
    for (;;)
    {
      ((HeadSetView)localObject).setLocationController(localaitg, localb, bool);
      localObject = (TextView)this.mContentView.findViewById(2131370868);
      ((TextView)localObject).setOnClickListener(new aitw(this, j, str));
      if (!auvj.isNightMode()) {
        break;
      }
      ((TextView)localObject).setBackgroundResource(2130841380);
      return;
      bool = false;
    }
    ((TextView)localObject).setBackgroundResource(2130841383);
  }
  
  private void initView()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = ((MapWidget)this.mContentView.findViewById(2131370855));
    aitz.p(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget, "地图 你正在共享位置");
    Object localObject = (ImageView)this.mContentView.findViewById(2131370860);
    aitz.p((View)localObject, "在地图区回到我的位置");
    this.d.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b, this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget, this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView.a, (ImageView)localObject, this.mContentView.findViewById(2131370867), this.mContentView.findViewById(2131370868), this.mContentView.findViewById(2131363647));
    localObject = this.mContentView.findViewById(2131365585);
    if (auvj.isNightMode()) {
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      aivd.a(getActivity().app).Ql(1);
      anot.a(null, "CliOper", "", "", "0X800A8BA", "0X800A8BA", 0, 0, "", "0", "0", "");
      return;
      ((View)localObject).setVisibility(8);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.duB();
      if (paramInt2 != -1) {
        break label89;
      }
      paramIntent = (LocationRoom.Venue)paramIntent.getParcelableExtra("key_picked_location");
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareFragment", 2, "[venue] share fragment onActivityResult: venue: " + paramIntent);
      }
      if (paramIntent == null) {
        break label72;
      }
      this.d.setVenue(paramIntent);
    }
    label72:
    label89:
    while (paramInt2 != 1)
    {
      return;
      QQToast.a(getActivity(), 1, 2131695477, 1).show();
      return;
    }
    getActivity().finish();
  }
  
  public boolean onBackEvent()
  {
    getActivity().overridePendingTransition(0, 2130772079);
    FragmentActivity localFragmentActivity = getActivity();
    if (aivd.a(localFragmentActivity.app).a(localFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b)) {
      return super.onBackEvent();
    }
    return true;
  }
  
  @SuppressLint({"InflateParams"})
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onCreateView: invoked. this: " + this + " activity: " + getActivity());
    }
    this.mContentView = paramLayoutInflater.inflate(2131559350, null);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView = ((HeadSetView)this.mContentView.findViewById(2131368420));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView.init();
    getActivity().overridePendingTransition(2130772077, 17432577);
    paramLayoutInflater = this.mContentView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onDestroy: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onFinish: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(0, 2130772079);
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onPause: invoked. this: " + this + " isFinishing: " + getActivity().isFinishing() + " activity: " + getActivity());
    }
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.Lw(false);
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onPause();
    }
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity.isFinishing())
    {
      aitz.duv();
      ThreadManager.getUIHandler().postDelayed(new LocationShareFragment.4(this, localFragmentActivity), 200L);
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onResume: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.Lw(true);
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onResume();
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView.onResume();
    aiqs localaiqs = aiqs.a(getActivity().app);
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b != null) && (localaiqs.a.b(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b))) {
      localaiqs.dj(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.getSessionType(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.xc());
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onStart: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onStart();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onStart();
    }
    ThreadManager.getSubThreadHandler().post(new LocationShareFragment.3(this));
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onStop: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onStop();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onViewCreated: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onViewCreated(paramView, paramBundle);
    paramView = getActivity();
    paramBundle = paramView.getIntent();
    int i = paramBundle.getIntExtra("FROM_KEY", -1);
    String str = paramBundle.getStringExtra("uin");
    int j = paramBundle.getIntExtra("uintype", -1);
    if (!aqiw.isNetworkAvailable()) {
      airk.a(paramView, i, j, str);
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.requestPermissions(new aitx(this, paramView, j, str, i), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    bTv();
  }
  
  public boolean overrideFinish()
  {
    boolean bool = super.overrideFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(0, 2130772079);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareFragment
 * JD-Core Version:    0.7.0.1
 */