package com.tencent.mobileqq.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagItem;
import dwi;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopMemberGagActivity$TroopGagListAdapter
  extends BaseAdapter
  implements View.OnClickListener, ListAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  private TroopMemberGagActivity.GagItemListener jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$GagItemListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public TroopMemberGagActivity$TroopGagListAdapter(TroopMemberGagActivity paramTroopMemberGagActivity, ArrayList paramArrayList, TroopMemberGagActivity.GagItemListener paramGagItemListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$GagItemListener = paramGagItemListener;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramTroopMemberGagActivity = paramArrayList.iterator();
    int i = 0;
    if (paramTroopMemberGagActivity.hasNext())
    {
      paramArrayList = (TroopGagMgr.GagItem)paramTroopMemberGagActivity.next();
      paramGagItemListener = this.jdField_a_of_type_JavaUtilArrayList;
      if (i == 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramGagItemListener.add(new dwi(this, paramArrayList, bool));
        i += 1;
        break;
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130904026, null);
      paramView = new TroopMemberGagActivity.TroopGagListAdapter.Holder(this);
      paramView.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131232685));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131234604));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131234605));
      paramView.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(paramView);
      localView.setTag(paramView);
    }
    paramView = (TroopMemberGagActivity.TroopGagListAdapter.Holder)localView.getTag();
    paramViewGroup = (dwi)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$GagItem.a);
    ImageView localImageView = paramView.jdField_a_of_type_AndroidWidgetImageView;
    if (paramViewGroup.jdField_a_of_type_Boolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      paramView.jdField_a_of_type_Dwi = ((dwi)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      localView.setSelected(true);
      localView.setContentDescription(paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$GagItem.a);
      return localView;
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = (TroopMemberGagActivity.TroopGagListAdapter.Holder)paramView.getTag();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      dwi localdwi = (dwi)localIterator.next();
      if (paramView.jdField_a_of_type_Dwi == localdwi) {
        localdwi.jdField_a_of_type_Boolean = true;
      } else {
        localdwi.jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$GagItemListener.a(paramView.jdField_a_of_type_Dwi.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$GagItem);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberGagActivity.TroopGagListAdapter
 * JD-Core Version:    0.7.0.1
 */