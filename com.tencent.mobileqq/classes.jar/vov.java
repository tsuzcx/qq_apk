import android.database.DataSetObserver;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import com.tencent.biz.qqstory.view.EmptySupportViewPager;
import com.tencent.biz.qqstory.view.PagerIndicator;
import com.tencent.biz.qqstory.view.PagerIndicator.IndicatorAdapter;

public class vov
  extends DataSetObserver
  implements ViewPager.OnPageChangeListener
{
  private vov(PagerIndicator paramPagerIndicator) {}
  
  public void onChanged()
  {
    Log.d("PagerIndicator", "onChanged");
    this.a.a(this.a.a.getCurrentItem(), (PagerIndicator.IndicatorAdapter)this.a.a.getAdapter());
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Log.d("PagerIndicator", "onPageSelected : " + paramInt);
    this.a.a(this.a.a.getCurrentItem(), (PagerIndicator.IndicatorAdapter)this.a.a.getAdapter());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vov
 * JD-Core Version:    0.7.0.1
 */