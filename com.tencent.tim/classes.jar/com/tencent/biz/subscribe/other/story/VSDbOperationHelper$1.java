package com.tencent.biz.subscribe.other.story;

import com.tencent.mobileqq.persistence.EntityManager;
import ram;
import sfk;

public class VSDbOperationHelper$1
  implements Runnable
{
  public VSDbOperationHelper$1(sfk paramsfk, VSUploadVideoEntry paramVSUploadVideoEntry, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.b == null) {
      return;
    }
    ram.i("Q.videostory.publish.upload.VSDbOperationHelper", "updateDbVideoEntry()  uploadStatus=" + this.b.statusToInfo() + " , isFirst=" + this.uk);
    if (this.b.originalEntry != null) {
      sfk.a(this.this$0).update(this.b.originalEntry);
    }
    if (this.uk)
    {
      sfk.a(this.this$0).persistOrReplace(this.b);
      return;
    }
    sfk.a(this.this$0).update(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSDbOperationHelper.1
 * JD-Core Version:    0.7.0.1
 */