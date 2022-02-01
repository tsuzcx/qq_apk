package com.unnamed.b.atv.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.List;

public class TwoDScrollView
  extends FrameLayout
{
  static final int ANIMATED_SCROLL_GAP = 250;
  static final float MAX_SCROLL_FACTOR = 0.5F;
  private View mChildToScrollTo = null;
  private boolean mIsBeingDragged = false;
  private boolean mIsLayoutDirty = true;
  private float mLastMotionX;
  private float mLastMotionY;
  private long mLastScroll;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private Scroller mScroller;
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private boolean mTwoDScrollViewMovedFocus;
  private VelocityTracker mVelocityTracker;
  
  public TwoDScrollView(Context paramContext)
  {
    super(paramContext);
    initTwoDScrollView();
  }
  
  public TwoDScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initTwoDScrollView();
  }
  
  public TwoDScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initTwoDScrollView();
  }
  
  private boolean canScroll()
  {
    boolean bool2 = false;
    View localView = getChildAt(0);
    boolean bool1 = bool2;
    if (localView != null)
    {
      int i = localView.getHeight();
      int j = localView.getWidth();
      if (getHeight() >= i + getPaddingTop() + getPaddingBottom())
      {
        bool1 = bool2;
        if (getWidth() >= j + getPaddingLeft() + getPaddingRight()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramInt2 >= paramInt3) || (paramInt1 < 0)) {
      i = 0;
    }
    do
    {
      return i;
      i = paramInt1;
    } while (paramInt2 + paramInt1 <= paramInt3);
    return paramInt3 - paramInt2;
  }
  
  private void doScroll(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      smoothScrollBy(paramInt1, paramInt2);
    }
  }
  
  private View findFocusableViewInBounds(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList = getFocusables(2);
    Object localObject2 = null;
    int i = 0;
    int i1 = localArrayList.size();
    int k = 0;
    Object localObject1;
    int m;
    int i3;
    int n;
    int i2;
    int j;
    if (k < i1)
    {
      localObject1 = (View)localArrayList.get(k);
      m = ((View)localObject1).getTop();
      i3 = ((View)localObject1).getBottom();
      n = ((View)localObject1).getLeft();
      i2 = ((View)localObject1).getRight();
      if ((paramInt1 >= i3) || (m >= paramInt2) || (paramInt3 >= i2) || (n >= paramInt4)) {
        break label283;
      }
      if ((paramInt1 < m) && (i3 < paramInt2) && (paramInt3 < n) && (i2 < paramInt4))
      {
        j = 1;
        label129:
        if (localObject2 != null) {
          break label157;
        }
        i = j;
      }
    }
    for (;;)
    {
      k += 1;
      localObject2 = localObject1;
      break;
      j = 0;
      break label129;
      label157:
      if (((paramBoolean1) && (m < localObject2.getTop())) || ((!paramBoolean1) && (i3 > localObject2.getBottom())))
      {
        m = 1;
        label188:
        if (((!paramBoolean2) || (n >= localObject2.getLeft())) && ((paramBoolean2) || (i2 <= localObject2.getRight()))) {
          break label250;
        }
      }
      label250:
      for (n = 1;; n = 0)
      {
        if (i == 0) {
          break label256;
        }
        if ((j == 0) || (m == 0) || (n == 0)) {
          break label283;
        }
        break;
        m = 0;
        break label188;
      }
      label256:
      if (j != 0)
      {
        i = 1;
      }
      else if ((m != 0) && (n != 0))
      {
        continue;
        return localObject2;
      }
      else
      {
        label283:
        localObject1 = localObject2;
      }
    }
  }
  
  private View findFocusableViewInMyBounds(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, View paramView)
  {
    int j = getVerticalFadingEdgeLength() / 2;
    int i = paramInt1 + j;
    paramInt1 = getHeight() + paramInt1 - j;
    int k = getHorizontalFadingEdgeLength() / 2;
    j = paramInt2 + k;
    paramInt2 = getWidth() + paramInt2 - k;
    if ((paramView != null) && (paramView.getTop() < paramInt1) && (paramView.getBottom() > i) && (paramView.getLeft() < paramInt2) && (paramView.getRight() > j)) {
      return paramView;
    }
    return findFocusableViewInBounds(paramBoolean1, i, paramInt1, paramBoolean2, j, paramInt2);
  }
  
  private void initTwoDScrollView()
  {
    this.mScroller = new Scroller(getContext());
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
  }
  
  private boolean isViewDescendantOf(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    if (((paramView1 instanceof ViewGroup)) && (isViewDescendantOf((View)paramView1, paramView2))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean scrollAndFocus(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = getHeight();
    int k = getScrollY();
    int m = k + i;
    boolean bool1;
    int j;
    boolean bool2;
    label57:
    Object localObject;
    if (paramInt1 == 33)
    {
      bool1 = true;
      j = getWidth();
      i = getScrollX();
      j = i + j;
      if (paramInt4 != 33) {
        break label147;
      }
      bool2 = true;
      localObject = findFocusableViewInBounds(bool1, paramInt2, paramInt3, bool2, paramInt5, paramInt6);
      if (localObject != null) {
        break label203;
      }
      localObject = this;
    }
    label147:
    label163:
    label194:
    label203:
    for (;;)
    {
      if (((paramInt2 >= k) && (paramInt3 <= m)) || ((paramInt5 >= i) && (paramInt6 <= j)))
      {
        bool1 = false;
        if ((localObject != findFocus()) && (((View)localObject).requestFocus(paramInt1)))
        {
          this.mTwoDScrollViewMovedFocus = true;
          this.mTwoDScrollViewMovedFocus = false;
        }
        return bool1;
        bool1 = false;
        break;
        bool2 = false;
        break label57;
      }
      if (bool1)
      {
        paramInt2 -= k;
        if (!bool2) {
          break label194;
        }
      }
      for (paramInt3 = paramInt5 - i;; paramInt3 = paramInt6 - j)
      {
        doScroll(paramInt3, paramInt2);
        bool1 = true;
        break;
        paramInt2 = paramInt3 - m;
        break label163;
      }
    }
  }
  
  private void scrollToChild(View paramView)
  {
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    int i = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
    if (i != 0) {
      scrollBy(0, i);
    }
  }
  
  private boolean scrollToChildRect(Rect paramRect, boolean paramBoolean)
  {
    int i = computeScrollDeltaToGetChildRectOnScreen(paramRect);
    if (i != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramBoolean) {
          break;
        }
        scrollBy(0, i);
      }
      return bool;
    }
    smoothScrollBy(0, i);
    return bool;
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("TwoDScrollView can host only one direct child");
    }
    super.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("TwoDScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("TwoDScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("TwoDScrollView can host only one direct child");
    }
    super.addView(paramView, paramLayoutParams);
  }
  
  public boolean arrowScroll(int paramInt, boolean paramBoolean)
  {
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView1 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int i;
    if (paramBoolean)
    {
      i = getMaxScrollAmountHorizontal();
      if (paramBoolean) {
        break label213;
      }
      if (localView1 == null) {
        break label98;
      }
      localView1.getDrawingRect(this.mTempRect);
      offsetDescendantRectToMyCoords(localView1, this.mTempRect);
      doScroll(0, computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
      localView1.requestFocus(paramInt);
    }
    label98:
    int j;
    int k;
    int m;
    for (;;)
    {
      return true;
      i = getMaxScrollAmountVertical();
      break;
      if ((paramInt == 33) && (getScrollY() < i)) {
        j = getScrollY();
      }
      while (j == 0)
      {
        return false;
        j = i;
        if (paramInt == 130)
        {
          j = i;
          if (getChildCount() > 0)
          {
            k = getChildAt(0).getBottom();
            m = getScrollY() + getHeight();
            j = i;
            if (k - m < i) {
              j = k - m;
            }
          }
        }
      }
      if (paramInt == 130) {}
      for (;;)
      {
        doScroll(0, j);
        break;
        j = -j;
      }
      label213:
      if (localView1 == null) {
        break label260;
      }
      localView1.getDrawingRect(this.mTempRect);
      offsetDescendantRectToMyCoords(localView1, this.mTempRect);
      doScroll(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), 0);
      localView1.requestFocus(paramInt);
    }
    label260:
    if ((paramInt == 33) && (getScrollY() < i)) {
      j = getScrollY();
    }
    while (j == 0)
    {
      return false;
      j = i;
      if (paramInt == 130)
      {
        j = i;
        if (getChildCount() > 0)
        {
          k = getChildAt(0).getBottom();
          m = getScrollY() + getHeight();
          j = i;
          if (k - m < i) {
            j = k - m;
          }
        }
      }
    }
    if (paramInt == 130) {}
    for (;;)
    {
      doScroll(j, 0);
      break;
      j = -j;
    }
  }
  
  protected int computeHorizontalScrollRange()
  {
    if (getChildCount() == 0) {
      return getWidth();
    }
    return getChildAt(0).getRight();
  }
  
  public void computeScroll()
  {
    int i;
    int j;
    int k;
    int m;
    if (this.mScroller.computeScrollOffset())
    {
      i = getScrollX();
      j = getScrollY();
      k = this.mScroller.getCurrX();
      m = this.mScroller.getCurrY();
      if (getChildCount() <= 0) {
        break label139;
      }
      View localView = getChildAt(0);
      scrollTo(clamp(k, getWidth() - getPaddingRight() - getPaddingLeft(), localView.getWidth()), clamp(m, getHeight() - getPaddingBottom() - getPaddingTop(), localView.getHeight()));
    }
    for (;;)
    {
      if ((i != getScrollX()) || (j != getScrollY())) {
        onScrollChanged(getScrollX(), getScrollY(), i, j);
      }
      postInvalidate();
      return;
      label139:
      scrollTo(k, m);
    }
  }
  
  protected int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int m = getHeight();
    int i = getScrollY();
    int k = i + m;
    int n = getVerticalFadingEdgeLength();
    int j = i;
    if (paramRect.top > 0) {
      j = i + n;
    }
    i = k;
    if (paramRect.bottom < getChildAt(0).getHeight()) {
      i = k - n;
    }
    if ((paramRect.bottom > i) && (paramRect.top > j)) {
      if (paramRect.height() > m)
      {
        j = paramRect.top - j + 0;
        i = Math.min(j, getChildAt(0).getBottom() - i);
      }
    }
    for (;;)
    {
      return i;
      j = paramRect.bottom - i + 0;
      break;
      if ((paramRect.top < j) && (paramRect.bottom < i))
      {
        if (paramRect.height() > m) {}
        for (i = 0 - (i - paramRect.bottom);; i = 0 - (j - paramRect.top))
        {
          i = Math.max(i, -getScrollY());
          break;
        }
      }
      i = 0;
    }
  }
  
  protected int computeVerticalScrollRange()
  {
    if (getChildCount() == 0) {
      return getHeight();
    }
    return getChildAt(0).getBottom();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (super.dispatchKeyEvent(paramKeyEvent)) {
      return true;
    }
    return executeKeyEvent(paramKeyEvent);
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    this.mTempRect.setEmpty();
    if (!canScroll()) {
      if (isFocused())
      {
        localView = findFocus();
        paramKeyEvent = localView;
        if (localView == this) {
          paramKeyEvent = null;
        }
        paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
        if ((paramKeyEvent == null) || (paramKeyEvent == this) || (!paramKeyEvent.requestFocus(130))) {
          break label72;
        }
        bool = true;
      }
    }
    label72:
    while (paramKeyEvent.getAction() != 0) {
      for (;;)
      {
        View localView;
        return bool;
        bool = false;
      }
    }
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    case 19: 
      if (!paramKeyEvent.isAltPressed()) {
        return arrowScroll(33, false);
      }
      return fullScroll(33, false);
    case 20: 
      if (!paramKeyEvent.isAltPressed()) {
        return arrowScroll(130, false);
      }
      return fullScroll(130, false);
    case 21: 
      if (!paramKeyEvent.isAltPressed()) {
        return arrowScroll(17, true);
      }
      return fullScroll(17, true);
    }
    if (!paramKeyEvent.isAltPressed()) {
      return arrowScroll(66, true);
    }
    return fullScroll(66, true);
  }
  
  public void fling(int paramInt1, int paramInt2)
  {
    boolean bool1;
    boolean bool2;
    label116:
    Object localObject;
    if (getChildCount() > 0)
    {
      int i = getHeight();
      int j = getPaddingBottom();
      int k = getPaddingTop();
      int m = getChildAt(0).getHeight();
      int n = getWidth();
      int i1 = getPaddingRight();
      int i2 = getPaddingLeft();
      int i3 = getChildAt(0).getWidth();
      this.mScroller.fling(getScrollX(), getScrollY(), paramInt1, paramInt2, 0, i3 - (n - i1 - i2), 0, m - (i - j - k));
      if (paramInt2 <= 0) {
        break label210;
      }
      bool1 = true;
      if (paramInt1 <= 0) {
        break label216;
      }
      bool2 = true;
      View localView = findFocusableViewInMyBounds(bool2, this.mScroller.getFinalX(), bool1, this.mScroller.getFinalY(), findFocus());
      localObject = localView;
      if (localView == null) {
        localObject = this;
      }
      if (localObject != findFocus()) {
        if (!bool1) {
          break label222;
        }
      }
    }
    label210:
    label216:
    label222:
    for (paramInt1 = 130;; paramInt1 = 33)
    {
      if (((View)localObject).requestFocus(paramInt1))
      {
        this.mTwoDScrollViewMovedFocus = true;
        this.mTwoDScrollViewMovedFocus = false;
      }
      awakenScrollBars(this.mScroller.getDuration());
      invalidate();
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label116;
    }
  }
  
  public boolean fullScroll(int paramInt, boolean paramBoolean)
  {
    int j = 1;
    int i = 1;
    View localView;
    if (!paramBoolean)
    {
      if (paramInt == 130) {}
      for (;;)
      {
        j = getHeight();
        this.mTempRect.top = 0;
        this.mTempRect.bottom = j;
        if (i != 0)
        {
          i = getChildCount();
          if (i > 0)
          {
            localView = getChildAt(i - 1);
            this.mTempRect.bottom = localView.getBottom();
            this.mTempRect.top = (this.mTempRect.bottom - j);
          }
        }
        return scrollAndFocus(paramInt, this.mTempRect.top, this.mTempRect.bottom, 0, 0, 0);
        i = 0;
      }
    }
    if (paramInt == 130) {}
    for (i = j;; i = 0)
    {
      j = getWidth();
      this.mTempRect.left = 0;
      this.mTempRect.right = j;
      if (i != 0)
      {
        i = getChildCount();
        if (i > 0)
        {
          localView = getChildAt(i - 1);
          this.mTempRect.right = localView.getBottom();
          this.mTempRect.left = (this.mTempRect.right - j);
        }
      }
      return scrollAndFocus(0, 0, 0, paramInt, this.mTempRect.top, this.mTempRect.bottom);
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getHeight();
    int k = getPaddingBottom();
    j = getChildAt(0).getBottom() - getScrollY() - (j - k);
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getHorizontalFadingEdgeLength();
    if (getScrollX() < i) {
      return getScrollX() / i;
    }
    return 1.0F;
  }
  
  public int getMaxScrollAmountHorizontal()
  {
    return (int)(0.5F * getWidth());
  }
  
  public int getMaxScrollAmountVertical()
  {
    return (int)(0.5F * getHeight());
  }
  
  protected float getRightFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getHorizontalFadingEdgeLength();
    int j = getWidth();
    int k = getPaddingRight();
    j = getChildAt(0).getRight() - getScrollX() - (j - k);
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    if (getScrollY() < i) {
      return getScrollY() / i;
    }
    return 1.0F;
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramInt1 = View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin, 0);
    paramInt2 = localMarginLayoutParams.topMargin;
    paramView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.bottomMargin + paramInt2, 0));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.mIsBeingDragged)) {
      return true;
    }
    if (!canScroll())
    {
      this.mIsBeingDragged = false;
      return false;
    }
    float f1 = paramMotionEvent.getY();
    float f2 = paramMotionEvent.getX();
    switch (i)
    {
    }
    for (;;)
    {
      return this.mIsBeingDragged;
      i = (int)Math.abs(f1 - this.mLastMotionY);
      int j = (int)Math.abs(f2 - this.mLastMotionX);
      if ((i > this.mTouchSlop) || (j > this.mTouchSlop))
      {
        this.mIsBeingDragged = true;
        continue;
        this.mLastMotionY = f1;
        this.mLastMotionX = f2;
        if (!this.mScroller.isFinished()) {}
        for (;;)
        {
          this.mIsBeingDragged = bool;
          break;
          bool = false;
        }
        this.mIsBeingDragged = false;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mIsLayoutDirty = false;
    if ((this.mChildToScrollTo != null) && (isViewDescendantOf(this.mChildToScrollTo, this))) {
      scrollToChild(this.mChildToScrollTo);
    }
    this.mChildToScrollTo = null;
    scrollTo(getScrollX(), getScrollY());
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i;
    if (paramInt == 2)
    {
      i = 130;
      if (paramRect != null) {
        break label44;
      }
    }
    label44:
    for (View localView = FocusFinder.getInstance().findNextFocus(this, null, i);; localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i))
    {
      if (localView != null) {
        break label58;
      }
      return false;
      i = paramInt;
      if (paramInt != 1) {
        break;
      }
      i = 33;
      break;
    }
    label58:
    return localView.requestFocus(i, paramRect);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (this == localView)) {
      return;
    }
    localView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(localView, this.mTempRect);
    doScroll(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {}
    while (!canScroll()) {
      return false;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    float f2 = paramMotionEvent.getX();
    int m;
    int k;
    switch (i)
    {
    default: 
    case 0: 
      for (;;)
      {
        return true;
        if (!this.mScroller.isFinished()) {
          this.mScroller.abortAnimation();
        }
        this.mLastMotionY = f1;
        this.mLastMotionX = f2;
      }
    case 2: 
      m = (int)(this.mLastMotionX - f2);
      k = (int)(this.mLastMotionY - f1);
      this.mLastMotionX = f2;
      this.mLastMotionY = f1;
      if (m < 0)
      {
        i = m;
        if (getScrollX() < 0) {
          i = 0;
        }
        label171:
        if (k >= 0) {
          break label269;
        }
        if (getScrollY() >= 0) {
          break label412;
        }
      }
      break;
    }
    while ((j != 0) || (i != 0))
    {
      scrollBy(i, j);
      break;
      i = m;
      if (m <= 0) {
        break label171;
      }
      i = getWidth();
      int n = getPaddingRight();
      i = getChildAt(0).getRight() - getScrollX() - (i - n);
      if (i > 0)
      {
        i = Math.min(i, m);
        break label171;
      }
      i = 0;
      break label171;
      label269:
      if (k > 0)
      {
        m = getHeight();
        n = getPaddingBottom();
        m = getChildAt(0).getBottom() - getScrollY() - (m - n);
        if (m <= 0) {
          continue;
        }
        j = Math.min(m, k);
        continue;
        paramMotionEvent = this.mVelocityTracker;
        paramMotionEvent.computeCurrentVelocity(1000, this.mMaximumVelocity);
        i = (int)paramMotionEvent.getXVelocity();
        j = (int)paramMotionEvent.getYVelocity();
        if ((Math.abs(i) + Math.abs(j) > this.mMinimumVelocity) && (getChildCount() > 0)) {
          fling(-i, -j);
        }
        if (this.mVelocityTracker == null) {
          break;
        }
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        break;
      }
      label412:
      j = k;
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.mTwoDScrollViewMovedFocus)
    {
      if (this.mIsLayoutDirty) {
        break label26;
      }
      scrollToChild(paramView2);
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      label26:
      this.mChildToScrollTo = paramView2;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    return scrollToChildRect(paramRect, paramBoolean);
  }
  
  public void requestLayout()
  {
    this.mIsLayoutDirty = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = clamp(paramInt1, getWidth() - getPaddingRight() - getPaddingLeft(), localView.getWidth());
      paramInt2 = clamp(paramInt2, getHeight() - getPaddingBottom() - getPaddingTop(), localView.getHeight());
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250L)
    {
      this.mScroller.startScroll(getScrollX(), getScrollY(), paramInt1, paramInt2);
      awakenScrollBars(this.mScroller.getDuration());
      invalidate();
    }
    for (;;)
    {
      this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
      return;
      if (!this.mScroller.isFinished()) {
        this.mScroller.abortAnimation();
      }
      scrollBy(paramInt1, paramInt2);
    }
  }
  
  public final void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1 - getScrollX(), paramInt2 - getScrollY());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.unnamed.b.atv.view.TwoDScrollView
 * JD-Core Version:    0.7.0.1
 */