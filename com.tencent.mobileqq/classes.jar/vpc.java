import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class vpc
  implements vpt
{
  private int jdField_a_of_type_Int;
  private final FeedBasePlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  private final vpb jdField_a_of_type_Vpb;
  private vpu jdField_a_of_type_Vpu;
  private wjb jdField_a_of_type_Wjb;
  protected final wpe a;
  
  public vpc(vpb paramvpb, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramFeedBasePlayInfo;
    this.jdField_a_of_type_Vpb = paramvpb;
    this.jdField_a_of_type_Wpe = ((wpe)uwa.a(12));
  }
  
  private void a(ErrorMessage paramErrorMessage, vpm paramvpm)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramvpm);
    this.jdField_a_of_type_Vpu.a(paramErrorMessage, localArrayList);
  }
  
  private void a(List<StoryVideoItem> paramList, FeedVideoInfo paramFeedVideoInfo)
  {
    if (this.jdField_a_of_type_Vpb.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Vpb);
      return;
    }
    if (paramFeedVideoInfo == null) {}
    for (this.jdField_a_of_type_Wjb = new wjb(1, this.jdField_a_of_type_Vpb.a.jdField_a_of_type_JavaLangString, 0, -1);; this.jdField_a_of_type_Wjb = new wjb(1, paramFeedVideoInfo))
    {
      this.jdField_a_of_type_Wjb.a(new vpd(this, paramList));
      this.jdField_a_of_type_Wjb.c();
      wxe.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d, %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Vpb);
      return;
      paramList.addAll(paramFeedVideoInfo.mVideoItemList);
    }
  }
  
  private void a(List<StoryVideoItem> paramList, String paramString)
  {
    paramList = vpa.a(paramList, paramString, this.jdField_a_of_type_Vpb);
    paramString = new ArrayList();
    paramString.add(paramList);
    this.jdField_a_of_type_Vpu.a(paramString, true);
  }
  
  private void a(List<StoryVideoItem> paramList, wje paramwje)
  {
    if (!paramwje.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      b(paramList, paramwje);
      return;
    }
    if (paramwje.c) {
      paramList.clear();
    }
    paramList.addAll(paramwje.jdField_a_of_type_JavaUtilList);
    wxe.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add video size:%d", Integer.valueOf(paramwje.jdField_a_of_type_JavaUtilList.size()));
    if ((!paramwje.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 20))
    {
      this.jdField_a_of_type_Int += 1;
      wxe.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d", Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Wjb.c();
      return;
    }
    b(paramList, paramwje);
  }
  
  private void b(List<StoryVideoItem> paramList, wje paramwje)
  {
    if (this.jdField_a_of_type_Vpb.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Vpb);
      return;
    }
    if (paramwje.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo == null)
    {
      a(paramList, paramwje.jdField_a_of_type_JavaLangString);
      return;
    }
    Iterator localIterator;
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().a(this.jdField_a_of_type_Vpb.a.b))
    {
      if (vpa.a() == null) {
        vpa.c(((uvx)uwa.a(5)).a(true));
      }
      if (vpa.a().size() != 0)
      {
        localIterator = vpa.a().iterator();
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (localStoryVideoItem.mPublishDate.equals(this.jdField_a_of_type_Vpb.a.c))
          {
            wxe.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add fail video %s", localStoryVideoItem);
            paramList.add(localStoryVideoItem);
          }
        }
        if (paramwje.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType != 1) {
          break label264;
        }
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      Collections.sort(paramList, new wqs(bool));
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
    paramwje.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = ((wpe)uwa.a(12)).a(1, paramwje.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.feedId, paramwje.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoSeq, paramList, paramwje.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoNextCookie, paramwje.jdField_a_of_type_Boolean, paramwje.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType, true);
    a(paramList, paramwje.jdField_a_of_type_JavaLangString);
  }
  
  public void a(vpu paramvpu)
  {
    if (this.jdField_a_of_type_Vpb.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Vpb);
      return;
    }
    this.jdField_a_of_type_Vpu = paramvpu;
    int i = vpa.a(this.jdField_a_of_type_Vpb, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
    Object localObject = new ArrayList();
    paramvpu = this.jdField_a_of_type_Wpe.a(this.jdField_a_of_type_Vpb.a.jdField_a_of_type_JavaLangString, i);
    if ((paramvpu != null) && (paramvpu.mIsVideoEnd) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache))
    {
      localObject = paramvpu.mVideoItemList;
      paramvpu = paramvpu.feedId;
      wxe.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return from cache %s", paramvpu);
      a((List)localObject, paramvpu);
      return;
    }
    a((List)localObject, paramvpu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpc
 * JD-Core Version:    0.7.0.1
 */