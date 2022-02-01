package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;

public class DragSortItemView
  extends ViewGroup
{
  private int mGravity = 48;
  
  public DragSortItemView(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
  }
  
  public int getGravity()
  {
    return this.mGravity;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = super.getChildAt(0);
    if (localView == null) {
      return;
    }
    if (this.mGravity == 48)
    {
      localView.layout(0, 0, super.getMeasuredWidth(), localView.getMeasuredHeight());
      return;
    }
    localView.layout(0, super.getMeasuredHeight() - localView.getMeasuredHeight(), super.getMeasuredWidth(), super.getMeasuredHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    View localView = super.getChildAt(0);
    if (localView == null)
    {
      super.setMeasuredDimension(0, j);
      return;
    }
    if (localView.isLayoutRequested()) {
      super.measureChild(localView, paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    paramInt1 = i;
    ViewGroup.LayoutParams localLayoutParams;
    if (paramInt2 == 0)
    {
      localLayoutParams = super.getLayoutParams();
      if (localLayoutParams.height <= 0) {
        break label90;
      }
    }
    label90:
    for (paramInt1 = localLayoutParams.height;; paramInt1 = localView.getMeasuredHeight())
    {
      super.setMeasuredDimension(j, paramInt1);
      return;
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.mGravity = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortItemView
 * JD-Core Version:    0.7.0.1
 */