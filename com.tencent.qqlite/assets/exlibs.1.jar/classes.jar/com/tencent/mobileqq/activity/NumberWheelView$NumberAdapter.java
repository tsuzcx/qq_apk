package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.widget.VerticalGallery.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class NumberWheelView$NumberAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 30;
  private Context jdField_a_of_type_AndroidContentContext;
  public List a;
  
  public NumberWheelView$NumberAdapter(NumberWheelView paramNumberWheelView, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)TypedValue.applyDimension(1, paramInt1, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
    a(paramInt2, paramInt3);
  }
  
  public View a(int paramInt)
  {
    return getView(paramInt, null, null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    while (paramInt1 <= paramInt2)
    {
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt1));
      paramInt1 += 1;
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
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
      localObject = paramView;
      if (paramView == null) {
        localObject = (WheelTextView)paramViewGroup;
      }
      paramView = String.format("%d", new Object[] { this.jdField_a_of_type_JavaUtilList.get(paramInt) });
      ((WheelTextView)localObject).setTextSize(20.0F);
      ((WheelTextView)localObject).setTextColor(-7829368);
      ((WheelTextView)localObject).setGravity(5);
      ((WheelTextView)localObject).setVisibility(0);
      ((WheelTextView)localObject).setText(paramView);
      return paramViewGroup;
      paramViewGroup = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NumberWheelView.NumberAdapter
 * JD-Core Version:    0.7.0.1
 */