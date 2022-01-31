import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class tji
  implements tjz
{
  private int jdField_a_of_type_Int;
  private final FeedBasePlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  private final tjh jdField_a_of_type_Tjh;
  private tka jdField_a_of_type_Tka;
  private udh jdField_a_of_type_Udh;
  protected final ujk a;
  
  public tji(tjh paramtjh, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramFeedBasePlayInfo;
    this.jdField_a_of_type_Tjh = paramtjh;
    this.jdField_a_of_type_Ujk = ((ujk)sqg.a(12));
  }
  
  private void a(ErrorMessage paramErrorMessage, tjs paramtjs)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramtjs);
    this.jdField_a_of_type_Tka.a(paramErrorMessage, localArrayList);
  }
  
  private void a(List<StoryVideoItem> paramList, FeedVideoInfo paramFeedVideoInfo)
  {
    if (this.jdField_a_of_type_Tjh.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Tjh);
      return;
    }
    if (paramFeedVideoInfo == null) {}
    for (this.jdField_a_of_type_Udh = new udh(1, this.jdField_a_of_type_Tjh.a.jdField_a_of_type_JavaLangString, 0, -1);; this.jdField_a_of_type_Udh = new udh(1, paramFeedVideoInfo))
    {
      this.jdField_a_of_type_Udh.a(new tjj(this, paramList));
      this.jdField_a_of_type_Udh.c();
      urk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d, %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Tjh);
      return;
      paramList.addAll(paramFeedVideoInfo.mVideoItemList);
    }
  }
  
  private void a(List<StoryVideoItem> paramList, String paramString)
  {
    paramList = tjg.a(paramList, paramString, this.jdField_a_of_type_Tjh);
    paramString = new ArrayList();
    paramString.add(paramList);
    this.jdField_a_of_type_Tka.a(paramString, true);
  }
  
  private void a(List<StoryVideoItem> paramList, udk paramudk)
  {
    if (!paramudk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      b(paramList, paramudk);
      return;
    }
    if (paramudk.c) {
      paramList.clear();
    }
    paramList.addAll(paramudk.jdField_a_of_type_JavaUtilList);
    urk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add video size:%d", Integer.valueOf(paramudk.jdField_a_of_type_JavaUtilList.size()));
    if ((!paramudk.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 20))
    {
      this.jdField_a_of_type_Int += 1;
      urk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d", Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Udh.c();
      return;
    }
    b(paramList, paramudk);
  }
  
  private void b(List<StoryVideoItem> paramList, udk paramudk)
  {
    if (this.jdField_a_of_type_Tjh.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Tjh);
      return;
    }
    if (paramudk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo == null)
    {
      a(paramList, paramudk.jdField_a_of_type_JavaLangString);
      return;
    }
    Iterator localIterator;
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().a(this.jdField_a_of_type_Tjh.a.b))
    {
      if (tjg.a() == null) {
        tjg.c(((sqd)sqg.a(5)).a(true));
      }
      if (tjg.a().size() != 0)
      {
        localIterator = tjg.a().iterator();
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (localStoryVideoItem.mPublishDate.equals(this.jdField_a_of_type_Tjh.a.c))
          {
            urk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add fail video %s", localStoryVideoItem);
            paramList.add(localStoryVideoItem);
          }
        }
        if (paramudk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType != 1) {
          break label264;
        }
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      Collections.sort(paramList, new uky(bool));
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
    paramudk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = ((ujk)sqg.a(12)).a(1, paramudk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.feedId, paramudk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoSeq, paramList, paramudk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoNextCookie, paramudk.jdField_a_of_type_Boolean, paramudk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType, true);
    a(paramList, paramudk.jdField_a_of_type_JavaLangString);
  }
  
  public void a(tka paramtka)
  {
    if (this.jdField_a_of_type_Tjh.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Tjh);
      return;
    }
    this.jdField_a_of_type_Tka = paramtka;
    int i = tjg.a(this.jdField_a_of_type_Tjh, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
    Object localObject = new ArrayList();
    paramtka = this.jdField_a_of_type_Ujk.a(this.jdField_a_of_type_Tjh.a.jdField_a_of_type_JavaLangString, i);
    if ((paramtka != null) && (paramtka.mIsVideoEnd) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache))
    {
      localObject = paramtka.mVideoItemList;
      paramtka = paramtka.feedId;
      urk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return from cache %s", paramtka);
      a((List)localObject, paramtka);
      return;
    }
    a((List)localObject, paramtka);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tji
 * JD-Core Version:    0.7.0.1
 */