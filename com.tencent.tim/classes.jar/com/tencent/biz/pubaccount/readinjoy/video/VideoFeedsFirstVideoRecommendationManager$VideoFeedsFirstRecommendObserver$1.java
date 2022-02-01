package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import kxv;
import mua;
import mua.a;
import mub;

public class VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1
  implements Runnable
{
  public VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1(mua.a parama, VideoInfo paramVideoInfo) {}
  
  public void run()
  {
    VideoPreDownloadMgr localVideoPreDownloadMgr = mua.a(this.a.a);
    if (localVideoPreDownloadMgr != null)
    {
      if (this.h.busiType != 1) {
        break label62;
      }
      if (!localVideoPreDownloadMgr.I(null, this.h.vid)) {
        localVideoPreDownloadMgr.d(null, this.h.vid, 0, this.h.duration);
      }
    }
    label62:
    while (this.h.busiType != 2) {
      return;
    }
    kxv.a().a(this.h.vid, "PubAccountArticleCenter.GetUrlByVid", new mub(this, localVideoPreDownloadMgr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1
 * JD-Core Version:    0.7.0.1
 */