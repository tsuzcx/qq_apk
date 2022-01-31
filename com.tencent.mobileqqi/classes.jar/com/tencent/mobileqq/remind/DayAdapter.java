package com.tencent.mobileqq.remind;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.widget.VerticalGallery.LayoutParams;

public class DayAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 25;
  private Context jdField_a_of_type_AndroidContentContext;
  
  public DayAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)TypedValue.applyDimension(1, paramInt, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
  }
  
  public View a(int paramInt)
  {
    return getView(paramInt, null, null);
  }
  
  public int getCount()
  {
    return 25568;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    if (paramView == null)
    {
      paramViewGroup = new WheelTextView(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.jdField_a_of_type_Int));
    }
    for (paramView = (WheelTextView)paramViewGroup;; paramView = (View)localObject)
    {
      String str = TimeHelper.a(paramInt);
      localObject = paramView;
      if (paramView == null) {
        localObject = (WheelTextView)paramViewGroup;
      }
      ((WheelTextView)localObject).setTextSize(20.0F);
      ((WheelTextView)localObject).setTextColor(-7829368);
      ((WheelTextView)localObject).setGravity(17);
      ((WheelTextView)localObject).setText(str);
      return paramViewGroup;
      paramViewGroup = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.remind.DayAdapter
 * JD-Core Version:    0.7.0.1
 */