package com.tencent.tim.cloudfile.feeds;

import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;

class CloudFileUploadingStatusBar$4$1
  implements Runnable
{
  CloudFileUploadingStatusBar$4$1(CloudFileUploadingStatusBar.4 param4) {}
  
  public void run()
  {
    QLog.d("CloudFileUploadingStatusBar", 1, "showCompletedState updateView");
    CloudFileUploadingStatusBar.die = false;
    CloudFileUploadingStatusBar.a(this.a.this$0);
    CloudFileUploadingStatusBar.a(this.a.this$0, null);
    CloudFileUploadingStatusBar.a(this.a.this$0).setImageDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar.4.1
 * JD-Core Version:    0.7.0.1
 */