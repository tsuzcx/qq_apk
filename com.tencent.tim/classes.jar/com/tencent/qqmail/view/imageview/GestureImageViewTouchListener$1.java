package com.tencent.qqmail.view.imageview;

import android.graphics.PointF;
import android.util.Log;

class GestureImageViewTouchListener$1
  implements FlingAnimationListener
{
  GestureImageViewTouchListener$1(GestureImageViewTouchListener paramGestureImageViewTouchListener) {}
  
  public void onComplete()
  {
    if (GestureImageViewTouchListener.access$100(this.this$0) != null) {
      GestureImageViewTouchListener.access$100(this.this$0).onFling();
    }
    Log.d("hy", "fling oncomplete animation");
  }
  
  public void onMove(float paramFloat1, float paramFloat2)
  {
    this.this$0.handleDrag(GestureImageViewTouchListener.access$000(this.this$0).x + paramFloat1, GestureImageViewTouchListener.access$000(this.this$0).y + paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.GestureImageViewTouchListener.1
 * JD-Core Version:    0.7.0.1
 */