package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import mtg;

class VideoFeedsRecommendFragment$CheckAccountFollowedRunnable$1
  implements Runnable
{
  VideoFeedsRecommendFragment$CheckAccountFollowedRunnable$1(VideoFeedsRecommendFragment.CheckAccountFollowedRunnable paramCheckAccountFollowedRunnable, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = VideoFeedsRecommendFragment.a(this.a.this$0).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      boolean bool = i | VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.a(this.a, (VideoInfo)localObject, this.apH);
      i = bool;
      if (((VideoInfo)localObject).jT != null)
      {
        localObject = ((VideoInfo)localObject).jT.iterator();
        for (;;)
        {
          i = bool;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject).next();
          bool = VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.a(this.a, localVideoInfo, this.apH) | bool;
        }
      }
    }
    if ((i != 0) && (VideoFeedsRecommendFragment.a(this.a.this$0) != null)) {
      VideoFeedsRecommendFragment.a(this.a.this$0).nS(VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.a(this.a).hH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.1
 * JD-Core Version:    0.7.0.1
 */