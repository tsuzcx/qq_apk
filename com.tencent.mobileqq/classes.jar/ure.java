import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

class ure
  extends ste<uqv, uqd>
{
  ure(uqv paramuqv)
  {
    super(paramuqv);
  }
  
  public void a(@NonNull uqv paramuqv, @NonNull uqd paramuqd)
  {
    if ((!paramuqd.jdField_a_of_type_JavaLangString.equals(uqv.a(paramuqv))) || (paramuqd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (uqv.a(paramuqv) == null))
    {
      ved.b(this.TAG, "ignore this comment list event. %s.", paramuqd.toString());
      return;
    }
    if (!uqv.a(paramuqv).c())
    {
      ved.e(this.TAG, "this feed does not support video list. ignore this comment list event. %s.", new Object[] { paramuqd.toString() });
      return;
    }
    ved.a(this.TAG, "receive comment list event. %s.", paramuqd.toString());
    uqv.a(paramuqv).a(paramuqd.jdField_a_of_type_JavaUtilList, paramuqd.c);
    uqv.a(paramuqv).a().updateVideoInfo(paramuqd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (uqv.a(paramuqv).a().size() < 1)
    {
      uqv.a(paramuqv).b();
      return;
    }
    paramuqv.a();
  }
  
  public Class acceptEventClass()
  {
    return uqd.class;
  }
  
  public void b(@NonNull uqv paramuqv, @NonNull uqd paramuqd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ure
 * JD-Core Version:    0.7.0.1
 */