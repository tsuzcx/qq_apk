import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;

public class tuk
  implements ViewTreeObserver.OnPreDrawListener
{
  public tuk(StoryPlayerActivity paramStoryPlayerActivity, View paramView) {}
  
  public boolean onPreDraw()
  {
    tyy.b((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerActivity.a(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerActivity.a, new tul(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tuk
 * JD-Core Version:    0.7.0.1
 */