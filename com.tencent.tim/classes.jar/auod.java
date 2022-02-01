import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.tim.todo.TodoListViewLogic.4;

public class auod
  implements Animator.AnimatorListener
{
  int repeatCount = 0;
  
  public auod(TodoListViewLogic.4 param4, ViewGroup paramViewGroup, ImageView paramImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.repeatCount >= 3) {
      this.eT.removeView(this.He);
    }
    aunz.a(this.a.this$0, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    aunz.a(this.a.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auod
 * JD-Core Version:    0.7.0.1
 */