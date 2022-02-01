package com.tencent.biz.subscribe.other.story;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import ram;
import sfd;

public abstract class BaseUploadVideoFeedTask
  implements Runnable
{
  public VSUploadVideoEntry a;
  protected sfd a;
  public String aDN;
  public AtomicBoolean aI = new AtomicBoolean(false);
  protected Handler mTaskHandler;
  
  public BaseUploadVideoFeedTask(VSUploadVideoEntry paramVSUploadVideoEntry)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry = paramVSUploadVideoEntry;
  }
  
  public void a(sfd paramsfd, Handler paramHandler)
  {
    this.jdField_a_of_type_Sfd = paramsfd;
    this.mTaskHandler = paramHandler;
  }
  
  public void bme()
  {
    ram.w("Q.videostory.publish.upload.BaseUploadVideoFeedTask", "cancelTask() try to stop task ==> fakeId=" + this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId);
    this.aI.set(true);
    if (this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.uploadStatus == 5) {
      new Bundle().putString("fakeId", this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId);
    }
    VSNetworkHelper.a().cK(null);
  }
  
  protected abstract void h(String paramString, Bundle paramBundle);
  
  public boolean isStop()
  {
    return this.aI.get();
  }
  
  public void run()
  {
    startTask();
  }
  
  protected abstract void startTask();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.BaseUploadVideoFeedTask
 * JD-Core Version:    0.7.0.1
 */