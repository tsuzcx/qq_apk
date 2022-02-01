package com.tencent.biz.subscribe.other.story;

import android.text.TextUtils;
import ram;
import sfp;

public class VSUploadVideoManager$1
  implements Runnable
{
  public void run()
  {
    if ((this.this$0.a != null) && (TextUtils.equals(this.this$0.a.a.fakeId, this.c.fakeId)))
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "[vs_publish_flow] startUploadVideoTask() newTask is runningTask => fakeId=" + this.c.fakeId);
      return;
    }
    ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "[vs_publish_flow] startUploadVideoTask() add newTask => fakeId=" + this.c.fakeId);
    this.this$0.a(this.c);
    this.this$0.bmk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSUploadVideoManager.1
 * JD-Core Version:    0.7.0.1
 */