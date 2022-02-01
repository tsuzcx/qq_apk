import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;

class adxy
  extends AnimatorListenerAdapter
{
  adxy(adxx paramadxx) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.log("animator set end!");
    if (this.this$0.Bo != null)
    {
      adxx.a(this.this$0).removeView(this.this$0.Bo);
      this.this$0.Bo = null;
      if (this.this$0.jq == null) {
        break label186;
      }
      adxx.b(this.this$0).removeView(this.this$0.jq);
      this.this$0.jq = null;
    }
    for (;;)
    {
      if (this.this$0.Bp != null)
      {
        this.this$0.Bp.setVisibility(0);
        paramAnimator = (AvatarPendantManager)this.this$0.app.getManager(46);
        paramAnimator.atx = -1L;
        paramAnimator.eeO();
      }
      if (this.this$0.Bn != null) {
        this.this$0.Bn.invalidate();
      }
      this.this$0.bwd = "";
      this.this$0.bwf = "";
      this.this$0.GN(true);
      return;
      this.this$0.log("something wrong, bubble view is null!");
      break;
      label186:
      this.this$0.log("something wrong, pendview is null!");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.log("animator set start!");
    this.this$0.GN(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxy
 * JD-Core Version:    0.7.0.1
 */