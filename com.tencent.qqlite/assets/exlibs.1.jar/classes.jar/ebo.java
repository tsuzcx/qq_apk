import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.richstatus.EditActivity;

public class ebo
  implements Runnable
{
  public ebo(EditActivity paramEditActivity) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -20.0F, 0.0F);
    localTranslateAnimation.setDuration(400L);
    localTranslateAnimation.setAnimationListener(new ebp(this));
    EditActivity.a(this.a).startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebo
 * JD-Core Version:    0.7.0.1
 */