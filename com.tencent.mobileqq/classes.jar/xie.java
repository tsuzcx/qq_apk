import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.tencent.biz.videostory.widget.easylyric.SingleLyricView;

public class xie
  extends AnimatorListenerAdapter
{
  public xie(SingleLyricView paramSingleLyricView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (SingleLyricView.a(this.a) != null) {
      SingleLyricView.a(this.a).setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xie
 * JD-Core Version:    0.7.0.1
 */