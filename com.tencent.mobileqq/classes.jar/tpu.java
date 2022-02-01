import android.view.animation.Animation;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

class tpu
  extends bkxp
{
  tpu(tpt paramtpt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (tps.a(this.a.a) != null)
    {
      paramAnimation = new ArrayList();
      paramAnimation.add(tps.a(this.a.a));
      tps.a(this.a.a).a(paramAnimation, tps.a(this.a.a));
      QQToast.a(this.a.a.a, 2, 2131717743, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tpu
 * JD-Core Version:    0.7.0.1
 */