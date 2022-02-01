package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ClickPreventableTextView
  extends TextView
  implements View.OnClickListener
{
  private View.OnClickListener clickListener;
  private boolean cwE;
  private boolean cwF;
  
  public ClickPreventableTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ClickPreventableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ClickPreventableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean atz()
  {
    return this.cwF;
  }
  
  public void dFH()
  {
    this.cwE = true;
  }
  
  public void onClick(View paramView)
  {
    if (this.cwE) {
      this.cwE = false;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.clickListener != null) {
        this.clickListener.onClick(paramView);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getMovementMethod() != null) {
      getMovementMethod().onTouchEvent(this, (Spannable)getText(), paramMotionEvent);
    }
    this.cwF = true;
    boolean bool = super.onTouchEvent(paramMotionEvent);
    this.cwF = false;
    return bool;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.clickListener = paramOnClickListener;
    super.setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ClickPreventableTextView
 * JD-Core Version:    0.7.0.1
 */