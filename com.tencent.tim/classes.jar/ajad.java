import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.qphone.base.util.QLog;

public class ajad
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajad(MedalGuideView paramMedalGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue("alpha")).floatValue();
    this.this$0.bn.setAlpha(f);
    f = ((Float)paramValueAnimator.getAnimatedValue("translate")).floatValue();
    this.this$0.bn.setTranslationY(f);
    f = paramValueAnimator.getAnimatedFraction();
    if ((!this.this$0.cnd) && (f >= 0.8857143F))
    {
      this.this$0.cnd = true;
      this.this$0.a.sendEmptyMessage(4);
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "send MSG_START_3D_ROTATE");
      }
    }
    if (f >= 1.0F) {
      paramValueAnimator.removeAllUpdateListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajad
 * JD-Core Version:    0.7.0.1
 */