package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import naf;

class VideoFollowManager$CheckAccountFollowedRunnable$1
  implements Runnable
{
  VideoFollowManager$CheckAccountFollowedRunnable$1(VideoFollowManager.CheckAccountFollowedRunnable paramCheckAccountFollowedRunnable, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = VideoFollowManager.a(this.a.this$0).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      boolean bool = i | VideoFollowManager.CheckAccountFollowedRunnable.a(this.a, (VideoInfo)localObject, this.apH);
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
          bool = VideoFollowManager.CheckAccountFollowedRunnable.a(this.a, localVideoInfo, this.apH) | bool;
        }
      }
    }
    if ((i != 0) && (VideoFollowManager.a(this.a.this$0) != null)) {
      VideoFollowManager.a(this.a.this$0).nS(VideoFollowManager.CheckAccountFollowedRunnable.a(this.a).hH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFollowManager.CheckAccountFollowedRunnable.1
 * JD-Core Version:    0.7.0.1
 */