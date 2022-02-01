package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kxm;
import lgo;
import lhf;
import lwg;

public class ArticleInfoModule$9
  implements Runnable
{
  public ArticleInfoModule$9(lhf paramlhf, long paramLong1, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, List paramList1, boolean paramBoolean2, long paramLong2, List paramList2, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    boolean bool3 = false;
    boolean bool1;
    Object localObject;
    if (this.up == -1L)
    {
      bool1 = true;
      this.this$0.a(Integer.valueOf(this.aHH), this.bl);
      this.this$0.rg(this.aHH);
      if (!this.val$success) {
        break label709;
      }
      localObject = (ConcurrentHashMap)lhf.b(this.this$0).get(Integer.valueOf(this.aHH));
      if (localObject != null) {
        break label821;
      }
      localObject = new ConcurrentHashMap();
    }
    label821:
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("\n");
      if (this.hR != null)
      {
        Iterator localIterator = this.hR.iterator();
        int i = 0;
        label119:
        if (localIterator.hasNext())
        {
          ArticleInfo localArticleInfo = (ArticleInfo)localIterator.next();
          localStringBuilder.append("article【" + i + "】 id : " + localArticleInfo.mArticleID + " seq : " + localArticleInfo.mRecommendSeq + " title : " + kxm.ev(localArticleInfo.mTitle) + " , groupID : " + localArticleInfo.mGroupId + " rowkey : " + localArticleInfo.innerUniqueID + ", mFeedType : " + localArticleInfo.mFeedType + " feeedCookie : " + localArticleInfo.mFeedCookie + ", mFeedID : " + localArticleInfo.mFeedId + " algorithmID : " + localArticleInfo.mAlgorithmID + " strategyId : " + localArticleInfo.mStrategyId + " businessID : " + localArticleInfo.businessId + " businessName :" + localArticleInfo.businessName + " commentShareUrl : " + localArticleInfo.commentShareUrl);
          SocializeFeedsInfo localSocializeFeedsInfo;
          if (localArticleInfo.mSocialFeedInfo != null)
          {
            localSocializeFeedsInfo = localArticleInfo.mSocialFeedInfo;
            if (QLog.isColorLevel())
            {
              localStringBuilder.append(" " + localSocializeFeedsInfo);
              localStringBuilder.append("\n");
            }
          }
          for (;;)
          {
            if ((kxm.x(localArticleInfo)) && (!((ConcurrentHashMap)localObject).containsKey(Long.valueOf(localArticleInfo.mRecommendSeq)))) {
              ((ConcurrentHashMap)localObject).put(Long.valueOf(localArticleInfo.mRecommendSeq), Boolean.valueOf(false));
            }
            i += 1;
            break label119;
            bool1 = false;
            break;
            localStringBuilder.append("SocialFeedInfo: mFeedId: " + localSocializeFeedsInfo.mFeedId + " mFeedStatus: " + localSocializeFeedsInfo.aSM + " mFollowStatus: " + localSocializeFeedsInfo.mFollowStatus);
            localStringBuilder.append("\n");
            continue;
            localStringBuilder.append("\n");
          }
        }
        if (((ConcurrentHashMap)localObject).size() > 0) {
          lhf.b(this.this$0).put(Integer.valueOf(this.aHH), localObject);
        }
      }
      localObject = new StringBuilder().append("handleRefreshChannel success=").append(this.val$success).append(" channelId=").append(this.aHH).append(" noMoreData=").append(this.akh).append(" beginRecommendSeq=").append(this.up).append(" endRecommendSeq=").append(this.uq).append(" isInMsgTab : ");
      boolean bool2 = bool3;
      if (this.this$0.mApp != null)
      {
        bool2 = bool3;
        if ((this.this$0.mApp instanceof QQAppInterface)) {
          bool2 = true;
        }
      }
      QLog.i("ArticleInfoModule", 1, bool2 + " isRefresh : " + bool1 + ", " + localStringBuilder.toString());
      lgo.cl(this.hR);
      label709:
      lwg.a().cI(this.hR);
      this.this$0.t(this.aHH, this.hR);
      if (bool1)
      {
        lhf.a(this.this$0, this.val$success, this.aHH, this.akh, this.hR, this.up, this.uq, this.hy, this.g);
        lhf.a(this.this$0, this.hR);
        return;
      }
      lhf.a(this.this$0, this.val$success, this.aHH, this.akh, this.hR, this.up, this.uq);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.9
 * JD-Core Version:    0.7.0.1
 */