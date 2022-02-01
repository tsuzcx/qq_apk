package com.tencent.biz.pubaccount.NativeAd.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class VerticleViewPager
  extends ViewPager
{
  public VerticleViewPager(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VerticleViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    setPageTransformer(true, new a(null));
    setOverScrollMode(2);
  }
  
  private MotionEvent swapXY(MotionEvent paramMotionEvent)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    paramMotionEvent.setLocation(paramMotionEvent.getY() / f2 * f1, paramMotionEvent.getX() / f1 * f2);
    return paramMotionEvent;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(swapXY(paramMotionEvent));
    swapXY(paramMotionEvent);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(swapXY(paramMotionEvent));
  }
  
  class a
    implements ViewPager.PageTransformer
  {
    private a() {}
    
    public void transformPage(View paramView, float paramFloat)
    {
      if (paramFloat < -1.0F)
      {
        paramView.setAlpha(0.0F);
        return;
      }
      if (paramFloat <= 1.0F)
      {
        paramView.setAlpha(1.0F);
        paramView.setTranslationX(paramView.getWidth() * -paramFloat);
        paramView.setTranslationY(paramView.getHeight() * paramFloat);
        return;
      }
      paramView.setAlpha(0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.adapter.VerticleViewPager
 * JD-Core Version:    0.7.0.1
 */