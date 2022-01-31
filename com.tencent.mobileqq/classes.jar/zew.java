import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import java.lang.ref.WeakReference;

public class zew
  implements Runnable
{
  public zew(ApolloLottieAnim paramApolloLottieAnim) {}
  
  public void run()
  {
    if ((ApolloLottieAnim.a(this.a) != null) && (ApolloLottieAnim.a(this.a).get() != null)) {
      ((DiniFlyAnimationView)ApolloLottieAnim.a(this.a).get()).endAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zew
 * JD-Core Version:    0.7.0.1
 */