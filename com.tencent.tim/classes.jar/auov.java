import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.tim.todo.TodoNewActivity;
import com.tencent.tim.todo.TodoNewActivity.2;

public class auov
  extends AnimatorListenerAdapter
{
  public auov(TodoNewActivity.2 param2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((TodoNewActivity.a(this.a.this$0) == 0) || (TodoNewActivity.a(this.a.this$0) == 4)) {
      TodoNewActivity.b(this.a.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auov
 * JD-Core Version:    0.7.0.1
 */