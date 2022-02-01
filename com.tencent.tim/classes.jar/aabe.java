import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.MyAnimationListener;

public class aabe
  implements AnimationView.MyAnimationListener
{
  public aabe(ThemeHbFragment paramThemeHbFragment) {}
  
  public void onAnimationEnd(AnimationView paramAnimationView) {}
  
  public void onAnimationRepeat(AnimationView paramAnimationView) {}
  
  public void onAnimationStart(AnimationView paramAnimationView)
  {
    if (ThemeHbFragment.a(this.this$0).getChildCount() > 0) {
      ThemeHbFragment.a(this.this$0).removeViewAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabe
 * JD-Core Version:    0.7.0.1
 */