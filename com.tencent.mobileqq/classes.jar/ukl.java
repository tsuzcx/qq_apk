import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class ukl
  extends AnimateUtils.AnimationAdapter
{
  public ukl(ComboAnimation3 paramComboAnimation3) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((ComboAnimation3.a(this.a) != null) && (ComboAnimation3.a(this.a).isShown())) {
      this.a.a.post(new ukm(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ukl
 * JD-Core Version:    0.7.0.1
 */