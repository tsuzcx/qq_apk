import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

class wkf
  extends umf<wjw, wje>
{
  wkf(wjw paramwjw)
  {
    super(paramwjw);
  }
  
  public void a(@NonNull wjw paramwjw, @NonNull wje paramwje)
  {
    if ((!paramwje.jdField_a_of_type_JavaLangString.equals(wjw.a(paramwjw))) || (paramwje.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (wjw.a(paramwjw) == null))
    {
      wxe.b(this.TAG, "ignore this comment list event. %s.", paramwje.toString());
      return;
    }
    if (!wjw.a(paramwjw).c())
    {
      wxe.e(this.TAG, "this feed does not support video list. ignore this comment list event. %s.", new Object[] { paramwje.toString() });
      return;
    }
    wxe.a(this.TAG, "receive comment list event. %s.", paramwje.toString());
    wjw.a(paramwjw).a(paramwje.jdField_a_of_type_JavaUtilList, paramwje.c);
    wjw.a(paramwjw).a().updateVideoInfo(paramwje.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (wjw.a(paramwjw).a().size() < 1)
    {
      wjw.a(paramwjw).b();
      return;
    }
    paramwjw.a();
  }
  
  public Class acceptEventClass()
  {
    return wje.class;
  }
  
  public void b(@NonNull wjw paramwjw, @NonNull wje paramwje) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkf
 * JD-Core Version:    0.7.0.1
 */