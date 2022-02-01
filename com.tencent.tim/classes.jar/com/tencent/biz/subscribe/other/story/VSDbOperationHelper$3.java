package com.tencent.biz.subscribe.other.story;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.persistence.EntityManager;
import ram;
import sfk;

public class VSDbOperationHelper$3
  implements Runnable
{
  public VSDbOperationHelper$3(sfk paramsfk, VSUploadVideoEntry paramVSUploadVideoEntry) {}
  
  public void run()
  {
    if (this.b == null) {
      return;
    }
    ram.i("Q.videostory.publish.upload.VSDbOperationHelper", "deleteLocalFile() detele local fail file");
    sfk.a(this.this$0, this.b);
    if (this.b.originalEntry != null) {
      sfk.a(this.this$0, this.b.originalEntry);
    }
    sfk.a(this.this$0).delete(PublishVideoEntry.class.getSimpleName(), "fakeVid=?", new String[] { this.b.fakeId });
    sfk.a(this.this$0).delete(VSUploadVideoEntry.class.getSimpleName(), "fakeId=?", new String[] { this.b.fakeId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSDbOperationHelper.3
 * JD-Core Version:    0.7.0.1
 */