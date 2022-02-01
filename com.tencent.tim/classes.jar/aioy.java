import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;

public class aioy
  implements ValueAnimator.AnimatorUpdateListener
{
  public aioy(FloatIconLayout paramFloatIconLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.DM.setRotation(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aioy
 * JD-Core Version:    0.7.0.1
 */