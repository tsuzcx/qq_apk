import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

public class wlp
  extends uhw<wli, wev>
{
  public wlp(wli paramwli)
  {
    super(paramwli);
  }
  
  public void a(@NonNull wli paramwli, @NonNull wev paramwev)
  {
    Object localObject = paramwli.a(paramwev.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramwev.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof wmg))
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramwev.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (wmg)localObject;
    if (paramwev.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ((wmg)localObject).c(paramwev.jdField_a_of_type_JavaUtilList, false);
      ((VideoListFeedItem)((wmg)localObject).a).updateVideoInfo(paramwev.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
      wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video update after count:%d", paramwev.jdField_a_of_type_JavaLangString, Integer.valueOf(((wmg)localObject).a().size()));
    }
    wli.a(paramwli).a((wmg)localObject);
  }
  
  public Class acceptEventClass()
  {
    return wev.class;
  }
  
  public void b(@NonNull wli paramwli, @NonNull wev paramwev) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlp
 * JD-Core Version:    0.7.0.1
 */