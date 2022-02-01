package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import aygz;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import ram;

class HWEditLocalVideoPlayer$2$1
  implements Runnable
{
  HWEditLocalVideoPlayer$2$1(HWEditLocalVideoPlayer.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.oG.size() > 0)
    {
      HWEditLocalVideoPlayer.a locala = (HWEditLocalVideoPlayer.a)this.a.this$0.oG.get(0);
      HWEditLocalVideoPlayer.a(this.a.this$0, locala);
    }
    for (;;)
    {
      this.a.this$0.b.a(Message.obtain(null, 8));
      HWEditLocalVideoPlayer.a(this.a.this$0, this.a.this$0.bqD);
      HWEditLocalVideoPlayer.a(this.a.this$0).set(true);
      this.a.this$0.b.Zo(true);
      return;
      ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "mFragmentInfos is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.2.1
 * JD-Core Version:    0.7.0.1
 */