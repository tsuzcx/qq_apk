package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import aydu;
import aygz;
import ayis;

public class HWEditImportVideoPlayer$6
  implements Runnable
{
  public HWEditImportVideoPlayer$6(ayis paramayis) {}
  
  public void run()
  {
    if (this.this$0.Yp) {
      return;
    }
    aydu localaydu = (aydu)this.this$0.a(aydu.class);
    if (localaydu != null) {
      localaydu.bsg();
    }
    this.this$0.b.a(Message.obtain(null, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */