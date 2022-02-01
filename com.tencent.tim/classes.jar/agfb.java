import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewStub;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;

public class agfb
  implements ValueAnimator.AnimatorUpdateListener
{
  public agfb(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    FileAssistantActivity.a(this.this$0).getLayoutParams().height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    FileAssistantActivity.a(this.this$0).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agfb
 * JD-Core Version:    0.7.0.1
 */