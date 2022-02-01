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
import android.view.animation.AnimationUtils;
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
  final ClampedScroller mScroller = new ClampedScroller();
  final View mTarget;
  
  public AutoScrollHelper(@NonNull View paramView)
  {
    this.mTarget = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i = (int)(paramView.density * 1575.0F + 0.5F);
    int j = (int)(paramView.density * 315.0F + 0.5F);
    float f = i;
    setMaximumVelocity(f, f);
    f = j;
    setMinimumVelocity(f, f);
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
    if (paramFloat2 == 0.0F) {
      return 0.0F;
    }
    int i = this.mEdgeType;
    switch (i)
    {
    default: 
      return 0.0F;
    case 2: 
      if (paramFloat1 < 0.0F) {
        return paramFloat1 / -paramFloat2;
      }
      break;
    case 0: 
    case 1: 
      if (paramFloat1 < paramFloat2)
      {
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
        if ((this.mAnimating) && (i == 1)) {
          return 1.0F;
        }
      }
      break;
    }
    return 0.0F;
  }
  
  private float getEdgeValue(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = constrain(paramFloat1 * paramFloat2, 0.0F, paramFloat3);
    paramFloat3 = constrainEdgeValue(paramFloat4, paramFloat1);
    paramFloat1 = constrainEdgeValue(paramFloat2 - paramFloat4, paramFloat1) - paramFloat3;
    if (paramFloat1 < 0.0F)
    {
      paramFloat1 = -this.mEdgeInterpolator.getInterpolation(-paramFloat1);
    }
    else
    {
      if (paramFloat1 <= 0.0F) {
        break label76;
      }
      paramFloat1 = this.mEdgeInterpolator.getInterpolation(paramFloat1);
    }
    return constrain(paramFloat1, -1.0F, 1.0F);
    label76:
    return 0.0F;
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
      this.mRunnable = new ScrollAnimationRunnable();
    }
    this.mAnimating = true;
    this.mNeedsReset = true;
    if (!this.mAlreadyDelayed)
    {
      int i = this.mActivationDelay;
      if (i > 0)
      {
        ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, i);
        break label70;
      }
    }
    this.mRunnable.run();
    label70:
    this.mAlreadyDelayed = true;
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
    boolean bool1 = this.mEnabled;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      break;
    case 1: 
    case 3: 
      requestStop();
      break;
    case 0: 
      this.mNeedsCancel = true;
      this.mAlreadyDelayed = false;
    case 2: 
      float f1 = computeTargetVelocity(0, paramMotionEvent.getX(), paramView.getWidth(), this.mTarget.getWidth());
      float f2 = computeTargetVelocity(1, paramMotionEvent.getY(), paramView.getHeight(), this.mTarget.getHeight());
      this.mScroller.setTargetVelocity(f1, f2);
      if ((!this.mAnimating) && (shouldAnimate())) {
        startAnimating();
      }
      break;
    }
    bool1 = bool2;
    if (this.mExclusive)
    {
      bool1 = bool2;
      if (this.mAnimating) {
        bool1 = true;
      }
    }
    return bool1;
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
    float[] arrayOfFloat = this.mMaximumEdges;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    return this;
  }
  
  @NonNull
  public AutoScrollHelper setMaximumVelocity(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.mMaximumVelocity;
    arrayOfFloat[0] = (paramFloat1 / 1000.0F);
    arrayOfFloat[1] = (paramFloat2 / 1000.0F);
    return this;
  }
  
  @NonNull
  public AutoScrollHelper setMinimumVelocity(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.mMinimumVelocity;
    arrayOfFloat[0] = (paramFloat1 / 1000.0F);
    arrayOfFloat[1] = (paramFloat2 / 1000.0F);
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
    float[] arrayOfFloat = this.mRelativeEdges;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    return this;
  }
  
  @NonNull
  public AutoScrollHelper setRelativeVelocity(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.mRelativeVelocity;
    arrayOfFloat[0] = (paramFloat1 / 1000.0F);
    arrayOfFloat[1] = (paramFloat2 / 1000.0F);
    return this;
  }
  
  boolean shouldAnimate()
  {
    ClampedScroller localClampedScroller = this.mScroller;
    int i = localClampedScroller.getVerticalDirection();
    int j = localClampedScroller.getHorizontalDirection();
    return ((i != 0) && (canTargetScrollVertically(i))) || ((j != 0) && (canTargetScrollHorizontally(j)));
  }
  
  private static class ClampedScroller
  {
    private long mDeltaTime = 0L;
    private int mDeltaX = 0;
    private int mDeltaY = 0;
    private int mEffectiveRampDown;
    private int mRampDownDuration;
    private int mRampUpDuration;
    private long mStartTime = -9223372036854775808L;
    private long mStopTime = -1L;
    private float mStopValue;
    private float mTargetVelocityX;
    private float mTargetVelocityY;
    
    private float getValueAt(long paramLong)
    {
      if (paramLong < this.mStartTime) {
        return 0.0F;
      }
      long l = this.mStopTime;
      if ((l >= 0L) && (paramLong >= l))
      {
        float f = this.mStopValue;
        return 1.0F - f + f * AutoScrollHelper.constrain((float)(paramLong - l) / this.mEffectiveRampDown, 0.0F, 1.0F);
      }
      return AutoScrollHelper.constrain((float)(paramLong - this.mStartTime) / this.mRampUpDuration, 0.0F, 1.0F) * 0.5F;
    }
    
    private float interpolateValue(float paramFloat)
    {
      return -4.0F * paramFloat * paramFloat + paramFloat * 4.0F;
    }
    
    public void computeScrollDelta()
    {
      if (this.mDeltaTime != 0L)
      {
        long l1 = AnimationUtils.currentAnimationTimeMillis();
        float f = interpolateValue(getValueAt(l1));
        long l2 = this.mDeltaTime;
        this.mDeltaTime = l1;
        f = (float)(l1 - l2) * f;
        this.mDeltaX = ((int)(this.mTargetVelocityX * f));
        this.mDeltaY = ((int)(f * this.mTargetVelocityY));
        return;
      }
      throw new RuntimeException("Cannot compute scroll delta before calling start()");
    }
    
    public int getDeltaX()
    {
      return this.mDeltaX;
    }
    
    public int getDeltaY()
    {
      return this.mDeltaY;
    }
    
    public int getHorizontalDirection()
    {
      float f = this.mTargetVelocityX;
      return (int)(f / Math.abs(f));
    }
    
    public int getVerticalDirection()
    {
      float f = this.mTargetVelocityY;
      return (int)(f / Math.abs(f));
    }
    
    public boolean isFinished()
    {
      return (this.mStopTime > 0L) && (AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + this.mEffectiveRampDown);
    }
    
    public void requestStop()
    {
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.mEffectiveRampDown = AutoScrollHelper.constrain((int)(l - this.mStartTime), 0, this.mRampDownDuration);
      this.mStopValue = getValueAt(l);
      this.mStopTime = l;
    }
    
    public void setRampDownDuration(int paramInt)
    {
      this.mRampDownDuration = paramInt;
    }
    
    public void setRampUpDuration(int paramInt)
    {
      this.mRampUpDuration = paramInt;
    }
    
    public void setTargetVelocity(float paramFloat1, float paramFloat2)
    {
      this.mTargetVelocityX = paramFloat1;
      this.mTargetVelocityY = paramFloat2;
    }
    
    public void start()
    {
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mStopTime = -1L;
      this.mDeltaTime = this.mStartTime;
      this.mStopValue = 0.5F;
      this.mDeltaX = 0;
      this.mDeltaY = 0;
    }
  }
  
  private class ScrollAnimationRunnable
    implements Runnable
  {
    ScrollAnimationRunnable() {}
    
    public void run()
    {
      if (!AutoScrollHelper.this.mAnimating) {
        return;
      }
      if (AutoScrollHelper.this.mNeedsReset)
      {
        localObject = AutoScrollHelper.this;
        ((AutoScrollHelper)localObject).mNeedsReset = false;
        ((AutoScrollHelper)localObject).mScroller.start();
      }
      Object localObject = AutoScrollHelper.this.mScroller;
      if ((!((AutoScrollHelper.ClampedScroller)localObject).isFinished()) && (AutoScrollHelper.this.shouldAnimate()))
      {
        if (AutoScrollHelper.this.mNeedsCancel)
        {
          AutoScrollHelper localAutoScrollHelper = AutoScrollHelper.this;
          localAutoScrollHelper.mNeedsCancel = false;
          localAutoScrollHelper.cancelTargetTouch();
        }
        ((AutoScrollHelper.ClampedScroller)localObject).computeScrollDelta();
        int i = ((AutoScrollHelper.ClampedScroller)localObject).getDeltaX();
        int j = ((AutoScrollHelper.ClampedScroller)localObject).getDeltaY();
        AutoScrollHelper.this.scrollTargetBy(i, j);
        ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, this);
        return;
      }
      AutoScrollHelper.this.mAnimating = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.AutoScrollHelper
 * JD-Core Version:    0.7.0.1
 */