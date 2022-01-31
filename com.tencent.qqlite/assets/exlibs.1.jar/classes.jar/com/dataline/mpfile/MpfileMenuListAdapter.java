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
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903453, null);
      }
      paramView = (MpfileItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      ((TextView)paramViewGroup.findViewById(2131296761)).setText(paramView.jdField_a_of_type_JavaLangString);
      return paramViewGroup;
    }
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903452, null);
    }
    paramView = (MpfileItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((TextView)paramViewGroup.findViewById(2131296761)).setText(paramView.jdField_a_of_type_JavaLangString);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131296760);
    if (MpfileItemInfo.d == paramView.h)
    {
      localImageView.setImageResource(2130838615);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131361925)))
    {
      localImageView.setImageResource(2130838608);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131361926)))
    {
      localImageView.setImageResource(2130838609);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131361924)))
    {
      localImageView.setImageResource(2130838610);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131361927)))
    {
      localImageView.setImageResource(2130838611);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131361928)))
    {
      localImageView.setImageResource(2130838612);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131361929)))
    {
      localImageView.setImageResource(2130838613);
      return paramViewGroup;
    }
    if (paramView.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131361930)))
    {
      localImageView.setImageResource(2130838614);
      return paramViewGroup;
    }
    localImageView.setImageResource(2130838612);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.mpfile.MpfileMenuListAdapter
 * JD-Core Version:    0.7.0.1
 */