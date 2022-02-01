import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;

public class xvg
  extends wag<StoryAtVideoFragment, xwq>
{
  public xvg(StoryAtVideoFragment paramStoryAtVideoFragment)
  {
    super(paramStoryAtVideoFragment);
  }
  
  public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull xwq paramxwq)
  {
    if ((!paramxwq.jdField_a_of_type_JavaLangString.equals(paramStoryAtVideoFragment.jdField_a_of_type_JavaLangString)) || (paramxwq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramStoryAtVideoFragment.jdField_a_of_type_Xwc == null))
    {
      ykq.b(this.TAG, "ignore this comment list event. %s.", paramxwq.toString());
      return;
    }
    if (!paramStoryAtVideoFragment.jdField_a_of_type_Xwc.c())
    {
      ykq.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramxwq.toString() });
      return;
    }
    ykq.a(this.TAG, "receive comment list event. %s.", paramxwq.toString());
    paramStoryAtVideoFragment.jdField_a_of_type_Xwc.a(paramxwq.jdField_a_of_type_JavaUtilList, paramxwq.c);
    paramStoryAtVideoFragment.jdField_a_of_type_Xwc.a().updateVideoInfo(paramxwq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (paramStoryAtVideoFragment.jdField_a_of_type_Xwc.a().size() < 1)
    {
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
      paramStoryAtVideoFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    paramStoryAtVideoFragment.a(paramStoryAtVideoFragment.jdField_a_of_type_Xwc);
  }
  
  public Class acceptEventClass()
  {
    return xwq.class;
  }
  
  public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull xwq paramxwq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvg
 * JD-Core Version:    0.7.0.1
 */