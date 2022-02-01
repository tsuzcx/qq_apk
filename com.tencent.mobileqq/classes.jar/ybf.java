import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;

public class ybf
  extends wfr<StoryAtVideoFragment, ycp>
{
  public ybf(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull ycp paramycp)
  {
    if ((!paramycp.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramycp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramStoryAtVideoFragment.jdField_a_of_type_Ycb == null))
    {
      yqp.b(this.TAG, "ignore this comment list event. %s.", paramycp.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Ycb.c())
    {
      yqp.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramycp.toString() });
      return;
    }
    yqp.a(this.TAG, "receive comment list event. %s.", paramycp.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Ycb.a(paramycp.jdField_a_of_type_JavaUtilList, paramycp.c);
    paramStoryAtVideoFragment.jdField_a_of_type_Ycb.a().updateVideoInfo(paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Ycb.a().size() < 1)
    {
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Ycb);
  }
  
  public Class acceptEventClass()
  {
    return ycp.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull ycp paramycp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybf
 * JD-Core Version:    0.7.0.1
 */