import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.widget.DynamicGridView;

public class auti
  extends AnimatorListenerAdapter
{
  public auti(DynamicGridView paramDynamicGridView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    DynamicGridView.a(this.a, false);
    DynamicGridView.a(this.a);
    DynamicGridView.a(this.a, this.hz);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    DynamicGridView.a(this.a, true);
    DynamicGridView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auti
 * JD-Core Version:    0.7.0.1
 */