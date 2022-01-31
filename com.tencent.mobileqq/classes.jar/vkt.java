import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class vkt
  implements vlk
{
  private int jdField_a_of_type_Int;
  private final FeedBasePlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  private final vks jdField_a_of_type_Vks;
  private vll jdField_a_of_type_Vll;
  private wes jdField_a_of_type_Wes;
  protected final wkv a;
  
  public vkt(vks paramvks, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramFeedBasePlayInfo;
    this.jdField_a_of_type_Vks = paramvks;
    this.jdField_a_of_type_Wkv = ((wkv)urr.a(12));
  }
  
  private void a(ErrorMessage paramErrorMessage, vld paramvld)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramvld);
    this.jdField_a_of_type_Vll.a(paramErrorMessage, localArrayList);
  }
  
  private void a(List<StoryVideoItem> paramList, FeedVideoInfo paramFeedVideoInfo)
  {
    if (this.jdField_a_of_type_Vks.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Vks);
      return;
    }
    if (paramFeedVideoInfo == null) {}
    for (this.jdField_a_of_type_Wes = new wes(1, this.jdField_a_of_type_Vks.a.jdField_a_of_type_JavaLangString, 0, -1);; this.jdField_a_of_type_Wes = new wes(1, paramFeedVideoInfo))
    {
      this.jdField_a_of_type_Wes.a(new vku(this, paramList));
      this.jdField_a_of_type_Wes.c();
      wsv.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d, %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Vks);
      return;
      paramList.addAll(paramFeedVideoInfo.mVideoItemList);
    }
  }
  
  private void a(List<StoryVideoItem> paramList, String paramString)
  {
    paramList = vkr.a(paramList, paramString, this.jdField_a_of_type_Vks);
    paramString = new ArrayList();
    paramString.add(paramList);
    this.jdField_a_of_type_Vll.a(paramString, true);
  }
  
  private void a(List<StoryVideoItem> paramList, wev paramwev)
  {
    if (!paramwev.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      b(paramList, paramwev);
      return;
    }
    if (paramwev.c) {
      paramList.clear();
    }
    paramList.addAll(paramwev.jdField_a_of_type_JavaUtilList);
    wsv.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add video size:%d", Integer.valueOf(paramwev.jdField_a_of_type_JavaUtilList.size()));
    if ((!paramwev.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 20))
    {
      this.jdField_a_of_type_Int += 1;
      wsv.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d", Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Wes.c();
      return;
    }
    b(paramList, paramwev);
  }
  
  private void b(List<StoryVideoItem> paramList, wev paramwev)
  {
    if (this.jdField_a_of_type_Vks.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Vks);
      return;
    }
    if (paramwev.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo == null)
    {
      a(paramList, paramwev.jdField_a_of_type_JavaLangString);
      return;
    }
    Iterator localIterator;
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().a(this.jdField_a_of_type_Vks.a.b))
    {
      if (vkr.a() == null) {
        vkr.c(((uro)urr.a(5)).a(true));
      }
      if (vkr.a().size() != 0)
      {
        localIterator = vkr.a().iterator();
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (localStoryVideoItem.mPublishDate.equals(this.jdField_a_of_type_Vks.a.c))
          {
            wsv.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add fail video %s", localStoryVideoItem);
            paramList.add(localStoryVideoItem);
          }
        }
        if (paramwev.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType != 1) {
          break label264;
        }
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      Collections.sort(paramList, new wmj(bool));
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
    paramwev.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = ((wkv)urr.a(12)).a(1, paramwev.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.feedId, paramwev.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoSeq, paramList, paramwev.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoNextCookie, paramwev.jdField_a_of_type_Boolean, paramwev.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType, true);
    a(paramList, paramwev.jdField_a_of_type_JavaLangString);
  }
  
  public void a(vll paramvll)
  {
    if (this.jdField_a_of_type_Vks.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Vks);
      return;
    }
    this.jdField_a_of_type_Vll = paramvll;
    int i = vkr.a(this.jdField_a_of_type_Vks, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
    Object localObject = new ArrayList();
    paramvll = this.jdField_a_of_type_Wkv.a(this.jdField_a_of_type_Vks.a.jdField_a_of_type_JavaLangString, i);
    if ((paramvll != null) && (paramvll.mIsVideoEnd) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache))
    {
      localObject = paramvll.mVideoItemList;
      paramvll = paramvll.feedId;
      wsv.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return from cache %s", paramvll);
      a((List)localObject, paramvll);
      return;
    }
    a((List)localObject, paramvll);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vkt
 * JD-Core Version:    0.7.0.1
 */