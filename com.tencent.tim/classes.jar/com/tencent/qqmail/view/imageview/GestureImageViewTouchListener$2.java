package com.tencent.qqmail.view.imageview;

import android.util.Log;

class GestureImageViewTouchListener$2
  implements ZoomAnimationListener
{
  GestureImageViewTouchListener$2(GestureImageViewTouchListener paramGestureImageViewTouchListener) {}
  
  public void onComplete()
  {
    Log.d("download", "handle zoom complete");
    GestureImageViewTouchListener.access$402(this.this$0, false);
    this.this$0.handleUp();
  }
  
  public void onZoom(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat1 <= GestureImageViewTouchListener.access$200(this.this$0)) && (paramFloat1 >= GestureImageViewTouchListener.access$300(this.this$0)))
    {
      Log.d("download", "handle zoom scale " + paramFloat1);
      this.this$0.handleScale(paramFloat1, paramFloat2, paramFloat3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.GestureImageViewTouchListener.2
 * JD-Core Version:    0.7.0.1
 */