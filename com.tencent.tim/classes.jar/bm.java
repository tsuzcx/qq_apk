import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout.LayoutParams;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteActivity.52.1;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XEditTextEx;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class bm
  implements Animator.AnimatorListener
{
  public bm(LiteActivity paramLiteActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    LiteActivity.a(this.this$0).setPadding(0, wja.dp2px(8.0F, this.this$0.app.getApplication().getResources()), 0, 0);
    this.this$0.a.getLayoutParams().height = -2;
    ((FrameLayout.LayoutParams)this.this$0.a.getLayoutParams()).setMargins(wja.dp2px(14.0F, this.this$0.app.getApplication().getResources()), 0, 0, 0);
    this.this$0.a.setMaxLines(6);
    this.this$0.a.setBackgroundResource(2130850843);
    this.this$0.a.setGravity(16);
    this.this$0.a.setPadding(wja.dp2px(11.0F, this.this$0.app.getApplication().getResources()), wja.dp2px(6.0F, this.this$0.app.getApplication().getResources()), wja.dp2px(11.0F, this.this$0.app.getApplication().getResources()), wja.dp2px(6.0F, this.this$0.app.getApplication().getResources()));
    this.this$0.a.requestLayout();
    this.this$0.uiHandler.postDelayed(new LiteActivity.52.1(this), 100L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     bm
 * JD-Core Version:    0.7.0.1
 */