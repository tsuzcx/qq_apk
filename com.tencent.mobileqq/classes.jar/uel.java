import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

class uel
  extends sgl<uec, udk>
{
  uel(uec paramuec)
  {
    super(paramuec);
  }
  
  public void a(@NonNull uec paramuec, @NonNull udk paramudk)
  {
    if ((!paramudk.jdField_a_of_type_JavaLangString.equals(uec.a(paramuec))) || (paramudk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (uec.a(paramuec) == null))
    {
      urk.b(this.TAG, "ignore this comment list event. %s.", paramudk.toString());
      return;
    }
    if (!uec.a(paramuec).c())
    {
      urk.e(this.TAG, "this feed does not support video list. ignore this comment list event. %s.", new Object[] { paramudk.toString() });
      return;
    }
    urk.a(this.TAG, "receive comment list event. %s.", paramudk.toString());
    uec.a(paramuec).a(paramudk.jdField_a_of_type_JavaUtilList, paramudk.c);
    uec.a(paramuec).a().updateVideoInfo(paramudk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (uec.a(paramuec).a().size() < 1)
    {
      uec.a(paramuec).b();
      return;
    }
    paramuec.a();
  }
  
  public Class acceptEventClass()
  {
    return udk.class;
  }
  
  public void b(@NonNull uec paramuec, @NonNull udk paramudk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uel
 * JD-Core Version:    0.7.0.1
 */