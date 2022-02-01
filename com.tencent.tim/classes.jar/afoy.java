import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class afoy
  implements ValueAnimator.AnimatorUpdateListener
{
  public afoy(EmotionSearchPanel paramEmotionSearchPanel, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(this.cST + this.cSU * f);
    EmotionSearchPanel.a(this.b, i);
    if (EmotionSearchPanel.a(this.b)) {
      EmotionSearchPanel.b(this.b, (int)(f * this.cSV));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afoy
 * JD-Core Version:    0.7.0.1
 */