import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3.3.1;

public class wnm
  extends auqs.a
{
  public wnm(ComboAnimation3 paramComboAnimation3) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((ComboAnimation3.a(this.a) != null) && (ComboAnimation3.a(this.a).isShown())) {
      this.a.c.post(new ComboAnimation3.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wnm
 * JD-Core Version:    0.7.0.1
 */