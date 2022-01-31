import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.AECamera.panel.material.AEMaterialPanel;

class wuu
  implements Animator.AnimatorListener
{
  wuu(wut paramwut) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryPiecesPart", 2, "ptv panel down");
    }
    if (wut.a(this.a) != null)
    {
      wut.a(this.a).setAlpha(1.0F);
      wut.a(this.a).setVisibility(4);
      wut.a(this.a).b().a(Boolean.valueOf(false));
    }
    wut.b(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wuu
 * JD-Core Version:    0.7.0.1
 */