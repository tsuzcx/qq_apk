import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout.b;

public class ntm
  implements Animation.AnimationListener
{
  public ntm(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CommonSuspensionGestureLayout.c(this.this$0).setVisibility(8);
    CommonSuspensionGestureLayout.a(this.this$0).h(true, this.val$deltaY, this.val$type);
    CommonSuspensionGestureLayout.a(this.this$0, this.val$type);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntm
 * JD-Core Version:    0.7.0.1
 */