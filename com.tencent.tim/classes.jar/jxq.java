import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.qphone.base.util.QLog;

public class jxq
  implements ValueAnimator.AnimatorUpdateListener
{
  public jxq(AdControlView paramAdControlView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    QLog.d("Ron", 2, "alpha:" + f);
    AdControlView.a(this.b).setAlpha(f);
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxq
 * JD-Core Version:    0.7.0.1
 */