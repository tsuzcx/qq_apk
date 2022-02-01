package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import lhf;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.FeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;

public class ArticleInfoModule$39
  implements Runnable
{
  public ArticleInfoModule$39(lhf paramlhf, List paramList, ConcurrentHashMap paramConcurrentHashMap, boolean paramBoolean) {}
  
  public void run()
  {
    EntityTransaction localEntityTransaction = this.this$0.mEntityManager.getTransaction();
    localEntityTransaction.begin();
    Iterator localIterator = this.hD.iterator();
    int i = 0;
    int j;
    Object localObject2;
    long l;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label679;
      }
      oidb_cmd0x8c8.FeedsInfo localFeedsInfo = (oidb_cmd0x8c8.FeedsInfo)localIterator.next();
      j = i;
      try
      {
        if (localFeedsInfo.has())
        {
          j = i;
          if (localFeedsInfo.get() != null)
          {
            j = i;
            if (localFeedsInfo.msg_social_fees_info.has())
            {
              j = i;
              if (localFeedsInfo.msg_social_fees_info.get() != null)
              {
                localObject2 = (oidb_cmd0x8c8.SocializeFeedsInfo)localFeedsInfo.msg_social_fees_info.get();
                if (((oidb_cmd0x8c8.SocializeFeedsInfo)localObject2).uint64_feeds_id.has())
                {
                  l = ((oidb_cmd0x8c8.SocializeFeedsInfo)localObject2).uint64_feeds_id.get();
                  label132:
                  if (l != 0L) {
                    break label171;
                  }
                  QLog.d("ArticleInfoModule", 1, "convertPBToInfo failed feedsInfo feedsId == 0");
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d("ArticleInfoModule", 1, "handle0x8c8UpdateUpvoteAndComment merge failed ", localException);
      }
    }
    for (;;)
    {
      break;
      l = 0L;
      break label132;
      label171:
      if (!localException.feeds_type.has())
      {
        QLog.d("ArticleInfoModule", 1, "convertPBToInfo failed feedsInfo feeds_type == null");
        break;
      }
      j = localException.feeds_type.get();
      Object localObject1 = l + "" + j;
      QLog.d("ArticleInfoModule", 1, new Object[] { "handle 8c8, feedsId = ", Long.valueOf(l), ", feedsType = ", Integer.valueOf(j) });
      ArticleInfo localArticleInfo = (ArticleInfo)this.bi.get((String)localObject1 + 0);
      if (localArticleInfo != null) {
        lhf.a(this.this$0, localArticleInfo, (oidb_cmd0x8c8.SocializeFeedsInfo)localObject2, 0);
      }
      localArticleInfo = (ArticleInfo)this.bi.get((String)localObject1 + 70);
      if (localArticleInfo != null) {
        lhf.a(this.this$0, localArticleInfo, (oidb_cmd0x8c8.SocializeFeedsInfo)localObject2, 70);
      }
      localObject1 = (ArticleInfo)this.bi.get((String)localObject1 + 41403);
      if (localObject1 != null) {
        lhf.a(this.this$0, (ArticleInfo)localObject1, (oidb_cmd0x8c8.SocializeFeedsInfo)localObject2, 41403);
      }
      if ((this.akf) && (localObject1 != null) && (((ArticleInfo)localObject1).mSocialFeedInfo != null) && (((ArticleInfo)localObject1).publishUin != 0L))
      {
        localObject2 = "publishUin = " + ((ArticleInfo)localObject1).publishUin;
        localObject2 = this.this$0.mEntityManager.query(ArticleInfo.class, true, (String)localObject2, null, null, null, "mRecommendSeq desc", null);
        if (localObject2 == null)
        {
          QLog.d("ArticleInfoModule", 1, "no soical feeds to update article.publishUin:" + ((ArticleInfo)localObject1).publishUin);
          break;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localArticleInfo = (ArticleInfo)((Iterator)localObject2).next();
          if ((localArticleInfo.mFeedId != ((ArticleInfo)localObject1).mFeedId) && (localArticleInfo.mSocialFeedInfo != null))
          {
            int k = 0;
            j = k;
            if (localArticleInfo.mSocialFeedInfo.mFollowStatus != 2)
            {
              j = k;
              if (((ArticleInfo)localObject1).mSocialFeedInfo.mFollowStatus == 2) {
                j = 1;
              }
            }
            localArticleInfo.mSocialFeedInfo.mFollowStatus = ((ArticleInfo)localObject1).mSocialFeedInfo.mFollowStatus;
            this.this$0.a(localArticleInfo);
            localArticleInfo = this.this$0.a(localArticleInfo, (int)localArticleInfo.mChannelID);
            if ((j != 0) && (localArticleInfo != null)) {
              localArticleInfo.isNeedShowBtnWhenFollowed = true;
            }
          }
        }
      }
      j = 1;
      i = j;
    }
    label679:
    if ((i != 0) && (this.this$0.mMainThreadHandler != null)) {
      this.this$0.mMainThreadHandler.post(new ArticleInfoModule.39.1(this));
    }
    localEntityTransaction.commit();
    localEntityTransaction.end();
    this.this$0.aMl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.39
 * JD-Core Version:    0.7.0.1
 */