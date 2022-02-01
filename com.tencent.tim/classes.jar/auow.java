import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import com.tencent.tim.todo.TodoNewActivity;

public class auow
  implements ValueAnimator.AnimatorUpdateListener
{
  public auow(TodoNewActivity paramTodoNewActivity, boolean paramBoolean, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    TodoNewActivity.a(this.this$0).getBackground().setAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    RelativeLayout localRelativeLayout = TodoNewActivity.b(this.this$0);
    if (this.djt) {}
    for (float f = 1.0F - paramValueAnimator.getAnimatedFraction();; f = paramValueAnimator.getAnimatedFraction())
    {
      localRelativeLayout.setTranslationY(f * this.val$height);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auow
 * JD-Core Version:    0.7.0.1
 */