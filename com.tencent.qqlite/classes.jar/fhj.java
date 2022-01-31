import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.widget.ActionSheet;

public class fhj
  implements Runnable
{
  public fhj(ActionSheet paramActionSheet) {}
  
  public void run()
  {
    ActionSheet.a(this.a, new TranslateAnimation(0.0F, 0.0F, -ActionSheet.a(this.a).getHeight(), 0.0F));
    ActionSheet.a(this.a).setFillEnabled(true);
    ActionSheet.a(this.a).setInterpolator(AnimationUtils.loadInterpolator(ActionSheet.a(this.a), 17432582));
    ActionSheet.a(this.a).setDuration(ActionSheet.a(this.a));
    ActionSheet.a(this.a).startAnimation(ActionSheet.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fhj
 * JD-Core Version:    0.7.0.1
 */