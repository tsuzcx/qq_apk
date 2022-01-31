package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;

public abstract class VerticalAbsSpinner
  extends AbsSpinner
{
  View jdField_a_of_type_AndroidViewView;
  Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  
  public VerticalAbsSpinner(Context paramContext)
  {
    super(paramContext);
    this.a = null;
  }
  
  public VerticalAbsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalAbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = null;
  }
  
  public View a()
  {
    if ((this.aB > 0) && (this.aA >= 0))
    {
      int i;
      Object localObject;
      if (Math.abs(this.aA - this.ap) > getChildCount())
      {
        i = this.aA + this.aB - this.ap;
        localObject = getChildAt(i);
        ((View)localObject).setTag(String.valueOf(i));
      }
      View localView;
      do
      {
        return localObject;
        i = this.aA - this.ap;
        localView = getChildAt(i);
        localObject = localView;
      } while (localView == null);
      localView.setTag(String.valueOf(i));
      return localView;
    }
    return null;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  void p()
  {
    super.p();
  }
  
  public void setSelection(int paramInt)
  {
    super.setSelection(paramInt);
    x();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    super.setSelection(paramInt, paramBoolean);
    x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.VerticalAbsSpinner
 * JD-Core Version:    0.7.0.1
 */