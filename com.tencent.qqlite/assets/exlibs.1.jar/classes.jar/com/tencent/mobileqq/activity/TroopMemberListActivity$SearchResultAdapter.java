package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import java.util.List;

public class TroopMemberListActivity$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public TroopMemberListActivity$SearchResultAdapter(TroopMemberListActivity paramTroopMemberListActivity, List paramList)
  {
    super(paramTroopMemberListActivity, paramTroopMemberListActivity.app, paramTroopMemberListActivity.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected Object a(int paramInt)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if (localATroopMember != null) {
      localFaceInfo.a = localATroopMember.a;
    }
    return localFaceInfo;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903689, paramViewGroup, false);
      paramViewGroup = new TroopMemberListActivity.TmViewHolder(paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.f.setTag(localATroopMember.a);
      paramViewGroup.b.setTag(localATroopMember.a);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(localATroopMember.a);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a(paramViewGroup, localATroopMember, a(1, localATroopMember.a), true);
      return paramView;
      paramViewGroup = (TroopMemberListActivity.TmViewHolder)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */