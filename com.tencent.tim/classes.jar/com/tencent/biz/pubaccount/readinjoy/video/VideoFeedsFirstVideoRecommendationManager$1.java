package com.tencent.biz.pubaccount.readinjoy.video;

import awit;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import kbp;
import kxm;
import nce;
import nce.a;
import nss;

public final class VideoFeedsFirstVideoRecommendationManager$1
  implements Runnable
{
  public VideoFeedsFirstVideoRecommendationManager$1(nss paramnss) {}
  
  public void run()
  {
    int i = awit.Qi();
    if ((this.a instanceof VideoInfo))
    {
      localObject = (VideoInfo)this.a;
      if (i == 1) {
        kbp.a(null, "", "0X8009A23", "0X8009A23", 0, 0, "", "", "", kxm.a((VideoInfo)localObject, i), false);
      }
    }
    while (!(this.a instanceof VideoInfo.EntranceDownloadInfo))
    {
      return;
      kbp.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", kxm.a((VideoInfo)localObject, i), false);
      return;
    }
    Object localObject = (VideoInfo.EntranceDownloadInfo)this.a;
    nce.a locala = new nce.a("", "", "", "");
    locala.V(1).a(((VideoInfo.EntranceDownloadInfo)localObject).WT).a(0).U(i).T(ReadinjoyTabFrame.aYY);
    kbp.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", locala.a().toJsonString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.1
 * JD-Core Version:    0.7.0.1
 */