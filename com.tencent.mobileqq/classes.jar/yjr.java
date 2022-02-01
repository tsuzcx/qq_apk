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

public class yjr
  extends wfr<yjc, wii>
{
  public yjr(yjc paramyjc)
  {
    super(paramyjc);
  }
  
  private void a(@NonNull yjc paramyjc, yka paramyka, boolean paramBoolean, StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    Object localObject1 = paramyka.a().iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
      if (((StoryVideoItem)localObject2).equals(paramStoryVideoItem1))
      {
        yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "update new video %s", paramStoryVideoItem1);
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
          paramyka.a(paramStoryVideoItem1, paramBoolean);
          yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "insert new video  %s", paramStoryVideoItem1);
          paramStoryVideoItem2 = (yip)wpm.a(12);
          localObject1 = ((VideoListFeedItem)paramyka.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramyka.a());
          if (!((FeedVideoInfo)localObject1).mIsVideoEnd)
          {
            yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "mark feed %s is video pull finish", paramyka.a().feedId);
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
            yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", yjc.a(paramyjc));
          }
          int j = paramyjc.a().size();
          i = 0;
          while (j > i)
          {
            paramStoryVideoItem2 = (yjy)yjc.a(paramyjc).get(i);
            if ((!(paramStoryVideoItem2 instanceof yju)) || (!((HotRecommendFeedItem)((yju)paramStoryVideoItem2).a()).mIsTopLocation)) {
              break;
            }
            i += 1;
          }
          paramyka.a(i, paramStoryVideoItem2);
          yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "feed fake %s to suc:%s", new Object[] { ((StoryVideoItem)localObject2).mVid, paramStoryVideoItem2 });
          paramStoryVideoItem2 = (yip)wpm.a(12);
          localObject1 = ((VideoListFeedItem)paramyka.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramyka.a());
          paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
          break label67;
          i += 1;
          break;
        }
        yjc.a(paramyjc).remove(paramyka);
        yjc.a(paramyjc).add(i, paramyka);
        if (QLog.isDebugVersion()) {
          yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", yjc.a(paramyjc));
        }
        if ((paramStoryVideoItem1.mTagInfoBase != null) && ((paramyka instanceof yir)))
        {
          paramStoryVideoItem2 = paramyka.d;
          paramStoryVideoItem2.remove(paramStoryVideoItem1.mTagInfoBase);
          if (paramStoryVideoItem2.size() <= 0) {
            break label610;
          }
          paramStoryVideoItem2.add(0, paramStoryVideoItem1.mTagInfoBase);
        }
      }
      for (;;)
      {
        yqp.d(this.TAG, "update tag list while publish , feedId :%s", new Object[] { paramyka.a().feedId });
        yjc.a(paramyjc).a(paramyka.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
        return;
        label610:
        paramStoryVideoItem2.add(paramStoryVideoItem1.mTagInfoBase);
      }
    }
  }
  
  public void a(@NonNull yjc paramyjc, @NonNull wii paramwii)
  {
    if (paramwii.a())
    {
      yqp.b(this.TAG, "group video upload");
      return;
    }
    Object localObject2;
    label33:
    Object localObject3;
    Object localObject1;
    if (paramwii.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject2 = paramwii.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (wih)((Iterator)localObject2).next();
        if (!(((wih)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
        {
          zkb.a("fake item type error", new Object[0]);
        }
        else
        {
          localObject1 = (ShareGroupItem)((wih)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner();
          if (yjc.a(paramyjc, ((ShareGroupItem)localObject1).shareGroupId))
          {
            localObject1 = yjc.a(paramyjc, yjc.a(paramyjc), ((ShareGroupItem)localObject1).shareGroupId, ((wih)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.date);
            if (localObject1 != null) {
              break label531;
            }
            if ((((wih)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
            {
              localObject1 = new yjx((ShareGroupFeedItem)((wih)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
              yjc.a(paramyjc).add(0, localObject1);
            }
            yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
          }
        }
      }
    }
    label531:
    for (;;)
    {
      if ((((wih)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem != null) && ((localObject1 instanceof yjx))) {
        ((yka)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = ((wih)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem;
      }
      localObject3 = ((wih)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        wig localwig = (wig)((Iterator)localObject3).next();
        a(paramyjc, (yka)localObject1, paramwii.jdField_a_of_type_Boolean, localwig.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, localwig.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      break label33;
      if ((!paramwii.jdField_b_of_type_Boolean) || (!yjc.a(paramyjc))) {
        break;
      }
      if (paramwii.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem == null)
      {
        yqp.d(this.TAG, "null pointer for feed item");
        return;
      }
      if (paramwii.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.getOwner() == null)
      {
        yqp.d(this.TAG, "null pointer for feed item user");
        return;
      }
      yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramwii);
      yqp.b("Q.qqstory.home.data.HomeFeedPresenter", "home task state write temp:" + paramwii.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.hashCode());
      localObject2 = yjc.a(paramyjc, yjc.a(paramyjc), paramwii.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new yir(paramwii.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
        int j = yjc.a(paramyjc).size();
        int i = 0;
        while (j > i)
        {
          localObject2 = (yjy)yjc.a(paramyjc).get(i);
          if ((!(localObject2 instanceof yju)) || (!((HotRecommendFeedItem)((yju)localObject2).a()).mIsTopLocation)) {
            break;
          }
          i += 1;
        }
        yjc.a(paramyjc).add(i, localObject1);
        yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
      }
      if (paramwii.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)
      {
        ((yir)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = paramwii.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
        ((yir)localObject1).jdField_a_of_type_Boolean = false;
      }
      a(paramyjc, (yka)localObject1, paramwii.jdField_a_of_type_Boolean, paramwii.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwii.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return wii.class;
  }
  
  public void b(@NonNull yjc paramyjc, @NonNull wii paramwii) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjr
 * JD-Core Version:    0.7.0.1
 */