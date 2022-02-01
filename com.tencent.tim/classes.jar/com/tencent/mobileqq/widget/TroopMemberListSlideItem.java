package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.Scroller;

public class TroopMemberListSlideItem
  extends FrameLayout
{
  protected View JG;
  protected View JH;
  protected boolean dbO;
  private boolean dbP;
  protected int eiG;
  protected Scroller mScroller;
  
  public TroopMemberListSlideItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public TroopMemberListSlideItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public void TR(boolean paramBoolean)
  {
    if (getScrollX() > 0) {
      return;
    }
    if (paramBoolean) {
      this.mScroller.startScroll(0, 0, this.eiG, 0);
    }
    for (;;)
    {
      invalidate();
      return;
      scrollTo(this.eiG, 0);
    }
  }
  
  public void TS(boolean paramBoolean)
  {
    if (getScrollX() == 0) {
      return;
    }
    if (paramBoolean) {
      this.mScroller.startScroll(this.eiG, 0, -this.eiG, 0);
    }
    for (;;)
    {
      invalidate();
      return;
      scrollTo(0, 0);
    }
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), 0);
      invalidate();
    }
  }
  
  protected void init(Context paramContext)
  {
    this.mScroller = new Scroller(paramContext);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.JG = getChildAt(0);
    this.JH = getChildAt(1);
    ViewGroup.LayoutParams localLayoutParams = this.JG.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.width == -1)) {
      this.dbO = true;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = this.JG.getMeasuredWidth();
    if (this.dbO) {
      paramInt1 = getMeasuredWidth();
    }
    this.JG.layout(0, 0, paramInt1, this.JG.getMeasuredHeight());
    this.JH.layout(paramInt1, 0, this.JH.getMeasuredWidth() + paramInt1, this.JH.getMeasuredHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.eiG = this.JH.getMeasuredWidth();
  }
  
  public void setSlideEnabled(boolean paramBoolean)
  {
    this.dbP = paramBoolean;
    if (this.dbP)
    {
      setClickable(true);
      return;
    }
    setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TroopMemberListSlideItem
 * JD-Core Version:    0.7.0.1
 */