import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;

public class whu
  extends umf<StoryAtVideoFragment, wje>
{
  public whu(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull wje paramwje)
  {
    if ((!paramwje.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramwje.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramStoryAtVideoFragment.jdField_a_of_type_Wiq == null))
    {
      wxe.b(this.TAG, "ignore this comment list event. %s.", paramwje.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Wiq.c())
    {
      wxe.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramwje.toString() });
      return;
    }
    wxe.a(this.TAG, "receive comment list event. %s.", paramwje.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Wiq.a(paramwje.jdField_a_of_type_JavaUtilList, paramwje.c);
    paramStoryAtVideoFragment.jdField_a_of_type_Wiq.a().updateVideoInfo(paramwje.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Wiq.a().size() < 1)
    {
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Wiq);
  }
  
  public Class acceptEventClass()
  {
    return wje.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull wje paramwje) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whu
 * JD-Core Version:    0.7.0.1
 */