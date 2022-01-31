package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import ejy;
import java.lang.ref.WeakReference;

public class NearbyTroopsView$UIHandler
  extends Handler
{
  private WeakReference a;
  
  public NearbyTroopsView$UIHandler(NearbyTroopsView paramNearbyTroopsView1, NearbyTroopsView paramNearbyTroopsView2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramNearbyTroopsView2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    NearbyTroopsView localNearbyTroopsView = (NearbyTroopsView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localNearbyTroopsView == null) {}
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
          localNearbyTroopsView.a(false);
          return;
        case 3: 
          localNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c();
          localNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.B();
          return;
        case 2: 
          localNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c();
          localNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.B();
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(1, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_AndroidContentContext.getString(2131363366));
        }
      } while (!localNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d);
      localNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d = false;
      localNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.notifyDataSetChanged();
      return;
      paramMessage = paramMessage.getData();
      i = (int)paramMessage.getLong("index", 0L);
      j = (int)paramMessage.getLong("count", 0L);
      k = paramMessage.getInt("lat", 0);
      m = paramMessage.getInt("lon", 0);
      paramMessage = paramMessage.getString("name");
    } while ((i == 0) || (j == 0) || (k == 0) || (m == 0) || (TextUtils.isEmpty(paramMessage)));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramMessage, k, m, i, j);
    return;
    paramMessage = new ejy(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.b.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.animateTo(new GeoPoint(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.d, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.e), paramMessage);
    return;
    localNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c();
    localNearbyTroopsView.m();
    return;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler
 * JD-Core Version:    0.7.0.1
 */