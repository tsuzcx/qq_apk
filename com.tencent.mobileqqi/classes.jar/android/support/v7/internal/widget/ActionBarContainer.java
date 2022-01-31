package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqqi.R.styleable;

public class ActionBarContainer
  extends FrameLayout
{
  private ActionBarView mActionBarView;
  private Drawable mBackground;
  private boolean mIsSplit;
  private boolean mIsStacked;
  private boolean mIsTransitioning;
  private Drawable mSplitBackground;
  private Drawable mStackedBackground;
  private View mTabContainer;
  
  public ActionBarContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundDrawable(null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.c);
    this.mBackground = paramContext.getDrawable(10);
    this.mStackedBackground = paramContext.getDrawable(11);
    if (getId() == 2131230929)
    {
      this.mIsSplit = true;
      this.mSplitBackground = paramContext.getDrawable(12);
    }
    paramContext.recycle();
    if (this.mIsSplit) {
      if (this.mSplitBackground != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      bool = false;
      continue;
      if ((this.mBackground != null) || (this.mStackedBackground != null)) {
        bool = false;
      }
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.mBackground != null) && (this.mBackground.isStateful())) {
      this.mBackground.setState(getDrawableState());
    }
    if ((this.mStackedBackground != null) && (this.mStackedBackground.isStateful())) {
      this.mStackedBackground.setState(getDrawableState());
    }
    if ((this.mSplitBackground != null) && (this.mSplitBackground.isStateful())) {
      this.mSplitBackground.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return this.mTabContainer;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() == 0) || (getHeight() == 0)) {}
    do
    {
      do
      {
        return;
        if (!this.mIsSplit) {
          break;
        }
      } while (this.mSplitBackground == null);
      this.mSplitBackground.draw(paramCanvas);
      return;
      if (this.mBackground != null) {
        this.mBackground.draw(paramCanvas);
      }
    } while ((this.mStackedBackground == null) || (!this.mIsStacked));
    this.mStackedBackground.draw(paramCanvas);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.mActionBarView = ((ActionBarView)findViewById(2131230927));
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.mIsTransitioning) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    boolean bool = false;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int j;
    label93:
    View localView;
    if ((this.mTabContainer != null) && (this.mTabContainer.getVisibility() != 8))
    {
      paramInt2 = 1;
      if ((this.mTabContainer == null) || (this.mTabContainer.getVisibility() == 8)) {
        break label164;
      }
      paramInt4 = getMeasuredHeight();
      j = this.mTabContainer.getMeasuredHeight();
      if ((this.mActionBarView.getDisplayOptions() & 0x2) != 0) {
        break label207;
      }
      int k = getChildCount();
      paramInt4 = 0;
      if (paramInt4 >= k) {
        break label151;
      }
      localView = getChildAt(paramInt4);
      if (localView != this.mTabContainer) {
        break label131;
      }
    }
    for (;;)
    {
      paramInt4 += 1;
      break label93;
      paramInt2 = 0;
      break;
      label131:
      if (!this.mActionBarView.isCollapsed()) {
        localView.offsetTopAndBottom(j);
      }
    }
    label151:
    this.mTabContainer.layout(paramInt1, 0, paramInt3, j);
    label164:
    if (this.mIsSplit)
    {
      if (this.mSplitBackground == null) {
        break label348;
      }
      this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        invalidate();
      }
      return;
      label207:
      this.mTabContainer.layout(paramInt1, paramInt4 - j, paramInt3, paramInt4);
      break;
      if (this.mBackground != null) {
        this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramBoolean = bool;
        if (paramInt2 != 0)
        {
          paramBoolean = bool;
          if (this.mStackedBackground != null) {
            paramBoolean = true;
          }
        }
        this.mIsStacked = paramBoolean;
        if (paramBoolean)
        {
          this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
          paramInt1 = i;
          break;
        }
        break;
      }
      label348:
      paramInt1 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mActionBarView == null) {}
    for (;;)
    {
      return;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mActionBarView.getLayoutParams();
      if (this.mActionBarView.isCollapsed()) {}
      int i;
      for (paramInt1 = 0; (this.mTabContainer != null) && (this.mTabContainer.getVisibility() != 8) && (View.MeasureSpec.getMode(paramInt2) == -2147483648); paramInt1 = localLayoutParams.bottomMargin + (paramInt1 + i))
      {
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + this.mTabContainer.getMeasuredHeight(), paramInt2));
        return;
        paramInt1 = this.mActionBarView.getMeasuredHeight();
        i = localLayoutParams.topMargin;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.mBackground != null)
    {
      this.mBackground.setCallback(null);
      unscheduleDrawable(this.mBackground);
    }
    this.mBackground = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    if (this.mIsSplit) {
      if (this.mSplitBackground != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.mBackground != null) || (this.mStackedBackground != null)) {
        bool = false;
      }
    }
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.mSplitBackground != null)
    {
      this.mSplitBackground.setCallback(null);
      unscheduleDrawable(this.mSplitBackground);
    }
    this.mSplitBackground = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    if (this.mIsSplit) {
      if (this.mSplitBackground != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.mBackground != null) || (this.mStackedBackground != null)) {
        bool = false;
      }
    }
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.mStackedBackground != null)
    {
      this.mStackedBackground.setCallback(null);
      unscheduleDrawable(this.mStackedBackground);
    }
    this.mStackedBackground = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    if (this.mIsSplit) {
      if (this.mSplitBackground != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.mBackground != null) || (this.mStackedBackground != null)) {
        bool = false;
      }
    }
  }
  
  public void setTabContainer(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if (this.mTabContainer != null) {
      removeView(this.mTabContainer);
    }
    this.mTabContainer = paramScrollingTabContainerView;
    if (paramScrollingTabContainerView != null)
    {
      addView(paramScrollingTabContainerView);
      ViewGroup.LayoutParams localLayoutParams = paramScrollingTabContainerView.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      paramScrollingTabContainerView.setAllowCollapse(false);
    }
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    this.mIsTransitioning = paramBoolean;
    if (paramBoolean) {}
    for (int i = 393216;; i = 262144)
    {
      setDescendantFocusability(i);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.mBackground != null) {
        this.mBackground.setVisible(bool, false);
      }
      if (this.mStackedBackground != null) {
        this.mStackedBackground.setVisible(bool, false);
      }
      if (this.mSplitBackground != null) {
        this.mSplitBackground.setVisible(bool, false);
      }
      return;
    }
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable == this.mBackground) && (!this.mIsSplit)) || ((paramDrawable == this.mStackedBackground) && (this.mIsStacked)) || ((paramDrawable == this.mSplitBackground) && (this.mIsSplit)) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */