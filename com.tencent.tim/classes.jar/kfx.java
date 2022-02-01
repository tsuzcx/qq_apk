import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10.1.1;
import com.tencent.biz.widgets.TabLayout;

public class kfx
  implements Animator.AnimatorListener
{
  public kfx(ReadInJoyChannelViewPagerController.10 param10) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    kfv.b(this.a.this$0, false);
    kfv.a(this.a.this$0, kfv.aIs, 0.0F, 0);
    kfv.a(this.a.this$0).postDelayed(new ReadInJoyChannelViewPagerController.10.1.1(this), 0L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfx
 * JD-Core Version:    0.7.0.1
 */