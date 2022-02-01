package com.tencent.biz.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;

public class ElasticHorScrView
  extends HorizontalScrollView
{
  protected Rect D = new Rect();
  protected final double V = 2.5D;
  protected ViewGroup al;
  protected boolean canMove;
  protected View ek;
  protected final int time = 300;
  protected float x;
  protected boolean yN = true;
  
  public ElasticHorScrView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ElasticHorScrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean ey()
  {
    return !this.D.isEmpty();
  }
  
  private boolean ez()
  {
    int i = this.ek.getMeasuredWidth();
    int j = getWidth();
    int k = getScrollX();
    return (k == 0) || (i - j == k);
  }
  
  private void l(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    int i;
    int j;
    int k;
    int m;
    do
    {
      return;
      this.x = paramMotionEvent.getX();
      return;
      if (ey()) {
        pI();
      }
      this.yN = true;
      return;
      if (this.yN)
      {
        this.x = paramMotionEvent.getX();
        this.yN = false;
      }
      float f1 = this.x;
      float f2 = paramMotionEvent.getX();
      i = (int)((f1 - f2) / 2.5D);
      this.x = f2;
      if (!ez()) {
        break;
      }
      if (this.D.isEmpty()) {
        this.D.set(this.ek.getLeft(), this.ek.getTop(), this.ek.getRight(), this.ek.getBottom());
      }
      j = this.ek.getMeasuredWidth();
      k = getWidth();
      m = getScrollX();
      Log.v("test", "inner.getLeft()" + this.ek.getLeft() + "distanceX" + i + "inner.getRight()" + this.ek.getRight());
    } while (((m != 0) || (i >= 0)) && ((j - k != m) || (i <= 0)));
    this.ek.layout(this.ek.getLeft() - i, this.ek.getTop(), this.ek.getRight() - i, this.ek.getBottom());
    return;
    scrollBy(i, 0);
  }
  
  private void pI()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(this.ek.getLeft(), this.D.left, 0.0F, 0.0F);
    localTranslateAnimation.setDuration(300L);
    this.ek.setAnimation(localTranslateAnimation);
    this.ek.layout(this.D.left, this.D.top, this.D.right, this.D.bottom);
    this.D.setEmpty();
  }
  
  protected void onFinishInflate()
  {
    if ((getChildCount() > 0) && ((getChildAt(0) instanceof ViewGroup))) {
      this.al = ((ViewGroup)getChildAt(0));
    }
    if (this.al.getChildCount() > 0) {
      this.ek = this.al.getChildAt(0);
    }
    super.onFinishInflate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.canMove) {
      return false;
    }
    l(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMove(boolean paramBoolean)
  {
    this.canMove = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.widgets.ElasticHorScrView
 * JD-Core Version:    0.7.0.1
 */