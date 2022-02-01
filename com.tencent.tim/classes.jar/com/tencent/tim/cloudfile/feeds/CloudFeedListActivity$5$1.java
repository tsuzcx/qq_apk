package com.tencent.tim.cloudfile.feeds;

import atgc;
import atlk;
import auhh;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class CloudFeedListActivity$5$1
  implements Runnable
{
  public CloudFeedListActivity$5$1(atlk paramatlk, List paramList) {}
  
  public void run()
  {
    Object localObject = (atgc)this.a.a.app.getManager(373);
    if (localObject != null) {}
    for (localObject = ((atgc)localObject).aG();; localObject = null)
    {
      if ((CloudFeedListActivity.a(this.a.a) != null) && (this.qD != null) && (localObject != null)) {
        CloudFeedListActivity.a(this.a.a).a((byte[])localObject, this.qD, 1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.feeds.CloudFeedListActivity.5.1
 * JD-Core Version:    0.7.0.1
 */