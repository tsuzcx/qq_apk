import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;

public class uot
  extends ste<StoryAtVideoFragment, uqd>
{
  public uot(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull uqd paramuqd)
  {
    if ((!paramuqd.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramuqd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramStoryAtVideoFragment.jdField_a_of_type_Upp == null))
    {
      ved.b(this.TAG, "ignore this comment list event. %s.", paramuqd.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Upp.c())
    {
      ved.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramuqd.toString() });
      return;
    }
    ved.a(this.TAG, "receive comment list event. %s.", paramuqd.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Upp.a(paramuqd.jdField_a_of_type_JavaUtilList, paramuqd.c);
    paramStoryAtVideoFragment.jdField_a_of_type_Upp.a().updateVideoInfo(paramuqd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Upp.a().size() < 1)
    {
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Upp);
  }
  
  public Class acceptEventClass()
  {
    return uqd.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull uqd paramuqd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uot
 * JD-Core Version:    0.7.0.1
 */