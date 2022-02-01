import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.open.agent.CardContainer;

public class arqj
  implements ValueAnimator.AnimatorUpdateListener
{
  public arqj(CardContainer paramCardContainer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = (RelativeLayout.LayoutParams)this.this$0.a.getLayoutParams();
    paramValueAnimator.topMargin = i;
    this.this$0.a.setLayoutParams(paramValueAnimator);
    this.this$0.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqj
 * JD-Core Version:    0.7.0.1
 */