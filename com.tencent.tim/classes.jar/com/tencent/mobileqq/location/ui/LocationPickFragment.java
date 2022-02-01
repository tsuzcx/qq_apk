package com.tencent.mobileqq.location.ui;

import aiqs;
import aira;
import aisj;
import aisq;
import aiss;
import aist;
import aisu;
import aisv;
import aisw;
import aisx;
import aisy;
import aisz;
import aita;
import aitb;
import aitz;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import aqiw;
import auvj;
import ayxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;
import riw;

public class LocationPickFragment
  extends PublicBaseFragment
{
  private static long JZ;
  private aisj jdField_a_of_type_Aisj;
  private LocationRoom.b jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private PoiSlideBottomPanel jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel;
  private View mContentView;
  
  public static void a(Activity paramActivity, int paramInt, String paramString, CameraPosition paramCameraPosition)
  {
    if (!aqiw.isNetworkAvailable()) {
      QQToast.a(paramActivity, 2131695491, 0).show();
    }
    while (System.currentTimeMillis() - JZ < 1000L) {
      return;
    }
    JZ = System.currentTimeMillis();
    if (aitz.av(paramActivity) <= 0)
    {
      QQToast.a(paramActivity, 1, paramActivity.getString(2131696323), 1).show();
      return;
    }
    if (!aiqs.a(((BaseActivity)paramActivity).app).a.ac(paramString, paramInt)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationPickFragment", 2, new Object[] { "[location_fragment]launch: invoked. ", " notSameSession: ", Boolean.valueOf(bool) });
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("FRAGMENT_KEY", "LocationPickFragment");
      localIntent.putExtra("key_last_position", paramCameraPosition.target);
      localIntent.putExtra("key_last_zoom", paramCameraPosition.zoom);
      PublicFragmentActivity.startForResult(paramActivity, localIntent, LocationPickFragment.class, 0);
      return;
    }
  }
  
  private void bTv()
  {
    initData();
    initView();
  }
  
  private void ciy()
  {
    if (auvj.isNightMode()) {
      this.mContentView.findViewById(2131373457).setBackgroundResource(2130838900);
    }
  }
  
  private void due()
  {
    ayxa.initLiuHaiProperty(getActivity());
    int i = ImmersiveUtils.getStatusBarHeight(getActivity());
    View localView = this.mContentView.findViewById(2131373450);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    int j;
    if (ayxa.sHasNotch)
    {
      localView.setPadding(riw.dip2px(getActivity(), 20.0F), ayxa.sNotchHeight, riw.dip2px(getActivity(), 20.0F), 0);
      j = localLayoutParams.height;
    }
    for (localLayoutParams.height = (i + ayxa.sNotchHeight + j);; localLayoutParams.height = (i + localLayoutParams.height))
    {
      localView.setLayoutParams(localLayoutParams);
      return;
      localView.setPadding(riw.dip2px(getActivity(), 20.0F), i, riw.dip2px(getActivity(), 20.0F), 0);
    }
  }
  
  private void dun()
  {
    ayxa.initLiuHaiProperty(getActivity());
    int i = riw.dip2px(getActivity(), 275.0F) - ayxa.sNotchHeight;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel = ((PoiSlideBottomPanel)this.mContentView.findViewById(2131378488));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.setBottomHeight(i);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.setTitleHeightNoDisplay(i);
    View localView1 = this.mContentView.findViewById(2131373447);
    localView1.setOnClickListener(new aiss(this));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.setDragView(localView1);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.findViewById(2131373446);
    View localView2 = this.mContentView.findViewById(2131373450);
    View localView3 = this.mContentView.findViewById(2131371122);
    View localView4 = this.mContentView.findViewById(2131373463);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.setSlidePanelListener(new aist(this, localView3, localView2, localView1, localImageView, localView4));
  }
  
  private void gR()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
    if ((localInputMethodManager != null) && (localInputMethodManager.isActive())) {
      localInputMethodManager.hideSoftInputFromWindow(((EditText)this.mContentView.findViewById(2131366542)).getWindowToken(), 0);
    }
  }
  
  private void initData()
  {
    this.jdField_a_of_type_Aisj = new aisj(getActivity().app);
    Intent localIntent = getActivity().getIntent();
    String str = localIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b = new LocationRoom.b(localIntent.getIntExtra("uintype", -1), str);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void initSearchBar()
  {
    getActivity().getWindow().setSoftInputMode(48);
    View localView1 = this.mContentView.findViewById(2131373463);
    View localView2 = localView1.findViewById(2131363801);
    localView2.setVisibility(8);
    ((TextView)localView1.findViewById(2131380917)).setText("查找集合地点");
    EditText localEditText = (EditText)localView1.findViewById(2131366542);
    localEditText.setOnKeyListener(new aisw(this, localEditText));
    localView2.setOnClickListener(new aisx(this, localEditText));
    localEditText.setImeOptions(3);
    localEditText.setOnHoverListener(new aisy(this));
    localEditText.setOnTouchListener(new aisz(this));
    localView1.findViewById(2131368696).setOnClickListener(new aita(this, localEditText));
    View localView3 = localView1.findViewById(2131380917);
    localEditText.addTextChangedListener(new aitb(this, localView3, localView1.findViewById(2131368696), localView2));
    if (auvj.isNightMode())
    {
      ((TextView)localView3).setTextColor(Color.parseColor("#8E8E93"));
      localEditText.setTextColor(Color.parseColor("#FFFFFF"));
    }
  }
  
  private void initView()
  {
    due();
    Object localObject1 = getActivity();
    this.mContentView.findViewById(2131373468).setOnClickListener(new aisu(this, (Activity)localObject1));
    this.mContentView.findViewById(2131373469).setOnClickListener(new aisv(this, (Activity)localObject1));
    if (auvj.isNightMode()) {
      this.mContentView.findViewById(2131373469).setBackgroundResource(2130846278);
    }
    initSearchBar();
    dun();
    Object localObject2 = (XListView)this.mContentView.findViewById(2131373455);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = ((MapWidget)this.mContentView.findViewById(2131370855));
    aitz.p(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget, "地图 你正在共享位置");
    ImageView localImageView = (ImageView)this.mContentView.findViewById(2131370860);
    aitz.p(localImageView, "在地图区回到我的位置");
    Object localObject3 = ((Activity)localObject1).getIntent();
    localObject3 = CameraPosition.fromLatLngZoom((LatLng)((Intent)localObject3).getParcelableExtra("key_last_position"), ((Intent)localObject3).getFloatExtra("key_last_zoom", 0.0F));
    this.jdField_a_of_type_Aisj.a((Activity)localObject1, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b, (CameraPosition)localObject3, this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget, localImageView, this.mContentView.findViewById(2131373469), this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel, (XListView)localObject2, this.mContentView.findViewById(2131373459), this.mContentView.findViewById(2131373442));
    localObject1 = this.mContentView.findViewById(2131365585);
    localObject2 = this.mContentView.findViewById(2131373450);
    if (auvj.isNightMode())
    {
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setBackgroundColor(Color.parseColor("#CC000000"));
      return;
    }
    ((View)localObject1).setVisibility(8);
    ((View)localObject2).setBackgroundColor(Color.parseColor("#7F000000"));
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.aQZ()))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.hide();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    getActivity().setResult(0);
    getActivity().overridePendingTransition(0, 2130772079);
    return super.onBackEvent();
  }
  
  @SuppressLint({"InflateParams"})
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onCreateView: invoked. this: " + this + " activity: " + getActivity());
    }
    this.mContentView = paramLayoutInflater.inflate(2131559349, null);
    getActivity().overridePendingTransition(2130772077, 2130772079);
    paramLayoutInflater = this.mContentView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onDestroy: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onFinish: invoked. this: " + this + " activity: " + getActivity());
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
      QLog.d("LocationPickFragment", 2, "[location_fragment]onPause: invoked. this: " + this + " isFinishing: " + getActivity().isFinishing() + " activity: " + getActivity());
    }
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onPause();
    }
    if (getActivity().isFinishing()) {
      ThreadManager.getUIHandler().postDelayed(new LocationPickFragment.12(this), 200L);
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onResume: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onResume();
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onStart: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onStart();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onStart();
    }
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onStop: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onStop();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onViewCreated: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onViewCreated(paramView, paramBundle);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView = getActivity();
      paramView.requestPermissions(new aisq(this, paramView), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    for (;;)
    {
      ciy();
      return;
      bTv();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.hide();
    }
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
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment
 * JD-Core Version:    0.7.0.1
 */