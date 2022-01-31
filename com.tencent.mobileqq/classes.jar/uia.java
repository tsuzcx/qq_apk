import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class uia
  extends AnimateUtils.AnimationAdapter
{
  public uia(VisitorsActivity paramVisitorsActivity) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.e.setVisibility(0);
    this.a.a.setClipChildren(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uia
 * JD-Core Version:    0.7.0.1
 */