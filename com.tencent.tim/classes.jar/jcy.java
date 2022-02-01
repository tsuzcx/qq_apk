import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ClipDrawable;
import com.tencent.av.ui.QavPanel;

public class jcy
  implements ValueAnimator.AnimatorUpdateListener
{
  public jcy(QavPanel paramQavPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (QavPanel.c(this.this$0))
    {
      if (this.this$0.a != null) {
        this.this$0.a.setLevel(i);
      }
      if (QavPanel.d(this.this$0))
      {
        QavPanel.a(this.this$0).nM(i);
        QavPanel.a(this.this$0).nO(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcy
 * JD-Core Version:    0.7.0.1
 */