import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout.b;

public class ntn
  implements Animation.AnimationListener
{
  public ntn(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CommonSuspensionGestureLayout.a(this.this$0).h(false, this.val$deltaY, 2);
    CommonSuspensionGestureLayout.a(this.this$0, 2);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntn
 * JD-Core Version:    0.7.0.1
 */