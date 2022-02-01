import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.j;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.qphone.base.util.QLog;

public class ajhv
  extends MultiAIOBaseViewPager.j
{
  public ajhv(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "ViewPager onPageScrollStateChanged() called with: state = [" + paramInt + "]");
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      MultiAIOFragment.a(this.this$0, MultiAIOFragment.a(this.this$0).getCurrentItem());
      MultiAIOFragment.a(this.this$0).setViewPagerBusy(false);
      return;
    case 1: 
      MultiAIOFragment.c(this.this$0);
      return;
    }
    MultiAIOFragment.c(this.this$0);
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onPageSelected() called with: position = [" + paramInt + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajhv
 * JD-Core Version:    0.7.0.1
 */