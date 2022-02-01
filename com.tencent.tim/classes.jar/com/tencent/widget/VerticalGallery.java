package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Transformation;
import android.widget.Scroller;
import android.widget.SpinnerAdapter;
import atau.a;

public class VerticalGallery
  extends VerticalAbsSpinner
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  private float De = 1.0F;
  private AdapterView.a jdField_a_of_type_ComTencentWidgetAdapterView$a;
  private FlingRunnable jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable = new FlingRunnable();
  private b jdField_a_of_type_ComTencentWidgetVerticalGallery$b;
  private a jdField_b_of_type_ComTencentWidgetVerticalGallery$a;
  private c jdField_b_of_type_ComTencentWidgetVerticalGallery$c;
  private boolean dlg;
  private boolean dlh;
  private boolean dli = true;
  private boolean dlj;
  private int euT;
  private int euU;
  private int euV = 5;
  private int mAnimationDuration = 400;
  private Runnable mDisableSuppressSelectionChangedRunnable = new VerticalGallery.1(this);
  private int mDownTouchPosition;
  private View mDownTouchView;
  private GestureDetector mGestureDetector = new GestureDetector(paramContext, this);
  private int mGravity;
  private boolean mIsFirstScroll;
  private int mLeftMost;
  private int mOrientation = 1;
  private boolean mReceivedInvokeKeyDown;
  private int mRightMost;
  private boolean mScrolling;
  private View mSelectedChild;
  private boolean mShouldCallbackDuringFling = true;
  private boolean mShouldCallbackOnUnselectedItemClick = true;
  private boolean mShouldStopFling;
  private int mSpacing;
  private boolean mSuppressSelectionChanged;
  private float mUnselectedAlpha;
  
  public VerticalGallery(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VerticalGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131035534);
  }
  
  public VerticalGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mGestureDetector.setIsLongpressEnabled(true);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sF, paramInt, 0);
    paramInt = paramAttributeSet.getInt(0, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    paramInt = paramAttributeSet.getInt(1, -1);
    if (paramInt > 0) {
      setAnimationDuration(paramInt);
    }
    setSpacing(paramAttributeSet.getDimensionPixelOffset(2, 0));
    setUnselectedAlpha(paramAttributeSet.getFloat(3, 0.5F));
    paramAttributeSet.recycle();
    setChildrenDrawingOrderEnabled(true);
    setStaticTransformationsEnabled(true);
    this.euV = ViewConfiguration.get(paramContext).getScaledScrollBarSize();
    if (aJP())
    {
      this.mGravity = 1;
      return;
    }
    this.mGravity = 16;
  }
  
  private void Wj(boolean paramBoolean)
  {
    int j = 0;
    int n = 0;
    int i1 = getChildCount();
    int m = this.mFirstPosition;
    View localView;
    if (paramBoolean)
    {
      k = getPaddingTop();
      j = 0;
      i = 0;
      for (;;)
      {
        if (j < i1)
        {
          localView = getChildAt(j);
          if (localView.getBottom() < k) {}
        }
        else
        {
          k = i;
          m = n;
          if (i == i1)
          {
            k = i - 1;
            m = n;
          }
          detachViewsFromParent(m, k);
          if (paramBoolean)
          {
            this.mFirstPosition = (k + this.mFirstPosition);
            if (aJR()) {
              this.mFirstPosition %= this.mItemCount;
            }
          }
          return;
        }
        this.jdField_a_of_type_ComTencentWidgetAbsSpinner$a.put(m + j, localView);
        j += 1;
        i += 1;
      }
    }
    n = getHeight();
    int i2 = getPaddingBottom();
    int k = i1 - 1;
    int i = 0;
    for (;;)
    {
      if (k >= 0)
      {
        localView = getChildAt(k);
        if (localView.getTop() > n - i2) {}
      }
      else
      {
        k = i;
        m = j;
        if (j != 0) {
          break;
        }
        m = j + 1;
        k = i;
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetAbsSpinner$a.put(m + k, localView);
      i += 1;
      j = k;
      k -= 1;
    }
  }
  
  private View a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!this.mDataChanged)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetAbsSpinner$a.get(paramInt1);
      if (localView != null)
      {
        paramInt1 = localView.getTop();
        this.mRightMost = Math.max(this.mRightMost, localView.getMeasuredHeight() + paramInt1);
        this.mLeftMost = Math.min(this.mLeftMost, paramInt1);
        c(localView, paramInt2, paramInt3, paramBoolean);
        return localView;
      }
    }
    View localView = this.mAdapter.getView(paramInt1, null, this);
    c(localView, paramInt2, paramInt3, paramBoolean);
    return localView;
  }
  
  private boolean aJP()
  {
    return this.mOrientation == 2;
  }
  
  private float bS()
  {
    if (aJP()) {
      return (getHeight() - getPaddingTop() - getPaddingBottom()) * bT() + getPaddingTop();
    }
    return (getWidth() - getPaddingLeft() - getPaddingRight()) * bT() + getPaddingLeft();
  }
  
  private void c(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = false;
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = (LayoutParams)generateDefaultLayoutParams();
    }
    for (;;)
    {
      int i;
      int j;
      int k;
      if (paramBoolean)
      {
        i = -1;
        addViewInLayout(paramView, i, localLayoutParams);
        if (paramInt1 == 0) {
          bool = true;
        }
        paramView.setSelected(bool);
        paramInt1 = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, localLayoutParams.height);
        paramView.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, localLayoutParams.width), paramInt1);
        i = d(paramView, true);
        j = paramView.getMeasuredWidth();
        k = paramView.getMeasuredHeight();
        if (!paramBoolean) {
          break label169;
        }
        paramInt1 = paramInt2;
        paramInt2 = k + paramInt2;
      }
      for (;;)
      {
        paramView.layout(i, paramInt1, i + j, paramInt2);
        return;
        i = 0;
        break;
        label169:
        paramInt1 = paramInt2 - k;
      }
    }
  }
  
  private int calculateTop(View paramView, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = getMeasuredHeight();
      label9:
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (int j = paramView.getMeasuredHeight();; j = paramView.getHeight()) {
      switch (this.mGravity)
      {
      default: 
        return 0;
        i = getHeight();
        break label9;
      }
    }
    return this.mSpinnerPadding.top;
    int k = this.mSpinnerPadding.bottom;
    int m = this.mSpinnerPadding.top;
    int n = this.mSpinnerPadding.top;
    return (i - k - m - j) / 2 + n;
    return i - this.mSpinnerPadding.bottom - j;
  }
  
  private int d(View paramView, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = getMeasuredWidth();
      label9:
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (int j = paramView.getMeasuredWidth();; j = paramView.getWidth()) {
      switch (this.mGravity)
      {
      case 2: 
      case 4: 
      default: 
        return 0;
        i = getWidth();
        break label9;
      }
    }
    return this.mSpinnerPadding.left;
    int k = this.mSpinnerPadding.right;
    int m = this.mSpinnerPadding.left;
    int n = this.mSpinnerPadding.left;
    return (i - k - m - j) / 2 + n;
    return i - this.mSpinnerPadding.right - j;
  }
  
  private void detachOffScreenChildren(boolean paramBoolean)
  {
    int j = 0;
    int n = 0;
    int i1 = getChildCount();
    int m = this.mFirstPosition;
    View localView;
    if (paramBoolean)
    {
      k = getPaddingLeft();
      j = 0;
      i = 0;
      for (;;)
      {
        if (j < i1)
        {
          localView = getChildAt(j);
          if (localView.getRight() < k) {}
        }
        else
        {
          k = i;
          m = n;
          if (i == i1)
          {
            k = i - 1;
            m = n;
          }
          detachViewsFromParent(m, k);
          if (paramBoolean)
          {
            this.mFirstPosition = (k + this.mFirstPosition);
            if (aJR()) {
              this.mFirstPosition %= this.mItemCount;
            }
          }
          return;
        }
        this.jdField_a_of_type_ComTencentWidgetAbsSpinner$a.put(m + j, localView);
        j += 1;
        i += 1;
      }
    }
    n = getWidth();
    int i2 = getPaddingRight();
    int k = i1 - 1;
    int i = 0;
    for (;;)
    {
      if (k >= 0)
      {
        localView = getChildAt(k);
        if (localView.getLeft() > n - i2) {}
      }
      else
      {
        k = i;
        m = j;
        if (j != 0) {
          break;
        }
        m = j + 1;
        k = i;
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetAbsSpinner$a.put(m + k, localView);
      i += 1;
      j = k;
      k -= 1;
    }
  }
  
  private boolean dispatchLongPress(View paramView, int paramInt, long paramLong)
  {
    if (this.mOnItemLongClickListener != null) {}
    for (boolean bool1 = this.mOnItemLongClickListener.a(this, this.mDownTouchView, this.mDownTouchPosition, paramLong);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.jdField_a_of_type_ComTencentWidgetAdapterView$a = new AdapterView.a(paramView, paramInt, paramLong);
        bool2 = super.showContextMenuForChild(this);
      }
      if (bool2) {
        performHapticFeedback(0);
      }
      return bool2;
    }
  }
  
  private void dispatchPress(View paramView)
  {
    if (paramView != null) {
      paramView.setPressed(true);
    }
    setPressed(true);
  }
  
  private void exD()
  {
    int j = 0;
    if (aJO()) {
      if ((getChildCount() != 0) && (this.mSelectedChild != null)) {}
    }
    int i;
    while (getChildCount() == 0)
    {
      return;
      i = getCenterOfView(this.mSelectedChild);
      i = getCenterOfGallery() - i;
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.startUsingDistance(i);
        return;
      }
      onFinishedMovement();
      return;
    }
    View localView1;
    if (this.mFirstPosition == 0)
    {
      localView1 = getChildAt(0);
      if (localView1.getTop() >= 0) {
        i = getPaddingTop() - localView1.getTop();
      }
    }
    while (i != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.startUsingDistance(i);
      return;
      View localView2 = getChildAt(getChildCount() - 1);
      if (localView2.getBottom() - localView1.getTop() < getBottom() - getPaddingBottom())
      {
        i = getPaddingLeft() - this.euT;
      }
      else
      {
        i = j;
        if (localView2.getBottom() < getBottom() - getPaddingBottom())
        {
          i = getHeight() - getPaddingBottom() - localView2.getBottom();
          continue;
          i = j;
          if (this.mFirstPosition + getChildCount() == this.mItemCount)
          {
            localView1 = getChildAt(getChildCount() - 1);
            i = j;
            if (localView1.getBottom() < getBottom() - getPaddingBottom()) {
              i = getHeight() - getPaddingBottom() - localView1.getBottom();
            }
          }
        }
      }
    }
    onFinishedMovement();
  }
  
  private void exE()
  {
    View localView = this.mSelectedChild;
    if (this.mSelectedChild == null) {}
    int n;
    do
    {
      return;
      n = getCenterOfGallery();
    } while ((localView != null) && (localView.getTop() <= n) && (localView.getBottom() >= n));
    int k = 2147483647;
    int j = 0;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      localView = getChildAt(i);
      if ((localView.getTop() > n) || (localView.getBottom() < n)) {}
    }
    for (;;)
    {
      j = this.mFirstPosition + i;
      i = j;
      if (aJR()) {
        i = j % this.mItemCount;
      }
      if (i == this.mSelectedPosition) {
        break;
      }
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      checkSelectionChanged();
      return;
      int m = Math.min(Math.abs(localView.getTop() - n), Math.abs(localView.getBottom() - n));
      if (m < k) {
        k = i;
      }
      for (j = m;; j = m)
      {
        i -= 1;
        m = j;
        j = k;
        k = m;
        break;
        m = k;
        k = j;
      }
      i = j;
    }
  }
  
  private void exF()
  {
    if (aJR()) {
      exJ();
    }
    for (;;)
    {
      return;
      int k = this.mSpacing;
      int m = getPaddingTop();
      View localView = getChildAt(0);
      int j;
      int i;
      if (localView != null)
      {
        j = this.mFirstPosition - 1;
        i = localView.getTop() - k;
      }
      while ((i > m) && (j >= 0))
      {
        localView = a(j, j - this.mSelectedPosition, i, false);
        this.mFirstPosition = j;
        i = localView.getTop() - k;
        j -= 1;
        continue;
        i = getBottom() - getTop() - getPaddingBottom();
        this.mShouldStopFling = true;
        j = 0;
      }
    }
  }
  
  private void exG()
  {
    if (aJR()) {
      exL();
    }
    for (;;)
    {
      return;
      int k = this.mSpacing;
      int m = getBottom();
      int n = getTop();
      int i1 = getPaddingRight();
      int i = getChildCount();
      int i2 = this.mItemCount;
      View localView = getChildAt(i - 1);
      int j;
      if (localView != null)
      {
        j = this.mFirstPosition + i;
        i = localView.getBottom() + k;
      }
      while ((i < m - n - i1) && (j < i2))
      {
        i = a(j, j - this.mSelectedPosition, i, true).getBottom() + k;
        j += 1;
        continue;
        j = this.mItemCount - 1;
        this.mFirstPosition = j;
        i = getPaddingTop();
        this.mShouldStopFling = true;
      }
    }
  }
  
  private void exI()
  {
    int k = this.mSpacing;
    int m = getPaddingLeft();
    View localView = getChildAt(0);
    int i;
    if (localView != null)
    {
      j = this.mFirstPosition - 1;
      i = localView.getLeft() - k;
    }
    while ((i > m) && (j >= 0))
    {
      localView = makeAndAddView(j, j - this.mSelectedPosition, i, false);
      this.mFirstPosition = j;
      i = localView.getLeft() - k;
      j -= 1;
      continue;
      i = getRight() - getLeft() - getPaddingRight();
      this.mShouldStopFling = true;
      j = 0;
    }
    int j = this.mItemCount - 1;
    while ((i > m) && (getChildCount() < this.mItemCount))
    {
      localView = makeAndAddView(j, j - this.mSelectedPosition, i, false);
      this.mFirstPosition = j;
      i = localView.getLeft() - k;
      j -= 1;
    }
  }
  
  private void exJ()
  {
    int k = this.mSpacing;
    int m = getPaddingTop();
    View localView = getChildAt(0);
    int i;
    if (localView != null)
    {
      j = this.mFirstPosition - 1;
      i = localView.getTop() - k;
    }
    while ((i > m) && (j >= 0))
    {
      localView = a(j, j - this.mSelectedPosition, i, false);
      this.mFirstPosition = j;
      i = localView.getTop() - k;
      j -= 1;
      continue;
      i = getBottom() - getTop() - getPaddingBottom();
      this.mShouldStopFling = true;
      j = 0;
    }
    int j = this.mItemCount - 1;
    while ((i > m) && (getChildCount() < this.mItemCount))
    {
      localView = a(j, j - this.mSelectedPosition, i, false);
      this.mFirstPosition = j;
      i = localView.getTop() - k;
      j -= 1;
    }
  }
  
  private void exK()
  {
    int k = this.mSpacing;
    int m = getRight() - getLeft() - getPaddingRight();
    int i = getChildCount();
    int n = this.mItemCount;
    View localView = getChildAt(i - 1);
    int j;
    if (localView != null)
    {
      j = this.mFirstPosition + i;
      i = localView.getRight() + k;
    }
    while ((i < m) && (j < n))
    {
      i = makeAndAddView(j, j - this.mSelectedPosition, i, true).getRight() + k;
      j += 1;
      continue;
      j = this.mItemCount - 1;
      this.mFirstPosition = j;
      i = getPaddingLeft();
      this.mShouldStopFling = true;
    }
    j %= n;
    while ((i <= m) && (getChildCount() < this.mItemCount))
    {
      i = makeAndAddView(j, j - this.mSelectedPosition, i, true).getRight() + k;
      j += 1;
    }
  }
  
  private void exL()
  {
    int k = this.mSpacing;
    int m = getBottom() - getTop() - getPaddingBottom();
    int i = getChildCount();
    int n = this.mItemCount;
    View localView = getChildAt(i - 1);
    int j;
    if (localView != null)
    {
      j = this.mFirstPosition + i;
      i = localView.getBottom() + k;
    }
    while ((i < m) && (j < n))
    {
      i = a(j, j - this.mSelectedPosition, i, true).getBottom() + k;
      j += 1;
      continue;
      j = this.mItemCount - 1;
      this.mFirstPosition = j;
      i = getPaddingTop();
      this.mShouldStopFling = true;
    }
    j %= n;
    while ((i <= m) && (getChildCount() < this.mItemCount))
    {
      i = a(j, j - this.mSelectedPosition, i, true).getBottom() + k;
      j += 1;
    }
  }
  
  private void fillToGalleryLeft()
  {
    if (aJR()) {
      exI();
    }
    for (;;)
    {
      return;
      int k = this.mSpacing;
      int m = getPaddingLeft();
      View localView = getChildAt(0);
      int j;
      int i;
      if (localView != null)
      {
        j = this.mFirstPosition - 1;
        i = localView.getLeft() - k;
      }
      while ((i > m) && (j >= 0))
      {
        localView = makeAndAddView(j, j - this.mSelectedPosition, i, false);
        this.mFirstPosition = j;
        i = localView.getLeft() - k;
        j -= 1;
        continue;
        i = getRight() - getLeft() - getPaddingRight();
        this.mShouldStopFling = true;
        j = 0;
      }
    }
  }
  
  private void fillToGalleryRight()
  {
    if (aJR()) {
      exK();
    }
    for (;;)
    {
      return;
      int k = this.mSpacing;
      int m = getRight();
      int n = getLeft();
      int i1 = getPaddingRight();
      int i = getChildCount();
      int i2 = this.mItemCount;
      View localView = getChildAt(i - 1);
      int j;
      if (localView != null)
      {
        j = this.mFirstPosition + i;
        i = localView.getRight() + k;
      }
      while ((i < m - n - i1) && (j < i2))
      {
        i = makeAndAddView(j, j - this.mSelectedPosition, i, true).getRight() + k;
        j += 1;
        continue;
        j = this.mItemCount - 1;
        this.mFirstPosition = j;
        i = getPaddingLeft();
        this.mShouldStopFling = true;
      }
    }
  }
  
  private int getCenterOfView(View paramView)
  {
    if (aJP()) {
      return paramView.getTop() + paramView.getHeight() / 2;
    }
    return paramView.getLeft() + paramView.getWidth() / 2;
  }
  
  private View makeAndAddView(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!this.mDataChanged)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetAbsSpinner$a.get(paramInt1);
      if (localView != null)
      {
        paramInt1 = localView.getLeft();
        this.mRightMost = Math.max(this.mRightMost, localView.getMeasuredWidth() + paramInt1);
        this.mLeftMost = Math.min(this.mLeftMost, paramInt1);
        setUpChild(localView, paramInt2, paramInt3, paramBoolean);
        return localView;
      }
    }
    View localView = this.mAdapter.getView(paramInt1, null, this);
    setUpChild(localView, paramInt2, paramInt3, paramBoolean);
    return localView;
  }
  
  private boolean nh(int paramInt)
  {
    if (paramInt != this.mSelectedPosition)
    {
      setSelectedPositionInt(paramInt);
      setNextSelectedPositionInt(paramInt);
      checkSelectionChanged();
      return true;
    }
    return false;
  }
  
  private void onFinishedMovement()
  {
    if (this.mSuppressSelectionChanged)
    {
      this.mSuppressSelectionChanged = false;
      super.selectionChanged();
    }
    invalidate();
    if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery$b != null) {
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery$b.a(this);
    }
  }
  
  private boolean scrollToChild(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = getCenterOfGallery();
      int i = getCenterOfView(localView);
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.startUsingDistance(paramInt - i);
      return true;
    }
    return false;
  }
  
  private void setSelectionToCenterChild()
  {
    View localView = this.mSelectedChild;
    if (this.mSelectedChild == null) {}
    int n;
    do
    {
      return;
      n = getCenterOfGallery();
    } while ((localView.getLeft() <= n) && (localView.getRight() >= n));
    int k = 2147483647;
    int j = 0;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      localView = getChildAt(i);
      if ((localView.getLeft() > n) || (localView.getRight() < n)) {}
    }
    for (;;)
    {
      j = this.mFirstPosition + i;
      i = j;
      if (aJR()) {
        i = j % this.mItemCount;
      }
      if (i == this.mSelectedPosition) {
        break;
      }
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      checkSelectionChanged();
      return;
      int m = Math.min(Math.abs(localView.getLeft() - n), Math.abs(localView.getRight() - n));
      if (m < k) {
        k = i;
      }
      for (j = m;; j = m)
      {
        i -= 1;
        m = j;
        j = k;
        k = m;
        break;
        m = k;
        k = j;
      }
      i = j;
    }
  }
  
  private void setUpChild(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = false;
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = (LayoutParams)generateDefaultLayoutParams();
    }
    for (;;)
    {
      int i;
      int j;
      int k;
      if (paramBoolean)
      {
        i = -1;
        addViewInLayout(paramView, i, localLayoutParams);
        if (paramInt1 == 0) {
          bool = true;
        }
        paramView.setSelected(bool);
        paramInt1 = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, localLayoutParams.height);
        paramView.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, localLayoutParams.width), paramInt1);
        i = calculateTop(paramView, true);
        j = paramView.getMeasuredHeight();
        k = paramView.getMeasuredWidth();
        if (!paramBoolean) {
          break label169;
        }
        paramInt1 = paramInt2;
        paramInt2 = k + paramInt2;
      }
      for (;;)
      {
        paramView.layout(paramInt1, i, paramInt2, i + j);
        return;
        i = 0;
        break;
        label169:
        paramInt1 = paramInt2 - k;
      }
    }
  }
  
  private void updateSelectedItemMetadata()
  {
    View localView1 = this.mSelectedChild;
    int j = this.mSelectedPosition - this.mFirstPosition;
    int i = j;
    if (aJR())
    {
      i = j;
      if (this.mFirstPosition > this.mSelectedPosition) {
        i = this.mItemCount - this.mFirstPosition + this.mSelectedPosition;
      }
    }
    View localView2 = getChildAt(i);
    this.mSelectedChild = localView2;
    if (localView2 == null) {}
    do
    {
      return;
      localView2.setSelected(true);
      localView2.setFocusable(true);
      if (hasFocus()) {
        localView2.requestFocus();
      }
      if (this.jdField_b_of_type_ComTencentWidgetVerticalGallery$c != null) {
        this.jdField_b_of_type_ComTencentWidgetVerticalGallery$c.af(localView2, i);
      }
    } while ((localView1 == null) || (localView1 == this.mSelectedChild));
    localView1.setSelected(false);
  }
  
  public boolean aJO()
  {
    return this.dlj;
  }
  
  protected boolean aJQ()
  {
    if ((!this.dlg) || (getChildCount() < this.mItemCount)) {}
    View localView;
    do
    {
      do
      {
        return false;
        localView = getChildAt(0);
      } while ((localView != null) && (localView.getLeft() < getLeft()));
      localView = getChildAt(getChildCount() - 1);
    } while ((localView != null) && (localView.getRight() > getRight()));
    return true;
  }
  
  public boolean aJR()
  {
    return (this.dlh) && (this.dli);
  }
  
  void abo(int paramInt)
  {
    int i = 0;
    if (getChildCount() == 0) {
      return;
    }
    boolean bool;
    if (paramInt < 0)
    {
      bool = true;
      if (!aJO()) {
        break label109;
      }
      if (((!aJR()) || (getChildCount() >= this.mItemCount)) && (getLimitedMotionScrollAmount(bool, paramInt) != paramInt))
      {
        FlingRunnable.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable, false);
        onFinishedMovement();
      }
      offsetChildrenTopAndBottom(paramInt);
      Wj(bool);
      if (!bool) {
        break label102;
      }
      exG();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetAbsSpinner$a.clear();
      exE();
      invalidate();
      return;
      bool = false;
      break;
      label102:
      exF();
    }
    label109:
    View localView;
    if (bool)
    {
      localView = getChildAt(getChildCount() - 1);
      if ((localView == null) || (localView.getRight() >= bS())) {
        break label263;
      }
      paramInt = i;
      if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.stop(false);
        paramInt = i;
      }
    }
    label263:
    for (;;)
    {
      offsetChildrenTopAndBottom(paramInt);
      Wj(bool);
      if (bool) {
        exG();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetAbsSpinner$a.clear();
        setSelectionToCenterChild();
        awakenScrollBars();
        invalidate();
        return;
        localView = getChildAt(0);
        if ((localView == null) || (localView.getLeft() <= getWidth() - bS())) {
          break label263;
        }
        paramInt = i;
        if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.stop(false);
        paramInt = i;
        break;
        exF();
      }
    }
  }
  
  protected float bT()
  {
    return 0.0F;
  }
  
  public float bU()
  {
    return this.De;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  void cl(int paramInt, boolean paramBoolean)
  {
    paramInt = this.mSpinnerPadding.top;
    int i = this.euT + paramInt;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    if (this.mItemCount == 0)
    {
      resetList();
      return;
    }
    if (this.mNextSelectedPosition >= 0) {
      setSelectedPositionInt(this.mNextSelectedPosition);
    }
    recycleAllViews();
    detachAllViewsFromParent();
    this.mRightMost = 0;
    this.mLeftMost = 0;
    this.mFirstPosition = this.mSelectedPosition;
    View localView = a(this.mFirstPosition, 0, 0, true);
    paramInt = this.mSpacing + i;
    if (aJO()) {
      paramInt = (getBottom() - getTop() - this.mSpinnerPadding.top - this.mSpinnerPadding.bottom) / 2 + i - localView.getHeight() / 2;
    }
    localView.offsetTopAndBottom(paramInt);
    exG();
    exF();
    this.jdField_a_of_type_ComTencentWidgetAbsSpinner$a.clear();
    invalidate();
    this.mDataChanged = false;
    this.mNeedSync = false;
    setNextSelectedPositionInt(this.mSelectedPosition);
    updateSelectedItemMetadata();
    if (getChildCount() < this.mItemCount) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.dli = paramBoolean;
      return;
    }
  }
  
  protected int computeHorizontalScrollExtent()
  {
    int k = 0;
    int m = getChildCount();
    if (m > 0)
    {
      int j = m * 100;
      View localView = getChildAt(0);
      int n = localView.getLeft();
      int i1 = localView.getWidth();
      int i = j;
      if (i1 > 0) {
        if (this.mFirstPosition != 0) {
          break label160;
        }
      }
      label160:
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          i = j;
          if (n > 0) {}
        }
        else
        {
          i = j + n * 100 / i1;
        }
        localView = getChildAt(m - 1);
        n = localView.getRight();
        i1 = localView.getWidth();
        j = i;
        if (i1 > 0)
        {
          j = k;
          if (m + this.mFirstPosition == this.mItemCount) {
            j = 1;
          }
          if (j != 0)
          {
            j = i;
            if (n < getWidth()) {}
          }
          else
          {
            j = i - (n - getWidth()) * 100 / i1;
          }
        }
        return j;
      }
    }
    return 0;
  }
  
  protected int computeHorizontalScrollOffset()
  {
    if ((this.mFirstPosition >= 0) && (getChildCount() > 0))
    {
      View localView = getChildAt(0);
      int i = localView.getLeft();
      int j = localView.getWidth();
      if (j > 0) {
        return Math.max(this.mFirstPosition / 1 * 100 - i * 100 / j, 0);
      }
    }
    return this.mSelectedPosition;
  }
  
  protected int computeHorizontalScrollRange()
  {
    return Math.max((this.mItemCount + 1 - 1) / 1 * 100, 0);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.dispatch(this);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    if (this.mSelectedChild != null) {
      this.mSelectedChild.setPressed(paramBoolean);
    }
  }
  
  public void dispatchSetSelected(boolean paramBoolean) {}
  
  protected void dispatchUnpress()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).setPressed(false);
      i -= 1;
    }
    setPressed(false);
  }
  
  protected void exH()
  {
    if (this.jdField_b_of_type_ComTencentWidgetVerticalGallery$a != null) {
      this.jdField_b_of_type_ComTencentWidgetVerticalGallery$a.b(this);
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  protected int getCenterOfGallery()
  {
    if (aJP()) {
      return (getHeight() - getPaddingTop() - getPaddingBottom()) / 2 + getPaddingTop();
    }
    return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = this.mSelectedPosition - this.mFirstPosition;
    if (i < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return i;
      }
    } while (paramInt2 < i);
    return paramInt2 + 1;
  }
  
  int getChildHeight(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    paramTransformation.clear();
    if (paramView == this.mSelectedChild) {}
    for (float f = 1.0F;; f = this.mUnselectedAlpha)
    {
      paramTransformation.setAlpha(f);
      return true;
    }
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.jdField_a_of_type_ComTencentWidgetAdapterView$a;
  }
  
  int getLimitedMotionScrollAmount(boolean paramBoolean, int paramInt)
  {
    int j = 0;
    View localView;
    if (paramBoolean)
    {
      i = this.mItemCount - 1;
      localView = getChildAt(i - this.mFirstPosition);
      if (localView != null) {
        break label40;
      }
      i = paramInt;
    }
    label40:
    int k;
    int m;
    do
    {
      return i;
      i = 0;
      break;
      k = getCenterOfView(localView);
      m = getCenterOfGallery();
      if (!paramBoolean) {
        break label86;
      }
      i = j;
    } while (k <= m);
    int i = m - k;
    if (paramBoolean) {}
    for (paramInt = Math.max(i, paramInt);; paramInt = Math.min(i, paramInt))
    {
      return paramInt;
      label86:
      if (k < m) {
        break;
      }
      return 0;
    }
  }
  
  public void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.invalidate(paramInt1, paramInt2 - (this.euV + this.euU), paramInt3, paramInt4);
  }
  
  void layout(int paramInt, boolean paramBoolean)
  {
    if (aJP())
    {
      cl(paramInt, paramBoolean);
      return;
    }
    paramInt = this.mSpinnerPadding.left;
    int i = this.euT + paramInt;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    if (this.mItemCount == 0)
    {
      resetList();
      return;
    }
    if (this.mNextSelectedPosition >= 0) {
      setSelectedPositionInt(this.mNextSelectedPosition);
    }
    recycleAllViews();
    detachAllViewsFromParent();
    this.mRightMost = 0;
    this.mLeftMost = 0;
    this.mFirstPosition = this.mSelectedPosition;
    View localView = makeAndAddView(this.mFirstPosition, 0, 0, true);
    paramInt = this.mSpacing + i;
    if (aJO()) {
      paramInt = (getRight() - getLeft() - this.mSpinnerPadding.left - this.mSpinnerPadding.right) / 2 + i - localView.getWidth() / 2;
    }
    localView.offsetLeftAndRight(paramInt);
    fillToGalleryRight();
    fillToGalleryLeft();
    this.jdField_a_of_type_ComTencentWidgetAbsSpinner$a.clear();
    invalidate();
    this.mDataChanged = false;
    this.mNeedSync = false;
    setNextSelectedPositionInt(this.mSelectedPosition);
    updateSelectedItemMetadata();
    if (getChildCount() < this.mItemCount) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.dli = paramBoolean;
      return;
    }
  }
  
  boolean moveNext()
  {
    return (this.mItemCount > 0) && (this.mSelectedPosition < this.mItemCount - 1);
  }
  
  boolean movePrevious()
  {
    return (this.mItemCount > 0) && (this.mSelectedPosition > 0);
  }
  
  public void offsetChildrenLeftAndRight(int paramInt)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).offsetLeftAndRight(paramInt);
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i).invalidate();
      }
      i -= 1;
    }
  }
  
  public void offsetChildrenTopAndBottom(int paramInt)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).offsetTopAndBottom(paramInt);
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i).invalidate();
      }
      i -= 1;
    }
  }
  
  void onCancel()
  {
    onUp();
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    if ((1 == paramMotionEvent.getAction()) && (this.mDownTouchPosition >= 0))
    {
      if ((!this.mShouldCallbackOnUnselectedItemClick) && (this.mDownTouchPosition == this.mSelectedPosition)) {}
      return true;
    }
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.stop(false);
    this.mDownTouchPosition = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if (this.mDownTouchPosition >= 0)
    {
      this.mDownTouchView = getChildAt(this.mDownTouchPosition - this.mFirstPosition);
      this.mDownTouchView.setPressed(true);
    }
    this.mIsFirstScroll = true;
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (aJQ()) {
      return true;
    }
    if (!this.mShouldCallbackDuringFling)
    {
      removeCallbacks(this.mDisableSuppressSelectionChangedRunnable);
      if (!this.mSuppressSelectionChanged) {
        this.mSuppressSelectionChanged = true;
      }
    }
    if (aJP())
    {
      paramFloat1 = bU();
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.startUsingVelocity((int)-(paramFloat1 * paramFloat2));
      return true;
    }
    paramFloat2 = bU();
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.startUsingVelocity((int)-(paramFloat2 * paramFloat1));
    return true;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.mSelectedChild != null)) {
      this.mSelectedChild.requestFocus(paramInt);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      do
      {
        do
        {
          return bool;
        } while (!movePrevious());
        playSoundEffect(1);
        return true;
      } while (!moveNext());
      playSoundEffect(3);
      return true;
      this.mReceivedInvokeKeyDown = true;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    if ((this.mReceivedInvokeKeyDown) && (this.mItemCount > 0))
    {
      dispatchPress(this.mSelectedChild);
      postDelayed(new VerticalGallery.2(this), ViewConfiguration.getPressedStateDuration());
      performItemClick(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mAdapter.getItemId(this.mSelectedPosition));
    }
    this.mReceivedInvokeKeyDown = false;
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mInLayout = true;
    layout(0, false);
    this.mInLayout = false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.mDownTouchPosition < 0) {
      return;
    }
    performHapticFeedback(0);
    long l = getItemIdAtPosition(this.mDownTouchPosition);
    dispatchLongPress(this.mDownTouchView, this.mDownTouchPosition, l);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (aJQ()) {
      return true;
    }
    this.mScrolling = true;
    getParent().requestDisallowInterceptTouchEvent(true);
    if (!this.mShouldCallbackDuringFling)
    {
      if (this.mIsFirstScroll)
      {
        if (!this.mSuppressSelectionChanged) {
          this.mSuppressSelectionChanged = true;
        }
        postDelayed(this.mDisableSuppressSelectionChangedRunnable, 250L);
      }
      if (!aJP()) {
        break label100;
      }
      abo((int)paramFloat2 * -1);
    }
    for (;;)
    {
      this.mIsFirstScroll = false;
      return true;
      if (!this.mSuppressSelectionChanged) {
        break;
      }
      this.mSuppressSelectionChanged = false;
      break;
      label100:
      trackMotionScroll((int)paramFloat1 * -1);
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.mDownTouchPosition >= 0)
    {
      if (aJR()) {
        this.mDownTouchPosition %= getCount();
      }
      if (aJO()) {
        scrollToChild(this.mDownTouchPosition - this.mFirstPosition);
      }
      nh(this.mDownTouchPosition);
      if ((this.mShouldCallbackOnUnselectedItemClick) || (this.mDownTouchPosition == this.mSelectedPosition)) {
        performItemClick(this.mDownTouchView, this.mDownTouchPosition, this.mAdapter.getItemId(this.mDownTouchPosition));
      }
      return true;
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.mGestureDetector.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i == 1) {
      onUp();
    }
    while (i != 3) {
      return bool;
    }
    onCancel();
    return bool;
  }
  
  protected void onUp()
  {
    if (FlingRunnable.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable).isFinished()) {
      scrollIntoSlots();
    }
    dispatchUnpress();
  }
  
  public void scrollIntoSlots()
  {
    int j = 0;
    if (aJP()) {
      exD();
    }
    int i;
    do
    {
      do
      {
        return;
        if (!aJO()) {
          break;
        }
      } while ((getChildCount() == 0) || (this.mSelectedChild == null));
      i = getCenterOfView(this.mSelectedChild);
      i = getCenterOfGallery() - i;
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.startUsingDistance(i);
        return;
      }
      onFinishedMovement();
      return;
    } while (getChildCount() == 0);
    View localView1;
    if (this.mFirstPosition == 0)
    {
      localView1 = getChildAt(0);
      if (localView1.getLeft() >= 0) {
        i = getPaddingLeft() - localView1.getLeft();
      }
    }
    while (i != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.startUsingDistance(i);
      return;
      View localView2 = getChildAt(getChildCount() - 1);
      if (localView2.getRight() - localView1.getLeft() < getRight() - getPaddingRight())
      {
        i = getPaddingLeft() - this.euT;
      }
      else
      {
        i = j;
        if (localView2.getRight() < getRight() - getPaddingRight())
        {
          i = getWidth() - getPaddingRight() - localView2.getRight();
          continue;
          i = j;
          if (this.mFirstPosition + getChildCount() == this.mItemCount)
          {
            localView1 = getChildAt(getChildCount() - 1);
            i = j;
            if (localView1.getRight() < getRight() - getPaddingRight()) {
              i = getWidth() - getPaddingRight() - localView1.getRight();
            }
          }
        }
      }
    }
    onFinishedMovement();
  }
  
  protected void selectionChanged()
  {
    if (!this.mSuppressSelectionChanged) {
      super.selectionChanged();
    }
  }
  
  public void setAnimationDuration(int paramInt)
  {
    this.mAnimationDuration = paramInt;
  }
  
  public void setCallbackDuringFling(boolean paramBoolean)
  {
    this.mShouldCallbackDuringFling = paramBoolean;
  }
  
  public void setCallbackOnUnselectedItemClick(boolean paramBoolean)
  {
    this.mShouldCallbackOnUnselectedItemClick = paramBoolean;
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    this.dlg = paramBoolean;
  }
  
  public void setFirstChildOffset(int paramInt)
  {
    this.euT = paramInt;
  }
  
  public void setFirstPosition(int paramInt)
  {
    this.mFirstPosition = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      this.mGravity = paramInt;
      requestLayout();
    }
  }
  
  public void setOnEndFlingListener(a parama)
  {
    this.jdField_b_of_type_ComTencentWidgetVerticalGallery$a = parama;
  }
  
  public void setOnEndMovementListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery$b = paramb;
  }
  
  public void setOnSelectViewDataUpdateListener(c paramc)
  {
    this.jdField_b_of_type_ComTencentWidgetVerticalGallery$c = paramc;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void setScrollBarBottomMargin(int paramInt)
  {
    this.euU = paramInt;
  }
  
  public void setScrollBarSize(int paramInt)
  {
    this.euV = paramInt;
  }
  
  public void setScrollCycle(boolean paramBoolean)
  {
    this.dlh = paramBoolean;
  }
  
  protected void setSelectedPositionInt(int paramInt)
  {
    super.setSelectedPositionInt(paramInt);
    updateSelectedItemMetadata();
  }
  
  public void setSlotInCenter(boolean paramBoolean)
  {
    this.dlj = paramBoolean;
  }
  
  public void setSpacing(int paramInt)
  {
    this.mSpacing = paramInt;
  }
  
  public void setUnselectedAlpha(float paramFloat)
  {
    this.mUnselectedAlpha = paramFloat;
  }
  
  public void setVelocityRatio(float paramFloat)
  {
    this.De = paramFloat;
    if (this.De < 0.5F) {
      this.De = 0.5F;
    }
    while (this.De <= 1.5F) {
      return;
    }
    this.De = 1.5F;
  }
  
  public boolean showContextMenu()
  {
    if ((isPressed()) && (this.mSelectedPosition >= 0)) {
      return dispatchLongPress(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
    }
    return false;
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    int i = getPositionForView(paramView);
    if (i < 0) {
      return false;
    }
    return dispatchLongPress(paramView, i, this.mAdapter.getItemId(i));
  }
  
  void trackMotionScroll(int paramInt)
  {
    int i = 0;
    if (getChildCount() == 0) {
      return;
    }
    boolean bool;
    if (paramInt < 0)
    {
      bool = true;
      if (!aJO()) {
        break label109;
      }
      if (((!aJR()) || (getChildCount() >= this.mItemCount)) && (getLimitedMotionScrollAmount(bool, paramInt) != paramInt))
      {
        FlingRunnable.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable, false);
        onFinishedMovement();
      }
      offsetChildrenLeftAndRight(paramInt);
      detachOffScreenChildren(bool);
      if (!bool) {
        break label102;
      }
      fillToGalleryRight();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetAbsSpinner$a.clear();
      setSelectionToCenterChild();
      invalidate();
      return;
      bool = false;
      break;
      label102:
      fillToGalleryLeft();
    }
    label109:
    View localView;
    if (bool)
    {
      localView = getChildAt(getChildCount() - 1);
      if ((localView == null) || (localView.getRight() >= bS())) {
        break label263;
      }
      paramInt = i;
      if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.stop(false);
        paramInt = i;
      }
    }
    label263:
    for (;;)
    {
      offsetChildrenLeftAndRight(paramInt);
      detachOffScreenChildren(bool);
      if (bool) {
        fillToGalleryRight();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetAbsSpinner$a.clear();
        setSelectionToCenterChild();
        awakenScrollBars();
        invalidate();
        return;
        localView = getChildAt(0);
        if ((localView == null) || (localView.getLeft() <= getWidth() - bS())) {
          break label263;
        }
        paramInt = i;
        if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery$FlingRunnable.stop(false);
        paramInt = i;
        break;
        fillToGalleryLeft();
      }
    }
  }
  
  class FlingRunnable
    implements Runnable
  {
    private int mLastFlingX;
    private int mLastFlingY;
    private Scroller mScroller = new Scroller(VerticalGallery.this.getContext());
    
    public FlingRunnable() {}
    
    private void endFling(boolean paramBoolean)
    {
      VerticalGallery.b(VerticalGallery.this, false);
      this.mScroller.forceFinished(true);
      if (paramBoolean) {
        VerticalGallery.this.scrollIntoSlots();
      }
      VerticalGallery.this.exH();
    }
    
    private void startCommon()
    {
      VerticalGallery.this.removeCallbacks(this);
    }
    
    public void exM()
    {
      if (VerticalGallery.this.mItemCount == 0)
      {
        endFling(true);
        return;
      }
      VerticalGallery.c(VerticalGallery.this, false);
      Scroller localScroller = this.mScroller;
      boolean bool = localScroller.computeScrollOffset();
      int j = localScroller.getCurrY();
      int i = this.mLastFlingY - j;
      if (i > 0) {
        VerticalGallery.a(VerticalGallery.this, VerticalGallery.this.mFirstPosition);
      }
      for (i = Math.min(VerticalGallery.this.getHeight() - VerticalGallery.this.getPaddingTop() - VerticalGallery.this.getPaddingBottom() - 1, i);; i = Math.max(-(VerticalGallery.this.getHeight() - VerticalGallery.this.getPaddingBottom() - VerticalGallery.this.getPaddingTop() - 1), i))
      {
        VerticalGallery.this.abo(i);
        if ((!bool) || (VerticalGallery.b(VerticalGallery.this))) {
          break;
        }
        this.mLastFlingY = j;
        VerticalGallery.this.post(this);
        return;
        int k = VerticalGallery.this.getChildCount();
        VerticalGallery.a(VerticalGallery.this, k - 1 + VerticalGallery.this.mFirstPosition);
      }
      endFling(true);
    }
    
    public void run()
    {
      if (VerticalGallery.a(VerticalGallery.this))
      {
        exM();
        return;
      }
      if (VerticalGallery.this.mItemCount == 0)
      {
        endFling(true);
        return;
      }
      VerticalGallery.c(VerticalGallery.this, false);
      Scroller localScroller = this.mScroller;
      boolean bool = localScroller.computeScrollOffset();
      int j = localScroller.getCurrX();
      int i = this.mLastFlingX - j;
      if (i > 0) {
        VerticalGallery.a(VerticalGallery.this, VerticalGallery.this.mFirstPosition);
      }
      for (i = Math.min(VerticalGallery.this.getWidth() - VerticalGallery.this.getPaddingLeft() - VerticalGallery.this.getPaddingRight() - 1, i);; i = Math.max(-(VerticalGallery.this.getWidth() - VerticalGallery.this.getPaddingRight() - VerticalGallery.this.getPaddingLeft() - 1), i))
      {
        VerticalGallery.this.trackMotionScroll(i);
        if ((!bool) || (VerticalGallery.b(VerticalGallery.this))) {
          break;
        }
        this.mLastFlingX = j;
        VerticalGallery.this.post(this);
        return;
        int k = VerticalGallery.this.getChildCount();
        VerticalGallery.a(VerticalGallery.this, k - 1 + VerticalGallery.this.mFirstPosition);
      }
      endFling(true);
    }
    
    public void startUsingDistance(int paramInt)
    {
      if (paramInt == 0) {
        return;
      }
      if (VerticalGallery.a(VerticalGallery.this))
      {
        startCommon();
        VerticalGallery.b(VerticalGallery.this, true);
        this.mLastFlingY = 0;
        this.mScroller.startScroll(0, 0, 0, -paramInt, VerticalGallery.a(VerticalGallery.this));
        VerticalGallery.this.post(this);
        return;
      }
      startCommon();
      VerticalGallery.b(VerticalGallery.this, true);
      this.mLastFlingX = 0;
      this.mScroller.startScroll(0, 0, -paramInt, 0, VerticalGallery.a(VerticalGallery.this));
      VerticalGallery.this.post(this);
    }
    
    public void startUsingVelocity(int paramInt)
    {
      if (paramInt == 0) {
        return;
      }
      startCommon();
      if (VerticalGallery.a(VerticalGallery.this))
      {
        if (paramInt < 0) {}
        for (i = 2147483647;; i = 0)
        {
          this.mLastFlingY = i;
          this.mScroller.fling(0, i, 0, paramInt, 0, 2147483647, 0, 2147483647);
          VerticalGallery.this.post(this);
          return;
        }
      }
      if (paramInt < 0) {}
      for (int i = 2147483647;; i = 0)
      {
        this.mLastFlingX = i;
        this.mScroller.fling(i, 0, paramInt, 0, 0, 2147483647, 0, 2147483647);
        VerticalGallery.this.post(this);
        return;
      }
    }
    
    public void stop(boolean paramBoolean)
    {
      VerticalGallery.this.removeCallbacks(this);
      endFling(paramBoolean);
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(VerticalGallery paramVerticalGallery);
  }
  
  public static abstract interface b
  {
    public abstract void a(VerticalGallery paramVerticalGallery);
  }
  
  public static abstract interface c
  {
    public abstract void af(View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.VerticalGallery
 * JD-Core Version:    0.7.0.1
 */