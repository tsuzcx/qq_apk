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

public class wlx
  extends uhw<wli, ukn>
{
  public wlx(wli paramwli)
  {
    super(paramwli);
  }
  
  private void a(@NonNull wli paramwli, wmg paramwmg, boolean paramBoolean, StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    Object localObject1 = paramwmg.a().iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
      if (((StoryVideoItem)localObject2).equals(paramStoryVideoItem1))
      {
        wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "update new video %s", paramStoryVideoItem1);
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
          paramwmg.a(paramStoryVideoItem1, paramBoolean);
          wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "insert new video  %s", paramStoryVideoItem1);
          paramStoryVideoItem2 = (wkv)urr.a(12);
          localObject1 = ((VideoListFeedItem)paramwmg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramwmg.a());
          if (!((FeedVideoInfo)localObject1).mIsVideoEnd)
          {
            wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "mark feed %s is video pull finish", paramwmg.a().feedId);
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
            wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", wli.a(paramwli));
          }
          int j = paramwli.a().size();
          i = 0;
          while (j > i)
          {
            paramStoryVideoItem2 = (wme)wli.a(paramwli).get(i);
            if ((!(paramStoryVideoItem2 instanceof wma)) || (!((HotRecommendFeedItem)((wma)paramStoryVideoItem2).a()).mIsTopLocation)) {
              break;
            }
            i += 1;
          }
          paramwmg.a(i, paramStoryVideoItem2);
          wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "feed fake %s to suc:%s", new Object[] { ((StoryVideoItem)localObject2).mVid, paramStoryVideoItem2 });
          paramStoryVideoItem2 = (wkv)urr.a(12);
          localObject1 = ((VideoListFeedItem)paramwmg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramwmg.a());
          paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
          break label67;
          i += 1;
          break;
        }
        wli.a(paramwli).remove(paramwmg);
        wli.a(paramwli).add(i, paramwmg);
        if (QLog.isDebugVersion()) {
          wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", wli.a(paramwli));
        }
        if ((paramStoryVideoItem1.mTagInfoBase != null) && ((paramwmg instanceof wkx)))
        {
          paramStoryVideoItem2 = paramwmg.d;
          paramStoryVideoItem2.remove(paramStoryVideoItem1.mTagInfoBase);
          if (paramStoryVideoItem2.size() <= 0) {
            break label610;
          }
          paramStoryVideoItem2.add(0, paramStoryVideoItem1.mTagInfoBase);
        }
      }
      for (;;)
      {
        wsv.d(this.TAG, "update tag list while publish , feedId :%s", new Object[] { paramwmg.a().feedId });
        wli.a(paramwli).a(paramwmg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
        return;
        label610:
        paramStoryVideoItem2.add(paramStoryVideoItem1.mTagInfoBase);
      }
    }
  }
  
  public void a(@NonNull wli paramwli, @NonNull ukn paramukn)
  {
    if (paramukn.a())
    {
      wsv.b(this.TAG, "group video upload");
      return;
    }
    Object localObject2;
    label33:
    Object localObject3;
    Object localObject1;
    if (paramukn.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject2 = paramukn.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ukm)((Iterator)localObject2).next();
        if (!(((ukm)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
        {
          xmh.a("fake item type error", new Object[0]);
        }
        else
        {
          localObject1 = (ShareGroupItem)((ukm)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner();
          if (wli.a(paramwli, ((ShareGroupItem)localObject1).shareGroupId))
          {
            localObject1 = wli.a(paramwli, wli.a(paramwli), ((ShareGroupItem)localObject1).shareGroupId, ((ukm)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.date);
            if (localObject1 != null) {
              break label531;
            }
            if ((((ukm)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
            {
              localObject1 = new wmd((ShareGroupFeedItem)((ukm)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
              wli.a(paramwli).add(0, localObject1);
            }
            wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
          }
        }
      }
    }
    label531:
    for (;;)
    {
      if ((((ukm)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem != null) && ((localObject1 instanceof wmd))) {
        ((wmg)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = ((ukm)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem;
      }
      localObject3 = ((ukm)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ukl localukl = (ukl)((Iterator)localObject3).next();
        a(paramwli, (wmg)localObject1, paramukn.jdField_a_of_type_Boolean, localukl.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, localukl.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      break label33;
      if ((!paramukn.jdField_b_of_type_Boolean) || (!wli.a(paramwli))) {
        break;
      }
      if (paramukn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem == null)
      {
        wsv.d(this.TAG, "null pointer for feed item");
        return;
      }
      if (paramukn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.getOwner() == null)
      {
        wsv.d(this.TAG, "null pointer for feed item user");
        return;
      }
      wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramukn);
      wsv.b("Q.qqstory.home.data.HomeFeedPresenter", "home task state write temp:" + paramukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.hashCode());
      localObject2 = wli.a(paramwli, wli.a(paramwli), paramukn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new wkx(paramukn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
        int j = wli.a(paramwli).size();
        int i = 0;
        while (j > i)
        {
          localObject2 = (wme)wli.a(paramwli).get(i);
          if ((!(localObject2 instanceof wma)) || (!((HotRecommendFeedItem)((wma)localObject2).a()).mIsTopLocation)) {
            break;
          }
          i += 1;
        }
        wli.a(paramwli).add(i, localObject1);
        wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
      }
      if (paramukn.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)
      {
        ((wkx)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = paramukn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
        ((wkx)localObject1).jdField_a_of_type_Boolean = false;
      }
      a(paramwli, (wmg)localObject1, paramukn.jdField_a_of_type_Boolean, paramukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramukn.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return ukn.class;
  }
  
  public void b(@NonNull wli paramwli, @NonNull ukn paramukn) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlx
 * JD-Core Version:    0.7.0.1
 */