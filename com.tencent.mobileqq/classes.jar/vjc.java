import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;

public class vjc
  implements ViewTreeObserver.OnPreDrawListener
{
  public vjc(StoryPlayerActivity paramStoryPlayerActivity, View paramView) {}
  
  public boolean onPreDraw()
  {
    vnq.b((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerActivity.a(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerActivity.a, new vjd(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vjc
 * JD-Core Version:    0.7.0.1
 */