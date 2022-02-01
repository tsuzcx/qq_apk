import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class ynd
  extends wjm<ymx, yml>
{
  public ynd(ymx paramymx)
  {
    super(paramymx);
  }
  
  public void a(@NonNull ymx paramymx, @NonNull yml paramyml)
  {
    if (paramyml.jdField_a_of_type_Int == 0) {
      return;
    }
    Object localObject = paramymx.a(paramyml.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramyml.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof ymm))
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramyml.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (ymm)localObject;
    FeedVideoInfo localFeedVideoInfo = ((ymk)wth.a(12)).a(paramyml.jdField_a_of_type_JavaLangString, ((GeneralFeedItem)((ymm)localObject).a).mVideoPullType);
    if (localFeedVideoInfo == null)
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find video info for feedId:%s, pullType:%d", new Object[] { paramyml.jdField_a_of_type_JavaLangString, Integer.valueOf(((GeneralFeedItem)((ymm)localObject).a).mVideoPullType) });
      return;
    }
    ((ymm)localObject).c(localFeedVideoInfo.mVideoItemList, true);
    ((GeneralFeedItem)((ymm)localObject).a).updateVideoInfo(localFeedVideoInfo);
    yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video and cookie update after count:%d", paramyml.jdField_a_of_type_JavaLangString, Integer.valueOf(((ymm)localObject).a().size()));
    ymx.a(paramymx).a((ynv)localObject);
  }
  
  public Class acceptEventClass()
  {
    return yml.class;
  }
  
  public void b(@NonNull ymx paramymx, @NonNull yml paramyml) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynd
 * JD-Core Version:    0.7.0.1
 */