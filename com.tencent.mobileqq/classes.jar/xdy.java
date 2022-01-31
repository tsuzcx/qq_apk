import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;

public class xdy
  implements Runnable
{
  public xdy(ThemeHbFragment paramThemeHbFragment) {}
  
  public void run()
  {
    ThemeHbFragment.a(this.a).startAnimation(ThemeHbFragment.a(this.a));
    ThemeHbFragment.a(this.a).setVisibility(0);
    this.a.a.a("theme.pack.show", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdy
 * JD-Core Version:    0.7.0.1
 */