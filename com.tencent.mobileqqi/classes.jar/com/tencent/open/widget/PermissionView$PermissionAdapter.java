package com.tencent.open.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import hot;

public class PermissionView$PermissionAdapter
  extends BaseAdapter
{
  protected PermissionView$PermissionAdapter(PermissionView paramPermissionView) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission != null) {}
    for (int i = this.a.jdField_a_of_type_ArrayOfComTencentOpenWidgetPermissionView$Permission.length; (i <= 17) || (this.a.jdField_a_of_type_Boolean); i = 0) {
      return i;
    }
    return 17;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new PermissionView.Tag();
      localView = View.inflate(this.a.jdField_a_of_type_AndroidContentContext, 2130903335, null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131232126));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131232125));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      this.a.a(paramViewGroup, paramInt);
      localView.setOnClickListener(new hot(this));
      return localView;
      paramViewGroup = (PermissionView.Tag)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.widget.PermissionView.PermissionAdapter
 * JD-Core Version:    0.7.0.1
 */