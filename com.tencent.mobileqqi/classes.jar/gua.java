import NearbyGroup.GroupArea;
import NearbyGroup.GroupInfo;
import NearbyGroup.RspActivity;
import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import NearbyGroup.RspTopic;
import NearbyGroup.XiaoQuInfo;
import android.view.View;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity.UIHandler;
import com.tencent.mobileqq.troop.data.GroupAreaWrapper;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import java.util.ArrayList;
import java.util.Iterator;

public class gua
  extends LBSObserver
{
  public gua(NearbyTroopsActivity paramNearbyTroopsActivity) {}
  
  protected void a(boolean paramBoolean1, RspGetAreaList paramRspGetAreaList, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    while ((paramRspGetAreaList == null) || (paramRspGetAreaList.vGroupArea == null)) {
      return;
    }
    paramRspGetAreaList = paramRspGetAreaList.vGroupArea;
    if (!this.a.jdField_b_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.a(paramRspGetAreaList);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.a(paramRspGetAreaList, paramBoolean2);
  }
  
  protected void a(boolean paramBoolean, RspGetGroupInArea paramRspGetGroupInArea)
  {
    if ((!paramBoolean) || (paramRspGetGroupInArea == null))
    {
      return;
      break label94;
      break label94;
    }
    label94:
    do
    {
      int i;
      int j;
      Object localObject2;
      Iterator localIterator;
      do
      {
        do
        {
          localObject1 = paramRspGetGroupInArea.stGroupArea;
        } while ((localObject1 == null) || (((GroupArea)localObject1).vGroupInfo == null) || (((GroupArea)localObject1).vGroupInfo.size() == 0) || (this.a.jdField_c_of_type_JavaUtilArrayList == null) || (this.a.jdField_c_of_type_JavaUtilArrayList.size() == 0));
        i = ((GroupArea)localObject1).iLat;
        j = ((GroupArea)localObject1).iLon;
        localObject2 = ((GroupArea)localObject1).strAreaName;
        localIterator = this.a.jdField_c_of_type_JavaUtilArrayList.iterator();
      } while (!localIterator.hasNext());
      GroupAreaWrapper localGroupAreaWrapper = (GroupAreaWrapper)localIterator.next();
      if ((localGroupAreaWrapper.d != 0) || (localGroupAreaWrapper.jdField_a_of_type_NearbyGroupGroupArea == null)) {
        break;
      }
      paramRspGetGroupInArea = localGroupAreaWrapper.jdField_a_of_type_NearbyGroupGroupArea;
      if ((paramRspGetGroupInArea.iLat != i) || (paramRspGetGroupInArea.iLon != j) || (!paramRspGetGroupInArea.strAreaName.equals(localObject2))) {
        break;
      }
      localGroupAreaWrapper.jdField_a_of_type_Boolean = false;
      if ((paramRspGetGroupInArea.vGroupInfo == null) || (paramRspGetGroupInArea.vGroupInfo.size() == 0)) {
        break;
      }
      Object localObject1 = ((GroupArea)localObject1).vGroupInfo.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GroupInfo)((Iterator)localObject1).next();
        paramRspGetGroupInArea.vGroupInfo.add(localObject2);
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_b_of_type_JavaUtilArrayList, this.a.jdField_c_of_type_JavaUtilArrayList);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, RspGetNearbyGroup paramRspGetNearbyGroup)
  {
    if ((this.a == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null)) {
      return;
    }
    if (paramBoolean2) {
      this.a.a(paramBoolean1);
    }
    if (!paramBoolean1)
    {
      if (this.a.jdField_c_of_type_Boolean)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler.sendEmptyMessage(2);
        return;
      }
      if (!this.a.jdField_c_of_type_Boolean)
      {
        this.a.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.jdField_c_of_type_Boolean = false;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.e(2);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
        return;
      }
    }
    if (paramRspGetNearbyGroup == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler.sendEmptyMessage(2);
      return;
    }
    Object localObject3 = paramRspGetNearbyGroup.vGroupInfo;
    Object localObject2 = paramRspGetNearbyGroup.vXiaoQuInfo;
    Object localObject1 = paramRspGetNearbyGroup.vGroupArea;
    if (paramBoolean2)
    {
      this.a.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (localObject2 == null) {
        break label450;
      }
      this.a.jdField_b_of_type_JavaUtilArrayList = new ArrayList(((ArrayList)localObject2).size());
      if (localObject1 == null) {
        break label467;
      }
    }
    label450:
    label467:
    for (this.a.jdField_c_of_type_JavaUtilArrayList = new ArrayList(((ArrayList)localObject1).size());; this.a.jdField_c_of_type_JavaUtilArrayList = new ArrayList())
    {
      this.a.d = paramRspGetNearbyGroup.iLat;
      this.a.jdField_e_of_type_Int = paramRspGetNearbyGroup.iLon;
      this.a.jdField_e_of_type_AndroidViewView.setVisibility(0);
      Object localObject4 = new GeoPoint(this.a.d, this.a.jdField_e_of_type_Int);
      if (1 != this.a.x) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setMyLocation((GeoPoint)localObject4);
      }
      this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getMaxZoomLevel() - 1);
      this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.animateTo((GeoPoint)localObject4);
      this.a.a(this.a.d, this.a.jdField_e_of_type_Int);
      if (localObject3 == null) {
        break label484;
      }
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (GroupInfo)((Iterator)localObject3).next();
        if ((this.a.a(((GroupInfo)localObject4).dwGroupFlagExt)) && (paramBoolean2))
        {
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Open_group", "Open_group_exp", 45, 0, "", "", "", "");
        }
      }
      this.a.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      break;
    }
    label484:
    if ((localObject2 != null) && (paramBoolean2))
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (XiaoQuInfo)((Iterator)localObject2).next();
        this.a.jdField_b_of_type_JavaUtilArrayList.add(localObject3);
      }
    }
    if (localObject1 != null) {
      if ((this.a.x != 1) || (((ArrayList)localObject1).size() <= 0) || (((ArrayList)localObject1).get(0) == null) || (!((GroupArea)((ArrayList)localObject1).get(0)).strAreaName.equals(this.a.j))) {
        break label1157;
      }
    }
    label1157:
    for (int i = 1;; i = 0)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label746;
        }
        localObject2 = (GroupArea)((Iterator)localObject1).next();
        if (this.a.jdField_c_of_type_JavaUtilArrayList == null) {
          break;
        }
        this.a.jdField_c_of_type_JavaUtilArrayList.add(new GroupAreaWrapper((GroupArea)localObject2));
        if ((i != 0) && (((GroupArea)localObject2).strAreaName.equals(this.a.j)))
        {
          localObject3 = (GroupAreaWrapper)this.a.jdField_c_of_type_JavaUtilArrayList.get(0);
          this.a.jdField_c_of_type_JavaUtilArrayList.set(0, new GroupAreaWrapper((GroupArea)localObject2));
          this.a.jdField_c_of_type_JavaUtilArrayList.set(this.a.jdField_c_of_type_JavaUtilArrayList.size() - 1, localObject3);
        }
      }
      label746:
      if ((paramRspGetNearbyGroup.stRspAct != null) && (paramRspGetNearbyGroup.stRspTopic != null) && (paramRspGetNearbyGroup.stRspAct.shShowPos > paramRspGetNearbyGroup.stRspTopic.shShowPos))
      {
        this.a.a(paramRspGetNearbyGroup.stRspAct);
        this.a.a(paramRspGetNearbyGroup.stRspTopic);
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter;
        if (paramRspGetNearbyGroup.iCompletedFlag != 0) {
          break label980;
        }
      }
      label980:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        ((NearbyTroopsExpandableListViewAdapter)localObject1).jdField_c_of_type_Boolean = paramBoolean1;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d = false;
        if ((!paramBoolean2) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() != 0) || (this.a.jdField_c_of_type_JavaUtilArrayList.size() != 0) || (this.a.jdField_b_of_type_JavaUtilArrayList.size() != 0)) {
          break label1041;
        }
        ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "nearbygrp_entry", "Clk_nearbygrp_blank", 0, 0, "", "", "", "");
        if (!this.a.jdField_c_of_type_Boolean) {
          break label985;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.jdField_c_of_type_Boolean = false;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.e(1);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
        return;
        this.a.a(paramRspGetNearbyGroup.stRspTopic);
        this.a.a(paramRspGetNearbyGroup.stRspAct);
        break;
      }
      label985:
      if (!this.a.jdField_c_of_type_Boolean)
      {
        this.a.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.jdField_c_of_type_Boolean = false;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.e(1);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
        return;
      }
      label1041:
      this.a.a(paramRspGetNearbyGroup);
      this.a.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_b_of_type_JavaUtilArrayList, this.a.jdField_c_of_type_JavaUtilArrayList);
      if (paramBoolean2) {
        this.a.e();
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(paramBoolean2);
      if (paramBoolean2) {
        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new gub(this));
      }
      if (this.a.x != 1) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gua
 * JD-Core Version:    0.7.0.1
 */