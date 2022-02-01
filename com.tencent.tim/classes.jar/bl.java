import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.dataline.activities.LiteActivity;
import com.tencent.widget.XEditTextEx;

public class bl
  implements ValueAnimator.AnimatorUpdateListener
{
  public bl(LiteActivity paramLiteActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.this$0.a.getLayoutParams().height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.this$0.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     bl
 * JD-Core Version:    0.7.0.1
 */