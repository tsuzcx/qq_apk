import android.os.Handler;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.app.ActionBar;
import com.tencent.mobileqq.activity.SplashActivity;

public class djv
  extends ViewPager.SimpleOnPageChangeListener
{
  public djv(SplashActivity paramSplashActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.a.supportInvalidateOptionsMenu();
    this.a.getSupportActionBar().setSelectedNavigationItem(paramInt);
    new Handler().postDelayed(new djw(this, paramInt), 500L);
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     djv
 * JD-Core Version:    0.7.0.1
 */