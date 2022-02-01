import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.tim.todo.widget.TodoCardView;

class auoh
  extends AnimatorListenerAdapter
{
  auoh(auof paramauof) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b.ewe();
    this.a.La.setVisibility(8);
    this.a.La.setAlpha(1.0F);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    aunz.b(this.a.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auoh
 * JD-Core Version:    0.7.0.1
 */