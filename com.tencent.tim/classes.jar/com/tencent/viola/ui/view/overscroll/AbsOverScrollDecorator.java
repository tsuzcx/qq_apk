package com.tencent.viola.ui.view.overscroll;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public abstract class AbsOverScrollDecorator
  implements View.OnTouchListener
{
  public static final float DEFAULT_DECELERATE_FACTOR = -2.0F;
  public static final float DEFAULT_TOUCH_DRAG_MOVE_RATIO_BCK = 1.0F;
  public static final float DEFAULT_TOUCH_DRAG_MOVE_RATIO_FWD = 3.0F;
  protected static final int MAX_BOUNCE_BACK_DURATION_MS = 800;
  protected static final int MIN_BOUNCE_BACK_DURATION_MS = 200;
  public static final int STATE_DRAG_END_SIDE = 2;
  public static final int STATE_DRAG_START_SIDE = 1;
  public static final int STATE_IDLE = 0;
  protected final BounceBackState mBounceBackState;
  protected IDecoratorState mCurrentState;
  protected final IdleState mIdleState;
  protected final OverScrollingState mOverScrollingState;
  protected final OverScrollStartAttributes mStartAttr = new OverScrollStartAttributes();
  protected float mVelocity;
  protected final IOverScrollDecoratorAdapter mViewAdapter;
  
  public AbsOverScrollDecorator(IOverScrollDecoratorAdapter paramIOverScrollDecoratorAdapter, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mViewAdapter = paramIOverScrollDecoratorAdapter;
    this.mBounceBackState = new BounceBackState(paramFloat1);
    this.mOverScrollingState = new OverScrollingState(paramFloat2, paramFloat3);
    this.mIdleState = new IdleState();
    this.mCurrentState = this.mIdleState;
    attach();
  }
  
  protected void attach()
  {
    getView().setOnTouchListener(this);
    getView().setOverScrollMode(2);
  }
  
  protected abstract AnimationAttributes createAnimationAttributes();
  
  protected abstract MotionAttributes createMotionAttributes();
  
  public View getView()
  {
    return this.mViewAdapter.getView();
  }
  
  protected void issueStateTransition(IDecoratorState paramIDecoratorState)
  {
    IDecoratorState localIDecoratorState = this.mCurrentState;
    this.mCurrentState = paramIDecoratorState;
    this.mCurrentState.handleEntryTransition(localIDecoratorState);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 2: 
      return this.mCurrentState.handleMoveTouchEvent(paramMotionEvent);
    }
    return this.mCurrentState.handleUpOrCancelTouchEvent(paramMotionEvent);
  }
  
  protected abstract void translateView(View paramView, float paramFloat);
  
  protected abstract void translateViewAndEvent(View paramView, float paramFloat, MotionEvent paramMotionEvent);
  
  public static abstract class AnimationAttributes
  {
    public float mAbsOffset;
    public float mMaxOffset;
    public Property<View, Float> mProperty;
    
    protected abstract void init(View paramView);
    
    protected abstract void onAnimationEnd();
    
    protected abstract void onUpdate(ValueAnimator paramValueAnimator);
  }
  
  public class BounceBackState
    implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, AbsOverScrollDecorator.IDecoratorState
  {
    protected final AbsOverScrollDecorator.AnimationAttributes mAnimAttributes;
    protected final Interpolator mBounceBackInterpolator = new DecelerateInterpolator();
    protected final float mDecelerateFactor;
    protected final float mDoubleDecelerateFactor;
    
    public BounceBackState(float paramFloat)
    {
      this.mDecelerateFactor = paramFloat;
      this.mDoubleDecelerateFactor = (2.0F * paramFloat);
      this.mAnimAttributes = AbsOverScrollDecorator.this.createAnimationAttributes();
    }
    
    protected Animator createAnimator()
    {
      float f1 = 0.0F;
      Object localObject = AbsOverScrollDecorator.this.mViewAdapter.getView();
      this.mAnimAttributes.init((View)localObject);
      if ((AbsOverScrollDecorator.this.mVelocity == 0.0F) || ((AbsOverScrollDecorator.this.mVelocity < 0.0F) && (AbsOverScrollDecorator.this.mStartAttr.mDir)) || ((AbsOverScrollDecorator.this.mVelocity > 0.0F) && (!AbsOverScrollDecorator.this.mStartAttr.mDir))) {
        return createBounceBackAnimator(this.mAnimAttributes.mAbsOffset);
      }
      float f2 = -AbsOverScrollDecorator.this.mVelocity / this.mDecelerateFactor;
      if (f2 < 0.0F) {}
      for (;;)
      {
        f2 = -AbsOverScrollDecorator.this.mVelocity * AbsOverScrollDecorator.this.mVelocity / this.mDoubleDecelerateFactor + this.mAnimAttributes.mAbsOffset;
        localObject = createSlowdownAnimator((View)localObject, (int)f1, f2);
        ObjectAnimator localObjectAnimator = createBounceBackAnimator(f2);
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playSequentially(new Animator[] { localObject, localObjectAnimator });
        return localAnimatorSet;
        f1 = f2;
      }
    }
    
    protected ObjectAnimator createBounceBackAnimator(float paramFloat)
    {
      Object localObject = AbsOverScrollDecorator.this.mViewAdapter.getView();
      paramFloat = Math.abs(paramFloat) / this.mAnimAttributes.mMaxOffset;
      localObject = ObjectAnimator.ofFloat(localObject, this.mAnimAttributes.mProperty, new float[] { AbsOverScrollDecorator.this.mStartAttr.mAbsOffset });
      ((ObjectAnimator)localObject).setDuration(Math.max((int)(paramFloat * 800.0F), 200));
      ((ObjectAnimator)localObject).setInterpolator(this.mBounceBackInterpolator);
      ((ObjectAnimator)localObject).addUpdateListener(this);
      return localObject;
    }
    
    protected ObjectAnimator createSlowdownAnimator(View paramView, int paramInt, float paramFloat)
    {
      paramView = ObjectAnimator.ofFloat(paramView, this.mAnimAttributes.mProperty, new float[] { paramFloat });
      paramView.setDuration(paramInt);
      paramView.setInterpolator(this.mBounceBackInterpolator);
      paramView.addUpdateListener(this);
      return paramView;
    }
    
    public void handleEntryTransition(AbsOverScrollDecorator.IDecoratorState paramIDecoratorState)
    {
      paramIDecoratorState = createAnimator();
      paramIDecoratorState.addListener(this);
      paramIDecoratorState.start();
    }
    
    public boolean handleMoveTouchEvent(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean handleUpOrCancelTouchEvent(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      AbsOverScrollDecorator.this.issueStateTransition(AbsOverScrollDecorator.this.mIdleState);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      this.mAnimAttributes.onUpdate(paramValueAnimator);
    }
  }
  
  public static abstract interface IDecoratorState
  {
    public abstract void handleEntryTransition(IDecoratorState paramIDecoratorState);
    
    public abstract boolean handleMoveTouchEvent(MotionEvent paramMotionEvent);
    
    public abstract boolean handleUpOrCancelTouchEvent(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface IOverScrollDecoratorAdapter
  {
    public abstract View getView();
    
    public abstract boolean isInAbsoluteEnd();
    
    public abstract boolean isInAbsoluteStart();
  }
  
  public class IdleState
    implements AbsOverScrollDecorator.IDecoratorState
  {
    final AbsOverScrollDecorator.MotionAttributes mMoveAttr = AbsOverScrollDecorator.this.createMotionAttributes();
    
    public IdleState() {}
    
    public void handleEntryTransition(AbsOverScrollDecorator.IDecoratorState paramIDecoratorState) {}
    
    public boolean handleMoveTouchEvent(MotionEvent paramMotionEvent)
    {
      View localView = AbsOverScrollDecorator.this.mViewAdapter.getView();
      if (!this.mMoveAttr.init(localView, paramMotionEvent)) {}
      while (((!AbsOverScrollDecorator.this.mViewAdapter.isInAbsoluteStart()) || (!this.mMoveAttr.mDir)) && ((!AbsOverScrollDecorator.this.mViewAdapter.isInAbsoluteEnd()) || (this.mMoveAttr.mDir))) {
        return false;
      }
      AbsOverScrollDecorator.this.mStartAttr.mPointerId = paramMotionEvent.getPointerId(0);
      AbsOverScrollDecorator.this.mStartAttr.mAbsOffset = this.mMoveAttr.mAbsOffset;
      AbsOverScrollDecorator.this.mStartAttr.mDir = this.mMoveAttr.mDir;
      AbsOverScrollDecorator.this.issueStateTransition(AbsOverScrollDecorator.this.mOverScrollingState);
      return AbsOverScrollDecorator.this.mOverScrollingState.handleMoveTouchEvent(paramMotionEvent);
    }
    
    public boolean handleUpOrCancelTouchEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  public static abstract class MotionAttributes
  {
    public float mAbsOffset;
    public float mDeltaOffset;
    public boolean mDir;
    
    protected abstract boolean init(View paramView, MotionEvent paramMotionEvent);
  }
  
  public static class OverScrollStartAttributes
  {
    protected float mAbsOffset;
    protected boolean mDir;
    protected int mPointerId;
  }
  
  public class OverScrollingState
    implements AbsOverScrollDecorator.IDecoratorState
  {
    int mCurrDragState;
    final AbsOverScrollDecorator.MotionAttributes mMoveAttr = AbsOverScrollDecorator.this.createMotionAttributes();
    protected final float mTouchDragRatioBck;
    protected final float mTouchDragRatioFwd;
    
    public OverScrollingState(float paramFloat1, float paramFloat2)
    {
      this.mTouchDragRatioFwd = paramFloat1;
      this.mTouchDragRatioBck = paramFloat2;
    }
    
    public void handleEntryTransition(AbsOverScrollDecorator.IDecoratorState paramIDecoratorState)
    {
      if (AbsOverScrollDecorator.this.mStartAttr.mDir) {}
      for (int i = 1;; i = 2)
      {
        this.mCurrDragState = i;
        return;
      }
    }
    
    public boolean handleMoveTouchEvent(MotionEvent paramMotionEvent)
    {
      if (AbsOverScrollDecorator.this.mStartAttr.mPointerId != paramMotionEvent.getPointerId(0)) {
        AbsOverScrollDecorator.this.issueStateTransition(AbsOverScrollDecorator.this.mBounceBackState);
      }
      View localView;
      do
      {
        return true;
        localView = AbsOverScrollDecorator.this.mViewAdapter.getView();
      } while (!this.mMoveAttr.init(localView, paramMotionEvent));
      float f2 = this.mMoveAttr.mDeltaOffset;
      if (this.mMoveAttr.mDir == AbsOverScrollDecorator.this.mStartAttr.mDir) {}
      for (float f1 = this.mTouchDragRatioFwd;; f1 = this.mTouchDragRatioBck)
      {
        f1 = f2 / f1;
        f2 = this.mMoveAttr.mAbsOffset + this.mMoveAttr.mDeltaOffset;
        if (((!AbsOverScrollDecorator.this.mStartAttr.mDir) || (this.mMoveAttr.mDir) || (f2 > AbsOverScrollDecorator.this.mStartAttr.mAbsOffset)) && ((AbsOverScrollDecorator.this.mStartAttr.mDir) || (!this.mMoveAttr.mDir) || (f2 < AbsOverScrollDecorator.this.mStartAttr.mAbsOffset))) {
          break;
        }
        AbsOverScrollDecorator.this.translateViewAndEvent(localView, AbsOverScrollDecorator.this.mStartAttr.mAbsOffset, paramMotionEvent);
        AbsOverScrollDecorator.this.issueStateTransition(AbsOverScrollDecorator.this.mIdleState);
        return true;
      }
      if (localView.getParent() != null) {
        localView.getParent().requestDisallowInterceptTouchEvent(true);
      }
      long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
      if (l > 0L) {
        AbsOverScrollDecorator.this.mVelocity = (f1 / (float)l);
      }
      AbsOverScrollDecorator.this.translateView(localView, f2);
      return true;
    }
    
    public boolean handleUpOrCancelTouchEvent(MotionEvent paramMotionEvent)
    {
      AbsOverScrollDecorator.this.issueStateTransition(AbsOverScrollDecorator.this.mBounceBackState);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.AbsOverScrollDecorator
 * JD-Core Version:    0.7.0.1
 */