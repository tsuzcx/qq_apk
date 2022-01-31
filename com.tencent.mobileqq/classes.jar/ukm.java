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

public class ukm
  extends sgl<ujx, sjc>
{
  public ukm(ujx paramujx)
  {
    super(paramujx);
  }
  
  private void a(@NonNull ujx paramujx, ukv paramukv, boolean paramBoolean, StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    Object localObject1 = paramukv.a().iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
      if (((StoryVideoItem)localObject2).equals(paramStoryVideoItem1))
      {
        urk.a("Q.qqstory.home.data.HomeFeedPresenter", "update new video %s", paramStoryVideoItem1);
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
          paramukv.a(paramStoryVideoItem1, paramBoolean);
          urk.a("Q.qqstory.home.data.HomeFeedPresenter", "insert new video  %s", paramStoryVideoItem1);
          paramStoryVideoItem2 = (ujk)sqg.a(12);
          localObject1 = ((VideoListFeedItem)paramukv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramukv.a());
          if (!((FeedVideoInfo)localObject1).mIsVideoEnd)
          {
            urk.a("Q.qqstory.home.data.HomeFeedPresenter", "mark feed %s is video pull finish", paramukv.a().feedId);
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
            urk.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", ujx.a(paramujx));
          }
          int j = paramujx.a().size();
          i = 0;
          while (j > i)
          {
            paramStoryVideoItem2 = (ukt)ujx.a(paramujx).get(i);
            if ((!(paramStoryVideoItem2 instanceof ukp)) || (!((HotRecommendFeedItem)((ukp)paramStoryVideoItem2).a()).mIsTopLocation)) {
              break;
            }
            i += 1;
          }
          paramukv.a(i, paramStoryVideoItem2);
          urk.d("Q.qqstory.home.data.HomeFeedPresenter", "feed fake %s to suc:%s", new Object[] { ((StoryVideoItem)localObject2).mVid, paramStoryVideoItem2 });
          paramStoryVideoItem2 = (ujk)sqg.a(12);
          localObject1 = ((VideoListFeedItem)paramukv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramukv.a());
          paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
          break label67;
          i += 1;
          break;
        }
        ujx.a(paramujx).remove(paramukv);
        ujx.a(paramujx).add(i, paramukv);
        if (QLog.isDebugVersion()) {
          urk.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", ujx.a(paramujx));
        }
        if ((paramStoryVideoItem1.mTagInfoBase != null) && ((paramukv instanceof ujm)))
        {
          paramStoryVideoItem2 = paramukv.d;
          paramStoryVideoItem2.remove(paramStoryVideoItem1.mTagInfoBase);
          if (paramStoryVideoItem2.size() <= 0) {
            break label610;
          }
          paramStoryVideoItem2.add(0, paramStoryVideoItem1.mTagInfoBase);
        }
      }
      for (;;)
      {
        urk.d(this.TAG, "update tag list while publish , feedId :%s", new Object[] { paramukv.a().feedId });
        ujx.a(paramujx).a(paramukv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
        return;
        label610:
        paramStoryVideoItem2.add(paramStoryVideoItem1.mTagInfoBase);
      }
    }
  }
  
  public void a(@NonNull ujx paramujx, @NonNull sjc paramsjc)
  {
    if (paramsjc.a())
    {
      urk.b(this.TAG, "group video upload");
      return;
    }
    Object localObject2;
    label33:
    Object localObject3;
    Object localObject1;
    if (paramsjc.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject2 = paramsjc.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (sjb)((Iterator)localObject2).next();
        if (!(((sjb)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
        {
          vkw.a("fake item type error", new Object[0]);
        }
        else
        {
          localObject1 = (ShareGroupItem)((sjb)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner();
          if (ujx.a(paramujx, ((ShareGroupItem)localObject1).shareGroupId))
          {
            localObject1 = ujx.a(paramujx, ujx.a(paramujx), ((ShareGroupItem)localObject1).shareGroupId, ((sjb)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.date);
            if (localObject1 != null) {
              break label531;
            }
            if ((((sjb)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
            {
              localObject1 = new uks((ShareGroupFeedItem)((sjb)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
              ujx.a(paramujx).add(0, localObject1);
            }
            urk.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
          }
        }
      }
    }
    label531:
    for (;;)
    {
      if ((((sjb)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem != null) && ((localObject1 instanceof uks))) {
        ((ukv)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = ((sjb)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem;
      }
      localObject3 = ((sjb)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        sja localsja = (sja)((Iterator)localObject3).next();
        a(paramujx, (ukv)localObject1, paramsjc.jdField_a_of_type_Boolean, localsja.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, localsja.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      break label33;
      if ((!paramsjc.jdField_b_of_type_Boolean) || (!ujx.a(paramujx))) {
        break;
      }
      if (paramsjc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem == null)
      {
        urk.d(this.TAG, "null pointer for feed item");
        return;
      }
      if (paramsjc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.getOwner() == null)
      {
        urk.d(this.TAG, "null pointer for feed item user");
        return;
      }
      urk.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramsjc);
      urk.b("Q.qqstory.home.data.HomeFeedPresenter", "home task state write temp:" + paramsjc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.hashCode());
      localObject2 = ujx.a(paramujx, ujx.a(paramujx), paramsjc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ujm(paramsjc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
        int j = ujx.a(paramujx).size();
        int i = 0;
        while (j > i)
        {
          localObject2 = (ukt)ujx.a(paramujx).get(i);
          if ((!(localObject2 instanceof ukp)) || (!((HotRecommendFeedItem)((ukp)localObject2).a()).mIsTopLocation)) {
            break;
          }
          i += 1;
        }
        ujx.a(paramujx).add(i, localObject1);
        urk.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
      }
      if (paramsjc.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)
      {
        ((ujm)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = paramsjc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
        ((ujm)localObject1).jdField_a_of_type_Boolean = false;
      }
      a(paramujx, (ukv)localObject1, paramsjc.jdField_a_of_type_Boolean, paramsjc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramsjc.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return sjc.class;
  }
  
  public void b(@NonNull ujx paramujx, @NonNull sjc paramsjc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukm
 * JD-Core Version:    0.7.0.1
 */