import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

class jdi
  implements ValueAnimator.AnimatorUpdateListener
{
  jdi(jdh paramjdh) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator.getAnimatedFraction();
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    float f;
    if (i <= 220)
    {
      f = i / 220.0F;
      jdh.a(this.this$0).setAlpha(f);
    }
    if (i <= 160)
    {
      f = i / 100.0F;
      jdh.a(this.this$0).setAlpha(f);
    }
    if (jdh.a(this.this$0) != null) {
      jdh.a(this.this$0).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdi
 * JD-Core Version:    0.7.0.1
 */