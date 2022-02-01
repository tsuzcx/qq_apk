import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView.2.1;
import com.tencent.widget.HorizontalListView;

public class abkl
  implements Animation.AnimationListener
{
  public abkl(CmGameDebugView paramCmGameDebugView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (CmGameDebugView.a(this.a))
    {
      CmGameDebugView.a(this.a).postDelayed(new CmGameDebugView.2.1(this), 0L);
      CmGameDebugView.a(this.a, false);
    }
    if (CmGameDebugView.b(this.a)) {
      CmGameDebugView.b(this.a, 0);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abkl
 * JD-Core Version:    0.7.0.1
 */