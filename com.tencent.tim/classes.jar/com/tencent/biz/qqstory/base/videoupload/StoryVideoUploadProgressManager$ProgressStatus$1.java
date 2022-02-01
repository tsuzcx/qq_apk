package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;
import poe;
import poe.a;
import ram;

public class StoryVideoUploadProgressManager$ProgressStatus$1
  implements Runnable
{
  public StoryVideoUploadProgressManager$ProgressStatus$1(poe.a parama) {}
  
  public void run()
  {
    ram.b("StoryVideoUploadProgressManager", "progress running, id=%s", this.a.id);
    poe.a.a(this.a);
    poe.a(this.a.this$0, this.a.id, this.a.progress);
    if (!poe.a.a(this.a)) {
      poe.a(this.a.this$0).postDelayed(poe.a.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1
 * JD-Core Version:    0.7.0.1
 */