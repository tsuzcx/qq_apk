import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class afpa
  implements ValueAnimator.AnimatorUpdateListener
{
  public afpa(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    EmotionSearchPanel localEmotionSearchPanel = this.b;
    int i = EmotionSearchPanel.b(this.b);
    EmotionSearchPanel.c(localEmotionSearchPanel, ((Integer)paramValueAnimator.getAnimatedValue()).intValue() + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpa
 * JD-Core Version:    0.7.0.1
 */