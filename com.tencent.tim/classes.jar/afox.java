import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class afox
  implements ValueAnimator.AnimatorUpdateListener
{
  public afox(EmotionSearchPanel paramEmotionSearchPanel, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(this.b.screenWidth - EmotionSearchPanel.a(this.b) * f);
    EmotionSearchPanel.a(this.b, i);
    if (EmotionSearchPanel.a(this.b)) {
      EmotionSearchPanel.b(this.b, (int)((1.0F - f) * this.cSS));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afox
 * JD-Core Version:    0.7.0.1
 */