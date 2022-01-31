import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.apollo.view.ApolloGameHotChatController;

public class yue
  implements Animation.AnimationListener
{
  public yue(ApolloGameHotChatController paramApolloGameHotChatController) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (ApolloGameHotChatController.a(this.a) != null) {
      ApolloGameHotChatController.a(this.a).a(true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yue
 * JD-Core Version:    0.7.0.1
 */