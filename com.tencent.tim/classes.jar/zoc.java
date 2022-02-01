import android.app.Activity;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment;

class zoc
  implements Animation.AnimationListener
{
  zoc(zob paramzob, Activity paramActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.a.this$0.a.getCount() == 1) && (!MiniMsgTabFragment.b(this.a.this$0)))
    {
      paramAnimation = MiniMsgTabFragment.a(this.a.this$0);
      paramAnimation.putExtra("miniAppID", MiniMsgTabFragment.a(this.a.this$0));
      paramAnimation.putExtra("clickID", -1);
      this.val$activity.setResult(-1, paramAnimation);
      this.val$activity.finish();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zoc
 * JD-Core Version:    0.7.0.1
 */