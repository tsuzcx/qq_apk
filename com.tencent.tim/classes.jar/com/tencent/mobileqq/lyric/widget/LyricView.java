package com.tencent.mobileqq.lyric.widget;

import aixc;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import atau.a;

public class LyricView
  extends FrameLayout
{
  protected aixc a;
  protected LyricViewInternal a;
  protected LyricViewScroll a;
  protected boolean cmk = true;
  protected boolean mIsScrollable;
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.ra, 0, 0);
    this.jdField_a_of_type_Aixc = new aixc();
    this.jdField_a_of_type_Aixc.h(paramContext);
    this.mIsScrollable = paramContext.getBoolean(16, false);
    paramContext.recycle();
  }
  
  public LyricViewInternal a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal;
  }
  
  public LyricViewScroll a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll;
  }
  
  public boolean ak(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.ak(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.ob(paramInt4 - paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.cmk)
    {
      ak(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public void setIsDealTouchEvent(boolean paramBoolean)
  {
    this.cmk = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricView
 * JD-Core Version:    0.7.0.1
 */