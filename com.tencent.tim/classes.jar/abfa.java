import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class abfa
  implements Animation.AnimationListener
{
  abfa(abex paramabex, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.xA != null) && ((this.xA.getTag() instanceof abex.a))) {
      ((abex.a)this.xA.getTag()).needInflate = true;
    }
    abex.a(this.this$0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abfa
 * JD-Core Version:    0.7.0.1
 */