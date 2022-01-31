package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import bps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopPrivilegeActivity$PrivilegeAdapter
  extends BaseAdapter
{
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public TroopPrivilegeActivity$PrivilegeAdapter(TroopPrivilegeActivity paramTroopPrivilegeActivity) {}
  
  public void a(String paramString, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bps localbps = (bps)localIterator.next();
      if ((localbps != null) && (localbps.jdField_a_of_type_JavaLangString != null) && (localbps.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        localbps.jdField_a_of_type_Int = paramInt;
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilList.add(new bps(this, paramString, paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = ((LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.getSystemService("layout_inflater")).inflate(2130903335, paramViewGroup, false);
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity);
    }
    paramView = (TextView)localView.findViewById(2131296458);
    paramViewGroup = (TextView)localView.findViewById(2131297747);
    bps localbps = (bps)getItem(paramInt);
    paramView.setText(localbps.jdField_a_of_type_JavaLangString);
    paramViewGroup.setText(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.a(localbps.jdField_a_of_type_Int));
    localView.setTag(localbps);
    if ((paramInt > 1) || (paramInt == getCount() - 1))
    {
      localView.setBackgroundResource(2130837944);
      return localView;
    }
    localView.setBackgroundResource(2130837945);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopPrivilegeActivity.PrivilegeAdapter
 * JD-Core Version:    0.7.0.1
 */