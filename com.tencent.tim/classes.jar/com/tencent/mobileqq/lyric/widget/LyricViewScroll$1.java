package com.tencent.mobileqq.lyric.widget;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

class LyricViewScroll$1
  extends TimerTask
{
  int last;
  
  LyricViewScroll$1(LyricViewScroll paramLyricViewScroll) {}
  
  public void run()
  {
    Log.v("LyricViewScroll", "fling detect running");
    if (this.last == this.this$0.getScrollY())
    {
      this.this$0.mLastY = this.last;
      LyricViewScroll.a(this.this$0).Qn(this.last);
      Log.d("LyricViewScroll", "fling stop");
      this.this$0.H.cancel();
      this.this$0.cmv = false;
      LyricViewScroll.a(this.this$0, false);
      return;
    }
    this.last = this.this$0.getScrollY();
    LyricViewScroll.a(this.this$0).Qo(this.last);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewScroll.1
 * JD-Core Version:    0.7.0.1
 */