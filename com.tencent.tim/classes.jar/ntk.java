import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout.b;

public class ntk
  implements Animation.AnimationListener
{
  public ntk(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CommonSuspensionGestureLayout.c(this.this$0).setLayerType(0, null);
    CommonSuspensionGestureLayout.a(this.this$0).aZn();
    CommonSuspensionGestureLayout.a(this.this$0).aZl();
    CommonSuspensionGestureLayout.b(this.this$0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    CommonSuspensionGestureLayout.a(this.this$0).aZm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntk
 * JD-Core Version:    0.7.0.1
 */