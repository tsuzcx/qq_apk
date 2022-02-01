package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import aydu;
import aygz;

class HWEditLocalVideoPlayer$6
  implements Runnable
{
  HWEditLocalVideoPlayer$6(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    aydu localaydu = (aydu)this.this$0.a(aydu.class);
    if (localaydu != null) {
      localaydu.bsg();
    }
    this.this$0.b.a(Message.obtain(null, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */