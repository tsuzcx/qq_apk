package com.tencent.tim.mvp.cloudfile;

import ateh;
import auhl;
import com.tencent.cloudfile.CloudOnlineFileExt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class CloudFileTeamWorkCreatePresenter$1
  implements Runnable
{
  public CloudFileTeamWorkCreatePresenter$1(auhl paramauhl, String paramString) {}
  
  public void run()
  {
    ateh localateh = (ateh)auhl.a(this.this$0).getBusinessHandler(180);
    CloudOnlineFileExt localCloudOnlineFileExt = localateh.a(auhl.a(this.this$0), this.cIt);
    if (localCloudOnlineFileExt != null)
    {
      auhl.a(this.this$0, localateh.a(auhl.a(this.this$0), localCloudOnlineFileExt));
      return;
    }
    ThreadManager.getUIHandler().post(new CloudFileTeamWorkCreatePresenter.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mvp.cloudfile.CloudFileTeamWorkCreatePresenter.1
 * JD-Core Version:    0.7.0.1
 */