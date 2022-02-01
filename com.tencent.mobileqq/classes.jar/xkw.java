import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayerFragment;

public class xkw
  implements ViewTreeObserver.OnPreDrawListener
{
  public xkw(StoryPlayerFragment paramStoryPlayerFragment, View paramView) {}
  
  public boolean onPreDraw()
  {
    xpf.b((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerFragment.a(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerFragment.a, new xkx(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkw
 * JD-Core Version:    0.7.0.1
 */