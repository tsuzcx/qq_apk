package com.tencent.biz.subscribe.other.story;

import android.text.TextUtils;
import ram;
import sfk;
import sfp;
import sfq;

public class VSUploadVideoManager$4
  implements Runnable
{
  public VSUploadVideoManager$4(sfp paramsfp, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.aDQ)) {
      return;
    }
    ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "retryUploadVideoTask() hand retry publish => fakeId=" + this.aDQ);
    if ((this.this$0.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask != null) && (TextUtils.equals(this.this$0.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask.a.fakeId, this.aDQ)))
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "retryUploadVideoTask() hand retryTask is runningTask => fakeId=" + this.aDQ);
      return;
    }
    if (sfp.a(this.this$0, this.this$0.cF, this.aDQ) != null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "retryUploadVideoTask() hand retryTask already in waiting list => fakeId=" + this.aDQ);
      return;
    }
    if (sfp.a(this.this$0, this.this$0.nU, this.aDQ) != null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "retryUploadVideoTask() hand retryTask already in success list => fakeId=" + this.aDQ);
      return;
    }
    VSUploadVideoEntry localVSUploadVideoEntry = sfp.a(this.this$0, this.this$0.nV, this.aDQ);
    if (localVSUploadVideoEntry != null)
    {
      sfp.a(this.this$0, localVSUploadVideoEntry, this.aDQ);
      return;
    }
    if (this.this$0.jdField_a_of_type_Sfk == null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "retryUploadVideoTask() mDbHelper == null");
      return;
    }
    this.this$0.jdField_a_of_type_Sfk.a(this.aDQ, new sfq(this), this.this$0.mTaskHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSUploadVideoManager.4
 * JD-Core Version:    0.7.0.1
 */