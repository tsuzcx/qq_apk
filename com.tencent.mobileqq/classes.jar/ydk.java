import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

public class ydk
  extends wag<ydd, xwq>
{
  public ydk(ydd paramydd)
  {
    super(paramydd);
  }
  
  public void a(@NonNull ydd paramydd, @NonNull xwq paramxwq)
  {
    Object localObject = paramydd.a(paramxwq.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramxwq.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof yeb))
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramxwq.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (yeb)localObject;
    if (paramxwq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ((yeb)localObject).c(paramxwq.jdField_a_of_type_JavaUtilList, false);
      ((VideoListFeedItem)((yeb)localObject).a).updateVideoInfo(paramxwq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
      ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video update after count:%d", paramxwq.jdField_a_of_type_JavaLangString, Integer.valueOf(((yeb)localObject).a().size()));
    }
    ydd.a(paramydd).a((yeb)localObject);
  }
  
  public Class acceptEventClass()
  {
    return xwq.class;
  }
  
  public void b(@NonNull ydd paramydd, @NonNull xwq paramxwq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydk
 * JD-Core Version:    0.7.0.1
 */