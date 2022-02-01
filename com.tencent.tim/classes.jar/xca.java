import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ViewAnimation;

class xca
  extends AnimatorListenerAdapter
{
  xca(xbu paramxbu) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (this.this$0.a != null)
    {
      this.this$0.a.mImageLayer = null;
      paramAnimator = ((ViewGroup)((Activity)this.this$0.mContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362332);
      if (paramAnimator != null)
      {
        this.this$0.a.setDuration(this.this$0.g.getDuration());
        paramAnimator.startAnimation(this.this$0.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xca
 * JD-Core Version:    0.7.0.1
 */