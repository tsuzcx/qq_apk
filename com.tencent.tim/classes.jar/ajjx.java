import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.c;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.mobileqq.multicard.MultiCardFragment.ReportRunnable;
import com.tencent.qphone.base.util.QLog;

public class ajjx
  implements TabPageIndicator.c
{
  public ajjx(MultiCardFragment paramMultiCardFragment) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "Indicator onPageScrollStateChanged() called with: state = [" + paramInt + "]");
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
        } while ((MultiCardFragment.a(this.this$0) == null) || (MultiCardFragment.a(this.this$0).getCurrentItem() <= MultiCardFragment.a(this.this$0).uS()));
        MultiCardFragment.a(this.this$0).Rc(MultiCardFragment.a(this.this$0).getCurrentItem());
        MultiCardFragment.a(this.this$0).doReport();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajjx
 * JD-Core Version:    0.7.0.1
 */