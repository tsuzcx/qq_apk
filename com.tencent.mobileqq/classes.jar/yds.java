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

public class yds
  extends wag<ydd, wcx>
{
  public yds(ydd paramydd)
  {
    super(paramydd);
  }
  
  private void a(@NonNull ydd paramydd, yeb paramyeb, boolean paramBoolean, StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    Object localObject1 = paramyeb.a().iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
      if (((StoryVideoItem)localObject2).equals(paramStoryVideoItem1))
      {
        ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "update new video %s", paramStoryVideoItem1);
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
          paramyeb.a(paramStoryVideoItem1, paramBoolean);
          ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "insert new video  %s", paramStoryVideoItem1);
          paramStoryVideoItem2 = (ycq)wjs.a(12);
          localObject1 = ((VideoListFeedItem)paramyeb.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramyeb.a());
          if (!((FeedVideoInfo)localObject1).mIsVideoEnd)
          {
            ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "mark feed %s is video pull finish", paramyeb.a().feedId);
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
            ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", ydd.a(paramydd));
          }
          int j = paramydd.a().size();
          i = 0;
          while (j > i)
          {
            paramStoryVideoItem2 = (ydz)ydd.a(paramydd).get(i);
            if ((!(paramStoryVideoItem2 instanceof ydv)) || (!((HotRecommendFeedItem)((ydv)paramStoryVideoItem2).a()).mIsTopLocation)) {
              break;
            }
            i += 1;
          }
          paramyeb.a(i, paramStoryVideoItem2);
          ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "feed fake %s to suc:%s", new Object[] { ((StoryVideoItem)localObject2).mVid, paramStoryVideoItem2 });
          paramStoryVideoItem2 = (ycq)wjs.a(12);
          localObject1 = ((VideoListFeedItem)paramyeb.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramyeb.a());
          paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
          break label67;
          i += 1;
          break;
        }
        ydd.a(paramydd).remove(paramyeb);
        ydd.a(paramydd).add(i, paramyeb);
        if (QLog.isDebugVersion()) {
          ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", ydd.a(paramydd));
        }
        if ((paramStoryVideoItem1.mTagInfoBase != null) && ((paramyeb instanceof ycs)))
        {
          paramStoryVideoItem2 = paramyeb.d;
          paramStoryVideoItem2.remove(paramStoryVideoItem1.mTagInfoBase);
          if (paramStoryVideoItem2.size() <= 0) {
            break label610;
          }
          paramStoryVideoItem2.add(0, paramStoryVideoItem1.mTagInfoBase);
        }
      }
      for (;;)
      {
        ykq.d(this.TAG, "update tag list while publish , feedId :%s", new Object[] { paramyeb.a().feedId });
        ydd.a(paramydd).a(paramyeb.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
        return;
        label610:
        paramStoryVideoItem2.add(paramStoryVideoItem1.mTagInfoBase);
      }
    }
  }
  
  public void a(@NonNull ydd paramydd, @NonNull wcx paramwcx)
  {
    if (paramwcx.a())
    {
      ykq.b(this.TAG, "group video upload");
      return;
    }
    Object localObject2;
    label33:
    Object localObject3;
    Object localObject1;
    if (paramwcx.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject2 = paramwcx.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (wcw)((Iterator)localObject2).next();
        if (!(((wcw)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
        {
          zdl.a("fake item type error", new Object[0]);
        }
        else
        {
          localObject1 = (ShareGroupItem)((wcw)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner();
          if (ydd.a(paramydd, ((ShareGroupItem)localObject1).shareGroupId))
          {
            localObject1 = ydd.a(paramydd, ydd.a(paramydd), ((ShareGroupItem)localObject1).shareGroupId, ((wcw)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.date);
            if (localObject1 != null) {
              break label531;
            }
            if ((((wcw)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
            {
              localObject1 = new ydy((ShareGroupFeedItem)((wcw)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
              ydd.a(paramydd).add(0, localObject1);
            }
            ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
          }
        }
      }
    }
    label531:
    for (;;)
    {
      if ((((wcw)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem != null) && ((localObject1 instanceof ydy))) {
        ((yeb)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = ((wcw)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem;
      }
      localObject3 = ((wcw)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        wcv localwcv = (wcv)((Iterator)localObject3).next();
        a(paramydd, (yeb)localObject1, paramwcx.jdField_a_of_type_Boolean, localwcv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, localwcv.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      break label33;
      if ((!paramwcx.jdField_b_of_type_Boolean) || (!ydd.a(paramydd))) {
        break;
      }
      if (paramwcx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem == null)
      {
        ykq.d(this.TAG, "null pointer for feed item");
        return;
      }
      if (paramwcx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.getOwner() == null)
      {
        ykq.d(this.TAG, "null pointer for feed item user");
        return;
      }
      ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramwcx);
      ykq.b("Q.qqstory.home.data.HomeFeedPresenter", "home task state write temp:" + paramwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.hashCode());
      localObject2 = ydd.a(paramydd, ydd.a(paramydd), paramwcx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ycs(paramwcx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
        int j = ydd.a(paramydd).size();
        int i = 0;
        while (j > i)
        {
          localObject2 = (ydz)ydd.a(paramydd).get(i);
          if ((!(localObject2 instanceof ydv)) || (!((HotRecommendFeedItem)((ydv)localObject2).a()).mIsTopLocation)) {
            break;
          }
          i += 1;
        }
        ydd.a(paramydd).add(i, localObject1);
        ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
      }
      if (paramwcx.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)
      {
        ((ycs)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = paramwcx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
        ((ycs)localObject1).jdField_a_of_type_Boolean = false;
      }
      a(paramydd, (yeb)localObject1, paramwcx.jdField_a_of_type_Boolean, paramwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwcx.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return wcx.class;
  }
  
  public void b(@NonNull ydd paramydd, @NonNull wcx paramwcx) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yds
 * JD-Core Version:    0.7.0.1
 */