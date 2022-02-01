package com.tencent.qqmail.card.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector.OnGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.common.base.Preconditions;

public class CardTransitionView
  extends FrameLayout
  implements Recyclable
{
  private static final int ANIMATION_DURATION = 300;
  private static final float CARD_SCALE_FACTOR = 1.02F;
  private static final float DAMPING_FACTOR = 0.5F;
  private static final String TAG = "DiscoverTransitionView";
  private static final int TRIGGER_REMOVE_VELOCITY = -300;
  private int mCardHeight;
  private int mCardWidth;
  private GestureDetector.OnGestureListener mGestureListener = new CardTransitionView.1(this);
  private float mPreY = 1.4E-45F;
  private int mRemoveThreshold;
  private long mSelectedItemId;
  private View mSelectedView;
  private int mShiftedY = 0;
  private boolean mShouldRemove;
  private int mTopOffset;
  private View.OnTouchListener mTouchListener = new CardTransitionView.2(this);
  private boolean mTouchable = true;
  private TransitionListener mTransitionListener;
  
  public CardTransitionView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CardTransitionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnTouchListener(this.mTouchListener);
  }
  
  private void onRemove()
  {
    int k = getChildCount();
    if (this.mSelectedView == getChildAt(k - 1)) {}
    for (int i = 1; k == 1; i = 0)
    {
      if (this.mTransitionListener != null)
      {
        this.mTransitionListener.onTransitionComplete(true);
        this.mTransitionListener.onViewRemoved(this.mSelectedItemId);
      }
      return;
    }
    if (i != 0)
    {
      slideAnim(getChildAt(k - 2), true, 300, 1.02F);
      return;
    }
    i = 0;
    int j = 0;
    label88:
    View localView;
    if (j < k)
    {
      localView = getChildAt(j);
      if (localView != this.mSelectedView) {
        break label118;
      }
      i = 1;
    }
    for (;;)
    {
      j += 1;
      break label88;
      break;
      label118:
      if (i == 0)
      {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.02F, 1.0F, 1.02F, 1, 0.5F, 1, 0.5F);
        localScaleAnimation.setDuration(300);
        localScaleAnimation.setFillAfter(true);
        localView.startAnimation(localScaleAnimation);
      }
      else
      {
        slideAnim(localView, false, 300, 1.02F);
      }
    }
  }
  
  private void onTouchUp(float paramFloat, int paramInt)
  {
    if (paramFloat == 1.4E-45F)
    {
      restore(0);
      return;
    }
    if ((-paramInt >= this.mRemoveThreshold) && (this.mShouldRemove))
    {
      removeCard();
      return;
    }
    restore(paramInt);
  }
  
  private void removeCard()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.mCardHeight);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setAnimationListener(new CardTransitionView.5(this));
    this.mSelectedView.startAnimation(localTranslateAnimation);
  }
  
  private void restore(int paramInt)
  {
    int k = getChildCount();
    if (paramInt == 0) {}
    View localView;
    for (int i = 150;; i = 300)
    {
      int j = 0;
      for (;;)
      {
        if (j >= k) {
          return;
        }
        localView = getChildAt(j);
        if (localView == this.mSelectedView) {
          break;
        }
        localObject = new ScaleAnimation(1.0F, 1.02F, 1.0F, 1.02F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject).setDuration(i);
        ((Animation)localObject).setFillAfter(true);
        localView.startAnimation((Animation)localObject);
        j += 1;
      }
    }
    Object localObject = new AnimationSet(true);
    ((AnimationSet)localObject).setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.9803922F, 1.0F, 0.9803922F, 1, 0.5F, 1, 0.5F);
    if (paramInt != 0)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramInt);
      localTranslateAnimation.setDuration(i * 2 / 3);
      ((AnimationSet)localObject).addAnimation(localTranslateAnimation);
      localScaleAnimation.setDuration(i / 3);
    }
    for (;;)
    {
      ((AnimationSet)localObject).addAnimation(localScaleAnimation);
      ((AnimationSet)localObject).setAnimationListener(new CardTransitionView.6(this));
      localView.startAnimation((Animation)localObject);
      break;
      localScaleAnimation.setDuration(i);
    }
  }
  
  private void slideAnim(View paramView, boolean paramBoolean, int paramInt, float paramFloat)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setFillAfter(true);
    if (paramBoolean) {}
    for (TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.mCardWidth, 0.0F, 0.0F);; localTranslateAnimation = new TranslateAnimation(0.0F, -this.mCardWidth, 0.0F, 0.0F))
    {
      localTranslateAnimation.setDuration(paramInt * 2 / 3);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, paramFloat, 1.0F, paramFloat, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(paramInt / 3);
      localAnimationSet.addAnimation(localTranslateAnimation);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.setAnimationListener(new CardTransitionView.7(this));
      paramView.startAnimation(localAnimationSet);
      return;
    }
  }
  
  private void zoomOnInit()
  {
    Log.d("DiscoverTransitionView", "zoomOnInit");
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      int k = (int)(localView.getX() + localView.getWidth() / 2);
      int m = (int)(localView.getY() + localView.getHeight() / 2);
      if (localView == this.mSelectedView) {}
      for (float f = 1.02F;; f = 0.9803922F)
      {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, f, 1.0F, f, 1, 0.5F, 1, 0.5F);
        localScaleAnimation.setDuration('');
        localScaleAnimation.setAnimationListener(new CardTransitionView.4(this, localView, f, k, m));
        localView.startAnimation(localScaleAnimation);
        i += 1;
        break;
      }
    }
  }
  
  public View.OnTouchListener getTouchListener()
  {
    return this.mTouchListener;
  }
  
  public void initTransition(ViewGroup paramViewGroup, View paramView, long paramLong, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramViewGroup);
    boolean bool;
    int i;
    label40:
    Object localObject;
    int k;
    int m;
    int n;
    int i1;
    if (paramViewGroup.getChildCount() > 0)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      this.mSelectedItemId = paramLong;
      this.mShouldRemove = paramBoolean;
      int j = paramViewGroup.getChildCount();
      i = 0;
      if (i >= j) {
        break label222;
      }
      localObject = paramViewGroup.getChildAt(i);
      k = ((View)localObject).getLeft();
      m = ((View)localObject).getRight();
      n = ((View)localObject).getTop();
      i1 = ((View)localObject).getBottom();
      if (localObject != paramView) {
        break label216;
      }
    }
    label216:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject = FakeView.instance(getContext(), (View)localObject, paramBoolean);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(m - k, i1 - n);
      localLayoutParams.leftMargin = k;
      localLayoutParams.topMargin = (this.mTopOffset + n);
      addView((View)localObject, localLayoutParams);
      if (paramBoolean)
      {
        this.mSelectedView = ((View)localObject);
        this.mCardWidth = (m - k - getResources().getDimensionPixelSize(2131296809));
        this.mCardHeight = (i1 - n);
        this.mRemoveThreshold = (this.mCardWidth / 3);
      }
      i += 1;
      break label40;
      bool = false;
      break;
    }
    label222:
    this.mTouchable = false;
    post(new CardTransitionView.3(this));
  }
  
  public void recycle()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof FakeView)) {
        ((FakeView)localView).recycle();
      }
      i += 1;
    }
  }
  
  public void restore()
  {
    restore(this.mShiftedY);
  }
  
  public void setTopOffset(int paramInt)
  {
    this.mTopOffset = paramInt;
  }
  
  public void setTransitionListener(TransitionListener paramTransitionListener)
  {
    this.mTransitionListener = paramTransitionListener;
  }
  
  static class FakeView
    extends View
    implements Recyclable
  {
    private View mOriView;
    
    protected FakeView(Context paramContext, View paramView)
    {
      super();
      this.mOriView = paramView;
    }
    
    public static FakeView instance(Context paramContext, View paramView, boolean paramBoolean)
    {
      return new FakeView(paramContext, paramView);
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      float f1 = getWidth();
      float f2 = getHeight();
      float f3 = this.mOriView.getWidth();
      float f4 = this.mOriView.getHeight();
      if ((f1 == 0.0F) || (f2 == 0.0F) || (f3 == 0.0F) || (f4 == 0.0F)) {
        return;
      }
      int i = paramCanvas.save();
      paramCanvas.scale(f1 / f3, f2 / f4);
      this.mOriView.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
    
    public void recycle() {}
  }
  
  public static abstract interface TransitionListener
  {
    public abstract void onScroll(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void onTransitionComplete(boolean paramBoolean);
    
    public abstract void onViewRemoved(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardTransitionView
 * JD-Core Version:    0.7.0.1
 */