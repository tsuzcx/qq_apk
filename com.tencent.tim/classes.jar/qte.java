import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;

class qte
  implements ValueAnimator.AnimatorUpdateListener
{
  qte(qtc paramqtc, StoryHomeHorizontalListView paramStoryHomeHorizontalListView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    try
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      this.b.scrollTo((int)(300.0F - f * 300.0F), 0);
      return;
    }
    catch (Exception paramValueAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qte
 * JD-Core Version:    0.7.0.1
 */