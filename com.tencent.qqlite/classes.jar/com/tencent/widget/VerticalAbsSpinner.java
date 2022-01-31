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
    if ((this.aA > 0) && (this.az >= 0))
    {
      int i;
      View localView2;
      View localView1;
      if (Math.abs(this.az - this.ao) > getChildCount())
      {
        i = this.az + this.aA - this.ao;
        localView2 = getChildAt(i);
        localView1 = localView2;
        if (localView2 != null)
        {
          localView2.setTag(String.valueOf(i));
          localView1 = localView2;
        }
      }
      do
      {
        return localView1;
        i = this.az - this.ao;
        localView2 = getChildAt(i);
        localView1 = localView2;
      } while (localView2 == null);
      localView2.setTag(String.valueOf(i));
      return localView2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.widget.VerticalAbsSpinner
 * JD-Core Version:    0.7.0.1
 */