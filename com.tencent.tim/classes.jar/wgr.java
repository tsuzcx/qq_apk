import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;

public class wgr
  extends auqs.a
{
  public wgr(VisitorsActivity paramVisitorsActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((paramAnimation == this.this$0.p) && (this.this$0.bcb)) {
      this.this$0.centerView.setText("");
    }
    this.this$0.centerView.clearAnimation();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == this.this$0.o) {
      this.this$0.centerView.setText(2131696213);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgr
 * JD-Core Version:    0.7.0.1
 */