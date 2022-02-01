package com.tencent.mobileqq.multiaio.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class IcsLinearLayout
  extends LinearLayout
{
  private static final int[] lS = { 16843049, 16843561, 16843562 };
  private Drawable mDivider;
  private int mDividerHeight;
  private int mDividerPadding;
  private int mDividerWidth;
  private int mShowDividers;
  
  public IcsLinearLayout(Context paramContext, int paramInt)
  {
    super(paramContext);
    paramContext = paramContext.obtainStyledAttributes(null, lS, paramInt, 0);
    setDividerDrawable(paramContext.getDrawable(0));
    this.mDividerPadding = paramContext.getDimensionPixelSize(2, 0);
    this.mShowDividers = paramContext.getInteger(1, 0);
    paramContext.recycle();
  }
  
  private void drawDividersHorizontal(Canvas paramCanvas)
  {
    int j = getChildCount();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (hasDividerBeforeChildAt(i)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        drawVerticalDivider(paramCanvas, localView.getLeft() - localLayoutParams.leftMargin);
      }
      i += 1;
    }
    if (hasDividerBeforeChildAt(j))
    {
      localView = getChildAt(j - 1);
      if (localView != null) {
        break label119;
      }
    }
    label119:
    for (i = getWidth() - getPaddingRight() - this.mDividerWidth;; i = localView.getRight())
    {
      drawVerticalDivider(paramCanvas, i);
      return;
    }
  }
  
  private void drawDividersVertical(Canvas paramCanvas)
  {
    int j = getChildCount();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (hasDividerBeforeChildAt(i)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        drawHorizontalDivider(paramCanvas, localView.getTop() - localLayoutParams.topMargin);
      }
      i += 1;
    }
    if (hasDividerBeforeChildAt(j))
    {
      localView = getChildAt(j - 1);
      if (localView != null) {
        break label119;
      }
    }
    label119:
    for (i = getHeight() - getPaddingBottom() - this.mDividerHeight;; i = localView.getBottom())
    {
      drawHorizontalDivider(paramCanvas, i);
      return;
    }
  }
  
  private void drawHorizontalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, paramInt, getWidth() - getPaddingRight() - this.mDividerPadding, this.mDividerHeight + paramInt);
    this.mDivider.draw(paramCanvas);
  }
  
  private void drawVerticalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(paramInt, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + paramInt, getHeight() - getPaddingBottom() - this.mDividerPadding);
    this.mDivider.draw(paramCanvas);
  }
  
  private boolean hasDividerBeforeChildAt(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == getChildCount())) {}
    for (;;)
    {
      return false;
      if ((this.mShowDividers & 0x2) != 0)
      {
        paramInt -= 1;
        while (paramInt >= 0)
        {
          if (getChildAt(paramInt).getVisibility() != 8) {
            return true;
          }
          paramInt -= 1;
        }
      }
    }
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = indexOfChild(paramView);
    int j = getOrientation();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (hasDividerBeforeChildAt(i))
    {
      if (j == 1) {
        localLayoutParams.topMargin = this.mDividerHeight;
      }
    }
    else
    {
      int k = getChildCount();
      if ((i == k - 1) && (hasDividerBeforeChildAt(k)))
      {
        if (j != 1) {
          break label109;
        }
        localLayoutParams.bottomMargin = this.mDividerHeight;
      }
    }
    for (;;)
    {
      super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      localLayoutParams.leftMargin = this.mDividerWidth;
      break;
      label109:
      localLayoutParams.rightMargin = this.mDividerWidth;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mDivider != null)
    {
      if (getOrientation() != 1) {
        break label26;
      }
      drawDividersVertical(paramCanvas);
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      return;
      label26:
      drawDividersHorizontal(paramCanvas);
    }
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    boolean bool = false;
    if (paramDrawable == this.mDivider) {
      return;
    }
    this.mDivider = paramDrawable;
    if (paramDrawable != null) {
      this.mDividerWidth = (paramDrawable.getIntrinsicWidth() - 2);
    }
    for (this.mDividerHeight = paramDrawable.getIntrinsicHeight();; this.mDividerHeight = 0)
    {
      if (paramDrawable == null) {
        bool = true;
      }
      setWillNotDraw(bool);
      requestLayout();
      return;
      this.mDividerWidth = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.IcsLinearLayout
 * JD-Core Version:    0.7.0.1
 */