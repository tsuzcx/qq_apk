package com.tencent.biz.pubaccount.util.monitor;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

class FPSSuspendedBall
  extends TextView
{
  private WindowManager.LayoutParams mLayoutParams;
  private WindowManager mWindowManager;
  
  public FPSSuspendedBall(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FPSSuspendedBall(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FPSSuspendedBall(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    createView(paramContext);
  }
  
  private void createView(Context paramContext)
  {
    setId(2131371895);
    setBackgroundColor(paramContext.getResources().getColor(2131165397));
    setText("60.00");
    setTextColor(-16711936);
    setGravity(17);
    setOnTouchListener(new a(null));
    this.mLayoutParams = new WindowManager.LayoutParams(-2, -2, 1000, 8, -3);
    this.mLayoutParams.gravity = 53;
    this.mLayoutParams.y = 250;
    float f = getTextSize();
    this.mLayoutParams.width = ((int)(5.0F * f));
    this.mLayoutParams.height = ((int)(f * 1.5D));
  }
  
  class a
    implements View.OnTouchListener
  {
    private int aMh;
    private int aMi;
    private float ji;
    private float jj;
    
    private a() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return false;
        this.aMh = FPSSuspendedBall.a(FPSSuspendedBall.this).x;
        this.aMi = FPSSuspendedBall.a(FPSSuspendedBall.this).y;
        this.ji = paramMotionEvent.getRawX();
        this.jj = paramMotionEvent.getRawY();
        continue;
        FPSSuspendedBall.a(FPSSuspendedBall.this).x = (this.aMh + (int)(this.ji - paramMotionEvent.getRawX()));
        FPSSuspendedBall.a(FPSSuspendedBall.this).y = (this.aMi + (int)(paramMotionEvent.getRawY() - this.jj));
        FPSSuspendedBall.a(FPSSuspendedBall.this).updateViewLayout(paramView, FPSSuspendedBall.a(FPSSuspendedBall.this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.FPSSuspendedBall
 * JD-Core Version:    0.7.0.1
 */