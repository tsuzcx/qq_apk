import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;

public class afoh
  implements Animator.AnimatorListener
{
  public afoh(EmotionKeywordLayout paramEmotionKeywordLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (paramAnimator == EmotionKeywordLayout.a(this.b)) {
      this.b.setVisibility(8);
    }
    if (EmotionKeywordLayout.a(this.b) != null) {
      EmotionKeywordLayout.a(this.b).resetCurrentX(0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afoh
 * JD-Core Version:    0.7.0.1
 */