import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.j;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.mobileqq.multicard.MultiCardFragment.ReportRunnable;
import com.tencent.mobileqq.multicard.MultiCardPageIndicator;
import com.tencent.qphone.base.util.QLog;

public class ajjv
  extends MultiAIOBaseViewPager.j
{
  public ajjv(MultiCardFragment paramMultiCardFragment) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "ViewPager onPageScrollStateChanged() called with: state = [" + paramInt + "]");
    }
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return;
          MultiCardFragment.a(this.this$0);
          MultiCardFragment.a(this.this$0, true);
          if ((MultiCardFragment.a(this.this$0) != null) && (MultiCardFragment.a(this.this$0).getCurrentItem() > MultiCardFragment.a(this.this$0).uS()))
          {
            MultiCardFragment.a(this.this$0).Rc(MultiCardFragment.a(this.this$0).getCurrentItem());
            MultiCardFragment.a(this.this$0).doReport();
          }
        } while (MultiCardFragment.a(this.this$0) == null);
        MultiCardFragment.a(this.this$0).setViewPagerBusy(false);
        return;
        MultiCardFragment.b(this.this$0, true);
        MultiCardFragment.a(this.this$0, false);
      } while (MultiCardFragment.a(this.this$0) == null);
      MultiCardFragment.a(this.this$0, MultiCardFragment.a(this.this$0).getCurrentItem());
      return;
    }
    MultiCardFragment.b(this.this$0, true);
    MultiCardFragment.a(this.this$0, false);
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onPageSelected() called with: position = [" + paramInt + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajjv
 * JD-Core Version:    0.7.0.1
 */