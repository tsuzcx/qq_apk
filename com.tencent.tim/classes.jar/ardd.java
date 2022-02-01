import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.mobileqq.webview.webso.WebSoService.12;

public class ardd
  implements Animator.AnimatorListener
{
  public ardd(WebSoService.12 param12, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$12.val$view.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$12.fW);
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$12.val$view.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewPropertyAnimator.setListener(null);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardd
 * JD-Core Version:    0.7.0.1
 */