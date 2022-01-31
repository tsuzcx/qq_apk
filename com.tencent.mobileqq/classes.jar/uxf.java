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

public class uxf
  extends ste<uwq, svv>
{
  public uxf(uwq paramuwq)
  {
    super(paramuwq);
  }
  
  private void a(@NonNull uwq paramuwq, uxo paramuxo, boolean paramBoolean, StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    Object localObject1 = paramuxo.a().iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
      if (((StoryVideoItem)localObject2).equals(paramStoryVideoItem1))
      {
        ved.a("Q.qqstory.home.data.HomeFeedPresenter", "update new video %s", paramStoryVideoItem1);
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
          paramuxo.a(paramStoryVideoItem1, paramBoolean);
          ved.a("Q.qqstory.home.data.HomeFeedPresenter", "insert new video  %s", paramStoryVideoItem1);
          paramStoryVideoItem2 = (uwd)tcz.a(12);
          localObject1 = ((VideoListFeedItem)paramuxo.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramuxo.a());
          if (!((FeedVideoInfo)localObject1).mIsVideoEnd)
          {
            ved.a("Q.qqstory.home.data.HomeFeedPresenter", "mark feed %s is video pull finish", paramuxo.a().feedId);
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
            ved.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", uwq.a(paramuwq));
          }
          int j = paramuwq.a().size();
          i = 0;
          while (j > i)
          {
            paramStoryVideoItem2 = (uxm)uwq.a(paramuwq).get(i);
            if ((!(paramStoryVideoItem2 instanceof uxi)) || (!((HotRecommendFeedItem)((uxi)paramStoryVideoItem2).a()).mIsTopLocation)) {
              break;
            }
            i += 1;
          }
          paramuxo.a(i, paramStoryVideoItem2);
          ved.d("Q.qqstory.home.data.HomeFeedPresenter", "feed fake %s to suc:%s", new Object[] { ((StoryVideoItem)localObject2).mVid, paramStoryVideoItem2 });
          paramStoryVideoItem2 = (uwd)tcz.a(12);
          localObject1 = ((VideoListFeedItem)paramuxo.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramuxo.a());
          paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
          break label67;
          i += 1;
          break;
        }
        uwq.a(paramuwq).remove(paramuxo);
        uwq.a(paramuwq).add(i, paramuxo);
        if (QLog.isDebugVersion()) {
          ved.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", uwq.a(paramuwq));
        }
        if ((paramStoryVideoItem1.mTagInfoBase != null) && ((paramuxo instanceof uwf)))
        {
          paramStoryVideoItem2 = paramuxo.d;
          paramStoryVideoItem2.remove(paramStoryVideoItem1.mTagInfoBase);
          if (paramStoryVideoItem2.size() <= 0) {
            break label610;
          }
          paramStoryVideoItem2.add(0, paramStoryVideoItem1.mTagInfoBase);
        }
      }
      for (;;)
      {
        ved.d(this.TAG, "update tag list while publish , feedId :%s", new Object[] { paramuxo.a().feedId });
        uwq.a(paramuwq).a(paramuxo.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
        return;
        label610:
        paramStoryVideoItem2.add(paramStoryVideoItem1.mTagInfoBase);
      }
    }
  }
  
  public void a(@NonNull uwq paramuwq, @NonNull svv paramsvv)
  {
    if (paramsvv.a())
    {
      ved.b(this.TAG, "group video upload");
      return;
    }
    Object localObject2;
    label33:
    Object localObject3;
    Object localObject1;
    if (paramsvv.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject2 = paramsvv.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (svu)((Iterator)localObject2).next();
        if (!(((svu)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
        {
          vxp.a("fake item type error", new Object[0]);
        }
        else
        {
          localObject1 = (ShareGroupItem)((svu)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner();
          if (uwq.a(paramuwq, ((ShareGroupItem)localObject1).shareGroupId))
          {
            localObject1 = uwq.a(paramuwq, uwq.a(paramuwq), ((ShareGroupItem)localObject1).shareGroupId, ((svu)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.date);
            if (localObject1 != null) {
              break label531;
            }
            if ((((svu)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
            {
              localObject1 = new uxl((ShareGroupFeedItem)((svu)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
              uwq.a(paramuwq).add(0, localObject1);
            }
            ved.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
          }
        }
      }
    }
    label531:
    for (;;)
    {
      if ((((svu)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem != null) && ((localObject1 instanceof uxl))) {
        ((uxo)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = ((svu)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem;
      }
      localObject3 = ((svu)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        svt localsvt = (svt)((Iterator)localObject3).next();
        a(paramuwq, (uxo)localObject1, paramsvv.jdField_a_of_type_Boolean, localsvt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, localsvt.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      break label33;
      if ((!paramsvv.jdField_b_of_type_Boolean) || (!uwq.a(paramuwq))) {
        break;
      }
      if (paramsvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem == null)
      {
        ved.d(this.TAG, "null pointer for feed item");
        return;
      }
      if (paramsvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.getOwner() == null)
      {
        ved.d(this.TAG, "null pointer for feed item user");
        return;
      }
      ved.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramsvv);
      ved.b("Q.qqstory.home.data.HomeFeedPresenter", "home task state write temp:" + paramsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.hashCode());
      localObject2 = uwq.a(paramuwq, uwq.a(paramuwq), paramsvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new uwf(paramsvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
        int j = uwq.a(paramuwq).size();
        int i = 0;
        while (j > i)
        {
          localObject2 = (uxm)uwq.a(paramuwq).get(i);
          if ((!(localObject2 instanceof uxi)) || (!((HotRecommendFeedItem)((uxi)localObject2).a()).mIsTopLocation)) {
            break;
          }
          i += 1;
        }
        uwq.a(paramuwq).add(i, localObject1);
        ved.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
      }
      if (paramsvv.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)
      {
        ((uwf)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = paramsvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
        ((uwf)localObject1).jdField_a_of_type_Boolean = false;
      }
      a(paramuwq, (uxo)localObject1, paramsvv.jdField_a_of_type_Boolean, paramsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramsvv.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return svv.class;
  }
  
  public void b(@NonNull uwq paramuwq, @NonNull svv paramsvv) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxf
 * JD-Core Version:    0.7.0.1
 */