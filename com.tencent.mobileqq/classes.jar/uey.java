import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class uey
  extends AnimateUtils.AnimationAdapter
{
  public uey(VisitorsActivity paramVisitorsActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.f = false;
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uey
 * JD-Core Version:    0.7.0.1
 */