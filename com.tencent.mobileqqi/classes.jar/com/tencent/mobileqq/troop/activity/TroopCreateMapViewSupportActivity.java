package com.tencent.mobileqq.troop.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateMapViewSupportActivity
  extends TroopCreateBaseActivity
{
  private static final String jdField_a_of_type_JavaLangString = "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ";
  private static final String c = "73dfcdeff8636c1d3501fa9a2860ebb7";
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  AutoLocationMapView jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView;
  int f = 0;
  
  private void e()
  {
    Object localObject = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getParent();
    ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
    getLayoutInflater().inflate(2130903368, (ViewGroup)localObject, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232306));
    this.f = ((int)getResources().getDimension(2131427567));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView = new AutoLocationMapView(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setId(2131230844);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setBuiltInZoomControls(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView, new RelativeLayout.LayoutParams(-1, this.f));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setVisibility(8);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131230844);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.getLayoutParams();
      localLayoutParams.height = this.f;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        if (paramBoolean1) {
          d();
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.a("LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ", new TroopCreateMapViewSupportActivity.AutoLocationJSCallback(this, paramString));
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.clearAllOverlays();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setVisibility(8);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.getVisibility() != 0) {
      return;
    }
    if (paramBoolean) {}
    for (TroopCreateMapViewSupportActivity.TroopCreateMapViewAnimation localTroopCreateMapViewAnimation = new TroopCreateMapViewSupportActivity.TroopCreateMapViewAnimation(this, 0, this.f);; localTroopCreateMapViewAnimation = new TroopCreateMapViewSupportActivity.TroopCreateMapViewAnimation(this, this.f, 0))
    {
      localTroopCreateMapViewAnimation.setDuration(600L);
      localTroopCreateMapViewAnimation.setFillAfter(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.startAnimation(localTroopCreateMapViewAnimation);
      return;
    }
  }
  
  public void d(String paramString)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(paramString)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("mapViewHeight", this.f);
      a(paramString, localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    e();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onDestroy();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onPause();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onResume();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onStop();
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onRestart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity
 * JD-Core Version:    0.7.0.1
 */