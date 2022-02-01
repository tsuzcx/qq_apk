import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.widget.LinearLayout;

class agyf
  implements ValueAnimator.AnimatorUpdateListener
{
  agyf(agyc paramagyc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f = Float.valueOf(paramValueAnimator.getAnimatedValue().toString()).floatValue();
      if ((agyc.a(this.this$0).getVisibility() == 0) && (Math.abs(agyc.a(this.this$0).getAlpha() - f) >= 0.02F)) {
        agyc.a(this.this$0).setAlpha(f);
      }
      if ((agyc.a(this.this$0).getVisibility() == 0) && (Math.abs(agyc.a(this.this$0).getAlpha() - f) >= 0.02F)) {
        agyc.a(this.this$0).setAlpha(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agyf
 * JD-Core Version:    0.7.0.1
 */