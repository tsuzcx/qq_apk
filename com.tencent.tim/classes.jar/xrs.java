import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.panel.PEPanel;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

public class xrs
  implements OnCompositionLoadedListener
{
  public xrs(PEPanel paramPEPanel, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo.PEPanel", 2, "composition is null ,return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmo.PEPanel", 2, String.format(" playLottieAnim onCompositionLoaded done ", new Object[0]));
    }
    Rect localRect = paramLottieComposition.getBounds();
    int i = this.a.getResources().getDisplayMetrics().widthPixels;
    i = XPanelContainer.aLe;
    wja.dp2px(40.0F, this.a.getResources());
    float f = this.a.getResources().getDisplayMetrics().widthPixels / localRect.width();
    PEPanel.a(this.a, paramLottieComposition.getDuration() * 6L / 10L);
    this.b.setComposition(paramLottieComposition);
    this.b.setScale(f);
    this.b.setScaleType(ImageView.ScaleType.FIT_XY);
    this.b.addAnimatorListener(PEPanel.a(this.a));
    this.b.addAnimatorUpdateListener(PEPanel.a(this.a));
    this.b.playAnimation();
    PEPanel.a(this.a).sendEmptyMessageDelayed(0, PEPanel.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrs
 * JD-Core Version:    0.7.0.1
 */