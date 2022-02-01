import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tim.todo.TodoNewActivity;

public class auop
  extends AnimatorListenerAdapter
{
  public auop(TodoNewActivity paramTodoNewActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    TodoNewActivity.a(this.this$0, 2);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    TodoNewActivity.b(this.this$0).setBackgroundResource(2130851730);
    TodoNewActivity.b(this.this$0).setCompoundDrawablesWithIntrinsicBounds(2130851731, 0, 0, 0);
    TodoNewActivity.b(this.this$0).setText("删除");
    TodoNewActivity.a(this.this$0).setVisibility(4);
    TodoNewActivity.c(this.this$0).setVisibility(0);
    TodoNewActivity.a(this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auop
 * JD-Core Version:    0.7.0.1
 */