package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.util.HashMap;
import java.util.List;
import oiu;
import ooz;
import opn;

class WSRecommendFragment$7
  implements Runnable
{
  WSRecommendFragment$7(WSRecommendFragment paramWSRecommendFragment, int paramInt, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    int i = 0;
    while (i < this.beR)
    {
      if (i < this.kY.size())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.kY.get(i);
        if (!WSRecommendFragment.a(this.this$0).containsKey(Integer.valueOf(i)))
        {
          WSRecommendFragment.a(this.this$0).put(Integer.valueOf(i), localstSimpleMetaFeed.id);
          ooz.d("weishi-report", "put:" + i);
          localHashMap1.put(Integer.valueOf(i), localstSimpleMetaFeed);
          localHashMap2.put(Integer.valueOf(i), localstSimpleMetaFeed.id);
        }
        if (this.awW) {
          oiu.l(1, opn.a(localstSimpleMetaFeed, true));
        }
      }
      i += 1;
    }
    WSRecommendFragment.a(this.this$0, localHashMap1, localHashMap2);
    WSPublicAccReport.getInstance().reportFallList(localHashMap1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment.7
 * JD-Core Version:    0.7.0.1
 */