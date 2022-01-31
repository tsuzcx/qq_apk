import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class twb
  implements tws
{
  private int jdField_a_of_type_Int;
  private final FeedBasePlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  private final twa jdField_a_of_type_Twa;
  private twt jdField_a_of_type_Twt;
  private uqa jdField_a_of_type_Uqa;
  protected final uwd a;
  
  public twb(twa paramtwa, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramFeedBasePlayInfo;
    this.jdField_a_of_type_Twa = paramtwa;
    this.jdField_a_of_type_Uwd = ((uwd)tcz.a(12));
  }
  
  private void a(ErrorMessage paramErrorMessage, twl paramtwl)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramtwl);
    this.jdField_a_of_type_Twt.a(paramErrorMessage, localArrayList);
  }
  
  private void a(List<StoryVideoItem> paramList, FeedVideoInfo paramFeedVideoInfo)
  {
    if (this.jdField_a_of_type_Twa.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Twa);
      return;
    }
    if (paramFeedVideoInfo == null) {}
    for (this.jdField_a_of_type_Uqa = new uqa(1, this.jdField_a_of_type_Twa.a.jdField_a_of_type_JavaLangString, 0, -1);; this.jdField_a_of_type_Uqa = new uqa(1, paramFeedVideoInfo))
    {
      this.jdField_a_of_type_Uqa.a(new twc(this, paramList));
      this.jdField_a_of_type_Uqa.c();
      ved.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d, %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Twa);
      return;
      paramList.addAll(paramFeedVideoInfo.mVideoItemList);
    }
  }
  
  private void a(List<StoryVideoItem> paramList, String paramString)
  {
    paramList = tvz.a(paramList, paramString, this.jdField_a_of_type_Twa);
    paramString = new ArrayList();
    paramString.add(paramList);
    this.jdField_a_of_type_Twt.a(paramString, true);
  }
  
  private void a(List<StoryVideoItem> paramList, uqd paramuqd)
  {
    if (!paramuqd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      b(paramList, paramuqd);
      return;
    }
    if (paramuqd.c) {
      paramList.clear();
    }
    paramList.addAll(paramuqd.jdField_a_of_type_JavaUtilList);
    ved.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add video size:%d", Integer.valueOf(paramuqd.jdField_a_of_type_JavaUtilList.size()));
    if ((!paramuqd.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 20))
    {
      this.jdField_a_of_type_Int += 1;
      ved.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d", Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Uqa.c();
      return;
    }
    b(paramList, paramuqd);
  }
  
  private void b(List<StoryVideoItem> paramList, uqd paramuqd)
  {
    if (this.jdField_a_of_type_Twa.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Twa);
      return;
    }
    if (paramuqd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo == null)
    {
      a(paramList, paramuqd.jdField_a_of_type_JavaLangString);
      return;
    }
    Iterator localIterator;
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().a(this.jdField_a_of_type_Twa.a.b))
    {
      if (tvz.a() == null) {
        tvz.c(((tcw)tcz.a(5)).a(true));
      }
      if (tvz.a().size() != 0)
      {
        localIterator = tvz.a().iterator();
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (localStoryVideoItem.mPublishDate.equals(this.jdField_a_of_type_Twa.a.c))
          {
            ved.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add fail video %s", localStoryVideoItem);
            paramList.add(localStoryVideoItem);
          }
        }
        if (paramuqd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType != 1) {
          break label264;
        }
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      Collections.sort(paramList, new uxr(bool));
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
    paramuqd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = ((uwd)tcz.a(12)).a(1, paramuqd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.feedId, paramuqd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoSeq, paramList, paramuqd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoNextCookie, paramuqd.jdField_a_of_type_Boolean, paramuqd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType, true);
    a(paramList, paramuqd.jdField_a_of_type_JavaLangString);
  }
  
  public void a(twt paramtwt)
  {
    if (this.jdField_a_of_type_Twa.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Twa);
      return;
    }
    this.jdField_a_of_type_Twt = paramtwt;
    int i = tvz.a(this.jdField_a_of_type_Twa, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
    Object localObject = new ArrayList();
    paramtwt = this.jdField_a_of_type_Uwd.a(this.jdField_a_of_type_Twa.a.jdField_a_of_type_JavaLangString, i);
    if ((paramtwt != null) && (paramtwt.mIsVideoEnd) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache))
    {
      localObject = paramtwt.mVideoItemList;
      paramtwt = paramtwt.feedId;
      ved.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return from cache %s", paramtwt);
      a((List)localObject, paramtwt);
      return;
    }
    a((List)localObject, paramtwt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twb
 * JD-Core Version:    0.7.0.1
 */