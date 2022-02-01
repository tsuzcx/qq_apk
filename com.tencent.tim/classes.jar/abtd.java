import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;

public class abtd
  implements Animation.AnimationListener
{
  public abtd(ApolloGameActivity paramApolloGameActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ApolloGameActivity.a(this.this$0).onDestroy();
    ApolloGameActivity.a(this.this$0).setVisibility(4);
    ApolloGameActivity.d(this.this$0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abtd
 * JD-Core Version:    0.7.0.1
 */