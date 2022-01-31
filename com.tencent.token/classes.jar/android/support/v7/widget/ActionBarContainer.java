package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ActionBarContainer
  extends FrameLayout
{
  private View mActionBarView;
  Drawable mBackground;
  private View mContextView;
  private int mHeight;
  boolean mIsSplit;
  boolean mIsStacked;
  private boolean mIsTransitioning;
  Drawable mSplitBackground;
  Drawable mStackedBackground;
  private View mTabContainer;
  
  public ActionBarContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = new ActionBarBackgroundDrawableV21(this);
      ViewCompat.setBackground(this, (Drawable)localObject);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBar);
      this.mBackground = paramContext.getDrawable(R.styleable.ActionBar_background);
      this.mStackedBackground = paramContext.getDrawable(R.styleable.ActionBar_backgroundStacked);
      this.mHeight = paramContext.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
      if (getId() == R.id.split_action_bar)
      {
        this.mIsSplit = true;
        this.mSplitBackground = paramContext.getDrawable(R.styleable.ActionBar_backgroundSplit);
      }
      paramContext.recycle();
      if (!this.mIsSplit) {
        break label143;
      }
      if (this.mSplitBackground != null) {
        break label138;
      }
      bool = true;
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      localObject = new ActionBarBackgroundDrawable(this);
      break;
      label138:
      bool = false;
      continue;
      label143:
      if ((this.mBackground == null) && (this.mStackedBackground == null)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private int getMeasuredHeightWithMargins(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    int j = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (i + j);
  }
  
  private boolean isCollapsed(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0);
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
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.mBackground != null) {
      this.mBackground.jumpToCurrentState();
    }
    if (this.mStackedBackground != null) {
      this.mStackedBackground.jumpToCurrentState();
    }
    if (this.mSplitBackground != null) {
      this.mSplitBackground.jumpToCurrentState();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.mActionBarView = findViewById(R.id.action_bar);
    this.mContextView = findViewById(R.id.action_context_bar);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.mIsTransitioning) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.mTabContainer;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      paramBoolean = true;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        paramInt2 = getMeasuredHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.layout(paramInt1, paramInt2 - localView.getMeasuredHeight() - localLayoutParams.bottomMargin, paramInt3, paramInt2 - localLayoutParams.bottomMargin);
      }
      if (!this.mIsSplit) {
        break label143;
      }
      if (this.mSplitBackground == null) {
        break label323;
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
      paramBoolean = false;
      break;
      label143:
      if (this.mBackground != null) {
        if (this.mActionBarView.getVisibility() == 0) {
          this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
        }
      }
      label195:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        this.mIsStacked = paramBoolean;
        if ((paramBoolean) && (this.mStackedBackground != null))
        {
          this.mStackedBackground.setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          paramInt1 = i;
          break;
          if ((this.mContextView != null) && (this.mContextView.getVisibility() == 0))
          {
            this.mBackground.setBounds(this.mContextView.getLeft(), this.mContextView.getTop(), this.mContextView.getRight(), this.mContextView.getBottom());
            break label195;
          }
          this.mBackground.setBounds(0, 0, 0, 0);
          break label195;
        }
        break;
      }
      label323:
      paramInt1 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.mActionBarView == null)
    {
      i = paramInt2;
      if (View.MeasureSpec.getMode(paramInt2) == -2147483648)
      {
        i = paramInt2;
        if (this.mHeight >= 0) {
          i = View.MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, View.MeasureSpec.getSize(paramInt2)), -2147483648);
        }
      }
    }
    super.onMeasure(paramInt1, i);
    if (this.mActionBarView == null) {}
    do
    {
      return;
      paramInt2 = View.MeasureSpec.getMode(i);
    } while ((this.mTabContainer == null) || (this.mTabContainer.getVisibility() == 8) || (paramInt2 == 1073741824));
    if (!isCollapsed(this.mActionBarView))
    {
      paramInt1 = getMeasuredHeightWithMargins(this.mActionBarView);
      if (paramInt2 != -2147483648) {
        break label172;
      }
    }
    label172:
    for (paramInt2 = View.MeasureSpec.getSize(i);; paramInt2 = 2147483647)
    {
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + getMeasuredHeightWithMargins(this.mTabContainer), paramInt2));
      return;
      if (!isCollapsed(this.mContextView))
      {
        paramInt1 = getMeasuredHeightWithMargins(this.mContextView);
        break;
      }
      paramInt1 = 0;
      break;
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
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.mActionBarView != null) {
        this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
      }
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
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.mIsSplit) && (this.mSplitBackground != null)) {
        this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
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
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.mIsStacked) && (this.mStackedBackground != null)) {
        this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
      }
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
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback, int paramInt)
  {
    if (paramInt != 0) {
      return super.startActionModeForChild(paramView, paramCallback, paramInt);
    }
    return null;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable == this.mBackground) && (!this.mIsSplit)) || ((paramDrawable == this.mStackedBackground) && (this.mIsStacked)) || ((paramDrawable == this.mSplitBackground) && (this.mIsSplit)) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */