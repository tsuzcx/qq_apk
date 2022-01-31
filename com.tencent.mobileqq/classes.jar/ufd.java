import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class ufd
  extends AnimateUtils.AnimationAdapter
{
  public ufd(VisitorsActivity paramVisitorsActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.c > 0)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 200L);
      return;
    }
    this.a.f.setVisibility(4);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.c -= 1;
    this.a.f.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ufd
 * JD-Core Version:    0.7.0.1
 */