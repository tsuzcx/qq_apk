import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class ydj
  extends wag<ydd, ycr>
{
  public ydj(ydd paramydd)
  {
    super(paramydd);
  }
  
  public void a(@NonNull ydd paramydd, @NonNull ycr paramycr)
  {
    if (paramycr.jdField_a_of_type_Int == 0) {
      return;
    }
    Object localObject = paramydd.a(paramycr.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramycr.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof ycs))
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramycr.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (ycs)localObject;
    FeedVideoInfo localFeedVideoInfo = ((ycq)wjs.a(12)).a(paramycr.jdField_a_of_type_JavaLangString, ((GeneralFeedItem)((ycs)localObject).a).mVideoPullType);
    if (localFeedVideoInfo == null)
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find video info for feedId:%s, pullType:%d", new Object[] { paramycr.jdField_a_of_type_JavaLangString, Integer.valueOf(((GeneralFeedItem)((ycs)localObject).a).mVideoPullType) });
      return;
    }
    ((ycs)localObject).c(localFeedVideoInfo.mVideoItemList, true);
    ((GeneralFeedItem)((ycs)localObject).a).updateVideoInfo(localFeedVideoInfo);
    ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video and cookie update after count:%d", paramycr.jdField_a_of_type_JavaLangString, Integer.valueOf(((ycs)localObject).a().size()));
    ydd.a(paramydd).a((yeb)localObject);
  }
  
  public Class acceptEventClass()
  {
    return ycr.class;
  }
  
  public void b(@NonNull ydd paramydd, @NonNull ycr paramycr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydj
 * JD-Core Version:    0.7.0.1
 */