import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.tencent.biz.videostory.widget.easylyric.SingleLyricView;

public class srh
  extends AnimatorListenerAdapter
{
  public srh(SingleLyricView paramSingleLyricView, String paramString) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (SingleLyricView.a(this.this$0) != null) {
      SingleLyricView.a(this.this$0).setText(this.val$text);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (SingleLyricView.a(this.this$0) != null)
    {
      SingleLyricView.a(this.this$0).setText(this.val$text);
      SingleLyricView.a(this.this$0).setAlpha(0.3F);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    SingleLyricView.a(this.this$0).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     srh
 * JD-Core Version:    0.7.0.1
 */