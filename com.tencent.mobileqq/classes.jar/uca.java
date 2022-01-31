import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;

public class uca
  extends sgl<StoryAtVideoFragment, udk>
{
  public uca(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull udk paramudk)
  {
    if ((!paramudk.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramudk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramStoryAtVideoFragment.jdField_a_of_type_Ucw == null))
    {
      urk.b(this.TAG, "ignore this comment list event. %s.", paramudk.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Ucw.c())
    {
      urk.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramudk.toString() });
      return;
    }
    urk.a(this.TAG, "receive comment list event. %s.", paramudk.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Ucw.a(paramudk.jdField_a_of_type_JavaUtilList, paramudk.c);
    paramStoryAtVideoFragment.jdField_a_of_type_Ucw.a().updateVideoInfo(paramudk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Ucw.a().size() < 1)
    {
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Ucw);
  }
  
  public Class acceptEventClass()
  {
    return udk.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull udk paramudk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uca
 * JD-Core Version:    0.7.0.1
 */