import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

public class acaa
  implements OnCompositionLoadedListener
{
  public acaa(ApolloLottieAnim paramApolloLottieAnim, DiniFlyAnimationView paramDiniFlyAnimationView, boolean paramBoolean) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, "composition is null ,return");
      }
    }
    do
    {
      return;
      if (!ApolloLottieAnim.a(this.this$0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloLottieAnim", 2, "anim is destroy ,return");
    return;
    this.b.setComposition(paramLottieComposition);
    this.b.setImageAssetDelegate(new acab(this));
    if (this.val$autoPlay)
    {
      this.b.setVisibility(0);
      this.b.playAnimation();
    }
    ApolloLottieAnim.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acaa
 * JD-Core Version:    0.7.0.1
 */