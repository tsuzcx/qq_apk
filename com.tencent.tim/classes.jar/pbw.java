import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.PointF;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.3;

public class pbw
  extends AnimatorListenerAdapter
{
  public pbw(QCircleFuelAnimationManager.3 param3, PointF paramPointF) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.mb.setVisibility(4);
    this.a.mb.setX(this.L.x);
    this.a.mb.setY(this.L.y + aqnm.dip2px(5.0F));
    this.a.mb.clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbw
 * JD-Core Version:    0.7.0.1
 */