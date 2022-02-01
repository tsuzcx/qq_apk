package com.tencent.qqmail.card.view;

import android.util.Log;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class CardTransitionView$1
  implements GestureDetector.OnGestureListener
{
  CardTransitionView$1(CardTransitionView paramCardTransitionView) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    Log.d("DiscoverTransitionView", "disctance:" + CardTransitionView.access$000(this.this$0) + " v:" + paramFloat2);
    if ((paramFloat2 > 0.0F) || (!CardTransitionView.access$100(this.this$0)))
    {
      CardTransitionView.access$200(this.this$0, CardTransitionView.access$000(this.this$0));
      return true;
    }
    if ((CardTransitionView.access$000(this.this$0) >= 0) || (paramFloat2 >= -300.0F) || (!CardTransitionView.access$100(this.this$0))) {
      return false;
    }
    CardTransitionView.access$300(this.this$0);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardTransitionView.1
 * JD-Core Version:    0.7.0.1
 */