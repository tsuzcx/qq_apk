import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class twe
  implements twv
{
  private int jdField_a_of_type_Int;
  private final FeedBasePlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  private final twd jdField_a_of_type_Twd;
  private tww jdField_a_of_type_Tww;
  private uqd jdField_a_of_type_Uqd;
  protected final uwg a;
  
  public twe(twd paramtwd, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramFeedBasePlayInfo;
    this.jdField_a_of_type_Twd = paramtwd;
    this.jdField_a_of_type_Uwg = ((uwg)tdc.a(12));
  }
  
  private void a(ErrorMessage paramErrorMessage, two paramtwo)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramtwo);
    this.jdField_a_of_type_Tww.a(paramErrorMessage, localArrayList);
  }
  
  private void a(List<StoryVideoItem> paramList, FeedVideoInfo paramFeedVideoInfo)
  {
    if (this.jdField_a_of_type_Twd.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Twd);
      return;
    }
    if (paramFeedVideoInfo == null) {}
    for (this.jdField_a_of_type_Uqd = new uqd(1, this.jdField_a_of_type_Twd.a.jdField_a_of_type_JavaLangString, 0, -1);; this.jdField_a_of_type_Uqd = new uqd(1, paramFeedVideoInfo))
    {
      this.jdField_a_of_type_Uqd.a(new twf(this, paramList));
      this.jdField_a_of_type_Uqd.c();
      veg.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d, %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Twd);
      return;
      paramList.addAll(paramFeedVideoInfo.mVideoItemList);
    }
  }
  
  private void a(List<StoryVideoItem> paramList, String paramString)
  {
    paramList = twc.a(paramList, paramString, this.jdField_a_of_type_Twd);
    paramString = new ArrayList();
    paramString.add(paramList);
    this.jdField_a_of_type_Tww.a(paramString, true);
  }
  
  private void a(List<StoryVideoItem> paramList, uqg paramuqg)
  {
    if (!paramuqg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      b(paramList, paramuqg);
      return;
    }
    if (paramuqg.c) {
      paramList.clear();
    }
    paramList.addAll(paramuqg.jdField_a_of_type_JavaUtilList);
    veg.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add video size:%d", Integer.valueOf(paramuqg.jdField_a_of_type_JavaUtilList.size()));
    if ((!paramuqg.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 20))
    {
      this.jdField_a_of_type_Int += 1;
      veg.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d", Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Uqd.c();
      return;
    }
    b(paramList, paramuqg);
  }
  
  private void b(List<StoryVideoItem> paramList, uqg paramuqg)
  {
    if (this.jdField_a_of_type_Twd.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Twd);
      return;
    }
    if (paramuqg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo == null)
    {
      a(paramList, paramuqg.jdField_a_of_type_JavaLangString);
      return;
    }
    Iterator localIterator;
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().a(this.jdField_a_of_type_Twd.a.b))
    {
      if (twc.a() == null) {
        twc.c(((tcz)tdc.a(5)).a(true));
      }
      if (twc.a().size() != 0)
      {
        localIterator = twc.a().iterator();
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (localStoryVideoItem.mPublishDate.equals(this.jdField_a_of_type_Twd.a.c))
          {
            veg.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add fail video %s", localStoryVideoItem);
            paramList.add(localStoryVideoItem);
          }
        }
        if (paramuqg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType != 1) {
          break label264;
        }
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      Collections.sort(paramList, new uxu(bool));
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
    paramuqg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = ((uwg)tdc.a(12)).a(1, paramuqg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.feedId, paramuqg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoSeq, paramList, paramuqg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoNextCookie, paramuqg.jdField_a_of_type_Boolean, paramuqg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType, true);
    a(paramList, paramuqg.jdField_a_of_type_JavaLangString);
  }
  
  public void a(tww paramtww)
  {
    if (this.jdField_a_of_type_Twd.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Twd);
      return;
    }
    this.jdField_a_of_type_Tww = paramtww;
    int i = twc.a(this.jdField_a_of_type_Twd, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
    Object localObject = new ArrayList();
    paramtww = this.jdField_a_of_type_Uwg.a(this.jdField_a_of_type_Twd.a.jdField_a_of_type_JavaLangString, i);
    if ((paramtww != null) && (paramtww.mIsVideoEnd) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache))
    {
      localObject = paramtww.mVideoItemList;
      paramtww = paramtww.feedId;
      veg.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return from cache %s", paramtww);
      a((List)localObject, paramtww);
      return;
    }
    a((List)localObject, paramtww);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twe
 * JD-Core Version:    0.7.0.1
 */