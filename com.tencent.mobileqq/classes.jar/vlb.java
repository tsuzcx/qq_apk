import android.animation.ValueAnimator;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.FrameListener;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;

public class vlb
  implements CustomFrameAnimationDrawable.FrameListener
{
  public vlb(UnlimitedBladeWorks paramUnlimitedBladeWorks) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 23) {
      UnlimitedBladeWorks.a(this.a).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vlb
 * JD-Core Version:    0.7.0.1
 */