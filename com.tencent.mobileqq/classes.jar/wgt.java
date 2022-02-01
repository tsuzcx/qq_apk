import android.content.Context;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class wgt
  extends whr
{
  wgt(wgs paramwgs) {}
  
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
    case 2131371500: 
    case 2131371498: 
    case 2131374614: 
    case 2131364925: 
    case 2131371501: 
      int i;
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!NetworkUtil.isNetSupport(this.a.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131703879), 0).a();
        }
        else
        {
          if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
          {
            if (xqr.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
              QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131703899), 1).a();
            }
          }
          else if ((this.a.jdField_a_of_type_Ybu != null) && (xqr.a()))
          {
            i = this.a.jdField_a_of_type_Ybu.a().type;
            if ((i == 3) || (i == 5))
            {
              QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131703870), 1).a();
              continue;
            }
          }
          this.a.e();
          continue;
          if (!NetworkUtil.isNetSupport(this.a.jdField_a_of_type_AndroidContentContext))
          {
            QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131703893), 0).a();
          }
          else if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
          {
            QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131703877), 0).a();
          }
          else
          {
            if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
            {
              if (xqr.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
                QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131703884), 1).a();
              }
            }
            else if ((this.a.jdField_a_of_type_Ybu != null) && (xqr.a()))
            {
              i = this.a.jdField_a_of_type_Ybu.a().type;
              if ((i == 3) || (i == 5))
              {
                QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131703894), 1).a();
                continue;
              }
            }
            i = ykv.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
            if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
            for (localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; localObject1 = "")
            {
              ykv.a("home_page", "clk_reply", ykv.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), ykv.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject1 });
              if (this.a.jdField_a_of_type_Wgi == null) {
                break;
              }
              localObject1 = (wgm)this.a.a("commentLego");
              this.a.jdField_a_of_type_Wgi.a((wgm)localObject1, paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
              break;
            }
            if (wgs.a(this.a) != null)
            {
              if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem))
              {
                localObject1 = (QQUserUIItem)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
                wgs.a(this.a).a(Long.parseLong(((QQUserUIItem)localObject1).qq), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
              }
            }
            else
            {
              i = ykv.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
              if (!(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
                break label812;
              }
            }
            for (localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; localObject1 = "")
            {
              ykv.a("home_page", "clk_play", ykv.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), ykv.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject1 });
              break;
              wgs.a(this.a).a(0L, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
              break label672;
            }
            if (this.a.jdField_a_of_type_Int == 11) {
              i = 211;
            }
            for (;;)
            {
              StoryDetailActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, i, 0);
              ykv.a("home_page", "clk_reply_mini", ykv.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(ykv.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem)), ykv.a(this.a.jdField_a_of_type_Int), "", this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
              break;
              if (this.a.jdField_a_of_type_Int == 12) {
                i = 222;
              } else {
                i = 210;
              }
            }
            if (!NetworkUtil.isNetSupport(this.a.jdField_a_of_type_AndroidContentContext))
            {
              QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131703878), 0).a();
            }
            else if (!UIUtils.isFastDoubleClick())
            {
              if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
              for (localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; localObject1 = "")
              {
                ykv.a("home_page", "clk_share", ykv.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { ykv.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem) + "", ykv.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject1 });
                if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() != null)) {
                  break label1158;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("FeedCommentLikeLego", 2, "can't share, commentLikeFeedItem not ready");
                break;
              }
              if (this.a.jdField_a_of_type_Ybt == null) {
                break;
              }
              if (wgs.a(this.a) == null) {
                wgs.a(this.a, wvu.a(this.a.jdField_a_of_type_AndroidAppActivity));
              }
              wgs.a(this.a).a(this.a.jdField_a_of_type_AndroidContentContext.getString(2131718786)).a(new wgu(this)).a(new wwt((BannerFeedItem)this.a.jdField_a_of_type_Ybt.a())).b();
            }
          }
        }
      }
      localObject2 = null;
      localObject1 = null;
      localList = this.a.jdField_a_of_type_Ybu.a();
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
            if (!zdu.c(((StoryVideoItem)localObject4).mCreateTime)) {
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
        QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131703907), 0).a();
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
        if (wgs.a(this.a) == null) {
          wgs.a(this.a, wvu.a(this.a.jdField_a_of_type_AndroidAppActivity));
        }
        localObject4 = wgs.a(this.a);
        if (bool3)
        {
          localObject3 = anvx.a(2131703904);
          label1605:
          localObject2 = ((wvu)localObject4).a((String)localObject3).a(new wgv(this)).a(wwx.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem, (StoryVideoItem)localObject1, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, ((StoryVideoItem)localObject1).mCreateTime, ((List)localObject2).size()));
          if (!bool1) {
            break label1755;
          }
          localObject1 = "1";
          label1671:
          localObject2 = ((wvu)localObject2).a("vote", (String)localObject1);
          if (!bool2) {
            break label1763;
          }
        }
        label1755:
        label1763:
        for (localObject1 = "1";; localObject1 = "0")
        {
          ((wvu)localObject2).a("grade", (String)localObject1).b();
          ykv.a("share_story", "share_day", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
          break;
          localObject3 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131718786);
          break label1605;
          localObject1 = "0";
          break label1671;
        }
      }
      if (wgs.a(this.a) == null) {
        wgs.a(this.a, wvu.a(this.a.jdField_a_of_type_AndroidAppActivity));
      }
      localObject4 = wgs.a(this.a);
      if (bool3)
      {
        localObject3 = anvx.a(2131703888);
        label1821:
        localObject2 = ((wvu)localObject4).a((String)localObject3).a(new wgw(this)).a(new wwu((StoryVideoItem)localObject1, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, ((List)localObject2).size()));
        if (!bool1) {
          break label1935;
        }
        localObject1 = "1";
        label1879:
        localObject2 = ((wvu)localObject2).a("vote", (String)localObject1);
        if (!bool2) {
          break label1943;
        }
      }
      label1935:
      label1943:
      for (localObject1 = "1";; localObject1 = "0")
      {
        ((wvu)localObject2).a("grade", (String)localObject1).b();
        break;
        localObject3 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131718786);
        break label1821;
        localObject1 = "0";
        break label1879;
      }
      QQStoryWatcherListActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 10);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgt
 * JD-Core Version:    0.7.0.1
 */