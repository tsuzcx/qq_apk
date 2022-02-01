import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;

public class abue
  implements ValueAnimator.AnimatorUpdateListener
{
  public abue(ApolloCardWindow paramApolloCardWindow, TextView paramTextView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.Ql != null)
    {
      if (this.Ql != ApolloCardWindow.a(this.this$0)) {
        break label42;
      }
      this.Ql.setText(abud.dl(((Integer)paramValueAnimator.getAnimatedValue()).intValue()));
    }
    label42:
    do
    {
      return;
      if (this.Ql == ApolloCardWindow.b(this.this$0))
      {
        this.Ql.setText(abud.dk(((Integer)paramValueAnimator.getAnimatedValue()).intValue()));
        return;
      }
    } while (this.Ql != ApolloCardWindow.c(this.this$0));
    this.Ql.setText(abud.dj(((Integer)paramValueAnimator.getAnimatedValue()).intValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abue
 * JD-Core Version:    0.7.0.1
 */