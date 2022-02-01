package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import psx;
import qvi;
import qvt;
import qwa;
import qwc;

public class HomeFeedPresenter$3
  implements Runnable
{
  public HomeFeedPresenter$3(qvt paramqvt, ArrayList paramArrayList) {}
  
  public void run()
  {
    qvi localqvi = (qvi)psx.a(12);
    Iterator localIterator = this.nm.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (qwa)localIterator.next();
      if ((localObject instanceof qwc))
      {
        localObject = (qwc)localObject;
        FeedVideoInfo localFeedVideoInfo = ((qwc)localObject).c().getVideoInfo();
        localFeedVideoInfo.mVideoItemList.addAll(((qwc)localObject).bS());
        localqvi.a(0, localFeedVideoInfo.feedId, localFeedVideoInfo.mVideoSeq, localFeedVideoInfo.mVideoItemList, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mIsVideoEnd, localFeedVideoInfo.mVideoPullType, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.3
 * JD-Core Version:    0.7.0.1
 */