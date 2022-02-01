import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class xmi
  implements xmz
{
  private int jdField_a_of_type_Int;
  private final FeedBasePlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  private final xmh jdField_a_of_type_Xmh;
  private xna jdField_a_of_type_Xna;
  private ygh jdField_a_of_type_Ygh;
  protected final ymk a;
  
  public xmi(xmh paramxmh, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramFeedBasePlayInfo;
    this.jdField_a_of_type_Xmh = paramxmh;
    this.jdField_a_of_type_Ymk = ((ymk)wth.a(12));
  }
  
  private void a(ErrorMessage paramErrorMessage, xms paramxms)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramxms);
    this.jdField_a_of_type_Xna.a(paramErrorMessage, localArrayList);
  }
  
  private void a(List<StoryVideoItem> paramList, FeedVideoInfo paramFeedVideoInfo)
  {
    if (this.jdField_a_of_type_Xmh.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Xmh);
      return;
    }
    if (paramFeedVideoInfo == null) {}
    for (this.jdField_a_of_type_Ygh = new ygh(1, this.jdField_a_of_type_Xmh.a.jdField_a_of_type_JavaLangString, 0, -1);; this.jdField_a_of_type_Ygh = new ygh(1, paramFeedVideoInfo))
    {
      this.jdField_a_of_type_Ygh.a(new xmj(this, paramList));
      this.jdField_a_of_type_Ygh.c();
      yuk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d, %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Xmh);
      return;
      paramList.addAll(paramFeedVideoInfo.mVideoItemList);
    }
  }
  
  private void a(List<StoryVideoItem> paramList, String paramString)
  {
    paramList = xmg.a(paramList, paramString, this.jdField_a_of_type_Xmh);
    paramString = new ArrayList();
    paramString.add(paramList);
    this.jdField_a_of_type_Xna.a(paramString, true);
  }
  
  private void a(List<StoryVideoItem> paramList, ygk paramygk)
  {
    if (!paramygk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      b(paramList, paramygk);
      return;
    }
    if (paramygk.c) {
      paramList.clear();
    }
    paramList.addAll(paramygk.jdField_a_of_type_JavaUtilList);
    yuk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add video size:%d", Integer.valueOf(paramygk.jdField_a_of_type_JavaUtilList.size()));
    if ((!paramygk.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 20))
    {
      this.jdField_a_of_type_Int += 1;
      yuk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d", Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Ygh.c();
      return;
    }
    b(paramList, paramygk);
  }
  
  private void b(List<StoryVideoItem> paramList, ygk paramygk)
  {
    if (this.jdField_a_of_type_Xmh.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Xmh);
      return;
    }
    if (paramygk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo == null)
    {
      a(paramList, paramygk.jdField_a_of_type_JavaLangString);
      return;
    }
    Iterator localIterator;
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().a(this.jdField_a_of_type_Xmh.a.b))
    {
      if (xmg.a() == null) {
        xmg.c(((wte)wth.a(5)).a(true));
      }
      if (xmg.a().size() != 0)
      {
        localIterator = xmg.a().iterator();
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (localStoryVideoItem.mPublishDate.equals(this.jdField_a_of_type_Xmh.a.c))
          {
            yuk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add fail video %s", localStoryVideoItem);
            paramList.add(localStoryVideoItem);
          }
        }
        if (paramygk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType != 1) {
          break label264;
        }
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      Collections.sort(paramList, new yny(bool));
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
    paramygk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = ((ymk)wth.a(12)).a(1, paramygk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.feedId, paramygk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoSeq, paramList, paramygk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoNextCookie, paramygk.jdField_a_of_type_Boolean, paramygk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo.mVideoPullType, true);
    a(paramList, paramygk.jdField_a_of_type_JavaLangString);
  }
  
  public void a(xna paramxna)
  {
    if (this.jdField_a_of_type_Xmh.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Xmh);
      return;
    }
    this.jdField_a_of_type_Xna = paramxna;
    int i = xmg.a(this.jdField_a_of_type_Xmh, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
    Object localObject = new ArrayList();
    paramxna = this.jdField_a_of_type_Ymk.a(this.jdField_a_of_type_Xmh.a.jdField_a_of_type_JavaLangString, i);
    if ((paramxna != null) && (paramxna.mIsVideoEnd) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache))
    {
      localObject = paramxna.mVideoItemList;
      paramxna = paramxna.feedId;
      yuk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return from cache %s", paramxna);
      a((List)localObject, paramxna);
      return;
    }
    a((List)localObject, paramxna);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmi
 * JD-Core Version:    0.7.0.1
 */