package com.tencent.token.ui.base;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;

class bg
  extends GestureDetector.SimpleOnGestureListener
{
  bg(HorizontialListView paramHorizontialListView) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return this.a.a(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return this.a.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      paramMotionEvent2 = this.a;
      paramMotionEvent2.d += (int)paramFloat1;
      this.a.requestLayout();
      return true;
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    Rect localRect = new Rect();
    int i = 0;
    for (;;)
    {
      if (i < this.a.getChildCount())
      {
        View localView = this.a.getChildAt(i);
        int j = localView.getLeft();
        int k = localView.getRight();
        localRect.set(j, localView.getTop(), k, localView.getBottom());
        if (!localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label207;
        }
        if (HorizontialListView.b(this.a) != null) {
          HorizontialListView.b(this.a).onItemClick(this.a, localView, HorizontialListView.c(this.a) + 1 + i, this.a.b.getItemId(HorizontialListView.c(this.a) + 1 + i));
        }
        if (HorizontialListView.d(this.a) != null) {
          HorizontialListView.d(this.a).onItemSelected(this.a, localView, HorizontialListView.c(this.a) + 1 + i, this.a.b.getItemId(HorizontialListView.c(this.a) + 1 + i));
        }
      }
      return true;
      label207:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bg
 * JD-Core Version:    0.7.0.1
 */