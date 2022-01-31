import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class dxj
  extends AnimateUtils.AnimationAdapter
{
  public dxj(ComboAnimation3 paramComboAnimation3) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((ComboAnimation3.a(this.a) != null) && (ComboAnimation3.a(this.a).isShown())) {
      this.a.a.post(new dxk(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dxj
 * JD-Core Version:    0.7.0.1
 */