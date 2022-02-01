import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.tim.todo.common.UnfinishedTodoItemBuilder.OnCheckBoxClickListener.1;

public class aupr
  extends AnimatorListenerAdapter
{
  public aupr(UnfinishedTodoItemBuilder.OnCheckBoxClickListener.1 param1) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (ViewGroup)aupq.a.a(this.a.a).aN.getParent();
    int i = paramAnimator.getMeasuredHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new aups(this, paramAnimator, i));
    localValueAnimator.addListener(new aupt(this));
    localValueAnimator.setDuration(300L);
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupr
 * JD-Core Version:    0.7.0.1
 */