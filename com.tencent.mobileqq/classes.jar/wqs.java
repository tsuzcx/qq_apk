import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.videostory.capture.widgets.AEBottomListScrollView;

class wqs
  implements Animation.AnimationListener
{
  wqs(wqq paramwqq) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((wqq.a(this.a) != null) && (!wqq.a(this.a)))
    {
      wqq.a(this.a).setAlpha(1.0F);
      wqq.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wqs
 * JD-Core Version:    0.7.0.1
 */