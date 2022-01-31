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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class uor
  extends upp
{
  uor(uoq paramuoq) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    label781:
    label1117:
    List localList;
    Object localObject3;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
    case 2131370664: 
    case 2131370662: 
    case 2131373717: 
    case 2131364543: 
    case 2131370665: 
      int i;
      do
      {
        return;
        if (!bdee.d(this.a.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131704782), 0).a();
          return;
        }
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
        {
          if (vyw.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
            QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, alpo.a(2131704802), 1).a();
          }
        }
        else if ((this.a.jdField_a_of_type_Wjz != null) && (vyw.a()))
        {
          i = this.a.jdField_a_of_type_Wjz.a().type;
          if ((i == 3) || (i == 5))
          {
            QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, alpo.a(2131704773), 1).a();
            return;
          }
        }
        this.a.e();
        return;
        if (!bdee.d(this.a.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131704796), 0).a();
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
        {
          QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131704780), 0).a();
          return;
        }
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
        {
          if (vyw.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
            QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, alpo.a(2131704787), 1).a();
          }
        }
        else if ((this.a.jdField_a_of_type_Wjz != null) && (vyw.a()))
        {
          i = this.a.jdField_a_of_type_Wjz.a().type;
          if ((i == 3) || (i == 5))
          {
            QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, alpo.a(2131704797), 1).a();
            return;
          }
        }
        i = wta.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
        for (localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; localObject1 = "")
        {
          wta.a("home_page", "clk_reply", wta.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), wta.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject1 });
          if (this.a.jdField_a_of_type_Uog == null) {
            break;
          }
          localObject1 = (uok)this.a.a("commentLego");
          this.a.jdField_a_of_type_Uog.a((uok)localObject1, paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
          return;
        }
        if (uoq.a(this.a) != null)
        {
          if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem))
          {
            paramView = (QQUserUIItem)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
            uoq.a(this.a).a(Long.parseLong(paramView.qq), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
          }
        }
        else
        {
          i = wta.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
          if (!(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
            break label781;
          }
        }
        for (paramView = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; paramView = "")
        {
          wta.a("home_page", "clk_play", wta.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), wta.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, paramView });
          return;
          uoq.a(this.a).a(0L, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
          break;
        }
        if (this.a.jdField_a_of_type_Int == 11) {
          i = 211;
        }
        for (;;)
        {
          StoryDetailActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, i, 0);
          wta.a("home_page", "clk_reply_mini", wta.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(wta.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem)), wta.a(this.a.jdField_a_of_type_Int), "", this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
          return;
          if (this.a.jdField_a_of_type_Int == 12) {
            i = 222;
          } else {
            i = 210;
          }
        }
        if (!bdee.d(this.a.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131704781), 0).a();
          return;
        }
      } while (xod.b());
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
      for (paramView = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; paramView = "")
      {
        wta.a("home_page", "clk_share", wta.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { wta.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem) + "", wta.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, paramView });
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() != null)) {
          break label1117;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FeedCommentLikeLego", 2, "can't share, commentLikeFeedItem not ready");
        return;
      }
      if (this.a.jdField_a_of_type_Wjy != null)
      {
        if (uoq.a(this.a) == null) {
          uoq.a(this.a, vdt.a(this.a.jdField_a_of_type_AndroidAppActivity));
        }
        uoq.a(this.a).a(this.a.jdField_a_of_type_AndroidContentContext.getString(2131720040)).a(new uos(this)).a(new ves((BannerFeedItem)this.a.jdField_a_of_type_Wjy.a())).b();
        return;
      }
      localObject1 = null;
      paramView = null;
      localList = this.a.jdField_a_of_type_Wjz.a();
      if (!localList.isEmpty())
      {
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
        {
          localObject3 = (StoryVideoItem)localIterator.next();
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject3).mVid)) {
            break label1909;
          }
          localObject2 = paramView;
          if (paramView == null)
          {
            if (!xmq.c(((StoryVideoItem)localObject3).mCreateTime)) {
              break label1396;
            }
            i = localList.size() - 1;
            label1313:
            if (i < 0) {
              break label1906;
            }
            localObject2 = (StoryVideoItem)localList.get(i);
            if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {
              break label1389;
            }
            paramView = (View)localObject2;
          }
          label1344:
          label1360:
          label1376:
          label1389:
          label1396:
          for (localObject2 = paramView;; localObject2 = localObject3)
          {
            if (localObject1 != null) {
              break label1900;
            }
            paramView = new ArrayList();
            paramView.add(((StoryVideoItem)localObject3).mVid);
            localObject1 = localObject2;
            localObject2 = localObject1;
            localObject1 = paramView;
            paramView = (View)localObject2;
            break;
            i -= 1;
            break label1313;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FeedCommentLikeLego", 2, "can't share, video list empty");
        }
        QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131704810), 0).a();
        return;
      }
      if (paramView == null) {
        break;
      }
      boolean bool1 = StoryVideoItem.hasPollVideo(localList);
      boolean bool2 = StoryVideoItem.hasInteractVideo(localList);
      boolean bool3 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe();
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.allowStrangerVisitAndPost == 1))
      {
        if (uoq.a(this.a) == null) {
          uoq.a(this.a, vdt.a(this.a.jdField_a_of_type_AndroidAppActivity));
        }
        localObject3 = uoq.a(this.a);
        if (bool3)
        {
          localObject2 = alpo.a(2131704807);
          localObject1 = ((vdt)localObject3).a((String)localObject2).a(new uot(this)).a(vew.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem, paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, paramView.mCreateTime, ((List)localObject1).size()));
          if (!bool1) {
            break label1692;
          }
          paramView = "1";
          label1613:
          localObject1 = ((vdt)localObject1).a("vote", paramView);
          if (!bool2) {
            break label1699;
          }
        }
        label1692:
        label1699:
        for (paramView = "1";; paramView = "0")
        {
          ((vdt)localObject1).a("grade", paramView).b();
          wta.a("share_story", "share_day", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
          return;
          localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131720040);
          break;
          paramView = "0";
          break label1613;
        }
      }
      if (uoq.a(this.a) == null) {
        uoq.a(this.a, vdt.a(this.a.jdField_a_of_type_AndroidAppActivity));
      }
      localObject3 = uoq.a(this.a);
      if (bool3)
      {
        localObject2 = alpo.a(2131704791);
        localObject1 = ((vdt)localObject3).a((String)localObject2).a(new uou(this)).a(new vet(paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, ((List)localObject1).size()));
        if (!bool1) {
          break label1863;
        }
        paramView = "1";
        label1812:
        localObject1 = ((vdt)localObject1).a("vote", paramView);
        if (!bool2) {
          break label1870;
        }
      }
      label1863:
      label1870:
      for (paramView = "1";; paramView = "0")
      {
        ((vdt)localObject1).a("grade", paramView).b();
        return;
        localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131720040);
        break;
        paramView = "0";
        break label1812;
      }
      QQStoryWatcherListActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 10);
      return;
      label1900:
      paramView = (View)localObject1;
      break label1360;
      label1906:
      break label1344;
      label1909:
      localObject2 = localObject1;
      localObject1 = paramView;
      paramView = (View)localObject2;
      break label1376;
      localObject1 = null;
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uor
 * JD-Core Version:    0.7.0.1
 */