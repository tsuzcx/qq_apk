import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;

public class wdl
  extends uhw<StoryAtVideoFragment, wev>
{
  public wdl(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull wev paramwev)
  {
    if ((!paramwev.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramwev.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramStoryAtVideoFragment.jdField_a_of_type_Weh == null))
    {
      wsv.b(this.TAG, "ignore this comment list event. %s.", paramwev.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Weh.c())
    {
      wsv.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramwev.toString() });
      return;
    }
    wsv.a(this.TAG, "receive comment list event. %s.", paramwev.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Weh.a(paramwev.jdField_a_of_type_JavaUtilList, paramwev.c);
    paramStoryAtVideoFragment.jdField_a_of_type_Weh.a().updateVideoInfo(paramwev.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Weh.a().size() < 1)
    {
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Weh);
  }
  
  public Class acceptEventClass()
  {
    return wev.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull wev paramwev) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdl
 * JD-Core Version:    0.7.0.1
 */