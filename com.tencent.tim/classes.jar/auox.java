import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.tim.todo.TodoNewActivity;

public class auox
  extends AnimatorListenerAdapter
{
  public auox(TodoNewActivity paramTodoNewActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    TodoNewActivity.c(this.this$0);
    this.this$0.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auox
 * JD-Core Version:    0.7.0.1
 */