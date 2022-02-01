package com.tencent.mobileqq.troop.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;

public class TroopCreateMapViewSupportActivity
  extends TroopCreateBaseActivity
{
  AutoLocationMapView a;
  int dRX = 0;
  RelativeLayout mh;
  
  private void dXz()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getParent();
    localViewGroup.removeView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
    this.mh = ((RelativeLayout)getLayoutInflater().inflate(2131560071, null, true));
    this.dRX = ((int)getResources().getDimension(2131298392));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView = new AutoLocationMapView(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setId(2131374279);
    this.mh.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView, new RelativeLayout.LayoutParams(-1, this.dRX));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131374279);
    this.mh.addView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131377361);
    localViewGroup.addView(this.mh, localLayoutParams);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    dXz();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onDestroy();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onResume();
    }
  }
  
  public void doOnStop()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity
 * JD-Core Version:    0.7.0.1
 */