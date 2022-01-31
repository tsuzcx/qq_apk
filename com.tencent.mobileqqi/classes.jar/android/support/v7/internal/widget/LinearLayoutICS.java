package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqqi.R.styleable;

public class LinearLayoutICS
  extends LinearLayout
{
  private static final int SHOW_DIVIDER_BEGINNING = 1;
  private static final int SHOW_DIVIDER_END = 4;
  private static final int SHOW_DIVIDER_MIDDLE = 2;
  private static final int SHOW_DIVIDER_NONE = 0;
  private final Drawable mDivider;
  private final int mDividerHeight;
  private final int mDividerPadding;
  private final int mDividerWidth;
  private final int mShowDividers;
  
  public LinearLayoutICS(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.H);
    this.mDivider = paramContext.getDrawable(0);
    if (this.mDivider != null)
    {
      this.mDividerWidth = this.mDivider.getIntrinsicWidth();
      this.mDividerHeight = this.mDivider.getIntrinsicHeight();
      this.mShowDividers = paramContext.getInt(1, 0);
      this.mDividerPadding = paramContext.getDimensionPixelSize(2, 0);
      paramContext.recycle();
      if (this.mDivider != null) {
        break label105;
      }
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      this.mDividerWidth = 0;
      this.mDividerHeight = 0;
      break;
      label105:
      bool = false;
    }
  }
  
  void drawSupportDividersHorizontal(Canvas paramCanvas)
  {
    int j = getChildCount();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (hasSupportDividerBeforeChildAt(i)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        drawSupportVerticalDivider(paramCanvas, localView.getLeft() - localLayoutParams.leftMargin);
      }
      i += 1;
    }
    if (hasSupportDividerBeforeChildAt(j))
    {
      localView = getChildAt(j - 1);
      if (localView != null) {
        break label119;
      }
    }
    label119:
    for (i = getWidth() - getPaddingRight() - this.mDividerWidth;; i = localView.getRight())
    {
      drawSupportVerticalDivider(paramCanvas, i);
      return;
    }
  }
  
  void drawSupportDividersVertical(Canvas paramCanvas)
  {
    int j = getChildCount();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (hasSupportDividerBeforeChildAt(i)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        drawSupportHorizontalDivider(paramCanvas, localView.getTop() - localLayoutParams.topMargin);
      }
      i += 1;
    }
    if (hasSupportDividerBeforeChildAt(j))
    {
      localView = getChildAt(j - 1);
      if (localView != null) {
        break label119;
      }
    }
    label119:
    for (i = getHeight() - getPaddingBottom() - this.mDividerHeight;; i = localView.getBottom())
    {
      drawSupportHorizontalDivider(paramCanvas, i);
      return;
    }
  }
  
  void drawSupportHorizontalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, paramInt, getWidth() - getPaddingRight() - this.mDividerPadding, this.mDividerHeight + paramInt);
    this.mDivider.draw(paramCanvas);
  }
  
  void drawSupportVerticalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(paramInt, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + paramInt, getHeight() - getPaddingBottom() - this.mDividerPadding);
    this.mDivider.draw(paramCanvas);
  }
  
  public int getSupportDividerWidth()
  {
    return this.mDividerWidth;
  }
  
  protected boolean hasSupportDividerBeforeChildAt(int paramInt)
  {
    if (paramInt == 0) {
      if ((this.mShowDividers & 0x1) == 0) {}
    }
    do
    {
      return true;
      return false;
      if (paramInt != getChildCount()) {
        break;
      }
    } while ((this.mShowDividers & 0x4) != 0);
    return false;
    if ((this.mShowDividers & 0x2) != 0)
    {
      paramInt -= 1;
      for (;;)
      {
        if (paramInt < 0) {
          break label75;
        }
        if (getChildAt(paramInt).getVisibility() != 8) {
          break;
        }
        paramInt -= 1;
      }
    }
    return false;
    label75:
    return false;
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    int j;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.mDivider != null)
    {
      i = indexOfChild(paramView);
      j = getChildCount();
      localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      if (getOrientation() != 1) {
        break label97;
      }
      if (!hasSupportDividerBeforeChildAt(i)) {
        break label67;
      }
      localLayoutParams.topMargin = this.mDividerHeight;
    }
    for (;;)
    {
      super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      label67:
      if ((i == j - 1) && (hasSupportDividerBeforeChildAt(j)))
      {
        localLayoutParams.bottomMargin = this.mDividerHeight;
        continue;
        label97:
        if (hasSupportDividerBeforeChildAt(i)) {
          localLayoutParams.leftMargin = this.mDividerWidth;
        } else if ((i == j - 1) && (hasSupportDividerBeforeChildAt(j))) {
          localLayoutParams.rightMargin = this.mDividerWidth;
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mDivider == null) {
      return;
    }
    if (getOrientation() == 1)
    {
      drawSupportDividersVertical(paramCanvas);
      return;
    }
    drawSupportDividersHorizontal(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.LinearLayoutICS
 * JD-Core Version:    0.7.0.1
 */