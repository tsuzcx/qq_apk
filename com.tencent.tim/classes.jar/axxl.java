import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView.a;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import java.util.Iterator;
import java.util.List;

public class axxl
  implements Animator.AnimatorListener
{
  public axxl(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.MU.setVisibility(0);
    QIMProviderContainerView.a(this.this$0, true);
    QIMProviderContainerView.a(this.this$0);
    if (QIMProviderContainerView.a(this.this$0) != null)
    {
      paramAnimator = QIMProviderContainerView.a(this.this$0).iterator();
      while (paramAnimator.hasNext()) {
        ((ProviderContainerView.a)paramAnimator.next()).ar(null, 0);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProviderContainerView", 2, "panelOpened : " + QIMProviderContainerView.a(this.this$0));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.kg.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxl
 * JD-Core Version:    0.7.0.1
 */