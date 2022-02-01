package com.dataline.mpfile;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MpfileMenuListAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext = null;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List jdField_a_of_type_JavaUtilList;
  
  public MpfileMenuListAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    while (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((MpfileItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).h == MpfileItemInfo.jdField_a_of_type_Int) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903521, null);
      }
      paramView = (MpfileItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      ((TextView)paramViewGroup.findViewById(2131231293)).setText(paramView.jdField_a_of_type_JavaLangString);
      return paramViewGroup;
    }
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903520, null);
    }
    paramView = (MpfileItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((TextView)paramViewGroup.findViewById(2131231293)).setText(paramView.jdField_a_of_type_JavaLangString);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131231292);
    if (MpfileItemInfo.d == paramView.h)
    {
      localImageView.setImageResource(2130838643);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558600)))
    {
      localImageView.setImageResource(2130838636);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558601)))
    {
      localImageView.setImageResource(2130838637);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558599)))
    {
      localImageView.setImageResource(2130838638);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558602)))
    {
      localImageView.setImageResource(2130838639);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558603)))
    {
      localImageView.setImageResource(2130838640);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558604)))
    {
      localImageView.setImageResource(2130838641);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558605)))
    {
      localImageView.setImageResource(2130838642);
      return paramViewGroup;
    }
    localImageView.setImageResource(2130838640);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return ((MpfileItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).h != MpfileItemInfo.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.mpfile.MpfileMenuListAdapter
 * JD-Core Version:    0.7.0.1
 */