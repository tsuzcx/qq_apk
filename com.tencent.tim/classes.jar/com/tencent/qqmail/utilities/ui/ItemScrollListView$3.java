package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

class ItemScrollListView$3
  extends GestureDetector.SimpleOnGestureListener
{
  private float lastX = -1.0F;
  private final int touchSlop = ViewConfiguration.get(this.val$context).getScaledTouchSlop();
  
  ItemScrollListView$3(ItemScrollListView paramItemScrollListView, Context paramContext) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((ItemScrollListView.access$300(this.this$0) != null) && (ItemScrollListView.access$400(this.this$0, paramMotionEvent) != ItemScrollListView.access$300(this.this$0)))
    {
      ItemScrollListView.access$500(this.this$0);
      return true;
    }
    this.lastX = -1.0F;
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((ItemScrollListView.access$600(this.this$0) & 0x4) == 4)
    {
      if (paramFloat1 > 1500.0F)
      {
        ItemScrollListView.access$500(this.this$0);
        return true;
      }
      if (paramFloat1 < -1500.0F)
      {
        ItemScrollListView.access$800(this.this$0);
        return true;
      }
    }
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent1 == null) {
      return false;
    }
    Object localObject;
    if ((ItemScrollListView.access$600(this.this$0) == 0) && (Math.tan(Math.toRadians(15.0D)) * Math.abs((int)(paramMotionEvent2.getX() - paramMotionEvent1.getX())) > Math.abs((int)(paramMotionEvent2.getY() - paramMotionEvent1.getY()))))
    {
      int i = this.this$0.pointToPosition((int)paramMotionEvent1.getX(), (int)paramMotionEvent1.getY());
      if ((i == -1) || (i < this.this$0.getHeaderViewsCount())) {
        return false;
      }
      int j = this.this$0.getHeaderViewsCount();
      localObject = ItemScrollListView.access$400(this.this$0, paramMotionEvent1);
      ItemScrollListView.access$700(this.this$0, i - j, (View)localObject);
    }
    if ((ItemScrollListView.access$600(this.this$0) & 0x4) == 4)
    {
      ItemScrollListView.access$602(this.this$0, 5);
      if (ItemScrollListView.access$300(this.this$0) == null) {
        return false;
      }
      localObject = ItemScrollListView.access$300(this.this$0);
      paramFloat2 = paramMotionEvent2.getX();
      if (this.lastX == -1.0F) {}
      for (paramFloat1 = paramMotionEvent1.getX();; paramFloat1 = this.lastX)
      {
        ((HorizontalScrollItemView)localObject).scrollBy((int)(paramFloat2 - paramFloat1), 0, ItemScrollListView.access$100(this.this$0));
        this.lastX = paramMotionEvent2.getX();
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.ItemScrollListView.3
 * JD-Core Version:    0.7.0.1
 */