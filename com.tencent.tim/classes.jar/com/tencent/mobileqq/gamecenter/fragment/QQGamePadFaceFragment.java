package com.tencent.mobileqq.gamecenter.fragment;

import ahrx;
import ahsj;
import ahsk;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anec;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import org.json.JSONException;
import org.json.JSONObject;
import wyw;
import wyw.b;

public class QQGamePadFaceFragment
  extends PublicBaseFragment
  implements wyw.b
{
  private ahrx jdField_a_of_type_Ahrx;
  private anec jdField_a_of_type_Anec;
  private PadFaceAd jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd;
  private wyw b;
  private boolean chX;
  private ArkAppView g;
  private QQAppInterface mApp;
  
  public static void a(Activity paramActivity, PadFaceAd paramPadFaceAd)
  {
    paramPadFaceAd = ahrx.a(paramPadFaceAd, null);
    paramPadFaceAd.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.b.startForResult(paramActivity, paramPadFaceAd, PublicTransFragmentActivity.class, QQGamePadFaceFragment.class, 10000);
  }
  
  private void dpB()
  {
    int j = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd == null) {
      return;
    }
    PadFaceAd localPadFaceAd = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd;
    this.b = new wyw();
    this.b.a(localPadFaceAd.appName, localPadFaceAd.appView, localPadFaceAd.appVersion, localPadFaceAd.arkMeta, getResources().getDisplayMetrics().scaledDensity, new SessionInfo());
    for (;;)
    {
      try
      {
        i = new JSONObject(localPadFaceAd.arkMeta).optInt("fullScreen", 1);
        if (i != 0) {
          continue;
        }
        i = 0;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("QQGamePadFaceFragment", 2, localJSONException, new Object[0]);
        int i = 1;
        continue;
        i = -1;
        continue;
      }
      if (i == 0) {
        continue;
      }
      j = this.g.getWidth();
      i = this.g.getHeight();
      this.b.setFixSize(j, i);
      this.b.setMaxSize(j, i);
      this.b.setHintSize(j, i);
      this.b.setMinSize(j, i);
      this.b.fI(j, i);
      this.b.a(this);
      this.g.setLoadCallback(new ahsk(this));
      this.g.a(this.b, null);
      this.g.setVisibility(0);
      this.g.setOnTouchListener(this.g);
      return;
      i = 1;
    }
  }
  
  private void dpC()
  {
    getActivity().finish();
    getActivity().overridePendingTransition(0, 0);
  }
  
  public boolean a(wyw paramwyw)
  {
    dpC();
    return true;
  }
  
  public boolean a(wyw paramwyw, String paramString1, String paramString2)
  {
    return false;
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    if (this.b != null) {
      this.b.doOnEvent(2);
    }
  }
  
  public boolean onBackEvent()
  {
    dpC();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mApp = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Anec = ((anec)this.mApp.getManager(12));
    this.jdField_a_of_type_Ahrx = this.jdField_a_of_type_Anec.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd = ahrx.a(getActivity().getIntent());
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd == null) {
      getActivity().finish();
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.isValid());
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.redPointId > 0) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd = this.jdField_a_of_type_Ahrx.c(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.redPointId);
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.isValid()));
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.g = new ArkAppView(getActivity(), null);
    this.g.setBorderType(0);
    paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
    paramLayoutInflater.addRule(13);
    paramBundle = new RelativeLayout(paramViewGroup.getContext());
    paramBundle.addView(this.g, paramLayoutInflater);
    paramViewGroup.addView(paramBundle, -1, -1);
    this.g.addOnLayoutChangeListener(new ahsj(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, null);
    return null;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    Object localObject;
    int i;
    if (paramBoolean)
    {
      localObject = getActivity().getWindow().getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        localObject = (ViewGroup)localObject;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < ((ViewGroup)localObject).getChildCount())
      {
        View localView = ((ViewGroup)localObject).getChildAt(i);
        if ((localView.getClass() == View.class) && (localView.getVisibility() == 0)) {
          ((ViewGroup)localObject).removeViewAt(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment
 * JD-Core Version:    0.7.0.1
 */