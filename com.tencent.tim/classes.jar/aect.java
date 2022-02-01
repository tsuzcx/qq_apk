import android.graphics.PorterDuff.Mode;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.list.DefaultItemBuilder.1;
import com.tencent.mobileqq.colornote.list.DefaultItemBuilder.1.1.1;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

public class aect
  implements OnCompositionLoadedListener
{
  public aect(DefaultItemBuilder.1 param1) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      QLog.e("DefaultItemBuilder", 1, "getLottieDrawable onCompositionLoaded failed");
      return;
    }
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.setImagesAssetsFolder(this.a.bwC);
    localLottieDrawable.setColorFilter(-16777216, PorterDuff.Mode.MULTIPLY);
    this.a.b.drawable = localLottieDrawable;
    ThreadManagerV2.getUIHandlerV2().post(new DefaultItemBuilder.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aect
 * JD-Core Version:    0.7.0.1
 */