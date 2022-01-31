import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.tencent.biz.videostory.widget.easylyric.SingleLyricView;

public class wzi
  extends AnimatorListenerAdapter
{
  public wzi(SingleLyricView paramSingleLyricView) {}
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    if (SingleLyricView.a(this.a) != null) {
      SingleLyricView.a(this.a).setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzi
 * JD-Core Version:    0.7.0.1
 */