import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;

class usg
  implements ValueAnimator.AnimatorUpdateListener
{
  usg(use paramuse, StoryHomeHorizontalListView paramStoryHomeHorizontalListView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    try
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.scrollTo((int)(300.0F - f * 300.0F), 0);
      return;
    }
    catch (Exception paramValueAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usg
 * JD-Core Version:    0.7.0.1
 */