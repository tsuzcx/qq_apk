import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class xin
  implements xje
{
  private int jdField_a_of_type_Int;
  private final FeedBasePlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  private final xim jdField_a_of_type_Xim;
  private xjf jdField_a_of_type_Xjf;
  private ycm jdField_a_of_type_Ycm;
  protected final yip a;
  
  public xin(xim paramxim, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramFeedBasePlayInfo;
    this.jdField_a_of_type_Xim = paramxim;
    this.jdField_a_of_type_Yip = ((yip)wpm.a(12));
  }
  
  private void a(ErrorMessage paramErrorMessage, xix paramxix)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramxix);
    this.jdField_a_of_type_Xjf.a(paramErrorMessage, localArrayList);
  }
  
  private void a(List<StoryVideoItem> paramList, FeedVideoInfo paramFeedVideoInfo)
  {
    if (this.jdField_a_of_type_Xim.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Xim);
      return;
    }
    if (paramFeedVideoInfo == null) {}
    for (this.jdField_a_of_type_Ycm = new ycm(1, this.jdField_a_of_type_Xim.a.jdField_a_of_type_JavaLangString, 0, -1);; this.jdField_a_of_type_Ycm = new ycm(1, paramFeedVideoInfo))
    {
      this.jdField_a_of_type_Ycm.a(new xio(this, paramList));
      this.jdField_a_of_type_Ycm.c();
      yqp.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d, %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Xim);
      return;
      paramList.addAll(paramFeedVideoInfo.mVideoItemList);
    }
  }
  
  private void a(List<StoryVideoItem> paramList, String paramString)
  {
    paramList = xil.a(paramList, paramString, this.jdField_a_of_type_Xim);
    paramString = new ArrayList();
    paramString.add(paramList);
    this.jdField_a_of_type_Xjf.a(paramString, true);
  }
  
  private void a(List<StoryVideoItem> paramList, ycp paramycp)
  {
    if (!paramycp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      b(paramList, paramycp);
      return;
    }
    if (paramycp.c) {
      paramList.clear();
    }
    paramList.addAll(paramycp.jdField_a_of_type_JavaUtilList);
    yqp.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add video size:%d", Integer.valueOf(paramycp.jdField_a_of_type_JavaUtilList.size()));
    if ((!paramycp.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 20))
    {
      this.jdField_a_of_type_Int += 1;
      yqp.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d", Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Ycm.c();
      return;
    }
    b(paramList, paramycp);
  }
  
  private void b(List<StoryVideoItem> paramList, ycp paramycp)
  {
    if (this.jdField_a_of_type_Xim.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Xim);
      return;
    }
    if (paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo == null)
    {
      a(paramList, paramycp.jdField_a_of_type_JavaLangString);
      return;
    }
    Iterator localIterator;
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().a(this.jdField_a_of_type_Xim.a.b))
    {
      if (xil.a() == null) {
        xil.c(((wpj)wpm.a(5)).a(true));
      }
      if (xil.a().size() != 0)
      {
        localIterator = xil.a().iterator();
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (localStoryVideoItem.mPublishDate.equals(this.jdField_a_of_type_Xim.a.c))
          {
            yqp.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add fail video %s", localStoryVideoItem);
            paramList.add(localStoryVideoItem);
          }
        }
        if (paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType != 1) {
          break label264;
        }
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      Collections.sort(paramList, new ykd(bool));
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
    paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = ((yip)wpm.a(12)).a(1, paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.feedId, paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoSeq, paramList, paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoNextCookie, paramycp.jdField_a_of_type_Boolean, paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType, true);
    a(paramList, paramycp.jdField_a_of_type_JavaLangString);
  }
  
  public void a(xjf paramxjf)
  {
    if (this.jdField_a_of_type_Xim.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Xim);
      return;
    }
    this.jdField_a_of_type_Xjf = paramxjf;
    int i = xil.a(this.jdField_a_of_type_Xim, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
    Object localObject = new ArrayList();
    paramxjf = this.jdField_a_of_type_Yip.a(this.jdField_a_of_type_Xim.a.jdField_a_of_type_JavaLangString, i);
    if ((paramxjf != null) && (paramxjf.mIsVideoEnd) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache))
    {
      localObject = paramxjf.mVideoItemList;
      paramxjf = paramxjf.feedId;
      yqp.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return from cache %s", paramxjf);
      a((List)localObject, paramxjf);
      return;
    }
    a((List)localObject, paramxjf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xin
 * JD-Core Version:    0.7.0.1
 */