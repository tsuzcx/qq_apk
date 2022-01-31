import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wqg
  extends umf<wpr, uow>
{
  public wqg(wpr paramwpr)
  {
    super(paramwpr);
  }
  
  private void a(@NonNull wpr paramwpr, wqp paramwqp, boolean paramBoolean, StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    Object localObject1 = paramwqp.a().iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
      if (((StoryVideoItem)localObject2).equals(paramStoryVideoItem1))
      {
        wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "update new video %s", paramStoryVideoItem1);
        if (paramStoryVideoItem2 == null) {
          ((StoryVideoItem)localObject2).copy(paramStoryVideoItem1);
        }
      }
    }
    label67:
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramwqp.a(paramStoryVideoItem1, paramBoolean);
          wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "insert new video  %s", paramStoryVideoItem1);
          paramStoryVideoItem2 = (wpe)uwa.a(12);
          localObject1 = ((VideoListFeedItem)paramwqp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramwqp.a());
          if (!((FeedVideoInfo)localObject1).mIsVideoEnd)
          {
            wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "mark feed %s is video pull finish", paramwqp.a().feedId);
            ((FeedVideoInfo)localObject1).mIsVideoEnd = true;
            localObject2 = ((FeedVideoInfo)localObject1).mVideoItemList.iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (!StoryVideoItem.isFakeVid(((StoryVideoItem)((Iterator)localObject2).next()).mVid)) {
                ((FeedVideoInfo)localObject1).mIsVideoEnd = false;
              }
            }
          }
          paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
          if (QLog.isDebugVersion()) {
            wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", wpr.a(paramwpr));
          }
          int j = paramwpr.a().size();
          i = 0;
          while (j > i)
          {
            paramStoryVideoItem2 = (wqn)wpr.a(paramwpr).get(i);
            if ((!(paramStoryVideoItem2 instanceof wqj)) || (!((HotRecommendFeedItem)((wqj)paramStoryVideoItem2).a()).mIsTopLocation)) {
              break;
            }
            i += 1;
          }
          paramwqp.a(i, paramStoryVideoItem2);
          wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "feed fake %s to suc:%s", new Object[] { ((StoryVideoItem)localObject2).mVid, paramStoryVideoItem2 });
          paramStoryVideoItem2 = (wpe)uwa.a(12);
          localObject1 = ((VideoListFeedItem)paramwqp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramwqp.a());
          paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
          break label67;
          i += 1;
          break;
        }
        wpr.a(paramwpr).remove(paramwqp);
        wpr.a(paramwpr).add(i, paramwqp);
        if (QLog.isDebugVersion()) {
          wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", wpr.a(paramwpr));
        }
        if ((paramStoryVideoItem1.mTagInfoBase != null) && ((paramwqp instanceof wpg)))
        {
          paramStoryVideoItem2 = paramwqp.d;
          paramStoryVideoItem2.remove(paramStoryVideoItem1.mTagInfoBase);
          if (paramStoryVideoItem2.size() <= 0) {
            break label610;
          }
          paramStoryVideoItem2.add(0, paramStoryVideoItem1.mTagInfoBase);
        }
      }
      for (;;)
      {
        wxe.d(this.TAG, "update tag list while publish , feedId :%s", new Object[] { paramwqp.a().feedId });
        wpr.a(paramwpr).a(paramwqp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
        return;
        label610:
        paramStoryVideoItem2.add(paramStoryVideoItem1.mTagInfoBase);
      }
    }
  }
  
  public void a(@NonNull wpr paramwpr, @NonNull uow paramuow)
  {
    if (paramuow.a())
    {
      wxe.b(this.TAG, "group video upload");
      return;
    }
    Object localObject2;
    label33:
    Object localObject3;
    Object localObject1;
    if (paramuow.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject2 = paramuow.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (uov)((Iterator)localObject2).next();
        if (!(((uov)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
        {
          xqq.a("fake item type error", new Object[0]);
        }
        else
        {
          localObject1 = (ShareGroupItem)((uov)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner();
          if (wpr.a(paramwpr, ((ShareGroupItem)localObject1).shareGroupId))
          {
            localObject1 = wpr.a(paramwpr, wpr.a(paramwpr), ((ShareGroupItem)localObject1).shareGroupId, ((uov)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.date);
            if (localObject1 != null) {
              break label531;
            }
            if ((((uov)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
            {
              localObject1 = new wqm((ShareGroupFeedItem)((uov)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
              wpr.a(paramwpr).add(0, localObject1);
            }
            wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
          }
        }
      }
    }
    label531:
    for (;;)
    {
      if ((((uov)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem != null) && ((localObject1 instanceof wqm))) {
        ((wqp)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = ((uov)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem;
      }
      localObject3 = ((uov)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        uou localuou = (uou)((Iterator)localObject3).next();
        a(paramwpr, (wqp)localObject1, paramuow.jdField_a_of_type_Boolean, localuou.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, localuou.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      break label33;
      if ((!paramuow.jdField_b_of_type_Boolean) || (!wpr.a(paramwpr))) {
        break;
      }
      if (paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem == null)
      {
        wxe.d(this.TAG, "null pointer for feed item");
        return;
      }
      if (paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.getOwner() == null)
      {
        wxe.d(this.TAG, "null pointer for feed item user");
        return;
      }
      wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramuow);
      wxe.b("Q.qqstory.home.data.HomeFeedPresenter", "home task state write temp:" + paramuow.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.hashCode());
      localObject2 = wpr.a(paramwpr, wpr.a(paramwpr), paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new wpg(paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
        int j = wpr.a(paramwpr).size();
        int i = 0;
        while (j > i)
        {
          localObject2 = (wqn)wpr.a(paramwpr).get(i);
          if ((!(localObject2 instanceof wqj)) || (!((HotRecommendFeedItem)((wqj)localObject2).a()).mIsTopLocation)) {
            break;
          }
          i += 1;
        }
        wpr.a(paramwpr).add(i, localObject1);
        wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
      }
      if (paramuow.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)
      {
        ((wpg)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
        ((wpg)localObject1).jdField_a_of_type_Boolean = false;
      }
      a(paramwpr, (wqp)localObject1, paramuow.jdField_a_of_type_Boolean, paramuow.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramuow.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
  
  public void b(@NonNull wpr paramwpr, @NonNull uow paramuow) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqg
 * JD-Core Version:    0.7.0.1
 */