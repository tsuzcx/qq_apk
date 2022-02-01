import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditScrollerView;

public class wql
  implements ValueAnimator.AnimatorUpdateListener
{
  public wql(VoiceTextEditScrollerView paramVoiceTextEditScrollerView, int paramInt1, int paramInt2, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    VoiceTextEditScrollerView.a(this.b, paramValueAnimator, this.bQH, this.bQI, this.val$view);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wql
 * JD-Core Version:    0.7.0.1
 */