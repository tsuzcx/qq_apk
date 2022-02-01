package com.tencent.biz.pubaccount.readinjoy.common;

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

public class ReadInJoyCardViewCostBall
  extends TextView
{
  private WindowManager.LayoutParams mLayoutParams;
  private WindowManager mWindowManager;
  
  public ReadInJoyCardViewCostBall(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyCardViewCostBall(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyCardViewCostBall(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
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
        this.aMh = ReadInJoyCardViewCostBall.a(ReadInJoyCardViewCostBall.this).x;
        this.aMi = ReadInJoyCardViewCostBall.a(ReadInJoyCardViewCostBall.this).y;
        this.ji = paramMotionEvent.getRawX();
        this.jj = paramMotionEvent.getRawY();
        continue;
        ReadInJoyCardViewCostBall.a(ReadInJoyCardViewCostBall.this).x = (this.aMh + (int)(this.ji - paramMotionEvent.getRawX()));
        ReadInJoyCardViewCostBall.a(ReadInJoyCardViewCostBall.this).y = (this.aMi + (int)(paramMotionEvent.getRawY() - this.jj));
        ReadInJoyCardViewCostBall.a(ReadInJoyCardViewCostBall.this).updateViewLayout(paramView, ReadInJoyCardViewCostBall.a(ReadInJoyCardViewCostBall.this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyCardViewCostBall
 * JD-Core Version:    0.7.0.1
 */