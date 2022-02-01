import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;

public class yfa
  extends wjm<StoryAtVideoFragment, ygk>
{
  public yfa(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull ygk paramygk)
  {
    if ((!paramygk.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramygk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramStoryAtVideoFragment.jdField_a_of_type_Yfw == null))
    {
      yuk.b(this.TAG, "ignore this comment list event. %s.", paramygk.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Yfw.c())
    {
      yuk.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramygk.toString() });
      return;
    }
    yuk.a(this.TAG, "receive comment list event. %s.", paramygk.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Yfw.a(paramygk.jdField_a_of_type_JavaUtilList, paramygk.c);
    paramStoryAtVideoFragment.jdField_a_of_type_Yfw.a().updateVideoInfo(paramygk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Yfw.a().size() < 1)
    {
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Yfw);
  }
  
  public Class acceptEventClass()
  {
    return ygk.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull ygk paramygk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfa
 * JD-Core Version:    0.7.0.1
 */