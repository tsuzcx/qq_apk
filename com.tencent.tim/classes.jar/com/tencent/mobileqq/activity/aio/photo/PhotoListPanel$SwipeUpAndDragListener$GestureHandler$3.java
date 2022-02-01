package com.tencent.mobileqq.activity.aio.photo;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3
  implements Runnable
{
  PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3(PhotoListPanel.h.c paramc, PhotoListPanel.h paramh) {}
  
  public void run()
  {
    if (this.d.hT != null)
    {
      this.d.hT.clearAnimation();
      this.d.hT.removeAllViews();
      ThreadManager.getUIHandler().postDelayed(this.d.ex, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.GestureHandler.3
 * JD-Core Version:    0.7.0.1
 */