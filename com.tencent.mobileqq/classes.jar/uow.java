import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;

public class uow
  extends sth<StoryAtVideoFragment, uqg>
{
  public uow(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull uqg paramuqg)
  {
    if ((!paramuqg.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramuqg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramStoryAtVideoFragment.jdField_a_of_type_Ups == null))
    {
      veg.b(this.TAG, "ignore this comment list event. %s.", paramuqg.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Ups.c())
    {
      veg.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramuqg.toString() });
      return;
    }
    veg.a(this.TAG, "receive comment list event. %s.", paramuqg.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Ups.a(paramuqg.jdField_a_of_type_JavaUtilList, paramuqg.c);
    paramStoryAtVideoFragment.jdField_a_of_type_Ups.a().updateVideoInfo(paramuqg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Ups.a().size() < 1)
    {
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Ups);
  }
  
  public Class acceptEventClass()
  {
    return uqg.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull uqg paramuqg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uow
 * JD-Core Version:    0.7.0.1
 */