import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;

class adyb
  extends AnimatorListenerAdapter
{
  adyb(adxx paramadxx, adyc.c paramc) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.this$0.jq != null) && (this.this$0.Bp != null))
    {
      this.this$0.jq.setVisibility(4);
      this.this$0.Bp.setVisibility(0);
      paramAnimator = (AvatarPendantManager)this.this$0.app.getManager(46);
      paramAnimator.atx = -1L;
      this.this$0.log("show pendant, " + this.this$0.mMsgId);
      paramAnimator.eeO();
    }
    if (this.this$0.Bo != null) {
      this.this$0.Bo.setVisibility(0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.this$0.jq != null) && (this.this$0.Bp != null))
    {
      this.this$0.jq.setVisibility(0);
      this.this$0.Bp.setVisibility(4);
      paramAnimator = (AvatarPendantManager)this.this$0.app.getManager(46);
      this.this$0.log("stop show pendant, " + this.this$0.mMsgId);
      paramAnimator.atx = this.this$0.mMsgId;
      paramAnimator.eeN();
    }
    if ((this.this$0.Bo != null) && (TextUtils.isEmpty(this.a.bwj))) {
      this.this$0.Bo.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyb
 * JD-Core Version:    0.7.0.1
 */