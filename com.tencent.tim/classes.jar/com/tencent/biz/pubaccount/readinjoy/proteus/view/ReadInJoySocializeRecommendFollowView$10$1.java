package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import lsf;
import lsf.b;
import lsh;
import mhx;

public class ReadInJoySocializeRecommendFollowView$10$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$10$1(lsh paramlsh, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "onUpdateAfterAccountFollow uin = " + this.val$uin + " isFollow = " + this.tT);
    }
    if ((lsf.a(this.a.this$0) != null) && (this.val$uin == lsf.a(this.a.this$0).mSocialFeedInfo.a.uin) && (!this.tT) && (lsf.a(this.a.this$0).isShowRecommendList))
    {
      lsf.a(this.a.this$0, false);
      lsf.a(this.a.this$0).isShowRecommendList = false;
    }
    if ((lsf.a(this.a.this$0) != null) && (lsf.a(this.a.this$0).mRecommendFollowInfos != null) && (lsf.a(this.a.this$0).mRecommendFollowInfos.iM != null))
    {
      Iterator localIterator = lsf.a(this.a.this$0).mRecommendFollowInfos.iM.iterator();
      while (localIterator.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
        if (this.val$uin == localRecommendFollowInfo.uin)
        {
          localRecommendFollowInfo.isFollowed = this.tT;
          lsf.a(this.a.this$0, localRecommendFollowInfo);
        }
      }
      lsf.a(this.a.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.10.1
 * JD-Core Version:    0.7.0.1
 */