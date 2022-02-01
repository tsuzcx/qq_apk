package com.tencent.mobileqq.onlinestatus.location;

import aiqn;
import aitz;
import aktp;
import akue;
import akuf;
import akug;
import akuh;
import akui;
import akuj;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import aqdf;
import aqdf.a;
import aqhu;
import aqiw;
import auvj;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.location.ui.LocationMapWidget;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class OnlineStatusLocationFragment
  extends PublicBaseFragment
  implements aqdf.a
{
  public ImageView AX;
  TextView WM;
  TextView WN;
  private akue jdField_a_of_type_Akue;
  private aqdf jdField_a_of_type_Aqdf;
  LocationHeadSetView jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHeadSetView;
  private LocationMapWidget b;
  private HashMap<String, a> eA = new HashMap(10);
  private LatLng l;
  private View mContentView;
  private String mNickName;
  private String mUin;
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, akue paramakue)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("Location_Latitude", paramakue.bo);
    localIntent.putExtra("Location_Longtitude", paramakue.bp);
    localIntent.putExtra("Location_PoiDesc", paramakue.bUh);
    localIntent.putExtra("Location_UpdateTime", paramakue.mUpdateTime);
    PublicFragmentActivity.start(paramActivity, localIntent, OnlineStatusLocationFragment.class);
  }
  
  private void initData()
  {
    Intent localIntent = getActivity().getIntent();
    this.mUin = localIntent.getStringExtra("uin");
    this.mNickName = localIntent.getStringExtra("uinname");
    double d1 = localIntent.getDoubleExtra("Location_Latitude", 0.0D);
    double d2 = localIntent.getDoubleExtra("Location_Longtitude", 0.0D);
    String str = localIntent.getStringExtra("Location_PoiDesc");
    long l1 = localIntent.getLongExtra("Location_UpdateTime", 0L);
    this.jdField_a_of_type_Akue = new akue(d1, d2, str);
    this.jdField_a_of_type_Akue.mUpdateTime = l1;
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusLocationFragment", 2, new Object[] { "uin:", this.mUin, " nick:", this.mNickName, " mLocationInfo:", this.jdField_a_of_type_Akue.toString() });
    }
  }
  
  private void initView()
  {
    this.b = ((LocationMapWidget)this.mContentView.findViewById(2131370855));
    this.AX = ((ImageView)this.mContentView.findViewById(2131370860));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHeadSetView = ((LocationHeadSetView)this.mContentView.findViewById(2131368420));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHeadSetView.setHeadSetClickListener(new akuh(this));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHeadSetView.setImmersiveHeight(ImmersiveUtils.getStatusBarHeight(getActivity()));
    this.WM = ((TextView)this.mContentView.findViewById(2131381014));
    this.WN = ((TextView)this.mContentView.findViewById(2131380847));
    Object localObject1 = aktp.j(NetConnInfoCenter.getServerTime(), this.jdField_a_of_type_Akue.mUpdateTime);
    this.WN.setText(this.jdField_a_of_type_Akue.bUh + " " + (String)localObject1);
    if (getActivity().app.getCurrentAccountUin().equals(this.mUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHeadSetView.setTitleText(getResources().getString(2131700552));
      this.WM.setText(String.format(getResources().getString(2131700550), new Object[] { "我的" }));
    }
    for (;;)
    {
      if (auvj.isNightMode()) {
        this.AX.setBackgroundResource(2130841354);
      }
      localObject1 = ((aktp)getActivity().app.getManager(369)).a(this.mUin);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusLocationFragment", 2, new Object[] { "mapInfo:", ((akuf)localObject1).toString() });
      }
      Object localObject2 = new LatLng(this.jdField_a_of_type_Akue.bo, this.jdField_a_of_type_Akue.bp);
      localObject2 = new aiqn(this.mUin, (LatLng)localObject2, 0.0D);
      aiqn localaiqn = new aiqn(getActivity().app.getCurrentAccountUin(), null, 0.0D);
      this.b.a(getActivity(), localaiqn, (aiqn)localObject2, (akuf)localObject1, 20);
      this.AX.setOnClickListener(new akui(this));
      this.b.setListener(new akuj(this));
      this.jdField_a_of_type_Aqdf = new aqdf(getActivity(), (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_Aqdf.a(this);
      if (!aqiw.isNetworkAvailable(getActivity())) {
        QQToast.a(getActivity(), 1, 2131720447, 1).show();
      }
      return;
      this.WM.setText(String.format(getResources().getString(2131700550), new Object[] { this.mNickName }));
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHeadSetView.setTitleText(getResources().getString(2131700551));
    }
  }
  
  public Bitmap E(String paramString)
  {
    Object localObject2 = (a)this.eA.get(paramString);
    long l1 = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l1 - ((a)localObject2).lastUpdateTime < 4000L) && (((a)localObject2).fs != null)) {
        return ((a)localObject2).fs;
      }
      localObject1 = localObject2;
      if (l1 - ((a)localObject2).abT < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new a(null);
      this.eA.put(paramString, localObject1);
    }
    ((a)localObject1).abT = l1;
    localObject2 = this.jdField_a_of_type_Aqdf.b(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Aqdf.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((a)localObject1).lastUpdateTime = l1;
      ((a)localObject1).fs = ((Bitmap)localObject2);
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
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mContentView = paramLayoutInflater.inflate(2131559352, paramViewGroup, false);
    getActivity().overridePendingTransition(2130772077, 17432577);
    paramLayoutInflater = this.mContentView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusLocationFragment", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = aqhu.r(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    a locala = (a)this.eA.get(paramString);
    long l1 = System.currentTimeMillis();
    paramBitmap = locala;
    if (locala == null)
    {
      paramBitmap = new a(null);
      this.eA.put(paramString, paramBitmap);
    }
    paramBitmap.lastUpdateTime = l1;
    paramBitmap.fs = localBitmap;
    this.b.u(paramString, localBitmap);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.b != null) {
      this.b.onDestroy();
    }
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.b != null) {
      this.b.onPause();
    }
    if (getActivity().isFinishing())
    {
      aitz.duv();
      ThreadManager.getUIHandler().postDelayed(new OnlineStatusLocationFragment.5(this), 200L);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.b != null) {
      this.b.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.b != null) {
      this.b.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.b != null) {
      this.b.onStop();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    initData();
    initView();
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView = getActivity();
      paramView.requestPermissions(new akug(this, paramView), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
  
  static class a
  {
    long abT;
    Bitmap fs;
    long lastUpdateTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.OnlineStatusLocationFragment
 * JD-Core Version:    0.7.0.1
 */