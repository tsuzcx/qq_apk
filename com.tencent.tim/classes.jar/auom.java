import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.tim.todo.TodoNewActivity;
import com.tencent.tim.widget.IphonePickerView;

public class auom
  implements Animation.AnimationListener
{
  public auom(TodoNewActivity paramTodoNewActivity, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    TodoNewActivity.a(this.this$0, false);
    if (this.py)
    {
      TodoNewActivity.a(this.this$0).setVisibility(0);
      return;
    }
    TodoNewActivity.a(this.this$0).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    TodoNewActivity.a(this.this$0, true);
    TodoNewActivity.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auom
 * JD-Core Version:    0.7.0.1
 */