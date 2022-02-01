import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.qphone.base.util.QLog;

public class afof
  implements ValueAnimator.AnimatorUpdateListener
{
  public afof(EmotionKeywordLayout paramEmotionKeywordLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordLayout", 2, "show:offset=" + f);
    }
    if (EmotionKeywordLayout.a(this.b) != null) {
      EmotionKeywordLayout.a(this.b).setTranslationY(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afof
 * JD-Core Version:    0.7.0.1
 */