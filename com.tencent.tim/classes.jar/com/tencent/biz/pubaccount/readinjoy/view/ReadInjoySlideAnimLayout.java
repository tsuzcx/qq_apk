package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

public class ReadInjoySlideAnimLayout
  extends FrameLayout
{
  public FrameLayout ap;
  private boolean asm;
  public View mContentView;
  private TextView tj;
  
  public ReadInjoySlideAnimLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(2131560476, this, true);
    this.ap = ((FrameLayout)paramContext.findViewById(2131365375));
    this.tj = ((TextView)paramContext.findViewById(2131377036));
  }
  
  public void aXg()
  {
    if (this.mContentView != null) {
      this.ap.removeView(this.mContentView);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.asm) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.asm) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setContentView(View paramView)
  {
    if ((this.mContentView != null) && (this.mContentView != paramView)) {
      this.ap.removeView(this.mContentView);
    }
    this.mContentView = paramView;
    paramView = new FrameLayout.LayoutParams(-1, -1);
    this.ap.addView(this.mContentView, 0, paramView);
    this.ap.setBackgroundColor(0);
  }
  
  public void setDisableContentTouch(boolean paramBoolean)
  {
    this.asm = paramBoolean;
  }
  
  public void setMessage(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.tj.setVisibility(0);
      this.tj.setText(paramString);
      return;
    }
    this.tj.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInjoySlideAnimLayout
 * JD-Core Version:    0.7.0.1
 */