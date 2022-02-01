import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

class xxr
  extends wag<xxi, xwq>
{
  xxr(xxi paramxxi)
  {
    super(paramxxi);
  }
  
  public void a(@NonNull xxi paramxxi, @NonNull xwq paramxwq)
  {
    if ((!paramxwq.jdField_a_of_type_JavaLangString.equals(xxi.a(paramxxi))) || (paramxwq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (xxi.a(paramxxi) == null))
    {
      ykq.b(this.TAG, "ignore this comment list event. %s.", paramxwq.toString());
      return;
    }
    if (!xxi.a(paramxxi).c())
    {
      ykq.e(this.TAG, "this feed does not support video list. ignore this comment list event. %s.", new Object[] { paramxwq.toString() });
      return;
    }
    ykq.a(this.TAG, "receive comment list event. %s.", paramxwq.toString());
    xxi.a(paramxxi).a(paramxwq.jdField_a_of_type_JavaUtilList, paramxwq.c);
    xxi.a(paramxxi).a().updateVideoInfo(paramxwq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (xxi.a(paramxxi).a().size() < 1)
    {
      xxi.a(paramxxi).b();
      return;
    }
    paramxxi.a();
  }
  
  public Class acceptEventClass()
  {
    return xwq.class;
  }
  
  public void b(@NonNull xxi paramxxi, @NonNull xwq paramxwq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxr
 * JD-Core Version:    0.7.0.1
 */