import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.widget.ActionSheet;

class fjw
  implements Animation.AnimationListener
{
  fjw(fjv paramfjv) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      ActionSheet.b(this.a.a);
      return;
    }
    catch (Exception paramAnimation) {}
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fjw
 * JD-Core Version:    0.7.0.1
 */