import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;

public class ysy
  implements Animation.AnimationListener
{
  public ysy(ApolloGameActivity paramApolloGameActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ApolloGameActivity.a(this.a).setVisibility(4);
    ApolloGameActivity.a(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysy
 * JD-Core Version:    0.7.0.1
 */