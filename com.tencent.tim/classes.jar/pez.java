import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;

class pez
  implements Animation.AnimationListener
{
  pez(pey parampey) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.this$0.clearAnimation();
    this.a.this$0.apU = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.this$0.apU = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pez
 * JD-Core Version:    0.7.0.1
 */