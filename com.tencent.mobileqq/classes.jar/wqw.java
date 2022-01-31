import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.videostory.capture.widgets.AEBottomListScrollView;

class wqw
  implements Animation.AnimationListener
{
  wqw(wqq paramwqq) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((wqq.a(this.a) != null) && (!wqq.a(this.a)))
    {
      wqq.a(this.a).setAlpha(1.0F);
      wqq.a(this.a).setVisibility(4);
    }
    if (this.a.a != null)
    {
      this.a.a.a(327684, new Object[0]);
      this.a.a.a(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    wqq.a(this.a).a().a(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wqw
 * JD-Core Version:    0.7.0.1
 */