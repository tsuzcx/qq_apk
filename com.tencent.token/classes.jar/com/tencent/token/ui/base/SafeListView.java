package com.tencent.token.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.tencent.token.global.h;

public class SafeListView
  extends ListView
{
  public SafeListView(Context paramContext)
  {
    super(paramContext);
  }
  
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
      h.c("SafeListView dispatchDraw" + paramCanvas.toString());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IndexOutOfBoundsException paramMotionEvent)
    {
      h.c("SafeListView dispatchTouchEvent" + paramMotionEvent.toString());
      return false;
    }
    catch (Exception paramMotionEvent)
    {
      h.c("SafeListView dispatchTouchEvent" + paramMotionEvent.toString());
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
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      h.c("SafeListView onLayout" + localIndexOutOfBoundsException.toString());
      localIndexOutOfBoundsException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      h.c("SafeListView onLayout" + localException.toString());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.SafeListView
 * JD-Core Version:    0.7.0.1
 */