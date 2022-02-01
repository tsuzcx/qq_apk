import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.qphone.base.util.QLog;

public class njj
  extends AnimatorListenerAdapter
{
  public njj(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    SlideActiveAnimController.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim onAnimationCancel");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    SlideActiveAnimController.a(this.this$0, false);
    SlideActiveAnimController.a(this.this$0, SlideActiveAnimController.access$600());
    SlideActiveAnimController.a(this.this$0).setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim onAnimationEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njj
 * JD-Core Version:    0.7.0.1
 */