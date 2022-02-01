import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;

public class xgl
  extends vll<StoryAtVideoFragment, xhv>
{
  public xgl(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull xhv paramxhv)
  {
    if ((!paramxhv.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramxhv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramStoryAtVideoFragment.jdField_a_of_type_Xhh == null))
    {
      xvv.b(this.TAG, "ignore this comment list event. %s.", paramxhv.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Xhh.c())
    {
      xvv.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramxhv.toString() });
      return;
    }
    xvv.a(this.TAG, "receive comment list event. %s.", paramxhv.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Xhh.a(paramxhv.jdField_a_of_type_JavaUtilList, paramxhv.c);
    paramStoryAtVideoFragment.jdField_a_of_type_Xhh.a().updateVideoInfo(paramxhv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Xhh.a().size() < 1)
    {
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Xhh);
  }
  
  public Class acceptEventClass()
  {
    return xhv.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull xhv paramxhv) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgl
 * JD-Core Version:    0.7.0.1
 */