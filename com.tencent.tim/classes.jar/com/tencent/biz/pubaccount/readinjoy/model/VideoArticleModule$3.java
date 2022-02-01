package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kxm;
import ljd;
import min;

public class VideoArticleModule$3
  implements Runnable
{
  public VideoArticleModule$3(ljd paramljd, long paramLong1, boolean paramBoolean1, List paramList, int paramInt, boolean paramBoolean2, long paramLong2, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    boolean bool;
    StringBuilder localStringBuilder1;
    label63:
    WeiShiVideoArticleInfo localWeiShiVideoArticleInfo;
    String str;
    if (this.up == -1L)
    {
      bool = true;
      if (!this.val$success) {
        break label374;
      }
      localStringBuilder1 = new StringBuilder("\n");
      if ((this.hR == null) || (this.hR.size() <= 0)) {
        break label275;
      }
      Iterator localIterator = this.hR.iterator();
      int i = 0;
      if (!localIterator.hasNext()) {
        break label275;
      }
      localWeiShiVideoArticleInfo = (WeiShiVideoArticleInfo)localIterator.next();
      if (localWeiShiVideoArticleInfo == null) {
        break label446;
      }
      StringBuilder localStringBuilder2 = new StringBuilder().append("article【").append(i).append("】 id : ").append(localWeiShiVideoArticleInfo.articleID).append(" seq : ").append(localWeiShiVideoArticleInfo.recommendSeq).append(" title : ").append(kxm.ev(localWeiShiVideoArticleInfo.title)).append(" rowkey : ").append(localWeiShiVideoArticleInfo.rowkey).append(" isUgc : ").append(localWeiShiVideoArticleInfo.isUgc).append(" vid : ");
      if (localWeiShiVideoArticleInfo.videoData != null) {
        break label263;
      }
      str = "";
      label192:
      localStringBuilder1.append(str + " feedsType : " + localWeiShiVideoArticleInfo.feedsType + " algorithmID : " + localWeiShiVideoArticleInfo.algorithmID + " strategyId : " + localWeiShiVideoArticleInfo.strategyID + " \n");
      i += 1;
    }
    label263:
    label275:
    label446:
    for (;;)
    {
      break label63;
      bool = false;
      break;
      str = localWeiShiVideoArticleInfo.videoData.vid;
      break label192;
      QLog.i(ljd.TAG, 1, "onGetChannelArticleList success=" + this.val$success + " channelId=" + this.aHH + " noMoreData=" + this.akh + " beginRecommendSeq=" + this.up + " endRecommendSeq=" + this.uD + " isRefresh : " + bool + ", " + localStringBuilder1.toString());
      label374:
      if (bool)
      {
        ljd.a(this.this$0, this.val$success, this.aHH, this.akh, this.hR, this.up, this.uD, this.g);
        return;
      }
      ljd.a(this.this$0, this.val$success, this.aHH, this.akh, this.hR, this.up, this.uD);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.VideoArticleModule.3
 * JD-Core Version:    0.7.0.1
 */