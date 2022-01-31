import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;

class urh
  extends sth<uqy, uqg>
{
  urh(uqy paramuqy)
  {
    super(paramuqy);
  }
  
  public void a(@NonNull uqy paramuqy, @NonNull uqg paramuqg)
  {
    if ((!paramuqg.jdField_a_of_type_JavaLangString.equals(uqy.a(paramuqy))) || (paramuqg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (uqy.a(paramuqy) == null))
    {
      veg.b(this.TAG, "ignore this comment list event. %s.", paramuqg.toString());
      return;
    }
    if (!uqy.a(paramuqy).c())
    {
      veg.e(this.TAG, "this feed does not support video list. ignore this comment list event. %s.", new Object[] { paramuqg.toString() });
      return;
    }
    veg.a(this.TAG, "receive comment list event. %s.", paramuqg.toString());
    uqy.a(paramuqy).a(paramuqg.jdField_a_of_type_JavaUtilList, paramuqg.c);
    uqy.a(paramuqy).a().updateVideoInfo(paramuqg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (uqy.a(paramuqy).a().size() < 1)
    {
      uqy.a(paramuqy).b();
      return;
    }
    paramuqy.a();
  }
  
  public Class acceptEventClass()
  {
    return uqg.class;
  }
  
  public void b(@NonNull uqy paramuqy, @NonNull uqg paramuqg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urh
 * JD-Core Version:    0.7.0.1
 */