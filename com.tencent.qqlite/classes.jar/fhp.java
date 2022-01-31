import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.widget.ActionSheet;

public class fhp
  implements Runnable
{
  public fhp(ActionSheet paramActionSheet) {}
  
  public void run()
  {
    ActionSheet.a(this.a, new TranslateAnimation(0.0F, 0.0F, 0.0F, -ActionSheet.a(this.a).getHeight()));
    ActionSheet.a(this.a).setInterpolator(AnimationUtils.loadInterpolator(ActionSheet.a(this.a), 17432582));
    ActionSheet.a(this.a).setDuration(200L);
    ActionSheet.a(this.a).setFillAfter(true);
    ActionSheet.a(this.a).startAnimation(ActionSheet.a(this.a));
    ActionSheet.a(this.a).setAnimationListener(new fhq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fhp
 * JD-Core Version:    0.7.0.1
 */