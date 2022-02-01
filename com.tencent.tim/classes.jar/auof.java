import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.tim.todo.widget.TodoCardView;

class auof
  extends AnimatorListenerAdapter
{
  auof(aunz paramaunz, View paramView, TodoCardView paramTodoCardView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.b.isEmpty())
    {
      paramAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      paramAnimator.setInterpolator(null);
      paramAnimator.addUpdateListener(new auog(this));
      paramAnimator.addListener(new auoh(this));
      paramAnimator.setDuration(100L).start();
      return;
    }
    this.b.ewe();
    this.La.setVisibility(8);
    aunz.b(this.this$0).setVisibility(0);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.La.setAlpha(0.0F);
    this.b.ewd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auof
 * JD-Core Version:    0.7.0.1
 */