import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.pubaccount.readinjoy.ad.view.KandianAdPandentMask.KandianAdPandentView;

public class koc
  implements Animator.AnimatorListener
{
  public koc(KandianAdPandentMask.KandianAdPandentView paramKandianAdPandentView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    KandianAdPandentMask.KandianAdPandentView.b(this.b);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     koc
 * JD-Core Version:    0.7.0.1
 */