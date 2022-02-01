import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;
import com.tencent.qphone.base.util.QLog;

public class afpb
  implements Animator.AnimatorListener
{
  public afpb(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "upAndDownAnim onAnimationEnd=");
    }
    wja.eR(this.b.bc);
    this.b.dbk();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "upAndDownAnim start animStartBottom=" + EmotionSearchPanel.b(this.b));
    }
    EmotionSearchPanel.c(this.b, EmotionSearchPanel.b(this.b));
    ((afnd)this.b.a.a().a().a(7)).MK(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpb
 * JD-Core Version:    0.7.0.1
 */