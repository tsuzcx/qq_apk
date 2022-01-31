import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

public class xcg
  implements OnCompositionLoadedListener
{
  public xcg(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    TroopUnAccalimedRedPacketList.a(this.a).setImageDrawable(localLottieDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcg
 * JD-Core Version:    0.7.0.1
 */