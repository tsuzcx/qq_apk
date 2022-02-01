import android.content.Context;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class pqo
  extends prh
{
  pqo(pqn parampqn) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    label672:
    label812:
    Object localObject2;
    label1158:
    List localList;
    Object localObject4;
    Object localObject3;
    switch (paramView.getId())
    {
    default: 
    case 2131371886: 
    case 2131371884: 
    case 2131375150: 
    case 2131365002: 
    case 2131371887: 
      int i;
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!aqiw.isNetSupport(this.a.mContext))
        {
          QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706129), 0).show();
        }
        else
        {
          if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
          {
            if (qow.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
              QQToast.a(this.a.mContext, 1, acfp.m(2131706149), 1).show();
            }
          }
          else if ((this.a.jdField_a_of_type_Qux != null) && (qow.Ke()))
          {
            i = this.a.jdField_a_of_type_Qux.a().type;
            if ((i == 3) || (i == 5))
            {
              QQToast.a(this.a.mContext, 1, acfp.m(2131706120), 1).show();
              continue;
            }
          }
          this.a.bmr();
          continue;
          if (!aqiw.isNetSupport(this.a.mContext))
          {
            QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706143), 0).show();
          }
          else if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
          {
            QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706127), 0).show();
          }
          else
          {
            if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
            {
              if (qow.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
                QQToast.a(this.a.mContext, 1, acfp.m(2131706134), 1).show();
              }
            }
            else if ((this.a.jdField_a_of_type_Qux != null) && (qow.Ke()))
            {
              i = this.a.jdField_a_of_type_Qux.a().type;
              if ((i == 3) || (i == 5))
              {
                QQToast.a(this.a.mContext, 1, acfp.m(2131706144), 1).show();
                continue;
              }
            }
            i = rar.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
            if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
            for (localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; localObject1 = "")
            {
              rar.a("home_page", "clk_reply", rar.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), rar.bX(this.a.mFeedType), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject1 });
              if (this.a.jdField_a_of_type_Pqh$b == null) {
                break;
              }
              localObject1 = (pqj)this.a.a("commentLego");
              this.a.jdField_a_of_type_Pqh$b.a((pqj)localObject1, paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
              break;
            }
            if (pqn.a(this.a) != null)
            {
              if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem))
              {
                localObject1 = (QQUserUIItem)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
                pqn.a(this.a).a(Long.parseLong(((QQUserUIItem)localObject1).qq), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
              }
            }
            else
            {
              i = rar.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
              if (!(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
                break label812;
              }
            }
            for (localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; localObject1 = "")
            {
              rar.a("home_page", "clk_play", rar.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), rar.bX(this.a.mFeedType), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject1 });
              break;
              pqn.a(this.a).a(0L, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
              break label672;
            }
            if (this.a.mFeedType == 11) {
              i = 211;
            }
            for (;;)
            {
              StoryDetailActivity.a(this.a.mActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, i, 0);
              rar.a("home_page", "clk_reply_mini", rar.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(rar.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem)), rar.bX(this.a.mFeedType), "", this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
              break;
              if (this.a.mFeedType == 12) {
                i = 222;
              } else {
                i = 210;
              }
            }
            if (!aqiw.isNetSupport(this.a.mContext))
            {
              QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706128), 0).show();
            }
            else if (!rpq.isFastDoubleClick())
            {
              if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
              for (localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; localObject1 = "")
              {
                rar.a("home_page", "clk_share", rar.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { rar.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem) + "", rar.bX(this.a.mFeedType), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject1 });
                if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() != null)) {
                  break label1158;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("FeedCommentLikeLego", 2, "can't share, commentLikeFeedItem not ready");
                break;
              }
              if (this.a.jdField_a_of_type_Quw == null) {
                break;
              }
              if (pqn.a(this.a) == null) {
                pqn.a(this.a, qbc.a(this.a.mActivity));
              }
              pqn.a(this.a).a(this.a.mContext.getString(2131720177)).a(new pqp(this)).a(new qcb((BannerFeedItem)this.a.jdField_a_of_type_Quw.a())).b();
            }
          }
        }
      }
      localObject2 = null;
      localObject1 = null;
      localList = this.a.jdField_a_of_type_Qux.bS();
      if (!localList.isEmpty())
      {
        Iterator localIterator = localList.iterator();
        label1409:
        label1426:
        label1441:
        label1448:
        if (localIterator.hasNext())
        {
          localObject4 = (StoryVideoItem)localIterator.next();
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject4).mVid)) {
            break label1986;
          }
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            if (!roq.ba(((StoryVideoItem)localObject4).mCreateTime)) {
              break label1448;
            }
            i = localList.size() - 1;
            label1359:
            if (i < 0) {
              break label1983;
            }
            localObject3 = (StoryVideoItem)localList.get(i);
            if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject3).mVid)) {
              break label1441;
            }
            localObject1 = localObject3;
          }
          label1391:
          for (localObject3 = localObject1;; localObject3 = localObject4)
          {
            if (localObject2 != null) {
              break label1976;
            }
            localObject1 = new ArrayList();
            ((List)localObject1).add(((StoryVideoItem)localObject4).mVid);
            localObject2 = localObject3;
            localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break;
            i -= 1;
            break label1359;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FeedCommentLikeLego", 2, "can't share, video list empty");
        }
        QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706157), 0).show();
        break;
      }
      if (localObject1 == null) {
        break;
      }
      boolean bool1 = StoryVideoItem.hasPollVideo(localList);
      boolean bool2 = StoryVideoItem.hasInteractVideo(localList);
      boolean bool3 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe();
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.allowStrangerVisitAndPost == 1))
      {
        if (pqn.a(this.a) == null) {
          pqn.a(this.a, qbc.a(this.a.mActivity));
        }
        localObject4 = pqn.a(this.a);
        if (bool3)
        {
          localObject3 = acfp.m(2131706154);
          label1605:
          localObject2 = ((qbc)localObject4).a((String)localObject3).a(new pqq(this)).a(qcf.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem, (StoryVideoItem)localObject1, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, ((StoryVideoItem)localObject1).mCreateTime, ((List)localObject2).size()));
          if (!bool1) {
            break label1755;
          }
          localObject1 = "1";
          label1671:
          localObject2 = ((qbc)localObject2).a("vote", (String)localObject1);
          if (!bool2) {
            break label1763;
          }
        }
        label1755:
        label1763:
        for (localObject1 = "1";; localObject1 = "0")
        {
          ((qbc)localObject2).a("grade", (String)localObject1).b();
          rar.a("share_story", "share_day", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
          break;
          localObject3 = this.a.mContext.getString(2131720177);
          break label1605;
          localObject1 = "0";
          break label1671;
        }
      }
      if (pqn.a(this.a) == null) {
        pqn.a(this.a, qbc.a(this.a.mActivity));
      }
      localObject4 = pqn.a(this.a);
      if (bool3)
      {
        localObject3 = acfp.m(2131706138);
        label1821:
        localObject2 = ((qbc)localObject4).a((String)localObject3).a(new pqr(this)).a(new qcc((StoryVideoItem)localObject1, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, ((List)localObject2).size()));
        if (!bool1) {
          break label1935;
        }
        localObject1 = "1";
        label1879:
        localObject2 = ((qbc)localObject2).a("vote", (String)localObject1);
        if (!bool2) {
          break label1943;
        }
      }
      label1935:
      label1943:
      for (localObject1 = "1";; localObject1 = "0")
      {
        ((qbc)localObject2).a("grade", (String)localObject1).b();
        break;
        localObject3 = this.a.mContext.getString(2131720177);
        break label1821;
        localObject1 = "0";
        break label1879;
      }
      QQStoryWatcherListActivity.i(this.a.mActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 10);
      break;
      label1976:
      localObject1 = localObject2;
      break label1409;
      label1983:
      break label1391;
      label1986:
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label1426;
      localObject2 = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqo
 * JD-Core Version:    0.7.0.1
 */