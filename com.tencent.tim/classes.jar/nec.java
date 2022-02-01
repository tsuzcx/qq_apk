import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.35.1;

public class nec
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$view.post(new ReadInJoyBaseAdapter.35.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nec
 * JD-Core Version:    0.7.0.1
 */