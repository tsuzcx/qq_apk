package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import aygz;
import ayis;

public class HWEditImportVideoPlayer$5
  implements Runnable
{
  public HWEditImportVideoPlayer$5(ayis paramayis, long paramLong) {}
  
  public void run()
  {
    long l2 = this.aCR / 1000000L;
    long l1;
    if (l2 < ayis.a(this.this$0)) {
      l1 = ayis.a(this.this$0);
    }
    while (this.this$0.b.aHd)
    {
      return;
      l1 = l2;
      if (l2 > ayis.b(this.this$0)) {
        l1 = ayis.b(this.this$0);
      }
    }
    this.this$0.b.a(Message.obtain(null, 13, new Long[] { Long.valueOf(l1), Long.valueOf(this.aCR) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */