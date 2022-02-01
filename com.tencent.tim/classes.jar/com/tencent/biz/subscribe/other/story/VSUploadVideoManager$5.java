package com.tencent.biz.subscribe.other.story;

import android.text.TextUtils;
import ram;
import sfk;
import sfp;
import sfr;
import sqn;

public class VSUploadVideoManager$5
  implements Runnable
{
  public void run()
  {
    if (TextUtils.isEmpty(this.aDQ)) {
      return;
    }
    if ((this.this$0.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask != null) && (TextUtils.equals(this.this$0.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask.a.fakeId, this.aDQ)))
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "autoRetryUploadVideoTask() Auto retryTask is runningTask => fakeId=" + this.aDQ);
      return;
    }
    if (sfp.a(this.this$0, this.this$0.cF, this.aDQ) != null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "autoRetryUploadVideoTask() Auto retryTask already in waiting list => fakeId=" + this.aDQ);
      return;
    }
    if (sfp.a(this.this$0, this.this$0.nU, this.aDQ) != null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "autoRetryUploadVideoTask() Auto retryTask already in success list => fakeId=" + this.aDQ);
      return;
    }
    if (sfp.a(this.this$0, this.this$0.nV, this.aDQ) != null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "autoRetryUploadVideoTask() Auto retryTask already in fail list => fakeId=" + this.aDQ);
      return;
    }
    if (this.this$0.jdField_a_of_type_Sfk == null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "autoRetryUploadVideoTask() mDbHelper == null");
      return;
    }
    sqn.n("upload_publishing_retry", null);
    this.this$0.jdField_a_of_type_Sfk.a(this.aDQ, new sfr(this), this.this$0.mTaskHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSUploadVideoManager.5
 * JD-Core Version:    0.7.0.1
 */