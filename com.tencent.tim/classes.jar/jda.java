import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.av.ui.QavPanel;

public class jda
  implements ValueAnimator.AnimatorUpdateListener
{
  public jda(QavPanel paramQavPanel, int[] paramArrayOfInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if ((i >= 0) && (i <= this.cK[0]))
    {
      j = this.cK[0];
      i = (int)(i * 255 * 1.0F / j);
      QavPanel.a(this.this$0).setAlpha(i);
      QavPanel.a(this.this$0).lg(true);
    }
    do
    {
      return;
      if ((i > this.cK[0]) && (i <= this.cK[1]))
      {
        QavPanel.a(this.this$0).lg(true);
        QavPanel.a(this.this$0).setAlpha(255);
        return;
      }
    } while ((i <= this.cK[1]) || (i > this.cK[2]));
    int j = this.cK[2];
    int k = this.cK[1];
    i = (int)((this.cK[2] - i) * 255 * 1.0F / (j - k));
    QavPanel.a(this.this$0).setAlpha(i);
    QavPanel.a(this.this$0).lg(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jda
 * JD-Core Version:    0.7.0.1
 */