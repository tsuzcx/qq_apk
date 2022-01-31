package com.tencent.mobileqq.troop.activity;

import NearbyGroup.GroupInfo;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.NearbyTroops;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.mobileqq.troop.data.NearbyTroops.MoreBtnViewHolder;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class TroopLocationActivity$TroopsAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  public boolean a;
  public boolean b = false;
  
  public TroopLocationActivity$TroopsAdapter(TroopLocationActivity paramTroopLocationActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    Object localObject = getItem(paramInt);
    if ((localObject instanceof GroupInfo))
    {
      localFaceInfo.jdField_a_of_type_JavaLangString = String.valueOf(((GroupInfo)localObject).lCode);
      localFaceInfo.jdField_a_of_type_Int = 4;
    }
    return localFaceInfo;
  }
  
  public void a(int paramInt)
  {
    Object localObject = (GroupInfo)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localObject == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.i == 10) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.b, "P_CliOper", "Grp_nearby", "", "nearbygrp_map", "Clk_data", 0, 0, String.valueOf(((GroupInfo)localObject).lCode), "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.i == 11) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.b, "P_CliOper", "Grp_set", "", "Grp_data_place", "Clk_data", 0, 0, String.valueOf(((GroupInfo)localObject).lCode), "", "", "");
    }
    localObject = TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.i, (GroupInfo)localObject, 0, false);
    TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.jdField_a_of_type_AndroidContentContext, (Bundle)localObject, 2);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      notifyDataSetChanged();
      if ((paramAbsListView.r() == paramAbsListView.a() - 1) && (!this.b) && (this.jdField_a_of_type_Boolean))
      {
        this.b = true;
        notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$UIHandler.sendEmptyMessage(1);
      }
    }
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if ((paramView != null) && ((paramView.getTag() instanceof NearbyTroops.CustomViewHolder))) {
        break label214;
      }
      paramView = NearbyTroops.d(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.jdField_a_of_type_AndroidContentContext, paramViewGroup);
    }
    label214:
    for (;;)
    {
      NearbyTroops.a(paramView, (GroupInfo)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.b, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.jdField_a_of_type_AndroidContentContext, false, 0L);
      View localView = paramView;
      for (;;)
      {
        paramView = localView.getTag();
        if ((paramView instanceof NearbyTroops.CustomViewHolder))
        {
          paramViewGroup = (NearbyTroops.CustomViewHolder)paramView;
          paramViewGroup.jdField_a_of_type_Int = paramInt;
          GroupInfo localGroupInfo = (GroupInfo)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
          paramViewGroup.c.setImageBitmap(a(4, String.valueOf(localGroupInfo.lCode)));
        }
        if ((paramView instanceof NearbyTroops.MoreBtnViewHolder)) {
          ((NearbyTroops.MoreBtnViewHolder)paramView).jdField_a_of_type_Int = paramInt;
        }
        localView.setOnClickListener(this);
        return localView;
        if (paramInt != this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        if (paramView != null)
        {
          localView = paramView;
          if ((paramView.getTag() instanceof NearbyTroops.MoreBtnViewHolder)) {}
        }
        else
        {
          localView = NearbyTroops.f(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity.jdField_a_of_type_AndroidContentContext, paramViewGroup);
        }
        NearbyTroops.a(localView);
      }
      return null;
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof NearbyTroops.CustomViewHolder)) {
      a(((NearbyTroops.CustomViewHolder)paramView).jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopLocationActivity.TroopsAdapter
 * JD-Core Version:    0.7.0.1
 */