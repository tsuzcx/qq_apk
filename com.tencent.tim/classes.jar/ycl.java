import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ycl
  implements Animation.AnimationListener
{
  ycl(ycd paramycd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.blp = false;
    this.this$0.bYr = 0;
    this.this$0.blq = false;
    this.this$0.blE = false;
    this.this$0.blD = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.this$0.W(this.this$0.xt, ycd.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ycl
 * JD-Core Version:    0.7.0.1
 */