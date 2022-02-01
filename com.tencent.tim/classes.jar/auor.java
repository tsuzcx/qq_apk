import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.tim.todo.TodoNewActivity;

class auor
  implements Animation.AnimationListener
{
  auor(auoq paramauoq) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    TodoNewActivity.e(this.a.this$0);
    this.a.this$0.overridePendingTransition(0, 0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auor
 * JD-Core Version:    0.7.0.1
 */