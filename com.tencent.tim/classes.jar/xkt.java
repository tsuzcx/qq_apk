import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

final class xkt
  implements OnCompositionLoadedListener
{
  xkt(DiniFlyAnimationView paramDiniFlyAnimationView, xbu.a parama, String paramString) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    this.b.setImageAssetDelegate(new xku(this));
    if (paramLottieComposition == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(xks.TAG, 2, "composition is null ,return");
      }
      return;
    }
    this.b.setComposition(paramLottieComposition);
    if ((this.a != null) && ("bubble".equals(this.aVw)))
    {
      paramLottieComposition = this.a.h.getCompRect();
      ViewGroup.LayoutParams localLayoutParams = this.a.h.getLayoutParams();
      int i = paramLottieComposition.width() * localLayoutParams.height / paramLottieComposition.height();
      this.a.h.getLayoutParams().width = i;
      this.a.h.setLayoutParams(localLayoutParams);
      this.a.h.setVisibility(0);
      this.a.hD.clearAnimation();
      this.a.hD.setVisibility(8);
      this.a.a.clearAnimation();
      this.a.a.setVisibility(8);
    }
    this.b.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkt
 * JD-Core Version:    0.7.0.1
 */