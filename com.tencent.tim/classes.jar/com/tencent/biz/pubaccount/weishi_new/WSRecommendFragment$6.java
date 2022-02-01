package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.util.HashMap;
import java.util.Map;
import ond;
import opn;

class WSRecommendFragment$6
  implements Runnable
{
  WSRecommendFragment$6(WSRecommendFragment paramWSRecommendFragment, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed) {}
  
  public void run()
  {
    if (!WSRecommendFragment.a(this.this$0).containsKey(Integer.valueOf(this.val$position)))
    {
      WSRecommendFragment.a(this.this$0).put(Integer.valueOf(this.val$position), this.a.id);
      stReportItem localstReportItem = ond.a(this.a, this.val$position);
      if ((this.a.video_type != 1) && (this.a.video_type != 6)) {
        WSPublicAccReport.getInstance().feedsItemReport("gzh_exposure", opn.getSceneTypeTestId(1), this.a, localstReportItem, 0);
      }
      WSRecommendFragment.a(this.this$0).put(Integer.valueOf(this.val$position), this.a);
      WSRecommendFragment.b(this.this$0).put(Integer.valueOf(this.val$position), this.a.id);
      if (WSRecommendFragment.a(this.this$0).size() == 8)
      {
        WSRecommendFragment.a(this.this$0, WSRecommendFragment.a(this.this$0), WSRecommendFragment.b(this.this$0));
        WSRecommendFragment.a(this.this$0).clear();
        WSRecommendFragment.b(this.this$0).clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment.6
 * JD-Core Version:    0.7.0.1
 */