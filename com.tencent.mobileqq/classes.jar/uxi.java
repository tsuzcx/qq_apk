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

public class uxi
  extends sth<uwt, svy>
{
  public uxi(uwt paramuwt)
  {
    super(paramuwt);
  }
  
  private void a(@NonNull uwt paramuwt, uxr paramuxr, boolean paramBoolean, StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    Object localObject1 = paramuxr.a().iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
      if (((StoryVideoItem)localObject2).equals(paramStoryVideoItem1))
      {
        veg.a("Q.qqstory.home.data.HomeFeedPresenter", "update new video %s", paramStoryVideoItem1);
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
          paramuxr.a(paramStoryVideoItem1, paramBoolean);
          veg.a("Q.qqstory.home.data.HomeFeedPresenter", "insert new video  %s", paramStoryVideoItem1);
          paramStoryVideoItem2 = (uwg)tdc.a(12);
          localObject1 = ((VideoListFeedItem)paramuxr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramuxr.a());
          if (!((FeedVideoInfo)localObject1).mIsVideoEnd)
          {
            veg.a("Q.qqstory.home.data.HomeFeedPresenter", "mark feed %s is video pull finish", paramuxr.a().feedId);
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
            veg.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", uwt.a(paramuwt));
          }
          int j = paramuwt.a().size();
          i = 0;
          while (j > i)
          {
            paramStoryVideoItem2 = (uxp)uwt.a(paramuwt).get(i);
            if ((!(paramStoryVideoItem2 instanceof uxl)) || (!((HotRecommendFeedItem)((uxl)paramStoryVideoItem2).a()).mIsTopLocation)) {
              break;
            }
            i += 1;
          }
          paramuxr.a(i, paramStoryVideoItem2);
          veg.d("Q.qqstory.home.data.HomeFeedPresenter", "feed fake %s to suc:%s", new Object[] { ((StoryVideoItem)localObject2).mVid, paramStoryVideoItem2 });
          paramStoryVideoItem2 = (uwg)tdc.a(12);
          localObject1 = ((VideoListFeedItem)paramuxr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramuxr.a());
          paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
          break label67;
          i += 1;
          break;
        }
        uwt.a(paramuwt).remove(paramuxr);
        uwt.a(paramuwt).add(i, paramuxr);
        if (QLog.isDebugVersion()) {
          veg.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", uwt.a(paramuwt));
        }
        if ((paramStoryVideoItem1.mTagInfoBase != null) && ((paramuxr instanceof uwi)))
        {
          paramStoryVideoItem2 = paramuxr.d;
          paramStoryVideoItem2.remove(paramStoryVideoItem1.mTagInfoBase);
          if (paramStoryVideoItem2.size() <= 0) {
            break label610;
          }
          paramStoryVideoItem2.add(0, paramStoryVideoItem1.mTagInfoBase);
        }
      }
      for (;;)
      {
        veg.d(this.TAG, "update tag list while publish , feedId :%s", new Object[] { paramuxr.a().feedId });
        uwt.a(paramuwt).a(paramuxr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
        return;
        label610:
        paramStoryVideoItem2.add(paramStoryVideoItem1.mTagInfoBase);
      }
    }
  }
  
  public void a(@NonNull uwt paramuwt, @NonNull svy paramsvy)
  {
    if (paramsvy.a())
    {
      veg.b(this.TAG, "group video upload");
      return;
    }
    Object localObject2;
    label33:
    Object localObject3;
    Object localObject1;
    if (paramsvy.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject2 = paramsvy.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (svx)((Iterator)localObject2).next();
        if (!(((svx)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
        {
          vxs.a("fake item type error", new Object[0]);
        }
        else
        {
          localObject1 = (ShareGroupItem)((svx)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner();
          if (uwt.a(paramuwt, ((ShareGroupItem)localObject1).shareGroupId))
          {
            localObject1 = uwt.a(paramuwt, uwt.a(paramuwt), ((ShareGroupItem)localObject1).shareGroupId, ((svx)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.date);
            if (localObject1 != null) {
              break label531;
            }
            if ((((svx)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
            {
              localObject1 = new uxo((ShareGroupFeedItem)((svx)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
              uwt.a(paramuwt).add(0, localObject1);
            }
            veg.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
          }
        }
      }
    }
    label531:
    for (;;)
    {
      if ((((svx)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem != null) && ((localObject1 instanceof uxo))) {
        ((uxr)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = ((svx)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem;
      }
      localObject3 = ((svx)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        svw localsvw = (svw)((Iterator)localObject3).next();
        a(paramuwt, (uxr)localObject1, paramsvy.jdField_a_of_type_Boolean, localsvw.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, localsvw.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      break label33;
      if ((!paramsvy.jdField_b_of_type_Boolean) || (!uwt.a(paramuwt))) {
        break;
      }
      if (paramsvy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem == null)
      {
        veg.d(this.TAG, "null pointer for feed item");
        return;
      }
      if (paramsvy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.getOwner() == null)
      {
        veg.d(this.TAG, "null pointer for feed item user");
        return;
      }
      veg.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramsvy);
      veg.b("Q.qqstory.home.data.HomeFeedPresenter", "home task state write temp:" + paramsvy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.hashCode());
      localObject2 = uwt.a(paramuwt, uwt.a(paramuwt), paramsvy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new uwi(paramsvy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
        int j = uwt.a(paramuwt).size();
        int i = 0;
        while (j > i)
        {
          localObject2 = (uxp)uwt.a(paramuwt).get(i);
          if ((!(localObject2 instanceof uxl)) || (!((HotRecommendFeedItem)((uxl)localObject2).a()).mIsTopLocation)) {
            break;
          }
          i += 1;
        }
        uwt.a(paramuwt).add(i, localObject1);
        veg.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
      }
      if (paramsvy.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)
      {
        ((uwi)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = paramsvy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
        ((uwi)localObject1).jdField_a_of_type_Boolean = false;
      }
      a(paramuwt, (uxr)localObject1, paramsvy.jdField_a_of_type_Boolean, paramsvy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramsvy.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return svy.class;
  }
  
  public void b(@NonNull uwt paramuwt, @NonNull svy paramsvy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxi
 * JD-Core Version:    0.7.0.1
 */