package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import psa;
import psm;
import psx;
import qvf;
import ram;

public final class FeedManager$1
  implements Runnable
{
  public FeedManager$1(String paramString) {}
  
  public void run()
  {
    Object localObject = (psm)psx.a(15);
    ((psm)localObject).b(new ArrayList(0), this.dL, false, true);
    ((psm)localObject).b(new ArrayList(0), this.dL, true, true);
    localObject = (psa)psx.a(17);
    ((psa)localObject).a(new ArrayList(0), this.dL, false, true);
    ((psa)localObject).a(new ArrayList(0), this.dL, true, true);
    localObject = (qvf)psx.a(11);
    FeedItem localFeedItem = ((qvf)localObject).a(this.dL);
    if (localFeedItem != null)
    {
      localFeedItem.reset();
      ((qvf)localObject).a(localFeedItem);
    }
    ram.b("Q.qqstory.home.data.FeedManager", "clear all feed interactive data %s", this.dL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.1
 * JD-Core Version:    0.7.0.1
 */