package com.tencent.tavcut.timeline;

import android.graphics.Bitmap;
import com.tencent.tavcut.cover.CoverListener;

class TimelineView$4
  implements CoverListener
{
  TimelineView$4(TimelineView paramTimelineView) {}
  
  public void onCover(int paramInt, Bitmap paramBitmap)
  {
    this.this$0.post(new TimelineView.4.1(this, paramInt, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineView.4
 * JD-Core Version:    0.7.0.1
 */