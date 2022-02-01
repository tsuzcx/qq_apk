import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.apollo.view.ApolloMainViewBinder.1;
import com.tencent.mobileqq.apollo.view.ApolloMainViewBinder.1.1.1;

public class acaf
  implements Animation.AnimationListener
{
  public acaf(ApolloMainViewBinder.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.xQ.setVisibility(8);
    this.a.xQ.postDelayed(new ApolloMainViewBinder.1.1.1(this), 300L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acaf
 * JD-Core Version:    0.7.0.1
 */