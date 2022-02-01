import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class wnt
  implements wok
{
  private int jdField_a_of_type_Int;
  private final FeedBasePlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  private final wns jdField_a_of_type_Wns;
  private wol jdField_a_of_type_Wol;
  private xhs jdField_a_of_type_Xhs;
  protected final xnv a;
  
  public wnt(wns paramwns, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramFeedBasePlayInfo;
    this.jdField_a_of_type_Wns = paramwns;
    this.jdField_a_of_type_Xnv = ((xnv)vux.a(12));
  }
  
  private void a(ErrorMessage paramErrorMessage, wod paramwod)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramwod);
    this.jdField_a_of_type_Wol.a(paramErrorMessage, localArrayList);
  }
  
  private void a(List<StoryVideoItem> paramList, FeedVideoInfo paramFeedVideoInfo)
  {
    if (this.jdField_a_of_type_Wns.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Wns);
      return;
    }
    if (paramFeedVideoInfo == null) {}
    for (this.jdField_a_of_type_Xhs = new xhs(1, this.jdField_a_of_type_Wns.a.jdField_a_of_type_JavaLangString, 0, -1);; this.jdField_a_of_type_Xhs = new xhs(1, paramFeedVideoInfo))
    {
      this.jdField_a_of_type_Xhs.a(new wnu(this, paramList));
      this.jdField_a_of_type_Xhs.c();
      xvv.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d, %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Wns);
      return;
      paramList.addAll(paramFeedVideoInfo.mVideoItemList);
    }
  }
  
  private void a(List<StoryVideoItem> paramList, String paramString)
  {
    paramList = wnr.a(paramList, paramString, this.jdField_a_of_type_Wns);
    paramString = new ArrayList();
    paramString.add(paramList);
    this.jdField_a_of_type_Wol.a(paramString, true);
  }
  
  private void a(List<StoryVideoItem> paramList, xhv paramxhv)
  {
    if (!paramxhv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      b(paramList, paramxhv);
      return;
    }
    if (paramxhv.c) {
      paramList.clear();
    }
    paramList.addAll(paramxhv.jdField_a_of_type_JavaUtilList);
    xvv.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add video size:%d", Integer.valueOf(paramxhv.jdField_a_of_type_JavaUtilList.size()));
    if ((!paramxhv.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 20))
    {
      this.jdField_a_of_type_Int += 1;
      xvv.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d", Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Xhs.c();
      return;
    }
    b(paramList, paramxhv);
  }
  
  private void b(List<StoryVideoItem> paramList, xhv paramxhv)
  {
    if (this.jdField_a_of_type_Wns.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Wns);
      return;
    }
    if (paramxhv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo == null)
    {
      a(paramList, paramxhv.jdField_a_of_type_JavaLangString);
      return;
    }
    Iterator localIterator;
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().a(this.jdField_a_of_type_Wns.a.b))
    {
      if (wnr.a() == null) {
        wnr.c(((vuu)vux.a(5)).a(true));
      }
      if (wnr.a().size() != 0)
      {
        localIterator = wnr.a().iterator();
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (localStoryVideoItem.mPublishDate.equals(this.jdField_a_of_type_Wns.a.c))
          {
            xvv.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add fail video %s", localStoryVideoItem);
            paramList.add(localStoryVideoItem);
          }
        }
        if (paramxhv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType != 1) {
          break label264;
        }
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      Collections.sort(paramList, new xpj(bool));
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
    paramxhv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = ((xnv)vux.a(12)).a(1, paramxhv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.feedId, paramxhv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoSeq, paramList, paramxhv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoNextCookie, paramxhv.jdField_a_of_type_Boolean, paramxhv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType, true);
    a(paramList, paramxhv.jdField_a_of_type_JavaLangString);
  }
  
  public void a(wol paramwol)
  {
    if (this.jdField_a_of_type_Wns.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Wns);
      return;
    }
    this.jdField_a_of_type_Wol = paramwol;
    int i = wnr.a(this.jdField_a_of_type_Wns, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
    Object localObject = new ArrayList();
    paramwol = this.jdField_a_of_type_Xnv.a(this.jdField_a_of_type_Wns.a.jdField_a_of_type_JavaLangString, i);
    if ((paramwol != null) && (paramwol.mIsVideoEnd) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache))
    {
      localObject = paramwol.mVideoItemList;
      paramwol = paramwol.feedId;
      xvv.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return from cache %s", paramwol);
      a((List)localObject, paramwol);
      return;
    }
    a((List)localObject, paramwol);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnt
 * JD-Core Version:    0.7.0.1
 */