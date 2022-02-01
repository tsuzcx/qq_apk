package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;

public class SwipeRefreshLayout
  extends ViewGroup
  implements NestedScrollingChild, NestedScrollingParent
{
  private static final int ALPHA_ANIMATION_DURATION = 300;
  private static final int ANIMATE_TO_START_DURATION = 200;
  private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
  private static final int CIRCLE_BG_LIGHT = -328966;
  @VisibleForTesting
  static final int CIRCLE_DIAMETER = 40;
  @VisibleForTesting
  static final int CIRCLE_DIAMETER_LARGE = 56;
  private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0F;
  public static final int DEFAULT = 1;
  private static final int DEFAULT_CIRCLE_TARGET = 64;
  private static final float DRAG_RATE = 0.5F;
  private static final int INVALID_POINTER = -1;
  public static final int LARGE = 0;
  private static final int[] LAYOUT_ATTRS = { 16842766 };
  private static final String LOG_TAG = "SwipeRefreshLayout";
  private static final int MAX_ALPHA = 255;
  private static final float MAX_PROGRESS_ANGLE = 0.8F;
  private static final int SCALE_DOWN_DURATION = 150;
  private static final int STARTING_PROGRESS_ALPHA = 76;
  private int mActivePointerId = -1;
  private Animation mAlphaMaxAnimation;
  private Animation mAlphaStartAnimation;
  private final Animation mAnimateToCorrectPosition = new Animation()
  {
    public void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      if (!SwipeRefreshLayout.this.mUsingCustomStart) {
        i = SwipeRefreshLayout.this.mSpinnerOffsetEnd - Math.abs(SwipeRefreshLayout.this.mOriginalOffsetTop);
      } else {
        i = SwipeRefreshLayout.this.mSpinnerOffsetEnd;
      }
      int j = SwipeRefreshLayout.this.mFrom;
      int i = (int)((i - SwipeRefreshLayout.this.mFrom) * paramAnonymousFloat);
      int k = SwipeRefreshLayout.this.mCircleView.getTop();
      SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(j + i - k);
      SwipeRefreshLayout.this.mProgress.setArrowScale(1.0F - paramAnonymousFloat);
    }
  };
  private final Animation mAnimateToStartPosition = new Animation()
  {
    public void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      SwipeRefreshLayout.this.moveToStart(paramAnonymousFloat);
    }
  };
  private OnChildScrollUpCallback mChildScrollUpCallback;
  private int mCircleDiameter;
  CircleImageView mCircleView;
  private int mCircleViewIndex = -1;
  int mCurrentTargetOffsetTop;
  private final DecelerateInterpolator mDecelerateInterpolator;
  protected int mFrom;
  private float mInitialDownY;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  OnRefreshListener mListener;
  private int mMediumAnimationDuration;
  private boolean mNestedScrollInProgress;
  private final NestedScrollingChildHelper mNestedScrollingChildHelper;
  private final NestedScrollingParentHelper mNestedScrollingParentHelper;
  boolean mNotify;
  protected int mOriginalOffsetTop;
  private final int[] mParentOffsetInWindow = new int[2];
  private final int[] mParentScrollConsumed = new int[2];
  CircularProgressDrawable mProgress;
  private Animation.AnimationListener mRefreshListener = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (SwipeRefreshLayout.this.mRefreshing)
      {
        SwipeRefreshLayout.this.mProgress.setAlpha(255);
        SwipeRefreshLayout.this.mProgress.start();
        if ((SwipeRefreshLayout.this.mNotify) && (SwipeRefreshLayout.this.mListener != null)) {
          SwipeRefreshLayout.this.mListener.onRefresh();
        }
        paramAnonymousAnimation = SwipeRefreshLayout.this;
        paramAnonymousAnimation.mCurrentTargetOffsetTop = paramAnonymousAnimation.mCircleView.getTop();
        return;
      }
      SwipeRefreshLayout.this.reset();
    }
    
    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  boolean mRefreshing = false;
  private boolean mReturningToStart;
  boolean mScale;
  private Animation mScaleAnimation;
  private Animation mScaleDownAnimation;
  private Animation mScaleDownToStartAnimation;
  int mSpinnerOffsetEnd;
  float mStartingScale;
  private View mTarget;
  private float mTotalDragDistance = -1.0F;
  private float mTotalUnconsumed;
  private int mTouchSlop;
  boolean mUsingCustomStart;
  
  public SwipeRefreshLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeRefreshLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mMediumAnimationDuration = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.mDecelerateInterpolator = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mCircleDiameter = ((int)(localDisplayMetrics.density * 40.0F));
    createProgressView();
    setChildrenDrawingOrderEnabled(true);
    this.mSpinnerOffsetEnd = ((int)(localDisplayMetrics.density * 64.0F));
    this.mTotalDragDistance = this.mSpinnerOffsetEnd;
    this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
    setNestedScrollingEnabled(true);
    int i = -this.mCircleDiameter;
    this.mCurrentTargetOffsetTop = i;
    this.mOriginalOffsetTop = i;
    moveToStart(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void animateOffsetToCorrectPosition(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.mAnimateToCorrectPosition.reset();
    this.mAnimateToCorrectPosition.setDuration(200L);
    this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
    if (paramAnimationListener != null) {
      this.mCircleView.setAnimationListener(paramAnimationListener);
    }
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
  }
  
  private void animateOffsetToStartPosition(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    if (this.mScale)
    {
      startScaleDownReturnToStartAnimation(paramInt, paramAnimationListener);
      return;
    }
    this.mFrom = paramInt;
    this.mAnimateToStartPosition.reset();
    this.mAnimateToStartPosition.setDuration(200L);
    this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
    if (paramAnimationListener != null) {
      this.mCircleView.setAnimationListener(paramAnimationListener);
    }
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mAnimateToStartPosition);
  }
  
  private void createProgressView()
  {
    this.mCircleView = new CircleImageView(getContext(), -328966);
    this.mProgress = new CircularProgressDrawable(getContext());
    this.mProgress.setStyle(1);
    this.mCircleView.setImageDrawable(this.mProgress);
    this.mCircleView.setVisibility(8);
    addView(this.mCircleView);
  }
  
  private void ensureTarget()
  {
    if (this.mTarget == null)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.mCircleView))
        {
          this.mTarget = localView;
          return;
        }
        i += 1;
      }
    }
  }
  
  private void finishSpinner(float paramFloat)
  {
    if (paramFloat > this.mTotalDragDistance)
    {
      setRefreshing(true, true);
      return;
    }
    this.mRefreshing = false;
    this.mProgress.setStartEndTrim(0.0F, 0.0F);
    Animation.AnimationListener local5 = null;
    if (!this.mScale) {
      local5 = new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (!SwipeRefreshLayout.this.mScale) {
            SwipeRefreshLayout.this.startScaleDownAnimation(null);
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      };
    }
    animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, local5);
    this.mProgress.setArrowEnabled(false);
  }
  
  private boolean isAnimationRunning(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void moveSpinner(float paramFloat)
  {
    this.mProgress.setArrowEnabled(true);
    float f1 = Math.min(1.0F, Math.abs(paramFloat / this.mTotalDragDistance));
    double d1 = f1;
    Double.isNaN(d1);
    float f2 = (float)Math.max(d1 - 0.4D, 0.0D) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.mTotalDragDistance;
    if (this.mUsingCustomStart) {
      i = this.mSpinnerOffsetEnd - this.mOriginalOffsetTop;
    } else {
      i = this.mSpinnerOffsetEnd;
    }
    float f3 = i;
    d1 = Math.max(0.0F, Math.min(f4 - f5, f3 * 2.0F) / f3) / 4.0F;
    double d2 = Math.pow(d1, 2.0D);
    Double.isNaN(d1);
    f4 = (float)(d1 - d2) * 2.0F;
    int i = this.mOriginalOffsetTop;
    int j = (int)(f3 * f1 + f3 * f4 * 2.0F);
    if (this.mCircleView.getVisibility() != 0) {
      this.mCircleView.setVisibility(0);
    }
    if (!this.mScale)
    {
      this.mCircleView.setScaleX(1.0F);
      this.mCircleView.setScaleY(1.0F);
    }
    if (this.mScale) {
      setAnimationProgress(Math.min(1.0F, paramFloat / this.mTotalDragDistance));
    }
    if (paramFloat < this.mTotalDragDistance)
    {
      if ((this.mProgress.getAlpha() > 76) && (!isAnimationRunning(this.mAlphaStartAnimation))) {
        startProgressAlphaStartAnimation();
      }
    }
    else if ((this.mProgress.getAlpha() < 255) && (!isAnimationRunning(this.mAlphaMaxAnimation))) {
      startProgressAlphaMaxAnimation();
    }
    this.mProgress.setStartEndTrim(0.0F, Math.min(0.8F, f2 * 0.8F));
    this.mProgress.setArrowScale(Math.min(1.0F, f2));
    this.mProgress.setProgressRotation((f2 * 0.4F - 0.25F + f4 * 2.0F) * 0.5F);
    setTargetOffsetTopAndBottom(i + j - this.mCurrentTargetOffsetTop);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
    }
  }
  
  private void setColorViewAlpha(int paramInt)
  {
    this.mCircleView.getBackground().setAlpha(paramInt);
    this.mProgress.setAlpha(paramInt);
  }
  
  private void setRefreshing(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mRefreshing != paramBoolean1)
    {
      this.mNotify = paramBoolean2;
      ensureTarget();
      this.mRefreshing = paramBoolean1;
      if (this.mRefreshing)
      {
        animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
        return;
      }
      startScaleDownAnimation(this.mRefreshListener);
    }
  }
  
  private Animation startAlphaAnimation(final int paramInt1, final int paramInt2)
  {
    Animation local4 = new Animation()
    {
      public void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        paramAnonymousTransformation = SwipeRefreshLayout.this.mProgress;
        int i = paramInt1;
        paramAnonymousTransformation.setAlpha((int)(i + (paramInt2 - i) * paramAnonymousFloat));
      }
    };
    local4.setDuration(300L);
    this.mCircleView.setAnimationListener(null);
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(local4);
    return local4;
  }
  
  private void startDragging(float paramFloat)
  {
    float f = this.mInitialDownY;
    int i = this.mTouchSlop;
    if ((paramFloat - f > i) && (!this.mIsBeingDragged))
    {
      this.mInitialMotionY = (f + i);
      this.mIsBeingDragged = true;
      this.mProgress.setAlpha(76);
    }
  }
  
  private void startProgressAlphaMaxAnimation()
  {
    this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
  }
  
  private void startProgressAlphaStartAnimation()
  {
    this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
  }
  
  private void startScaleDownReturnToStartAnimation(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.mStartingScale = this.mCircleView.getScaleX();
    this.mScaleDownToStartAnimation = new Animation()
    {
      public void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        float f1 = SwipeRefreshLayout.this.mStartingScale;
        float f2 = -SwipeRefreshLayout.this.mStartingScale;
        SwipeRefreshLayout.this.setAnimationProgress(f1 + f2 * paramAnonymousFloat);
        SwipeRefreshLayout.this.moveToStart(paramAnonymousFloat);
      }
    };
    this.mScaleDownToStartAnimation.setDuration(150L);
    if (paramAnimationListener != null) {
      this.mCircleView.setAnimationListener(paramAnimationListener);
    }
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
  }
  
  private void startScaleUpAnimation(Animation.AnimationListener paramAnimationListener)
  {
    this.mCircleView.setVisibility(0);
    this.mProgress.setAlpha(255);
    this.mScaleAnimation = new Animation()
    {
      public void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.setAnimationProgress(paramAnonymousFloat);
      }
    };
    this.mScaleAnimation.setDuration(this.mMediumAnimationDuration);
    if (paramAnimationListener != null) {
      this.mCircleView.setAnimationListener(paramAnimationListener);
    }
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mScaleAnimation);
  }
  
  public boolean canChildScrollUp()
  {
    Object localObject = this.mChildScrollUpCallback;
    if (localObject != null) {
      return ((OnChildScrollUpCallback)localObject).canChildScrollUp(this, this.mTarget);
    }
    localObject = this.mTarget;
    if ((localObject instanceof ListView)) {
      return ListViewCompat.canScrollList((ListView)localObject, -1);
    }
    return ((View)localObject).canScrollVertically(-1);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.mNestedScrollingChildHelper.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.mNestedScrollingChildHelper.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.mNestedScrollingChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = this.mCircleViewIndex;
    if (i < 0) {
      return paramInt2;
    }
    if (paramInt2 == paramInt1 - 1) {
      return i;
    }
    if (paramInt2 >= i) {
      return paramInt2 + 1;
    }
    return paramInt2;
  }
  
  public int getNestedScrollAxes()
  {
    return this.mNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  public int getProgressCircleDiameter()
  {
    return this.mCircleDiameter;
  }
  
  public int getProgressViewEndOffset()
  {
    return this.mSpinnerOffsetEnd;
  }
  
  public int getProgressViewStartOffset()
  {
    return this.mOriginalOffsetTop;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
  }
  
  public boolean isRefreshing()
  {
    return this.mRefreshing;
  }
  
  void moveToStart(float paramFloat)
  {
    int i = this.mFrom;
    setTargetOffsetTopAndBottom(i + (int)((this.mOriginalOffsetTop - i) * paramFloat) - this.mCircleView.getTop());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    reset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ensureTarget();
    int i = paramMotionEvent.getActionMasked();
    if ((this.mReturningToStart) && (i == 0)) {
      this.mReturningToStart = false;
    }
    if ((isEnabled()) && (!this.mReturningToStart) && (!canChildScrollUp()) && (!this.mRefreshing))
    {
      if (this.mNestedScrollInProgress) {
        return false;
      }
      if (i != 6) {
        switch (i)
        {
        default: 
          break;
        case 2: 
          i = this.mActivePointerId;
          if (i == -1)
          {
            Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
            return false;
          }
          i = paramMotionEvent.findPointerIndex(i);
          if (i < 0) {
            return false;
          }
          startDragging(paramMotionEvent.getY(i));
          break;
        case 1: 
        case 3: 
          this.mIsBeingDragged = false;
          this.mActivePointerId = -1;
          break;
        case 0: 
          setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.mIsBeingDragged = false;
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i < 0) {
            return false;
          }
          this.mInitialDownY = paramMotionEvent.getY(i);
          break;
        }
      } else {
        onSecondaryPointerUp(paramMotionEvent);
      }
      return this.mIsBeingDragged;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() == 0) {
      return;
    }
    if (this.mTarget == null) {
      ensureTarget();
    }
    Object localObject = this.mTarget;
    if (localObject == null) {
      return;
    }
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    ((View)localObject).layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt3 = this.mCircleView.getMeasuredWidth();
    paramInt2 = this.mCircleView.getMeasuredHeight();
    localObject = this.mCircleView;
    paramInt1 /= 2;
    paramInt3 /= 2;
    paramInt4 = this.mCurrentTargetOffsetTop;
    ((CircleImageView)localObject).layout(paramInt1 - paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mTarget == null) {
      ensureTarget();
    }
    View localView = this.mTarget;
    if (localView == null) {
      return;
    }
    localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
    this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
    this.mCircleViewIndex = -1;
    paramInt1 = 0;
    while (paramInt1 < getChildCount())
    {
      if (getChildAt(paramInt1) == this.mCircleView)
      {
        this.mCircleViewIndex = paramInt1;
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (paramInt2 > 0)
    {
      float f1 = this.mTotalUnconsumed;
      if (f1 > 0.0F)
      {
        float f2 = paramInt2;
        if (f2 > f1)
        {
          paramArrayOfInt[1] = (paramInt2 - (int)f1);
          this.mTotalUnconsumed = 0.0F;
        }
        else
        {
          this.mTotalUnconsumed = (f1 - f2);
          paramArrayOfInt[1] = paramInt2;
        }
        moveSpinner(this.mTotalUnconsumed);
      }
    }
    if ((this.mUsingCustomStart) && (paramInt2 > 0) && (this.mTotalUnconsumed == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
      this.mCircleView.setVisibility(8);
    }
    paramView = this.mParentScrollConsumed;
    if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
    {
      paramArrayOfInt[0] += paramView[0];
      paramArrayOfInt[1] += paramView[1];
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mParentOffsetInWindow);
    paramInt1 = paramInt4 + this.mParentOffsetInWindow[1];
    if ((paramInt1 < 0) && (!canChildScrollUp()))
    {
      this.mTotalUnconsumed += Math.abs(paramInt1);
      moveSpinner(this.mTotalUnconsumed);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.mNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    startNestedScroll(paramInt & 0x2);
    this.mTotalUnconsumed = 0.0F;
    this.mNestedScrollInProgress = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!this.mReturningToStart) && (!this.mRefreshing) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.mNestedScrollingParentHelper.onStopNestedScroll(paramView);
    this.mNestedScrollInProgress = false;
    float f = this.mTotalUnconsumed;
    if (f > 0.0F)
    {
      finishSpinner(f);
      this.mTotalUnconsumed = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((this.mReturningToStart) && (i == 0)) {
      this.mReturningToStart = false;
    }
    if ((isEnabled()) && (!this.mReturningToStart) && (!canChildScrollUp()) && (!this.mRefreshing))
    {
      if (this.mNestedScrollInProgress) {
        return false;
      }
      float f1;
      switch (i)
      {
      case 4: 
      default: 
        break;
      case 6: 
        onSecondaryPointerUp(paramMotionEvent);
        break;
      case 5: 
        i = paramMotionEvent.getActionIndex();
        if (i < 0)
        {
          Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
          return false;
        }
        this.mActivePointerId = paramMotionEvent.getPointerId(i);
        break;
      case 3: 
        return false;
      case 2: 
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i < 0)
        {
          Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
          return false;
        }
        f1 = paramMotionEvent.getY(i);
        startDragging(f1);
        if (this.mIsBeingDragged)
        {
          f1 = (f1 - this.mInitialMotionY) * 0.5F;
          if (f1 > 0.0F) {
            moveSpinner(f1);
          } else {
            return false;
          }
        }
        break;
      case 1: 
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i < 0)
        {
          Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
          return false;
        }
        if (this.mIsBeingDragged)
        {
          f1 = paramMotionEvent.getY(i);
          float f2 = this.mInitialMotionY;
          this.mIsBeingDragged = false;
          finishSpinner((f1 - f2) * 0.5F);
        }
        this.mActivePointerId = -1;
        return false;
      case 0: 
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mIsBeingDragged = false;
      }
      return true;
    }
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 21) || (!(this.mTarget instanceof AbsListView)))
    {
      View localView = this.mTarget;
      if ((localView != null) && (!ViewCompat.isNestedScrollingEnabled(localView))) {
        return;
      }
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  void reset()
  {
    this.mCircleView.clearAnimation();
    this.mProgress.stop();
    this.mCircleView.setVisibility(8);
    setColorViewAlpha(255);
    if (this.mScale) {
      setAnimationProgress(0.0F);
    } else {
      setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
    }
    this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
  }
  
  void setAnimationProgress(float paramFloat)
  {
    this.mCircleView.setScaleX(paramFloat);
    this.mCircleView.setScaleY(paramFloat);
  }
  
  @Deprecated
  public void setColorScheme(@ColorRes int... paramVarArgs)
  {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(@ColorInt int... paramVarArgs)
  {
    ensureTarget();
    this.mProgress.setColorSchemeColors(paramVarArgs);
  }
  
  public void setColorSchemeResources(@ColorRes int... paramVarArgs)
  {
    Context localContext = getContext();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfInt[i] = ContextCompat.getColor(localContext, paramVarArgs[i]);
      i += 1;
    }
    setColorSchemeColors(arrayOfInt);
  }
  
  public void setDistanceToTriggerSync(int paramInt)
  {
    this.mTotalDragDistance = paramInt;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (!paramBoolean) {
      reset();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.mNestedScrollingChildHelper.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback paramOnChildScrollUpCallback)
  {
    this.mChildScrollUpCallback = paramOnChildScrollUpCallback;
  }
  
  public void setOnRefreshListener(@Nullable OnRefreshListener paramOnRefreshListener)
  {
    this.mListener = paramOnRefreshListener;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt)
  {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(@ColorInt int paramInt)
  {
    this.mCircleView.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(@ColorRes int paramInt)
  {
    setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  public void setProgressViewEndTarget(boolean paramBoolean, int paramInt)
  {
    this.mSpinnerOffsetEnd = paramInt;
    this.mScale = paramBoolean;
    this.mCircleView.invalidate();
  }
  
  public void setProgressViewOffset(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mScale = paramBoolean;
    this.mOriginalOffsetTop = paramInt1;
    this.mSpinnerOffsetEnd = paramInt2;
    this.mUsingCustomStart = true;
    reset();
    this.mRefreshing = false;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mRefreshing != paramBoolean))
    {
      this.mRefreshing = paramBoolean;
      int i;
      if (!this.mUsingCustomStart) {
        i = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
      } else {
        i = this.mSpinnerOffsetEnd;
      }
      setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop);
      this.mNotify = false;
      startScaleUpAnimation(this.mRefreshListener);
      return;
    }
    setRefreshing(paramBoolean, false);
  }
  
  public void setSize(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if (paramInt == 0) {
      this.mCircleDiameter = ((int)(localDisplayMetrics.density * 56.0F));
    } else {
      this.mCircleDiameter = ((int)(localDisplayMetrics.density * 40.0F));
    }
    this.mCircleView.setImageDrawable(null);
    this.mProgress.setStyle(paramInt);
    this.mCircleView.setImageDrawable(this.mProgress);
  }
  
  void setTargetOffsetTopAndBottom(int paramInt)
  {
    this.mCircleView.bringToFront();
    ViewCompat.offsetTopAndBottom(this.mCircleView, paramInt);
    this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.mNestedScrollingChildHelper.startNestedScroll(paramInt);
  }
  
  void startScaleDownAnimation(Animation.AnimationListener paramAnimationListener)
  {
    this.mScaleDownAnimation = new Animation()
    {
      public void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.setAnimationProgress(1.0F - paramAnonymousFloat);
      }
    };
    this.mScaleDownAnimation.setDuration(150L);
    this.mCircleView.setAnimationListener(paramAnimationListener);
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mScaleDownAnimation);
  }
  
  public void stopNestedScroll()
  {
    this.mNestedScrollingChildHelper.stopNestedScroll();
  }
  
  public static abstract interface OnChildScrollUpCallback
  {
    public abstract boolean canChildScrollUp(@NonNull SwipeRefreshLayout paramSwipeRefreshLayout, @Nullable View paramView);
  }
  
  public static abstract interface OnRefreshListener
  {
    public abstract void onRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */