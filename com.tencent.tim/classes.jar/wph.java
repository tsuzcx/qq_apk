import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.WeakHashMap;

class wph
  implements OnCompositionLoadedListener
{
  wph(wpe paramwpe) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (wpe.a(this.a) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEggLottieAnimView", 2, "LottieComposition.Factory.fromInputStream mLottieView is null!");
      }
      return;
    }
    if (paramLottieComposition != null)
    {
      wpe.a(this.a).setComposition(paramLottieComposition);
      wpe.a(this.a).loop(false);
      wpe.a(this.a).setVisibility(0);
      wpe.a(this.a).playAnimation();
      return;
    }
    wpe.a(this.a).clear();
    this.a.stopAnim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wph
 * JD-Core Version:    0.7.0.1
 */