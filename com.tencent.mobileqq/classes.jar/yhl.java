import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

class yhl
  extends wjm<yhc, ygk>
{
  yhl(yhc paramyhc)
  {
    super(paramyhc);
  }
  
  public void a(@NonNull yhc paramyhc, @NonNull ygk paramygk)
  {
    if ((!paramygk.jdField_a_of_type_JavaLangString.equals(yhc.a(paramyhc))) || (paramygk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (yhc.a(paramyhc) == null))
    {
      yuk.b(this.TAG, "ignore this comment list event. %s.", paramygk.toString());
      return;
    }
    if (!yhc.a(paramyhc).c())
    {
      yuk.e(this.TAG, "this feed does not support video list. ignore this comment list event. %s.", new Object[] { paramygk.toString() });
      return;
    }
    yuk.a(this.TAG, "receive comment list event. %s.", paramygk.toString());
    yhc.a(paramyhc).a(paramygk.jdField_a_of_type_JavaUtilList, paramygk.c);
    yhc.a(paramyhc).a().updateVideoInfo(paramygk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (yhc.a(paramyhc).a().size() < 1)
    {
      yhc.a(paramyhc).b();
      return;
    }
    paramyhc.a();
  }
  
  public Class acceptEventClass()
  {
    return ygk.class;
  }
  
  public void b(@NonNull yhc paramyhc, @NonNull ygk paramygk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhl
 * JD-Core Version:    0.7.0.1
 */