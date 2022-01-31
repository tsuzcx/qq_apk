import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.richstatus.EditActivity;

public class gld
  implements Runnable
{
  public gld(EditActivity paramEditActivity) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -20.0F, 0.0F);
    localTranslateAnimation.setDuration(400L);
    localTranslateAnimation.setAnimationListener(new gle(this));
    EditActivity.a(this.a).startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gld
 * JD-Core Version:    0.7.0.1
 */