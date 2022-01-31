package com.tencent.token.ui.base;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;

final class be
  extends GestureDetector.SimpleOnGestureListener
{
  be(HorizontialListView paramHorizontialListView) {}
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return this.a.a();
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return this.a.a(paramFloat1);
  }
  
  public final boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      paramMotionEvent2 = this.a;
      paramMotionEvent2.d += (int)paramFloat1;
      this.a.requestLayout();
      return true;
    }
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
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
        if (HorizontialListView.c(this.a) != null) {
          HorizontialListView.c(this.a).onItemClick(this.a, localView, HorizontialListView.d(this.a) + 1 + i, this.a.b.getItemId(HorizontialListView.d(this.a) + 1 + i));
        }
        if (HorizontialListView.e(this.a) != null) {
          HorizontialListView.e(this.a).onItemSelected(this.a, localView, HorizontialListView.d(this.a) + 1 + i, this.a.b.getItemId(HorizontialListView.d(this.a) + 1 + i));
        }
      }
      return true;
      label207:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.be
 * JD-Core Version:    0.7.0.1
 */