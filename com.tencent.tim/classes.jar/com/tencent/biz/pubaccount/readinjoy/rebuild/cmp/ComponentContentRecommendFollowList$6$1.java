package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mbu;
import mhx;

public class ComponentContentRecommendFollowList$6$1
  implements Runnable
{
  public ComponentContentRecommendFollowList$6$1(mbu parammbu, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentRecommendFollowList", 2, "onUpdateAfterAccountFollow uin = " + this.val$uin + " isFollow = " + this.tT);
    }
    Iterator localIterator = ComponentContentRecommendFollowList.a(this.a.this$0).mRecommendFollowInfos.iM.iterator();
    while (localIterator.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
      if (this.val$uin == localRecommendFollowInfo.uin)
      {
        localRecommendFollowInfo.isFollowed = this.tT;
        this.a.this$0.a(localRecommendFollowInfo);
      }
    }
    ComponentContentRecommendFollowList.a(this.a.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList.6.1
 * JD-Core Version:    0.7.0.1
 */