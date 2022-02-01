import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.tim.todo.TodoNewActivity;

public class auon
  implements ValueAnimator.AnimatorUpdateListener
{
  public auon(TodoNewActivity paramTodoNewActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = this.this$0.getResources().getDisplayMetrics().density;
    float f2 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = TodoNewActivity.b(this.this$0).getLayoutParams();
    paramValueAnimator.width = ((int)((44.0F + 68.0F * f2) * f1));
    TodoNewActivity.b(this.this$0).setPadding((int)((12.0F + 13.0F * f2) * f1), 0, 0, 0);
    TodoNewActivity.b(this.this$0).setLayoutParams(paramValueAnimator);
    TodoNewActivity.c(this.this$0).setTranslationY((int)(f1 * (9.0F - f2 * 9.0F)));
    TodoNewActivity.c(this.this$0).setAlpha(f2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auon
 * JD-Core Version:    0.7.0.1
 */