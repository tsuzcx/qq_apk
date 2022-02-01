import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

public class yne
  extends wjm<ymx, ygk>
{
  public yne(ymx paramymx)
  {
    super(paramymx);
  }
  
  public void a(@NonNull ymx paramymx, @NonNull ygk paramygk)
  {
    Object localObject = paramymx.a(paramygk.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramygk.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof ynv))
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramygk.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (ynv)localObject;
    if (paramygk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ((ynv)localObject).c(paramygk.jdField_a_of_type_JavaUtilList, false);
      ((VideoListFeedItem)((ynv)localObject).a).updateVideoInfo(paramygk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
      yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video update after count:%d", paramygk.jdField_a_of_type_JavaLangString, Integer.valueOf(((ynv)localObject).a().size()));
    }
    ymx.a(paramymx).a((ynv)localObject);
  }
  
  public Class acceptEventClass()
  {
    return ygk.class;
  }
  
  public void b(@NonNull ymx paramymx, @NonNull ygk paramygk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yne
 * JD-Core Version:    0.7.0.1
 */