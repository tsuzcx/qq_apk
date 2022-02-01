package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import aygz;

class HWEditLocalVideoPlayer$5
  implements Runnable
{
  HWEditLocalVideoPlayer$5(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.b.aHd) {
      return;
    }
    this.this$0.b.a(Message.obtain(null, 13, new Long[] { Long.valueOf(this.aCR / 1000000L), Long.valueOf(this.aCR) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */