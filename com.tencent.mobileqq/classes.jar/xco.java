import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class xco
  implements xdf
{
  private int jdField_a_of_type_Int;
  private final FeedBasePlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  private final xcn jdField_a_of_type_Xcn;
  private xdg jdField_a_of_type_Xdg;
  private xwn jdField_a_of_type_Xwn;
  protected final ycq a;
  
  public xco(xcn paramxcn, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramFeedBasePlayInfo;
    this.jdField_a_of_type_Xcn = paramxcn;
    this.jdField_a_of_type_Ycq = ((ycq)wjs.a(12));
  }
  
  private void a(ErrorMessage paramErrorMessage, xcy paramxcy)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramxcy);
    this.jdField_a_of_type_Xdg.a(paramErrorMessage, localArrayList);
  }
  
  private void a(List<StoryVideoItem> paramList, FeedVideoInfo paramFeedVideoInfo)
  {
    if (this.jdField_a_of_type_Xcn.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Xcn);
      return;
    }
    if (paramFeedVideoInfo == null) {}
    for (this.jdField_a_of_type_Xwn = new xwn(1, this.jdField_a_of_type_Xcn.a.jdField_a_of_type_JavaLangString, 0, -1);; this.jdField_a_of_type_Xwn = new xwn(1, paramFeedVideoInfo))
    {
      this.jdField_a_of_type_Xwn.a(new xcp(this, paramList));
      this.jdField_a_of_type_Xwn.c();
      ykq.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d, %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Xcn);
      return;
      paramList.addAll(paramFeedVideoInfo.mVideoItemList);
    }
  }
  
  private void a(List<StoryVideoItem> paramList, String paramString)
  {
    paramList = xcm.a(paramList, paramString, this.jdField_a_of_type_Xcn);
    paramString = new ArrayList();
    paramString.add(paramList);
    this.jdField_a_of_type_Xdg.a(paramString, true);
  }
  
  private void a(List<StoryVideoItem> paramList, xwq paramxwq)
  {
    if (!paramxwq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      b(paramList, paramxwq);
      return;
    }
    if (paramxwq.c) {
      paramList.clear();
    }
    paramList.addAll(paramxwq.jdField_a_of_type_JavaUtilList);
    ykq.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add video size:%d", Integer.valueOf(paramxwq.jdField_a_of_type_JavaUtilList.size()));
    if ((!paramxwq.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 20))
    {
      this.jdField_a_of_type_Int += 1;
      ykq.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d", Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Xwn.c();
      return;
    }
    b(paramList, paramxwq);
  }
  
  private void b(List<StoryVideoItem> paramList, xwq paramxwq)
  {
    if (this.jdField_a_of_type_Xcn.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Xcn);
      return;
    }
    if (paramxwq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo == null)
    {
      a(paramList, paramxwq.jdField_a_of_type_JavaLangString);
      return;
    }
    Iterator localIterator;
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().a(this.jdField_a_of_type_Xcn.a.b))
    {
      if (xcm.a() == null) {
        xcm.c(((wjp)wjs.a(5)).a(true));
      }
      if (xcm.a().size() != 0)
      {
        localIterator = xcm.a().iterator();
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (localStoryVideoItem.mPublishDate.equals(this.jdField_a_of_type_Xcn.a.c))
          {
            ykq.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add fail video %s", localStoryVideoItem);
            paramList.add(localStoryVideoItem);
          }
        }
        if (paramxwq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType != 1) {
          break label264;
        }
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      Collections.sort(paramList, new yee(bool));
      localIterator = paramList.iterator();
      paramList = new ArrayList(paramList.size());
      while (localIterator.hasNext())
      {
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
        if (!paramList.contains(localStoryVideoItem)) {
          paramList.add(localStoryVideoItem);
        }
      }
    }
    paramxwq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = ((ycq)wjs.a(12)).a(1, paramxwq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.feedId, paramxwq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoSeq, paramList, paramxwq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoNextCookie, paramxwq.jdField_a_of_type_Boolean, paramxwq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType, true);
    a(paramList, paramxwq.jdField_a_of_type_JavaLangString);
  }
  
  public void a(xdg paramxdg)
  {
    if (this.jdField_a_of_type_Xcn.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Xcn);
      return;
    }
    this.jdField_a_of_type_Xdg = paramxdg;
    int i = xcm.a(this.jdField_a_of_type_Xcn, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
    Object localObject = new ArrayList();
    paramxdg = this.jdField_a_of_type_Ycq.a(this.jdField_a_of_type_Xcn.a.jdField_a_of_type_JavaLangString, i);
    if ((paramxdg != null) && (paramxdg.mIsVideoEnd) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache))
    {
      localObject = paramxdg.mVideoItemList;
      paramxdg = paramxdg.feedId;
      ykq.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return from cache %s", paramxdg);
      a((List)localObject, paramxdg);
      return;
    }
    a((List)localObject, paramxdg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xco
 * JD-Core Version:    0.7.0.1
 */