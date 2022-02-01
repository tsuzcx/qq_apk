import android.animation.ObjectAnimator;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.olympic.activity.PromotionEntry.UpdateOperateBtnStatusRunnable;
import java.lang.ref.WeakReference;

public class akqs
  implements OnCompositionLoadedListener
{
  public akqs(PromotionEntry.UpdateOperateBtnStatusRunnable paramUpdateOperateBtnStatusRunnable, String paramString) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null) {}
    do
    {
      return;
      this.b.lottieDrawable = new LottieDrawable();
      this.b.lottieDrawable.setComposition(paramLottieComposition);
      this.b.lottieDrawable.setImageAssetDelegate(new akqt(this));
      this.b.lottieDrawable.loop(true);
      paramLottieComposition = (ImageView)PromotionEntry.UpdateOperateBtnStatusRunnable.a(this.b).get();
    } while ((paramLottieComposition == null) || (paramLottieComposition.getVisibility() != 0) || (this.b.bL == null) || (this.b.bL.isRunning()));
    paramLottieComposition.setImageDrawable(this.b.lottieDrawable);
    this.b.lottieDrawable.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqs
 * JD-Core Version:    0.7.0.1
 */