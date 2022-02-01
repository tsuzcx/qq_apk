package com.tencent.mobileqq.activity.aio.photo;

import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicBoolean;

class PhotoListPanel$SwipeUpAndDragListener$3
  implements Runnable
{
  PhotoListPanel$SwipeUpAndDragListener$3(PhotoListPanel.h paramh) {}
  
  public void run()
  {
    PhotoListPanel.e.a locala;
    if ((this.this$0.bJ.get()) && (SystemClock.elapsedRealtime() - this.this$0.JD >= PhotoListPanel.h.access$000()))
    {
      locala = (PhotoListPanel.e.a)this.this$0.d.mRecyclerView.findViewHolderForAdapterPosition(this.this$0.bXr);
      if (locala != null) {
        break label61;
      }
    }
    label61:
    do
    {
      do
      {
        return;
      } while (this.this$0.bjV);
      this.this$0.bjV = true;
      this.this$0.a = this.this$0.c;
    } while (this.this$0.a == null);
    this.this$0.a.a(locala, this.this$0.bXr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.3
 * JD-Core Version:    0.7.0.1
 */