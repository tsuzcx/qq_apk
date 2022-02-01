package com.tencent.biz.pubaccount.readinjoy.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import kmw;
import mtg;
import mtg.e;
import mvy;

public class VideoFeedsRecommendFragment$1$1
  implements Runnable
{
  public VideoFeedsRecommendFragment$1$1(mvy parammvy, int paramInt) {}
  
  public void run()
  {
    if (VideoFeedsRecommendFragment.a(this.a.this$0).getScrollState() != 0) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (LinearLayoutManager)VideoFeedsRecommendFragment.a(this.a.this$0).getLayoutManager();
      int i = ((LinearLayoutManager)localObject1).findFirstVisibleItemPosition();
      int j = ((LinearLayoutManager)localObject1).findLastVisibleItemPosition();
      localObject1 = null;
      if (i < j)
      {
        Object localObject2 = VideoFeedsRecommendFragment.a(this.a.this$0).getLayoutManager().findViewByPosition(i);
        if (localObject2 == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = VideoFeedsRecommendFragment.a(this.a.this$0).getChildViewHolder((View)localObject2);
          if (i == this.aVp) {
            localObject1 = localObject2;
          }
          if (localObject2 != null) {
            if ((localObject2 instanceof mtg.e))
            {
              localObject2 = ((mtg.e)localObject2).a;
              if (localObject2 != null) {
                ((VideoFeedsAlphaMaskView)localObject2).setAlpha(0.0F);
              }
            }
          }
        }
      }
    } while ((VideoFeedsRecommendFragment.a(this.a.this$0) == null) || (VideoFeedsRecommendFragment.a(this.a.this$0).isPlaying()) || (localObject1 == null));
    VideoFeedsRecommendFragment.a(this.a.this$0).onPagerChanged((RecyclerView.ViewHolder)localObject1);
    kmw.a(this.a.this$0.getActivity(), VideoFeedsRecommendFragment.a(this.a.this$0));
    kmw.b(this.a.this$0.getActivity(), VideoFeedsRecommendFragment.a(this.a.this$0));
    VideoFeedsRecommendFragment.a(this.a.this$0).aRW();
    VideoFeedsRecommendFragment.a(this.a.this$0).restart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.1.1
 * JD-Core Version:    0.7.0.1
 */