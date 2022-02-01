import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.tim.todo.TodoNewActivity;

public class auoq
  implements Animation.AnimationListener
{
  public auoq(TodoNewActivity paramTodoNewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    TodoNewActivity.b(this.this$0).setVisibility(4);
    paramAnimation = new AlphaAnimation(1.0F, 0.0F);
    paramAnimation.setDuration(100L);
    paramAnimation.setAnimationListener(new auor(this));
    TodoNewActivity.a(this.this$0).startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    TodoNewActivity.a(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auoq
 * JD-Core Version:    0.7.0.1
 */