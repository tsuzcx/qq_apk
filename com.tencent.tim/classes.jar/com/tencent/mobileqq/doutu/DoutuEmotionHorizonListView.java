package com.tencent.mobileqq.doutu;

import afdt;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.widget.HorizontalListView;
import yku;

public class DoutuEmotionHorizonListView
  extends HorizontalListView
{
  private a a;
  
  public DoutuEmotionHorizonListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DoutuEmotionHorizonListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      this.a.Ao(paramMotionEvent.getAction());
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt1 > 0)
    {
      if (!(getAdapter() instanceof afdt)) {
        break label34;
      }
      ((afdt)getAdapter()).cYz();
    }
    for (;;)
    {
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
      label34:
      if ((getAdapter() instanceof yku)) {
        ((yku)getAdapter()).cja();
      }
    }
  }
  
  public void setTouchListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Ao(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuEmotionHorizonListView
 * JD-Core Version:    0.7.0.1
 */