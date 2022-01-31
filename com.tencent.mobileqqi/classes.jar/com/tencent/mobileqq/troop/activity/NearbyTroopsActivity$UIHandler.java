package com.tencent.mobileqq.troop.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import gui;
import java.lang.ref.WeakReference;

public class NearbyTroopsActivity$UIHandler
  extends Handler
{
  private WeakReference a;
  
  public NearbyTroopsActivity$UIHandler(NearbyTroopsActivity paramNearbyTroopsActivity1, NearbyTroopsActivity paramNearbyTroopsActivity2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramNearbyTroopsActivity2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    NearbyTroopsActivity localNearbyTroopsActivity = (NearbyTroopsActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localNearbyTroopsActivity == null) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1: 
          localNearbyTroopsActivity.a(false);
          return;
        case 3: 
          localNearbyTroopsActivity.e();
          localNearbyTroopsActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.B();
          return;
        case 2: 
          localNearbyTroopsActivity.e();
          localNearbyTroopsActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.B();
          NearbyTroopsActivity.a(localNearbyTroopsActivity, 1, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.getString(2131562097));
        }
      } while (!localNearbyTroopsActivity.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d);
      localNearbyTroopsActivity.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d = false;
      localNearbyTroopsActivity.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.notifyDataSetChanged();
      return;
      paramMessage = paramMessage.getData();
      i = (int)paramMessage.getLong("index", 0L);
      j = (int)paramMessage.getLong("count", 0L);
      k = paramMessage.getInt("lat", 0);
      m = paramMessage.getInt("lon", 0);
      paramMessage = paramMessage.getString("name");
    } while ((i == 0) || (j == 0) || (k == 0) || (m == 0) || (TextUtils.isEmpty(paramMessage)));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(paramMessage, k, m, i, j);
    return;
    paramMessage = new gui(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.b.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.animateTo(new GeoPoint(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.d, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.e), paramMessage);
    return;
    localNearbyTroopsActivity.e();
    localNearbyTroopsActivity.g();
    return;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.NearbyTroopsActivity.UIHandler
 * JD-Core Version:    0.7.0.1
 */