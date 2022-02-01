import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.tim.todo.widget.TodoCardView;

class auoe
  implements ValueAnimator.AnimatorUpdateListener
{
  auoe(aunz paramaunz, ViewGroup.MarginLayoutParams paramMarginLayoutParams, RelativeLayout.LayoutParams paramLayoutParams, View paramView, TodoCardView paramTodoCardView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f < 0.01F) {
      f = 0.0F;
    }
    for (;;)
    {
      this.c.topMargin = ((int)(this.H.topMargin * f));
      this.c.leftMargin = ((int)(this.H.leftMargin * f));
      this.c.rightMargin = ((int)(this.H.rightMargin * f));
      this.c.bottomMargin = ((int)(this.H.bottomMargin * f));
      this.La.setAlpha(1.0F - f);
      if (this.b != null)
      {
        paramValueAnimator = (ViewGroup.MarginLayoutParams)this.b.getLayoutParams();
        int i = aunz.a(this.this$0).getBottom();
        paramValueAnimator.topMargin = (this.H.topMargin - (int)((this.H.topMargin - i) * (1.0F - f)));
        this.b.setAnimationProgress(1.0F - f);
      }
      aunz.a(this.this$0).requestLayout();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auoe
 * JD-Core Version:    0.7.0.1
 */