import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class afpc
  implements ValueAnimator.AnimatorUpdateListener
{
  public afpc(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    EmotionSearchPanel.c(this.b, EmotionSearchPanel.keyboardHeight - ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpc
 * JD-Core Version:    0.7.0.1
 */