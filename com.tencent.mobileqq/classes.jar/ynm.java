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

public class ynm
  extends wjm<ymx, wmd>
{
  public ynm(ymx paramymx)
  {
    super(paramymx);
  }
  
  private void a(@NonNull ymx paramymx, ynv paramynv, boolean paramBoolean, StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    Object localObject1 = paramynv.a().iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
      if (((StoryVideoItem)localObject2).equals(paramStoryVideoItem1))
      {
        yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "update new video %s", paramStoryVideoItem1);
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
          paramynv.a(paramStoryVideoItem1, paramBoolean);
          yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "insert new video  %s", paramStoryVideoItem1);
          paramStoryVideoItem2 = (ymk)wth.a(12);
          localObject1 = ((VideoListFeedItem)paramynv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramynv.a());
          if (!((FeedVideoInfo)localObject1).mIsVideoEnd)
          {
            yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "mark feed %s is video pull finish", paramynv.a().feedId);
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
            yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", ymx.a(paramymx));
          }
          int j = paramymx.a().size();
          i = 0;
          while (j > i)
          {
            paramStoryVideoItem2 = (ynt)ymx.a(paramymx).get(i);
            if ((!(paramStoryVideoItem2 instanceof ynp)) || (!((HotRecommendFeedItem)((ynp)paramStoryVideoItem2).a()).mIsTopLocation)) {
              break;
            }
            i += 1;
          }
          paramynv.a(i, paramStoryVideoItem2);
          yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "feed fake %s to suc:%s", new Object[] { ((StoryVideoItem)localObject2).mVid, paramStoryVideoItem2 });
          paramStoryVideoItem2 = (ymk)wth.a(12);
          localObject1 = ((VideoListFeedItem)paramynv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramynv.a());
          paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
          break label67;
          i += 1;
          break;
        }
        ymx.a(paramymx).remove(paramynv);
        ymx.a(paramymx).add(i, paramynv);
        if (QLog.isDebugVersion()) {
          yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", ymx.a(paramymx));
        }
        if ((paramStoryVideoItem1.mTagInfoBase != null) && ((paramynv instanceof ymm)))
        {
          paramStoryVideoItem2 = paramynv.d;
          paramStoryVideoItem2.remove(paramStoryVideoItem1.mTagInfoBase);
          if (paramStoryVideoItem2.size() <= 0) {
            break label610;
          }
          paramStoryVideoItem2.add(0, paramStoryVideoItem1.mTagInfoBase);
        }
      }
      for (;;)
      {
        yuk.d(this.TAG, "update tag list while publish , feedId :%s", new Object[] { paramynv.a().feedId });
        ymx.a(paramymx).a(paramynv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
        return;
        label610:
        paramStoryVideoItem2.add(paramStoryVideoItem1.mTagInfoBase);
      }
    }
  }
  
  public void a(@NonNull ymx paramymx, @NonNull wmd paramwmd)
  {
    if (paramwmd.a())
    {
      yuk.b(this.TAG, "group video upload");
      return;
    }
    Object localObject2;
    label33:
    Object localObject3;
    Object localObject1;
    if (paramwmd.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject2 = paramwmd.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (wmc)((Iterator)localObject2).next();
        if (!(((wmc)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
        {
          znw.a("fake item type error", new Object[0]);
        }
        else
        {
          localObject1 = (ShareGroupItem)((wmc)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner();
          if (ymx.a(paramymx, ((ShareGroupItem)localObject1).shareGroupId))
          {
            localObject1 = ymx.a(paramymx, ymx.a(paramymx), ((ShareGroupItem)localObject1).shareGroupId, ((wmc)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.date);
            if (localObject1 != null) {
              break label531;
            }
            if ((((wmc)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
            {
              localObject1 = new yns((ShareGroupFeedItem)((wmc)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
              ymx.a(paramymx).add(0, localObject1);
            }
            yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
          }
        }
      }
    }
    label531:
    for (;;)
    {
      if ((((wmc)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem != null) && ((localObject1 instanceof yns))) {
        ((ynv)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = ((wmc)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem;
      }
      localObject3 = ((wmc)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        wmb localwmb = (wmb)((Iterator)localObject3).next();
        a(paramymx, (ynv)localObject1, paramwmd.jdField_a_of_type_Boolean, localwmb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, localwmb.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      break label33;
      if ((!paramwmd.jdField_b_of_type_Boolean) || (!ymx.a(paramymx))) {
        break;
      }
      if (paramwmd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem == null)
      {
        yuk.d(this.TAG, "null pointer for feed item");
        return;
      }
      if (paramwmd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.getOwner() == null)
      {
        yuk.d(this.TAG, "null pointer for feed item user");
        return;
      }
      yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramwmd);
      yuk.b("Q.qqstory.home.data.HomeFeedPresenter", "home task state write temp:" + paramwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.hashCode());
      localObject2 = ymx.a(paramymx, ymx.a(paramymx), paramwmd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ymm(paramwmd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
        int j = ymx.a(paramymx).size();
        int i = 0;
        while (j > i)
        {
          localObject2 = (ynt)ymx.a(paramymx).get(i);
          if ((!(localObject2 instanceof ynp)) || (!((HotRecommendFeedItem)((ynp)localObject2).a()).mIsTopLocation)) {
            break;
          }
          i += 1;
        }
        ymx.a(paramymx).add(i, localObject1);
        yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
      }
      if (paramwmd.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)
      {
        ((ymm)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = paramwmd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
        ((ymm)localObject1).jdField_a_of_type_Boolean = false;
      }
      a(paramymx, (ynv)localObject1, paramwmd.jdField_a_of_type_Boolean, paramwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwmd.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return wmd.class;
  }
  
  public void b(@NonNull ymx paramymx, @NonNull wmd paramwmd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynm
 * JD-Core Version:    0.7.0.1
 */