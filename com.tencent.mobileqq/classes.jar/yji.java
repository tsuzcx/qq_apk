import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class yji
  extends wfr<yjc, yiq>
{
  public yji(yjc paramyjc)
  {
    super(paramyjc);
  }
  
  public void a(@NonNull yjc paramyjc, @NonNull yiq paramyiq)
  {
    if (paramyiq.jdField_a_of_type_Int == 0) {
      return;
    }
    Object localObject = paramyjc.a(paramyiq.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramyiq.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof yir))
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramyiq.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (yir)localObject;
    FeedVideoInfo localFeedVideoInfo = ((yip)wpm.a(12)).a(paramyiq.jdField_a_of_type_JavaLangString, ((GeneralFeedItem)((yir)localObject).a).mVideoPullType);
    if (localFeedVideoInfo == null)
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find video info for feedId:%s, pullType:%d", new Object[] { paramyiq.jdField_a_of_type_JavaLangString, Integer.valueOf(((GeneralFeedItem)((yir)localObject).a).mVideoPullType) });
      return;
    }
    ((yir)localObject).c(localFeedVideoInfo.mVideoItemList, true);
    ((GeneralFeedItem)((yir)localObject).a).updateVideoInfo(localFeedVideoInfo);
    yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video and cookie update after count:%d", paramyiq.jdField_a_of_type_JavaLangString, Integer.valueOf(((yir)localObject).a().size()));
    yjc.a(paramyjc).a((yka)localObject);
  }
  
  public Class acceptEventClass()
  {
    return yiq.class;
  }
  
  public void b(@NonNull yjc paramyjc, @NonNull yiq paramyiq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yji
 * JD-Core Version:    0.7.0.1
 */