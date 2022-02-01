import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.lebasearch.widget.ScrolledTabHost;
import com.tencent.mobileqq.ocr.ui.SearchResultFragment;
import com.tencent.mobileqq.ocr.ui.SearchResultViewPagerAdapter;

public class akok
  implements ViewPager.OnPageChangeListener
{
  public akok(SearchResultFragment paramSearchResultFragment) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.b.b.setCurrentTab(paramInt);
    if (this.b.dnX != paramInt) {
      this.b.a.eY(paramInt);
    }
    this.b.dnX = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akok
 * JD-Core Version:    0.7.0.1
 */