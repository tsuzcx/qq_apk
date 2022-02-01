import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

class ydq
  extends wfr<ydh, ycp>
{
  ydq(ydh paramydh)
  {
    super(paramydh);
  }
  
  public void a(@NonNull ydh paramydh, @NonNull ycp paramycp)
  {
    if ((!paramycp.jdField_a_of_type_JavaLangString.equals(ydh.a(paramydh))) || (paramycp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (ydh.a(paramydh) == null))
    {
      yqp.b(this.TAG, "ignore this comment list event. %s.", paramycp.toString());
      return;
    }
    if (!ydh.a(paramydh).c())
    {
      yqp.e(this.TAG, "this feed does not support video list. ignore this comment list event. %s.", new Object[] { paramycp.toString() });
      return;
    }
    yqp.a(this.TAG, "receive comment list event. %s.", paramycp.toString());
    ydh.a(paramydh).a(paramycp.jdField_a_of_type_JavaUtilList, paramycp.c);
    ydh.a(paramydh).a().updateVideoInfo(paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (ydh.a(paramydh).a().size() < 1)
    {
      ydh.a(paramydh).b();
      return;
    }
    paramydh.a();
  }
  
  public Class acceptEventClass()
  {
    return ycp.class;
  }
  
  public void b(@NonNull ydh paramydh, @NonNull ycp paramycp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydq
 * JD-Core Version:    0.7.0.1
 */