import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class afoz
  implements Animator.AnimatorListener
{
  public afoz(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.a.a(false, 0, false, null, 0);
    paramAnimator = (afnd)this.b.a.a().a().a(7);
    if (EmotionSearchPanel.b(this.b))
    {
      EmotionSearchPanel.a(this.b, false);
      paramAnimator.Id(this.b.bc.getText().toString());
    }
    paramAnimator.MK(0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afoz
 * JD-Core Version:    0.7.0.1
 */