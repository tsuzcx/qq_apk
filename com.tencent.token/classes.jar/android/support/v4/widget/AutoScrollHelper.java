package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

public abstract class AutoScrollHelper
  implements View.OnTouchListener
{
  private static final int DEFAULT_ACTIVATION_DELAY = ;
  private static final int DEFAULT_EDGE_TYPE = 1;
  private static final float DEFAULT_MAXIMUM_EDGE = 3.4028235E+38F;
  private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
  private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
  private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
  private static final int DEFAULT_RAMP_UP_DURATION = 500;
  private static final float DEFAULT_RELATIVE_EDGE = 0.2F;
  private static final float DEFAULT_RELATIVE_VELOCITY = 1.0F;
  public static final int EDGE_TYPE_INSIDE = 0;
  public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
  public static final int EDGE_TYPE_OUTSIDE = 2;
  private static final int HORIZONTAL = 0;
  public static final float NO_MAX = 3.4028235E+38F;
  public static final float NO_MIN = 0.0F;
  public static final float RELATIVE_UNSPECIFIED = 0.0F;
  private static final int VERTICAL = 1;
  private int mActivationDelay;
  private boolean mAlreadyDelayed;
  boolean mAnimating;
  private final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
  private int mEdgeType;
  private boolean mEnabled;
  private boolean mExclusive;
  private float[] mMaximumEdges = { 3.4028235E+38F, 3.4028235E+38F };
  private float[] mMaximumVelocity = { 3.4028235E+38F, 3.4028235E+38F };
  private float[] mMinimumVelocity = { 0.0F, 0.0F };
  boolean mNeedsCancel;
  boolean mNeedsReset;
  private float[] mRelativeEdges = { 0.0F, 0.0F };
  private float[] mRelativeVelocity = { 0.0F, 0.0F };
  private Runnable mRunnable;
  final AutoScrollHelper.ClampedScroller mScroller = new AutoScrollHelper.ClampedScroller();
  final View mTarget;
  
  public AutoScrollHelper(@NonNull View paramView)
  {
    this.mTarget = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i = (int)(1575.0F * paramView.density + 0.5F);
    int j = (int)(paramView.density * 315.0F + 0.5F);
    setMaximumVelocity(i, i);
    setMinimumVelocity(j, j);
    setEdgeType(1);
    setMaximumEdges(3.4028235E+38F, 3.4028235E+38F);
    setRelativeEdges(0.2F, 0.2F);
    setRelativeVelocity(1.0F, 1.0F);
    setActivationDelay(DEFAULT_ACTIVATION_DELAY);
    setRampUpDuration(500);
    setRampDownDuration(500);
  }
  
  private float computeTargetVelocity(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = getEdgeValue(this.mRelativeEdges[paramInt], paramFloat2, this.mMaximumEdges[paramInt], paramFloat1);
    if (paramFloat1 == 0.0F) {
      return 0.0F;
    }
    float f2 = this.mRelativeVelocity[paramInt];
    paramFloat2 = this.mMinimumVelocity[paramInt];
    float f1 = this.mMaximumVelocity[paramInt];
    paramFloat3 = f2 * paramFloat3;
    if (paramFloat1 > 0.0F) {
      return constrain(paramFloat1 * paramFloat3, paramFloat2, f1);
    }
    return -constrain(-paramFloat1 * paramFloat3, paramFloat2, f1);
  }
  
  static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  static int constrain(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private float constrainEdgeValue(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 0.0F) {}
    do
    {
      do
      {
        do
        {
          return 0.0F;
          switch (this.mEdgeType)
          {
          default: 
            return 0.0F;
          }
        } while (paramFloat1 >= paramFloat2);
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
      } while ((!this.mAnimating) || (this.mEdgeType != 1));
      return 1.0F;
    } while (paramFloat1 >= 0.0F);
    return paramFloat1 / -paramFloat2;
  }
  
  private float getEdgeValue(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = 0.0F;
    paramFloat1 = constrain(paramFloat1 * paramFloat2, 0.0F, paramFloat3);
    paramFloat3 = constrainEdgeValue(paramFloat4, paramFloat1);
    paramFloat2 = constrainEdgeValue(paramFloat2 - paramFloat4, paramFloat1) - paramFloat3;
    if (paramFloat2 < 0.0F) {}
    for (paramFloat1 = -this.mEdgeInterpolator.getInterpolation(-paramFloat2);; paramFloat1 = this.mEdgeInterpolator.getInterpolation(paramFloat2))
    {
      paramFloat1 = constrain(paramFloat1, -1.0F, 1.0F);
      do
      {
        return paramFloat1;
        paramFloat1 = f;
      } while (paramFloat2 <= 0.0F);
    }
  }
  
  private void requestStop()
  {
    if (this.mNeedsReset)
    {
      this.mAnimating = false;
      return;
    }
    this.mScroller.requestStop();
  }
  
  private void startAnimating()
  {
    if (this.mRunnable == null) {
      this.mRunnable = new AutoScrollHelper.ScrollAnimationRunnable(this);
    }
    this.mAnimating = true;
    this.mNeedsReset = true;
    if ((!this.mAlreadyDelayed) && (this.mActivationDelay > 0)) {
      ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, this.mActivationDelay);
    }
    for (;;)
    {
      this.mAlreadyDelayed = true;
      return;
      this.mRunnable.run();
    }
  }
  
  public abstract boolean canTargetScrollHorizontally(int paramInt);
  
  public abstract boolean canTargetScrollVertically(int paramInt);
  
  void cancelTargetTouch()
  {
    long l = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    this.mTarget.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public boolean isEnabled()
  {
    return this.mEnabled;
  }
  
  public boolean isExclusive()
  {
    return this.mExclusive;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!this.mEnabled) {
      return false;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      if ((!this.mExclusive) || (!this.mAnimating)) {
        break;
      }
    }
    for (;;)
    {
      return bool;
      this.mNeedsCancel = true;
      this.mAlreadyDelayed = false;
      float f1 = computeTargetVelocity(0, paramMotionEvent.getX(), paramView.getWidth(), this.mTarget.getWidth());
      float f2 = computeTargetVelocity(1, paramMotionEvent.getY(), paramView.getHeight(), this.mTarget.getHeight());
      this.mScroller.setTargetVelocity(f1, f2);
      if ((this.mAnimating) || (!shouldAnimate())) {
        break;
      }
      startAnimating();
      break;
      requestStop();
      break;
      bool = false;
    }
  }
  
  public abstract void scrollTargetBy(int paramInt1, int paramInt2);
  
  @NonNull
  public AutoScrollHelper setActivationDelay(int paramInt)
  {
    this.mActivationDelay = paramInt;
    return this;
  }
  
  @NonNull
  public AutoScrollHelper setEdgeType(int paramInt)
  {
    this.mEdgeType = paramInt;
    return this;
  }
  
  public AutoScrollHelper setEnabled(boolean paramBoolean)
  {
    if ((this.mEnabled) && (!paramBoolean)) {
      requestStop();
    }
    this.mEnabled = paramBoolean;
    return this;
  }
  
  public AutoScrollHelper setExclusive(boolean paramBoolean)
  {
    this.mExclusive = paramBoolean;
    return this;
  }
  
  @NonNull
  public AutoScrollHelper setMaximumEdges(float paramFloat1, float paramFloat2)
  {
    this.mMaximumEdges[0] = paramFloat1;
    this.mMaximumEdges[1] = paramFloat2;
    return this;
  }
  
  @NonNull
  public AutoScrollHelper setMaximumVelocity(float paramFloat1, float paramFloat2)
  {
    this.mMaximumVelocity[0] = (paramFloat1 / 1000.0F);
    this.mMaximumVelocity[1] = (paramFloat2 / 1000.0F);
    return this;
  }
  
  @NonNull
  public AutoScrollHelper setMinimumVelocity(float paramFloat1, float paramFloat2)
  {
    this.mMinimumVelocity[0] = (paramFloat1 / 1000.0F);
    this.mMinimumVelocity[1] = (paramFloat2 / 1000.0F);
    return this;
  }
  
  @NonNull
  public AutoScrollHelper setRampDownDuration(int paramInt)
  {
    this.mScroller.setRampDownDuration(paramInt);
    return this;
  }
  
  @NonNull
  public AutoScrollHelper setRampUpDuration(int paramInt)
  {
    this.mScroller.setRampUpDuration(paramInt);
    return this;
  }
  
  @NonNull
  public AutoScrollHelper setRelativeEdges(float paramFloat1, float paramFloat2)
  {
    this.mRelativeEdges[0] = paramFloat1;
    this.mRelativeEdges[1] = paramFloat2;
    return this;
  }
  
  @NonNull
  public AutoScrollHelper setRelativeVelocity(float paramFloat1, float paramFloat2)
  {
    this.mRelativeVelocity[0] = (paramFloat1 / 1000.0F);
    this.mRelativeVelocity[1] = (paramFloat2 / 1000.0F);
    return this;
  }
  
  boolean shouldAnimate()
  {
    AutoScrollHelper.ClampedScroller localClampedScroller = this.mScroller;
    int i = localClampedScroller.getVerticalDirection();
    int j = localClampedScroller.getHorizontalDirection();
    return ((i != 0) && (canTargetScrollVertically(i))) || ((j != 0) && (canTargetScrollHorizontally(j)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.AutoScrollHelper
 * JD-Core Version:    0.7.0.1
 */