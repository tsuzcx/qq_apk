import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.tencent.biz.videostory.widget.easylyric.SingleLyricView;

public class sri
  implements ValueAnimator.AnimatorUpdateListener
{
  public sri(SingleLyricView paramSingleLyricView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (SingleLyricView.a(this.this$0) != null) {
      SingleLyricView.a(this.this$0).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sri
 * JD-Core Version:    0.7.0.1
 */