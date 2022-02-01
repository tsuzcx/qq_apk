import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout.LayoutParams;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XEditTextEx;
import mqq.app.MobileQQ;

public class bo
  implements Animator.AnimatorListener
{
  public bo(LiteActivity paramLiteActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    LiteActivity.a(this.this$0).setPadding(0, 0, 0, 0);
    ((FrameLayout.LayoutParams)this.this$0.a.getLayoutParams()).setMargins(0, 0, 0, 0);
    this.this$0.a.setPadding(wja.dp2px(24.0F, this.this$0.app.getApplication().getResources()), wja.dp2px(10.0F, this.this$0.app.getApplication().getResources()), wja.dp2px(24.0F, this.this$0.app.getApplication().getResources()), 0);
    LiteActivity.a(this.this$0).getLayoutParams().height = -1;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     bo
 * JD-Core Version:    0.7.0.1
 */