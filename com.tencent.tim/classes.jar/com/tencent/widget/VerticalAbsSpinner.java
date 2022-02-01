package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public abstract class VerticalAbsSpinner
  extends AbsSpinner
{
  View mSelectedView = null;
  
  public VerticalAbsSpinner(Context paramContext)
  {
    super(paramContext);
  }
  
  public VerticalAbsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalAbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public View getSelectedView()
  {
    if ((this.mItemCount > 0) && (this.mSelectedPosition >= 0))
    {
      int i;
      View localView2;
      View localView1;
      if (Math.abs(this.mSelectedPosition - this.mFirstPosition) > getChildCount())
      {
        i = this.mSelectedPosition + this.mItemCount - this.mFirstPosition;
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
        i = this.mSelectedPosition - this.mFirstPosition;
        localView2 = getChildAt(i);
        localView1 = localView2;
      } while (localView2 == null);
      localView2.setTag(String.valueOf(i));
      return localView2;
    }
    return null;
  }
  
  void handleDataChanged()
  {
    super.handleDataChanged();
  }
  
  public void setSelection(int paramInt)
  {
    super.setSelection(paramInt);
    checkSelectionChanged();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    super.setSelection(paramInt, paramBoolean);
    checkSelectionChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.VerticalAbsSpinner
 * JD-Core Version:    0.7.0.1
 */