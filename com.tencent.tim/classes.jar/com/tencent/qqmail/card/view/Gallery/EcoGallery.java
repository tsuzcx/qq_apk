package com.tencent.qqmail.card.view.Gallery;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.Scroller;
import android.widget.SpinnerAdapter;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import com.tencent.androidqqmail.R.styleable;
import com.tencent.qqmail.QMApplicationContext;
import java.lang.reflect.Field;

public class EcoGallery
  extends EcoGalleryAbsSpinner
  implements GestureDetector.OnGestureListener
{
  private static final int INVALID_POINTER = -1;
  private static final String LOG_TAG = "Gallery";
  public static final float OVER_SCROLL_FRICTION = 0.5F;
  private static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
  private static final String TAG = "Gallery";
  private static final boolean localLOGV = false;
  private int mActivePointerId = -1;
  private int mAnimationDuration = 500;
  private boolean mBroken;
  private EcoGalleryAdapterView.AdapterContextMenuInfo mContextMenuInfo;
  private Runnable mDisableSuppressSelectionChangedRunnable = new EcoGallery.1(this);
  private int mDownTouchPosition;
  private View mDownTouchView;
  private EdgeEffectCompat mEdgeGlowLeft;
  private EdgeEffectCompat mEdgeGlowRight;
  private FlingRunnable mFlingRunnable = new FlingRunnable();
  private GestureDetector mGestureDetector;
  private int mGravity;
  private float mInitialMotionX;
  private float mInitialMotionY;
  protected boolean mIsBeingDragged = false;
  private boolean mIsFirstScroll;
  private int mLastScrollState = 0;
  private int mLastTouchX;
  private int mLastTouchY;
  float mManipulateCoeff = 0.7F;
  private Runnable mMoveTopAfterLayout = null;
  private MoveTopRunnable mMoveTopRunnable = new MoveTopRunnable();
  private OnScrollListener mOnScrollListener;
  private long mPreTrackTime = 0L;
  private boolean mReceivedInvokeKeyDown;
  private View mSelectedChild;
  private boolean mShouldCallbackDuringFling = true;
  private boolean mShouldCallbackOnUnselectedItemClick = true;
  private boolean mShouldStopFling;
  private int mSpacing = 0;
  private boolean mSuppressSelectionChanged;
  private int mTouchSlop;
  private float mUnselectedAlpha;
  
  public EcoGallery(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EcoGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131034536);
  }
  
  public EcoGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mBroken = true;
    this.mGestureDetector = new GestureDetector(paramContext, this);
    this.mGestureDetector.setIsLongpressEnabled(true);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.EcoGallery, paramInt, 0);
    paramInt = paramContext.getInt(R.styleable.EcoGallery_eco_gravity, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    paramInt = paramContext.getInt(R.styleable.EcoGallery_animationDuration, -1);
    if (paramInt > 0) {
      setAnimationDuration(paramInt);
    }
    setSpacing(paramContext.getDimensionPixelOffset(R.styleable.EcoGallery_spacing, 0));
    setUnselectedAlpha(paramContext.getFloat(R.styleable.EcoGallery_unselectedAlpha, 0.8F));
    paramContext.recycle();
    int j = 1024;
    paramInt = j;
    int i = j;
    try
    {
      paramContext = ViewGroup.class.getDeclaredField("FLAG_USE_CHILD_DRAWING_ORDER");
      paramInt = j;
      i = j;
      paramAttributeSet = ViewGroup.class.getDeclaredField("FLAG_SUPPORT_STATIC_TRANSFORMATIONS");
      paramInt = j;
      i = j;
      paramContext.setAccessible(true);
      paramInt = j;
      i = j;
      paramAttributeSet.setAccessible(true);
      paramInt = j;
      i = j;
      j = paramContext.getInt(this);
      paramInt = j;
      i = j;
      int k = paramAttributeSet.getInt(this);
      i = k;
      paramInt = j;
      j = i;
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      for (;;)
      {
        try
        {
          paramContext = ViewGroup.class.getDeclaredField("mGroupFlags");
          paramContext.setAccessible(true);
          paramContext.set(this, Integer.valueOf(j | paramInt | paramContext.getInt(this)));
          this.mBroken = false;
          return;
        }
        catch (NoSuchFieldException paramContext)
        {
          Log.e("Gallery", paramContext.getMessage(), paramContext);
          return;
        }
        catch (IllegalAccessException paramContext)
        {
          Log.e("Gallery", paramContext.getMessage(), paramContext);
        }
        paramContext = paramContext;
        Log.e("Gallery", paramContext.getMessage(), paramContext);
        j = 2048;
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        Log.e("Gallery", paramContext.getMessage(), paramContext);
        j = 2048;
        paramInt = i;
      }
    }
  }
  
  private void absorbGlows(int paramInt)
  {
    if (paramInt < 0)
    {
      ensureLeftGlow();
      this.mEdgeGlowLeft.onAbsorb(paramInt);
    }
    for (;;)
    {
      if (paramInt != 0) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      if (paramInt > 0)
      {
        ensureRightGlow();
        this.mEdgeGlowRight.onAbsorb(paramInt);
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
  
  private float computeDisplacement()
  {
    int i = getHeight();
    float f2 = 0.5F;
    float f1 = f2;
    if (this.mLastTouchY > 0)
    {
      f1 = f2;
      if (this.mLastTouchY < i) {
        f1 = this.mLastTouchY / i;
      }
    }
    return f1;
  }
  
  private void considerReleasingGlowsOnScroll(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mEdgeGlowLeft != null)
    {
      bool1 = bool2;
      if (!this.mEdgeGlowLeft.isFinished())
      {
        bool1 = bool2;
        if (paramInt > 0) {
          bool1 = this.mEdgeGlowLeft.onRelease();
        }
      }
    }
    bool2 = bool1;
    if (this.mEdgeGlowRight != null)
    {
      bool2 = bool1;
      if (!this.mEdgeGlowRight.isFinished())
      {
        bool2 = bool1;
        if (paramInt < 0) {
          bool2 = bool1 | this.mEdgeGlowRight.onRelease();
        }
      }
    }
    if (bool2) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void detachOffScreenChildren(boolean paramBoolean)
  {
    int j = 0;
    int k = 0;
    int i2 = getChildCount();
    int i1 = this.mFirstPosition;
    int n;
    View localView;
    if (paramBoolean)
    {
      i3 = getPaddingLeft();
      j = 0;
      i = 0;
      for (;;)
      {
        m = i;
        n = k;
        if (j < i2)
        {
          localView = getChildAt(j);
          if (localView.getRight() >= i3)
          {
            n = k;
            m = i;
          }
        }
        else
        {
          detachViewsFromParent(n, m);
          if (paramBoolean) {
            this.mFirstPosition = (m + this.mFirstPosition);
          }
          return;
        }
        this.mRecycler.addScrapView(localView, i1 + j);
        j += 1;
        i += 1;
      }
    }
    int i3 = getWidth();
    int i4 = getPaddingRight();
    int i = i2 - 1;
    int m = 0;
    k = j;
    j = m;
    for (;;)
    {
      m = j;
      n = k;
      if (i < 0) {
        break;
      }
      localView = getChildAt(i);
      m = j;
      n = k;
      if (localView.getLeft() <= i3 - i4) {
        break;
      }
      this.mRecycler.addScrapView(localView, i1 + i);
      j += 1;
      k = i;
      i -= 1;
    }
  }
  
  private boolean dispatchLongPress(View paramView, int paramInt, long paramLong)
  {
    if (this.mOnItemLongClickListener != null) {}
    for (boolean bool1 = this.mOnItemLongClickListener.onItemLongClick(this, this.mDownTouchView, this.mDownTouchPosition, paramLong);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.mContextMenuInfo = new EcoGalleryAdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
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
  
  private void dispatchUnpress()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).setPressed(false);
      i -= 1;
    }
    setPressed(false);
  }
  
  private void ensureLeftGlow()
  {
    if (this.mEdgeGlowLeft != null) {
      return;
    }
    this.mEdgeGlowLeft = new EdgeEffectCompat(getContext());
    this.mEdgeGlowLeft.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void ensureRightGlow()
  {
    if (this.mEdgeGlowRight != null) {
      return;
    }
    this.mEdgeGlowRight = new EdgeEffectCompat(getContext());
    this.mEdgeGlowRight.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void fillToGalleryLeft()
  {
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
  
  private void fillToGalleryRight()
  {
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
  
  private int getCenterOfGallery()
  {
    int i = getPaddingLeft();
    return i + (getWidth() - i - getPaddingRight()) / 2;
  }
  
  private static int getCenterOfView(View paramView)
  {
    return paramView.getLeft() + paramView.getWidth() / 2;
  }
  
  private float getMotionEventX(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (paramInt < 0) {
      return 1.4E-45F;
    }
    return MotionEventCompat.getX(paramMotionEvent, paramInt);
  }
  
  private float getMotionEventY(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (paramInt < 0) {
      return 1.4E-45F;
    }
    return MotionEventCompat.getY(paramMotionEvent, paramInt);
  }
  
  private void invalidateGlow()
  {
    this.mEdgeGlowRight = null;
    this.mEdgeGlowLeft = null;
  }
  
  private void invokeOnItemScrollListener()
  {
    if (this.mOnScrollListener == null) {
      return;
    }
    if ((this.mSelectedPosition != 0) && (this.mSelectedPosition != this.mItemCount - 1))
    {
      this.mOnScrollListener.onScroll(this.mFirstPosition, getChildCount(), this.mItemCount, this.mSelectedPosition, 0);
      return;
    }
    View localView = getChildAt(this.mSelectedPosition - this.mFirstPosition);
    if (localView == null)
    {
      this.mOnScrollListener.onScroll(this.mFirstPosition, getChildCount(), this.mItemCount, this.mSelectedPosition, 0);
      return;
    }
    int i = getCenterOfView(localView);
    int j = getCenterOfGallery();
    this.mOnScrollListener.onScroll(this.mFirstPosition, getChildCount(), this.mItemCount, this.mSelectedPosition, i - j);
  }
  
  private View makeAndAddView(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    logInGalleryI("makeAndAddView1");
    View localView = obtainView(paramInt1, this.mIsScraped);
    logInGalleryI("makeAndAddView2");
    setUpChild(localView, paramInt2, paramInt3, paramBoolean);
    logInGalleryI("makeAndAddView3");
    return localView;
  }
  
  private int manipulateDistance(int paramInt)
  {
    View localView = getChildAt(this.mSelectedPosition - this.mFirstPosition);
    if (localView == null) {
      return paramInt;
    }
    int k = getCenterOfView(localView);
    int m = getCenterOfGallery();
    int i = localView.getWidth();
    int n = this.mSpacing + i;
    int j = (int)(Math.signum(paramInt) * n * this.mManipulateCoeff + (m - k + paramInt)) / n;
    i = j;
    if (j == 0)
    {
      i = j;
      if (Math.abs(paramInt) >= this.mTouchSlop)
      {
        if (paramInt <= 0) {
          break label131;
        }
        i = 1;
      }
    }
    i += this.mSelectedPosition;
    if (i < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      return (paramInt - this.mSelectedPosition) * n + (k - m);
      label131:
      i = -1;
      break;
      paramInt = i;
      if (i >= this.mItemCount) {
        paramInt = this.mItemCount - 1;
      }
    }
  }
  
  private void offsetChildrenLeftAndRight(int paramInt)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).offsetLeftAndRight(paramInt);
      i -= 1;
    }
  }
  
  private void onFinishedMovement()
  {
    if (this.mSuppressSelectionChanged)
    {
      this.mSuppressSelectionChanged = false;
      super.selectionChanged();
    }
    invalidate();
  }
  
  private void pullGlow(int paramInt)
  {
    float f;
    if (paramInt < 0)
    {
      ensureLeftGlow();
      f = computeDisplacement();
      this.mEdgeGlowLeft.onPull(-paramInt / getWidth(), 1.0F - f);
    }
    for (;;)
    {
      if (paramInt != 0) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      if (paramInt > 0)
      {
        ensureRightGlow();
        f = computeDisplacement();
        this.mEdgeGlowRight.onPull(paramInt / getWidth(), f);
      }
    }
  }
  
  private void releaseGlows()
  {
    boolean bool1 = false;
    if (this.mEdgeGlowLeft != null) {
      bool1 = false | this.mEdgeGlowLeft.onRelease();
    }
    boolean bool2 = bool1;
    if (this.mEdgeGlowRight != null) {
      bool2 = bool1 | this.mEdgeGlowRight.onRelease();
    }
    if (bool2) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void scrollIntoSlots()
  {
    if ((getChildCount() == 0) || (this.mSelectedChild == null)) {
      return;
    }
    int i = getCenterOfView(this.mSelectedChild);
    i = getCenterOfGallery() - i;
    if (i != 0)
    {
      this.mFlingRunnable.startUsingDistance(i);
      return;
    }
    onFinishedMovement();
  }
  
  private boolean scrollToChild(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = getCenterOfGallery();
      int i = getCenterOfView(localView);
      this.mFlingRunnable.startUsingDistance(paramInt - i);
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
      i = this.mFirstPosition + i;
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
    EcoGalleryAbsSpinner.LayoutParams localLayoutParams = (EcoGalleryAbsSpinner.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = generateDefaultLayoutParams();
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
          break label166;
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
        label166:
        paramInt1 = paramInt2 - k;
      }
    }
  }
  
  private boolean shouldPerformItemClick(View paramView)
  {
    if (paramView == null) {}
    while (Math.abs(getCenterOfGallery() - getCenterOfView(paramView)) >= this.mTouchSlop) {
      return false;
    }
    return true;
  }
  
  private void updateSelectedItemMetadata()
  {
    View localView1 = this.mSelectedChild;
    View localView2 = getChildAt(this.mSelectedPosition - this.mFirstPosition);
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
    } while (localView1 == null);
    localView1.setSelected(false);
    localView1.setFocusable(false);
  }
  
  protected float calculateOffsetOfCenter(View paramView)
  {
    int i = getCenterOfCoverflow();
    return Math.max(Math.min((getCenterOfView(paramView) - i) / (i * 1.0F), 1.0F), -1.0F);
  }
  
  public boolean canScroll(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mSelectedPosition == 0) && (paramInt1 > this.mTouchSlop)) {}
    while ((this.mSelectedPosition == this.mItemCount - 1) && (paramInt1 < -this.mTouchSlop)) {
      return false;
    }
    return true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof EcoGalleryAbsSpinner.LayoutParams;
  }
  
  protected int computeHorizontalScrollExtent()
  {
    return 1;
  }
  
  protected int computeHorizontalScrollOffset()
  {
    return this.mSelectedPosition;
  }
  
  protected int computeHorizontalScrollRange()
  {
    return this.mItemCount;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.dispatch(this, null, null);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    if (this.mSelectedChild != null) {
      this.mSelectedChild.setPressed(paramBoolean);
    }
  }
  
  public void dispatchSetSelected(boolean paramBoolean) {}
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k = 0;
    int i = k;
    int j;
    if (this.mEdgeGlowLeft != null)
    {
      i = k;
      if (!this.mEdgeGlowLeft.isFinished())
      {
        k = paramCanvas.save();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-getHeight(), 0.0F);
        j = false | this.mEdgeGlowLeft.draw(paramCanvas);
        paramCanvas.restoreToCount(k);
      }
    }
    k = j;
    boolean bool;
    if (this.mEdgeGlowRight != null)
    {
      k = j;
      if (!this.mEdgeGlowRight.isFinished())
      {
        int m = paramCanvas.save();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(0.0F, -getWidth());
        bool = j | this.mEdgeGlowRight.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    if (bool) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    float f = Math.abs(calculateOffsetOfCenter(paramView));
    paramView.setAlpha(1.0F - f + this.mUnselectedAlpha * f);
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected EcoGalleryAbsSpinner.LayoutParams generateDefaultLayoutParams()
  {
    return new EcoGalleryAbsSpinner.LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new EcoGalleryAbsSpinner.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new EcoGalleryAbsSpinner.LayoutParams(paramLayoutParams);
  }
  
  protected int getCenterOfCoverflow()
  {
    return (getWidth() - getPaddingLeft() - getPaddingRight() >> 1) + getPaddingLeft();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = this.mSelectedPosition - this.mFirstPosition;
    if (i < 0) {}
    do
    {
      do
      {
        return paramInt2;
      } while (i >= paramInt1);
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
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.mContextMenuInfo;
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
        break label42;
      }
      j = paramInt;
    }
    label42:
    int k;
    int m;
    label100:
    do
    {
      return j;
      i = 0;
      break;
      k = getCenterOfView(localView);
      m = getCenterOfGallery();
      if ((ViewCompat.getOverScrollMode(this) == 2) && (this.mLastScrollState != 2)) {}
      for (i = 1;; i = 0)
      {
        if (!paramBoolean) {
          break label100;
        }
        if (k > m) {
          break label118;
        }
        if (i == 0) {
          break;
        }
        return (int)(paramInt * 0.5F);
      }
      if (k < m) {
        break label118;
      }
    } while (i == 0);
    return (int)(paramInt * 0.5F);
    label118:
    int i = m - k;
    if (paramBoolean) {}
    for (paramInt = Math.max(i, paramInt);; paramInt = Math.min(i, paramInt)) {
      return paramInt;
    }
  }
  
  public boolean isBroken()
  {
    return this.mBroken;
  }
  
  void layout(int paramInt, boolean paramBoolean)
  {
    paramInt = this.mSpinnerPadding.left;
    int i = getRight();
    int j = getLeft();
    int k = this.mSpinnerPadding.left;
    int m = this.mSpinnerPadding.right;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    if (this.mItemCount == 0) {
      resetList();
    }
    do
    {
      return;
      if (this.mNextSelectedPosition >= 0) {
        setSelectedPositionInt(this.mNextSelectedPosition);
      }
      recycleAllViews();
      detachAllViewsFromParent();
      this.mFirstPosition = this.mSelectedPosition;
      View localView = makeAndAddView(this.mSelectedPosition, 0, 0, true);
      localView.offsetLeftAndRight(paramInt + (i - j - k - m) / 2 - localView.getWidth() / 2);
      fillToGalleryRight();
      fillToGalleryLeft();
      invalidate();
      checkSelectionChanged();
      this.mDataChanged = false;
      this.mNeedSync = false;
      setNextSelectedPositionInt(this.mSelectedPosition);
      updateSelectedItemMetadata();
      this.mRecycler.scrapActiveViews();
    } while (this.mMoveTopAfterLayout == null);
    post(this.mMoveTopAfterLayout);
    this.mMoveTopAfterLayout = null;
  }
  
  boolean moveNext()
  {
    if ((this.mItemCount > 0) && (this.mSelectedPosition < this.mItemCount - 1))
    {
      scrollToChild(this.mSelectedPosition - this.mFirstPosition + 1);
      return true;
    }
    return false;
  }
  
  boolean movePrevious()
  {
    if ((this.mItemCount > 0) && (this.mSelectedPosition > 0))
    {
      scrollToChild(this.mSelectedPosition - this.mFirstPosition - 1);
      return true;
    }
    return false;
  }
  
  void onCancel()
  {
    onUp();
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.mFlingRunnable.stop(false);
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
    if (!this.mShouldCallbackDuringFling)
    {
      removeCallbacks(this.mDisableSuppressSelectionChangedRunnable);
      if (!this.mSuppressSelectionChanged) {
        this.mSuppressSelectionChanged = true;
      }
    }
    this.mFlingRunnable.startUsingVelocity((int)-paramFloat1);
    return true;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.mSelectedChild != null)) {
      this.mSelectedChild.requestFocus(paramInt);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    }
    for (;;)
    {
      boolean bool1;
      if (!this.mIsBeingDragged)
      {
        bool1 = bool2;
        if (!super.onInterceptTouchEvent(paramMotionEvent)) {}
      }
      else
      {
        bool1 = true;
      }
      float f1;
      float f2;
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
              this.mIsBeingDragged = false;
              f1 = getMotionEventX(paramMotionEvent, this.mActivePointerId);
              f2 = getMotionEventY(paramMotionEvent, this.mActivePointerId);
              bool1 = bool2;
            } while (f1 == 1.4E-45F);
            bool1 = bool2;
          } while (f2 == 1.4E-45F);
          this.mInitialMotionX = f1;
          this.mInitialMotionY = f2;
          break;
          if (this.mActivePointerId == -1)
          {
            Log.e("Gallery", "Got ACTION_MOVE event but don't have an active pointer id.");
            return false;
          }
          f1 = getMotionEventY(paramMotionEvent, this.mActivePointerId);
          f2 = getMotionEventX(paramMotionEvent, this.mActivePointerId);
          bool1 = bool2;
        } while (f1 == 1.4E-45F);
        bool1 = bool2;
      } while (f2 == 1.4E-45F);
      float f3 = Math.max(Math.abs(f1 - this.mInitialMotionY), Math.abs(f2 - this.mInitialMotionX));
      long l1 = paramMotionEvent.getEventTime();
      long l2 = paramMotionEvent.getDownTime();
      if (((!this.mIsBeingDragged) && (f3 > this.mTouchSlop)) || (l1 - l2 > ViewConfiguration.getLongPressTimeout()))
      {
        this.mIsBeingDragged = true;
        paramMotionEvent.setAction(0);
        paramMotionEvent.setLocation(this.mInitialMotionX, this.mInitialMotionY);
        this.mGestureDetector.onTouchEvent(paramMotionEvent);
        paramMotionEvent.setLocation(f2, f1);
        paramMotionEvent.setAction(2);
        continue;
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
      }
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
      postDelayed(new EcoGallery.2(this), ViewConfiguration.getPressedStateDuration());
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
    if (this.mDownTouchPosition < 0) {}
    while (!shouldPerformItemClick(this.mDownTouchView)) {
      return;
    }
    long l = getItemIdAtPosition(this.mDownTouchPosition);
    dispatchLongPress(this.mDownTouchView, this.mDownTouchPosition, l);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    if (!this.mShouldCallbackDuringFling) {
      if (this.mIsFirstScroll)
      {
        if (!this.mSuppressSelectionChanged) {
          this.mSuppressSelectionChanged = true;
        }
        postDelayed(this.mDisableSuppressSelectionChangedRunnable, 250L);
      }
    }
    for (;;)
    {
      trackMotionScroll((int)paramFloat1 * -1);
      this.mIsFirstScroll = false;
      return true;
      if (this.mSuppressSelectionChanged) {
        this.mSuppressSelectionChanged = false;
      }
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.mDownTouchPosition >= 0)
    {
      scrollToChild(this.mDownTouchPosition - this.mFirstPosition);
      if ((this.mShouldCallbackOnUnselectedItemClick) || (this.mDownTouchPosition == this.mSelectedPosition)) {
        performItemClick(this.mDownTouchView, this.mDownTouchPosition, this.mAdapter.getItemId(this.mDownTouchPosition));
      }
      return true;
    }
    return false;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      invalidateGlow();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    this.mLastTouchX = ((int)paramMotionEvent.getX());
    this.mLastTouchY = ((int)paramMotionEvent.getY());
    boolean bool = this.mGestureDetector.onTouchEvent(paramMotionEvent);
    if (i == 1) {
      onUp();
    }
    while (i != 3) {
      return bool;
    }
    onCancel();
    return bool;
  }
  
  void onUp()
  {
    if (this.mFlingRunnable.mScroller.isFinished()) {
      scrollIntoSlots();
    }
    dispatchUnpress();
    releaseGlows();
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    if (!shouldPerformItemClick(paramView)) {
      return false;
    }
    return super.performItemClick(paramView, paramInt, paramLong);
  }
  
  void reportScrollStateChange(int paramInt)
  {
    if (paramInt != this.mLastScrollState)
    {
      if (this.mOnScrollListener != null)
      {
        this.mLastScrollState = paramInt;
        this.mOnScrollListener.onScrollStateChanged(paramInt);
      }
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        if ((localView instanceof ScrollStateObserveView)) {
          ((ScrollStateObserveView)localView).onScrollStateChanged(paramInt);
        }
        i += 1;
      }
    }
  }
  
  void selectionChanged()
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
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      this.mGravity = paramInt;
      requestLayout();
    }
  }
  
  public void setOnScrollListener(OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListener = paramOnScrollListener;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(paramInt);
  }
  
  void setSelectedPositionInt(int paramInt)
  {
    int i = this.mSelectedPosition;
    super.setSelectedPositionInt(paramInt);
    updateSelectedItemMetadata();
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onSelectedChanged(this.mSelectedPosition, i);
    }
  }
  
  public void setSpacing(int paramInt)
  {
    this.mSpacing = paramInt;
  }
  
  public void setUnselectedAlpha(float paramFloat)
  {
    this.mUnselectedAlpha = paramFloat;
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
  
  public void smoothToFirstPos()
  {
    this.mMoveTopRunnable.scrollTop();
  }
  
  void trackMotionScroll(int paramInt)
  {
    if (getChildCount() == 0) {
      return;
    }
    boolean bool;
    int i;
    if (paramInt < 0)
    {
      bool = true;
      i = getLimitedMotionScrollAmount(bool, paramInt);
      if (i != paramInt)
      {
        this.mFlingRunnable.endFling(false);
        onFinishedMovement();
      }
      offsetChildrenLeftAndRight(i);
      detachOffScreenChildren(bool);
      if (!bool) {
        break label94;
      }
      fillToGalleryRight();
    }
    for (;;)
    {
      setSelectionToCenterChild();
      if (ViewCompat.getOverScrollMode(this) != 2)
      {
        considerReleasingGlowsOnScroll(i);
        pullGlow(i - paramInt);
      }
      invokeOnItemScrollListener();
      invalidate();
      return;
      bool = false;
      break;
      label94:
      fillToGalleryLeft();
    }
  }
  
  class FlingRunnable
    implements Runnable
  {
    private int mLastFlingX;
    private Scroller mScroller = new Scroller(EcoGallery.this.getContext());
    
    public FlingRunnable() {}
    
    private void endFling(boolean paramBoolean)
    {
      this.mScroller.forceFinished(true);
      if (paramBoolean) {
        EcoGallery.this.scrollIntoSlots();
      }
      EcoGallery.this.reportScrollStateChange(0);
    }
    
    private void startCommon()
    {
      EcoGallery.this.removeCallbacks(this);
    }
    
    public void run()
    {
      if (EcoGallery.this.mItemCount == 0)
      {
        endFling(true);
        return;
      }
      EcoGallery.access$702(EcoGallery.this, false);
      Scroller localScroller = this.mScroller;
      boolean bool = localScroller.computeScrollOffset();
      int j = localScroller.getCurrX();
      int i = this.mLastFlingX - j;
      if (i > 0) {
        EcoGallery.access$802(EcoGallery.this, EcoGallery.this.mFirstPosition);
      }
      for (i = Math.min(EcoGallery.this.getWidth() - EcoGallery.this.getPaddingLeft() - EcoGallery.this.getPaddingRight() - 1, i);; i = Math.max(-(EcoGallery.this.getWidth() - EcoGallery.this.getPaddingRight() - EcoGallery.this.getPaddingLeft() - 1), i))
      {
        EcoGallery.this.trackMotionScroll(i);
        if ((!bool) || (EcoGallery.this.mShouldStopFling)) {
          break;
        }
        this.mLastFlingX = j;
        ViewCompat.postOnAnimation(EcoGallery.this, this);
        return;
        int k = EcoGallery.this.getChildCount();
        EcoGallery.access$802(EcoGallery.this, k - 1 + EcoGallery.this.mFirstPosition);
      }
      endFling(true);
    }
    
    public void startFling(int paramInt1, int paramInt2)
    {
      if (paramInt1 == 0) {
        return;
      }
      startCommon();
      EcoGallery.this.reportScrollStateChange(1);
      this.mLastFlingX = 0;
      this.mScroller.fling(0, 0, -paramInt2, 0, -Math.abs(paramInt1), Math.abs(paramInt1), 0, 0);
      ViewCompat.postOnAnimation(EcoGallery.this, this);
    }
    
    public void startUsingDistance(int paramInt)
    {
      startUsingDistance(paramInt, EcoGallery.this.mAnimationDuration);
    }
    
    public void startUsingDistance(int paramInt1, int paramInt2)
    {
      if (paramInt1 == 0) {
        return;
      }
      startCommon();
      EcoGallery.this.reportScrollStateChange(1);
      this.mLastFlingX = 0;
      this.mScroller.startScroll(0, 0, -paramInt1, 0, paramInt2);
      ViewCompat.postOnAnimation(EcoGallery.this, this);
    }
    
    public void startUsingVelocity(int paramInt)
    {
      if (paramInt == 0) {
        return;
      }
      int i = (int)(paramInt / 1.5D);
      startCommon();
      paramInt = Math.abs(i);
      double d2 = EcoGallery.FlingUtil.getSplineFlingDistance(paramInt) * Math.signum(i);
      int j = EcoGallery.this.manipulateDistance((int)d2);
      paramInt = EcoGallery.FlingUtil.getSplineFlingDuration(paramInt);
      double d3 = j;
      double d1 = d2;
      if (d2 == 0.0D) {
        d1 = 1.0D;
      }
      d2 = Math.abs(d3 / d1);
      d1 = d2;
      if (d2 > 1.5D) {
        d1 = 1.5D;
      }
      i = (int)(d1 * paramInt);
      paramInt = i;
      if (i < EcoGallery.this.mAnimationDuration) {
        paramInt = EcoGallery.this.mAnimationDuration;
      }
      EcoGallery.this.reportScrollStateChange(2);
      this.mLastFlingX = 0;
      this.mScroller.startScroll(0, 0, j, 0, paramInt);
      ViewCompat.postOnAnimation(EcoGallery.this, this);
    }
    
    public void stop(boolean paramBoolean)
    {
      EcoGallery.this.removeCallbacks(this);
      endFling(paramBoolean);
    }
  }
  
  public static class FlingUtil
  {
    private static final float DECELERATION_RATE = (float)(Math.log(0.78D) / Math.log(0.9D));
    private static final float INFLEXION = 0.35F;
    private static float mFlingFriction = ViewConfiguration.getScrollFriction() * 3.0F;
    private static float mPhysicalCoeff = computeDeceleration(0.84F);
    private static float mPpi = QMApplicationContext.sharedInstance().getResources().getDisplayMetrics().density * 160.0F;
    
    private static float computeDeceleration(float paramFloat)
    {
      return 386.0878F * mPpi * paramFloat;
    }
    
    public static double getFlingVelocityByDistance(float paramFloat)
    {
      return Math.exp(Math.log(Math.abs(paramFloat) / (mFlingFriction * mPhysicalCoeff)) * (DECELERATION_RATE - 1.0D) / DECELERATION_RATE) * (mFlingFriction * mPhysicalCoeff) / 0.3499999940395355D * Math.signum(paramFloat);
    }
    
    private static double getSplineDeceleration(double paramDouble)
    {
      return Math.log(0.3499999940395355D * Math.abs(paramDouble) / (mFlingFriction * mPhysicalCoeff));
    }
    
    public static double getSplineFlingDistance(float paramFloat)
    {
      double d1 = getSplineDeceleration(paramFloat);
      double d2 = DECELERATION_RATE;
      double d3 = mFlingFriction * mPhysicalCoeff;
      return Math.exp(d1 * (DECELERATION_RATE / (d2 - 1.0D))) * d3;
    }
    
    public static int getSplineFlingDuration(double paramDouble)
    {
      return (int)(Math.exp(getSplineDeceleration(paramDouble) / (DECELERATION_RATE - 1.0D)) * 1000.0D);
    }
  }
  
  static class LinearScroller
  {
    private float mDelta;
    private int mDest;
    private int mMaxStep;
    private int mScrolled;
    private float mSign;
    private long mStartTime;
    
    public boolean computeScrollOffset()
    {
      if (this.mScrolled >= this.mDest) {
        return false;
      }
      int i = Math.min((int)((int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime) * this.mDelta), this.mDest);
      if (i - this.mScrolled > this.mMaxStep) {}
      for (this.mScrolled += this.mMaxStep;; this.mScrolled = i) {
        return true;
      }
    }
    
    public int getScrolled()
    {
      return (int)(this.mScrolled * this.mSign);
    }
    
    public void startScroll(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mDest = Math.abs(paramInt1);
      this.mMaxStep = Math.abs(paramInt3);
      this.mDelta = Math.max(1.0F, this.mDest / paramInt2);
      this.mScrolled = 0;
      this.mSign = Math.signum(paramInt1);
    }
  }
  
  class MoveTopRunnable
    implements Runnable
  {
    private static final int MAX_STEP = 240;
    private static final int SCROLL_DURATION = 200;
    private int mLastScroll;
    private EcoGallery.LinearScroller mScroller = new EcoGallery.LinearScroller(null);
    
    public MoveTopRunnable() {}
    
    public void run()
    {
      if (EcoGallery.this.mItemCount == 0)
      {
        stop();
        return;
      }
      boolean bool = this.mScroller.computeScrollOffset();
      int j = this.mScroller.getScrolled();
      int i = this.mLastScroll - j;
      if (i > 0) {
        EcoGallery.access$802(EcoGallery.this, EcoGallery.this.mFirstPosition);
      }
      for (i = Math.min(EcoGallery.this.getWidth() - EcoGallery.this.getPaddingLeft() - EcoGallery.this.getPaddingRight() - 1, i);; i = Math.max(-(EcoGallery.this.getWidth() - EcoGallery.this.getPaddingRight() - EcoGallery.this.getPaddingLeft() - 1), i))
      {
        EcoGallery.this.trackMotionScroll(i);
        if ((!bool) || (EcoGallery.this.mShouldStopFling)) {
          break;
        }
        this.mLastScroll = j;
        ViewCompat.postOnAnimation(EcoGallery.this, this);
        return;
        int k = EcoGallery.this.getChildCount();
        EcoGallery.access$802(EcoGallery.this, k - 1 + EcoGallery.this.mFirstPosition);
      }
      stop();
    }
    
    public void scrollTop()
    {
      stop();
      if ((EcoGallery.this.mDataChanged) || (EcoGallery.this.isLayoutRequested())) {
        EcoGallery.access$1002(EcoGallery.this, new EcoGallery.MoveTopRunnable.1(this));
      }
      int i = EcoGallery.this.getChildCount();
      View localView = EcoGallery.this.getChildAt(0);
      if ((i <= 1) || (localView == null)) {
        return;
      }
      i = EcoGallery.this.getCenterOfGallery();
      int j = EcoGallery.getCenterOfView(localView);
      int k = EcoGallery.this.mFirstPosition;
      float f = localView.getWidth() + EcoGallery.this.mSpacing;
      i = (int)(i - j + f * k);
      j = Math.min(EcoGallery.this.getWidth() - EcoGallery.this.getPaddingRight() - EcoGallery.this.getPaddingLeft() - 1, 240);
      this.mLastScroll = 0;
      this.mScroller.startScroll(-i, 200, j);
      EcoGallery.access$702(EcoGallery.this, false);
      EcoGallery.this.reportScrollStateChange(2);
      ViewCompat.postOnAnimation(EcoGallery.this, this);
    }
    
    public void stop()
    {
      EcoGallery.this.removeCallbacks(this);
      EcoGallery.this.reportScrollStateChange(0);
      EcoGallery.this.mFlingRunnable.stop(false);
    }
  }
  
  public static abstract interface OnScrollListener
  {
    public static final int SCROLL_STATE_FLING = 2;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_TOUCH_SCROLL = 1;
    
    public abstract void onScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract void onScrollStateChanged(int paramInt);
    
    public abstract void onSelectedChanged(int paramInt1, int paramInt2);
  }
  
  public static abstract interface ScrollStateObserveView
  {
    public abstract void onScrollStateChanged(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.Gallery.EcoGallery
 * JD-Core Version:    0.7.0.1
 */