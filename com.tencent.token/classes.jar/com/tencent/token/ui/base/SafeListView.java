package com.tencent.token.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.tencent.token.xv;

public class SafeListView
  extends ListView
{
  public SafeListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SafeListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (IndexOutOfBoundsException paramCanvas)
    {
      StringBuilder localStringBuilder = new StringBuilder("SafeListView dispatchDraw");
      localStringBuilder.append(paramCanvas.toString());
      xv.c(localStringBuilder.toString());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      localStringBuilder = new StringBuilder("SafeListView dispatchTouchEvent");
      localStringBuilder.append(paramMotionEvent.toString());
      xv.c(localStringBuilder.toString());
      return false;
    }
    catch (IndexOutOfBoundsException paramMotionEvent)
    {
      StringBuilder localStringBuilder = new StringBuilder("SafeListView dispatchTouchEvent");
      localStringBuilder.append(paramMotionEvent.toString());
      xv.c(localStringBuilder.toString());
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder("SafeListView onLayout");
      localStringBuilder.append(localException.toString());
      xv.c(localStringBuilder.toString());
      localException.printStackTrace();
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SafeListView onLayout");
      localStringBuilder.append(localIndexOutOfBoundsException.toString());
      xv.c(localStringBuilder.toString());
      localIndexOutOfBoundsException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.SafeListView
 * JD-Core Version:    0.7.0.1
 */