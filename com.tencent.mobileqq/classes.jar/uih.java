import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class uih
  extends AnimateUtils.AnimationAdapter
{
  public uih(VisitorsActivity paramVisitorsActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((paramAnimation == this.a.b) && (this.a.d)) {
      this.a.centerView.setText("");
    }
    this.a.centerView.clearAnimation();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == this.a.a) {
      this.a.centerView.setText(2131433084);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uih
 * JD-Core Version:    0.7.0.1
 */