import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class umw
  extends AnimateUtils.AnimationAdapter
{
  public umw(VisitorsActivity paramVisitorsActivity) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.e.setVisibility(0);
    this.a.a.setClipChildren(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     umw
 * JD-Core Version:    0.7.0.1
 */