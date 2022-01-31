import NearbyGroup.GroupArea;
import NearbyGroup.GroupInfo;
import NearbyGroup.RspActivity;
import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import NearbyGroup.RspTopic;
import NearbyGroup.XiaoQuInfo;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.mobileqq.troop.data.GroupAreaWrapper;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import java.util.ArrayList;
import java.util.Iterator;

public class eim
  extends LBSObserver
{
  public eim(NearbyTroopsView paramNearbyTroopsView) {}
  
  protected void a(boolean paramBoolean1, RspGetAreaList paramRspGetAreaList, boolean paramBoolean2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.d())) {}
    while ((this.a == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView == null) || (!paramBoolean1) || (paramRspGetAreaList == null) || (paramRspGetAreaList.vGroupArea == null)) {
      return;
    }
    paramRspGetAreaList = paramRspGetAreaList.vGroupArea;
    if (!this.a.jdField_d_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.a(paramRspGetAreaList);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.a(paramRspGetAreaList, paramBoolean2);
  }
  
  protected void a(boolean paramBoolean, RspGetGroupInArea paramRspGetGroupInArea)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.d())) {}
    label25:
    do
    {
      Object localObject2;
      do
      {
        int i;
        int j;
        GroupAreaWrapper localGroupAreaWrapper;
        do
        {
          do
          {
            Iterator localIterator;
            do
            {
              do
              {
                ;;;
                break label25;
                while ((this.a == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null) || (!paramBoolean) || (paramRspGetGroupInArea == null)) {}
                localObject1 = paramRspGetGroupInArea.stGroupArea;
              } while ((localObject1 == null) || (((GroupArea)localObject1).vGroupInfo == null) || (((GroupArea)localObject1).vGroupInfo.size() == 0) || (this.a.c == null) || (this.a.c.size() == 0));
              i = ((GroupArea)localObject1).iLat;
              j = ((GroupArea)localObject1).iLon;
              localObject2 = ((GroupArea)localObject1).strAreaName;
              localIterator = this.a.c.iterator();
            } while (!localIterator.hasNext());
            localGroupAreaWrapper = (GroupAreaWrapper)localIterator.next();
          } while ((localGroupAreaWrapper.jdField_d_of_type_Int != 0) || (localGroupAreaWrapper.jdField_a_of_type_NearbyGroupGroupArea == null));
          paramRspGetGroupInArea = localGroupAreaWrapper.jdField_a_of_type_NearbyGroupGroupArea;
        } while ((paramRspGetGroupInArea.iLat != i) || (paramRspGetGroupInArea.iLon != j) || (!paramRspGetGroupInArea.strAreaName.equals(localObject2)));
        localGroupAreaWrapper.jdField_a_of_type_Boolean = false;
      } while ((paramRspGetGroupInArea.vGroupInfo == null) || (paramRspGetGroupInArea.vGroupInfo.size() == 0));
      Object localObject1 = ((GroupArea)localObject1).vGroupInfo.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GroupInfo)((Iterator)localObject1).next();
        paramRspGetGroupInArea.vGroupInfo.add(localObject2);
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList, this.a.b, this.a.c);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, RspGetNearbyGroup paramRspGetNearbyGroup)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.d())) {
      break label25;
    }
    label25:
    while ((this.a == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null)) {
      return;
    }
    if (paramBoolean2) {
      this.a.a(paramBoolean1);
    }
    if (!paramBoolean1)
    {
      if (this.a.jdField_e_of_type_Boolean)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessage(2);
        return;
      }
      if (!this.a.jdField_e_of_type_Boolean)
      {
        this.a.f.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.c = false;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d(2);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
        return;
      }
    }
    if (paramRspGetNearbyGroup == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessage(2);
      return;
    }
    Object localObject3 = paramRspGetNearbyGroup.vGroupInfo;
    Object localObject2 = paramRspGetNearbyGroup.vXiaoQuInfo;
    Object localObject1 = paramRspGetNearbyGroup.vGroupArea;
    if ((paramRspGetNearbyGroup.dwFlag & 0x1) != 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.a.g = true;
      if (paramBoolean2)
      {
        this.a.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        if (localObject2 == null) {
          break label531;
        }
        this.a.b = new ArrayList(((ArrayList)localObject2).size());
        label243:
        if (localObject1 == null) {
          break label548;
        }
      }
    }
    label531:
    label548:
    for (this.a.c = new ArrayList(((ArrayList)localObject1).size());; this.a.c = new ArrayList())
    {
      this.a.jdField_d_of_type_Int = paramRspGetNearbyGroup.iLat;
      this.a.jdField_e_of_type_Int = paramRspGetNearbyGroup.iLon;
      this.a.f.setVisibility(0);
      Object localObject4 = new GeoPoint(this.a.jdField_d_of_type_Int, this.a.jdField_e_of_type_Int);
      if (1 != this.a.w) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setMyLocation((GeoPoint)localObject4);
      }
      this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getMaxZoomLevel() - 1);
      this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.animateTo((GeoPoint)localObject4);
      this.a.a(this.a.jdField_d_of_type_Int, this.a.jdField_e_of_type_Int);
      if (localObject3 == null) {
        break label565;
      }
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (GroupInfo)((Iterator)localObject3).next();
        if ((this.a.a(((GroupInfo)localObject4).dwGroupFlagExt)) && (paramBoolean2))
        {
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "CliOper", "", "", "Open_group", "Open_group_exp", 45, 0, "", "", "", "");
        }
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.a.g = false;
      break;
      this.a.b = new ArrayList();
      break label243;
    }
    label565:
    if ((localObject2 != null) && (paramBoolean2))
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (XiaoQuInfo)((Iterator)localObject2).next();
        this.a.b.add(localObject3);
      }
    }
    if (localObject1 != null) {
      if ((this.a.w != 1) || (((ArrayList)localObject1).size() <= 0) || (((ArrayList)localObject1).get(0) == null) || (!((GroupArea)((ArrayList)localObject1).get(0)).strAreaName.equals(this.a.j))) {
        break label1243;
      }
    }
    label827:
    label1243:
    for (int i = 1;; i = 0)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label827;
        }
        localObject2 = (GroupArea)((Iterator)localObject1).next();
        if (this.a.c == null) {
          break;
        }
        this.a.c.add(new GroupAreaWrapper((GroupArea)localObject2));
        if ((i != 0) && (((GroupArea)localObject2).strAreaName.equals(this.a.j)))
        {
          localObject3 = (GroupAreaWrapper)this.a.c.get(0);
          this.a.c.set(0, new GroupAreaWrapper((GroupArea)localObject2));
          this.a.c.set(this.a.c.size() - 1, localObject3);
        }
      }
      if ((paramRspGetNearbyGroup.stRspAct != null) && (paramRspGetNearbyGroup.stRspTopic != null) && (paramRspGetNearbyGroup.stRspAct.shShowPos > paramRspGetNearbyGroup.stRspTopic.shShowPos))
      {
        this.a.a(paramRspGetNearbyGroup.stRspAct);
        this.a.a(paramRspGetNearbyGroup.stRspTopic);
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter;
        if (paramRspGetNearbyGroup.iCompletedFlag != 0) {
          break label1066;
        }
      }
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        ((NearbyTroopsExpandableListViewAdapter)localObject1).c = paramBoolean1;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.jdField_d_of_type_Boolean = false;
        if ((!paramBoolean2) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() != 0) || (this.a.c.size() != 0) || (this.a.b.size() != 0)) {
          break label1127;
        }
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "nearbygrp_entry", "Clk_nearbygrp_blank", 0, 0, "", "", "", "");
        if (!this.a.jdField_e_of_type_Boolean) {
          break label1071;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.c = false;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d(1);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
        return;
        this.a.a(paramRspGetNearbyGroup.stRspTopic);
        this.a.a(paramRspGetNearbyGroup.stRspAct);
        break;
      }
      if (!this.a.jdField_e_of_type_Boolean)
      {
        this.a.f.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.c = false;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d(1);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
        return;
      }
      label1127:
      this.a.a(paramRspGetNearbyGroup);
      this.a.f.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList, this.a.b, this.a.c);
      if (paramBoolean2) {
        this.a.j();
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(paramBoolean2);
      if (paramBoolean2) {
        new Thread(new ein(this)).start();
      }
      if (this.a.w != 1) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.f();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eim
 * JD-Core Version:    0.7.0.1
 */