import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;

class awws
  implements Animator.AnimatorListener
{
  awws(awwq paramawwq) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryPiecesPart", 2, "ptv panel down");
    }
    if (awwq.a(this.this$0) != null)
    {
      awwq.a(this.this$0).setAlpha(1.0F);
      awwq.a(this.this$0).setVisibility(4);
      awwq.a(this.this$0).q().postValue(Boolean.valueOf(false));
    }
    awwq.c(this.this$0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awws
 * JD-Core Version:    0.7.0.1
 */