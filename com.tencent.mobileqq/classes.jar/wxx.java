import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.OvershootInterpolator;
import com.tencent.mobileqq.activity.qwallet.RedPacketRecordFragment;

public class wxx
  implements Runnable
{
  public wxx(RedPacketRecordFragment paramRedPacketRecordFragment) {}
  
  public void run()
  {
    this.a.a.setAlpha(0.3F);
    this.a.a.animate().alpha(1.0F).setDuration(200L);
    this.a.b.setAlpha(0.3F);
    this.a.b.setPivotX(this.a.b.getWidth() / 2);
    this.a.b.setPivotY(this.a.b.getHeight() / 2);
    this.a.b.setScaleX(0.5F);
    this.a.b.setScaleY(0.5F);
    this.a.b.animate().alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setDuration(300L).setInterpolator(new OvershootInterpolator(1.6F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wxx
 * JD-Core Version:    0.7.0.1
 */