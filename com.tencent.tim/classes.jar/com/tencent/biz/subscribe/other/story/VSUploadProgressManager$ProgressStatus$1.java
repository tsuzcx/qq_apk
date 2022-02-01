package com.tencent.biz.subscribe.other.story;

import android.os.Handler;
import sfl;
import sfl.a;

public class VSUploadProgressManager$ProgressStatus$1
  implements Runnable
{
  public VSUploadProgressManager$ProgressStatus$1(sfl.a parama) {}
  
  public void run()
  {
    sfl.a.a(this.a);
    sfl.a(this.a.this$0, this.a.id, this.a.progress);
    if (!sfl.a.a(this.a)) {
      sfl.a(this.a.this$0).postDelayed(sfl.a.a(this.a), 550L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSUploadProgressManager.ProgressStatus.1
 * JD-Core Version:    0.7.0.1
 */