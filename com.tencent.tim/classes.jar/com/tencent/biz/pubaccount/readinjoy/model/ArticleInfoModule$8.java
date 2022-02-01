package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kxm;
import lcc;
import lhf;

public class ArticleInfoModule$8
  implements Runnable
{
  public ArticleInfoModule$8(lhf paramlhf, boolean paramBoolean1, List paramList1, List paramList2, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.val$success)
    {
      if ((this.hQ == null) || (this.hQ.size() != 1) || (this.hR == null) || (this.hR.isEmpty())) {
        if (QLog.isColorLevel()) {
          QLog.e("ArticleInfoModule", 2, "###onGetVideoRealtimeReplaceList: reqArticleList  szie != 1 or articleInfoList is empty.");
        }
      }
      long l2;
      Object localObject1;
      do
      {
        StringBuilder localStringBuilder;
        Object localObject2;
        long l1;
        Object localObject3;
        do
        {
          do
          {
            do
            {
              return;
              l2 = ((Long)this.hQ.get(0)).longValue();
              localStringBuilder = new StringBuilder("\n");
              localObject1 = this.hR.iterator();
              i = 0;
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ArticleInfo)((Iterator)localObject1).next();
                localStringBuilder.append("实时替换 article【" + i + "】 id : " + ((ArticleInfo)localObject2).mArticleID + " seq : " + ((ArticleInfo)localObject2).mRecommendSeq + " title : " + kxm.ev(((ArticleInfo)localObject2).mTitle) + " , groupID : " + ((ArticleInfo)localObject2).mGroupId + " algorithmID : " + ((ArticleInfo)localObject2).mAlgorithmID + " strategyId : " + ((ArticleInfo)localObject2).mStrategyId + " feedType: " + ((ArticleInfo)localObject2).mFeedType);
                if (QLog.isColorLevel()) {
                  if (((ArticleInfo)localObject2).mSocialFeedInfo != null)
                  {
                    localStringBuilder.append(" " + ((ArticleInfo)localObject2).mSocialFeedInfo);
                    localStringBuilder.append("\n");
                  }
                }
                for (;;)
                {
                  i += 1;
                  break;
                  localStringBuilder.append("\n");
                  continue;
                  localStringBuilder.append("\n");
                }
              }
              QLog.i("ArticleInfoModule", 1, "###onGetVideoRealtimeReplaceList success=" + this.val$success + " channelId=" + this.aHH + ", reqArticleID: " + l2 + localStringBuilder.toString());
              localObject1 = this.this$0.c(Integer.valueOf(this.aHH));
              if (localObject1 != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.i("ArticleInfoModule", 1, "###onGetVideoRealtimeReplaceList fail, for currentSeqList is null, channelId=" + this.aHH);
            return;
            localObject2 = ((List)localObject1).iterator();
            l1 = -1L;
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (Long)((Iterator)localObject2).next();
              ArticleInfo localArticleInfo = this.this$0.a(Integer.valueOf(this.aHH), (Long)localObject3);
              if (l2 == localArticleInfo.mArticleID)
              {
                l1 = ((Long)localObject3).longValue();
                QLog.i("ArticleInfoModule", 1, "###onGetVideoRealtimeReplaceList find the original article seq：" + localObject3 + ", reqArticleID: " + l2 + ", title : " + kxm.ev(localArticleInfo.mTitle));
              }
            }
          } while (l1 == -1L);
          if (QLog.isColorLevel())
          {
            localStringBuilder.setLength(0);
            localStringBuilder.append("current seq list >>").append("\n");
            i = 0;
            while (i < ((List)localObject1).size())
            {
              localObject2 = this.this$0.a(Integer.valueOf(this.aHH), (Long)((List)localObject1).get(i));
              localStringBuilder.append("article [" + i + "] seq : " + ((List)localObject1).get(i) + ", id : " + ((ArticleInfo)localObject2).mArticleID + " title : " + kxm.ev(((ArticleInfo)localObject2).mTitle));
              localStringBuilder.append("\n");
              i += 1;
            }
            QLog.d("ArticleInfoModule", 2, localStringBuilder.toString());
          }
          localObject2 = (ConcurrentHashMap)lhf.a(this.this$0).get(Integer.valueOf(this.aHH));
        } while (localObject2 == null);
        int k = ((List)localObject1).size();
        int j = this.hR.size();
        int i = 0;
        boolean bool;
        while (i < k)
        {
          long l3 = ((Long)((List)localObject1).get(i)).longValue();
          if (((0xFFFFFF00 & l1) == (0xFFFFFF00 & l3)) && (l3 >= l1))
          {
            localObject3 = this.this$0.a(Integer.valueOf(this.aHH), Long.valueOf(l3));
            ((ArticleInfo)localObject3).mRecommendSeq = (j + l3);
            ((ConcurrentHashMap)localObject2).remove(Long.valueOf(l3));
            bool = this.this$0.e(Long.valueOf(((ArticleInfo)localObject3).mArticleID));
            lhf.a(this.this$0, Integer.valueOf(this.aHH), (ArticleInfo)localObject3, true, bool);
          }
          i += 1;
        }
        i = j - 1;
        while (i >= 0)
        {
          localObject1 = (ArticleInfo)this.hR.get(i);
          ((ArticleInfo)localObject1).mRecommendSeq = (j + l1 - 1L - i);
          bool = this.this$0.e(Long.valueOf(((ArticleInfo)localObject1).mArticleID));
          lhf.a(this.this$0, Integer.valueOf(this.aHH), (ArticleInfo)localObject1, true, bool);
          i -= 1;
        }
        localObject1 = this.this$0.c(Integer.valueOf(this.aHH));
        if (QLog.isColorLevel())
        {
          localStringBuilder.setLength(0);
          localStringBuilder.append("new seq list >>").append("\n");
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject2 = this.this$0.a(Integer.valueOf(this.aHH), (Long)((List)localObject1).get(i));
            localStringBuilder.append("article [" + i + "] seq : " + ((List)localObject1).get(i) + ", id : " + ((ArticleInfo)localObject2).mArticleID + " title : " + kxm.ev(((ArticleInfo)localObject2).mTitle));
            localStringBuilder.append("\n");
            i += 1;
          }
          QLog.d("ArticleInfoModule", 2, localStringBuilder.toString());
        }
      } while (!this.akg);
      lcc.a().a(this.val$success, this.aHH, l2, (List)localObject1, this.hR);
      return;
    }
    QLog.e("ArticleInfoModule", 1, "###onGetVideoRealtimeReplaceList failure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.8
 * JD-Core Version:    0.7.0.1
 */