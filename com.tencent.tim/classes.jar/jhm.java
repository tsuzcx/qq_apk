import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.1.2;
import com.tencent.av.ui.guide.GuideHelper.a;
import com.tencent.av.ui.guide.GuideHelper.a.a;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

public class jhm
  implements OnCompositionLoadedListener
{
  public jhm(GuideHelper.a parama, Context paramContext, long paramLong, GuideHelper.a.a parama1) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    int i = wja.dp2px(130.0F, this.val$context.getResources());
    int j = wja.dp2px(120.0F, this.val$context.getResources());
    if (paramLottieComposition == null)
    {
      QLog.w("GuideHelper", 1, "onCompositionLoaded, fail, seq[" + this.kQ + "]");
      return;
    }
    Object localObject = paramLottieComposition.getBounds();
    float f1 = i / ((Rect)localObject).width();
    float f2 = j / ((Rect)localObject).height();
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setScale(f1, f2);
    ((LottieDrawable)localObject).setRepeatCount(-1);
    ((LottieDrawable)localObject).setImageAssetDelegate(new jhn(this));
    asfe.getUIHandler().post(new GuideHelper.LottieDrawableHelper.1.2(this, (LottieDrawable)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhm
 * JD-Core Version:    0.7.0.1
 */