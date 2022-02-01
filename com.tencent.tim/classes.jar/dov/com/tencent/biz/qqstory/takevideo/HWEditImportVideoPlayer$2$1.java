package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import aygz;
import ayis;
import ayis.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import ram;

class HWEditImportVideoPlayer$2$1
  implements Runnable
{
  HWEditImportVideoPlayer$2$1(HWEditImportVideoPlayer.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.oG.size() > 0)
    {
      ayis.a locala = (ayis.a)this.a.this$0.oG.get(0);
      ayis.a(this.a.this$0, locala);
    }
    for (;;)
    {
      this.a.this$0.b.a(Message.obtain(null, 8));
      ayis.a(this.a.this$0).set(true);
      return;
      ram.e("Q.qqstory.record.HWEditImportVideoPlayer", "mFragmentInfos is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.2.1
 * JD-Core Version:    0.7.0.1
 */