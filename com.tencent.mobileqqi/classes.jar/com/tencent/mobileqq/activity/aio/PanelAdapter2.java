package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class PanelAdapter2
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public PanelAdapter2(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public View.OnClickListener a()
  {
    return this.jdField_a_of_type_AndroidViewView$OnClickListener;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
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
    PlusPanel.PluginData localPluginData = (PlusPanel.PluginData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramViewGroup = new PanelAdapter2.ViewHolder();
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903120, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131231293));
      paramViewGroup.b = ((ImageView)localView.findViewById(2131231295));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131231294));
      localView.setTag(paramViewGroup);
      paramView = paramViewGroup;
      paramViewGroup = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localPluginData.jdField_a_of_type_JavaLangString);
      if (!localPluginData.jdField_a_of_type_Boolean) {
        break label177;
      }
      paramViewGroup.b.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = localPluginData.jdField_a_of_type_Int;
      localView.setContentDescription(localPluginData.b);
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return localView;
      paramViewGroup = (PanelAdapter2.ViewHolder)paramView.getTag();
      localView = paramView;
      break;
      label177:
      paramViewGroup.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PanelAdapter2
 * JD-Core Version:    0.7.0.1
 */