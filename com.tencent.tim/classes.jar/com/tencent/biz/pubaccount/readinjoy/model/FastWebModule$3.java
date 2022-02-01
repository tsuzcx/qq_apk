package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kxm;
import lhu;
import lhu.c;

public class FastWebModule$3
  implements Runnable
{
  public FastWebModule$3(lhu paramlhu, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.hR.size())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.hR.get(i);
      if ((kxm.j(localArticleInfo)) || ((localArticleInfo instanceof AdvertisementInfo))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localArticleInfo != null) && (!TextUtils.isEmpty(localArticleInfo.mArticleContentUrl)) && (localArticleInfo.mArticleContentUrl.startsWith("http")) && (kxm.a(localArticleInfo.mArticleContentUrl, localArticleInfo.mChannelID, localArticleInfo)))
        {
          lhu.c localc = (lhu.c)lhu.a(this.this$0).get(localArticleInfo.mChannelID + "_" + localArticleInfo.mArticleID);
          if ((localc == null) || (localc.Cl())) {
            this.this$0.a(localArticleInfo.mArticleContentUrl, localArticleInfo.innerUniqueID, localArticleInfo.mSubscribeID, 3, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.3
 * JD-Core Version:    0.7.0.1
 */