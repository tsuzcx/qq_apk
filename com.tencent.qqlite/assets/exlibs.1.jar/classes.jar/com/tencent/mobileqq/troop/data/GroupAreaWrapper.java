package com.tencent.mobileqq.troop.data;

import NearbyGroup.GroupArea;
import NearbyGroup.GroupInfo;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import java.util.ArrayList;

public class GroupAreaWrapper
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public GroupArea a;
  public GroupAreaWrapper.ActivityInfo a;
  public GroupAreaWrapper.TopicInfo a;
  public boolean a;
  public int d = 0;
  
  public GroupAreaWrapper()
  {
    this.jdField_a_of_type_NearbyGroupGroupArea = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$ActivityInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$TopicInfo = null;
  }
  
  public GroupAreaWrapper(GroupArea paramGroupArea)
  {
    this.jdField_a_of_type_NearbyGroupGroupArea = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$ActivityInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$TopicInfo = null;
    this.d = 0;
    this.jdField_a_of_type_NearbyGroupGroupArea = paramGroupArea;
  }
  
  public GroupAreaWrapper(GroupAreaWrapper.ActivityInfo paramActivityInfo)
  {
    this.jdField_a_of_type_NearbyGroupGroupArea = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$ActivityInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$TopicInfo = null;
    this.d = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$ActivityInfo = paramActivityInfo;
  }
  
  public GroupAreaWrapper(GroupAreaWrapper.TopicInfo paramTopicInfo)
  {
    this.jdField_a_of_type_NearbyGroupGroupArea = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$ActivityInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$TopicInfo = null;
    this.d = 2;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$TopicInfo = paramTopicInfo;
  }
  
  public int a()
  {
    int i = 1;
    if (this.d == 0) {
      if ((this.jdField_a_of_type_NearbyGroupGroupArea != null) && (this.jdField_a_of_type_NearbyGroupGroupArea.vGroupInfo != null)) {}
    }
    while ((this.d != 1) && (this.d != 2))
    {
      return 0;
      int j = this.jdField_a_of_type_NearbyGroupGroupArea.vGroupInfo.size();
      if (this.jdField_a_of_type_NearbyGroupGroupArea.dwGroupTotalCnt > this.jdField_a_of_type_NearbyGroupGroupArea.vGroupInfo.size()) {}
      for (;;)
      {
        return j + i;
        i = 0;
      }
    }
    return 1;
  }
  
  public GroupInfo a(int paramInt)
  {
    if (this.d == 0)
    {
      ArrayList localArrayList = this.jdField_a_of_type_NearbyGroupGroupArea.vGroupInfo;
      if (localArrayList != null) {
        return (GroupInfo)localArrayList.get(paramInt);
      }
    }
    return null;
  }
  
  public View a(Context paramContext, int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    NearbyTroops.GroupViewHolder localGroupViewHolder = null;
    if (paramView != null) {
      localGroupViewHolder = (NearbyTroops.GroupViewHolder)paramView.getTag();
    }
    if (this.d == 0)
    {
      if ((localGroupViewHolder == null) || (localGroupViewHolder.a != 3)) {
        paramView = NearbyTroops.b(paramContext, paramViewGroup);
      }
      NearbyTroops.a(paramView, this.jdField_a_of_type_NearbyGroupGroupArea.strAreaName, (float)this.jdField_a_of_type_NearbyGroupGroupArea.dwGroupTotalCnt, (float)this.jdField_a_of_type_NearbyGroupGroupArea.dwDistance, paramBoolean);
    }
    while ((localGroupViewHolder != null) && (localGroupViewHolder.a == 1)) {
      return paramView;
    }
    return NearbyTroops.a(paramContext, paramViewGroup);
  }
  
  public View a(NearbyTroopsBaseView.INearbyTroopContext paramINearbyTroopContext, Context paramContext, NearbyTroopsExpandableListViewAdapter paramNearbyTroopsExpandableListViewAdapter, int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup)
  {
    if (this.d == 0)
    {
      ArrayList localArrayList = this.jdField_a_of_type_NearbyGroupGroupArea.vGroupInfo;
      if (localArrayList == null)
      {
        paramNearbyTroopsExpandableListViewAdapter = null;
        return paramNearbyTroopsExpandableListViewAdapter;
      }
      if (paramInt2 == localArrayList.size())
      {
        if (paramView != null)
        {
          paramINearbyTroopContext = paramView;
          if ((paramView.getTag() instanceof NearbyTroops.MoreBtnViewHolder)) {}
        }
        else
        {
          paramINearbyTroopContext = NearbyTroops.e(paramContext, paramViewGroup);
        }
        NearbyTroops.a(paramINearbyTroopContext, this.jdField_a_of_type_Boolean, (int)this.jdField_a_of_type_NearbyGroupGroupArea.dwGroupTotalCnt - localArrayList.size());
        return paramINearbyTroopContext;
      }
      if ((paramView != null) && ((paramView.getTag() instanceof NearbyTroops.CustomViewHolder)) && (!(paramView.getTag() instanceof NearbyTroops.ActivityAndTopicViewHolder))) {
        break label352;
      }
      if (paramInt2 == paramNearbyTroopsExpandableListViewAdapter.getChildrenCount(paramInt1) - 1) {
        paramView = NearbyTroops.a(paramContext, paramViewGroup, true);
      }
    }
    label352:
    for (;;)
    {
      try
      {
        l = Long.parseLong(paramINearbyTroopContext.a());
        NearbyTroops.a(paramView, a(paramInt2), paramContext, false, l);
        paramNearbyTroopsExpandableListViewAdapter.a((NearbyTroops.CustomViewHolder)paramView.getTag(), null);
        return paramView;
        paramView = NearbyTroops.a(paramContext, paramViewGroup, false);
        continue;
      }
      catch (NumberFormatException paramINearbyTroopContext)
      {
        long l = 0L;
        continue;
      }
      if (this.d == 1)
      {
        if (paramView != null)
        {
          paramNearbyTroopsExpandableListViewAdapter = paramView;
          if ((paramView.getTag() instanceof NearbyTroops.ActivityAndTopicViewHolder)) {}
        }
        else
        {
          paramNearbyTroopsExpandableListViewAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$ActivityInfo.a(paramContext, paramViewGroup);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$ActivityInfo.b(paramNearbyTroopsExpandableListViewAdapter);
        ReportController.b(paramINearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "ac", "exp", 0, 0, "", "", "", "");
        return paramNearbyTroopsExpandableListViewAdapter;
      }
      paramNearbyTroopsExpandableListViewAdapter = paramView;
      if (this.d != 2) {
        break;
      }
      if (paramView != null)
      {
        paramNearbyTroopsExpandableListViewAdapter = paramView;
        if ((paramView.getTag() instanceof NearbyTroops.ActivityAndTopicViewHolder)) {}
      }
      else
      {
        paramNearbyTroopsExpandableListViewAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$TopicInfo.a(paramContext, paramViewGroup);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$TopicInfo.b(paramNearbyTroopsExpandableListViewAdapter);
      ReportController.b(paramINearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "post", "exp", 0, 0, "", "", "", "");
      return paramNearbyTroopsExpandableListViewAdapter;
    }
  }
  
  public Object a()
  {
    if (this.d == 0) {
      return this.jdField_a_of_type_NearbyGroupGroupArea;
    }
    if (this.d == 1) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$ActivityInfo;
    }
    if (this.d == 2) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataGroupAreaWrapper$TopicInfo;
    }
    return null;
  }
  
  public void a(Context paramContext, GroupInfo paramGroupInfo, int paramInt)
  {
    if (paramGroupInfo == null) {
      return;
    }
    TroopUtils.a(paramContext, TroopUtils.a(paramInt, paramGroupInfo, 0, false), 2);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.d == 0)
    {
      Object localObject = this.jdField_a_of_type_NearbyGroupGroupArea.vGroupInfo;
      if (localObject != null)
      {
        localObject = (GroupInfo)((ArrayList)localObject).get(paramInt1);
        if (localObject != null)
        {
          ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_nearby", "", "nearbygrp_list", "Clk_data", 0, 0, String.valueOf(((GroupInfo)localObject).lCode), String.valueOf(paramInt4), "", "");
          a(paramContext, (GroupInfo)localObject, paramInt3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.GroupAreaWrapper
 * JD-Core Version:    0.7.0.1
 */