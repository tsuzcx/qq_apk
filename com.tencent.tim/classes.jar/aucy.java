import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.widget.LinearLayout;

class aucy
  implements ValueAnimator.AnimatorUpdateListener
{
  aucy(aucv paramaucv) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f = Float.valueOf(paramValueAnimator.getAnimatedValue().toString()).floatValue();
      if ((aucv.a(this.this$0).getVisibility() == 0) && (Math.abs(aucv.a(this.this$0).getAlpha() - f) >= 0.02F)) {
        aucv.a(this.this$0).setAlpha(f);
      }
      if ((aucv.a(this.this$0).getVisibility() == 0) && (Math.abs(aucv.a(this.this$0).getAlpha() - f) >= 0.02F)) {
        aucv.a(this.this$0).setAlpha(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucy
 * JD-Core Version:    0.7.0.1
 */