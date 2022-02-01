import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.tencent.biz.videostory.widget.easylyric.SingleLyricView;

public class srk
  extends AnimatorListenerAdapter
{
  public srk(SingleLyricView paramSingleLyricView) {}
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    if (SingleLyricView.a(this.this$0) != null) {
      SingleLyricView.a(this.this$0).setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     srk
 * JD-Core Version:    0.7.0.1
 */