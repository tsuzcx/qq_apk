package com.tencent.mobileqq.profile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;

@TargetApi(9)
public class ReboundHorizontalScrollView
  extends HorizontalScrollView
{
  private static final int jdField_a_of_type_Int = 200;
  private Context jdField_a_of_type_AndroidContentContext;
  private int b;
  
  public ReboundHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public ReboundHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  public ReboundHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    setFadingEdgeLength(0);
    this.b = ((int)(this.a.getResources().getDisplayMetrics().density * 200.0F));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @TargetApi(9)
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, this.b, paramInt8, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ReboundHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */