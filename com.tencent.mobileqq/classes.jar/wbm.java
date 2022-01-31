import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqstory.view.EmptySupportViewPager;
import java.util.Iterator;
import java.util.List;

public class wbm
  implements ViewPager.OnPageChangeListener
{
  public wbm(EmptySupportViewPager paramEmptySupportViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.a.a != null)
    {
      Iterator localIterator = this.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrollStateChanged(paramInt);
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.a.a != null)
    {
      Iterator localIterator = this.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.a.a != null)
    {
      Iterator localIterator = this.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageSelected(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wbm
 * JD-Core Version:    0.7.0.1
 */