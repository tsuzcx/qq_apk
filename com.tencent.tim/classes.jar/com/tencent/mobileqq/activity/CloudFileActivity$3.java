package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import urk;

public class CloudFileActivity$3
  implements Runnable
{
  CloudFileActivity$3(CloudFileActivity paramCloudFileActivity) {}
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.this$0.app.getManager(13);
    if ((localWebProcessManager != null) && (localWebProcessManager.aFT())) {
      localWebProcessManager.a(-1, new urk(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.CloudFileActivity.3
 * JD-Core Version:    0.7.0.1
 */