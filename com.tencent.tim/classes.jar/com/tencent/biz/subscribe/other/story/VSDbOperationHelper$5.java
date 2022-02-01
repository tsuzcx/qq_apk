package com.tencent.biz.subscribe.other.story;

import ram;
import sfk;

public class VSDbOperationHelper$5
  implements Runnable
{
  public VSDbOperationHelper$5(sfk paramsfk, VSUploadVideoEntry paramVSUploadVideoEntry) {}
  
  public void run()
  {
    if (this.b != null)
    {
      ram.i("Q.videostory.publish.upload.VSDbOperationHelper", "deleteLocalFileAfterComposite() fakeId:" + this.b.fakeId);
      sfk.a(this.this$0, this.b.originalEntry);
      this.this$0.a(this.b, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSDbOperationHelper.5
 * JD-Core Version:    0.7.0.1
 */