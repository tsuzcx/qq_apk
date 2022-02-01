import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

class xiw
  extends vll<xin, xhv>
{
  xiw(xin paramxin)
  {
    super(paramxin);
  }
  
  public void a(@NonNull xin paramxin, @NonNull xhv paramxhv)
  {
    if ((!paramxhv.jdField_a_of_type_JavaLangString.equals(xin.a(paramxin))) || (paramxhv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (xin.a(paramxin) == null))
    {
      xvv.b(this.TAG, "ignore this comment list event. %s.", paramxhv.toString());
      return;
    }
    if (!xin.a(paramxin).c())
    {
      xvv.e(this.TAG, "this feed does not support video list. ignore this comment list event. %s.", new Object[] { paramxhv.toString() });
      return;
    }
    xvv.a(this.TAG, "receive comment list event. %s.", paramxhv.toString());
    xin.a(paramxin).a(paramxhv.jdField_a_of_type_JavaUtilList, paramxhv.c);
    xin.a(paramxin).a().updateVideoInfo(paramxhv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (xin.a(paramxin).a().size() < 1)
    {
      xin.a(paramxin).b();
      return;
    }
    paramxin.a();
  }
  
  public Class acceptEventClass()
  {
    return xhv.class;
  }
  
  public void b(@NonNull xin paramxin, @NonNull xhv paramxhv) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xiw
 * JD-Core Version:    0.7.0.1
 */