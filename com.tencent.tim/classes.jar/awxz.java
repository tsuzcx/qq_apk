import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class awxz
  implements Animation.AnimationListener
{
  awxz(awxv paramawxv) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((awxv.a(this.this$0) != null) && (!awxv.a(this.this$0)))
    {
      awxv.a(this.this$0).setAlpha(1.0F);
      awxv.a(this.this$0).setVisibility(4);
    }
    if (awxv.b(this.this$0) != null)
    {
      awxv.c(this.this$0).p(327683, new Object[0]);
      awxv.d(this.this$0).p(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    awxv.a(this.this$0).a().by(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awxz
 * JD-Core Version:    0.7.0.1
 */