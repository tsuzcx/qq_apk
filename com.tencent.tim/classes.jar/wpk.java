import com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.1;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Set;

public class wpk
  implements OnCompositionLoadedListener
{
  public wpk(AudioTransitionAnimManager.1 param1) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      QLog.e("AudioTransitionAnimManager", 2, "getDrawable onCompositionLoaded lottieComposition is null or mIsDestroyed:");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel getDrawable finish type" + this.a.val$type);
    }
    wpj.a(this.a.this$0).remove(Integer.valueOf(this.a.val$type));
    LottieDrawable localLottieDrawable = new LottieDrawable();
    wpn localwpn = new wpn(this.a.val$context, this.a.val$path);
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.setImageAssetDelegate(localwpn);
    wpj.a(this.a.this$0).put(this.a.val$path, localLottieDrawable);
    wpj.a(this.a.this$0, localLottieDrawable, this.a.val$type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpk
 * JD-Core Version:    0.7.0.1
 */