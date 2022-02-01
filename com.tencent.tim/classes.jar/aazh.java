import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class aazh
  implements ValueAnimator.AnimatorUpdateListener
{
  public aazh(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f = Float.valueOf(paramValueAnimator.getAnimatedValue().toString()).floatValue();
      if ((this.this$0.Ao.getVisibility() == 0) && (Math.abs(this.this$0.Ao.getAlpha() - f) >= 0.02F)) {
        this.this$0.Ao.setAlpha(f);
      }
      if ((this.this$0.dR.getVisibility() == 0) && (Math.abs(this.this$0.Ao.getAlpha() - f) >= 0.02F)) {
        this.this$0.dR.setAlpha(Float.valueOf(f).floatValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aazh
 * JD-Core Version:    0.7.0.1
 */