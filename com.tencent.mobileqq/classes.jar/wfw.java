import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

class wfw
  extends uhw<wfn, wev>
{
  wfw(wfn paramwfn)
  {
    super(paramwfn);
  }
  
  public void a(@NonNull wfn paramwfn, @NonNull wev paramwev)
  {
    if ((!paramwev.jdField_a_of_type_JavaLangString.equals(wfn.a(paramwfn))) || (paramwev.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (wfn.a(paramwfn) == null))
    {
      wsv.b(this.TAG, "ignore this comment list event. %s.", paramwev.toString());
      return;
    }
    if (!wfn.a(paramwfn).c())
    {
      wsv.e(this.TAG, "this feed does not support video list. ignore this comment list event. %s.", new Object[] { paramwev.toString() });
      return;
    }
    wsv.a(this.TAG, "receive comment list event. %s.", paramwev.toString());
    wfn.a(paramwfn).a(paramwev.jdField_a_of_type_JavaUtilList, paramwev.c);
    wfn.a(paramwfn).a().updateVideoInfo(paramwev.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (wfn.a(paramwfn).a().size() < 1)
    {
      wfn.a(paramwfn).b();
      return;
    }
    paramwfn.a();
  }
  
  public Class acceptEventClass()
  {
    return wev.class;
  }
  
  public void b(@NonNull wfn paramwfn, @NonNull wev paramwev) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfw
 * JD-Core Version:    0.7.0.1
 */