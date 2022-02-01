package com.tencent.viola.ui.view.overscroll;

import android.animation.ValueAnimator;
import android.support.annotation.RequiresApi;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;

public class HorizontalOverScrollBounceEffectDecorator
  extends AbsOverScrollDecorator
{
  private OverScrollHelper.OverScrollListener overScrollListener;
  
  public HorizontalOverScrollBounceEffectDecorator(AbsOverScrollDecorator.IOverScrollDecoratorAdapter paramIOverScrollDecoratorAdapter, float paramFloat1, float paramFloat2, float paramFloat3, OverScrollHelper.OverScrollListener paramOverScrollListener)
  {
    super(paramIOverScrollDecoratorAdapter, paramFloat1, paramFloat2, paramFloat3);
    this.overScrollListener = paramOverScrollListener;
  }
  
  public HorizontalOverScrollBounceEffectDecorator(AbsOverScrollDecorator.IOverScrollDecoratorAdapter paramIOverScrollDecoratorAdapter, OverScrollHelper.OverScrollListener paramOverScrollListener)
  {
    this(paramIOverScrollDecoratorAdapter, 3.0F, 1.0F, -2.0F, paramOverScrollListener);
  }
  
  protected AbsOverScrollDecorator.AnimationAttributes createAnimationAttributes()
  {
    return new AnimationAttributesHorizontal(this);
  }
  
  protected AbsOverScrollDecorator.MotionAttributes createMotionAttributes()
  {
    return new MotionAttributesHorizontal();
  }
  
  void onUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.overScrollListener == null) {
      return;
    }
    if (paramValueAnimator != null) {}
    for (float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();; f = 0.0F)
    {
      this.overScrollListener.onOverScroll(f);
      return;
    }
  }
  
  protected void translateView(View paramView, float paramFloat)
  {
    if (this.overScrollListener != null) {
      this.overScrollListener.onOverScroll(paramFloat);
    }
    paramView.setTranslationX(paramFloat);
  }
  
  protected void translateViewAndEvent(View paramView, float paramFloat, MotionEvent paramMotionEvent)
  {
    paramView.setTranslationX(paramFloat);
    paramMotionEvent.offsetLocation(paramFloat - paramMotionEvent.getX(0), 0.0F);
  }
  
  public static class AnimationAttributesHorizontal
    extends AbsOverScrollDecorator.AnimationAttributes
  {
    private WeakReference<HorizontalOverScrollBounceEffectDecorator> weakRef;
    
    public AnimationAttributesHorizontal(HorizontalOverScrollBounceEffectDecorator paramHorizontalOverScrollBounceEffectDecorator)
    {
      this.mProperty = View.TRANSLATION_X;
      this.weakRef = new WeakReference(paramHorizontalOverScrollBounceEffectDecorator);
    }
    
    @RequiresApi(api=11)
    protected void init(View paramView)
    {
      this.mAbsOffset = paramView.getTranslationX();
      this.mMaxOffset = paramView.getWidth();
    }
    
    protected void onAnimationEnd()
    {
      HorizontalOverScrollBounceEffectDecorator localHorizontalOverScrollBounceEffectDecorator = (HorizontalOverScrollBounceEffectDecorator)this.weakRef.get();
      if (localHorizontalOverScrollBounceEffectDecorator != null) {
        localHorizontalOverScrollBounceEffectDecorator.onUpdate(null);
      }
    }
    
    protected void onUpdate(ValueAnimator paramValueAnimator)
    {
      HorizontalOverScrollBounceEffectDecorator localHorizontalOverScrollBounceEffectDecorator = (HorizontalOverScrollBounceEffectDecorator)this.weakRef.get();
      if (localHorizontalOverScrollBounceEffectDecorator != null) {
        localHorizontalOverScrollBounceEffectDecorator.onUpdate(paramValueAnimator);
      }
    }
  }
  
  public static class MotionAttributesHorizontal
    extends AbsOverScrollDecorator.MotionAttributes
  {
    public boolean init(View paramView, MotionEvent paramMotionEvent)
    {
      boolean bool = false;
      if (paramMotionEvent.getHistorySize() == 0) {}
      float f1;
      float f2;
      float f3;
      do
      {
        return false;
        f1 = paramMotionEvent.getY(0);
        f2 = paramMotionEvent.getHistoricalY(0, 0);
        f3 = paramMotionEvent.getX(0) - paramMotionEvent.getHistoricalX(0, 0);
      } while (Math.abs(f3) < Math.abs(f1 - f2));
      this.mAbsOffset = paramView.getTranslationX();
      this.mDeltaOffset = f3;
      if (this.mDeltaOffset > 0.0F) {
        bool = true;
      }
      this.mDir = bool;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.HorizontalOverScrollBounceEffectDecorator
 * JD-Core Version:    0.7.0.1
 */