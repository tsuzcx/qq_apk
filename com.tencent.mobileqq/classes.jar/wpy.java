import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

public class wpy
  extends umf<wpr, wje>
{
  public wpy(wpr paramwpr)
  {
    super(paramwpr);
  }
  
  public void a(@NonNull wpr paramwpr, @NonNull wje paramwje)
  {
    Object localObject = paramwpr.a(paramwje.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramwje.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof wqp))
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramwje.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (wqp)localObject;
    if (paramwje.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ((wqp)localObject).c(paramwje.jdField_a_of_type_JavaUtilList, false);
      ((VideoListFeedItem)((wqp)localObject).a).updateVideoInfo(paramwje.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
      wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video update after count:%d", paramwje.jdField_a_of_type_JavaLangString, Integer.valueOf(((wqp)localObject).a().size()));
    }
    wpr.a(paramwpr).a((wqp)localObject);
  }
  
  public Class acceptEventClass()
  {
    return wje.class;
  }
  
  public void b(@NonNull wpr paramwpr, @NonNull wje paramwje) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpy
 * JD-Core Version:    0.7.0.1
 */