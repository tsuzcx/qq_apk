import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView.3.1;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView.3.2;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;

public class nqe
  implements Animation.AnimationListener
{
  public nqe(RefreshAnimView paramRefreshAnimView, String paramString, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    long l = Aladdin.getConfig(222).getIntegerFromString("refresh_bar_text_delay_time", 100);
    RefreshAnimView.a(this.this$0).postDelayed(new RefreshAnimView.3.1(this), l);
    paramAnimation = new RefreshAnimView.3.2(this);
    if (RefreshAnimView.a(this.this$0) != null)
    {
      paramAnimation.run();
      return;
    }
    try
    {
      LottieComposition.Factory.fromAssetFileName(this.this$0.getContext(), "readinjoy_refresh_animation.json", new nqf(this, paramAnimation));
      return;
    }
    catch (Exception paramAnimation)
    {
      QLog.e("RefreshAnimView", 2, "fromAssetFileName", paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nqe
 * JD-Core Version:    0.7.0.1
 */