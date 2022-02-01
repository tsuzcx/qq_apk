import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.a;
import java.util.List;

public class zpl
  implements ValueAnimator.AnimatorUpdateListener
{
  private IntEvaluator a = new IntEvaluator();
  private int len = this.uE.size();
  
  public zpl(AvatarPendantActivity paramAvatarPendantActivity, List paramList1, List paramList2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() / 100.0F;
    int i = 0;
    while (i < this.len)
    {
      paramValueAnimator = (View)this.uE.get(i);
      AvatarPendantActivity.a locala = (AvatarPendantActivity.a)this.uF.get(i);
      ViewGroup.LayoutParams localLayoutParams = paramValueAnimator.getLayoutParams();
      if (locala.ahj != locala.cet)
      {
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)paramValueAnimator.getLayoutParams();
        localLayoutParams1.topMargin = this.a.evaluate(f, Integer.valueOf(locala.ahj), Integer.valueOf(locala.cet)).intValue();
        paramValueAnimator.setLayoutParams(localLayoutParams1);
      }
      if (locala.ceu != locala.cev) {
        localLayoutParams.height = this.a.evaluate(f, Integer.valueOf(locala.ceu), Integer.valueOf(locala.cev)).intValue();
      }
      if (locala.cew != locala.cex) {
        localLayoutParams.width = this.a.evaluate(f, Integer.valueOf(locala.cew), Integer.valueOf(locala.cex)).intValue();
      }
      paramValueAnimator.setLayoutParams(localLayoutParams);
      paramValueAnimator.requestLayout();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpl
 * JD-Core Version:    0.7.0.1
 */