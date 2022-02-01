package com.tencent.qqmail.card.view;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.core.view.MotionEventCompat;

class CardTransitionView$2
  implements View.OnTouchListener
{
  private GestureDetector mGestureDetector = new GestureDetector(this.this$0.getContext(), CardTransitionView.access$400(this.this$0));
  
  CardTransitionView$2(CardTransitionView paramCardTransitionView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 0) {
      CardTransitionView.access$600(this.this$0, CardTransitionView.access$500(this.this$0), CardTransitionView.access$000(this.this$0));
    }
    do
    {
      do
      {
        return true;
        if ((i != 3) && (i != 1)) {
          break;
        }
        Log.d("DiscoverTransitionView", "performLongClick transition");
        CardTransitionView.access$702(this.this$0, false);
      } while (this.mGestureDetector.onTouchEvent(paramMotionEvent));
      CardTransitionView.access$600(this.this$0, CardTransitionView.access$500(this.this$0), CardTransitionView.access$000(this.this$0));
      return true;
    } while ((i != 2) || (!CardTransitionView.access$700(this.this$0)));
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    if (CardTransitionView.access$500(this.this$0) == 1.4E-45F)
    {
      Log.d("DiscoverTransitionView", "on touch Initialize");
      CardTransitionView.access$502(this.this$0, (int)paramMotionEvent.getY());
      CardTransitionView.access$002(this.this$0, 0);
      return true;
    }
    float f1 = paramMotionEvent.getY();
    float f2 = f1 - CardTransitionView.access$500(this.this$0);
    if ((CardTransitionView.access$000(this.this$0) + f2 >= 0.0F) || (!CardTransitionView.access$100(this.this$0)))
    {
      i = (int)(f2 * 0.5F);
      CardTransitionView.access$800(this.this$0).offsetTopAndBottom(i);
      CardTransitionView.access$502(this.this$0, f1);
      CardTransitionView.access$002(this.this$0, i + CardTransitionView.access$000(this.this$0));
      paramView = CardTransitionView.access$1000(this.this$0);
      paramMotionEvent = CardTransitionView.access$800(this.this$0);
      i = CardTransitionView.access$000(this.this$0);
      if (-CardTransitionView.access$000(this.this$0) < CardTransitionView.access$900(this.this$0)) {
        break label331;
      }
    }
    label331:
    for (boolean bool = true;; bool = false)
    {
      paramView.onScroll(paramMotionEvent, i, bool, CardTransitionView.access$100(this.this$0));
      return true;
      i = (int)f2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardTransitionView.2
 * JD-Core Version:    0.7.0.1
 */