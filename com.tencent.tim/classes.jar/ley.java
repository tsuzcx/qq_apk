import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.widget.HorizontalListView;

public class ley
  implements ValueAnimator.AnimatorUpdateListener
{
  public ley(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = ReadInJoySelfFragment.a(this.this$0).getLayoutParams();
    paramValueAnimator.height = i;
    ReadInJoySelfFragment.a(this.this$0).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ley
 * JD-Core Version:    0.7.0.1
 */