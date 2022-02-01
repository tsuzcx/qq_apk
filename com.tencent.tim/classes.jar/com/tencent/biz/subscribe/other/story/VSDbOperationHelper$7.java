package com.tencent.biz.subscribe.other.story;

import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.persistence.EntityManager;
import ram;
import sfk;
import sqn;

public class VSDbOperationHelper$7
  implements Runnable
{
  public VSDbOperationHelper$7(sfk paramsfk, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.aDQ)) {
      return;
    }
    VSUploadVideoEntry localVSUploadVideoEntry = sfk.a(this.this$0, this.aDQ);
    if (localVSUploadVideoEntry != null)
    {
      sfk.b(this.this$0, localVSUploadVideoEntry);
      sfk.a(this.this$0).delete(PublishVideoEntry.class.getSimpleName(), "fakeVid=?", new String[] { localVSUploadVideoEntry.fakeId });
      sfk.a(this.this$0).delete(VSUploadVideoEntry.class.getSimpleName(), "fakeId=?", new String[] { localVSUploadVideoEntry.fakeId });
      ram.i("Q.videostory.publish.upload.VSDbOperationHelper", "deleteUploadTask() delete task success => fakeId=" + this.aDQ);
    }
    for (;;)
    {
      sqn.a("mystatus_edit", "fail_dlt", 0, 0, new String[0]);
      return;
      ram.i("Q.videostory.publish.upload.VSDbOperationHelper", "deleteUploadTask() delete task not fail info => fakeId=" + this.aDQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSDbOperationHelper.7
 * JD-Core Version:    0.7.0.1
 */