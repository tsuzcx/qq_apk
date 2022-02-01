import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tim.todo.TodoNewActivity;

public class auoo
  extends AnimatorListenerAdapter
{
  public auoo(TodoNewActivity paramTodoNewActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    TodoNewActivity.b(this.this$0).setBackgroundResource(2130851741);
    TodoNewActivity.b(this.this$0).setCompoundDrawablesWithIntrinsicBounds(2130851729, 0, 0, 0);
    TodoNewActivity.a(this.this$0, 0);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    TodoNewActivity.b(this.this$0).setText("");
    TodoNewActivity.a(this.this$0).setVisibility(0);
    TodoNewActivity.a(this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auoo
 * JD-Core Version:    0.7.0.1
 */