package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import wja;
import xks;

public class ClickedWaveView
  extends ImageView
{
  static final int bSK = wja.dp2px(0.01F, BaseApplicationImpl.getContext().getResources());
  static final int bSL = wja.dp2px(60.0F, BaseApplicationImpl.getContext().getResources());
  MovingRadiusRunnable jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$MovingRadiusRunnable = new MovingRadiusRunnable();
  a jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$a = null;
  private Bundle ah;
  int bSM = 20;
  int bSN = 0;
  Drawable dM = null;
  Scroller g = null;
  
  public ClickedWaveView(Context paramContext)
  {
    super(paramContext);
    this.g = new Scroller(paramContext, new DecelerateInterpolator());
  }
  
  public ClickedWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = new Scroller(paramContext, new DecelerateInterpolator());
  }
  
  public ClickedWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.g = new Scroller(paramContext, new DecelerateInterpolator());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    int j = getHeight() / 2;
    Paint localPaint = new Paint();
    localPaint.setARGB(this.bSN, 0, 0, 0);
    if (this.bSM > i) {
      this.bSM = i;
    }
    paramCanvas.drawCircle(i, j, this.bSM, localPaint);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return bool;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$a.bZJ();
      }
      if ((this.dM != null) && ((this.dM instanceof CustomFrameAnimationDrawable))) {
        ((CustomFrameAnimationDrawable)this.dM).unscheduleSelf((Runnable)this.dM);
      }
      this.g.startScroll(bSK, 0, bSL, 0, 900);
      this.bSM = bSK;
      this.bSN = 30;
      xks.b(this, this.ah.getInt("type"), this.ah.getInt("id"));
      postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$MovingRadiusRunnable, 20L);
      return true;
      setImageDrawable(this.dM);
      if ((this.dM != null) && ((this.dM instanceof CustomFrameAnimationDrawable))) {
        ((CustomFrameAnimationDrawable)this.dM).resume();
      }
      if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$a != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$a.bx(this.ah);
      }
    }
  }
  
  public void setCustomDrawable(Drawable paramDrawable)
  {
    this.dM = paramDrawable;
  }
  
  public void setExtraInfo(Bundle paramBundle)
  {
    this.ah = paramBundle;
  }
  
  public void setOnTouchReceive(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$a = parama;
  }
  
  class MovingRadiusRunnable
    implements Runnable
  {
    MovingRadiusRunnable() {}
    
    public void run()
    {
      if ((ClickedWaveView.this.g.computeScrollOffset()) || (ClickedWaveView.this.bSN > 0))
      {
        ClickedWaveView.this.bSM = ClickedWaveView.this.g.getCurrX();
        if (ClickedWaveView.this.bSN > 0)
        {
          ClickedWaveView localClickedWaveView = ClickedWaveView.this;
          localClickedWaveView.bSN -= 3;
        }
        if (ClickedWaveView.this.bSN < 0) {
          ClickedWaveView.this.bSN = 0;
        }
        ClickedWaveView.this.postInvalidate();
        ClickedWaveView.this.postDelayed(this, 20L);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bZJ();
    
    public abstract void bx(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ClickedWaveView
 * JD-Core Version:    0.7.0.1
 */