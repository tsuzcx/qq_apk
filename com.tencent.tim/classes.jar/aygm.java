import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoGuide;

public class aygm
  implements Animation.AnimationListener
{
  public aygm(EditVideoGuide paramEditVideoGuide) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.bsL();
    this.this$0.b.changeState(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygm
 * JD-Core Version:    0.7.0.1
 */