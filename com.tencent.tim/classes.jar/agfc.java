import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewStub;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;

public class agfc
  extends AnimatorListenerAdapter
{
  public agfc(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    FileAssistantActivity.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agfc
 * JD-Core Version:    0.7.0.1
 */