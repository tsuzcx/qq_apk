package com.tencent.tim.cloudfile.feeds;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.TimerTask;
import mqq.os.MqqHandler;

class CloudFileUploadingStatusBar$4
  extends TimerTask
{
  CloudFileUploadingStatusBar$4(CloudFileUploadingStatusBar paramCloudFileUploadingStatusBar) {}
  
  public void run()
  {
    CloudFileUploadingStatusBar.a(this.this$0, null);
    ThreadManager.getUIHandler().post(new CloudFileUploadingStatusBar.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar.4
 * JD-Core Version:    0.7.0.1
 */