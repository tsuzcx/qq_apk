package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;
import psa;
import psm;
import psx;
import psz;
import qrs;
import qru;
import qvf;
import qvi;
import ram;

public class DetailFeedAllInfoPuller$1
  implements Runnable
{
  public DetailFeedAllInfoPuller$1(qrs paramqrs) {}
  
  public void run()
  {
    boolean bool2 = false;
    Object localObject1 = (CommentLikeFeedItem)((qvf)psx.a(11)).a(qrs.a(this.this$0));
    if (localObject1 == null)
    {
      qrs.a(this.this$0, qrs.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
      return;
    }
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof VideoListFeedItem))
    {
      localObject2 = (VideoListFeedItem)localObject1;
      localObject3 = ((qvi)psx.a(12)).a(qrs.a(this.this$0), ((VideoListFeedItem)localObject2).mVideoPullType);
      if (localObject3 == null)
      {
        qrs.a(this.this$0, qrs.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
        return;
      }
      ((VideoListFeedItem)localObject2).mVideoNextCookie = ((FeedVideoInfo)localObject3).mVideoNextCookie;
      ((VideoListFeedItem)localObject2).mIsVideoEnd = ((FeedVideoInfo)localObject3).mIsVideoEnd;
      ((VideoListFeedItem)localObject2).mVideoPullType = ((FeedVideoInfo)localObject3).mVideoPullType;
      ((VideoListFeedItem)localObject2).mVideoSeq = ((FeedVideoInfo)localObject3).mVideoSeq;
      qrs.a(this.this$0).I(((FeedVideoInfo)localObject3).mVideoItemList, true);
      localObject2 = ((psz)psx.a(27)).c(qrs.a(this.this$0), ((FeedVideoInfo)localObject3).mVideoItemList);
      qrs.a(this.this$0).J((List)localObject2, true);
    }
    qrs.a(this.this$0).d = ((CommentLikeFeedItem)localObject1);
    if (this.this$0.aEX)
    {
      localObject2 = (psm)psx.a(15);
      localObject1 = ((psm)localObject2).c(qrs.a(this.this$0), qrs.a(this.this$0));
      qrs.a(this.this$0).e((List)localObject1, true, qrs.a(this.this$0));
      localObject1 = (psa)psx.a(17);
      localObject3 = ((psa)localObject1).a(qrs.a(this.this$0), qrs.a(this.this$0));
      qrs.a(this.this$0).d((List)localObject3, true, qrs.a(this.this$0));
      if (qrs.a(this.this$0).Kl())
      {
        localObject3 = qrs.a(this.this$0);
        if (qrs.a(this.this$0)) {
          break label510;
        }
        bool1 = true;
        localObject2 = ((psm)localObject2).c((String)localObject3, bool1);
        localObject3 = qrs.a(this.this$0);
        if (qrs.a(this.this$0)) {
          break label515;
        }
        bool1 = true;
        label401:
        ((qru)localObject3).e((List)localObject2, true, bool1);
        localObject2 = qrs.a(this.this$0);
        if (qrs.a(this.this$0)) {
          break label520;
        }
      }
    }
    label515:
    label520:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = ((psa)localObject1).a((String)localObject2, bool1);
      localObject2 = qrs.a(this.this$0);
      bool1 = bool2;
      if (!qrs.a(this.this$0)) {
        bool1 = true;
      }
      ((qru)localObject2).d((List)localObject1, true, bool1);
      ram.b("Q.qqstory.detail.DetailFeedAllInfoPuller", "load feed data from cache: %s.", qrs.a(this.this$0).toString());
      qrs.a(this.this$0, qrs.a(this.this$0), true, new ErrorMessage());
      return;
      label510:
      bool1 = false;
      break;
      bool1 = false;
      break label401;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.1
 * JD-Core Version:    0.7.0.1
 */