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

public class xox
  extends vll<xoi, voc>
{
  public xox(xoi paramxoi)
  {
    super(paramxoi);
  }
  
  private void a(@NonNull xoi paramxoi, xpg paramxpg, boolean paramBoolean, StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    Object localObject1 = paramxpg.a().iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
      if (((StoryVideoItem)localObject2).equals(paramStoryVideoItem1))
      {
        xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "update new video %s", paramStoryVideoItem1);
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
          paramxpg.a(paramStoryVideoItem1, paramBoolean);
          xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "insert new video  %s", paramStoryVideoItem1);
          paramStoryVideoItem2 = (xnv)vux.a(12);
          localObject1 = ((VideoListFeedItem)paramxpg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramxpg.a());
          if (!((FeedVideoInfo)localObject1).mIsVideoEnd)
          {
            xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "mark feed %s is video pull finish", paramxpg.a().feedId);
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
            xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", xoi.a(paramxoi));
          }
          int j = paramxoi.a().size();
          i = 0;
          while (j > i)
          {
            paramStoryVideoItem2 = (xpe)xoi.a(paramxoi).get(i);
            if ((!(paramStoryVideoItem2 instanceof xpa)) || (!((HotRecommendFeedItem)((xpa)paramStoryVideoItem2).a()).mIsTopLocation)) {
              break;
            }
            i += 1;
          }
          paramxpg.a(i, paramStoryVideoItem2);
          xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "feed fake %s to suc:%s", new Object[] { ((StoryVideoItem)localObject2).mVid, paramStoryVideoItem2 });
          paramStoryVideoItem2 = (xnv)vux.a(12);
          localObject1 = ((VideoListFeedItem)paramxpg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramxpg.a());
          paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
          break label67;
          i += 1;
          break;
        }
        xoi.a(paramxoi).remove(paramxpg);
        xoi.a(paramxoi).add(i, paramxpg);
        if (QLog.isDebugVersion()) {
          xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", xoi.a(paramxoi));
        }
        if ((paramStoryVideoItem1.mTagInfoBase != null) && ((paramxpg instanceof xnx)))
        {
          paramStoryVideoItem2 = paramxpg.d;
          paramStoryVideoItem2.remove(paramStoryVideoItem1.mTagInfoBase);
          if (paramStoryVideoItem2.size() <= 0) {
            break label610;
          }
          paramStoryVideoItem2.add(0, paramStoryVideoItem1.mTagInfoBase);
        }
      }
      for (;;)
      {
        xvv.d(this.TAG, "update tag list while publish , feedId :%s", new Object[] { paramxpg.a().feedId });
        xoi.a(paramxoi).a(paramxpg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
        return;
        label610:
        paramStoryVideoItem2.add(paramStoryVideoItem1.mTagInfoBase);
      }
    }
  }
  
  public void a(@NonNull xoi paramxoi, @NonNull voc paramvoc)
  {
    if (paramvoc.a())
    {
      xvv.b(this.TAG, "group video upload");
      return;
    }
    Object localObject2;
    label33:
    Object localObject3;
    Object localObject1;
    if (paramvoc.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject2 = paramvoc.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (vob)((Iterator)localObject2).next();
        if (!(((vob)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
        {
          yos.a("fake item type error", new Object[0]);
        }
        else
        {
          localObject1 = (ShareGroupItem)((vob)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner();
          if (xoi.a(paramxoi, ((ShareGroupItem)localObject1).shareGroupId))
          {
            localObject1 = xoi.a(paramxoi, xoi.a(paramxoi), ((ShareGroupItem)localObject1).shareGroupId, ((vob)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.date);
            if (localObject1 != null) {
              break label531;
            }
            if ((((vob)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
            {
              localObject1 = new xpd((ShareGroupFeedItem)((vob)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
              xoi.a(paramxoi).add(0, localObject1);
            }
            xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
          }
        }
      }
    }
    label531:
    for (;;)
    {
      if ((((vob)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem != null) && ((localObject1 instanceof xpd))) {
        ((xpg)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = ((vob)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem;
      }
      localObject3 = ((vob)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        voa localvoa = (voa)((Iterator)localObject3).next();
        a(paramxoi, (xpg)localObject1, paramvoc.jdField_a_of_type_Boolean, localvoa.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, localvoa.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      break label33;
      if ((!paramvoc.jdField_b_of_type_Boolean) || (!xoi.a(paramxoi))) {
        break;
      }
      if (paramvoc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem == null)
      {
        xvv.d(this.TAG, "null pointer for feed item");
        return;
      }
      if (paramvoc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.getOwner() == null)
      {
        xvv.d(this.TAG, "null pointer for feed item user");
        return;
      }
      xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramvoc);
      xvv.b("Q.qqstory.home.data.HomeFeedPresenter", "home task state write temp:" + paramvoc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.hashCode());
      localObject2 = xoi.a(paramxoi, xoi.a(paramxoi), paramvoc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new xnx(paramvoc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
        int j = xoi.a(paramxoi).size();
        int i = 0;
        while (j > i)
        {
          localObject2 = (xpe)xoi.a(paramxoi).get(i);
          if ((!(localObject2 instanceof xpa)) || (!((HotRecommendFeedItem)((xpa)localObject2).a()).mIsTopLocation)) {
            break;
          }
          i += 1;
        }
        xoi.a(paramxoi).add(i, localObject1);
        xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
      }
      if (paramvoc.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)
      {
        ((xnx)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = paramvoc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
        ((xnx)localObject1).jdField_a_of_type_Boolean = false;
      }
      a(paramxoi, (xpg)localObject1, paramvoc.jdField_a_of_type_Boolean, paramvoc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvoc.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return voc.class;
  }
  
  public void b(@NonNull xoi paramxoi, @NonNull voc paramvoc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xox
 * JD-Core Version:    0.7.0.1
 */